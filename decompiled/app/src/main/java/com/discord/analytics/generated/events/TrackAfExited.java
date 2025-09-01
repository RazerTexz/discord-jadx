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

/* compiled from: TrackAfExited.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u001c\u0010\u001d\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0006R\u001b\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018R!\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010)\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010\u0018R\u001b\u0010+\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018R$\u0010.\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R!\u00104\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010&\u001a\u0004\b5\u0010(R$\u00107\u001a\u0004\u0018\u0001068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R!\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010&\u001a\u0004\b>\u0010(R!\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010&\u001a\u0004\b@\u0010(R!\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010&\u001a\u0004\bB\u0010(¨\u0006C"}, d2 = {"Lcom/discord/analytics/generated/events/TrackAfExited;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "feedLayout", "Ljava/lang/CharSequence;", "getFeedLayout", "()Ljava/lang/CharSequence;", "", "numCardsViewed", "Ljava/lang/Long;", "getNumCardsViewed", "()Ljava/lang/Long;", "windowWidth", "getWindowWidth", "secondsSpent", "getSecondsSpent", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "loadId", "getLoadId", "windowHeight", "getWindowHeight", "", "subscribedGames", "Ljava/util/List;", "getSubscribedGames", "()Ljava/util/List;", "numCardsTotal", "getNumCardsTotal", "numGamesViewed", "getNumGamesViewed", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "storeApplicationIdsViewed", "getStoreApplicationIdsViewed", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "gameIdsViewed", "getGameIdsViewed", "storeSkuIdsViewed", "getStoreSkuIdsViewed", "newsIdsViewed", "getNewsIdsViewed", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackAfExited implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence loadId = null;
    private final List<Long> gameIdsViewed = null;
    private final List<Long> storeApplicationIdsViewed = null;
    private final List<Long> storeSkuIdsViewed = null;
    private final Long numGamesViewed = null;
    private final Long numCardsViewed = null;
    private final Long secondsSpent = null;
    private final CharSequence feedLayout = null;
    private final Long windowWidth = null;
    private final Long windowHeight = null;
    private final List<Long> subscribedGames = null;
    private final Long numCardsTotal = null;
    private final List<Long> newsIdsViewed = null;
    private final transient String analyticsSchemaTypeName = "af_exited";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfExited)) {
            return false;
        }
        TrackAfExited trackAfExited = (TrackAfExited) other;
        return Intrinsics3.areEqual(this.loadId, trackAfExited.loadId) && Intrinsics3.areEqual(this.gameIdsViewed, trackAfExited.gameIdsViewed) && Intrinsics3.areEqual(this.storeApplicationIdsViewed, trackAfExited.storeApplicationIdsViewed) && Intrinsics3.areEqual(this.storeSkuIdsViewed, trackAfExited.storeSkuIdsViewed) && Intrinsics3.areEqual(this.numGamesViewed, trackAfExited.numGamesViewed) && Intrinsics3.areEqual(this.numCardsViewed, trackAfExited.numCardsViewed) && Intrinsics3.areEqual(this.secondsSpent, trackAfExited.secondsSpent) && Intrinsics3.areEqual(this.feedLayout, trackAfExited.feedLayout) && Intrinsics3.areEqual(this.windowWidth, trackAfExited.windowWidth) && Intrinsics3.areEqual(this.windowHeight, trackAfExited.windowHeight) && Intrinsics3.areEqual(this.subscribedGames, trackAfExited.subscribedGames) && Intrinsics3.areEqual(this.numCardsTotal, trackAfExited.numCardsTotal) && Intrinsics3.areEqual(this.newsIdsViewed, trackAfExited.newsIdsViewed);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<Long> list = this.gameIdsViewed;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.storeApplicationIdsViewed;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Long> list3 = this.storeSkuIdsViewed;
        int iHashCode4 = (iHashCode3 + (list3 != null ? list3.hashCode() : 0)) * 31;
        Long l = this.numGamesViewed;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numCardsViewed;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.secondsSpent;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.feedLayout;
        int iHashCode8 = (iHashCode7 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l4 = this.windowWidth;
        int iHashCode9 = (iHashCode8 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.windowHeight;
        int iHashCode10 = (iHashCode9 + (l5 != null ? l5.hashCode() : 0)) * 31;
        List<Long> list4 = this.subscribedGames;
        int iHashCode11 = (iHashCode10 + (list4 != null ? list4.hashCode() : 0)) * 31;
        Long l6 = this.numCardsTotal;
        int iHashCode12 = (iHashCode11 + (l6 != null ? l6.hashCode() : 0)) * 31;
        List<Long> list5 = this.newsIdsViewed;
        return iHashCode12 + (list5 != null ? list5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAfExited(loadId=");
        sbU.append(this.loadId);
        sbU.append(", gameIdsViewed=");
        sbU.append(this.gameIdsViewed);
        sbU.append(", storeApplicationIdsViewed=");
        sbU.append(this.storeApplicationIdsViewed);
        sbU.append(", storeSkuIdsViewed=");
        sbU.append(this.storeSkuIdsViewed);
        sbU.append(", numGamesViewed=");
        sbU.append(this.numGamesViewed);
        sbU.append(", numCardsViewed=");
        sbU.append(this.numCardsViewed);
        sbU.append(", secondsSpent=");
        sbU.append(this.secondsSpent);
        sbU.append(", feedLayout=");
        sbU.append(this.feedLayout);
        sbU.append(", windowWidth=");
        sbU.append(this.windowWidth);
        sbU.append(", windowHeight=");
        sbU.append(this.windowHeight);
        sbU.append(", subscribedGames=");
        sbU.append(this.subscribedGames);
        sbU.append(", numCardsTotal=");
        sbU.append(this.numCardsTotal);
        sbU.append(", newsIdsViewed=");
        return outline.L(sbU, this.newsIdsViewed, ")");
    }
}
