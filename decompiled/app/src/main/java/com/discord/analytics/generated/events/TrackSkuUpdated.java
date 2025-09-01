package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackPriceByCurrency;
import com.discord.analytics.generated.traits.TrackPriceByCurrency2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackSkuUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR!\u0010\u001f\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0013R$\u0010\"\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010(\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b(\u0010*R!\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0017\u001a\u0004\b,\u0010\u0019R\u001c\u0010-\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0006R\u001b\u00100\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0011\u001a\u0004\b1\u0010\u0013R\u001b\u00102\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u001b\u001a\u0004\b3\u0010\u001dR$\u00105\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001b\u0010;\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u0011\u001a\u0004\b<\u0010\u0013R!\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u0017\u001a\u0004\b>\u0010\u0019R\u001b\u0010?\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010)\u001a\u0004\b?\u0010*R\u001b\u0010@\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010)\u001a\u0004\b@\u0010*R!\u0010A\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010\u0017\u001a\u0004\bB\u0010\u0019R\u001b\u0010C\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010\u001b\u001a\u0004\bD\u0010\u001dR\u001b\u0010E\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010\u001b\u001a\u0004\bF\u0010\u001dR\u001b\u0010G\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010\u0011\u001a\u0004\bH\u0010\u0013R\u001b\u0010I\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010)\u001a\u0004\bJ\u0010*R\u001b\u0010K\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010\u001b\u001a\u0004\bL\u0010\u001dR\u001b\u0010M\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010\u001b\u001a\u0004\bN\u0010\u001dR\u001b\u0010O\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010\u001b\u001a\u0004\bP\u0010\u001d¨\u0006Q"}, d2 = {"Lcom/discord/analytics/generated/events/TrackSkuUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackPriceByCurrencyReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "dependentSkuId", "Ljava/lang/Long;", "getDependentSkuId", "()Ljava/lang/Long;", "", "", "features", "Ljava/util/List;", "getFeatures", "()Ljava/util/List;", "storeTitle", "Ljava/lang/CharSequence;", "getStoreTitle", "()Ljava/lang/CharSequence;", "Lcom/discord/primitives/Timestamp;", "releaseDate", "getReleaseDate", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "isExclusive", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "availableLocales", "getAvailableLocales", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "regularPriceTier", "getRegularPriceTier", "contentRatingPegi", "getContentRatingPegi", "Lcom/discord/analytics/generated/traits/TrackPriceByCurrency;", "trackPriceByCurrency", "Lcom/discord/analytics/generated/traits/TrackPriceByCurrency;", "getTrackPriceByCurrency", "()Lcom/discord/analytics/generated/traits/TrackPriceByCurrency;", "setTrackPriceByCurrency", "(Lcom/discord/analytics/generated/traits/TrackPriceByCurrency;)V", "priceTier", "getPriceTier", "genres", "getGenres", "isDistribution", "isPremium", "bundledSkuIds", "getBundledSkuIds", "updateType", "getUpdateType", "metacriticId", "getMetacriticId", "skuId", "getSkuId", ModelAuditLogEntry.CHANGE_KEY_AVAILABLE, "getAvailable", "updateFrom", "getUpdateFrom", "contentRatingEsrb", "getContentRatingEsrb", "accessType", "getAccessType", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackSkuUpdated implements AnalyticsSchema, TrackBase2, TrackPriceByCurrency2 {
    private TrackBase trackBase;
    private TrackPriceByCurrency trackPriceByCurrency;
    private final Long skuId = null;
    private final CharSequence updateFrom = null;
    private final CharSequence updateType = null;
    private final CharSequence storeTitle = null;
    private final Long dependentSkuId = null;
    private final List<Long> bundledSkuIds = null;
    private final CharSequence accessType = null;
    private final Long releaseDate = null;
    private final Boolean isPremium = null;
    private final Boolean isDistribution = null;
    private final Boolean available = null;
    private final List<CharSequence> availableLocales = null;
    private final CharSequence metacriticId = null;
    private final Boolean isExclusive = null;
    private final List<CharSequence> genres = null;
    private final List<CharSequence> features = null;
    private final CharSequence contentRatingPegi = null;
    private final CharSequence contentRatingEsrb = null;
    private final Long regularPriceTier = null;
    private final Long priceTier = null;
    private final transient String analyticsSchemaTypeName = "sku_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSkuUpdated)) {
            return false;
        }
        TrackSkuUpdated trackSkuUpdated = (TrackSkuUpdated) other;
        return Intrinsics3.areEqual(this.skuId, trackSkuUpdated.skuId) && Intrinsics3.areEqual(this.updateFrom, trackSkuUpdated.updateFrom) && Intrinsics3.areEqual(this.updateType, trackSkuUpdated.updateType) && Intrinsics3.areEqual(this.storeTitle, trackSkuUpdated.storeTitle) && Intrinsics3.areEqual(this.dependentSkuId, trackSkuUpdated.dependentSkuId) && Intrinsics3.areEqual(this.bundledSkuIds, trackSkuUpdated.bundledSkuIds) && Intrinsics3.areEqual(this.accessType, trackSkuUpdated.accessType) && Intrinsics3.areEqual(this.releaseDate, trackSkuUpdated.releaseDate) && Intrinsics3.areEqual(this.isPremium, trackSkuUpdated.isPremium) && Intrinsics3.areEqual(this.isDistribution, trackSkuUpdated.isDistribution) && Intrinsics3.areEqual(this.available, trackSkuUpdated.available) && Intrinsics3.areEqual(this.availableLocales, trackSkuUpdated.availableLocales) && Intrinsics3.areEqual(this.metacriticId, trackSkuUpdated.metacriticId) && Intrinsics3.areEqual(this.isExclusive, trackSkuUpdated.isExclusive) && Intrinsics3.areEqual(this.genres, trackSkuUpdated.genres) && Intrinsics3.areEqual(this.features, trackSkuUpdated.features) && Intrinsics3.areEqual(this.contentRatingPegi, trackSkuUpdated.contentRatingPegi) && Intrinsics3.areEqual(this.contentRatingEsrb, trackSkuUpdated.contentRatingEsrb) && Intrinsics3.areEqual(this.regularPriceTier, trackSkuUpdated.regularPriceTier) && Intrinsics3.areEqual(this.priceTier, trackSkuUpdated.priceTier);
    }

    public int hashCode() {
        Long l = this.skuId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.updateFrom;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.updateType;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.storeTitle;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l2 = this.dependentSkuId;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        List<Long> list = this.bundledSkuIds;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.accessType;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.releaseDate;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.isPremium;
        int iHashCode9 = (iHashCode8 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isDistribution;
        int iHashCode10 = (iHashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.available;
        int iHashCode11 = (iHashCode10 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        List<CharSequence> list2 = this.availableLocales;
        int iHashCode12 = (iHashCode11 + (list2 != null ? list2.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.metacriticId;
        int iHashCode13 = (iHashCode12 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Boolean bool4 = this.isExclusive;
        int iHashCode14 = (iHashCode13 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        List<CharSequence> list3 = this.genres;
        int iHashCode15 = (iHashCode14 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<CharSequence> list4 = this.features;
        int iHashCode16 = (iHashCode15 + (list4 != null ? list4.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.contentRatingPegi;
        int iHashCode17 = (iHashCode16 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.contentRatingEsrb;
        int iHashCode18 = (iHashCode17 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        Long l4 = this.regularPriceTier;
        int iHashCode19 = (iHashCode18 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.priceTier;
        return iHashCode19 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSkuUpdated(skuId=");
        sbU.append(this.skuId);
        sbU.append(", updateFrom=");
        sbU.append(this.updateFrom);
        sbU.append(", updateType=");
        sbU.append(this.updateType);
        sbU.append(", storeTitle=");
        sbU.append(this.storeTitle);
        sbU.append(", dependentSkuId=");
        sbU.append(this.dependentSkuId);
        sbU.append(", bundledSkuIds=");
        sbU.append(this.bundledSkuIds);
        sbU.append(", accessType=");
        sbU.append(this.accessType);
        sbU.append(", releaseDate=");
        sbU.append(this.releaseDate);
        sbU.append(", isPremium=");
        sbU.append(this.isPremium);
        sbU.append(", isDistribution=");
        sbU.append(this.isDistribution);
        sbU.append(", available=");
        sbU.append(this.available);
        sbU.append(", availableLocales=");
        sbU.append(this.availableLocales);
        sbU.append(", metacriticId=");
        sbU.append(this.metacriticId);
        sbU.append(", isExclusive=");
        sbU.append(this.isExclusive);
        sbU.append(", genres=");
        sbU.append(this.genres);
        sbU.append(", features=");
        sbU.append(this.features);
        sbU.append(", contentRatingPegi=");
        sbU.append(this.contentRatingPegi);
        sbU.append(", contentRatingEsrb=");
        sbU.append(this.contentRatingEsrb);
        sbU.append(", regularPriceTier=");
        sbU.append(this.regularPriceTier);
        sbU.append(", priceTier=");
        return outline.G(sbU, this.priceTier, ")");
    }
}
