package com.discord.api.forum;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ForumPostFirstMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR)\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/discord/api/forum/ForumPostFirstMessages;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/forum/ForumPostFirstMessage;", "threads", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ForumPostFirstMessages {
    private final Map<Long, ForumPostFirstMessages2> threads;

    public final Map<Long, ForumPostFirstMessages2> a() {
        return this.threads;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ForumPostFirstMessages) && Intrinsics3.areEqual(this.threads, ((ForumPostFirstMessages) other).threads);
        }
        return true;
    }

    public int hashCode() {
        Map<Long, ForumPostFirstMessages2> map = this.threads;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.M(outline.U("ForumPostFirstMessages(threads="), this.threads, ")");
    }
}
