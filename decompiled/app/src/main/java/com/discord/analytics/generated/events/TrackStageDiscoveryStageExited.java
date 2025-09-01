package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackStageDiscoveryStageExited.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018R\u001b\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013R$\u0010#\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010*\u001a\u0004\u0018\u00010)8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001b\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u00105\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u0006R!\u00109\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`88\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0011\u001a\u0004\b:\u0010\u0013R\u001b\u0010;\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u0011\u001a\u0004\b<\u0010\u0013¨\u0006="}, d2 = {"Lcom/discord/analytics/generated/events/TrackStageDiscoveryStageExited;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "stageInstanceId", "Ljava/lang/Long;", "getStageInstanceId", "()Ljava/lang/Long;", "", "stageInstanceRecommendations", "Ljava/lang/CharSequence;", "getStageInstanceRecommendations", "()Ljava/lang/CharSequence;", "", "recommendationSource", "Ljava/util/List;", "getRecommendationSource", "()Ljava/util/List;", "loadId", "getLoadId", "lastVisibleIndexAtLoad", "getLastVisibleIndexAtLoad", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "", "recommendationScore", "Ljava/lang/Float;", "getRecommendationScore", "()Ljava/lang/Float;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/primitives/Timestamp;", "joinTimestamp", "getJoinTimestamp", "index", "getIndex", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackStageDiscoveryStageExited implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence loadId = null;
    private final CharSequence stageInstanceRecommendations = null;
    private final Long lastVisibleIndexAtLoad = null;
    private final Long index = null;
    private final Long stageInstanceId = null;
    private final List<Long> recommendationSource = null;
    private final Float recommendationScore = null;
    private final Long joinTimestamp = null;
    private final transient String analyticsSchemaTypeName = "stage_discovery_stage_exited";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStageDiscoveryStageExited)) {
            return false;
        }
        TrackStageDiscoveryStageExited trackStageDiscoveryStageExited = (TrackStageDiscoveryStageExited) other;
        return Intrinsics3.areEqual(this.loadId, trackStageDiscoveryStageExited.loadId) && Intrinsics3.areEqual(this.stageInstanceRecommendations, trackStageDiscoveryStageExited.stageInstanceRecommendations) && Intrinsics3.areEqual(this.lastVisibleIndexAtLoad, trackStageDiscoveryStageExited.lastVisibleIndexAtLoad) && Intrinsics3.areEqual(this.index, trackStageDiscoveryStageExited.index) && Intrinsics3.areEqual(this.stageInstanceId, trackStageDiscoveryStageExited.stageInstanceId) && Intrinsics3.areEqual(this.recommendationSource, trackStageDiscoveryStageExited.recommendationSource) && Intrinsics3.areEqual(this.recommendationScore, trackStageDiscoveryStageExited.recommendationScore) && Intrinsics3.areEqual(this.joinTimestamp, trackStageDiscoveryStageExited.joinTimestamp);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.stageInstanceRecommendations;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.lastVisibleIndexAtLoad;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.index;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.stageInstanceId;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.recommendationSource;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        Float f = this.recommendationScore;
        int iHashCode7 = (iHashCode6 + (f != null ? f.hashCode() : 0)) * 31;
        Long l4 = this.joinTimestamp;
        return iHashCode7 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStageDiscoveryStageExited(loadId=");
        sbU.append(this.loadId);
        sbU.append(", stageInstanceRecommendations=");
        sbU.append(this.stageInstanceRecommendations);
        sbU.append(", lastVisibleIndexAtLoad=");
        sbU.append(this.lastVisibleIndexAtLoad);
        sbU.append(", index=");
        sbU.append(this.index);
        sbU.append(", stageInstanceId=");
        sbU.append(this.stageInstanceId);
        sbU.append(", recommendationSource=");
        sbU.append(this.recommendationSource);
        sbU.append(", recommendationScore=");
        sbU.append(this.recommendationScore);
        sbU.append(", joinTimestamp=");
        return outline.G(sbU, this.joinTimestamp, ")");
    }
}
