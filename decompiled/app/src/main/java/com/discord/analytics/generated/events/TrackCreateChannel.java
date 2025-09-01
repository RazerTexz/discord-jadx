package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuildLfgGroup;
import com.discord.analytics.generated.traits.TrackGuildLfgGroup2;
import com.discord.analytics.generated.traits.TrackLfgGroup;
import com.discord.analytics.generated.traits.TrackLfgGroup2;
import com.discord.analytics.generated.traits.TrackThread;
import com.discord.analytics.generated.traits.TrackThread2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackCreateChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010(\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0015R\u001b\u0010*\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,R\u001b\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R$\u00103\u001a\u0004\u0018\u0001028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u00020\u00068\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\bR\u001b\u0010<\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0013\u001a\u0004\b=\u0010\u0015R\u001b\u0010>\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u0013\u001a\u0004\b?\u0010\u0015R$\u0010A\u001a\u0004\u0018\u00010@8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001b\u0010G\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010\u0013\u001a\u0004\bH\u0010\u0015R\u001b\u0010I\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010\u0013\u001a\u0004\bJ\u0010\u0015R!\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010K8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001b\u0010P\u001a\u0004\u0018\u00010-8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010/\u001a\u0004\bQ\u00101¨\u0006R"}, d2 = {"Lcom/discord/analytics/generated/events/TrackCreateChannel;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLfgGroupReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildLfgGroupReceiver;", "Lcom/discord/analytics/generated/traits/TrackThreadReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "activeAnnouncementThreadCount", "Ljava/lang/Long;", "getActiveAnnouncementThreadCount", "()Ljava/lang/Long;", "channelType", "getChannelType", "originChannelId", "getOriginChannelId", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackThread;", "trackThread", "Lcom/discord/analytics/generated/traits/TrackThread;", "getTrackThread", "()Lcom/discord/analytics/generated/traits/TrackThread;", "setTrackThread", "(Lcom/discord/analytics/generated/traits/TrackThread;)V", "activeThreadCount", "getActiveThreadCount", "isNsfw", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "", "channelName", "Ljava/lang/CharSequence;", "getChannelName", "()Ljava/lang/CharSequence;", "Lcom/discord/analytics/generated/traits/TrackLfgGroup;", "trackLfgGroup", "Lcom/discord/analytics/generated/traits/TrackLfgGroup;", "getTrackLfgGroup", "()Lcom/discord/analytics/generated/traits/TrackLfgGroup;", "setTrackLfgGroup", "(Lcom/discord/analytics/generated/traits/TrackLfgGroup;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "starterMessageAgeMinutes", "getStarterMessageAgeMinutes", "parentId", "getParentId", "Lcom/discord/analytics/generated/traits/TrackGuildLfgGroup;", "trackGuildLfgGroup", "Lcom/discord/analytics/generated/traits/TrackGuildLfgGroup;", "getTrackGuildLfgGroup", "()Lcom/discord/analytics/generated/traits/TrackGuildLfgGroup;", "setTrackGuildLfgGroup", "(Lcom/discord/analytics/generated/traits/TrackGuildLfgGroup;)V", "channelId", "getChannelId", "guildId", "getGuildId", "", "recipientIds", "Ljava/util/List;", "getRecipientIds", "()Ljava/util/List;", "guildName", "getGuildName", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackCreateChannel implements AnalyticsSchema, TrackBase2, TrackLfgGroup2, TrackGuildLfgGroup2, TrackThread2 {
    private TrackBase trackBase;
    private TrackGuildLfgGroup trackGuildLfgGroup;
    private TrackLfgGroup trackLfgGroup;
    private TrackThread trackThread;
    private final Long channelId = null;
    private final Long channelType = null;
    private final List<Long> recipientIds = null;
    private final Long originChannelId = null;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final CharSequence channelName = null;
    private final Boolean isNsfw = null;
    private final Long parentId = null;
    private final Long starterMessageAgeMinutes = null;
    private final Long activeThreadCount = null;
    private final Long activeAnnouncementThreadCount = null;
    private final transient String analyticsSchemaTypeName = "create_channel";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCreateChannel)) {
            return false;
        }
        TrackCreateChannel trackCreateChannel = (TrackCreateChannel) other;
        return Intrinsics3.areEqual(this.channelId, trackCreateChannel.channelId) && Intrinsics3.areEqual(this.channelType, trackCreateChannel.channelType) && Intrinsics3.areEqual(this.recipientIds, trackCreateChannel.recipientIds) && Intrinsics3.areEqual(this.originChannelId, trackCreateChannel.originChannelId) && Intrinsics3.areEqual(this.guildId, trackCreateChannel.guildId) && Intrinsics3.areEqual(this.guildName, trackCreateChannel.guildName) && Intrinsics3.areEqual(this.channelName, trackCreateChannel.channelName) && Intrinsics3.areEqual(this.isNsfw, trackCreateChannel.isNsfw) && Intrinsics3.areEqual(this.parentId, trackCreateChannel.parentId) && Intrinsics3.areEqual(this.starterMessageAgeMinutes, trackCreateChannel.starterMessageAgeMinutes) && Intrinsics3.areEqual(this.activeThreadCount, trackCreateChannel.activeThreadCount) && Intrinsics3.areEqual(this.activeAnnouncementThreadCount, trackCreateChannel.activeAnnouncementThreadCount);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        List<Long> list = this.recipientIds;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Long l3 = this.originChannelId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence = this.guildName;
        int iHashCode6 = (iHashCode5 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.channelName;
        int iHashCode7 = (iHashCode6 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.isNsfw;
        int iHashCode8 = (iHashCode7 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l5 = this.parentId;
        int iHashCode9 = (iHashCode8 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.starterMessageAgeMinutes;
        int iHashCode10 = (iHashCode9 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.activeThreadCount;
        int iHashCode11 = (iHashCode10 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.activeAnnouncementThreadCount;
        return iHashCode11 + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackCreateChannel(channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", recipientIds=");
        sbU.append(this.recipientIds);
        sbU.append(", originChannelId=");
        sbU.append(this.originChannelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", channelName=");
        sbU.append(this.channelName);
        sbU.append(", isNsfw=");
        sbU.append(this.isNsfw);
        sbU.append(", parentId=");
        sbU.append(this.parentId);
        sbU.append(", starterMessageAgeMinutes=");
        sbU.append(this.starterMessageAgeMinutes);
        sbU.append(", activeThreadCount=");
        sbU.append(this.activeThreadCount);
        sbU.append(", activeAnnouncementThreadCount=");
        return outline.G(sbU, this.activeAnnouncementThreadCount, ")");
    }
}
