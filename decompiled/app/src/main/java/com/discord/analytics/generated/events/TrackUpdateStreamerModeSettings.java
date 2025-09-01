package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackUpdateStreamerModeSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011R\u001c\u0010\u001f\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0005R\u001b\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R\u001b\u0010$\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u000f\u001a\u0004\b%\u0010\u0011¨\u0006&"}, d2 = {"Lcom/discord/analytics/generated/events/TrackUpdateStreamerModeSettings;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "disableSounds", "Ljava/lang/Boolean;", "getDisableSounds", "()Ljava/lang/Boolean;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "disableNotifications", "getDisableNotifications", "hidePersonalInfo", "getHidePersonalInfo", "enabled", "getEnabled", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "hideInstantInvites", "getHideInstantInvites", "automatic", "getAutomatic", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackUpdateStreamerModeSettings implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean automatic = null;
    private final Boolean disableNotifications = null;
    private final Boolean disableSounds = null;
    private final Boolean enabled = null;
    private final Boolean hideInstantInvites = null;
    private final Boolean hidePersonalInfo = null;
    private final transient String analyticsSchemaTypeName = "update_streamer_mode_settings";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpdateStreamerModeSettings)) {
            return false;
        }
        TrackUpdateStreamerModeSettings trackUpdateStreamerModeSettings = (TrackUpdateStreamerModeSettings) other;
        return Intrinsics3.areEqual(this.automatic, trackUpdateStreamerModeSettings.automatic) && Intrinsics3.areEqual(this.disableNotifications, trackUpdateStreamerModeSettings.disableNotifications) && Intrinsics3.areEqual(this.disableSounds, trackUpdateStreamerModeSettings.disableSounds) && Intrinsics3.areEqual(this.enabled, trackUpdateStreamerModeSettings.enabled) && Intrinsics3.areEqual(this.hideInstantInvites, trackUpdateStreamerModeSettings.hideInstantInvites) && Intrinsics3.areEqual(this.hidePersonalInfo, trackUpdateStreamerModeSettings.hidePersonalInfo);
    }

    public int hashCode() {
        Boolean bool = this.automatic;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.disableNotifications;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.disableSounds;
        int iHashCode3 = (iHashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.enabled;
        int iHashCode4 = (iHashCode3 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.hideInstantInvites;
        int iHashCode5 = (iHashCode4 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.hidePersonalInfo;
        return iHashCode5 + (bool6 != null ? bool6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUpdateStreamerModeSettings(automatic=");
        sbU.append(this.automatic);
        sbU.append(", disableNotifications=");
        sbU.append(this.disableNotifications);
        sbU.append(", disableSounds=");
        sbU.append(this.disableSounds);
        sbU.append(", enabled=");
        sbU.append(this.enabled);
        sbU.append(", hideInstantInvites=");
        sbU.append(this.hideInstantInvites);
        sbU.append(", hidePersonalInfo=");
        return outline.D(sbU, this.hidePersonalInfo, ")");
    }
}
