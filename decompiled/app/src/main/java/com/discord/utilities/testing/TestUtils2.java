package com.discord.utilities.testing;

import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: TestUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.testing.TestUtilsKt$IS_JUNIT_TEST$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class TestUtils2 extends Lambda implements Function0<Boolean> {
    public static final TestUtils2 INSTANCE = new TestUtils2();

    public TestUtils2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics3.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
        Intrinsics3.checkNotNullExpressionValue(stackTrace, "Thread.currentThread().stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            Intrinsics3.checkNotNullExpressionValue(stackTraceElement, "it");
            String className = stackTraceElement.getClassName();
            Intrinsics3.checkNotNullExpressionValue(className, "it.className");
            if (StringsJVM.startsWith$default(className, "org.junit", false, 2, null)) {
                return true;
            }
        }
        return false;
    }
}
