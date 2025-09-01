package com.discord.widgets.guildscheduledevent;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.UserGuildMember;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventListItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "<init>", "()V", "Companion", "Event", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class GuildScheduledEventListItem implements MGRecyclerDataPayload {
    public static final int TYPE_EVENT = 0;

    /* compiled from: GuildScheduledEventListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJd\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010\u0004R\u001c\u0010*\u001a\u00020\u001f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010!R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010-\u001a\u0004\b.\u0010\nR\u0019\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010/\u001a\u0004\b0\u0010\rR\u001c\u00101\u001a\u00020\u001c8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u001eR\u0019\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b\u0018\u0010\rR\u0019\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b4\u0010\rR\u0019\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010/\u001a\u0004\b5\u0010\rR\u0019\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010/\u001a\u0004\b\u0015\u0010\r¨\u00068"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component1", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/guild/UserGuildMember;", "component3", "()Lcom/discord/models/guild/UserGuildMember;", "", "component4", "()Z", "component5", "component6", "component7", "component8", "event", "channel", "creator", "isRsvped", "canStartEvent", "canShare", "isConnected", "canConnect", "copy", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/UserGuildMember;ZZZZZ)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getEvent", "type", "I", "getType", "Lcom/discord/models/guild/UserGuildMember;", "getCreator", "Z", "getCanStartEvent", "key", "Ljava/lang/String;", "getKey", "getCanConnect", "getCanShare", "<init>", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/UserGuildMember;ZZZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Event extends GuildScheduledEventListItem {
        private final boolean canConnect;
        private final boolean canShare;
        private final boolean canStartEvent;
        private final Channel channel;
        private final UserGuildMember creator;
        private final GuildScheduledEvent event;
        private final boolean isConnected;
        private final boolean isRsvped;
        private final String key;
        private final int type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Event(GuildScheduledEvent guildScheduledEvent, Channel channel, UserGuildMember userGuildMember, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            super(null);
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
            this.event = guildScheduledEvent;
            this.channel = channel;
            this.creator = userGuildMember;
            this.isRsvped = z2;
            this.canStartEvent = z3;
            this.canShare = z4;
            this.isConnected = z5;
            this.canConnect = z6;
            this.key = String.valueOf(guildScheduledEvent.getId());
        }

        public static /* synthetic */ Event copy$default(Event event, GuildScheduledEvent guildScheduledEvent, Channel channel, UserGuildMember userGuildMember, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
            return event.copy((i & 1) != 0 ? event.event : guildScheduledEvent, (i & 2) != 0 ? event.channel : channel, (i & 4) != 0 ? event.creator : userGuildMember, (i & 8) != 0 ? event.isRsvped : z2, (i & 16) != 0 ? event.canStartEvent : z3, (i & 32) != 0 ? event.canShare : z4, (i & 64) != 0 ? event.isConnected : z5, (i & 128) != 0 ? event.canConnect : z6);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildScheduledEvent getEvent() {
            return this.event;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component3, reason: from getter */
        public final UserGuildMember getCreator() {
            return this.creator;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsRsvped() {
            return this.isRsvped;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getCanStartEvent() {
            return this.canStartEvent;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getCanShare() {
            return this.canShare;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsConnected() {
            return this.isConnected;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getCanConnect() {
            return this.canConnect;
        }

        public final Event copy(GuildScheduledEvent event, Channel channel, UserGuildMember creator, boolean isRsvped, boolean canStartEvent, boolean canShare, boolean isConnected, boolean canConnect) {
            Intrinsics3.checkNotNullParameter(event, "event");
            return new Event(event, channel, creator, isRsvped, canStartEvent, canShare, isConnected, canConnect);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Event)) {
                return false;
            }
            Event event = (Event) other;
            return Intrinsics3.areEqual(this.event, event.event) && Intrinsics3.areEqual(this.channel, event.channel) && Intrinsics3.areEqual(this.creator, event.creator) && this.isRsvped == event.isRsvped && this.canStartEvent == event.canStartEvent && this.canShare == event.canShare && this.isConnected == event.isConnected && this.canConnect == event.canConnect;
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

        public final UserGuildMember getCreator() {
            return this.creator;
        }

        public final GuildScheduledEvent getEvent() {
            return this.event;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            GuildScheduledEvent guildScheduledEvent = this.event;
            int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            UserGuildMember userGuildMember = this.creator;
            int iHashCode3 = (iHashCode2 + (userGuildMember != null ? userGuildMember.hashCode() : 0)) * 31;
            boolean z2 = this.isRsvped;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode3 + i) * 31;
            boolean z3 = this.canStartEvent;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.canShare;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.isConnected;
            int i7 = z5;
            if (z5 != 0) {
                i7 = 1;
            }
            int i8 = (i6 + i7) * 31;
            boolean z6 = this.canConnect;
            return i8 + (z6 ? 1 : z6 ? 1 : 0);
        }

        public final boolean isConnected() {
            return this.isConnected;
        }

        public final boolean isRsvped() {
            return this.isRsvped;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Event(event=");
            sbU.append(this.event);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", creator=");
            sbU.append(this.creator);
            sbU.append(", isRsvped=");
            sbU.append(this.isRsvped);
            sbU.append(", canStartEvent=");
            sbU.append(this.canStartEvent);
            sbU.append(", canShare=");
            sbU.append(this.canShare);
            sbU.append(", isConnected=");
            sbU.append(this.isConnected);
            sbU.append(", canConnect=");
            return outline.O(sbU, this.canConnect, ")");
        }
    }

    private GuildScheduledEventListItem() {
    }

    public /* synthetic */ GuildScheduledEventListItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
