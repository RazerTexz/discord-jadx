package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.z.d.Intrinsics3;

/* compiled from: KotlinTypeFactory.kt */
/* renamed from: d0.e0.p.d.m0.n.n, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class KotlinTypeFactory6 extends SpecialTypes4 {
    public final KotlinType4 k;

    public KotlinTypeFactory6(KotlinType4 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        this.k = kotlinType4;
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4
    public KotlinType4 getDelegate() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4, d0.e0.p.d.m0.n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType4 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4, d0.e0.p.d.m0.n.KotlinType3
    public KotlinType4 makeNullableAsSpecified(boolean z2) {
        return z2 == isMarkedNullable() ? this : this.k.makeNullableAsSpecified(z2).replaceAnnotations(getAnnotations());
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4, d0.e0.p.d.m0.n.KotlinType3
    public KotlinTypeFactory6 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return annotations4 != getAnnotations() ? new KotlinTypeFactory3(this, annotations4) : this;
    }
}
