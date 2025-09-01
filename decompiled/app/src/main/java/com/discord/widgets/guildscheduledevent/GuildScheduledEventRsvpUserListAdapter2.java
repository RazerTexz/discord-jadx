package com.discord.widgets.guildscheduledevent;

import android.view.View;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventRsvpUserListAdapter;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventRsvpUserListItem;
import kotlin.Metadata;

/* compiled from: GuildScheduledEventRsvpUserListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventRsvpUserListAdapter$UserViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildScheduledEventRsvpUserListAdapter2 implements View.OnClickListener {
    public final /* synthetic */ GuildScheduledEventRsvpUserListItem.RsvpUser $item;
    public final /* synthetic */ GuildScheduledEventRsvpUserListAdapter.UserViewHolder this$0;

    public GuildScheduledEventRsvpUserListAdapter2(GuildScheduledEventRsvpUserListAdapter.UserViewHolder userViewHolder, GuildScheduledEventRsvpUserListItem.RsvpUser rsvpUser) {
        this.this$0 = userViewHolder;
        this.$item = rsvpUser;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventRsvpUserListAdapter.access$getOnItemClick$p(GuildScheduledEventRsvpUserListAdapter.this).invoke(Long.valueOf(this.$item.getUserId()));
    }
}
