package com.discord.api.directory;

import b.d.b.a.outline;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: DirectoryEntryGuild.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u001c\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010R\u0019\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010#\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u000e\u001a\u0004\b$\u0010\u0010¨\u0006%"}, d2 = {"Lcom/discord/api/directory/DirectoryEntryEvent;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "authorId", "J", "getAuthorId", "()J", "primaryCategoryId", "I", "getPrimaryCategoryId", "Lcom/discord/api/utcdatetime/UtcDateTime;", "createdAt", "Lcom/discord/api/utcdatetime/UtcDateTime;", "getCreatedAt", "()Lcom/discord/api/utcdatetime/UtcDateTime;", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "Ljava/lang/String;", "getDescription", "directoryChannelId", "getDirectoryChannelId", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvent", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "a", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "entityId", "getEntityId", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.directory.DirectoryEntryEvent, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class DirectoryEntryGuild2 {
    private final long authorId;
    private final UtcDateTime createdAt;
    private final String description;
    private final long directoryChannelId;
    private final long entityId;
    private final GuildScheduledEvent guildScheduledEvent;
    private final int primaryCategoryId;

    /* renamed from: a, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectoryEntryGuild2)) {
            return false;
        }
        DirectoryEntryGuild2 directoryEntryGuild2 = (DirectoryEntryGuild2) other;
        return this.directoryChannelId == directoryEntryGuild2.directoryChannelId && this.entityId == directoryEntryGuild2.entityId && this.authorId == directoryEntryGuild2.authorId && Intrinsics3.areEqual(this.description, directoryEntryGuild2.description) && this.primaryCategoryId == directoryEntryGuild2.primaryCategoryId && Intrinsics3.areEqual(this.createdAt, directoryEntryGuild2.createdAt) && Intrinsics3.areEqual(this.guildScheduledEvent, directoryEntryGuild2.guildScheduledEvent);
    }

    public int hashCode() {
        long j = this.directoryChannelId;
        long j2 = this.entityId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.authorId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str = this.description;
        int iHashCode = (((i2 + (str != null ? str.hashCode() : 0)) * 31) + this.primaryCategoryId) * 31;
        UtcDateTime utcDateTime = this.createdAt;
        int iHashCode2 = (iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        return iHashCode2 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("DirectoryEntryEvent(directoryChannelId=");
        sbU.append(this.directoryChannelId);
        sbU.append(", entityId=");
        sbU.append(this.entityId);
        sbU.append(", authorId=");
        sbU.append(this.authorId);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", primaryCategoryId=");
        sbU.append(this.primaryCategoryId);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(")");
        return sbU.toString();
    }
}
