package d0.e0.p.d.m0.e.a.h0;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.z.d.Intrinsics3;

/* compiled from: JavaForKotlinOverridePropertyDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.e.a.h0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class JavaForKotlinOverridePropertyDescriptor extends JavaPropertyDescriptor {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaForKotlinOverridePropertyDescriptor(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor2, PropertyDescriptor propertyDescriptor) {
        super(classDescriptor, Annotations4.f.getEMPTY(), simpleFunctionDescriptor.getModality(), simpleFunctionDescriptor.getVisibility(), simpleFunctionDescriptor2 != null, propertyDescriptor.getName(), simpleFunctionDescriptor.getSource(), null, CallableMemberDescriptor.a.DECLARATION, false, null);
        Intrinsics3.checkNotNullParameter(classDescriptor, "ownerDescriptor");
        Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "getterMethod");
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "overriddenProperty");
    }
}
