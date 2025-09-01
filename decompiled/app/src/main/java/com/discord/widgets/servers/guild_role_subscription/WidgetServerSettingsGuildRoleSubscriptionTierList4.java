package com.discord.widgets.servers.guild_role_subscription;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetServerSettingsGuildRoleSubscriptionTierList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel;", "invoke", "()Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptionTierList$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionTierList4 extends Lambda implements Function0<ServerSettingsGuildRoleSubscriptionTierListViewModel> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionTierList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptionTierList4(WidgetServerSettingsGuildRoleSubscriptionTierList widgetServerSettingsGuildRoleSubscriptionTierList) {
        super(0);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionTierList;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ServerSettingsGuildRoleSubscriptionTierListViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsGuildRoleSubscriptionTierListViewModel invoke() {
        return new ServerSettingsGuildRoleSubscriptionTierListViewModel(WidgetServerSettingsGuildRoleSubscriptionTierList.access$getGuildId$p(this.this$0), null, null, null, 14, null);
    }
}
