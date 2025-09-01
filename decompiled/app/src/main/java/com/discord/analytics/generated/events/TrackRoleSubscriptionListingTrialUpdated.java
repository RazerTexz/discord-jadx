package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackRoleSubscriptionListingTrialUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0006R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016R\u001b\u0010 \u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\u0016R$\u0010#\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010)\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0014\u001a\u0004\b*\u0010\u0016¨\u0006+"}, d2 = {"Lcom/discord/analytics/generated/events/TrackRoleSubscriptionListingTrialUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "", "roleSubscriptionListingId", "Ljava/lang/Long;", "getRoleSubscriptionListingId", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "trialIntervalCount", "getTrialIntervalCount", "activeTrialUserLimit", "getActiveTrialUserLimit", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "trialInterval", "getTrialInterval", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackRoleSubscriptionListingTrialUpdated implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long roleSubscriptionListingId = null;
    private final Long trialInterval = null;
    private final Long trialIntervalCount = null;
    private final Long activeTrialUserLimit = null;
    private final transient String analyticsSchemaTypeName = "role_subscription_listing_trial_updated";

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
        if (!(other instanceof TrackRoleSubscriptionListingTrialUpdated)) {
            return false;
        }
        TrackRoleSubscriptionListingTrialUpdated trackRoleSubscriptionListingTrialUpdated = (TrackRoleSubscriptionListingTrialUpdated) other;
        return Intrinsics3.areEqual(this.roleSubscriptionListingId, trackRoleSubscriptionListingTrialUpdated.roleSubscriptionListingId) && Intrinsics3.areEqual(this.trialInterval, trackRoleSubscriptionListingTrialUpdated.trialInterval) && Intrinsics3.areEqual(this.trialIntervalCount, trackRoleSubscriptionListingTrialUpdated.trialIntervalCount) && Intrinsics3.areEqual(this.activeTrialUserLimit, trackRoleSubscriptionListingTrialUpdated.activeTrialUserLimit);
    }

    public int hashCode() {
        Long l = this.roleSubscriptionListingId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.trialInterval;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.trialIntervalCount;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.activeTrialUserLimit;
        return iHashCode3 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRoleSubscriptionListingTrialUpdated(roleSubscriptionListingId=");
        sbU.append(this.roleSubscriptionListingId);
        sbU.append(", trialInterval=");
        sbU.append(this.trialInterval);
        sbU.append(", trialIntervalCount=");
        sbU.append(this.trialIntervalCount);
        sbU.append(", activeTrialUserLimit=");
        return outline.G(sbU, this.activeTrialUserLimit, ")");
    }
}
