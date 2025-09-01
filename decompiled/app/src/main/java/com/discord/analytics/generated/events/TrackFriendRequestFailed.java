package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSite2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackFriendRequestFailed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0006R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019R\u001b\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u001b\u0010#\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b#\u0010\u0011R$\u0010%\u001a\u0004\u0018\u00010$8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u0010+\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0010\u001a\u0004\b+\u0010\u0011R\u001b\u0010,\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0017\u001a\u0004\b-\u0010\u0019R\u001b\u0010.\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u001c\u001a\u0004\b/\u0010\u001eR$\u00101\u001a\u0004\u0018\u0001008\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001b\u00107\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u001c\u001a\u0004\b8\u0010\u001e¨\u00069"}, d2 = {"Lcom/discord/analytics/generated/events/TrackFriendRequestFailed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackMarketingSiteReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "isInviteLike", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "", "discriminator", "Ljava/lang/Long;", "getDiscriminator", "()Ljava/lang/Long;", "", "username", "Ljava/lang/CharSequence;", "getUsername", "()Ljava/lang/CharSequence;", "usernameLen", "getUsernameLen", NotificationCompat.CATEGORY_EMAIL, "getEmail", "isEmailLike", "Lcom/discord/analytics/generated/traits/TrackMarketingSite;", "trackMarketingSite", "Lcom/discord/analytics/generated/traits/TrackMarketingSite;", "getTrackMarketingSite", "()Lcom/discord/analytics/generated/traits/TrackMarketingSite;", "setTrackMarketingSite", "(Lcom/discord/analytics/generated/traits/TrackMarketingSite;)V", "isNumOnly", "discrimLen", "getDiscrimLen", ModelAuditLogEntry.CHANGE_KEY_REASON, "getReason", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "query", "getQuery", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackFriendRequestFailed implements AnalyticsSchema, TrackBase2, TrackMarketingSite2 {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final Long discriminator = null;
    private final CharSequence email = null;
    private final CharSequence reason = null;
    private final CharSequence username = null;
    private final Long discrimLen = null;
    private final Long usernameLen = null;
    private final Boolean isEmailLike = null;
    private final Boolean isInviteLike = null;
    private final Boolean isNumOnly = null;
    private final CharSequence query = null;
    private final transient String analyticsSchemaTypeName = "friend_request_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackFriendRequestFailed)) {
            return false;
        }
        TrackFriendRequestFailed trackFriendRequestFailed = (TrackFriendRequestFailed) other;
        return Intrinsics3.areEqual(this.discriminator, trackFriendRequestFailed.discriminator) && Intrinsics3.areEqual(this.email, trackFriendRequestFailed.email) && Intrinsics3.areEqual(this.reason, trackFriendRequestFailed.reason) && Intrinsics3.areEqual(this.username, trackFriendRequestFailed.username) && Intrinsics3.areEqual(this.discrimLen, trackFriendRequestFailed.discrimLen) && Intrinsics3.areEqual(this.usernameLen, trackFriendRequestFailed.usernameLen) && Intrinsics3.areEqual(this.isEmailLike, trackFriendRequestFailed.isEmailLike) && Intrinsics3.areEqual(this.isInviteLike, trackFriendRequestFailed.isInviteLike) && Intrinsics3.areEqual(this.isNumOnly, trackFriendRequestFailed.isNumOnly) && Intrinsics3.areEqual(this.query, trackFriendRequestFailed.query);
    }

    public int hashCode() {
        Long l = this.discriminator;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.email;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.reason;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.username;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l2 = this.discrimLen;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.usernameLen;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.isEmailLike;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isInviteLike;
        int iHashCode8 = (iHashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isNumOnly;
        int iHashCode9 = (iHashCode8 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.query;
        return iHashCode9 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackFriendRequestFailed(discriminator=");
        sbU.append(this.discriminator);
        sbU.append(", email=");
        sbU.append(this.email);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", username=");
        sbU.append(this.username);
        sbU.append(", discrimLen=");
        sbU.append(this.discrimLen);
        sbU.append(", usernameLen=");
        sbU.append(this.usernameLen);
        sbU.append(", isEmailLike=");
        sbU.append(this.isEmailLike);
        sbU.append(", isInviteLike=");
        sbU.append(this.isInviteLike);
        sbU.append(", isNumOnly=");
        sbU.append(this.isNumOnly);
        sbU.append(", query=");
        return outline.E(sbU, this.query, ")");
    }
}
