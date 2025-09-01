package com.discord.utilities.search.history;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.stores.StoreSearch;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.node.QueryNode;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: MGPreferenceSearchHistoryCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 J5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\fJ%\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00150\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\"\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/discord/utilities/search/history/MGPreferenceSearchHistoryCache;", "Lcom/discord/utilities/search/history/SearchHistoryCache;", "Ljava/util/LinkedList;", "Lcom/discord/utilities/search/history/MGPreferenceSearchHistoryCache$TargetHistory;", "Lcom/discord/stores/StoreSearch$SearchTarget;", "searchTarget", "", "Lcom/discord/utilities/search/query/node/QueryNode;", "query", "putAndCopy", "(Ljava/util/LinkedList;Lcom/discord/stores/StoreSearch$SearchTarget;Ljava/util/List;)Ljava/util/LinkedList;", "removeAndCopy", "(Ljava/util/LinkedList;Lcom/discord/stores/StoreSearch$SearchTarget;)Ljava/util/LinkedList;", "key", "find", "", "persistQuery", "(Lcom/discord/stores/StoreSearch$SearchTarget;Ljava/util/List;)V", "clear", "(Lcom/discord/stores/StoreSearch$SearchTarget;)V", "Lrx/Observable;", "", "getHistory", "(Lcom/discord/stores/StoreSearch$SearchTarget;)Lrx/Observable;", "", "MAX_QUERIES_PER_TARGET", "I", "MAX_SEARCH_TARGETS", "Lcom/discord/utilities/persister/Persister;", "backingCache", "Lcom/discord/utilities/persister/Persister;", "<init>", "()V", "TargetHistory", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MGPreferenceSearchHistoryCache implements SearchHistoryCache {
    private final int MAX_SEARCH_TARGETS = 10;
    private final int MAX_QUERIES_PER_TARGET = 5;
    private final Persister<LinkedList<TargetHistory>> backingCache = new Persister<>("SEARCH_HISTORY_V2", new LinkedList());

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R%\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/discord/utilities/search/history/MGPreferenceSearchHistoryCache$TargetHistory;", "", "Lcom/discord/stores/StoreSearch$SearchTarget;", "component1", "()Lcom/discord/stores/StoreSearch$SearchTarget;", "Ljava/util/LinkedList;", "", "Lcom/discord/utilities/search/query/node/QueryNode;", "component2", "()Ljava/util/LinkedList;", "searchTarget", "recentQueries", "copy", "(Lcom/discord/stores/StoreSearch$SearchTarget;Ljava/util/LinkedList;)Lcom/discord/utilities/search/history/MGPreferenceSearchHistoryCache$TargetHistory;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreSearch$SearchTarget;", "getSearchTarget", "Ljava/util/LinkedList;", "getRecentQueries", "<init>", "(Lcom/discord/stores/StoreSearch$SearchTarget;Ljava/util/LinkedList;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class TargetHistory {
        private final LinkedList<List<QueryNode>> recentQueries;
        private final StoreSearch.SearchTarget searchTarget;

        public TargetHistory(StoreSearch.SearchTarget searchTarget, LinkedList<List<QueryNode>> linkedList) {
            Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
            Intrinsics3.checkNotNullParameter(linkedList, "recentQueries");
            this.searchTarget = searchTarget;
            this.recentQueries = linkedList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TargetHistory copy$default(TargetHistory targetHistory, StoreSearch.SearchTarget searchTarget, LinkedList linkedList, int i, Object obj) {
            if ((i & 1) != 0) {
                searchTarget = targetHistory.searchTarget;
            }
            if ((i & 2) != 0) {
                linkedList = targetHistory.recentQueries;
            }
            return targetHistory.copy(searchTarget, linkedList);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreSearch.SearchTarget getSearchTarget() {
            return this.searchTarget;
        }

        public final LinkedList<List<QueryNode>> component2() {
            return this.recentQueries;
        }

        public final TargetHistory copy(StoreSearch.SearchTarget searchTarget, LinkedList<List<QueryNode>> recentQueries) {
            Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
            Intrinsics3.checkNotNullParameter(recentQueries, "recentQueries");
            return new TargetHistory(searchTarget, recentQueries);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TargetHistory)) {
                return false;
            }
            TargetHistory targetHistory = (TargetHistory) other;
            return Intrinsics3.areEqual(this.searchTarget, targetHistory.searchTarget) && Intrinsics3.areEqual(this.recentQueries, targetHistory.recentQueries);
        }

        public final LinkedList<List<QueryNode>> getRecentQueries() {
            return this.recentQueries;
        }

        public final StoreSearch.SearchTarget getSearchTarget() {
            return this.searchTarget;
        }

        public int hashCode() {
            StoreSearch.SearchTarget searchTarget = this.searchTarget;
            int iHashCode = (searchTarget != null ? searchTarget.hashCode() : 0) * 31;
            LinkedList<List<QueryNode>> linkedList = this.recentQueries;
            return iHashCode + (linkedList != null ? linkedList.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("TargetHistory(searchTarget=");
            sbU.append(this.searchTarget);
            sbU.append(", recentQueries=");
            sbU.append(this.recentQueries);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/util/LinkedList;", "Lcom/discord/utilities/search/history/MGPreferenceSearchHistoryCache$TargetHistory;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/util/LinkedList;)Ljava/util/LinkedList;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$clear$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<LinkedList<TargetHistory>, LinkedList<TargetHistory>> {
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        public AnonymousClass1(StoreSearch.SearchTarget searchTarget) {
            this.$searchTarget = searchTarget;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ LinkedList<TargetHistory> call(LinkedList<TargetHistory> linkedList) {
            return call2(linkedList);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final LinkedList<TargetHistory> call2(LinkedList<TargetHistory> linkedList) {
            MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = MGPreferenceSearchHistoryCache.this;
            Intrinsics3.checkNotNullExpressionValue(linkedList, "it");
            return MGPreferenceSearchHistoryCache.access$removeAndCopy(mGPreferenceSearchHistoryCache, linkedList, this.$searchTarget);
        }
    }

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/util/LinkedList;", "Lcom/discord/utilities/search/history/MGPreferenceSearchHistoryCache$TargetHistory;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/util/LinkedList;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$clear$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<LinkedList<TargetHistory>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LinkedList<TargetHistory> linkedList) {
            invoke2(linkedList);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LinkedList<TargetHistory> linkedList) {
            Persister persisterAccess$getBackingCache$p = MGPreferenceSearchHistoryCache.access$getBackingCache$p(MGPreferenceSearchHistoryCache.this);
            Intrinsics3.checkNotNullExpressionValue(linkedList, "it");
            Persister.set$default(persisterAccess$getBackingCache$p, linkedList, false, 2, null);
        }
    }

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005 \u0002*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Ljava/util/LinkedList;", "Lcom/discord/utilities/search/history/MGPreferenceSearchHistoryCache$TargetHistory;", "kotlin.jvm.PlatformType", "it", "", "", "Lcom/discord/utilities/search/query/node/QueryNode;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/LinkedList;)Ljava/util/Collection;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$getHistory$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<LinkedList<TargetHistory>, Collection<? extends List<? extends QueryNode>>> {
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        public AnonymousClass1(StoreSearch.SearchTarget searchTarget) {
            this.$searchTarget = searchTarget;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Collection<? extends List<? extends QueryNode>> call(LinkedList<TargetHistory> linkedList) {
            return call2(linkedList);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Collection<List<QueryNode>> call2(LinkedList<TargetHistory> linkedList) {
            MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = MGPreferenceSearchHistoryCache.this;
            Intrinsics3.checkNotNullExpressionValue(linkedList, "it");
            return MGPreferenceSearchHistoryCache.access$find(mGPreferenceSearchHistoryCache, linkedList, this.$searchTarget);
        }
    }

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/util/LinkedList;", "Lcom/discord/utilities/search/history/MGPreferenceSearchHistoryCache$TargetHistory;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/util/LinkedList;)Ljava/util/LinkedList;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$persistQuery$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<LinkedList<TargetHistory>, LinkedList<TargetHistory>> {
        public final /* synthetic */ List $query;
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        public AnonymousClass1(StoreSearch.SearchTarget searchTarget, List list) {
            this.$searchTarget = searchTarget;
            this.$query = list;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ LinkedList<TargetHistory> call(LinkedList<TargetHistory> linkedList) {
            return call2(linkedList);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final LinkedList<TargetHistory> call2(LinkedList<TargetHistory> linkedList) {
            MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = MGPreferenceSearchHistoryCache.this;
            Intrinsics3.checkNotNullExpressionValue(linkedList, "it");
            return MGPreferenceSearchHistoryCache.access$putAndCopy(mGPreferenceSearchHistoryCache, linkedList, this.$searchTarget, this.$query);
        }
    }

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/util/LinkedList;", "Lcom/discord/utilities/search/history/MGPreferenceSearchHistoryCache$TargetHistory;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/util/LinkedList;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$persistQuery$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<LinkedList<TargetHistory>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LinkedList<TargetHistory> linkedList) {
            invoke2(linkedList);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LinkedList<TargetHistory> linkedList) {
            Persister persisterAccess$getBackingCache$p = MGPreferenceSearchHistoryCache.access$getBackingCache$p(MGPreferenceSearchHistoryCache.this);
            Intrinsics3.checkNotNullExpressionValue(linkedList, "it");
            Persister.set$default(persisterAccess$getBackingCache$p, linkedList, false, 2, null);
        }
    }

    public static final /* synthetic */ LinkedList access$find(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache, LinkedList linkedList, StoreSearch.SearchTarget searchTarget) {
        return mGPreferenceSearchHistoryCache.find(linkedList, searchTarget);
    }

    public static final /* synthetic */ Persister access$getBackingCache$p(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache) {
        return mGPreferenceSearchHistoryCache.backingCache;
    }

    public static final /* synthetic */ LinkedList access$putAndCopy(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache, LinkedList linkedList, StoreSearch.SearchTarget searchTarget, List list) {
        return mGPreferenceSearchHistoryCache.putAndCopy(linkedList, searchTarget, list);
    }

    public static final /* synthetic */ LinkedList access$removeAndCopy(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache, LinkedList linkedList, StoreSearch.SearchTarget searchTarget) {
        return mGPreferenceSearchHistoryCache.removeAndCopy(linkedList, searchTarget);
    }

    private final LinkedList<List<QueryNode>> find(LinkedList<TargetHistory> linkedList, StoreSearch.SearchTarget searchTarget) {
        Iterator<TargetHistory> it = linkedList.iterator();
        Intrinsics3.checkNotNullExpressionValue(it, "iterator()");
        while (it.hasNext()) {
            TargetHistory next = it.next();
            Intrinsics3.checkNotNullExpressionValue(next, "iter.next()");
            TargetHistory targetHistory = next;
            if (Intrinsics3.areEqual(targetHistory.getSearchTarget(), searchTarget)) {
                return targetHistory.getRecentQueries();
            }
        }
        return new LinkedList<>();
    }

    private final LinkedList<TargetHistory> putAndCopy(LinkedList<TargetHistory> linkedList, StoreSearch.SearchTarget searchTarget, List<? extends QueryNode> list) {
        TargetHistory targetHistory;
        Iterator<TargetHistory> it = linkedList.iterator();
        Intrinsics3.checkNotNullExpressionValue(it, "iterator()");
        while (true) {
            if (!it.hasNext()) {
                targetHistory = null;
                break;
            }
            TargetHistory next = it.next();
            Intrinsics3.checkNotNullExpressionValue(next, "targetsIter.next()");
            targetHistory = next;
            if (Intrinsics3.areEqual(targetHistory.getSearchTarget(), searchTarget)) {
                it.remove();
                break;
            }
        }
        if (targetHistory == null) {
            targetHistory = new TargetHistory(searchTarget, new LinkedList());
        }
        Iterator<List<QueryNode>> it2 = targetHistory.getRecentQueries().iterator();
        Intrinsics3.checkNotNullExpressionValue(it2, "targetHistory.recentQueries.iterator()");
        while (it2.hasNext()) {
            List<QueryNode> next2 = it2.next();
            Intrinsics3.checkNotNullExpressionValue(next2, "queriesIter.next()");
            if (Intrinsics3.areEqual(next2, list)) {
                it2.remove();
            }
        }
        targetHistory.getRecentQueries().push(list);
        linkedList.push(new TargetHistory(searchTarget, new LinkedList(_Collections.take(targetHistory.getRecentQueries(), this.MAX_QUERIES_PER_TARGET))));
        return new LinkedList<>(_Collections.take(linkedList, this.MAX_SEARCH_TARGETS));
    }

    private final LinkedList<TargetHistory> removeAndCopy(LinkedList<TargetHistory> linkedList, StoreSearch.SearchTarget searchTarget) {
        Iterator<TargetHistory> it = linkedList.iterator();
        Intrinsics3.checkNotNullExpressionValue(it, "iterator()");
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TargetHistory next = it.next();
            Intrinsics3.checkNotNullExpressionValue(next, "iter.next()");
            if (Intrinsics3.areEqual(next.getSearchTarget(), searchTarget)) {
                it.remove();
                break;
            }
        }
        return new LinkedList<>(linkedList);
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public void clear(StoreSearch.SearchTarget searchTarget) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Observable<R> observableG = this.backingCache.getObservable().Z(1).G(new AnonymousClass1(searchTarget));
        Intrinsics3.checkNotNullExpressionValue(observableG, "backingCache\n        .ge…veAndCopy(searchTarget) }");
        ObservableExtensionsKt.appSubscribe$default(observableG, (Context) null, "clear history", (Function1) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public Observable<Collection<List<QueryNode>>> getHistory(StoreSearch.SearchTarget searchTarget) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Observable observableG = this.backingCache.getObservable().G(new AnonymousClass1(searchTarget));
        Intrinsics3.checkNotNullExpressionValue(observableG, "backingCache\n        .ge…{ it.find(searchTarget) }");
        return observableG;
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public void persistQuery(StoreSearch.SearchTarget searchTarget, List<? extends QueryNode> query) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Intrinsics3.checkNotNullParameter(query, "query");
        Observable<R> observableG = this.backingCache.getObservable().Z(1).G(new AnonymousClass1(searchTarget, query));
        Intrinsics3.checkNotNullExpressionValue(observableG, "backingCache\n        .ge…py(searchTarget, query) }");
        ObservableExtensionsKt.appSubscribe$default(observableG, (Context) null, "persist query", (Function1) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }
}
