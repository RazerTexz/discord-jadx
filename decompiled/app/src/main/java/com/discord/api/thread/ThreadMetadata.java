package com.discord.api.thread;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ThreadMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/discord/api/thread/ThreadMetadata;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "autoArchiveDuration", "I", "c", ModelAuditLogEntry.CHANGE_KEY_ARCHIVED, "Z", "b", "()Z", "archiveTimestamp", "Ljava/lang/String;", "a", ModelAuditLogEntry.CHANGE_KEY_LOCKED, "d", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ThreadMetadata {
    private final String archiveTimestamp;
    private final boolean archived;
    private final int autoArchiveDuration;
    private final boolean locked;

    /* renamed from: a, reason: from getter */
    public final String getArchiveTimestamp() {
        return this.archiveTimestamp;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getArchived() {
        return this.archived;
    }

    /* renamed from: c, reason: from getter */
    public final int getAutoArchiveDuration() {
        return this.autoArchiveDuration;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getLocked() {
        return this.locked;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadMetadata)) {
            return false;
        }
        ThreadMetadata threadMetadata = (ThreadMetadata) other;
        return this.archived == threadMetadata.archived && Intrinsics3.areEqual(this.archiveTimestamp, threadMetadata.archiveTimestamp) && this.autoArchiveDuration == threadMetadata.autoArchiveDuration && this.locked == threadMetadata.locked;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z2 = this.archived;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.archiveTimestamp;
        int iHashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.autoArchiveDuration) * 31;
        boolean z3 = this.locked;
        return iHashCode + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ThreadMetadata(archived=");
        sbU.append(this.archived);
        sbU.append(", archiveTimestamp=");
        sbU.append(this.archiveTimestamp);
        sbU.append(", autoArchiveDuration=");
        sbU.append(this.autoArchiveDuration);
        sbU.append(", locked=");
        return outline.O(sbU, this.locked, ")");
    }
}
