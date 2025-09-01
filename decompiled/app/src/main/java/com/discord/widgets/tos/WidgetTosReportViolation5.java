package com.discord.widgets.tos;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetTosReportViolation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel;", "invoke", "()Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.tos.WidgetTosReportViolation$viewModel$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetTosReportViolation5 extends Lambda implements Function0<WidgetTosReportViolationViewModel> {
    public final /* synthetic */ WidgetTosReportViolation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTosReportViolation5(WidgetTosReportViolation widgetTosReportViolation) {
        super(0);
        this.this$0 = widgetTosReportViolation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetTosReportViolationViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetTosReportViolationViewModel invoke() {
        return new WidgetTosReportViolationViewModel(WidgetTosReportViolation.access$getArgs$p(this.this$0).getChannelId(), WidgetTosReportViolation.access$getArgs$p(this.this$0).getMessageId());
    }
}
