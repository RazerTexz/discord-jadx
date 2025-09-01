package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.b.TransportFactory;
import b.i.a.f.e.o.f;
import b.i.a.f.n.c0;
import b.i.a.f.n.v;
import b.i.c.DataCollectionDefaultChange;
import b.i.c.FirebaseApp2;
import b.i.c.q.EventHandler2;
import b.i.c.q.Subscriber2;
import b.i.c.r.HeartBeatInfo;
import b.i.c.s.n;
import b.i.c.s.q;
import b.i.c.t.Provider2;
import b.i.c.u.g;
import b.i.c.w.h;
import b.i.c.w.j;
import b.i.c.w.x;
import b.i.c.w.y;
import b.i.c.x.UserAgentPublisher;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* loaded from: classes3.dex */
public class FirebaseMessaging {

    @Nullable
    @SuppressLint({"FirebaseUnknownNullness"})
    @VisibleForTesting
    public static TransportFactory a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f3112b;
    public final FirebaseApp2 c;
    public final FirebaseInstanceId d;
    public final a e;
    public final Executor f;
    public final Task<y> g;

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public class a {
        public final Subscriber2 a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f3113b;

        @Nullable
        public EventHandler2<DataCollectionDefaultChange> c;

        @Nullable
        public Boolean d;

        public a(Subscriber2 subscriber2) {
            this.a = subscriber2;
        }

        public synchronized void a() {
            if (this.f3113b) {
                return;
            }
            Boolean boolC = c();
            this.d = boolC;
            if (boolC == null) {
                j jVar = new j(this);
                this.c = jVar;
                this.a.a(DataCollectionDefaultChange.class, jVar);
            }
            this.f3113b = true;
        }

        public synchronized boolean b() {
            a();
            Boolean bool = this.d;
            if (bool != null) {
                return bool.booleanValue();
            }
            return FirebaseMessaging.this.c.g();
        }

        @Nullable
        public final Boolean c() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            FirebaseApp2 firebaseApp2 = FirebaseMessaging.this.c;
            firebaseApp2.a();
            Context context = firebaseApp2.d;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
    }

    public FirebaseMessaging(FirebaseApp2 firebaseApp2, FirebaseInstanceId firebaseInstanceId, Provider2<UserAgentPublisher> provider2, Provider2<HeartBeatInfo> provider22, g gVar, @Nullable TransportFactory transportFactory, Subscriber2 subscriber2) throws ClassNotFoundException {
        try {
            Class.forName("com.google.firebase.iid.FirebaseInstanceIdReceiver");
            a = transportFactory;
            this.c = firebaseApp2;
            this.d = firebaseInstanceId;
            this.e = new a(subscriber2);
            firebaseApp2.a();
            Context context = firebaseApp2.d;
            this.f3112b = context;
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new b.i.a.f.e.o.j.a("Firebase-Messaging-Init"));
            this.f = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.execute(new b.i.c.w.g(this, firebaseInstanceId));
            q qVar = new q(context);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new b.i.a.f.e.o.j.a("Firebase-Messaging-Topics-Io"));
            int i = y.f1800b;
            Task<y> taskO = f.o(scheduledThreadPoolExecutor2, new x(context, scheduledThreadPoolExecutor2, firebaseInstanceId, qVar, new n(firebaseApp2, qVar, provider2, provider22, gVar)));
            this.g = taskO;
            c0 c0Var = (c0) taskO;
            c0Var.f1592b.a(new v(new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b.i.a.f.e.o.j.a("Firebase-Messaging-Trigger-Topics-Io")), new h(this)));
            c0Var.w();
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("FirebaseMessaging and FirebaseInstanceId versions not compatible. Update to latest version of firebase-messaging.");
        }
    }

    @NonNull
    @Keep
    public static synchronized FirebaseMessaging getInstance(@NonNull FirebaseApp2 firebaseApp2) {
        FirebaseMessaging firebaseMessaging;
        firebaseApp2.a();
        firebaseMessaging = (FirebaseMessaging) firebaseApp2.g.a(FirebaseMessaging.class);
        AnimatableValueParser.z(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }
}
