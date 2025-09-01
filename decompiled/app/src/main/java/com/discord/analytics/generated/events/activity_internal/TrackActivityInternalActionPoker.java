package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackActivityInternalActionPoker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0013R\u001b\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010&\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013R$\u0010)\u001a\u0004\u0018\u00010(8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001b\u0010/\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010#\u001a\u0004\b0\u0010%R\u001b\u00101\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001b\u00105\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0011\u001a\u0004\b6\u0010\u0013R\u001b\u00107\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010#\u001a\u0004\b8\u0010%R\u001b\u00109\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010#\u001a\u0004\b:\u0010%R\u001b\u0010;\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u0011\u001a\u0004\b<\u0010\u0013R\u001b\u0010=\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010#\u001a\u0004\b>\u0010%R\u001b\u0010?\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010\u0011\u001a\u0004\b@\u0010\u0013R\u001c\u0010A\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010\u0006R\u001b\u0010D\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010\u0011\u001a\u0004\bE\u0010\u0013R\u001b\u0010F\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010\u0011\u001a\u0004\bG\u0010\u0013¨\u0006H"}, d2 = {"Lcom/discord/analytics/generated/events/activity_internal/TrackActivityInternalActionPoker;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "tableRank", "Ljava/lang/Long;", "getTableRank", "()Ljava/lang/Long;", "betAmount", "getBetAmount", "winnings", "getWinnings", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "trackActivityInternalMetadata", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "getTrackActivityInternalMetadata", "()Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "setTrackActivityInternalMetadata", "(Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;)V", "turnDurationS", "getTurnDurationS", "", "phase", "Ljava/lang/CharSequence;", "getPhase", "()Ljava/lang/CharSequence;", "potSize", "getPotSize", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "cosmeticId", "getCosmeticId", "cosmeticLocked", "Ljava/lang/Boolean;", "getCosmeticLocked", "()Ljava/lang/Boolean;", "numPlayers", "getNumPlayers", "cosmeticType", "getCosmeticType", "betAction", "getBetAction", "startingWallet", "getStartingWallet", "actionName", "getActionName", "numBots", "getNumBots", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "currentWallet", "getCurrentWallet", "numSpectators", "getNumSpectators", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalActionPoker implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final Long numBots = null;
    private final Long numPlayers = null;
    private final Long numSpectators = null;
    private final CharSequence phase = null;
    private final Long turnDurationS = null;
    private final CharSequence betAction = null;
    private final Long betAmount = null;
    private final Long winnings = null;
    private final Long startingWallet = null;
    private final Long currentWallet = null;
    private final Long potSize = null;
    private final Long tableRank = null;
    private final CharSequence cosmeticType = null;
    private final CharSequence cosmeticId = null;
    private final Boolean cosmeticLocked = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_action_poker";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalActionPoker)) {
            return false;
        }
        TrackActivityInternalActionPoker trackActivityInternalActionPoker = (TrackActivityInternalActionPoker) other;
        return Intrinsics3.areEqual(this.actionName, trackActivityInternalActionPoker.actionName) && Intrinsics3.areEqual(this.numBots, trackActivityInternalActionPoker.numBots) && Intrinsics3.areEqual(this.numPlayers, trackActivityInternalActionPoker.numPlayers) && Intrinsics3.areEqual(this.numSpectators, trackActivityInternalActionPoker.numSpectators) && Intrinsics3.areEqual(this.phase, trackActivityInternalActionPoker.phase) && Intrinsics3.areEqual(this.turnDurationS, trackActivityInternalActionPoker.turnDurationS) && Intrinsics3.areEqual(this.betAction, trackActivityInternalActionPoker.betAction) && Intrinsics3.areEqual(this.betAmount, trackActivityInternalActionPoker.betAmount) && Intrinsics3.areEqual(this.winnings, trackActivityInternalActionPoker.winnings) && Intrinsics3.areEqual(this.startingWallet, trackActivityInternalActionPoker.startingWallet) && Intrinsics3.areEqual(this.currentWallet, trackActivityInternalActionPoker.currentWallet) && Intrinsics3.areEqual(this.potSize, trackActivityInternalActionPoker.potSize) && Intrinsics3.areEqual(this.tableRank, trackActivityInternalActionPoker.tableRank) && Intrinsics3.areEqual(this.cosmeticType, trackActivityInternalActionPoker.cosmeticType) && Intrinsics3.areEqual(this.cosmeticId, trackActivityInternalActionPoker.cosmeticId) && Intrinsics3.areEqual(this.cosmeticLocked, trackActivityInternalActionPoker.cosmeticLocked);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.numBots;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numPlayers;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numSpectators;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.phase;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l4 = this.turnDurationS;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.betAction;
        int iHashCode7 = (iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l5 = this.betAmount;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.winnings;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.startingWallet;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.currentWallet;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.potSize;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.tableRank;
        int iHashCode13 = (iHashCode12 + (l10 != null ? l10.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.cosmeticType;
        int iHashCode14 = (iHashCode13 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.cosmeticId;
        int iHashCode15 = (iHashCode14 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Boolean bool = this.cosmeticLocked;
        return iHashCode15 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalActionPoker(actionName=");
        sbU.append(this.actionName);
        sbU.append(", numBots=");
        sbU.append(this.numBots);
        sbU.append(", numPlayers=");
        sbU.append(this.numPlayers);
        sbU.append(", numSpectators=");
        sbU.append(this.numSpectators);
        sbU.append(", phase=");
        sbU.append(this.phase);
        sbU.append(", turnDurationS=");
        sbU.append(this.turnDurationS);
        sbU.append(", betAction=");
        sbU.append(this.betAction);
        sbU.append(", betAmount=");
        sbU.append(this.betAmount);
        sbU.append(", winnings=");
        sbU.append(this.winnings);
        sbU.append(", startingWallet=");
        sbU.append(this.startingWallet);
        sbU.append(", currentWallet=");
        sbU.append(this.currentWallet);
        sbU.append(", potSize=");
        sbU.append(this.potSize);
        sbU.append(", tableRank=");
        sbU.append(this.tableRank);
        sbU.append(", cosmeticType=");
        sbU.append(this.cosmeticType);
        sbU.append(", cosmeticId=");
        sbU.append(this.cosmeticId);
        sbU.append(", cosmeticLocked=");
        return outline.D(sbU, this.cosmeticLocked, ")");
    }
}
