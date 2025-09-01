package com.discord.widgets.servers.guildboost;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildBoostTransfer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel;", "invoke", "()Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildBoostTransfer3 extends Lambda implements Function0<GuildBoostTransferInProgressViewModel> {
    public final /* synthetic */ WidgetGuildBoostTransfer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildBoostTransfer3(WidgetGuildBoostTransfer widgetGuildBoostTransfer) {
        super(0);
        this.this$0 = widgetGuildBoostTransfer;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildBoostTransferInProgressViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildBoostTransferInProgressViewModel invoke() {
        return new GuildBoostTransferInProgressViewModel(this.this$0.getMostRecentIntent().getLongExtra("SLOT_ID", -1L), this.this$0.getMostRecentIntent().getLongExtra("SUBSCRIPTION_ID", -1L), this.this$0.getMostRecentIntent().getLongExtra("PREVIOUS_GUILD_ID", -1L), this.this$0.getMostRecentIntent().getLongExtra("TARGET_GUILD_ID", -1L), null, null, null, 112, null);
    }
}
