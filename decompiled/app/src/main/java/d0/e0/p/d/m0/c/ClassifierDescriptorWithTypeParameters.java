package d0.e0.p.d.m0.c;

import java.util.List;

/* compiled from: ClassifierDescriptorWithTypeParameters.java */
/* renamed from: d0.e0.p.d.m0.c.i, reason: use source file name */
/* loaded from: classes3.dex */
public interface ClassifierDescriptorWithTypeParameters extends ClassifierDescriptor, DeclarationDescriptorWithVisibility, MemberDescriptor, Substitutable<ClassifierDescriptorWithTypeParameters> {
    List<TypeParameterDescriptor> getDeclaredTypeParameters();

    boolean isInner();
}
