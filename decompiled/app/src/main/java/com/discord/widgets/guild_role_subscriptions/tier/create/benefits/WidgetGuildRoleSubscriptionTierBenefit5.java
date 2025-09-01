package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.app.AppFragment;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "", "channelName", "", "channelIconResId", "", "invoke", "(JLjava/lang/String;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$createChannelLauncher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit5 extends Lambda implements Function3<Long, String, Integer, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefit5(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        super(3);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Long l, String str, Integer num) {
        invoke(l.longValue(), str, num.intValue());
        return Unit.a;
    }

    public final void invoke(long j, String str, int i) {
        Intrinsics3.checkNotNullParameter(str, "channelName");
        WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(this.this$0).updateChannel(j, str, Integer.valueOf(i));
        AppFragment.hideKeyboard$default(this.this$0, null, 1, null);
    }
}
