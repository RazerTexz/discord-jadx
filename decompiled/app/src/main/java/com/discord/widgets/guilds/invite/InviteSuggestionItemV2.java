package com.discord.widgets.guilds.invite;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InviteSuggestionItemV2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00072\u00020\u0001:\u0004\b\u0007\t\nB\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "hasSentInvite", "()Z", "<init>", "()V", "Companion", "ChannelItem", "SearchNoResultsItem", "UserItem", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2$SearchNoResultsItem;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2$UserItem;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2$ChannelItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class InviteSuggestionItemV2 implements MGRecyclerDataPayload {
    public static final int TYPE_CHANNEL = 3;
    public static final int TYPE_EMPTY_SEARCH_RESULTS = 1;
    public static final int TYPE_USER = 2;

    /* compiled from: InviteSuggestionItemV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ.\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001b\u001a\u00020\u00128\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0014R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010 \u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010\u0007¨\u0006&"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2$ChannelItem;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2;", "", "hasSentInvite", "()Z", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "component2", "", "component3", "()Ljava/lang/String;", "channel", "hasSent", "searchQuery", "copy", "(Lcom/discord/api/channel/Channel;ZLjava/lang/String;)Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2$ChannelItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSearchQuery", "type", "I", "getType", "Z", "getHasSent", "key", "getKey", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;ZLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ChannelItem extends InviteSuggestionItemV2 {
        private final Channel channel;
        private final boolean hasSent;
        private final String key;
        private final String searchQuery;
        private final int type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelItem(Channel channel, boolean z2, String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(str, "searchQuery");
            this.channel = channel;
            this.hasSent = z2;
            this.searchQuery = str;
            this.type = 3;
            StringBuilder sbU = outline.U("c");
            sbU.append(String.valueOf(channel.getId()));
            sbU.append(str);
            this.key = sbU.toString();
        }

        public static /* synthetic */ ChannelItem copy$default(ChannelItem channelItem, Channel channel, boolean z2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelItem.channel;
            }
            if ((i & 2) != 0) {
                z2 = channelItem.hasSent;
            }
            if ((i & 4) != 0) {
                str = channelItem.searchQuery;
            }
            return channelItem.copy(channel, z2, str);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getHasSent() {
            return this.hasSent;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSearchQuery() {
            return this.searchQuery;
        }

        public final ChannelItem copy(Channel channel, boolean hasSent, String searchQuery) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
            return new ChannelItem(channel, hasSent, searchQuery);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelItem)) {
                return false;
            }
            ChannelItem channelItem = (ChannelItem) other;
            return Intrinsics3.areEqual(this.channel, channelItem.channel) && this.hasSent == channelItem.hasSent && Intrinsics3.areEqual(this.searchQuery, channelItem.searchQuery);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final boolean getHasSent() {
            return this.hasSent;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getSearchQuery() {
            return this.searchQuery;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItemV2
        public boolean hasSentInvite() {
            return this.hasSent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.hasSent;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            String str = this.searchQuery;
            return i2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelItem(channel=");
            sbU.append(this.channel);
            sbU.append(", hasSent=");
            sbU.append(this.hasSent);
            sbU.append(", searchQuery=");
            return outline.J(sbU, this.searchQuery, ")");
        }
    }

    /* compiled from: InviteSuggestionItemV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2$SearchNoResultsItem;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2;", "", "hasSentInvite", "()Z", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "", "type", "I", "getType", "()I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class SearchNoResultsItem extends InviteSuggestionItemV2 {
        public static final SearchNoResultsItem INSTANCE = new SearchNoResultsItem();
        private static final int type = 1;
        private static final String key = "SEARCH_NO_RESULTS";

        private SearchNoResultsItem() {
            super(null);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return type;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItemV2
        public boolean hasSentInvite() {
            return true;
        }
    }

    /* compiled from: InviteSuggestionItemV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ.\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001b\u001a\u00020\u00128\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0014R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001c\u0010 \u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u000bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2$UserItem;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2;", "", "hasSentInvite", "()Z", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "component2", "", "component3", "()Ljava/lang/String;", "user", "hasSent", "searchQuery", "copy", "(Lcom/discord/models/user/User;ZLjava/lang/String;)Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2$UserItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSearchQuery", "type", "I", "getType", "Lcom/discord/models/user/User;", "getUser", "key", "getKey", "Z", "getHasSent", "<init>", "(Lcom/discord/models/user/User;ZLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UserItem extends InviteSuggestionItemV2 {
        private final boolean hasSent;
        private final String key;
        private final String searchQuery;
        private final int type;
        private final User user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserItem(User user, boolean z2, String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(str, "searchQuery");
            this.user = user;
            this.hasSent = z2;
            this.searchQuery = str;
            this.type = 2;
            StringBuilder sbU = outline.U("u");
            sbU.append(String.valueOf(user.getId()));
            sbU.append(str);
            this.key = sbU.toString();
        }

        public static /* synthetic */ UserItem copy$default(UserItem userItem, User user, boolean z2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                user = userItem.user;
            }
            if ((i & 2) != 0) {
                z2 = userItem.hasSent;
            }
            if ((i & 4) != 0) {
                str = userItem.searchQuery;
            }
            return userItem.copy(user, z2, str);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getHasSent() {
            return this.hasSent;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSearchQuery() {
            return this.searchQuery;
        }

        public final UserItem copy(User user, boolean hasSent, String searchQuery) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
            return new UserItem(user, hasSent, searchQuery);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserItem)) {
                return false;
            }
            UserItem userItem = (UserItem) other;
            return Intrinsics3.areEqual(this.user, userItem.user) && this.hasSent == userItem.hasSent && Intrinsics3.areEqual(this.searchQuery, userItem.searchQuery);
        }

        public final boolean getHasSent() {
            return this.hasSent;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getSearchQuery() {
            return this.searchQuery;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItemV2
        public boolean hasSentInvite() {
            return this.hasSent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            boolean z2 = this.hasSent;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            String str = this.searchQuery;
            return i2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("UserItem(user=");
            sbU.append(this.user);
            sbU.append(", hasSent=");
            sbU.append(this.hasSent);
            sbU.append(", searchQuery=");
            return outline.J(sbU, this.searchQuery, ")");
        }
    }

    private InviteSuggestionItemV2() {
    }

    public abstract boolean hasSentInvite();

    public /* synthetic */ InviteSuggestionItemV2(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
