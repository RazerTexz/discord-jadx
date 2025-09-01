package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.v0;
import d0.e0.p.d.m0.e.a.i0.l.LazyJavaPackageFragment;
import d0.z.d.Intrinsics3;

/* compiled from: KotlinJvmBinaryPackageSourceElement.kt */
/* renamed from: d0.e0.p.d.m0.e.b.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class KotlinJvmBinaryPackageSourceElement implements SourceElement {

    /* renamed from: b, reason: collision with root package name */
    public final LazyJavaPackageFragment f3380b;

    public KotlinJvmBinaryPackageSourceElement(LazyJavaPackageFragment lazyJavaPackageFragment) {
        Intrinsics3.checkNotNullParameter(lazyJavaPackageFragment, "packageFragment");
        this.f3380b = lazyJavaPackageFragment;
    }

    @Override // d0.e0.p.d.m0.c.SourceElement
    public v0 getContainingFile() {
        v0 v0Var = v0.a;
        Intrinsics3.checkNotNullExpressionValue(v0Var, "NO_SOURCE_FILE");
        return v0Var;
    }

    public String toString() {
        return this.f3380b + ": " + this.f3380b.getBinaryClasses$descriptors_jvm().keySet();
    }
}
