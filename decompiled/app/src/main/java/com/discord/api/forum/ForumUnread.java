package com.discord.api.forum;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ForumUnread.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u00060\u0010j\u0002`\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/discord/api/forum/ForumUnread;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "missing", "Z", "getMissing", "()Z", "", "Lcom/discord/primitives/ChannelId;", "threadId", "J", "b", "()J", "count", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ForumUnread {
    private final Integer count;
    private final boolean missing;
    private final long threadId;

    /* renamed from: a, reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    /* renamed from: b, reason: from getter */
    public final long getThreadId() {
        return this.threadId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForumUnread)) {
            return false;
        }
        ForumUnread forumUnread = (ForumUnread) other;
        return this.threadId == forumUnread.threadId && this.missing == forumUnread.missing && Intrinsics3.areEqual(this.count, forumUnread.count);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.threadId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z2 = this.missing;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        Integer num = this.count;
        return i3 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ForumUnread(threadId=");
        sbU.append(this.threadId);
        sbU.append(", missing=");
        sbU.append(this.missing);
        sbU.append(", count=");
        return outline.F(sbU, this.count, ")");
    }
}
