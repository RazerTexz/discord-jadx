package com.discord.api.thread;

import com.discord.api.guildmember.GuildMember;
import com.discord.api.presence.Presence;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.Metadata;

/* compiled from: AugmentedThreadMember.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u0019\u0010\u0019\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/discord/api/thread/AugmentedThreadMember;", "", "", "flags", "I", "a", "()I", "Lcom/discord/api/presence/Presence;", "presence", "Lcom/discord/api/presence/Presence;", "f", "()Lcom/discord/api/presence/Presence;", "", "userId", "J", "g", "()J", "", "muted", "Z", "e", "()Z", ModelAuditLogEntry.CHANGE_KEY_ID, "getId", "Lcom/discord/api/utcdatetime/UtcDateTime;", "joinTimestamp", "Lcom/discord/api/utcdatetime/UtcDateTime;", "b", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "Lcom/discord/api/guildmember/GuildMember;", "member", "Lcom/discord/api/guildmember/GuildMember;", "c", "()Lcom/discord/api/guildmember/GuildMember;", "Lcom/discord/api/thread/MuteConfig;", "muteConfig", "Lcom/discord/api/thread/MuteConfig;", "d", "()Lcom/discord/api/thread/MuteConfig;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class AugmentedThreadMember {
    private final int flags;
    private final long id;
    private final UtcDateTime joinTimestamp;
    private final GuildMember member;
    private final MuteConfig muteConfig;
    private final boolean muted;
    private final Presence presence;
    private final long userId;

    /* renamed from: a, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* renamed from: b, reason: from getter */
    public final UtcDateTime getJoinTimestamp() {
        return this.joinTimestamp;
    }

    /* renamed from: c, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
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
    public final Presence getPresence() {
        return this.presence;
    }

    /* renamed from: g, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }
}
