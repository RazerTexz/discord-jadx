package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackCustomStatusUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\u00068\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\bR$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010\u0015R$\u0010*\u001a\u0004\u0018\u00010)8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001b\u00100\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00104\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u0013\u001a\u0004\b5\u0010\u0015R\u001b\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001b\u0010;\u001a\u0004\u0018\u0001068\u0006@\u0006¢\u0006\f\n\u0004\b;\u00108\u001a\u0004\b<\u0010:R$\u0010>\u001a\u0004\u0018\u00010=8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006D"}, d2 = {"Lcom/discord/analytics/generated/events/TrackCustomStatusUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackSourceMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "voiceChannelId", "Ljava/lang/Long;", "getVoiceChannelId", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "trackSourceMetadata", "Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "getTrackSourceMetadata", "()Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "setTrackSourceMetadata", "(Lcom/discord/analytics/generated/traits/TrackSourceMetadata;)V", "textLen", "getTextLen", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "hasEmoji", "Ljava/lang/Boolean;", "getHasEmoji", "()Ljava/lang/Boolean;", "voiceChannelVoiceStateCount", "getVoiceChannelVoiceStateCount", "", "emojiType", "Ljava/lang/CharSequence;", "getEmojiType", "()Ljava/lang/CharSequence;", "clearAfter", "getClearAfter", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackCustomStatusUpdated implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackLocationMetadata2, TrackSourceMetadata2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private final Boolean hasEmoji = null;
    private final CharSequence emojiType = null;
    private final Long textLen = null;
    private final CharSequence clearAfter = null;
    private final Long voiceChannelId = null;
    private final Long voiceChannelVoiceStateCount = null;
    private final transient String analyticsSchemaTypeName = "custom_status_updated";

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

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCustomStatusUpdated)) {
            return false;
        }
        TrackCustomStatusUpdated trackCustomStatusUpdated = (TrackCustomStatusUpdated) other;
        return Intrinsics3.areEqual(this.hasEmoji, trackCustomStatusUpdated.hasEmoji) && Intrinsics3.areEqual(this.emojiType, trackCustomStatusUpdated.emojiType) && Intrinsics3.areEqual(this.textLen, trackCustomStatusUpdated.textLen) && Intrinsics3.areEqual(this.clearAfter, trackCustomStatusUpdated.clearAfter) && Intrinsics3.areEqual(this.voiceChannelId, trackCustomStatusUpdated.voiceChannelId) && Intrinsics3.areEqual(this.voiceChannelVoiceStateCount, trackCustomStatusUpdated.voiceChannelVoiceStateCount);
    }

    public int hashCode() {
        Boolean bool = this.hasEmoji;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.emojiType;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l = this.textLen;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.clearAfter;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l2 = this.voiceChannelId;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.voiceChannelVoiceStateCount;
        return iHashCode5 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackCustomStatusUpdated(hasEmoji=");
        sbU.append(this.hasEmoji);
        sbU.append(", emojiType=");
        sbU.append(this.emojiType);
        sbU.append(", textLen=");
        sbU.append(this.textLen);
        sbU.append(", clearAfter=");
        sbU.append(this.clearAfter);
        sbU.append(", voiceChannelId=");
        sbU.append(this.voiceChannelId);
        sbU.append(", voiceChannelVoiceStateCount=");
        return outline.G(sbU, this.voiceChannelVoiceStateCount, ")");
    }
}
