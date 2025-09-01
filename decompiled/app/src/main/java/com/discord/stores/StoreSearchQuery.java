package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.o;
import com.discord.models.domain.ModelSearchResponse;
import com.discord.models.message.Message;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreSearch;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.network.SearchFetcher;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.network.state.QueryFetchState;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.parsing.QueryParser;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.validation.SearchData;
import d0.g0.StringsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreSearchQuery.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 :2\u00020\u0001:\u0001:B\u000f\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b8\u00109J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J;\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00132\b\b\u0002\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0011J5\u0010#\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\f¢\u0006\u0004\b#\u0010$J!\u0010%\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0006¢\u0006\u0004\b'\u0010\u0011R\u0016\u0010(\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0019\u00100\u001a\b\u0012\u0004\u0012\u00020\u00170-8F@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010/R2\u00103\u001a\u001e\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00170\u0017\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00170\u0017018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/discord/stores/StoreSearchQuery;", "", "Lcom/discord/stores/StoreSearch$SearchTarget;", "searchTarget", "Lcom/discord/utilities/search/network/SearchQuery;", "query", "", "performInitialLoad", "(Lcom/discord/stores/StoreSearch$SearchTarget;Lcom/discord/utilities/search/network/SearchQuery;)V", "searchQuery", "Lcom/discord/models/domain/ModelSearchResponse;", "response", "", "isInitialLoad", "handleResponse", "(Lcom/discord/utilities/search/network/SearchQuery;Lcom/discord/models/domain/ModelSearchResponse;Z)V", "handleError", "()V", "", "Lcom/discord/primitives/MessageId;", "oldestMessageId", "makeQuery", "(Lcom/discord/utilities/search/network/SearchQuery;Lcom/discord/stores/StoreSearch$SearchTarget;Ljava/lang/Long;Z)V", "Lcom/discord/utilities/search/network/state/SearchState;", "searchState", "updateAndPublish", "(Lcom/discord/utilities/search/network/state/SearchState;)V", "unsubscribe", "Lcom/discord/stores/StoreSearch;", "searchStore", "", "queryString", "Lcom/discord/utilities/search/strings/SearchStringProvider;", "searchStringProvider", "includeNsfw", "parseAndQuery", "(Lcom/discord/stores/StoreSearch;Lcom/discord/stores/StoreSearch$SearchTarget;Ljava/lang/String;Lcom/discord/utilities/search/strings/SearchStringProvider;Z)V", "loadMore", "(Lcom/discord/stores/StoreSearch$SearchTarget;J)V", "clear", "currentSearchState", "Lcom/discord/utilities/search/network/state/SearchState;", "Lcom/discord/utilities/search/network/SearchFetcher;", "searchFetcher", "Lcom/discord/utilities/search/network/SearchFetcher;", "Lrx/Observable;", "getState", "()Lrx/Observable;", "state", "Lrx/subjects/SerializedSubject;", "kotlin.jvm.PlatformType", "searchStateSubject", "Lrx/subjects/SerializedSubject;", "Lrx/Subscription;", "querySubscription", "Lrx/Subscription;", "<init>", "(Lcom/discord/utilities/search/network/SearchFetcher;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreSearchQuery {
    private static final SearchState SEARCH_STATE_NONE = new SearchState(QueryFetchState.NONE, null, null, null, null, false, 0, 126, null);
    private SearchState currentSearchState;
    private Subscription querySubscription;
    private final SearchFetcher searchFetcher;
    private final SerializedSubject<SearchState, SearchState> searchStateSubject;

    /* compiled from: StoreSearchQuery.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelSearchResponse;", "searchResponse", "", "invoke", "(Lcom/discord/models/domain/ModelSearchResponse;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearchQuery$makeQuery$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelSearchResponse, Unit> {
        public final /* synthetic */ boolean $isInitialLoad;
        public final /* synthetic */ SearchQuery $query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SearchQuery searchQuery, boolean z2) {
            super(1);
            this.$query = searchQuery;
            this.$isInitialLoad = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelSearchResponse modelSearchResponse) {
            invoke2(modelSearchResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelSearchResponse modelSearchResponse) {
            Intrinsics3.checkNotNullParameter(modelSearchResponse, "searchResponse");
            StoreSearchQuery.access$handleResponse(StoreSearchQuery.this, this.$query, modelSearchResponse, this.$isInitialLoad);
        }
    }

    /* compiled from: StoreSearchQuery.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearchQuery$makeQuery$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreSearchQuery.access$setQuerySubscription$p(StoreSearchQuery.this, subscription);
        }
    }

    /* compiled from: StoreSearchQuery.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearchQuery$makeQuery$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreSearchQuery.access$handleError(StoreSearchQuery.this);
        }
    }

    /* compiled from: StoreSearchQuery.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0001*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "Lcom/discord/utilities/search/query/node/QueryNode;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearchQuery$parseAndQuery$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<String, List<QueryNode>> {
        public final /* synthetic */ SearchStringProvider $searchStringProvider;

        public AnonymousClass1(SearchStringProvider searchStringProvider) {
            this.$searchStringProvider = searchStringProvider;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<QueryNode> call(String str) {
            return call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<QueryNode> call2(String str) {
            QueryParser queryParser = new QueryParser(this.$searchStringProvider);
            Intrinsics3.checkNotNullExpressionValue(str, "it");
            return Parser.parse$default(queryParser, str, null, null, 4, null);
        }
    }

    /* compiled from: StoreSearchQuery.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u00002\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/utilities/search/query/node/QueryNode;", "kotlin.jvm.PlatformType", "queryNodes", "Lcom/discord/utilities/search/validation/SearchData;", "searchData", "Lcom/discord/utilities/search/network/SearchQuery;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Lcom/discord/utilities/search/validation/SearchData;)Lcom/discord/utilities/search/network/SearchQuery;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearchQuery$parseAndQuery$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<List<QueryNode>, SearchData, SearchQuery> {
        public final /* synthetic */ boolean $includeNsfw;
        public final /* synthetic */ StoreSearch $searchStore;
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        public AnonymousClass2(StoreSearch storeSearch, StoreSearch.SearchTarget searchTarget, boolean z2) {
            this.$searchStore = storeSearch;
            this.$searchTarget = searchTarget;
            this.$includeNsfw = z2;
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ SearchQuery call(List<QueryNode> list, SearchData searchData) {
            return call2(list, searchData);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final SearchQuery call2(List<QueryNode> list, SearchData searchData) {
            QueryNode.Companion companion = QueryNode.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(list, "queryNodes");
            Intrinsics3.checkNotNullExpressionValue(searchData, "searchData");
            companion.preprocess(list, searchData);
            this.$searchStore.persistQuery$app_productionGoogleRelease(this.$searchTarget, list);
            return new SearchQuery.Builder().setIncludeNsfw(this.$includeNsfw).buildFrom(list, searchData);
        }
    }

    /* compiled from: StoreSearchQuery.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/search/network/SearchQuery;", "it", "", "invoke", "(Lcom/discord/utilities/search/network/SearchQuery;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearchQuery$parseAndQuery$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<SearchQuery, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(SearchQuery searchQuery) {
            return Boolean.valueOf(invoke2(searchQuery));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(SearchQuery searchQuery) {
            return searchQuery != null && searchQuery.isValid();
        }
    }

    /* compiled from: StoreSearchQuery.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/search/network/SearchQuery;", "searchQuery", "", "invoke", "(Lcom/discord/utilities/search/network/SearchQuery;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearchQuery$parseAndQuery$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<SearchQuery, Unit> {
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(StoreSearch.SearchTarget searchTarget) {
            super(1);
            this.$searchTarget = searchTarget;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SearchQuery searchQuery) {
            invoke2(searchQuery);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SearchQuery searchQuery) {
            if (searchQuery == null) {
                StoreSearchQuery.access$handleError(StoreSearchQuery.this);
            } else {
                StoreSearchQuery.access$performInitialLoad(StoreSearchQuery.this, this.$searchTarget, searchQuery);
            }
        }
    }

    public StoreSearchQuery(SearchFetcher searchFetcher) {
        Intrinsics3.checkNotNullParameter(searchFetcher, "searchFetcher");
        this.searchFetcher = searchFetcher;
        SearchState searchState = SEARCH_STATE_NONE;
        this.searchStateSubject = new SerializedSubject<>(BehaviorSubject.l0(searchState));
        this.currentSearchState = searchState;
    }

    public static final /* synthetic */ Subscription access$getQuerySubscription$p(StoreSearchQuery storeSearchQuery) {
        return storeSearchQuery.querySubscription;
    }

    public static final /* synthetic */ void access$handleError(StoreSearchQuery storeSearchQuery) {
        storeSearchQuery.handleError();
    }

    public static final /* synthetic */ void access$handleResponse(StoreSearchQuery storeSearchQuery, SearchQuery searchQuery, ModelSearchResponse modelSearchResponse, boolean z2) {
        storeSearchQuery.handleResponse(searchQuery, modelSearchResponse, z2);
    }

    public static final /* synthetic */ void access$performInitialLoad(StoreSearchQuery storeSearchQuery, StoreSearch.SearchTarget searchTarget, SearchQuery searchQuery) {
        storeSearchQuery.performInitialLoad(searchTarget, searchQuery);
    }

    public static final /* synthetic */ void access$setQuerySubscription$p(StoreSearchQuery storeSearchQuery, Subscription subscription) {
        storeSearchQuery.querySubscription = subscription;
    }

    private final void handleError() {
        updateAndPublish(new SearchState(QueryFetchState.FAILED, null, null, null, null, false, 0, 126, null));
    }

    private final synchronized void handleResponse(SearchQuery searchQuery, ModelSearchResponse response, boolean isInitialLoad) {
        SearchState searchState;
        int totalResults;
        List arrayList;
        Integer errorCode = response.getErrorCode();
        if (errorCode == null) {
            if (isInitialLoad) {
                totalResults = response.getTotalResults();
                arrayList = new ArrayList();
            } else {
                totalResults = this.currentSearchState.getTotalResults();
                List<Message> hits = this.currentSearchState.getHits();
                if (hits == null || (arrayList = _Collections.toMutableList((Collection) hits)) == null) {
                    arrayList = new ArrayList();
                }
            }
            int i = totalResults;
            List list = arrayList;
            List<com.discord.api.message.Message> hits2 = response.getHits();
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(hits2, 10));
            Iterator<T> it = hits2.iterator();
            while (it.hasNext()) {
                arrayList2.add(new Message((com.discord.api.message.Message) it.next()));
            }
            list.addAll(arrayList2);
            searchState = new SearchState(QueryFetchState.COMPLETED, searchQuery, response.getThreads(), response.getMembers(), list, i > list.size(), i);
        } else {
            searchState = errorCode.intValue() == 111000 ? new SearchState(QueryFetchState.INDEXING, searchQuery, null, null, null, false, 0, 124, null) : new SearchState(QueryFetchState.FAILED, searchQuery, null, null, null, false, 0, 124, null);
        }
        updateAndPublish(searchState);
    }

    private final void makeQuery(SearchQuery query, StoreSearch.SearchTarget searchTarget, Long oldestMessageId, boolean isInitialLoad) {
        ObservableExtensionsKt.appSubscribe$default(this.searchFetcher.makeQuery(searchTarget, oldestMessageId, query), (Context) null, "makeQuery", new AnonymousClass2(), new AnonymousClass1(query, isInitialLoad), new AnonymousClass3(), (Function0) null, (Function0) null, 97, (Object) null);
    }

    public static /* synthetic */ void makeQuery$default(StoreSearchQuery storeSearchQuery, SearchQuery searchQuery, StoreSearch.SearchTarget searchTarget, Long l, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        storeSearchQuery.makeQuery(searchQuery, searchTarget, l, z2);
    }

    private final void performInitialLoad(StoreSearch.SearchTarget searchTarget, SearchQuery query) {
        unsubscribe();
        makeQuery$default(this, query, searchTarget, null, false, 12, null);
    }

    private final synchronized void unsubscribe() {
        Subscription subscription = this.querySubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    private final synchronized void updateAndPublish(SearchState searchState) {
        this.currentSearchState = searchState;
        this.searchStateSubject.k.onNext(searchState);
    }

    public final void clear() {
        unsubscribe();
        updateAndPublish(SEARCH_STATE_NONE);
    }

    public final Observable<SearchState> getState() {
        Observable<SearchState> observableR = this.searchStateSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "searchStateSubject\n        .distinctUntilChanged()");
        return observableR;
    }

    public final synchronized void loadMore(StoreSearch.SearchTarget searchTarget, long oldestMessageId) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        SearchQuery searchQuery = this.currentSearchState.getSearchQuery();
        if (searchQuery != null) {
            if (this.currentSearchState.getQueryFetchState() != QueryFetchState.COMPLETED) {
                return;
            }
            if (this.currentSearchState.getHasMore()) {
                unsubscribe();
                updateAndPublish(new SearchState(QueryFetchState.LOADING_MORE, searchQuery, this.currentSearchState.getThreads(), this.currentSearchState.getThreadMembers(), this.currentSearchState.getHits(), false, this.currentSearchState.getTotalResults()));
                makeQuery(searchQuery, searchTarget, Long.valueOf(oldestMessageId), false);
            }
        }
    }

    public final void parseAndQuery(StoreSearch searchStore, StoreSearch.SearchTarget searchTarget, String queryString, SearchStringProvider searchStringProvider, boolean includeNsfw) {
        Intrinsics3.checkNotNullParameter(searchStore, "searchStore");
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Intrinsics3.checkNotNullParameter(queryString, "queryString");
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        unsubscribe();
        if (!(!StringsJVM.isBlank(queryString))) {
            updateAndPublish(new SearchState(QueryFetchState.NONE, null, null, null, null, false, 0, 126, null));
            return;
        }
        updateAndPublish(new SearchState(QueryFetchState.IN_PROGRESS, null, null, null, null, false, 0, 126, null));
        Observable observableZ = Observable.j0(new ScalarSynchronousObservable(queryString).G(new AnonymousClass1(searchStringProvider)), searchStore.getStoreSearchData().get(), new AnonymousClass2(searchStore, searchTarget, includeNsfw)).k(o.c(AnonymousClass3.INSTANCE, null, 1L, TimeUnit.SECONDS)).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "Observable\n            .…   )\n            .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableZ), (Context) null, "parseAndQuery", (Function1) null, new AnonymousClass4(searchTarget), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }
}
