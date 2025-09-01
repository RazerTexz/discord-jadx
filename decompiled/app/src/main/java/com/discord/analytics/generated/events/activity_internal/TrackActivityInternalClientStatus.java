package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackActivityInternalClientStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0006R\u001b\u0010#\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013R\u001b\u0010%\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013R\u001b\u0010'\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b(\u0010\u0013R\u001b\u0010)\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0011\u001a\u0004\b*\u0010\u0013R$\u0010,\u001a\u0004\u0018\u00010+8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/discord/analytics/generated/events/activity_internal/TrackActivityInternalClientStatus;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "activityWidth", "Ljava/lang/Long;", "getActivityWidth", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "fpsAvg", "Ljava/lang/Float;", "getFpsAvg", "()Ljava/lang/Float;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "intervalRateMs", "getIntervalRateMs", "activityHeight", "getActivityHeight", "networkLatencyMs", "getNetworkLatencyMs", "networkAttempts", "getNetworkAttempts", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "trackActivityInternalMetadata", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "getTrackActivityInternalMetadata", "()Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "setTrackActivityInternalMetadata", "(Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalClientStatus implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final Long activityWidth = null;
    private final Long activityHeight = null;
    private final Long networkLatencyMs = null;
    private final Long networkAttempts = null;
    private final Long intervalRateMs = null;
    private final Float fpsAvg = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_client_status";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalClientStatus)) {
            return false;
        }
        TrackActivityInternalClientStatus trackActivityInternalClientStatus = (TrackActivityInternalClientStatus) other;
        return Intrinsics3.areEqual(this.activityWidth, trackActivityInternalClientStatus.activityWidth) && Intrinsics3.areEqual(this.activityHeight, trackActivityInternalClientStatus.activityHeight) && Intrinsics3.areEqual(this.networkLatencyMs, trackActivityInternalClientStatus.networkLatencyMs) && Intrinsics3.areEqual(this.networkAttempts, trackActivityInternalClientStatus.networkAttempts) && Intrinsics3.areEqual(this.intervalRateMs, trackActivityInternalClientStatus.intervalRateMs) && Intrinsics3.areEqual(this.fpsAvg, trackActivityInternalClientStatus.fpsAvg);
    }

    public int hashCode() {
        Long l = this.activityWidth;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.activityHeight;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.networkLatencyMs;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.networkAttempts;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.intervalRateMs;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Float f = this.fpsAvg;
        return iHashCode5 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalClientStatus(activityWidth=");
        sbU.append(this.activityWidth);
        sbU.append(", activityHeight=");
        sbU.append(this.activityHeight);
        sbU.append(", networkLatencyMs=");
        sbU.append(this.networkLatencyMs);
        sbU.append(", networkAttempts=");
        sbU.append(this.networkAttempts);
        sbU.append(", intervalRateMs=");
        sbU.append(this.intervalRateMs);
        sbU.append(", fpsAvg=");
        sbU.append(this.fpsAvg);
        sbU.append(")");
        return sbU.toString();
    }
}
