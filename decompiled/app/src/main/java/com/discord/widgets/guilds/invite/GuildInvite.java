package com.discord.widgets.guilds.invite;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.user.User;
import com.discord.models.domain.ModelInvite;
import com.discord.models.invite.InviteUtils;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u0000 22\u00020\u0001:\u00012B_\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u000e\u0010\u0016\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\u000e\u0010\u0017\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\n\u0012\u000e\u0010\u0018\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\f\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u000e\u0010\u001b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0013¢\u0006\u0004\b0\u00101J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0018\u0010\r\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\tJv\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\u0010\b\u0002\u0010\u0016\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u0010\b\u0002\u0010\u0017\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\n2\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\f2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\u0010\b\u0002\u0010\u001b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0013HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010\u0004R!\u0010\u0018\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b)\u0010\tR\u0019\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b\u0019\u0010\u0010R!\u0010\u0017\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b+\u0010\tR!\u0010\u001b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b,\u0010\tR\u0019\u0010\u001a\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b.\u0010\u0012R!\u0010\u0016\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b/\u0010\t¨\u00063"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInvite;", "Ljava/io/Serializable;", "", "toLink", "()Ljava/lang/String;", "component1", "", "Lcom/discord/primitives/GuildId;", "component2", "()Ljava/lang/Long;", "Lcom/discord/primitives/ChannelId;", "component3", "Lcom/discord/primitives/UserId;", "component4", "", "component5", "()Z", "component6", "()J", "Lcom/discord/primitives/GuildScheduledEventId;", "component7", "inviteCode", "guildId", "channelId", "inviterId", "isStaticInvite", "expirationTimeMs", "guildScheduledEventId", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;ZJLjava/lang/Long;)Lcom/discord/widgets/guilds/invite/GuildInvite;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getInviteCode", "Ljava/lang/Long;", "getInviterId", "Z", "getChannelId", "getGuildScheduledEventId", "J", "getExpirationTimeMs", "getGuildId", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;ZJLjava/lang/Long;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class GuildInvite implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long channelId;
    private final long expirationTimeMs;
    private final Long guildId;
    private final Long guildScheduledEventId;
    private final String inviteCode;
    private final Long inviterId;
    private final boolean isStaticInvite;

    /* compiled from: GuildInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInvite$Companion;", "", "Lcom/discord/models/domain/ModelInvite;", "invite", "Lcom/discord/widgets/guilds/invite/GuildInvite;", "createFromModelInvite", "(Lcom/discord/models/domain/ModelInvite;)Lcom/discord/widgets/guilds/invite/GuildInvite;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final GuildInvite createFromModelInvite(ModelInvite invite) {
            boolean zAreEqual;
            Intrinsics3.checkNotNullParameter(invite, "invite");
            GuildScheduledEvent guildScheduledEvent = invite.getGuildScheduledEvent();
            Long lValueOf = null;
            if ((guildScheduledEvent != null ? guildScheduledEvent.getChannelId() : null) != null) {
                GuildScheduledEvent guildScheduledEvent2 = invite.getGuildScheduledEvent();
                Long channelId = guildScheduledEvent2 != null ? guildScheduledEvent2.getChannelId() : null;
                Channel channel = invite.getChannel();
                zAreEqual = Intrinsics3.areEqual(channelId, channel != null ? Long.valueOf(channel.getId()) : null);
            } else {
                zAreEqual = true;
            }
            String str = invite.code;
            Intrinsics3.checkNotNullExpressionValue(str, "invite.code");
            Guild guild = invite.guild;
            Long lValueOf2 = guild != null ? Long.valueOf(guild.getId()) : null;
            Channel channel2 = invite.getChannel();
            Long lValueOf3 = channel2 != null ? Long.valueOf(channel2.getId()) : null;
            User inviter = invite.getInviter();
            Long lValueOf4 = inviter != null ? Long.valueOf(inviter.getId()) : null;
            boolean zIsStatic = invite.isStatic();
            long expirationTime = invite.getExpirationTime();
            if (zAreEqual) {
                GuildScheduledEvent guildScheduledEvent3 = invite.getGuildScheduledEvent();
                if (guildScheduledEvent3 != null) {
                    lValueOf = Long.valueOf(guildScheduledEvent3.getId());
                }
            } else if (zAreEqual) {
                throw new NoWhenBranchMatchedException();
            }
            return new GuildInvite(str, lValueOf2, lValueOf3, lValueOf4, zIsStatic, expirationTime, lValueOf);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GuildInvite(String str, Long l, Long l2, Long l3, boolean z2, long j, Long l4) {
        Intrinsics3.checkNotNullParameter(str, "inviteCode");
        this.inviteCode = str;
        this.guildId = l;
        this.channelId = l2;
        this.inviterId = l3;
        this.isStaticInvite = z2;
        this.expirationTimeMs = j;
        this.guildScheduledEventId = l4;
    }

    public static /* synthetic */ GuildInvite copy$default(GuildInvite guildInvite, String str, Long l, Long l2, Long l3, boolean z2, long j, Long l4, int i, Object obj) {
        return guildInvite.copy((i & 1) != 0 ? guildInvite.inviteCode : str, (i & 2) != 0 ? guildInvite.guildId : l, (i & 4) != 0 ? guildInvite.channelId : l2, (i & 8) != 0 ? guildInvite.inviterId : l3, (i & 16) != 0 ? guildInvite.isStaticInvite : z2, (i & 32) != 0 ? guildInvite.expirationTimeMs : j, (i & 64) != 0 ? guildInvite.guildScheduledEventId : l4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getInviteCode() {
        return this.inviteCode;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getInviterId() {
        return this.inviterId;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsStaticInvite() {
        return this.isStaticInvite;
    }

    /* renamed from: component6, reason: from getter */
    public final long getExpirationTimeMs() {
        return this.expirationTimeMs;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final GuildInvite copy(String inviteCode, Long guildId, Long channelId, Long inviterId, boolean isStaticInvite, long expirationTimeMs, Long guildScheduledEventId) {
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        return new GuildInvite(inviteCode, guildId, channelId, inviterId, isStaticInvite, expirationTimeMs, guildScheduledEventId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildInvite)) {
            return false;
        }
        GuildInvite guildInvite = (GuildInvite) other;
        return Intrinsics3.areEqual(this.inviteCode, guildInvite.inviteCode) && Intrinsics3.areEqual(this.guildId, guildInvite.guildId) && Intrinsics3.areEqual(this.channelId, guildInvite.channelId) && Intrinsics3.areEqual(this.inviterId, guildInvite.inviterId) && this.isStaticInvite == guildInvite.isStaticInvite && this.expirationTimeMs == guildInvite.expirationTimeMs && Intrinsics3.areEqual(this.guildScheduledEventId, guildInvite.guildScheduledEventId);
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final long getExpirationTimeMs() {
        return this.expirationTimeMs;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final Long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final String getInviteCode() {
        return this.inviteCode;
    }

    public final Long getInviterId() {
        return this.inviterId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.inviteCode;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.guildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.inviterId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        boolean z2 = this.isStaticInvite;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int iA = (b.a(this.expirationTimeMs) + ((iHashCode4 + i) * 31)) * 31;
        Long l4 = this.guildScheduledEventId;
        return iA + (l4 != null ? l4.hashCode() : 0);
    }

    public final boolean isStaticInvite() {
        return this.isStaticInvite;
    }

    public final String toLink() {
        return InviteUtils.INSTANCE.createLinkFromCode(this.inviteCode, this.guildScheduledEventId);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildInvite(inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", inviterId=");
        sbU.append(this.inviterId);
        sbU.append(", isStaticInvite=");
        sbU.append(this.isStaticInvite);
        sbU.append(", expirationTimeMs=");
        sbU.append(this.expirationTimeMs);
        sbU.append(", guildScheduledEventId=");
        return outline.G(sbU, this.guildScheduledEventId, ")");
    }
}
