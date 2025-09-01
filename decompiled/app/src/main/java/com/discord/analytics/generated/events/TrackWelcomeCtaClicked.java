package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackWelcomeCtaClicked.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R\u001b\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$¨\u0006)"}, d2 = {"Lcom/discord/analytics/generated/events/TrackWelcomeCtaClicked;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "stickerId", "Ljava/lang/CharSequence;", "getStickerId", "()Ljava/lang/CharSequence;", "isReply", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "", NotificationCompat.MessagingStyle.Message.KEY_SENDER, "Ljava/lang/Long;", "getSender", "()Ljava/lang/Long;", "targetUser", "getTargetUser", "<init>", "(Ljava/lang/Boolean;Ljava/lang/CharSequence;Ljava/lang/Long;Ljava/lang/Long;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackWelcomeCtaClicked implements AnalyticsSchema, TrackBase2 {
    private final transient String analyticsSchemaTypeName;
    private final Boolean isReply;
    private final Long sender;
    private final CharSequence stickerId;
    private final Long targetUser;
    private TrackBase trackBase;

    public TrackWelcomeCtaClicked() {
        this.isReply = null;
        this.stickerId = null;
        this.targetUser = null;
        this.sender = null;
        this.analyticsSchemaTypeName = "welcome_cta_clicked";
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackWelcomeCtaClicked)) {
            return false;
        }
        TrackWelcomeCtaClicked trackWelcomeCtaClicked = (TrackWelcomeCtaClicked) other;
        return Intrinsics3.areEqual(this.isReply, trackWelcomeCtaClicked.isReply) && Intrinsics3.areEqual(this.stickerId, trackWelcomeCtaClicked.stickerId) && Intrinsics3.areEqual(this.targetUser, trackWelcomeCtaClicked.targetUser) && Intrinsics3.areEqual(this.sender, trackWelcomeCtaClicked.sender);
    }

    public int hashCode() {
        Boolean bool = this.isReply;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.stickerId;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l = this.targetUser;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.sender;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackWelcomeCtaClicked(isReply=");
        sbU.append(this.isReply);
        sbU.append(", stickerId=");
        sbU.append(this.stickerId);
        sbU.append(", targetUser=");
        sbU.append(this.targetUser);
        sbU.append(", sender=");
        return outline.G(sbU, this.sender, ")");
    }

    public TrackWelcomeCtaClicked(Boolean bool, CharSequence charSequence, Long l, Long l2) {
        this.isReply = bool;
        this.stickerId = charSequence;
        this.targetUser = l;
        this.sender = l2;
        this.analyticsSchemaTypeName = "welcome_cta_clicked";
    }
}
