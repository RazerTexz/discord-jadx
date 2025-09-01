package com.discord.api.thread;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.message.Message;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ThreadListing.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011R!\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/discord/api/thread/ThreadListing;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/api/channel/Channel;", "threads", "Ljava/util/List;", "c", "()Ljava/util/List;", "hasMore", "Z", "b", "()Z", "Lcom/discord/api/thread/ThreadMember;", "members", "getMembers", "Lcom/discord/api/message/Message;", "firstMessages", "a", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ThreadListing {
    private final List<Message> firstMessages;
    private final boolean hasMore;
    private final List<ThreadMember> members;
    private final List<Channel> threads;

    public final List<Message> a() {
        return this.firstMessages;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<Channel> c() {
        return this.threads;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadListing)) {
            return false;
        }
        ThreadListing threadListing = (ThreadListing) other;
        return Intrinsics3.areEqual(this.threads, threadListing.threads) && this.hasMore == threadListing.hasMore && Intrinsics3.areEqual(this.members, threadListing.members) && Intrinsics3.areEqual(this.firstMessages, threadListing.firstMessages);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<Channel> list = this.threads;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.hasMore;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        List<ThreadMember> list2 = this.members;
        int iHashCode2 = (i2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Message> list3 = this.firstMessages;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ThreadListing(threads=");
        sbU.append(this.threads);
        sbU.append(", hasMore=");
        sbU.append(this.hasMore);
        sbU.append(", members=");
        sbU.append(this.members);
        sbU.append(", firstMessages=");
        return outline.L(sbU, this.firstMessages, ")");
    }
}
