package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.Visibility2;
import d0.e0.p.d.m0.d.b.LookupLocation3;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.e0.p.d.m0.p.numbers;
import d0.e0.p.d.m0.p.numbers2;
import d0.g0.StringNumberConversions;
import d0.g0.StringNumberConversionsJVM2;
import d0.g0._Strings;
import d0.z.d.Intrinsics3;

/* compiled from: utils.kt */
/* renamed from: d0.e0.p.d.m0.e.a.f0, reason: use source file name */
/* loaded from: classes3.dex */
public final class utils2 {
    public static final utils6 lexicalCastFrom(KotlinType kotlinType, String str) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics3.checkNotNullParameter(str, "value");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            if (classDescriptor.getKind() == ClassKind.ENUM_CLASS) {
                MemberScope3 unsubstitutedInnerClassesScope = classDescriptor.getUnsubstitutedInnerClassesScope();
                Name nameIdentifier = Name.identifier(str);
                Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(value)");
                ClassifierDescriptor contributedClassifier = unsubstitutedInnerClassesScope.getContributedClassifier(nameIdentifier, LookupLocation3.FROM_BACKEND);
                if (!(contributedClassifier instanceof ClassDescriptor)) {
                    return null;
                }
                ClassDescriptor classDescriptor2 = (ClassDescriptor) contributedClassifier;
                if (classDescriptor2.getKind() == ClassKind.ENUM_ENTRY) {
                    return new utils5(classDescriptor2);
                }
                return null;
            }
        }
        KotlinType kotlinTypeMakeNotNullable = TypeUtils2.makeNotNullable(kotlinType);
        numbers numbersVarExtractRadix = numbers2.extractRadix(str);
        String strComponent1 = numbersVarExtractRadix.component1();
        int iComponent2 = numbersVarExtractRadix.component2();
        Object objValueOf = KotlinBuiltIns.isBoolean(kotlinTypeMakeNotNullable) ? Boolean.valueOf(Boolean.parseBoolean(str)) : KotlinBuiltIns.isChar(kotlinTypeMakeNotNullable) ? _Strings.singleOrNull(str) : KotlinBuiltIns.isByte(kotlinTypeMakeNotNullable) ? StringNumberConversions.toByteOrNull(strComponent1, iComponent2) : KotlinBuiltIns.isShort(kotlinTypeMakeNotNullable) ? StringNumberConversions.toShortOrNull(strComponent1, iComponent2) : KotlinBuiltIns.isInt(kotlinTypeMakeNotNullable) ? StringNumberConversions.toIntOrNull(strComponent1, iComponent2) : KotlinBuiltIns.isLong(kotlinTypeMakeNotNullable) ? StringNumberConversions.toLongOrNull(strComponent1, iComponent2) : KotlinBuiltIns.isFloat(kotlinTypeMakeNotNullable) ? StringNumberConversionsJVM2.toFloatOrNull(str) : KotlinBuiltIns.isDouble(kotlinTypeMakeNotNullable) ? StringNumberConversionsJVM2.toDoubleOrNull(str) : KotlinBuiltIns.isString(kotlinTypeMakeNotNullable) ? null : null;
        if (objValueOf != null) {
            return new utils3(objValueOf);
        }
        return null;
    }

    public static final DescriptorVisibility2 toDescriptorVisibility(Visibility2 visibility2) {
        Intrinsics3.checkNotNullParameter(visibility2, "<this>");
        DescriptorVisibility2 descriptorVisibility = JavaDescriptorVisibilities.toDescriptorVisibility(visibility2);
        Intrinsics3.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(this)");
        return descriptorVisibility;
    }
}
