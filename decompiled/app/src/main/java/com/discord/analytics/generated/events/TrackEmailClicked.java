package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackEmail;
import com.discord.analytics.generated.traits.TrackEmail2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackEmailClicked.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u001c\u0010\u001d\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0006R\u001b\u0010 \u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018R\u001b\u0010$\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013R\u001b\u0010&\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013R$\u0010)\u001a\u0004\u0018\u00010(8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/discord/analytics/generated/events/TrackEmailClicked;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackEmailReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "actionType", "Ljava/lang/CharSequence;", "getActionType", "()Ljava/lang/CharSequence;", "", "targetGuildId", "Ljava/lang/Long;", "getTargetGuildId", "()Ljava/lang/Long;", "targetChannelId", "getTargetChannelId", "trackingId", "getTrackingId", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "guildId", "getGuildId", "channelId", "getChannelId", "path", "getPath", "target", "getTarget", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackEmail;", "trackEmail", "Lcom/discord/analytics/generated/traits/TrackEmail;", "getTrackEmail", "()Lcom/discord/analytics/generated/traits/TrackEmail;", "setTrackEmail", "(Lcom/discord/analytics/generated/traits/TrackEmail;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackEmailClicked implements AnalyticsSchema, TrackBase2, TrackEmail2 {
    private TrackBase trackBase;
    private TrackEmail trackEmail;
    private final CharSequence trackingId = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final CharSequence path = null;
    private final CharSequence actionType = null;
    private final CharSequence target = null;
    private final Long targetGuildId = null;
    private final Long targetChannelId = null;
    private final transient String analyticsSchemaTypeName = "email_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackEmailClicked)) {
            return false;
        }
        TrackEmailClicked trackEmailClicked = (TrackEmailClicked) other;
        return Intrinsics3.areEqual(this.trackingId, trackEmailClicked.trackingId) && Intrinsics3.areEqual(this.guildId, trackEmailClicked.guildId) && Intrinsics3.areEqual(this.channelId, trackEmailClicked.channelId) && Intrinsics3.areEqual(this.path, trackEmailClicked.path) && Intrinsics3.areEqual(this.actionType, trackEmailClicked.actionType) && Intrinsics3.areEqual(this.target, trackEmailClicked.target) && Intrinsics3.areEqual(this.targetGuildId, trackEmailClicked.targetGuildId) && Intrinsics3.areEqual(this.targetChannelId, trackEmailClicked.targetChannelId);
    }

    public int hashCode() {
        CharSequence charSequence = this.trackingId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.guildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.path;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.actionType;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.target;
        int iHashCode6 = (iHashCode5 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.targetGuildId;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.targetChannelId;
        return iHashCode7 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackEmailClicked(trackingId=");
        sbU.append(this.trackingId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", path=");
        sbU.append(this.path);
        sbU.append(", actionType=");
        sbU.append(this.actionType);
        sbU.append(", target=");
        sbU.append(this.target);
        sbU.append(", targetGuildId=");
        sbU.append(this.targetGuildId);
        sbU.append(", targetChannelId=");
        return outline.G(sbU, this.targetChannelId, ")");
    }
}
