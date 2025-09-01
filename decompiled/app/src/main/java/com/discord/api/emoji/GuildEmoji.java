package com.discord.api.emoji;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: GuildEmoji.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010 \u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000fR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000fR!\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/discord/api/emoji/GuildEmoji;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "requireColons", "Z", "f", "()Z", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "e", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "c", "()J", "managed", "d", ModelAuditLogEntry.CHANGE_KEY_AVAILABLE, "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "animated", "a", "", "roles", "Ljava/util/List;", "g", "()Ljava/util/List;", "<init>", "(JLjava/lang/String;Ljava/util/List;ZZZLjava/lang/Boolean;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildEmoji {
    private final boolean animated;
    private final Boolean available;
    private final long id;
    private final boolean managed;
    private final String name;
    private final boolean requireColons;
    private final List<Long> roles;

    public GuildEmoji(long j, String str, List<Long> list, boolean z2, boolean z3, boolean z4, Boolean bool) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.id = j;
        this.name = str;
        this.roles = list;
        this.requireColons = z2;
        this.managed = z3;
        this.animated = z4;
        this.available = bool;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAnimated() {
        return this.animated;
    }

    /* renamed from: b, reason: from getter */
    public final Boolean getAvailable() {
        return this.available;
    }

    /* renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getManaged() {
        return this.managed;
    }

    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildEmoji)) {
            return false;
        }
        GuildEmoji guildEmoji = (GuildEmoji) other;
        return this.id == guildEmoji.id && Intrinsics3.areEqual(this.name, guildEmoji.name) && Intrinsics3.areEqual(this.roles, guildEmoji.roles) && this.requireColons == guildEmoji.requireColons && this.managed == guildEmoji.managed && this.animated == guildEmoji.animated && Intrinsics3.areEqual(this.available, guildEmoji.available);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getRequireColons() {
        return this.requireColons;
    }

    public final List<Long> g() {
        return this.roles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<Long> list = this.roles;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.requireColons;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode2 + i2) * 31;
        boolean z3 = this.managed;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z4 = this.animated;
        int i6 = (i5 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
        Boolean bool = this.available;
        return i6 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildEmoji(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", requireColons=");
        sbU.append(this.requireColons);
        sbU.append(", managed=");
        sbU.append(this.managed);
        sbU.append(", animated=");
        sbU.append(this.animated);
        sbU.append(", available=");
        return outline.D(sbU, this.available, ")");
    }
}
