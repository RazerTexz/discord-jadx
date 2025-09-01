package com.discord.widgets.channels.list;

import android.view.View;
import b.d.b.a.outline;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemInvite;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import kotlin.Metadata;

/* compiled from: WidgetChannelsListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemInvite$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ ChannelListItem $data;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemInvite this$0;

    public WidgetChannelsListAdapter$ItemInvite$onConfigure$1(WidgetChannelsListAdapter.ItemInvite itemInvite, ChannelListItem channelListItem) {
        this.this$0 = itemInvite;
        this.$data = channelListItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteShare.Companion.launch$default(WidgetGuildInviteShare.INSTANCE, outline.x(view, "it", "it.context"), WidgetChannelsListAdapter.access$getFragmentManager$p(WidgetChannelsListAdapter.ItemInvite.access$getAdapter$p(this.this$0)), ((ChannelListItemInvite) this.$data).getGuildId(), null, false, null, null, "Directory", 120, null);
    }
}
