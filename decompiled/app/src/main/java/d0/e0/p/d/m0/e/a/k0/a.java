package d0.e0.p.d.m0.e.a.k0;

import d0.e0.p.d.m0.g.ClassId;
import d0.z.d.Intrinsics3;
import java.util.Collection;

/* compiled from: javaElements.kt */
/* loaded from: classes3.dex */
public interface a extends l {

    /* compiled from: javaElements.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.k0.a$a, reason: collision with other inner class name */
    public static final class C0385a {
        public static boolean isFreshlySupportedTypeUseAnnotation(a aVar) {
            Intrinsics3.checkNotNullParameter(aVar, "this");
            return false;
        }

        public static boolean isIdeExternalAnnotation(a aVar) {
            Intrinsics3.checkNotNullParameter(aVar, "this");
            return false;
        }
    }

    Collection<annotationArguments> getArguments();

    ClassId getClassId();

    boolean isFreshlySupportedTypeUseAnnotation();

    boolean isIdeExternalAnnotation();

    g resolve();
}
