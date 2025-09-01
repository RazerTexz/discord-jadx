package com.discord.widgets.channels.memberlist;

import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import kotlin.Metadata;

/* compiled from: WidgetChannelMembersListViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"com/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList$Companion$EMPTY$1", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "", "index", "Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item;", "get", "(I)Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item;", "itemPosition", "getHeaderPositionForItem", "(I)Ljava/lang/Integer;", "", "listId", "Ljava/lang/String;", "getListId", "()Ljava/lang/String;", "size", "I", "getSize", "()I", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$MemberList$Companion$EMPTY$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel4 implements WidgetChannelMembersListViewModel.MemberList {
    private final String listId = "";
    private final int size;

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public ChannelMembersListAdapter.Item get(int index) {
        throw new IllegalStateException("");
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public Integer getHeaderPositionForItem(int itemPosition) {
        return 0;
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public String getListId() {
        return this.listId;
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public int getSize() {
        return this.size;
    }
}
