package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackAndroidHardwareSurvey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R\u001b\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\"R\u001b\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012R\u001c\u0010%\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0005R\u001b\u0010(\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b)\u0010\u0017R\u001b\u0010*\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0015\u001a\u0004\b+\u0010\u0017R$\u0010-\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00103\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b4\u0010\u0012R\u001b\u00105\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0010\u001a\u0004\b6\u0010\u0012R\u001b\u00107\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0010\u001a\u0004\b8\u0010\u0012R\u001b\u00109\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0015\u001a\u0004\b:\u0010\u0017R\u001b\u0010;\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010!\u001a\u0004\b<\u0010\"R\u001b\u0010=\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u0010\u001a\u0004\b>\u0010\u0012R\u001b\u0010?\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010\u0010\u001a\u0004\b@\u0010\u0012¨\u0006A"}, d2 = {"Lcom/discord/analytics/generated/events/TrackAndroidHardwareSurvey;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "decoders480", "Ljava/lang/Long;", "getDecoders480", "()Ljava/lang/Long;", "", "deviceSupportedAbis", "Ljava/lang/CharSequence;", "getDeviceSupportedAbis", "()Ljava/lang/CharSequence;", "largeMemoryClass", "getLargeMemoryClass", "decoders720", "getDecoders720", "deviceModel", "getDeviceModel", "deviceBoard", "getDeviceBoard", "isLowRamDevice", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "memoryClass", "getMemoryClass", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "deviceProduct", "getDeviceProduct", "deviceManufacturer", "getDeviceManufacturer", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "decoders1080", "getDecoders1080", "hardwareDecoders720", "getHardwareDecoders720", "hardwareDecoders480", "getHardwareDecoders480", "deviceBrand", "getDeviceBrand", "deviceIs64Bit", "getDeviceIs64Bit", "testDurationMs", "getTestDurationMs", "hardwareDecoders1080", "getHardwareDecoders1080", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackAndroidHardwareSurvey implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence deviceBoard = null;
    private final CharSequence deviceBrand = null;
    private final CharSequence deviceManufacturer = null;
    private final CharSequence deviceModel = null;
    private final CharSequence deviceProduct = null;
    private final CharSequence deviceSupportedAbis = null;
    private final Boolean deviceIs64Bit = null;
    private final Boolean isLowRamDevice = null;
    private final Long memoryClass = null;
    private final Long largeMemoryClass = null;
    private final Long hardwareDecoders1080 = null;
    private final Long hardwareDecoders720 = null;
    private final Long hardwareDecoders480 = null;
    private final Long decoders1080 = null;
    private final Long decoders720 = null;
    private final Long decoders480 = null;
    private final Long testDurationMs = null;
    private final transient String analyticsSchemaTypeName = "android_hardware_survey";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAndroidHardwareSurvey)) {
            return false;
        }
        TrackAndroidHardwareSurvey trackAndroidHardwareSurvey = (TrackAndroidHardwareSurvey) other;
        return Intrinsics3.areEqual(this.deviceBoard, trackAndroidHardwareSurvey.deviceBoard) && Intrinsics3.areEqual(this.deviceBrand, trackAndroidHardwareSurvey.deviceBrand) && Intrinsics3.areEqual(this.deviceManufacturer, trackAndroidHardwareSurvey.deviceManufacturer) && Intrinsics3.areEqual(this.deviceModel, trackAndroidHardwareSurvey.deviceModel) && Intrinsics3.areEqual(this.deviceProduct, trackAndroidHardwareSurvey.deviceProduct) && Intrinsics3.areEqual(this.deviceSupportedAbis, trackAndroidHardwareSurvey.deviceSupportedAbis) && Intrinsics3.areEqual(this.deviceIs64Bit, trackAndroidHardwareSurvey.deviceIs64Bit) && Intrinsics3.areEqual(this.isLowRamDevice, trackAndroidHardwareSurvey.isLowRamDevice) && Intrinsics3.areEqual(this.memoryClass, trackAndroidHardwareSurvey.memoryClass) && Intrinsics3.areEqual(this.largeMemoryClass, trackAndroidHardwareSurvey.largeMemoryClass) && Intrinsics3.areEqual(this.hardwareDecoders1080, trackAndroidHardwareSurvey.hardwareDecoders1080) && Intrinsics3.areEqual(this.hardwareDecoders720, trackAndroidHardwareSurvey.hardwareDecoders720) && Intrinsics3.areEqual(this.hardwareDecoders480, trackAndroidHardwareSurvey.hardwareDecoders480) && Intrinsics3.areEqual(this.decoders1080, trackAndroidHardwareSurvey.decoders1080) && Intrinsics3.areEqual(this.decoders720, trackAndroidHardwareSurvey.decoders720) && Intrinsics3.areEqual(this.decoders480, trackAndroidHardwareSurvey.decoders480) && Intrinsics3.areEqual(this.testDurationMs, trackAndroidHardwareSurvey.testDurationMs);
    }

    public int hashCode() {
        CharSequence charSequence = this.deviceBoard;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.deviceBrand;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.deviceManufacturer;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.deviceModel;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.deviceProduct;
        int iHashCode5 = (iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.deviceSupportedAbis;
        int iHashCode6 = (iHashCode5 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Boolean bool = this.deviceIs64Bit;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isLowRamDevice;
        int iHashCode8 = (iHashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.memoryClass;
        int iHashCode9 = (iHashCode8 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.largeMemoryClass;
        int iHashCode10 = (iHashCode9 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.hardwareDecoders1080;
        int iHashCode11 = (iHashCode10 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.hardwareDecoders720;
        int iHashCode12 = (iHashCode11 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.hardwareDecoders480;
        int iHashCode13 = (iHashCode12 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.decoders1080;
        int iHashCode14 = (iHashCode13 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.decoders720;
        int iHashCode15 = (iHashCode14 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.decoders480;
        int iHashCode16 = (iHashCode15 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.testDurationMs;
        return iHashCode16 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAndroidHardwareSurvey(deviceBoard=");
        sbU.append(this.deviceBoard);
        sbU.append(", deviceBrand=");
        sbU.append(this.deviceBrand);
        sbU.append(", deviceManufacturer=");
        sbU.append(this.deviceManufacturer);
        sbU.append(", deviceModel=");
        sbU.append(this.deviceModel);
        sbU.append(", deviceProduct=");
        sbU.append(this.deviceProduct);
        sbU.append(", deviceSupportedAbis=");
        sbU.append(this.deviceSupportedAbis);
        sbU.append(", deviceIs64Bit=");
        sbU.append(this.deviceIs64Bit);
        sbU.append(", isLowRamDevice=");
        sbU.append(this.isLowRamDevice);
        sbU.append(", memoryClass=");
        sbU.append(this.memoryClass);
        sbU.append(", largeMemoryClass=");
        sbU.append(this.largeMemoryClass);
        sbU.append(", hardwareDecoders1080=");
        sbU.append(this.hardwareDecoders1080);
        sbU.append(", hardwareDecoders720=");
        sbU.append(this.hardwareDecoders720);
        sbU.append(", hardwareDecoders480=");
        sbU.append(this.hardwareDecoders480);
        sbU.append(", decoders1080=");
        sbU.append(this.decoders1080);
        sbU.append(", decoders720=");
        sbU.append(this.decoders720);
        sbU.append(", decoders480=");
        sbU.append(this.decoders480);
        sbU.append(", testDurationMs=");
        return outline.G(sbU, this.testDurationMs, ")");
    }
}
