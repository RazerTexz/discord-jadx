package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackActivityUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011R\u001b\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001dR\u001b\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R\u001b\u0010$\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018R\u001b\u0010&\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R\u001c\u0010(\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0005R$\u0010,\u001a\u0004\u0018\u00010+8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001b\u00102\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0016\u001a\u0004\b3\u0010\u0018R\u001b\u00104\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u001b\u001a\u0004\b5\u0010\u001dR\u001b\u00106\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u0016\u001a\u0004\b7\u0010\u0018¨\u00068"}, d2 = {"Lcom/discord/analytics/generated/events/TrackActivityUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hasJoinSecret", "Ljava/lang/Boolean;", "getHasJoinSecret", "()Ljava/lang/Boolean;", "hasSpectateSecret", "getHasSpectateSecret", "", "activitySessionId", "Ljava/lang/CharSequence;", "getActivitySessionId", "()Ljava/lang/CharSequence;", "", "applicationId", "Ljava/lang/Long;", "getApplicationId", "()Ljava/lang/Long;", "hasImages", "getHasImages", "partyMax", "getPartyMax", "hasMatchSecret", "getHasMatchSecret", "trackId", "getTrackId", "partyPlatform", "getPartyPlatform", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "partyId", "getPartyId", "type", "getType", "platform", "getPlatform", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackActivityUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Boolean hasMatchSecret = null;
    private final Boolean hasSpectateSecret = null;
    private final Boolean hasJoinSecret = null;
    private final Boolean hasImages = null;
    private final Long partyMax = null;
    private final CharSequence partyId = null;
    private final CharSequence platform = null;
    private final CharSequence partyPlatform = null;
    private final CharSequence trackId = null;
    private final Long type = null;
    private final CharSequence activitySessionId = null;
    private final transient String analyticsSchemaTypeName = "activity_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityUpdated)) {
            return false;
        }
        TrackActivityUpdated trackActivityUpdated = (TrackActivityUpdated) other;
        return Intrinsics3.areEqual(this.applicationId, trackActivityUpdated.applicationId) && Intrinsics3.areEqual(this.hasMatchSecret, trackActivityUpdated.hasMatchSecret) && Intrinsics3.areEqual(this.hasSpectateSecret, trackActivityUpdated.hasSpectateSecret) && Intrinsics3.areEqual(this.hasJoinSecret, trackActivityUpdated.hasJoinSecret) && Intrinsics3.areEqual(this.hasImages, trackActivityUpdated.hasImages) && Intrinsics3.areEqual(this.partyMax, trackActivityUpdated.partyMax) && Intrinsics3.areEqual(this.partyId, trackActivityUpdated.partyId) && Intrinsics3.areEqual(this.platform, trackActivityUpdated.platform) && Intrinsics3.areEqual(this.partyPlatform, trackActivityUpdated.partyPlatform) && Intrinsics3.areEqual(this.trackId, trackActivityUpdated.trackId) && Intrinsics3.areEqual(this.type, trackActivityUpdated.type) && Intrinsics3.areEqual(this.activitySessionId, trackActivityUpdated.activitySessionId);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Boolean bool = this.hasMatchSecret;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasSpectateSecret;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.hasJoinSecret;
        int iHashCode4 = (iHashCode3 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.hasImages;
        int iHashCode5 = (iHashCode4 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l2 = this.partyMax;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.partyId;
        int iHashCode7 = (iHashCode6 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.platform;
        int iHashCode8 = (iHashCode7 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.partyPlatform;
        int iHashCode9 = (iHashCode8 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.trackId;
        int iHashCode10 = (iHashCode9 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.type;
        int iHashCode11 = (iHashCode10 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.activitySessionId;
        return iHashCode11 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityUpdated(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", hasMatchSecret=");
        sbU.append(this.hasMatchSecret);
        sbU.append(", hasSpectateSecret=");
        sbU.append(this.hasSpectateSecret);
        sbU.append(", hasJoinSecret=");
        sbU.append(this.hasJoinSecret);
        sbU.append(", hasImages=");
        sbU.append(this.hasImages);
        sbU.append(", partyMax=");
        sbU.append(this.partyMax);
        sbU.append(", partyId=");
        sbU.append(this.partyId);
        sbU.append(", platform=");
        sbU.append(this.platform);
        sbU.append(", partyPlatform=");
        sbU.append(this.partyPlatform);
        sbU.append(", trackId=");
        sbU.append(this.trackId);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", activitySessionId=");
        return outline.E(sbU, this.activitySessionId, ")");
    }
}
