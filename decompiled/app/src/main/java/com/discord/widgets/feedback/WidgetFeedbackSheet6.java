package com.discord.widgets.feedback;

import com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetFeedbackSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetViewModel;", "invoke", "()Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$viewModelStreamFeedbackSheet$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetFeedbackSheet6 extends Lambda implements Function0<StreamFeedbackSheetViewModel> {
    public final /* synthetic */ WidgetFeedbackSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFeedbackSheet6(WidgetFeedbackSheet widgetFeedbackSheet) {
        super(0);
        this.this$0 = widgetFeedbackSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StreamFeedbackSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StreamFeedbackSheetViewModel invoke() {
        String string = WidgetFeedbackSheet.access$getArgumentsOrDefault$p(this.this$0).getString(WidgetFeedbackSheet.ARG_STREAM_FEEDBACK_STREAM_KEY);
        if (string == null) {
            string = "";
        }
        String str = string;
        Intrinsics3.checkNotNullExpressionValue(str, "argumentsOrDefault.getSt…EEDBACK_STREAM_KEY) ?: \"\"");
        return new StreamFeedbackSheetViewModel(str, WidgetFeedbackSheet.access$getArgumentsOrDefault$p(this.this$0).getString(WidgetFeedbackSheet.ARG_STREAM_FEEDBACK_MEDIA_SESSION_ID), null, null, null, 28, null);
    }
}
