package d0.e0.p.d.m0.n;

import d0.Lazy5;
import d0.LazyJVM;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* compiled from: StarProjectionImpl.kt */
/* renamed from: d0.e0.p.d.m0.n.o0, reason: use source file name */
/* loaded from: classes3.dex */
public final class StarProjectionImpl2 extends TypeProjectionBase {
    public final TypeParameterDescriptor a;

    /* renamed from: b, reason: collision with root package name */
    public final Lazy f3532b;

    /* compiled from: StarProjectionImpl.kt */
    /* renamed from: d0.e0.p.d.m0.n.o0$a */
    public static final class a extends Lambda implements Function0<KotlinType> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ KotlinType invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType invoke() {
            return StarProjectionImpl3.starProjectionType(StarProjectionImpl2.access$getTypeParameter$p(StarProjectionImpl2.this));
        }
    }

    public StarProjectionImpl2(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        this.a = typeParameterDescriptor;
        this.f3532b = LazyJVM.lazy(Lazy5.PUBLICATION, new a());
    }

    public static final /* synthetic */ TypeParameterDescriptor access$getTypeParameter$p(StarProjectionImpl2 starProjectionImpl2) {
        return starProjectionImpl2.a;
    }

    @Override // d0.e0.p.d.m0.n.TypeProjection
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    @Override // d0.e0.p.d.m0.n.TypeProjection
    public KotlinType getType() {
        return (KotlinType) this.f3532b.getValue();
    }

    @Override // d0.e0.p.d.m0.n.TypeProjection
    public boolean isStarProjection() {
        return true;
    }

    @Override // d0.e0.p.d.m0.n.TypeProjection
    public TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
