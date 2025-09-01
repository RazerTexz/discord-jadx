package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.Intrinsics3;
import java.util.Collection;

/* compiled from: descriptorBasedTypeSignatureMapping.kt */
/* renamed from: d0.e0.p.d.m0.e.b.x, reason: use source file name */
/* loaded from: classes3.dex */
public interface descriptorBasedTypeSignatureMapping2<T> {

    /* compiled from: descriptorBasedTypeSignatureMapping.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.x$a */
    public static final class a {
        public static <T> String getPredefinedFullInternalNameForClass(descriptorBasedTypeSignatureMapping2<? extends T> descriptorbasedtypesignaturemapping2, ClassDescriptor classDescriptor) {
            Intrinsics3.checkNotNullParameter(descriptorbasedtypesignaturemapping2, "this");
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            return null;
        }

        public static <T> KotlinType preprocessType(descriptorBasedTypeSignatureMapping2<? extends T> descriptorbasedtypesignaturemapping2, KotlinType kotlinType) {
            Intrinsics3.checkNotNullParameter(descriptorbasedtypesignaturemapping2, "this");
            Intrinsics3.checkNotNullParameter(kotlinType, "kotlinType");
            return null;
        }

        public static <T> boolean releaseCoroutines(descriptorBasedTypeSignatureMapping2<? extends T> descriptorbasedtypesignaturemapping2) {
            Intrinsics3.checkNotNullParameter(descriptorbasedtypesignaturemapping2, "this");
            return true;
        }
    }

    KotlinType commonSupertype(Collection<KotlinType> collection);

    String getPredefinedFullInternalNameForClass(ClassDescriptor classDescriptor);

    String getPredefinedInternalNameForClass(ClassDescriptor classDescriptor);

    T getPredefinedTypeForClass(ClassDescriptor classDescriptor);

    KotlinType preprocessType(KotlinType kotlinType);

    void processErrorType(KotlinType kotlinType, ClassDescriptor classDescriptor);

    boolean releaseCoroutines();
}
