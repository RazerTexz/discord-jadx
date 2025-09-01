package com.discord.api.thread;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ThreadMembersUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007R!\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0019\u0010\u001c\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010R!\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018¨\u0006 "}, d2 = {"Lcom/discord/api/thread/ThreadMembersUpdate;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "c", "()J", "memberCount", "I", "getMemberCount", "", "memberIdsPreview", "Ljava/util/List;", "getMemberIdsPreview", "()Ljava/util/List;", "Lcom/discord/api/thread/AugmentedThreadMember;", "addedMembers", "a", "guildId", "b", "removedMemberIds", "d", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ThreadMembersUpdate {
    private final List<AugmentedThreadMember> addedMembers;
    private final long guildId;
    private final long id;
    private final int memberCount;
    private final List<Long> memberIdsPreview;
    private final List<Long> removedMemberIds;

    public final List<AugmentedThreadMember> a() {
        return this.addedMembers;
    }

    /* renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<Long> d() {
        return this.removedMemberIds;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadMembersUpdate)) {
            return false;
        }
        ThreadMembersUpdate threadMembersUpdate = (ThreadMembersUpdate) other;
        return this.id == threadMembersUpdate.id && this.guildId == threadMembersUpdate.guildId && this.memberCount == threadMembersUpdate.memberCount && Intrinsics3.areEqual(this.removedMemberIds, threadMembersUpdate.removedMemberIds) && Intrinsics3.areEqual(this.memberIdsPreview, threadMembersUpdate.memberIdsPreview) && Intrinsics3.areEqual(this.addedMembers, threadMembersUpdate.addedMembers);
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.guildId;
        int i = ((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.memberCount) * 31;
        List<Long> list = this.removedMemberIds;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.memberIdsPreview;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<AugmentedThreadMember> list3 = this.addedMembers;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ThreadMembersUpdate(id=");
        sbU.append(this.id);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", memberCount=");
        sbU.append(this.memberCount);
        sbU.append(", removedMemberIds=");
        sbU.append(this.removedMemberIds);
        sbU.append(", memberIdsPreview=");
        sbU.append(this.memberIdsPreview);
        sbU.append(", addedMembers=");
        return outline.L(sbU, this.addedMembers, ")");
    }
}
