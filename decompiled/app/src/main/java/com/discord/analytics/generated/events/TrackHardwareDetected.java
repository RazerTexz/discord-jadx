package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackHardwareDetected.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\r\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016R\u001b\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016R\u001b\u0010$\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0016R\u001b\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010+\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0014\u001a\u0004\b,\u0010\u0016R\u001b\u0010-\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0014\u001a\u0004\b.\u0010\u0016R\u001b\u0010/\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010(\u001a\u0004\b0\u0010*R\u001b\u00101\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0014\u001a\u0004\b2\u0010\u0016R\u001b\u00103\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0014\u001a\u0004\b4\u0010\u0016R\u001b\u00105\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0014\u001a\u0004\b6\u0010\u0016R\u001b\u00107\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010(\u001a\u0004\b8\u0010*R\u001b\u00109\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0014\u001a\u0004\b:\u0010\u0016R\u001b\u0010;\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u000f\u001a\u0004\b<\u0010\u0011R\u001b\u0010=\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u0014\u001a\u0004\b>\u0010\u0016R\u001b\u0010?\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010\u0016R\u001b\u0010A\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010\u0014\u001a\u0004\bB\u0010\u0016R$\u0010D\u001a\u0004\u0018\u00010C8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001b\u0010J\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010(\u001a\u0004\bK\u0010*R\u001b\u0010L\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010\u0014\u001a\u0004\bM\u0010\u0016R\u001b\u0010N\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010(\u001a\u0004\bO\u0010*¨\u0006P"}, d2 = {"Lcom/discord/analytics/generated/events/TrackHardwareDetected;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "cameraDefaultHasMjpg", "Ljava/lang/Boolean;", "getCameraDefaultHasMjpg", "()Ljava/lang/Boolean;", "", "cameraDefaultMaxWidth", "Ljava/lang/Long;", "getCameraDefaultMaxWidth", "()Ljava/lang/Long;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "cameraDefaultHasNv12", "getCameraDefaultHasNv12", "wave", "getWave", "displayPrimaryHeight", "getDisplayPrimaryHeight", "cameraDefaultHasI420", "getCameraDefaultHasI420", "cpuMemory", "getCpuMemory", "cameraDefaultVendorId", "getCameraDefaultVendorId", "", "cameraDefaultName", "Ljava/lang/CharSequence;", "getCameraDefaultName", "()Ljava/lang/CharSequence;", "cameraCount", "getCameraCount", "cameraDefaultProductId", "getCameraDefaultProductId", "gpuBrand", "getGpuBrand", "displayMonitors", "getDisplayMonitors", "gpuCount", "getGpuCount", "displayPrimaryWidth", "getDisplayPrimaryWidth", "cpuVendor", "getCpuVendor", "displayDesktopWidth", "getDisplayDesktopWidth", "cameraDefaultHasYuy2", "getCameraDefaultHasYuy2", "gpuMemory", "getGpuMemory", "batteries", "getBatteries", "displayDesktopHeight", "getDisplayDesktopHeight", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "cpuBrand", "getCpuBrand", "cameraDefaultMaxHeight", "getCameraDefaultMaxHeight", "cameraDefaultBus", "getCameraDefaultBus", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackHardwareDetected implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long wave = null;
    private final CharSequence cpuBrand = null;
    private final CharSequence cpuVendor = null;
    private final Long cpuMemory = null;
    private final CharSequence gpuBrand = null;
    private final Long gpuCount = null;
    private final Long gpuMemory = null;
    private final Long batteries = null;
    private final Long displayMonitors = null;
    private final Long displayPrimaryWidth = null;
    private final Long displayPrimaryHeight = null;
    private final Long displayDesktopWidth = null;
    private final Long displayDesktopHeight = null;
    private final Long cameraCount = null;
    private final CharSequence cameraDefaultName = null;
    private final Long cameraDefaultMaxWidth = null;
    private final Long cameraDefaultMaxHeight = null;
    private final Boolean cameraDefaultHasI420 = null;
    private final Boolean cameraDefaultHasNv12 = null;
    private final Boolean cameraDefaultHasYuy2 = null;
    private final Boolean cameraDefaultHasMjpg = null;
    private final CharSequence cameraDefaultBus = null;
    private final Long cameraDefaultVendorId = null;
    private final Long cameraDefaultProductId = null;
    private final transient String analyticsSchemaTypeName = "hardware_detected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackHardwareDetected)) {
            return false;
        }
        TrackHardwareDetected trackHardwareDetected = (TrackHardwareDetected) other;
        return Intrinsics3.areEqual(this.wave, trackHardwareDetected.wave) && Intrinsics3.areEqual(this.cpuBrand, trackHardwareDetected.cpuBrand) && Intrinsics3.areEqual(this.cpuVendor, trackHardwareDetected.cpuVendor) && Intrinsics3.areEqual(this.cpuMemory, trackHardwareDetected.cpuMemory) && Intrinsics3.areEqual(this.gpuBrand, trackHardwareDetected.gpuBrand) && Intrinsics3.areEqual(this.gpuCount, trackHardwareDetected.gpuCount) && Intrinsics3.areEqual(this.gpuMemory, trackHardwareDetected.gpuMemory) && Intrinsics3.areEqual(this.batteries, trackHardwareDetected.batteries) && Intrinsics3.areEqual(this.displayMonitors, trackHardwareDetected.displayMonitors) && Intrinsics3.areEqual(this.displayPrimaryWidth, trackHardwareDetected.displayPrimaryWidth) && Intrinsics3.areEqual(this.displayPrimaryHeight, trackHardwareDetected.displayPrimaryHeight) && Intrinsics3.areEqual(this.displayDesktopWidth, trackHardwareDetected.displayDesktopWidth) && Intrinsics3.areEqual(this.displayDesktopHeight, trackHardwareDetected.displayDesktopHeight) && Intrinsics3.areEqual(this.cameraCount, trackHardwareDetected.cameraCount) && Intrinsics3.areEqual(this.cameraDefaultName, trackHardwareDetected.cameraDefaultName) && Intrinsics3.areEqual(this.cameraDefaultMaxWidth, trackHardwareDetected.cameraDefaultMaxWidth) && Intrinsics3.areEqual(this.cameraDefaultMaxHeight, trackHardwareDetected.cameraDefaultMaxHeight) && Intrinsics3.areEqual(this.cameraDefaultHasI420, trackHardwareDetected.cameraDefaultHasI420) && Intrinsics3.areEqual(this.cameraDefaultHasNv12, trackHardwareDetected.cameraDefaultHasNv12) && Intrinsics3.areEqual(this.cameraDefaultHasYuy2, trackHardwareDetected.cameraDefaultHasYuy2) && Intrinsics3.areEqual(this.cameraDefaultHasMjpg, trackHardwareDetected.cameraDefaultHasMjpg) && Intrinsics3.areEqual(this.cameraDefaultBus, trackHardwareDetected.cameraDefaultBus) && Intrinsics3.areEqual(this.cameraDefaultVendorId, trackHardwareDetected.cameraDefaultVendorId) && Intrinsics3.areEqual(this.cameraDefaultProductId, trackHardwareDetected.cameraDefaultProductId);
    }

    public int hashCode() {
        Long l = this.wave;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.cpuBrand;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.cpuVendor;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l2 = this.cpuMemory;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.gpuBrand;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l3 = this.gpuCount;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.gpuMemory;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.batteries;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.displayMonitors;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.displayPrimaryWidth;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.displayPrimaryHeight;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.displayDesktopWidth;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.displayDesktopHeight;
        int iHashCode13 = (iHashCode12 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.cameraCount;
        int iHashCode14 = (iHashCode13 + (l11 != null ? l11.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.cameraDefaultName;
        int iHashCode15 = (iHashCode14 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l12 = this.cameraDefaultMaxWidth;
        int iHashCode16 = (iHashCode15 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.cameraDefaultMaxHeight;
        int iHashCode17 = (iHashCode16 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Boolean bool = this.cameraDefaultHasI420;
        int iHashCode18 = (iHashCode17 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.cameraDefaultHasNv12;
        int iHashCode19 = (iHashCode18 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.cameraDefaultHasYuy2;
        int iHashCode20 = (iHashCode19 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.cameraDefaultHasMjpg;
        int iHashCode21 = (iHashCode20 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.cameraDefaultBus;
        int iHashCode22 = (iHashCode21 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l14 = this.cameraDefaultVendorId;
        int iHashCode23 = (iHashCode22 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.cameraDefaultProductId;
        return iHashCode23 + (l15 != null ? l15.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackHardwareDetected(wave=");
        sbU.append(this.wave);
        sbU.append(", cpuBrand=");
        sbU.append(this.cpuBrand);
        sbU.append(", cpuVendor=");
        sbU.append(this.cpuVendor);
        sbU.append(", cpuMemory=");
        sbU.append(this.cpuMemory);
        sbU.append(", gpuBrand=");
        sbU.append(this.gpuBrand);
        sbU.append(", gpuCount=");
        sbU.append(this.gpuCount);
        sbU.append(", gpuMemory=");
        sbU.append(this.gpuMemory);
        sbU.append(", batteries=");
        sbU.append(this.batteries);
        sbU.append(", displayMonitors=");
        sbU.append(this.displayMonitors);
        sbU.append(", displayPrimaryWidth=");
        sbU.append(this.displayPrimaryWidth);
        sbU.append(", displayPrimaryHeight=");
        sbU.append(this.displayPrimaryHeight);
        sbU.append(", displayDesktopWidth=");
        sbU.append(this.displayDesktopWidth);
        sbU.append(", displayDesktopHeight=");
        sbU.append(this.displayDesktopHeight);
        sbU.append(", cameraCount=");
        sbU.append(this.cameraCount);
        sbU.append(", cameraDefaultName=");
        sbU.append(this.cameraDefaultName);
        sbU.append(", cameraDefaultMaxWidth=");
        sbU.append(this.cameraDefaultMaxWidth);
        sbU.append(", cameraDefaultMaxHeight=");
        sbU.append(this.cameraDefaultMaxHeight);
        sbU.append(", cameraDefaultHasI420=");
        sbU.append(this.cameraDefaultHasI420);
        sbU.append(", cameraDefaultHasNv12=");
        sbU.append(this.cameraDefaultHasNv12);
        sbU.append(", cameraDefaultHasYuy2=");
        sbU.append(this.cameraDefaultHasYuy2);
        sbU.append(", cameraDefaultHasMjpg=");
        sbU.append(this.cameraDefaultHasMjpg);
        sbU.append(", cameraDefaultBus=");
        sbU.append(this.cameraDefaultBus);
        sbU.append(", cameraDefaultVendorId=");
        sbU.append(this.cameraDefaultVendorId);
        sbU.append(", cameraDefaultProductId=");
        return outline.G(sbU, this.cameraDefaultProductId, ")");
    }
}
