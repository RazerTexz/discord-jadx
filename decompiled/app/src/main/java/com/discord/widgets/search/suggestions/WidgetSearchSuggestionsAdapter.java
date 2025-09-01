package com.discord.widgets.search.suggestions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetSearchSuggestionItemHeaderBinding;
import com.discord.databinding.WidgetSearchSuggestionItemHeaderHistoryBinding;
import com.discord.databinding.WidgetSearchSuggestionsItemChannelBinding;
import com.discord.databinding.WidgetSearchSuggestionsItemHasBinding;
import com.discord.databinding.WidgetSearchSuggestionsItemRecentQueryBinding;
import com.discord.databinding.WidgetSearchSuggestionsItemSuggestionBinding;
import com.discord.databinding.WidgetSearchSuggestionsItemUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.mg_recycler.SingleTypePayload;
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
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.user.UserUtils;
import com.discord.views.StatusView;
import com.discord.views.UserListItemView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetSearchSuggestionsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\b/0123456B\u000f\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R.\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b0\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000b0\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R4\u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0004\u0012\u00020\u000b0\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R.\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000b0\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R.\u0010(\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000b0\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0015\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019¨\u00067"}, d2 = {"Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function0;", "", "onClearHistoryClicked", "Lkotlin/jvm/functions/Function0;", "getOnClearHistoryClicked", "()Lkotlin/jvm/functions/Function0;", "setOnClearHistoryClicked", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;", "onHasClicked", "Lkotlin/jvm/functions/Function1;", "getOnHasClicked", "()Lkotlin/jvm/functions/Function1;", "setOnHasClicked", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/utilities/search/query/FilterType;", "onFilterClicked", "getOnFilterClicked", "setOnFilterClicked", "", "Lcom/discord/utilities/search/query/node/QueryNode;", "onRecentQueryClicked", "getOnRecentQueryClicked", "setOnRecentQueryClicked", "Lcom/discord/utilities/search/suggestion/entries/UserSuggestion;", "onUserClicked", "getOnUserClicked", "setOnUserClicked", "Lcom/discord/utilities/search/suggestion/entries/ChannelSuggestion;", "onChannelClicked", "getOnChannelClicked", "setOnChannelClicked", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Companion", "FilterViewHolder", "HasViewHolder", "HeaderViewHolder", "HistoryHeaderViewHolder", "InChannelViewHolder", "RecentQueryViewHolder", "UserViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TYPE_FILTER = 2;
    private static final int TYPE_HAS = 5;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_HISTORY_HEADER = 1;
    private static final int TYPE_IN_CHANNEL = 4;
    private static final int TYPE_RECENT_QUERY = 6;
    private static final int TYPE_USER = 3;
    private Function1<? super ChannelSuggestion, Unit> onChannelClicked;
    private Function0<Unit> onClearHistoryClicked;
    private Function1<? super FilterType, Unit> onFilterClicked;
    private Function1<? super HasNode2, Unit> onHasClicked;
    private Function1<? super List<? extends QueryNode>, Unit> onRecentQueryClicked;
    private Function1<? super UserSuggestion, Unit> onUserClicked;

    /* compiled from: WidgetSearchSuggestionsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010!J\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\b\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\b\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\b\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u0006\u0010\b\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00178\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00178\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u00178\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0016\u0010\u001f\u001a\u00020\u00178\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019¨\u0006\""}, d2 = {"Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter$Companion;", "", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "category", "Lcom/discord/utilities/mg_recycler/SingleTypePayload;", "getHeaderItem", "(Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;)Lcom/discord/utilities/mg_recycler/SingleTypePayload;", "Lcom/discord/utilities/search/suggestion/entries/FilterSuggestion;", "data", "getFilterItem", "(Lcom/discord/utilities/search/suggestion/entries/FilterSuggestion;)Lcom/discord/utilities/mg_recycler/SingleTypePayload;", "Lcom/discord/utilities/search/suggestion/entries/UserSuggestion;", "getUserItem", "(Lcom/discord/utilities/search/suggestion/entries/UserSuggestion;)Lcom/discord/utilities/mg_recycler/SingleTypePayload;", "Lcom/discord/utilities/search/suggestion/entries/ChannelSuggestion;", "getInChannelItem", "(Lcom/discord/utilities/search/suggestion/entries/ChannelSuggestion;)Lcom/discord/utilities/mg_recycler/SingleTypePayload;", "Lcom/discord/utilities/search/suggestion/entries/HasSuggestion;", "getHasItem", "(Lcom/discord/utilities/search/suggestion/entries/HasSuggestion;)Lcom/discord/utilities/mg_recycler/SingleTypePayload;", "Lcom/discord/utilities/search/suggestion/entries/RecentQuerySuggestion;", "getRecentQueryItem", "(Lcom/discord/utilities/search/suggestion/entries/RecentQuerySuggestion;)Lcom/discord/utilities/mg_recycler/SingleTypePayload;", "", "TYPE_FILTER", "I", "TYPE_HAS", "TYPE_HEADER", "TYPE_HISTORY_HEADER", "TYPE_IN_CHANNEL", "TYPE_RECENT_QUERY", "TYPE_USER", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final SingleTypePayload<FilterSuggestion> getFilterItem(FilterSuggestion data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            return new SingleTypePayload<>(data, data.getCategory().name(), 2);
        }

        public final SingleTypePayload<HasSuggestion> getHasItem(HasSuggestion data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            return new SingleTypePayload<>(data, data.getHasAnswerOption().name(), 5);
        }

        public final SingleTypePayload<SearchSuggestion.Category> getHeaderItem(SearchSuggestion.Category category) {
            Intrinsics3.checkNotNullParameter(category, "category");
            return new SingleTypePayload<>(category, category.name(), category == SearchSuggestion.Category.RECENT_QUERY ? 1 : 0);
        }

        public final SingleTypePayload<ChannelSuggestion> getInChannelItem(ChannelSuggestion data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            return new SingleTypePayload<>(data, String.valueOf(data.getChannelId()), 4);
        }

        public final SingleTypePayload<RecentQuerySuggestion> getRecentQueryItem(RecentQuerySuggestion data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            return new SingleTypePayload<>(data, String.valueOf(data.hashCode()), 6);
        }

        public final SingleTypePayload<UserSuggestion> getUserItem(UserSuggestion data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            return new SingleTypePayload<>(data, data.getTargetType().name() + data.getUserId(), 3);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSearchSuggestionsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0003H\u0015¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter$FilterViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Landroid/content/Context;", "context", "Lcom/discord/utilities/search/query/FilterType;", "filterType", "Landroid/graphics/drawable/Drawable;", "getIconDrawable", "(Landroid/content/Context;Lcom/discord/utilities/search/query/FilterType;)Landroid/graphics/drawable/Drawable;", "", "getAnswerText", "(Lcom/discord/utilities/search/query/FilterType;)I", "getFilterText", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetSearchSuggestionsItemSuggestionBinding;", "binding", "Lcom/discord/databinding/WidgetSearchSuggestionsItemSuggestionBinding;", "searchSuggestionsAdapter", "<init>", "(Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class FilterViewHolder extends MGRecyclerViewHolder<WidgetSearchSuggestionsAdapter, MGRecyclerDataPayload> {
        private final WidgetSearchSuggestionsItemSuggestionBinding binding;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;
            public static final /* synthetic */ int[] $EnumSwitchMapping$2;

            static {
                FilterType.values();
                int[] iArr = new int[4];
                $EnumSwitchMapping$0 = iArr;
                FilterType filterType = FilterType.FROM;
                iArr[filterType.ordinal()] = 1;
                FilterType filterType2 = FilterType.MENTIONS;
                iArr[filterType2.ordinal()] = 2;
                FilterType filterType3 = FilterType.HAS;
                iArr[filterType3.ordinal()] = 3;
                FilterType filterType4 = FilterType.IN;
                iArr[filterType4.ordinal()] = 4;
                FilterType.values();
                int[] iArr2 = new int[4];
                $EnumSwitchMapping$1 = iArr2;
                iArr2[filterType.ordinal()] = 1;
                iArr2[filterType2.ordinal()] = 2;
                iArr2[filterType3.ordinal()] = 3;
                iArr2[filterType4.ordinal()] = 4;
                FilterType.values();
                int[] iArr3 = new int[4];
                $EnumSwitchMapping$2 = iArr3;
                iArr3[filterType.ordinal()] = 1;
                iArr3[filterType2.ordinal()] = 2;
                iArr3[filterType3.ordinal()] = 3;
                iArr3[filterType4.ordinal()] = 4;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FilterViewHolder(WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter) {
            super(R.layout.widget_search_suggestions_item_suggestion, widgetSearchSuggestionsAdapter);
            Intrinsics3.checkNotNullParameter(widgetSearchSuggestionsAdapter, "searchSuggestionsAdapter");
            View view = this.itemView;
            int i = R.id.suggestion_example_answer;
            TextView textView = (TextView) view.findViewById(R.id.suggestion_example_answer);
            if (textView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i = R.id.suggestion_example_filter;
                TextView textView2 = (TextView) view.findViewById(R.id.suggestion_example_filter);
                if (textView2 != null) {
                    i = R.id.suggestion_example_icon;
                    ImageView imageView = (ImageView) view.findViewById(R.id.suggestion_example_icon);
                    if (imageView != null) {
                        WidgetSearchSuggestionsItemSuggestionBinding widgetSearchSuggestionsItemSuggestionBinding = new WidgetSearchSuggestionsItemSuggestionBinding(relativeLayout, textView, relativeLayout, textView2, imageView);
                        Intrinsics3.checkNotNullExpressionValue(widgetSearchSuggestionsItemSuggestionBinding, "WidgetSearchSuggestionsI…ionBinding.bind(itemView)");
                        this.binding = widgetSearchSuggestionsItemSuggestionBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetSearchSuggestionsAdapter access$getAdapter$p(FilterViewHolder filterViewHolder) {
            return (WidgetSearchSuggestionsAdapter) filterViewHolder.adapter;
        }

        @StringRes
        private final int getAnswerText(FilterType filterType) {
            int iOrdinal = filterType.ordinal();
            if (iOrdinal == 0) {
                return R.string.search_answer_from;
            }
            if (iOrdinal == 1) {
                return R.string.search_answer_mentions;
            }
            if (iOrdinal == 2) {
                return R.string.search_answer_has;
            }
            if (iOrdinal == 3) {
                return R.string.search_answer_in;
            }
            throw new NoWhenBranchMatchedException();
        }

        @StringRes
        private final int getFilterText(FilterType filterType) {
            int iOrdinal = filterType.ordinal();
            if (iOrdinal == 0) {
                return R.string.search_filter_from;
            }
            if (iOrdinal == 1) {
                return R.string.search_filter_mentions;
            }
            if (iOrdinal == 2) {
                return R.string.search_filter_has;
            }
            if (iOrdinal == 3) {
                return R.string.search_filter_in;
            }
            throw new NoWhenBranchMatchedException();
        }

        private final Drawable getIconDrawable(Context context, FilterType filterType) {
            int iOrdinal = filterType.ordinal();
            if (iOrdinal == 0) {
                return ContextCompat.getDrawable(context, R.drawable.ic_members_24dp);
            }
            if (iOrdinal == 1) {
                return ContextCompat.getDrawable(context, R.drawable.ic_mentions_white_24dp);
            }
            if (iOrdinal == 2) {
                return ContextCompat.getDrawable(context, R.drawable.ic_attachment_white_24dp);
            }
            if (iOrdinal == 3) {
                return ContextCompat.getDrawable(context, R.drawable.ic_text_channel_white_24dp);
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        @SuppressLint({"SetTextI18n"})
        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            FilterType filterType = ((FilterSuggestion) ((SingleTypePayload) data).getData()).getFilterType();
            int filterText = getFilterText(filterType);
            int answerText = getAnswerText(filterType);
            this.binding.c.setOnClickListener(new WidgetSearchSuggestionsAdapter$FilterViewHolder$onConfigure$1(this, filterType));
            ImageView imageView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.suggestionExampleIcon");
            Context context = imageView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.suggestionExampleIcon.context");
            imageView.setImageDrawable(getIconDrawable(context, filterType));
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.suggestionExampleFilter");
            textView.setText(FormatUtils.l("**" + FormatUtils.h(outline.x(this.itemView, "itemView", "itemView.context"), filterText, new Object[0], null, 4) + "**:", new Object[0], null, 2));
            TextView textView2 = this.binding.f2530b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.suggestionExampleAnswer");
            textView2.setText(FormatUtils.h(outline.x(this.itemView, "itemView", "itemView.context"), answerText, new Object[0], null, 4));
        }
    }

    /* compiled from: WidgetSearchSuggestionsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0015¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter$HasViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/utilities/search/strings/SearchStringProvider;", "searchStringProvider", "Lcom/discord/utilities/search/strings/SearchStringProvider;", "Lcom/discord/databinding/WidgetSearchSuggestionsItemHasBinding;", "binding", "Lcom/discord/databinding/WidgetSearchSuggestionsItemHasBinding;", "searchSuggestionsAdapter", "<init>", "(Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class HasViewHolder extends MGRecyclerViewHolder<WidgetSearchSuggestionsAdapter, MGRecyclerDataPayload> {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final WidgetSearchSuggestionsItemHasBinding binding;
        private final SearchStringProvider searchStringProvider;

        /* compiled from: WidgetSearchSuggestionsAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter$HasViewHolder$Companion;", "", "Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;", "hasAnswerOption", "", "getIconRes", "(Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;)I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    HasNode2.values();
                    int[] iArr = new int[7];
                    $EnumSwitchMapping$0 = iArr;
                    iArr[HasNode2.FILE.ordinal()] = 1;
                    iArr[HasNode2.VIDEO.ordinal()] = 2;
                    iArr[HasNode2.IMAGE.ordinal()] = 3;
                    iArr[HasNode2.SOUND.ordinal()] = 4;
                    iArr[HasNode2.STICKER.ordinal()] = 5;
                    iArr[HasNode2.EMBED.ordinal()] = 6;
                    iArr[HasNode2.LINK.ordinal()] = 7;
                }
            }

            private Companion() {
            }

            public static final /* synthetic */ int access$getIconRes(Companion companion, HasNode2 hasNode2) {
                return companion.getIconRes(hasNode2);
            }

            @DrawableRes
            private final int getIconRes(HasNode2 hasAnswerOption) {
                switch (hasAnswerOption) {
                    case LINK:
                        return R.drawable.ic_diag_link_24dp;
                    case EMBED:
                        return R.drawable.ic_embed_white_24dp;
                    case FILE:
                        return R.drawable.ic_attachment_white_24dp;
                    case VIDEO:
                        return R.drawable.ic_play_circle_outline_white_24dp;
                    case IMAGE:
                        return R.drawable.ic_text_image_24dp;
                    case SOUND:
                        return R.drawable.ic_sound_24dp;
                    case STICKER:
                        return R.drawable.ic_sticker_icon_24dp;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HasViewHolder(WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter) {
            super(R.layout.widget_search_suggestions_item_has, widgetSearchSuggestionsAdapter);
            Intrinsics3.checkNotNullParameter(widgetSearchSuggestionsAdapter, "searchSuggestionsAdapter");
            View view = this.itemView;
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int i = R.id.search_suggestions_item_has_icon;
            ImageView imageView = (ImageView) view.findViewById(R.id.search_suggestions_item_has_icon);
            if (imageView != null) {
                i = R.id.search_suggestions_item_has_text;
                TextView textView = (TextView) view.findViewById(R.id.search_suggestions_item_has_text);
                if (textView != null) {
                    WidgetSearchSuggestionsItemHasBinding widgetSearchSuggestionsItemHasBinding = new WidgetSearchSuggestionsItemHasBinding((RelativeLayout) view, relativeLayout, imageView, textView);
                    Intrinsics3.checkNotNullExpressionValue(widgetSearchSuggestionsItemHasBinding, "WidgetSearchSuggestionsI…HasBinding.bind(itemView)");
                    this.binding = widgetSearchSuggestionsItemHasBinding;
                    Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.searchSuggestionItemHasContainer");
                    Context context = relativeLayout.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "binding.searchSuggestionItemHasContainer.context");
                    this.searchStringProvider = new ContextSearchStringProvider(context);
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetSearchSuggestionsAdapter access$getAdapter$p(HasViewHolder hasViewHolder) {
            return (WidgetSearchSuggestionsAdapter) hasViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        @SuppressLint({"SetTextI18n"})
        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            HasSuggestion hasSuggestion = (HasSuggestion) ((SingleTypePayload) data).getData();
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.searchSuggestionsItemHasText");
            textView.setText(hasSuggestion.getHasAnswerOption().getLocalizedInputText(this.searchStringProvider));
            this.binding.c.setImageResource(Companion.access$getIconRes(INSTANCE, hasSuggestion.getHasAnswerOption()));
            this.binding.f2528b.setOnClickListener(new WidgetSearchSuggestionsAdapter$HasViewHolder$onConfigure$1(this, hasSuggestion));
        }
    }

    /* compiled from: WidgetSearchSuggestionsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter$HeaderViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "category", "", "getCategoryLabel", "(Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;)I", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetSearchSuggestionItemHeaderBinding;", "binding", "Lcom/discord/databinding/WidgetSearchSuggestionItemHeaderBinding;", "searchSuggestionsAdapter", "<init>", "(Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class HeaderViewHolder extends MGRecyclerViewHolder<WidgetSearchSuggestionsAdapter, MGRecyclerDataPayload> {
        private final WidgetSearchSuggestionItemHeaderBinding binding;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                SearchSuggestion.Category.values();
                int[] iArr = new int[7];
                $EnumSwitchMapping$0 = iArr;
                iArr[SearchSuggestion.Category.FILTER.ordinal()] = 1;
                iArr[SearchSuggestion.Category.MENTIONS_USER.ordinal()] = 2;
                iArr[SearchSuggestion.Category.FROM_USER.ordinal()] = 3;
                iArr[SearchSuggestion.Category.HAS.ordinal()] = 4;
                iArr[SearchSuggestion.Category.BEFORE_DATE.ordinal()] = 5;
                iArr[SearchSuggestion.Category.IN_CHANNEL.ordinal()] = 6;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter) {
            super(R.layout.widget_search_suggestion_item_header, widgetSearchSuggestionsAdapter);
            Intrinsics3.checkNotNullParameter(widgetSearchSuggestionsAdapter, "searchSuggestionsAdapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            WidgetSearchSuggestionItemHeaderBinding widgetSearchSuggestionItemHeaderBinding = new WidgetSearchSuggestionItemHeaderBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(widgetSearchSuggestionItemHeaderBinding, "WidgetSearchSuggestionIt…derBinding.bind(itemView)");
            this.binding = widgetSearchSuggestionItemHeaderBinding;
        }

        private final int getCategoryLabel(SearchSuggestion.Category category) {
            if (category != null) {
                int iOrdinal = category.ordinal();
                if (iOrdinal == 0) {
                    return R.string.search_group_header_search_options;
                }
                if (iOrdinal == 1) {
                    return R.string.search_group_header_mentions;
                }
                if (iOrdinal == 2) {
                    return R.string.search_group_header_from;
                }
                if (iOrdinal == 3) {
                    return R.string.search_group_header_has;
                }
                if (iOrdinal == 4) {
                    return R.string.search_group_header_dates;
                }
                if (iOrdinal == 5) {
                    return R.string.search_group_header_channels;
                }
            }
            throw new IllegalArgumentException("couldn't resolve category: " + category);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            this.binding.f2524b.setText(getCategoryLabel((SearchSuggestion.Category) ((SingleTypePayload) data).getData()));
        }
    }

    /* compiled from: WidgetSearchSuggestionsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter$HistoryHeaderViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetSearchSuggestionItemHeaderHistoryBinding;", "binding", "Lcom/discord/databinding/WidgetSearchSuggestionItemHeaderHistoryBinding;", "searchSuggestionsAdapter", "<init>", "(Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class HistoryHeaderViewHolder extends MGRecyclerViewHolder<WidgetSearchSuggestionsAdapter, MGRecyclerDataPayload> {
        private final WidgetSearchSuggestionItemHeaderHistoryBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HistoryHeaderViewHolder(WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter) {
            super(R.layout.widget_search_suggestion_item_header_history, widgetSearchSuggestionsAdapter);
            Intrinsics3.checkNotNullParameter(widgetSearchSuggestionsAdapter, "searchSuggestionsAdapter");
            View view = this.itemView;
            int i = R.id.suggestion_item_header_history_clear_icon;
            ImageView imageView = (ImageView) view.findViewById(R.id.suggestion_item_header_history_clear_icon);
            if (imageView != null) {
                i = R.id.suggestion_item_header_history_divider;
                View viewFindViewById = view.findViewById(R.id.suggestion_item_header_history_divider);
                if (viewFindViewById != null) {
                    i = R.id.suggestion_item_header_history_text;
                    TextView textView = (TextView) view.findViewById(R.id.suggestion_item_header_history_text);
                    if (textView != null) {
                        WidgetSearchSuggestionItemHeaderHistoryBinding widgetSearchSuggestionItemHeaderHistoryBinding = new WidgetSearchSuggestionItemHeaderHistoryBinding((RelativeLayout) view, imageView, viewFindViewById, textView);
                        Intrinsics3.checkNotNullExpressionValue(widgetSearchSuggestionItemHeaderHistoryBinding, "WidgetSearchSuggestionIt…oryBinding.bind(itemView)");
                        this.binding = widgetSearchSuggestionItemHeaderHistoryBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetSearchSuggestionsAdapter access$getAdapter$p(HistoryHeaderViewHolder historyHeaderViewHolder) {
            return (WidgetSearchSuggestionsAdapter) historyHeaderViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            this.binding.f2525b.setOnClickListener(new WidgetSearchSuggestionsAdapter$HistoryHeaderViewHolder$onConfigure$1(this));
        }
    }

    /* compiled from: WidgetSearchSuggestionsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter$InChannelViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetSearchSuggestionsItemChannelBinding;", "binding", "Lcom/discord/databinding/WidgetSearchSuggestionsItemChannelBinding;", "searchSuggestionsAdapter", "<init>", "(Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class InChannelViewHolder extends MGRecyclerViewHolder<WidgetSearchSuggestionsAdapter, MGRecyclerDataPayload> {
        private final WidgetSearchSuggestionsItemChannelBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InChannelViewHolder(WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter) {
            super(R.layout.widget_search_suggestions_item_channel, widgetSearchSuggestionsAdapter);
            Intrinsics3.checkNotNullParameter(widgetSearchSuggestionsAdapter, "searchSuggestionsAdapter");
            View view = this.itemView;
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int i = R.id.search_suggestions_item_channel_icon;
            ImageView imageView = (ImageView) view.findViewById(R.id.search_suggestions_item_channel_icon);
            if (imageView != null) {
                i = R.id.search_suggestions_item_channel_text;
                TextView textView = (TextView) view.findViewById(R.id.search_suggestions_item_channel_text);
                if (textView != null) {
                    WidgetSearchSuggestionsItemChannelBinding widgetSearchSuggestionsItemChannelBinding = new WidgetSearchSuggestionsItemChannelBinding((RelativeLayout) view, relativeLayout, imageView, textView);
                    Intrinsics3.checkNotNullExpressionValue(widgetSearchSuggestionsItemChannelBinding, "WidgetSearchSuggestionsI…nelBinding.bind(itemView)");
                    this.binding = widgetSearchSuggestionsItemChannelBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetSearchSuggestionsAdapter access$getAdapter$p(InChannelViewHolder inChannelViewHolder) {
            return (WidgetSearchSuggestionsAdapter) inChannelViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ChannelSuggestion channelSuggestion = (ChannelSuggestion) ((SingleTypePayload) data).getData();
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.searchSuggestionsItemChannelText");
            textView.setText(channelSuggestion.getChannelName());
            this.binding.f2527b.setOnClickListener(new WidgetSearchSuggestionsAdapter$InChannelViewHolder$onConfigure$1(this, channelSuggestion));
        }
    }

    /* compiled from: WidgetSearchSuggestionsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter$RecentQueryViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetSearchSuggestionsItemRecentQueryBinding;", "binding", "Lcom/discord/databinding/WidgetSearchSuggestionsItemRecentQueryBinding;", "widgetSearchSuggestionsAdapter", "<init>", "(Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class RecentQueryViewHolder extends MGRecyclerViewHolder<WidgetSearchSuggestionsAdapter, MGRecyclerDataPayload> {
        private final WidgetSearchSuggestionsItemRecentQueryBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecentQueryViewHolder(WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter) {
            super(R.layout.widget_search_suggestions_item_recent_query, widgetSearchSuggestionsAdapter);
            Intrinsics3.checkNotNullParameter(widgetSearchSuggestionsAdapter, "widgetSearchSuggestionsAdapter");
            View view = this.itemView;
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int i = R.id.search_suggestions_item_recent_query_icon;
            ImageView imageView = (ImageView) view.findViewById(R.id.search_suggestions_item_recent_query_icon);
            if (imageView != null) {
                i = R.id.search_suggestions_item_recent_query_text;
                TextView textView = (TextView) view.findViewById(R.id.search_suggestions_item_recent_query_text);
                if (textView != null) {
                    WidgetSearchSuggestionsItemRecentQueryBinding widgetSearchSuggestionsItemRecentQueryBinding = new WidgetSearchSuggestionsItemRecentQueryBinding((RelativeLayout) view, relativeLayout, imageView, textView);
                    Intrinsics3.checkNotNullExpressionValue(widgetSearchSuggestionsItemRecentQueryBinding, "WidgetSearchSuggestionsI…eryBinding.bind(itemView)");
                    this.binding = widgetSearchSuggestionsItemRecentQueryBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetSearchSuggestionsAdapter access$getAdapter$p(RecentQueryViewHolder recentQueryViewHolder) {
            return (WidgetSearchSuggestionsAdapter) recentQueryViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            List<QueryNode> query = ((RecentQuerySuggestion) ((SingleTypePayload) data).getData()).getQuery();
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.searchSuggestionsItemRecentQueryText");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
            textView.setText(AstRenderer.render(query, context));
            this.binding.f2529b.setOnClickListener(new WidgetSearchSuggestionsAdapter$RecentQueryViewHolder$onConfigure$1(this, query));
        }
    }

    /* compiled from: WidgetSearchSuggestionsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter$UserViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetSearchSuggestionsItemUserBinding;", "binding", "Lcom/discord/databinding/WidgetSearchSuggestionsItemUserBinding;", "searchSuggestionsAdapter", "<init>", "(Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestionsAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class UserViewHolder extends MGRecyclerViewHolder<WidgetSearchSuggestionsAdapter, MGRecyclerDataPayload> {
        private final WidgetSearchSuggestionsItemUserBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserViewHolder(WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter) {
            super(R.layout.widget_search_suggestions_item_user, widgetSearchSuggestionsAdapter);
            Intrinsics3.checkNotNullParameter(widgetSearchSuggestionsAdapter, "searchSuggestionsAdapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            UserListItemView userListItemView = (UserListItemView) view;
            WidgetSearchSuggestionsItemUserBinding widgetSearchSuggestionsItemUserBinding = new WidgetSearchSuggestionsItemUserBinding(userListItemView, userListItemView);
            Intrinsics3.checkNotNullExpressionValue(widgetSearchSuggestionsItemUserBinding, "WidgetSearchSuggestionsI…serBinding.bind(itemView)");
            this.binding = widgetSearchSuggestionsItemUserBinding;
        }

        public static final /* synthetic */ WidgetSearchSuggestionsAdapter access$getAdapter$p(UserViewHolder userViewHolder) {
            return (WidgetSearchSuggestionsAdapter) userViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            UserSuggestion userSuggestion = (UserSuggestion) ((SingleTypePayload) data).getData();
            UserListItemView userListItemView = this.binding.f2531b;
            User user = userSuggestion.getUser();
            GuildMember guildMember = userSuggestion.getGuildMember();
            int i = UserListItemView.j;
            Objects.requireNonNull(userListItemView);
            Intrinsics3.checkNotNullParameter(user, "user");
            StringBuilder sb = new StringBuilder();
            sb.append(user.getUsername());
            UserUtils userUtils = UserUtils.INSTANCE;
            sb.append(userUtils.getDiscriminatorWithPadding(user));
            String string = sb.toString();
            String nick = guildMember != null ? guildMember.getNick() : null;
            if (nick == null || nick.length() == 0) {
                TextView textView = userListItemView.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.userListItemName");
                textView.setText(string);
                TextView textView2 = userListItemView.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.userListItemNameSecondary");
                textView2.setText("");
            } else {
                TextView textView3 = userListItemView.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.userListItemName");
                textView3.setText(nick);
                TextView textView4 = userListItemView.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.userListItemNameSecondary");
                textView4.setText(string);
            }
            SimpleDraweeView simpleDraweeView = userListItemView.binding.f99b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.userListItemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, user, R.dimen.avatar_size_standard, null, null, guildMember, 24, null);
            userListItemView.binding.e.setPresence(null);
            StatusView statusView = userListItemView.binding.e;
            Intrinsics3.checkNotNullExpressionValue(statusView, "binding.userListItemStatus");
            statusView.setVisibility(userUtils.isStatusVisible(user, (Presence) null, false) ? 0 : 8);
            this.binding.f2531b.setOnClickListener(new WidgetSearchSuggestionsAdapter$UserViewHolder$onConfigure$1(this, userSuggestion));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearchSuggestionsAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onFilterClicked = WidgetSearchSuggestionsAdapter$onFilterClicked$1.INSTANCE;
        this.onUserClicked = WidgetSearchSuggestionsAdapter$onUserClicked$1.INSTANCE;
        this.onChannelClicked = WidgetSearchSuggestionsAdapter$onChannelClicked$1.INSTANCE;
        this.onHasClicked = WidgetSearchSuggestionsAdapter$onHasClicked$1.INSTANCE;
        this.onRecentQueryClicked = WidgetSearchSuggestionsAdapter$onRecentQueryClicked$1.INSTANCE;
        this.onClearHistoryClicked = WidgetSearchSuggestionsAdapter$onClearHistoryClicked$1.INSTANCE;
    }

    public final Function1<ChannelSuggestion, Unit> getOnChannelClicked() {
        return this.onChannelClicked;
    }

    public final Function0<Unit> getOnClearHistoryClicked() {
        return this.onClearHistoryClicked;
    }

    public final Function1<FilterType, Unit> getOnFilterClicked() {
        return this.onFilterClicked;
    }

    public final Function1<HasNode2, Unit> getOnHasClicked() {
        return this.onHasClicked;
    }

    public final Function1<List<? extends QueryNode>, Unit> getOnRecentQueryClicked() {
        return this.onRecentQueryClicked;
    }

    public final Function1<UserSuggestion, Unit> getOnUserClicked() {
        return this.onUserClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnChannelClicked(Function1<? super ChannelSuggestion, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onChannelClicked = function1;
    }

    public final void setOnClearHistoryClicked(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onClearHistoryClicked = function0;
    }

    public final void setOnFilterClicked(Function1<? super FilterType, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onFilterClicked = function1;
    }

    public final void setOnHasClicked(Function1<? super HasNode2, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onHasClicked = function1;
    }

    public final void setOnRecentQueryClicked(Function1<? super List<? extends QueryNode>, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onRecentQueryClicked = function1;
    }

    public final void setOnUserClicked(Function1<? super UserSuggestion, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onUserClicked = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new HeaderViewHolder(this);
            case 1:
                return new HistoryHeaderViewHolder(this);
            case 2:
                return new FilterViewHolder(this);
            case 3:
                return new UserViewHolder(this);
            case 4:
                return new InChannelViewHolder(this);
            case 5:
                return new HasViewHolder(this);
            case 6:
                return new RecentQueryViewHolder(this);
            default:
                throw invalidViewTypeException(viewType);
        }
    }
}
