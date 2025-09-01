package com.discord.widgets.search.suggestions;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSearchSuggestionsBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.HasNode2;
import com.discord.utilities.search.strings.ContextSearchStringProvider;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import com.discord.utilities.search.suggestion.entries.FilterSuggestion;
import com.discord.utilities.search.suggestion.entries.HasSuggestion;
import com.discord.utilities.search.suggestion.entries.RecentQuerySuggestion;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetSearchSuggestions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestions;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestions$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestions$Model;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/utilities/search/strings/SearchStringProvider;", "searchStringProvider", "Lcom/discord/utilities/search/strings/SearchStringProvider;", "Lcom/discord/databinding/WidgetSearchSuggestionsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSearchSuggestionsBinding;", "binding", "Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;", "adapter", "Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;", "<init>", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSearchSuggestions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSearchSuggestions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSearchSuggestionsBinding;", 0)};
    private WidgetSearchSuggestionsAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private SearchStringProvider searchStringProvider;

    /* compiled from: WidgetSearchSuggestions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB#\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J0\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001b\u0010\u0005R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001c\u0010\u0005¨\u0006 "}, d2 = {"Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestions$Model;", "", "", "Lcom/discord/utilities/search/query/node/QueryNode;", "component1", "()Ljava/util/List;", "", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion;", "component2", "query", "suggestionEntries", "copy", "(Ljava/util/List;Ljava/util/List;)Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestions$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "suggestionItems", "Ljava/util/List;", "getSuggestionItems", "getQuery", "getSuggestionEntries", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<QueryNode> query;
        private final List<SearchSuggestion> suggestionEntries;
        private final List<MGRecyclerDataPayload> suggestionItems;

        /* compiled from: WidgetSearchSuggestions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestions$Model$Companion;", "", "Lcom/discord/utilities/search/strings/SearchStringProvider;", "searchStringProvider", "Lrx/Observable;", "Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestions$Model;", "get", "(Lcom/discord/utilities/search/strings/SearchStringProvider;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(SearchStringProvider searchStringProvider) {
                Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getSearch().getStoreSearchData().get(), companion.getSearch().getStoreSearchInput().getCurrentParsedInput(), companion.getSearch().getHistory(), new WidgetSearchSuggestions2(searchStringProvider));
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…gestionEntries)\n        }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…().distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                SearchSuggestion.Category.values();
                int[] iArr = new int[7];
                $EnumSwitchMapping$0 = iArr;
                iArr[SearchSuggestion.Category.FILTER.ordinal()] = 1;
                iArr[SearchSuggestion.Category.FROM_USER.ordinal()] = 2;
                iArr[SearchSuggestion.Category.MENTIONS_USER.ordinal()] = 3;
                iArr[SearchSuggestion.Category.IN_CHANNEL.ordinal()] = 4;
                iArr[SearchSuggestion.Category.HAS.ordinal()] = 5;
                iArr[SearchSuggestion.Category.RECENT_QUERY.ordinal()] = 6;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(List<QueryNode> list, List<? extends SearchSuggestion> list2) {
            Intrinsics3.checkNotNullParameter(list, "query");
            Intrinsics3.checkNotNullParameter(list2, "suggestionEntries");
            this.query = list;
            this.suggestionEntries = list2;
            this.suggestionItems = new ArrayList();
            SearchSuggestion.Category category = null;
            for (SearchSuggestion searchSuggestion : list2) {
                SearchSuggestion.Category category2 = searchSuggestion.getCategory();
                if (category == null || category2 != category) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getHeaderItem(category2));
                    category = category2;
                }
                int iOrdinal = category2.ordinal();
                if (iOrdinal == 0) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getFilterItem((FilterSuggestion) searchSuggestion));
                } else if (iOrdinal == 1 || iOrdinal == 2) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getUserItem((UserSuggestion) searchSuggestion));
                } else if (iOrdinal == 3) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getHasItem((HasSuggestion) searchSuggestion));
                } else if (iOrdinal == 5) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getInChannelItem((ChannelSuggestion) searchSuggestion));
                } else if (iOrdinal == 6) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getRecentQueryItem((RecentQuerySuggestion) searchSuggestion));
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = model.query;
            }
            if ((i & 2) != 0) {
                list2 = model.suggestionEntries;
            }
            return model.copy(list, list2);
        }

        public final List<QueryNode> component1() {
            return this.query;
        }

        public final List<SearchSuggestion> component2() {
            return this.suggestionEntries;
        }

        public final Model copy(List<QueryNode> query, List<? extends SearchSuggestion> suggestionEntries) {
            Intrinsics3.checkNotNullParameter(query, "query");
            Intrinsics3.checkNotNullParameter(suggestionEntries, "suggestionEntries");
            return new Model(query, suggestionEntries);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.query, model.query) && Intrinsics3.areEqual(this.suggestionEntries, model.suggestionEntries);
        }

        public final List<QueryNode> getQuery() {
            return this.query;
        }

        public final List<SearchSuggestion> getSuggestionEntries() {
            return this.suggestionEntries;
        }

        public final List<MGRecyclerDataPayload> getSuggestionItems() {
            return this.suggestionItems;
        }

        public int hashCode() {
            List<QueryNode> list = this.query;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            List<SearchSuggestion> list2 = this.suggestionEntries;
            return iHashCode + (list2 != null ? list2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(query=");
            sbU.append(this.query);
            sbU.append(", suggestionEntries=");
            return outline.L(sbU, this.suggestionEntries, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            UserSuggestion.TargetType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[UserSuggestion.TargetType.FROM.ordinal()] = 1;
            iArr[UserSuggestion.TargetType.MENTIONS.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetSearchSuggestions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/search/query/FilterType;", "filterType", "", "invoke", "(Lcom/discord/utilities/search/query/FilterType;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<FilterType, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FilterType filterType) {
            invoke2(filterType);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FilterType filterType) {
            Intrinsics3.checkNotNullParameter(filterType, "filterType");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onFilterClicked(filterType, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this), this.$model.getQuery());
        }
    }

    /* compiled from: WidgetSearchSuggestions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/search/suggestion/entries/UserSuggestion;", "userSuggestion", "", "invoke", "(Lcom/discord/utilities/search/suggestion/entries/UserSuggestion;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<UserSuggestion, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserSuggestion userSuggestion) {
            invoke2(userSuggestion);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserSuggestion userSuggestion) {
            Intrinsics3.checkNotNullParameter(userSuggestion, "userSuggestion");
            int iOrdinal = userSuggestion.getTargetType().ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    return;
                }
                StoreStream.INSTANCE.getSearch().getStoreSearchInput().onMentionsUserClicked(userSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getMentionsFilterString(), this.$model.getQuery());
            } else {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                companion.getSearch().getStoreSearchInput().onFromUserClicked(userSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getFromFilterString(), this.$model.getQuery());
                companion.getSearch().getStoreSearchInput().onMentionsUserClicked(userSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getMentionsFilterString(), this.$model.getQuery());
            }
        }
    }

    /* compiled from: WidgetSearchSuggestions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/search/suggestion/entries/ChannelSuggestion;", "channelSuggestion", "", "invoke", "(Lcom/discord/utilities/search/suggestion/entries/ChannelSuggestion;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<ChannelSuggestion, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelSuggestion channelSuggestion) {
            invoke2(channelSuggestion);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelSuggestion channelSuggestion) {
            Intrinsics3.checkNotNullParameter(channelSuggestion, "channelSuggestion");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onInChannelClicked(channelSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getInFilterString(), this.$model.getQuery());
        }
    }

    /* compiled from: WidgetSearchSuggestions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;", "hasAnswerOption", "", "invoke", "(Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<HasNode2, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HasNode2 hasNode2) {
            invoke2(hasNode2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HasNode2 hasNode2) {
            Intrinsics3.checkNotNullParameter(hasNode2, "hasAnswerOption");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onHasClicked(hasNode2, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getHasFilterString(), hasNode2.getLocalizedInputText(WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this)), this.$model.getQuery());
        }
    }

    /* compiled from: WidgetSearchSuggestions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/utilities/search/query/node/QueryNode;", "queryNodes", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<List<? extends QueryNode>, Unit> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends QueryNode> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends QueryNode> list) {
            Intrinsics3.checkNotNullParameter(list, "queryNodes");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onQueryClicked(list);
        }
    }

    /* compiled from: WidgetSearchSuggestions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        public AnonymousClass6() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStream.INSTANCE.getSearch().clearHistory();
        }
    }

    /* compiled from: WidgetSearchSuggestions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestions$Model;", "model", "", "invoke", "(Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestions$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "model");
            WidgetSearchSuggestions.access$configureUI(WidgetSearchSuggestions.this, model);
        }
    }

    public WidgetSearchSuggestions() {
        super(R.layout.widget_search_suggestions);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSearchSuggestions3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSearchSuggestions widgetSearchSuggestions, Model model) {
        widgetSearchSuggestions.configureUI(model);
    }

    public static final /* synthetic */ SearchStringProvider access$getSearchStringProvider$p(WidgetSearchSuggestions widgetSearchSuggestions) {
        SearchStringProvider searchStringProvider = widgetSearchSuggestions.searchStringProvider;
        if (searchStringProvider == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("searchStringProvider");
        }
        return searchStringProvider;
    }

    public static final /* synthetic */ void access$setSearchStringProvider$p(WidgetSearchSuggestions widgetSearchSuggestions, SearchStringProvider searchStringProvider) {
        widgetSearchSuggestions.searchStringProvider = searchStringProvider;
    }

    private final void configureUI(Model model) {
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter = this.adapter;
        if (widgetSearchSuggestionsAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter.setData(model.getSuggestionItems());
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter2 = this.adapter;
        if (widgetSearchSuggestionsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter2.setOnFilterClicked(new AnonymousClass1(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter3 = this.adapter;
        if (widgetSearchSuggestionsAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter3.setOnUserClicked(new AnonymousClass2(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter4 = this.adapter;
        if (widgetSearchSuggestionsAdapter4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter4.setOnChannelClicked(new AnonymousClass3(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter5 = this.adapter;
        if (widgetSearchSuggestionsAdapter5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter5.setOnHasClicked(new AnonymousClass4(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter6 = this.adapter;
        if (widgetSearchSuggestionsAdapter6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter6.setOnRecentQueryClicked(AnonymousClass5.INSTANCE);
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter7 = this.adapter;
        if (widgetSearchSuggestionsAdapter7 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter7.setOnClearHistoryClicked(AnonymousClass6.INSTANCE);
    }

    private final WidgetSearchSuggestionsBinding getBinding() {
        return (WidgetSearchSuggestionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2526b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.searchSuggestionsRecycler");
        this.adapter = (WidgetSearchSuggestionsAdapter) companion.configure(new WidgetSearchSuggestionsAdapter(recyclerView));
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            RecyclerView recyclerView2 = getBinding().f2526b;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.searchSuggestionsRecycler");
            recyclerView2.setItemAnimator(null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ContextSearchStringProvider contextSearchStringProvider = new ContextSearchStringProvider(requireContext());
        this.searchStringProvider = contextSearchStringProvider;
        Model.Companion companion = Model.INSTANCE;
        if (contextSearchStringProvider == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("searchStringProvider");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.get(contextSearchStringProvider), this, null, 2, null), WidgetSearchSuggestions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
