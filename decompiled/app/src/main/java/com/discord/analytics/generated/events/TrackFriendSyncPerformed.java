package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackFriendSyncPerformed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u001c\u0010\u001b\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012R\u001b\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010\u0012R\u001b\u0010'\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010\u0012R\u001b\u0010)\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u0010-\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010*\u001a\u0004\b-\u0010,R$\u0010/\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/discord/analytics/generated/events/TrackFriendSyncPerformed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "uploadedContactsLength", "Ljava/lang/Long;", "getUploadedContactsLength", "()Ljava/lang/Long;", "externalFriendListLength", "getExternalFriendListLength", "numExternalFriendsAdded", "getNumExternalFriendsAdded", "numSuggestionsMutual", "getNumSuggestionsMutual", "numReverseSuggestionsMutual", "getNumReverseSuggestionsMutual", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "numSuggestionsNonmutual", "getNumSuggestionsNonmutual", "", "platformType", "Ljava/lang/CharSequence;", "getPlatformType", "()Ljava/lang/CharSequence;", "numReverseSuggestionsNonmutual", "getNumReverseSuggestionsNonmutual", "numExternalFriendsRemoved", "getNumExternalFriendsRemoved", "friendSyncEnabled", "Ljava/lang/Boolean;", "getFriendSyncEnabled", "()Ljava/lang/Boolean;", "isBackgroundSync", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackFriendSyncPerformed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean isBackgroundSync = null;
    private final CharSequence platformType = null;
    private final Long numExternalFriendsAdded = null;
    private final Long numExternalFriendsRemoved = null;
    private final Long numSuggestionsMutual = null;
    private final Long numReverseSuggestionsMutual = null;
    private final Long numSuggestionsNonmutual = null;
    private final Long numReverseSuggestionsNonmutual = null;
    private final Long uploadedContactsLength = null;
    private final Long externalFriendListLength = null;
    private final Boolean friendSyncEnabled = null;
    private final transient String analyticsSchemaTypeName = "friend_sync_performed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackFriendSyncPerformed)) {
            return false;
        }
        TrackFriendSyncPerformed trackFriendSyncPerformed = (TrackFriendSyncPerformed) other;
        return Intrinsics3.areEqual(this.isBackgroundSync, trackFriendSyncPerformed.isBackgroundSync) && Intrinsics3.areEqual(this.platformType, trackFriendSyncPerformed.platformType) && Intrinsics3.areEqual(this.numExternalFriendsAdded, trackFriendSyncPerformed.numExternalFriendsAdded) && Intrinsics3.areEqual(this.numExternalFriendsRemoved, trackFriendSyncPerformed.numExternalFriendsRemoved) && Intrinsics3.areEqual(this.numSuggestionsMutual, trackFriendSyncPerformed.numSuggestionsMutual) && Intrinsics3.areEqual(this.numReverseSuggestionsMutual, trackFriendSyncPerformed.numReverseSuggestionsMutual) && Intrinsics3.areEqual(this.numSuggestionsNonmutual, trackFriendSyncPerformed.numSuggestionsNonmutual) && Intrinsics3.areEqual(this.numReverseSuggestionsNonmutual, trackFriendSyncPerformed.numReverseSuggestionsNonmutual) && Intrinsics3.areEqual(this.uploadedContactsLength, trackFriendSyncPerformed.uploadedContactsLength) && Intrinsics3.areEqual(this.externalFriendListLength, trackFriendSyncPerformed.externalFriendListLength) && Intrinsics3.areEqual(this.friendSyncEnabled, trackFriendSyncPerformed.friendSyncEnabled);
    }

    public int hashCode() {
        Boolean bool = this.isBackgroundSync;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.platformType;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l = this.numExternalFriendsAdded;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numExternalFriendsRemoved;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numSuggestionsMutual;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numReverseSuggestionsMutual;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numSuggestionsNonmutual;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.numReverseSuggestionsNonmutual;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.uploadedContactsLength;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.externalFriendListLength;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Boolean bool2 = this.friendSyncEnabled;
        return iHashCode10 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackFriendSyncPerformed(isBackgroundSync=");
        sbU.append(this.isBackgroundSync);
        sbU.append(", platformType=");
        sbU.append(this.platformType);
        sbU.append(", numExternalFriendsAdded=");
        sbU.append(this.numExternalFriendsAdded);
        sbU.append(", numExternalFriendsRemoved=");
        sbU.append(this.numExternalFriendsRemoved);
        sbU.append(", numSuggestionsMutual=");
        sbU.append(this.numSuggestionsMutual);
        sbU.append(", numReverseSuggestionsMutual=");
        sbU.append(this.numReverseSuggestionsMutual);
        sbU.append(", numSuggestionsNonmutual=");
        sbU.append(this.numSuggestionsNonmutual);
        sbU.append(", numReverseSuggestionsNonmutual=");
        sbU.append(this.numReverseSuggestionsNonmutual);
        sbU.append(", uploadedContactsLength=");
        sbU.append(this.uploadedContactsLength);
        sbU.append(", externalFriendListLength=");
        sbU.append(this.externalFriendListLength);
        sbU.append(", friendSyncEnabled=");
        return outline.D(sbU, this.friendSyncEnabled, ")");
    }
}
