package com.discord.utilities.lazy.memberlist;

import com.discord.utilities.collections.SparseMutableList;
import java.util.SortedMap;
import kotlin.Metadata;

/* compiled from: MemberList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H&¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\u00060\bj\u0002`\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/discord/utilities/lazy/memberlist/MemberList;", "", "Lcom/discord/utilities/collections/SparseMutableList;", "Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "getRows", "()Lcom/discord/utilities/collections/SparseMutableList;", "Ljava/util/SortedMap;", "", "", "getGroupIndices", "()Ljava/util/SortedMap;", "getInitialSize", "()I", "initialSize", "Lcom/discord/primitives/MemberListId;", "getListId", "()Ljava/lang/String;", "listId", "getSize", "size", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface MemberList {
    SortedMap<Integer, String> getGroupIndices();

    int getInitialSize();

    String getListId();

    SparseMutableList<MemberListRow> getRows();

    int getSize();
}
