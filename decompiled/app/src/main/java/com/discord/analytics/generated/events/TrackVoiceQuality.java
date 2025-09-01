package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackVoiceQuality.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u001c\u0010\u001b\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012R\u001b\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010\u0012R\u001b\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00103\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b4\u0010\u0012R\u001b\u00105\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0010\u001a\u0004\b6\u0010\u0012¨\u00067"}, d2 = {"Lcom/discord/analytics/generated/events/TrackVoiceQuality;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "previousTier", "Ljava/lang/Long;", "getPreviousTier", "()Ljava/lang/Long;", "averagePing", "getAveragePing", "speaker", "getSpeaker", "channelId", "getChannelId", "maximumPing", "getMaximumPing", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "duration", "getDuration", "", "sessionId", "Ljava/lang/CharSequence;", "getSessionId", "()Ljava/lang/CharSequence;", "guildId", "getGuildId", "", "quality", "Ljava/lang/Float;", "getQuality", "()Ljava/lang/Float;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "minimumPing", "getMinimumPing", "tier", "getTier", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackVoiceQuality implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long averagePing = null;
    private final Long channelId = null;
    private final Long duration = null;
    private final Long guildId = null;
    private final Long maximumPing = null;
    private final Long minimumPing = null;
    private final Long previousTier = null;
    private final Float quality = null;
    private final CharSequence sessionId = null;
    private final Long speaker = null;
    private final Long tier = null;
    private final transient String analyticsSchemaTypeName = "voice_quality";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVoiceQuality)) {
            return false;
        }
        TrackVoiceQuality trackVoiceQuality = (TrackVoiceQuality) other;
        return Intrinsics3.areEqual(this.averagePing, trackVoiceQuality.averagePing) && Intrinsics3.areEqual(this.channelId, trackVoiceQuality.channelId) && Intrinsics3.areEqual(this.duration, trackVoiceQuality.duration) && Intrinsics3.areEqual(this.guildId, trackVoiceQuality.guildId) && Intrinsics3.areEqual(this.maximumPing, trackVoiceQuality.maximumPing) && Intrinsics3.areEqual(this.minimumPing, trackVoiceQuality.minimumPing) && Intrinsics3.areEqual(this.previousTier, trackVoiceQuality.previousTier) && Intrinsics3.areEqual(this.quality, trackVoiceQuality.quality) && Intrinsics3.areEqual(this.sessionId, trackVoiceQuality.sessionId) && Intrinsics3.areEqual(this.speaker, trackVoiceQuality.speaker) && Intrinsics3.areEqual(this.tier, trackVoiceQuality.tier);
    }

    public int hashCode() {
        Long l = this.averagePing;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.duration;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.maximumPing;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.minimumPing;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.previousTier;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Float f = this.quality;
        int iHashCode8 = (iHashCode7 + (f != null ? f.hashCode() : 0)) * 31;
        CharSequence charSequence = this.sessionId;
        int iHashCode9 = (iHashCode8 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l8 = this.speaker;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.tier;
        return iHashCode10 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVoiceQuality(averagePing=");
        sbU.append(this.averagePing);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", duration=");
        sbU.append(this.duration);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", maximumPing=");
        sbU.append(this.maximumPing);
        sbU.append(", minimumPing=");
        sbU.append(this.minimumPing);
        sbU.append(", previousTier=");
        sbU.append(this.previousTier);
        sbU.append(", quality=");
        sbU.append(this.quality);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", speaker=");
        sbU.append(this.speaker);
        sbU.append(", tier=");
        return outline.G(sbU, this.tier, ")");
    }
}
