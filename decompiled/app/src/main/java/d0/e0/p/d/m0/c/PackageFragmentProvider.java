package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: PackageFragmentProvider.kt */
/* renamed from: d0.e0.p.d.m0.c.f0, reason: use source file name */
/* loaded from: classes3.dex */
public interface PackageFragmentProvider {
    List<PackageFragmentDescriptor> getPackageFragments(FqName fqName);

    Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1);
}
