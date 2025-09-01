package b.i.a.f.i.b;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import b.d.b.a.outline;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public class u4 implements t5 {
    public static volatile u4 a;
    public long A;
    public volatile Boolean B;
    public Boolean C;
    public Boolean D;
    public volatile boolean E;
    public int F;
    public final long H;

    /* renamed from: b, reason: collision with root package name */
    public final Context f1570b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final ga g;
    public final c h;
    public final d4 i;
    public final q3 j;
    public final r4 k;
    public final w8 l;
    public final t9 m;
    public final o3 n;
    public final b.i.a.f.e.o.b o;
    public final h7 p;
    public final c6 q;
    public final a r;

    /* renamed from: s, reason: collision with root package name */
    public final d7 f1571s;
    public m3 t;
    public q7 u;
    public j v;
    public n3 w;

    /* renamed from: x, reason: collision with root package name */
    public m4 f1572x;

    /* renamed from: z, reason: collision with root package name */
    public Boolean f1574z;

    /* renamed from: y, reason: collision with root package name */
    public boolean f1573y = false;
    public AtomicInteger G = new AtomicInteger(0);

    public u4(y5 y5Var) throws IllegalStateException {
        Context context;
        Bundle bundle;
        boolean z2 = false;
        Context context2 = y5Var.a;
        ga gaVar = new ga();
        this.g = gaVar;
        b.i.a.f.e.o.f.c = gaVar;
        this.f1570b = context2;
        this.c = y5Var.f1580b;
        this.d = y5Var.c;
        this.e = y5Var.d;
        this.f = y5Var.h;
        this.B = y5Var.e;
        this.E = true;
        zzae zzaeVar = y5Var.g;
        if (zzaeVar != null && (bundle = zzaeVar.p) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.C = (Boolean) obj;
            }
            Object obj2 = zzaeVar.p.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.D = (Boolean) obj2;
            }
        }
        synchronized (b.i.a.f.h.l.l2.a) {
            b.i.a.f.h.l.t2 t2Var = b.i.a.f.h.l.l2.f1456b;
            Context applicationContext = context2.getApplicationContext();
            applicationContext = applicationContext == null ? context2 : applicationContext;
            if (t2Var == null || t2Var.a() != applicationContext) {
                b.i.a.f.h.l.y1.c();
                b.i.a.f.h.l.s2.b();
                synchronized (b.i.a.f.h.l.c2.class) {
                    b.i.a.f.h.l.c2 c2Var = b.i.a.f.h.l.c2.a;
                    if (c2Var != null && (context = c2Var.f1437b) != null && c2Var.c != null) {
                        context.getContentResolver().unregisterContentObserver(b.i.a.f.h.l.c2.a.c);
                    }
                    b.i.a.f.h.l.c2.a = null;
                }
                b.i.a.f.h.l.l2.f1456b = new b.i.a.f.h.l.v1(applicationContext, b.i.a.f.e.o.f.Q1(new b.i.a.f.h.l.k2(applicationContext)));
                b.i.a.f.h.l.l2.d.incrementAndGet();
            }
        }
        this.o = b.i.a.f.e.o.c.a;
        Long l = y5Var.i;
        this.H = l != null ? l.longValue() : System.currentTimeMillis();
        this.h = new c(this);
        d4 d4Var = new d4(this);
        d4Var.p();
        this.i = d4Var;
        q3 q3Var = new q3(this);
        q3Var.p();
        this.j = q3Var;
        t9 t9Var = new t9(this);
        t9Var.p();
        this.m = t9Var;
        o3 o3Var = new o3(this);
        o3Var.p();
        this.n = o3Var;
        this.r = new a(this);
        h7 h7Var = new h7(this);
        h7Var.u();
        this.p = h7Var;
        c6 c6Var = new c6(this);
        c6Var.u();
        this.q = c6Var;
        w8 w8Var = new w8(this);
        w8Var.u();
        this.l = w8Var;
        d7 d7Var = new d7(this);
        d7Var.p();
        this.f1571s = d7Var;
        r4 r4Var = new r4(this);
        r4Var.p();
        this.k = r4Var;
        zzae zzaeVar2 = y5Var.g;
        if (zzaeVar2 != null && zzaeVar2.k != 0) {
            z2 = true;
        }
        boolean z3 = !z2;
        if (context2.getApplicationContext() instanceof Application) {
            c6 c6VarS = s();
            if (c6VarS.a.f1570b.getApplicationContext() instanceof Application) {
                Application application = (Application) c6VarS.a.f1570b.getApplicationContext();
                if (c6VarS.c == null) {
                    c6VarS.c = new y6(c6VarS, null);
                }
                if (z3) {
                    application.unregisterActivityLifecycleCallbacks(c6VarS.c);
                    application.registerActivityLifecycleCallbacks(c6VarS.c);
                    c6VarS.g().n.a("Registered activity lifecycle callback");
                }
            }
        } else {
            g().i.a("Application context is not an Application");
        }
        r4Var.v(new w4(this, y5Var));
    }

    public static u4 b(Context context, zzae zzaeVar, Long l) {
        Bundle bundle;
        if (zzaeVar != null && (zzaeVar.n == null || zzaeVar.o == null)) {
            zzaeVar = new zzae(zzaeVar.j, zzaeVar.k, zzaeVar.l, zzaeVar.m, null, null, zzaeVar.p);
        }
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(context.getApplicationContext(), "null reference");
        if (a == null) {
            synchronized (u4.class) {
                if (a == null) {
                    a = new u4(new y5(context, zzaeVar, l));
                }
            }
        } else if (zzaeVar != null && (bundle = zzaeVar.p) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            a.B = Boolean.valueOf(zzaeVar.p.getBoolean("dataCollectionDefaultEnabled"));
        }
        return a;
    }

    public static void c(s5 s5Var) {
        if (s5Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static void p(a5 a5Var) {
        if (a5Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (a5Var.f1518b) {
            return;
        }
        String strValueOf = String.valueOf(a5Var.getClass());
        throw new IllegalStateException(outline.j(strValueOf.length() + 27, "Component not initialized: ", strValueOf));
    }

    public static void q(r5 r5Var) {
        if (r5Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (r5Var.n()) {
            return;
        }
        String strValueOf = String.valueOf(r5Var.getClass());
        throw new IllegalStateException(outline.j(strValueOf.length() + 27, "Component not initialized: ", strValueOf));
    }

    public final a A() {
        a aVar = this.r;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("Component not created");
    }

    @WorkerThread
    public final boolean B() {
        return this.B != null && this.B.booleanValue();
    }

    public final c a() {
        return this.h;
    }

    @WorkerThread
    public final boolean d() {
        return e() == 0;
    }

    @WorkerThread
    public final int e() {
        f().b();
        if (this.h.x()) {
            return 1;
        }
        Boolean bool = this.D;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (b.i.a.f.h.l.t8.b() && this.h.o(p.H0) && !h()) {
            return 8;
        }
        Boolean boolX = o().x();
        if (boolX != null) {
            return boolX.booleanValue() ? 0 : 3;
        }
        Boolean boolW = this.h.w("firebase_analytics_collection_enabled");
        if (boolW != null) {
            return boolW.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.C;
        if (bool2 != null) {
            return bool2.booleanValue() ? 0 : 5;
        }
        if (b.i.a.f.e.h.j.h.a("isMeasurementExplicitlyDisabled").e) {
            return 6;
        }
        return (!this.h.o(p.S) || this.B == null || this.B.booleanValue()) ? 0 : 7;
    }

    @Override // b.i.a.f.i.b.t5
    public final r4 f() {
        q(this.k);
        return this.k;
    }

    @Override // b.i.a.f.i.b.t5
    public final q3 g() {
        q(this.j);
        return this.j;
    }

    @WorkerThread
    public final boolean h() {
        f().b();
        return this.E;
    }

    @Override // b.i.a.f.i.b.t5
    public final b.i.a.f.e.o.b i() {
        return this.o;
    }

    @Override // b.i.a.f.i.b.t5
    public final Context j() {
        return this.f1570b;
    }

    @Override // b.i.a.f.i.b.t5
    public final ga k() {
        return this.g;
    }

    public final void l() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c3  */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m() {
        if (!this.f1573y) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        f().b();
        Boolean bool = this.f1574z;
        if (bool == null || this.A == 0) {
            Objects.requireNonNull((b.i.a.f.e.o.c) this.o);
            this.A = SystemClock.elapsedRealtime();
            Boolean boolValueOf = Boolean.valueOf(t().p0("android.permission.INTERNET") && t().p0("android.permission.ACCESS_NETWORK_STATE") && (b.i.a.f.e.p.b.a(this.f1570b).c() || this.h.C() || (n4.a(this.f1570b) && t9.U(this.f1570b))));
            this.f1574z = boolValueOf;
            if (boolValueOf.booleanValue()) {
                t9 t9VarT = t();
                n3 n3VarZ = z();
                n3VarZ.t();
                String str = n3VarZ.k;
                n3 n3VarZ2 = z();
                n3VarZ2.t();
                String str2 = n3VarZ2.l;
                n3 n3VarZ3 = z();
                n3VarZ3.t();
                if (!t9VarT.c0(str, str2, n3VarZ3.m)) {
                    n3 n3VarZ4 = z();
                    n3VarZ4.t();
                    boolean z2 = TextUtils.isEmpty(n3VarZ4.l) ? false : true;
                    this.f1574z = Boolean.valueOf(z2);
                }
            }
        } else if (!bool.booleanValue()) {
            Objects.requireNonNull((b.i.a.f.e.o.c) this.o);
            if (Math.abs(SystemClock.elapsedRealtime() - this.A) > 1000) {
            }
        }
        return this.f1574z.booleanValue();
    }

    public final d7 n() {
        q(this.f1571s);
        return this.f1571s;
    }

    public final d4 o() {
        c(this.i);
        return this.i;
    }

    public final w8 r() {
        p(this.l);
        return this.l;
    }

    public final c6 s() {
        p(this.q);
        return this.q;
    }

    public final t9 t() {
        c(this.m);
        return this.m;
    }

    public final o3 u() {
        c(this.n);
        return this.n;
    }

    public final boolean v() {
        return TextUtils.isEmpty(this.c);
    }

    public final h7 w() {
        p(this.p);
        return this.p;
    }

    public final q7 x() {
        p(this.u);
        return this.u;
    }

    public final j y() {
        q(this.v);
        return this.v;
    }

    public final n3 z() {
        p(this.w);
        return this.w;
    }
}
