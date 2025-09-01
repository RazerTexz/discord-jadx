package b.i.a.c;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import b.i.a.c.Bundleable;
import b.i.a.c.f3.Util2;
import java.util.Arrays;

/* compiled from: MediaMetadata.java */
/* renamed from: b.i.a.c.p1, reason: use source file name */
/* loaded from: classes3.dex */
public final class MediaMetadata implements Bundleable {
    public static final MediaMetadata j = new b().a();
    public static final Bundleable.a<MediaMetadata> k = l0.a;

    @Nullable
    public final Integer A;

    @Nullable
    public final Boolean B;

    @Nullable
    @Deprecated
    public final Integer C;

    @Nullable
    public final Integer D;

    @Nullable
    public final Integer E;

    @Nullable
    public final Integer F;

    @Nullable
    public final Integer G;

    @Nullable
    public final Integer H;

    @Nullable
    public final Integer I;

    @Nullable
    public final CharSequence J;

    @Nullable
    public final CharSequence K;

    @Nullable
    public final CharSequence L;

    @Nullable
    public final Integer M;

    @Nullable
    public final Integer N;

    @Nullable
    public final CharSequence O;

    @Nullable
    public final CharSequence P;

    @Nullable
    public final Bundle Q;

    @Nullable
    public final CharSequence l;

    @Nullable
    public final CharSequence m;

    @Nullable
    public final CharSequence n;

    @Nullable
    public final CharSequence o;

    @Nullable
    public final CharSequence p;

    @Nullable
    public final CharSequence q;

    @Nullable
    public final CharSequence r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public final Uri f1046s;

    @Nullable
    public final Rating t;

    @Nullable
    public final Rating u;

    @Nullable
    public final byte[] v;

    @Nullable
    public final Integer w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public final Uri f1047x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public final Integer f1048y;

    /* renamed from: z, reason: collision with root package name */
    @Nullable
    public final Integer f1049z;

    /* compiled from: MediaMetadata.java */
    /* renamed from: b.i.a.c.p1$b */
    public static final class b {

        @Nullable
        public Integer A;

        @Nullable
        public Integer B;

        @Nullable
        public CharSequence C;

        @Nullable
        public CharSequence D;

        @Nullable
        public Bundle E;

        @Nullable
        public CharSequence a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public CharSequence f1050b;

        @Nullable
        public CharSequence c;

        @Nullable
        public CharSequence d;

        @Nullable
        public CharSequence e;

        @Nullable
        public CharSequence f;

        @Nullable
        public CharSequence g;

        @Nullable
        public Uri h;

        @Nullable
        public Rating i;

        @Nullable
        public Rating j;

        @Nullable
        public byte[] k;

        @Nullable
        public Integer l;

        @Nullable
        public Uri m;

        @Nullable
        public Integer n;

        @Nullable
        public Integer o;

        @Nullable
        public Integer p;

        @Nullable
        public Boolean q;

        @Nullable
        public Integer r;

        /* renamed from: s, reason: collision with root package name */
        @Nullable
        public Integer f1051s;

        @Nullable
        public Integer t;

        @Nullable
        public Integer u;

        @Nullable
        public Integer v;

        @Nullable
        public Integer w;

        /* renamed from: x, reason: collision with root package name */
        @Nullable
        public CharSequence f1052x;

        /* renamed from: y, reason: collision with root package name */
        @Nullable
        public CharSequence f1053y;

        /* renamed from: z, reason: collision with root package name */
        @Nullable
        public CharSequence f1054z;

        public b() {
        }

        public MediaMetadata a() {
            return new MediaMetadata(this, null);
        }

        public b b(byte[] bArr, int i) {
            if (this.k == null || Util2.a(Integer.valueOf(i), 3) || !Util2.a(this.l, 3)) {
                this.k = (byte[]) bArr.clone();
                this.l = Integer.valueOf(i);
            }
            return this;
        }

