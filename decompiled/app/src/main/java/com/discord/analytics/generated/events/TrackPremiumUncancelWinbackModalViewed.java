package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackPremiumUncancelWinbackModalViewed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0007R\u001b\u0010#\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001fR\u001b\u0010%\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010'8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010/\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u00105\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u001d\u001a\u0004\b6\u0010\u001fR\u001b\u00107\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0011\u001a\u0004\b8\u0010\u0013R\u001b\u00109\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u001d\u001a\u0004\b:\u0010\u001fR\u001b\u0010;\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u0011\u001a\u0004\b<\u0010\u0013R\u001b\u0010=\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u001d\u001a\u0004\b>\u0010\u001f¨\u0006?"}, d2 = {"Lcom/discord/analytics/generated/events/TrackPremiumUncancelWinbackModalViewed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "globalEmojiPersonalized", "Ljava/lang/Boolean;", "getGlobalEmojiPersonalized", "()Ljava/lang/Boolean;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "globalEmojiStats", "Ljava/lang/Long;", "getGlobalEmojiStats", "()Ljava/lang/Long;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "hdStreamingStats", "getHdStreamingStats", "largeFileUploadPosition", "getLargeFileUploadPosition", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;", "trackSubscriptionMetadata", "Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;", "getTrackSubscriptionMetadata", "()Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;", "setTrackSubscriptionMetadata", "(Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;)V", "largeFileUploadStats", "getLargeFileUploadStats", "hdStreamingPersonalized", "getHdStreamingPersonalized", "globalEmojiPosition", "getGlobalEmojiPosition", "largeFileUploadPersonalized", "getLargeFileUploadPersonalized", "hdStreamingPosition", "getHdStreamingPosition", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackPremiumUncancelWinbackModalViewed implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackSubscriptionMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final Long globalEmojiPosition = null;
    private final Long globalEmojiStats = null;
    private final Boolean globalEmojiPersonalized = null;
    private final Long hdStreamingPosition = null;
    private final Long hdStreamingStats = null;
    private final Boolean hdStreamingPersonalized = null;
    private final Long largeFileUploadPosition = null;
    private final Long largeFileUploadStats = null;
    private final Boolean largeFileUploadPersonalized = null;
    private final transient String analyticsSchemaTypeName = "premium_uncancel_winback_modal_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumUncancelWinbackModalViewed)) {
            return false;
        }
        TrackPremiumUncancelWinbackModalViewed trackPremiumUncancelWinbackModalViewed = (TrackPremiumUncancelWinbackModalViewed) other;
        return Intrinsics3.areEqual(this.globalEmojiPosition, trackPremiumUncancelWinbackModalViewed.globalEmojiPosition) && Intrinsics3.areEqual(this.globalEmojiStats, trackPremiumUncancelWinbackModalViewed.globalEmojiStats) && Intrinsics3.areEqual(this.globalEmojiPersonalized, trackPremiumUncancelWinbackModalViewed.globalEmojiPersonalized) && Intrinsics3.areEqual(this.hdStreamingPosition, trackPremiumUncancelWinbackModalViewed.hdStreamingPosition) && Intrinsics3.areEqual(this.hdStreamingStats, trackPremiumUncancelWinbackModalViewed.hdStreamingStats) && Intrinsics3.areEqual(this.hdStreamingPersonalized, trackPremiumUncancelWinbackModalViewed.hdStreamingPersonalized) && Intrinsics3.areEqual(this.largeFileUploadPosition, trackPremiumUncancelWinbackModalViewed.largeFileUploadPosition) && Intrinsics3.areEqual(this.largeFileUploadStats, trackPremiumUncancelWinbackModalViewed.largeFileUploadStats) && Intrinsics3.areEqual(this.largeFileUploadPersonalized, trackPremiumUncancelWinbackModalViewed.largeFileUploadPersonalized);
    }

    public int hashCode() {
        Long l = this.globalEmojiPosition;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.globalEmojiStats;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.globalEmojiPersonalized;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l3 = this.hdStreamingPosition;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.hdStreamingStats;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool2 = this.hdStreamingPersonalized;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l5 = this.largeFileUploadPosition;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.largeFileUploadStats;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Boolean bool3 = this.largeFileUploadPersonalized;
        return iHashCode8 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPremiumUncancelWinbackModalViewed(globalEmojiPosition=");
        sbU.append(this.globalEmojiPosition);
        sbU.append(", globalEmojiStats=");
        sbU.append(this.globalEmojiStats);
        sbU.append(", globalEmojiPersonalized=");
        sbU.append(this.globalEmojiPersonalized);
        sbU.append(", hdStreamingPosition=");
        sbU.append(this.hdStreamingPosition);
        sbU.append(", hdStreamingStats=");
        sbU.append(this.hdStreamingStats);
        sbU.append(", hdStreamingPersonalized=");
        sbU.append(this.hdStreamingPersonalized);
        sbU.append(", largeFileUploadPosition=");
        sbU.append(this.largeFileUploadPosition);
        sbU.append(", largeFileUploadStats=");
        sbU.append(this.largeFileUploadStats);
        sbU.append(", largeFileUploadPersonalized=");
        return outline.D(sbU, this.largeFileUploadPersonalized, ")");
    }
}
