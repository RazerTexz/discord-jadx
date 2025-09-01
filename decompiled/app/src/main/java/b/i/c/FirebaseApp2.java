package b.i.c;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.j.c;
import b.i.a.f.e.k.j;
import b.i.c.l.Component4;
import b.i.c.l.ComponentRegistrar;
import b.i.c.l.ComponentRuntime4;
import b.i.c.l.EventBus;
import b.i.c.l.EventBus2;
import b.i.c.l.Lazy2;
import b.i.c.q.Event3;
import b.i.c.q.EventHandler2;
import b.i.c.v.DataCollectionConfigStorage;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.badge.BadgeDrawable;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FirebaseApp.java */
/* renamed from: b.i.c.c, reason: use source file name */
/* loaded from: classes3.dex */
public class FirebaseApp2 {
    public static final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Executor f1653b = new d(null);
    public static final Map<String, FirebaseApp2> c = new ArrayMap();
    public final Context d;
    public final String e;
    public final FirebaseOptions f;
    public final ComponentRuntime4 g;
    public final Lazy2<DataCollectionConfigStorage> j;
    public final AtomicBoolean h = new AtomicBoolean(false);
    public final AtomicBoolean i = new AtomicBoolean();
    public final List<b> k = new CopyOnWriteArrayList();

    /* compiled from: FirebaseApp.java */
    /* renamed from: b.i.c.c$b */
    public interface b {
        void a(boolean z2);
    }

    /* compiled from: FirebaseApp.java */
    @TargetApi(14)
    /* renamed from: b.i.c.c$c */
    public static class c implements c.a {
        public static AtomicReference<c> a = new AtomicReference<>();

