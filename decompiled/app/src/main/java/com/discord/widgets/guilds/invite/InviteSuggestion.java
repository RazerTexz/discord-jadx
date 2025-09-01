package com.discord.widgets.guilds.invite;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InviteSuggestion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestion;", "", "<init>", "()V", "ChannelItem", "UserSuggestion", "Lcom/discord/widgets/guilds/invite/InviteSuggestion$UserSuggestion;", "Lcom/discord/widgets/guilds/invite/InviteSuggestion$ChannelItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class InviteSuggestion {

    /* compiled from: InviteSuggestion.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestion$ChannelItem;", "Lcom/discord/widgets/guilds/invite/InviteSuggestion;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "channel", "copy", "(Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/guilds/invite/InviteSuggestion$ChannelItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ChannelItem extends InviteSuggestion {
        private final Channel channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelItem(Channel channel) {
            super(null);
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
        }

        public static /* synthetic */ ChannelItem copy$default(ChannelItem channelItem, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelItem.channel;
            }
            return channelItem.copy(channel);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final ChannelItem copy(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new ChannelItem(channel);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ChannelItem) && Intrinsics3.areEqual(this.channel, ((ChannelItem) other).channel);
            }
            return true;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public int hashCode() {
            Channel channel = this.channel;
            if (channel != null) {
                return channel.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelItem(channel=");
            sbU.append(this.channel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: InviteSuggestion.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestion$UserSuggestion;", "Lcom/discord/widgets/guilds/invite/InviteSuggestion;", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "user", "copy", "(Lcom/discord/models/user/User;)Lcom/discord/widgets/guilds/invite/InviteSuggestion$UserSuggestion;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/user/User;", "getUser", "<init>", "(Lcom/discord/models/user/User;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UserSuggestion extends InviteSuggestion {
        private final User user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserSuggestion(User user) {
            super(null);
            Intrinsics3.checkNotNullParameter(user, "user");
            this.user = user;
        }

        public static /* synthetic */ UserSuggestion copy$default(UserSuggestion userSuggestion, User user, int i, Object obj) {
            if ((i & 1) != 0) {
                user = userSuggestion.user;
            }
            return userSuggestion.copy(user);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final UserSuggestion copy(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            return new UserSuggestion(user);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof UserSuggestion) && Intrinsics3.areEqual(this.user, ((UserSuggestion) other).user);
            }
            return true;
        }

        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            User user = this.user;
            if (user != null) {
                return user.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("UserSuggestion(user=");
            sbU.append(this.user);
            sbU.append(")");
            return sbU.toString();
        }
    }

    private InviteSuggestion() {
    }

    public /* synthetic */ InviteSuggestion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
