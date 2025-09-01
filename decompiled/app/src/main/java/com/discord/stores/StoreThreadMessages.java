package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelPayload;
import com.discord.models.message.Message;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.d0._Ranges;
import d0.t.Maps6;
import d0.t.MutableCollections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreThreadMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 K2\u00020\u0001:\u0002KLB!\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010G\u001a\u00020F\u0012\b\b\u0002\u0010@\u001a\u00020?¢\u0006\u0004\bI\u0010JJ\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\u00052\n\u0010\t\u001a\u00060\u0002j\u0002`\bH\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0018\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\u00110\u00170\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00162\n\u0010\u001a\u001a\u00060\u0002j\u0002`\b¢\u0006\u0004\b\u0018\u0010\u001bJ\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\u0010\u001a\u001a\u00060\u0002j\u0002`\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b#\u0010\u000eJ\u001b\u0010$\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b$\u0010\u0007J\u0017\u0010%\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b%\u0010\u0015J\u0017\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u000fH\u0007¢\u0006\u0004\b+\u0010\u0015J\u0017\u0010,\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u000fH\u0007¢\u0006\u0004\b,\u0010\u0015J\u0017\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-H\u0007¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-H\u0007¢\u0006\u0004\b1\u00100J\u0017\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u000202H\u0007¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u000206H\u0007¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0005H\u0017¢\u0006\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR&\u0010B\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\u00110\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR&\u0010E\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\u00110D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006M"}, d2 = {"Lcom/discord/stores/StoreThreadMessages;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "deleteForGuild", "(J)V", "Lcom/discord/primitives/ChannelId;", "parentChannelId", "deleteForParentChannel", "Lcom/discord/api/guild/Guild;", "guild", "updateFromGuild", "(Lcom/discord/api/guild/Guild;)V", "Lcom/discord/api/channel/Channel;", "thread", "Lcom/discord/stores/StoreThreadMessages$ThreadState;", "getOrAddState", "(Lcom/discord/api/channel/Channel;)Lcom/discord/stores/StoreThreadMessages$ThreadState;", "updateFromThread", "(Lcom/discord/api/channel/Channel;)V", "Lrx/Observable;", "", "observeThreadCountAndLatestMessage", "()Lrx/Observable;", "channelId", "(J)Lrx/Observable;", "", "getThreadMessageCount", "(J)Ljava/lang/Integer;", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "handleGuildCreate", "handleGuildDelete", "handleThreadCreateOrUpdate", "Lcom/discord/models/thread/dto/ModelThreadListSync;", "threadListSync", "handleThreadListSync", "(Lcom/discord/models/thread/dto/ModelThreadListSync;)V", "channel", "handleChannelDelete", "handleThreadDelete", "Lcom/discord/api/message/Message;", "message", "handleMessageCreate", "(Lcom/discord/api/message/Message;)V", "handleMessageUpdate", "Lcom/discord/models/domain/ModelMessageDelete;", "messageDeleteBulk", "handleMessageDelete", "(Lcom/discord/models/domain/ModelMessageDelete;)V", "Lcom/discord/stores/StoreMessagesLoader$ChannelChunk;", "chunk", "handleMessagesLoaded", "(Lcom/discord/stores/StoreMessagesLoader$ChannelChunk;)V", "snapshotData", "()V", "Lcom/discord/stores/StoreMessages;", "storeMessages", "Lcom/discord/stores/StoreMessages;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "threadsSnapshot", "Ljava/util/Map;", "", "threads", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "<init>", "(Lcom/discord/stores/StoreMessages;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "ThreadState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreThreadMessages extends StoreV2 {
    public static final int MAX_THREAD_MESSAGE_COUNT = 50;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;
    private final StoreMessages storeMessages;
    private final Map<Long, ThreadState> threads;
    private Map<Long, ThreadState> threadsSnapshot;

    /* compiled from: StoreThreadMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0006\u0012\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b*\u0010+J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJP\u0010\u0014\u001a\u00020\u00002\f\b\u0002\u0010\u000f\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u0010\u001a\u00060\u0002j\u0002`\u00062\f\b\u0002\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u000bJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0011\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R\u001d\u0010\u000f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b \u0010\u0005R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010$R\u001d\u0010\u0010\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b%\u0010\u0005R\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\u000b\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/discord/stores/StoreThreadMessages$ThreadState;", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "Lcom/discord/primitives/GuildId;", "component2", "component3", "", "component4", "()I", "Lcom/discord/models/message/Message;", "component5", "()Lcom/discord/models/message/Message;", "threadId", "guildId", "parentId", "count", "mostRecentMessage", "copy", "(JJJILcom/discord/models/message/Message;)Lcom/discord/stores/StoreThreadMessages$ThreadState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getParentId", "getThreadId", "Lcom/discord/models/message/Message;", "getMostRecentMessage", "setMostRecentMessage", "(Lcom/discord/models/message/Message;)V", "getGuildId", "I", "getCount", "setCount", "(I)V", "<init>", "(JJJILcom/discord/models/message/Message;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ThreadState {
        private int count;
        private final long guildId;
        private Message mostRecentMessage;
        private final long parentId;
        private final long threadId;

        public ThreadState(long j, long j2, long j3, int i, Message message) {
            this.threadId = j;
            this.guildId = j2;
            this.parentId = j3;
            this.count = i;
            this.mostRecentMessage = message;
        }

        public static /* synthetic */ ThreadState copy$default(ThreadState threadState, long j, long j2, long j3, int i, Message message, int i2, Object obj) {
            return threadState.copy((i2 & 1) != 0 ? threadState.threadId : j, (i2 & 2) != 0 ? threadState.guildId : j2, (i2 & 4) != 0 ? threadState.parentId : j3, (i2 & 8) != 0 ? threadState.count : i, (i2 & 16) != 0 ? threadState.mostRecentMessage : message);
        }

        /* renamed from: component1, reason: from getter */
        public final long getThreadId() {
            return this.threadId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component3, reason: from getter */
        public final long getParentId() {
            return this.parentId;
        }

        /* renamed from: component4, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* renamed from: component5, reason: from getter */
        public final Message getMostRecentMessage() {
            return this.mostRecentMessage;
        }

        public final ThreadState copy(long threadId, long guildId, long parentId, int count, Message mostRecentMessage) {
            return new ThreadState(threadId, guildId, parentId, count, mostRecentMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThreadState)) {
                return false;
            }
            ThreadState threadState = (ThreadState) other;
            return this.threadId == threadState.threadId && this.guildId == threadState.guildId && this.parentId == threadState.parentId && this.count == threadState.count && Intrinsics3.areEqual(this.mostRecentMessage, threadState.mostRecentMessage);
        }

        public final int getCount() {
            return this.count;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final Message getMostRecentMessage() {
            return this.mostRecentMessage;
        }

        public final long getParentId() {
            return this.parentId;
        }

        public final long getThreadId() {
            return this.threadId;
        }

        public int hashCode() {
            int iA = (((b.a(this.parentId) + ((b.a(this.guildId) + (b.a(this.threadId) * 31)) * 31)) * 31) + this.count) * 31;
            Message message = this.mostRecentMessage;
            return iA + (message != null ? message.hashCode() : 0);
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public final void setMostRecentMessage(Message message) {
            this.mostRecentMessage = message;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ThreadState(threadId=");
            sbU.append(this.threadId);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", parentId=");
            sbU.append(this.parentId);
            sbU.append(", count=");
            sbU.append(this.count);
            sbU.append(", mostRecentMessage=");
            sbU.append(this.mostRecentMessage);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreThreadMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreThreadMessages$ThreadState;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreThreadMessages$observeThreadCountAndLatestMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends ThreadState>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends ThreadState> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends ThreadState> invoke2() {
            return StoreThreadMessages.access$getThreadsSnapshot$p(StoreThreadMessages.this);
        }
    }

    /* compiled from: StoreThreadMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreThreadMessages$ThreadState;", "invoke", "()Lcom/discord/stores/StoreThreadMessages$ThreadState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreThreadMessages$observeThreadCountAndLatestMessage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<ThreadState> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ThreadState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ThreadState invoke() {
            return (ThreadState) StoreThreadMessages.access$getThreadsSnapshot$p(StoreThreadMessages.this).get(Long.valueOf(this.$channelId));
        }
    }

    public /* synthetic */ StoreThreadMessages(StoreMessages storeMessages, StoreChannels storeChannels, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeMessages, storeChannels, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ Map access$getThreadsSnapshot$p(StoreThreadMessages storeThreadMessages) {
        return storeThreadMessages.threadsSnapshot;
    }

    public static final /* synthetic */ void access$setThreadsSnapshot$p(StoreThreadMessages storeThreadMessages, Map map) {
        storeThreadMessages.threadsSnapshot = map;
    }

    @Store3
    private final void deleteForGuild(long guildId) {
        if (MutableCollections.removeAll(this.threads.values(), new StoreThreadMessages2(guildId))) {
            markChanged();
        }
    }

    @Store3
    private final void deleteForParentChannel(long parentChannelId) {
        if (MutableCollections.removeAll(this.threads.values(), new StoreThreadMessages3(parentChannelId))) {
            markChanged();
        }
    }

    @Store3
    private final ThreadState getOrAddState(Channel thread) {
        ThreadState threadState = (ThreadState) outline.d(thread, this.threads);
        if (threadState == null) {
            long id2 = thread.getId();
            long guildId = thread.getGuildId();
            long parentId = thread.getParentId();
            Integer messageCount = thread.getMessageCount();
            threadState = new ThreadState(id2, guildId, parentId, messageCount != null ? messageCount.intValue() : 0, null);
            this.threads.put(Long.valueOf(thread.getId()), threadState);
            markChanged();
        }
        return threadState;
    }

    @Store3
    private final void updateFromGuild(Guild guild) {
        List<Channel> listN = guild.N();
        if (listN != null) {
            Iterator<T> it = listN.iterator();
            while (it.hasNext()) {
                updateFromThread((Channel) it.next());
            }
        }
    }

    @Store3
    private final void updateFromThread(Channel thread) {
        ThreadState orAddState = getOrAddState(thread);
        Integer messageCount = thread.getMessageCount();
        if (messageCount != null) {
            this.threads.put(Long.valueOf(thread.getId()), ThreadState.copy$default(orAddState, 0L, 0L, 0L, messageCount.intValue(), null, 23, null));
            markChanged();
        }
        if (thread.getLastMessageId() != 0) {
            Message mostRecentMessage = orAddState.getMostRecentMessage();
            if (mostRecentMessage == null || mostRecentMessage.getId() != thread.getLastMessageId()) {
                this.threads.put(Long.valueOf(thread.getId()), ThreadState.copy$default(orAddState, 0L, 0L, 0L, 0, null, 15, null));
                markChanged();
            }
        }
    }

    public final Integer getThreadMessageCount(long channelId) {
        ThreadState threadState = this.threadsSnapshot.get(Long.valueOf(channelId));
        if (threadState != null) {
            return Integer.valueOf(threadState.getCount());
        }
        return null;
    }

    @Store3
    public final void handleChannelDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        deleteForParentChannel(channel.getId());
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        Iterator<T> it = guilds.iterator();
        while (it.hasNext()) {
            updateFromGuild((Guild) it.next());
        }
    }

    @Store3
    public final void handleGuildCreate(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        updateFromGuild(guild);
    }

    @Store3
    public final void handleGuildDelete(long guildId) {
        deleteForGuild(guildId);
    }

    @Store3
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Channel channel = this.storeChannels.getChannel(message.getChannelId());
        if (channel == null || !ChannelUtils.H(channel)) {
            return;
        }
        ThreadState orAddState = getOrAddState(channel);
        this.threads.put(Long.valueOf(channel.getId()), ThreadState.copy$default(orAddState, 0L, 0L, 0L, _Ranges.coerceAtMost(orAddState.getCount() + 1, 50), new Message(message), 7, null));
        markChanged();
    }

    @Store3
    public final void handleMessageDelete(ModelMessageDelete messageDeleteBulk) {
        Message mostRecentMessage;
        Intrinsics3.checkNotNullParameter(messageDeleteBulk, "messageDeleteBulk");
        ThreadState threadState = this.threads.get(Long.valueOf(messageDeleteBulk.getChannelId()));
        Long lValueOf = (threadState == null || (mostRecentMessage = threadState.getMostRecentMessage()) == null) ? null : Long.valueOf(mostRecentMessage.getId());
        if (lValueOf != null) {
            lValueOf.longValue();
            Iterator<Long> it = messageDeleteBulk.getMessageIds().iterator();
            while (it.hasNext()) {
                if (!(!Intrinsics3.areEqual(lValueOf, it.next()))) {
                    this.threads.put(Long.valueOf(messageDeleteBulk.getChannelId()), ThreadState.copy$default(threadState, 0L, 0L, 0L, 0, null, 15, null));
                    markChanged();
                    return;
                }
            }
        }
    }

    @Store3
    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        Message mostRecentMessage;
        Intrinsics3.checkNotNullParameter(message, "message");
        ThreadState threadState = this.threads.get(Long.valueOf(message.getChannelId()));
        if (threadState == null || (mostRecentMessage = threadState.getMostRecentMessage()) == null || mostRecentMessage.getId() != message.getId()) {
            return;
        }
        this.threads.put(Long.valueOf(message.getChannelId()), ThreadState.copy$default(threadState, 0L, 0L, 0L, 0, this.storeMessages.getMessage(message.getChannelId(), message.getId()), 15, null));
        markChanged();
    }

    @Store3
    public final void handleMessagesLoaded(StoreMessagesLoader.ChannelChunk chunk) {
        Channel channel;
        Channel channel2;
        Intrinsics3.checkNotNullParameter(chunk, "chunk");
        boolean z2 = false;
        boolean z3 = false;
        for (Message message : chunk.getMessages()) {
            if (message.hasThread() && !this.threads.containsKey(Long.valueOf(message.getId())) && (channel2 = this.storeChannels.getThreadsByIdInternal$app_productionGoogleRelease().get(Long.valueOf(message.getId()))) != null) {
                updateFromThread(channel2);
                z3 = true;
            }
        }
        if (z3) {
            markChanged();
        }
        if (chunk.isPresent() && (channel = this.storeChannels.getThreadsByIdInternal$app_productionGoogleRelease().get(Long.valueOf(chunk.getChannelId()))) != null && ChannelUtils.H(channel)) {
            ThreadState orAddState = getOrAddState(channel);
            if (chunk.getMessages().isEmpty()) {
                this.threads.put(Long.valueOf(channel.getId()), ThreadState.copy$default(orAddState, 0L, 0L, 0L, 0, null, 7, null));
            } else {
                Message message2 = this.storeMessages.getMessage(chunk.getChannelId(), chunk.getMessages().get(0).getId());
                int size = chunk.getMessages().size();
                List<Message> messages = chunk.getMessages();
                if (!(messages instanceof Collection) || !messages.isEmpty()) {
                    Iterator<T> it = messages.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Integer type = ((Message) it.next()).getType();
                        if (type != null && type.intValue() == 21) {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (z2) {
                    size--;
                }
                Integer type2 = message2 != null ? message2.getType() : null;
                this.threads.put(Long.valueOf(channel.getId()), ThreadState.copy$default(orAddState, 0L, 0L, 0L, _Ranges.coerceAtMost(size, 50), (type2 != null && type2.intValue() == 21) ? null : message2, 7, null));
            }
            markChanged();
        }
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel thread) {
        Intrinsics3.checkNotNullParameter(thread, "thread");
        updateFromThread(thread);
    }

    @Store3
    public final void handleThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (this.threads.containsKey(Long.valueOf(channel.getId()))) {
            this.threads.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    @Store3
    public final void handleThreadListSync(ModelThreadListSync threadListSync) {
        Intrinsics3.checkNotNullParameter(threadListSync, "threadListSync");
        Iterator<T> it = threadListSync.getThreads().iterator();
        while (it.hasNext()) {
            updateFromThread((Channel) it.next());
        }
        List<com.discord.api.message.Message> mostRecentMessages = threadListSync.getMostRecentMessages();
        if (mostRecentMessages != null) {
            for (com.discord.api.message.Message message : mostRecentMessages) {
                ThreadState threadState = this.threads.get(Long.valueOf(message.getChannelId()));
                if (threadState != null) {
                    this.threads.put(Long.valueOf(message.getChannelId()), ThreadState.copy$default(threadState, 0L, 0L, 0L, 0, new Message(message), 15, null));
                }
            }
        }
    }

    public final Observable<Map<Long, ThreadState>> observeThreadCountAndLatestMessage() {
        Observable<Map<Long, ThreadState>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.threadsSnapshot = new HashMap(this.threads);
    }

    public StoreThreadMessages(StoreMessages storeMessages, StoreChannels storeChannels, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeMessages, "storeMessages");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeMessages = storeMessages;
        this.storeChannels = storeChannels;
        this.observationDeck = observationDeck;
        this.threads = new HashMap();
        this.threadsSnapshot = Maps6.emptyMap();
    }

    public final Observable<ThreadState> observeThreadCountAndLatestMessage(long channelId) {
        Observable<ThreadState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass2(channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }
}
