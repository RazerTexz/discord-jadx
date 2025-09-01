package com.discord.utilities.search.suggestion.entries;

import b.d.b.a.outline;
import com.discord.utilities.search.query.node.answer.HasNode2;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HasSuggestion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u00020\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/utilities/search/suggestion/entries/HasSuggestion;", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion;", "Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;", "component1", "()Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;", "hasAnswerOption", "copy", "(Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;)Lcom/discord/utilities/search/suggestion/entries/HasSuggestion;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "category", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "getCategory", "()Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;", "getHasAnswerOption", "<init>", "(Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class HasSuggestion implements SearchSuggestion {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SearchSuggestion.Category category;
    private final HasNode2 hasAnswerOption;

    /* compiled from: HasSuggestion.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/utilities/search/suggestion/entries/HasSuggestion$Companion;", "", "", "currentInput", "Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;", "hasAnswerOption", "Lcom/discord/utilities/search/strings/SearchStringProvider;", "searchStringProvider", "", "canComplete", "(Ljava/lang/CharSequence;Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;Lcom/discord/utilities/search/strings/SearchStringProvider;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final boolean canComplete(CharSequence currentInput, HasNode2 hasAnswerOption, SearchStringProvider searchStringProvider) {
            Intrinsics3.checkNotNullParameter(currentInput, "currentInput");
            Intrinsics3.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
            Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
            return Strings4.contains$default((CharSequence) hasAnswerOption.getLocalizedInputText(searchStringProvider), currentInput, false, 2, (Object) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HasSuggestion(HasNode2 hasNode2) {
        Intrinsics3.checkNotNullParameter(hasNode2, "hasAnswerOption");
        this.hasAnswerOption = hasNode2;
        this.category = SearchSuggestion.Category.HAS;
    }

    public static /* synthetic */ HasSuggestion copy$default(HasSuggestion hasSuggestion, HasNode2 hasNode2, int i, Object obj) {
        if ((i & 1) != 0) {
            hasNode2 = hasSuggestion.hasAnswerOption;
        }
        return hasSuggestion.copy(hasNode2);
    }

    /* renamed from: component1, reason: from getter */
    public final HasNode2 getHasAnswerOption() {
        return this.hasAnswerOption;
    }

    public final HasSuggestion copy(HasNode2 hasAnswerOption) {
        Intrinsics3.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        return new HasSuggestion(hasAnswerOption);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HasSuggestion) && Intrinsics3.areEqual(this.hasAnswerOption, ((HasSuggestion) other).hasAnswerOption);
        }
        return true;
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion.Category getCategory() {
        return this.category;
    }

    public final HasNode2 getHasAnswerOption() {
        return this.hasAnswerOption;
    }

    public int hashCode() {
        HasNode2 hasNode2 = this.hasAnswerOption;
        if (hasNode2 != null) {
            return hasNode2.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("HasSuggestion(hasAnswerOption=");
        sbU.append(this.hasAnswerOption);
        sbU.append(")");
        return sbU.toString();
    }
}
