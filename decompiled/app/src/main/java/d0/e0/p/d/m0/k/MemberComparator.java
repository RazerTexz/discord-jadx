package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ConstructorDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import java.util.Comparator;

/* compiled from: MemberComparator.java */
/* renamed from: d0.e0.p.d.m0.k.h, reason: use source file name */
/* loaded from: classes3.dex */
public class MemberComparator implements Comparator<DeclarationDescriptor> {
    public static final MemberComparator j = new MemberComparator();

    public static int a(DeclarationDescriptor declarationDescriptor) {
        if (DescriptorUtils.isEnumEntry(declarationDescriptor)) {
            return 8;
        }
        if (declarationDescriptor instanceof ConstructorDescriptor) {
            return 7;
        }
        if (declarationDescriptor instanceof PropertyDescriptor) {
            return ((PropertyDescriptor) declarationDescriptor).getExtensionReceiverParameter() == null ? 6 : 5;
        }
        if (declarationDescriptor instanceof FunctionDescriptor) {
            return ((FunctionDescriptor) declarationDescriptor).getExtensionReceiverParameter() == null ? 4 : 3;
        }
        if (declarationDescriptor instanceof ClassDescriptor) {
            return 2;
        }
        return declarationDescriptor instanceof TypeAliasDescriptor ? 1 : 0;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        return compare2(declarationDescriptor, declarationDescriptor2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        Integer numValueOf;
        int iA = a(declarationDescriptor2) - a(declarationDescriptor);
        if (iA != 0) {
            numValueOf = Integer.valueOf(iA);
        } else if (DescriptorUtils.isEnumEntry(declarationDescriptor) && DescriptorUtils.isEnumEntry(declarationDescriptor2)) {
            numValueOf = 0;
        } else {
            int iCompareTo2 = declarationDescriptor.getName().compareTo2(declarationDescriptor2.getName());
            numValueOf = iCompareTo2 != 0 ? Integer.valueOf(iCompareTo2) : null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }
}
