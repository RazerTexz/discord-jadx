package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.forum.ForumUnread;
import com.discord.api.forum.ForumUnreads;
import com.discord.api.message.Message;
import com.discord.api.user.User;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.updates.ObservationDeck;
import com.discord.widgets.forums.ForumUtils;
import d0.Tuples;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StoreForumPostReadStates.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010D\u001a\u00020C\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\bF\u0010GJ#\u0010\u0007\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u00030\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\t0\u0002¢\u0006\u0004\b\n\u0010\bJ%\u0010\u000f\u001a\u00020\u000e2\n\u0010\f\u001a\u00060\u0004j\u0002`\u000b2\n\u0010\r\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b!\u0010 J\u0017\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u000eH\u0016¢\u0006\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R \u0010,\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R \u0010.\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010-R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R&\u00109\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R&\u0010;\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010:R \u0010<\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010-R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lcom/discord/stores/StoreForumPostReadStates;", "Lcom/discord/stores/StoreV2;", "Lrx/Observable;", "", "", "Lcom/discord/primitives/ChannelId;", "", "observeThreadUnreadCounts", "()Lrx/Observable;", "", "observeThreadIdsWithPersistedReadStates", "Lcom/discord/primitives/GuildId;", "guildId", "channelId", "", "requestForumUnreads", "(JJ)V", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/api/message/Message;", "message", "handleMessageCreate", "(Lcom/discord/api/message/Message;)V", "Lcom/discord/models/domain/ModelReadState;", "readState", "handleMessageAck", "(Lcom/discord/models/domain/ModelReadState;)V", "Lcom/discord/api/channel/Channel;", "channel", "handleThreadCreateOrUpdate", "(Lcom/discord/api/channel/Channel;)V", "handleThreadDelete", "Lcom/discord/api/forum/ForumUnreads;", "forumUnreads", "handleForumUnreads", "(Lcom/discord/api/forum/ForumUnreads;)V", "snapshotData", "()V", "Lcom/discord/stores/StoreGatewayConnection;", "storeGatewayConnection", "Lcom/discord/stores/StoreGatewayConnection;", "", "threadIdsWithPersistedAcks", "Ljava/util/Set;", "processedForumUnreadRequests", "Lcom/discord/stores/StoreThreadsActive;", "storeThreadsActive", "Lcom/discord/stores/StoreThreadsActive;", "Lcom/discord/stores/StoreMessageAck;", "storeMessageAck", "Lcom/discord/stores/StoreMessageAck;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "", "threadUnreadCounts", "Ljava/util/Map;", "threadUnreadCountsSnapshot", "threadIdsWithPersistedAcksSnapshot", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreGatewayConnection;Lcom/discord/stores/StoreThreadsActive;Lcom/discord/stores/StoreMessageAck;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreUser;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreForumPostReadStates extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Set<Long> processedForumUnreadRequests;
    private final StoreChannels storeChannels;
    private final StoreGatewayConnection storeGatewayConnection;
    private final StoreMessageAck storeMessageAck;
    private final StoreThreadsActive storeThreadsActive;
    private final StoreUser storeUser;
    private final Set<Long> threadIdsWithPersistedAcks;
    private Set<Long> threadIdsWithPersistedAcksSnapshot;
    private final Map<Long, Integer> threadUnreadCounts;
    private Map<Long, Integer> threadUnreadCountsSnapshot;

    /* compiled from: StoreForumPostReadStates.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "invoke", "()Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreForumPostReadStates$observeThreadIdsWithPersistedReadStates$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Long> invoke2() {
            return StoreForumPostReadStates.access$getThreadIdsWithPersistedAcksSnapshot$p(StoreForumPostReadStates.this);
        }
    }

    /* compiled from: StoreForumPostReadStates.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreForumPostReadStates$observeThreadUnreadCounts$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Integer>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Integer> invoke2() {
            return StoreForumPostReadStates.access$getThreadUnreadCountsSnapshot$p(StoreForumPostReadStates.this);
        }
    }

    /* compiled from: StoreForumPostReadStates.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreForumPostReadStates$requestForumUnreads$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, this.$guildId, null, 2, null) || StoreForumPostReadStates.access$getProcessedForumUnreadRequests$p(StoreForumPostReadStates.this).contains(Long.valueOf(this.$channelId))) {
                return;
            }
            StoreForumPostReadStates.access$getProcessedForumUnreadRequests$p(StoreForumPostReadStates.this).add(Long.valueOf(this.$channelId));
            Map<Long, Channel> mapEmptyMap = StoreForumPostReadStates.access$getStoreThreadsActive$p(StoreForumPostReadStates.this).getAllActiveThreadsInternal$app_productionGoogleRelease().get(Long.valueOf(this.$guildId));
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Channel> entry : mapEmptyMap.entrySet()) {
                if (entry.getValue().getParentId() == this.$channelId) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Map<Long, StoreMessageAck.Ack> all = StoreForumPostReadStates.access$getStoreMessageAck$p(StoreForumPostReadStates.this).getAll();
            Set setKeySet = linkedHashMap.keySet();
            ArrayList arrayList = new ArrayList();
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                StoreMessageAck.Ack ack = all.get(Long.valueOf(jLongValue));
                Tuples2 tuples2 = ack != null ? Tuples.to(Long.valueOf(jLongValue), Long.valueOf(ack.getMessageId())) : null;
                if (tuples2 != null) {
                    arrayList.add(tuples2);
                }
            }
            StoreForumPostReadStates.access$getStoreGatewayConnection$p(StoreForumPostReadStates.this).requestForumUnreads(this.$guildId, this.$channelId, arrayList);
        }
    }

    public StoreForumPostReadStates(Dispatcher dispatcher, StoreGatewayConnection storeGatewayConnection, StoreThreadsActive storeThreadsActive, StoreMessageAck storeMessageAck, StoreChannels storeChannels, StoreUser storeUser, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeGatewayConnection, "storeGatewayConnection");
        Intrinsics3.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        Intrinsics3.checkNotNullParameter(storeMessageAck, "storeMessageAck");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeGatewayConnection = storeGatewayConnection;
        this.storeThreadsActive = storeThreadsActive;
        this.storeMessageAck = storeMessageAck;
        this.storeChannels = storeChannels;
        this.storeUser = storeUser;
        this.observationDeck = observationDeck;
        this.threadIdsWithPersistedAcks = new LinkedHashSet();
        this.threadIdsWithPersistedAcksSnapshot = Sets5.emptySet();
        this.threadUnreadCounts = new LinkedHashMap();
        this.threadUnreadCountsSnapshot = Maps6.emptyMap();
        this.processedForumUnreadRequests = new LinkedHashSet();
    }

    public static final /* synthetic */ Set access$getProcessedForumUnreadRequests$p(StoreForumPostReadStates storeForumPostReadStates) {
        return storeForumPostReadStates.processedForumUnreadRequests;
    }

    public static final /* synthetic */ StoreGatewayConnection access$getStoreGatewayConnection$p(StoreForumPostReadStates storeForumPostReadStates) {
        return storeForumPostReadStates.storeGatewayConnection;
    }

    public static final /* synthetic */ StoreMessageAck access$getStoreMessageAck$p(StoreForumPostReadStates storeForumPostReadStates) {
        return storeForumPostReadStates.storeMessageAck;
    }

    public static final /* synthetic */ StoreThreadsActive access$getStoreThreadsActive$p(StoreForumPostReadStates storeForumPostReadStates) {
        return storeForumPostReadStates.storeThreadsActive;
    }

    public static final /* synthetic */ Set access$getThreadIdsWithPersistedAcksSnapshot$p(StoreForumPostReadStates storeForumPostReadStates) {
        return storeForumPostReadStates.threadIdsWithPersistedAcksSnapshot;
    }

    public static final /* synthetic */ Map access$getThreadUnreadCountsSnapshot$p(StoreForumPostReadStates storeForumPostReadStates) {
        return storeForumPostReadStates.threadUnreadCountsSnapshot;
    }

    public static final /* synthetic */ void access$setThreadIdsWithPersistedAcksSnapshot$p(StoreForumPostReadStates storeForumPostReadStates, Set set) {
        storeForumPostReadStates.threadIdsWithPersistedAcksSnapshot = set;
    }

    public static final /* synthetic */ void access$setThreadUnreadCountsSnapshot$p(StoreForumPostReadStates storeForumPostReadStates, Map map) {
        storeForumPostReadStates.threadUnreadCountsSnapshot = map;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        ModelPayload.VersionedReadStates readState = payload.getReadState();
        Intrinsics3.checkNotNullExpressionValue(readState, "payload.readState");
        if (!readState.isPartial()) {
            this.threadIdsWithPersistedAcks.clear();
        }
        this.processedForumUnreadRequests.clear();
        this.threadUnreadCounts.clear();
        ModelPayload.VersionedReadStates readState2 = payload.getReadState();
        Intrinsics3.checkNotNullExpressionValue(readState2, "payload.readState");
        List<ModelReadState> entries = readState2.getEntries();
        Intrinsics3.checkNotNullExpressionValue(entries, "payload.readState.entries");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(entries, 10));
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((ModelReadState) it.next()).getChannelId()));
        }
        this.threadIdsWithPersistedAcks.addAll(arrayList);
        markChanged();
    }

    @Store3
    public final void handleForumUnreads(ForumUnreads forumUnreads) {
        Intrinsics3.checkNotNullParameter(forumUnreads, "forumUnreads");
        if (forumUnreads.getPermissionDenied()) {
            return;
        }
        for (ForumUnread forumUnread : forumUnreads.b()) {
            Map<Long, Integer> map = this.threadUnreadCounts;
            Long lValueOf = Long.valueOf(forumUnread.getThreadId());
            Integer count = forumUnread.getCount();
            map.put(lValueOf, Integer.valueOf(count != null ? count.intValue() : 0));
        }
        markChanged();
    }

    @Store3
    public final void handleMessageAck(ModelReadState readState) {
        Intrinsics3.checkNotNullParameter(readState, "readState");
        long channelId = readState.getChannelId();
        if (this.threadUnreadCounts.containsKey(Long.valueOf(channelId))) {
            this.threadUnreadCounts.put(Long.valueOf(channelId), 0);
            markChanged();
        }
    }

    @Store3
    public final void handleMessageCreate(Message message) {
        Channel channel;
        Intrinsics3.checkNotNullParameter(message, "message");
        long channelId = message.getChannelId();
        Channel channel2 = this.storeChannels.getChannel(channelId);
        if (channel2 == null || (channel = this.storeChannels.getChannel(channel2.getParentId())) == null || !ChannelUtils.r(channel2, channel)) {
            return;
        }
        User author = message.getAuthor();
        if (author == null || author.getId() != this.storeUser.getMeSnapshot().getId()) {
            Integer num = this.threadUnreadCounts.get(Long.valueOf(channelId));
            this.threadUnreadCounts.put(Long.valueOf(channelId), Integer.valueOf((num != null ? num.intValue() : 0) + 1));
        } else {
            this.threadUnreadCounts.put(Long.valueOf(channelId), 0);
        }
        markChanged();
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (!ChannelUtils.j(channel) || this.threadUnreadCounts.remove(Long.valueOf(channel.getId())) == null) {
            return;
        }
        markChanged();
    }

    @Store3
    public final void handleThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (this.threadUnreadCounts.remove(Long.valueOf(channel.getId())) != null) {
            markChanged();
        }
    }

    public final Observable<Set<Long>> observeThreadIdsWithPersistedReadStates() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Map<Long, Integer>> observeThreadUnreadCounts() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final void requestForumUnreads(long guildId, long channelId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, channelId));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.threadIdsWithPersistedAcksSnapshot = new HashSet(this.threadIdsWithPersistedAcks);
        this.threadUnreadCountsSnapshot = new HashMap(this.threadUnreadCounts);
    }
}
