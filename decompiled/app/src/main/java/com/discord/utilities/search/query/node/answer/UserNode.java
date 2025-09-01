package com.discord.utilities.search.query.node.answer;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.validation.SearchData;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: UserNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0013J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u001a\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u001e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00118V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010$R\u0019\u0010\u0014\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010\u0013¨\u0006)"}, d2 = {"Lcom/discord/utilities/search/query/node/answer/UserNode;", "Lcom/discord/utilities/search/query/node/answer/AnswerNode;", "", "component2", "()I", "Lcom/discord/utilities/search/network/SearchQuery$Builder;", "queryBuilder", "Lcom/discord/utilities/search/validation/SearchData;", "searchData", "Lcom/discord/utilities/search/query/FilterType;", "filterType", "", "updateQuery", "(Lcom/discord/utilities/search/network/SearchQuery$Builder;Lcom/discord/utilities/search/validation/SearchData;Lcom/discord/utilities/search/query/FilterType;)V", "", "isValid", "(Lcom/discord/utilities/search/validation/SearchData;)Z", "", "component1", "()Ljava/lang/String;", "userName", "discriminator", "copy", "(Ljava/lang/String;I)Lcom/discord/utilities/search/query/node/answer/UserNode;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "getValidFilters", "()Ljava/util/Set;", "validFilters", "getText", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "I", "Ljava/lang/String;", "getUserName", "<init>", "(Ljava/lang/String;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class UserNode extends AnswerNode {
    private final int discriminator;
    private final String userName;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FilterType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[FilterType.FROM.ordinal()] = 1;
            iArr[FilterType.MENTIONS.ordinal()] = 2;
        }
    }

    public UserNode(String str, int i) {
        Intrinsics3.checkNotNullParameter(str, "userName");
        this.userName = str;
        this.discriminator = i;
    }

    /* renamed from: component2, reason: from getter */
    private final int getDiscriminator() {
        return this.discriminator;
    }

    public static /* synthetic */ UserNode copy$default(UserNode userNode, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userNode.userName;
        }
        if ((i2 & 2) != 0) {
            i = userNode.discriminator;
        }
        return userNode.copy(str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    public final UserNode copy(String userName, int discriminator) {
        Intrinsics3.checkNotNullParameter(userName, "userName");
        return new UserNode(userName, discriminator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserNode)) {
            return false;
        }
        UserNode userNode = (UserNode) other;
        return Intrinsics3.areEqual(this.userName, userNode.userName) && this.discriminator == userNode.discriminator;
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public /* bridge */ /* synthetic */ CharSequence getText() {
        return getText();
    }

    public final String getUserName() {
        return this.userName;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public Set<FilterType> getValidFilters() {
        return Sets5.setOf((Object[]) new FilterType[]{FilterType.FROM, FilterType.MENTIONS});
    }

    public int hashCode() {
        String str = this.userName;
        return ((str != null ? str.hashCode() : 0) * 31) + this.discriminator;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public boolean isValid(SearchData searchData) {
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
        return searchData.getUserId(this.userName, this.discriminator) != null;
    }

    public String toString() {
        StringBuilder sbU = outline.U("UserNode(userName=");
        sbU.append(this.userName);
        sbU.append(", discriminator=");
        return outline.B(sbU, this.discriminator, ")");
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public void updateQuery(SearchQuery.Builder queryBuilder, SearchData searchData, FilterType filterType) {
        String str;
        Intrinsics3.checkNotNullParameter(queryBuilder, "queryBuilder");
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
        if (filterType == null) {
            return;
        }
        int iOrdinal = filterType.ordinal();
        if (iOrdinal == 0) {
            str = "author_id";
        } else if (iOrdinal != 1) {
            return;
        } else {
            str = "mentions";
        }
        queryBuilder.appendParam(str, String.valueOf(searchData.getUserId(this.userName, this.discriminator)));
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public String getText() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.userName);
        sb.append("#");
        String str = String.format("%04d", Arrays.copyOf(new Object[]{Integer.valueOf(this.discriminator)}, 1));
        Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        sb.append(str);
        return sb.toString();
    }
}
