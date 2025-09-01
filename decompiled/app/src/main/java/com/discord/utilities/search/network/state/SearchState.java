package com.discord.utilities.search.network.state;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.thread.ThreadMember;
import com.discord.models.message.Message;
import com.discord.utilities.search.network.SearchQuery;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SearchState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0013¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015Jp\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b2\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\"\u0010\u0015J\u001a\u0010$\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\u0007R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\u0004R!\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010*\u001a\u0004\b+\u0010\u000bR!\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b,\u0010\u000bR\u0019\u0010\u001b\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b.\u0010\u0012R!\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b/\u0010\u000bR\u0019\u0010\u001c\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00100\u001a\u0004\b1\u0010\u0015¨\u00064"}, d2 = {"Lcom/discord/utilities/search/network/state/SearchState;", "", "Lcom/discord/utilities/search/network/state/QueryFetchState;", "component1", "()Lcom/discord/utilities/search/network/state/QueryFetchState;", "Lcom/discord/utilities/search/network/SearchQuery;", "component2", "()Lcom/discord/utilities/search/network/SearchQuery;", "", "Lcom/discord/api/channel/Channel;", "component3", "()Ljava/util/List;", "Lcom/discord/api/thread/ThreadMember;", "component4", "Lcom/discord/models/message/Message;", "component5", "", "component6", "()Z", "", "component7", "()I", "queryFetchState", "searchQuery", "threads", "threadMembers", "hits", "hasMore", "totalResults", "copy", "(Lcom/discord/utilities/search/network/state/QueryFetchState;Lcom/discord/utilities/search/network/SearchQuery;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZI)Lcom/discord/utilities/search/network/state/SearchState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/search/network/SearchQuery;", "getSearchQuery", "Lcom/discord/utilities/search/network/state/QueryFetchState;", "getQueryFetchState", "Ljava/util/List;", "getHits", "getThreadMembers", "Z", "getHasMore", "getThreads", "I", "getTotalResults", "<init>", "(Lcom/discord/utilities/search/network/state/QueryFetchState;Lcom/discord/utilities/search/network/SearchQuery;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZI)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class SearchState {
    private final boolean hasMore;
    private final List<Message> hits;
    private final QueryFetchState queryFetchState;
    private final SearchQuery searchQuery;
    private final List<ThreadMember> threadMembers;
    private final List<Channel> threads;
    private final int totalResults;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchState(QueryFetchState queryFetchState, SearchQuery searchQuery, List<Channel> list, List<? extends ThreadMember> list2, List<Message> list3, boolean z2, int i) {
        Intrinsics3.checkNotNullParameter(queryFetchState, "queryFetchState");
        this.queryFetchState = queryFetchState;
        this.searchQuery = searchQuery;
        this.threads = list;
        this.threadMembers = list2;
        this.hits = list3;
        this.hasMore = z2;
        this.totalResults = i;
    }

    public static /* synthetic */ SearchState copy$default(SearchState searchState, QueryFetchState queryFetchState, SearchQuery searchQuery, List list, List list2, List list3, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            queryFetchState = searchState.queryFetchState;
        }
        if ((i2 & 2) != 0) {
            searchQuery = searchState.searchQuery;
        }
        SearchQuery searchQuery2 = searchQuery;
        if ((i2 & 4) != 0) {
            list = searchState.threads;
        }
        List list4 = list;
        if ((i2 & 8) != 0) {
            list2 = searchState.threadMembers;
        }
        List list5 = list2;
        if ((i2 & 16) != 0) {
            list3 = searchState.hits;
        }
        List list6 = list3;
        if ((i2 & 32) != 0) {
            z2 = searchState.hasMore;
        }
        boolean z3 = z2;
        if ((i2 & 64) != 0) {
            i = searchState.totalResults;
        }
        return searchState.copy(queryFetchState, searchQuery2, list4, list5, list6, z3, i);
    }

    /* renamed from: component1, reason: from getter */
    public final QueryFetchState getQueryFetchState() {
        return this.queryFetchState;
    }

    /* renamed from: component2, reason: from getter */
    public final SearchQuery getSearchQuery() {
        return this.searchQuery;
    }

    public final List<Channel> component3() {
        return this.threads;
    }

    public final List<ThreadMember> component4() {
        return this.threadMembers;
    }

    public final List<Message> component5() {
        return this.hits;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* renamed from: component7, reason: from getter */
    public final int getTotalResults() {
        return this.totalResults;
    }

    public final SearchState copy(QueryFetchState queryFetchState, SearchQuery searchQuery, List<Channel> threads, List<? extends ThreadMember> threadMembers, List<Message> hits, boolean hasMore, int totalResults) {
        Intrinsics3.checkNotNullParameter(queryFetchState, "queryFetchState");
        return new SearchState(queryFetchState, searchQuery, threads, threadMembers, hits, hasMore, totalResults);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchState)) {
            return false;
        }
        SearchState searchState = (SearchState) other;
        return Intrinsics3.areEqual(this.queryFetchState, searchState.queryFetchState) && Intrinsics3.areEqual(this.searchQuery, searchState.searchQuery) && Intrinsics3.areEqual(this.threads, searchState.threads) && Intrinsics3.areEqual(this.threadMembers, searchState.threadMembers) && Intrinsics3.areEqual(this.hits, searchState.hits) && this.hasMore == searchState.hasMore && this.totalResults == searchState.totalResults;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<Message> getHits() {
        return this.hits;
    }

    public final QueryFetchState getQueryFetchState() {
        return this.queryFetchState;
    }

    public final SearchQuery getSearchQuery() {
        return this.searchQuery;
    }

    public final List<ThreadMember> getThreadMembers() {
        return this.threadMembers;
    }

    public final List<Channel> getThreads() {
        return this.threads;
    }

    public final int getTotalResults() {
        return this.totalResults;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        QueryFetchState queryFetchState = this.queryFetchState;
        int iHashCode = (queryFetchState != null ? queryFetchState.hashCode() : 0) * 31;
        SearchQuery searchQuery = this.searchQuery;
        int iHashCode2 = (iHashCode + (searchQuery != null ? searchQuery.hashCode() : 0)) * 31;
        List<Channel> list = this.threads;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<ThreadMember> list2 = this.threadMembers;
        int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Message> list3 = this.hits;
        int iHashCode5 = (iHashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31;
        boolean z2 = this.hasMore;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return ((iHashCode5 + i) * 31) + this.totalResults;
    }

    public String toString() {
        StringBuilder sbU = outline.U("SearchState(queryFetchState=");
        sbU.append(this.queryFetchState);
        sbU.append(", searchQuery=");
        sbU.append(this.searchQuery);
        sbU.append(", threads=");
        sbU.append(this.threads);
        sbU.append(", threadMembers=");
        sbU.append(this.threadMembers);
        sbU.append(", hits=");
        sbU.append(this.hits);
        sbU.append(", hasMore=");
        sbU.append(this.hasMore);
        sbU.append(", totalResults=");
        return outline.B(sbU, this.totalResults, ")");
    }

    public /* synthetic */ SearchState(QueryFetchState queryFetchState, SearchQuery searchQuery, List list, List list2, List list3, boolean z2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(queryFetchState, (i2 & 2) != 0 ? null : searchQuery, (i2 & 4) != 0 ? null : list, (i2 & 8) != 0 ? null : list2, (i2 & 16) == 0 ? list3 : null, (i2 & 32) != 0 ? false : z2, (i2 & 64) == 0 ? i : 0);
    }
}
