package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreThreadDraft;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ThreadDraftFormEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u000e\u0010\u001b\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\n\u0010\u001c\u001a\u00060\u0005j\u0002`\t\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0012\u0012\u0006\u0010 \u001a\u00020\u0015\u0012\u0006\u0010!\u001a\u00020\u0015\u0012\u0006\u0010\"\u001a\u00020\u0015¢\u0006\u0004\bD\u0010EJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\n\u001a\u00060\u0005j\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017Jz\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00022\u0010\b\u0002\u0010\u001b\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\f\b\u0002\u0010\u001c\u001a\u00060\u0005j\u0002`\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00152\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010,\u001a\u00020\u00152\b\u0010+\u001a\u0004\u0018\u00010*HÖ\u0003¢\u0006\u0004\b,\u0010-R!\u0010\u001b\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b/\u0010\bR\u0019\u0010 \u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b \u00100\u001a\u0004\b1\u0010\u0017R\u0019\u0010\"\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00100\u001a\u0004\b2\u0010\u0017R\u001c\u00103\u001a\u00020\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010)R\u0019\u0010\u001f\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00106\u001a\u0004\b7\u0010\u0014R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00108\u001a\u0004\b9\u0010\u000eR\u001d\u0010\u001c\u001a\u00060\u0005j\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010:\u001a\u0004\b;\u0010\u000bR\u001c\u0010<\u001a\u00020%8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010'R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010?\u001a\u0004\b@\u0010\u0004R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010A\u001a\u0004\bB\u0010\u0011R\u0019\u0010!\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b!\u00100\u001a\u0004\bC\u0010\u0017¨\u0006F"}, d2 = {"Lcom/discord/widgets/chat/list/entries/ThreadDraftFormEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "Lcom/discord/primitives/MessageId;", "component2", "()Ljava/lang/Long;", "Lcom/discord/primitives/GuildId;", "component3", "()J", "Lcom/discord/models/guild/Guild;", "component4", "()Lcom/discord/models/guild/Guild;", "", "component5", "()Ljava/lang/Integer;", "Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;", "component6", "()Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;", "", "component7", "()Z", "component8", "component9", "parentChannel", "parentMessageId", "guildId", "guild", "defaultAutoArchiveDuration", "threadDraftState", "canCreatePrivateThread", "canSeePrivateThreadOption", "canCreatePublicThread", "copy", "(Lcom/discord/api/channel/Channel;Ljava/lang/Long;JLcom/discord/models/guild/Guild;Ljava/lang/Integer;Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;ZZZ)Lcom/discord/widgets/chat/list/entries/ThreadDraftFormEntry;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getParentMessageId", "Z", "getCanCreatePrivateThread", "getCanCreatePublicThread", "type", "I", "getType", "Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;", "getThreadDraftState", "Lcom/discord/models/guild/Guild;", "getGuild", "J", "getGuildId", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/api/channel/Channel;", "getParentChannel", "Ljava/lang/Integer;", "getDefaultAutoArchiveDuration", "getCanSeePrivateThreadOption", "<init>", "(Lcom/discord/api/channel/Channel;Ljava/lang/Long;JLcom/discord/models/guild/Guild;Ljava/lang/Integer;Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ThreadDraftFormEntry extends ChatListEntry {
    private final boolean canCreatePrivateThread;
    private final boolean canCreatePublicThread;
    private final boolean canSeePrivateThreadOption;
    private final Integer defaultAutoArchiveDuration;
    private final Guild guild;
    private final long guildId;
    private final String key;
    private final Channel parentChannel;
    private final Long parentMessageId;
    private final StoreThreadDraft.ThreadDraftState threadDraftState;
    private final int type;

    public ThreadDraftFormEntry(Channel channel, Long l, long j, Guild guild, Integer num, StoreThreadDraft.ThreadDraftState threadDraftState, boolean z2, boolean z3, boolean z4) {
        Intrinsics3.checkNotNullParameter(channel, "parentChannel");
        Intrinsics3.checkNotNullParameter(threadDraftState, "threadDraftState");
        this.parentChannel = channel;
        this.parentMessageId = l;
        this.guildId = j;
        this.guild = guild;
        this.defaultAutoArchiveDuration = num;
        this.threadDraftState = threadDraftState;
        this.canCreatePrivateThread = z2;
        this.canSeePrivateThreadOption = z3;
        this.canCreatePublicThread = z4;
        this.type = 37;
        StringBuilder sbU = outline.U("37");
        sbU.append(channel.getId());
        sbU.append(l);
        this.key = sbU.toString();
    }

    public static /* synthetic */ ThreadDraftFormEntry copy$default(ThreadDraftFormEntry threadDraftFormEntry, Channel channel, Long l, long j, Guild guild, Integer num, StoreThreadDraft.ThreadDraftState threadDraftState, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        return threadDraftFormEntry.copy((i & 1) != 0 ? threadDraftFormEntry.parentChannel : channel, (i & 2) != 0 ? threadDraftFormEntry.parentMessageId : l, (i & 4) != 0 ? threadDraftFormEntry.guildId : j, (i & 8) != 0 ? threadDraftFormEntry.guild : guild, (i & 16) != 0 ? threadDraftFormEntry.defaultAutoArchiveDuration : num, (i & 32) != 0 ? threadDraftFormEntry.threadDraftState : threadDraftState, (i & 64) != 0 ? threadDraftFormEntry.canCreatePrivateThread : z2, (i & 128) != 0 ? threadDraftFormEntry.canSeePrivateThreadOption : z3, (i & 256) != 0 ? threadDraftFormEntry.canCreatePublicThread : z4);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getParentMessageId() {
        return this.parentMessageId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component4, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getDefaultAutoArchiveDuration() {
        return this.defaultAutoArchiveDuration;
    }

    /* renamed from: component6, reason: from getter */
    public final StoreThreadDraft.ThreadDraftState getThreadDraftState() {
        return this.threadDraftState;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getCanCreatePrivateThread() {
        return this.canCreatePrivateThread;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getCanSeePrivateThreadOption() {
        return this.canSeePrivateThreadOption;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getCanCreatePublicThread() {
        return this.canCreatePublicThread;
    }

    public final ThreadDraftFormEntry copy(Channel parentChannel, Long parentMessageId, long guildId, Guild guild, Integer defaultAutoArchiveDuration, StoreThreadDraft.ThreadDraftState threadDraftState, boolean canCreatePrivateThread, boolean canSeePrivateThreadOption, boolean canCreatePublicThread) {
        Intrinsics3.checkNotNullParameter(parentChannel, "parentChannel");
        Intrinsics3.checkNotNullParameter(threadDraftState, "threadDraftState");
        return new ThreadDraftFormEntry(parentChannel, parentMessageId, guildId, guild, defaultAutoArchiveDuration, threadDraftState, canCreatePrivateThread, canSeePrivateThreadOption, canCreatePublicThread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadDraftFormEntry)) {
            return false;
        }
        ThreadDraftFormEntry threadDraftFormEntry = (ThreadDraftFormEntry) other;
        return Intrinsics3.areEqual(this.parentChannel, threadDraftFormEntry.parentChannel) && Intrinsics3.areEqual(this.parentMessageId, threadDraftFormEntry.parentMessageId) && this.guildId == threadDraftFormEntry.guildId && Intrinsics3.areEqual(this.guild, threadDraftFormEntry.guild) && Intrinsics3.areEqual(this.defaultAutoArchiveDuration, threadDraftFormEntry.defaultAutoArchiveDuration) && Intrinsics3.areEqual(this.threadDraftState, threadDraftFormEntry.threadDraftState) && this.canCreatePrivateThread == threadDraftFormEntry.canCreatePrivateThread && this.canSeePrivateThreadOption == threadDraftFormEntry.canSeePrivateThreadOption && this.canCreatePublicThread == threadDraftFormEntry.canCreatePublicThread;
    }

    public final boolean getCanCreatePrivateThread() {
        return this.canCreatePrivateThread;
    }

    public final boolean getCanCreatePublicThread() {
        return this.canCreatePublicThread;
    }

    public final boolean getCanSeePrivateThreadOption() {
        return this.canSeePrivateThreadOption;
    }

    public final Integer getDefaultAutoArchiveDuration() {
        return this.defaultAutoArchiveDuration;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    public final Long getParentMessageId() {
        return this.parentMessageId;
    }

    public final StoreThreadDraft.ThreadDraftState getThreadDraftState() {
        return this.threadDraftState;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = this.parentChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Long l = this.parentMessageId;
        int iA = (b.a(this.guildId) + ((iHashCode + (l != null ? l.hashCode() : 0)) * 31)) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iA + (guild != null ? guild.hashCode() : 0)) * 31;
        Integer num = this.defaultAutoArchiveDuration;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        StoreThreadDraft.ThreadDraftState threadDraftState = this.threadDraftState;
        int iHashCode4 = (iHashCode3 + (threadDraftState != null ? threadDraftState.hashCode() : 0)) * 31;
        boolean z2 = this.canCreatePrivateThread;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode4 + i) * 31;
        boolean z3 = this.canSeePrivateThreadOption;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.canCreatePublicThread;
        return i4 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ThreadDraftFormEntry(parentChannel=");
        sbU.append(this.parentChannel);
        sbU.append(", parentMessageId=");
        sbU.append(this.parentMessageId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", defaultAutoArchiveDuration=");
        sbU.append(this.defaultAutoArchiveDuration);
        sbU.append(", threadDraftState=");
        sbU.append(this.threadDraftState);
        sbU.append(", canCreatePrivateThread=");
        sbU.append(this.canCreatePrivateThread);
        sbU.append(", canSeePrivateThreadOption=");
        sbU.append(this.canSeePrivateThreadOption);
        sbU.append(", canCreatePublicThread=");
        return outline.O(sbU, this.canCreatePublicThread, ")");
    }
}
