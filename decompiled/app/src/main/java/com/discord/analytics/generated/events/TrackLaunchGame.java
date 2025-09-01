package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackLaunchGame.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u001c\u0010\u001b\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010*\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u000f\u001a\u0004\b+\u0010\u0011R\u001b\u0010,\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0014\u001a\u0004\b-\u0010\u0016R\u001b\u0010.\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0014\u001a\u0004\b/\u0010\u0016¨\u00060"}, d2 = {"Lcom/discord/analytics/generated/events/TrackLaunchGame;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "elevated", "Ljava/lang/Boolean;", "getElevated", "()Ljava/lang/Boolean;", "", "distributor", "Ljava/lang/CharSequence;", "getDistributor", "()Ljava/lang/CharSequence;", "gamePlatform", "getGamePlatform", "customName", "getCustomName", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "gameId", "Ljava/lang/Long;", "getGameId", "()Ljava/lang/Long;", "verified", "getVerified", "game", "getGame", "platformType", "getPlatformType", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackLaunchGame implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence game = null;
    private final Long gameId = null;
    private final Boolean verified = null;
    private final Boolean elevated = null;
    private final CharSequence customName = null;
    private final CharSequence platformType = null;
    private final CharSequence gamePlatform = null;
    private final CharSequence distributor = null;
    private final transient String analyticsSchemaTypeName = "launch_game";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLaunchGame)) {
            return false;
        }
        TrackLaunchGame trackLaunchGame = (TrackLaunchGame) other;
        return Intrinsics3.areEqual(this.game, trackLaunchGame.game) && Intrinsics3.areEqual(this.gameId, trackLaunchGame.gameId) && Intrinsics3.areEqual(this.verified, trackLaunchGame.verified) && Intrinsics3.areEqual(this.elevated, trackLaunchGame.elevated) && Intrinsics3.areEqual(this.customName, trackLaunchGame.customName) && Intrinsics3.areEqual(this.platformType, trackLaunchGame.platformType) && Intrinsics3.areEqual(this.gamePlatform, trackLaunchGame.gamePlatform) && Intrinsics3.areEqual(this.distributor, trackLaunchGame.distributor);
    }

    public int hashCode() {
        CharSequence charSequence = this.game;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.gameId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.verified;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.elevated;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.customName;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.platformType;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.gamePlatform;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.distributor;
        return iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackLaunchGame(game=");
        sbU.append(this.game);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", verified=");
        sbU.append(this.verified);
        sbU.append(", elevated=");
        sbU.append(this.elevated);
        sbU.append(", customName=");
        sbU.append(this.customName);
        sbU.append(", platformType=");
        sbU.append(this.platformType);
        sbU.append(", gamePlatform=");
        sbU.append(this.gamePlatform);
        sbU.append(", distributor=");
        return outline.E(sbU, this.distributor, ")");
    }
}
