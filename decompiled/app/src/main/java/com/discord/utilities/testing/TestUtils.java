package com.discord.utilities.testing;

import android.os.Build;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.Metadata;

/* compiled from: TestUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\"\u001d\u0010\u0006\u001a\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0002¨\u0006\u0007"}, d2 = {"", "isTest", "()Z", "IS_JUNIT_TEST$delegate", "Lkotlin/Lazy;", "getIS_JUNIT_TEST", "IS_JUNIT_TEST", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.testing.TestUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class TestUtils {
    private static final Lazy IS_JUNIT_TEST$delegate = LazyJVM.lazy(TestUtils2.INSTANCE);

    public static final boolean getIS_JUNIT_TEST() {
        return ((Boolean) IS_JUNIT_TEST$delegate.getValue()).booleanValue();
    }

    public static final boolean isTest() {
        return Intrinsics3.areEqual(Build.FINGERPRINT, "roboelectric");
    }
}
