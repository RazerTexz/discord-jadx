package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackNetworkInformationDurations.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010R\u001b\u0010!\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0010R\u001b\u0010#\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u000e\u001a\u0004\b$\u0010\u0010¨\u0006%"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackNetworkInformationDurations;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "durationConnectionTypeNone", "Ljava/lang/Long;", "getDurationConnectionTypeNone", "()Ljava/lang/Long;", "durationConnectionTypeOther", "getDurationConnectionTypeOther", "durationConnectionTypeEthernet", "getDurationConnectionTypeEthernet", "durationEffectiveConnectionSpeed3g", "getDurationEffectiveConnectionSpeed3g", "durationEffectiveConnectionSpeed2g", "getDurationEffectiveConnectionSpeed2g", "durationConnectionTypeCellular", "getDurationConnectionTypeCellular", "durationConnectionTypeWifi", "getDurationConnectionTypeWifi", "durationEffectiveConnectionSpeed4g", "getDurationEffectiveConnectionSpeed4g", "durationConnectionTypeUnknown", "getDurationConnectionTypeUnknown", "durationEffectiveConnectionSpeedUnknown", "getDurationEffectiveConnectionSpeedUnknown", "durationConnectionTypeBluetooth", "getDurationConnectionTypeBluetooth", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkInformationDurations {
    private final Long durationConnectionTypeWifi = null;
    private final Long durationConnectionTypeCellular = null;
    private final Long durationConnectionTypeEthernet = null;
    private final Long durationConnectionTypeBluetooth = null;
    private final Long durationConnectionTypeOther = null;
    private final Long durationConnectionTypeUnknown = null;
    private final Long durationConnectionTypeNone = null;
    private final Long durationEffectiveConnectionSpeed2g = null;
    private final Long durationEffectiveConnectionSpeed3g = null;
    private final Long durationEffectiveConnectionSpeed4g = null;
    private final Long durationEffectiveConnectionSpeedUnknown = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkInformationDurations)) {
            return false;
        }
        TrackNetworkInformationDurations trackNetworkInformationDurations = (TrackNetworkInformationDurations) other;
        return Intrinsics3.areEqual(this.durationConnectionTypeWifi, trackNetworkInformationDurations.durationConnectionTypeWifi) && Intrinsics3.areEqual(this.durationConnectionTypeCellular, trackNetworkInformationDurations.durationConnectionTypeCellular) && Intrinsics3.areEqual(this.durationConnectionTypeEthernet, trackNetworkInformationDurations.durationConnectionTypeEthernet) && Intrinsics3.areEqual(this.durationConnectionTypeBluetooth, trackNetworkInformationDurations.durationConnectionTypeBluetooth) && Intrinsics3.areEqual(this.durationConnectionTypeOther, trackNetworkInformationDurations.durationConnectionTypeOther) && Intrinsics3.areEqual(this.durationConnectionTypeUnknown, trackNetworkInformationDurations.durationConnectionTypeUnknown) && Intrinsics3.areEqual(this.durationConnectionTypeNone, trackNetworkInformationDurations.durationConnectionTypeNone) && Intrinsics3.areEqual(this.durationEffectiveConnectionSpeed2g, trackNetworkInformationDurations.durationEffectiveConnectionSpeed2g) && Intrinsics3.areEqual(this.durationEffectiveConnectionSpeed3g, trackNetworkInformationDurations.durationEffectiveConnectionSpeed3g) && Intrinsics3.areEqual(this.durationEffectiveConnectionSpeed4g, trackNetworkInformationDurations.durationEffectiveConnectionSpeed4g) && Intrinsics3.areEqual(this.durationEffectiveConnectionSpeedUnknown, trackNetworkInformationDurations.durationEffectiveConnectionSpeedUnknown);
    }

    public int hashCode() {
        Long l = this.durationConnectionTypeWifi;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.durationConnectionTypeCellular;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.durationConnectionTypeEthernet;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.durationConnectionTypeBluetooth;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.durationConnectionTypeOther;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.durationConnectionTypeUnknown;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.durationConnectionTypeNone;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.durationEffectiveConnectionSpeed2g;
        int iHashCode8 = (iHashCode7 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.durationEffectiveConnectionSpeed3g;
        int iHashCode9 = (iHashCode8 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.durationEffectiveConnectionSpeed4g;
        int iHashCode10 = (iHashCode9 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.durationEffectiveConnectionSpeedUnknown;
        return iHashCode10 + (l11 != null ? l11.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNetworkInformationDurations(durationConnectionTypeWifi=");
        sbU.append(this.durationConnectionTypeWifi);
        sbU.append(", durationConnectionTypeCellular=");
        sbU.append(this.durationConnectionTypeCellular);
        sbU.append(", durationConnectionTypeEthernet=");
        sbU.append(this.durationConnectionTypeEthernet);
        sbU.append(", durationConnectionTypeBluetooth=");
        sbU.append(this.durationConnectionTypeBluetooth);
        sbU.append(", durationConnectionTypeOther=");
        sbU.append(this.durationConnectionTypeOther);
        sbU.append(", durationConnectionTypeUnknown=");
        sbU.append(this.durationConnectionTypeUnknown);
        sbU.append(", durationConnectionTypeNone=");
        sbU.append(this.durationConnectionTypeNone);
        sbU.append(", durationEffectiveConnectionSpeed2g=");
        sbU.append(this.durationEffectiveConnectionSpeed2g);
        sbU.append(", durationEffectiveConnectionSpeed3g=");
        sbU.append(this.durationEffectiveConnectionSpeed3g);
        sbU.append(", durationEffectiveConnectionSpeed4g=");
        sbU.append(this.durationEffectiveConnectionSpeed4g);
        sbU.append(", durationEffectiveConnectionSpeedUnknown=");
        return outline.G(sbU, this.durationEffectiveConnectionSpeedUnknown, ")");
    }
}
