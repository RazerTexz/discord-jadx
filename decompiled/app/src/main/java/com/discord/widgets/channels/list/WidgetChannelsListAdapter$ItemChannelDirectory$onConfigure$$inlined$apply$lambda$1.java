package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import com.discord.widgets.channels.list.items.ChannelListItemDirectory;
import kotlin.Metadata;

/* compiled from: WidgetChannelsListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/channels/list/WidgetChannelsListAdapter$ItemChannelDirectory$onConfigure$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelDirectory$onConfigure$$inlined$apply$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ ChannelListItemDirectory $item$inlined;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemChannelDirectory this$0;

    public WidgetChannelsListAdapter$ItemChannelDirectory$onConfigure$$inlined$apply$lambda$1(WidgetChannelsListAdapter.ItemChannelDirectory itemChannelDirectory, ChannelListItemDirectory channelListItemDirectory) {
        this.this$0 = itemChannelDirectory;
        this.$item$inlined = channelListItemDirectory;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChannelsListAdapter.ItemChannelDirectory.access$getAdapter$p(this.this$0).getOnSelectChannel().invoke(this.$item$inlined.getChannel());
    }
}
