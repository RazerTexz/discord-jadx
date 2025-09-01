package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackQuickswitcherClosed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0007\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u0017R\u001b\u0010#\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017R\u001b\u0010%\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'R\u001b\u0010(\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b)\u0010\u0017R\u001b\u0010*\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0015\u001a\u0004\b+\u0010\u0017R\u001c\u0010,\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0005R\u001b\u0010/\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010\u0012R\u001b\u00101\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0015\u001a\u0004\b2\u0010\u0017R\u001b\u00103\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b4\u0010\u0012R\u001b\u00105\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010&\u001a\u0004\b5\u0010'R\u001b\u00106\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u0010\u001a\u0004\b7\u0010\u0012R\u001b\u00108\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u0015\u001a\u0004\b9\u0010\u0017R\u001b\u0010:\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u0015\u001a\u0004\b;\u0010\u0017R\u001b\u0010<\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0015\u001a\u0004\b=\u0010\u0017R\u001b\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001b\u0010C\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010\u0015\u001a\u0004\bD\u0010\u0017R\u001b\u0010E\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010\u0015\u001a\u0004\bF\u0010\u0017R\u001b\u0010G\u001a\u0004\u0018\u00010>8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010@\u001a\u0004\bH\u0010BR\u001b\u0010I\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010\u0015\u001a\u0004\bJ\u0010\u0017R\u001b\u0010K\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010&\u001a\u0004\bK\u0010'R\u001b\u0010L\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010\u0015\u001a\u0004\bM\u0010\u0017R\u001b\u0010N\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010\u0015\u001a\u0004\bO\u0010\u0017¨\u0006P"}, d2 = {"Lcom/discord/analytics/generated/events/TrackQuickswitcherClosed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "queryMode", "Ljava/lang/CharSequence;", "getQueryMode", "()Ljava/lang/CharSequence;", "", "numResultsGroupDms", "Ljava/lang/Long;", "getNumResultsGroupDms", "()Ljava/lang/Long;", "numResultsTextChannels", "getNumResultsTextChannels", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "selectedUserId", "getSelectedUserId", "currentChannelType", "getCurrentChannelType", "isPhoneLike", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "selectedIndex", "getSelectedIndex", "selectedChannelId", "getSelectedChannelId", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "selectedType", "getSelectedType", "selectedGuildId", "getSelectedGuildId", "topResultType", "getTopResultType", "isEmailLike", "query", "getQuery", "currentGuildId", "getCurrentGuildId", "numResultsTotal", "getNumResultsTotal", "numResultsVoiceChannels", "getNumResultsVoiceChannels", "", "topResultScore", "Ljava/lang/Float;", "getTopResultScore", "()Ljava/lang/Float;", "numResultsGuilds", "getNumResultsGuilds", "queryLength", "getQueryLength", "selectedScore", "getSelectedScore", "maxQueryLength", "getMaxQueryLength", "isUsernameLike", "numResultsUsers", "getNumResultsUsers", "currentChannelId", "getCurrentChannelId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackQuickswitcherClosed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long currentChannelId = null;
    private final Long currentChannelType = null;
    private final Long currentGuildId = null;
    private final CharSequence queryMode = null;
    private final Long queryLength = null;
    private final Long maxQueryLength = null;
    private final CharSequence topResultType = null;
    private final Float topResultScore = null;
    private final Long numResultsTotal = null;
    private final Long numResultsUsers = null;
    private final Long numResultsTextChannels = null;
    private final Long numResultsVoiceChannels = null;
    private final Long numResultsGuilds = null;
    private final Long numResultsGroupDms = null;
    private final CharSequence selectedType = null;
    private final Float selectedScore = null;
    private final Long selectedIndex = null;
    private final Long selectedGuildId = null;
    private final Long selectedChannelId = null;
    private final Long selectedUserId = null;
    private final Boolean isEmailLike = null;
    private final Boolean isPhoneLike = null;
    private final Boolean isUsernameLike = null;
    private final CharSequence query = null;
    private final transient String analyticsSchemaTypeName = "quickswitcher_closed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackQuickswitcherClosed)) {
            return false;
        }
        TrackQuickswitcherClosed trackQuickswitcherClosed = (TrackQuickswitcherClosed) other;
        return Intrinsics3.areEqual(this.currentChannelId, trackQuickswitcherClosed.currentChannelId) && Intrinsics3.areEqual(this.currentChannelType, trackQuickswitcherClosed.currentChannelType) && Intrinsics3.areEqual(this.currentGuildId, trackQuickswitcherClosed.currentGuildId) && Intrinsics3.areEqual(this.queryMode, trackQuickswitcherClosed.queryMode) && Intrinsics3.areEqual(this.queryLength, trackQuickswitcherClosed.queryLength) && Intrinsics3.areEqual(this.maxQueryLength, trackQuickswitcherClosed.maxQueryLength) && Intrinsics3.areEqual(this.topResultType, trackQuickswitcherClosed.topResultType) && Intrinsics3.areEqual(this.topResultScore, trackQuickswitcherClosed.topResultScore) && Intrinsics3.areEqual(this.numResultsTotal, trackQuickswitcherClosed.numResultsTotal) && Intrinsics3.areEqual(this.numResultsUsers, trackQuickswitcherClosed.numResultsUsers) && Intrinsics3.areEqual(this.numResultsTextChannels, trackQuickswitcherClosed.numResultsTextChannels) && Intrinsics3.areEqual(this.numResultsVoiceChannels, trackQuickswitcherClosed.numResultsVoiceChannels) && Intrinsics3.areEqual(this.numResultsGuilds, trackQuickswitcherClosed.numResultsGuilds) && Intrinsics3.areEqual(this.numResultsGroupDms, trackQuickswitcherClosed.numResultsGroupDms) && Intrinsics3.areEqual(this.selectedType, trackQuickswitcherClosed.selectedType) && Intrinsics3.areEqual(this.selectedScore, trackQuickswitcherClosed.selectedScore) && Intrinsics3.areEqual(this.selectedIndex, trackQuickswitcherClosed.selectedIndex) && Intrinsics3.areEqual(this.selectedGuildId, trackQuickswitcherClosed.selectedGuildId) && Intrinsics3.areEqual(this.selectedChannelId, trackQuickswitcherClosed.selectedChannelId) && Intrinsics3.areEqual(this.selectedUserId, trackQuickswitcherClosed.selectedUserId) && Intrinsics3.areEqual(this.isEmailLike, trackQuickswitcherClosed.isEmailLike) && Intrinsics3.areEqual(this.isPhoneLike, trackQuickswitcherClosed.isPhoneLike) && Intrinsics3.areEqual(this.isUsernameLike, trackQuickswitcherClosed.isUsernameLike) && Intrinsics3.areEqual(this.query, trackQuickswitcherClosed.query);
    }

    public int hashCode() {
        Long l = this.currentChannelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.currentChannelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.currentGuildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.queryMode;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l4 = this.queryLength;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.maxQueryLength;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.topResultType;
        int iHashCode7 = (iHashCode6 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Float f = this.topResultScore;
        int iHashCode8 = (iHashCode7 + (f != null ? f.hashCode() : 0)) * 31;
        Long l6 = this.numResultsTotal;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.numResultsUsers;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.numResultsTextChannels;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.numResultsVoiceChannels;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.numResultsGuilds;
        int iHashCode13 = (iHashCode12 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.numResultsGroupDms;
        int iHashCode14 = (iHashCode13 + (l11 != null ? l11.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.selectedType;
        int iHashCode15 = (iHashCode14 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Float f2 = this.selectedScore;
        int iHashCode16 = (iHashCode15 + (f2 != null ? f2.hashCode() : 0)) * 31;
        Long l12 = this.selectedIndex;
        int iHashCode17 = (iHashCode16 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.selectedGuildId;
        int iHashCode18 = (iHashCode17 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.selectedChannelId;
        int iHashCode19 = (iHashCode18 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.selectedUserId;
        int iHashCode20 = (iHashCode19 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Boolean bool = this.isEmailLike;
        int iHashCode21 = (iHashCode20 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isPhoneLike;
        int iHashCode22 = (iHashCode21 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isUsernameLike;
        int iHashCode23 = (iHashCode22 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.query;
        return iHashCode23 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackQuickswitcherClosed(currentChannelId=");
        sbU.append(this.currentChannelId);
        sbU.append(", currentChannelType=");
        sbU.append(this.currentChannelType);
        sbU.append(", currentGuildId=");
        sbU.append(this.currentGuildId);
        sbU.append(", queryMode=");
        sbU.append(this.queryMode);
        sbU.append(", queryLength=");
        sbU.append(this.queryLength);
        sbU.append(", maxQueryLength=");
        sbU.append(this.maxQueryLength);
        sbU.append(", topResultType=");
        sbU.append(this.topResultType);
        sbU.append(", topResultScore=");
        sbU.append(this.topResultScore);
        sbU.append(", numResultsTotal=");
        sbU.append(this.numResultsTotal);
        sbU.append(", numResultsUsers=");
        sbU.append(this.numResultsUsers);
        sbU.append(", numResultsTextChannels=");
        sbU.append(this.numResultsTextChannels);
        sbU.append(", numResultsVoiceChannels=");
        sbU.append(this.numResultsVoiceChannels);
        sbU.append(", numResultsGuilds=");
        sbU.append(this.numResultsGuilds);
        sbU.append(", numResultsGroupDms=");
        sbU.append(this.numResultsGroupDms);
        sbU.append(", selectedType=");
        sbU.append(this.selectedType);
        sbU.append(", selectedScore=");
        sbU.append(this.selectedScore);
        sbU.append(", selectedIndex=");
        sbU.append(this.selectedIndex);
        sbU.append(", selectedGuildId=");
        sbU.append(this.selectedGuildId);
        sbU.append(", selectedChannelId=");
        sbU.append(this.selectedChannelId);
        sbU.append(", selectedUserId=");
        sbU.append(this.selectedUserId);
        sbU.append(", isEmailLike=");
        sbU.append(this.isEmailLike);
        sbU.append(", isPhoneLike=");
        sbU.append(this.isPhoneLike);
        sbU.append(", isUsernameLike=");
        sbU.append(this.isUsernameLike);
        sbU.append(", query=");
        return outline.E(sbU, this.query, ")");
    }
}
