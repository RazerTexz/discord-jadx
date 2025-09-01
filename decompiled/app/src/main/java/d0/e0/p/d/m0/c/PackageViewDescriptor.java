package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: PackageViewDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.c.j0, reason: use source file name */
/* loaded from: classes3.dex */
public interface PackageViewDescriptor extends DeclarationDescriptor {

    /* compiled from: PackageViewDescriptor.kt */
    /* renamed from: d0.e0.p.d.m0.c.j0$a */
    public static final class a {
        public static boolean isEmpty(PackageViewDescriptor packageViewDescriptor) {
            Intrinsics3.checkNotNullParameter(packageViewDescriptor, "this");
            return packageViewDescriptor.getFragments().isEmpty();
        }
    }

    FqName getFqName();

    List<PackageFragmentDescriptor> getFragments();

    MemberScope3 getMemberScope();

    ModuleDescriptor2 getModule();

    boolean isEmpty();
}
