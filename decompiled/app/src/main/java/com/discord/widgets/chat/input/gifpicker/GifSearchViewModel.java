package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreGifPicker;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.SearchType;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.LeadingEdgeThrottle;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import d0.LazyJVM;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.a.OnSubscribeLift;
import j0.p.Schedulers2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: GifSearchViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\"#$BM\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$ViewState;", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState;)V", "", "searchText", "setSearchText", "(Ljava/lang/String;)V", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;", "gifItem", "selectGif", "(Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;)V", "Lrx/subjects/BehaviorSubject;", "searchSubject", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/widgets/chat/MessageManager;", "messageManager", "Lcom/discord/widgets/chat/MessageManager;", "Lcom/discord/stores/StoreGifPicker;", "storeGifPicker", "Lcom/discord/stores/StoreGifPicker;", "Lcom/discord/stores/StoreAnalytics;", "storeAnalytics", "Lcom/discord/stores/StoreAnalytics;", "Landroid/content/Context;", "context", "Lrx/Observable;", "storeStateObservable", "<init>", "(Landroid/content/Context;Lrx/subjects/BehaviorSubject;Lcom/discord/stores/StoreGifPicker;Lcom/discord/stores/StoreAnalytics;Lcom/discord/widgets/chat/MessageManager;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GifSearchViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MessageManager messageManager;
    private final BehaviorSubject<String> searchSubject;
    private final StoreAnalytics storeAnalytics;
    private final StoreGifPicker storeGifPicker;

    /* compiled from: GifSearchViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            GifSearchViewModel.access$handleStoreState(GifSearchViewModel.this, storeState);
        }
    }

    /* compiled from: GifSearchViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JA\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$Companion;", "", "Lrx/subjects/BehaviorSubject;", "", "searchSubject", "Lcom/discord/stores/StoreAnalytics;", "storeAnalytics", "Lcom/discord/stores/StoreGifPicker;", "storeGifPicker", "", "trendingSearchTerms", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState;", "observeQueryState", "(Lrx/subjects/BehaviorSubject;Lcom/discord/stores/StoreAnalytics;Lcom/discord/stores/StoreGifPicker;Ljava/util/List;)Lrx/Observable;", "observeStoreState", "(Lrx/subjects/BehaviorSubject;Lcom/discord/stores/StoreAnalytics;Lcom/discord/stores/StoreGifPicker;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeQueryState(Companion companion, BehaviorSubject behaviorSubject, StoreAnalytics storeAnalytics, StoreGifPicker storeGifPicker, List list) {
            return companion.observeQueryState(behaviorSubject, storeAnalytics, storeGifPicker, list);
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, BehaviorSubject behaviorSubject, StoreAnalytics storeAnalytics, StoreGifPicker storeGifPicker) {
            return companion.observeStoreState(behaviorSubject, storeAnalytics, storeGifPicker);
        }

        private final Observable<StoreState> observeQueryState(BehaviorSubject<String> searchSubject, StoreAnalytics storeAnalytics, StoreGifPicker storeGifPicker, List<String> trendingSearchTerms) {
            Observable<String> observableR = searchSubject.J(Schedulers2.c()).r();
            Observable<StoreState> observableY = Observable.h0(new OnSubscribeLift(observableR.j, new LeadingEdgeThrottle(1000L, TimeUnit.MILLISECONDS, Schedulers2.c()))).u(new GifSearchViewModel2(storeAnalytics)).Y(new GifSearchViewModel3(trendingSearchTerms, storeGifPicker));
            Intrinsics3.checkNotNullExpressionValue(observableY, "searchSubject\n          …          }\n            }");
            return observableY;
        }

        private final Observable<StoreState> observeStoreState(BehaviorSubject<String> searchSubject, StoreAnalytics storeAnalytics, StoreGifPicker storeGifPicker) {
            Observable observableY = storeGifPicker.observeGifTrendingSearchTerms().Y(new GifSearchViewModel4(searchSubject, storeAnalytics, storeGifPicker));
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeGifPicker.observeGi…fPicker, terms)\n        }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GifSearchViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\n\u000bB\u0017\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState;", "", "", "", "trendingSearchTerms", "Ljava/util/List;", "getTrendingSearchTerms", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "SearchResults", "TrendingSearchTermsResults", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState$TrendingSearchTermsResults;", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState$SearchResults;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {
        private final List<String> trendingSearchTerms;

        /* compiled from: GifSearchViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b \u0010!J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\nJL\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001c\u0010\u0005R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001d\u0010\u0005R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\n¨\u0006\""}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState$SearchResults;", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState;", "", "Lcom/discord/models/gifpicker/dto/ModelGif;", "component1", "()Ljava/util/List;", "", "component2", "component3", "component4", "()Ljava/lang/String;", "gifs", "suggested", "trending", "searchQuery", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState$SearchResults;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getTrending", "getSuggested", "getGifs", "Ljava/lang/String;", "getSearchQuery", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SearchResults extends StoreState {
            private final List<ModelGif> gifs;
            private final String searchQuery;
            private final List<String> suggested;
            private final List<String> trending;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SearchResults(List<ModelGif> list, List<String> list2, List<String> list3, String str) {
                super(list3, null);
                Intrinsics3.checkNotNullParameter(list, "gifs");
                Intrinsics3.checkNotNullParameter(list2, "suggested");
                Intrinsics3.checkNotNullParameter(list3, "trending");
                this.gifs = list;
                this.suggested = list2;
                this.trending = list3;
                this.searchQuery = str;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SearchResults copy$default(SearchResults searchResults, List list, List list2, List list3, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = searchResults.gifs;
                }
                if ((i & 2) != 0) {
                    list2 = searchResults.suggested;
                }
                if ((i & 4) != 0) {
                    list3 = searchResults.trending;
                }
                if ((i & 8) != 0) {
                    str = searchResults.searchQuery;
                }
                return searchResults.copy(list, list2, list3, str);
            }

            public final List<ModelGif> component1() {
                return this.gifs;
            }

            public final List<String> component2() {
                return this.suggested;
            }

            public final List<String> component3() {
                return this.trending;
            }

            /* renamed from: component4, reason: from getter */
            public final String getSearchQuery() {
                return this.searchQuery;
            }

            public final SearchResults copy(List<ModelGif> gifs, List<String> suggested, List<String> trending, String searchQuery) {
                Intrinsics3.checkNotNullParameter(gifs, "gifs");
                Intrinsics3.checkNotNullParameter(suggested, "suggested");
                Intrinsics3.checkNotNullParameter(trending, "trending");
                return new SearchResults(gifs, suggested, trending, searchQuery);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SearchResults)) {
                    return false;
                }
                SearchResults searchResults = (SearchResults) other;
                return Intrinsics3.areEqual(this.gifs, searchResults.gifs) && Intrinsics3.areEqual(this.suggested, searchResults.suggested) && Intrinsics3.areEqual(this.trending, searchResults.trending) && Intrinsics3.areEqual(this.searchQuery, searchResults.searchQuery);
            }

            public final List<ModelGif> getGifs() {
                return this.gifs;
            }

            public final String getSearchQuery() {
                return this.searchQuery;
            }

            public final List<String> getSuggested() {
                return this.suggested;
            }

            public final List<String> getTrending() {
                return this.trending;
            }

            public int hashCode() {
                List<ModelGif> list = this.gifs;
                int iHashCode = (list != null ? list.hashCode() : 0) * 31;
                List<String> list2 = this.suggested;
                int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
                List<String> list3 = this.trending;
                int iHashCode3 = (iHashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
                String str = this.searchQuery;
                return iHashCode3 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("SearchResults(gifs=");
                sbU.append(this.gifs);
                sbU.append(", suggested=");
                sbU.append(this.suggested);
                sbU.append(", trending=");
                sbU.append(this.trending);
                sbU.append(", searchQuery=");
                return outline.J(sbU, this.searchQuery, ")");
            }
        }

        /* compiled from: GifSearchViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState$TrendingSearchTermsResults;", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState;", "", "", "component1", "()Ljava/util/List;", "trending", "copy", "(Ljava/util/List;)Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState$TrendingSearchTermsResults;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getTrending", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class TrendingSearchTermsResults extends StoreState {
            private final List<String> trending;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TrendingSearchTermsResults(List<String> list) {
                super(list, null);
                Intrinsics3.checkNotNullParameter(list, "trending");
                this.trending = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ TrendingSearchTermsResults copy$default(TrendingSearchTermsResults trendingSearchTermsResults, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = trendingSearchTermsResults.trending;
                }
                return trendingSearchTermsResults.copy(list);
            }

            public final List<String> component1() {
                return this.trending;
            }

            public final TrendingSearchTermsResults copy(List<String> trending) {
                Intrinsics3.checkNotNullParameter(trending, "trending");
                return new TrendingSearchTermsResults(trending);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof TrendingSearchTermsResults) && Intrinsics3.areEqual(this.trending, ((TrendingSearchTermsResults) other).trending);
                }
                return true;
            }

            public final List<String> getTrending() {
                return this.trending;
            }

            public int hashCode() {
                List<String> list = this.trending;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("TrendingSearchTermsResults(trending="), this.trending, ")");
            }
        }

        private StoreState(List<String> list) {
            this.trendingSearchTerms = list;
        }

        public final List<String> getTrendingSearchTerms() {
            return this.trendingSearchTerms;
        }

        public /* synthetic */ StoreState(List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(list);
        }
    }

    /* compiled from: GifSearchViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$ViewState;", "", "<init>", "()V", "Loaded", "LoadingSearchResults", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$ViewState$Loaded;", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$ViewState$LoadingSearchResults;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: GifSearchViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0017\u001a\u00020\f8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u000eR\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$ViewState$Loaded;", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$ViewState;", "", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem;", "component1", "()Ljava/util/List;", "adapterItems", "copy", "(Ljava/util/List;)Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "gifCount$delegate", "Lkotlin/Lazy;", "getGifCount", "gifCount", "Ljava/util/List;", "getAdapterItems", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final List<GifAdapterItem> adapterItems;

            /* renamed from: gifCount$delegate, reason: from kotlin metadata */
            private final Lazy gifCount;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends GifAdapterItem> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "adapterItems");
                this.adapterItems = list;
                this.gifCount = LazyJVM.lazy(new GifSearchViewModel5(this));
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.adapterItems;
                }
                return loaded.copy(list);
            }

            public final List<GifAdapterItem> component1() {
                return this.adapterItems;
            }

            public final Loaded copy(List<? extends GifAdapterItem> adapterItems) {
                Intrinsics3.checkNotNullParameter(adapterItems, "adapterItems");
                return new Loaded(adapterItems);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.adapterItems, ((Loaded) other).adapterItems);
                }
                return true;
            }

            public final List<GifAdapterItem> getAdapterItems() {
                return this.adapterItems;
            }

            public final int getGifCount() {
                return ((Number) this.gifCount.getValue()).intValue();
            }

            public int hashCode() {
                List<GifAdapterItem> list = this.adapterItems;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(adapterItems="), this.adapterItems, ")");
            }
        }

        /* compiled from: GifSearchViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$ViewState$LoadingSearchResults;", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class LoadingSearchResults extends ViewState {
            public static final LoadingSearchResults INSTANCE = new LoadingSearchResults();

            private LoadingSearchResults() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GifSearchViewModel(Context context, BehaviorSubject behaviorSubject, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, MessageManager messageManager, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        BehaviorSubject behaviorSubjectL0;
        if ((i & 2) != 0) {
            behaviorSubjectL0 = BehaviorSubject.l0("");
            Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        } else {
            behaviorSubjectL0 = behaviorSubject;
        }
        StoreGifPicker gifPicker = (i & 4) != 0 ? StoreStream.INSTANCE.getGifPicker() : storeGifPicker;
        StoreAnalytics analytics = (i & 8) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        this(context, behaviorSubjectL0, gifPicker, analytics, (i & 16) != 0 ? new MessageManager(context, null, null, null, null, null, null, null, null, 510, null) : messageManager, (i & 32) != 0 ? Companion.access$observeStoreState(INSTANCE, behaviorSubjectL0, analytics, gifPicker) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GifSearchViewModel gifSearchViewModel, StoreState storeState) {
        gifSearchViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        ArrayList arrayList = new ArrayList();
        List<String> trendingSearchTerms = storeState.getTrendingSearchTerms();
        boolean z2 = storeState instanceof StoreState.SearchResults;
        if (z2) {
            StoreState.SearchResults searchResults = (StoreState.SearchResults) storeState;
            List<ModelGif> gifs = searchResults.getGifs();
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(gifs, 10));
            Iterator<T> it = gifs.iterator();
            while (it.hasNext()) {
                arrayList2.add(new GifAdapterItem.GifItem((ModelGif) it.next(), searchResults.getSearchQuery()));
            }
            arrayList.addAll(arrayList2);
            List<String> suggested = searchResults.getSuggested();
            boolean z3 = arrayList.size() > 0;
            boolean z4 = searchResults.getSuggested().size() > 0;
            String strN0 = this.searchSubject.n0();
            Intrinsics3.checkNotNullExpressionValue(strN0, "searchSubject.value");
            boolean z5 = strN0.length() > 0;
            arrayList.add(z3 ? new GifAdapterItem.SuggestedTermsItem.SuggestedTermsNonEmptyResults(suggested, R.string.gif_picker_related_search) : (!z5 || z4) ? (z5 && z4) ? new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(suggested, R.string.no_gif_search_results_with_related_search) : new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(suggested, R.string.gif_picker_enter_search) : new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(suggested, R.string.no_gif_search_results_without_related_search));
        } else if (storeState instanceof StoreState.TrendingSearchTermsResults) {
            arrayList.add(new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(trendingSearchTerms, R.string.gif_picker_enter_search));
        }
        ViewState.Loaded loaded = new ViewState.Loaded(arrayList);
        if (z2) {
            StoreAnalytics.trackSearchResultViewed$default(this.storeAnalytics, SearchType.GIF, loaded.getGifCount(), null, null, false, 28, null);
        }
        updateViewState(loaded);
    }

    public final void selectGif(GifAdapterItem.GifItem gifItem) {
        Intrinsics3.checkNotNullParameter(gifItem, "gifItem");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            StoreAnalytics.trackSearchResultSelected$default(this.storeAnalytics, SearchType.GIF, loaded.getGifCount(), null, new Traits.Source(null, null, Traits.Source.Obj.GIF_PICKER, null, null, 27, null), 4, null);
        }
        MessageManager.sendMessage$default(this.messageManager, gifItem.getGif().getTenorGifUrl(), null, null, null, null, false, null, null, null, 510, null);
    }

    public final void setSearchText(String searchText) {
        Intrinsics3.checkNotNullParameter(searchText, "searchText");
        if (!Intrinsics3.areEqual(this.searchSubject.n0(), searchText)) {
            if (searchText.length() > 0) {
                updateViewState(ViewState.LoadingSearchResults.INSTANCE);
            }
        }
        this.searchSubject.onNext(searchText);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifSearchViewModel(Context context, BehaviorSubject<String> behaviorSubject, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, MessageManager messageManager, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(behaviorSubject, "searchSubject");
        Intrinsics3.checkNotNullParameter(storeGifPicker, "storeGifPicker");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(messageManager, "messageManager");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.searchSubject = behaviorSubject;
        this.storeGifPicker = storeGifPicker;
        this.storeAnalytics = storeAnalytics;
        this.messageManager = messageManager;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), GifSearchViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
