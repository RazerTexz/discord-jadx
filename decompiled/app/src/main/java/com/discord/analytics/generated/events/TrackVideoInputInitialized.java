package com.discord.analytics.generated.events;

import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackVideoInputInitialized.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0005¨\u0006+"}, d2 = {"Lcom/discord/analytics/generated/events/TrackVideoInputInitialized;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Ljava/lang/Float;", "getActivity", "()Ljava/lang/Float;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "deviceName", "Ljava/lang/CharSequence;", "getDeviceName", "()Ljava/lang/CharSequence;", "timedOut", "Ljava/lang/Boolean;", "getTimedOut", "()Ljava/lang/Boolean;", "", "timeToFirstFrameMs", "Ljava/lang/Long;", "getTimeToFirstFrameMs", "()Ljava/lang/Long;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackVideoInputInitialized implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence deviceName = null;
    private final Long timeToFirstFrameMs = null;
    private final Boolean timedOut = null;
    private final Float activity = null;
    private final transient String analyticsSchemaTypeName = "video_input_initialized";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoInputInitialized)) {
            return false;
        }
        TrackVideoInputInitialized trackVideoInputInitialized = (TrackVideoInputInitialized) other;
        return Intrinsics3.areEqual(this.deviceName, trackVideoInputInitialized.deviceName) && Intrinsics3.areEqual(this.timeToFirstFrameMs, trackVideoInputInitialized.timeToFirstFrameMs) && Intrinsics3.areEqual(this.timedOut, trackVideoInputInitialized.timedOut) && Intrinsics3.areEqual(this.activity, trackVideoInputInitialized.activity);
    }

    public int hashCode() {
        CharSequence charSequence = this.deviceName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.timeToFirstFrameMs;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.timedOut;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Float f = this.activity;
        return iHashCode3 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVideoInputInitialized(deviceName=");
        sbU.append(this.deviceName);
        sbU.append(", timeToFirstFrameMs=");
        sbU.append(this.timeToFirstFrameMs);
        sbU.append(", timedOut=");
        sbU.append(this.timedOut);
        sbU.append(", activity=");
        sbU.append(this.activity);
        sbU.append(")");
        return sbU.toString();
    }
}
