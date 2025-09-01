package d0.e0.p.d.m0.c;

/* compiled from: MemberDescriptor.java */
/* renamed from: d0.e0.p.d.m0.c.y, reason: use source file name */
/* loaded from: classes3.dex */
public interface MemberDescriptor extends DeclarationDescriptorNonRoot, DeclarationDescriptorWithVisibility {
    Modality getModality();

    DescriptorVisibility2 getVisibility();

    boolean isActual();

    boolean isExpect();

    boolean isExternal();
}
