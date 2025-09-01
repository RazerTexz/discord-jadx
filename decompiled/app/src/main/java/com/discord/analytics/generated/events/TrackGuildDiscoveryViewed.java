package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackGuildDiscoveryViewed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010'\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b(\u0010\u0013R\u001b\u0010)\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0011\u001a\u0004\b*\u0010\u0013R\u001b\u0010+\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0011\u001a\u0004\b,\u0010\u0013R!\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001c\u00102\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0006R\u001b\u00105\u001a\u0004\u0018\u00010\"8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010$\u001a\u0004\b6\u0010&¨\u00067"}, d2 = {"Lcom/discord/analytics/generated/events/TrackGuildDiscoveryViewed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "numGuilds", "Ljava/lang/Long;", "getNumGuilds", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "", "loadId", "Ljava/lang/CharSequence;", "getLoadId", "()Ljava/lang/CharSequence;", "numGuildsRecommended", "getNumGuildsRecommended", "categoryId", "getCategoryId", "numGuildsPopular", "getNumGuildsPopular", "", "recommendedGuildIds", "Ljava/util/List;", "getRecommendedGuildIds", "()Ljava/util/List;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "recommendationsSource", "getRecommendationsSource", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackGuildDiscoveryViewed implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence loadId = null;
    private final Long numGuilds = null;
    private final Long numGuildsRecommended = null;
    private final Long numGuildsPopular = null;
    private final List<Long> recommendedGuildIds = null;
    private final Long categoryId = null;
    private final CharSequence recommendationsSource = null;
    private final transient String analyticsSchemaTypeName = "guild_discovery_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildDiscoveryViewed)) {
            return false;
        }
        TrackGuildDiscoveryViewed trackGuildDiscoveryViewed = (TrackGuildDiscoveryViewed) other;
        return Intrinsics3.areEqual(this.loadId, trackGuildDiscoveryViewed.loadId) && Intrinsics3.areEqual(this.numGuilds, trackGuildDiscoveryViewed.numGuilds) && Intrinsics3.areEqual(this.numGuildsRecommended, trackGuildDiscoveryViewed.numGuildsRecommended) && Intrinsics3.areEqual(this.numGuildsPopular, trackGuildDiscoveryViewed.numGuildsPopular) && Intrinsics3.areEqual(this.recommendedGuildIds, trackGuildDiscoveryViewed.recommendedGuildIds) && Intrinsics3.areEqual(this.categoryId, trackGuildDiscoveryViewed.categoryId) && Intrinsics3.areEqual(this.recommendationsSource, trackGuildDiscoveryViewed.recommendationsSource);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.numGuilds;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numGuildsRecommended;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numGuildsPopular;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.recommendedGuildIds;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        Long l4 = this.categoryId;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.recommendationsSource;
        return iHashCode6 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildDiscoveryViewed(loadId=");
        sbU.append(this.loadId);
        sbU.append(", numGuilds=");
        sbU.append(this.numGuilds);
        sbU.append(", numGuildsRecommended=");
        sbU.append(this.numGuildsRecommended);
        sbU.append(", numGuildsPopular=");
        sbU.append(this.numGuildsPopular);
        sbU.append(", recommendedGuildIds=");
        sbU.append(this.recommendedGuildIds);
        sbU.append(", categoryId=");
        sbU.append(this.categoryId);
        sbU.append(", recommendationsSource=");
        return outline.E(sbU, this.recommendationsSource, ")");
    }
}
