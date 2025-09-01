package d0.x.d;

import d0.x.PlatformImplementations;
import d0.z.d.Intrinsics3;

/* compiled from: JDK7PlatformImplementations.kt */
/* renamed from: d0.x.d.a, reason: use source file name */
/* loaded from: classes3.dex */
public class JDK7PlatformImplementations extends PlatformImplementations {
    @Override // d0.x.PlatformImplementations
    public void addSuppressed(Throwable th, Throwable th2) {
        Intrinsics3.checkNotNullParameter(th, "cause");
        Intrinsics3.checkNotNullParameter(th2, "exception");
        th.addSuppressed(th2);
    }
}
