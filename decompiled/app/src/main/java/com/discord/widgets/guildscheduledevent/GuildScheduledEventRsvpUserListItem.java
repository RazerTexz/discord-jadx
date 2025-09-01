package com.discord.widgets.guildscheduledevent;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventRsvpUserListItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "<init>", "()V", "Companion", "RsvpUser", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListItem$RsvpUser;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class GuildScheduledEventRsvpUserListItem implements MGRecyclerDataPayload {
    public static final int TYPE_EVENT_RSVP_USER = 0;

    /* compiled from: GuildScheduledEventRsvpUserListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00013BM\u0012\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\u0010\u0017\u001a\u00060\u0002j\u0002`\u000f¢\u0006\u0004\b1\u00102J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ\u0014\u0010\u0010\u001a\u00060\u0002j\u0002`\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0005Jd\u0010\u0018\u001a\u00020\u00002\f\b\u0002\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0014\u001a\u00020\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\f\b\u0002\u0010\u0017\u001a\u00060\u0002j\u0002`\u000fHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001a\u0010\bJ\u0010\u0010\u001b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001b\u0010\fJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b\"\u0010\bR\u001c\u0010#\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010\bR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b%\u0010\bR\u0019\u0010\u0014\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010\fR\u001d\u0010\u0011\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010\u0005R\u001c\u0010*\u001a\u00020\n8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010\fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b,\u0010\bR\u001d\u0010\u0017\u001a\u00060\u0002j\u0002`\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b-\u0010\u0005R\u0019\u0010\u0012\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b.\u0010\bR\u0019\u0010/\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010!\u001a\u0004\b0\u0010\b¨\u00064"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListItem$RsvpUser;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListItem;", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()I", "component5", "component6", "Lcom/discord/primitives/GuildId;", "component7", "userId", "username", "userAvatar", "discriminator", "nickname", "guildAvatar", "guildId", "copy", "(JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;J)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListItem$RsvpUser;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGuildAvatar", "key", "getKey", "getUserAvatar", "I", "getDiscriminator", "J", "getUserId", "type", "getType", "getNickname", "getGuildId", "getUsername", "displayName", "getDisplayName", "<init>", "(JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;J)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class RsvpUser extends GuildScheduledEventRsvpUserListItem {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int discriminator;
        private final String displayName;
        private final String guildAvatar;
        private final long guildId;
        private final String key;
        private final String nickname;
        private final int type;
        private final String userAvatar;
        private final long userId;
        private final String username;

        /* compiled from: GuildScheduledEventRsvpUserListItem.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListItem$RsvpUser$Companion;", "", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventUser;", "guildScheduledEventUser", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListItem$RsvpUser;", "from", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventUser;J)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListItem$RsvpUser;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final RsvpUser from(GuildScheduledEventUser guildScheduledEventUser, long guildId) {
                Intrinsics3.checkNotNullParameter(guildScheduledEventUser, "guildScheduledEventUser");
                return new RsvpUser(guildScheduledEventUser.getUser().getId(), guildScheduledEventUser.getUser().getUsername(), guildScheduledEventUser.getUser().getAvatar(), guildScheduledEventUser.getUser().getDiscriminator(), guildScheduledEventUser.getGuildMember().getNick(), guildScheduledEventUser.getGuildMember().getAvatarHash(), guildId);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RsvpUser(long j, String str, String str2, int i, String str3, String str4, long j2) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "username");
            this.userId = j;
            this.username = str;
            this.userAvatar = str2;
            this.discriminator = i;
            this.nickname = str3;
            this.guildAvatar = str4;
            this.guildId = j2;
            this.key = String.valueOf(j);
            this.displayName = str3 != null ? str3 : str;
        }

        public static /* synthetic */ RsvpUser copy$default(RsvpUser rsvpUser, long j, String str, String str2, int i, String str3, String str4, long j2, int i2, Object obj) {
            return rsvpUser.copy((i2 & 1) != 0 ? rsvpUser.userId : j, (i2 & 2) != 0 ? rsvpUser.username : str, (i2 & 4) != 0 ? rsvpUser.userAvatar : str2, (i2 & 8) != 0 ? rsvpUser.discriminator : i, (i2 & 16) != 0 ? rsvpUser.nickname : str3, (i2 & 32) != 0 ? rsvpUser.guildAvatar : str4, (i2 & 64) != 0 ? rsvpUser.guildId : j2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getUserId() {
            return this.userId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getUsername() {
            return this.username;
        }

        /* renamed from: component3, reason: from getter */
        public final String getUserAvatar() {
            return this.userAvatar;
        }

        /* renamed from: component4, reason: from getter */
        public final int getDiscriminator() {
            return this.discriminator;
        }

        /* renamed from: component5, reason: from getter */
        public final String getNickname() {
            return this.nickname;
        }

        /* renamed from: component6, reason: from getter */
        public final String getGuildAvatar() {
            return this.guildAvatar;
        }

        /* renamed from: component7, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final RsvpUser copy(long userId, String username, String userAvatar, int discriminator, String nickname, String guildAvatar, long guildId) {
            Intrinsics3.checkNotNullParameter(username, "username");
            return new RsvpUser(userId, username, userAvatar, discriminator, nickname, guildAvatar, guildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RsvpUser)) {
                return false;
            }
            RsvpUser rsvpUser = (RsvpUser) other;
            return this.userId == rsvpUser.userId && Intrinsics3.areEqual(this.username, rsvpUser.username) && Intrinsics3.areEqual(this.userAvatar, rsvpUser.userAvatar) && this.discriminator == rsvpUser.discriminator && Intrinsics3.areEqual(this.nickname, rsvpUser.nickname) && Intrinsics3.areEqual(this.guildAvatar, rsvpUser.guildAvatar) && this.guildId == rsvpUser.guildId;
        }

        public final int getDiscriminator() {
            return this.discriminator;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final String getGuildAvatar() {
            return this.guildAvatar;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getNickname() {
            return this.nickname;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final String getUserAvatar() {
            return this.userAvatar;
        }

        public final long getUserId() {
            return this.userId;
        }

        public final String getUsername() {
            return this.username;
        }

        public int hashCode() {
            int iA = b.a(this.userId) * 31;
            String str = this.username;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.userAvatar;
            int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.discriminator) * 31;
            String str3 = this.nickname;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.guildAvatar;
            return b.a(this.guildId) + ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("RsvpUser(userId=");
            sbU.append(this.userId);
            sbU.append(", username=");
            sbU.append(this.username);
            sbU.append(", userAvatar=");
            sbU.append(this.userAvatar);
            sbU.append(", discriminator=");
            sbU.append(this.discriminator);
            sbU.append(", nickname=");
            sbU.append(this.nickname);
            sbU.append(", guildAvatar=");
            sbU.append(this.guildAvatar);
            sbU.append(", guildId=");
            return outline.C(sbU, this.guildId, ")");
        }
    }

    private GuildScheduledEventRsvpUserListItem() {
    }

    public /* synthetic */ GuildScheduledEventRsvpUserListItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
