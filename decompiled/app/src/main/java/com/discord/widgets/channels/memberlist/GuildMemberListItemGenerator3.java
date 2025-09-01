package com.discord.widgets.channels.memberlist;

import b.d.b.a.outline;
import com.discord.utilities.collections.SparseMutableList;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import d0.z.d.Intrinsics3;
import java.util.Set;
import java.util.SortedMap;
import kotlin.Metadata;

/* compiled from: GuildMemberListItemGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B=\u0012\n\u0010\u0016\u001a\u00060\bj\u0002`\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b)\u0010*J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÂ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÂ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0012\u001a\u00060\bj\u0002`\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015JN\u0010\u001a\u001a\u00020\u00002\f\b\u0002\u0010\u0016\u001a\u00060\bj\u0002`\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00072\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0013J\u0010\u0010\u001d\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0015J\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0017\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b$\u0010\u0015R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010%R \u0010\u0016\u001a\u00060\bj\u0002`\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010(¨\u0006+"}, d2 = {"Lcom/discord/widgets/channels/memberlist/GuildMemberListItems;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "Lcom/discord/utilities/collections/SparseMutableList;", "Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item;", "component3", "()Lcom/discord/utilities/collections/SparseMutableList;", "Ljava/util/SortedMap;", "", "", "component4", "()Ljava/util/SortedMap;", "index", "get", "(I)Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item;", "itemPosition", "getHeaderPositionForItem", "(I)Ljava/lang/Integer;", "Lcom/discord/primitives/MemberListId;", "component1", "()Ljava/lang/String;", "component2", "()I", "listId", "size", "listItems", "groupIndices", "copy", "(Ljava/lang/String;ILcom/discord/utilities/collections/SparseMutableList;Ljava/util/SortedMap;)Lcom/discord/widgets/channels/memberlist/GuildMemberListItems;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getSize", "Ljava/util/SortedMap;", "Ljava/lang/String;", "getListId", "Lcom/discord/utilities/collections/SparseMutableList;", "<init>", "(Ljava/lang/String;ILcom/discord/utilities/collections/SparseMutableList;Ljava/util/SortedMap;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.memberlist.GuildMemberListItems, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class GuildMemberListItemGenerator3 implements WidgetChannelMembersListViewModel.MemberList {
    private final SortedMap<Integer, String> groupIndices;
    private final String listId;
    private final SparseMutableList<ChannelMembersListAdapter.Item> listItems;
    private final int size;

    public GuildMemberListItemGenerator3(String str, int i, SparseMutableList<ChannelMembersListAdapter.Item> sparseMutableList, SortedMap<Integer, String> sortedMap) {
        Intrinsics3.checkNotNullParameter(str, "listId");
        Intrinsics3.checkNotNullParameter(sparseMutableList, "listItems");
        Intrinsics3.checkNotNullParameter(sortedMap, "groupIndices");
        this.listId = str;
        this.size = i;
        this.listItems = sparseMutableList;
        this.groupIndices = sortedMap;
    }

    private final SparseMutableList<ChannelMembersListAdapter.Item> component3() {
        return this.listItems;
    }

    private final SortedMap<Integer, String> component4() {
        return this.groupIndices;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildMemberListItemGenerator3 copy$default(GuildMemberListItemGenerator3 guildMemberListItemGenerator3, String str, int i, SparseMutableList sparseMutableList, SortedMap sortedMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = guildMemberListItemGenerator3.getListId();
        }
        if ((i2 & 2) != 0) {
            i = guildMemberListItemGenerator3.getSize();
        }
        if ((i2 & 4) != 0) {
            sparseMutableList = guildMemberListItemGenerator3.listItems;
        }
        if ((i2 & 8) != 0) {
            sortedMap = guildMemberListItemGenerator3.groupIndices;
        }
        return guildMemberListItemGenerator3.copy(str, i, sparseMutableList, sortedMap);
    }

    public final String component1() {
        return getListId();
    }

    public final int component2() {
        return getSize();
    }

    public final GuildMemberListItemGenerator3 copy(String listId, int size, SparseMutableList<ChannelMembersListAdapter.Item> listItems, SortedMap<Integer, String> groupIndices) {
        Intrinsics3.checkNotNullParameter(listId, "listId");
        Intrinsics3.checkNotNullParameter(listItems, "listItems");
        Intrinsics3.checkNotNullParameter(groupIndices, "groupIndices");
        return new GuildMemberListItemGenerator3(listId, size, listItems, groupIndices);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMemberListItemGenerator3)) {
            return false;
        }
        GuildMemberListItemGenerator3 guildMemberListItemGenerator3 = (GuildMemberListItemGenerator3) other;
        return Intrinsics3.areEqual(getListId(), guildMemberListItemGenerator3.getListId()) && getSize() == guildMemberListItemGenerator3.getSize() && Intrinsics3.areEqual(this.listItems, guildMemberListItemGenerator3.listItems) && Intrinsics3.areEqual(this.groupIndices, guildMemberListItemGenerator3.groupIndices);
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public ChannelMembersListAdapter.Item get(int index) {
        ChannelMembersListAdapter.Item item = this.listItems.get(index);
        return item != null ? item : (ChannelMembersListAdapter.Item) GuildMemberListItemGenerator.access$getPLACEHOLDER_INSTANCES$p().get(index % GuildMemberListItemGenerator.access$getPLACEHOLDER_INSTANCES$p().size());
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public Integer getHeaderPositionForItem(int itemPosition) {
        Set<Integer> setKeySet = this.groupIndices.keySet();
        Intrinsics3.checkNotNullExpressionValue(setKeySet, "groupIndices.keys");
        Object obj = null;
        for (Object obj2 : setKeySet) {
            if (((Integer) obj2).intValue() < itemPosition + 1) {
                obj = obj2;
            }
        }
        return (Integer) obj;
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public String getListId() {
        return this.listId;
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.MemberList
    public int getSize() {
        return this.size;
    }

    public int hashCode() {
        String listId = getListId();
        int size = (getSize() + ((listId != null ? listId.hashCode() : 0) * 31)) * 31;
        SparseMutableList<ChannelMembersListAdapter.Item> sparseMutableList = this.listItems;
        int iHashCode = (size + (sparseMutableList != null ? sparseMutableList.hashCode() : 0)) * 31;
        SortedMap<Integer, String> sortedMap = this.groupIndices;
        return iHashCode + (sortedMap != null ? sortedMap.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildMemberListItems(listId=");
        sbU.append(getListId());
        sbU.append(", size=");
        sbU.append(getSize());
        sbU.append(", listItems=");
        sbU.append(this.listItems);
        sbU.append(", groupIndices=");
        sbU.append(this.groupIndices);
        sbU.append(")");
        return sbU.toString();
    }
}
