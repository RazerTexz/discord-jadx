package com.discord.api.message.reaction;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: MessageReaction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\nR\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/api/message/reaction/MessageReaction;", "", "", "c", "()Z", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/message/reaction/MessageReactionEmoji;", "emoji", "Lcom/discord/api/message/reaction/MessageReactionEmoji;", "b", "()Lcom/discord/api/message/reaction/MessageReactionEmoji;", "count", "I", "a", "me", "Z", "getMe", "<init>", "(ILcom/discord/api/message/reaction/MessageReactionEmoji;Z)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class MessageReaction {
    private final int count;
    private final MessageReactionEmoji emoji;
    private final boolean me;

    public MessageReaction(int i, MessageReactionEmoji messageReactionEmoji, boolean z2) {
        Intrinsics3.checkNotNullParameter(messageReactionEmoji, "emoji");
        this.count = i;
        this.emoji = messageReactionEmoji;
        this.me = z2;
    }

    /* renamed from: a, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* renamed from: b, reason: from getter */
    public final MessageReactionEmoji getEmoji() {
        return this.emoji;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getMe() {
        return this.me;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageReaction)) {
            return false;
        }
        MessageReaction messageReaction = (MessageReaction) other;
        return this.count == messageReaction.count && Intrinsics3.areEqual(this.emoji, messageReaction.emoji) && this.me == messageReaction.me;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.count * 31;
        MessageReactionEmoji messageReactionEmoji = this.emoji;
        int iHashCode = (i + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0)) * 31;
        boolean z2 = this.me;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        return iHashCode + i2;
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageReaction(count=");
        sbU.append(this.count);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(", me=");
        return outline.O(sbU, this.me, ")");
    }
}
