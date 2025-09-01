package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackAfGame.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackAfGame;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "gameId", "Ljava/lang/Long;", "getGameId", "()Ljava/lang/Long;", "", "gameName", "Ljava/lang/CharSequence;", "getGameName", "()Ljava/lang/CharSequence;", "afNews", "Ljava/lang/Boolean;", "getAfNews", "()Ljava/lang/Boolean;", "gamePlatform", "getGamePlatform", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackAfGame {
    private final Long gameId = null;
    private final CharSequence gameName = null;
    private final Boolean afNews = null;
    private final CharSequence gamePlatform = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfGame)) {
            return false;
        }
        TrackAfGame trackAfGame = (TrackAfGame) other;
        return Intrinsics3.areEqual(this.gameId, trackAfGame.gameId) && Intrinsics3.areEqual(this.gameName, trackAfGame.gameName) && Intrinsics3.areEqual(this.afNews, trackAfGame.afNews) && Intrinsics3.areEqual(this.gamePlatform, trackAfGame.gamePlatform);
    }

    public int hashCode() {
        Long l = this.gameId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.gameName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.afNews;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.gamePlatform;
        return iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAfGame(gameId=");
        sbU.append(this.gameId);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", afNews=");
        sbU.append(this.afNews);
        sbU.append(", gamePlatform=");
        return outline.E(sbU, this.gamePlatform, ")");
    }
}
