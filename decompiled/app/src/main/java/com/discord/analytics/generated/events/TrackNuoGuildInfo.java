package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackNuoGuildInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012R\u001c\u0010 \u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0005R\u001b\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012R$\u0010&\u001a\u0004\u0018\u00010%8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010,\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0010\u001a\u0004\b-\u0010\u0012¨\u0006."}, d2 = {"Lcom/discord/analytics/generated/events/TrackNuoGuildInfo;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "guildCount", "Ljava/lang/Long;", "getGuildCount", "()Ljava/lang/Long;", "verificationLevelEnabled", "Ljava/lang/Boolean;", "getVerificationLevelEnabled", "()Ljava/lang/Boolean;", "", "evaluatedStep", "Ljava/lang/CharSequence;", "getEvaluatedStep", "()Ljava/lang/CharSequence;", "hasSplash", "getHasSplash", "invitedGuildId", "getInvitedGuildId", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "memberCount", "getMemberCount", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "channelType", "getChannelType", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNuoGuildInfo implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence evaluatedStep = null;
    private final Long invitedGuildId = null;
    private final Long guildCount = null;
    private final Long memberCount = null;
    private final Boolean hasSplash = null;
    private final Long channelType = null;
    private final Boolean verificationLevelEnabled = null;
    private final transient String analyticsSchemaTypeName = "nuo_guild_info";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNuoGuildInfo)) {
            return false;
        }
        TrackNuoGuildInfo trackNuoGuildInfo = (TrackNuoGuildInfo) other;
        return Intrinsics3.areEqual(this.evaluatedStep, trackNuoGuildInfo.evaluatedStep) && Intrinsics3.areEqual(this.invitedGuildId, trackNuoGuildInfo.invitedGuildId) && Intrinsics3.areEqual(this.guildCount, trackNuoGuildInfo.guildCount) && Intrinsics3.areEqual(this.memberCount, trackNuoGuildInfo.memberCount) && Intrinsics3.areEqual(this.hasSplash, trackNuoGuildInfo.hasSplash) && Intrinsics3.areEqual(this.channelType, trackNuoGuildInfo.channelType) && Intrinsics3.areEqual(this.verificationLevelEnabled, trackNuoGuildInfo.verificationLevelEnabled);
    }

    public int hashCode() {
        CharSequence charSequence = this.evaluatedStep;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.invitedGuildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.guildCount;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.memberCount;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.hasSplash;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l4 = this.channelType;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool2 = this.verificationLevelEnabled;
        return iHashCode6 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNuoGuildInfo(evaluatedStep=");
        sbU.append(this.evaluatedStep);
        sbU.append(", invitedGuildId=");
        sbU.append(this.invitedGuildId);
        sbU.append(", guildCount=");
        sbU.append(this.guildCount);
        sbU.append(", memberCount=");
        sbU.append(this.memberCount);
        sbU.append(", hasSplash=");
        sbU.append(this.hasSplash);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", verificationLevelEnabled=");
        return outline.D(sbU, this.verificationLevelEnabled, ")");
    }
}
