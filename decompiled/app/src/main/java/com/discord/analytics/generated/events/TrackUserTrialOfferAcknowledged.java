package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackUserTrialOfferAcknowledged.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR!\u0010 \u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c¨\u0006\""}, d2 = {"Lcom/discord/analytics/generated/events/TrackUserTrialOfferAcknowledged;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "", "trialOfferId", "Ljava/lang/Long;", "getTrialOfferId", "()Ljava/lang/Long;", "trialId", "getTrialId", "Lcom/discord/primitives/Timestamp;", "expiresAt", "getExpiresAt", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackUserTrialOfferAcknowledged implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long trialOfferId = null;
    private final Long trialId = null;
    private final Long expiresAt = null;
    private final transient String analyticsSchemaTypeName = "user_trial_offer_acknowledged";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserTrialOfferAcknowledged)) {
            return false;
        }
        TrackUserTrialOfferAcknowledged trackUserTrialOfferAcknowledged = (TrackUserTrialOfferAcknowledged) other;
        return Intrinsics3.areEqual(this.trialOfferId, trackUserTrialOfferAcknowledged.trialOfferId) && Intrinsics3.areEqual(this.trialId, trackUserTrialOfferAcknowledged.trialId) && Intrinsics3.areEqual(this.expiresAt, trackUserTrialOfferAcknowledged.expiresAt);
    }

    public int hashCode() {
        Long l = this.trialOfferId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.trialId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.expiresAt;
        return iHashCode2 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUserTrialOfferAcknowledged(trialOfferId=");
        sbU.append(this.trialOfferId);
        sbU.append(", trialId=");
        sbU.append(this.trialId);
        sbU.append(", expiresAt=");
        return outline.G(sbU, this.expiresAt, ")");
    }
}
