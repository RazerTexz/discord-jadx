package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: SpecialTypes.kt */
/* renamed from: d0.e0.p.d.m0.n.m, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class SpecialTypes4 extends KotlinType4 {
    @Override // d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        return getDelegate().getAnnotations();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public List<TypeProjection> getArguments() {
        return getDelegate().getArguments();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public TypeConstructor getConstructor() {
        return getDelegate().getConstructor();
    }

    public abstract KotlinType4 getDelegate();

    @Override // d0.e0.p.d.m0.n.KotlinType
    public MemberScope3 getMemberScope() {
        return getDelegate().getMemberScope();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public boolean isMarkedNullable() {
        return getDelegate().isMarkedNullable();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    public abstract SpecialTypes4 replaceDelegate(KotlinType4 kotlinType4);

    @Override // d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public KotlinType4 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return replaceDelegate((KotlinType4) kotlinTypeRefiner.refineType(getDelegate()));
    }
}
