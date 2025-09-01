package com.discord.widgets.channels.list;

import android.view.View;
import b.d.b.a.outline;
import com.discord.widgets.channels.WidgetCreateChannel;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import com.discord.widgets.channels.list.items.ChannelListItemCategory;
import kotlin.Metadata;

/* compiled from: WidgetChannelsListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$4 implements View.OnClickListener {
    public final /* synthetic */ ChannelListItemCategory $item;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemChannelCategory this$0;

    public WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$4(WidgetChannelsListAdapter.ItemChannelCategory itemChannelCategory, ChannelListItemCategory channelListItemCategory) {
        this.this$0 = itemChannelCategory;
        this.$item = channelListItemCategory;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetCreateChannel.INSTANCE.show(outline.x(this.this$0.itemView, "itemView", "itemView.context"), this.$item.getChannel().getGuildId(), 0, Long.valueOf(this.$item.getChannel().getId()));
    }
}
