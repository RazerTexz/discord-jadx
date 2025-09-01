package com.google.android.gms.internal.measurement;

import b.i.a.f.h.l.c6;
import b.i.a.f.h.l.e4;
import b.i.a.f.h.l.g4;
import b.i.a.f.h.l.h5;
import b.i.a.f.h.l.j7;
import b.i.a.f.h.l.k7;
import b.i.a.f.h.l.l3;
import b.i.a.f.h.l.o7;
import b.i.a.f.h.l.q3;
import b.i.a.f.h.l.q6;
import b.i.a.f.h.l.t3;
import b.i.a.f.h.l.u3;
import b.i.a.f.h.l.w4;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.objectweb.asm.Opcodes;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public abstract class zzhi extends u3 {
    public static final Logger a = Logger.getLogger(zzhi.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f3007b = j7.g;
    public g4 c;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static class a extends zzhi {
        public final byte[] d;
        public final int e;
        public int f;

        public a(byte[] bArr, int i) {
            super(null);
            if ((i | 0 | (bArr.length - i)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
            }
            this.d = bArr;
            this.f = 0;
            this.e = i;
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void A(long j) throws IOException {
            try {
                byte[] bArr = this.d;
                int i = this.f;
                int i2 = i + 1;
                this.f = i2;
                bArr[i] = (byte) j;
                int i3 = i2 + 1;
                this.f = i3;
                bArr[i2] = (byte) (j >> 8);
                int i4 = i3 + 1;
                this.f = i4;
                bArr[i3] = (byte) (j >> 16);
                int i5 = i4 + 1;
                this.f = i5;
                bArr[i4] = (byte) (j >> 24);
                int i6 = i5 + 1;
                this.f = i6;
                bArr[i5] = (byte) (j >> 32);
                int i7 = i6 + 1;
                this.f = i7;
                bArr[i6] = (byte) (j >> 40);
                int i8 = i7 + 1;
                this.f = i8;
                bArr[i7] = (byte) (j >> 48);
                this.f = i8 + 1;
                bArr[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void C(int i) throws IOException {
            try {
                byte[] bArr = this.d;
                int i2 = this.f;
                int i3 = i2 + 1;
                this.f = i3;
                bArr[i2] = (byte) i;
                int i4 = i3 + 1;
                this.f = i4;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i4 + 1;
                this.f = i5;
                bArr[i4] = (byte) (i >> 16);
                this.f = i5 + 1;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void G(int i, int i2) throws IOException {
            r((i << 3) | 5);
            C(i2);
        }

        public final void W(t3 t3Var) throws IOException {
            r(t3Var.d());
            t3Var.j(this);
        }

        public final void X(c6 c6Var) throws IOException {
            r(c6Var.g());
            c6Var.i(this);
        }

        public final void Y(String str) throws IOException {
            int i = this.f;
            try {
                int iL = zzhi.L(str.length() * 3);
                int iL2 = zzhi.L(str.length());
                if (iL2 != iL) {
                    r(k7.a(str));
                    this.f = k7.a.b(str, this.d, this.f, a());
                    return;
                }
                int i2 = i + iL2;
                this.f = i2;
                int iB = k7.a.b(str, this.d, i2, a());
                this.f = i;
                r((iB - i) - iL2);
                this.f = iB;
            } catch (o7 e) {
                this.f = i;
                zzhi.a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e);
                byte[] bytes = str.getBytes(w4.a);
                try {
                    r(bytes.length);
                    Z(bytes, 0, bytes.length);
                } catch (zza e2) {
                    throw e2;
                } catch (IndexOutOfBoundsException e3) {
                    throw new zza(e3);
                }
            } catch (IndexOutOfBoundsException e4) {
                throw new zza(e4);
            }
        }

        public final void Z(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.d, this.f, i2);
                this.f += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final int a() {
            return this.e - this.f;
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void d(byte b2) throws IOException {
            try {
                byte[] bArr = this.d;
                int i = this.f;
                this.f = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void e(int i) throws IOException {
            if (i >= 0) {
                r(i);
            } else {
                m(i);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void f(int i, int i2) throws IOException {
            r((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void g(int i, long j) throws IOException {
            r((i << 3) | 0);
            m(j);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void h(int i, t3 t3Var) throws IOException {
            r((i << 3) | 2);
            W(t3Var);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void i(int i, c6 c6Var) throws IOException {
            f(1, 3);
            y(2, i);
            f(3, 2);
            X(c6Var);
            f(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void j(int i, c6 c6Var, q6 q6Var) throws IOException {
            r((i << 3) | 2);
            l3 l3Var = (l3) c6Var;
            int iE = l3Var.e();
            if (iE == -1) {
                iE = q6Var.e(l3Var);
                l3Var.l(iE);
            }
            r(iE);
            q6Var.g(c6Var, this.c);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void k(int i, String str) throws IOException {
            r((i << 3) | 2);
            Y(str);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void l(int i, boolean z2) throws IOException {
            r((i << 3) | 0);
            d(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void m(long j) throws IOException {
            if (zzhi.f3007b && a() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.d;
                    int i = this.f;
                    this.f = i + 1;
                    j7.g(bArr, i, (byte) ((((int) j) & Opcodes.LAND) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.d;
                int i2 = this.f;
                this.f = i2 + 1;
                j7.g(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.d;
                    int i3 = this.f;
                    this.f = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & Opcodes.LAND) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
                }
            }
            byte[] bArr4 = this.d;
            int i4 = this.f;
            this.f = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void r(int i) throws IOException {
            if (!zzhi.f3007b || q3.a() || a() < 5) {
                while ((i & (-128)) != 0) {
                    try {
                        byte[] bArr = this.d;
                        int i2 = this.f;
                        this.f = i2 + 1;
                        bArr[i2] = (byte) ((i & Opcodes.LAND) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
                    }
                }
                byte[] bArr2 = this.d;
                int i3 = this.f;
                this.f = i3 + 1;
                bArr2[i3] = (byte) i;
                return;
            }
            if ((i & (-128)) == 0) {
                byte[] bArr3 = this.d;
                int i4 = this.f;
                this.f = i4 + 1;
                j7.g(bArr3, i4, (byte) i);
                return;
            }
            byte[] bArr4 = this.d;
            int i5 = this.f;
            this.f = i5 + 1;
            j7.g(bArr4, i5, (byte) (i | 128));
            int i6 = i >>> 7;
            if ((i6 & (-128)) == 0) {
                byte[] bArr5 = this.d;
                int i7 = this.f;
                this.f = i7 + 1;
                j7.g(bArr5, i7, (byte) i6);
                return;
            }
            byte[] bArr6 = this.d;
            int i8 = this.f;
            this.f = i8 + 1;
            j7.g(bArr6, i8, (byte) (i6 | 128));
            int i9 = i6 >>> 7;
            if ((i9 & (-128)) == 0) {
                byte[] bArr7 = this.d;
                int i10 = this.f;
                this.f = i10 + 1;
                j7.g(bArr7, i10, (byte) i9);
                return;
            }
            byte[] bArr8 = this.d;
            int i11 = this.f;
            this.f = i11 + 1;
            j7.g(bArr8, i11, (byte) (i9 | 128));
            int i12 = i9 >>> 7;
            if ((i12 & (-128)) == 0) {
                byte[] bArr9 = this.d;
                int i13 = this.f;
                this.f = i13 + 1;
                j7.g(bArr9, i13, (byte) i12);
                return;
            }
            byte[] bArr10 = this.d;
            int i14 = this.f;
            this.f = i14 + 1;
            j7.g(bArr10, i14, (byte) (i12 | 128));
            byte[] bArr11 = this.d;
            int i15 = this.f;
            this.f = i15 + 1;
            j7.g(bArr11, i15, (byte) (i12 >>> 7));
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void s(int i, int i2) throws IOException {
            r((i << 3) | 0);
            if (i2 >= 0) {
                r(i2);
            } else {
                m(i2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void t(int i, t3 t3Var) throws IOException {
            f(1, 3);
            y(2, i);
            h(3, t3Var);
            f(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void y(int i, int i2) throws IOException {
            r((i << 3) | 0);
            r(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        public final void z(int i, long j) throws IOException {
            r((i << 3) | 1);
            A(j);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static class zza extends IOException {
        public zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public zza(String str, Throwable th) {
            String strValueOf = String.valueOf(str);
            super(strValueOf.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(strValueOf) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
        }
    }

    public zzhi() {
    }

    public static int B(int i, long j) {
        return F(j) + L(i << 3);
    }

    public static int D(int i) {
        return L(i << 3);
    }

    public static int E(int i, long j) {
        return F(j) + L(i << 3);
    }

    public static int F(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int H(int i) {
        if (i >= 0) {
            return L(i);
        }
        return 10;
    }

    public static int I(int i, int i2) {
        return H(i2) + L(i << 3);
    }

    public static int J(int i, long j) {
        return F(R(j)) + L(i << 3);
    }

    public static int K(long j) {
        return F(R(j));
    }

    public static int L(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int M(int i, int i2) {
        return L(i2) + L(i << 3);
    }

    public static int N(int i) {
        return L(i << 3) + 8;
    }

    public static int O(int i) {
        return L(V(i));
    }

    public static int P(int i, int i2) {
        return L(V(i2)) + L(i << 3);
    }

    public static int Q(int i) {
        return L(i << 3) + 8;
    }

    public static long R(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int S(int i) {
        return L(i << 3) + 4;
    }

    public static int T(int i) {
        return L(i << 3) + 4;
    }

    public static int U(int i, int i2) {
        return H(i2) + L(i << 3);
    }

    public static int V(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int b(h5 h5Var) {
        int iA = h5Var.a();
        return L(iA) + iA;
    }

    public static int c(c6 c6Var, q6 q6Var) {
        l3 l3Var = (l3) c6Var;
        int iE = l3Var.e();
        if (iE == -1) {
            iE = q6Var.e(l3Var);
            l3Var.l(iE);
        }
        return L(iE) + iE;
    }

    public static int n(int i) {
        return L(i << 3) + 4;
    }

    public static int o(int i, String str) {
        return q(str) + L(i << 3);
    }

    public static int p(t3 t3Var) {
        int iD = t3Var.d();
        return L(iD) + iD;
    }

    public static int q(String str) {
        int length;
        try {
            length = k7.a(str);
        } catch (o7 unused) {
            length = str.getBytes(w4.a).length;
        }
        return L(length) + length;
    }

    public static int u(int i) {
        return L(i << 3) + 8;
    }

    public static int v(int i) {
        return L(i << 3) + 1;
    }

    public static int w(int i, t3 t3Var) {
        int iL = L(i << 3);
        int iD = t3Var.d();
        return L(iD) + iD + iL;
    }

    @Deprecated
    public static int x(int i, c6 c6Var, q6 q6Var) {
        int iL = L(i << 3) << 1;
        l3 l3Var = (l3) c6Var;
        int iE = l3Var.e();
        if (iE == -1) {
            iE = q6Var.e(l3Var);
            l3Var.l(iE);
        }
        return iL + iE;
    }

    public abstract void A(long j) throws IOException;

    public abstract void C(int i) throws IOException;

    public abstract void G(int i, int i2) throws IOException;

    public abstract int a();

    public abstract void d(byte b2) throws IOException;

    public abstract void e(int i) throws IOException;

    public abstract void f(int i, int i2) throws IOException;

    public abstract void g(int i, long j) throws IOException;

    public abstract void h(int i, t3 t3Var) throws IOException;

    public abstract void i(int i, c6 c6Var) throws IOException;

    public abstract void j(int i, c6 c6Var, q6 q6Var) throws IOException;

    public abstract void k(int i, String str) throws IOException;

    public abstract void l(int i, boolean z2) throws IOException;

    public abstract void m(long j) throws IOException;

    public abstract void r(int i) throws IOException;

    public abstract void s(int i, int i2) throws IOException;

    public abstract void t(int i, t3 t3Var) throws IOException;

    public abstract void y(int i, int i2) throws IOException;

    public abstract void z(int i, long j) throws IOException;

    public zzhi(e4 e4Var) {
    }
}
