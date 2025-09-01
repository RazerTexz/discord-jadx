package com.discord.widgets.tos;

import com.discord.utilities.intent.IntentUtilsKt;
import com.discord.widgets.tos.WidgetTosReportViolation;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetTosReportViolation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolation$Companion$Arguments;", "invoke", "()Lcom/discord/widgets/tos/WidgetTosReportViolation$Companion$Arguments;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.tos.WidgetTosReportViolation$args$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetTosReportViolation3 extends Lambda implements Function0<WidgetTosReportViolation.Companion.Arguments> {
    public final /* synthetic */ WidgetTosReportViolation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTosReportViolation3(WidgetTosReportViolation widgetTosReportViolation) {
        super(0);
        this.this$0 = widgetTosReportViolation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetTosReportViolation.Companion.Arguments invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetTosReportViolation.Companion.Arguments invoke() {
        return new WidgetTosReportViolation.Companion.Arguments(IntentUtilsKt.getStringExtraOrDefault$default(this.this$0.getMostRecentIntent(), "EXTRA_TARGET", null, 2, null), this.this$0.getMostRecentIntent().getLongExtra("EXTRA_CHANNEL_ID", 0L), this.this$0.getMostRecentIntent().getLongExtra("EXTRA_MESSAGE_ID", 0L));
    }
}
