package com.discord.api.forum;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ForumUnreads.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u00060\fj\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/discord/api/forum/ForumUnreads;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "getChannelId", "()J", "permissionDenied", "Z", "a", "()Z", "", "Lcom/discord/api/forum/ForumUnread;", "threads", "Ljava/util/List;", "b", "()Ljava/util/List;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ForumUnreads {
    private final long channelId;
    private final boolean permissionDenied;
    private final List<ForumUnread> threads;

    /* renamed from: a, reason: from getter */
    public final boolean getPermissionDenied() {
        return this.permissionDenied;
    }

    public final List<ForumUnread> b() {
        return this.threads;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForumUnreads)) {
            return false;
        }
        ForumUnreads forumUnreads = (ForumUnreads) other;
        return this.channelId == forumUnreads.channelId && this.permissionDenied == forumUnreads.permissionDenied && Intrinsics3.areEqual(this.threads, forumUnreads.threads);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.channelId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z2 = this.permissionDenied;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        List<ForumUnread> list = this.threads;
        return i3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ForumUnreads(channelId=");
        sbU.append(this.channelId);
        sbU.append(", permissionDenied=");
        sbU.append(this.permissionDenied);
        sbU.append(", threads=");
        return outline.L(sbU, this.threads, ")");
    }
}
