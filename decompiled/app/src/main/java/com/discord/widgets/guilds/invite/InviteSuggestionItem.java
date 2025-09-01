package com.discord.widgets.guilds.invite;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InviteSuggestionItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \f2\u00020\u0001:\u0003\r\f\u000eB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u0082\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestionItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "hasSentInvite", "()Z", "", "type", "I", "getType", "()I", "<init>", "()V", "SearchNoResultsItem", "ChannelItem", "UserItem", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItem$SearchNoResultsItem;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItem$UserItem;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItem$ChannelItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class InviteSuggestionItem implements MGRecyclerDataPayload {

    /* renamed from: SearchNoResultsItem, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String key = "SEARCH_NO_RESULTS";
    private final int type;

    /* compiled from: InviteSuggestionItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u00108\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\u001a\u001a\u00020\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000fR\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestionItem$ChannelItem;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItem;", "", "hasSentInvite", "()Z", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "component2", "channel", "hasSent", "copy", "(Lcom/discord/api/channel/Channel;Z)Lcom/discord/widgets/guilds/invite/InviteSuggestionItem$ChannelItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/api/channel/Channel;", "getChannel", "Z", "getHasSent", "<init>", "(Lcom/discord/api/channel/Channel;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ChannelItem extends InviteSuggestionItem {
        private final Channel channel;
        private final boolean hasSent;
        private final String key;
        private final int type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelItem(Channel channel, boolean z2) {
            super(null);
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.hasSent = z2;
            this.type = 1;
            StringBuilder sbU = outline.U("c");
            sbU.append(String.valueOf(channel.getId()));
            this.key = sbU.toString();
        }

        public static /* synthetic */ ChannelItem copy$default(ChannelItem channelItem, Channel channel, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelItem.channel;
            }
            if ((i & 2) != 0) {
                z2 = channelItem.hasSent;
            }
            return channelItem.copy(channel, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getHasSent() {
            return this.hasSent;
        }

        public final ChannelItem copy(Channel channel, boolean hasSent) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new ChannelItem(channel, hasSent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelItem)) {
                return false;
            }
            ChannelItem channelItem = (ChannelItem) other;
            return Intrinsics3.areEqual(this.channel, channelItem.channel) && this.hasSent == channelItem.hasSent;
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

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem
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
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelItem(channel=");
            sbU.append(this.channel);
            sbU.append(", hasSent=");
            return outline.O(sbU, this.hasSent, ")");
        }
    }

    /* compiled from: InviteSuggestionItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestionItem$SearchNoResultsItem;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItem;", "", "hasSentInvite", "()Z", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.InviteSuggestionItem$SearchNoResultsItem, reason: from kotlin metadata */
    public static final class Companion extends InviteSuggestionItem {
        private Companion() {
            super(null);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return InviteSuggestionItem.access$getKey$cp();
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem
        public boolean hasSentInvite() {
            return true;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: InviteSuggestionItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\u0019\u001a\u00020\u00108\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0012R\u001c\u0010\u001c\u001a\u00020\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010\u0007¨\u0006#"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestionItem$UserItem;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItem;", "", "hasSentInvite", "()Z", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "component2", "user", "hasSent", "copy", "(Lcom/discord/models/user/User;Z)Lcom/discord/widgets/guilds/invite/InviteSuggestionItem$UserItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHasSent", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/models/user/User;", "getUser", "<init>", "(Lcom/discord/models/user/User;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UserItem extends InviteSuggestionItem {
        private final boolean hasSent;
        private final String key;
        private final int type;
        private final User user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserItem(User user, boolean z2) {
            super(null);
            Intrinsics3.checkNotNullParameter(user, "user");
            this.user = user;
            this.hasSent = z2;
            StringBuilder sbU = outline.U("u");
            sbU.append(String.valueOf(user.getId()));
            this.key = sbU.toString();
        }

        public static /* synthetic */ UserItem copy$default(UserItem userItem, User user, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                user = userItem.user;
            }
            if ((i & 2) != 0) {
                z2 = userItem.hasSent;
            }
            return userItem.copy(user, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getHasSent() {
            return this.hasSent;
        }

        public final UserItem copy(User user, boolean hasSent) {
            Intrinsics3.checkNotNullParameter(user, "user");
            return new UserItem(user, hasSent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserItem)) {
                return false;
            }
            UserItem userItem = (UserItem) other;
            return Intrinsics3.areEqual(this.user, userItem.user) && this.hasSent == userItem.hasSent;
        }

        public final boolean getHasSent() {
            return this.hasSent;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem
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
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("UserItem(user=");
            sbU.append(this.user);
            sbU.append(", hasSent=");
            return outline.O(sbU, this.hasSent, ")");
        }
    }

    private InviteSuggestionItem() {
        this.type = -1;
    }

    public static final /* synthetic */ String access$getKey$cp() {
        return key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public abstract boolean hasSentInvite();

    public /* synthetic */ InviteSuggestionItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
