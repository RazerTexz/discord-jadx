package com.discord.utilities.lazy.memberlist;

import androidx.annotation.VisibleForTesting;
import b.d.b.a.outline;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.utilities.collections.SparseMutableList;
import com.discord.utilities.lazy.memberlist.MemberListRow;
import com.discord.utilities.logging.Logger;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* compiled from: ChannelMemberList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\n\u00105\u001a\u00060\u0004j\u0002`4\u0012\b\b\u0002\u00109\u001a\u00020\u0003\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<¢\u0006\u0004\b?\u0010@B\u0011\b\u0016\u0012\u0006\u0010A\u001a\u00020\u0000¢\u0006\u0004\b?\u0010BJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0014\u0010\u0011J\u0015\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u001f\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0004\b\u001f\u0010 J'\u0010$\u001a\u00020\u000b2\u0018\u0010#\u001a\u0014\u0012\b\u0012\u00060!j\u0002`\"\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001d¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0&H\u0016¢\u0006\u0004\b'\u0010(J#\u0010*\u001a\u00020\u000b2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007¢\u0006\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\"\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010/R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\t0&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u00103R \u00105\u001a\u00060\u0004j\u0002`48\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001c\u00109\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010-R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006C"}, d2 = {"Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;", "Lcom/discord/utilities/lazy/memberlist/MemberList;", "Ljava/util/SortedMap;", "", "", "getGroupIndices", "()Ljava/util/SortedMap;", "startIndex", "", "Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "items", "", "sync", "(ILjava/util/List;)V", "index", "item", "insert", "(ILcom/discord/utilities/lazy/memberlist/MemberListRow;)V", "add", "(Lcom/discord/utilities/lazy/memberlist/MemberListRow;)V", "update", "delete", "(I)V", "Lkotlin/ranges/IntRange;", "range", "invalidate", "(Lkotlin/ranges/IntRange;)V", "Lcom/discord/models/domain/ModelGuildMemberListUpdate$Group;", "groups", "Lkotlin/Function1;", "makeGroup", "setGroups", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "", "Lcom/discord/primitives/UserId;", "makeMember", "rebuildMembers", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/utilities/collections/SparseMutableList;", "getRows", "()Lcom/discord/utilities/collections/SparseMutableList;", "groupIndices", "setGroupIndices", "(Ljava/util/SortedMap;)V", "getSize", "()I", "size", "Ljava/util/SortedMap;", "rows", "Lcom/discord/utilities/collections/SparseMutableList;", "", "Ljava/util/Map;", "Lcom/discord/primitives/MemberListId;", "listId", "Ljava/lang/String;", "getListId", "()Ljava/lang/String;", "initialSize", "I", "getInitialSize", "Lcom/discord/utilities/logging/Logger;", "logger", "Lcom/discord/utilities/logging/Logger;", "<init>", "(Ljava/lang/String;ILcom/discord/utilities/logging/Logger;)V", "other", "(Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelMemberList implements MemberList {
    private SortedMap<Integer, String> groupIndices;
    private Map<String, ? extends MemberListRow> groups;
    private final int initialSize;
    private final String listId;
    private final Logger logger;
    private SparseMutableList<MemberListRow> rows;

    public ChannelMemberList(String str, int i, Logger logger) {
        Intrinsics3.checkNotNullParameter(str, "listId");
        this.listId = str;
        this.initialSize = i;
        this.logger = logger;
        this.rows = new SparseMutableList<>(getInitialSize(), 100);
        this.groups = Maps6.emptyMap();
        this.groupIndices = new TreeMap();
    }

    public final void add(MemberListRow item) {
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbU = outline.U("memberListId: ");
            sbU.append(getListId());
            sbU.append(" ADD");
            logger.recordBreadcrumb(sbU.toString(), "ChannelMemberList");
        }
        this.rows.add(item);
    }

    public final void delete(int index) {
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbU = outline.U("memberListId: ");
            sbU.append(getListId());
            sbU.append(" DELETE index: ");
            sbU.append(index);
            logger.recordBreadcrumb(sbU.toString(), "ChannelMemberList");
        }
        this.rows.remove(index);
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberList
    public SortedMap<Integer, String> getGroupIndices() {
        return this.groupIndices;
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberList
    public int getInitialSize() {
        return this.initialSize;
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberList
    public String getListId() {
        return this.listId;
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberList
    public SparseMutableList<MemberListRow> getRows() {
        return this.rows;
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberList
    public int getSize() {
        return this.rows.size();
    }

    public final void insert(int index, MemberListRow item) {
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbU = outline.U("memberListId: ");
            sbU.append(getListId());
            sbU.append(" INSERT: index: ");
            sbU.append(index);
            logger.recordBreadcrumb(sbU.toString(), "ChannelMemberList");
        }
        this.rows.add(index, item);
    }

    public final void invalidate(Ranges2 range) {
        Intrinsics3.checkNotNullParameter(range, "range");
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbU = outline.U("memberListId: ");
            sbU.append(getListId());
            sbU.append(" INVALIDATE range: ");
            sbU.append(range);
            logger.recordBreadcrumb(sbU.toString(), "ChannelMemberList");
        }
        int iMin = Math.min(range.getLast(), Collections2.getLastIndex(this.rows));
        int first = range.getFirst();
        if (first > iMin) {
            return;
        }
        while (true) {
            this.rows.set(first, null);
            if (first == iMin) {
                return;
            } else {
                first++;
            }
        }
    }

    public final void rebuildMembers(Function1<? super Long, ? extends MemberListRow> makeMember) {
        Intrinsics3.checkNotNullParameter(makeMember, "makeMember");
        int i = 0;
        for (MemberListRow memberListRow : this.rows) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            MemberListRow memberListRow2 = memberListRow;
            if (memberListRow2 instanceof MemberListRow.Member) {
                this.rows.set(i, makeMember.invoke(Long.valueOf(((MemberListRow.Member) memberListRow2).getUserId())));
            }
            i = i2;
        }
    }

    @VisibleForTesting
    public final void setGroupIndices(SortedMap<Integer, String> groupIndices) {
        Intrinsics3.checkNotNullParameter(groupIndices, "groupIndices");
        this.groupIndices = groupIndices;
    }

    public final void setGroups(List<ModelGuildMemberListUpdate.Group> groups, Function1<? super ModelGuildMemberListUpdate.Group, ? extends MemberListRow> makeGroup) {
        Intrinsics3.checkNotNullParameter(groups, "groups");
        Intrinsics3.checkNotNullParameter(makeGroup, "makeGroup");
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbU = outline.U("memberListId: ");
            sbU.append(getListId());
            sbU.append(" SET_GROUPS");
            logger.recordBreadcrumb(sbU.toString(), "ChannelMemberList");
        }
        this.groupIndices.clear();
        int count = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(groups, 10)), 16));
        for (ModelGuildMemberListUpdate.Group group : groups) {
            String id2 = group.getId();
            this.groupIndices.put(Integer.valueOf(count), group.getId());
            count += group.getCount() + 1;
            linkedHashMap.put(id2, makeGroup.invoke(group));
        }
        this.groups = linkedHashMap;
        this.rows.setSize(count);
    }

    public final void sync(int startIndex, List<? extends MemberListRow> items) {
        Intrinsics3.checkNotNullParameter(items, "items");
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbU = outline.U("memberListId: ");
            sbU.append(getListId());
            sbU.append(" SYNC: startIndex: ");
            sbU.append(startIndex);
            sbU.append(" -- items size: ");
            sbU.append(items.size());
            logger.recordBreadcrumb(sbU.toString(), "ChannelMemberList");
        }
        int i = 0;
        for (Object obj : items) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            update(i + startIndex, (MemberListRow) obj);
            i = i2;
        }
    }

    public final void update(int index, MemberListRow item) {
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbU = outline.U("memberListId: ");
            sbU.append(getListId());
            sbU.append(" UPDATE index: ");
            sbU.append(index);
            logger.recordBreadcrumb(sbU.toString(), "ChannelMemberList");
        }
        this.rows.set(index, item);
    }

    public /* synthetic */ ChannelMemberList(String str, int i, Logger logger, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : logger);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChannelMemberList(ChannelMemberList channelMemberList) {
        this(channelMemberList.getListId(), 0, channelMemberList.logger, 2, null);
        Intrinsics3.checkNotNullParameter(channelMemberList, "other");
        this.rows = channelMemberList.rows.deepCopy();
        this.groups = new HashMap(channelMemberList.groups);
        this.groupIndices = new TreeMap((SortedMap) channelMemberList.groupIndices);
    }
}
