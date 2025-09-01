package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackLocationStackMetadata;
import com.discord.analytics.generated.traits.TrackLocationStackMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackPremiumFeatureUsageV2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001d\u001a\u00020\u00068\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\bR$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010+\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010\u001aR\u001b\u0010-\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0018\u001a\u0004\b.\u0010\u001aR$\u00100\u001a\u0004\u0018\u00010/8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001b\u00106\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u0018\u001a\u0004\b7\u0010\u001aR$\u00109\u001a\u0004\u0018\u0001088\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u0004\u0018\u00010?8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006F"}, d2 = {"Lcom/discord/analytics/generated/events/TrackPremiumFeatureUsageV2;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackSourceMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationStackMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "guildId", "Ljava/lang/Long;", "getGuildId", "()Ljava/lang/Long;", "", "rtcConnectionId", "Ljava/lang/CharSequence;", "getRtcConnectionId", "()Ljava/lang/CharSequence;", "mediaSessionId", "getMediaSessionId", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "inOverlay", "Ljava/lang/Boolean;", "getInOverlay", "()Ljava/lang/Boolean;", "applicationName", "getApplicationName", "featureTier", "getFeatureTier", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "featureName", "getFeatureName", "Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "trackSourceMetadata", "Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "getTrackSourceMetadata", "()Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "setTrackSourceMetadata", "(Lcom/discord/analytics/generated/traits/TrackSourceMetadata;)V", "Lcom/discord/analytics/generated/traits/TrackLocationStackMetadata;", "trackLocationStackMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationStackMetadata;", "getTrackLocationStackMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationStackMetadata;", "setTrackLocationStackMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationStackMetadata;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackPremiumFeatureUsageV2 implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackSourceMetadata2, TrackLocationStackMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackLocationStackMetadata trackLocationStackMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private final CharSequence featureName = null;
    private final CharSequence featureTier = null;
    private final Long guildId = null;
    private final CharSequence rtcConnectionId = null;
    private final CharSequence mediaSessionId = null;
    private final Boolean inOverlay = null;
    private final CharSequence applicationName = null;
    private final transient String analyticsSchemaTypeName = "premium_feature_usage_v2";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumFeatureUsageV2)) {
            return false;
        }
        TrackPremiumFeatureUsageV2 trackPremiumFeatureUsageV2 = (TrackPremiumFeatureUsageV2) other;
        return Intrinsics3.areEqual(this.featureName, trackPremiumFeatureUsageV2.featureName) && Intrinsics3.areEqual(this.featureTier, trackPremiumFeatureUsageV2.featureTier) && Intrinsics3.areEqual(this.guildId, trackPremiumFeatureUsageV2.guildId) && Intrinsics3.areEqual(this.rtcConnectionId, trackPremiumFeatureUsageV2.rtcConnectionId) && Intrinsics3.areEqual(this.mediaSessionId, trackPremiumFeatureUsageV2.mediaSessionId) && Intrinsics3.areEqual(this.inOverlay, trackPremiumFeatureUsageV2.inOverlay) && Intrinsics3.areEqual(this.applicationName, trackPremiumFeatureUsageV2.applicationName);
    }

    public int hashCode() {
        CharSequence charSequence = this.featureName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.featureTier;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.guildId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.rtcConnectionId;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.mediaSessionId;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool = this.inOverlay;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.applicationName;
        return iHashCode6 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPremiumFeatureUsageV2(featureName=");
        sbU.append(this.featureName);
        sbU.append(", featureTier=");
        sbU.append(this.featureTier);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", inOverlay=");
        sbU.append(this.inOverlay);
        sbU.append(", applicationName=");
        return outline.E(sbU, this.applicationName, ")");
    }
}
