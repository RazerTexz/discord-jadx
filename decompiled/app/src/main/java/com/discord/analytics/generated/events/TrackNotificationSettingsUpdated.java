package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackNotificationSettingsUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00068\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\bR!\u0010\u001a\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014R\u001b\u0010 \u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010$8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u0010+\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0012\u001a\u0004\b,\u0010\u0014R\u001b\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00102\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0012\u001a\u0004\b3\u0010\u0014R$\u00105\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010B8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR!\u0010I\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u00198\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010\u001b\u001a\u0004\bJ\u0010\u001dR\u001b\u0010K\u001a\u0004\u0018\u00010-8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010/\u001a\u0004\bL\u00101R!\u0010M\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u00198\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010\u001b\u001a\u0004\bN\u0010\u001dR\u001b\u0010O\u001a\u0004\u0018\u00010-8\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010/\u001a\u0004\bP\u00101R\u001b\u0010Q\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010\u0012\u001a\u0004\bR\u0010\u0014R\u001b\u0010S\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010\u0012\u001a\u0004\bT\u0010\u0014R\u001b\u0010U\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010\u001b\u001a\u0004\bV\u0010\u001d¨\u0006W"}, d2 = {"Lcom/discord/analytics/generated/events/TrackNotificationSettingsUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "channelIsOverridden", "Ljava/lang/Boolean;", "getChannelIsOverridden", "()Ljava/lang/Boolean;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "", "Lcom/discord/primitives/Timestamp;", "channeMutedUntil", "Ljava/lang/Long;", "getChanneMutedUntil", "()Ljava/lang/Long;", "guildIsMuted", "getGuildIsMuted", "guildScheduledEventsMuted", "getGuildScheduledEventsMuted", "guildNotifyHighlights", "getGuildNotifyHighlights", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "guildReceiveMobilePush", "getGuildReceiveMobilePush", "", "updateType", "Ljava/lang/CharSequence;", "getUpdateType", "()Ljava/lang/CharSequence;", "guildSuppressRoles", "getGuildSuppressRoles", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "guildMutedUntil", "getGuildMutedUntil", "guildMessageNotificationSettings", "getGuildMessageNotificationSettings", "channelMutedUntil", "getChannelMutedUntil", "channelMessageNotificationSettings", "getChannelMessageNotificationSettings", "channelIsMuted", "getChannelIsMuted", "guildSuppressEveryone", "getGuildSuppressEveryone", "parentId", "getParentId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNotificationSettingsUpdated implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence updateType = null;
    private final Boolean guildSuppressEveryone = null;
    private final Boolean guildSuppressRoles = null;
    private final Boolean guildIsMuted = null;
    private final Long guildMutedUntil = null;
    private final Boolean guildReceiveMobilePush = null;
    private final CharSequence guildMessageNotificationSettings = null;
    private final Long parentId = null;
    private final Boolean channelIsOverridden = null;
    private final Boolean channelIsMuted = null;
    private final Long channeMutedUntil = null;
    private final Long channelMutedUntil = null;
    private final CharSequence channelMessageNotificationSettings = null;
    private final Boolean guildScheduledEventsMuted = null;
    private final Long guildNotifyHighlights = null;
    private final transient String analyticsSchemaTypeName = "notification_settings_updated";

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
        if (!(other instanceof TrackNotificationSettingsUpdated)) {
            return false;
        }
        TrackNotificationSettingsUpdated trackNotificationSettingsUpdated = (TrackNotificationSettingsUpdated) other;
        return Intrinsics3.areEqual(this.updateType, trackNotificationSettingsUpdated.updateType) && Intrinsics3.areEqual(this.guildSuppressEveryone, trackNotificationSettingsUpdated.guildSuppressEveryone) && Intrinsics3.areEqual(this.guildSuppressRoles, trackNotificationSettingsUpdated.guildSuppressRoles) && Intrinsics3.areEqual(this.guildIsMuted, trackNotificationSettingsUpdated.guildIsMuted) && Intrinsics3.areEqual(this.guildMutedUntil, trackNotificationSettingsUpdated.guildMutedUntil) && Intrinsics3.areEqual(this.guildReceiveMobilePush, trackNotificationSettingsUpdated.guildReceiveMobilePush) && Intrinsics3.areEqual(this.guildMessageNotificationSettings, trackNotificationSettingsUpdated.guildMessageNotificationSettings) && Intrinsics3.areEqual(this.parentId, trackNotificationSettingsUpdated.parentId) && Intrinsics3.areEqual(this.channelIsOverridden, trackNotificationSettingsUpdated.channelIsOverridden) && Intrinsics3.areEqual(this.channelIsMuted, trackNotificationSettingsUpdated.channelIsMuted) && Intrinsics3.areEqual(this.channeMutedUntil, trackNotificationSettingsUpdated.channeMutedUntil) && Intrinsics3.areEqual(this.channelMutedUntil, trackNotificationSettingsUpdated.channelMutedUntil) && Intrinsics3.areEqual(this.channelMessageNotificationSettings, trackNotificationSettingsUpdated.channelMessageNotificationSettings) && Intrinsics3.areEqual(this.guildScheduledEventsMuted, trackNotificationSettingsUpdated.guildScheduledEventsMuted) && Intrinsics3.areEqual(this.guildNotifyHighlights, trackNotificationSettingsUpdated.guildNotifyHighlights);
    }

    public int hashCode() {
        CharSequence charSequence = this.updateType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.guildSuppressEveryone;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.guildSuppressRoles;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.guildIsMuted;
        int iHashCode4 = (iHashCode3 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l = this.guildMutedUntil;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool4 = this.guildReceiveMobilePush;
        int iHashCode6 = (iHashCode5 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.guildMessageNotificationSettings;
        int iHashCode7 = (iHashCode6 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l2 = this.parentId;
        int iHashCode8 = (iHashCode7 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool5 = this.channelIsOverridden;
        int iHashCode9 = (iHashCode8 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.channelIsMuted;
        int iHashCode10 = (iHashCode9 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Long l3 = this.channeMutedUntil;
        int iHashCode11 = (iHashCode10 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.channelMutedUntil;
        int iHashCode12 = (iHashCode11 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.channelMessageNotificationSettings;
        int iHashCode13 = (iHashCode12 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool7 = this.guildScheduledEventsMuted;
        int iHashCode14 = (iHashCode13 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Long l5 = this.guildNotifyHighlights;
        return iHashCode14 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNotificationSettingsUpdated(updateType=");
        sbU.append(this.updateType);
        sbU.append(", guildSuppressEveryone=");
        sbU.append(this.guildSuppressEveryone);
        sbU.append(", guildSuppressRoles=");
        sbU.append(this.guildSuppressRoles);
        sbU.append(", guildIsMuted=");
        sbU.append(this.guildIsMuted);
        sbU.append(", guildMutedUntil=");
        sbU.append(this.guildMutedUntil);
        sbU.append(", guildReceiveMobilePush=");
        sbU.append(this.guildReceiveMobilePush);
        sbU.append(", guildMessageNotificationSettings=");
        sbU.append(this.guildMessageNotificationSettings);
        sbU.append(", parentId=");
        sbU.append(this.parentId);
        sbU.append(", channelIsOverridden=");
        sbU.append(this.channelIsOverridden);
        sbU.append(", channelIsMuted=");
        sbU.append(this.channelIsMuted);
        sbU.append(", channeMutedUntil=");
        sbU.append(this.channeMutedUntil);
        sbU.append(", channelMutedUntil=");
        sbU.append(this.channelMutedUntil);
        sbU.append(", channelMessageNotificationSettings=");
        sbU.append(this.channelMessageNotificationSettings);
        sbU.append(", guildScheduledEventsMuted=");
        sbU.append(this.guildScheduledEventsMuted);
        sbU.append(", guildNotifyHighlights=");
        return outline.G(sbU, this.guildNotifyHighlights, ")");
    }
}
