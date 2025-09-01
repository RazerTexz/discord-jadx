package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.presence.ClientStatus;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import kotlin.Metadata;

/* compiled from: WidgetGlobalSearchScoreStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010\t\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0010\u0010\b\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ'\u0010\f\u001a\u00020\u0003*\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u00052\n\u0010\u000b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u0003*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0003*\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u00020\u0003*\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchScoreStrategy;", "", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "", "searchType", "", "", "Lcom/discord/primitives/ChannelId;", "frecencyChannels", "score", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;ILjava/util/Collection;)I", "channelId", "scoreFrecency", "(Ljava/util/Collection;J)I", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemUser;", "scoreUser", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemUser;I)I", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemChannel;", "scoreChannel", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemChannel;)I", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "scoreMatchedResult", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;)I", "FUZZY_MATCH_SCORE_MAX_DEDUCTION", "I", "FRECENCY_PRI_LIMIT", "FUZZY_MATCH_SCORE_BASE", "MENTIONS_MATCH_SCORE", "<init>", "()V", "SearchType", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchScoreStrategy {
    public static final int FRECENCY_PRI_LIMIT = 50;
    private static final int FUZZY_MATCH_SCORE_BASE = -100;
    private static final int FUZZY_MATCH_SCORE_MAX_DEDUCTION = 20;
    public static final WidgetGlobalSearchScoreStrategy INSTANCE = new WidgetGlobalSearchScoreStrategy();
    private static final int MENTIONS_MATCH_SCORE = 100;

    /* compiled from: WidgetGlobalSearchScoreStrategy.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchScoreStrategy$SearchType;", "", "", "dmChannelWeight", "I", "getDmChannelWeight", "()I", "friendWeight", "getFriendWeight", "<init>", "(Ljava/lang/String;III)V", "USER", "NONE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum SearchType {
        USER(10, 5),
        NONE(1, 1);

        private final int dmChannelWeight;
        private final int friendWeight;

        SearchType(int i, int i2) {
            this.friendWeight = i;
            this.dmChannelWeight = i2;
        }

        public final int getDmChannelWeight() {
            return this.dmChannelWeight;
        }

        public final int getFriendWeight() {
            return this.friendWeight;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ClientStatus.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[ClientStatus.ONLINE.ordinal()] = 1;
            iArr[ClientStatus.IDLE.ordinal()] = 2;
            iArr[ClientStatus.DND.ordinal()] = 3;
        }
    }

    private WidgetGlobalSearchScoreStrategy() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int score(WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, int i, Collection<Long> collection) {
        int iScoreChannel;
        Intrinsics3.checkNotNullParameter(itemDataPayload, "$this$score");
        Intrinsics3.checkNotNullParameter(collection, "frecencyChannels");
        Channel channel = itemDataPayload.getChannel();
        int iScoreFrecency = scoreFrecency(collection, channel != null ? channel.getId() : 0L);
        if (!(itemDataPayload instanceof WidgetGlobalSearchModel.ItemUser)) {
            if (itemDataPayload instanceof WidgetGlobalSearchModel.ItemChannel) {
                iScoreChannel = scoreChannel((WidgetGlobalSearchModel.ItemChannel) itemDataPayload);
            }
            if (itemDataPayload.getMentions() > 0) {
                iScoreFrecency += itemDataPayload.getMentions() + 100;
            }
            return scoreMatchedResult(itemDataPayload.getMatchedResult()) + iScoreFrecency;
        }
        iScoreChannel = scoreUser((WidgetGlobalSearchModel.ItemUser) itemDataPayload, i);
        iScoreFrecency += iScoreChannel;
        if (itemDataPayload.getMentions() > 0) {
        }
        return scoreMatchedResult(itemDataPayload.getMatchedResult()) + iScoreFrecency;
    }

    public final int scoreChannel(WidgetGlobalSearchModel.ItemChannel itemChannel) {
        Intrinsics3.checkNotNullParameter(itemChannel, "$this$scoreChannel");
        Guild guild = itemChannel.getGuild();
        return (guild != null ? guild.getMemberCount() : 0) > 200 ? -5 : 0;
    }

    public final int scoreFrecency(Collection<Long> collection, long j) {
        Intrinsics3.checkNotNullParameter(collection, "$this$scoreFrecency");
        int iIndexOf = _Collections.indexOf(collection, Long.valueOf(j));
        if (iIndexOf == -1) {
            return 0;
        }
        if (iIndexOf >= 0 && 5 > iIndexOf) {
            return 60 - iIndexOf;
        }
        if (5 <= iIndexOf && 50 > iIndexOf) {
            return 55 - iIndexOf;
        }
        return 2;
    }

    public final int scoreMatchedResult(WidgetGlobalSearchModel.MatchedResult matchedResult) {
        Intrinsics3.checkNotNullParameter(matchedResult, "$this$scoreMatchedResult");
        int firstMatchIndex = matchedResult.getFirstMatchIndex();
        int i = 0;
        int iMin = firstMatchIndex == -1 ? (-100) - Math.min(matchedResult.getValue().length(), 20) : (firstMatchIndex >= 0 && 10 >= firstMatchIndex) ? 15 - matchedResult.getFirstMatchIndex() : 0;
        if (matchedResult.getFirstMatchIndex() == 0) {
            i = 2;
        } else if (matchedResult.getFirstMatchIndex() > 0 && !Character.isLetterOrDigit(matchedResult.getValue().charAt(matchedResult.getFirstMatchIndex() - 1))) {
            i = 1;
        }
        return iMin + i;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int scoreUser(WidgetGlobalSearchModel.ItemUser itemUser, int i) {
        int i2;
        Intrinsics3.checkNotNullParameter(itemUser, "$this$scoreUser");
        SearchType searchType = i != 1 ? SearchType.NONE : SearchType.USER;
        Presence presence = itemUser.getPresence();
        ClientStatus status = presence != null ? presence.getStatus() : null;
        if (status != null) {
            int iOrdinal = status.ordinal();
            i2 = iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? 0 : 2 : 3 : 4;
        }
        return i2 + (itemUser.isFriend() ? searchType.getFriendWeight() : 0) + (itemUser.getChannel() != null ? searchType.getDmChannelWeight() : 0) + (Intrinsics3.areEqual(itemUser.getMatchedResult().getValue(), itemUser.getUser().getUsername()) ? 2 : 0);
    }
}
