package com.discord.widgets.guilds.invite;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildInviteSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel;", "invoke", "()Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteSettings6 extends Lambda implements Function0<GuildInviteSettingsViewModel> {
    public final /* synthetic */ WidgetGuildInviteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteSettings6(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        super(0);
        this.this$0 = widgetGuildInviteSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildInviteSettingsViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildInviteSettingsViewModel invoke() {
        long longExtra = this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L);
        return new GuildInviteSettingsViewModel(longExtra != 0 ? Long.valueOf(longExtra) : null, this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", 0L), null, null, null, 28, null);
    }
}
