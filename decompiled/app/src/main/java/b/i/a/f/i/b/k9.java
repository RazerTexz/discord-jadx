package b.i.a.f.i.b;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.h.l.a1;
import b.i.a.f.h.l.c1;
import b.i.a.f.h.l.d1;
import b.i.a.f.h.l.e1;
import b.i.a.f.h.l.hb;
import b.i.a.f.h.l.i1;
import b.i.a.f.h.l.u4;
import com.adjust.sdk.AdjustConfig;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public class k9 implements t5 {
    public static volatile k9 a;

    /* renamed from: b, reason: collision with root package name */
    public p4 f1542b;
    public x3 c;
    public g d;
    public b4 e;
    public h9 f;
    public ba g;
    public final q9 h;
    public g7 i;
    public q8 j;
    public final u4 k;
    public boolean m;
    public long n;
    public List<Runnable> o;
    public int p;
    public int q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1543s;
    public boolean t;
    public FileLock u;
    public FileChannel v;
    public List<Long> w;

    /* renamed from: x, reason: collision with root package name */
    public List<Long> f1544x;

    /* renamed from: y, reason: collision with root package name */
    public long f1545y;

    /* renamed from: z, reason: collision with root package name */
    public final Map<String, d> f1546z;
    public boolean l = false;
    public final v9 A = new n9(this);

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public class a {
        public b.i.a.f.h.l.e1 a;

        /* renamed from: b, reason: collision with root package name */
        public List<Long> f1547b;
        public List<b.i.a.f.h.l.a1> c;
        public long d;

        public a(k9 k9Var, j9 j9Var) {
        }

        public final void a(b.i.a.f.h.l.e1 e1Var) {
            this.a = e1Var;
        }

        public final boolean b(long j, b.i.a.f.h.l.a1 a1Var) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            if (this.f1547b == null) {
                this.f1547b = new ArrayList();
            }
            if (this.c.size() > 0 && ((this.c.get(0).H() / 1000) / 60) / 60 != ((a1Var.H() / 1000) / 60) / 60) {
                return false;
            }
            long jG = this.d + a1Var.g();
            if (jG >= Math.max(0, p.i.a(null).intValue())) {
                return false;
            }
            this.d = jG;
            this.c.add(a1Var);
            this.f1547b.add(Long.valueOf(j));
            return this.c.size() < Math.max(1, p.j.a(null).intValue());
        }
    }

    public k9(r9 r9Var) throws IllegalStateException {
        u4 u4VarB = u4.b(r9Var.a, null, null);
        this.k = u4VarB;
        this.f1545y = -1L;
        q9 q9Var = new q9(this);
        q9Var.o();
        this.h = q9Var;
        x3 x3Var = new x3(this);
        x3Var.o();
        this.c = x3Var;
        p4 p4Var = new p4(this);
        p4Var.o();
        this.f1542b = p4Var;
        this.f1546z = new HashMap();
        u4VarB.f().v(new j9(this, r9Var));
    }

    public static void C(i9 i9Var) {
        if (i9Var == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (i9Var.c) {
            return;
        }
        String strValueOf = String.valueOf(i9Var.getClass());
        throw new IllegalStateException(outline.j(strValueOf.length() + 27, "Component not initialized: ", strValueOf));
    }

    public static k9 b(Context context) {
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(context.getApplicationContext(), "null reference");
        if (a == null) {
            synchronized (k9.class) {
                if (a == null) {
                    a = new k9(new r9(context));
                }
            }
        }
        return a;
    }

    public static void d(a1.a aVar, int i, String str) {
        List<b.i.a.f.h.l.c1> listV = aVar.v();
        for (int i2 = 0; i2 < listV.size(); i2++) {
            if ("_err".equals(listV.get(i2).B())) {
                return;
            }
        }
        c1.a aVarQ = b.i.a.f.h.l.c1.Q();
        aVarQ.s("_err");
        aVarQ.r(Long.valueOf(i).longValue());
        b.i.a.f.h.l.c1 c1Var = (b.i.a.f.h.l.c1) ((b.i.a.f.h.l.u4) aVarQ.p());
        c1.a aVarQ2 = b.i.a.f.h.l.c1.Q();
        aVarQ2.s("_ev");
        aVarQ2.t(str);
        b.i.a.f.h.l.c1 c1Var2 = (b.i.a.f.h.l.c1) ((b.i.a.f.h.l.u4) aVarQ2.p());
        if (aVar.l) {
            aVar.n();
            aVar.l = false;
        }
        b.i.a.f.h.l.a1.A((b.i.a.f.h.l.a1) aVar.k, c1Var);
        if (aVar.l) {
            aVar.n();
            aVar.l = false;
        }
        b.i.a.f.h.l.a1.A((b.i.a.f.h.l.a1) aVar.k, c1Var2);
    }

    public static void e(a1.a aVar, @NonNull String str) {
        List<b.i.a.f.h.l.c1> listV = aVar.v();
        for (int i = 0; i < listV.size(); i++) {
            if (str.equals(listV.get(i).B())) {
                aVar.x(i);
                return;
            }
        }
    }

    public final void A(a1.a aVar, a1.a aVar2) {
        AnimatableValueParser.l("_e".equals(aVar.y()));
        N();
        b.i.a.f.h.l.c1 c1VarW = q9.w((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVar.p()), "_et");
        if (!c1VarW.I() || c1VarW.J() <= 0) {
            return;
        }
        long J = c1VarW.J();
        N();
        b.i.a.f.h.l.c1 c1VarW2 = q9.w((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVar2.p()), "_et");
        if (c1VarW2 != null && c1VarW2.J() > 0) {
            J += c1VarW2.J();
        }
        N();
        q9.E(aVar2, "_et", Long.valueOf(J));
        N();
        q9.E(aVar, "_fr", 1L);
    }

    @WorkerThread
    public final void B(zzaq zzaqVar, zzn zznVar) throws IllegalStateException {
        if (b.i.a.f.h.l.ea.b() && this.k.h.o(p.A0)) {
            u3 u3VarB = u3.b(zzaqVar);
            this.k.t().H(u3VarB.d, K().h0(zznVar.j));
            this.k.t().Q(u3VarB, this.k.h.m(zznVar.j));
            zzaqVar = u3VarB.a();
        }
        if (this.k.h.o(p.f1556e0) && "_cmp".equals(zzaqVar.j) && "referrer API v2".equals(zzaqVar.k.j.getString("_cis"))) {
            String string = zzaqVar.k.j.getString("gclid");
            if (!TextUtils.isEmpty(string)) {
                o(new zzku("_lgclid", zzaqVar.m, string, "auto"), zznVar);
            }
        }
        l(zzaqVar, zznVar);
    }

    @WorkerThread
    public final void D(zzku zzkuVar, zzn zznVar) {
        U();
        P();
        if (L(zznVar)) {
            if (!zznVar.q) {
                G(zznVar);
                return;
            }
            if ("_npa".equals(zzkuVar.k) && zznVar.B != null) {
                this.k.g().m.a("Falling back to manifest metadata value for ad personalization");
                Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
                o(new zzku("_npa", System.currentTimeMillis(), Long.valueOf(zznVar.B.booleanValue() ? 1L : 0L), "auto"), zznVar);
                return;
            }
            this.k.g().m.b("Removing user property", this.k.u().y(zzkuVar.k));
            K().b0();
            try {
                G(zznVar);
                K().V(zznVar.j, zzkuVar.k);
                K().s();
                this.k.g().m.b("User property removed", this.k.u().y(zzkuVar.k));
            } finally {
                K().e0();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0237  */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E(zzn zznVar) {
        a4 a4Var;
        String str;
        long j;
        String str2;
        long j2;
        PackageInfo packageInfoB;
        String str3;
        long j3;
        ApplicationInfo applicationInfoA;
        boolean z2;
        U();
        P();
        Objects.requireNonNull(zznVar, "null reference");
        AnimatableValueParser.w(zznVar.j);
        if (L(zznVar)) {
            a4 a4VarT = K().T(zznVar.j);
            if (a4VarT != null && TextUtils.isEmpty(a4VarT.v()) && !TextUtils.isEmpty(zznVar.k)) {
                a4VarT.F(0L);
                K().I(a4VarT);
                p4 p4VarH = H();
                String str4 = zznVar.j;
                p4VarH.b();
                p4VarH.g.remove(str4);
            }
            if (!zznVar.q) {
                G(zznVar);
                return;
            }
            long jCurrentTimeMillis = zznVar.v;
            if (jCurrentTimeMillis == 0) {
                Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            j jVarY = this.k.y();
            jVarY.b();
            jVarY.g = null;
            jVarY.h = 0L;
            int i = zznVar.w;
            if (i != 0 && i != 1) {
                this.k.g().i.c("Incorrect app type, assuming installed app. appId, appType", q3.s(zznVar.j), Integer.valueOf(i));
                i = 0;
            }
            K().b0();
            try {
                u9 u9VarY = K().Y(zznVar.j, "_npa");
                if (u9VarY == null || "auto".equals(u9VarY.f1576b)) {
                    Boolean bool = zznVar.B;
                    if (bool != null) {
                        a4Var = null;
                        zzku zzkuVar = new zzku("_npa", jCurrentTimeMillis, Long.valueOf(bool.booleanValue() ? 1L : 0L), "auto");
                        if (u9VarY == null || !u9VarY.e.equals(zzkuVar.m)) {
                            o(zzkuVar, zznVar);
                        }
                    } else {
                        a4Var = null;
                        if (u9VarY != null) {
                            D(new zzku("_npa", jCurrentTimeMillis, null, "auto"), zznVar);
                        }
                    }
                } else {
                    a4Var = null;
                }
                a4 a4VarT2 = K().T(zznVar.j);
                if (a4VarT2 != null) {
                    this.k.t();
                    if (t9.d0(zznVar.k, a4VarT2.v(), zznVar.A, a4VarT2.y())) {
                        this.k.g().i.b("New GMP App Id passed in. Removing cached database data. appId", q3.s(a4VarT2.o()));
                        g gVarK = K();
                        String strO = a4VarT2.o();
                        gVarK.n();
                        gVarK.b();
                        AnimatableValueParser.w(strO);
                        try {
                            SQLiteDatabase sQLiteDatabaseT = gVarK.t();
                            String[] strArr = {strO};
                            int iDelete = sQLiteDatabaseT.delete("events", "app_id=?", strArr) + 0 + sQLiteDatabaseT.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseT.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseT.delete("apps", "app_id=?", strArr) + sQLiteDatabaseT.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseT.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseT.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseT.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseT.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseT.delete("consent_settings", "app_id=?", strArr);
                            if (iDelete > 0) {
                                gVarK.g().n.c("Deleted application data. app, records", strO, Integer.valueOf(iDelete));
                            }
                        } catch (SQLiteException e) {
                            gVarK.g().f.c("Error deleting application data. appId, error", q3.s(strO), e);
                        }
                        a4VarT2 = a4Var;
                    }
                }
                if (a4VarT2 != null) {
                    if (((a4VarT2.N() == -2147483648L || a4VarT2.N() == zznVar.f3012s) ? false : true) | ((a4VarT2.N() != -2147483648L || a4VarT2.M() == null || a4VarT2.M().equals(zznVar.l)) ? false : true)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("_pv", a4VarT2.M());
                        l(new zzaq("_au", new zzap(bundle), "auto", jCurrentTimeMillis), zznVar);
                    }
                }
                G(zznVar);
                if ((i == 0 ? K().z(zznVar.j, "_f") : i == 1 ? K().z(zznVar.j, "_v") : a4Var) == null) {
                    long j4 = ((jCurrentTimeMillis / 3600000) + 1) * 3600000;
                    if (i == 0) {
                        o(new zzku("_fot", jCurrentTimeMillis, Long.valueOf(j4), "auto"), zznVar);
                        U();
                        this.k.f1572x.a(zznVar.j);
                        U();
                        P();
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("_c", 1L);
                        bundle2.putLong("_r", 1L);
                        bundle2.putLong("_uwa", 0L);
                        bundle2.putLong("_pfo", 0L);
                        bundle2.putLong("_sys", 0L);
                        bundle2.putLong("_sysu", 0L);
                        if (this.k.h.u(zznVar.j, p.T)) {
                            str2 = "_et";
                            j2 = 1;
                            bundle2.putLong(str2, 1L);
                        } else {
                            str2 = "_et";
                            j2 = 1;
                        }
                        if (zznVar.f3015z) {
                            bundle2.putLong("_dac", j2);
                        }
                        g gVarK2 = K();
                        String str5 = zznVar.j;
                        AnimatableValueParser.w(str5);
                        gVarK2.b();
                        gVarK2.n();
                        long jG0 = gVarK2.g0(str5, "first_open_count");
                        if (this.k.f1570b.getPackageManager() == null) {
                            this.k.g().f.b("PackageManager is null, first open report might be inaccurate. appId", q3.s(zznVar.j));
                            str3 = str2;
                            j3 = jG0;
                        } else {
                            try {
                                packageInfoB = b.i.a.f.e.p.b.a(this.k.f1570b).b(zznVar.j, 0);
                            } catch (PackageManager.NameNotFoundException e2) {
                                this.k.g().f.c("Package info is null, first open report might be inaccurate. appId", q3.s(zznVar.j), e2);
                                packageInfoB = a4Var;
                            }
                            if (packageInfoB != 0) {
                                long j5 = packageInfoB.firstInstallTime;
                                if (j5 != 0) {
                                    str3 = str2;
                                    if (j5 != packageInfoB.lastUpdateTime) {
                                        if (!this.k.h.o(p.n0) || jG0 == 0) {
                                            bundle2.putLong("_uwa", 1L);
                                        }
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    j3 = jG0;
                                    o(new zzku("_fi", jCurrentTimeMillis, Long.valueOf(z2 ? 1L : 0L), "auto"), zznVar);
                                } else {
                                    str3 = str2;
                                    j3 = jG0;
                                }
                                try {
                                    applicationInfoA = b.i.a.f.e.p.b.a(this.k.f1570b).a(zznVar.j, 0);
                                } catch (PackageManager.NameNotFoundException e3) {
                                    this.k.g().f.c("Application info is null, first open report might be inaccurate. appId", q3.s(zznVar.j), e3);
                                    applicationInfoA = a4Var;
                                }
                                if (applicationInfoA != 0) {
                                    if ((applicationInfoA.flags & 1) != 0) {
                                        bundle2.putLong("_sys", 1L);
                                    }
                                    if ((applicationInfoA.flags & 128) != 0) {
                                        bundle2.putLong("_sysu", 1L);
                                    }
                                }
                            }
                        }
                        if (j3 >= 0) {
                            bundle2.putLong("_pfo", j3);
                        }
                        B(new zzaq("_f", new zzap(bundle2), "auto", jCurrentTimeMillis), zznVar);
                        str = str3;
                    } else {
                        str = "_et";
                        if (i == 1) {
                            o(new zzku("_fvt", jCurrentTimeMillis, Long.valueOf(j4), "auto"), zznVar);
                            U();
                            P();
                            Bundle bundle3 = new Bundle();
                            bundle3.putLong("_c", 1L);
                            bundle3.putLong("_r", 1L);
                            if (this.k.h.u(zznVar.j, p.T)) {
                                j = 1;
                                bundle3.putLong(str, 1L);
                            } else {
                                j = 1;
                            }
                            if (zznVar.f3015z) {
                                bundle3.putLong("_dac", j);
                            }
                            B(new zzaq("_v", new zzap(bundle3), "auto", jCurrentTimeMillis), zznVar);
                        }
                    }
                    if (!this.k.h.u(zznVar.j, p.U)) {
                        Bundle bundle4 = new Bundle();
                        bundle4.putLong(str, 1L);
                        if (this.k.h.u(zznVar.j, p.T)) {
                            bundle4.putLong("_fr", 1L);
                        }
                        B(new zzaq("_e", new zzap(bundle4), "auto", jCurrentTimeMillis), zznVar);
                    }
                } else if (zznVar.r) {
                    B(new zzaq("_cd", new zzap(new Bundle()), "auto", jCurrentTimeMillis), zznVar);
                }
                K().s();
            } finally {
                K().e0();
            }
        }
    }

    @WorkerThread
    public final void F(zzz zzzVar, zzn zznVar) {
        Objects.requireNonNull(zzzVar, "null reference");
        AnimatableValueParser.w(zzzVar.j);
        Objects.requireNonNull(zzzVar.l, "null reference");
        AnimatableValueParser.w(zzzVar.l.k);
        U();
        P();
        if (L(zznVar)) {
            if (!zznVar.q) {
                G(zznVar);
                return;
            }
            K().b0();
            try {
                G(zznVar);
                zzz zzzVarZ = K().Z(zzzVar.j, zzzVar.l.k);
                if (zzzVarZ != null) {
                    this.k.g().m.c("Removing conditional user property", zzzVar.j, this.k.u().y(zzzVar.l.k));
                    K().a0(zzzVar.j, zzzVar.l.k);
                    if (zzzVarZ.n) {
                        K().V(zzzVar.j, zzzVar.l.k);
                    }
                    zzaq zzaqVar = zzzVar.t;
                    if (zzaqVar != null) {
                        zzap zzapVar = zzaqVar.k;
                        Bundle bundleX0 = zzapVar != null ? zzapVar.x0() : null;
                        t9 t9VarT = this.k.t();
                        String str = zzzVar.j;
                        zzaq zzaqVar2 = zzzVar.t;
                        I(t9VarT.B(str, zzaqVar2.j, bundleX0, zzzVarZ.k, zzaqVar2.m, true, b.i.a.f.h.l.x7.b() && this.k.h.o(p.M0)), zznVar);
                    }
                } else {
                    this.k.g().i.c("Conditional user property doesn't exist", q3.s(zzzVar.j), this.k.u().y(zzzVar.l.k));
                }
                K().s();
            } finally {
                K().e0();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0407  */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final a4 G(zzn zznVar) {
        boolean z2;
        long j;
        String str;
        long j2;
        U();
        P();
        Objects.requireNonNull(zznVar, "null reference");
        AnimatableValueParser.w(zznVar.j);
        a4 a4VarT = K().T(zznVar.j);
        d dVarH = d.a;
        d dVarH2 = (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) ? a(zznVar.j).h(d.b(zznVar.F)) : dVarH;
        String strT = (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0) && !dVarH2.j()) ? "" : this.j.t(zznVar.j);
        if (((b.i.a.f.h.l.p9) b.i.a.f.h.l.m9.j.a()).a() && this.k.h.o(p.o0)) {
            if (a4VarT == null) {
                a4VarT = new a4(this.k, zznVar.j);
                if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) {
                    if (dVarH2.k()) {
                        a4VarT.c(c(dVarH2));
                    }
                    if (dVarH2.j()) {
                        a4VarT.x(strT);
                    }
                } else {
                    a4VarT.c(W());
                    a4VarT.x(strT);
                }
            } else if ((!b.i.a.f.h.l.t8.b() || !this.k.h.o(p.J0) || dVarH2.j()) && !strT.equals(a4VarT.E())) {
                a4VarT.x(strT);
                if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) {
                    a4VarT.c(c(dVarH2));
                } else {
                    a4VarT.c(W());
                }
            } else if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0) && TextUtils.isEmpty(a4VarT.s()) && dVarH2.k()) {
                a4VarT.c(c(dVarH2));
            }
            a4VarT.m(zznVar.k);
            a4VarT.q(zznVar.A);
            if (b.i.a.f.h.l.da.b() && this.k.h.u(a4VarT.o(), p.f1561j0)) {
                a4VarT.u(zznVar.E);
            }
            if (!TextUtils.isEmpty(zznVar.t)) {
                a4VarT.A(zznVar.t);
            }
            long j3 = zznVar.n;
            if (j3 != 0) {
                a4VarT.t(j3);
            }
            if (!TextUtils.isEmpty(zznVar.l)) {
                a4VarT.D(zznVar.l);
            }
            a4VarT.p(zznVar.f3012s);
            String str2 = zznVar.m;
            if (str2 != null) {
                a4VarT.G(str2);
            }
            a4VarT.w(zznVar.o);
            a4VarT.e(zznVar.q);
            if (!TextUtils.isEmpty(zznVar.p)) {
                a4VarT.J(zznVar.p);
            }
            if (!this.k.h.o(p.y0)) {
                a4VarT.R(zznVar.u);
            }
            a4VarT.n(zznVar.f3013x);
            a4VarT.r(zznVar.f3014y);
            a4VarT.b(zznVar.B);
            a4VarT.z(zznVar.C);
            a4VarT.a.f().b();
            if (a4VarT.E) {
                K().I(a4VarT);
            }
            return a4VarT;
        }
        if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) {
            dVarH = a(zznVar.j).h(d.b(zznVar.F));
        }
        boolean z3 = true;
        if (a4VarT == null) {
            a4VarT = new a4(this.k, zznVar.j);
            if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) {
                if (dVarH.k()) {
                    a4VarT.c(c(dVarH));
                }
                if (dVarH.j()) {
                    a4VarT.x(strT);
                }
            } else {
                a4VarT.c(W());
                a4VarT.x(strT);
            }
        } else if ((!b.i.a.f.h.l.t8.b() || !this.k.h.o(p.J0) || dVarH.j()) && !strT.equals(a4VarT.E())) {
            a4VarT.x(strT);
            if (!b.i.a.f.h.l.t8.b() || !this.k.h.o(p.J0)) {
                a4VarT.c(W());
            } else if (dVarH.k()) {
                a4VarT.c(c(dVarH));
            }
        } else {
            if (!b.i.a.f.h.l.t8.b() || !this.k.h.o(p.J0) || !TextUtils.isEmpty(a4VarT.s()) || !dVarH.k()) {
                z2 = false;
                if (!TextUtils.equals(zznVar.k, a4VarT.v())) {
                    a4VarT.m(zznVar.k);
                    z2 = true;
                }
                if (!TextUtils.equals(zznVar.A, a4VarT.y())) {
                    a4VarT.q(zznVar.A);
                    z2 = true;
                }
                if (b.i.a.f.h.l.da.b() && this.k.h.u(a4VarT.o(), p.f1561j0) && !TextUtils.equals(zznVar.E, a4VarT.B())) {
                    a4VarT.u(zznVar.E);
                    z2 = true;
                }
                if (!TextUtils.isEmpty(zznVar.t) && !zznVar.t.equals(a4VarT.H())) {
                    a4VarT.A(zznVar.t);
                    z2 = true;
                }
                j = zznVar.n;
                if (j != 0 && j != a4VarT.P()) {
                    a4VarT.t(zznVar.n);
                    z2 = true;
                }
                if (!TextUtils.isEmpty(zznVar.l) && !zznVar.l.equals(a4VarT.M())) {
                    a4VarT.D(zznVar.l);
                    z2 = true;
                }
                if (zznVar.f3012s != a4VarT.N()) {
                    a4VarT.p(zznVar.f3012s);
                    z2 = true;
                }
                str = zznVar.m;
                if (str != null && !str.equals(a4VarT.O())) {
                    a4VarT.G(zznVar.m);
                    z2 = true;
                }
                if (zznVar.o != a4VarT.Q()) {
                    a4VarT.w(zznVar.o);
                    z2 = true;
                }
                if (zznVar.q != a4VarT.T()) {
                    a4VarT.e(zznVar.q);
                    z2 = true;
                }
                if (!TextUtils.isEmpty(zznVar.p)) {
                    String str3 = zznVar.p;
                    a4VarT.a.f().b();
                    if (!str3.equals(a4VarT.D)) {
                        a4VarT.J(zznVar.p);
                        z2 = true;
                    }
                }
                if (!this.k.h.o(p.y0) && zznVar.u != a4VarT.g()) {
                    a4VarT.R(zznVar.u);
                    z2 = true;
                }
                if (zznVar.f3013x != a4VarT.h()) {
                    a4VarT.n(zznVar.f3013x);
                    z2 = true;
                }
                if (zznVar.f3014y != a4VarT.i()) {
                    a4VarT.r(zznVar.f3014y);
                    z2 = true;
                }
                if (zznVar.B != a4VarT.j()) {
                    a4VarT.b(zznVar.B);
                    z2 = true;
                }
                j2 = zznVar.C;
                if (j2 != 0 || j2 == a4VarT.S()) {
                    z3 = z2;
                } else {
                    a4VarT.z(zznVar.C);
                }
                if (z3) {
                    K().I(a4VarT);
                }
                return a4VarT;
            }
            a4VarT.c(c(dVarH));
        }
        z2 = true;
        if (!TextUtils.equals(zznVar.k, a4VarT.v())) {
        }
        if (!TextUtils.equals(zznVar.A, a4VarT.y())) {
        }
        if (b.i.a.f.h.l.da.b()) {
            a4VarT.u(zznVar.E);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zznVar.t)) {
            a4VarT.A(zznVar.t);
            z2 = true;
        }
        j = zznVar.n;
        if (j != 0) {
            a4VarT.t(zznVar.n);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zznVar.l)) {
            a4VarT.D(zznVar.l);
            z2 = true;
        }
        if (zznVar.f3012s != a4VarT.N()) {
        }
        str = zznVar.m;
        if (str != null) {
            a4VarT.G(zznVar.m);
            z2 = true;
        }
        if (zznVar.o != a4VarT.Q()) {
        }
        if (zznVar.q != a4VarT.T()) {
        }
        if (!TextUtils.isEmpty(zznVar.p)) {
        }
        if (!this.k.h.o(p.y0)) {
            a4VarT.R(zznVar.u);
            z2 = true;
        }
        if (zznVar.f3013x != a4VarT.h()) {
        }
        if (zznVar.f3014y != a4VarT.i()) {
        }
        if (zznVar.B != a4VarT.j()) {
        }
        j2 = zznVar.C;
        if (j2 != 0) {
            z3 = z2;
        }
        if (z3) {
        }
        return a4VarT;
    }

    public final p4 H() {
        C(this.f1542b);
        return this.f1542b;
    }

    /* JADX WARN: Removed duplicated region for block: B:296:0x094d A[Catch: all -> 0x099c, TryCatch #2 {all -> 0x099c, blocks: (B:38:0x013e, B:41:0x014d, B:43:0x0157, B:48:0x0163, B:55:0x0175, B:58:0x0181, B:60:0x0198, B:65:0x01b1, B:70:0x01e6, B:72:0x01ec, B:74:0x01fa, B:76:0x0202, B:78:0x020c, B:80:0x0217, B:83:0x021e, B:92:0x02b0, B:94:0x02ba, B:98:0x02f3, B:102:0x0305, B:104:0x0352, B:106:0x0357, B:107:0x0370, B:111:0x0381, B:113:0x0396, B:115:0x039b, B:116:0x03b4, B:120:0x03d9, B:124:0x03fe, B:125:0x0417, B:128:0x0426, B:131:0x0449, B:132:0x0465, B:134:0x046f, B:136:0x047b, B:138:0x0481, B:139:0x048c, B:141:0x0498, B:142:0x04af, B:144:0x04d7, B:147:0x04f0, B:150:0x0536, B:152:0x054e, B:154:0x0585, B:155:0x058a, B:157:0x0592, B:158:0x0597, B:160:0x059f, B:161:0x05a4, B:163:0x05ad, B:164:0x05b1, B:166:0x05be, B:167:0x05c3, B:169:0x05c9, B:171:0x05d7, B:172:0x05ee, B:174:0x05f4, B:176:0x0604, B:178:0x060e, B:180:0x0616, B:181:0x061b, B:183:0x0625, B:185:0x062f, B:187:0x0637, B:193:0x0654, B:195:0x065c, B:196:0x065f, B:198:0x066e, B:199:0x0671, B:201:0x0687, B:203:0x0695, B:227:0x073f, B:229:0x0784, B:230:0x0789, B:232:0x0791, B:234:0x0797, B:236:0x07a5, B:238:0x07ac, B:241:0x07b4, B:242:0x07b7, B:237:0x07a9, B:243:0x07b8, B:245:0x07c4, B:247:0x07d3, B:249:0x07e1, B:251:0x07f0, B:253:0x0800, B:255:0x080e, B:258:0x081f, B:260:0x0854, B:261:0x0859, B:257:0x0814, B:250:0x07e9, B:262:0x0865, B:264:0x086b, B:266:0x0879, B:271:0x0890, B:273:0x089a, B:274:0x08a1, B:275:0x08ac, B:277:0x08b2, B:279:0x08e1, B:280:0x08f1, B:282:0x08f9, B:283:0x08fd, B:285:0x0906, B:294:0x0947, B:296:0x094d, B:299:0x0969, B:288:0x0913, B:290:0x0931, B:298:0x0951, B:268:0x087f, B:270:0x0889, B:205:0x069b, B:207:0x06ad, B:209:0x06b1, B:211:0x06bc, B:212:0x06c7, B:214:0x06d9, B:216:0x06dd, B:218:0x06e3, B:220:0x06f3, B:222:0x0705, B:226:0x073c, B:223:0x071f, B:225:0x0725, B:188:0x063d, B:190:0x0647, B:192:0x064f, B:151:0x0540, B:85:0x0248, B:86:0x0267, B:91:0x0293, B:90:0x0282, B:77:0x0207, B:68:0x01bf, B:69:0x01dc), top: B:309:0x013e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02ba A[Catch: all -> 0x099c, TryCatch #2 {all -> 0x099c, blocks: (B:38:0x013e, B:41:0x014d, B:43:0x0157, B:48:0x0163, B:55:0x0175, B:58:0x0181, B:60:0x0198, B:65:0x01b1, B:70:0x01e6, B:72:0x01ec, B:74:0x01fa, B:76:0x0202, B:78:0x020c, B:80:0x0217, B:83:0x021e, B:92:0x02b0, B:94:0x02ba, B:98:0x02f3, B:102:0x0305, B:104:0x0352, B:106:0x0357, B:107:0x0370, B:111:0x0381, B:113:0x0396, B:115:0x039b, B:116:0x03b4, B:120:0x03d9, B:124:0x03fe, B:125:0x0417, B:128:0x0426, B:131:0x0449, B:132:0x0465, B:134:0x046f, B:136:0x047b, B:138:0x0481, B:139:0x048c, B:141:0x0498, B:142:0x04af, B:144:0x04d7, B:147:0x04f0, B:150:0x0536, B:152:0x054e, B:154:0x0585, B:155:0x058a, B:157:0x0592, B:158:0x0597, B:160:0x059f, B:161:0x05a4, B:163:0x05ad, B:164:0x05b1, B:166:0x05be, B:167:0x05c3, B:169:0x05c9, B:171:0x05d7, B:172:0x05ee, B:174:0x05f4, B:176:0x0604, B:178:0x060e, B:180:0x0616, B:181:0x061b, B:183:0x0625, B:185:0x062f, B:187:0x0637, B:193:0x0654, B:195:0x065c, B:196:0x065f, B:198:0x066e, B:199:0x0671, B:201:0x0687, B:203:0x0695, B:227:0x073f, B:229:0x0784, B:230:0x0789, B:232:0x0791, B:234:0x0797, B:236:0x07a5, B:238:0x07ac, B:241:0x07b4, B:242:0x07b7, B:237:0x07a9, B:243:0x07b8, B:245:0x07c4, B:247:0x07d3, B:249:0x07e1, B:251:0x07f0, B:253:0x0800, B:255:0x080e, B:258:0x081f, B:260:0x0854, B:261:0x0859, B:257:0x0814, B:250:0x07e9, B:262:0x0865, B:264:0x086b, B:266:0x0879, B:271:0x0890, B:273:0x089a, B:274:0x08a1, B:275:0x08ac, B:277:0x08b2, B:279:0x08e1, B:280:0x08f1, B:282:0x08f9, B:283:0x08fd, B:285:0x0906, B:294:0x0947, B:296:0x094d, B:299:0x0969, B:288:0x0913, B:290:0x0931, B:298:0x0951, B:268:0x087f, B:270:0x0889, B:205:0x069b, B:207:0x06ad, B:209:0x06b1, B:211:0x06bc, B:212:0x06c7, B:214:0x06d9, B:216:0x06dd, B:218:0x06e3, B:220:0x06f3, B:222:0x0705, B:226:0x073c, B:223:0x071f, B:225:0x0725, B:188:0x063d, B:190:0x0647, B:192:0x064f, B:151:0x0540, B:85:0x0248, B:86:0x0267, B:91:0x0293, B:90:0x0282, B:77:0x0207, B:68:0x01bf, B:69:0x01dc), top: B:309:0x013e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02f3 A[Catch: all -> 0x099c, TRY_LEAVE, TryCatch #2 {all -> 0x099c, blocks: (B:38:0x013e, B:41:0x014d, B:43:0x0157, B:48:0x0163, B:55:0x0175, B:58:0x0181, B:60:0x0198, B:65:0x01b1, B:70:0x01e6, B:72:0x01ec, B:74:0x01fa, B:76:0x0202, B:78:0x020c, B:80:0x0217, B:83:0x021e, B:92:0x02b0, B:94:0x02ba, B:98:0x02f3, B:102:0x0305, B:104:0x0352, B:106:0x0357, B:107:0x0370, B:111:0x0381, B:113:0x0396, B:115:0x039b, B:116:0x03b4, B:120:0x03d9, B:124:0x03fe, B:125:0x0417, B:128:0x0426, B:131:0x0449, B:132:0x0465, B:134:0x046f, B:136:0x047b, B:138:0x0481, B:139:0x048c, B:141:0x0498, B:142:0x04af, B:144:0x04d7, B:147:0x04f0, B:150:0x0536, B:152:0x054e, B:154:0x0585, B:155:0x058a, B:157:0x0592, B:158:0x0597, B:160:0x059f, B:161:0x05a4, B:163:0x05ad, B:164:0x05b1, B:166:0x05be, B:167:0x05c3, B:169:0x05c9, B:171:0x05d7, B:172:0x05ee, B:174:0x05f4, B:176:0x0604, B:178:0x060e, B:180:0x0616, B:181:0x061b, B:183:0x0625, B:185:0x062f, B:187:0x0637, B:193:0x0654, B:195:0x065c, B:196:0x065f, B:198:0x066e, B:199:0x0671, B:201:0x0687, B:203:0x0695, B:227:0x073f, B:229:0x0784, B:230:0x0789, B:232:0x0791, B:234:0x0797, B:236:0x07a5, B:238:0x07ac, B:241:0x07b4, B:242:0x07b7, B:237:0x07a9, B:243:0x07b8, B:245:0x07c4, B:247:0x07d3, B:249:0x07e1, B:251:0x07f0, B:253:0x0800, B:255:0x080e, B:258:0x081f, B:260:0x0854, B:261:0x0859, B:257:0x0814, B:250:0x07e9, B:262:0x0865, B:264:0x086b, B:266:0x0879, B:271:0x0890, B:273:0x089a, B:274:0x08a1, B:275:0x08ac, B:277:0x08b2, B:279:0x08e1, B:280:0x08f1, B:282:0x08f9, B:283:0x08fd, B:285:0x0906, B:294:0x0947, B:296:0x094d, B:299:0x0969, B:288:0x0913, B:290:0x0931, B:298:0x0951, B:268:0x087f, B:270:0x0889, B:205:0x069b, B:207:0x06ad, B:209:0x06b1, B:211:0x06bc, B:212:0x06c7, B:214:0x06d9, B:216:0x06dd, B:218:0x06e3, B:220:0x06f3, B:222:0x0705, B:226:0x073c, B:223:0x071f, B:225:0x0725, B:188:0x063d, B:190:0x0647, B:192:0x064f, B:151:0x0540, B:85:0x0248, B:86:0x0267, B:91:0x0293, B:90:0x0282, B:77:0x0207, B:68:0x01bf, B:69:0x01dc), top: B:309:0x013e, inners: #0, #1 }] */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I(zzaq zzaqVar, zzn zznVar) throws IllegalStateException {
        long j;
        int i;
        l lVarA;
        boolean z2;
        u9 u9VarY;
        long jLongValue;
        boolean z3;
        g gVarK;
        u9 u9Var;
        u9 u9Var2;
        Long l;
        a4 a4VarT;
        zzaq zzaqVarA = zzaqVar;
        AnimatableValueParser.A(zznVar);
        AnimatableValueParser.w(zznVar.j);
        long jNanoTime = System.nanoTime();
        U();
        P();
        String str = zznVar.j;
        N();
        if (q9.O(zzaqVar, zznVar)) {
            if (!zznVar.q) {
                G(zznVar);
                return;
            }
            boolean z4 = true;
            if (H().x(str, zzaqVarA.j)) {
                this.k.g().A().c("Dropping blacklisted event. appId", q3.s(str), this.k.u().u(zzaqVarA.j));
                if (!H().C(str) && !H().D(str)) {
                    z4 = false;
                }
                if (z4 || "_err".equals(zzaqVarA.j)) {
                    l = null;
                } else {
                    l = null;
                    this.k.t().S(this.A, str, 11, "_ev", zzaqVarA.j, 0);
                }
                if (!z4 || (a4VarT = K().T(str)) == null || Math.abs(((b.i.a.f.e.o.c) this.k.i()).a() - Math.max(a4VarT.W(), a4VarT.V())) <= p.f1565z.a(l).longValue()) {
                    return;
                }
                this.k.g().C().a("Fetching config for blacklisted app");
                n(a4VarT);
                return;
            }
            if (b.i.a.f.h.l.o8.b() && this.k.a().o(p.w0)) {
                u3 u3VarB = u3.b(zzaqVar);
                this.k.t().Q(u3VarB, this.k.a().m(str));
                zzaqVarA = u3VarB.a();
            }
            if (this.k.g().x(2)) {
                this.k.g().D().b("Logging event", this.k.u().t(zzaqVarA));
            }
            K().b0();
            try {
                G(zznVar);
                boolean z5 = "ecommerce_purchase".equals(zzaqVarA.j) || "purchase".equals(zzaqVarA.j) || "refund".equals(zzaqVarA.j);
                if ("_iap".equals(zzaqVarA.j) || z5) {
                    String strA0 = zzaqVarA.k.A0("currency");
                    if (z5) {
                        double dDoubleValue = zzaqVarA.k.z0("value").doubleValue() * 1000000.0d;
                        if (dDoubleValue == 0.0d) {
                            dDoubleValue = zzaqVarA.k.y0("value").longValue() * 1000000.0d;
                        }
                        if (dDoubleValue > 9.223372036854776E18d || dDoubleValue < -9.223372036854776E18d) {
                            this.k.g().A().c("Data lost. Currency value is too big. appId", q3.s(str), Double.valueOf(dDoubleValue));
                            j = jNanoTime;
                            i = 0;
                            z3 = false;
                            if (!z3) {
                                K().s();
                                return;
                            }
                        } else {
                            jLongValue = Math.round(dDoubleValue);
                            if ("refund".equals(zzaqVarA.j)) {
                                jLongValue = -jLongValue;
                            }
                        }
                    } else {
                        jLongValue = zzaqVarA.k.y0("value").longValue();
                    }
                    if (!TextUtils.isEmpty(strA0)) {
                        String upperCase = strA0.toUpperCase(Locale.US);
                        if (upperCase.matches("[A-Z]{3}")) {
                            String strConcat = upperCase.length() != 0 ? "_ltv_".concat(upperCase) : new String("_ltv_");
                            u9 u9VarY2 = K().Y(str, strConcat);
                            if (u9VarY2 != null) {
                                Object obj = u9VarY2.e;
                                if (obj instanceof Long) {
                                    j = jNanoTime;
                                    i = 0;
                                    u9Var = new u9(str, zzaqVarA.l, strConcat, ((b.i.a.f.e.o.c) this.k.i()).a(), Long.valueOf(((Long) obj).longValue() + jLongValue));
                                    u9Var2 = u9Var;
                                    if (!K().M(u9Var2)) {
                                    }
                                } else {
                                    j = jNanoTime;
                                    i = 0;
                                    gVarK = K();
                                    int iQ = this.k.a().q(str, p.E) - 1;
                                    AnimatableValueParser.w(str);
                                    gVarK.b();
                                    gVarK.n();
                                    try {
                                        gVarK.t().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(iQ)});
                                    } catch (SQLiteException e) {
                                        gVarK.g().z().c("Error pruning currencies. appId", q3.s(str), e);
                                    }
                                    u9Var = new u9(str, zzaqVarA.l, strConcat, ((b.i.a.f.e.o.c) this.k.i()).a(), Long.valueOf(jLongValue));
                                    u9Var2 = u9Var;
                                    if (!K().M(u9Var2)) {
                                        this.k.g().z().d("Too many unique user properties are set. Ignoring user property. appId", q3.s(str), this.k.u().y(u9Var2.c), u9Var2.e);
                                        this.k.t().S(this.A, str, 9, null, null, 0);
                                    }
                                }
                            } else {
                                j = jNanoTime;
                                i = 0;
                                gVarK = K();
                                int iQ2 = this.k.a().q(str, p.E) - 1;
                                AnimatableValueParser.w(str);
                                gVarK.b();
                                gVarK.n();
                                gVarK.t().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(iQ2)});
                                u9Var = new u9(str, zzaqVarA.l, strConcat, ((b.i.a.f.e.o.c) this.k.i()).a(), Long.valueOf(jLongValue));
                                u9Var2 = u9Var;
                                if (!K().M(u9Var2)) {
                                }
                            }
                        } else {
                            j = jNanoTime;
                            i = 0;
                        }
                        z3 = true;
                        if (!z3) {
                        }
                    }
                } else {
                    j = jNanoTime;
                    i = 0;
                }
                boolean zX = t9.X(zzaqVarA.j);
                boolean zEquals = "_err".equals(zzaqVarA.j);
                this.k.t();
                f fVarX = K().x(V(), str, t9.v(zzaqVarA.k) + 1, true, zX, false, zEquals, false);
                long jIntValue = fVarX.f1532b - p.k.a(null).intValue();
                if (jIntValue > 0) {
                    if (jIntValue % 1000 == 1) {
                        this.k.g().z().c("Data loss. Too many events logged. appId, count", q3.s(str), Long.valueOf(fVarX.f1532b));
                    }
                    K().s();
                    return;
                }
                if (zX) {
                    long jIntValue2 = fVarX.a - p.m.a(null).intValue();
                    if (jIntValue2 > 0) {
                        if (jIntValue2 % 1000 == 1) {
                            this.k.g().z().c("Data loss. Too many public events logged. appId, count", q3.s(str), Long.valueOf(fVarX.a));
                        }
                        this.k.t().S(this.A, str, 16, "_ev", zzaqVarA.j, 0);
                        K().s();
                        return;
                    }
                }
                if (zEquals) {
                    long jMax = fVarX.d - Math.max(i, Math.min(1000000, this.k.a().q(zznVar.j, p.l)));
                    if (jMax > 0) {
                        if (jMax == 1) {
                            this.k.g().z().c("Too many error events logged. appId, count", q3.s(str), Long.valueOf(fVarX.d));
                        }
                        K().s();
                        return;
                    }
                }
                Bundle bundleX0 = zzaqVarA.k.x0();
                this.k.t().I(bundleX0, "_o", zzaqVarA.l);
                if (this.k.t().s0(str)) {
                    this.k.t().I(bundleX0, "_dbg", 1L);
                    this.k.t().I(bundleX0, "_r", 1L);
                }
                if ("_s".equals(zzaqVarA.j) && (u9VarY = K().Y(zznVar.j, "_sno")) != null && (u9VarY.e instanceof Long)) {
                    this.k.t().I(bundleX0, "_sno", u9VarY.e);
                }
                long jX = K().X(str);
                if (jX > 0) {
                    this.k.g().A().c("Data lost. Too many events stored on disk, deleted. appId", q3.s(str), Long.valueOf(jX));
                }
                m mVar = new m(this.k, zzaqVarA.l, str, zzaqVarA.j, zzaqVarA.m, 0L, bundleX0);
                l lVarZ = K().z(str, mVar.f1549b);
                if (lVarZ != null) {
                    mVar = mVar.a(this.k, lVarZ.f);
                    lVarA = lVarZ.a(mVar.d);
                } else {
                    if (K().f0(str) >= this.k.a().p(str) && zX) {
                        this.k.g().z().d("Too many event names used, ignoring event. appId, name, supported count", q3.s(str), this.k.u().u(mVar.f1549b), Integer.valueOf(this.k.a().p(str)));
                        this.k.t().S(this.A, str, 8, null, null, 0);
                        return;
                    }
                    lVarA = new l(str, mVar.f1549b, mVar.d);
                }
                K().H(lVarA);
                U();
                P();
                AnimatableValueParser.A(mVar);
                AnimatableValueParser.A(zznVar);
                AnimatableValueParser.w(mVar.a);
                AnimatableValueParser.l(mVar.a.equals(zznVar.j));
                e1.a aVarU0 = b.i.a.f.h.l.e1.u0();
                aVarU0.q();
                aVarU0.x("android");
                if (!TextUtils.isEmpty(zznVar.j)) {
                    aVarU0.X(zznVar.j);
                }
                if (!TextUtils.isEmpty(zznVar.m)) {
                    aVarU0.T(zznVar.m);
                }
                if (!TextUtils.isEmpty(zznVar.l)) {
                    aVarU0.a0(zznVar.l);
                }
                long j2 = zznVar.f3012s;
                if (j2 != -2147483648L) {
                    aVarU0.c0((int) j2);
                }
                aVarU0.W(zznVar.n);
                if (!TextUtils.isEmpty(zznVar.k)) {
                    aVarU0.m0(zznVar.k);
                }
                if (b.i.a.f.h.l.t8.b() && this.k.a().o(p.J0)) {
                    aVarU0.w0(a(zznVar.j).h(d.b(zznVar.F)).d());
                }
                if (b.i.a.f.h.l.da.b() && this.k.a().v(zznVar.j, p.f1561j0)) {
                    if (TextUtils.isEmpty(aVarU0.s0()) && !TextUtils.isEmpty(zznVar.E)) {
                        aVarU0.u0(zznVar.E);
                    }
                    if (TextUtils.isEmpty(aVarU0.s0()) && TextUtils.isEmpty(aVarU0.x0()) && !TextUtils.isEmpty(zznVar.A)) {
                        aVarU0.r0(zznVar.A);
                    }
                } else if (TextUtils.isEmpty(aVarU0.s0()) && !TextUtils.isEmpty(zznVar.A)) {
                    aVarU0.r0(zznVar.A);
                }
                long j3 = zznVar.o;
                if (j3 != 0) {
                    aVarU0.d0(j3);
                }
                aVarU0.l0(zznVar.C);
                List<Integer> listU = N().U();
                if (listU != null) {
                    aVarU0.M(listU);
                }
                d dVarH = a(zznVar.j).h(d.b(zznVar.F));
                if (!b.i.a.f.h.l.t8.b() || !this.k.a().o(p.J0) || dVarH.j()) {
                    Pair<String, Boolean> pairS = this.j.s(zznVar.j, dVarH);
                    if (TextUtils.isEmpty((CharSequence) pairS.first)) {
                        if (!this.k.y().s(this.k.j()) && zznVar.f3014y && (!hb.b() || !this.k.a().v(zznVar.j, p.G0))) {
                            String string = Settings.Secure.getString(this.k.j().getContentResolver(), "android_id");
                            if (string == null) {
                                this.k.g().A().b("null secure ID. appId", q3.s(aVarU0.k0()));
                                string = "null";
                            } else if (string.isEmpty()) {
                                this.k.g().A().b("empty secure ID. appId", q3.s(aVarU0.k0()));
                            }
                            aVarU0.o0(string);
                        }
                    } else if (zznVar.f3013x) {
                        aVarU0.e0((String) pairS.first);
                        Object obj2 = pairS.second;
                        if (obj2 != null) {
                            aVarU0.y(((Boolean) obj2).booleanValue());
                        }
                    }
                }
                this.k.y().o();
                aVarU0.J(Build.MODEL);
                this.k.y().o();
                aVarU0.E(Build.VERSION.RELEASE);
                aVarU0.V((int) this.k.y().t());
                aVarU0.N(this.k.y().u());
                if (!this.k.a().o(p.y0)) {
                    aVarU0.i0(zznVar.u);
                }
                if (this.k.d()) {
                    if (b.i.a.f.h.l.t8.b() && this.k.a().o(p.J0)) {
                        aVarU0.k0();
                    } else {
                        aVarU0.k0();
                    }
                    if (!TextUtils.isEmpty(null)) {
                        aVarU0.q0();
                        throw null;
                    }
                }
                a4 a4VarT2 = K().T(zznVar.j);
                if (a4VarT2 == null) {
                    a4VarT2 = new a4(this.k, zznVar.j);
                    if (b.i.a.f.h.l.t8.b() && this.k.a().o(p.J0)) {
                        a4VarT2.c(c(dVarH));
                    } else {
                        a4VarT2.c(W());
                    }
                    a4VarT2.A(zznVar.t);
                    a4VarT2.m(zznVar.k);
                    if (!b.i.a.f.h.l.t8.b() || !this.k.a().o(p.J0) || dVarH.j()) {
                        a4VarT2.x(this.j.t(zznVar.j));
                    }
                    a4VarT2.C(0L);
                    a4VarT2.a(0L);
                    a4VarT2.l(0L);
                    a4VarT2.D(zznVar.l);
                    a4VarT2.p(zznVar.f3012s);
                    a4VarT2.G(zznVar.m);
                    a4VarT2.t(zznVar.n);
                    a4VarT2.w(zznVar.o);
                    a4VarT2.e(zznVar.q);
                    if (!this.k.a().o(p.y0)) {
                        a4VarT2.R(zznVar.u);
                    }
                    a4VarT2.z(zznVar.C);
                    K().I(a4VarT2);
                }
                if ((!b.i.a.f.h.l.t8.b() || !this.k.a().o(p.J0) || dVarH.k()) && !TextUtils.isEmpty(a4VarT2.s())) {
                    aVarU0.h0(a4VarT2.s());
                }
                if (!TextUtils.isEmpty(a4VarT2.H())) {
                    aVarU0.n0(a4VarT2.H());
                }
                List<u9> listC = K().C(zznVar.j);
                for (int i2 = 0; i2 < listC.size(); i2++) {
                    i1.a aVarL = b.i.a.f.h.l.i1.L();
                    aVarL.r(listC.get(i2).c);
                    aVarL.q(listC.get(i2).d);
                    N().G(aVarL, listC.get(i2).e);
                    aVarU0.u(aVarL);
                }
                try {
                    long jV = K().v((b.i.a.f.h.l.e1) ((b.i.a.f.h.l.u4) aVarU0.p()));
                    g gVarK2 = K();
                    zzap zzapVar = mVar.f;
                    if (zzapVar != null) {
                        Iterator<String> it = zzapVar.iterator();
                        while (true) {
                            n nVar = (n) it;
                            if (nVar.hasNext()) {
                                if ("_r".equals((String) nVar.next())) {
                                    break;
                                }
                            } else {
                                boolean zY = H().y(mVar.a, mVar.f1549b);
                                f fVarY = K().y(V(), mVar.a, false, false);
                                if (!zY || fVarY.e >= this.k.a().s(mVar.a)) {
                                }
                                if (gVarK2.L(mVar, jV, z2)) {
                                    this.n = 0L;
                                }
                            }
                        }
                        z2 = true;
                        if (gVarK2.L(mVar, jV, z2)) {
                        }
                    } else {
                        z2 = false;
                        if (gVarK2.L(mVar, jV, z2)) {
                        }
                    }
                } catch (IOException e2) {
                    this.k.g().z().c("Data loss. Failed to insert raw event metadata. appId", q3.s(aVarU0.k0()), e2);
                }
                K().s();
                K().e0();
                w();
                this.k.g().D().b("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
            } finally {
                K().e0();
            }
        }
    }

    public final x3 J() {
        C(this.c);
        return this.c;
    }

    public final g K() {
        C(this.d);
        return this.d;
    }

    public final boolean L(zzn zznVar) {
        return (b.i.a.f.h.l.da.b() && this.k.h.u(zznVar.j, p.f1561j0)) ? (TextUtils.isEmpty(zznVar.k) && TextUtils.isEmpty(zznVar.E) && TextUtils.isEmpty(zznVar.A)) ? false : true : (TextUtils.isEmpty(zznVar.k) && TextUtils.isEmpty(zznVar.A)) ? false : true;
    }

    public final ba M() {
        C(this.g);
        return this.g;
    }

    public final q9 N() {
        C(this.h);
        return this.h;
    }

    public final o3 O() {
        return this.k.u();
    }

    public final void P() {
        if (!this.l) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    @WorkerThread
    public final void Q() throws IllegalStateException {
        a4 a4VarT;
        String strJ;
        U();
        P();
        this.t = true;
        try {
            Boolean bool = this.k.x().e;
            if (bool == null) {
                this.k.g().i.a("Upload data called on the client side before use of service was decided");
                return;
            }
            if (bool.booleanValue()) {
                this.k.g().f.a("Upload called in the client side when service should be used");
                return;
            }
            if (this.n > 0) {
                w();
                return;
            }
            U();
            if (this.w != null) {
                this.k.g().n.a("Uploading requested multiple times");
                return;
            }
            if (!J().u()) {
                this.k.g().n.a("Network not connected, ignoring upload request");
                w();
                return;
            }
            Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
            long jCurrentTimeMillis = System.currentTimeMillis();
            int iQ = this.k.h.q(null, p.Q);
            long jLongValue = jCurrentTimeMillis - p.d.a(null).longValue();
            for (int i = 0; i < iQ && t(jLongValue); i++) {
            }
            long jA = this.k.o().f.a();
            if (jA != 0) {
                this.k.g().m.b("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(jCurrentTimeMillis - jA)));
            }
            String strU = K().u();
            if (TextUtils.isEmpty(strU)) {
                this.f1545y = -1L;
                String strB = K().B(jCurrentTimeMillis - p.d.a(null).longValue());
                if (!TextUtils.isEmpty(strB) && (a4VarT = K().T(strB)) != null) {
                    n(a4VarT);
                }
            } else {
                if (this.f1545y == -1) {
                    this.f1545y = K().j0();
                }
                List<Pair<b.i.a.f.h.l.e1, Long>> listD = K().D(strU, this.k.h.q(strU, p.g), Math.max(0, this.k.h.q(strU, p.h)));
                if (!listD.isEmpty()) {
                    if (!b.i.a.f.h.l.t8.b() || !this.k.h.o(p.J0) || a(strU).j()) {
                        Iterator<Pair<b.i.a.f.h.l.e1, Long>> it = listD.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                strJ = null;
                                break;
                            }
                            b.i.a.f.h.l.e1 e1Var = (b.i.a.f.h.l.e1) it.next().first;
                            if (!TextUtils.isEmpty(e1Var.J())) {
                                strJ = e1Var.J();
                                break;
                            }
                        }
                        if (strJ != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= listD.size()) {
                                    break;
                                }
                                b.i.a.f.h.l.e1 e1Var2 = (b.i.a.f.h.l.e1) listD.get(i2).first;
                                if (!TextUtils.isEmpty(e1Var2.J()) && !e1Var2.J().equals(strJ)) {
                                    listD = listD.subList(0, i2);
                                    break;
                                }
                                i2++;
                            }
                        }
                    }
                    d1.a aVarX = b.i.a.f.h.l.d1.x();
                    int size = listD.size();
                    ArrayList arrayList = new ArrayList(listD.size());
                    boolean z2 = "1".equals(this.k.h.c.h(strU, "gaia_collection_enabled")) && !(b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0) && !a(strU).j());
                    boolean z3 = (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0) && !a(strU).j()) ? false : true;
                    boolean z4 = (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0) && !a(strU).k()) ? false : true;
                    int i3 = 0;
                    while (i3 < size) {
                        e1.a aVarT = ((b.i.a.f.h.l.e1) listD.get(i3).first).t();
                        arrayList.add((Long) listD.get(i3).second);
                        ArrayList arrayList2 = arrayList;
                        if (aVarT.l) {
                            aVarT.n();
                            aVarT.l = false;
                        }
                        b.i.a.f.h.l.e1.W0((b.i.a.f.h.l.e1) aVarT.k, 33025L);
                        if (aVarT.l) {
                            aVarT.n();
                            aVarT.l = false;
                        }
                        b.i.a.f.h.l.e1.y((b.i.a.f.h.l.e1) aVarT.k, jCurrentTimeMillis);
                        if (aVarT.l) {
                            aVarT.n();
                            aVarT.l = false;
                        }
                        b.i.a.f.h.l.e1.m0((b.i.a.f.h.l.e1) aVarT.k, false);
                        if (!z2) {
                            if (aVarT.l) {
                                aVarT.n();
                                aVarT.l = false;
                            }
                            b.i.a.f.h.l.e1.i1((b.i.a.f.h.l.e1) aVarT.k);
                        }
                        if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) {
                            if (!z3) {
                                if (aVarT.l) {
                                    aVarT.n();
                                    aVarT.l = false;
                                }
                                b.i.a.f.h.l.e1.F0((b.i.a.f.h.l.e1) aVarT.k);
                                if (aVarT.l) {
                                    aVarT.n();
                                    aVarT.l = false;
                                }
                                b.i.a.f.h.l.e1.L0((b.i.a.f.h.l.e1) aVarT.k);
                            }
                            if (!z4) {
                                if (aVarT.l) {
                                    aVarT.n();
                                    aVarT.l = false;
                                }
                                b.i.a.f.h.l.e1.Q0((b.i.a.f.h.l.e1) aVarT.k);
                            }
                        }
                        if (this.k.h.u(strU, p.X)) {
                            long jT = N().t(((b.i.a.f.h.l.e1) ((b.i.a.f.h.l.u4) aVarT.p())).d());
                            if (aVarT.l) {
                                aVarT.n();
                                aVarT.l = false;
                            }
                            b.i.a.f.h.l.e1.p1((b.i.a.f.h.l.e1) aVarT.k, jT);
                        }
                        aVarX.q(aVarT);
                        i3++;
                        arrayList = arrayList2;
                    }
                    ArrayList arrayList3 = arrayList;
                    String strZ = this.k.g().x(2) ? N().z((b.i.a.f.h.l.d1) ((b.i.a.f.h.l.u4) aVarX.p())) : null;
                    N();
                    byte[] bArrD = ((b.i.a.f.h.l.d1) ((b.i.a.f.h.l.u4) aVarX.p())).d();
                    String strA = p.q.a(null);
                    try {
                        URL url = new URL(strA);
                        AnimatableValueParser.l(!arrayList3.isEmpty());
                        if (this.w != null) {
                            this.k.g().f.a("Set uploading progress before finishing the previous upload");
                        } else {
                            this.w = new ArrayList(arrayList3);
                        }
                        this.k.o().g.b(jCurrentTimeMillis);
                        this.k.g().n.d("Uploading data. app, uncompressed size, data", size > 0 ? ((b.i.a.f.h.l.d1) aVarX.k).u().G1() : "?", Integer.valueOf(bArrD.length), strZ);
                        this.f1543s = true;
                        x3 x3VarJ = J();
                        m9 m9Var = new m9(this, strU);
                        x3VarJ.b();
                        x3VarJ.n();
                        x3VarJ.f().x(new c4(x3VarJ, strU, url, bArrD, null, m9Var));
                    } catch (MalformedURLException unused) {
                        this.k.g().f.c("Failed to parse upload URL. Not uploading. appId", q3.s(strU), strA);
                    }
                }
            }
        } finally {
            this.t = false;
            x();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void R() throws IOException {
        boolean z2;
        FileLock fileLockTryLock;
        int i;
        int i2;
        int i3;
        FileLock fileLock;
        U();
        P();
        if (this.m) {
            return;
        }
        boolean z3 = true;
        this.m = true;
        U();
        if (this.k.h.o(p.f1560i0) && (fileLock = this.u) != null && fileLock.isValid()) {
            this.k.g().n.a("Storage concurrent access okay");
        } else {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.k.f1570b.getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.v = channel;
                fileLockTryLock = channel.tryLock();
                this.u = fileLockTryLock;
            } catch (FileNotFoundException e) {
                this.k.g().f.b("Failed to acquire storage lock", e);
            } catch (IOException e2) {
                this.k.g().f.b("Failed to access storage lock file", e2);
            } catch (OverlappingFileLockException e3) {
                this.k.g().i.b("Storage lock already acquired", e3);
            }
            if (fileLockTryLock != null) {
                this.k.g().n.a("Storage concurrent access okay");
            } else {
                this.k.g().f.a("Storage concurrent data access panic");
                z2 = false;
                if (z2) {
                    return;
                }
                FileChannel fileChannel = this.v;
                U();
                if (fileChannel == null || !fileChannel.isOpen()) {
                    this.k.g().f.a("Bad channel to read from");
                } else {
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0L);
                        i3 = fileChannel.read(byteBufferAllocate);
                    } catch (IOException e4) {
                        this.k.g().f.b("Failed to read from channel", e4);
                    }
                    if (i3 == 4) {
                        byteBufferAllocate.flip();
                        i = byteBufferAllocate.getInt();
                        n3 n3VarZ = this.k.z();
                        n3VarZ.t();
                        i2 = n3VarZ.e;
                        U();
                        if (i <= i2) {
                            this.k.g().f.c("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                            return;
                        }
                        if (i >= i2) {
                            return;
                        }
                        FileChannel fileChannel2 = this.v;
                        U();
                        if (fileChannel2 != null && fileChannel2.isOpen()) {
                            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                            byteBufferAllocate2.putInt(i2);
                            byteBufferAllocate2.flip();
                            try {
                                fileChannel2.truncate(0L);
                                this.k.h.o(p.s0);
                                fileChannel2.write(byteBufferAllocate2);
                                fileChannel2.force(true);
                                if (fileChannel2.size() != 4) {
                                    this.k.g().f.b("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                                }
                            } catch (IOException e5) {
                                this.k.g().f.b("Failed to write to channel", e5);
                            }
                            if (z3) {
                                this.k.g().f.c("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                                return;
                            } else {
                                this.k.g().n.c("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                                return;
                            }
                        }
                        this.k.g().f.a("Bad channel to read from");
                        z3 = false;
                        if (z3) {
                        }
                    } else if (i3 != -1) {
                        this.k.g().i.b("Unexpected data length. Bytes read", Integer.valueOf(i3));
                    }
                }
                i = 0;
                n3 n3VarZ2 = this.k.z();
                n3VarZ2.t();
                i2 = n3VarZ2.e;
                U();
                if (i <= i2) {
                }
            }
        }
        z2 = true;
        if (z2) {
        }
    }

    public final b4 S() {
        b4 b4Var = this.e;
        if (b4Var != null) {
            return b4Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final h9 T() {
        C(this.f);
        return this.f;
    }

    @WorkerThread
    public final void U() {
        this.k.f().b();
    }

    public final long V() {
        Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
        long jCurrentTimeMillis = System.currentTimeMillis();
        d4 d4VarO = this.k.o();
        d4VarO.o();
        d4VarO.b();
        long jA = d4VarO.j.a();
        if (jA == 0) {
            jA = 1 + d4VarO.e().v0().nextInt(86400000);
            d4VarO.j.b(jA);
        }
        return ((((jCurrentTimeMillis + jA) / 1000) / 60) / 60) / 24;
    }

    @WorkerThread
    @Deprecated
    public final String W() {
        byte[] bArr = new byte[16];
        this.k.t().v0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    @WorkerThread
    public final d a(String str) {
        String string;
        d dVar = d.a;
        if (!b.i.a.f.h.l.t8.b() || !this.k.h.o(p.J0)) {
            return dVar;
        }
        U();
        P();
        d dVar2 = this.f1546z.get(str);
        if (dVar2 != null) {
            return dVar2;
        }
        g gVarK = K();
        Objects.requireNonNull(gVarK);
        Objects.requireNonNull(str, "null reference");
        gVarK.b();
        gVarK.n();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = gVarK.t().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
                if (cursorRawQuery.moveToFirst()) {
                    string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                } else {
                    cursorRawQuery.close();
                    string = "G1";
                }
                d dVarB = d.b(string);
                s(str, dVarB);
                return dVarB;
            } catch (SQLiteException e) {
                gVarK.g().f.c("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final String c(d dVar) {
        if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0) && !dVar.k()) {
            return null;
        }
        return W();
    }

    @Override // b.i.a.f.i.b.t5
    public final r4 f() {
        return this.k.f();
    }

    @Override // b.i.a.f.i.b.t5
    public final q3 g() {
        return this.k.g();
    }

    public final void h(e1.a aVar, long j, boolean z2) {
        u9 u9Var;
        boolean z3;
        String str = z2 ? "_se" : "_lte";
        u9 u9VarY = K().Y(aVar.k0(), str);
        if (u9VarY == null || u9VarY.e == null) {
            String strK0 = aVar.k0();
            Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
            u9Var = new u9(strK0, "auto", str, System.currentTimeMillis(), Long.valueOf(j));
        } else {
            String strK02 = aVar.k0();
            Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
            u9Var = new u9(strK02, "auto", str, System.currentTimeMillis(), Long.valueOf(((Long) u9VarY.e).longValue() + j));
        }
        i1.a aVarL = b.i.a.f.h.l.i1.L();
        aVarL.r(str);
        Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
        aVarL.q(System.currentTimeMillis());
        aVarL.s(((Long) u9Var.e).longValue());
        b.i.a.f.h.l.i1 i1Var = (b.i.a.f.h.l.i1) ((b.i.a.f.h.l.u4) aVarL.p());
        int iS = q9.s(aVar, str);
        if (iS >= 0) {
            if (aVar.l) {
                aVar.n();
                aVar.l = false;
            }
            b.i.a.f.h.l.e1.x((b.i.a.f.h.l.e1) aVar.k, iS, i1Var);
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            if (aVar.l) {
                aVar.n();
                aVar.l = false;
            }
            b.i.a.f.h.l.e1.A((b.i.a.f.h.l.e1) aVar.k, i1Var);
        }
        if (j > 0) {
            K().M(u9Var);
            this.k.g().n.c("Updated engagement user property. scope, value", z2 ? "session-scoped" : "lifetime", u9Var.e);
        }
    }

    @Override // b.i.a.f.i.b.t5
    public final b.i.a.f.e.o.b i() {
        return this.k.o;
    }

    @Override // b.i.a.f.i.b.t5
    public final Context j() {
        return this.k.f1570b;
    }

    @Override // b.i.a.f.i.b.t5
    public final ga k() {
        return this.k.g;
    }

    @WorkerThread
    public final void l(zzaq zzaqVar, zzn zznVar) throws IllegalStateException {
        List<zzz> listF;
        List<zzz> listF2;
        List<zzz> listF3;
        zzaq zzaqVar2 = zzaqVar;
        Objects.requireNonNull(zznVar, "null reference");
        AnimatableValueParser.w(zznVar.j);
        U();
        P();
        String str = zznVar.j;
        long j = zzaqVar2.m;
        N();
        if (q9.O(zzaqVar, zznVar)) {
            if (!zznVar.q) {
                G(zznVar);
                return;
            }
            List<String> list = zznVar.D;
            if (list != null) {
                if (!list.contains(zzaqVar2.j)) {
                    this.k.g().m.d("Dropping non-safelisted event. appId, event name, origin", str, zzaqVar2.j, zzaqVar2.l);
                    return;
                } else {
                    Bundle bundleX0 = zzaqVar2.k.x0();
                    bundleX0.putLong("ga_safelisted", 1L);
                    zzaqVar2 = new zzaq(zzaqVar2.j, new zzap(bundleX0), zzaqVar2.l, zzaqVar2.m);
                }
            }
            K().b0();
            try {
                g gVarK = K();
                AnimatableValueParser.w(str);
                gVarK.b();
                gVarK.n();
                if (j < 0) {
                    gVarK.g().i.c("Invalid time querying timed out conditional properties", q3.s(str), Long.valueOf(j));
                    listF = Collections.emptyList();
                } else {
                    listF = gVarK.F("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzz zzzVar : listF) {
                    if (zzzVar != null) {
                        this.k.g().n.d("User property timed out", zzzVar.j, this.k.u().y(zzzVar.l.k), zzzVar.l.w0());
                        zzaq zzaqVar3 = zzzVar.p;
                        if (zzaqVar3 != null) {
                            I(new zzaq(zzaqVar3, j), zznVar);
                        }
                        K().a0(str, zzzVar.l.k);
                    }
                }
                g gVarK2 = K();
                AnimatableValueParser.w(str);
                gVarK2.b();
                gVarK2.n();
                if (j < 0) {
                    gVarK2.g().i.c("Invalid time querying expired conditional properties", q3.s(str), Long.valueOf(j));
                    listF2 = Collections.emptyList();
                } else {
                    listF2 = gVarK2.F("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(listF2.size());
                for (zzz zzzVar2 : listF2) {
                    if (zzzVar2 != null) {
                        this.k.g().n.d("User property expired", zzzVar2.j, this.k.u().y(zzzVar2.l.k), zzzVar2.l.w0());
                        K().V(str, zzzVar2.l.k);
                        zzaq zzaqVar4 = zzzVar2.t;
                        if (zzaqVar4 != null) {
                            arrayList.add(zzaqVar4);
                        }
                        K().a0(str, zzzVar2.l.k);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    I(new zzaq((zzaq) obj, j), zznVar);
                }
                g gVarK3 = K();
                String str2 = zzaqVar2.j;
                AnimatableValueParser.w(str);
                AnimatableValueParser.w(str2);
                gVarK3.b();
                gVarK3.n();
                if (j < 0) {
                    gVarK3.g().i.d("Invalid time querying triggered conditional properties", q3.s(str), gVarK3.d().u(str2), Long.valueOf(j));
                    listF3 = Collections.emptyList();
                } else {
                    listF3 = gVarK3.F("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(listF3.size());
                for (zzz zzzVar3 : listF3) {
                    if (zzzVar3 != null) {
                        zzku zzkuVar = zzzVar3.l;
                        u9 u9Var = new u9(zzzVar3.j, zzzVar3.k, zzkuVar.k, j, zzkuVar.w0());
                        if (K().M(u9Var)) {
                            this.k.g().n.d("User property triggered", zzzVar3.j, this.k.u().y(u9Var.c), u9Var.e);
                        } else {
                            this.k.g().f.d("Too many active user properties, ignoring", q3.s(zzzVar3.j), this.k.u().y(u9Var.c), u9Var.e);
                        }
                        zzaq zzaqVar5 = zzzVar3.r;
                        if (zzaqVar5 != null) {
                            arrayList2.add(zzaqVar5);
                        }
                        zzzVar3.l = new zzku(u9Var);
                        zzzVar3.n = true;
                        K().N(zzzVar3);
                    }
                }
                I(zzaqVar2, zznVar);
                int size2 = arrayList2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    I(new zzaq((zzaq) obj2, j), zznVar);
                }
                K().s();
            } finally {
                K().e0();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d7  */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m(zzaq zzaqVar, String str) throws IllegalStateException {
        boolean z2;
        a4 a4VarT = K().T(str);
        if (a4VarT == null || TextUtils.isEmpty(a4VarT.M())) {
            this.k.g().m.b("No app data available; dropping event", str);
            return;
        }
        Boolean boolZ = z(a4VarT);
        if (boolZ == null) {
            if (!"_ui".equals(zzaqVar.j)) {
                this.k.g().i.b("Could not find package. appId", q3.s(str));
            }
        } else if (!boolZ.booleanValue()) {
            this.k.g().f.b("App version does not match; dropping event. appId", q3.s(str));
            return;
        }
        String strV = a4VarT.v();
        String strM = a4VarT.M();
        long jN = a4VarT.N();
        String strO = a4VarT.O();
        long jP = a4VarT.P();
        long jQ = a4VarT.Q();
        boolean zT = a4VarT.T();
        String strH = a4VarT.H();
        long jG = a4VarT.g();
        boolean zH = a4VarT.h();
        boolean zI = a4VarT.i();
        String strY = a4VarT.y();
        Boolean boolJ = a4VarT.j();
        long jS = a4VarT.S();
        List<String> listK = a4VarT.k();
        if (b.i.a.f.h.l.da.b()) {
            z2 = zT;
            String strB = this.k.h.u(a4VarT.o(), p.f1561j0) ? a4VarT.B() : null;
            B(zzaqVar, new zzn(str, strV, strM, jN, strO, jP, jQ, (String) null, z2, false, strH, jG, 0L, 0, zH, zI, false, strY, boolJ, jS, listK, strB, (b.i.a.f.h.l.t8.b() || !this.k.h.o(p.J0)) ? "" : a(str).d()));
        }
        z2 = zT;
        B(zzaqVar, new zzn(str, strV, strM, jN, strO, jP, jQ, (String) null, z2, false, strH, jG, 0L, 0, zH, zI, false, strY, boolJ, jS, listK, strB, (b.i.a.f.h.l.t8.b() || !this.k.h.o(p.J0)) ? "" : a(str).d()));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(a4 a4Var) throws IllegalStateException {
        U();
        if (b.i.a.f.h.l.da.b() && this.k.h.u(a4Var.o(), p.f1561j0)) {
            if (TextUtils.isEmpty(a4Var.v()) && TextUtils.isEmpty(a4Var.B()) && TextUtils.isEmpty(a4Var.y())) {
                r(a4Var.o(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(a4Var.v()) && TextUtils.isEmpty(a4Var.y())) {
            r(a4Var.o(), 204, null, null, null);
            return;
        }
        c cVar = this.k.h;
        Objects.requireNonNull(cVar);
        Uri.Builder builder = new Uri.Builder();
        String strV = a4Var.v();
        if (TextUtils.isEmpty(strV)) {
            if (b.i.a.f.h.l.da.b() && cVar.a.h.u(a4Var.o(), p.f1561j0)) {
                strV = a4Var.B();
                if (TextUtils.isEmpty(strV)) {
                }
            } else {
                strV = a4Var.y();
            }
        }
        ArrayMap arrayMap = null;
        Uri.Builder builderEncodedAuthority = builder.scheme(p.e.a(null)).encodedAuthority(p.f.a(null));
        String strValueOf = String.valueOf(strV);
        builderEncodedAuthority.path(strValueOf.length() != 0 ? "config/app/".concat(strValueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", a4Var.s()).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "33025");
        String string = builder.build().toString();
        try {
            URL url = new URL(string);
            this.k.g().n.b("Fetching remote configuration", a4Var.o());
            b.i.a.f.h.l.u0 u0VarS = H().s(a4Var.o());
            p4 p4VarH = H();
            String strO = a4Var.o();
            p4VarH.b();
            String str = p4VarH.i.get(strO);
            if (u0VarS != null && !TextUtils.isEmpty(str)) {
                arrayMap = new ArrayMap();
                arrayMap.put("If-Modified-Since", str);
            }
            this.r = true;
            x3 x3VarJ = J();
            String strO2 = a4Var.o();
            l9 l9Var = new l9(this);
            x3VarJ.b();
            x3VarJ.n();
            x3VarJ.f().x(new c4(x3VarJ, strO2, url, null, arrayMap, l9Var));
        } catch (MalformedURLException unused) {
            this.k.g().f.c("Failed to parse config URL. Not fetching. appId", q3.s(a4Var.o()), string);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(zzku zzkuVar, zzn zznVar) {
        U();
        P();
        if (L(zznVar)) {
            if (!zznVar.q) {
                G(zznVar);
                return;
            }
            int iH0 = this.k.t().h0(zzkuVar.k);
            if (iH0 != 0) {
                this.k.t();
                String strE = t9.E(zzkuVar.k, 24, true);
                String str = zzkuVar.k;
                this.k.t().S(this.A, zznVar.j, iH0, "_ev", strE, str != null ? str.length() : 0);
                return;
            }
            int iI0 = this.k.t().i0(zzkuVar.k, zzkuVar.w0());
            if (iI0 != 0) {
                this.k.t();
                String strE2 = t9.E(zzkuVar.k, 24, true);
                Object objW0 = zzkuVar.w0();
                this.k.t().S(this.A, zznVar.j, iI0, "_ev", strE2, (objW0 == null || !((objW0 instanceof String) || (objW0 instanceof CharSequence))) ? 0 : String.valueOf(objW0).length());
                return;
            }
            Object objN0 = this.k.t().n0(zzkuVar.k, zzkuVar.w0());
            if (objN0 == null) {
                return;
            }
            if ("_sid".equals(zzkuVar.k)) {
                long j = zzkuVar.l;
                String str2 = zzkuVar.o;
                long jLongValue = 0;
                u9 u9VarY = K().Y(zznVar.j, "_sno");
                if (u9VarY != null) {
                    Object obj = u9VarY.e;
                    if (obj instanceof Long) {
                        jLongValue = ((Long) obj).longValue();
                    } else {
                        if (u9VarY != null) {
                            this.k.g().i.b("Retrieved last session number from database does not contain a valid (long) value", u9VarY.e);
                        }
                        l lVarZ = K().z(zznVar.j, "_s");
                        if (lVarZ != null) {
                            jLongValue = lVarZ.c;
                            this.k.g().n.b("Backfill the session number. Last used session number", Long.valueOf(jLongValue));
                        }
                    }
                    o(new zzku("_sno", j, Long.valueOf(jLongValue + 1), str2), zznVar);
                }
            }
            u9 u9Var = new u9(zznVar.j, zzkuVar.o, zzkuVar.k, zzkuVar.l, objN0);
            this.k.g().n.c("Setting user property", this.k.u().y(u9Var.c), objN0);
            K().b0();
            try {
                G(zznVar);
                boolean zM = K().M(u9Var);
                K().s();
                if (!zM) {
                    this.k.g().f.c("Too many unique user properties are set. Ignoring user property", this.k.u().y(u9Var.c), u9Var.e);
                    this.k.t().S(this.A, zznVar.j, 9, null, null, 0);
                }
            } finally {
                K().e0();
            }
        }
    }

    @WorkerThread
    public final void p(zzn zznVar) {
        if (this.w != null) {
            ArrayList arrayList = new ArrayList();
            this.f1544x = arrayList;
            arrayList.addAll(this.w);
        }
        g gVarK = K();
        String str = zznVar.j;
        AnimatableValueParser.w(str);
        gVarK.b();
        gVarK.n();
        try {
            SQLiteDatabase sQLiteDatabaseT = gVarK.t();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseT.delete("apps", "app_id=?", strArr) + 0 + sQLiteDatabaseT.delete("events", "app_id=?", strArr) + sQLiteDatabaseT.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseT.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseT.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseT.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseT.delete("queue", "app_id=?", strArr) + sQLiteDatabaseT.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseT.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseT.delete("default_event_params", "app_id=?", strArr);
            if (iDelete > 0) {
                gVarK.g().n.c("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            gVarK.g().f.c("Error resetting analytics data. appId, error", q3.s(str), e);
        }
        if (zznVar.q) {
            E(zznVar);
        }
    }

    @WorkerThread
    public final void q(zzz zzzVar, zzn zznVar) {
        zzaq zzaqVar;
        boolean z2;
        Objects.requireNonNull(zzzVar, "null reference");
        AnimatableValueParser.w(zzzVar.j);
        Objects.requireNonNull(zzzVar.k, "null reference");
        Objects.requireNonNull(zzzVar.l, "null reference");
        AnimatableValueParser.w(zzzVar.l.k);
        U();
        P();
        if (L(zznVar)) {
            if (!zznVar.q) {
                G(zznVar);
                return;
            }
            zzz zzzVar2 = new zzz(zzzVar);
            boolean z3 = false;
            zzzVar2.n = false;
            K().b0();
            try {
                zzz zzzVarZ = K().Z(zzzVar2.j, zzzVar2.l.k);
                if (zzzVarZ != null && !zzzVarZ.k.equals(zzzVar2.k)) {
                    this.k.g().i.d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.k.u().y(zzzVar2.l.k), zzzVar2.k, zzzVarZ.k);
                }
                if (zzzVarZ != null && (z2 = zzzVarZ.n)) {
                    zzzVar2.k = zzzVarZ.k;
                    zzzVar2.m = zzzVarZ.m;
                    zzzVar2.q = zzzVarZ.q;
                    zzzVar2.o = zzzVarZ.o;
                    zzzVar2.r = zzzVarZ.r;
                    zzzVar2.n = z2;
                    zzku zzkuVar = zzzVar2.l;
                    zzzVar2.l = new zzku(zzkuVar.k, zzzVarZ.l.l, zzkuVar.w0(), zzzVarZ.l.o);
                } else if (TextUtils.isEmpty(zzzVar2.o)) {
                    zzku zzkuVar2 = zzzVar2.l;
                    zzzVar2.l = new zzku(zzkuVar2.k, zzzVar2.m, zzkuVar2.w0(), zzzVar2.l.o);
                    zzzVar2.n = true;
                    z3 = true;
                }
                if (zzzVar2.n) {
                    zzku zzkuVar3 = zzzVar2.l;
                    u9 u9Var = new u9(zzzVar2.j, zzzVar2.k, zzkuVar3.k, zzkuVar3.l, zzkuVar3.w0());
                    if (K().M(u9Var)) {
                        this.k.g().m.d("User property updated immediately", zzzVar2.j, this.k.u().y(u9Var.c), u9Var.e);
                    } else {
                        this.k.g().f.d("(2)Too many active user properties, ignoring", q3.s(zzzVar2.j), this.k.u().y(u9Var.c), u9Var.e);
                    }
                    if (z3 && (zzaqVar = zzzVar2.r) != null) {
                        I(new zzaq(zzaqVar, zzzVar2.m), zznVar);
                    }
                }
                if (K().N(zzzVar2)) {
                    this.k.g().m.d("Conditional property added", zzzVar2.j, this.k.u().y(zzzVar2.l.k), zzzVar2.l.w0());
                } else {
                    this.k.g().f.d("Too many conditional properties, ignoring", q3.s(zzzVar2.j), this.k.u().y(zzzVar2.l.k), zzzVar2.l.w0());
                }
                K().s();
            } finally {
                K().e0();
            }
        }
    }

    @WorkerThread
    public final void r(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) throws IllegalStateException {
        U();
        P();
        AnimatableValueParser.w(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.r = false;
                x();
            }
        }
        this.k.g().n.b("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        K().b0();
        try {
            a4 a4VarT = K().T(str);
            boolean z2 = true;
            boolean z3 = (i == 200 || i == 204 || i == 304) && th == null;
            if (a4VarT == null) {
                this.k.g().i.b("App does not exist in onConfigFetched. appId", q3.s(str));
            } else if (z3 || i == 404) {
                List<String> list = map != null ? map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : list.get(0);
                if (i != 404 && i != 304) {
                    H().w(str, bArr, str2);
                } else if (H().s(str) == null) {
                    H().w(str, null, null);
                }
                Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
                a4VarT.F(System.currentTimeMillis());
                K().I(a4VarT);
                if (i == 404) {
                    this.k.g().k.b("Config not found. Using empty config. appId", str);
                } else {
                    this.k.g().n.c("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (J().u() && v()) {
                    Q();
                } else {
                    w();
                }
            } else {
                Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
                a4VarT.I(System.currentTimeMillis());
                K().I(a4VarT);
                this.k.g().n.c("Fetching config failed. code, error", Integer.valueOf(i), th);
                p4 p4VarH = H();
                p4VarH.b();
                p4VarH.i.put(str, null);
                h4 h4Var = this.k.o().g;
                Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
                h4Var.b(System.currentTimeMillis());
                if (i != 503 && i != 429) {
                    z2 = false;
                }
                if (z2) {
                    h4 h4Var2 = this.k.o().h;
                    Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
                    h4Var2.b(System.currentTimeMillis());
                }
                w();
            }
            K().s();
        } finally {
            K().e0();
        }
    }

    @WorkerThread
    public final void s(String str, d dVar) {
        if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) {
            U();
            P();
            this.f1546z.put(str, dVar);
            g gVarK = K();
            if (b.i.a.f.h.l.t8.b() && gVarK.a.h.o(p.J0)) {
                Objects.requireNonNull(str, "null reference");
                gVarK.b();
                gVarK.n();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("consent_state", dVar.d());
                try {
                    if (gVarK.t().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                        gVarK.g().f.b("Failed to insert/update consent setting (got -1). appId", q3.s(str));
                    }
                } catch (SQLiteException e) {
                    gVarK.g().f.c("Error storing consent setting. appId, error", q3.s(str), e);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02e8 A[Catch: all -> 0x0ef1, TRY_ENTER, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ef A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02fb A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x06b6 A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0777  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x078d A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0934  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0945 A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0955 A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:376:0x096f A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x09f5 A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:500:0x0ce2 A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0cf5  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x0cf8 A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:504:0x0d1f A[Catch: all -> 0x0ef1, TRY_LEAVE, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:618:0x1083  */
    /* JADX WARN: Removed duplicated region for block: B:626:0x109a A[Catch: all -> 0x1080, TRY_ENTER, TryCatch #12 {all -> 0x1080, blocks: (B:549:0x0eaf, B:548:0x0eac, B:540:0x0e4b, B:542:0x0e75, B:543:0x0e80, B:544:0x0e92, B:546:0x0e9c, B:537:0x0e32, B:552:0x0ebc, B:554:0x0ec9, B:555:0x0ecf, B:556:0x0ed7, B:558:0x0edd, B:563:0x0ef8, B:565:0x0f09, B:585:0x0f7e, B:587:0x0f84, B:589:0x0f94, B:592:0x0f9b, B:597:0x0fce, B:593:0x0fa3, B:595:0x0faf, B:596:0x0fb5, B:598:0x0fdf, B:599:0x0ff6, B:602:0x0ffe, B:603:0x1003, B:604:0x1013, B:606:0x102d, B:607:0x1046, B:608:0x104e, B:613:0x1070, B:612:0x105f, B:566:0x0f23, B:568:0x0f29, B:570:0x0f33, B:572:0x0f3a, B:578:0x0f4a, B:580:0x0f51, B:582:0x0f70, B:584:0x0f77, B:583:0x0f74, B:579:0x0f4e, B:571:0x0f37, B:619:0x1084, B:626:0x109a, B:627:0x109d), top: B:649:0x002c, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013c A[Catch: SQLiteException -> 0x009e, all -> 0x02aa, TRY_LEAVE, TryCatch #2 {all -> 0x02aa, blocks: (B:23:0x0084, B:28:0x0090, B:30:0x0095, B:65:0x0136, B:67:0x013c, B:71:0x015c, B:72:0x0160, B:73:0x0172, B:75:0x0178, B:79:0x0186, B:87:0x019a, B:90:0x01a6, B:93:0x01c4, B:95:0x01ea, B:102:0x0207, B:103:0x0210, B:105:0x021b, B:107:0x0224, B:114:0x0252, B:113:0x0241, B:92:0x01b9, B:126:0x026d, B:55:0x00fe, B:60:0x0109), top: B:631:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:715:? A[Catch: all -> 0x1080, SYNTHETIC, TRY_LEAVE, TryCatch #12 {all -> 0x1080, blocks: (B:549:0x0eaf, B:548:0x0eac, B:540:0x0e4b, B:542:0x0e75, B:543:0x0e80, B:544:0x0e92, B:546:0x0e9c, B:537:0x0e32, B:552:0x0ebc, B:554:0x0ec9, B:555:0x0ecf, B:556:0x0ed7, B:558:0x0edd, B:563:0x0ef8, B:565:0x0f09, B:585:0x0f7e, B:587:0x0f84, B:589:0x0f94, B:592:0x0f9b, B:597:0x0fce, B:593:0x0fa3, B:595:0x0faf, B:596:0x0fb5, B:598:0x0fdf, B:599:0x0ff6, B:602:0x0ffe, B:603:0x1003, B:604:0x1013, B:606:0x102d, B:607:0x1046, B:608:0x104e, B:613:0x1070, B:612:0x105f, B:566:0x0f23, B:568:0x0f29, B:570:0x0f33, B:572:0x0f3a, B:578:0x0f4a, B:580:0x0f51, B:582:0x0f70, B:584:0x0f77, B:583:0x0f74, B:579:0x0f4e, B:571:0x0f37, B:619:0x1084, B:626:0x109a, B:627:0x109d), top: B:649:0x002c, inners: #5 }] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean t(long j) throws Throwable {
        a aVar;
        g gVarK;
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Throwable th;
        Cursor cursor;
        SQLiteException sQLiteException;
        Cursor cursor2;
        String string;
        Cursor cursor3;
        Cursor cursor4;
        List<b.i.a.f.h.l.a1> list;
        boolean z2;
        int i;
        boolean z3;
        a aVar2;
        k9 k9Var;
        boolean z4;
        int iZ;
        a aVar3;
        k9 k9Var2;
        SecureRandom secureRandom;
        int i2;
        Long l;
        HashMap map;
        long jU;
        HashMap map2;
        int i3;
        a4 a4VarT;
        boolean z5;
        boolean z6;
        String str6;
        int i4;
        a1.a aVar4;
        e1.a aVar5;
        a1.a aVar6;
        int i5;
        String str7;
        String str8;
        String str9;
        String str10;
        int i6;
        e1.a aVar7;
        int i7;
        int i8;
        boolean z7;
        a1.a aVar8;
        char c;
        SQLiteDatabase sQLiteDatabaseT;
        SQLiteException sQLiteException2;
        Cursor cursor5;
        Cursor cursor6;
        String[] strArr;
        String string2;
        Cursor cursorQuery;
        Cursor cursor7;
        String str11;
        String[] strArr2;
        a1.a aVar9;
        String[] strArr3;
        k9 k9Var3 = this;
        String str12 = "_sn";
        String str13 = "_ai";
        K().b0();
        try {
            aVar = new a(k9Var3, null);
            gVarK = K();
            j2 = k9Var3.f1545y;
            AnimatableValueParser.A(aVar);
            gVarK.b();
            gVarK.n();
            try {
                try {
                    try {
                        sQLiteDatabaseT = gVarK.t();
                        try {
                            try {
                            } catch (Throwable th2) {
                                th = th2;
                                cursor3 = "";
                                cursor = cursor3;
                                if (cursor == null) {
                                    throw th;
                                }
                                cursor.close();
                                throw th;
                            }
                        } catch (SQLiteException e) {
                            e = e;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cursor = null;
                }
            } catch (SQLiteException e2) {
                e = e2;
                str = "_si";
                str2 = "_sc";
                str3 = "_sn";
                str4 = "_npa";
                str5 = "";
            }
        } catch (Throwable th5) {
            th = th5;
        }
        if (TextUtils.isEmpty(null)) {
            if (j2 != -1) {
                try {
                    strArr3 = new String[]{String.valueOf(j2), String.valueOf(j)};
                } catch (SQLiteException e3) {
                    sQLiteException2 = e3;
                    str5 = "";
                    cursor5 = null;
                    str = "_si";
                    str2 = "_sc";
                    str4 = "_npa";
                    sQLiteException = sQLiteException2;
                    string = null;
                    cursor6 = cursor5;
                    str3 = "_sn";
                    cursor4 = cursor6;
                    try {
                        gVarK.g().z().c("Data loss. Error selecting raw event. appId", q3.s(string), sQLiteException);
                        if (cursor4 != null) {
                        }
                        list = aVar.c;
                    } catch (Throwable th6) {
                        th = th6;
                        cursor3 = cursor4;
                        cursor = cursor3;
                        if (cursor == null) {
                        }
                    }
                    Throwable th7 = th;
                    K().e0();
                    throw th7;
                }
            } else {
                try {
                    strArr3 = new String[]{String.valueOf(j)};
                } catch (SQLiteException e4) {
                    e = e4;
                    str5 = "";
                    sQLiteException2 = e;
                    cursor5 = null;
                    str = "_si";
                    str2 = "_sc";
                    str4 = "_npa";
                    sQLiteException = sQLiteException2;
                    string = null;
                    cursor6 = cursor5;
                    str3 = "_sn";
                    cursor4 = cursor6;
                    gVarK.g().z().c("Data loss. Error selecting raw event. appId", q3.s(string), sQLiteException);
                    if (cursor4 != null) {
                    }
                    list = aVar.c;
                    Throwable th72 = th;
                    K().e0();
                    throw th72;
                }
            }
            String str14 = j2 != -1 ? "rowid <= ? and " : "";
            str5 = "";
            StringBuilder sb = new StringBuilder(str14.length() + Opcodes.LCMP);
            sb.append("select app_id, metadata_fingerprint from raw_events where ");
            sb.append(str14);
            sb.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
            cursorQuery = sQLiteDatabaseT.rawQuery(sb.toString(), strArr3);
            try {
            } catch (SQLiteException e5) {
                sQLiteException2 = e5;
                cursor5 = cursorQuery;
                str = "_si";
                str2 = "_sc";
                str4 = "_npa";
                sQLiteException = sQLiteException2;
                string = null;
                cursor6 = cursor5;
                str3 = "_sn";
                cursor4 = cursor6;
                gVarK.g().z().c("Data loss. Error selecting raw event. appId", q3.s(string), sQLiteException);
                if (cursor4 != null) {
                }
                list = aVar.c;
                Throwable th722 = th;
                K().e0();
                throw th722;
            }
            if (cursorQuery.moveToFirst()) {
                string = cursorQuery.getString(0);
                try {
                    string2 = cursorQuery.getString(1);
                    cursorQuery.close();
                    cursorQuery = cursorQuery;
                    try {
                        cursor7 = cursorQuery;
                    } catch (SQLiteException e6) {
                        e = e6;
                        str = "_si";
                        str2 = "_sc";
                        str3 = "_sn";
                        str4 = "_npa";
                    } catch (Throwable th8) {
                        th = th8;
                        cursor7 = cursorQuery;
                    }
                    try {
                        cursorQuery = sQLiteDatabaseT.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{string, string2}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
                    } catch (SQLiteException e7) {
                        e = e7;
                        str = "_si";
                        str2 = "_sc";
                        str3 = "_sn";
                        str4 = "_npa";
                        cursorQuery = cursor7;
                    } catch (Throwable th9) {
                        th = th9;
                        cursor = cursor7;
                        th = th;
                        if (cursor == null) {
                        }
                    }
                } catch (SQLiteException e8) {
                    e = e8;
                    str = "_si";
                    str2 = "_sc";
                    str3 = "_sn";
                    str4 = "_npa";
                    sQLiteException = e;
                    cursor4 = cursorQuery;
                    gVarK.g().z().c("Data loss. Error selecting raw event. appId", q3.s(string), sQLiteException);
                    if (cursor4 != null) {
                    }
                    list = aVar.c;
                    Throwable th7222 = th;
                    K().e0();
                    throw th7222;
                }
                if (cursorQuery.moveToFirst()) {
                    gVarK.g().z().b("Raw event metadata record is missing. appId", q3.s(string));
                    cursorQuery.close();
                    str = "_si";
                    str2 = "_sc";
                    str3 = "_sn";
                    str4 = "_npa";
                    list = aVar.c;
                    if (list != null) {
                        if (!(list != null || list.isEmpty())) {
                        }
                    }
                    Throwable th72222 = th;
                    K().e0();
                    throw th72222;
                }
                str4 = "_npa";
                str3 = null;
                try {
                    try {
                        try {
                            b.i.a.f.h.l.e1 e1Var = (b.i.a.f.h.l.e1) ((b.i.a.f.h.l.u4) ((e1.a) q9.x(b.i.a.f.h.l.e1.u0(), cursorQuery.getBlob(0))).p());
                            if (cursorQuery.moveToNext()) {
                                try {
                                    str = "_si";
                                    str2 = "_sc";
                                    try {
                                        gVarK.g().A().b("Get multiple raw event metadata records, expected one. appId", q3.s(string));
                                    } catch (SQLiteException e9) {
                                        e = e9;
                                        sQLiteException = e;
                                        cursor6 = cursorQuery;
                                        str3 = "_sn";
                                        cursor4 = cursor6;
                                        gVarK.g().z().c("Data loss. Error selecting raw event. appId", q3.s(string), sQLiteException);
                                        if (cursor4 != null) {
                                        }
                                        list = aVar.c;
                                        Throwable th722222 = th;
                                        K().e0();
                                        throw th722222;
                                    }
                                } catch (SQLiteException e10) {
                                    e = e10;
                                    str = "_si";
                                    str2 = "_sc";
                                    sQLiteException = e;
                                    cursor6 = cursorQuery;
                                    str3 = "_sn";
                                    cursor4 = cursor6;
                                    gVarK.g().z().c("Data loss. Error selecting raw event. appId", q3.s(string), sQLiteException);
                                    if (cursor4 != null) {
                                    }
                                    list = aVar.c;
                                    Throwable th7222222 = th;
                                    K().e0();
                                    throw th7222222;
                                }
                            } else {
                                str = "_si";
                                str2 = "_sc";
                            }
                            try {
                                cursorQuery.close();
                                aVar.a(e1Var);
                                if (j2 != -1) {
                                    str11 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                    strArr2 = new String[]{string, string2, String.valueOf(j2)};
                                } else {
                                    str11 = "app_id = ? and metadata_fingerprint = ?";
                                    strArr2 = new String[]{string, string2};
                                }
                                cursorQuery = sQLiteDatabaseT.query("raw_events", new String[]{"rowid", ModelAuditLogEntry.CHANGE_KEY_NAME, "timestamp", "data"}, str11, strArr2, null, null, "rowid", null);
                                if (cursorQuery.moveToFirst()) {
                                    while (true) {
                                        long j3 = cursorQuery.getLong(0);
                                        try {
                                            aVar9 = (a1.a) q9.x(b.i.a.f.h.l.a1.M(), cursorQuery.getBlob(3));
                                            aVar9.t(cursorQuery.getString(1));
                                            str3 = str12;
                                            aVar9.r(cursorQuery.getLong(2));
                                        } catch (IOException e11) {
                                            str3 = str12;
                                            gVarK.g().z().c("Data loss. Failed to merge raw event. appId", q3.s(string), e11);
                                        }
                                        if (!aVar.b(j3, (b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVar9.p()))) {
                                            cursorQuery.close();
                                            break;
                                        }
                                        if (!cursorQuery.moveToNext()) {
                                            cursorQuery.close();
                                            break;
                                        }
                                        str12 = str3;
                                    }
                                } else {
                                    gVarK.g().A().b("Raw event data disappeared while in transaction. appId", q3.s(string));
                                    cursorQuery.close();
                                    str3 = "_sn";
                                }
                            } catch (SQLiteException e12) {
                                e = e12;
                                str3 = str12;
                                sQLiteException = e;
                                cursor4 = cursorQuery;
                                gVarK.g().z().c("Data loss. Error selecting raw event. appId", q3.s(string), sQLiteException);
                                if (cursor4 != null) {
                                }
                                list = aVar.c;
                                Throwable th72222222 = th;
                                K().e0();
                                throw th72222222;
                            }
                        } catch (IOException e13) {
                            str = "_si";
                            str2 = "_sc";
                            str3 = "_sn";
                            gVarK.g().z().c("Data loss. Failed to merge raw event metadata. appId", q3.s(string), e13);
                            cursorQuery.close();
                        }
                    } catch (SQLiteException e14) {
                        e = e14;
                        sQLiteException = e;
                        cursor4 = cursorQuery;
                        gVarK.g().z().c("Data loss. Error selecting raw event. appId", q3.s(string), sQLiteException);
                        if (cursor4 != null) {
                            cursor4.close();
                        }
                        list = aVar.c;
                        Throwable th722222222 = th;
                        K().e0();
                        throw th722222222;
                    }
                } catch (SQLiteException e15) {
                    e = e15;
                    str = "_si";
                    str2 = "_sc";
                }
                list = aVar.c;
                Throwable th7222222222 = th;
                K().e0();
                throw th7222222222;
            }
            cursorQuery.close();
            str = "_si";
            str2 = "_sc";
            str3 = "_sn";
            str4 = "_npa";
            list = aVar.c;
            if (!(list != null || list.isEmpty())) {
                K().s();
                K().e0();
                return false;
            }
            e1.a aVarT = aVar.a.t();
            aVarT.F();
            boolean zV = k9Var3.k.a().v(aVar.a.G1(), p.U);
            int i9 = -1;
            boolean z8 = false;
            int i10 = 0;
            int i11 = 0;
            a1.a aVar10 = null;
            a1.a aVar11 = null;
            int i12 = -1;
            long jLongValue = 0;
            while (true) {
                z2 = z8;
                i = i10;
                String str15 = str3;
                if (i11 >= aVar.c.size()) {
                    break;
                }
                a1.a aVarT2 = aVar.c.get(i11).t();
                int i13 = i11;
                if (H().x(aVar.a.G1(), aVarT2.y())) {
                    z6 = zV;
                    k9Var3.k.g().A().c("Dropping blacklisted raw event. appId", q3.s(aVar.a.G1()), k9Var3.k.u().u(aVarT2.y()));
                    if (!(H().C(aVar.a.G1()) || H().D(aVar.a.G1())) && !"_err".equals(aVarT2.y())) {
                        k9Var3.k.t().S(k9Var3.A, aVar.a.G1(), 11, "_ev", aVarT2.y(), 0);
                    }
                    i5 = i9;
                    str6 = str13;
                    aVar4 = aVar11;
                    z8 = z2;
                    i10 = i;
                    str7 = str15;
                    str9 = str;
                    str10 = str2;
                    i7 = i13;
                    aVar7 = aVarT;
                } else {
                    z6 = zV;
                    if (b.i.a.f.h.l.x7.b() && k9Var3.k.a().v(aVar.a.G1(), p.M0) && aVarT2.y().equals(v5.a(str13))) {
                        aVarT2.t(str13);
                        k9Var3.k.g().D().a("Renaming ad_impression to _ai");
                        if (k9Var3.k.g().x(5)) {
                            for (int i14 = 0; i14 < aVarT2.w(); i14++) {
                                if ("ad_platform".equals(aVarT2.u(i14).B()) && !TextUtils.isEmpty(aVarT2.u(i14).G()) && AdjustConfig.AD_REVENUE_ADMOB.equalsIgnoreCase(aVarT2.u(i14).G())) {
                                    k9Var3.k.g().B().a("AdMob ad impression logged from app. Potentially duplicative.");
                                }
                            }
                        }
                    }
                    boolean zY = H().y(aVar.a.G1(), aVarT2.y());
                    if (zY) {
                        str6 = str13;
                        i4 = i12;
                    } else {
                        N();
                        String strY = aVarT2.y();
                        AnimatableValueParser.w(strY);
                        str6 = str13;
                        int iHashCode = strY.hashCode();
                        i4 = i12;
                        if (iHashCode == 94660) {
                            if (strY.equals("_in")) {
                                c = 0;
                            }
                        } else if (iHashCode != 95025) {
                            c = (iHashCode == 95027 && strY.equals("_ui")) ? (char) 1 : (char) 65535;
                            if (c == 0 || c == 1 || c == 2) {
                                aVar5 = aVarT;
                                aVar6 = aVar10;
                                aVar4 = aVar11;
                                z8 = z2;
                                if (zY) {
                                    if (k9Var3.k.a().v(aVar.a.G1(), p.T)) {
                                    }
                                    i12 = i6;
                                    if (!z6) {
                                    }
                                    i7 = i13;
                                    aVar.c.set(i7, (b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT2.p()));
                                    i10 = i + 1;
                                    aVar7.t(aVarT2);
                                    aVar10 = aVar6;
                                } else {
                                    ArrayList arrayList = new ArrayList(aVarT2.v());
                                    int i15 = -1;
                                    int i16 = -1;
                                    for (int i17 = 0; i17 < arrayList.size(); i17++) {
                                        if ("value".equals(((b.i.a.f.h.l.c1) arrayList.get(i17)).B())) {
                                            i15 = i17;
                                        } else if ("currency".equals(((b.i.a.f.h.l.c1) arrayList.get(i17)).B())) {
                                            i16 = i17;
                                        }
                                    }
                                    if (i15 != -1) {
                                        if (((b.i.a.f.h.l.c1) arrayList.get(i15)).I() || ((b.i.a.f.h.l.c1) arrayList.get(i15)).M()) {
                                            if (i16 != -1) {
                                                String strG = ((b.i.a.f.h.l.c1) arrayList.get(i16)).G();
                                                if (strG.length() == 3) {
                                                    int iCharCount = 0;
                                                    while (iCharCount < strG.length()) {
                                                        int iCodePointAt = strG.codePointAt(iCharCount);
                                                        if (Character.isLetter(iCodePointAt)) {
                                                            iCharCount += Character.charCount(iCodePointAt);
                                                        }
                                                    }
                                                    z7 = false;
                                                }
                                                z7 = true;
                                                break;
                                            }
                                            z7 = true;
                                            if (z7) {
                                                k9Var3.k.g().B().a("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                                aVarT2.x(i15);
                                                e(aVarT2, "_c");
                                                d(aVarT2, 19, "currency");
                                            }
                                        } else {
                                            k9Var3.k.g().B().a("Value must be specified with a numeric type.");
                                            aVarT2.x(i15);
                                            e(aVarT2, "_c");
                                            d(aVarT2, 18, "value");
                                        }
                                    }
                                    if (k9Var3.k.a().v(aVar.a.G1(), p.T)) {
                                        i5 = i9;
                                        str7 = str15;
                                        str8 = "_et";
                                        str9 = str;
                                        str10 = str2;
                                        i6 = i4;
                                        aVar7 = aVar5;
                                    } else {
                                        if ("_e".equals(aVarT2.y())) {
                                            N();
                                            if (q9.w((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT2.p()), "_fr") == null) {
                                                if (aVar4 != null && Math.abs(aVar4.z() - aVarT2.z()) <= 1000) {
                                                    a1.a aVar12 = (a1.a) ((u4.b) aVar4.clone());
                                                    if (k9Var3.u(aVarT2, aVar12)) {
                                                        aVar7 = aVar5;
                                                        aVar7.r(i9, aVar12);
                                                        str8 = "_et";
                                                        i8 = i4;
                                                        i5 = i9;
                                                        i12 = i8;
                                                        str7 = str15;
                                                        str9 = str;
                                                        str10 = str2;
                                                        aVar6 = null;
                                                        aVar4 = null;
                                                    }
                                                }
                                                aVar7 = aVar5;
                                                aVar6 = aVarT2;
                                                i12 = i;
                                            } else {
                                                aVar7 = aVar5;
                                                i12 = i4;
                                            }
                                            i5 = i9;
                                            str7 = str15;
                                            str8 = "_et";
                                            str9 = str;
                                            str10 = str2;
                                        } else {
                                            aVar7 = aVar5;
                                            if ("_vs".equals(aVarT2.y())) {
                                                N();
                                                str8 = "_et";
                                                if (q9.w((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT2.p()), str8) == null) {
                                                    if (aVar6 != null && Math.abs(aVar6.z() - aVarT2.z()) <= 1000) {
                                                        a1.a aVar13 = (a1.a) ((u4.b) aVar6.clone());
                                                        if (k9Var3.u(aVar13, aVarT2)) {
                                                            i8 = i4;
                                                            aVar7.r(i8, aVar13);
                                                            i5 = i9;
                                                            i12 = i8;
                                                            str7 = str15;
                                                            str9 = str;
                                                            str10 = str2;
                                                            aVar6 = null;
                                                            aVar4 = null;
                                                        }
                                                    }
                                                    aVar4 = aVarT2;
                                                    i12 = i4;
                                                    i5 = i;
                                                    str7 = str15;
                                                    str9 = str;
                                                    str10 = str2;
                                                } else {
                                                    i6 = i4;
                                                }
                                            } else {
                                                str8 = "_et";
                                                i6 = i4;
                                                if (k9Var3.k.a().v(aVar.a.G1(), p.m0) && "_ab".equals(aVarT2.y())) {
                                                    N();
                                                    if (q9.w((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT2.p()), str8) == null && aVar6 != null && Math.abs(aVar6.z() - aVarT2.z()) <= 4000) {
                                                        a1.a aVar14 = (a1.a) ((u4.b) aVar6.clone());
                                                        k9Var3.A(aVar14, aVarT2);
                                                        AnimatableValueParser.l("_e".equals(aVar14.y()));
                                                        N();
                                                        str7 = str15;
                                                        b.i.a.f.h.l.c1 c1VarW = q9.w((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVar14.p()), str7);
                                                        N();
                                                        str10 = str2;
                                                        b.i.a.f.h.l.c1 c1VarW2 = q9.w((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVar14.p()), str10);
                                                        N();
                                                        i5 = i9;
                                                        str9 = str;
                                                        b.i.a.f.h.l.c1 c1VarW3 = q9.w((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVar14.p()), str9);
                                                        String strG2 = c1VarW != null ? c1VarW.G() : str5;
                                                        if (!TextUtils.isEmpty(strG2)) {
                                                            N();
                                                            q9.E(aVarT2, str7, strG2);
                                                        }
                                                        String strG3 = c1VarW2 != null ? c1VarW2.G() : str5;
                                                        if (!TextUtils.isEmpty(strG3)) {
                                                            N();
                                                            q9.E(aVarT2, str10, strG3);
                                                        }
                                                        if (c1VarW3 != null) {
                                                            N();
                                                            q9.E(aVarT2, str9, Long.valueOf(c1VarW3.J()));
                                                        }
                                                        aVar7.r(i6, aVar14);
                                                        i12 = i6;
                                                        aVar6 = null;
                                                    }
                                                }
                                            }
                                            i5 = i9;
                                            str7 = str15;
                                            str9 = str;
                                            str10 = str2;
                                        }
                                        if (!z6 && "_e".equals(aVarT2.y())) {
                                            if (aVarT2.w() != 0) {
                                                k9Var3.k.g().A().b("Engagement event does not contain any parameters. appId", q3.s(aVar.a.G1()));
                                            } else {
                                                N();
                                                Long l2 = (Long) q9.R((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT2.p()), str8);
                                                if (l2 == null) {
                                                    k9Var3.k.g().A().b("Engagement event does not include duration. appId", q3.s(aVar.a.G1()));
                                                } else {
                                                    jLongValue += l2.longValue();
                                                }
                                            }
                                        }
                                        i7 = i13;
                                        aVar.c.set(i7, (b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT2.p()));
                                        i10 = i + 1;
                                        aVar7.t(aVarT2);
                                        aVar10 = aVar6;
                                    }
                                    i12 = i6;
                                    if (!z6) {
                                        if (aVarT2.w() != 0) {
                                        }
                                    }
                                    i7 = i13;
                                    aVar.c.set(i7, (b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT2.p()));
                                    i10 = i + 1;
                                    aVar7.t(aVarT2);
                                    aVar10 = aVar6;
                                }
                            }
                        } else {
                            if (strY.equals("_ug")) {
                                c = 2;
                            }
                            if (c == 0) {
                                if (c == 0 || c == 1 || c == 2) {
                                }
                            }
                        }
                    }
                    aVar6 = aVar10;
                    int i18 = 0;
                    boolean z9 = false;
                    boolean z10 = false;
                    while (true) {
                        aVar5 = aVarT;
                        if (i18 >= aVarT2.w()) {
                            break;
                        }
                        if ("_c".equals(aVarT2.u(i18).B())) {
                            c1.a aVarT3 = aVarT2.u(i18).t();
                            aVarT3.r(1L);
                            aVarT2.q(i18, (b.i.a.f.h.l.c1) ((b.i.a.f.h.l.u4) aVarT3.p()));
                            aVar8 = aVar11;
                            z9 = true;
                        } else if ("_r".equals(aVarT2.u(i18).B())) {
                            c1.a aVarT4 = aVarT2.u(i18).t();
                            aVar8 = aVar11;
                            aVarT4.r(1L);
                            aVarT2.q(i18, (b.i.a.f.h.l.c1) ((b.i.a.f.h.l.u4) aVarT4.p()));
                            z10 = true;
                        } else {
                            aVar8 = aVar11;
                        }
                        i18++;
                        aVarT = aVar5;
                        aVar11 = aVar8;
                    }
                    aVar4 = aVar11;
                    if (!z9 && zY) {
                        k9Var3.k.g().D().b("Marking event as conversion", k9Var3.k.u().u(aVarT2.y()));
                        c1.a aVarQ = b.i.a.f.h.l.c1.Q();
                        aVarQ.s("_c");
                        aVarQ.r(1L);
                        aVarT2.s(aVarQ);
                    }
                    if (!z10) {
                        k9Var3.k.g().D().b("Marking event as real-time", k9Var3.k.u().u(aVarT2.y()));
                        c1.a aVarQ2 = b.i.a.f.h.l.c1.Q();
                        aVarQ2.s("_r");
                        aVarQ2.r(1L);
                        aVarT2.s(aVarQ2);
                    }
                    if (K().y(V(), aVar.a.G1(), false, true).e > k9Var3.k.a().s(aVar.a.G1())) {
                        e(aVarT2, "_r");
                    } else {
                        z2 = true;
                    }
                    if (t9.X(aVarT2.y()) && zY && K().y(V(), aVar.a.G1(), true, false).c > k9Var3.k.a().q(aVar.a.G1(), p.n)) {
                        k9Var3.k.g().A().b("Too many conversions. Not logging as conversion. appId", q3.s(aVar.a.G1()));
                        boolean z11 = false;
                        int i19 = -1;
                        c1.a aVarT5 = null;
                        for (int i20 = 0; i20 < aVarT2.w(); i20++) {
                            b.i.a.f.h.l.c1 c1VarU = aVarT2.u(i20);
                            if ("_c".equals(c1VarU.B())) {
                                aVarT5 = c1VarU.t();
                                i19 = i20;
                            } else if ("_err".equals(c1VarU.B())) {
                                z11 = true;
                            }
                        }
                        if (z11 && aVarT5 != null) {
                            aVarT2.x(i19);
                        } else if (aVarT5 != null) {
                            c1.a aVar15 = (c1.a) ((u4.b) aVarT5.clone());
                            aVar15.s("_err");
                            aVar15.r(10L);
                            aVarT2.q(i19, (b.i.a.f.h.l.c1) ((b.i.a.f.h.l.u4) aVar15.p()));
                        } else {
                            k9Var3.k.g().z().b("Did not find conversion parameter. appId", q3.s(aVar.a.G1()));
                        }
                    }
                    z8 = z2;
                    if (zY) {
                    }
                }
                i11 = i7 + 1;
                str2 = str10;
                str = str9;
                aVarT = aVar7;
                str3 = str7;
                i9 = i5;
                zV = z6;
                str13 = str6;
                aVar11 = aVar4;
            }
            e1.a aVar16 = aVarT;
            if (zV) {
                int i21 = i;
                int i22 = 0;
                while (i22 < i21) {
                    b.i.a.f.h.l.a1 a1VarB = aVar16.B(i22);
                    if ("_e".equals(a1VarB.F())) {
                        N();
                        if (q9.w(a1VarB, "_fr") != null) {
                            aVar16.G(i22);
                            i21--;
                            i22--;
                        } else {
                            N();
                            b.i.a.f.h.l.c1 c1VarW4 = q9.w(a1VarB, "_et");
                            if (c1VarW4 != null) {
                                Long lValueOf = c1VarW4.I() ? Long.valueOf(c1VarW4.J()) : null;
                                if (lValueOf != null && lValueOf.longValue() > 0) {
                                    jLongValue += lValueOf.longValue();
                                }
                            }
                        }
                    }
                    i22++;
                }
            }
            long j4 = jLongValue;
            k9Var3.h(aVar16, j4, false);
            Iterator<b.i.a.f.h.l.a1> it = aVar16.z().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z3 = false;
                    break;
                }
                if ("_s".equals(it.next().F())) {
                    z3 = true;
                    break;
                }
            }
            if (z3) {
                K().V(aVar16.k0(), "_se");
            }
            if (q9.s(aVar16, "_sid") >= 0) {
                k9Var3.h(aVar16, j4, true);
            } else {
                int iS = q9.s(aVar16, "_se");
                if (iS >= 0) {
                    aVar16.R(iS);
                    k9Var3.k.g().z().b("Session engagement user property is in the bundle without session ID. appId", q3.s(aVar.a.G1()));
                }
            }
            q9 q9VarN = N();
            q9VarN.g().D().a("Checking account type status for ad personalization signals");
            if (q9VarN.r().A(aVar16.k0()) && (a4VarT = q9VarN.q().T(aVar16.k0())) != null && a4VarT.h() && q9VarN.c().w()) {
                q9VarN.g().C().a("Turning off ad personalization due to account type");
                i1.a aVarL = b.i.a.f.h.l.i1.L();
                String str16 = str4;
                aVarL.r(str16);
                aVarL.q(q9VarN.c().v());
                aVarL.s(1L);
                b.i.a.f.h.l.i1 i1Var = (b.i.a.f.h.l.i1) ((b.i.a.f.h.l.u4) aVarL.p());
                int i23 = 0;
                while (true) {
                    if (i23 >= aVar16.Q()) {
                        z5 = false;
                        break;
                    }
                    if (str16.equals(aVar16.O(i23).D())) {
                        aVar16.s(i23, i1Var);
                        z5 = true;
                        break;
                    }
                    i23++;
                }
                if (!z5) {
                    aVar16.v(i1Var);
                }
            }
            aVar16.D(RecyclerView.FOREVER_NS);
            aVar16.H(Long.MIN_VALUE);
            for (int i24 = 0; i24 < aVar16.A(); i24++) {
                b.i.a.f.h.l.a1 a1VarB2 = aVar16.B(i24);
                if (a1VarB2.H() < aVar16.U()) {
                    aVar16.D(a1VarB2.H());
                }
                if (a1VarB2.H() > aVar16.Y()) {
                    aVar16.H(a1VarB2.H());
                }
            }
            if (hb.b() && k9Var3.k.a().v(aVar16.k0(), p.G0)) {
                aVar16.v0();
            }
            aVar16.t0();
            aVar16.I(M().t(aVar16.k0(), aVar16.z(), aVar16.P(), Long.valueOf(aVar16.U()), Long.valueOf(aVar16.Y())));
            if (k9Var3.k.a().A(aVar.a.G1())) {
                HashMap map3 = new HashMap();
                ArrayList arrayList2 = new ArrayList();
                SecureRandom secureRandomV0 = k9Var3.k.t().v0();
                int i25 = 0;
                while (i25 < aVar16.A()) {
                    a1.a aVarT6 = aVar16.B(i25).t();
                    if (aVarT6.y().equals("_ep")) {
                        N();
                        String str17 = (String) q9.R((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT6.p()), "_en");
                        l lVarZ = (l) map3.get(str17);
                        if (lVarZ == null) {
                            lVarZ = K().z(aVar.a.G1(), str17);
                            map3.put(str17, lVarZ);
                        }
                        if (lVarZ.i == null) {
                            if (lVarZ.j.longValue() > 1) {
                                N();
                                q9.E(aVarT6, "_sr", lVarZ.j);
                            }
                            Boolean bool = lVarZ.k;
                            if (bool != null && bool.booleanValue()) {
                                N();
                                q9.E(aVarT6, "_efs", 1L);
                            }
                            arrayList2.add((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT6.p()));
                        }
                        aVar16.r(i25, aVarT6);
                    } else {
                        long jB = H().B(aVar.a.G1());
                        k9Var3.k.t();
                        long jU2 = t9.u(aVarT6.z(), jB);
                        b.i.a.f.h.l.a1 a1Var = (b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT6.p());
                        Long l3 = 1L;
                        if (TextUtils.isEmpty("_dbg") || l3 == null) {
                            iZ = z4 ? H().z(aVar.a.G1(), aVarT6.y()) : 1;
                            if (iZ > 0) {
                                k9Var3.k.g().A().c("Sample rate must be positive. event, rate", aVarT6.y(), Integer.valueOf(iZ));
                                arrayList2.add((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT6.p()));
                                aVar16.r(i25, aVarT6);
                            } else {
                                l lVarZ2 = (l) map3.get(aVarT6.y());
                                if (lVarZ2 == null) {
                                    try {
                                        lVarZ2 = K().z(aVar.a.G1(), aVarT6.y());
                                        if (lVarZ2 == null) {
                                            k9Var3.k.g().A().c("Event being bundled has no eventAggregate. appId, eventName", aVar.a.G1(), aVarT6.y());
                                            lVarZ2 = new l(aVar.a.G1(), aVarT6.y(), 1L, 1L, 1L, aVarT6.z(), 0L, null, null, null, null);
                                        }
                                    } catch (Throwable th10) {
                                        th = th10;
                                    }
                                }
                                N();
                                Long l4 = (Long) q9.R((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT6.p()), "_eid");
                                Boolean boolValueOf = Boolean.valueOf(l4 != null);
                                if (iZ == 1) {
                                    arrayList2.add((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT6.p()));
                                    if (boolValueOf.booleanValue() && (lVarZ2.i != null || lVarZ2.j != null || lVarZ2.k != null)) {
                                        map3.put(aVarT6.y(), lVarZ2.c(null, null, null));
                                    }
                                    aVar16.r(i25, aVarT6);
                                } else {
                                    if (secureRandomV0.nextInt(iZ) == 0) {
                                        N();
                                        aVar3 = aVar;
                                        long j5 = iZ;
                                        q9.E(aVarT6, "_sr", Long.valueOf(j5));
                                        arrayList2.add((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT6.p()));
                                        if (boolValueOf.booleanValue()) {
                                            lVarZ2 = lVarZ2.c(null, Long.valueOf(j5), null);
                                        }
                                        map3.put(aVarT6.y(), lVarZ2.b(aVarT6.z(), jU2));
                                        k9Var2 = this;
                                        map2 = map3;
                                        secureRandom = secureRandomV0;
                                        i3 = i25;
                                    } else {
                                        aVar3 = aVar;
                                        Long l5 = lVarZ2.h;
                                        if (l5 != null) {
                                            long jLongValue2 = l5.longValue();
                                            k9Var2 = this;
                                            l = l4;
                                            map = map3;
                                            jU = jLongValue2;
                                            secureRandom = secureRandomV0;
                                            i2 = i25;
                                        } else {
                                            k9Var2 = this;
                                            secureRandom = secureRandomV0;
                                            k9Var2.k.t();
                                            i2 = i25;
                                            l = l4;
                                            map = map3;
                                            jU = t9.u(aVarT6.A(), jB);
                                        }
                                        if (jU != jU2) {
                                            N();
                                            q9.E(aVarT6, "_efs", 1L);
                                            N();
                                            long j6 = iZ;
                                            q9.E(aVarT6, "_sr", Long.valueOf(j6));
                                            arrayList2.add((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT6.p()));
                                            if (boolValueOf.booleanValue()) {
                                                lVarZ2 = lVarZ2.c(null, Long.valueOf(j6), Boolean.TRUE);
                                            }
                                            map2 = map;
                                            map2.put(aVarT6.y(), lVarZ2.b(aVarT6.z(), jU2));
                                        } else {
                                            map2 = map;
                                            if (boolValueOf.booleanValue()) {
                                                map2.put(aVarT6.y(), lVarZ2.c(l, null, null));
                                            }
                                        }
                                        i3 = i2;
                                    }
                                    aVar16.r(i3, aVarT6);
                                }
                            }
                        } else {
                            Iterator<b.i.a.f.h.l.c1> it2 = a1Var.v().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                b.i.a.f.h.l.c1 next = it2.next();
                                Iterator<b.i.a.f.h.l.c1> it3 = it2;
                                if ("_dbg".equals(next.B())) {
                                    z4 = l3.equals(Long.valueOf(next.J())) || ((l3 instanceof String) && l3.equals(next.G())) || ((l3 instanceof Double) && l3.equals(Double.valueOf(next.N())));
                                } else {
                                    it2 = it3;
                                }
                            }
                            if (z4) {
                            }
                            if (iZ > 0) {
                            }
                        }
                        i25 = i3 + 1;
                        k9Var3 = k9Var2;
                        map3 = map2;
                        aVar = aVar3;
                        secureRandomV0 = secureRandom;
                    }
                    map2 = map3;
                    secureRandom = secureRandomV0;
                    i3 = i25;
                    aVar3 = aVar;
                    k9Var2 = this;
                    i25 = i3 + 1;
                    k9Var3 = k9Var2;
                    map3 = map2;
                    aVar = aVar3;
                    secureRandomV0 = secureRandom;
                }
                HashMap map4 = map3;
                aVar2 = aVar;
                k9Var = k9Var3;
                if (arrayList2.size() < aVar16.A()) {
                    aVar16.F();
                    aVar16.w(arrayList2);
                }
                Iterator it4 = map4.entrySet().iterator();
                while (it4.hasNext()) {
                    K().H((l) ((Map.Entry) it4.next()).getValue());
                }
            } else {
                aVar2 = aVar;
                k9Var = k9Var3;
            }
            a aVar17 = aVar2;
            String strG1 = aVar17.a.G1();
            a4 a4VarT2 = K().T(strG1);
            if (a4VarT2 == null) {
                k9Var.k.g().z().b("Bundling raw events w/o app info. appId", q3.s(aVar17.a.G1()));
            } else if (aVar16.A() > 0) {
                long jL = a4VarT2.L();
                if (jL != 0) {
                    aVar16.S(jL);
                } else {
                    aVar16.f0();
                }
                long jK = a4VarT2.K();
                if (jK != 0) {
                    jL = jK;
                }
                if (jL != 0) {
                    aVar16.K(jL);
                } else {
                    aVar16.b0();
                }
                a4VarT2.X();
                aVar16.Z((int) a4VarT2.U());
                a4VarT2.a(aVar16.U());
                a4VarT2.l(aVar16.Y());
                String strF = a4VarT2.f();
                if (strF != null) {
                    aVar16.j0(strF);
                } else {
                    aVar16.p0();
                }
                K().I(a4VarT2);
            }
            if (aVar16.A() > 0) {
                b.i.a.f.h.l.u0 u0VarS = H().s(aVar17.a.G1());
                if (u0VarS != null && u0VarS.x()) {
                    aVar16.g0(u0VarS.y());
                } else if (TextUtils.isEmpty(aVar17.a.S())) {
                    aVar16.g0(-1L);
                } else {
                    k9Var.k.g().A().b("Did not find measurement config or missing version info. appId", q3.s(aVar17.a.G1()));
                }
                K().K((b.i.a.f.h.l.e1) ((b.i.a.f.h.l.u4) aVar16.p()), z2);
            }
            g gVarK2 = K();
            List<Long> list2 = aVar17.f1547b;
            AnimatableValueParser.A(list2);
            gVarK2.b();
            gVarK2.n();
            StringBuilder sb2 = new StringBuilder("rowid in (");
            for (int i26 = 0; i26 < list2.size(); i26++) {
                if (i26 != 0) {
                    sb2.append(",");
                }
                sb2.append(list2.get(i26).longValue());
            }
            sb2.append(")");
            int iDelete = gVarK2.t().delete("raw_events", sb2.toString(), null);
            if (iDelete != list2.size()) {
                gVarK2.g().z().c("Deleted fewer rows from raw events table than expected", Integer.valueOf(iDelete), Integer.valueOf(list2.size()));
            }
            g gVarK3 = K();
            try {
                gVarK3.t().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{strG1, strG1});
            } catch (SQLiteException e16) {
                gVarK3.g().z().c("Failed to remove unused event metadata. appId", q3.s(strG1), e16);
            }
            K().s();
            K().e0();
            return true;
        }
        str5 = "";
        if (j2 != -1) {
            strArr = new String[]{null, String.valueOf(j2)};
        } else {
            try {
                strArr = new String[]{null};
            } catch (SQLiteException e17) {
                e = e17;
                str = "_si";
                str2 = "_sc";
                str3 = "_sn";
                str4 = "_npa";
                sQLiteException = e;
                cursor2 = null;
                string = null;
                cursor4 = cursor2;
                gVarK.g().z().c("Data loss. Error selecting raw event. appId", q3.s(string), sQLiteException);
                if (cursor4 != null) {
                }
                list = aVar.c;
                Throwable th72222222222 = th;
                K().e0();
                throw th72222222222;
            }
        }
        String str18 = j2 != -1 ? " and rowid <= ?" : str5;
        StringBuilder sb3 = new StringBuilder(str18.length() + 84);
        sb3.append("select metadata_fingerprint from raw_events where app_id = ?");
        sb3.append(str18);
        sb3.append(" order by rowid limit 1;");
        Cursor cursorRawQuery = sQLiteDatabaseT.rawQuery(sb3.toString(), strArr);
        try {
        } catch (SQLiteException e18) {
            str = "_si";
            str2 = "_sc";
            str3 = "_sn";
            str4 = "_npa";
            sQLiteException = e18;
            cursor2 = cursorRawQuery;
            string = null;
            cursor4 = cursor2;
            gVarK.g().z().c("Data loss. Error selecting raw event. appId", q3.s(string), sQLiteException);
            if (cursor4 != null) {
            }
            list = aVar.c;
            Throwable th722222222222 = th;
            K().e0();
            throw th722222222222;
        }
        if (!cursorRawQuery.moveToFirst()) {
            cursorRawQuery.close();
            str = "_si";
            str2 = "_sc";
            str3 = "_sn";
            str4 = "_npa";
            list = aVar.c;
            Throwable th7222222222222 = th;
            K().e0();
            throw th7222222222222;
        }
        string2 = cursorRawQuery.getString(0);
        cursorRawQuery.close();
        string = null;
        cursorQuery = cursorRawQuery;
        cursor7 = cursorQuery;
        cursorQuery = sQLiteDatabaseT.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{string, string2}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
        if (cursorQuery.moveToFirst()) {
        }
    }

    public final boolean u(a1.a aVar, a1.a aVar2) {
        AnimatableValueParser.l("_e".equals(aVar.y()));
        N();
        b.i.a.f.h.l.c1 c1VarW = q9.w((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVar.p()), "_sc");
        String strG = c1VarW == null ? null : c1VarW.G();
        N();
        b.i.a.f.h.l.c1 c1VarW2 = q9.w((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVar2.p()), "_pc");
        String strG2 = c1VarW2 != null ? c1VarW2.G() : null;
        if (strG2 == null || !strG2.equals(strG)) {
            return false;
        }
        A(aVar, aVar2);
        return true;
    }

    public final boolean v() {
        U();
        P();
        return ((K().S("select count(1) > 0 from raw_events", null) > 0L ? 1 : (K().S("select count(1) > 0 from raw_events", null) == 0L ? 0 : -1)) != 0) || !TextUtils.isEmpty(K().u());
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void w() {
        boolean z2;
        long jMax;
        long jMax2;
        int iIntValue;
        U();
        P();
        if (this.n > 0) {
            Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
            long jAbs = 3600000 - Math.abs(SystemClock.elapsedRealtime() - this.n);
            if (jAbs > 0) {
                this.k.g().n.b("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                S().a();
                T().s();
                return;
            }
            this.n = 0L;
        }
        if (!this.k.m() || !v()) {
            this.k.g().n.a("Nothing to upload or uploading impossible");
            S().a();
            T().s();
            return;
        }
        Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jMax3 = Math.max(0L, p.A.a(null).longValue());
        if (K().S("select count(1) > 0 from raw_events where realtime = 1", null) != 0) {
            z2 = true;
        } else if (!(K().S("select count(1) > 0 from queue where has_realtime = 1", null) != 0)) {
            z2 = false;
        }
        if (z2) {
            String strH = this.k.h.h("debug.firebase.analytics.app", "");
            jMax = (TextUtils.isEmpty(strH) || ".none.".equals(strH)) ? Math.max(0L, p.u.a(null).longValue()) : Math.max(0L, p.v.a(null).longValue());
        } else {
            jMax = Math.max(0L, p.t.a(null).longValue());
        }
        long jA = this.k.o().f.a();
        long jA2 = this.k.o().g.a();
        long j = jMax;
        long jMax4 = Math.max(K().w("select max(bundle_end_timestamp) from queue", null, 0L), K().w("select max(timestamp) from raw_events", null, 0L));
        if (jMax4 == 0) {
            jMax2 = 0;
        } else {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = jCurrentTimeMillis - Math.abs(jA - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jA2 - jCurrentTimeMillis);
            long jMax5 = Math.max(jAbs3, jAbs4);
            jMax2 = jMax3 + jAbs2;
            if (z2 && jMax5 > 0) {
                jMax2 = Math.min(jAbs2, jMax5) + j;
            }
            if (!N().N(jMax5, j)) {
                jMax2 = jMax5 + j;
            }
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                for (int i = 0; i < Math.min(20, Math.max(0, p.C.a(null).intValue())); i++) {
                    jMax2 += Math.max(0L, p.B.a(null).longValue()) * (1 << i);
                    if (jMax2 > jAbs4) {
                        break;
                    }
                }
                jMax2 = 0;
            }
        }
        if (jMax2 == 0) {
            this.k.g().n.a("Next upload time is 0");
            S().a();
            T().s();
            return;
        }
        if (!J().u()) {
            this.k.g().n.a("No network");
            b4 b4VarS = S();
            b4VarS.a.P();
            b4VarS.a.f().b();
            if (!b4VarS.f1520b) {
                b4VarS.a.k.f1570b.registerReceiver(b4VarS, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                b4VarS.c = b4VarS.a.J().u();
                b4VarS.a.g().n.b("Registering connectivity change receiver. Network connected", Boolean.valueOf(b4VarS.c));
                b4VarS.f1520b = true;
            }
            T().s();
            return;
        }
        long jA3 = this.k.o().h.a();
        long jMax6 = Math.max(0L, p.r.a(null).longValue());
        if (!N().N(jA3, jMax6)) {
            jMax2 = Math.max(jMax2, jA3 + jMax6);
        }
        S().a();
        Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
        long jCurrentTimeMillis2 = jMax2 - System.currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            jCurrentTimeMillis2 = Math.max(0L, p.w.a(null).longValue());
            h4 h4Var = this.k.o().f;
            Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
            h4Var.b(System.currentTimeMillis());
        }
        this.k.g().n.b("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis2));
        h9 h9VarT = T();
        h9VarT.n();
        Context context = h9VarT.a.f1570b;
        if (!n4.a(context)) {
            h9VarT.g().m.a("Receiver not registered/enabled");
        }
        if (!t9.U(context)) {
            h9VarT.g().m.a("Service not registered/enabled");
        }
        h9VarT.s();
        h9VarT.g().n.b("Scheduling upload, millis", Long.valueOf(jCurrentTimeMillis2));
        Objects.requireNonNull((b.i.a.f.e.o.c) h9VarT.a.o);
        long jElapsedRealtime = SystemClock.elapsedRealtime() + jCurrentTimeMillis2;
        if (jCurrentTimeMillis2 < Math.max(0L, p.f1563x.a(null).longValue())) {
            if (!(h9VarT.e.d != 0)) {
                h9VarT.e.b(jCurrentTimeMillis2);
            }
        }
        if (Build.VERSION.SDK_INT < 24) {
            h9VarT.d.setInexactRepeating(2, jElapsedRealtime, Math.max(p.f1562s.a(null).longValue(), jCurrentTimeMillis2), h9VarT.u());
            return;
        }
        Context context2 = h9VarT.a.f1570b;
        ComponentName componentName = new ComponentName(context2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iT = h9VarT.t();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        JobInfo jobInfoBuild = new JobInfo.Builder(iT, componentName).setMinimumLatency(jCurrentTimeMillis2).setOverrideDeadline(jCurrentTimeMillis2 << 1).setExtras(persistableBundle).build();
        Method method = b.i.a.f.h.l.a4.a;
        JobScheduler jobScheduler = (JobScheduler) context2.getSystemService("jobscheduler");
        if (b.i.a.f.h.l.a4.a == null || context2.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) {
            jobScheduler.schedule(jobInfoBuild);
            return;
        }
        Method method2 = b.i.a.f.h.l.a4.f1435b;
        if (method2 != null) {
            try {
                iIntValue = ((Integer) method2.invoke(null, new Object[0])).intValue();
            } catch (IllegalAccessException | InvocationTargetException e) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "myUserId invocation illegal", e);
                }
            }
        } else {
            iIntValue = 0;
        }
        Method method3 = b.i.a.f.h.l.a4.a;
        if (method3 != null) {
            try {
                ((Integer) method3.invoke(jobScheduler, jobInfoBuild, "com.google.android.gms", Integer.valueOf(iIntValue), "UploadAlarm")).intValue();
                return;
            } catch (IllegalAccessException | InvocationTargetException e2) {
                Log.e("UploadAlarm", "error calling scheduleAsPackage", e2);
            }
        }
        jobScheduler.schedule(jobInfoBuild);
    }

    @WorkerThread
    public final void x() throws IllegalStateException {
        U();
        if (this.r || this.f1543s || this.t) {
            this.k.g().n.d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.r), Boolean.valueOf(this.f1543s), Boolean.valueOf(this.t));
            return;
        }
        this.k.g().n.a("Stopping uploading service(s)");
        List<Runnable> list = this.o;
        if (list == null) {
            return;
        }
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.o.clear();
    }

    @WorkerThread
    public final zzn y(String str) {
        a4 a4VarT = K().T(str);
        if (a4VarT == null || TextUtils.isEmpty(a4VarT.M())) {
            this.k.g().m.b("No app data available; dropping", str);
            return null;
        }
        Boolean boolZ = z(a4VarT);
        if (boolZ != null && !boolZ.booleanValue()) {
            this.k.g().f.b("App version does not match; dropping. appId", q3.s(str));
            return null;
        }
        return new zzn(str, a4VarT.v(), a4VarT.M(), a4VarT.N(), a4VarT.O(), a4VarT.P(), a4VarT.Q(), (String) null, a4VarT.T(), false, a4VarT.H(), a4VarT.g(), 0L, 0, a4VarT.h(), a4VarT.i(), false, a4VarT.y(), a4VarT.j(), a4VarT.S(), a4VarT.k(), (b.i.a.f.h.l.da.b() && this.k.h.u(str, p.f1561j0)) ? a4VarT.B() : null, (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) ? a(str).d() : "");
    }

    @WorkerThread
    public final Boolean z(a4 a4Var) {
        try {
            if (a4Var.N() != -2147483648L) {
                if (a4Var.N() == b.i.a.f.e.p.b.a(this.k.f1570b).b(a4Var.o(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = b.i.a.f.e.p.b.a(this.k.f1570b).b(a4Var.o(), 0).versionName;
                if (a4Var.M() != null && a4Var.M().equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
