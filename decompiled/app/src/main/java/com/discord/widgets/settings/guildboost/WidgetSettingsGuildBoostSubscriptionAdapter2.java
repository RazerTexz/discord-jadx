package com.discord.widgets.settings.guildboost;

import android.view.View;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$onConfigure$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter2 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter.Item $data;
    public final /* synthetic */ boolean $hasCooldown;
    public final /* synthetic */ boolean $isActiveGuildBoost;
    public final /* synthetic */ ModelGuildBoostSlot $slot;
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem this$0;

    public WidgetSettingsGuildBoostSubscriptionAdapter2(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem guildBoostListItem, boolean z2, boolean z3, WidgetSettingsGuildBoostSubscriptionAdapter.Item item, ModelGuildBoostSlot modelGuildBoostSlot) {
        this.this$0 = guildBoostListItem;
        this.$isActiveGuildBoost = z2;
        this.$hasCooldown = z3;
        this.$data = item;
        this.$slot = modelGuildBoostSlot;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!this.$isActiveGuildBoost && !this.$hasCooldown) {
            WidgetSettingsGuildBoostSubscriptionAdapter.access$getSubscribeListener$p(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0)).invoke(Long.valueOf(this.$slot.getId()));
            return;
        }
        WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem guildBoostListItem = this.this$0;
        Intrinsics3.checkNotNullExpressionValue(view, "view");
        WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$showGuildBoostPopup(guildBoostListItem, view, this.$hasCooldown, WidgetSettingsGuildBoostSubscriptionAdapter.access$getCanCancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0)), WidgetSettingsGuildBoostSubscriptionAdapter.access$getCanUncancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0)), (WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem) this.$data);
    }
}
