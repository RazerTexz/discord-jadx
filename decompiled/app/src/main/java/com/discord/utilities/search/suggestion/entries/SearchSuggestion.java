package com.discord.utilities.search.suggestion.entries;

import kotlin.Metadata;

/* compiled from: SearchSuggestion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0006R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion;", "", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "getCategory", "()Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "category", "Category", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface SearchSuggestion {

    /* compiled from: SearchSuggestion.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "", "<init>", "(Ljava/lang/String;I)V", "FILTER", "MENTIONS_USER", "FROM_USER", "HAS", "BEFORE_DATE", "IN_CHANNEL", "RECENT_QUERY", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum Category {
        FILTER,
        MENTIONS_USER,
        FROM_USER,
        HAS,
        BEFORE_DATE,
        IN_CHANNEL,
        RECENT_QUERY
    }

    Category getCategory();
}
