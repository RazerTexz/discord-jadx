package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.e.a.i0.l.LazyJavaClassDescriptor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.p.DFS;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: JvmBuiltInsCustomizer.kt */
/* renamed from: d0.e0.p.d.m0.b.q.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer6 implements DFS.c<ClassDescriptor> {
    public final /* synthetic */ JvmBuiltInsCustomizer2 a;

    public JvmBuiltInsCustomizer6(JvmBuiltInsCustomizer2 jvmBuiltInsCustomizer2) {
        this.a = jvmBuiltInsCustomizer2;
    }

    @Override // d0.e0.p.d.m0.p.DFS.c
    public /* bridge */ /* synthetic */ Iterable<? extends ClassDescriptor> getNeighbors(ClassDescriptor classDescriptor) {
        return getNeighbors2(classDescriptor);
    }

    /* renamed from: getNeighbors, reason: avoid collision after fix types in other method */
    public final Iterable<ClassDescriptor> getNeighbors2(ClassDescriptor classDescriptor) {
        Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
        Intrinsics3.checkNotNullExpressionValue(supertypes, "it.typeConstructor.supertypes");
        JvmBuiltInsCustomizer2 jvmBuiltInsCustomizer2 = this.a;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            ClassifierDescriptor declarationDescriptor = ((KotlinType) it.next()).getConstructor().getDeclarationDescriptor();
            ClassifierDescriptor original = declarationDescriptor == null ? null : declarationDescriptor.getOriginal();
            ClassDescriptor classDescriptor2 = original instanceof ClassDescriptor ? (ClassDescriptor) original : null;
            LazyJavaClassDescriptor lazyJavaClassDescriptorAccess$getJavaAnalogue = classDescriptor2 != null ? JvmBuiltInsCustomizer2.access$getJavaAnalogue(jvmBuiltInsCustomizer2, classDescriptor2) : null;
            if (lazyJavaClassDescriptorAccess$getJavaAnalogue != null) {
                arrayList.add(lazyJavaClassDescriptorAccess$getJavaAnalogue);
            }
        }
        return arrayList;
    }
}
