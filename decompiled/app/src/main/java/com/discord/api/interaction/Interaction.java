package com.discord.api.interaction;

import b.d.b.a.outline;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Interaction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$BC\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/discord/api/interaction/Interaction;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "b", "", ModelAuditLogEntry.CHANGE_KEY_ID, "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "Lcom/discord/api/user/User;", "user", "Lcom/discord/api/user/User;", "c", "()Lcom/discord/api/user/User;", "Lcom/discord/api/interaction/Member;", "member", "Lcom/discord/api/interaction/Member;", "getMember", "()Lcom/discord/api/interaction/Member;", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lcom/discord/api/user/User;Lcom/discord/api/interaction/Member;)V", "Companion", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Interaction {
    public static final int TYPE_INTERACTION_APPLICATION_COMMAND = 2;
    public static final int TYPE_INTERACTION_PING = 1;
    private final Long id;
    private final Interaction2 member;
    private final String name;
    private final Integer type;
    private final User user;

    public Interaction() {
        this.id = null;
        this.type = null;
        this.name = null;
        this.user = null;
        this.member = null;
    }

    /* renamed from: a, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: c, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Interaction)) {
            return false;
        }
        Interaction interaction = (Interaction) other;
        return Intrinsics3.areEqual(this.id, interaction.id) && Intrinsics3.areEqual(this.type, interaction.type) && Intrinsics3.areEqual(this.name, interaction.name) && Intrinsics3.areEqual(this.user, interaction.user) && Intrinsics3.areEqual(this.member, interaction.member);
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Integer num = this.type;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.name;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        User user = this.user;
        int iHashCode4 = (iHashCode3 + (user != null ? user.hashCode() : 0)) * 31;
        Interaction2 interaction2 = this.member;
        return iHashCode4 + (interaction2 != null ? interaction2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Interaction(id=");
        sbU.append(this.id);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(")");
        return sbU.toString();
    }

    public Interaction(Long l, Integer num, String str, User user, Interaction2 interaction2) {
        this.id = l;
        this.type = num;
        this.name = str;
        this.user = user;
        this.member = null;
    }
}
