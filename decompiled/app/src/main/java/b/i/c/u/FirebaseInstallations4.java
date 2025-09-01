package b.i.c.u;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.browser.trusted.sharing.ShareTarget;
import b.c.a.a0.AnimatableValueParser;
import b.i.c.FirebaseApp2;
import b.i.c.r.HeartBeatInfo;
import b.i.c.t.Provider2;
import b.i.c.u.o.AutoValue_PersistedInstallationEntry;
import b.i.c.u.o.IidStore;
import b.i.c.u.o.PersistedInstallation;
import b.i.c.u.o.PersistedInstallationEntry;
import b.i.c.u.p.AutoValue_InstallationResponse;
import b.i.c.u.p.AutoValue_TokenResult;
import b.i.c.u.p.FirebaseInstallationServiceClient;
import b.i.c.u.p.InstallationResponse;
import b.i.c.u.p.TokenResult;
import b.i.c.x.UserAgentPublisher;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.FirebaseInstallationsException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FirebaseInstallations.java */
/* renamed from: b.i.c.u.f, reason: use source file name */
/* loaded from: classes3.dex */
public class FirebaseInstallations4 implements g {
    public static final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadFactory f1780b = new a();
    public final FirebaseApp2 c;
    public final FirebaseInstallationServiceClient d;
    public final PersistedInstallation e;
    public final Utils6 f;
    public final IidStore g;
    public final RandomFidGenerator h;
    public final Object i;
    public final ExecutorService j;
    public final ExecutorService k;

    @GuardedBy("this")
    public String l;

    @GuardedBy("lock")
    public final List<StateListener> m;

