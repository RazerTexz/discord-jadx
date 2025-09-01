package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$guildRoleSubscriptionGroupListingId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier5 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptionEditTier5(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        super(0);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionEditTier;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_GROUP_LISTING_ID", -1L);
    }
}
