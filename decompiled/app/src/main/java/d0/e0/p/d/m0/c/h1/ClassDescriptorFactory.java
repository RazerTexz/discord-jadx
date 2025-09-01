package d0.e0.p.d.m0.c.h1;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import java.util.Collection;

/* compiled from: ClassDescriptorFactory.kt */
/* renamed from: d0.e0.p.d.m0.c.h1.b, reason: use source file name */
/* loaded from: classes3.dex */
public interface ClassDescriptorFactory {
    ClassDescriptor createClass(ClassId classId);

    Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName fqName);

    boolean shouldCreateClass(FqName fqName, Name name);
}
