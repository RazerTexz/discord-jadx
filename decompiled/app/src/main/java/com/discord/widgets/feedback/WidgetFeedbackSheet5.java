package com.discord.widgets.feedback;

import com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSheetViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetFeedbackSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guild_delete_feedback/GuildDeleteFeedbackSheetViewModel;", "invoke", "()Lcom/discord/widgets/guild_delete_feedback/GuildDeleteFeedbackSheetViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$viewModelGuildDeleteFeedbackSheet$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetFeedbackSheet5 extends Lambda implements Function0<GuildDeleteFeedbackSheetViewModel> {
    public final /* synthetic */ WidgetFeedbackSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFeedbackSheet5(WidgetFeedbackSheet widgetFeedbackSheet) {
        super(0);
        this.this$0 = widgetFeedbackSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildDeleteFeedbackSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildDeleteFeedbackSheetViewModel invoke() {
        return new GuildDeleteFeedbackSheetViewModel(WidgetFeedbackSheet.access$getArgumentsOrDefault$p(this.this$0).getLong(WidgetFeedbackSheet.ARG_GUILD_DELETE_FEEDBACK_GUILD_ID));
    }
}
