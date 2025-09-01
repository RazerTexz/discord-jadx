package com.discord.api.thread;

import b.d.b.a.outline;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ThreadMemberUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010R\u0019\u0010\u001c\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\u001f\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010R\u001b\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/discord/api/thread/ThreadMemberUpdate;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "userId", "J", "g", "()J", "muted", "Z", "f", "()Z", "Lcom/discord/api/utcdatetime/UtcDateTime;", "joinTimestamp", "Lcom/discord/api/utcdatetime/UtcDateTime;", "d", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "guildId", "b", "flags", "I", "a", ModelAuditLogEntry.CHANGE_KEY_ID, "c", "Lcom/discord/api/thread/MuteConfig;", "muteConfig", "Lcom/discord/api/thread/MuteConfig;", "e", "()Lcom/discord/api/thread/MuteConfig;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ThreadMemberUpdate {
    private final int flags;
    private final long guildId;
    private final long id;
    private final UtcDateTime joinTimestamp;
    private final MuteConfig muteConfig;
    private final boolean muted;
    private final long userId;

    /* renamed from: a, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final UtcDateTime getJoinTimestamp() {
        return this.joinTimestamp;
    }

    /* renamed from: e, reason: from getter */
    public final MuteConfig getMuteConfig() {
        return this.muteConfig;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadMemberUpdate)) {
            return false;
        }
        ThreadMemberUpdate threadMemberUpdate = (ThreadMemberUpdate) other;
        return this.id == threadMemberUpdate.id && this.guildId == threadMemberUpdate.guildId && this.userId == threadMemberUpdate.userId && this.flags == threadMemberUpdate.flags && Intrinsics3.areEqual(this.joinTimestamp, threadMemberUpdate.joinTimestamp) && this.muted == threadMemberUpdate.muted && Intrinsics3.areEqual(this.muteConfig, threadMemberUpdate.muteConfig);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getMuted() {
        return this.muted;
    }

    /* renamed from: g, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.id;
        long j2 = this.guildId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.userId;
        int i2 = (((i + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.flags) * 31;
        UtcDateTime utcDateTime = this.joinTimestamp;
        int iHashCode = (i2 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        boolean z2 = this.muted;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (iHashCode + i3) * 31;
        MuteConfig muteConfig = this.muteConfig;
        return i4 + (muteConfig != null ? muteConfig.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ThreadMemberUpdate(id=");
        sbU.append(this.id);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", joinTimestamp=");
        sbU.append(this.joinTimestamp);
        sbU.append(", muted=");
        sbU.append(this.muted);
        sbU.append(", muteConfig=");
        sbU.append(this.muteConfig);
        sbU.append(")");
        return sbU.toString();
    }
}
