package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackActivityInternalLaunchStepCompleted.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0006R\u001b\u0010%\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R$\u0010*\u001a\u0004\u0018\u00010)8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001b\u00100\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0011\u001a\u0004\b1\u0010\u0013R\u001b\u00102\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0018\u001a\u0004\b3\u0010\u001a¨\u00064"}, d2 = {"Lcom/discord/analytics/generated/events/activity_internal/TrackActivityInternalLaunchStepCompleted;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "errorMessage", "Ljava/lang/CharSequence;", "getErrorMessage", "()Ljava/lang/CharSequence;", "step", "getStep", "", "durationMs", "Ljava/lang/Long;", "getDurationMs", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "trackActivityInternalMetadata", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "getTrackActivityInternalMetadata", "()Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "setTrackActivityInternalMetadata", "(Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "success", "Ljava/lang/Boolean;", "getSuccess", "()Ljava/lang/Boolean;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "nextStep", "getNextStep", "errorCode", "getErrorCode", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalLaunchStepCompleted implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence step = null;
    private final CharSequence nextStep = null;
    private final Long durationMs = null;
    private final Boolean success = null;
    private final Long errorCode = null;
    private final CharSequence errorMessage = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_launch_step_completed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalLaunchStepCompleted)) {
            return false;
        }
        TrackActivityInternalLaunchStepCompleted trackActivityInternalLaunchStepCompleted = (TrackActivityInternalLaunchStepCompleted) other;
        return Intrinsics3.areEqual(this.step, trackActivityInternalLaunchStepCompleted.step) && Intrinsics3.areEqual(this.nextStep, trackActivityInternalLaunchStepCompleted.nextStep) && Intrinsics3.areEqual(this.durationMs, trackActivityInternalLaunchStepCompleted.durationMs) && Intrinsics3.areEqual(this.success, trackActivityInternalLaunchStepCompleted.success) && Intrinsics3.areEqual(this.errorCode, trackActivityInternalLaunchStepCompleted.errorCode) && Intrinsics3.areEqual(this.errorMessage, trackActivityInternalLaunchStepCompleted.errorMessage);
    }

    public int hashCode() {
        CharSequence charSequence = this.step;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.nextStep;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.durationMs;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.success;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.errorCode;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.errorMessage;
        return iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalLaunchStepCompleted(step=");
        sbU.append(this.step);
        sbU.append(", nextStep=");
        sbU.append(this.nextStep);
        sbU.append(", durationMs=");
        sbU.append(this.durationMs);
        sbU.append(", success=");
        sbU.append(this.success);
        sbU.append(", errorCode=");
        sbU.append(this.errorCode);
        sbU.append(", errorMessage=");
        return outline.E(sbU, this.errorMessage, ")");
    }
}
