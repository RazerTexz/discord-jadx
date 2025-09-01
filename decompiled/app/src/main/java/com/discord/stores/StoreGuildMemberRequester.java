package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.guildmember.GuildMembersChunk;
import com.discord.api.user.User;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.utilities.lazy.requester.GuildMemberRequestManager;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: StoreGuildMemberRequester.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b4\u00105J)\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0003¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000e\u001a\u00020\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\f\u001a\u00060\u0002j\u0002`\u000bH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0012\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u000b0\u0010H\u0003¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\f\u001a\u00060\u0002j\u0002`\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001b\u0010\u0017J)\u0010\u001f\u001a\u00020\b2\n\u0010\u001d\u001a\u00060\u0002j\u0002`\u001c2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R6\u0010/\u001a\"\u0012\b\u0012\u00060\u0002j\u0002`\u001c\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`.\u0012\u0004\u0012\u00020\u00060-0,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/discord/stores/StoreGuildMemberRequester;", "Lcom/discord/stores/Store;", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "Lcom/discord/models/message/Message;", "messages", "", "requestForMessages", "(JLjava/lang/Iterable;)V", "Lcom/discord/primitives/UserId;", "userId", "", "guildMemberExists", "(JJ)Z", "", "userIds", "sendRequests", "(JLjava/util/List;)V", "queueRequest", "(JJ)V", "performQueuedRequests", "()V", "isConnected", "handleConnectionReady", "(Z)V", "handleConnectionOpen", "Lcom/discord/primitives/ChannelId;", "channelId", "", "handleLoadMessages", "(JLjava/util/Collection;)V", "Lcom/discord/api/guildmember/GuildMembersChunk;", "chunk", "handleGuildMembersChunk", "(Lcom/discord/api/guildmember/GuildMembersChunk;)V", "Lcom/discord/utilities/lazy/requester/GuildMemberRequestManager;", "requestManager", "Lcom/discord/utilities/lazy/requester/GuildMemberRequestManager;", "Z", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Ljava/util/TreeMap;", "", "Lcom/discord/primitives/MessageId;", "channelPendingMessages", "Ljava/util/TreeMap;", "Lcom/discord/stores/StoreStream;", "collector", "Lcom/discord/stores/StoreStream;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildMemberRequester extends Store {
    private final TreeMap<Long, Map<Long, Message>> channelPendingMessages;
    private final StoreStream collector;
    private final Dispatcher dispatcher;
    private boolean isConnected;
    private final GuildMemberRequestManager requestManager;

    /* compiled from: StoreGuildMemberRequester.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildMemberRequester$performQueuedRequests$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildMemberRequester.access$getRequestManager$p(StoreGuildMemberRequester.this).flush();
        }
    }

    /* compiled from: StoreGuildMemberRequester.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildMemberRequester$queueRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildMemberRequester.access$getRequestManager$p(StoreGuildMemberRequester.this).queueRequest(this.$guildId, this.$userId);
        }
    }

    public StoreGuildMemberRequester(StoreStream storeStream, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(storeStream, "collector");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.collector = storeStream;
        this.dispatcher = dispatcher;
        this.requestManager = new GuildMemberRequestManager(new StoreGuildMemberRequester2(this), new StoreGuildMemberRequester3(this));
        this.channelPendingMessages = new TreeMap<>();
    }

    public static final /* synthetic */ GuildMemberRequestManager access$getRequestManager$p(StoreGuildMemberRequester storeGuildMemberRequester) {
        return storeGuildMemberRequester.requestManager;
    }

    public static final /* synthetic */ boolean access$guildMemberExists(StoreGuildMemberRequester storeGuildMemberRequester, long j, long j2) {
        return storeGuildMemberRequester.guildMemberExists(j, j2);
    }

    public static final /* synthetic */ void access$sendRequests(StoreGuildMemberRequester storeGuildMemberRequester, long j, List list) {
        storeGuildMemberRequester.sendRequests(j, list);
    }

    @Store3
    private final boolean guildMemberExists(long guildId, long userId) {
        Map<Long, GuildMember> map = this.collector.getGuilds().getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        return (map != null ? map.get(Long.valueOf(userId)) : null) != null;
    }

    @Store3
    private final void requestForMessages(long guildId, Iterable<Message> messages) {
        for (Message message : messages) {
            User author = message.getAuthor();
            if (author != null) {
                this.requestManager.queueRequest(guildId, author.getId());
            }
            List<User> mentions = message.getMentions();
            if (mentions != null) {
                Iterator<T> it = mentions.iterator();
                while (it.hasNext()) {
                    this.requestManager.queueRequest(guildId, ((User) it.next()).getId());
                }
            }
        }
    }

    @Store3
    private final void sendRequests(long guildId, List<Long> userIds) {
        StoreGatewayConnection.requestGuildMembers$default(this.collector.getGatewaySocket(), guildId, null, userIds, null, 2, null);
    }

    @Store3
    public final void handleConnectionOpen() {
        this.isConnected = true;
        this.requestManager.reset();
        for (Map.Entry<Long, Map<Long, Message>> entry : this.channelPendingMessages.entrySet()) {
            handleLoadMessages(entry.getKey().longValue(), entry.getValue().values());
        }
        this.channelPendingMessages.clear();
    }

    @Store3
    public final void handleConnectionReady(boolean isConnected) {
        this.isConnected = isConnected;
        if (isConnected) {
            this.requestManager.requestUnacknowledged();
        }
    }

    @Store3
    public final void handleGuildMembersChunk(GuildMembersChunk chunk) {
        Intrinsics3.checkNotNullParameter(chunk, "chunk");
        long guildId = chunk.getGuildId();
        List<com.discord.api.guildmember.GuildMember> listB = chunk.b();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listB, 10));
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.discord.api.guildmember.GuildMember) it.next()).getUser());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.requestManager.acknowledge(guildId, ((User) it2.next()).getId());
        }
        List<Long> listC = chunk.c();
        if (listC != null) {
            Iterator<T> it3 = listC.iterator();
            while (it3.hasNext()) {
                this.requestManager.acknowledge(guildId, ((Number) it3.next()).longValue());
            }
        }
    }

    @Store3
    public final void handleLoadMessages(long channelId, Collection<Message> messages) {
        Intrinsics3.checkNotNullParameter(messages, "messages");
        if (!this.isConnected) {
            Map map = this.channelPendingMessages.get(Long.valueOf(channelId));
            if (map == null) {
                map = new HashMap(messages.size());
            }
            for (Object obj : messages) {
                map.put(Long.valueOf(((Message) obj).getId()), obj);
            }
            this.channelPendingMessages.put(Long.valueOf(channelId), map);
            return;
        }
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.collector.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            Long lValueOf = Long.valueOf(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId());
            if (!(lValueOf.longValue() > 0)) {
                lValueOf = null;
            }
            if (lValueOf != null) {
                requestForMessages(lValueOf.longValue(), messages);
                this.requestManager.flush();
            }
        }
    }

    public final void performQueuedRequests() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void queueRequest(long guildId, long userId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, userId));
    }
}
