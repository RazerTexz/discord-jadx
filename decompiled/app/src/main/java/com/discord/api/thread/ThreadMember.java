package com.discord.api.thread;

import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ThreadMember.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0014\u001a\u00020\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0019\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/api/thread/ThreadMember;", "", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "b", "()J", "", "flags", "I", "a", "()I", "Lcom/discord/api/thread/MuteConfig;", "muteConfig", "Lcom/discord/api/thread/MuteConfig;", "d", "()Lcom/discord/api/thread/MuteConfig;", "userId", "f", "Lcom/discord/api/utcdatetime/UtcDateTime;", "joinTimestamp", "Lcom/discord/api/utcdatetime/UtcDateTime;", "c", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "", "muted", "Z", "e", "()Z", "<init>", "(JJILcom/discord/api/utcdatetime/UtcDateTime;ZLcom/discord/api/thread/MuteConfig;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public class ThreadMember {
    private final int flags;
    private final long id;
    private final UtcDateTime joinTimestamp;
    private final MuteConfig muteConfig;
    private final boolean muted;
    private final long userId;

    public ThreadMember(long j, long j2, int i, UtcDateTime utcDateTime, boolean z2, MuteConfig muteConfig) {
        Intrinsics3.checkNotNullParameter(utcDateTime, "joinTimestamp");
        this.id = j;
        this.userId = j2;
        this.flags = i;
        this.joinTimestamp = utcDateTime;
        this.muted = z2;
        this.muteConfig = muteConfig;
    }

    /* renamed from: a, reason: from getter */
    public int getFlags() {
        return this.flags;
    }

    /* renamed from: b, reason: from getter */
    public long getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public UtcDateTime getJoinTimestamp() {
        return this.joinTimestamp;
    }

    /* renamed from: d, reason: from getter */
    public final MuteConfig getMuteConfig() {
        return this.muteConfig;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getMuted() {
        return this.muted;
    }

    /* renamed from: f, reason: from getter */
    public long getUserId() {
        return this.userId;
    }
}
