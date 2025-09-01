package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.TypeConstructor;

/* compiled from: ClassifierDescriptor.java */
/* renamed from: d0.e0.p.d.m0.c.h, reason: use source file name */
/* loaded from: classes3.dex */
public interface ClassifierDescriptor extends DeclarationDescriptorNonRoot {
    KotlinType4 getDefaultType();

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    ClassifierDescriptor getOriginal();

    TypeConstructor getTypeConstructor();
}
