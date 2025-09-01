package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackStoreListingUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001b\u0010&\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0010\u001a\u0004\b'\u0010\u0012R\u001b\u0010(\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0010\u001a\u0004\b)\u0010\u0012R!\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001b\u0010/\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010\u0012R\u001c\u00101\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u0005R\u001b\u00104\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u0015\u001a\u0004\b5\u0010\u0017R\u001b\u00106\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u0015\u001a\u0004\b7\u0010\u0017R!\u00108\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010*8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010,\u001a\u0004\b9\u0010.¨\u0006:"}, d2 = {"Lcom/discord/analytics/generated/events/TrackStoreListingUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "thumbnailAssetId", "Ljava/lang/Long;", "getThumbnailAssetId", "()Ljava/lang/Long;", "", "updateFrom", "Ljava/lang/CharSequence;", "getUpdateFrom", "()Ljava/lang/CharSequence;", "updateType", "getUpdateType", "isPublished", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "skuId", "getSkuId", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "storeListingId", "getStoreListingId", "guildId", "getGuildId", "", "childSkuIds", "Ljava/util/List;", "getChildSkuIds", "()Ljava/util/List;", "previewVideoAssetId", "getPreviewVideoAssetId", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "flavorText", "getFlavorText", "tagline", "getTagline", "carouselItems", "getCarouselItems", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackStoreListingUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long storeListingId = null;
    private final Long skuId = null;
    private final CharSequence updateFrom = null;
    private final CharSequence updateType = null;
    private final Long guildId = null;
    private final List<Long> childSkuIds = null;
    private final Boolean isPublished = null;
    private final CharSequence tagline = null;
    private final CharSequence flavorText = null;
    private final Long thumbnailAssetId = null;
    private final Long previewVideoAssetId = null;
    private final List<CharSequence> carouselItems = null;
    private final transient String analyticsSchemaTypeName = "store_listing_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStoreListingUpdated)) {
            return false;
        }
        TrackStoreListingUpdated trackStoreListingUpdated = (TrackStoreListingUpdated) other;
        return Intrinsics3.areEqual(this.storeListingId, trackStoreListingUpdated.storeListingId) && Intrinsics3.areEqual(this.skuId, trackStoreListingUpdated.skuId) && Intrinsics3.areEqual(this.updateFrom, trackStoreListingUpdated.updateFrom) && Intrinsics3.areEqual(this.updateType, trackStoreListingUpdated.updateType) && Intrinsics3.areEqual(this.guildId, trackStoreListingUpdated.guildId) && Intrinsics3.areEqual(this.childSkuIds, trackStoreListingUpdated.childSkuIds) && Intrinsics3.areEqual(this.isPublished, trackStoreListingUpdated.isPublished) && Intrinsics3.areEqual(this.tagline, trackStoreListingUpdated.tagline) && Intrinsics3.areEqual(this.flavorText, trackStoreListingUpdated.flavorText) && Intrinsics3.areEqual(this.thumbnailAssetId, trackStoreListingUpdated.thumbnailAssetId) && Intrinsics3.areEqual(this.previewVideoAssetId, trackStoreListingUpdated.previewVideoAssetId) && Intrinsics3.areEqual(this.carouselItems, trackStoreListingUpdated.carouselItems);
    }

    public int hashCode() {
        Long l = this.storeListingId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.skuId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.updateFrom;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.updateType;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.childSkuIds;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.isPublished;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.tagline;
        int iHashCode8 = (iHashCode7 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.flavorText;
        int iHashCode9 = (iHashCode8 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l4 = this.thumbnailAssetId;
        int iHashCode10 = (iHashCode9 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.previewVideoAssetId;
        int iHashCode11 = (iHashCode10 + (l5 != null ? l5.hashCode() : 0)) * 31;
        List<CharSequence> list2 = this.carouselItems;
        return iHashCode11 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStoreListingUpdated(storeListingId=");
        sbU.append(this.storeListingId);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", updateFrom=");
        sbU.append(this.updateFrom);
        sbU.append(", updateType=");
        sbU.append(this.updateType);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", childSkuIds=");
        sbU.append(this.childSkuIds);
        sbU.append(", isPublished=");
        sbU.append(this.isPublished);
        sbU.append(", tagline=");
        sbU.append(this.tagline);
        sbU.append(", flavorText=");
        sbU.append(this.flavorText);
        sbU.append(", thumbnailAssetId=");
        sbU.append(this.thumbnailAssetId);
        sbU.append(", previewVideoAssetId=");
        sbU.append(this.previewVideoAssetId);
        sbU.append(", carouselItems=");
        return outline.L(sbU, this.carouselItems, ")");
    }
}
