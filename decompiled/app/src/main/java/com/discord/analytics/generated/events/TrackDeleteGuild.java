package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackDeleteGuild.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016R\u001b\u0010$\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0016R\u001b\u0010&\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u0016R\u001b\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010-\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0005¨\u00060"}, d2 = {"Lcom/discord/analytics/generated/events/TrackDeleteGuild;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "guildIsVip", "Ljava/lang/Boolean;", "getGuildIsVip", "()Ljava/lang/Boolean;", "", "guildNumChannels", "Ljava/lang/Long;", "getGuildNumChannels", "()Ljava/lang/Long;", "guildSizeTotal", "getGuildSizeTotal", "guildNumTextChannels", "getGuildNumTextChannels", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "guildNumVoiceChannels", "getGuildNumVoiceChannels", "guildId", "getGuildId", "guildNumRoles", "getGuildNumRoles", "", "guildName", "Ljava/lang/CharSequence;", "getGuildName", "()Ljava/lang/CharSequence;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackDeleteGuild implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final Long guildSizeTotal = null;
    private final Long guildNumChannels = null;
    private final Long guildNumTextChannels = null;
    private final Long guildNumVoiceChannels = null;
    private final Long guildNumRoles = null;
    private final Boolean guildIsVip = null;
    private final transient String analyticsSchemaTypeName = "delete_guild";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDeleteGuild)) {
            return false;
        }
        TrackDeleteGuild trackDeleteGuild = (TrackDeleteGuild) other;
        return Intrinsics3.areEqual(this.guildId, trackDeleteGuild.guildId) && Intrinsics3.areEqual(this.guildName, trackDeleteGuild.guildName) && Intrinsics3.areEqual(this.guildSizeTotal, trackDeleteGuild.guildSizeTotal) && Intrinsics3.areEqual(this.guildNumChannels, trackDeleteGuild.guildNumChannels) && Intrinsics3.areEqual(this.guildNumTextChannels, trackDeleteGuild.guildNumTextChannels) && Intrinsics3.areEqual(this.guildNumVoiceChannels, trackDeleteGuild.guildNumVoiceChannels) && Intrinsics3.areEqual(this.guildNumRoles, trackDeleteGuild.guildNumRoles) && Intrinsics3.areEqual(this.guildIsVip, trackDeleteGuild.guildIsVip);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.guildName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.guildSizeTotal;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildNumChannels;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildNumTextChannels;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.guildNumVoiceChannels;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.guildNumRoles;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Boolean bool = this.guildIsVip;
        return iHashCode7 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDeleteGuild(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", guildSizeTotal=");
        sbU.append(this.guildSizeTotal);
        sbU.append(", guildNumChannels=");
        sbU.append(this.guildNumChannels);
        sbU.append(", guildNumTextChannels=");
        sbU.append(this.guildNumTextChannels);
        sbU.append(", guildNumVoiceChannels=");
        sbU.append(this.guildNumVoiceChannels);
        sbU.append(", guildNumRoles=");
        sbU.append(this.guildNumRoles);
        sbU.append(", guildIsVip=");
        return outline.D(sbU, this.guildIsVip, ")");
    }
}
