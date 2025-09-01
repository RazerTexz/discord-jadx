package b.i.a.c;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import b.i.a.c.Bundleable;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.ColorInfo;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Format.java */
/* renamed from: b.i.a.c.j1, reason: use source file name */
/* loaded from: classes3.dex */
public final class Format2 implements Bundleable {
    public static final Format2 j = new b().a();
    public static final Bundleable.a<Format2> k = h0.a;
    public final long A;
    public final int B;
    public final int C;
    public final float D;
    public final int E;
    public final float F;

    @Nullable
    public final byte[] G;
    public final int H;

    @Nullable
    public final ColorInfo I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;
    public final int P;
    public int Q;

    @Nullable
    public final String l;

    @Nullable
    public final String m;

    @Nullable
    public final String n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public final int f1017s;

    @Nullable
    public final String t;

    @Nullable
    public final Metadata u;

    @Nullable
    public final String v;

    @Nullable
    public final String w;

    /* renamed from: x, reason: collision with root package name */
    public final int f1018x;

    /* renamed from: y, reason: collision with root package name */
    public final List<byte[]> f1019y;

    /* renamed from: z, reason: collision with root package name */
    @Nullable
    public final DrmInitData f1020z;

    public Format2(b bVar, a aVar) {
        this.l = bVar.a;
        this.m = bVar.f1021b;
        this.n = Util2.C(bVar.c);
        this.o = bVar.d;
        this.p = bVar.e;
        int i = bVar.f;
        this.q = i;
        int i2 = bVar.g;
        this.r = i2;
        this.f1017s = i2 != -1 ? i2 : i;
        this.t = bVar.h;
        this.u = bVar.i;
        this.v = bVar.j;
        this.w = bVar.k;
        this.f1018x = bVar.l;
        List<byte[]> list = bVar.m;
        this.f1019y = list == null ? Collections.emptyList() : list;
        DrmInitData drmInitData = bVar.n;
        this.f1020z = drmInitData;
        this.A = bVar.o;
        this.B = bVar.p;
        this.C = bVar.q;
        this.D = bVar.r;
        int i3 = bVar.f1022s;
        this.E = i3 == -1 ? 0 : i3;
        float f = bVar.t;
        this.F = f == -1.0f ? 1.0f : f;
        this.G = bVar.u;
        this.H = bVar.v;
        this.I = bVar.w;
        this.J = bVar.f1023x;
        this.K = bVar.f1024y;
        this.L = bVar.f1025z;
        int i4 = bVar.A;
        this.M = i4 == -1 ? 0 : i4;
        int i5 = bVar.B;
        this.N = i5 != -1 ? i5 : 0;
        this.O = bVar.C;
        int i6 = bVar.D;
        if (i6 != 0 || drmInitData == null) {
            this.P = i6;
        } else {
            this.P = 1;
        }
    }

    @Nullable
    public static <T> T b(@Nullable T t, @Nullable T t2) {
        return t != null ? t : t2;
    }

    public static String d(int i) {
        return Integer.toString(i, 36);
    }

    public b a() {
        return new b(this, null);
    }

