package com.discord.api.role;

import b.d.b.a.outline;
import com.discord.api.guildhash.GuildHashes;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildRoleDelete.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/api/role/GuildRoleDelete;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guildhash/GuildHashes;", "guildHashes", "Lcom/discord/api/guildhash/GuildHashes;", "a", "()Lcom/discord/api/guildhash/GuildHashes;", "", "roleId", "J", "c", "()J", "guildId", "b", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildRoleDelete {
    private final GuildHashes guildHashes;
    private final long guildId;
    private final long roleId;

    /* renamed from: a, reason: from getter */
    public final GuildHashes getGuildHashes() {
        return this.guildHashes;
    }

    /* renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: c, reason: from getter */
    public final long getRoleId() {
        return this.roleId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleDelete)) {
            return false;
        }
        GuildRoleDelete guildRoleDelete = (GuildRoleDelete) other;
        return this.guildId == guildRoleDelete.guildId && this.roleId == guildRoleDelete.roleId && Intrinsics3.areEqual(this.guildHashes, guildRoleDelete.guildHashes);
    }

    public int hashCode() {
        long j = this.guildId;
        long j2 = this.roleId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        GuildHashes guildHashes = this.guildHashes;
        return i + (guildHashes != null ? guildHashes.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildRoleDelete(guildId=");
        sbU.append(this.guildId);
        sbU.append(", roleId=");
        sbU.append(this.roleId);
        sbU.append(", guildHashes=");
        sbU.append(this.guildHashes);
        sbU.append(")");
        return sbU.toString();
    }
}