    /* compiled from: FirebaseInstallations.java */
    /* renamed from: b.i.c.u.f$a */
    public class a implements ThreadFactory {
        public final AtomicInteger j = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.j.getAndIncrement())));
        }
    }

    public FirebaseInstallations4(FirebaseApp2 firebaseApp2, @NonNull Provider2<UserAgentPublisher> provider2, @NonNull Provider2<HeartBeatInfo> provider22) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ThreadFactory threadFactory = f1780b;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, timeUnit, linkedBlockingQueue, threadFactory);
        firebaseApp2.a();
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = new FirebaseInstallationServiceClient(firebaseApp2.d, provider2, provider22);
        PersistedInstallation persistedInstallation = new PersistedInstallation(firebaseApp2);
        Utils6 utils6C = Utils6.c();
        IidStore iidStore = new IidStore(firebaseApp2);
        RandomFidGenerator randomFidGenerator = new RandomFidGenerator();
        this.i = new Object();
        this.m = new ArrayList();
        this.c = firebaseApp2;
        this.d = firebaseInstallationServiceClient;
        this.e = persistedInstallation;
        this.f = utils6C;
        this.g = iidStore;
        this.h = randomFidGenerator;
        this.j = threadPoolExecutor;
        this.k = new ThreadPoolExecutor(0, 1, 30L, timeUnit, new LinkedBlockingQueue(), threadFactory);
    }

    @NonNull
    public static FirebaseInstallations4 f() {
        FirebaseApp2 firebaseApp2B = FirebaseApp2.b();
        AnimatableValueParser.o(true, "Null is not a valid value of FirebaseApp.");
        firebaseApp2B.a();
        return (FirebaseInstallations4) firebaseApp2B.g.a(g.class);
    }

    @Override // b.i.c.u.g
    @NonNull
    public Task<k> a(boolean z2) {
        h();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetAuthTokenListener getAuthTokenListener = new GetAuthTokenListener(this.f, taskCompletionSource);
        synchronized (this.i) {
            this.m.add(getAuthTokenListener);
        }
        Task task = taskCompletionSource.a;
        this.j.execute(new FirebaseInstallations2(this, z2));
        return task;
    }

    public final void b(boolean z2) {
        PersistedInstallationEntry persistedInstallationEntryB;
        synchronized (a) {
            FirebaseApp2 firebaseApp2 = this.c;
            firebaseApp2.a();
            CrossProcessLock crossProcessLockA = CrossProcessLock.a(firebaseApp2.d, "generatefid.lock");
            try {
                persistedInstallationEntryB = this.e.b();
                if (persistedInstallationEntryB.i()) {
                    String strI = i(persistedInstallationEntryB);
                    PersistedInstallation persistedInstallation = this.e;
                    AutoValue_PersistedInstallationEntry.b bVar = (AutoValue_PersistedInstallationEntry.b) persistedInstallationEntryB.k();
                    bVar.a = strI;
                    bVar.b(PersistedInstallation.a.UNREGISTERED);
                    persistedInstallationEntryB = bVar.a();
                    persistedInstallation.a(persistedInstallationEntryB);
                }
            } finally {
                if (crossProcessLockA != null) {
                    crossProcessLockA.b();
                }
            }
        }
        if (z2) {
            AutoValue_PersistedInstallationEntry.b bVar2 = (AutoValue_PersistedInstallationEntry.b) persistedInstallationEntryB.k();
            bVar2.c = null;
            persistedInstallationEntryB = bVar2.a();
        }
        l(persistedInstallationEntryB);
        this.k.execute(new FirebaseInstallations3(this, z2));
    }

    public final PersistedInstallationEntry c(@NonNull PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        int responseCode;
        TokenResult tokenResultF;
        FirebaseInstallationsException.a aVar = FirebaseInstallationsException.a.UNAVAILABLE;
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = this.d;
        String strD = d();
        AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) persistedInstallationEntry;
        String str = autoValue_PersistedInstallationEntry.f1784b;
        String strG = g();
        String str2 = autoValue_PersistedInstallationEntry.e;
        if (!firebaseInstallationServiceClient.f.a()) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", aVar);
        }
        URL urlA = firebaseInstallationServiceClient.a(String.format("projects/%s/installations/%s/authTokens:generate", strG, str));
        for (int i = 0; i <= 1; i++) {
            HttpURLConnection httpURLConnectionC = firebaseInstallationServiceClient.c(urlA, strD);
            try {
                httpURLConnectionC.setRequestMethod(ShareTarget.METHOD_POST);
                httpURLConnectionC.addRequestProperty("Authorization", "FIS_v2 " + str2);
                httpURLConnectionC.setDoOutput(true);
                firebaseInstallationServiceClient.h(httpURLConnectionC);
                responseCode = httpURLConnectionC.getResponseCode();
                firebaseInstallationServiceClient.f.b(responseCode);
            } catch (IOException | AssertionError unused) {
            } catch (Throwable th) {
                httpURLConnectionC.disconnect();
                throw th;
            }
            if (responseCode >= 200 && responseCode < 300) {
                tokenResultF = firebaseInstallationServiceClient.f(httpURLConnectionC);
            } else {
                FirebaseInstallationServiceClient.b(httpURLConnectionC, null, strD, strG);
                if (responseCode == 401 || responseCode == 404) {
                    AutoValue_TokenResult.b bVar = (AutoValue_TokenResult.b) TokenResult.a();
                    bVar.c = TokenResult.b.AUTH_ERROR;
                    tokenResultF = bVar.a();
                } else {
                    if (responseCode == 429) {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.a.TOO_MANY_REQUESTS);
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                        AutoValue_TokenResult.b bVar2 = (AutoValue_TokenResult.b) TokenResult.a();
                        bVar2.c = TokenResult.b.BAD_CONFIG;
                        tokenResultF = bVar2.a();
                    } else {
                        httpURLConnectionC.disconnect();
                    }
                }
            }
            httpURLConnectionC.disconnect();
            AutoValue_TokenResult autoValue_TokenResult = (AutoValue_TokenResult) tokenResultF;
            int iOrdinal = autoValue_TokenResult.c.ordinal();
            if (iOrdinal == 0) {
                String str3 = autoValue_TokenResult.a;
                long j = autoValue_TokenResult.f1789b;
                long jB = this.f.b();
                AutoValue_PersistedInstallationEntry.b bVar3 = (AutoValue_PersistedInstallationEntry.b) persistedInstallationEntry.k();
                bVar3.c = str3;
                bVar3.e = Long.valueOf(j);
                bVar3.f = Long.valueOf(jB);
                return bVar3.a();
            }
            if (iOrdinal == 1) {
                AutoValue_PersistedInstallationEntry.b bVar4 = (AutoValue_PersistedInstallationEntry.b) persistedInstallationEntry.k();
                bVar4.g = "BAD CONFIG";
                bVar4.b(PersistedInstallation.a.REGISTER_ERROR);
                return bVar4.a();
            }
            if (iOrdinal != 2) {
                throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", aVar);
            }
            synchronized (this) {
                this.l = null;
            }
            PersistedInstallationEntry.a aVarK = persistedInstallationEntry.k();
            aVarK.b(PersistedInstallation.a.NOT_GENERATED);
            return aVarK.a();
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", aVar);
    }

    @Nullable
    public String d() {
        FirebaseApp2 firebaseApp2 = this.c;
        firebaseApp2.a();
        return firebaseApp2.f.a;
    }

    @VisibleForTesting
    public String e() {
        FirebaseApp2 firebaseApp2 = this.c;
        firebaseApp2.a();
        return firebaseApp2.f.f1655b;
    }

    @Nullable
    public String g() {
        FirebaseApp2 firebaseApp2 = this.c;
        firebaseApp2.a();
        return firebaseApp2.f.g;
    }

    @Override // b.i.c.u.g
    @NonNull
    public Task<String> getId() {
        String str;
        h();
        synchronized (this) {
            str = this.l;
        }
        if (str != null) {
            return b.i.a.f.e.o.f.Z(str);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetIdListener getIdListener = new GetIdListener(taskCompletionSource);
        synchronized (this.i) {
            this.m.add(getIdListener);
        }
        Task task = taskCompletionSource.a;
        this.j.execute(new FirebaseInstallations(this));
        return task;
    }

    public final void h() {
        AnimatableValueParser.v(e(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        AnimatableValueParser.v(g(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        AnimatableValueParser.v(d(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        String strE = e();
        Pattern pattern = Utils6.f1783b;
        AnimatableValueParser.o(strE.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        AnimatableValueParser.o(Utils6.f1783b.matcher(d()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public final String i(PersistedInstallationEntry persistedInstallationEntry) {
        String string;
        FirebaseApp2 firebaseApp2 = this.c;
        firebaseApp2.a();
        if (firebaseApp2.e.equals("CHIME_ANDROID_SDK") || this.c.h()) {
            if (((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).c == PersistedInstallation.a.ATTEMPT_MIGRATION) {
                IidStore iidStore = this.g;
                synchronized (iidStore.f1786b) {
                    synchronized (iidStore.f1786b) {
                        string = iidStore.f1786b.getString("|S|id", null);
                    }
                    if (string == null) {
                        string = iidStore.a();
                    }
                }
                return TextUtils.isEmpty(string) ? this.h.a() : string;
            }
        }
        return this.h.a();
    }

    public final PersistedInstallationEntry j(PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        int responseCode;
        InstallationResponse installationResponseE;
        FirebaseInstallationsException.a aVar = FirebaseInstallationsException.a.UNAVAILABLE;
        AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) persistedInstallationEntry;
        String str = autoValue_PersistedInstallationEntry.f1784b;
        String string = null;
        if (str != null && str.length() == 11) {
            IidStore iidStore = this.g;
            synchronized (iidStore.f1786b) {
                String[] strArr = IidStore.a;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str2 = strArr[i];
                    String string2 = iidStore.f1786b.getString("|T|" + iidStore.c + "|" + str2, null);
                    if (string2 == null || string2.isEmpty()) {
                        i++;
                    } else if (string2.startsWith("{")) {
                        try {
                            string = new JSONObject(string2).getString("token");
                        } catch (JSONException unused) {
                        }
                    } else {
                        string = string2;
                    }
                }
            }
        }
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = this.d;
        String strD = d();
        String str3 = autoValue_PersistedInstallationEntry.f1784b;
        String strG = g();
        String strE = e();
        if (!firebaseInstallationServiceClient.f.a()) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", aVar);
        }
        URL urlA = firebaseInstallationServiceClient.a(String.format("projects/%s/installations", strG));
        for (int i2 = 0; i2 <= 1; i2++) {
            HttpURLConnection httpURLConnectionC = firebaseInstallationServiceClient.c(urlA, strD);
            try {
                try {
                    httpURLConnectionC.setRequestMethod(ShareTarget.METHOD_POST);
                    httpURLConnectionC.setDoOutput(true);
                    if (string != null) {
                        httpURLConnectionC.addRequestProperty("x-goog-fis-android-iid-migration-auth", string);
                    }
                    firebaseInstallationServiceClient.g(httpURLConnectionC, str3, strE);
                    responseCode = httpURLConnectionC.getResponseCode();
                    firebaseInstallationServiceClient.f.b(responseCode);
                } catch (IOException | AssertionError unused2) {
                }
                if (responseCode >= 200 && responseCode < 300) {
                    installationResponseE = firebaseInstallationServiceClient.e(httpURLConnectionC);
                } else {
                    FirebaseInstallationServiceClient.b(httpURLConnectionC, strE, strD, strG);
                    if (responseCode == 429) {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.a.TOO_MANY_REQUESTS);
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                        AutoValue_InstallationResponse autoValue_InstallationResponse = new AutoValue_InstallationResponse(null, null, null, null, InstallationResponse.a.BAD_CONFIG, null);
                        httpURLConnectionC.disconnect();
                        installationResponseE = autoValue_InstallationResponse;
                    } else {
                        httpURLConnectionC.disconnect();
                    }
                }
                AutoValue_InstallationResponse autoValue_InstallationResponse2 = (AutoValue_InstallationResponse) installationResponseE;
                int iOrdinal = autoValue_InstallationResponse2.e.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", aVar);
                    }
                    AutoValue_PersistedInstallationEntry.b bVar = (AutoValue_PersistedInstallationEntry.b) persistedInstallationEntry.k();
                    bVar.g = "BAD CONFIG";
                    bVar.b(PersistedInstallation.a.REGISTER_ERROR);
                    return bVar.a();
                }
                String str4 = autoValue_InstallationResponse2.f1788b;
                String str5 = autoValue_InstallationResponse2.c;
                long jB = this.f.b();
                String strC = autoValue_InstallationResponse2.d.c();
                long jD = autoValue_InstallationResponse2.d.d();
                AutoValue_PersistedInstallationEntry.b bVar2 = (AutoValue_PersistedInstallationEntry.b) persistedInstallationEntry.k();
                bVar2.a = str4;
                bVar2.b(PersistedInstallation.a.REGISTERED);
                bVar2.c = strC;
                bVar2.d = str5;
                bVar2.e = Long.valueOf(jD);
                bVar2.f = Long.valueOf(jB);
                return bVar2.a();
            } finally {
                httpURLConnectionC.disconnect();
            }
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", aVar);
    }

    public final void k(Exception exc) {
        synchronized (this.i) {
            Iterator<StateListener> it = this.m.iterator();
            while (it.hasNext()) {
                if (it.next().a(exc)) {
                    it.remove();
                }
            }
        }
    }

    public final void l(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (this.i) {
            Iterator<StateListener> it = this.m.iterator();
            while (it.hasNext()) {
                if (it.next().b(persistedInstallationEntry)) {
                    it.remove();
                }
            }
        }
    }
}
