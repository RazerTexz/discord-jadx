package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.UserGuildMember;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ChannelListItemActiveEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\u000e\u0010\u001d\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014¢\u0006\u0004\b1\u00102J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0018\u0010\u0015\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016Jf\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\b2\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\u0010\b\u0002\u0010\u001d\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004J\u0010\u0010!\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b!\u0010\nJ\u001a\u0010#\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0019\u0010\u001b\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010%\u001a\u0004\b&\u0010\u0011R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b(\u0010\u000eR!\u0010\u001d\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010)\u001a\u0004\b*\u0010\u0016R\u0019\u0010\u0019\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b,\u0010\nR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b.\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u0010\u0007R\u0019\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010%\u001a\u0004\b\u001c\u0010\u0011¨\u00063"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemActiveEventData;", "", "", "component1", "()Ljava/lang/String;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "component2", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "", "component3", "()I", "", "Lcom/discord/models/guild/UserGuildMember;", "component4", "()Ljava/util/List;", "", "component5", "()Z", "component6", "", "Lcom/discord/primitives/GuildScheduledEventId;", "component7", "()Ljava/lang/Long;", ModelAuditLogEntry.CHANGE_KEY_TOPIC, "locationInfo", "audienceSize", "speakers", "connected", "isSpeaker", "eventId", "copy", "(Ljava/lang/String;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;ILjava/util/List;ZZLjava/lang/Long;)Lcom/discord/widgets/channels/list/items/ChannelListItemActiveEventData;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getConnected", "Ljava/util/List;", "getSpeakers", "Ljava/lang/Long;", "getEventId", "I", "getAudienceSize", "Ljava/lang/String;", "getTopic", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "getLocationInfo", "<init>", "(Ljava/lang/String;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;ILjava/util/List;ZZLjava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.list.items.ChannelListItemActiveEventData, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemActiveEvent2 {
    private final int audienceSize;
    private final boolean connected;
    private final Long eventId;
    private final boolean isSpeaker;
    private final GuildScheduledEventLocationInfo locationInfo;
    private final List<UserGuildMember> speakers;
    private final String topic;

    public ChannelListItemActiveEvent2(String str, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, int i, List<UserGuildMember> list, boolean z2, boolean z3, Long l) {
        Intrinsics3.checkNotNullParameter(guildScheduledEventLocationInfo, "locationInfo");
        Intrinsics3.checkNotNullParameter(list, "speakers");
        this.topic = str;
        this.locationInfo = guildScheduledEventLocationInfo;
        this.audienceSize = i;
        this.speakers = list;
        this.connected = z2;
        this.isSpeaker = z3;
        this.eventId = l;
    }

    public static /* synthetic */ ChannelListItemActiveEvent2 copy$default(ChannelListItemActiveEvent2 channelListItemActiveEvent2, String str, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, int i, List list, boolean z2, boolean z3, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = channelListItemActiveEvent2.topic;
        }
        if ((i2 & 2) != 0) {
            guildScheduledEventLocationInfo = channelListItemActiveEvent2.locationInfo;
        }
        GuildScheduledEventLocationInfo guildScheduledEventLocationInfo2 = guildScheduledEventLocationInfo;
        if ((i2 & 4) != 0) {
            i = channelListItemActiveEvent2.audienceSize;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            list = channelListItemActiveEvent2.speakers;
        }
        List list2 = list;
        if ((i2 & 16) != 0) {
            z2 = channelListItemActiveEvent2.connected;
        }
        boolean z4 = z2;
        if ((i2 & 32) != 0) {
            z3 = channelListItemActiveEvent2.isSpeaker;
        }
        boolean z5 = z3;
        if ((i2 & 64) != 0) {
            l = channelListItemActiveEvent2.eventId;
        }
        return channelListItemActiveEvent2.copy(str, guildScheduledEventLocationInfo2, i3, list2, z4, z5, l);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    /* renamed from: component2, reason: from getter */
    public final GuildScheduledEventLocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final int getAudienceSize() {
        return this.audienceSize;
    }

    public final List<UserGuildMember> component4() {
        return this.speakers;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getConnected() {
        return this.connected;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsSpeaker() {
        return this.isSpeaker;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getEventId() {
        return this.eventId;
    }

    public final ChannelListItemActiveEvent2 copy(String topic, GuildScheduledEventLocationInfo locationInfo, int audienceSize, List<UserGuildMember> speakers, boolean connected, boolean isSpeaker, Long eventId) {
        Intrinsics3.checkNotNullParameter(locationInfo, "locationInfo");
        Intrinsics3.checkNotNullParameter(speakers, "speakers");
        return new ChannelListItemActiveEvent2(topic, locationInfo, audienceSize, speakers, connected, isSpeaker, eventId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemActiveEvent2)) {
            return false;
        }
        ChannelListItemActiveEvent2 channelListItemActiveEvent2 = (ChannelListItemActiveEvent2) other;
        return Intrinsics3.areEqual(this.topic, channelListItemActiveEvent2.topic) && Intrinsics3.areEqual(this.locationInfo, channelListItemActiveEvent2.locationInfo) && this.audienceSize == channelListItemActiveEvent2.audienceSize && Intrinsics3.areEqual(this.speakers, channelListItemActiveEvent2.speakers) && this.connected == channelListItemActiveEvent2.connected && this.isSpeaker == channelListItemActiveEvent2.isSpeaker && Intrinsics3.areEqual(this.eventId, channelListItemActiveEvent2.eventId);
    }

    public final int getAudienceSize() {
        return this.audienceSize;
    }

    public final boolean getConnected() {
        return this.connected;
    }

    public final Long getEventId() {
        return this.eventId;
    }

    public final GuildScheduledEventLocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    public final List<UserGuildMember> getSpeakers() {
        return this.speakers;
    }

    public final String getTopic() {
        return this.topic;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.topic;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        GuildScheduledEventLocationInfo guildScheduledEventLocationInfo = this.locationInfo;
        int iHashCode2 = (((iHashCode + (guildScheduledEventLocationInfo != null ? guildScheduledEventLocationInfo.hashCode() : 0)) * 31) + this.audienceSize) * 31;
        List<UserGuildMember> list = this.speakers;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.connected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        boolean z3 = this.isSpeaker;
        int i3 = (i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        Long l = this.eventId;
        return i3 + (l != null ? l.hashCode() : 0);
    }

    public final boolean isSpeaker() {
        return this.isSpeaker;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemActiveEventData(topic=");
        sbU.append(this.topic);
        sbU.append(", locationInfo=");
        sbU.append(this.locationInfo);
        sbU.append(", audienceSize=");
        sbU.append(this.audienceSize);
        sbU.append(", speakers=");
        sbU.append(this.speakers);
        sbU.append(", connected=");
        sbU.append(this.connected);
        sbU.append(", isSpeaker=");
        sbU.append(this.isSpeaker);
        sbU.append(", eventId=");
        return outline.G(sbU, this.eventId, ")");
    }
}