        public b(MediaMetadata mediaMetadata, a aVar) {
            this.a = mediaMetadata.l;
            this.f1050b = mediaMetadata.m;
            this.c = mediaMetadata.n;
            this.d = mediaMetadata.o;
            this.e = mediaMetadata.p;
            this.f = mediaMetadata.q;
            this.g = mediaMetadata.r;
            this.h = mediaMetadata.f1046s;
            this.i = mediaMetadata.t;
            this.j = mediaMetadata.u;
            this.k = mediaMetadata.v;
            this.l = mediaMetadata.w;
            this.m = mediaMetadata.f1047x;
            this.n = mediaMetadata.f1048y;
            this.o = mediaMetadata.f1049z;
            this.p = mediaMetadata.A;
            this.q = mediaMetadata.B;
            this.r = mediaMetadata.D;
            this.f1051s = mediaMetadata.E;
            this.t = mediaMetadata.F;
            this.u = mediaMetadata.G;
            this.v = mediaMetadata.H;
            this.w = mediaMetadata.I;
            this.f1052x = mediaMetadata.J;
            this.f1053y = mediaMetadata.K;
            this.f1054z = mediaMetadata.L;
            this.A = mediaMetadata.M;
            this.B = mediaMetadata.N;
            this.C = mediaMetadata.O;
            this.D = mediaMetadata.P;
            this.E = mediaMetadata.Q;
        }
    }

    public MediaMetadata(b bVar, a aVar) {
        this.l = bVar.a;
        this.m = bVar.f1050b;
        this.n = bVar.c;
        this.o = bVar.d;
        this.p = bVar.e;
        this.q = bVar.f;
        this.r = bVar.g;
        this.f1046s = bVar.h;
        this.t = bVar.i;
        this.u = bVar.j;
        this.v = bVar.k;
        this.w = bVar.l;
        this.f1047x = bVar.m;
        this.f1048y = bVar.n;
        this.f1049z = bVar.o;
        this.A = bVar.p;
        this.B = bVar.q;
        Integer num = bVar.r;
        this.C = num;
        this.D = num;
        this.E = bVar.f1051s;
        this.F = bVar.t;
        this.G = bVar.u;
        this.H = bVar.v;
        this.I = bVar.w;
        this.J = bVar.f1052x;
        this.K = bVar.f1053y;
        this.L = bVar.f1054z;
        this.M = bVar.A;
        this.N = bVar.B;
        this.O = bVar.C;
        this.P = bVar.D;
        this.Q = bVar.E;
    }

    public static String b(int i) {
        return Integer.toString(i, 36);
    }

    public b a() {
        return new b(this, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaMetadata.class != obj.getClass()) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return Util2.a(this.l, mediaMetadata.l) && Util2.a(this.m, mediaMetadata.m) && Util2.a(this.n, mediaMetadata.n) && Util2.a(this.o, mediaMetadata.o) && Util2.a(this.p, mediaMetadata.p) && Util2.a(this.q, mediaMetadata.q) && Util2.a(this.r, mediaMetadata.r) && Util2.a(this.f1046s, mediaMetadata.f1046s) && Util2.a(this.t, mediaMetadata.t) && Util2.a(this.u, mediaMetadata.u) && Arrays.equals(this.v, mediaMetadata.v) && Util2.a(this.w, mediaMetadata.w) && Util2.a(this.f1047x, mediaMetadata.f1047x) && Util2.a(this.f1048y, mediaMetadata.f1048y) && Util2.a(this.f1049z, mediaMetadata.f1049z) && Util2.a(this.A, mediaMetadata.A) && Util2.a(this.B, mediaMetadata.B) && Util2.a(this.D, mediaMetadata.D) && Util2.a(this.E, mediaMetadata.E) && Util2.a(this.F, mediaMetadata.F) && Util2.a(this.G, mediaMetadata.G) && Util2.a(this.H, mediaMetadata.H) && Util2.a(this.I, mediaMetadata.I) && Util2.a(this.J, mediaMetadata.J) && Util2.a(this.K, mediaMetadata.K) && Util2.a(this.L, mediaMetadata.L) && Util2.a(this.M, mediaMetadata.M) && Util2.a(this.N, mediaMetadata.N) && Util2.a(this.O, mediaMetadata.O) && Util2.a(this.P, mediaMetadata.P);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.f1046s, this.t, this.u, Integer.valueOf(Arrays.hashCode(this.v)), this.w, this.f1047x, this.f1048y, this.f1049z, this.A, this.B, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P});
    }
}
