package com.discord.api.guild.welcome;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildWelcomeChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/api/guild/welcome/GuildWelcomeChannel;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "emojiName", "Ljava/lang/String;", "d", "", "channelId", "J", "a", "()J", "emojiId", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "b", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildWelcomeChannel {
    private final long channelId;
    private final String description;
    private final Long emojiId;
    private final String emojiName;

    /* renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: c, reason: from getter */
    public final Long getEmojiId() {
        return this.emojiId;
    }

    /* renamed from: d, reason: from getter */
    public final String getEmojiName() {
        return this.emojiName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildWelcomeChannel)) {
            return false;
        }
        GuildWelcomeChannel guildWelcomeChannel = (GuildWelcomeChannel) other;
        return this.channelId == guildWelcomeChannel.channelId && Intrinsics3.areEqual(this.description, guildWelcomeChannel.description) && Intrinsics3.areEqual(this.emojiId, guildWelcomeChannel.emojiId) && Intrinsics3.areEqual(this.emojiName, guildWelcomeChannel.emojiName);
    }

    public int hashCode() {
        long j = this.channelId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.description;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.emojiId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.emojiName;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildWelcomeChannel(channelId=");
        sbU.append(this.channelId);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", emojiId=");
        sbU.append(this.emojiId);
        sbU.append(", emojiName=");
        return outline.J(sbU, this.emojiName, ")");
    }
}
