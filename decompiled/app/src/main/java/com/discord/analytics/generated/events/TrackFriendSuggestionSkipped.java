package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackFriendSuggestionSkipped.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0015R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0015R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0005R\u001b\u0010.\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0014\u001a\u0004\b/\u0010\u0015R\u001b\u00100\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0014\u001a\u0004\b1\u0010\u0015R\u001b\u00102\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0010\u001a\u0004\b3\u0010\u0012¨\u00064"}, d2 = {"Lcom/discord/analytics/generated/events/TrackFriendSuggestionSkipped;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "suggestedUserId", "Ljava/lang/Long;", "getSuggestedUserId", "()Ljava/lang/Long;", "isReverseSuggestion", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "existingRelationshipType", "getExistingRelationshipType", "userIsDiscoverable", "getUserIsDiscoverable", "otherUserDiscoverable", "getOtherUserDiscoverable", "otherUserAllowedInSuggestions", "getOtherUserAllowedInSuggestions", "isNonMutual", "", "platformType", "Ljava/lang/CharSequence;", "getPlatformType", "()Ljava/lang/CharSequence;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "userConsents", "getUserConsents", "otherUserConsents", "getOtherUserConsents", "userAllowedInSuggestions", "getUserAllowedInSuggestions", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackFriendSuggestionSkipped implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long suggestedUserId = null;
    private final CharSequence platformType = null;
    private final Boolean isNonMutual = null;
    private final Boolean isReverseSuggestion = null;
    private final Long existingRelationshipType = null;
    private final Long userAllowedInSuggestions = null;
    private final Boolean userConsents = null;
    private final Boolean userIsDiscoverable = null;
    private final Long otherUserAllowedInSuggestions = null;
    private final Boolean otherUserConsents = null;
    private final Boolean otherUserDiscoverable = null;
    private final transient String analyticsSchemaTypeName = "friend_suggestion_skipped";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackFriendSuggestionSkipped)) {
            return false;
        }
        TrackFriendSuggestionSkipped trackFriendSuggestionSkipped = (TrackFriendSuggestionSkipped) other;
        return Intrinsics3.areEqual(this.suggestedUserId, trackFriendSuggestionSkipped.suggestedUserId) && Intrinsics3.areEqual(this.platformType, trackFriendSuggestionSkipped.platformType) && Intrinsics3.areEqual(this.isNonMutual, trackFriendSuggestionSkipped.isNonMutual) && Intrinsics3.areEqual(this.isReverseSuggestion, trackFriendSuggestionSkipped.isReverseSuggestion) && Intrinsics3.areEqual(this.existingRelationshipType, trackFriendSuggestionSkipped.existingRelationshipType) && Intrinsics3.areEqual(this.userAllowedInSuggestions, trackFriendSuggestionSkipped.userAllowedInSuggestions) && Intrinsics3.areEqual(this.userConsents, trackFriendSuggestionSkipped.userConsents) && Intrinsics3.areEqual(this.userIsDiscoverable, trackFriendSuggestionSkipped.userIsDiscoverable) && Intrinsics3.areEqual(this.otherUserAllowedInSuggestions, trackFriendSuggestionSkipped.otherUserAllowedInSuggestions) && Intrinsics3.areEqual(this.otherUserConsents, trackFriendSuggestionSkipped.otherUserConsents) && Intrinsics3.areEqual(this.otherUserDiscoverable, trackFriendSuggestionSkipped.otherUserDiscoverable);
    }

    public int hashCode() {
        Long l = this.suggestedUserId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.platformType;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.isNonMutual;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isReverseSuggestion;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l2 = this.existingRelationshipType;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.userAllowedInSuggestions;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool3 = this.userConsents;
        int iHashCode7 = (iHashCode6 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.userIsDiscoverable;
        int iHashCode8 = (iHashCode7 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l4 = this.otherUserAllowedInSuggestions;
        int iHashCode9 = (iHashCode8 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool5 = this.otherUserConsents;
        int iHashCode10 = (iHashCode9 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.otherUserDiscoverable;
        return iHashCode10 + (bool6 != null ? bool6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackFriendSuggestionSkipped(suggestedUserId=");
        sbU.append(this.suggestedUserId);
        sbU.append(", platformType=");
        sbU.append(this.platformType);
        sbU.append(", isNonMutual=");
        sbU.append(this.isNonMutual);
        sbU.append(", isReverseSuggestion=");
        sbU.append(this.isReverseSuggestion);
        sbU.append(", existingRelationshipType=");
        sbU.append(this.existingRelationshipType);
        sbU.append(", userAllowedInSuggestions=");
        sbU.append(this.userAllowedInSuggestions);
        sbU.append(", userConsents=");
        sbU.append(this.userConsents);
        sbU.append(", userIsDiscoverable=");
        sbU.append(this.userIsDiscoverable);
        sbU.append(", otherUserAllowedInSuggestions=");
        sbU.append(this.otherUserAllowedInSuggestions);
        sbU.append(", otherUserConsents=");
        sbU.append(this.otherUserConsents);
        sbU.append(", otherUserDiscoverable=");
        return outline.D(sbU, this.otherUserDiscoverable, ")");
    }
}
