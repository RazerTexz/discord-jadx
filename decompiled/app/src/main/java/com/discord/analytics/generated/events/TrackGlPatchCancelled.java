package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackDispatchBase;
import com.discord.analytics.generated.traits.TrackDispatchBase2;
import com.discord.analytics.generated.traits.TrackDispatchPatch;
import com.discord.analytics.generated.traits.TrackDispatchPatch2;
import com.discord.analytics.generated.traits.TrackDispatchStats;
import com.discord.analytics.generated.traits.TrackDispatchStats2;
import com.discord.api.science.AnalyticsSchema;
import kotlin.Metadata;

/* compiled from: TrackGlPatchCancelled.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u00020\u00148\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/discord/analytics/generated/events/TrackGlPatchCancelled;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackDispatchBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackDispatchPatchReceiver;", "Lcom/discord/analytics/generated/traits/TrackDispatchStatsReceiver;", "Lcom/discord/analytics/generated/traits/TrackDispatchBase;", "trackDispatchBase", "Lcom/discord/analytics/generated/traits/TrackDispatchBase;", "getTrackDispatchBase", "()Lcom/discord/analytics/generated/traits/TrackDispatchBase;", "setTrackDispatchBase", "(Lcom/discord/analytics/generated/traits/TrackDispatchBase;)V", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "Lcom/discord/analytics/generated/traits/TrackDispatchStats;", "trackDispatchStats", "Lcom/discord/analytics/generated/traits/TrackDispatchStats;", "getTrackDispatchStats", "()Lcom/discord/analytics/generated/traits/TrackDispatchStats;", "setTrackDispatchStats", "(Lcom/discord/analytics/generated/traits/TrackDispatchStats;)V", "Lcom/discord/analytics/generated/traits/TrackDispatchPatch;", "trackDispatchPatch", "Lcom/discord/analytics/generated/traits/TrackDispatchPatch;", "getTrackDispatchPatch", "()Lcom/discord/analytics/generated/traits/TrackDispatchPatch;", "setTrackDispatchPatch", "(Lcom/discord/analytics/generated/traits/TrackDispatchPatch;)V", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class TrackGlPatchCancelled implements AnalyticsSchema, TrackBase2, TrackDispatchBase2, TrackDispatchPatch2, TrackDispatchStats2 {
    private final transient String analyticsSchemaTypeName = "gl_patch_cancelled";
    private TrackBase trackBase;
    private TrackDispatchBase trackDispatchBase;
    private TrackDispatchPatch trackDispatchPatch;
    private TrackDispatchStats trackDispatchStats;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
