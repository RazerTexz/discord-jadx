package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: LazyJavaScope.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.l.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class LazyJavaScope3 extends Lambda implements Function1<SimpleFunctionDescriptor, CallableDescriptor> {
    public static final LazyJavaScope3 j = new LazyJavaScope3();

    public LazyJavaScope3() {
        super(1);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CallableDescriptor invoke2(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "<this>");
        return simpleFunctionDescriptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CallableDescriptor invoke(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        return invoke2(simpleFunctionDescriptor);
    }
}
