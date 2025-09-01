package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: OverridingUtil.java */
/* renamed from: d0.e0.p.d.m0.k.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class OverridingUtil5 implements Function1<CallableMemberDescriptor, Unit> {
    public final /* synthetic */ OverridingStrategy2 j;
    public final /* synthetic */ CallableMemberDescriptor k;

    public OverridingUtil5(OverridingStrategy2 overridingStrategy2, CallableMemberDescriptor callableMemberDescriptor) {
        this.j = overridingStrategy2;
        this.k = callableMemberDescriptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return invoke2(callableMemberDescriptor);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public Unit invoke2(CallableMemberDescriptor callableMemberDescriptor) {
        this.j.inheritanceConflict(this.k, callableMemberDescriptor);
        return Unit.a;
    }
}
