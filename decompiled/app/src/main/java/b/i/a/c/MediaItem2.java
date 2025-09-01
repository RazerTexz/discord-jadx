package b.i.a.c;

import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Bundleable;
import b.i.a.c.f3.Util2;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableCollection;
import b.i.b.b.ImmutableList2;
import b.i.b.b.ImmutableMap2;
import b.i.b.b.RegularImmutableList;
import b.i.b.b.RegularImmutableMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* compiled from: MediaItem.java */
/* renamed from: b.i.a.c.o1, reason: use source file name */
/* loaded from: classes3.dex */
public final class MediaItem2 implements Bundleable {
    public static final Bundleable.a<MediaItem2> j;
    public final String k;

    @Nullable
    public final h l;
    public final g m;
    public final MediaMetadata n;
    public final d o;

    /* compiled from: MediaItem.java */
    /* renamed from: b.i.a.c.o1$b */
    public static final class b {
    }

    /* compiled from: MediaItem.java */
    /* renamed from: b.i.a.c.o1$c */
    public static final class c {

        @Nullable
        public String a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public Uri f1034b;

        @Nullable
        public String c;

        @Nullable
        public String g;

        @Nullable
        public Object i;

        @Nullable
        public MediaMetadata j;
        public d.a d = new d.a();
        public f.a e = new f.a(null);
        public List<?> f = Collections.emptyList();
        public ImmutableList2<k> h = RegularImmutableList.l;
        public g.a k = new g.a();

        public MediaItem2 a() {
            i iVar;
            f.a aVar = this.e;
            AnimatableValueParser.D(aVar.f1037b == null || aVar.a != null);
            Uri uri = this.f1034b;
            if (uri != null) {
                String str = this.c;
                f.a aVar2 = this.e;
                iVar = new i(uri, str, aVar2.a != null ? new f(aVar2, null) : null, null, this.f, this.g, this.h, this.i, null);
            } else {
                iVar = null;
            }
            String str2 = this.a;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            e eVarA = this.d.a();
            g.a aVar3 = this.k;
            Objects.requireNonNull(aVar3);
            g gVar = new g(aVar3, null);
            MediaMetadata mediaMetadata = this.j;
            if (mediaMetadata == null) {
                mediaMetadata = MediaMetadata.j;
            }
            return new MediaItem2(str3, eVarA, iVar, gVar, mediaMetadata, null);
        }
    }

    /* compiled from: MediaItem.java */
    /* renamed from: b.i.a.c.o1$d */
    public static class d implements Bundleable {
        public static final Bundleable.a<e> j;

        @IntRange(from = 0)
        public final long k;
        public final long l;
        public final boolean m;
        public final boolean n;
        public final boolean o;

        /* compiled from: MediaItem.java */
        /* renamed from: b.i.a.c.o1$d$a */
        public static final class a {
            public long a;

            /* renamed from: b, reason: collision with root package name */
            public long f1035b = Long.MIN_VALUE;
            public boolean c;
            public boolean d;
            public boolean e;

            @Deprecated
            public e a() {
                return new e(this, null);
            }
        }

        static {
            new a().a();
            j = i0.a;
        }

        public d(a aVar, a aVar2) {
            this.k = aVar.a;
            this.l = aVar.f1035b;
            this.m = aVar.c;
            this.n = aVar.d;
            this.o = aVar.e;
        }

        public static String a(int i) {
            return Integer.toString(i, 36);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.k == dVar.k && this.l == dVar.l && this.m == dVar.m && this.n == dVar.n && this.o == dVar.o;
        }

        public int hashCode() {
            long j2 = this.k;
            int i = ((int) (j2 ^ (j2 >>> 32))) * 31;
            long j3 = this.l;
            return ((((((i + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.m ? 1 : 0)) * 31) + (this.n ? 1 : 0)) * 31) + (this.o ? 1 : 0);
        }
    }

    /* compiled from: MediaItem.java */
    @Deprecated
    /* renamed from: b.i.a.c.o1$e */
    public static final class e extends d {
        public static final e p = new d.a().a();

        public e(d.a aVar, a aVar2) {
            super(aVar, null);
        }
    }

    /* compiled from: MediaItem.java */
    /* renamed from: b.i.a.c.o1$f */
    public static final class f {
        public final UUID a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final Uri f1036b;
        public final ImmutableMap2<String, String> c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final ImmutableList2<Integer> g;

