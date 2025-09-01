package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackDispatchBase;
import com.discord.analytics.generated.traits.TrackDispatchBase2;
import com.discord.analytics.generated.traits.TrackDispatchPatch;
import com.discord.analytics.generated.traits.TrackDispatchPatch2;
import com.discord.analytics.generated.traits.TrackDispatchStats;
import com.discord.analytics.generated.traits.TrackDispatchStats2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackGlPatchFailed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\u00068\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010/\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/discord/analytics/generated/events/TrackGlPatchFailed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackDispatchBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackDispatchPatchReceiver;", "Lcom/discord/analytics/generated/traits/TrackDispatchStatsReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackDispatchBase;", "trackDispatchBase", "Lcom/discord/analytics/generated/traits/TrackDispatchBase;", "getTrackDispatchBase", "()Lcom/discord/analytics/generated/traits/TrackDispatchBase;", "setTrackDispatchBase", "(Lcom/discord/analytics/generated/traits/TrackDispatchBase;)V", "", "errorCode", "Ljava/lang/Long;", "getErrorCode", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackDispatchPatch;", "trackDispatchPatch", "Lcom/discord/analytics/generated/traits/TrackDispatchPatch;", "getTrackDispatchPatch", "()Lcom/discord/analytics/generated/traits/TrackDispatchPatch;", "setTrackDispatchPatch", "(Lcom/discord/analytics/generated/traits/TrackDispatchPatch;)V", "Lcom/discord/analytics/generated/traits/TrackDispatchStats;", "trackDispatchStats", "Lcom/discord/analytics/generated/traits/TrackDispatchStats;", "getTrackDispatchStats", "()Lcom/discord/analytics/generated/traits/TrackDispatchStats;", "setTrackDispatchStats", "(Lcom/discord/analytics/generated/traits/TrackDispatchStats;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackGlPatchFailed implements AnalyticsSchema, TrackBase2, TrackDispatchBase2, TrackDispatchPatch2, TrackDispatchStats2 {
    private TrackBase trackBase;
    private TrackDispatchBase trackDispatchBase;
    private TrackDispatchPatch trackDispatchPatch;
    private TrackDispatchStats trackDispatchStats;
    private final Long errorCode = null;
    private final transient String analyticsSchemaTypeName = "gl_patch_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackGlPatchFailed) && Intrinsics3.areEqual(this.errorCode, ((TrackGlPatchFailed) other).errorCode);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.errorCode;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackGlPatchFailed(errorCode="), this.errorCode, ")");
    }
}
