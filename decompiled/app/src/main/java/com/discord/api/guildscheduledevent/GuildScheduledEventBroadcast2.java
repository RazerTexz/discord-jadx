package com.discord.api.guildscheduledevent;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildScheduledEventBroadcast.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEventBroadcastBody;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "entityId", "Ljava/lang/Long;", "getEntityId", "()Ljava/lang/Long;", "type", "I", "getType", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.guildscheduledevent.GuildScheduledEventBroadcastBody, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class GuildScheduledEventBroadcast2 {
    private final Long entityId;
    private final int type;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventBroadcast2)) {
            return false;
        }
        GuildScheduledEventBroadcast2 guildScheduledEventBroadcast2 = (GuildScheduledEventBroadcast2) other;
        return this.type == guildScheduledEventBroadcast2.type && Intrinsics3.areEqual(this.entityId, guildScheduledEventBroadcast2.entityId);
    }

    public int hashCode() {
        int i = this.type * 31;
        Long l = this.entityId;
        return i + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventBroadcastBody(type=");
        sbU.append(this.type);
        sbU.append(", entityId=");
        return outline.G(sbU, this.entityId, ")");
    }
}
