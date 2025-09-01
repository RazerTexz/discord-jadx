package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.ArrayList;
import java.util.List;
import x.a.a.ICustomTabsCallback;
import x.a.a.ICustomTabsService;

/* loaded from: classes.dex */
public class CustomTabsClient {
    private static final String TAG = "CustomTabsClient";
    private final Context mApplicationContext;
    private final ICustomTabsService mService;
    private final ComponentName mServiceComponentName;

    /* renamed from: androidx.browser.customtabs.CustomTabsClient$1, reason: invalid class name */
    public class AnonymousClass1 extends CustomTabsServiceConnection {
        public final /* synthetic */ Context val$applicationContext;

        public AnonymousClass1(Context context) {
            this.val$applicationContext = context;
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public final void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull CustomTabsClient customTabsClient) {
            customTabsClient.warmup(0L);
            this.val$applicationContext.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: androidx.browser.customtabs.CustomTabsClient$2, reason: invalid class name */
    public class AnonymousClass2 extends ICustomTabsCallback.a {
        private Handler mHandler = new Handler(Looper.getMainLooper());
        public final /* synthetic */ CustomTabsCallback val$callback;

        /* renamed from: androidx.browser.customtabs.CustomTabsClient$2$1, reason: invalid class name */
        public class AnonymousClass1 implements Runnable {
            public final /* synthetic */ Bundle val$extras;
            public final /* synthetic */ int val$navigationEvent;

            public AnonymousClass1(int i, Bundle bundle) {
                this.val$navigationEvent = i;
                this.val$extras = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2.this.val$callback.onNavigationEvent(this.val$navigationEvent, this.val$extras);
            }
        }

        /* renamed from: androidx.browser.customtabs.CustomTabsClient$2$2, reason: invalid class name and collision with other inner class name */
        public class RunnableC00012 implements Runnable {
            public final /* synthetic */ Bundle val$args;
            public final /* synthetic */ String val$callbackName;

            public RunnableC00012(String str, Bundle bundle) {
                this.val$callbackName = str;
                this.val$args = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2.this.val$callback.extraCallback(this.val$callbackName, this.val$args);
            }
        }

        /* renamed from: androidx.browser.customtabs.CustomTabsClient$2$3, reason: invalid class name */
        public class AnonymousClass3 implements Runnable {
            public final /* synthetic */ Bundle val$extras;

            public AnonymousClass3(Bundle bundle) {
                this.val$extras = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2.this.val$callback.onMessageChannelReady(this.val$extras);
            }
        }

        /* renamed from: androidx.browser.customtabs.CustomTabsClient$2$4, reason: invalid class name */
        public class AnonymousClass4 implements Runnable {
            public final /* synthetic */ Bundle val$extras;
            public final /* synthetic */ String val$message;

            public AnonymousClass4(String str, Bundle bundle) {
                this.val$message = str;
                this.val$extras = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2.this.val$callback.onPostMessage(this.val$message, this.val$extras);
            }
        }

        /* renamed from: androidx.browser.customtabs.CustomTabsClient$2$5, reason: invalid class name */
        public class AnonymousClass5 implements Runnable {
            public final /* synthetic */ Bundle val$extras;
            public final /* synthetic */ int val$relation;
            public final /* synthetic */ Uri val$requestedOrigin;
            public final /* synthetic */ boolean val$result;

            public AnonymousClass5(int i, Uri uri, boolean z2, Bundle bundle) {
                this.val$relation = i;
                this.val$requestedOrigin = uri;
                this.val$result = z2;
                this.val$extras = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2.this.val$callback.onRelationshipValidationResult(this.val$relation, this.val$requestedOrigin, this.val$result, this.val$extras);
            }
        }

        public AnonymousClass2(CustomTabsCallback customTabsCallback) {
            this.val$callback = customTabsCallback;
        }

        @Override // x.a.a.ICustomTabsCallback
        public void extraCallback(String str, Bundle bundle) throws RemoteException {
            if (this.val$callback == null) {
                return;
            }
            this.mHandler.post(new RunnableC00012(str, bundle));
        }

        @Override // x.a.a.ICustomTabsCallback
        public Bundle extraCallbackWithResult(@NonNull String str, @Nullable Bundle bundle) throws RemoteException {
            CustomTabsCallback customTabsCallback = this.val$callback;
            if (customTabsCallback == null) {
                return null;
            }
            return customTabsCallback.extraCallbackWithResult(str, bundle);
        }

        @Override // x.a.a.ICustomTabsCallback
        public void onMessageChannelReady(Bundle bundle) throws RemoteException {
            if (this.val$callback == null) {
                return;
            }
            this.mHandler.post(new AnonymousClass3(bundle));
        }

        @Override // x.a.a.ICustomTabsCallback
        public void onNavigationEvent(int i, Bundle bundle) {
            if (this.val$callback == null) {
                return;
            }
            this.mHandler.post(new AnonymousClass1(i, bundle));
        }

        @Override // x.a.a.ICustomTabsCallback
        public void onPostMessage(String str, Bundle bundle) throws RemoteException {
            if (this.val$callback == null) {
                return;
            }
            this.mHandler.post(new AnonymousClass4(str, bundle));
        }

        @Override // x.a.a.ICustomTabsCallback
        public void onRelationshipValidationResult(int i, Uri uri, boolean z2, @Nullable Bundle bundle) throws RemoteException {
            if (this.val$callback == null) {
                return;
            }
            this.mHandler.post(new AnonymousClass5(i, uri, z2, bundle));
        }
    }

    public CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
        this.mService = iCustomTabsService;
        this.mServiceComponentName = componentName;
        this.mApplicationContext = context;
    }

