package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackPremiumGuildSubscriptionRemoved.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012R\u001c\u0010 \u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0005R\u001b\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012R\u001b\u0010%\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010\u0012¨\u0006'"}, d2 = {"Lcom/discord/analytics/generated/events/TrackPremiumGuildSubscriptionRemoved;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "previousTier", "Ljava/lang/Long;", "getPreviousTier", "()Ljava/lang/Long;", "premiumGuildSubscriptionId", "getPremiumGuildSubscriptionId", "currentTier", "getCurrentTier", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "tierLost", "getTierLost", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "premiumSubscriptionCount", "getPremiumSubscriptionCount", "guildId", "getGuildId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackPremiumGuildSubscriptionRemoved implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Long premiumGuildSubscriptionId = null;
    private final Long currentTier = null;
    private final Long previousTier = null;
    private final Long premiumSubscriptionCount = null;
    private final Long tierLost = null;
    private final transient String analyticsSchemaTypeName = "premium_guild_subscription_removed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumGuildSubscriptionRemoved)) {
            return false;
        }
        TrackPremiumGuildSubscriptionRemoved trackPremiumGuildSubscriptionRemoved = (TrackPremiumGuildSubscriptionRemoved) other;
        return Intrinsics3.areEqual(this.guildId, trackPremiumGuildSubscriptionRemoved.guildId) && Intrinsics3.areEqual(this.premiumGuildSubscriptionId, trackPremiumGuildSubscriptionRemoved.premiumGuildSubscriptionId) && Intrinsics3.areEqual(this.currentTier, trackPremiumGuildSubscriptionRemoved.currentTier) && Intrinsics3.areEqual(this.previousTier, trackPremiumGuildSubscriptionRemoved.previousTier) && Intrinsics3.areEqual(this.premiumSubscriptionCount, trackPremiumGuildSubscriptionRemoved.premiumSubscriptionCount) && Intrinsics3.areEqual(this.tierLost, trackPremiumGuildSubscriptionRemoved.tierLost);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.premiumGuildSubscriptionId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.currentTier;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.previousTier;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.premiumSubscriptionCount;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.tierLost;
        return iHashCode5 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPremiumGuildSubscriptionRemoved(guildId=");
        sbU.append(this.guildId);
        sbU.append(", premiumGuildSubscriptionId=");
        sbU.append(this.premiumGuildSubscriptionId);
        sbU.append(", currentTier=");
        sbU.append(this.currentTier);
        sbU.append(", previousTier=");
        sbU.append(this.previousTier);
        sbU.append(", premiumSubscriptionCount=");
        sbU.append(this.premiumSubscriptionCount);
        sbU.append(", tierLost=");
        return outline.G(sbU, this.tierLost, ")");
    }
}
