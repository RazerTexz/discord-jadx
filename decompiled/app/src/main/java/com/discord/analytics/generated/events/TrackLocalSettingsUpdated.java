package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackLocalSettingsUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R\u001c\u0010!\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0005R\u001b\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010)\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u000f\u001a\u0004\b*\u0010\u0011¨\u0006+"}, d2 = {"Lcom/discord/analytics/generated/events/TrackLocalSettingsUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "notificationsEnabled", "Ljava/lang/Boolean;", "getNotificationsEnabled", "()Ljava/lang/Boolean;", "nativePhoneIntegrationEnabled", "getNativePhoneIntegrationEnabled", "notificationsInAppEnabled", "getNotificationsInAppEnabled", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "autoStreaming", "getAutoStreaming", "colorblindEnabled", "getColorblindEnabled", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "", "saturationLevel", "Ljava/lang/Float;", "getSaturationLevel", "()Ljava/lang/Float;", "gameDetectionEnabled", "getGameDetectionEnabled", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackLocalSettingsUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean notificationsEnabled = null;
    private final Boolean notificationsInAppEnabled = null;
    private final Boolean colorblindEnabled = null;
    private final Float saturationLevel = null;
    private final Boolean gameDetectionEnabled = null;
    private final Boolean nativePhoneIntegrationEnabled = null;
    private final Boolean autoStreaming = null;
    private final transient String analyticsSchemaTypeName = "local_settings_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLocalSettingsUpdated)) {
            return false;
        }
        TrackLocalSettingsUpdated trackLocalSettingsUpdated = (TrackLocalSettingsUpdated) other;
        return Intrinsics3.areEqual(this.notificationsEnabled, trackLocalSettingsUpdated.notificationsEnabled) && Intrinsics3.areEqual(this.notificationsInAppEnabled, trackLocalSettingsUpdated.notificationsInAppEnabled) && Intrinsics3.areEqual(this.colorblindEnabled, trackLocalSettingsUpdated.colorblindEnabled) && Intrinsics3.areEqual(this.saturationLevel, trackLocalSettingsUpdated.saturationLevel) && Intrinsics3.areEqual(this.gameDetectionEnabled, trackLocalSettingsUpdated.gameDetectionEnabled) && Intrinsics3.areEqual(this.nativePhoneIntegrationEnabled, trackLocalSettingsUpdated.nativePhoneIntegrationEnabled) && Intrinsics3.areEqual(this.autoStreaming, trackLocalSettingsUpdated.autoStreaming);
    }

    public int hashCode() {
        Boolean bool = this.notificationsEnabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.notificationsInAppEnabled;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.colorblindEnabled;
        int iHashCode3 = (iHashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Float f = this.saturationLevel;
        int iHashCode4 = (iHashCode3 + (f != null ? f.hashCode() : 0)) * 31;
        Boolean bool4 = this.gameDetectionEnabled;
        int iHashCode5 = (iHashCode4 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.nativePhoneIntegrationEnabled;
        int iHashCode6 = (iHashCode5 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.autoStreaming;
        return iHashCode6 + (bool6 != null ? bool6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackLocalSettingsUpdated(notificationsEnabled=");
        sbU.append(this.notificationsEnabled);
        sbU.append(", notificationsInAppEnabled=");
        sbU.append(this.notificationsInAppEnabled);
        sbU.append(", colorblindEnabled=");
        sbU.append(this.colorblindEnabled);
        sbU.append(", saturationLevel=");
        sbU.append(this.saturationLevel);
        sbU.append(", gameDetectionEnabled=");
        sbU.append(this.gameDetectionEnabled);
        sbU.append(", nativePhoneIntegrationEnabled=");
        sbU.append(this.nativePhoneIntegrationEnabled);
        sbU.append(", autoStreaming=");
        return outline.D(sbU, this.autoStreaming, ")");
    }
}
