package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackSubscriptionLazySyncUserPerks.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u0012R\u001b\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012R\u001b\u0010%\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010\u0012R\u001b\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R!\u0010-\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0010\u001a\u0004\b.\u0010\u0012R\u001b\u0010/\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010\u0012R!\u00101\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`,8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0010\u001a\u0004\b2\u0010\u0012R\u001b\u00103\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0017\u001a\u0004\b4\u0010\u0019R!\u00105\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`,8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0010\u001a\u0004\b6\u0010\u0012R!\u00107\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`,8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0010\u001a\u0004\b8\u0010\u0012¨\u00069"}, d2 = {"Lcom/discord/analytics/generated/events/TrackSubscriptionLazySyncUserPerks;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "subscriptionPlanId", "Ljava/lang/Long;", "getSubscriptionPlanId", "()Ljava/lang/Long;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "premiumUntilMismatch", "Ljava/lang/Boolean;", "getPremiumUntilMismatch", "()Ljava/lang/Boolean;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "subscriptionId", "getSubscriptionId", "paymentGateway", "getPaymentGateway", "newPremiumType", "getNewPremiumType", "", "paymentGatewayPlanId", "Ljava/lang/CharSequence;", "getPaymentGatewayPlanId", "()Ljava/lang/CharSequence;", "Lcom/discord/primitives/Timestamp;", "currentPeriodEnd", "getCurrentPeriodEnd", "originalPremiumType", "getOriginalPremiumType", "currentPeriodStart", "getCurrentPeriodStart", "premiumTypeMismatch", "getPremiumTypeMismatch", "originalPremiumUntil", "getOriginalPremiumUntil", "newPremiumUntil", "getNewPremiumUntil", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackSubscriptionLazySyncUserPerks implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long subscriptionId = null;
    private final Long subscriptionPlanId = null;
    private final Long paymentGateway = null;
    private final CharSequence paymentGatewayPlanId = null;
    private final Long currentPeriodStart = null;
    private final Long currentPeriodEnd = null;
    private final Boolean premiumTypeMismatch = null;
    private final Boolean premiumUntilMismatch = null;
    private final Long originalPremiumType = null;
    private final Long originalPremiumUntil = null;
    private final Long newPremiumType = null;
    private final Long newPremiumUntil = null;
    private final transient String analyticsSchemaTypeName = "subscription_lazy_sync_user_perks";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionLazySyncUserPerks)) {
            return false;
        }
        TrackSubscriptionLazySyncUserPerks trackSubscriptionLazySyncUserPerks = (TrackSubscriptionLazySyncUserPerks) other;
        return Intrinsics3.areEqual(this.subscriptionId, trackSubscriptionLazySyncUserPerks.subscriptionId) && Intrinsics3.areEqual(this.subscriptionPlanId, trackSubscriptionLazySyncUserPerks.subscriptionPlanId) && Intrinsics3.areEqual(this.paymentGateway, trackSubscriptionLazySyncUserPerks.paymentGateway) && Intrinsics3.areEqual(this.paymentGatewayPlanId, trackSubscriptionLazySyncUserPerks.paymentGatewayPlanId) && Intrinsics3.areEqual(this.currentPeriodStart, trackSubscriptionLazySyncUserPerks.currentPeriodStart) && Intrinsics3.areEqual(this.currentPeriodEnd, trackSubscriptionLazySyncUserPerks.currentPeriodEnd) && Intrinsics3.areEqual(this.premiumTypeMismatch, trackSubscriptionLazySyncUserPerks.premiumTypeMismatch) && Intrinsics3.areEqual(this.premiumUntilMismatch, trackSubscriptionLazySyncUserPerks.premiumUntilMismatch) && Intrinsics3.areEqual(this.originalPremiumType, trackSubscriptionLazySyncUserPerks.originalPremiumType) && Intrinsics3.areEqual(this.originalPremiumUntil, trackSubscriptionLazySyncUserPerks.originalPremiumUntil) && Intrinsics3.areEqual(this.newPremiumType, trackSubscriptionLazySyncUserPerks.newPremiumType) && Intrinsics3.areEqual(this.newPremiumUntil, trackSubscriptionLazySyncUserPerks.newPremiumUntil);
    }

    public int hashCode() {
        Long l = this.subscriptionId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.subscriptionPlanId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.paymentGateway;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.paymentGatewayPlanId;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l4 = this.currentPeriodStart;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.currentPeriodEnd;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool = this.premiumTypeMismatch;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.premiumUntilMismatch;
        int iHashCode8 = (iHashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l6 = this.originalPremiumType;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.originalPremiumUntil;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.newPremiumType;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.newPremiumUntil;
        return iHashCode11 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSubscriptionLazySyncUserPerks(subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", subscriptionPlanId=");
        sbU.append(this.subscriptionPlanId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", paymentGatewayPlanId=");
        sbU.append(this.paymentGatewayPlanId);
        sbU.append(", currentPeriodStart=");
        sbU.append(this.currentPeriodStart);
        sbU.append(", currentPeriodEnd=");
        sbU.append(this.currentPeriodEnd);
        sbU.append(", premiumTypeMismatch=");
        sbU.append(this.premiumTypeMismatch);
        sbU.append(", premiumUntilMismatch=");
        sbU.append(this.premiumUntilMismatch);
        sbU.append(", originalPremiumType=");
        sbU.append(this.originalPremiumType);
        sbU.append(", originalPremiumUntil=");
        sbU.append(this.originalPremiumUntil);
        sbU.append(", newPremiumType=");
        sbU.append(this.newPremiumType);
        sbU.append(", newPremiumUntil=");
        return outline.G(sbU, this.newPremiumUntil, ")");
    }
}
