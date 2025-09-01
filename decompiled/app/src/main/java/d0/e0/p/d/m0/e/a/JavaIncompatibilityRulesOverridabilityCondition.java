package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.e.a.h0.JavaClassDescriptor;
import d0.e0.p.d.m0.e.a.h0.JavaMethodDescriptor;
import d0.e0.p.d.m0.e.b.methodSignatureMapping;
import d0.e0.p.d.m0.e.b.methodSignatureMapping3;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.ExternalOverridabilityCondition;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
/* renamed from: d0.e0.p.d.m0.e.a.x, reason: use source file name */
/* loaded from: classes3.dex */
public final class JavaIncompatibilityRulesOverridabilityCondition implements ExternalOverridabilityCondition {
    public static final a a = new a(null);

    /* compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.x$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final methodSignatureMapping a(FunctionDescriptor functionDescriptor, ValueParameterDescriptor valueParameterDescriptor) {
            if (!methodSignatureMapping3.forceSingleValueParameterBoxing(functionDescriptor)) {
                boolean z2 = false;
                if (functionDescriptor.getValueParameters().size() == 1) {
                    DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
                    ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
                    if (classDescriptor != null) {
                        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
                        Intrinsics3.checkNotNullExpressionValue(valueParameters, "f.valueParameters");
                        ClassifierDescriptor declarationDescriptor = ((ValueParameterDescriptor) _Collections.single((List) valueParameters)).getType().getConstructor().getDeclarationDescriptor();
                        ClassDescriptor classDescriptor2 = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
                        if (classDescriptor2 != null) {
                            z2 = KotlinBuiltIns.isPrimitiveClass(classDescriptor) && Intrinsics3.areEqual(DescriptorUtils2.getFqNameSafe(classDescriptor), DescriptorUtils2.getFqNameSafe(classDescriptor2));
                        }
                    }
                }
                if (!z2) {
                    KotlinType type = valueParameterDescriptor.getType();
                    Intrinsics3.checkNotNullExpressionValue(type, "valueParameterDescriptor.type");
                    return methodSignatureMapping3.mapToJvmType(type);
                }
            }
            KotlinType type2 = valueParameterDescriptor.getType();
            Intrinsics3.checkNotNullExpressionValue(type2, "valueParameterDescriptor.type");
            return methodSignatureMapping3.mapToJvmType(TypeUtils2.makeNullable(type2));
        }

        public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
            Intrinsics3.checkNotNullParameter(callableDescriptor, "superDescriptor");
            Intrinsics3.checkNotNullParameter(callableDescriptor2, "subDescriptor");
            if ((callableDescriptor2 instanceof JavaMethodDescriptor) && (callableDescriptor instanceof FunctionDescriptor)) {
                JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) callableDescriptor2;
                javaMethodDescriptor.getValueParameters().size();
                FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor;
                functionDescriptor.getValueParameters().size();
                List<ValueParameterDescriptor> valueParameters = javaMethodDescriptor.getOriginal().getValueParameters();
                Intrinsics3.checkNotNullExpressionValue(valueParameters, "subDescriptor.original.valueParameters");
                List<ValueParameterDescriptor> valueParameters2 = functionDescriptor.getOriginal().getValueParameters();
                Intrinsics3.checkNotNullExpressionValue(valueParameters2, "superDescriptor.original.valueParameters");
                for (Tuples2 tuples2 : _Collections.zip(valueParameters, valueParameters2)) {
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) tuples2.component1();
                    ValueParameterDescriptor valueParameterDescriptor2 = (ValueParameterDescriptor) tuples2.component2();
                    Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "subParameter");
                    boolean z2 = a((FunctionDescriptor) callableDescriptor2, valueParameterDescriptor) instanceof methodSignatureMapping.d;
                    Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor2, "superParameter");
                    if (z2 != (a(functionDescriptor, valueParameterDescriptor2) instanceof methodSignatureMapping.d)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override // d0.e0.p.d.m0.k.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.a getContract() {
        return ExternalOverridabilityCondition.a.CONFLICTS_ONLY;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    @Override // d0.e0.p.d.m0.k.ExternalOverridabilityCondition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExternalOverridabilityCondition.b isOverridable(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        ExternalOverridabilityCondition.b bVar = ExternalOverridabilityCondition.b.INCOMPATIBLE;
        Intrinsics3.checkNotNullParameter(callableDescriptor, "superDescriptor");
        Intrinsics3.checkNotNullParameter(callableDescriptor2, "subDescriptor");
        boolean z2 = false;
        if ((callableDescriptor instanceof CallableMemberDescriptor) && (callableDescriptor2 instanceof FunctionDescriptor) && !KotlinBuiltIns.isBuiltIn(callableDescriptor2)) {
            specialBuiltinMembers3 specialbuiltinmembers3 = specialBuiltinMembers3.m;
            FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor2;
            Name name = functionDescriptor.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "subDescriptor.name");
            if (!specialbuiltinmembers3.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
                specialBuiltinMembers2 specialbuiltinmembers2 = specialBuiltinMembers2.m;
                Name name2 = functionDescriptor.getName();
                Intrinsics3.checkNotNullExpressionValue(name2, "subDescriptor.name");
                if (specialbuiltinmembers2.getSameAsRenamedInJvmBuiltin(name2)) {
                    CallableMemberDescriptor overriddenSpecialBuiltin = specialBuiltinMembers.getOverriddenSpecialBuiltin((CallableMemberDescriptor) callableDescriptor);
                    Boolean boolValueOf = Boolean.valueOf(functionDescriptor.isHiddenToOvercomeSignatureClash());
                    boolean z3 = callableDescriptor instanceof FunctionDescriptor;
                    if (!(!Intrinsics3.areEqual(boolValueOf, (z3 ? (FunctionDescriptor) callableDescriptor : null) == null ? null : Boolean.valueOf(r7.isHiddenToOvercomeSignatureClash()))) || (overriddenSpecialBuiltin != null && functionDescriptor.isHiddenToOvercomeSignatureClash())) {
                        if ((classDescriptor instanceof JavaClassDescriptor) && functionDescriptor.getInitialSignatureDescriptor() == null && overriddenSpecialBuiltin != null && !specialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(classDescriptor, overriddenSpecialBuiltin)) {
                            if ((overriddenSpecialBuiltin instanceof FunctionDescriptor) && z3 && specialBuiltinMembers3.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor) overriddenSpecialBuiltin) != null) {
                                String strComputeJvmDescriptor$default = methodSignatureMapping3.computeJvmDescriptor$default(functionDescriptor, false, false, 2, null);
                                FunctionDescriptor original = ((FunctionDescriptor) callableDescriptor).getOriginal();
                                Intrinsics3.checkNotNullExpressionValue(original, "superDescriptor.original");
                                if (!Intrinsics3.areEqual(strComputeJvmDescriptor$default, methodSignatureMapping3.computeJvmDescriptor$default(original, false, false, 2, null))) {
                                }
                            } else {
                                z2 = true;
                            }
                        }
                    }
                }
            }
        }
        return (z2 || a.doesJavaOverrideHaveIncompatibleValueParameterKinds(callableDescriptor, callableDescriptor2)) ? bVar : ExternalOverridabilityCondition.b.UNKNOWN;
    }
}
