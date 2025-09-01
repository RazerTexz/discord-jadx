package d0.e0.p.d.m0.c.h1;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.z.d.Intrinsics3;

/* compiled from: PlatformDependentDeclarationFilter.kt */
/* renamed from: d0.e0.p.d.m0.c.h1.c, reason: use source file name */
/* loaded from: classes3.dex */
public interface PlatformDependentDeclarationFilter {

    /* compiled from: PlatformDependentDeclarationFilter.kt */
    /* renamed from: d0.e0.p.d.m0.c.h1.c$a */
    public static final class a implements PlatformDependentDeclarationFilter {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.c.h1.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "functionDescriptor");
            return true;
        }
    }

    /* compiled from: PlatformDependentDeclarationFilter.kt */
    /* renamed from: d0.e0.p.d.m0.c.h1.c$b */
    public static final class b implements PlatformDependentDeclarationFilter {
        public static final b a = new b();

        @Override // d0.e0.p.d.m0.c.h1.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "functionDescriptor");
            return !simpleFunctionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilter2.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME());
        }
    }

    boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor);
}
