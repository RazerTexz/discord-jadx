package com.discord.api.forum;

import b.d.b.a.outline;
import com.discord.api.message.Message;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ForumPostFirstMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/discord/api/forum/ForumPostFirstMessage;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/message/Message;", "firstMessage", "Lcom/discord/api/message/Message;", "a", "()Lcom/discord/api/message/Message;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.forum.ForumPostFirstMessage, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ForumPostFirstMessages2 {
    private final Message firstMessage;

    /* renamed from: a, reason: from getter */
    public final Message getFirstMessage() {
        return this.firstMessage;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ForumPostFirstMessages2) && Intrinsics3.areEqual(this.firstMessage, ((ForumPostFirstMessages2) other).firstMessage);
        }
        return true;
    }

    public int hashCode() {
        Message message = this.firstMessage;
        if (message != null) {
            return message.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ForumPostFirstMessage(firstMessage=");
        sbU.append(this.firstMessage);
        sbU.append(")");
        return sbU.toString();
    }
}
