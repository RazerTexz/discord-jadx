package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadata2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackStoreDirectoryCardInteracted.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\u00068\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010%8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u00101\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u001c\u001a\u0004\b2\u0010\u001dR\u001b\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00100R\u001b\u00105\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u001c\u001a\u0004\b6\u0010\u001dR\u001b\u00107\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u001c\u001a\u0004\b8\u0010\u001dR$\u0010:\u001a\u0004\u0018\u0001098\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001b\u0010@\u001a\u0004\u0018\u00010,8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010.\u001a\u0004\bA\u00100R\u001b\u0010B\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010\u001c\u001a\u0004\bC\u0010\u001dR\u001b\u0010D\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010\u001c\u001a\u0004\bE\u0010\u001dR$\u0010G\u001a\u0004\u0018\u00010F8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006M"}, d2 = {"Lcom/discord/analytics/generated/events/TrackStoreDirectoryCardInteracted;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackPaymentMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "isHero", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "", "listIndex", "Ljava/lang/Long;", "getListIndex", "()Ljava/lang/Long;", "nitroLearnMore", "getNitroLearnMore", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "", "listSort", "Ljava/lang/CharSequence;", "getListSort", "()Ljava/lang/CharSequence;", "blogPostOpened", "getBlogPostOpened", "loadId", "getLoadId", "watchTrailer", "getWatchTrailer", "audioEnabled", "getAudioEnabled", "Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;", "trackPaymentMetadata", "Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;", "getTrackPaymentMetadata", "()Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;", "setTrackPaymentMetadata", "(Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;)V", "listFilterDistributionType", "getListFilterDistributionType", "premiumLearnMore", "getPremiumLearnMore", "listSearched", "getListSearched", "Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;", "trackStoreSkuMetadata", "Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;", "getTrackStoreSkuMetadata", "()Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;", "setTrackStoreSkuMetadata", "(Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackStoreDirectoryCardInteracted implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackStoreSkuMetadata2, TrackPaymentMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final CharSequence loadId = null;
    private final Boolean audioEnabled = null;
    private final Boolean blogPostOpened = null;
    private final Boolean isHero = null;
    private final Boolean watchTrailer = null;
    private final Boolean nitroLearnMore = null;
    private final Boolean premiumLearnMore = null;
    private final Long listIndex = null;
    private final Boolean listSearched = null;
    private final CharSequence listSort = null;
    private final CharSequence listFilterDistributionType = null;
    private final transient String analyticsSchemaTypeName = "store_directory_card_interacted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStoreDirectoryCardInteracted)) {
            return false;
        }
        TrackStoreDirectoryCardInteracted trackStoreDirectoryCardInteracted = (TrackStoreDirectoryCardInteracted) other;
        return Intrinsics3.areEqual(this.loadId, trackStoreDirectoryCardInteracted.loadId) && Intrinsics3.areEqual(this.audioEnabled, trackStoreDirectoryCardInteracted.audioEnabled) && Intrinsics3.areEqual(this.blogPostOpened, trackStoreDirectoryCardInteracted.blogPostOpened) && Intrinsics3.areEqual(this.isHero, trackStoreDirectoryCardInteracted.isHero) && Intrinsics3.areEqual(this.watchTrailer, trackStoreDirectoryCardInteracted.watchTrailer) && Intrinsics3.areEqual(this.nitroLearnMore, trackStoreDirectoryCardInteracted.nitroLearnMore) && Intrinsics3.areEqual(this.premiumLearnMore, trackStoreDirectoryCardInteracted.premiumLearnMore) && Intrinsics3.areEqual(this.listIndex, trackStoreDirectoryCardInteracted.listIndex) && Intrinsics3.areEqual(this.listSearched, trackStoreDirectoryCardInteracted.listSearched) && Intrinsics3.areEqual(this.listSort, trackStoreDirectoryCardInteracted.listSort) && Intrinsics3.areEqual(this.listFilterDistributionType, trackStoreDirectoryCardInteracted.listFilterDistributionType);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.audioEnabled;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.blogPostOpened;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isHero;
        int iHashCode4 = (iHashCode3 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.watchTrailer;
        int iHashCode5 = (iHashCode4 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.nitroLearnMore;
        int iHashCode6 = (iHashCode5 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.premiumLearnMore;
        int iHashCode7 = (iHashCode6 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Long l = this.listIndex;
        int iHashCode8 = (iHashCode7 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool7 = this.listSearched;
        int iHashCode9 = (iHashCode8 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.listSort;
        int iHashCode10 = (iHashCode9 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.listFilterDistributionType;
        return iHashCode10 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStoreDirectoryCardInteracted(loadId=");
        sbU.append(this.loadId);
        sbU.append(", audioEnabled=");
        sbU.append(this.audioEnabled);
        sbU.append(", blogPostOpened=");
        sbU.append(this.blogPostOpened);
        sbU.append(", isHero=");
        sbU.append(this.isHero);
        sbU.append(", watchTrailer=");
        sbU.append(this.watchTrailer);
        sbU.append(", nitroLearnMore=");
        sbU.append(this.nitroLearnMore);
        sbU.append(", premiumLearnMore=");
        sbU.append(this.premiumLearnMore);
        sbU.append(", listIndex=");
        sbU.append(this.listIndex);
        sbU.append(", listSearched=");
        sbU.append(this.listSearched);
        sbU.append(", listSort=");
        sbU.append(this.listSort);
        sbU.append(", listFilterDistributionType=");
        return outline.E(sbU, this.listFilterDistributionType, ")");
    }
}
