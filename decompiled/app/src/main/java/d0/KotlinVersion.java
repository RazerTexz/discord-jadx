package d0;

import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: KotlinVersion.kt */
/* renamed from: d0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class KotlinVersion implements Comparable<KotlinVersion> {
    public static final KotlinVersion j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;

    /* compiled from: KotlinVersion.kt */
    /* renamed from: d0.e$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        j = KotlinVersion2.get();
    }

    public KotlinVersion(int i, int i2, int i3) {
        this.l = i;
        this.m = i2;
        this.n = i3;
        if (i >= 0 && 255 >= i && i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3) {
            this.k = (i << 16) + (i2 << 8) + i3;
            return;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(KotlinVersion kotlinVersion) {
        return compareTo2(kotlinVersion);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KotlinVersion)) {
            obj = null;
        }
        KotlinVersion kotlinVersion = (KotlinVersion) obj;
        return kotlinVersion != null && this.k == kotlinVersion.k;
    }

    public int hashCode() {
        return this.k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.l);
        sb.append('.');
        sb.append(this.m);
        sb.append('.');
        sb.append(this.n);
        return sb.toString();
    }

    /* renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(KotlinVersion kotlinVersion) {
        Intrinsics3.checkNotNullParameter(kotlinVersion, "other");
        return this.k - kotlinVersion.k;
    }
}
