package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: DescriptorRendererImpl.kt */
/* renamed from: d0.e0.p.d.m0.j.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class DescriptorRendererImpl3 extends Lambda implements Function1<KotlinType, CharSequence> {
    public final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DescriptorRendererImpl3(DescriptorRendererImpl descriptorRendererImpl) {
        super(1);
        this.this$0 = descriptorRendererImpl;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(KotlinType kotlinType) {
        DescriptorRendererImpl descriptorRendererImpl = this.this$0;
        Intrinsics3.checkNotNullExpressionValue(kotlinType, "it");
        return descriptorRendererImpl.renderType(kotlinType);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(KotlinType kotlinType) {
        return invoke2(kotlinType);
    }
}
