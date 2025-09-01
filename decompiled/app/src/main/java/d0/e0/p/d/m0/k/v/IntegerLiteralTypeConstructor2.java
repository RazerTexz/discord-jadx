package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: IntegerLiteralTypeConstructor.kt */
/* renamed from: d0.e0.p.d.m0.k.v.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class IntegerLiteralTypeConstructor2 extends Lambda implements Function1<KotlinType, CharSequence> {
    public static final IntegerLiteralTypeConstructor2 j = new IntegerLiteralTypeConstructor2();

    public IntegerLiteralTypeConstructor2() {
        super(1);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "it");
        return kotlinType.toString();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(KotlinType kotlinType) {
        return invoke2(kotlinType);
    }
}
