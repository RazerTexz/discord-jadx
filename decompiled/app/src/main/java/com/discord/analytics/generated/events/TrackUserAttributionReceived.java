package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackUserAttributionReceived.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012R\u001b\u0010 \u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012R\u001b\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012R\u001b\u0010$\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010\u0012R\u001c\u0010&\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0005¨\u0006)"}, d2 = {"Lcom/discord/analytics/generated/events/TrackUserAttributionReceived;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "attributionAdgroup", "Ljava/lang/CharSequence;", "getAttributionAdgroup", "()Ljava/lang/CharSequence;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "attributionCreative", "getAttributionCreative", "adjustTrackerToken", "getAdjustTrackerToken", "adjustAdid", "getAdjustAdid", "attributionCampaign", "getAttributionCampaign", "attributionNetwork", "getAttributionNetwork", "adjustTrackerName", "getAdjustTrackerName", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackUserAttributionReceived implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence adjustTrackerToken = null;
    private final CharSequence adjustTrackerName = null;
    private final CharSequence attributionNetwork = null;
    private final CharSequence attributionCampaign = null;
    private final CharSequence attributionAdgroup = null;
    private final CharSequence attributionCreative = null;
    private final CharSequence adjustAdid = null;
    private final transient String analyticsSchemaTypeName = "user_attribution_received";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserAttributionReceived)) {
            return false;
        }
        TrackUserAttributionReceived trackUserAttributionReceived = (TrackUserAttributionReceived) other;
        return Intrinsics3.areEqual(this.adjustTrackerToken, trackUserAttributionReceived.adjustTrackerToken) && Intrinsics3.areEqual(this.adjustTrackerName, trackUserAttributionReceived.adjustTrackerName) && Intrinsics3.areEqual(this.attributionNetwork, trackUserAttributionReceived.attributionNetwork) && Intrinsics3.areEqual(this.attributionCampaign, trackUserAttributionReceived.attributionCampaign) && Intrinsics3.areEqual(this.attributionAdgroup, trackUserAttributionReceived.attributionAdgroup) && Intrinsics3.areEqual(this.attributionCreative, trackUserAttributionReceived.attributionCreative) && Intrinsics3.areEqual(this.adjustAdid, trackUserAttributionReceived.adjustAdid);
    }

    public int hashCode() {
        CharSequence charSequence = this.adjustTrackerToken;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.adjustTrackerName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.attributionNetwork;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.attributionCampaign;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.attributionAdgroup;
        int iHashCode5 = (iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.attributionCreative;
        int iHashCode6 = (iHashCode5 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.adjustAdid;
        return iHashCode6 + (charSequence7 != null ? charSequence7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUserAttributionReceived(adjustTrackerToken=");
        sbU.append(this.adjustTrackerToken);
        sbU.append(", adjustTrackerName=");
        sbU.append(this.adjustTrackerName);
        sbU.append(", attributionNetwork=");
        sbU.append(this.attributionNetwork);
        sbU.append(", attributionCampaign=");
        sbU.append(this.attributionCampaign);
        sbU.append(", attributionAdgroup=");
        sbU.append(this.attributionAdgroup);
        sbU.append(", attributionCreative=");
        sbU.append(this.attributionCreative);
        sbU.append(", adjustAdid=");
        return outline.E(sbU, this.adjustAdid, ")");
    }
}
