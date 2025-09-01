package com.discord.api.role;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: GuildRole.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\u0019\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0007R\u0019\u0010%\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\nR\u0019\u0010(\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b)\u0010\nR\u0019\u0010*\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010\u0004R\u0019\u0010,\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b-\u0010\u0013¨\u0006."}, d2 = {"Lcom/discord/api/role/GuildRole;", "Ljava/io/Serializable;", "", "a", "()J", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", ModelAuditLogEntry.CHANGE_KEY_HOIST, "Z", "c", "()Z", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "g", "icon", "d", "managed", "e", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "getId", "Lcom/discord/api/role/GuildRoleTags;", ModelAuditLogEntry.CHANGE_KEY_TAGS, "Lcom/discord/api/role/GuildRoleTags;", "j", "()Lcom/discord/api/role/GuildRoleTags;", "unicodeEmoji", "k", ModelAuditLogEntry.CHANGE_KEY_POSITION, "I", "i", ModelAuditLogEntry.CHANGE_KEY_COLOR, "b", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "h", ModelAuditLogEntry.CHANGE_KEY_MENTIONABLE, "f", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildRole implements Serializable {
    private final int color;
    private final boolean hoist;
    private final String icon;
    private final long id;
    private final boolean managed;
    private final boolean mentionable;
    private final String name;
    private final long permissions;
    private final int position;
    private final GuildRoleTags tags;
    private final String unicodeEmoji;

    /* renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getHoist() {
        return this.hoist;
    }

    /* renamed from: d, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getManaged() {
        return this.managed;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRole)) {
            return false;
        }
        GuildRole guildRole = (GuildRole) other;
        return this.position == guildRole.position && Intrinsics3.areEqual(this.name, guildRole.name) && this.id == guildRole.id && this.color == guildRole.color && this.hoist == guildRole.hoist && this.permissions == guildRole.permissions && this.mentionable == guildRole.mentionable && this.managed == guildRole.managed && Intrinsics3.areEqual(this.icon, guildRole.icon) && Intrinsics3.areEqual(this.tags, guildRole.tags) && Intrinsics3.areEqual(this.unicodeEmoji, guildRole.unicodeEmoji);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getMentionable() {
        return this.mentionable;
    }

    /* renamed from: g, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final long getId() {
        return this.id;
    }

    /* renamed from: h, reason: from getter */
    public final long getPermissions() {
        return this.permissions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.position * 31;
        String str = this.name;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.id;
        int i2 = (((((i + iHashCode) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.color) * 31;
        boolean z2 = this.hoist;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        long j2 = this.permissions;
        int i4 = (((i2 + i3) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        boolean z3 = this.mentionable;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z4 = this.managed;
        int i7 = (i6 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
        String str2 = this.icon;
        int iHashCode2 = (i7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        GuildRoleTags guildRoleTags = this.tags;
        int iHashCode3 = (iHashCode2 + (guildRoleTags != null ? guildRoleTags.hashCode() : 0)) * 31;
        String str3 = this.unicodeEmoji;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* renamed from: j, reason: from getter */
    public final GuildRoleTags getTags() {
        return this.tags;
    }

    /* renamed from: k, reason: from getter */
    public final String getUnicodeEmoji() {
        return this.unicodeEmoji;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildRole(position=");
        sbU.append(this.position);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", color=");
        sbU.append(this.color);
        sbU.append(", hoist=");
        sbU.append(this.hoist);
        sbU.append(", permissions=");
        sbU.append(this.permissions);
        sbU.append(", mentionable=");
        sbU.append(this.mentionable);
        sbU.append(", managed=");
        sbU.append(this.managed);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", tags=");
        sbU.append(this.tags);
        sbU.append(", unicodeEmoji=");
        return outline.J(sbU, this.unicodeEmoji, ")");
    }
}
