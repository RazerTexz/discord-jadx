package com.discord.widgets.announcements;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelFollowSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel;", "invoke", "()Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelFollowSheet3 extends Lambda implements Function0<WidgetChannelFollowSheetViewModel> {
    public final /* synthetic */ WidgetChannelFollowSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelFollowSheet3(WidgetChannelFollowSheet widgetChannelFollowSheet) {
        super(0);
        this.this$0 = widgetChannelFollowSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChannelFollowSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelFollowSheetViewModel invoke() {
        return new WidgetChannelFollowSheetViewModel(WidgetChannelFollowSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_GUILD_ID"), WidgetChannelFollowSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID"), null, null, null, 28, null);
    }
}
