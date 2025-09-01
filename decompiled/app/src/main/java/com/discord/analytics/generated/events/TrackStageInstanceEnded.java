package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackStageInstanceEnded.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0007R\u001b\u0010$\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001bR\u001b\u0010&\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010\u001bR\u001b\u0010(\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010\u001bR$\u0010+\u001a\u0004\u0018\u00010*8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00101\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0019\u001a\u0004\b2\u0010\u001bR\u001b\u00103\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0019\u001a\u0004\b4\u0010\u001bR\u001b\u00105\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0019\u001a\u0004\b6\u0010\u001bR$\u00108\u001a\u0004\u0018\u0001078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010>\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u0019\u001a\u0004\b?\u0010\u001bR\u001b\u0010@\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\u0019\u001a\u0004\bA\u0010\u001b¨\u0006B"}, d2 = {"Lcom/discord/analytics/generated/events/TrackStageInstanceEnded;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "", "stageInstanceId", "Ljava/lang/Long;", "getStageInstanceId", "()Ljava/lang/Long;", "", ModelAuditLogEntry.CHANGE_KEY_TOPIC, "Ljava/lang/CharSequence;", "getTopic", "()Ljava/lang/CharSequence;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "privacyLevel", "getPrivacyLevel", "totalUniqueSpeakers", "getTotalUniqueSpeakers", "totalUniqueListeners", "getTotalUniqueListeners", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "maxConcurrentListeners", "getMaxConcurrentListeners", "updaterId", "getUpdaterId", "guildScheduledEventId", "getGuildScheduledEventId", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "maxConcurrentSpeakers", "getMaxConcurrentSpeakers", "numParticipants", "getNumParticipants", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackStageInstanceEnded implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long stageInstanceId = null;
    private final CharSequence topic = null;
    private final Long privacyLevel = null;
    private final Long updaterId = null;
    private final Long guildScheduledEventId = null;
    private final Long totalUniqueListeners = null;
    private final Long maxConcurrentListeners = null;
    private final Long totalUniqueSpeakers = null;
    private final Long maxConcurrentSpeakers = null;
    private final Long numParticipants = null;
    private final transient String analyticsSchemaTypeName = "stage_instance_ended";

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
        if (!(other instanceof TrackStageInstanceEnded)) {
            return false;
        }
        TrackStageInstanceEnded trackStageInstanceEnded = (TrackStageInstanceEnded) other;
        return Intrinsics3.areEqual(this.stageInstanceId, trackStageInstanceEnded.stageInstanceId) && Intrinsics3.areEqual(this.topic, trackStageInstanceEnded.topic) && Intrinsics3.areEqual(this.privacyLevel, trackStageInstanceEnded.privacyLevel) && Intrinsics3.areEqual(this.updaterId, trackStageInstanceEnded.updaterId) && Intrinsics3.areEqual(this.guildScheduledEventId, trackStageInstanceEnded.guildScheduledEventId) && Intrinsics3.areEqual(this.totalUniqueListeners, trackStageInstanceEnded.totalUniqueListeners) && Intrinsics3.areEqual(this.maxConcurrentListeners, trackStageInstanceEnded.maxConcurrentListeners) && Intrinsics3.areEqual(this.totalUniqueSpeakers, trackStageInstanceEnded.totalUniqueSpeakers) && Intrinsics3.areEqual(this.maxConcurrentSpeakers, trackStageInstanceEnded.maxConcurrentSpeakers) && Intrinsics3.areEqual(this.numParticipants, trackStageInstanceEnded.numParticipants);
    }

    public int hashCode() {
        Long l = this.stageInstanceId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.topic;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.privacyLevel;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.updaterId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildScheduledEventId;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.totalUniqueListeners;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.maxConcurrentListeners;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.totalUniqueSpeakers;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.maxConcurrentSpeakers;
        int iHashCode9 = (iHashCode8 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.numParticipants;
        return iHashCode9 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStageInstanceEnded(stageInstanceId=");
        sbU.append(this.stageInstanceId);
        sbU.append(", topic=");
        sbU.append(this.topic);
        sbU.append(", privacyLevel=");
        sbU.append(this.privacyLevel);
        sbU.append(", updaterId=");
        sbU.append(this.updaterId);
        sbU.append(", guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", totalUniqueListeners=");
        sbU.append(this.totalUniqueListeners);
        sbU.append(", maxConcurrentListeners=");
        sbU.append(this.maxConcurrentListeners);
        sbU.append(", totalUniqueSpeakers=");
        sbU.append(this.totalUniqueSpeakers);
        sbU.append(", maxConcurrentSpeakers=");
        sbU.append(this.maxConcurrentSpeakers);
        sbU.append(", numParticipants=");
        return outline.G(sbU, this.numParticipants, ")");
    }
}
