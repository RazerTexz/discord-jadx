package com.discord.analytics.generated.events.network_action;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackNetworkActionInviteResolve.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B£\u0001\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bJ\u0010KJ\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014R\u001b\u0010#\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0014R$\u0010&\u001a\u0004\u0018\u00010%8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010,\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0012\u001a\u0004\b-\u0010\u0014R\u001b\u0010.\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0012\u001a\u0004\b/\u0010\u0014R$\u00101\u001a\u0004\u0018\u0001008\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001b\u00107\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u001e\u001a\u0004\b8\u0010 R\u001b\u00109\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0012\u001a\u0004\b:\u0010\u0014R\u001b\u0010;\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u0017\u001a\u0004\b<\u0010\u0019R\u001b\u0010=\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u001e\u001a\u0004\b>\u0010 R$\u0010@\u001a\u0004\u0018\u00010?8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001b\u0010F\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010\u0012\u001a\u0004\bG\u0010\u0014R\u001b\u0010H\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010\u0017\u001a\u0004\bI\u0010\u0019¨\u0006L"}, d2 = {"Lcom/discord/analytics/generated/events/network_action/TrackNetworkActionInviteResolve;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "destinationUserId", "Ljava/lang/Long;", "getDestinationUserId", "()Ljava/lang/Long;", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "Ljava/lang/CharSequence;", "getCode", "()Ljava/lang/CharSequence;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "resolved", "Ljava/lang/Boolean;", "getResolved", "()Ljava/lang/Boolean;", "channelId", "getChannelId", "guildId", "getGuildId", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "channelType", "getChannelType", "inviterId", "getInviterId", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "trackNetworkMetadata", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "getTrackNetworkMetadata", "()Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "b", "(Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;)V", "userBanned", "getUserBanned", "sizeTotal", "getSizeTotal", "inviteType", "getInviteType", "authenticated", "getAuthenticated", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "sizeOnline", "getSizeOnline", "inputValue", "getInputValue", "<init>", "(Ljava/lang/Boolean;Ljava/lang/CharSequence;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/CharSequence;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/CharSequence;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkActionInviteResolve implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Boolean authenticated;
    private final Long channelId;
    private final Long channelType;
    private final CharSequence code;
    private final Long destinationUserId;
    private final Long guildId;
    private final CharSequence inputValue;
    private final CharSequence inviteType;
    private final Long inviterId;
    private final Boolean resolved;
    private final Long sizeOnline;
    private final Long sizeTotal;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;
    private final Boolean userBanned;

    public TrackNetworkActionInviteResolve(Boolean bool, CharSequence charSequence, Boolean bool2, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, CharSequence charSequence2, Long l7, Boolean bool3, CharSequence charSequence3) {
        this.resolved = bool;
        this.code = charSequence;
        this.authenticated = bool2;
        this.guildId = l;
        this.channelId = l2;
        this.channelType = l3;
        this.inviterId = l4;
        this.sizeTotal = l5;
        this.sizeOnline = l6;
        this.inviteType = charSequence2;
        this.destinationUserId = l7;
        this.userBanned = bool3;
        this.inputValue = charSequence3;
        this.analyticsSchemaTypeName = "network_action_invite_resolve";
    }

    @Override // com.discord.analytics.generated.traits.TrackNetworkMetadata2
    public void b(TrackNetworkMetadata trackNetworkMetadata) {
        this.trackNetworkMetadata = trackNetworkMetadata;
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
        if (!(other instanceof TrackNetworkActionInviteResolve)) {
            return false;
        }
        TrackNetworkActionInviteResolve trackNetworkActionInviteResolve = (TrackNetworkActionInviteResolve) other;
        return Intrinsics3.areEqual(this.resolved, trackNetworkActionInviteResolve.resolved) && Intrinsics3.areEqual(this.code, trackNetworkActionInviteResolve.code) && Intrinsics3.areEqual(this.authenticated, trackNetworkActionInviteResolve.authenticated) && Intrinsics3.areEqual(this.guildId, trackNetworkActionInviteResolve.guildId) && Intrinsics3.areEqual(this.channelId, trackNetworkActionInviteResolve.channelId) && Intrinsics3.areEqual(this.channelType, trackNetworkActionInviteResolve.channelType) && Intrinsics3.areEqual(this.inviterId, trackNetworkActionInviteResolve.inviterId) && Intrinsics3.areEqual(this.sizeTotal, trackNetworkActionInviteResolve.sizeTotal) && Intrinsics3.areEqual(this.sizeOnline, trackNetworkActionInviteResolve.sizeOnline) && Intrinsics3.areEqual(this.inviteType, trackNetworkActionInviteResolve.inviteType) && Intrinsics3.areEqual(this.destinationUserId, trackNetworkActionInviteResolve.destinationUserId) && Intrinsics3.areEqual(this.userBanned, trackNetworkActionInviteResolve.userBanned) && Intrinsics3.areEqual(this.inputValue, trackNetworkActionInviteResolve.inputValue);
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
        return iHashCode12 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNetworkActionInviteResolve(resolved=");
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
        return outline.E(sbU, this.inputValue, ")");
    }

    public TrackNetworkActionInviteResolve() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null);
    }
}
