package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackOverlayPerfInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0013R$\u0010\"\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010(\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b)\u0010\u0013R\u001b\u0010*\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b+\u0010\u0013R\u001b\u0010,\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b-\u0010\u0013R\u001b\u0010.\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0011\u001a\u0004\b/\u0010\u0013R\u001b\u00100\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0011\u001a\u0004\b1\u0010\u0013R\u001b\u00102\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0011\u001a\u0004\b3\u0010\u0013R\u001b\u00104\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001c\u00108\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u0006R\u001b\u0010;\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u001a\u001a\u0004\b<\u0010\u001cR\u001b\u0010=\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u0011\u001a\u0004\b>\u0010\u0013R\u001b\u0010?\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010\u0011\u001a\u0004\b@\u0010\u0013R\u001b\u0010A\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010\u0011\u001a\u0004\bB\u0010\u0013R$\u0010D\u001a\u0004\u0018\u00010C8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001b\u0010J\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010\u0011\u001a\u0004\bK\u0010\u0013R\u001b\u0010L\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010\u0011\u001a\u0004\bM\u0010\u0013¨\u0006N"}, d2 = {"Lcom/discord/analytics/generated/events/TrackOverlayPerfInfo;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "frameTimeMinUs", "Ljava/lang/Long;", "getFrameTimeMinUs", "()Ljava/lang/Long;", "frameTimeMaxUs", "getFrameTimeMaxUs", "drawTimeMinUs", "getDrawTimeMinUs", "", "apiName", "Ljava/lang/CharSequence;", "getApiName", "()Ljava/lang/CharSequence;", "width", "getWidth", "captureTimeMinUs", "getCaptureTimeMinUs", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "trackOverlayClientMetadata", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "getTrackOverlayClientMetadata", "()Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "setTrackOverlayClientMetadata", "(Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;)V", "captureTimeAvgUs", "getCaptureTimeAvgUs", "framesReceived", "getFramesReceived", "drawTimeAvgUs", "getDrawTimeAvgUs", "height", "getHeight", "framesCaptured", "getFramesCaptured", "lockFailures", "getLockFailures", "fullscreen", "Ljava/lang/Boolean;", "getFullscreen", "()Ljava/lang/Boolean;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "frameBufferSource", "getFrameBufferSource", "drawTimeMaxUs", "getDrawTimeMaxUs", "frameCount", "getFrameCount", "frameTimeAvgUs", "getFrameTimeAvgUs", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "captureTimeMaxUs", "getCaptureTimeMaxUs", "durationUs", "getDurationUs", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackOverlayPerfInfo implements AnalyticsSchema, TrackBase2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Long width = null;
    private final Long height = null;
    private final CharSequence apiName = null;
    private final Boolean fullscreen = null;
    private final CharSequence frameBufferSource = null;
    private final Long durationUs = null;
    private final Long frameCount = null;
    private final Long framesReceived = null;
    private final Long framesCaptured = null;
    private final Long lockFailures = null;
    private final Long frameTimeMinUs = null;
    private final Long frameTimeMaxUs = null;
    private final Long frameTimeAvgUs = null;
    private final Long drawTimeMinUs = null;
    private final Long drawTimeMaxUs = null;
    private final Long drawTimeAvgUs = null;
    private final Long captureTimeMinUs = null;
    private final Long captureTimeMaxUs = null;
    private final Long captureTimeAvgUs = null;
    private final transient String analyticsSchemaTypeName = "overlay_perf_info";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayPerfInfo)) {
            return false;
        }
        TrackOverlayPerfInfo trackOverlayPerfInfo = (TrackOverlayPerfInfo) other;
        return Intrinsics3.areEqual(this.width, trackOverlayPerfInfo.width) && Intrinsics3.areEqual(this.height, trackOverlayPerfInfo.height) && Intrinsics3.areEqual(this.apiName, trackOverlayPerfInfo.apiName) && Intrinsics3.areEqual(this.fullscreen, trackOverlayPerfInfo.fullscreen) && Intrinsics3.areEqual(this.frameBufferSource, trackOverlayPerfInfo.frameBufferSource) && Intrinsics3.areEqual(this.durationUs, trackOverlayPerfInfo.durationUs) && Intrinsics3.areEqual(this.frameCount, trackOverlayPerfInfo.frameCount) && Intrinsics3.areEqual(this.framesReceived, trackOverlayPerfInfo.framesReceived) && Intrinsics3.areEqual(this.framesCaptured, trackOverlayPerfInfo.framesCaptured) && Intrinsics3.areEqual(this.lockFailures, trackOverlayPerfInfo.lockFailures) && Intrinsics3.areEqual(this.frameTimeMinUs, trackOverlayPerfInfo.frameTimeMinUs) && Intrinsics3.areEqual(this.frameTimeMaxUs, trackOverlayPerfInfo.frameTimeMaxUs) && Intrinsics3.areEqual(this.frameTimeAvgUs, trackOverlayPerfInfo.frameTimeAvgUs) && Intrinsics3.areEqual(this.drawTimeMinUs, trackOverlayPerfInfo.drawTimeMinUs) && Intrinsics3.areEqual(this.drawTimeMaxUs, trackOverlayPerfInfo.drawTimeMaxUs) && Intrinsics3.areEqual(this.drawTimeAvgUs, trackOverlayPerfInfo.drawTimeAvgUs) && Intrinsics3.areEqual(this.captureTimeMinUs, trackOverlayPerfInfo.captureTimeMinUs) && Intrinsics3.areEqual(this.captureTimeMaxUs, trackOverlayPerfInfo.captureTimeMaxUs) && Intrinsics3.areEqual(this.captureTimeAvgUs, trackOverlayPerfInfo.captureTimeAvgUs);
    }

    public int hashCode() {
        Long l = this.width;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.height;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.apiName;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.fullscreen;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.frameBufferSource;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.durationUs;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.frameCount;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.framesReceived;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.framesCaptured;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.lockFailures;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.frameTimeMinUs;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.frameTimeMaxUs;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.frameTimeAvgUs;
        int iHashCode13 = (iHashCode12 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.drawTimeMinUs;
        int iHashCode14 = (iHashCode13 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.drawTimeMaxUs;
        int iHashCode15 = (iHashCode14 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.drawTimeAvgUs;
        int iHashCode16 = (iHashCode15 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.captureTimeMinUs;
        int iHashCode17 = (iHashCode16 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.captureTimeMaxUs;
        int iHashCode18 = (iHashCode17 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.captureTimeAvgUs;
        return iHashCode18 + (l16 != null ? l16.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackOverlayPerfInfo(width=");
        sbU.append(this.width);
        sbU.append(", height=");
        sbU.append(this.height);
        sbU.append(", apiName=");
        sbU.append(this.apiName);
        sbU.append(", fullscreen=");
        sbU.append(this.fullscreen);
        sbU.append(", frameBufferSource=");
        sbU.append(this.frameBufferSource);
        sbU.append(", durationUs=");
        sbU.append(this.durationUs);
        sbU.append(", frameCount=");
        sbU.append(this.frameCount);
        sbU.append(", framesReceived=");
        sbU.append(this.framesReceived);
        sbU.append(", framesCaptured=");
        sbU.append(this.framesCaptured);
        sbU.append(", lockFailures=");
        sbU.append(this.lockFailures);
        sbU.append(", frameTimeMinUs=");
        sbU.append(this.frameTimeMinUs);
        sbU.append(", frameTimeMaxUs=");
        sbU.append(this.frameTimeMaxUs);
        sbU.append(", frameTimeAvgUs=");
        sbU.append(this.frameTimeAvgUs);
        sbU.append(", drawTimeMinUs=");
        sbU.append(this.drawTimeMinUs);
        sbU.append(", drawTimeMaxUs=");
        sbU.append(this.drawTimeMaxUs);
        sbU.append(", drawTimeAvgUs=");
        sbU.append(this.drawTimeAvgUs);
        sbU.append(", captureTimeMinUs=");
        sbU.append(this.captureTimeMinUs);
        sbU.append(", captureTimeMaxUs=");
        sbU.append(this.captureTimeMaxUs);
        sbU.append(", captureTimeAvgUs=");
        return outline.G(sbU, this.captureTimeAvgUs, ")");
    }
}
