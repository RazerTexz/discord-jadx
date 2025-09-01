package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackNativeEchoCancellationConfigured.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0005R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010$\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010\u0014R\u001b\u0010&\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010\u0014R\u001b\u0010(\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010\u0014R\u001b\u0010*\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010\u0014¨\u0006,"}, d2 = {"Lcom/discord/analytics/generated/events/TrackNativeEchoCancellationConfigured;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "aecEnabledByDefault", "Ljava/lang/Boolean;", "getAecEnabledByDefault", "()Ljava/lang/Boolean;", "aecEnabledInSettings", "getAecEnabledInSettings", "aecMobileMode", "getAecMobileMode", "builtinAecRequested", "getBuiltinAecRequested", "builtinAecSupportedJava", "getBuiltinAecSupportedJava", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "builtinAecSupportedNative", "getBuiltinAecSupportedNative", "builtinAecEnabled", "getBuiltinAecEnabled", "aecEnabledInNativeConfig", "getAecEnabledInNativeConfig", "aecMobileModeByDefault", "getAecMobileModeByDefault", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNativeEchoCancellationConfigured implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean builtinAecSupportedJava = null;
    private final Boolean builtinAecSupportedNative = null;
    private final Boolean builtinAecRequested = null;
    private final Boolean builtinAecEnabled = null;
    private final Boolean aecEnabledInSettings = null;
    private final Boolean aecEnabledInNativeConfig = null;
    private final Boolean aecMobileMode = null;
    private final Boolean aecEnabledByDefault = null;
    private final Boolean aecMobileModeByDefault = null;
    private final transient String analyticsSchemaTypeName = "native_echo_cancellation_configured";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNativeEchoCancellationConfigured)) {
            return false;
        }
        TrackNativeEchoCancellationConfigured trackNativeEchoCancellationConfigured = (TrackNativeEchoCancellationConfigured) other;
        return Intrinsics3.areEqual(this.builtinAecSupportedJava, trackNativeEchoCancellationConfigured.builtinAecSupportedJava) && Intrinsics3.areEqual(this.builtinAecSupportedNative, trackNativeEchoCancellationConfigured.builtinAecSupportedNative) && Intrinsics3.areEqual(this.builtinAecRequested, trackNativeEchoCancellationConfigured.builtinAecRequested) && Intrinsics3.areEqual(this.builtinAecEnabled, trackNativeEchoCancellationConfigured.builtinAecEnabled) && Intrinsics3.areEqual(this.aecEnabledInSettings, trackNativeEchoCancellationConfigured.aecEnabledInSettings) && Intrinsics3.areEqual(this.aecEnabledInNativeConfig, trackNativeEchoCancellationConfigured.aecEnabledInNativeConfig) && Intrinsics3.areEqual(this.aecMobileMode, trackNativeEchoCancellationConfigured.aecMobileMode) && Intrinsics3.areEqual(this.aecEnabledByDefault, trackNativeEchoCancellationConfigured.aecEnabledByDefault) && Intrinsics3.areEqual(this.aecMobileModeByDefault, trackNativeEchoCancellationConfigured.aecMobileModeByDefault);
    }

    public int hashCode() {
        Boolean bool = this.builtinAecSupportedJava;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.builtinAecSupportedNative;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.builtinAecRequested;
        int iHashCode3 = (iHashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.builtinAecEnabled;
        int iHashCode4 = (iHashCode3 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.aecEnabledInSettings;
        int iHashCode5 = (iHashCode4 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.aecEnabledInNativeConfig;
        int iHashCode6 = (iHashCode5 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Boolean bool7 = this.aecMobileMode;
        int iHashCode7 = (iHashCode6 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Boolean bool8 = this.aecEnabledByDefault;
        int iHashCode8 = (iHashCode7 + (bool8 != null ? bool8.hashCode() : 0)) * 31;
        Boolean bool9 = this.aecMobileModeByDefault;
        return iHashCode8 + (bool9 != null ? bool9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNativeEchoCancellationConfigured(builtinAecSupportedJava=");
        sbU.append(this.builtinAecSupportedJava);
        sbU.append(", builtinAecSupportedNative=");
        sbU.append(this.builtinAecSupportedNative);
        sbU.append(", builtinAecRequested=");
        sbU.append(this.builtinAecRequested);
        sbU.append(", builtinAecEnabled=");
        sbU.append(this.builtinAecEnabled);
        sbU.append(", aecEnabledInSettings=");
        sbU.append(this.aecEnabledInSettings);
        sbU.append(", aecEnabledInNativeConfig=");
        sbU.append(this.aecEnabledInNativeConfig);
        sbU.append(", aecMobileMode=");
        sbU.append(this.aecMobileMode);
        sbU.append(", aecEnabledByDefault=");
        sbU.append(this.aecEnabledByDefault);
        sbU.append(", aecMobileModeByDefault=");
        return outline.D(sbU, this.aecMobileModeByDefault, ")");
    }
}
