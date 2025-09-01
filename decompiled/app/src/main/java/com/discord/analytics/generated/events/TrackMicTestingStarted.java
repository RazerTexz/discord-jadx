package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackMicTestingStarted.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018R\u001b\u0010$\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013R\u001b\u0010&\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R\u001c\u0010(\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0006R$\u0010,\u001a\u0004\u0018\u00010+8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001b\u00102\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/discord/analytics/generated/events/TrackMicTestingStarted;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "outputDeviceName", "Ljava/lang/CharSequence;", "getOutputDeviceName", "()Ljava/lang/CharSequence;", "", "inputDeviceVolume", "Ljava/lang/Long;", "getInputDeviceVolume", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "inputMode", "getInputMode", "inputSensitivityThreshold", "getInputSensitivityThreshold", "inputDeviceName", "getInputDeviceName", "outputDeviceVolume", "getOutputDeviceVolume", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "inputSensitivityIsAutomatic", "Ljava/lang/Boolean;", "getInputSensitivityIsAutomatic", "()Ljava/lang/Boolean;", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackMicTestingStarted implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence inputDeviceName = null;
    private final Long inputDeviceVolume = null;
    private final CharSequence outputDeviceName = null;
    private final Long outputDeviceVolume = null;
    private final CharSequence inputMode = null;
    private final Boolean inputSensitivityIsAutomatic = null;
    private final Long inputSensitivityThreshold = null;
    private final transient String analyticsSchemaTypeName = "mic_testing_started";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMicTestingStarted)) {
            return false;
        }
        TrackMicTestingStarted trackMicTestingStarted = (TrackMicTestingStarted) other;
        return Intrinsics3.areEqual(this.inputDeviceName, trackMicTestingStarted.inputDeviceName) && Intrinsics3.areEqual(this.inputDeviceVolume, trackMicTestingStarted.inputDeviceVolume) && Intrinsics3.areEqual(this.outputDeviceName, trackMicTestingStarted.outputDeviceName) && Intrinsics3.areEqual(this.outputDeviceVolume, trackMicTestingStarted.outputDeviceVolume) && Intrinsics3.areEqual(this.inputMode, trackMicTestingStarted.inputMode) && Intrinsics3.areEqual(this.inputSensitivityIsAutomatic, trackMicTestingStarted.inputSensitivityIsAutomatic) && Intrinsics3.areEqual(this.inputSensitivityThreshold, trackMicTestingStarted.inputSensitivityThreshold);
    }

    public int hashCode() {
        CharSequence charSequence = this.inputDeviceName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.inputDeviceVolume;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.outputDeviceName;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l2 = this.outputDeviceVolume;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.inputMode;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.inputSensitivityIsAutomatic;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l3 = this.inputSensitivityThreshold;
        return iHashCode6 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMicTestingStarted(inputDeviceName=");
        sbU.append(this.inputDeviceName);
        sbU.append(", inputDeviceVolume=");
        sbU.append(this.inputDeviceVolume);
        sbU.append(", outputDeviceName=");
        sbU.append(this.outputDeviceName);
        sbU.append(", outputDeviceVolume=");
        sbU.append(this.outputDeviceVolume);
        sbU.append(", inputMode=");
        sbU.append(this.inputMode);
        sbU.append(", inputSensitivityIsAutomatic=");
        sbU.append(this.inputSensitivityIsAutomatic);
        sbU.append(", inputSensitivityThreshold=");
        return outline.G(sbU, this.inputSensitivityThreshold, ")");
    }
}
