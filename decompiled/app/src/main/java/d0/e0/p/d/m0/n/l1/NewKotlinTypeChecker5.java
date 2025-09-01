package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.AbstractStrictEqualityTypeChecker;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.z.d.Intrinsics3;

/* compiled from: NewKotlinTypeChecker.kt */
/* renamed from: d0.e0.p.d.m0.n.l1.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class NewKotlinTypeChecker5 {
    public static final NewKotlinTypeChecker5 a = new NewKotlinTypeChecker5();

    public final boolean strictEqualTypes(KotlinType3 kotlinType3, KotlinType3 kotlinType32) {
        Intrinsics3.checkNotNullParameter(kotlinType3, "a");
        Intrinsics3.checkNotNullParameter(kotlinType32, "b");
        return AbstractStrictEqualityTypeChecker.a.strictEqualTypes(NewKotlinTypeChecker4.a, kotlinType3, kotlinType32);
    }
}
