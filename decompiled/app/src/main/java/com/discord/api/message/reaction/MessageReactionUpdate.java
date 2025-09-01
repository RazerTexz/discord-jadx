package com.discord.api.message.reaction;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: MessageReactionUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0019\u0010\u0013\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/discord/api/message/reaction/MessageReactionUpdate;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "messageId", "J", "c", "()J", "channelId", "a", "userId", "d", "Lcom/discord/api/message/reaction/MessageReactionEmoji;", "emoji", "Lcom/discord/api/message/reaction/MessageReactionEmoji;", "b", "()Lcom/discord/api/message/reaction/MessageReactionEmoji;", "<init>", "(JJJLcom/discord/api/message/reaction/MessageReactionEmoji;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class MessageReactionUpdate {
    private final long channelId;
    private final MessageReactionEmoji emoji;
    private final long messageId;
    private final long userId;

    public MessageReactionUpdate(long j, long j2, long j3, MessageReactionEmoji messageReactionEmoji) {
        Intrinsics3.checkNotNullParameter(messageReactionEmoji, "emoji");
        this.userId = j;
        this.channelId = j2;
        this.messageId = j3;
        this.emoji = messageReactionEmoji;
    }

    /* renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final MessageReactionEmoji getEmoji() {
        return this.emoji;
    }

    /* renamed from: c, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* renamed from: d, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageReactionUpdate)) {
            return false;
        }
        MessageReactionUpdate messageReactionUpdate = (MessageReactionUpdate) other;
        return this.userId == messageReactionUpdate.userId && this.channelId == messageReactionUpdate.channelId && this.messageId == messageReactionUpdate.messageId && Intrinsics3.areEqual(this.emoji, messageReactionUpdate.emoji);
    }

    public int hashCode() {
        long j = this.userId;
        long j2 = this.channelId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.messageId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        MessageReactionEmoji messageReactionEmoji = this.emoji;
        return i2 + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageReactionUpdate(userId=");
        sbU.append(this.userId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(")");
        return sbU.toString();
    }
}
