package d0.e0.p.d.m0.n;

import d0.z.d.Intrinsics3;

/* compiled from: KotlinTypeFactory.kt */
/* renamed from: d0.e0.p.d.m0.n.h0, reason: use source file name */
/* loaded from: classes3.dex */
public final class KotlinTypeFactory4 extends KotlinTypeFactory6 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinTypeFactory4(KotlinType4 kotlinType4) {
        super(kotlinType4);
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4, d0.e0.p.d.m0.n.KotlinType
    public boolean isMarkedNullable() {
        return true;
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4
    public /* bridge */ /* synthetic */ SpecialTypes4 replaceDelegate(KotlinType4 kotlinType4) {
        return replaceDelegate(kotlinType4);
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4
    public KotlinTypeFactory4 replaceDelegate(KotlinType4 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        return new KotlinTypeFactory4(kotlinType4);
    }
}