    public boolean c(Format2 format2) {
        if (this.f1019y.size() != format2.f1019y.size()) {
            return false;
        }
        for (int i = 0; i < this.f1019y.size(); i++) {
            if (!Arrays.equals(this.f1019y.get(i), format2.f1019y.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || Format2.class != obj.getClass()) {
            return false;
        }
        Format2 format2 = (Format2) obj;
        int i2 = this.Q;
        return (i2 == 0 || (i = format2.Q) == 0 || i2 == i) && this.o == format2.o && this.p == format2.p && this.q == format2.q && this.r == format2.r && this.f1018x == format2.f1018x && this.A == format2.A && this.B == format2.B && this.C == format2.C && this.E == format2.E && this.H == format2.H && this.J == format2.J && this.K == format2.K && this.L == format2.L && this.M == format2.M && this.N == format2.N && this.O == format2.O && this.P == format2.P && Float.compare(this.D, format2.D) == 0 && Float.compare(this.F, format2.F) == 0 && Util2.a(this.l, format2.l) && Util2.a(this.m, format2.m) && Util2.a(this.t, format2.t) && Util2.a(this.v, format2.v) && Util2.a(this.w, format2.w) && Util2.a(this.n, format2.n) && Arrays.equals(this.G, format2.G) && Util2.a(this.u, format2.u) && Util2.a(this.I, format2.I) && Util2.a(this.f1020z, format2.f1020z) && c(format2);
    }

    public int hashCode() {
        if (this.Q == 0) {
            String str = this.l;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.m;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.n;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31;
            String str4 = this.t;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.u;
            int iHashCode5 = (iHashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str5 = this.v;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.w;
            this.Q = ((((((((((((((((Float.floatToIntBits(this.F) + ((((Float.floatToIntBits(this.D) + ((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.f1018x) * 31) + ((int) this.A)) * 31) + this.B) * 31) + this.C) * 31)) * 31) + this.E) * 31)) * 31) + this.H) * 31) + this.J) * 31) + this.K) * 31) + this.L) * 31) + this.M) * 31) + this.N) * 31) + this.O) * 31) + this.P;
        }
        return this.Q;
    }

    public String toString() {
        String str = this.l;
        String str2 = this.m;
        String str3 = this.v;
        String str4 = this.w;
        String str5 = this.t;
        int i = this.f1017s;
        String str6 = this.n;
        int i2 = this.B;
        int i3 = this.C;
        float f = this.D;
        int i4 = this.J;
        int i5 = this.K;
        StringBuilder sbS = outline.S(outline.b(str6, outline.b(str5, outline.b(str4, outline.b(str3, outline.b(str2, outline.b(str, 104)))))), "Format(", str, ", ", str2);
        outline.s0(sbS, ", ", str3, ", ", str4);
        sbS.append(", ");
        sbS.append(str5);
        sbS.append(", ");
        sbS.append(i);
        sbS.append(", ");
        sbS.append(str6);
        sbS.append(", [");
        sbS.append(i2);
        sbS.append(", ");
        sbS.append(i3);
        sbS.append(", ");
        sbS.append(f);
        sbS.append("], [");
        sbS.append(i4);
        sbS.append(", ");
        sbS.append(i5);
        sbS.append("])");
        return sbS.toString();
    }

    /* compiled from: Format.java */
    /* renamed from: b.i.a.c.j1$b */
    public static final class b {
        public int A;
        public int B;
        public int C;
        public int D;

        @Nullable
        public String a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public String f1021b;

        @Nullable
        public String c;
        public int d;
        public int e;
        public int f;
        public int g;

        @Nullable
        public String h;

        @Nullable
        public Metadata i;

        @Nullable
        public String j;

        @Nullable
        public String k;
        public int l;

        @Nullable
        public List<byte[]> m;

        @Nullable
        public DrmInitData n;
        public long o;
        public int p;
        public int q;
        public float r;

        /* renamed from: s, reason: collision with root package name */
        public int f1022s;
        public float t;

        @Nullable
        public byte[] u;
        public int v;

        @Nullable
        public ColorInfo w;

        /* renamed from: x, reason: collision with root package name */
        public int f1023x;

        /* renamed from: y, reason: collision with root package name */
        public int f1024y;

        /* renamed from: z, reason: collision with root package name */
        public int f1025z;

        public b() {
            this.f = -1;
            this.g = -1;
            this.l = -1;
            this.o = RecyclerView.FOREVER_NS;
            this.p = -1;
            this.q = -1;
            this.r = -1.0f;
            this.t = 1.0f;
            this.v = -1;
            this.f1023x = -1;
            this.f1024y = -1;
            this.f1025z = -1;
            this.C = -1;
            this.D = 0;
        }

        public Format2 a() {
            return new Format2(this, null);
        }

        public b b(int i) {
            this.a = Integer.toString(i);
            return this;
        }

        public b(Format2 format2, a aVar) {
            this.a = format2.l;
            this.f1021b = format2.m;
            this.c = format2.n;
            this.d = format2.o;
            this.e = format2.p;
            this.f = format2.q;
            this.g = format2.r;
            this.h = format2.t;
            this.i = format2.u;
            this.j = format2.v;
            this.k = format2.w;
            this.l = format2.f1018x;
            this.m = format2.f1019y;
            this.n = format2.f1020z;
            this.o = format2.A;
            this.p = format2.B;
            this.q = format2.C;
            this.r = format2.D;
            this.f1022s = format2.E;
            this.t = format2.F;
            this.u = format2.G;
            this.v = format2.H;
            this.w = format2.I;
            this.f1023x = format2.J;
            this.f1024y = format2.K;
            this.f1025z = format2.L;
            this.A = format2.M;
            this.B = format2.N;
            this.C = format2.O;
            this.D = format2.P;
        }
    }
}
