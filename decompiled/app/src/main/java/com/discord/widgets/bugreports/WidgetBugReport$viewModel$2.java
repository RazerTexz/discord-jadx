package com.discord.widgets.bugreports;

import android.net.Uri;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetBugReport.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportViewModel;", "invoke", "()Lcom/discord/widgets/bugreports/BugReportViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetBugReport$viewModel$2 extends Lambda implements Function0<BugReportViewModel> {
    public final /* synthetic */ WidgetBugReport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetBugReport$viewModel$2(WidgetBugReport widgetBugReport) {
        super(0);
        this.this$0 = widgetBugReport;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ BugReportViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final BugReportViewModel invoke() {
        Uri uri = Uri.parse(this.this$0.getMostRecentIntent().getStringExtra(WidgetBugReport.INTENT_EXTRA_SCREENSHOT_URI));
        String stringExtra = this.this$0.getMostRecentIntent().getStringExtra(WidgetBugReport.INTENT_EXTRA_SCREENSHOT_FILENAME);
        if (stringExtra == null) {
            stringExtra = "";
        }
        Intrinsics3.checkNotNullExpressionValue(uri, "screenshotUri");
        return new BugReportViewModel(uri, stringExtra, null, 4, null);
    }
}
