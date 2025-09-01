package com.discord.api.emoji;

import b.d.b.a.outline;
import com.discord.api.guildhash.GuildHashes;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: GuildEmojisUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/discord/api/emoji/GuildEmojisUpdate;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/api/emoji/GuildEmoji;", "emojis", "Ljava/util/List;", "a", "()Ljava/util/List;", "Lcom/discord/api/guildhash/GuildHashes;", "guildHashes", "Lcom/discord/api/guildhash/GuildHashes;", "b", "()Lcom/discord/api/guildhash/GuildHashes;", "", "guildId", "J", "c", "()J", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildEmojisUpdate {
    private final List<GuildEmoji> emojis;
    private final GuildHashes guildHashes;
    private final long guildId;

    public final List<GuildEmoji> a() {
        return this.emojis;
    }

    /* renamed from: b, reason: from getter */
    public final GuildHashes getGuildHashes() {
        return this.guildHashes;
    }

    /* renamed from: c, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildEmojisUpdate)) {
            return false;
        }
        GuildEmojisUpdate guildEmojisUpdate = (GuildEmojisUpdate) other;
        return this.guildId == guildEmojisUpdate.guildId && Intrinsics3.areEqual(this.emojis, guildEmojisUpdate.emojis) && Intrinsics3.areEqual(this.guildHashes, guildEmojisUpdate.guildHashes);
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<GuildEmoji> list = this.emojis;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        GuildHashes guildHashes = this.guildHashes;
        return iHashCode + (guildHashes != null ? guildHashes.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildEmojisUpdate(guildId=");
        sbU.append(this.guildId);
        sbU.append(", emojis=");
        sbU.append(this.emojis);
        sbU.append(", guildHashes=");
        sbU.append(this.guildHashes);
        sbU.append(")");
        return sbU.toString();
    }
}
