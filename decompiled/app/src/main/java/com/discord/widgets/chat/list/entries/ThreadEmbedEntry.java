package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ThreadEmbedEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\n\u0010\u001d\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\f\u0012\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0016\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u000f\u0012\u0006\u0010#\u001a\u00020\u0016\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010%\u001a\u00020\f¢\u0006\u0004\bD\u0010EJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u000fHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0012J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u000eJ\u0090\u0001\u0010&\u001a\u00020\u00002\f\b\u0002\u0010\u001d\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0018\b\u0002\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u000f2\b\b\u0002\u0010#\u001a\u00020\u00162\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010%\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b*\u0010\u000bJ\u001a\u0010-\u001a\u00020\u00162\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b-\u0010.R\u001b\u0010 \u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010/\u001a\u0004\b0\u0010\u000eR)\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00101\u001a\u0004\b2\u0010\u0012R\u0019\u0010%\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010/\u001a\u0004\b3\u0010\u000eR'\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00101\u001a\u0004\b4\u0010\u0012R\u001d\u0010\u001d\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00105\u001a\u0004\b6\u0010\u0005R\u0019\u0010\u001f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b8\u0010\u000bR\u0019\u0010#\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b#\u00109\u001a\u0004\b:\u0010\u0018R\u001b\u0010$\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010;\u001a\u0004\b<\u0010\u001bR\u001c\u0010=\u001a\u00020\t8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b=\u00107\u001a\u0004\b>\u0010\u000bR\u0019\u0010\u001e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010?\u001a\u0004\b@\u0010\bR\u001c\u0010A\u001a\u00020\u00148\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010)¨\u0006F"}, d2 = {"Lcom/discord/widgets/chat/list/entries/ThreadEmbedEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "Lcom/discord/primitives/MessageId;", "component1", "()J", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "", "component3", "()I", "Lcom/discord/models/message/Message;", "component4", "()Lcom/discord/models/message/Message;", "", "Lcom/discord/api/role/GuildRole;", "component5", "()Ljava/util/Map;", "Lcom/discord/primitives/UserId;", "", "component6", "", "component7", "()Z", "Lcom/discord/models/member/GuildMember;", "component8", "()Lcom/discord/models/member/GuildMember;", "component9", "messageId", "thread", "threadMessageCount", "mostRecentMessage", "roleMentions", "nickOrUsernames", "animateEmojis", "mostRecentMessageGuildMember", "parentMessage", "copy", "(JLcom/discord/api/channel/Channel;ILcom/discord/models/message/Message;Ljava/util/Map;Ljava/util/Map;ZLcom/discord/models/member/GuildMember;Lcom/discord/models/message/Message;)Lcom/discord/widgets/chat/list/entries/ThreadEmbedEntry;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/message/Message;", "getMostRecentMessage", "Ljava/util/Map;", "getNickOrUsernames", "getParentMessage", "getRoleMentions", "J", "getMessageId", "I", "getThreadMessageCount", "Z", "getAnimateEmojis", "Lcom/discord/models/member/GuildMember;", "getMostRecentMessageGuildMember", "type", "getType", "Lcom/discord/api/channel/Channel;", "getThread", "key", "Ljava/lang/String;", "getKey", "<init>", "(JLcom/discord/api/channel/Channel;ILcom/discord/models/message/Message;Ljava/util/Map;Ljava/util/Map;ZLcom/discord/models/member/GuildMember;Lcom/discord/models/message/Message;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ThreadEmbedEntry extends ChatListEntry {
    private final boolean animateEmojis;
    private final String key;
    private final long messageId;
    private final Message mostRecentMessage;
    private final GuildMember mostRecentMessageGuildMember;
    private final Map<Long, String> nickOrUsernames;
    private final Message parentMessage;
    private final Map<Long, GuildRole> roleMentions;
    private final Channel thread;
    private final int threadMessageCount;
    private final int type;

    public ThreadEmbedEntry(long j, Channel channel, int i, Message message, Map<Long, GuildRole> map, Map<Long, String> map2, boolean z2, GuildMember guildMember, Message message2) {
        Intrinsics3.checkNotNullParameter(channel, "thread");
        Intrinsics3.checkNotNullParameter(map2, "nickOrUsernames");
        Intrinsics3.checkNotNullParameter(message2, "parentMessage");
        this.messageId = j;
        this.thread = channel;
        this.threadMessageCount = i;
        this.mostRecentMessage = message;
        this.roleMentions = map;
        this.nickOrUsernames = map2;
        this.animateEmojis = z2;
        this.mostRecentMessageGuildMember = guildMember;
        this.parentMessage = message2;
        this.type = 35;
        this.key = outline.t("35 -- ", j);
    }

    public static /* synthetic */ ThreadEmbedEntry copy$default(ThreadEmbedEntry threadEmbedEntry, long j, Channel channel, int i, Message message, Map map, Map map2, boolean z2, GuildMember guildMember, Message message2, int i2, Object obj) {
        return threadEmbedEntry.copy((i2 & 1) != 0 ? threadEmbedEntry.messageId : j, (i2 & 2) != 0 ? threadEmbedEntry.thread : channel, (i2 & 4) != 0 ? threadEmbedEntry.threadMessageCount : i, (i2 & 8) != 0 ? threadEmbedEntry.mostRecentMessage : message, (i2 & 16) != 0 ? threadEmbedEntry.roleMentions : map, (i2 & 32) != 0 ? threadEmbedEntry.nickOrUsernames : map2, (i2 & 64) != 0 ? threadEmbedEntry.animateEmojis : z2, (i2 & 128) != 0 ? threadEmbedEntry.mostRecentMessageGuildMember : guildMember, (i2 & 256) != 0 ? threadEmbedEntry.parentMessage : message2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* renamed from: component2, reason: from getter */
    public final Channel getThread() {
        return this.thread;
    }

    /* renamed from: component3, reason: from getter */
    public final int getThreadMessageCount() {
        return this.threadMessageCount;
    }

    /* renamed from: component4, reason: from getter */
    public final Message getMostRecentMessage() {
        return this.mostRecentMessage;
    }

    public final Map<Long, GuildRole> component5() {
        return this.roleMentions;
    }

    public final Map<Long, String> component6() {
        return this.nickOrUsernames;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    /* renamed from: component8, reason: from getter */
    public final GuildMember getMostRecentMessageGuildMember() {
        return this.mostRecentMessageGuildMember;
    }

    /* renamed from: component9, reason: from getter */
    public final Message getParentMessage() {
        return this.parentMessage;
    }

    public final ThreadEmbedEntry copy(long messageId, Channel thread, int threadMessageCount, Message mostRecentMessage, Map<Long, GuildRole> roleMentions, Map<Long, String> nickOrUsernames, boolean animateEmojis, GuildMember mostRecentMessageGuildMember, Message parentMessage) {
        Intrinsics3.checkNotNullParameter(thread, "thread");
        Intrinsics3.checkNotNullParameter(nickOrUsernames, "nickOrUsernames");
        Intrinsics3.checkNotNullParameter(parentMessage, "parentMessage");
        return new ThreadEmbedEntry(messageId, thread, threadMessageCount, mostRecentMessage, roleMentions, nickOrUsernames, animateEmojis, mostRecentMessageGuildMember, parentMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadEmbedEntry)) {
            return false;
        }
        ThreadEmbedEntry threadEmbedEntry = (ThreadEmbedEntry) other;
        return this.messageId == threadEmbedEntry.messageId && Intrinsics3.areEqual(this.thread, threadEmbedEntry.thread) && this.threadMessageCount == threadEmbedEntry.threadMessageCount && Intrinsics3.areEqual(this.mostRecentMessage, threadEmbedEntry.mostRecentMessage) && Intrinsics3.areEqual(this.roleMentions, threadEmbedEntry.roleMentions) && Intrinsics3.areEqual(this.nickOrUsernames, threadEmbedEntry.nickOrUsernames) && this.animateEmojis == threadEmbedEntry.animateEmojis && Intrinsics3.areEqual(this.mostRecentMessageGuildMember, threadEmbedEntry.mostRecentMessageGuildMember) && Intrinsics3.areEqual(this.parentMessage, threadEmbedEntry.parentMessage);
    }

    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final Message getMostRecentMessage() {
        return this.mostRecentMessage;
    }

    public final GuildMember getMostRecentMessageGuildMember() {
        return this.mostRecentMessageGuildMember;
    }

    public final Map<Long, String> getNickOrUsernames() {
        return this.nickOrUsernames;
    }

    public final Message getParentMessage() {
        return this.parentMessage;
    }

    public final Map<Long, GuildRole> getRoleMentions() {
        return this.roleMentions;
    }

    public final Channel getThread() {
        return this.thread;
    }

    public final int getThreadMessageCount() {
        return this.threadMessageCount;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = b.a(this.messageId) * 31;
        Channel channel = this.thread;
        int iHashCode = (((iA + (channel != null ? channel.hashCode() : 0)) * 31) + this.threadMessageCount) * 31;
        Message message = this.mostRecentMessage;
        int iHashCode2 = (iHashCode + (message != null ? message.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map = this.roleMentions;
        int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, String> map2 = this.nickOrUsernames;
        int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
        boolean z2 = this.animateEmojis;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode4 + i) * 31;
        GuildMember guildMember = this.mostRecentMessageGuildMember;
        int iHashCode5 = (i2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        Message message2 = this.parentMessage;
        return iHashCode5 + (message2 != null ? message2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ThreadEmbedEntry(messageId=");
        sbU.append(this.messageId);
        sbU.append(", thread=");
        sbU.append(this.thread);
        sbU.append(", threadMessageCount=");
        sbU.append(this.threadMessageCount);
        sbU.append(", mostRecentMessage=");
        sbU.append(this.mostRecentMessage);
        sbU.append(", roleMentions=");
        sbU.append(this.roleMentions);
        sbU.append(", nickOrUsernames=");
        sbU.append(this.nickOrUsernames);
        sbU.append(", animateEmojis=");
        sbU.append(this.animateEmojis);
        sbU.append(", mostRecentMessageGuildMember=");
        sbU.append(this.mostRecentMessageGuildMember);
        sbU.append(", parentMessage=");
        sbU.append(this.parentMessage);
        sbU.append(")");
        return sbU.toString();
    }
}
