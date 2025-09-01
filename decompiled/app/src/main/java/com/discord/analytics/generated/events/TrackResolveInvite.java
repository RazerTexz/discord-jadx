package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackResolveInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0017\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u0010*\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\"R\u001b\u0010,\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010\u001dR\u001b\u0010.\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0010\u001a\u0004\b/\u0010\u0012R\u001b\u00100\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u001b\u001a\u0004\b1\u0010\u001dR\u001b\u00102\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0010\u001a\u0004\b3\u0010\u0012R\u001b\u00104\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u0010\u001a\u0004\b5\u0010\u0012R\u001b\u00106\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010 \u001a\u0004\b7\u0010\"R\u001b\u00108\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010 \u001a\u0004\b9\u0010\"R\u001b\u0010:\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u0010\u001a\u0004\b;\u0010\u0012R\u001b\u0010<\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0010\u001a\u0004\b=\u0010\u0012¨\u0006>"}, d2 = {"Lcom/discord/analytics/generated/events/TrackResolveInvite;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "errorCode", "Ljava/lang/Long;", "getErrorCode", "()Ljava/lang/Long;", "guildId", "getGuildId", "sizeTotal", "getSizeTotal", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "userBanned", "Ljava/lang/Boolean;", "getUserBanned", "()Ljava/lang/Boolean;", "", "inputValue", "Ljava/lang/CharSequence;", "getInputValue", "()Ljava/lang/CharSequence;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", ModelAuditLogEntry.CHANGE_KEY_CODE, "getCode", "authenticated", "getAuthenticated", "inviterId", "getInviterId", "resolved", "getResolved", "sizeOnline", "getSizeOnline", "channelId", "getChannelId", "inviteType", "getInviteType", "errorMessage", "getErrorMessage", "destinationUserId", "getDestinationUserId", "channelType", "getChannelType", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackResolveInvite implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean resolved = null;
    private final CharSequence code = null;
    private final Boolean authenticated = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long inviterId = null;
    private final Long sizeTotal = null;
    private final Long sizeOnline = null;
    private final CharSequence inviteType = null;
    private final Long destinationUserId = null;
    private final Boolean userBanned = null;
    private final CharSequence inputValue = null;
    private final Long errorCode = null;
    private final CharSequence errorMessage = null;
    private final transient String analyticsSchemaTypeName = "resolve_invite";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackResolveInvite)) {
            return false;
        }
        TrackResolveInvite trackResolveInvite = (TrackResolveInvite) other;
        return Intrinsics3.areEqual(this.resolved, trackResolveInvite.resolved) && Intrinsics3.areEqual(this.code, trackResolveInvite.code) && Intrinsics3.areEqual(this.authenticated, trackResolveInvite.authenticated) && Intrinsics3.areEqual(this.guildId, trackResolveInvite.guildId) && Intrinsics3.areEqual(this.channelId, trackResolveInvite.channelId) && Intrinsics3.areEqual(this.channelType, trackResolveInvite.channelType) && Intrinsics3.areEqual(this.inviterId, trackResolveInvite.inviterId) && Intrinsics3.areEqual(this.sizeTotal, trackResolveInvite.sizeTotal) && Intrinsics3.areEqual(this.sizeOnline, trackResolveInvite.sizeOnline) && Intrinsics3.areEqual(this.inviteType, trackResolveInvite.inviteType) && Intrinsics3.areEqual(this.destinationUserId, trackResolveInvite.destinationUserId) && Intrinsics3.areEqual(this.userBanned, trackResolveInvite.userBanned) && Intrinsics3.areEqual(this.inputValue, trackResolveInvite.inputValue) && Intrinsics3.areEqual(this.errorCode, trackResolveInvite.errorCode) && Intrinsics3.areEqual(this.errorMessage, trackResolveInvite.errorMessage);
    }

    public int hashCode() {
        Boolean bool = this.resolved;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.code;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool2 = this.authenticated;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.guildId;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelType;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.inviterId;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.sizeTotal;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.sizeOnline;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.inviteType;
        int iHashCode10 = (iHashCode9 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l7 = this.destinationUserId;
        int iHashCode11 = (iHashCode10 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Boolean bool3 = this.userBanned;
        int iHashCode12 = (iHashCode11 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.inputValue;
        int iHashCode13 = (iHashCode12 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l8 = this.errorCode;
        int iHashCode14 = (iHashCode13 + (l8 != null ? l8.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.errorMessage;
        return iHashCode14 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackResolveInvite(resolved=");
        sbU.append(this.resolved);
        sbU.append(", code=");
        sbU.append(this.code);
        sbU.append(", authenticated=");
        sbU.append(this.authenticated);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", inviterId=");
        sbU.append(this.inviterId);
        sbU.append(", sizeTotal=");
        sbU.append(this.sizeTotal);
        sbU.append(", sizeOnline=");
        sbU.append(this.sizeOnline);
        sbU.append(", inviteType=");
        sbU.append(this.inviteType);
        sbU.append(", destinationUserId=");
        sbU.append(this.destinationUserId);
        sbU.append(", userBanned=");
        sbU.append(this.userBanned);
        sbU.append(", inputValue=");
        sbU.append(this.inputValue);
        sbU.append(", errorCode=");
        sbU.append(this.errorCode);
        sbU.append(", errorMessage=");
        return outline.E(sbU, this.errorMessage, ")");
    }
}
