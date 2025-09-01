package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import kotlin.jvm.functions.Function1;

/* compiled from: OverridingUtil.java */
/* renamed from: d0.e0.p.d.m0.k.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class OverridingUtil3 implements Function1<CallableMemberDescriptor, Boolean> {
    public final /* synthetic */ ClassDescriptor j;

    public OverridingUtil3(ClassDescriptor classDescriptor) {
        this.j = classDescriptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return invoke2(callableMemberDescriptor);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public Boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(!DescriptorVisibilities.isPrivate(callableMemberDescriptor.getVisibility()) && DescriptorVisibilities.isVisibleIgnoringReceiver(callableMemberDescriptor, this.j));
    }
}
