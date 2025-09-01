package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.Guild;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ChannelListItemGuildScheduledEvents.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u001c\u0010\u001a\u001a\u00020\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u001d\u001a\u00020\u00108\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0012R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemGuildScheduledEvents;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component1", "()Ljava/util/List;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "data", "guild", "copy", "(Ljava/util/List;Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/channels/list/items/ChannelListItemGuildScheduledEvents;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getData", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Ljava/util/List;Lcom/discord/models/guild/Guild;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemGuildScheduledEvents implements ChannelListItem {
    private final List<GuildScheduledEvent> data;
    private final Guild guild;
    private final String key;
    private final int type;

    public ChannelListItemGuildScheduledEvents(List<GuildScheduledEvent> list, Guild guild) {
        Intrinsics3.checkNotNullParameter(list, "data");
        Intrinsics3.checkNotNullParameter(guild, "guild");
        this.data = list;
        this.guild = guild;
        this.type = 19;
        this.key = String.valueOf(getType());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChannelListItemGuildScheduledEvents copy$default(ChannelListItemGuildScheduledEvents channelListItemGuildScheduledEvents, List list, Guild guild, int i, Object obj) {
        if ((i & 1) != 0) {
            list = channelListItemGuildScheduledEvents.data;
        }
        if ((i & 2) != 0) {
            guild = channelListItemGuildScheduledEvents.guild;
        }
        return channelListItemGuildScheduledEvents.copy(list, guild);
    }

    public final List<GuildScheduledEvent> component1() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final ChannelListItemGuildScheduledEvents copy(List<GuildScheduledEvent> data, Guild guild) {
        Intrinsics3.checkNotNullParameter(data, "data");
        Intrinsics3.checkNotNullParameter(guild, "guild");
        return new ChannelListItemGuildScheduledEvents(data, guild);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemGuildScheduledEvents)) {
            return false;
        }
        ChannelListItemGuildScheduledEvents channelListItemGuildScheduledEvents = (ChannelListItemGuildScheduledEvents) other;
        return Intrinsics3.areEqual(this.data, channelListItemGuildScheduledEvents.data) && Intrinsics3.areEqual(this.guild, channelListItemGuildScheduledEvents.guild);
    }

    public final List<GuildScheduledEvent> getData() {
        return this.data;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        List<GuildScheduledEvent> list = this.data;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        Guild guild = this.guild;
        return iHashCode + (guild != null ? guild.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemGuildScheduledEvents(data=");
        sbU.append(this.data);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(")");
        return sbU.toString();
    }
}
