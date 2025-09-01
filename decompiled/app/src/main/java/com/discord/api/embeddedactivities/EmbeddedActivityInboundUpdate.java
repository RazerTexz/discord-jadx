package com.discord.api.embeddedactivities;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: EmbeddedActivityInboundUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u00060\fj\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\u00060\fj\u0002`\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R#\u0010\u001c\u001a\f\u0012\b\u0012\u00060\fj\u0002`\u001b0\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/discord/api/embeddedactivities/EmbeddedActivityInboundUpdate;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "a", "()J", "Lcom/discord/api/embeddedactivities/EmbeddedActivity;", "embeddedActivity", "Lcom/discord/api/embeddedactivities/EmbeddedActivity;", "b", "()Lcom/discord/api/embeddedactivities/EmbeddedActivity;", "Lcom/discord/primitives/GuildId;", "guildId", "c", "", "Lcom/discord/primitives/UserId;", "users", "Ljava/util/List;", "d", "()Ljava/util/List;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class EmbeddedActivityInboundUpdate {
    private final long channelId;
    private final EmbeddedActivity embeddedActivity;
    private final long guildId;
    private final List<Long> users;

    /* renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final EmbeddedActivity getEmbeddedActivity() {
        return this.embeddedActivity;
    }

    /* renamed from: c, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final List<Long> d() {
        return this.users;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbeddedActivityInboundUpdate)) {
            return false;
        }
        EmbeddedActivityInboundUpdate embeddedActivityInboundUpdate = (EmbeddedActivityInboundUpdate) other;
        return this.channelId == embeddedActivityInboundUpdate.channelId && Intrinsics3.areEqual(this.embeddedActivity, embeddedActivityInboundUpdate.embeddedActivity) && this.guildId == embeddedActivityInboundUpdate.guildId && Intrinsics3.areEqual(this.users, embeddedActivityInboundUpdate.users);
    }

    public int hashCode() {
        long j = this.channelId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        EmbeddedActivity embeddedActivity = this.embeddedActivity;
        int iHashCode = embeddedActivity != null ? embeddedActivity.hashCode() : 0;
        long j2 = this.guildId;
        int i2 = (((i + iHashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        List<Long> list = this.users;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("EmbeddedActivityInboundUpdate(channelId=");
        sbU.append(this.channelId);
        sbU.append(", embeddedActivity=");
        sbU.append(this.embeddedActivity);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", users=");
        return outline.L(sbU, this.users, ")");
    }
}
