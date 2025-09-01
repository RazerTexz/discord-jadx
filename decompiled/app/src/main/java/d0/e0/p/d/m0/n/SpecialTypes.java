package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.z.d.Intrinsics3;

/* compiled from: SpecialTypes.kt */
/* renamed from: d0.e0.p.d.m0.n.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class SpecialTypes extends SpecialTypes4 {
    public final KotlinType4 k;
    public final KotlinType4 l;

    public SpecialTypes(KotlinType4 kotlinType4, KotlinType4 kotlinType42) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        Intrinsics3.checkNotNullParameter(kotlinType42, "abbreviation");
        this.k = kotlinType4;
        this.l = kotlinType42;
    }

    public final KotlinType4 getAbbreviation() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4
    public KotlinType4 getDelegate() {
        return this.k;
    }

    public final KotlinType4 getExpandedType() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4, d0.e0.p.d.m0.n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType4 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4, d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4, d0.e0.p.d.m0.n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType4 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4
    public /* bridge */ /* synthetic */ SpecialTypes4 replaceDelegate(KotlinType4 kotlinType4) {
        return replaceDelegate(kotlinType4);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4, d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType4 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4
    public SpecialTypes replaceDelegate(KotlinType4 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        return new SpecialTypes(kotlinType4, this.l);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4, d0.e0.p.d.m0.n.KotlinType3
    public SpecialTypes makeNullableAsSpecified(boolean z2) {
        return new SpecialTypes(this.k.makeNullableAsSpecified(z2), this.l.makeNullableAsSpecified(z2));
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4, d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4, d0.e0.p.d.m0.n.KotlinType3
    public SpecialTypes replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return new SpecialTypes(this.k.replaceAnnotations(annotations4), this.l);
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4, d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public SpecialTypes refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new SpecialTypes((KotlinType4) kotlinTypeRefiner.refineType(this.k), (KotlinType4) kotlinTypeRefiner.refineType(this.l));
    }
}
