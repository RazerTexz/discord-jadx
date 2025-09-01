package com.discord.api.guildhash;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildHashes.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/discord/api/guildhash/GuildHashes;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guildhash/GuildHash;", "channels", "Lcom/discord/api/guildhash/GuildHash;", "a", "()Lcom/discord/api/guildhash/GuildHash;", "version", "I", "d", "roles", "c", "metadata", "b", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildHashes {
    private final GuildHash channels;
    private final GuildHash metadata;
    private final GuildHash roles;
    private final int version;

    /* renamed from: a, reason: from getter */
    public final GuildHash getChannels() {
        return this.channels;
    }

    /* renamed from: b, reason: from getter */
    public final GuildHash getMetadata() {
        return this.metadata;
    }

    /* renamed from: c, reason: from getter */
    public final GuildHash getRoles() {
        return this.roles;
    }

    /* renamed from: d, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildHashes)) {
            return false;
        }
        GuildHashes guildHashes = (GuildHashes) other;
        return Intrinsics3.areEqual(this.metadata, guildHashes.metadata) && Intrinsics3.areEqual(this.channels, guildHashes.channels) && Intrinsics3.areEqual(this.roles, guildHashes.roles) && this.version == guildHashes.version;
    }

    public int hashCode() {
        GuildHash guildHash = this.metadata;
        int iHashCode = (guildHash != null ? guildHash.hashCode() : 0) * 31;
        GuildHash guildHash2 = this.channels;
        int iHashCode2 = (iHashCode + (guildHash2 != null ? guildHash2.hashCode() : 0)) * 31;
        GuildHash guildHash3 = this.roles;
        return ((iHashCode2 + (guildHash3 != null ? guildHash3.hashCode() : 0)) * 31) + this.version;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildHashes(metadata=");
        sbU.append(this.metadata);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", version=");
        return outline.B(sbU, this.version, ")");
    }
}
