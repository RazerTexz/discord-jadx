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

/* compiled from: TrackAfLoaded.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR!\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010\"\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013R\u001b\u0010$\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013R\u001b\u0010&\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013R!\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010!R\u001b\u0010*\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b+\u0010\u0013R\u001b\u0010,\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b-\u0010\u0013R!\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u001f\u001a\u0004\b/\u0010!R\u001c\u00100\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0006R\u001b\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u00108\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u0011\u001a\u0004\b9\u0010\u0013R\u001b\u0010:\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u0011\u001a\u0004\b;\u0010\u0013R\u001b\u0010<\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0011\u001a\u0004\b=\u0010\u0013R\u001b\u0010>\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u0011\u001a\u0004\b?\u0010\u0013R\u001b\u0010@\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\u0011\u001a\u0004\bA\u0010\u0013R$\u0010C\u001a\u0004\u0018\u00010B8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR!\u0010I\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010\u001f\u001a\u0004\bJ\u0010!R\u001b\u0010K\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010\u0011\u001a\u0004\bL\u0010\u0013R\u001b\u0010M\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010\u0011\u001a\u0004\bN\u0010\u0013R\u001b\u0010O\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010\u0011\u001a\u0004\bP\u0010\u0013R\u001b\u0010Q\u001a\u0004\u0018\u0001038\u0006@\u0006¢\u0006\f\n\u0004\bQ\u00105\u001a\u0004\bR\u00107R\u001b\u0010S\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010\u0011\u001a\u0004\bT\u0010\u0013R\u001b\u0010U\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010\u0011\u001a\u0004\bV\u0010\u0013R\u001b\u0010W\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bW\u0010\u0011\u001a\u0004\bX\u0010\u0013¨\u0006Y"}, d2 = {"Lcom/discord/analytics/generated/events/TrackAfLoaded;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "numCards", "Ljava/lang/Long;", "getNumCards", "()Ljava/lang/Long;", "numCardsGameNews", "getNumCardsGameNews", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "gameIds", "Ljava/util/List;", "getGameIds", "()Ljava/util/List;", "numGamePartiesSolo", "getNumGamePartiesSolo", "numGamePartiesCollapsed", "getNumGamePartiesCollapsed", "numSoloCollapsed", "getNumSoloCollapsed", "newsIdsViewed", "getNewsIdsViewed", "numItemsNowPlaying", "getNumItemsNowPlaying", "numGameParties", "getNumGameParties", "subscribedGames", "getSubscribedGames", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "", "feedLayout", "Ljava/lang/CharSequence;", "getFeedLayout", "()Ljava/lang/CharSequence;", "windowWidth", "getWindowWidth", "numCardsGamePlayable", "getNumCardsGamePlayable", "numLauncherApplications", "getNumLauncherApplications", "numGamePartiesRecentlyPlayed", "getNumGamePartiesRecentlyPlayed", "numGamePartiesRichPresence", "getNumGamePartiesRichPresence", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "guildIdsViewed", "getGuildIdsViewed", "numRecentlyPlayedCollapsed", "getNumRecentlyPlayedCollapsed", "numGamePartiesVoice", "getNumGamePartiesVoice", "numItemsRecentlyPlayed", "getNumItemsRecentlyPlayed", "loadId", "getLoadId", "windowHeight", "getWindowHeight", "numUsersSubscribed", "getNumUsersSubscribed", "numCardsVisible", "getNumCardsVisible", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackAfLoaded implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence loadId = null;
    private final List<Long> gameIds = null;
    private final Long numCards = null;
    private final Long numCardsVisible = null;
    private final Long numCardsGameNews = null;
    private final Long numCardsGamePlayable = null;
    private final Long numGameParties = null;
    private final Long numGamePartiesVoice = null;
    private final Long numGamePartiesSolo = null;
    private final Long numGamePartiesRecentlyPlayed = null;
    private final Long numGamePartiesRichPresence = null;
    private final Long numGamePartiesCollapsed = null;
    private final Long numSoloCollapsed = null;
    private final Long numRecentlyPlayedCollapsed = null;
    private final Long numUsersSubscribed = null;
    private final Long numLauncherApplications = null;
    private final Long windowWidth = null;
    private final Long windowHeight = null;
    private final CharSequence feedLayout = null;
    private final List<Long> subscribedGames = null;
    private final Long numItemsNowPlaying = null;
    private final Long numItemsRecentlyPlayed = null;
    private final List<Long> newsIdsViewed = null;
    private final List<Long> guildIdsViewed = null;
    private final transient String analyticsSchemaTypeName = "af_loaded";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfLoaded)) {
            return false;
        }
        TrackAfLoaded trackAfLoaded = (TrackAfLoaded) other;
        return Intrinsics3.areEqual(this.loadId, trackAfLoaded.loadId) && Intrinsics3.areEqual(this.gameIds, trackAfLoaded.gameIds) && Intrinsics3.areEqual(this.numCards, trackAfLoaded.numCards) && Intrinsics3.areEqual(this.numCardsVisible, trackAfLoaded.numCardsVisible) && Intrinsics3.areEqual(this.numCardsGameNews, trackAfLoaded.numCardsGameNews) && Intrinsics3.areEqual(this.numCardsGamePlayable, trackAfLoaded.numCardsGamePlayable) && Intrinsics3.areEqual(this.numGameParties, trackAfLoaded.numGameParties) && Intrinsics3.areEqual(this.numGamePartiesVoice, trackAfLoaded.numGamePartiesVoice) && Intrinsics3.areEqual(this.numGamePartiesSolo, trackAfLoaded.numGamePartiesSolo) && Intrinsics3.areEqual(this.numGamePartiesRecentlyPlayed, trackAfLoaded.numGamePartiesRecentlyPlayed) && Intrinsics3.areEqual(this.numGamePartiesRichPresence, trackAfLoaded.numGamePartiesRichPresence) && Intrinsics3.areEqual(this.numGamePartiesCollapsed, trackAfLoaded.numGamePartiesCollapsed) && Intrinsics3.areEqual(this.numSoloCollapsed, trackAfLoaded.numSoloCollapsed) && Intrinsics3.areEqual(this.numRecentlyPlayedCollapsed, trackAfLoaded.numRecentlyPlayedCollapsed) && Intrinsics3.areEqual(this.numUsersSubscribed, trackAfLoaded.numUsersSubscribed) && Intrinsics3.areEqual(this.numLauncherApplications, trackAfLoaded.numLauncherApplications) && Intrinsics3.areEqual(this.windowWidth, trackAfLoaded.windowWidth) && Intrinsics3.areEqual(this.windowHeight, trackAfLoaded.windowHeight) && Intrinsics3.areEqual(this.feedLayout, trackAfLoaded.feedLayout) && Intrinsics3.areEqual(this.subscribedGames, trackAfLoaded.subscribedGames) && Intrinsics3.areEqual(this.numItemsNowPlaying, trackAfLoaded.numItemsNowPlaying) && Intrinsics3.areEqual(this.numItemsRecentlyPlayed, trackAfLoaded.numItemsRecentlyPlayed) && Intrinsics3.areEqual(this.newsIdsViewed, trackAfLoaded.newsIdsViewed) && Intrinsics3.areEqual(this.guildIdsViewed, trackAfLoaded.guildIdsViewed);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<Long> list = this.gameIds;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Long l = this.numCards;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numCardsVisible;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numCardsGameNews;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numCardsGamePlayable;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numGameParties;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.numGamePartiesVoice;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.numGamePartiesSolo;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.numGamePartiesRecentlyPlayed;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.numGamePartiesRichPresence;
        int iHashCode11 = (iHashCode10 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.numGamePartiesCollapsed;
        int iHashCode12 = (iHashCode11 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.numSoloCollapsed;
        int iHashCode13 = (iHashCode12 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.numRecentlyPlayedCollapsed;
        int iHashCode14 = (iHashCode13 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.numUsersSubscribed;
        int iHashCode15 = (iHashCode14 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.numLauncherApplications;
        int iHashCode16 = (iHashCode15 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.windowWidth;
        int iHashCode17 = (iHashCode16 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.windowHeight;
        int iHashCode18 = (iHashCode17 + (l16 != null ? l16.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.feedLayout;
        int iHashCode19 = (iHashCode18 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        List<Long> list2 = this.subscribedGames;
        int iHashCode20 = (iHashCode19 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Long l17 = this.numItemsNowPlaying;
        int iHashCode21 = (iHashCode20 + (l17 != null ? l17.hashCode() : 0)) * 31;
        Long l18 = this.numItemsRecentlyPlayed;
        int iHashCode22 = (iHashCode21 + (l18 != null ? l18.hashCode() : 0)) * 31;
        List<Long> list3 = this.newsIdsViewed;
        int iHashCode23 = (iHashCode22 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<Long> list4 = this.guildIdsViewed;
        return iHashCode23 + (list4 != null ? list4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAfLoaded(loadId=");
        sbU.append(this.loadId);
        sbU.append(", gameIds=");
        sbU.append(this.gameIds);
        sbU.append(", numCards=");
        sbU.append(this.numCards);
        sbU.append(", numCardsVisible=");
        sbU.append(this.numCardsVisible);
        sbU.append(", numCardsGameNews=");
        sbU.append(this.numCardsGameNews);
        sbU.append(", numCardsGamePlayable=");
        sbU.append(this.numCardsGamePlayable);
        sbU.append(", numGameParties=");
        sbU.append(this.numGameParties);
        sbU.append(", numGamePartiesVoice=");
        sbU.append(this.numGamePartiesVoice);
        sbU.append(", numGamePartiesSolo=");
        sbU.append(this.numGamePartiesSolo);
        sbU.append(", numGamePartiesRecentlyPlayed=");
        sbU.append(this.numGamePartiesRecentlyPlayed);
        sbU.append(", numGamePartiesRichPresence=");
        sbU.append(this.numGamePartiesRichPresence);
        sbU.append(", numGamePartiesCollapsed=");
        sbU.append(this.numGamePartiesCollapsed);
        sbU.append(", numSoloCollapsed=");
        sbU.append(this.numSoloCollapsed);
        sbU.append(", numRecentlyPlayedCollapsed=");
        sbU.append(this.numRecentlyPlayedCollapsed);
        sbU.append(", numUsersSubscribed=");
        sbU.append(this.numUsersSubscribed);
        sbU.append(", numLauncherApplications=");
        sbU.append(this.numLauncherApplications);
        sbU.append(", windowWidth=");
        sbU.append(this.windowWidth);
        sbU.append(", windowHeight=");
        sbU.append(this.windowHeight);
        sbU.append(", feedLayout=");
        sbU.append(this.feedLayout);
        sbU.append(", subscribedGames=");
        sbU.append(this.subscribedGames);
        sbU.append(", numItemsNowPlaying=");
        sbU.append(this.numItemsNowPlaying);
        sbU.append(", numItemsRecentlyPlayed=");
        sbU.append(this.numItemsRecentlyPlayed);
        sbU.append(", newsIdsViewed=");
        sbU.append(this.newsIdsViewed);
        sbU.append(", guildIdsViewed=");
        return outline.L(sbU, this.guildIdsViewed, ")");
    }
}
