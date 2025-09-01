package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackActivityInternalActionChess.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0006R\u001b\u0010%\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010)\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010!R\u001b\u0010+\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(R\u001b\u0010-\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010!R\u001b\u0010/\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u001f\u001a\u0004\b0\u0010!R\u001b\u00101\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u001f\u001a\u0004\b2\u0010!R\u001b\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u00108\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010&\u001a\u0004\b9\u0010(R\u001b\u0010:\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u001f\u001a\u0004\b;\u0010!R\u001b\u0010<\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u001f\u001a\u0004\b=\u0010!R\u001b\u0010>\u001a\u0004\u0018\u0001038\u0006@\u0006¢\u0006\f\n\u0004\b>\u00105\u001a\u0004\b?\u00107¨\u0006@"}, d2 = {"Lcom/discord/analytics/generated/events/activity_internal/TrackActivityInternalActionChess;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "trackActivityInternalMetadata", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "getTrackActivityInternalMetadata", "()Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "setTrackActivityInternalMetadata", "(Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;)V", "", "playerColor", "Ljava/lang/CharSequence;", "getPlayerColor", "()Ljava/lang/CharSequence;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "lockedGame", "Ljava/lang/Boolean;", "getLockedGame", "()Ljava/lang/Boolean;", "lastScreen", "getLastScreen", "againstBot", "getAgainstBot", "phase", "getPhase", "pieceSet", "getPieceSet", "background", "getBackground", "", "reconnectTime", "Ljava/lang/Long;", "getReconnectTime", "()Ljava/lang/Long;", "timedGame", "getTimedGame", "actionName", "getActionName", "moveType", "getMoveType", "numSpectators", "getNumSpectators", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalActionChess implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final CharSequence phase = null;
    private final CharSequence moveType = null;
    private final Boolean lockedGame = null;
    private final Boolean timedGame = null;
    private final Boolean againstBot = null;
    private final CharSequence background = null;
    private final CharSequence pieceSet = null;
    private final Long numSpectators = null;
    private final CharSequence playerColor = null;
    private final CharSequence lastScreen = null;
    private final Long reconnectTime = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_action_chess";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalActionChess)) {
            return false;
        }
        TrackActivityInternalActionChess trackActivityInternalActionChess = (TrackActivityInternalActionChess) other;
        return Intrinsics3.areEqual(this.actionName, trackActivityInternalActionChess.actionName) && Intrinsics3.areEqual(this.phase, trackActivityInternalActionChess.phase) && Intrinsics3.areEqual(this.moveType, trackActivityInternalActionChess.moveType) && Intrinsics3.areEqual(this.lockedGame, trackActivityInternalActionChess.lockedGame) && Intrinsics3.areEqual(this.timedGame, trackActivityInternalActionChess.timedGame) && Intrinsics3.areEqual(this.againstBot, trackActivityInternalActionChess.againstBot) && Intrinsics3.areEqual(this.background, trackActivityInternalActionChess.background) && Intrinsics3.areEqual(this.pieceSet, trackActivityInternalActionChess.pieceSet) && Intrinsics3.areEqual(this.numSpectators, trackActivityInternalActionChess.numSpectators) && Intrinsics3.areEqual(this.playerColor, trackActivityInternalActionChess.playerColor) && Intrinsics3.areEqual(this.lastScreen, trackActivityInternalActionChess.lastScreen) && Intrinsics3.areEqual(this.reconnectTime, trackActivityInternalActionChess.reconnectTime);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.phase;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.moveType;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.lockedGame;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.timedGame;
        int iHashCode5 = (iHashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.againstBot;
        int iHashCode6 = (iHashCode5 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.background;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.pieceSet;
        int iHashCode8 = (iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l = this.numSpectators;
        int iHashCode9 = (iHashCode8 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.playerColor;
        int iHashCode10 = (iHashCode9 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.lastScreen;
        int iHashCode11 = (iHashCode10 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        Long l2 = this.reconnectTime;
        return iHashCode11 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalActionChess(actionName=");
        sbU.append(this.actionName);
        sbU.append(", phase=");
        sbU.append(this.phase);
        sbU.append(", moveType=");
        sbU.append(this.moveType);
        sbU.append(", lockedGame=");
        sbU.append(this.lockedGame);
        sbU.append(", timedGame=");
        sbU.append(this.timedGame);
        sbU.append(", againstBot=");
        sbU.append(this.againstBot);
        sbU.append(", background=");
        sbU.append(this.background);
        sbU.append(", pieceSet=");
        sbU.append(this.pieceSet);
        sbU.append(", numSpectators=");
        sbU.append(this.numSpectators);
        sbU.append(", playerColor=");
        sbU.append(this.playerColor);
        sbU.append(", lastScreen=");
        sbU.append(this.lastScreen);
        sbU.append(", reconnectTime=");
        return outline.G(sbU, this.reconnectTime, ")");
    }
}
