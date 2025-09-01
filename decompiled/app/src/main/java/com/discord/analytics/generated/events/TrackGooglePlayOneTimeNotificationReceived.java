package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackGooglePlayOneTimeNotificationReceived.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR!\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010$\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013R\u001b\u0010&\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R\u001b\u0010(\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018R\u001c\u0010*\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0005R\u001b\u0010-\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0016\u001a\u0004\b.\u0010\u0018R\u001b\u0010/\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0016\u001a\u0004\b0\u0010\u0018R\u001b\u00101\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0011\u001a\u0004\b2\u0010\u0013R\u001b\u00103\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0016\u001a\u0004\b4\u0010\u0018R\u001b\u00105\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0016\u001a\u0004\b6\u0010\u0018¨\u00067"}, d2 = {"Lcom/discord/analytics/generated/events/TrackGooglePlayOneTimeNotificationReceived;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/primitives/Timestamp;", "eventTime", "Ljava/lang/Long;", "getEventTime", "()Ljava/lang/Long;", "", "notificationVersion", "Ljava/lang/CharSequence;", "getNotificationVersion", "()Ljava/lang/CharSequence;", "notificationType", "getNotificationType", "skuId", "getSkuId", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "paymentId", "getPaymentId", "purchaseToken", "getPurchaseToken", "orderId", "getOrderId", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "packageName", "getPackageName", "oneTimePurchaseSkuId", "getOneTimePurchaseSkuId", "paymentGateway", "getPaymentGateway", "version", "getVersion", "messageId", "getMessageId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackGooglePlayOneTimeNotificationReceived implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long paymentId = null;
    private final Long skuId = null;
    private final CharSequence oneTimePurchaseSkuId = null;
    private final Long paymentGateway = null;
    private final CharSequence messageId = null;
    private final CharSequence version = null;
    private final CharSequence packageName = null;
    private final Long eventTime = null;
    private final CharSequence notificationVersion = null;
    private final Long notificationType = null;
    private final CharSequence purchaseToken = null;
    private final CharSequence orderId = null;
    private final transient String analyticsSchemaTypeName = "google_play_one_time_notification_received";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGooglePlayOneTimeNotificationReceived)) {
            return false;
        }
        TrackGooglePlayOneTimeNotificationReceived trackGooglePlayOneTimeNotificationReceived = (TrackGooglePlayOneTimeNotificationReceived) other;
        return Intrinsics3.areEqual(this.paymentId, trackGooglePlayOneTimeNotificationReceived.paymentId) && Intrinsics3.areEqual(this.skuId, trackGooglePlayOneTimeNotificationReceived.skuId) && Intrinsics3.areEqual(this.oneTimePurchaseSkuId, trackGooglePlayOneTimeNotificationReceived.oneTimePurchaseSkuId) && Intrinsics3.areEqual(this.paymentGateway, trackGooglePlayOneTimeNotificationReceived.paymentGateway) && Intrinsics3.areEqual(this.messageId, trackGooglePlayOneTimeNotificationReceived.messageId) && Intrinsics3.areEqual(this.version, trackGooglePlayOneTimeNotificationReceived.version) && Intrinsics3.areEqual(this.packageName, trackGooglePlayOneTimeNotificationReceived.packageName) && Intrinsics3.areEqual(this.eventTime, trackGooglePlayOneTimeNotificationReceived.eventTime) && Intrinsics3.areEqual(this.notificationVersion, trackGooglePlayOneTimeNotificationReceived.notificationVersion) && Intrinsics3.areEqual(this.notificationType, trackGooglePlayOneTimeNotificationReceived.notificationType) && Intrinsics3.areEqual(this.purchaseToken, trackGooglePlayOneTimeNotificationReceived.purchaseToken) && Intrinsics3.areEqual(this.orderId, trackGooglePlayOneTimeNotificationReceived.orderId);
    }

    public int hashCode() {
        Long l = this.paymentId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.skuId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.oneTimePurchaseSkuId;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.paymentGateway;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.messageId;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.version;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.packageName;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l4 = this.eventTime;
        int iHashCode8 = (iHashCode7 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.notificationVersion;
        int iHashCode9 = (iHashCode8 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l5 = this.notificationType;
        int iHashCode10 = (iHashCode9 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.purchaseToken;
        int iHashCode11 = (iHashCode10 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.orderId;
        return iHashCode11 + (charSequence7 != null ? charSequence7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGooglePlayOneTimeNotificationReceived(paymentId=");
        sbU.append(this.paymentId);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", oneTimePurchaseSkuId=");
        sbU.append(this.oneTimePurchaseSkuId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", version=");
        sbU.append(this.version);
        sbU.append(", packageName=");
        sbU.append(this.packageName);
        sbU.append(", eventTime=");
        sbU.append(this.eventTime);
        sbU.append(", notificationVersion=");
        sbU.append(this.notificationVersion);
        sbU.append(", notificationType=");
        sbU.append(this.notificationType);
        sbU.append(", purchaseToken=");
        sbU.append(this.purchaseToken);
        sbU.append(", orderId=");
        return outline.E(sbU, this.orderId, ")");
    }
}