    public static boolean bindCustomTabsService(@NonNull Context context, @Nullable String str, @NonNull CustomTabsServiceConnection customTabsServiceConnection) {
        customTabsServiceConnection.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 33);
    }

    public static boolean bindCustomTabsServicePreservePriority(@NonNull Context context, @Nullable String str, @NonNull CustomTabsServiceConnection customTabsServiceConnection) {
        customTabsServiceConnection.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 1);
    }

    public static boolean connectAndInitialize(@NonNull Context context, @NonNull String str) {
        if (str == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            return bindCustomTabsService(applicationContext, str, new AnonymousClass1(applicationContext));
        } catch (SecurityException unused) {
            return false;
        }
    }

    private ICustomTabsCallback.a createCallbackWrapper(@Nullable CustomTabsCallback customTabsCallback) {
        return new AnonymousClass2(customTabsCallback);
    }

    private static PendingIntent createSessionId(Context context, int i) {
        return PendingIntent.getActivity(context, i, new Intent(), 0);
    }

    @Nullable
    public static String getPackageName(@NonNull Context context, @Nullable List<String> list) {
        return getPackageName(context, list, false);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static CustomTabsSession.PendingSession newPendingSession(@NonNull Context context, @Nullable CustomTabsCallback customTabsCallback, int i) {
        return new CustomTabsSession.PendingSession(customTabsCallback, createSessionId(context, i));
    }

    @Nullable
    private CustomTabsSession newSessionInternal(@Nullable CustomTabsCallback customTabsCallback, @Nullable PendingIntent pendingIntent) {
        boolean zNewSession;
        ICustomTabsCallback.a aVarCreateCallbackWrapper = createCallbackWrapper(customTabsCallback);
        try {
            if (pendingIntent != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(CustomTabsIntent.EXTRA_SESSION_ID, pendingIntent);
                zNewSession = this.mService.newSessionWithExtras(aVarCreateCallbackWrapper, bundle);
            } else {
                zNewSession = this.mService.newSession(aVarCreateCallbackWrapper);
            }
            if (zNewSession) {
                return new CustomTabsSession(this.mService, aVarCreateCallbackWrapper, this.mServiceComponentName, pendingIntent);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public CustomTabsSession attachSession(@NonNull CustomTabsSession.PendingSession pendingSession) {
        return newSessionInternal(pendingSession.getCallback(), pendingSession.getId());
    }

    @Nullable
    public Bundle extraCommand(@NonNull String str, @Nullable Bundle bundle) {
        try {
            return this.mService.extraCommand(str, bundle);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Nullable
    public CustomTabsSession newSession(@Nullable CustomTabsCallback customTabsCallback) {
        return newSessionInternal(customTabsCallback, null);
    }

    public boolean warmup(long j) {
        try {
            return this.mService.warmup(j);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Nullable
    public static String getPackageName(@NonNull Context context, @Nullable List<String> list, boolean z2) {
        ResolveInfo resolveInfoResolveActivity;
        PackageManager packageManager = context.getPackageManager();
        List<String> arrayList = list == null ? new ArrayList<>() : list;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        if (!z2 && (resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0)) != null) {
            String str = resolveInfoResolveActivity.activityInfo.packageName;
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str);
            if (list != null) {
                arrayList2.addAll(list);
            }
            arrayList = arrayList2;
        }
        Intent intent2 = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        for (String str2 : arrayList) {
            intent2.setPackage(str2);
            if (packageManager.resolveService(intent2, 0) != null) {
                return str2;
            }
        }
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        Log.w(TAG, "Unable to find any Custom Tabs packages, you may need to add a <queries> element to your manifest. See the docs for CustomTabsClient#getPackageName.");
        return null;
    }

    @Nullable
    public CustomTabsSession newSession(@Nullable CustomTabsCallback customTabsCallback, int i) {
        return newSessionInternal(customTabsCallback, createSessionId(this.mApplicationContext, i));
    }
}
