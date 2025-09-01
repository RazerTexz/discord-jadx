package com.discord.widgets.channels.memberlist;

import b.d.b.a.outline;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: PrivateChannelMemberListItemGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\n\u0010\u0011\u001a\u00060\rj\u0002`\u000e\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\"\u0010#J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÂ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u000f\u001a\u00060\rj\u0002`\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J.\u0010\u0013\u001a\u00020\u00002\f\b\u0002\u0010\u0011\u001a\u00060\rj\u0002`\u000e2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0010J\u0010\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u0011\u001a\u00060\rj\u0002`\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u0010R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001fR\u0016\u0010!\u001a\u00020\u00068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0017¨\u0006$"}, d2 = {"Lcom/discord/widgets/channels/memberlist/PrivateChannelMemberListItems;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "", "Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item;", "component2", "()Ljava/util/List;", "", "index", "get", "(I)Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item;", "itemPosition", "getHeaderPositionForItem", "(I)Ljava/lang/Integer;", "", "Lcom/discord/primitives/MemberListId;", "component1", "()Ljava/lang/String;", "listId", "listItems", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/discord/widgets/channels/memberlist/PrivateChannelMemberListItems;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getListId", "Ljava/util/List;", "getSize", "size", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListItems, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class PrivateChannelMemberListItemGenerator4 implements WidgetChannelMembersListViewModel.MemberList {
    private final String listId;
    private final List<ChannelMembersListAdapter.Item> listItems;

    /* JADX WARN: Multi-variable type inference failed */
    public PrivateChannelMemberListItemGenerator4(String str, List<? extends ChannelMembersListAdapter.Item> list) {
        Intrinsics3.checkNotNullParameter(str, "listId");
        Intrinsics3.checkNotNullParameter(list, "listItems");
        this.listId = str;
        this.listItems = list;
    }

    private final List<ChannelMembersListAdapter.Item> component2() {
        return this.listItems;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PrivateChannelMemberListItemGenerator4 copy$default(PrivateChannelMemberListItemGenerator4 privateChannelMemberListItemGenerator4, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = privateChannelMemberListItemGenerator4.getListId();
        }
        if ((i & 2) != 0) {
            list = privateChannelMemberListItemGenerator4.listItems;
        }
        return privateChannelMemberListItemGenerator4.copy(str, list);
    }

    public final String component1() {
        return getListId();
    }

    public final PrivateChannelMemberListItemGenerator4 copy(String listId, List<? extends ChannelMembersListAdapter.Item> listItems) {
        Intrinsics3.checkNotNullParameter(listId, "listId");
        Intrinsics3.checkNotNullParameter(listItems, "listItems");
        return new PrivateChannelMemberListItemGenerator4(listId, listItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrivateChannelMemberListItemGenerator4)) {
            return false;
        }
        PrivateChannelMemberListItemGenerator4 privateChannelMemberListItemGenerator4 = (PrivateChannelMemberListItemGenerator4) other;
        return Intrinsics3.areEqual(getListId(), privateChannelMemberListItemGenerator4.getListId()) && Intrinsics3.areEqual(this.listItems, privateChannelMemberListItemGenerator4.listItems);
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public ChannelMembersListAdapter.Item get(int index) {
        return this.listItems.get(index);
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
        return this.listItems.size();
    }

    public int hashCode() {
        String listId = getListId();
        int iHashCode = (listId != null ? listId.hashCode() : 0) * 31;
        List<ChannelMembersListAdapter.Item> list = this.listItems;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PrivateChannelMemberListItems(listId=");
        sbU.append(getListId());
        sbU.append(", listItems=");
        return outline.L(sbU, this.listItems, ")");
    }
}
