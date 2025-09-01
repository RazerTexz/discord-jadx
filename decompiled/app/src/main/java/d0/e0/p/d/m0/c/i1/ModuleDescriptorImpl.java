package d0.e0.p.d.m0.c.i1;

import java.util.List;
import java.util.Set;

/* compiled from: ModuleDescriptorImpl.kt */
/* renamed from: d0.e0.p.d.m0.c.i1.w, reason: use source file name */
/* loaded from: classes3.dex */
public interface ModuleDescriptorImpl {
    List<ModuleDescriptorImpl3> getAllDependencies();

    List<ModuleDescriptorImpl3> getDirectExpectedByDependencies();

    Set<ModuleDescriptorImpl3> getModulesWhoseInternalsAreVisible();
}
