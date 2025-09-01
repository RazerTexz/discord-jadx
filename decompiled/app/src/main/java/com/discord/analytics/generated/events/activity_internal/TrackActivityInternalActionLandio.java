package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackActivityInternalActionLandio.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0006R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001aR\u001b\u0010$\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001aR\u001b\u0010&\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001aR\u001b\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u0010-\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0018\u001a\u0004\b.\u0010\u001aR\u001b\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,R\u001b\u00101\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0018\u001a\u0004\b2\u0010\u001aR\u001b\u00103\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0018\u001a\u0004\b4\u0010\u001aR\u001b\u00105\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0018\u001a\u0004\b6\u0010\u001aR\u001b\u00107\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0018\u001a\u0004\b8\u0010\u001aR$\u0010:\u001a\u0004\u0018\u0001098\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001b\u0010@\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\u0018\u001a\u0004\bA\u0010\u001a¨\u0006B"}, d2 = {"Lcom/discord/analytics/generated/events/activity_internal/TrackActivityInternalActionLandio;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "toggleEnable", "Ljava/lang/Boolean;", "getToggleEnable", "()Ljava/lang/Boolean;", "", "turnClaimed", "Ljava/lang/Long;", "getTurnClaimed", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "ping", "getPing", "turnKills", "getTurnKills", "frame", "getFrame", "", "server", "Ljava/lang/CharSequence;", "getServer", "()Ljava/lang/CharSequence;", "numPlayers", "getNumPlayers", "actionName", "getActionName", "numVotesNo", "getNumVotesNo", "pingPeak", "getPingPeak", "framePeak", "getFramePeak", "numVotesYes", "getNumVotesYes", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "trackActivityInternalMetadata", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "getTrackActivityInternalMetadata", "()Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "setTrackActivityInternalMetadata", "(Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;)V", "turnLifespan", "getTurnLifespan", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalActionLandio implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final Long ping = null;
    private final CharSequence server = null;
    private final Long pingPeak = null;
    private final Long frame = null;
    private final Long framePeak = null;
    private final Long numPlayers = null;
    private final Long numVotesYes = null;
    private final Long numVotesNo = null;
    private final Long turnLifespan = null;
    private final Long turnKills = null;
    private final Long turnClaimed = null;
    private final Boolean toggleEnable = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_action_landio";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalActionLandio)) {
            return false;
        }
        TrackActivityInternalActionLandio trackActivityInternalActionLandio = (TrackActivityInternalActionLandio) other;
        return Intrinsics3.areEqual(this.actionName, trackActivityInternalActionLandio.actionName) && Intrinsics3.areEqual(this.ping, trackActivityInternalActionLandio.ping) && Intrinsics3.areEqual(this.server, trackActivityInternalActionLandio.server) && Intrinsics3.areEqual(this.pingPeak, trackActivityInternalActionLandio.pingPeak) && Intrinsics3.areEqual(this.frame, trackActivityInternalActionLandio.frame) && Intrinsics3.areEqual(this.framePeak, trackActivityInternalActionLandio.framePeak) && Intrinsics3.areEqual(this.numPlayers, trackActivityInternalActionLandio.numPlayers) && Intrinsics3.areEqual(this.numVotesYes, trackActivityInternalActionLandio.numVotesYes) && Intrinsics3.areEqual(this.numVotesNo, trackActivityInternalActionLandio.numVotesNo) && Intrinsics3.areEqual(this.turnLifespan, trackActivityInternalActionLandio.turnLifespan) && Intrinsics3.areEqual(this.turnKills, trackActivityInternalActionLandio.turnKills) && Intrinsics3.areEqual(this.turnClaimed, trackActivityInternalActionLandio.turnClaimed) && Intrinsics3.areEqual(this.toggleEnable, trackActivityInternalActionLandio.toggleEnable);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.ping;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.server;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l2 = this.pingPeak;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.frame;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.framePeak;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numPlayers;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.numVotesYes;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.numVotesNo;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.turnLifespan;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.turnKills;
        int iHashCode11 = (iHashCode10 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.turnClaimed;
        int iHashCode12 = (iHashCode11 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Boolean bool = this.toggleEnable;
        return iHashCode12 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalActionLandio(actionName=");
        sbU.append(this.actionName);
        sbU.append(", ping=");
        sbU.append(this.ping);
        sbU.append(", server=");
        sbU.append(this.server);
        sbU.append(", pingPeak=");
        sbU.append(this.pingPeak);
        sbU.append(", frame=");
        sbU.append(this.frame);
        sbU.append(", framePeak=");
        sbU.append(this.framePeak);
        sbU.append(", numPlayers=");
        sbU.append(this.numPlayers);
        sbU.append(", numVotesYes=");
        sbU.append(this.numVotesYes);
        sbU.append(", numVotesNo=");
        sbU.append(this.numVotesNo);
        sbU.append(", turnLifespan=");
        sbU.append(this.turnLifespan);
        sbU.append(", turnKills=");
        sbU.append(this.turnKills);
        sbU.append(", turnClaimed=");
        sbU.append(this.turnClaimed);
        sbU.append(", toggleEnable=");
        return outline.D(sbU, this.toggleEnable, ")");
    }
}
