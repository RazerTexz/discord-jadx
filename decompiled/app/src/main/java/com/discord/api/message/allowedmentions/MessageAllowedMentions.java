package com.discord.api.message.allowedmentions;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: MessageAllowedMentions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R!\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/discord/api/message/allowedmentions/MessageAllowedMentions;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "", "users", "Ljava/util/List;", "d", "()Ljava/util/List;", "roles", "c", "Lcom/discord/api/message/allowedmentions/MessageAllowedMentionsTypes;", "parse", "a", "repliedUser", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class MessageAllowedMentions {
    private final List<MessageAllowedMentions2> parse;
    private final Boolean repliedUser;
    private final List<Long> roles;
    private final List<Long> users;

    public MessageAllowedMentions() {
        this(null, null, null, null, 15);
    }

    public MessageAllowedMentions(List list, List list2, List list3, Boolean bool, int i) {
        list = (i & 1) != 0 ? null : list;
        int i2 = i & 2;
        int i3 = i & 4;
        bool = (i & 8) != 0 ? null : bool;
        this.parse = list;
        this.users = null;
        this.roles = null;
        this.repliedUser = bool;
    }

    public final List<MessageAllowedMentions2> a() {
        return this.parse;
    }

    /* renamed from: b, reason: from getter */
    public final Boolean getRepliedUser() {
        return this.repliedUser;
    }

    public final List<Long> c() {
        return this.roles;
    }

    public final List<Long> d() {
        return this.users;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageAllowedMentions)) {
            return false;
        }
        MessageAllowedMentions messageAllowedMentions = (MessageAllowedMentions) other;
        return Intrinsics3.areEqual(this.parse, messageAllowedMentions.parse) && Intrinsics3.areEqual(this.users, messageAllowedMentions.users) && Intrinsics3.areEqual(this.roles, messageAllowedMentions.roles) && Intrinsics3.areEqual(this.repliedUser, messageAllowedMentions.repliedUser);
    }

    public int hashCode() {
        List<MessageAllowedMentions2> list = this.parse;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Long> list2 = this.users;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Long> list3 = this.roles;
        int iHashCode3 = (iHashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        Boolean bool = this.repliedUser;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageAllowedMentions(parse=");
        sbU.append(this.parse);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", repliedUser=");
        return outline.D(sbU, this.repliedUser, ")");
    }
}
