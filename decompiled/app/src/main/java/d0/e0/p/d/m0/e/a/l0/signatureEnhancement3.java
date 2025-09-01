package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: signatureEnhancement.kt */
/* renamed from: d0.e0.p.d.m0.e.a.l0.n, reason: use source file name */
/* loaded from: classes3.dex */
public final class signatureEnhancement3 extends Lambda implements Function1<CallableMemberDescriptor, KotlinType> {
    public static final signatureEnhancement3 j = new signatureEnhancement3();

    public signatureEnhancement3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ KotlinType invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return invoke2(callableMemberDescriptor);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final KotlinType invoke2(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "it");
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        Intrinsics3.checkNotNull(extensionReceiverParameter);
        KotlinType type = extensionReceiverParameter.getType();
        Intrinsics3.checkNotNullExpressionValue(type, "it.extensionReceiverParameter!!.type");
        return type;
    }
}
