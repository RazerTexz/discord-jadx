package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackStageDiscoveryLoaded.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR!\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0005R\u001b\u0010#\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R!\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b)\u0010\u0013R\u001b\u0010*\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0016\u001a\u0004\b+\u0010\u0018R!\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b-\u0010\u0013R!\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0011\u001a\u0004\b/\u0010\u0013¨\u00060"}, d2 = {"Lcom/discord/analytics/generated/events/TrackStageDiscoveryLoaded;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "", "indexes", "Ljava/util/List;", "getIndexes", "()Ljava/util/List;", "", "stageInstanceRecommendations", "Ljava/lang/CharSequence;", "getStageInstanceRecommendations", "()Ljava/lang/CharSequence;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "lastVisibleIndexAtLoad", "Ljava/lang/Long;", "getLastVisibleIndexAtLoad", "()Ljava/lang/Long;", "", "recommendationScores", "getRecommendationScores", "loadId", "getLoadId", "stageInstanceIds", "getStageInstanceIds", "recommendationSources", "getRecommendationSources", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackStageDiscoveryLoaded implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final CharSequence stageInstanceRecommendations = null;
    private final Long lastVisibleIndexAtLoad = null;
    private final List<Long> indexes = null;
    private final List<Long> stageInstanceIds = null;
    private final List<Long> recommendationSources = null;
    private final List<Float> recommendationScores = null;
    private final transient String analyticsSchemaTypeName = "stage_discovery_loaded";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStageDiscoveryLoaded)) {
            return false;
        }
        TrackStageDiscoveryLoaded trackStageDiscoveryLoaded = (TrackStageDiscoveryLoaded) other;
        return Intrinsics3.areEqual(this.loadId, trackStageDiscoveryLoaded.loadId) && Intrinsics3.areEqual(this.stageInstanceRecommendations, trackStageDiscoveryLoaded.stageInstanceRecommendations) && Intrinsics3.areEqual(this.lastVisibleIndexAtLoad, trackStageDiscoveryLoaded.lastVisibleIndexAtLoad) && Intrinsics3.areEqual(this.indexes, trackStageDiscoveryLoaded.indexes) && Intrinsics3.areEqual(this.stageInstanceIds, trackStageDiscoveryLoaded.stageInstanceIds) && Intrinsics3.areEqual(this.recommendationSources, trackStageDiscoveryLoaded.recommendationSources) && Intrinsics3.areEqual(this.recommendationScores, trackStageDiscoveryLoaded.recommendationScores);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.stageInstanceRecommendations;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.lastVisibleIndexAtLoad;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        List<Long> list = this.indexes;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.stageInstanceIds;
        int iHashCode5 = (iHashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Long> list3 = this.recommendationSources;
        int iHashCode6 = (iHashCode5 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<Float> list4 = this.recommendationScores;
        return iHashCode6 + (list4 != null ? list4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStageDiscoveryLoaded(loadId=");
        sbU.append(this.loadId);
        sbU.append(", stageInstanceRecommendations=");
        sbU.append(this.stageInstanceRecommendations);
        sbU.append(", lastVisibleIndexAtLoad=");
        sbU.append(this.lastVisibleIndexAtLoad);
        sbU.append(", indexes=");
        sbU.append(this.indexes);
        sbU.append(", stageInstanceIds=");
        sbU.append(this.stageInstanceIds);
        sbU.append(", recommendationSources=");
        sbU.append(this.recommendationSources);
        sbU.append(", recommendationScores=");
        return outline.L(sbU, this.recommendationScores, ")");
    }
}
