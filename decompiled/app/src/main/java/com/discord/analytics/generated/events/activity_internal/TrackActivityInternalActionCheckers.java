package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackActivityInternalActionCheckers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001aR\u001b\u0010$\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001aR\u001b\u0010&\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010*\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010\u001aR\u001b\u0010,\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u001f\u001a\u0004\b-\u0010!R$\u0010/\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u00105\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010'\u001a\u0004\b6\u0010)R\u001b\u00107\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010'\u001a\u0004\b8\u0010)R\u001c\u00109\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u0006R\u001b\u0010<\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0018\u001a\u0004\b=\u0010\u001aR\u001b\u0010>\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u0018\u001a\u0004\b?\u0010\u001aR\u001b\u0010@\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\u0018\u001a\u0004\bA\u0010\u001aR\u001b\u0010B\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010\u001f\u001a\u0004\bC\u0010!¨\u0006D"}, d2 = {"Lcom/discord/analytics/generated/events/activity_internal/TrackActivityInternalActionCheckers;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "trackActivityInternalMetadata", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "getTrackActivityInternalMetadata", "()Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "setTrackActivityInternalMetadata", "(Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;)V", "", "pieceSet", "Ljava/lang/CharSequence;", "getPieceSet", "()Ljava/lang/CharSequence;", "background", "getBackground", "", "numSpectators", "Ljava/lang/Long;", "getNumSpectators", "()Ljava/lang/Long;", "phase", "getPhase", "playerColor", "getPlayerColor", "againstBot", "Ljava/lang/Boolean;", "getAgainstBot", "()Ljava/lang/Boolean;", "moveType", "getMoveType", "reconnectTime", "getReconnectTime", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "lockedGame", "getLockedGame", "timedGame", "getTimedGame", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "actionName", "getActionName", "interestingMoveType", "getInterestingMoveType", "lastScreen", "getLastScreen", "jumpCount", "getJumpCount", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalActionCheckers implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final CharSequence phase = null;
    private final CharSequence moveType = null;
    private final CharSequence interestingMoveType = null;
    private final Boolean lockedGame = null;
    private final Boolean timedGame = null;
    private final Boolean againstBot = null;
    private final CharSequence background = null;
    private final CharSequence pieceSet = null;
    private final Long numSpectators = null;
    private final CharSequence playerColor = null;
    private final CharSequence lastScreen = null;
    private final Long jumpCount = null;
    private final Long reconnectTime = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_action_checkers";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalActionCheckers)) {
            return false;
        }
        TrackActivityInternalActionCheckers trackActivityInternalActionCheckers = (TrackActivityInternalActionCheckers) other;
        return Intrinsics3.areEqual(this.actionName, trackActivityInternalActionCheckers.actionName) && Intrinsics3.areEqual(this.phase, trackActivityInternalActionCheckers.phase) && Intrinsics3.areEqual(this.moveType, trackActivityInternalActionCheckers.moveType) && Intrinsics3.areEqual(this.interestingMoveType, trackActivityInternalActionCheckers.interestingMoveType) && Intrinsics3.areEqual(this.lockedGame, trackActivityInternalActionCheckers.lockedGame) && Intrinsics3.areEqual(this.timedGame, trackActivityInternalActionCheckers.timedGame) && Intrinsics3.areEqual(this.againstBot, trackActivityInternalActionCheckers.againstBot) && Intrinsics3.areEqual(this.background, trackActivityInternalActionCheckers.background) && Intrinsics3.areEqual(this.pieceSet, trackActivityInternalActionCheckers.pieceSet) && Intrinsics3.areEqual(this.numSpectators, trackActivityInternalActionCheckers.numSpectators) && Intrinsics3.areEqual(this.playerColor, trackActivityInternalActionCheckers.playerColor) && Intrinsics3.areEqual(this.lastScreen, trackActivityInternalActionCheckers.lastScreen) && Intrinsics3.areEqual(this.jumpCount, trackActivityInternalActionCheckers.jumpCount) && Intrinsics3.areEqual(this.reconnectTime, trackActivityInternalActionCheckers.reconnectTime);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.phase;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.moveType;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.interestingMoveType;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool = this.lockedGame;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.timedGame;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.againstBot;
        int iHashCode7 = (iHashCode6 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.background;
        int iHashCode8 = (iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.pieceSet;
        int iHashCode9 = (iHashCode8 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Long l = this.numSpectators;
        int iHashCode10 = (iHashCode9 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.playerColor;
        int iHashCode11 = (iHashCode10 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.lastScreen;
        int iHashCode12 = (iHashCode11 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        Long l2 = this.jumpCount;
        int iHashCode13 = (iHashCode12 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.reconnectTime;
        return iHashCode13 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalActionCheckers(actionName=");
        sbU.append(this.actionName);
        sbU.append(", phase=");
        sbU.append(this.phase);
        sbU.append(", moveType=");
        sbU.append(this.moveType);
        sbU.append(", interestingMoveType=");
        sbU.append(this.interestingMoveType);
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
        sbU.append(", jumpCount=");
        sbU.append(this.jumpCount);
        sbU.append(", reconnectTime=");
        return outline.G(sbU, this.reconnectTime, ")");
    }
}
