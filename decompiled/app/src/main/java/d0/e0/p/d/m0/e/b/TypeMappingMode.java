package d0.e0.p.d.m0.e.b;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.PointerIconCompat;
import androidx.media.AudioAttributesCompat;
import d0.e0.p.d.m0.n.Variance;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TypeMappingMode.kt */
/* renamed from: d0.e0.p.d.m0.e.b.z, reason: use source file name */
/* loaded from: classes3.dex */
public final class TypeMappingMode {
    public static final TypeMappingMode a;

    /* renamed from: b, reason: collision with root package name */
    public static final TypeMappingMode f3383b;
    public static final TypeMappingMode c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final TypeMappingMode i;
    public final boolean j;
    public final TypeMappingMode k;
    public final TypeMappingMode l;
    public final boolean m;

    /* compiled from: TypeMappingMode.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.z$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        TypeMappingMode typeMappingMode = new TypeMappingMode(false, false, false, false, false, null, false, null, null, false, AudioAttributesCompat.FLAG_ALL, null);
        a = typeMappingMode;
        TypeMappingMode typeMappingMode2 = new TypeMappingMode(false, false, false, false, false, null, false, null, null, true, FrameMetricsAggregator.EVERY_DURATION, null);
        f3383b = typeMappingMode2;
        new TypeMappingMode(false, true, false, false, false, null, false, null, null, false, PointerIconCompat.TYPE_GRABBING, null);
        c = new TypeMappingMode(false, false, false, false, false, typeMappingMode, false, null, null, false, 988, null);
        new TypeMappingMode(false, false, false, false, false, typeMappingMode2, false, null, null, true, 476, null);
        new TypeMappingMode(false, true, false, false, false, typeMappingMode, false, null, null, false, 988, null);
        new TypeMappingMode(false, false, false, true, false, typeMappingMode, false, null, null, false, 983, null);
        new TypeMappingMode(false, false, false, true, false, typeMappingMode, false, null, null, false, 919, null);
        new TypeMappingMode(false, false, true, false, false, typeMappingMode, false, null, null, false, 984, null);
    }

    public TypeMappingMode(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, TypeMappingMode typeMappingMode, boolean z7, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean z8) {
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = z6;
        this.i = typeMappingMode;
        this.j = z7;
        this.k = typeMappingMode2;
        this.l = typeMappingMode3;
        this.m = z8;
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.j;
    }

    public final boolean getMapTypeAliases() {
        return this.m;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.e;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.d;
    }

    public final boolean isForAnnotationParameter() {
        return this.f;
    }

    public final TypeMappingMode toGenericArgumentMode(Variance variance, boolean z2) {
        Intrinsics3.checkNotNullParameter(variance, "effectiveVariance");
        if (!z2 || !this.f) {
            int iOrdinal = variance.ordinal();
            if (iOrdinal == 0) {
                TypeMappingMode typeMappingMode = this.l;
                if (typeMappingMode != null) {
                    return typeMappingMode;
                }
            } else if (iOrdinal != 1) {
                TypeMappingMode typeMappingMode2 = this.i;
                if (typeMappingMode2 != null) {
                    return typeMappingMode2;
                }
            } else {
                TypeMappingMode typeMappingMode3 = this.k;
                if (typeMappingMode3 != null) {
                    return typeMappingMode3;
                }
            }
        }
        return this;
    }

    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.d, true, this.f, this.g, this.h, this.i, this.j, this.k, this.l, false, 512, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TypeMappingMode(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, TypeMappingMode typeMappingMode, boolean z7, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean z8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z9 = (i & 1) != 0 ? true : z2;
        boolean z10 = (i & 2) != 0 ? true : z3;
        boolean z11 = (i & 4) != 0 ? false : z4;
        boolean z12 = (i & 8) != 0 ? false : z5;
        boolean z13 = (i & 16) != 0 ? false : z6;
        TypeMappingMode typeMappingMode4 = (i & 32) != 0 ? null : typeMappingMode;
        this(z9, z10, z11, z12, z13, typeMappingMode4, (i & 64) == 0 ? z7 : true, (i & 128) != 0 ? typeMappingMode4 : typeMappingMode2, (i & 256) != 0 ? typeMappingMode4 : typeMappingMode3, (i & 512) == 0 ? z8 : false);
    }
}
