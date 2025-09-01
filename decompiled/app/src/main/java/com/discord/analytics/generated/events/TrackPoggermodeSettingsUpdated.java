package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackPoggermodeSettingsUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R!\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010)\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u0012R\u001b\u0010+\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010!R!\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010\u001dR\u001b\u0010/\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010\u0012R\u001b\u00101\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u001f\u001a\u0004\b2\u0010!R\u001b\u00103\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u001f\u001a\u0004\b4\u0010!¨\u00065"}, d2 = {"Lcom/discord/analytics/generated/events/TrackPoggermodeSettingsUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "confettiSize", "Ljava/lang/Long;", "getConfettiSize", "()Ljava/lang/Long;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "confettiCount", "getConfettiCount", "", "", "confettiEnabledLocations", "Ljava/util/List;", "getConfettiEnabledLocations", "()Ljava/util/List;", "screenshakeEnabled", "Ljava/lang/Boolean;", "getScreenshakeEnabled", "()Ljava/lang/Boolean;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "combosRequiredCount", "getCombosRequiredCount", "combosEnabled", "getCombosEnabled", "screenshakeEnabledLocations", "getScreenshakeEnabledLocations", "shakeIntensity", "getShakeIntensity", "enabled", "getEnabled", "confettiEnabled", "getConfettiEnabled", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackPoggermodeSettingsUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean enabled = null;
    private final Boolean combosEnabled = null;
    private final Long combosRequiredCount = null;
    private final Boolean screenshakeEnabled = null;
    private final Long shakeIntensity = null;
    private final List<CharSequence> screenshakeEnabledLocations = null;
    private final Boolean confettiEnabled = null;
    private final Long confettiSize = null;
    private final Long confettiCount = null;
    private final List<CharSequence> confettiEnabledLocations = null;
    private final transient String analyticsSchemaTypeName = "poggermode_settings_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPoggermodeSettingsUpdated)) {
            return false;
        }
        TrackPoggermodeSettingsUpdated trackPoggermodeSettingsUpdated = (TrackPoggermodeSettingsUpdated) other;
        return Intrinsics3.areEqual(this.enabled, trackPoggermodeSettingsUpdated.enabled) && Intrinsics3.areEqual(this.combosEnabled, trackPoggermodeSettingsUpdated.combosEnabled) && Intrinsics3.areEqual(this.combosRequiredCount, trackPoggermodeSettingsUpdated.combosRequiredCount) && Intrinsics3.areEqual(this.screenshakeEnabled, trackPoggermodeSettingsUpdated.screenshakeEnabled) && Intrinsics3.areEqual(this.shakeIntensity, trackPoggermodeSettingsUpdated.shakeIntensity) && Intrinsics3.areEqual(this.screenshakeEnabledLocations, trackPoggermodeSettingsUpdated.screenshakeEnabledLocations) && Intrinsics3.areEqual(this.confettiEnabled, trackPoggermodeSettingsUpdated.confettiEnabled) && Intrinsics3.areEqual(this.confettiSize, trackPoggermodeSettingsUpdated.confettiSize) && Intrinsics3.areEqual(this.confettiCount, trackPoggermodeSettingsUpdated.confettiCount) && Intrinsics3.areEqual(this.confettiEnabledLocations, trackPoggermodeSettingsUpdated.confettiEnabledLocations);
    }

    public int hashCode() {
        Boolean bool = this.enabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.combosEnabled;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.combosRequiredCount;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool3 = this.screenshakeEnabled;
        int iHashCode4 = (iHashCode3 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l2 = this.shakeIntensity;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        List<CharSequence> list = this.screenshakeEnabledLocations;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool4 = this.confettiEnabled;
        int iHashCode7 = (iHashCode6 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l3 = this.confettiSize;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.confettiCount;
        int iHashCode9 = (iHashCode8 + (l4 != null ? l4.hashCode() : 0)) * 31;
        List<CharSequence> list2 = this.confettiEnabledLocations;
        return iHashCode9 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPoggermodeSettingsUpdated(enabled=");
        sbU.append(this.enabled);
        sbU.append(", combosEnabled=");
        sbU.append(this.combosEnabled);
        sbU.append(", combosRequiredCount=");
        sbU.append(this.combosRequiredCount);
        sbU.append(", screenshakeEnabled=");
        sbU.append(this.screenshakeEnabled);
        sbU.append(", shakeIntensity=");
        sbU.append(this.shakeIntensity);
        sbU.append(", screenshakeEnabledLocations=");
        sbU.append(this.screenshakeEnabledLocations);
        sbU.append(", confettiEnabled=");
        sbU.append(this.confettiEnabled);
        sbU.append(", confettiSize=");
        sbU.append(this.confettiSize);
        sbU.append(", confettiCount=");
        sbU.append(this.confettiCount);
        sbU.append(", confettiEnabledLocations=");
        return outline.L(sbU, this.confettiEnabledLocations, ")");
    }
}
