package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import java.util.Collection;
import java.util.List;

/* compiled from: TypeConstructor.java */
/* renamed from: d0.e0.p.d.m0.n.u0, reason: use source file name */
/* loaded from: classes3.dex */
public interface TypeConstructor extends d0.e0.p.d.m0.n.n1.l {
    KotlinBuiltIns getBuiltIns();

    ClassifierDescriptor getDeclarationDescriptor();

    List<TypeParameterDescriptor> getParameters();

    Collection<KotlinType> getSupertypes();

    boolean isDenotable();

    TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner);
}
