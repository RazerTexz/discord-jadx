package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.k.a0.MemberScope3;

/* compiled from: PackageFragmentDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.c.e0, reason: use source file name */
/* loaded from: classes3.dex */
public interface PackageFragmentDescriptor extends ClassOrPackageFragmentDescriptor {
    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorNonRoot, d0.e0.p.d.m0.c.DeclarationDescriptor
    ModuleDescriptor2 getContainingDeclaration();

    FqName getFqName();

    MemberScope3 getMemberScope();
}
