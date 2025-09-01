package com.discord.utilities.search.query.node.answer;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.validation.SearchData;
import com.discord.widgets.chat.input.MentionUtils;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: ChannelNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b$\u0010%J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0010J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u000e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\u0010¨\u0006&"}, d2 = {"Lcom/discord/utilities/search/query/node/answer/ChannelNode;", "Lcom/discord/utilities/search/query/node/answer/AnswerNode;", "Lcom/discord/utilities/search/network/SearchQuery$Builder;", "queryBuilder", "Lcom/discord/utilities/search/validation/SearchData;", "searchData", "Lcom/discord/utilities/search/query/FilterType;", "filterType", "", "updateQuery", "(Lcom/discord/utilities/search/network/SearchQuery$Builder;Lcom/discord/utilities/search/validation/SearchData;Lcom/discord/utilities/search/query/FilterType;)V", "", "isValid", "(Lcom/discord/utilities/search/validation/SearchData;)Z", "", "component1", "()Ljava/lang/String;", "channelName", "copy", "(Ljava/lang/String;)Lcom/discord/utilities/search/query/node/answer/ChannelNode;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "getText", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "", "getValidFilters", "()Ljava/util/Set;", "validFilters", "Ljava/lang/String;", "getChannelName", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelNode extends AnswerNode {
    private final String channelName;

    public ChannelNode(String str) {
        Intrinsics3.checkNotNullParameter(str, "channelName");
        this.channelName = str;
    }

    public static /* synthetic */ ChannelNode copy$default(ChannelNode channelNode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelNode.channelName;
        }
        return channelNode.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    public final ChannelNode copy(String channelName) {
        Intrinsics3.checkNotNullParameter(channelName, "channelName");
        return new ChannelNode(channelName);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ChannelNode) && Intrinsics3.areEqual(this.channelName, ((ChannelNode) other).channelName);
        }
        return true;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public /* bridge */ /* synthetic */ CharSequence getText() {
        return getText();
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public Set<FilterType> getValidFilters() {
        return SetsJVM.setOf(FilterType.IN);
    }

    public int hashCode() {
        String str = this.channelName;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public boolean isValid(SearchData searchData) {
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
        return searchData.getChannelNameIndex().containsKey(this.channelName);
    }

    public String toString() {
        return outline.J(outline.U("ChannelNode(channelName="), this.channelName, ")");
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public void updateQuery(SearchQuery.Builder queryBuilder, SearchData searchData, FilterType filterType) {
        Long l;
        Intrinsics3.checkNotNullParameter(queryBuilder, "queryBuilder");
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
        if (_Collections.contains(getValidFilters(), filterType) && (l = searchData.getChannelNameIndex().get(this.channelName)) != null) {
            queryBuilder.appendParam(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, String.valueOf(l.longValue()));
        }
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public String getText() {
        StringBuilder sbQ = outline.Q(MentionUtils.CHANNELS_CHAR);
        sbQ.append(this.channelName);
        return sbQ.toString();
    }
}