        @Override // b.i.a.f.e.h.j.c.a
        public void a(boolean z2) {
            Object obj = FirebaseApp2.a;
            synchronized (FirebaseApp2.a) {
                Iterator it = new ArrayList(FirebaseApp2.c.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp2 firebaseApp2 = (FirebaseApp2) it.next();
                    if (firebaseApp2.h.get()) {
                        Log.d("FirebaseApp", "Notifying background state change listeners.");
                        Iterator<b> it2 = firebaseApp2.k.iterator();
                        while (it2.hasNext()) {
                            it2.next().a(z2);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: FirebaseApp.java */
    /* renamed from: b.i.c.c$d */
    public static class d implements Executor {
        public static final Handler j = new Handler(Looper.getMainLooper());

        public d(a aVar) {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            j.post(runnable);
        }
    }

    /* compiled from: FirebaseApp.java */
    @TargetApi(24)
    /* renamed from: b.i.c.c$e */
    public static class e extends BroadcastReceiver {
        public static AtomicReference<e> a = new AtomicReference<>();

        /* renamed from: b, reason: collision with root package name */
        public final Context f1654b;

        public e(Context context) {
            this.f1654b = context;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Object obj = FirebaseApp2.a;
            synchronized (FirebaseApp2.a) {
                Iterator<FirebaseApp2> it = FirebaseApp2.c.values().iterator();
                while (it.hasNext()) {
                    it.next().d();
                }
            }
            this.f1654b.unregisterReceiver(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FirebaseApp2(Context context, String str, FirebaseOptions firebaseOptions) throws PackageManager.NameNotFoundException, ClassNotFoundException {
        Bundle bundle;
        List<String> listEmptyList;
        PackageManager packageManager;
        new CopyOnWriteArrayList();
        this.d = context;
        AnimatableValueParser.w(str);
        this.e = str;
        Objects.requireNonNull(firebaseOptions, "null reference");
        this.f = firebaseOptions;
        try {
            packageManager = context.getPackageManager();
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        if (packageManager == null) {
            Log.w("ComponentDiscovery", "Context has no PackageManager.");
        } else {
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) ComponentDiscoveryService.class), 128);
            if (serviceInfo != null) {
                bundle = serviceInfo.metaData;
                if (bundle != null) {
                    Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                    listEmptyList = Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : bundle.keySet()) {
                        if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str2)) && str2.startsWith("com.google.firebase.components:")) {
                            arrayList.add(str2.substring(31));
                        }
                    }
                    listEmptyList = arrayList;
                }
                ArrayList arrayList2 = new ArrayList();
                for (String str3 : listEmptyList) {
                    try {
                        Class<?> cls = Class.forName(str3);
                        if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                            arrayList2.add((ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                        } else {
                            Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", str3, "com.google.firebase.components.ComponentRegistrar"));
                        }
                    } catch (ClassNotFoundException e2) {
                        Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str3), e2);
                    } catch (IllegalAccessException e3) {
                        Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", str3), e3);
                    } catch (InstantiationException e4) {
                        Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", str3), e4);
                    } catch (NoSuchMethodException e5) {
                        Log.w("ComponentDiscovery", String.format("Could not instantiate %s", str3), e5);
                    } catch (InvocationTargetException e6) {
                        Log.w("ComponentDiscovery", String.format("Could not instantiate %s", str3), e6);
                    }
                }
                arrayList2.add(new FirebaseCommonRegistrar());
                this.g = new ComponentRuntime4(f1653b, arrayList2, Component4.c(context, Context.class, new Class[0]), Component4.c(this, FirebaseApp2.class, new Class[0]), Component4.c(firebaseOptions, FirebaseOptions.class, new Class[0]));
                this.j = new Lazy2<>(new FirebaseApp(this, context));
            }
            Log.w("ComponentDiscovery", ComponentDiscoveryService.class + " has no service info.");
        }
        bundle = null;
        if (bundle != null) {
        }
        ArrayList arrayList22 = new ArrayList();
        while (r13.hasNext()) {
        }
        arrayList22.add(new FirebaseCommonRegistrar());
        this.g = new ComponentRuntime4(f1653b, arrayList22, Component4.c(context, Context.class, new Class[0]), Component4.c(this, FirebaseApp2.class, new Class[0]), Component4.c(firebaseOptions, FirebaseOptions.class, new Class[0]));
        this.j = new Lazy2<>(new FirebaseApp(this, context));
    }

    @NonNull
    public static FirebaseApp2 b() {
        FirebaseApp2 firebaseApp2;
        synchronized (a) {
            firebaseApp2 = c.get("[DEFAULT]");
            if (firebaseApp2 == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + b.i.a.f.e.o.g.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp2;
    }

    @Nullable
    public static FirebaseApp2 e(@NonNull Context context) {
        synchronized (a) {
            if (c.containsKey("[DEFAULT]")) {
                return b();
            }
            FirebaseOptions firebaseOptionsA = FirebaseOptions.a(context);
            if (firebaseOptionsA == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return f(context, firebaseOptionsA);
        }
    }

    @NonNull
    public static FirebaseApp2 f(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions) {
        FirebaseApp2 firebaseApp2;
        AtomicReference<c> atomicReference = c.a;
        if (context.getApplicationContext() instanceof Application) {
            Application application = (Application) context.getApplicationContext();
            if (c.a.get() == null) {
                c cVar = new c();
                if (c.a.compareAndSet(null, cVar)) {
                    b.i.a.f.e.h.j.c.a(application);
                    b.i.a.f.e.h.j.c cVar2 = b.i.a.f.e.h.j.c.j;
                    Objects.requireNonNull(cVar2);
                    synchronized (cVar2) {
                        cVar2.m.add(cVar);
                    }
                }
            }
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (a) {
            Map<String, FirebaseApp2> map = c;
            AnimatableValueParser.G(!map.containsKey("[DEFAULT]"), "FirebaseApp name [DEFAULT] already exists!");
            AnimatableValueParser.z(context, "Application context cannot be null.");
            firebaseApp2 = new FirebaseApp2(context, "[DEFAULT]", firebaseOptions);
            map.put("[DEFAULT]", firebaseApp2);
        }
        firebaseApp2.d();
        return firebaseApp2;
    }

    public final void a() {
        AnimatableValueParser.G(!this.i.get(), "FirebaseApp was deleted");
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        a();
        byte[] bytes = this.e.getBytes(Charset.defaultCharset());
        sb.append(bytes == null ? null : Base64.encodeToString(bytes, 11));
        sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
        a();
        byte[] bytes2 = this.f.f1655b.getBytes(Charset.defaultCharset());
        sb.append(bytes2 != null ? Base64.encodeToString(bytes2, 11) : null);
        return sb.toString();
    }

    public final void d() {
        Queue<Event3<?>> queue;
        Set<Map.Entry<EventHandler2<Object>, Executor>> setEmptySet;
        if (!UserManagerCompat.isUserUnlocked(this.d)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            a();
            sb.append(this.e);
            Log.i("FirebaseApp", sb.toString());
            Context context = this.d;
            if (e.a.get() == null) {
                e eVar = new e(context);
                if (e.a.compareAndSet(null, eVar)) {
                    context.registerReceiver(eVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                    return;
                }
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Device unlocked: initializing all Firebase APIs for app ");
        a();
        sb2.append(this.e);
        Log.i("FirebaseApp", sb2.toString());
        ComponentRuntime4 componentRuntime4 = this.g;
        boolean zH = h();
        for (Map.Entry<Component4<?>, Lazy2<?>> entry : componentRuntime4.f1665b.entrySet()) {
            Component4<?> key = entry.getKey();
            Lazy2<?> value = entry.getValue();
            int i = key.c;
            if (!(i == 1)) {
                if (!(i == 2) || !zH) {
                }
            }
            value.get();
        }
        EventBus2 eventBus2 = componentRuntime4.e;
        synchronized (eventBus2) {
            queue = eventBus2.f1669b;
            if (queue != null) {
                eventBus2.f1669b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (Event3<?> event3 : queue) {
                Objects.requireNonNull(event3);
                synchronized (eventBus2) {
                    Queue<Event3<?>> queue2 = eventBus2.f1669b;
                    if (queue2 != null) {
                        queue2.add(event3);
                    } else {
                        synchronized (eventBus2) {
                            ConcurrentHashMap<EventHandler2<Object>, Executor> concurrentHashMap = eventBus2.a.get(null);
                            setEmptySet = concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
                        }
                        for (Map.Entry<EventHandler2<Object>, Executor> entry2 : setEmptySet) {
                            entry2.getValue().execute(new EventBus(entry2, event3));
                        }
                    }
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp2)) {
            return false;
        }
        String str = this.e;
        FirebaseApp2 firebaseApp2 = (FirebaseApp2) obj;
        firebaseApp2.a();
        return str.equals(firebaseApp2.e);
    }

    public boolean g() {
        boolean z2;
        a();
        DataCollectionConfigStorage dataCollectionConfigStorage = this.j.get();
        synchronized (dataCollectionConfigStorage) {
            z2 = dataCollectionConfigStorage.d;
        }
        return z2;
    }

    @VisibleForTesting
    public boolean h() {
        a();
        return "[DEFAULT]".equals(this.e);
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public String toString() {
        j jVar = new j(this);
        jVar.a(ModelAuditLogEntry.CHANGE_KEY_NAME, this.e);
        jVar.a("options", this.f);
        return jVar.toString();
    }
}
