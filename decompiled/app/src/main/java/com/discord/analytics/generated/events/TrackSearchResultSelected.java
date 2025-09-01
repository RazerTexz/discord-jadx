package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackSearchResultSelected.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00078\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\tR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001b\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00104\u001a\u0004\u0018\u00010/8\u0006@\u0006¢\u0006\f\n\u0004\b4\u00101\u001a\u0004\b5\u00103R\u001b\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00103R$\u00109\u001a\u0004\u0018\u0001088\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001b\u0010?\u001a\u0004\u0018\u00010/8\u0006@\u0006¢\u0006\f\n\u0004\b?\u00101\u001a\u0004\b@\u00103R$\u0010B\u001a\u0004\u0018\u00010A8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001b\u0010H\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010%\u001a\u0004\bI\u0010'R\u001b\u0010J\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010%\u001a\u0004\bK\u0010'R\u001b\u0010L\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010%\u001a\u0004\bM\u0010'R\u001b\u0010N\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u001b\u0010R\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010%\u001a\u0004\bS\u0010'R\u001b\u0010T\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010%\u001a\u0004\bU\u0010'R\u001b\u0010V\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010%\u001a\u0004\bW\u0010'R\u0019\u0010X\u001a\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[¨\u0006\\"}, d2 = {"Lcom/discord/analytics/generated/events/TrackSearchResultSelected;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "Lcom/discord/analytics/generated/traits/TrackSourceMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "", "numModifiers", "Ljava/lang/Long;", "getNumModifiers", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "query", "Ljava/lang/CharSequence;", "getQuery", "()Ljava/lang/CharSequence;", "loadId", "getLoadId", "searchType", "getSearchType", "Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "trackSourceMetadata", "Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "getTrackSourceMetadata", "()Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "setTrackSourceMetadata", "(Lcom/discord/analytics/generated/traits/TrackSourceMetadata;)V", "searchId", "getSearchId", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "indexNum", "getIndexNum", "limit", "getLimit", "totalResults", "getTotalResults", "previewEnabled", "Ljava/lang/Boolean;", "getPreviewEnabled", "()Ljava/lang/Boolean;", "pageResults", "getPageResults", "offset", "getOffset", "page", "getPage", "modifiers", "J", "getModifiers", "()J", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackSearchResultSelected implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackSourceMetadata2, TrackLocationMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Long indexNum;
    private final Long limit;
    private final CharSequence loadId;
    private final long modifiers;
    private final Long numModifiers;
    private final Long offset;
    private final Long page;
    private final Long pageResults;
    private final Boolean previewEnabled;
    private final CharSequence query;
    private final CharSequence searchId;
    private final CharSequence searchType;
    private final Long totalResults;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSourceMetadata trackSourceMetadata;

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
        if (!(other instanceof TrackSearchResultSelected)) {
            return false;
        }
        TrackSearchResultSelected trackSearchResultSelected = (TrackSearchResultSelected) other;
        return Intrinsics3.areEqual(this.searchType, trackSearchResultSelected.searchType) && Intrinsics3.areEqual(this.loadId, trackSearchResultSelected.loadId) && Intrinsics3.areEqual(this.searchId, trackSearchResultSelected.searchId) && Intrinsics3.areEqual(this.indexNum, trackSearchResultSelected.indexNum) && Intrinsics3.areEqual(this.limit, trackSearchResultSelected.limit) && Intrinsics3.areEqual(this.offset, trackSearchResultSelected.offset) && Intrinsics3.areEqual(this.page, trackSearchResultSelected.page) && Intrinsics3.areEqual(this.totalResults, trackSearchResultSelected.totalResults) && Intrinsics3.areEqual(this.pageResults, trackSearchResultSelected.pageResults) && this.modifiers == trackSearchResultSelected.modifiers && Intrinsics3.areEqual(this.numModifiers, trackSearchResultSelected.numModifiers) && Intrinsics3.areEqual(this.previewEnabled, trackSearchResultSelected.previewEnabled) && Intrinsics3.areEqual(this.query, trackSearchResultSelected.query);
    }

    public int hashCode() {
        CharSequence charSequence = this.searchType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.loadId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.searchId;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.indexNum;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.limit;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.offset;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.page;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.totalResults;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.pageResults;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        long j = this.modifiers;
        int i = (iHashCode9 + ((int) (j ^ (j >>> 32)))) * 31;
        Long l7 = this.numModifiers;
        int iHashCode10 = (i + (l7 != null ? l7.hashCode() : 0)) * 31;
        Boolean bool = this.previewEnabled;
        int iHashCode11 = (iHashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.query;
        return iHashCode11 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSearchResultSelected(searchType=");
        sbU.append(this.searchType);
        sbU.append(", loadId=");
        sbU.append(this.loadId);
        sbU.append(", searchId=");
        sbU.append(this.searchId);
        sbU.append(", indexNum=");
        sbU.append(this.indexNum);
        sbU.append(", limit=");
        sbU.append(this.limit);
        sbU.append(", offset=");
        sbU.append(this.offset);
        sbU.append(", page=");
        sbU.append(this.page);
        sbU.append(", totalResults=");
        sbU.append(this.totalResults);
        sbU.append(", pageResults=");
        sbU.append(this.pageResults);
        sbU.append(", modifiers=");
        sbU.append(this.modifiers);
        sbU.append(", numModifiers=");
        sbU.append(this.numModifiers);
        sbU.append(", previewEnabled=");
        sbU.append(this.previewEnabled);
        sbU.append(", query=");
        return outline.E(sbU, this.query, ")");
    }
}
