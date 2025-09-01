package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: signatureEnhancement.kt */
/* renamed from: d0.e0.p.d.m0.e.a.l0.p, reason: use source file name */
/* loaded from: classes3.dex */
public final class signatureEnhancement5 extends Lambda implements Function1<CallableMemberDescriptor, KotlinType> {
    public final /* synthetic */ ValueParameterDescriptor $p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public signatureEnhancement5(ValueParameterDescriptor valueParameterDescriptor) {
        super(1);
        this.$p = valueParameterDescriptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ KotlinType invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return invoke2(callableMemberDescriptor);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final KotlinType invoke2(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "it");
        KotlinType type = callableMemberDescriptor.getValueParameters().get(this.$p.getIndex()).getType();
        Intrinsics3.checkNotNullExpressionValue(type, "it.valueParameters[p.index].type");
        return type;
    }
}
