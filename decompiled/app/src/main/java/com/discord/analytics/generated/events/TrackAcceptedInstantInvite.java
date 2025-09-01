package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackAcceptedInstantInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012R\u001b\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012R\u001b\u0010$\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010\u0012R\u001b\u0010&\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0010\u001a\u0004\b'\u0010\u0012R\u001b\u0010(\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u0010,\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0010\u001a\u0004\b-\u0010\u0012R$\u0010/\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u00105\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0010\u001a\u0004\b6\u0010\u0012R\u001b\u00107\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0010\u001a\u0004\b8\u0010\u0012R\u001b\u00109\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010)\u001a\u0004\b:\u0010+R\u001b\u0010;\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u001d\u001a\u0004\b<\u0010\u001fR\u001b\u0010=\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u0010\u001a\u0004\b>\u0010\u0012R\u001b\u0010?\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010\u0010\u001a\u0004\b@\u0010\u0012R\u001b\u0010A\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010\u0010\u001a\u0004\bB\u0010\u0012R\u001c\u0010C\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u0005R\u001b\u0010F\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010\u0010\u001a\u0004\bG\u0010\u0012R\u001b\u0010H\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010\u0010\u001a\u0004\bI\u0010\u0012R\u001b\u0010J\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010\u0010\u001a\u0004\bK\u0010\u0012R\u001b\u0010L\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010\u0010\u001a\u0004\bM\u0010\u0012¨\u0006N"}, d2 = {"Lcom/discord/analytics/generated/events/TrackAcceptedInstantInvite;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "sizeOnline", "Ljava/lang/Long;", "getSizeOnline", "()Ljava/lang/Long;", "guild", "getGuild", "ownerId", "getOwnerId", "inviteGuildScheduledEventId", "getInviteGuildScheduledEventId", "channel", "getChannel", "", "inviteType", "Ljava/lang/CharSequence;", "getInviteType", "()Ljava/lang/CharSequence;", "channelType", "getChannelType", "userGuilds", "getUserGuilds", "destinationUserId", "getDestinationUserId", "sizeTotal", "getSizeTotal", "custom", "Ljava/lang/Boolean;", "getCustom", "()Ljava/lang/Boolean;", "guildSizeTotal", "getGuildSizeTotal", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "locationGuildId", "getLocationGuildId", "guildVerificationLevel", "getGuildVerificationLevel", "hasMutualGuild", "getHasMutualGuild", "invite", "getInvite", "userDay", "getUserDay", "guildOwner", "getGuildOwner", "locationChannelType", "getLocationChannelType", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "guildSizeOnline", "getGuildSizeOnline", "locationChannelId", "getLocationChannelId", "inviter", "getInviter", "locationMessageId", "getLocationMessageId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackAcceptedInstantInvite implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channel = null;
    private final Long channelType = null;
    private final Boolean custom = null;
    private final Long guild = null;
    private final Long guildOwner = null;
    private final Long ownerId = null;
    private final CharSequence invite = null;
    private final Long inviter = null;
    private final Long userDay = null;
    private final Long userGuilds = null;
    private final Long locationGuildId = null;
    private final Long locationChannelId = null;
    private final Long locationChannelType = null;
    private final Long locationMessageId = null;
    private final Long guildSizeTotal = null;
    private final Long guildSizeOnline = null;
    private final Long sizeTotal = null;
    private final Long sizeOnline = null;
    private final CharSequence inviteType = null;
    private final Long destinationUserId = null;
    private final Long guildVerificationLevel = null;
    private final Boolean hasMutualGuild = null;
    private final Long inviteGuildScheduledEventId = null;
    private final transient String analyticsSchemaTypeName = "accepted_instant_invite";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAcceptedInstantInvite)) {
            return false;
        }
        TrackAcceptedInstantInvite trackAcceptedInstantInvite = (TrackAcceptedInstantInvite) other;
        return Intrinsics3.areEqual(this.channel, trackAcceptedInstantInvite.channel) && Intrinsics3.areEqual(this.channelType, trackAcceptedInstantInvite.channelType) && Intrinsics3.areEqual(this.custom, trackAcceptedInstantInvite.custom) && Intrinsics3.areEqual(this.guild, trackAcceptedInstantInvite.guild) && Intrinsics3.areEqual(this.guildOwner, trackAcceptedInstantInvite.guildOwner) && Intrinsics3.areEqual(this.ownerId, trackAcceptedInstantInvite.ownerId) && Intrinsics3.areEqual(this.invite, trackAcceptedInstantInvite.invite) && Intrinsics3.areEqual(this.inviter, trackAcceptedInstantInvite.inviter) && Intrinsics3.areEqual(this.userDay, trackAcceptedInstantInvite.userDay) && Intrinsics3.areEqual(this.userGuilds, trackAcceptedInstantInvite.userGuilds) && Intrinsics3.areEqual(this.locationGuildId, trackAcceptedInstantInvite.locationGuildId) && Intrinsics3.areEqual(this.locationChannelId, trackAcceptedInstantInvite.locationChannelId) && Intrinsics3.areEqual(this.locationChannelType, trackAcceptedInstantInvite.locationChannelType) && Intrinsics3.areEqual(this.locationMessageId, trackAcceptedInstantInvite.locationMessageId) && Intrinsics3.areEqual(this.guildSizeTotal, trackAcceptedInstantInvite.guildSizeTotal) && Intrinsics3.areEqual(this.guildSizeOnline, trackAcceptedInstantInvite.guildSizeOnline) && Intrinsics3.areEqual(this.sizeTotal, trackAcceptedInstantInvite.sizeTotal) && Intrinsics3.areEqual(this.sizeOnline, trackAcceptedInstantInvite.sizeOnline) && Intrinsics3.areEqual(this.inviteType, trackAcceptedInstantInvite.inviteType) && Intrinsics3.areEqual(this.destinationUserId, trackAcceptedInstantInvite.destinationUserId) && Intrinsics3.areEqual(this.guildVerificationLevel, trackAcceptedInstantInvite.guildVerificationLevel) && Intrinsics3.areEqual(this.hasMutualGuild, trackAcceptedInstantInvite.hasMutualGuild) && Intrinsics3.areEqual(this.inviteGuildScheduledEventId, trackAcceptedInstantInvite.inviteGuildScheduledEventId);
    }

    public int hashCode() {
        Long l = this.channel;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.custom;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l3 = this.guild;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildOwner;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.ownerId;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence = this.invite;
        int iHashCode7 = (iHashCode6 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l6 = this.inviter;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.userDay;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.userGuilds;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.locationGuildId;
        int iHashCode11 = (iHashCode10 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.locationChannelId;
        int iHashCode12 = (iHashCode11 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.locationChannelType;
        int iHashCode13 = (iHashCode12 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.locationMessageId;
        int iHashCode14 = (iHashCode13 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.guildSizeTotal;
        int iHashCode15 = (iHashCode14 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.guildSizeOnline;
        int iHashCode16 = (iHashCode15 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.sizeTotal;
        int iHashCode17 = (iHashCode16 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.sizeOnline;
        int iHashCode18 = (iHashCode17 + (l16 != null ? l16.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.inviteType;
        int iHashCode19 = (iHashCode18 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l17 = this.destinationUserId;
        int iHashCode20 = (iHashCode19 + (l17 != null ? l17.hashCode() : 0)) * 31;
        Long l18 = this.guildVerificationLevel;
        int iHashCode21 = (iHashCode20 + (l18 != null ? l18.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasMutualGuild;
        int iHashCode22 = (iHashCode21 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l19 = this.inviteGuildScheduledEventId;
        return iHashCode22 + (l19 != null ? l19.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAcceptedInstantInvite(channel=");
        sbU.append(this.channel);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", custom=");
        sbU.append(this.custom);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", guildOwner=");
        sbU.append(this.guildOwner);
        sbU.append(", ownerId=");
        sbU.append(this.ownerId);
        sbU.append(", invite=");
        sbU.append(this.invite);
        sbU.append(", inviter=");
        sbU.append(this.inviter);
        sbU.append(", userDay=");
        sbU.append(this.userDay);
        sbU.append(", userGuilds=");
        sbU.append(this.userGuilds);
        sbU.append(", locationGuildId=");
        sbU.append(this.locationGuildId);
        sbU.append(", locationChannelId=");
        sbU.append(this.locationChannelId);
        sbU.append(", locationChannelType=");
        sbU.append(this.locationChannelType);
        sbU.append(", locationMessageId=");
        sbU.append(this.locationMessageId);
        sbU.append(", guildSizeTotal=");
        sbU.append(this.guildSizeTotal);
        sbU.append(", guildSizeOnline=");
        sbU.append(this.guildSizeOnline);
        sbU.append(", sizeTotal=");
        sbU.append(this.sizeTotal);
        sbU.append(", sizeOnline=");
        sbU.append(this.sizeOnline);
        sbU.append(", inviteType=");
        sbU.append(this.inviteType);
        sbU.append(", destinationUserId=");
        sbU.append(this.destinationUserId);
        sbU.append(", guildVerificationLevel=");
        sbU.append(this.guildVerificationLevel);
        sbU.append(", hasMutualGuild=");
        sbU.append(this.hasMutualGuild);
        sbU.append(", inviteGuildScheduledEventId=");
        return outline.G(sbU, this.inviteGuildScheduledEventId, ")");
    }
}
