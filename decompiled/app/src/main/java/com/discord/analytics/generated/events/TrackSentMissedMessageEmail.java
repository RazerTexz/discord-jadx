package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackSentMissedMessageEmail.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R\u001c\u0010 \u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0005R\u001b\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012R!\u0010&\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017R$\u0010)\u001a\u0004\u0018\u00010(8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001b\u0010/\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0015\u001a\u0004\b0\u0010\u0017¨\u00061"}, d2 = {"Lcom/discord/analytics/generated/events/TrackSentMissedMessageEmail;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "trackingPixelUuid", "Ljava/lang/CharSequence;", "getTrackingPixelUuid", "()Ljava/lang/CharSequence;", "", "totalDmsMissed", "Ljava/lang/Long;", "getTotalDmsMissed", "()Ljava/lang/Long;", "totalApproximateMessagesMissed", "getTotalApproximateMessagesMissed", "didSend", "Ljava/lang/Boolean;", "getDidSend", "()Ljava/lang/Boolean;", "totalChannelsMissed", "getTotalChannelsMissed", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "subjectClassification", "getSubjectClassification", "Lcom/discord/primitives/Timestamp;", "lastAckAt", "getLastAckAt", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "totalGuildsMissed", "getTotalGuildsMissed", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackSentMissedMessageEmail implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence trackingPixelUuid = null;
    private final CharSequence subjectClassification = null;
    private final Long totalGuildsMissed = null;
    private final Long totalChannelsMissed = null;
    private final Long totalDmsMissed = null;
    private final Long totalApproximateMessagesMissed = null;
    private final Long lastAckAt = null;
    private final Boolean didSend = null;
    private final transient String analyticsSchemaTypeName = "sent_missed_message_email";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSentMissedMessageEmail)) {
            return false;
        }
        TrackSentMissedMessageEmail trackSentMissedMessageEmail = (TrackSentMissedMessageEmail) other;
        return Intrinsics3.areEqual(this.trackingPixelUuid, trackSentMissedMessageEmail.trackingPixelUuid) && Intrinsics3.areEqual(this.subjectClassification, trackSentMissedMessageEmail.subjectClassification) && Intrinsics3.areEqual(this.totalGuildsMissed, trackSentMissedMessageEmail.totalGuildsMissed) && Intrinsics3.areEqual(this.totalChannelsMissed, trackSentMissedMessageEmail.totalChannelsMissed) && Intrinsics3.areEqual(this.totalDmsMissed, trackSentMissedMessageEmail.totalDmsMissed) && Intrinsics3.areEqual(this.totalApproximateMessagesMissed, trackSentMissedMessageEmail.totalApproximateMessagesMissed) && Intrinsics3.areEqual(this.lastAckAt, trackSentMissedMessageEmail.lastAckAt) && Intrinsics3.areEqual(this.didSend, trackSentMissedMessageEmail.didSend);
    }

    public int hashCode() {
        CharSequence charSequence = this.trackingPixelUuid;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.subjectClassification;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.totalGuildsMissed;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.totalChannelsMissed;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.totalDmsMissed;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.totalApproximateMessagesMissed;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.lastAckAt;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool = this.didSend;
        return iHashCode7 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSentMissedMessageEmail(trackingPixelUuid=");
        sbU.append(this.trackingPixelUuid);
        sbU.append(", subjectClassification=");
        sbU.append(this.subjectClassification);
        sbU.append(", totalGuildsMissed=");
        sbU.append(this.totalGuildsMissed);
        sbU.append(", totalChannelsMissed=");
        sbU.append(this.totalChannelsMissed);
        sbU.append(", totalDmsMissed=");
        sbU.append(this.totalDmsMissed);
        sbU.append(", totalApproximateMessagesMissed=");
        sbU.append(this.totalApproximateMessagesMissed);
        sbU.append(", lastAckAt=");
        sbU.append(this.lastAckAt);
        sbU.append(", didSend=");
        return outline.D(sbU, this.didSend, ")");
    }
}
