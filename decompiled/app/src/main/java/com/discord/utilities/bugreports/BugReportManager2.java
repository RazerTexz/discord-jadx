package com.discord.utilities.bugreports;

import com.discord.screenshot_detection.ScreenshotDetector;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: BugReportManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/screenshot_detection/ScreenshotDetector;", "invoke", "()Lcom/discord/screenshot_detection/ScreenshotDetector;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.bugreports.BugReportManager$screenshotDetector$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class BugReportManager2 extends Lambda implements Function0<ScreenshotDetector> {
    public static final BugReportManager2 INSTANCE = new BugReportManager2();

    public BugReportManager2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ScreenshotDetector invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ScreenshotDetector invoke() {
        ScreenshotDetector screenshotDetector = ScreenshotDetector.a;
        if (screenshotDetector == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("screenshotDetector");
        }
        return screenshotDetector;
    }
}