        @Nullable
        public final byte[] h;

        /* compiled from: MediaItem.java */
        /* renamed from: b.i.a.c.o1$f$a */
        public static final class a {

            @Nullable
            public UUID a;

            /* renamed from: b, reason: collision with root package name */
            @Nullable
            public Uri f1037b;
            public ImmutableMap2<String, String> c = RegularImmutableMap.m;
            public boolean d;
            public boolean e;
            public boolean f;
            public ImmutableList2<Integer> g;

            @Nullable
            public byte[] h;

            public a(a aVar) {
                AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
                this.g = RegularImmutableList.l;
            }
        }

        public f(a aVar, a aVar2) {
            AnimatableValueParser.D((aVar.f && aVar.f1037b == null) ? false : true);
            UUID uuid = aVar.a;
            Objects.requireNonNull(uuid);
            this.a = uuid;
            this.f1036b = aVar.f1037b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.f = aVar.f;
            this.e = aVar.e;
            this.g = aVar.g;
            byte[] bArr = aVar.h;
            this.h = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.a.equals(fVar.a) && Util2.a(this.f1036b, fVar.f1036b) && Util2.a(this.c, fVar.c) && this.d == fVar.d && this.f == fVar.f && this.e == fVar.e && this.g.equals(fVar.g) && Arrays.equals(this.h, fVar.h);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            Uri uri = this.f1036b;
            return Arrays.hashCode(this.h) + ((this.g.hashCode() + ((((((((this.c.hashCode() + ((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31)) * 31) + (this.d ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31)) * 31);
        }
    }

    /* compiled from: MediaItem.java */
    /* renamed from: b.i.a.c.o1$h */
    public static class h {
        public final Uri a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f1039b;

        @Nullable
        public final f c;
        public final List<?> d;

        @Nullable
        public final String e;
        public final ImmutableList2<k> f;

        @Nullable
        public final Object g;

        /* JADX WARN: Multi-variable type inference failed */
        public h(Uri uri, String str, f fVar, b bVar, List list, String str2, ImmutableList2 immutableList2, Object obj, a aVar) {
            this.a = uri;
            this.f1039b = str;
            this.c = fVar;
            this.d = list;
            this.e = str2;
            this.f = immutableList2;
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
            b.i.a.f.e.o.f.A(4, "initialCapacity");
            Object[] objArrCopyOf = new Object[4];
            int i = 0;
            int i2 = 0;
            while (i < immutableList2.size()) {
                j jVar = new j(new k.a((k) immutableList2.get(i), null), null);
                int i3 = i2 + 1;
                if (objArrCopyOf.length < i3) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.a(objArrCopyOf.length, i3));
                }
                objArrCopyOf[i2] = jVar;
                i++;
                i2 = i3;
            }
            ImmutableList2.l(objArrCopyOf, i2);
            this.g = obj;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.a.equals(hVar.a) && Util2.a(this.f1039b, hVar.f1039b) && Util2.a(this.c, hVar.c) && Util2.a(null, null) && this.d.equals(hVar.d) && Util2.a(this.e, hVar.e) && this.f.equals(hVar.f) && Util2.a(this.g, hVar.g);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            String str = this.f1039b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            f fVar = this.c;
            int iHashCode3 = (this.d.hashCode() + ((((iHashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 31) + 0) * 31)) * 31;
            String str2 = this.e;
            int iHashCode4 = (this.f.hashCode() + ((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
            Object obj = this.g;
            return iHashCode4 + (obj != null ? obj.hashCode() : 0);
        }
    }

    /* compiled from: MediaItem.java */
    @Deprecated
    /* renamed from: b.i.a.c.o1$i */
    public static final class i extends h {
        public i(Uri uri, String str, f fVar, b bVar, List list, String str2, ImmutableList2 immutableList2, Object obj, a aVar) {
            super(uri, str, fVar, null, list, str2, immutableList2, obj, null);
        }
    }

    /* compiled from: MediaItem.java */
    @Deprecated
    /* renamed from: b.i.a.c.o1$j */
    public static final class j extends k {
        public j(k.a aVar, a aVar2) {
            super(aVar, null);
        }
    }

    /* compiled from: MediaItem.java */
    /* renamed from: b.i.a.c.o1$k */
    public static class k {
        public final Uri a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f1040b;

        @Nullable
        public final String c;
        public final int d;
        public final int e;

        @Nullable
        public final String f;

        /* compiled from: MediaItem.java */
        /* renamed from: b.i.a.c.o1$k$a */
        public static final class a {
            public Uri a;

            /* renamed from: b, reason: collision with root package name */
            @Nullable
            public String f1041b;

            @Nullable
            public String c;
            public int d;
            public int e;

            @Nullable
            public String f;

            public a(k kVar, a aVar) {
                this.a = kVar.a;
                this.f1041b = kVar.f1040b;
                this.c = kVar.c;
                this.d = kVar.d;
                this.e = kVar.e;
                this.f = kVar.f;
            }
        }

        public k(a aVar, a aVar2) {
            this.a = aVar.a;
            this.f1040b = aVar.f1041b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.f;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return this.a.equals(kVar.a) && Util2.a(this.f1040b, kVar.f1040b) && Util2.a(this.c, kVar.c) && this.d == kVar.d && this.e == kVar.e && Util2.a(this.f, kVar.f);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            String str = this.f1040b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.c;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.d) * 31) + this.e) * 31;
            String str3 = this.f;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }
    }

    static {
        new c().a();
        j = k0.a;
    }

    public MediaItem2(String str, e eVar, @Nullable i iVar, g gVar, MediaMetadata mediaMetadata) {
        this.k = str;
        this.l = null;
        this.m = gVar;
        this.n = mediaMetadata;
        this.o = eVar;
    }

    public static String a(int i2) {
        return Integer.toString(i2, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem2)) {
            return false;
        }
        MediaItem2 mediaItem2 = (MediaItem2) obj;
        return Util2.a(this.k, mediaItem2.k) && this.o.equals(mediaItem2.o) && Util2.a(this.l, mediaItem2.l) && Util2.a(this.m, mediaItem2.m) && Util2.a(this.n, mediaItem2.n);
    }

    public int hashCode() {
        int iHashCode = this.k.hashCode() * 31;
        h hVar = this.l;
        return this.n.hashCode() + ((this.o.hashCode() + ((this.m.hashCode() + ((iHashCode + (hVar != null ? hVar.hashCode() : 0)) * 31)) * 31)) * 31);
    }

    public MediaItem2(String str, e eVar, i iVar, g gVar, MediaMetadata mediaMetadata, a aVar) {
        this.k = str;
        this.l = iVar;
        this.m = gVar;
        this.n = mediaMetadata;
        this.o = eVar;
    }

    /* compiled from: MediaItem.java */
    /* renamed from: b.i.a.c.o1$g */
    public static final class g implements Bundleable {
        public static final g j = new a().a();
        public static final Bundleable.a<g> k = j0.a;
        public final long l;
        public final long m;
        public final long n;
        public final float o;
        public final float p;

        /* compiled from: MediaItem.java */
        /* renamed from: b.i.a.c.o1$g$a */
        public static final class a {
            public long a = -9223372036854775807L;

            /* renamed from: b, reason: collision with root package name */
            public long f1038b = -9223372036854775807L;
            public long c = -9223372036854775807L;
            public float d = -3.4028235E38f;
            public float e = -3.4028235E38f;

            public g a() {
                return new g(this, null);
            }
        }

        public g(a aVar, a aVar2) {
            long j2 = aVar.a;
            long j3 = aVar.f1038b;
            long j4 = aVar.c;
            float f = aVar.d;
            float f2 = aVar.e;
            this.l = j2;
            this.m = j3;
            this.n = j4;
            this.o = f;
            this.p = f2;
        }

        public static String a(int i) {
            return Integer.toString(i, 36);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.l == gVar.l && this.m == gVar.m && this.n == gVar.n && this.o == gVar.o && this.p == gVar.p;
        }

        public int hashCode() {
            long j2 = this.l;
            long j3 = this.m;
            int i = ((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.n;
            int i2 = (i + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            float f = this.o;
            int iFloatToIntBits = (i2 + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
            float f2 = this.p;
            return iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
        }

        @Deprecated
        public g(long j2, long j3, long j4, float f, float f2) {
            this.l = j2;
            this.m = j3;
            this.n = j4;
            this.o = f;
            this.p = f2;
        }
    }
}
