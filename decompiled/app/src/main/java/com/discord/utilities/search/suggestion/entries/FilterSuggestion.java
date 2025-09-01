package com.discord.utilities.search.suggestion.entries;

import b.d.b.a.outline;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FilterSuggestion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u00020\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/utilities/search/suggestion/entries/FilterSuggestion;", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion;", "Lcom/discord/utilities/search/query/FilterType;", "component1", "()Lcom/discord/utilities/search/query/FilterType;", "filterType", "copy", "(Lcom/discord/utilities/search/query/FilterType;)Lcom/discord/utilities/search/suggestion/entries/FilterSuggestion;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "category", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "getCategory", "()Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "Lcom/discord/utilities/search/query/FilterType;", "getFilterType", "<init>", "(Lcom/discord/utilities/search/query/FilterType;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class FilterSuggestion implements SearchSuggestion {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SearchSuggestion.Category category;
    private final FilterType filterType;

    /* compiled from: FilterSuggestion.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/utilities/search/suggestion/entries/FilterSuggestion$Companion;", "", "Lcom/discord/utilities/search/query/FilterType;", "filterType", "Lcom/discord/utilities/search/strings/SearchStringProvider;", "searchStringProvider", "", "getStringRepresentation", "(Lcom/discord/utilities/search/query/FilterType;Lcom/discord/utilities/search/strings/SearchStringProvider;)Ljava/lang/String;", "", "currentInput", "", "canComplete", "(Ljava/lang/CharSequence;Lcom/discord/utilities/search/query/FilterType;Lcom/discord/utilities/search/strings/SearchStringProvider;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                FilterType.values();
                int[] iArr = new int[4];
                $EnumSwitchMapping$0 = iArr;
                iArr[FilterType.FROM.ordinal()] = 1;
                iArr[FilterType.MENTIONS.ordinal()] = 2;
                iArr[FilterType.HAS.ordinal()] = 3;
                iArr[FilterType.IN.ordinal()] = 4;
            }
        }

        private Companion() {
        }

        private final String getStringRepresentation(FilterType filterType, SearchStringProvider searchStringProvider) {
            String fromFilterString;
            int iOrdinal = filterType.ordinal();
            if (iOrdinal == 0) {
                fromFilterString = searchStringProvider.getFromFilterString();
            } else if (iOrdinal == 1 || iOrdinal == 2) {
                fromFilterString = searchStringProvider.getMentionsFilterString();
            } else {
                if (iOrdinal != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                fromFilterString = searchStringProvider.getInFilterString();
            }
            return fromFilterString + MentionUtils.EMOJIS_AND_STICKERS_CHAR;
        }

        public final boolean canComplete(CharSequence currentInput, FilterType filterType, SearchStringProvider searchStringProvider) {
            Intrinsics3.checkNotNullParameter(currentInput, "currentInput");
            Intrinsics3.checkNotNullParameter(filterType, "filterType");
            Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
            return Strings4.contains$default((CharSequence) getStringRepresentation(filterType, searchStringProvider), currentInput, false, 2, (Object) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FilterSuggestion(FilterType filterType) {
        Intrinsics3.checkNotNullParameter(filterType, "filterType");
        this.filterType = filterType;
        this.category = SearchSuggestion.Category.FILTER;
    }

    public static /* synthetic */ FilterSuggestion copy$default(FilterSuggestion filterSuggestion, FilterType filterType, int i, Object obj) {
        if ((i & 1) != 0) {
            filterType = filterSuggestion.filterType;
        }
        return filterSuggestion.copy(filterType);
    }

    /* renamed from: component1, reason: from getter */
    public final FilterType getFilterType() {
        return this.filterType;
    }

    public final FilterSuggestion copy(FilterType filterType) {
        Intrinsics3.checkNotNullParameter(filterType, "filterType");
        return new FilterSuggestion(filterType);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof FilterSuggestion) && Intrinsics3.areEqual(this.filterType, ((FilterSuggestion) other).filterType);
        }
        return true;
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion.Category getCategory() {
        return this.category;
    }

    public final FilterType getFilterType() {
        return this.filterType;
    }

    public int hashCode() {
        FilterType filterType = this.filterType;
        if (filterType != null) {
            return filterType.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("FilterSuggestion(filterType=");
        sbU.append(this.filterType);
        sbU.append(")");
        return sbU.toString();
    }
}
