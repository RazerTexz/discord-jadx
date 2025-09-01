package com.discord.utilities.lazy.memberlist;

import com.discord.utilities.collections.SparseMutableList;
import d0.z.d.Intrinsics3;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ThreadMemberList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0010\u001a\u001a\u00060\u0004j\u0002`\u0019\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001a\u001a\u00060\u0004j\u0002`\u00198\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/discord/utilities/lazy/memberlist/ThreadMemberList;", "Lcom/discord/utilities/lazy/memberlist/MemberList;", "Ljava/util/SortedMap;", "", "", "getGroupIndices", "()Ljava/util/SortedMap;", "Lcom/discord/utilities/collections/SparseMutableList;", "Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "getRows", "()Lcom/discord/utilities/collections/SparseMutableList;", "row", "", "add", "(Lcom/discord/utilities/lazy/memberlist/MemberListRow;)V", "rows", "Lcom/discord/utilities/collections/SparseMutableList;", "getSize", "()I", "size", "initialSize", "I", "getInitialSize", "groupIndices", "Ljava/util/SortedMap;", "Lcom/discord/primitives/MemberListId;", "listId", "Ljava/lang/String;", "getListId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ThreadMemberList implements MemberList {
    private SortedMap<Integer, String> groupIndices;
    private final int initialSize;
    private final String listId;
    private SparseMutableList<MemberListRow> rows;

    public ThreadMemberList(String str, int i) {
        Intrinsics3.checkNotNullParameter(str, "listId");
        this.listId = str;
        this.initialSize = i;
        this.rows = new SparseMutableList<>(getInitialSize(), 100);
        this.groupIndices = new TreeMap();
    }

    public final void add(MemberListRow row) {
        this.rows.add(row);
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

    public /* synthetic */ ThreadMemberList(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i);
    }
}
