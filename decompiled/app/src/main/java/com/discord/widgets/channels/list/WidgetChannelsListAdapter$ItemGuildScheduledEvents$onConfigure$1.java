package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import com.discord.widgets.channels.list.items.ChannelListItemGuildScheduledEvents;
import kotlin.Metadata;

/* compiled from: WidgetChannelsListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemGuildScheduledEvents$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ ChannelListItemGuildScheduledEvents $item;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemGuildScheduledEvents this$0;

    public WidgetChannelsListAdapter$ItemGuildScheduledEvents$onConfigure$1(WidgetChannelsListAdapter.ItemGuildScheduledEvents itemGuildScheduledEvents, ChannelListItemGuildScheduledEvents channelListItemGuildScheduledEvents) {
        this.this$0 = itemGuildScheduledEvents;
        this.$item = channelListItemGuildScheduledEvents;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChannelsListAdapter.ItemGuildScheduledEvents.access$getAdapter$p(this.this$0).getOnViewGuildScheduledEvents().invoke(this.$item.getGuild());
    }
}
