package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackThread;
import com.discord.analytics.generated.traits.TrackThread2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackThreadNotificationSettingsUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R!\u0010\u001b\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001eR\u001b\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#R!\u0010(\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001eR\u001b\u0010*\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010\u001eR$\u0010-\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00104\u001a\u0004\u0018\u0001038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001b\u0010A\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010\u001c\u001a\u0004\bB\u0010\u001eR\u001b\u0010C\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010\u001c\u001a\u0004\bD\u0010\u001eR\u001b\u0010E\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010\u0011\u001a\u0004\bF\u0010\u0013R\u001b\u0010G\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010\u0011\u001a\u0004\bH\u0010\u0013R\u001b\u0010I\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010!\u001a\u0004\bJ\u0010#¨\u0006K"}, d2 = {"Lcom/discord/analytics/generated/events/TrackThreadNotificationSettingsUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackThreadReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "newThreadIsMuted", "Ljava/lang/Boolean;", "getNewThreadIsMuted", "()Ljava/lang/Boolean;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "oldThreadIsMuted", "getOldThreadIsMuted", "", "Lcom/discord/primitives/Timestamp;", "oldThreadMutedUntil", "Ljava/lang/Long;", "getOldThreadMutedUntil", "()Ljava/lang/Long;", "", "parentNotificationSetting", "Ljava/lang/CharSequence;", "getParentNotificationSetting", "()Ljava/lang/CharSequence;", "guildId", "getGuildId", "oldThreadNotificationSetting", "getOldThreadNotificationSetting", "newThreadMutedUntil", "getNewThreadMutedUntil", "channelType", "getChannelType", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackThread;", "trackThread", "Lcom/discord/analytics/generated/traits/TrackThread;", "getTrackThread", "()Lcom/discord/analytics/generated/traits/TrackThread;", "setTrackThread", "(Lcom/discord/analytics/generated/traits/TrackThread;)V", "channelId", "getChannelId", "parentId", "getParentId", "hasInteractedWithThread", "getHasInteractedWithThread", "parentIsMuted", "getParentIsMuted", "newThreadNotificationSetting", "getNewThreadNotificationSetting", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackThreadNotificationSettingsUpdated implements AnalyticsSchema, TrackBase2, TrackThread2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackThread trackThread;
    private final Long channelId = null;
    private final Long parentId = null;
    private final Long guildId = null;
    private final Long channelType = null;
    private final Boolean hasInteractedWithThread = null;
    private final Boolean parentIsMuted = null;
    private final CharSequence oldThreadNotificationSetting = null;
    private final CharSequence newThreadNotificationSetting = null;
    private final CharSequence parentNotificationSetting = null;
    private final Boolean oldThreadIsMuted = null;
    private final Boolean newThreadIsMuted = null;
    private final Long oldThreadMutedUntil = null;
    private final Long newThreadMutedUntil = null;
    private final transient String analyticsSchemaTypeName = "thread_notification_settings_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackThreadNotificationSettingsUpdated)) {
            return false;
        }
        TrackThreadNotificationSettingsUpdated trackThreadNotificationSettingsUpdated = (TrackThreadNotificationSettingsUpdated) other;
        return Intrinsics3.areEqual(this.channelId, trackThreadNotificationSettingsUpdated.channelId) && Intrinsics3.areEqual(this.parentId, trackThreadNotificationSettingsUpdated.parentId) && Intrinsics3.areEqual(this.guildId, trackThreadNotificationSettingsUpdated.guildId) && Intrinsics3.areEqual(this.channelType, trackThreadNotificationSettingsUpdated.channelType) && Intrinsics3.areEqual(this.hasInteractedWithThread, trackThreadNotificationSettingsUpdated.hasInteractedWithThread) && Intrinsics3.areEqual(this.parentIsMuted, trackThreadNotificationSettingsUpdated.parentIsMuted) && Intrinsics3.areEqual(this.oldThreadNotificationSetting, trackThreadNotificationSettingsUpdated.oldThreadNotificationSetting) && Intrinsics3.areEqual(this.newThreadNotificationSetting, trackThreadNotificationSettingsUpdated.newThreadNotificationSetting) && Intrinsics3.areEqual(this.parentNotificationSetting, trackThreadNotificationSettingsUpdated.parentNotificationSetting) && Intrinsics3.areEqual(this.oldThreadIsMuted, trackThreadNotificationSettingsUpdated.oldThreadIsMuted) && Intrinsics3.areEqual(this.newThreadIsMuted, trackThreadNotificationSettingsUpdated.newThreadIsMuted) && Intrinsics3.areEqual(this.oldThreadMutedUntil, trackThreadNotificationSettingsUpdated.oldThreadMutedUntil) && Intrinsics3.areEqual(this.newThreadMutedUntil, trackThreadNotificationSettingsUpdated.newThreadMutedUntil);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.parentId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.channelType;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool = this.hasInteractedWithThread;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.parentIsMuted;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.oldThreadNotificationSetting;
        int iHashCode7 = (iHashCode6 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.newThreadNotificationSetting;
        int iHashCode8 = (iHashCode7 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.parentNotificationSetting;
        int iHashCode9 = (iHashCode8 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool3 = this.oldThreadIsMuted;
        int iHashCode10 = (iHashCode9 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.newThreadIsMuted;
        int iHashCode11 = (iHashCode10 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l5 = this.oldThreadMutedUntil;
        int iHashCode12 = (iHashCode11 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.newThreadMutedUntil;
        return iHashCode12 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackThreadNotificationSettingsUpdated(channelId=");
        sbU.append(this.channelId);
        sbU.append(", parentId=");
        sbU.append(this.parentId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", hasInteractedWithThread=");
        sbU.append(this.hasInteractedWithThread);
        sbU.append(", parentIsMuted=");
        sbU.append(this.parentIsMuted);
        sbU.append(", oldThreadNotificationSetting=");
        sbU.append(this.oldThreadNotificationSetting);
        sbU.append(", newThreadNotificationSetting=");
        sbU.append(this.newThreadNotificationSetting);
        sbU.append(", parentNotificationSetting=");
        sbU.append(this.parentNotificationSetting);
        sbU.append(", oldThreadIsMuted=");
        sbU.append(this.oldThreadIsMuted);
        sbU.append(", newThreadIsMuted=");
        sbU.append(this.newThreadIsMuted);
        sbU.append(", oldThreadMutedUntil=");
        sbU.append(this.oldThreadMutedUntil);
        sbU.append(", newThreadMutedUntil=");
        return outline.G(sbU, this.newThreadMutedUntil, ")");
    }
}
