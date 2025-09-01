package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.c.g1.Annotations3;
import d0.e0.p.d.m0.g.Name;

/* compiled from: DeclarationDescriptor.java */
/* renamed from: d0.e0.p.d.m0.c.m, reason: use source file name */
/* loaded from: classes3.dex */
public interface DeclarationDescriptor extends Annotations3 {
    <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d);

    DeclarationDescriptor getContainingDeclaration();

    Name getName();

    DeclarationDescriptor getOriginal();
}
