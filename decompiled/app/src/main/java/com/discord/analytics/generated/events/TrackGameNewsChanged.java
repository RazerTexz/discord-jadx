package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCard2;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGame2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackGameNewsChanged.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0007R\u001b\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010+\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010\u001bR\u001b\u0010-\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010\u001bR$\u00100\u001a\u0004\u0018\u00010/8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001b\u00106\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010(\u001a\u0004\b7\u0010*¨\u00068"}, d2 = {"Lcom/discord/analytics/generated/events/TrackGameNewsChanged;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackAfGameReceiver;", "Lcom/discord/analytics/generated/traits/TrackAfCardReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "changeCount", "Ljava/lang/Long;", "getChangeCount", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackAfGame;", "trackAfGame", "Lcom/discord/analytics/generated/traits/TrackAfGame;", "getTrackAfGame", "()Lcom/discord/analytics/generated/traits/TrackAfGame;", "setTrackAfGame", "(Lcom/discord/analytics/generated/traits/TrackAfGame;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "", "newsUrl", "Ljava/lang/CharSequence;", "getNewsUrl", "()Ljava/lang/CharSequence;", "newsFromIndex", "getNewsFromIndex", "newsToIndex", "getNewsToIndex", "Lcom/discord/analytics/generated/traits/TrackAfCard;", "trackAfCard", "Lcom/discord/analytics/generated/traits/TrackAfCard;", "getTrackAfCard", "()Lcom/discord/analytics/generated/traits/TrackAfCard;", "setTrackAfCard", "(Lcom/discord/analytics/generated/traits/TrackAfCard;)V", "newsChangeType", "getNewsChangeType", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackGameNewsChanged implements AnalyticsSchema, TrackBase2, TrackAfGame2, TrackAfCard2 {
    private TrackAfCard trackAfCard;
    private TrackAfGame trackAfGame;
    private TrackBase trackBase;
    private final Long changeCount = null;
    private final CharSequence newsUrl = null;
    private final Long newsToIndex = null;
    private final Long newsFromIndex = null;
    private final CharSequence newsChangeType = null;
    private final transient String analyticsSchemaTypeName = "game_news_changed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGameNewsChanged)) {
            return false;
        }
        TrackGameNewsChanged trackGameNewsChanged = (TrackGameNewsChanged) other;
        return Intrinsics3.areEqual(this.changeCount, trackGameNewsChanged.changeCount) && Intrinsics3.areEqual(this.newsUrl, trackGameNewsChanged.newsUrl) && Intrinsics3.areEqual(this.newsToIndex, trackGameNewsChanged.newsToIndex) && Intrinsics3.areEqual(this.newsFromIndex, trackGameNewsChanged.newsFromIndex) && Intrinsics3.areEqual(this.newsChangeType, trackGameNewsChanged.newsChangeType);
    }

    public int hashCode() {
        Long l = this.changeCount;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.newsUrl;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.newsToIndex;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.newsFromIndex;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.newsChangeType;
        return iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGameNewsChanged(changeCount=");
        sbU.append(this.changeCount);
        sbU.append(", newsUrl=");
        sbU.append(this.newsUrl);
        sbU.append(", newsToIndex=");
        sbU.append(this.newsToIndex);
        sbU.append(", newsFromIndex=");
        sbU.append(this.newsFromIndex);
        sbU.append(", newsChangeType=");
        return outline.E(sbU, this.newsChangeType, ")");
    }
}
