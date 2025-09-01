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

/* compiled from: TrackStageInstanceStarted.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\r\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00103\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0012\u001a\u0004\b4\u0010\u0014R\u001b\u00105\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0012\u001a\u0004\b6\u0010\u0014R\u001b\u00107\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0012\u001a\u0004\b8\u0010\u0014R\u001b\u00109\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0012\u001a\u0004\b:\u0010\u0014R\u001b\u0010;\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u0012\u001a\u0004\b<\u0010\u0014R\u001b\u0010>\u001a\u0004\u0018\u00010=8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001b\u0010B\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010\u0012\u001a\u0004\bC\u0010\u0014R\u001b\u0010D\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010\u0012\u001a\u0004\bE\u0010\u0014¨\u0006F"}, d2 = {"Lcom/discord/analytics/generated/events/TrackStageInstanceStarted;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "guildScheduledEventId", "Ljava/lang/Long;", "getGuildScheduledEventId", "()Ljava/lang/Long;", "maxConcurrentListeners", "getMaxConcurrentListeners", "sendStartNotification", "Ljava/lang/Boolean;", "getSendStartNotification", "()Ljava/lang/Boolean;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "privacyLevel", "getPrivacyLevel", "stageInstanceId", "getStageInstanceId", "numParticipants", "getNumParticipants", "maxConcurrentSpeakers", "getMaxConcurrentSpeakers", "updaterId", "getUpdaterId", "", ModelAuditLogEntry.CHANGE_KEY_TOPIC, "Ljava/lang/CharSequence;", "getTopic", "()Ljava/lang/CharSequence;", "totalUniqueListeners", "getTotalUniqueListeners", "totalUniqueSpeakers", "getTotalUniqueSpeakers", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackStageInstanceStarted implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long stageInstanceId = null;
    private final CharSequence topic = null;
    private final Long privacyLevel = null;
    private final Long numParticipants = null;
    private final Long updaterId = null;
    private final Long guildScheduledEventId = null;
    private final Long totalUniqueListeners = null;
    private final Long maxConcurrentListeners = null;
    private final Long totalUniqueSpeakers = null;
    private final Long maxConcurrentSpeakers = null;
    private final Boolean sendStartNotification = null;
    private final transient String analyticsSchemaTypeName = "stage_instance_started";

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
        if (!(other instanceof TrackStageInstanceStarted)) {
            return false;
        }
        TrackStageInstanceStarted trackStageInstanceStarted = (TrackStageInstanceStarted) other;
        return Intrinsics3.areEqual(this.stageInstanceId, trackStageInstanceStarted.stageInstanceId) && Intrinsics3.areEqual(this.topic, trackStageInstanceStarted.topic) && Intrinsics3.areEqual(this.privacyLevel, trackStageInstanceStarted.privacyLevel) && Intrinsics3.areEqual(this.numParticipants, trackStageInstanceStarted.numParticipants) && Intrinsics3.areEqual(this.updaterId, trackStageInstanceStarted.updaterId) && Intrinsics3.areEqual(this.guildScheduledEventId, trackStageInstanceStarted.guildScheduledEventId) && Intrinsics3.areEqual(this.totalUniqueListeners, trackStageInstanceStarted.totalUniqueListeners) && Intrinsics3.areEqual(this.maxConcurrentListeners, trackStageInstanceStarted.maxConcurrentListeners) && Intrinsics3.areEqual(this.totalUniqueSpeakers, trackStageInstanceStarted.totalUniqueSpeakers) && Intrinsics3.areEqual(this.maxConcurrentSpeakers, trackStageInstanceStarted.maxConcurrentSpeakers) && Intrinsics3.areEqual(this.sendStartNotification, trackStageInstanceStarted.sendStartNotification);
    }

    public int hashCode() {
        Long l = this.stageInstanceId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.topic;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.privacyLevel;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numParticipants;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.updaterId;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.guildScheduledEventId;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.totalUniqueListeners;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.maxConcurrentListeners;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.totalUniqueSpeakers;
        int iHashCode9 = (iHashCode8 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.maxConcurrentSpeakers;
        int iHashCode10 = (iHashCode9 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Boolean bool = this.sendStartNotification;
        return iHashCode10 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStageInstanceStarted(stageInstanceId=");
        sbU.append(this.stageInstanceId);
        sbU.append(", topic=");
        sbU.append(this.topic);
        sbU.append(", privacyLevel=");
        sbU.append(this.privacyLevel);
        sbU.append(", numParticipants=");
        sbU.append(this.numParticipants);
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
        sbU.append(", sendStartNotification=");
        return outline.D(sbU, this.sendStartNotification, ")");
    }
}
