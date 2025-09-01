package com.discord.widgets.hubs.events;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetHubEventsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\n\u0010\u0014\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\f\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b2\u00103J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000eJp\u0010\u001d\u001a\u00020\u00002\f\b\u0002\u0010\u0014\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0019\u0010\u0017\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b\u0017\u0010\u000eR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b*\u0010\u000bR\u0019\u0010\u0019\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b+\u0010\u000eR\u001d\u0010\u0014\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010,\u001a\u0004\b-\u0010\u0005R\u0019\u0010\u001c\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010(\u001a\u0004\b\u001c\u0010\u000eR\u0019\u0010\u001a\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b.\u0010\u000eR\u0019\u0010\u001b\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b\u001b\u0010\u000eR\u0019\u0010\u0018\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b/\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u00100\u001a\u0004\b1\u0010\b¨\u00064"}, d2 = {"Lcom/discord/widgets/hubs/events/HubGuildScheduledEventData;", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component2", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "Lcom/discord/api/channel/Channel;", "component3", "()Lcom/discord/api/channel/Channel;", "", "component4", "()Z", "component5", "component6", "component7", "component8", "component9", "directoryChannelId", "event", "channel", "isRsvped", "canShare", "canStartEvent", "canConnect", "isConnected", "isInGuild", "copy", "(JLcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/api/channel/Channel;ZZZZZZ)Lcom/discord/widgets/hubs/events/HubGuildScheduledEventData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/api/channel/Channel;", "getChannel", "getCanStartEvent", "J", "getDirectoryChannelId", "getCanConnect", "getCanShare", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getEvent", "<init>", "(JLcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/api/channel/Channel;ZZZZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.events.HubGuildScheduledEventData, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubEventsViewModel2 {
    private final boolean canConnect;
    private final boolean canShare;
    private final boolean canStartEvent;
    private final Channel channel;
    private final long directoryChannelId;
    private final GuildScheduledEvent event;
    private final boolean isConnected;
    private final boolean isInGuild;
    private final boolean isRsvped;

    public WidgetHubEventsViewModel2(long j, GuildScheduledEvent guildScheduledEvent, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
        this.directoryChannelId = j;
        this.event = guildScheduledEvent;
        this.channel = channel;
        this.isRsvped = z2;
        this.canShare = z3;
        this.canStartEvent = z4;
        this.canConnect = z5;
        this.isConnected = z6;
        this.isInGuild = z7;
    }

    public static /* synthetic */ WidgetHubEventsViewModel2 copy$default(WidgetHubEventsViewModel2 widgetHubEventsViewModel2, long j, GuildScheduledEvent guildScheduledEvent, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
        return widgetHubEventsViewModel2.copy((i & 1) != 0 ? widgetHubEventsViewModel2.directoryChannelId : j, (i & 2) != 0 ? widgetHubEventsViewModel2.event : guildScheduledEvent, (i & 4) != 0 ? widgetHubEventsViewModel2.channel : channel, (i & 8) != 0 ? widgetHubEventsViewModel2.isRsvped : z2, (i & 16) != 0 ? widgetHubEventsViewModel2.canShare : z3, (i & 32) != 0 ? widgetHubEventsViewModel2.canStartEvent : z4, (i & 64) != 0 ? widgetHubEventsViewModel2.canConnect : z5, (i & 128) != 0 ? widgetHubEventsViewModel2.isConnected : z6, (i & 256) != 0 ? widgetHubEventsViewModel2.isInGuild : z7);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    /* renamed from: component2, reason: from getter */
    public final GuildScheduledEvent getEvent() {
        return this.event;
    }

    /* renamed from: component3, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsRsvped() {
        return this.isRsvped;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCanShare() {
        return this.canShare;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getCanConnect() {
        return this.canConnect;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsConnected() {
        return this.isConnected;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsInGuild() {
        return this.isInGuild;
    }

    public final WidgetHubEventsViewModel2 copy(long directoryChannelId, GuildScheduledEvent event, Channel channel, boolean isRsvped, boolean canShare, boolean canStartEvent, boolean canConnect, boolean isConnected, boolean isInGuild) {
        Intrinsics3.checkNotNullParameter(event, "event");
        return new WidgetHubEventsViewModel2(directoryChannelId, event, channel, isRsvped, canShare, canStartEvent, canConnect, isConnected, isInGuild);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubEventsViewModel2)) {
            return false;
        }
        WidgetHubEventsViewModel2 widgetHubEventsViewModel2 = (WidgetHubEventsViewModel2) other;
        return this.directoryChannelId == widgetHubEventsViewModel2.directoryChannelId && Intrinsics3.areEqual(this.event, widgetHubEventsViewModel2.event) && Intrinsics3.areEqual(this.channel, widgetHubEventsViewModel2.channel) && this.isRsvped == widgetHubEventsViewModel2.isRsvped && this.canShare == widgetHubEventsViewModel2.canShare && this.canStartEvent == widgetHubEventsViewModel2.canStartEvent && this.canConnect == widgetHubEventsViewModel2.canConnect && this.isConnected == widgetHubEventsViewModel2.isConnected && this.isInGuild == widgetHubEventsViewModel2.isInGuild;
    }

    public final boolean getCanConnect() {
        return this.canConnect;
    }

    public final boolean getCanShare() {
        return this.canShare;
    }

    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final GuildScheduledEvent getEvent() {
        return this.event;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = b.a(this.directoryChannelId) * 31;
        GuildScheduledEvent guildScheduledEvent = this.event;
        int iHashCode = (iA + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        boolean z2 = this.isRsvped;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        boolean z3 = this.canShare;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.canStartEvent;
        int i5 = z4;
        if (z4 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z5 = this.canConnect;
        int i7 = z5;
        if (z5 != 0) {
            i7 = 1;
        }
        int i8 = (i6 + i7) * 31;
        boolean z6 = this.isConnected;
        int i9 = z6;
        if (z6 != 0) {
            i9 = 1;
        }
        int i10 = (i8 + i9) * 31;
        boolean z7 = this.isInGuild;
        return i10 + (z7 ? 1 : z7 ? 1 : 0);
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isInGuild() {
        return this.isInGuild;
    }

    public final boolean isRsvped() {
        return this.isRsvped;
    }

    public String toString() {
        StringBuilder sbU = outline.U("HubGuildScheduledEventData(directoryChannelId=");
        sbU.append(this.directoryChannelId);
        sbU.append(", event=");
        sbU.append(this.event);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", isRsvped=");
        sbU.append(this.isRsvped);
        sbU.append(", canShare=");
        sbU.append(this.canShare);
        sbU.append(", canStartEvent=");
        sbU.append(this.canStartEvent);
        sbU.append(", canConnect=");
        sbU.append(this.canConnect);
        sbU.append(", isConnected=");
        sbU.append(this.isConnected);
        sbU.append(", isInGuild=");
        return outline.O(sbU, this.isInGuild, ")");
    }
}
