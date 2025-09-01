package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackPaymentFlowStep.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001b\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001c\u0010G\u001a\u00020\b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010\nR\u001b\u0010J\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010*\u001a\u0004\bK\u0010,R\u001b\u0010L\u001a\u0004\u0018\u00010B8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010D\u001a\u0004\bM\u0010FR\u001b\u0010N\u001a\u0004\u0018\u00010B8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010D\u001a\u0004\bO\u0010FR\u001b\u0010P\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010*\u001a\u0004\bQ\u0010,R\u001b\u0010R\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U¨\u0006V"}, d2 = {"Lcom/discord/analytics/generated/events/TrackPaymentFlowStep;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackPaymentMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackSourceMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;", "trackPaymentMetadata", "Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;", "getTrackPaymentMetadata", "()Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;", "setTrackPaymentMetadata", "(Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;)V", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "", "loadId", "Ljava/lang/CharSequence;", "getLoadId", "()Ljava/lang/CharSequence;", "Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;", "trackStoreSkuMetadata", "Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;", "getTrackStoreSkuMetadata", "()Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;", "setTrackStoreSkuMetadata", "(Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;)V", "Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "trackSourceMetadata", "Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "getTrackSourceMetadata", "()Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "setTrackSourceMetadata", "(Lcom/discord/analytics/generated/traits/TrackSourceMetadata;)V", "Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;", "trackSubscriptionMetadata", "Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;", "getTrackSubscriptionMetadata", "()Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;", "setTrackSubscriptionMetadata", "(Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;)V", "", "stepDurationMs", "Ljava/lang/Long;", "getStepDurationMs", "()Ljava/lang/Long;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "fromStep", "getFromStep", "flowDurationMs", "getFlowDurationMs", "guildId", "getGuildId", "toStep", "getToStep", "eligibleForTrial", "Ljava/lang/Boolean;", "getEligibleForTrial", "()Ljava/lang/Boolean;", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackPaymentFlowStep implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackStoreSkuMetadata2, TrackSubscriptionMetadata2, TrackPaymentMetadata2, TrackSourceMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final CharSequence toStep = null;
    private final CharSequence fromStep = null;
    private final CharSequence loadId = null;
    private final Long stepDurationMs = null;
    private final Long flowDurationMs = null;
    private final Boolean eligibleForTrial = null;
    private final Long guildId = null;
    private final transient String analyticsSchemaTypeName = "payment_flow_step";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentFlowStep)) {
            return false;
        }
        TrackPaymentFlowStep trackPaymentFlowStep = (TrackPaymentFlowStep) other;
        return Intrinsics3.areEqual(this.toStep, trackPaymentFlowStep.toStep) && Intrinsics3.areEqual(this.fromStep, trackPaymentFlowStep.fromStep) && Intrinsics3.areEqual(this.loadId, trackPaymentFlowStep.loadId) && Intrinsics3.areEqual(this.stepDurationMs, trackPaymentFlowStep.stepDurationMs) && Intrinsics3.areEqual(this.flowDurationMs, trackPaymentFlowStep.flowDurationMs) && Intrinsics3.areEqual(this.eligibleForTrial, trackPaymentFlowStep.eligibleForTrial) && Intrinsics3.areEqual(this.guildId, trackPaymentFlowStep.guildId);
    }

    public int hashCode() {
        CharSequence charSequence = this.toStep;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.fromStep;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.loadId;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.stepDurationMs;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.flowDurationMs;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.eligibleForTrial;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        return iHashCode6 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPaymentFlowStep(toStep=");
        sbU.append(this.toStep);
        sbU.append(", fromStep=");
        sbU.append(this.fromStep);
        sbU.append(", loadId=");
        sbU.append(this.loadId);
        sbU.append(", stepDurationMs=");
        sbU.append(this.stepDurationMs);
        sbU.append(", flowDurationMs=");
        sbU.append(this.flowDurationMs);
        sbU.append(", eligibleForTrial=");
        sbU.append(this.eligibleForTrial);
        sbU.append(", guildId=");
        return outline.G(sbU, this.guildId, ")");
    }
}
