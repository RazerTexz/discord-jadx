package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackRoleSubscriptionPurchaseSystemMessageCtaClicked.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B7\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b6\u00107J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0007¨\u00068"}, d2 = {"Lcom/discord/analytics/generated/events/TrackRoleSubscriptionPurchaseSystemMessageCtaClicked;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "e", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "", "messageId", "Ljava/lang/Long;", "getMessageId", "()Ljava/lang/Long;", NotificationCompat.MessagingStyle.Message.KEY_SENDER, "getSender", "targetUser", "getTargetUser", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "stickerId", "Ljava/lang/CharSequence;", "getStickerId", "()Ljava/lang/CharSequence;", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "<init>", "(Ljava/lang/Long;Ljava/lang/CharSequence;Ljava/lang/Long;Ljava/lang/Long;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackRoleSubscriptionPurchaseSystemMessageCtaClicked implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private final transient String analyticsSchemaTypeName;
    private final Long messageId;
    private final Long sender;
    private final CharSequence stickerId;
    private final Long targetUser;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;

    public TrackRoleSubscriptionPurchaseSystemMessageCtaClicked() {
        this.messageId = null;
        this.stickerId = null;
        this.targetUser = null;
        this.sender = null;
        this.analyticsSchemaTypeName = "role_subscription_purchase_system_message_cta_clicked";
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public void e(TrackChannel trackChannel) {
        this.trackChannel = trackChannel;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRoleSubscriptionPurchaseSystemMessageCtaClicked)) {
            return false;
        }
        TrackRoleSubscriptionPurchaseSystemMessageCtaClicked trackRoleSubscriptionPurchaseSystemMessageCtaClicked = (TrackRoleSubscriptionPurchaseSystemMessageCtaClicked) other;
        return Intrinsics3.areEqual(this.messageId, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.messageId) && Intrinsics3.areEqual(this.stickerId, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.stickerId) && Intrinsics3.areEqual(this.targetUser, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.targetUser) && Intrinsics3.areEqual(this.sender, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.sender);
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.stickerId;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.targetUser;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.sender;
        return iHashCode3 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRoleSubscriptionPurchaseSystemMessageCtaClicked(messageId=");
        sbU.append(this.messageId);
        sbU.append(", stickerId=");
        sbU.append(this.stickerId);
        sbU.append(", targetUser=");
        sbU.append(this.targetUser);
        sbU.append(", sender=");
        return outline.G(sbU, this.sender, ")");
    }

    public TrackRoleSubscriptionPurchaseSystemMessageCtaClicked(Long l, CharSequence charSequence, Long l2, Long l3) {
        this.messageId = l;
        this.stickerId = charSequence;
        this.targetUser = l2;
        this.sender = l3;
        this.analyticsSchemaTypeName = "role_subscription_purchase_system_message_cta_clicked";
    }
}
