package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackInviteSent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\u001c\u0010\"\u001a\u00020\u00068\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\bR\u001b\u0010%\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0015R\u001b\u0010'\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010\u0015R\u001b\u0010)\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0013\u001a\u0004\b*\u0010\u0015R$\u0010,\u001a\u0004\u0018\u00010+8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001b\u00102\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0013\u001a\u0004\b3\u0010\u0015R\u001b\u00104\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010 \u001a\u0004\b4\u0010!R$\u00106\u001a\u0004\u0018\u0001058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001b\u0010<\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0013\u001a\u0004\b=\u0010\u0015R\u001b\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001b\u0010C\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010\u0013\u001a\u0004\bD\u0010\u0015R\u001b\u0010E\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010\u0013\u001a\u0004\bF\u0010\u0015R\u001b\u0010G\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010\u0013\u001a\u0004\bH\u0010\u0015R\u001b\u0010I\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010\u0013\u001a\u0004\bJ\u0010\u0015R\u001b\u0010K\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010\u0013\u001a\u0004\bL\u0010\u0015R$\u0010N\u001a\u0004\u0018\u00010M8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001b\u0010T\u001a\u0004\u0018\u00010>8\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010@\u001a\u0004\bU\u0010BR\u001b\u0010V\u001a\u0004\u0018\u00010>8\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010@\u001a\u0004\bW\u0010B¨\u0006X"}, d2 = {"Lcom/discord/analytics/generated/events/TrackInviteSent;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "inviteGuildId", "Ljava/lang/Long;", "getInviteGuildId", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "inviteChannelType", "getInviteChannelType", "isSuggested", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "destinationUserId", "getDestinationUserId", "rowNum", "getRowNum", "applicationId", "getApplicationId", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "inviteInviterId", "getInviteInviterId", "isFiltered", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "numTotal", "getNumTotal", "", "sendType", "Ljava/lang/CharSequence;", "getSendType", "()Ljava/lang/CharSequence;", "messageId", "getMessageId", "inviteChannelId", "getInviteChannelId", "numSelected", "getNumSelected", "inviteGuildScheduledEventId", "getInviteGuildScheduledEventId", "numAffinityConnections", "getNumAffinityConnections", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "inviteType", "getInviteType", "inviteCode", "getInviteCode", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackInviteSent implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence inviteType = null;
    private final CharSequence inviteCode = null;
    private final Long messageId = null;
    private final Long inviteGuildId = null;
    private final Long inviteChannelId = null;
    private final Long inviteChannelType = null;
    private final Long inviteInviterId = null;
    private final Long applicationId = null;
    private final Long destinationUserId = null;
    private final Boolean isSuggested = null;
    private final Long rowNum = null;
    private final Long numTotal = null;
    private final Long numAffinityConnections = null;
    private final Boolean isFiltered = null;
    private final Long numSelected = null;
    private final CharSequence sendType = null;
    private final Long inviteGuildScheduledEventId = null;
    private final transient String analyticsSchemaTypeName = "invite_sent";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInviteSent)) {
            return false;
        }
        TrackInviteSent trackInviteSent = (TrackInviteSent) other;
        return Intrinsics3.areEqual(this.inviteType, trackInviteSent.inviteType) && Intrinsics3.areEqual(this.inviteCode, trackInviteSent.inviteCode) && Intrinsics3.areEqual(this.messageId, trackInviteSent.messageId) && Intrinsics3.areEqual(this.inviteGuildId, trackInviteSent.inviteGuildId) && Intrinsics3.areEqual(this.inviteChannelId, trackInviteSent.inviteChannelId) && Intrinsics3.areEqual(this.inviteChannelType, trackInviteSent.inviteChannelType) && Intrinsics3.areEqual(this.inviteInviterId, trackInviteSent.inviteInviterId) && Intrinsics3.areEqual(this.applicationId, trackInviteSent.applicationId) && Intrinsics3.areEqual(this.destinationUserId, trackInviteSent.destinationUserId) && Intrinsics3.areEqual(this.isSuggested, trackInviteSent.isSuggested) && Intrinsics3.areEqual(this.rowNum, trackInviteSent.rowNum) && Intrinsics3.areEqual(this.numTotal, trackInviteSent.numTotal) && Intrinsics3.areEqual(this.numAffinityConnections, trackInviteSent.numAffinityConnections) && Intrinsics3.areEqual(this.isFiltered, trackInviteSent.isFiltered) && Intrinsics3.areEqual(this.numSelected, trackInviteSent.numSelected) && Intrinsics3.areEqual(this.sendType, trackInviteSent.sendType) && Intrinsics3.areEqual(this.inviteGuildScheduledEventId, trackInviteSent.inviteGuildScheduledEventId);
    }

    public int hashCode() {
        CharSequence charSequence = this.inviteType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.inviteCode;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.messageId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.inviteGuildId;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.inviteChannelId;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.inviteChannelType;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.inviteInviterId;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.applicationId;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.destinationUserId;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Boolean bool = this.isSuggested;
        int iHashCode10 = (iHashCode9 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l8 = this.rowNum;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.numTotal;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.numAffinityConnections;
        int iHashCode13 = (iHashCode12 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Boolean bool2 = this.isFiltered;
        int iHashCode14 = (iHashCode13 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l11 = this.numSelected;
        int iHashCode15 = (iHashCode14 + (l11 != null ? l11.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.sendType;
        int iHashCode16 = (iHashCode15 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l12 = this.inviteGuildScheduledEventId;
        return iHashCode16 + (l12 != null ? l12.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackInviteSent(inviteType=");
        sbU.append(this.inviteType);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", inviteGuildId=");
        sbU.append(this.inviteGuildId);
        sbU.append(", inviteChannelId=");
        sbU.append(this.inviteChannelId);
        sbU.append(", inviteChannelType=");
        sbU.append(this.inviteChannelType);
        sbU.append(", inviteInviterId=");
        sbU.append(this.inviteInviterId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", destinationUserId=");
        sbU.append(this.destinationUserId);
        sbU.append(", isSuggested=");
        sbU.append(this.isSuggested);
        sbU.append(", rowNum=");
        sbU.append(this.rowNum);
        sbU.append(", numTotal=");
        sbU.append(this.numTotal);
        sbU.append(", numAffinityConnections=");
        sbU.append(this.numAffinityConnections);
        sbU.append(", isFiltered=");
        sbU.append(this.isFiltered);
        sbU.append(", numSelected=");
        sbU.append(this.numSelected);
        sbU.append(", sendType=");
        sbU.append(this.sendType);
        sbU.append(", inviteGuildScheduledEventId=");
        return outline.G(sbU, this.inviteGuildScheduledEventId, ")");
    }
}
