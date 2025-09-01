package com.discord.widgets.settings.guildboost;

import android.view.MenuItem;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter;
import kotlin.Metadata;

/* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "it", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$showGuildBoostPopup$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter5 implements MenuItem.OnMenuItemClickListener {
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem $data;
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem this$0;

    public WidgetSettingsGuildBoostSubscriptionAdapter5(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem guildBoostListItem, WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem guildBoostItem) {
        this.this$0 = guildBoostListItem;
        this.$data = guildBoostItem;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        WidgetSettingsGuildBoostSubscriptionAdapter.access$getCancelListener$p(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0)).invoke(Long.valueOf(this.$data.getBoostSlot().getId()), Boolean.FALSE);
        return true;
    }
}
