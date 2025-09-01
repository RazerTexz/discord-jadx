package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: signatureEnhancement.kt */
/* renamed from: d0.e0.p.d.m0.e.a.l0.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class signatureEnhancement4 extends Lambda implements Function1<CallableMemberDescriptor, KotlinType> {
    public static final signatureEnhancement4 j = new signatureEnhancement4();

    public signatureEnhancement4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ KotlinType invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return invoke2(callableMemberDescriptor);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final KotlinType invoke2(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "it");
        KotlinType returnType = callableMemberDescriptor.getReturnType();
        Intrinsics3.checkNotNull(returnType);
        return returnType;
    }
}
