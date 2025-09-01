package com.discord.api.message.reaction;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: MessageReactionEmoji.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/discord/api/message/reaction/MessageReactionEmoji;", "", "", "c", "()Ljava/lang/String;", "", "e", "()Z", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "animated", "Z", "a", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "d", ModelAuditLogEntry.CHANGE_KEY_ID, "b", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class MessageReactionEmoji {
    private final boolean animated;
    private final String id;
    private final String name;

    public MessageReactionEmoji(String str, String str2, boolean z2) {
        this.id = str;
        this.name = str2;
        this.animated = z2;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAnimated() {
        return this.animated;
    }

    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final String c() {
        String str = this.id;
        if (str != null) {
            return str;
        }
        String str2 = this.name;
        Intrinsics3.checkNotNull(str2);
        return str2;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final boolean e() {
        return this.id != null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageReactionEmoji)) {
            return false;
        }
        MessageReactionEmoji messageReactionEmoji = (MessageReactionEmoji) other;
        return Intrinsics3.areEqual(this.id, messageReactionEmoji.id) && Intrinsics3.areEqual(this.name, messageReactionEmoji.name) && this.animated == messageReactionEmoji.animated;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.animated;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode2 + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageReactionEmoji(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", animated=");
        return outline.O(sbU, this.animated, ")");
    }
}
