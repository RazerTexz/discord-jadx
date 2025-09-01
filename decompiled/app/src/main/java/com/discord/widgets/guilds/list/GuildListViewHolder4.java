package com.discord.widgets.guilds.list;

import android.view.View;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.GuildListViewHolder;
import kotlin.Metadata;

/* compiled from: GuildListViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.list.GuildListViewHolder$FriendsViewHolder$configure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildListViewHolder4 implements View.OnClickListener {
    public final /* synthetic */ GuildListItem.FriendsItem $data;
    public final /* synthetic */ GuildListViewHolder.FriendsViewHolder this$0;

    public GuildListViewHolder4(GuildListViewHolder.FriendsViewHolder friendsViewHolder, GuildListItem.FriendsItem friendsItem) {
        this.this$0 = friendsViewHolder;
        this.$data = friendsItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildListViewHolder.FriendsViewHolder.access$getOnClicked$p(this.this$0).invoke(this.$data);
    }
}
