package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.e.a.i0.l.JavaDescriptorUtil;
import d0.e0.p.d.m0.k.ExternalOverridabilityCondition;
import d0.z.d.Intrinsics3;

/* compiled from: FieldOverridabilityCondition.kt */
/* renamed from: d0.e0.p.d.m0.e.a.r, reason: use source file name */
/* loaded from: classes3.dex */
public final class FieldOverridabilityCondition implements ExternalOverridabilityCondition {
    @Override // d0.e0.p.d.m0.k.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.a getContract() {
        return ExternalOverridabilityCondition.a.BOTH;
    }

    @Override // d0.e0.p.d.m0.k.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.b isOverridable(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        ExternalOverridabilityCondition.b bVar = ExternalOverridabilityCondition.b.UNKNOWN;
        Intrinsics3.checkNotNullParameter(callableDescriptor, "superDescriptor");
        Intrinsics3.checkNotNullParameter(callableDescriptor2, "subDescriptor");
        if (!(callableDescriptor2 instanceof PropertyDescriptor) || !(callableDescriptor instanceof PropertyDescriptor)) {
            return bVar;
        }
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor2;
        PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor;
        return !Intrinsics3.areEqual(propertyDescriptor.getName(), propertyDescriptor2.getName()) ? bVar : (JavaDescriptorUtil.isJavaField(propertyDescriptor) && JavaDescriptorUtil.isJavaField(propertyDescriptor2)) ? ExternalOverridabilityCondition.b.OVERRIDABLE : (JavaDescriptorUtil.isJavaField(propertyDescriptor) || JavaDescriptorUtil.isJavaField(propertyDescriptor2)) ? ExternalOverridabilityCondition.b.INCOMPATIBLE : bVar;
    }
}
