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
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackSearchResultViewed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b%\u0010#R!\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010+\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001cR$\u0010.\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u00104\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u001a\u001a\u0004\b5\u0010\u001cR\u001b\u00106\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b6\u00108R\u001b\u00109\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b9\u00107\u001a\u0004\b9\u00108R\u001b\u0010:\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u001a\u001a\u0004\b;\u0010\u001cR\u0019\u0010<\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001b\u0010@\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\u001a\u001a\u0004\bA\u0010\u001cR\u001b\u0010B\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010!\u001a\u0004\bC\u0010#R\u001b\u0010D\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bD\u00107\u001a\u0004\bD\u00108R$\u0010F\u001a\u0004\u0018\u00010E8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001b\u0010L\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010\u001a\u001a\u0004\bM\u0010\u001cR\u001b\u0010N\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bN\u00107\u001a\u0004\bO\u00108R\u001b\u0010P\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010\u001a\u001a\u0004\bQ\u0010\u001cR\u001b\u0010R\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010\u001a\u001a\u0004\bS\u0010\u001cR\u001b\u0010T\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010!\u001a\u0004\bU\u0010#R\u001b\u0010V\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010\u001a\u001a\u0004\bW\u0010\u001cR\u001b\u0010X\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\bX\u0010\u001a\u001a\u0004\bY\u0010\u001cR\u001b\u0010Z\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010\u001a\u001a\u0004\b[\u0010\u001cR$\u0010]\u001a\u0004\u0018\u00010\\8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001b\u0010c\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\bc\u0010\u001a\u001a\u0004\bd\u0010\u001cR\u001b\u0010e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\be\u0010!\u001a\u0004\bf\u0010#R\u001c\u0010g\u001a\u00020\u00068\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010\b¨\u0006j"}, d2 = {"Lcom/discord/analytics/generated/events/TrackSearchResultViewed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "", "pageResults", "Ljava/lang/Long;", "getPageResults", "()Ljava/lang/Long;", "page", "getPage", "", "prevSearchId", "Ljava/lang/CharSequence;", "getPrevSearchId", "()Ljava/lang/CharSequence;", "loadId", "getLoadId", "", "guildIds", "Ljava/util/List;", "getGuildIds", "()Ljava/util/List;", "totalResults", "getTotalResults", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "offset", "getOffset", "isSuggestion", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "isError", "pageNumAttach", "getPageNumAttach", "modifiers", "J", "getModifiers", "()J", "numResultsLocked", "getNumResultsLocked", "searchType", "getSearchType", "isIndexing", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "numModifiers", "getNumModifiers", "previewEnabled", "getPreviewEnabled", "pageNumLinks", "getPageNumLinks", "pageNumEmbeds", "getPageNumEmbeds", "query", "getQuery", "loadDurationMs", "getLoadDurationMs", "pageNumMessages", "getPageNumMessages", "categoryId", "getCategoryId", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "limit", "getLimit", "searchId", "getSearchId", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackSearchResultViewed implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackGuild2, TrackChannel2 {
    private final transient String analyticsSchemaTypeName;
    private final Long categoryId;
    private final List<Long> guildIds;
    private final Boolean isError;
    private final Boolean isIndexing;
    private final Boolean isSuggestion;
    private final Long limit;
    private final Long loadDurationMs;
    private final CharSequence loadId;
    private final long modifiers;
    private final Long numModifiers;
    private final Long numResultsLocked;
    private final Long offset;
    private final Long page;
    private final Long pageNumAttach;
    private final Long pageNumEmbeds;
    private final Long pageNumLinks;
    private final Long pageNumMessages;
    private final Long pageResults;
    private final CharSequence prevSearchId;
    private final Boolean previewEnabled;
    private final CharSequence query;
    private final CharSequence searchId;
    private final CharSequence searchType;
    private final Long totalResults;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;

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
        if (!(other instanceof TrackSearchResultViewed)) {
            return false;
        }
        TrackSearchResultViewed trackSearchResultViewed = (TrackSearchResultViewed) other;
        return Intrinsics3.areEqual(this.searchType, trackSearchResultViewed.searchType) && Intrinsics3.areEqual(this.loadId, trackSearchResultViewed.loadId) && Intrinsics3.areEqual(this.loadDurationMs, trackSearchResultViewed.loadDurationMs) && Intrinsics3.areEqual(this.searchId, trackSearchResultViewed.searchId) && Intrinsics3.areEqual(this.prevSearchId, trackSearchResultViewed.prevSearchId) && Intrinsics3.areEqual(this.isError, trackSearchResultViewed.isError) && Intrinsics3.areEqual(this.limit, trackSearchResultViewed.limit) && Intrinsics3.areEqual(this.offset, trackSearchResultViewed.offset) && Intrinsics3.areEqual(this.page, trackSearchResultViewed.page) && Intrinsics3.areEqual(this.totalResults, trackSearchResultViewed.totalResults) && Intrinsics3.areEqual(this.pageResults, trackSearchResultViewed.pageResults) && Intrinsics3.areEqual(this.isIndexing, trackSearchResultViewed.isIndexing) && Intrinsics3.areEqual(this.pageNumMessages, trackSearchResultViewed.pageNumMessages) && Intrinsics3.areEqual(this.pageNumLinks, trackSearchResultViewed.pageNumLinks) && Intrinsics3.areEqual(this.pageNumEmbeds, trackSearchResultViewed.pageNumEmbeds) && Intrinsics3.areEqual(this.pageNumAttach, trackSearchResultViewed.pageNumAttach) && this.modifiers == trackSearchResultViewed.modifiers && Intrinsics3.areEqual(this.numModifiers, trackSearchResultViewed.numModifiers) && Intrinsics3.areEqual(this.query, trackSearchResultViewed.query) && Intrinsics3.areEqual(this.guildIds, trackSearchResultViewed.guildIds) && Intrinsics3.areEqual(this.categoryId, trackSearchResultViewed.categoryId) && Intrinsics3.areEqual(this.previewEnabled, trackSearchResultViewed.previewEnabled) && Intrinsics3.areEqual(this.numResultsLocked, trackSearchResultViewed.numResultsLocked) && Intrinsics3.areEqual(this.isSuggestion, trackSearchResultViewed.isSuggestion);
    }

    public int hashCode() {
        CharSequence charSequence = this.searchType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.loadId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.loadDurationMs;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.searchId;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.prevSearchId;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool = this.isError;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.limit;
        int iHashCode7 = (iHashCode6 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.offset;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.page;
        int iHashCode9 = (iHashCode8 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.totalResults;
        int iHashCode10 = (iHashCode9 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.pageResults;
        int iHashCode11 = (iHashCode10 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Boolean bool2 = this.isIndexing;
        int iHashCode12 = (iHashCode11 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l7 = this.pageNumMessages;
        int iHashCode13 = (iHashCode12 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.pageNumLinks;
        int iHashCode14 = (iHashCode13 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.pageNumEmbeds;
        int iHashCode15 = (iHashCode14 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.pageNumAttach;
        int iHashCode16 = (iHashCode15 + (l10 != null ? l10.hashCode() : 0)) * 31;
        long j = this.modifiers;
        int i = (iHashCode16 + ((int) (j ^ (j >>> 32)))) * 31;
        Long l11 = this.numModifiers;
        int iHashCode17 = (i + (l11 != null ? l11.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.query;
        int iHashCode18 = (iHashCode17 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        List<Long> list = this.guildIds;
        int iHashCode19 = (iHashCode18 + (list != null ? list.hashCode() : 0)) * 31;
        Long l12 = this.categoryId;
        int iHashCode20 = (iHashCode19 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Boolean bool3 = this.previewEnabled;
        int iHashCode21 = (iHashCode20 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l13 = this.numResultsLocked;
        int iHashCode22 = (iHashCode21 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Boolean bool4 = this.isSuggestion;
        return iHashCode22 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSearchResultViewed(searchType=");
        sbU.append(this.searchType);
        sbU.append(", loadId=");
        sbU.append(this.loadId);
        sbU.append(", loadDurationMs=");
        sbU.append(this.loadDurationMs);
        sbU.append(", searchId=");
        sbU.append(this.searchId);
        sbU.append(", prevSearchId=");
        sbU.append(this.prevSearchId);
        sbU.append(", isError=");
        sbU.append(this.isError);
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
        sbU.append(", isIndexing=");
        sbU.append(this.isIndexing);
        sbU.append(", pageNumMessages=");
        sbU.append(this.pageNumMessages);
        sbU.append(", pageNumLinks=");
        sbU.append(this.pageNumLinks);
        sbU.append(", pageNumEmbeds=");
        sbU.append(this.pageNumEmbeds);
        sbU.append(", pageNumAttach=");
        sbU.append(this.pageNumAttach);
        sbU.append(", modifiers=");
        sbU.append(this.modifiers);
        sbU.append(", numModifiers=");
        sbU.append(this.numModifiers);
        sbU.append(", query=");
        sbU.append(this.query);
        sbU.append(", guildIds=");
        sbU.append(this.guildIds);
        sbU.append(", categoryId=");
        sbU.append(this.categoryId);
        sbU.append(", previewEnabled=");
        sbU.append(this.previewEnabled);
        sbU.append(", numResultsLocked=");
        sbU.append(this.numResultsLocked);
        sbU.append(", isSuggestion=");
        return outline.D(sbU, this.isSuggestion, ")");
    }
}
