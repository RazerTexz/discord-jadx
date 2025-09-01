package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.e.a.h0.JavaClassDescriptor;
import d0.z.d.Intrinsics3;

/* compiled from: JavaClassesTracker.kt */
/* renamed from: d0.e0.p.d.m0.e.a.t, reason: use source file name */
/* loaded from: classes3.dex */
public interface JavaClassesTracker {

    /* compiled from: JavaClassesTracker.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.t$a */
    public static final class a implements JavaClassesTracker {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.e.a.JavaClassesTracker
        public void reportClass(JavaClassDescriptor javaClassDescriptor) {
            Intrinsics3.checkNotNullParameter(javaClassDescriptor, "classDescriptor");
        }
    }

    void reportClass(JavaClassDescriptor javaClassDescriptor);
}
