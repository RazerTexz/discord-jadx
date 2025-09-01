package com.discord.utilities.search.network;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSearchResponse;
import com.discord.stores.StoreSearch;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.a.OnSubscribeDefer;
import j0.l.a.OnSubscribeRedo6;
import j0.l.c.TrampolineScheduler;
import j0.l.e.InternalObservableUtils;
import j0.l.e.ScalarSynchronousObservable;
import j0.p.Schedulers2;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;

/* compiled from: SearchFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\u00020\f*\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/utilities/search/network/SearchFetcher;", "", "Lcom/discord/stores/StoreSearch$SearchTarget;", "searchTarget", "", "oldestMessageId", "Lcom/discord/utilities/search/network/SearchQuery;", "searchQuery", "Lrx/Observable;", "Lcom/discord/models/domain/ModelSearchResponse;", "getRestObservable", "(Lcom/discord/stores/StoreSearch$SearchTarget;Ljava/lang/Long;Lcom/discord/utilities/search/network/SearchQuery;)Lrx/Observable;", "", "isIndexing", "(Lcom/discord/models/domain/ModelSearchResponse;)Z", "makeQuery", "Ljava/util/concurrent/atomic/AtomicInteger;", "indexingRetryCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class SearchFetcher {
    private AtomicInteger indexingRetryCount = new AtomicInteger(0);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreSearch.SearchTarget.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreSearch.SearchTarget.Type.GUILD.ordinal()] = 1;
            iArr[StoreSearch.SearchTarget.Type.CHANNEL.ordinal()] = 2;
        }
    }

    /* compiled from: SearchFetcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ljava/util/concurrent/atomic/AtomicInteger;", "", "invoke", "(Ljava/util/concurrent/atomic/AtomicInteger;)Ljava/lang/Integer;", "getNullIfZero"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.network.SearchFetcher$getRestObservable$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<AtomicInteger, Integer> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(AtomicInteger atomicInteger) {
            return invoke2(atomicInteger);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Integer invoke2(AtomicInteger atomicInteger) {
            Intrinsics3.checkNotNullParameter(atomicInteger, "$this$getNullIfZero");
            int i = atomicInteger.get();
            if (i != 0) {
                return Integer.valueOf(i);
            }
            return null;
        }
    }

    /* compiled from: SearchFetcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0005\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0001 \u0002*\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Observable;", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.network.SearchFetcher$getRestObservable$2, reason: invalid class name */
    public static final class AnonymousClass2<R> implements Func0<Observable<Integer>> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Observable<Integer> call() {
            return new ScalarSynchronousObservable(AnonymousClass1.INSTANCE.invoke2(SearchFetcher.access$getIndexingRetryCount$p(SearchFetcher.this)));
        }
    }

    /* compiled from: SearchFetcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "attempts", "Lrx/Observable;", "Lcom/discord/models/domain/ModelSearchResponse;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Integer;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.network.SearchFetcher$getRestObservable$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<Integer, Observable<? extends ModelSearchResponse>> {
        public final /* synthetic */ Long $oldestMessageId;
        public final /* synthetic */ Map $queryParams;
        public final /* synthetic */ SearchQuery $searchQuery;
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        public AnonymousClass3(StoreSearch.SearchTarget searchTarget, Long l, Map map, SearchQuery searchQuery) {
            this.$searchTarget = searchTarget;
            this.$oldestMessageId = l;
            this.$queryParams = map;
            this.$searchQuery = searchQuery;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends ModelSearchResponse> call(Integer num) {
            return call2(num);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends ModelSearchResponse> call2(Integer num) {
            int iOrdinal = this.$searchTarget.getType().ordinal();
            if (iOrdinal == 0) {
                return RestAPI.INSTANCE.getApi().searchGuildMessages(this.$searchTarget.getId(), this.$oldestMessageId, (List) this.$queryParams.get("author_id"), (List) this.$queryParams.get("mentions"), (List) this.$queryParams.get(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID), (List) this.$queryParams.get("has"), (List) this.$queryParams.get("content"), num, Boolean.valueOf(this.$searchQuery.getIncludeNsfw()));
            }
            if (iOrdinal == 1) {
                return RestAPI.INSTANCE.getApi().searchChannelMessages(this.$searchTarget.getId(), this.$oldestMessageId, (List) this.$queryParams.get("author_id"), (List) this.$queryParams.get("mentions"), (List) this.$queryParams.get("has"), (List) this.$queryParams.get("content"), num, Boolean.valueOf(this.$searchQuery.getIncludeNsfw()));
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: SearchFetcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/ModelSearchResponse;", "kotlin.jvm.PlatformType", "searchResponse", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelSearchResponse;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.network.SearchFetcher$makeQuery$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<ModelSearchResponse> {
        public final /* synthetic */ AtomicLong $resubscribeDelayMillis;

        public AnonymousClass1(AtomicLong atomicLong) {
            this.$resubscribeDelayMillis = atomicLong;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelSearchResponse modelSearchResponse) {
            call2(modelSearchResponse);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelSearchResponse modelSearchResponse) {
            SearchFetcher searchFetcher = SearchFetcher.this;
            Intrinsics3.checkNotNullExpressionValue(modelSearchResponse, "searchResponse");
            if (SearchFetcher.access$isIndexing(searchFetcher, modelSearchResponse)) {
                this.$resubscribeDelayMillis.set(modelSearchResponse.getRetryMillis());
                SearchFetcher.access$getIndexingRetryCount$p(SearchFetcher.this).incrementAndGet();
            }
        }
    }

    /* compiled from: SearchFetcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00000\u00002.\u0010\u0003\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lrx/Observable;", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "observable", NotificationCompat.CATEGORY_CALL, "(Lrx/Observable;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.network.SearchFetcher$makeQuery$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Observable<? extends Void>, Observable<?>> {
        public final /* synthetic */ AtomicLong $resubscribeDelayMillis;

        /* compiled from: SearchFetcher.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/lang/Void;", "kotlin.jvm.PlatformType", "it", "Lrx/Observable;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.search.network.SearchFetcher$makeQuery$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Void, Observable<? extends Long>> {
            public AnonymousClass1() {
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Long> call(Void r1) {
                return call2(r1);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Long> call2(Void r3) {
                return Observable.d0(AnonymousClass2.this.$resubscribeDelayMillis.get(), TimeUnit.MILLISECONDS);
            }
        }

        public AnonymousClass2(AtomicLong atomicLong) {
            this.$resubscribeDelayMillis = atomicLong;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<?> call(Observable<? extends Void> observable) {
            return call2(observable);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<?> call2(Observable<? extends Void> observable) {
            return observable.A(new AnonymousClass1());
        }
    }

    /* compiled from: SearchFetcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/ModelSearchResponse;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelSearchResponse;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.network.SearchFetcher$makeQuery$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<ModelSearchResponse, Boolean> {
        public AnonymousClass3() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(ModelSearchResponse modelSearchResponse) {
            return call2(modelSearchResponse);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(ModelSearchResponse modelSearchResponse) {
            SearchFetcher searchFetcher = SearchFetcher.this;
            Intrinsics3.checkNotNullExpressionValue(modelSearchResponse, "it");
            return Boolean.valueOf(!SearchFetcher.access$isIndexing(searchFetcher, modelSearchResponse));
        }
    }

    public static final /* synthetic */ AtomicInteger access$getIndexingRetryCount$p(SearchFetcher searchFetcher) {
        return searchFetcher.indexingRetryCount;
    }

    public static final /* synthetic */ boolean access$isIndexing(SearchFetcher searchFetcher, ModelSearchResponse modelSearchResponse) {
        return searchFetcher.isIndexing(modelSearchResponse);
    }

    public static final /* synthetic */ void access$setIndexingRetryCount$p(SearchFetcher searchFetcher, AtomicInteger atomicInteger) {
        searchFetcher.indexingRetryCount = atomicInteger;
    }

    private final Observable<ModelSearchResponse> getRestObservable(StoreSearch.SearchTarget searchTarget, Long oldestMessageId, SearchQuery searchQuery) {
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Observable observableA = Observable.h0(new OnSubscribeDefer(new AnonymousClass2())).A(new AnonymousClass3(searchTarget, oldestMessageId, searchQuery.getParams(), searchQuery));
        Intrinsics3.checkNotNullExpressionValue(observableA, "Observable\n        .defe…  )\n          }\n        }");
        return ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null);
    }

    private final boolean isIndexing(ModelSearchResponse modelSearchResponse) {
        Integer errorCode = modelSearchResponse.getErrorCode();
        return errorCode != null && errorCode.intValue() == 111000;
    }

    public Observable<ModelSearchResponse> makeQuery(StoreSearch.SearchTarget searchTarget, Long oldestMessageId, SearchQuery searchQuery) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
        AtomicLong atomicLong = new AtomicLong();
        Observable<ModelSearchResponse> observableU = getRestObservable(searchTarget, oldestMessageId, searchQuery).u(new AnonymousClass1(atomicLong));
        InternalObservableUtils.c cVar = new InternalObservableUtils.c(new AnonymousClass2(atomicLong));
        AtomicReference<Schedulers2> atomicReference = Schedulers2.a;
        Observable<ModelSearchResponse> observableB0 = Observable.h0(new OnSubscribeRedo6(observableU, cVar, false, true, TrampolineScheduler.a)).b0(new AnonymousClass3());
        Intrinsics3.checkNotNullExpressionValue(observableB0, "getRestObservable(search…ntil { !it.isIndexing() }");
        return observableB0;
    }
}
