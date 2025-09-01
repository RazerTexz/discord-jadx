package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackRegisterViewed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010\"\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013R\u001b\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010)\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+R\u001b\u0010,\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010&\u001a\u0004\b-\u0010(R\u001b\u0010.\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010&\u001a\u0004\b/\u0010(R\u001c\u00100\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0006R\u001b\u00103\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010&\u001a\u0004\b4\u0010(¨\u00065"}, d2 = {"Lcom/discord/analytics/generated/events/TrackRegisterViewed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "registrationSource", "Ljava/lang/CharSequence;", "getRegistrationSource", "()Ljava/lang/CharSequence;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;", "trackStoreSkuMetadata", "Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;", "getTrackStoreSkuMetadata", "()Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;", "setTrackStoreSkuMetadata", "(Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;)V", "inviteCode", "getInviteCode", "", "inviteGuildId", "Ljava/lang/Long;", "getInviteGuildId", "()Ljava/lang/Long;", "isUnclaimed", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "inviteChannelId", "getInviteChannelId", "inviteChannelType", "getInviteChannelType", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "inviteInviterId", "getInviteInviterId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackRegisterViewed implements AnalyticsSchema, TrackBase2, TrackStoreSkuMetadata2 {
    private TrackBase trackBase;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final CharSequence registrationSource = null;
    private final Boolean isUnclaimed = null;
    private final CharSequence inviteCode = null;
    private final Long inviteGuildId = null;
    private final Long inviteChannelId = null;
    private final Long inviteChannelType = null;
    private final Long inviteInviterId = null;
    private final transient String analyticsSchemaTypeName = "register_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRegisterViewed)) {
            return false;
        }
        TrackRegisterViewed trackRegisterViewed = (TrackRegisterViewed) other;
        return Intrinsics3.areEqual(this.registrationSource, trackRegisterViewed.registrationSource) && Intrinsics3.areEqual(this.isUnclaimed, trackRegisterViewed.isUnclaimed) && Intrinsics3.areEqual(this.inviteCode, trackRegisterViewed.inviteCode) && Intrinsics3.areEqual(this.inviteGuildId, trackRegisterViewed.inviteGuildId) && Intrinsics3.areEqual(this.inviteChannelId, trackRegisterViewed.inviteChannelId) && Intrinsics3.areEqual(this.inviteChannelType, trackRegisterViewed.inviteChannelType) && Intrinsics3.areEqual(this.inviteInviterId, trackRegisterViewed.inviteInviterId);
    }

    public int hashCode() {
        CharSequence charSequence = this.registrationSource;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.isUnclaimed;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.inviteCode;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.inviteGuildId;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.inviteChannelId;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.inviteChannelType;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.inviteInviterId;
        return iHashCode6 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRegisterViewed(registrationSource=");
        sbU.append(this.registrationSource);
        sbU.append(", isUnclaimed=");
        sbU.append(this.isUnclaimed);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", inviteGuildId=");
        sbU.append(this.inviteGuildId);
        sbU.append(", inviteChannelId=");
        sbU.append(this.inviteChannelId);
        sbU.append(", inviteChannelType=");
        sbU.append(this.inviteChannelType);
        sbU.append(", inviteInviterId=");
        return outline.G(sbU, this.inviteInviterId, ")");
    }
}
