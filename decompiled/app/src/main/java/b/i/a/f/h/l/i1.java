package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class i1 extends u4<i1, a> implements d6 {
    private static final i1 zzj;
    private static volatile j6<i1> zzk;
    private int zzc;
    private long zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends u4.b<i1, a> implements d6 {
        public a() {
            super(i1.M());
        }

        public final a q(long j) {
            if (this.l) {
                n();
                this.l = false;
            }
            i1.w((i1) this.k, j);
            return this;
        }

        public final a r(String str) {
            if (this.l) {
                n();
                this.l = false;
            }
            i1.x((i1) this.k, str);
            return this;
        }

        public final a s(long j) {
            if (this.l) {
                n();
                this.l = false;
            }
            i1.B((i1) this.k, j);
            return this;
        }

        public a(k1 k1Var) {
            super(i1.M());
        }
    }

    static {
        i1 i1Var = new i1();
        zzj = i1Var;
        u4.r(i1.class, i1Var);
    }

    public static void A(i1 i1Var) {
        i1Var.zzc &= -9;
        i1Var.zzg = 0L;
    }

    public static void B(i1 i1Var, long j) {
        i1Var.zzc |= 8;
        i1Var.zzg = j;
    }

    public static void C(i1 i1Var, String str) {
        Objects.requireNonNull(i1Var);
        str.getClass();
        i1Var.zzc |= 4;
        i1Var.zzf = str;
    }

    public static void E(i1 i1Var) {
        i1Var.zzc &= -33;
        i1Var.zzi = 0.0d;
    }

    public static a L() {
        return zzj.s();
    }

    public static /* synthetic */ i1 M() {
        return zzj;
    }

    public static void u(i1 i1Var) {
        i1Var.zzc &= -5;
        i1Var.zzf = zzj.zzf;
    }

    public static void v(i1 i1Var, double d) {
        i1Var.zzc |= 32;
        i1Var.zzi = d;
    }

    public static void w(i1 i1Var, long j) {
        i1Var.zzc |= 1;
        i1Var.zzd = j;
    }

    public static void x(i1 i1Var, String str) {
        Objects.requireNonNull(i1Var);
        str.getClass();
        i1Var.zzc |= 2;
        i1Var.zze = str;
    }

    public final String D() {
        return this.zze;
    }

    public final boolean F() {
        return (this.zzc & 4) != 0;
    }

    public final String G() {
        return this.zzf;
    }

    public final boolean H() {
        return (this.zzc & 8) != 0;
    }

    public final long I() {
        return this.zzg;
    }

    public final boolean J() {
        return (this.zzc & 32) != 0;
    }

    public final double K() {
        return this.zzi;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (k1.a[i - 1]) {
            case 1:
                return new i1();
            case 2:
                return new a(null);
            case 3:
                return new o6(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                j6<i1> aVar = zzk;
                if (aVar == null) {
                    synchronized (i1.class) {
                        aVar = zzk;
                        if (aVar == null) {
                            aVar = new u4.a<>(zzj);
                            zzk = aVar;
                        }
                    }
                }
                return aVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final boolean y() {
        return (this.zzc & 1) != 0;
    }

    public final long z() {
        return this.zzd;
    }
}
