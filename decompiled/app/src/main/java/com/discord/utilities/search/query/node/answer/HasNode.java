package com.discord.utilities.search.query.node.answer;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.validation.SearchData;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: HasNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b)\u0010*B\u0019\b\u0016\u0012\u0006\u0010+\u001a\u00020\u0018\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b)\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\"8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001c\u0010\u0015\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010(¨\u0006/"}, d2 = {"Lcom/discord/utilities/search/query/node/answer/HasNode;", "Lcom/discord/utilities/search/query/node/answer/AnswerNode;", "Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;", "component1", "()Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;", "Lcom/discord/utilities/search/validation/SearchData;", "searchData", "", "isValid", "(Lcom/discord/utilities/search/validation/SearchData;)Z", "Lcom/discord/utilities/search/network/SearchQuery$Builder;", "queryBuilder", "Lcom/discord/utilities/search/query/FilterType;", "filterType", "", "updateQuery", "(Lcom/discord/utilities/search/network/SearchQuery$Builder;Lcom/discord/utilities/search/validation/SearchData;Lcom/discord/utilities/search/query/FilterType;)V", "", "component2", "()Ljava/lang/CharSequence;", "hasAnswerOption", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "copy", "(Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;Ljava/lang/CharSequence;)Lcom/discord/utilities/search/query/node/answer/HasNode;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "getValidFilters", "()Ljava/util/Set;", "validFilters", "Ljava/lang/CharSequence;", "getText", "Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;", "<init>", "(Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;Ljava/lang/CharSequence;)V", "match", "Lcom/discord/utilities/search/strings/SearchStringProvider;", "searchStringProvider", "(Ljava/lang/String;Lcom/discord/utilities/search/strings/SearchStringProvider;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class HasNode extends AnswerNode {
    private final HasNode2 hasAnswerOption;
    private final CharSequence text;

    public HasNode(HasNode2 hasNode2, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(hasNode2, "hasAnswerOption");
        Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.hasAnswerOption = hasNode2;
        this.text = charSequence;
    }

    /* renamed from: component1, reason: from getter */
    private final HasNode2 getHasAnswerOption() {
        return this.hasAnswerOption;
    }

    public static /* synthetic */ HasNode copy$default(HasNode hasNode, HasNode2 hasNode2, CharSequence charSequence, int i, Object obj) {
        if ((i & 1) != 0) {
            hasNode2 = hasNode.hasAnswerOption;
        }
        if ((i & 2) != 0) {
            charSequence = hasNode.getText();
        }
        return hasNode.copy(hasNode2, charSequence);
    }

    public final CharSequence component2() {
        return getText();
    }

    public final HasNode copy(HasNode2 hasAnswerOption, CharSequence text) {
        Intrinsics3.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        return new HasNode(hasAnswerOption, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HasNode)) {
            return false;
        }
        HasNode hasNode = (HasNode) other;
        return Intrinsics3.areEqual(this.hasAnswerOption, hasNode.hasAnswerOption) && Intrinsics3.areEqual(getText(), hasNode.getText());
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public CharSequence getText() {
        return this.text;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public Set<FilterType> getValidFilters() {
        return SetsJVM.setOf(FilterType.HAS);
    }

    public int hashCode() {
        HasNode2 hasNode2 = this.hasAnswerOption;
        int iHashCode = (hasNode2 != null ? hasNode2.hashCode() : 0) * 31;
        CharSequence text = getText();
        return iHashCode + (text != null ? text.hashCode() : 0);
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public boolean isValid(SearchData searchData) {
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
        return true;
    }

    public String toString() {
        StringBuilder sbU = outline.U("HasNode(hasAnswerOption=");
        sbU.append(this.hasAnswerOption);
        sbU.append(", text=");
        sbU.append(getText());
        sbU.append(")");
        return sbU.toString();
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public void updateQuery(SearchQuery.Builder queryBuilder, SearchData searchData, FilterType filterType) {
        Intrinsics3.checkNotNullParameter(queryBuilder, "queryBuilder");
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
        if (_Collections.contains(getValidFilters(), filterType)) {
            queryBuilder.appendParam("has", this.hasAnswerOption.getRestParamValue());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HasNode(String str, SearchStringProvider searchStringProvider) {
        this(HasNode2.INSTANCE.getOptionFromString(str, searchStringProvider), str);
        Intrinsics3.checkNotNullParameter(str, "match");
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
    }
}
