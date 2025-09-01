package f0.e0.h;

import androidx.browser.trusted.sharing.ShareTarget;
import d0.z.d.Intrinsics3;

/* compiled from: HttpMethod.kt */
/* renamed from: f0.e0.h.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class HttpMethod {
    public static final boolean a(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "method");
        return (Intrinsics3.areEqual(str, ShareTarget.METHOD_GET) || Intrinsics3.areEqual(str, "HEAD")) ? false : true;
    }
}
