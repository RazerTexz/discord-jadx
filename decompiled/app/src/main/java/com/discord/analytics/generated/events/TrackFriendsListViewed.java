package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackFriendsListViewed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0017\u0010\u0015R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012R\u001c\u0010\u001d\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u0010,\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0014\u001a\u0004\b-\u0010\u0015R\u001b\u0010.\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0010\u001a\u0004\b/\u0010\u0012¨\u00060"}, d2 = {"Lcom/discord/analytics/generated/events/TrackFriendsListViewed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "numFriends", "Ljava/lang/Long;", "getNumFriends", "()Ljava/lang/Long;", "isDiscoverableEmail", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "wasDismissed", "getWasDismissed", "isDiscoverablePhone", "numOutgoingRequests", "getNumOutgoingRequests", "numIncomingRequests", "getNumIncomingRequests", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "tabOpened", "Ljava/lang/CharSequence;", "getTabOpened", "()Ljava/lang/CharSequence;", "contactSyncIsEnabled", "getContactSyncIsEnabled", "numSuggestions", "getNumSuggestions", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackFriendsListViewed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence tabOpened = null;
    private final Long numFriends = null;
    private final Long numOutgoingRequests = null;
    private final Long numIncomingRequests = null;
    private final Long numSuggestions = null;
    private final Boolean wasDismissed = null;
    private final Boolean contactSyncIsEnabled = null;
    private final Boolean isDiscoverableEmail = null;
    private final Boolean isDiscoverablePhone = null;
    private final transient String analyticsSchemaTypeName = "friends_list_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackFriendsListViewed)) {
            return false;
        }
        TrackFriendsListViewed trackFriendsListViewed = (TrackFriendsListViewed) other;
        return Intrinsics3.areEqual(this.tabOpened, trackFriendsListViewed.tabOpened) && Intrinsics3.areEqual(this.numFriends, trackFriendsListViewed.numFriends) && Intrinsics3.areEqual(this.numOutgoingRequests, trackFriendsListViewed.numOutgoingRequests) && Intrinsics3.areEqual(this.numIncomingRequests, trackFriendsListViewed.numIncomingRequests) && Intrinsics3.areEqual(this.numSuggestions, trackFriendsListViewed.numSuggestions) && Intrinsics3.areEqual(this.wasDismissed, trackFriendsListViewed.wasDismissed) && Intrinsics3.areEqual(this.contactSyncIsEnabled, trackFriendsListViewed.contactSyncIsEnabled) && Intrinsics3.areEqual(this.isDiscoverableEmail, trackFriendsListViewed.isDiscoverableEmail) && Intrinsics3.areEqual(this.isDiscoverablePhone, trackFriendsListViewed.isDiscoverablePhone);
    }

    public int hashCode() {
        CharSequence charSequence = this.tabOpened;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.numFriends;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numOutgoingRequests;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numIncomingRequests;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numSuggestions;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool = this.wasDismissed;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.contactSyncIsEnabled;
        int iHashCode7 = (iHashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isDiscoverableEmail;
        int iHashCode8 = (iHashCode7 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.isDiscoverablePhone;
        return iHashCode8 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackFriendsListViewed(tabOpened=");
        sbU.append(this.tabOpened);
        sbU.append(", numFriends=");
        sbU.append(this.numFriends);
        sbU.append(", numOutgoingRequests=");
        sbU.append(this.numOutgoingRequests);
        sbU.append(", numIncomingRequests=");
        sbU.append(this.numIncomingRequests);
        sbU.append(", numSuggestions=");
        sbU.append(this.numSuggestions);
        sbU.append(", wasDismissed=");
        sbU.append(this.wasDismissed);
        sbU.append(", contactSyncIsEnabled=");
        sbU.append(this.contactSyncIsEnabled);
        sbU.append(", isDiscoverableEmail=");
        sbU.append(this.isDiscoverableEmail);
        sbU.append(", isDiscoverablePhone=");
        return outline.D(sbU, this.isDiscoverablePhone, ")");
    }
}
