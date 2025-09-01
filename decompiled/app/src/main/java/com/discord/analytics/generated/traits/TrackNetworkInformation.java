package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackNetworkInformation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackNetworkInformation;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "effectiveConnectionSpeed", "Ljava/lang/CharSequence;", "getEffectiveConnectionSpeed", "()Ljava/lang/CharSequence;", "connectionType", "getConnectionType", "serviceProvider", "getServiceProvider", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkInformation {
    private final CharSequence connectionType = null;
    private final CharSequence effectiveConnectionSpeed = null;
    private final CharSequence serviceProvider = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkInformation)) {
            return false;
        }
        TrackNetworkInformation trackNetworkInformation = (TrackNetworkInformation) other;
        return Intrinsics3.areEqual(this.connectionType, trackNetworkInformation.connectionType) && Intrinsics3.areEqual(this.effectiveConnectionSpeed, trackNetworkInformation.effectiveConnectionSpeed) && Intrinsics3.areEqual(this.serviceProvider, trackNetworkInformation.serviceProvider);
    }

    public int hashCode() {
        CharSequence charSequence = this.connectionType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.effectiveConnectionSpeed;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.serviceProvider;
        return iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNetworkInformation(connectionType=");
        sbU.append(this.connectionType);
        sbU.append(", effectiveConnectionSpeed=");
        sbU.append(this.effectiveConnectionSpeed);
        sbU.append(", serviceProvider=");
        return outline.E(sbU, this.serviceProvider, ")");
    }
}
