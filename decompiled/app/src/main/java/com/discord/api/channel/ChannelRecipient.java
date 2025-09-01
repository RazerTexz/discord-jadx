package com.discord.api.channel;

import b.d.b.a.outline;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChannelRecipient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0015\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/discord/api/channel/ChannelRecipient;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", ModelAuditLogEntry.CHANGE_KEY_NICK, "Ljava/lang/String;", "b", "", "channelId", "J", "a", "()J", "Lcom/discord/api/user/User;", "user", "Lcom/discord/api/user/User;", "c", "()Lcom/discord/api/user/User;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ChannelRecipient {
    private final long channelId;
    private final String nick;
    private final User user;

    /* renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: c, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelRecipient)) {
            return false;
        }
        ChannelRecipient channelRecipient = (ChannelRecipient) other;
        return Intrinsics3.areEqual(this.nick, channelRecipient.nick) && this.channelId == channelRecipient.channelId && Intrinsics3.areEqual(this.user, channelRecipient.user);
    }

    public int hashCode() {
        String str = this.nick;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.channelId;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        User user = this.user;
        return i + (user != null ? user.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelRecipient(nick=");
        sbU.append(this.nick);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(")");
        return sbU.toString();
    }
}
