package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.message.Message;
import com.discord.models.domain.ModelChannelUnreadUpdate;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.collections.CollectionExtensions;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.persister.Persister;
import com.discord.widgets.forums.ForumUtils;
import d0.t.CollectionsJVM;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreMessagesMostRecent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010A\u001a\u00020@\u0012\b\b\u0002\u00107\u001a\u000206¢\u0006\u0004\bC\u0010DJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\n\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0018\u001a\u00020\u00102\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u00142\n\u0010\u0017\u001a\u00060\u0013j\u0002`\u0016H\u0003¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001b\u001a\u0016\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\b\u0012\u00060\u0013j\u0002`\u00160\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\b\u0012\u00060\u0013j\u0002`\u00160\u001a0\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\u001e\u001a\f\u0012\b\u0012\u00060\u0013j\u0002`\u00160\u001d2\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014¢\u0006\u0004\b\u001e\u0010 J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0007¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0007¢\u0006\u0004\b+\u0010*J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\fH\u0007¢\u0006\u0004\b-\u0010\u000eJ\u0017\u0010/\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020.H\u0007¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b1\u0010\u0006J\u000f\u00102\u001a\u00020\u0004H\u0017¢\u0006\u0004\b2\u00103R*\u00104\u001a\u0016\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\b\u0012\u00060\u0013j\u0002`\u00160\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R0\u0010:\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\b\u0012\u00060\u0013j\u0002`\u00160\u001a098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;RB\u0010>\u001a.\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\b\u0012\u00060\u0013j\u0002`\u00160<j\u0016\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\b\u0012\u00060\u0013j\u0002`\u0016`=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006E"}, d2 = {"Lcom/discord/stores/StoreMessagesMostRecent;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/api/message/Message;", "message", "", "mostRecentIdsUpdateFromMessage", "(Lcom/discord/api/message/Message;)V", "", "Lcom/discord/api/channel/Channel;", "channels", "mostRecentIdsUpdateFromChannels", "(Ljava/util/Collection;)V", "Lcom/discord/models/domain/ModelChannelUnreadUpdate;", "channelUnreadUpdate", "(Lcom/discord/models/domain/ModelChannelUnreadUpdate;)V", "channel", "", "updateParentChannelMostRecentIds", "(Lcom/discord/api/channel/Channel;)Z", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/MessageId;", "messageId", "updateMostRecentIds", "(JJ)Z", "", "getMostRecentIds", "()Ljava/util/Map;", "Lrx/Observable;", "observeRecentMessageIds", "()Lrx/Observable;", "(J)Lrx/Observable;", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/api/guild/Guild;", "guild", "handleGuildAdd", "(Lcom/discord/api/guild/Guild;)V", "handleChannelCreateOrUpdate", "(Lcom/discord/api/channel/Channel;)V", "handleThreadCreateOrUpdate", "channelReadStateUpdate", "handleChannelUnreadUpdate", "Lcom/discord/models/thread/dto/ModelThreadListSync;", "handleThreadListSync", "(Lcom/discord/models/thread/dto/ModelThreadListSync;)V", "handleMessageCreate", "snapshotData", "()V", "mostRecentIdsSnapshot", "Ljava/util/Map;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/utilities/persister/Persister;", "mostRecentIdsCache", "Lcom/discord/utilities/persister/Persister;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mostRecentIds", "Ljava/util/HashMap;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "<init>", "(Lcom/discord/stores/StoreChannels;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreMessagesMostRecent extends StoreV2 {
    private final HashMap<Long, Long> mostRecentIds;
    private final Persister<Map<Long, Long>> mostRecentIdsCache;
    private Map<Long, Long> mostRecentIdsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;

    /* compiled from: StoreMessagesMostRecent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/primitives/MessageId;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesMostRecent$observeRecentMessageIds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Long> invoke2() {
            return StoreMessagesMostRecent.this.getMostRecentIds();
        }
    }

    /* compiled from: StoreMessagesMostRecent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\u0014 \u0004*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00030\u0001j\u0002`\u000326\u0010\u0005\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u0003 \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/primitives/MessageId;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesMostRecent$observeRecentMessageIds$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Map<Long, ? extends Long>, Long> {
        public final /* synthetic */ long $channelId;

        public AnonymousClass2(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Long call(Map<Long, ? extends Long> map) {
            return call2((Map<Long, Long>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(Map<Long, Long> map) {
            Long l = map.get(Long.valueOf(this.$channelId));
            return Long.valueOf(l != null ? l.longValue() : 0L);
        }
    }

    public /* synthetic */ StoreMessagesMostRecent(StoreChannels storeChannels, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeChannels, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    @Store3
    private final void mostRecentIdsUpdateFromChannels(ModelChannelUnreadUpdate channelUnreadUpdate) {
        for (ModelReadState modelReadState : channelUnreadUpdate.getChannelReadStates()) {
            if (updateMostRecentIds(modelReadState.getChannelId(), modelReadState.getLastMessageId())) {
                markChanged();
            }
        }
    }

    @Store3
    private final void mostRecentIdsUpdateFromMessage(Message message) {
        if (updateMostRecentIds(message.getChannelId(), message.getId())) {
            markChanged();
        }
    }

    @Store3
    private final boolean updateMostRecentIds(long channelId, long messageId) {
        boolean z2 = MessageUtils.compareMessages(this.mostRecentIds.get(Long.valueOf(channelId)), Long.valueOf(messageId)) < 0;
        if (z2) {
            this.mostRecentIds.put(Long.valueOf(channelId), Long.valueOf(messageId));
        }
        return z2;
    }

    @Store3
    private final boolean updateParentChannelMostRecentIds(Channel channel) {
        Channel channel2;
        if (ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, 2, null) && ChannelUtils.H(channel) && !ChannelUtils.j(channel) && (channel2 = this.storeChannels.getChannel(channel.getParentId())) != null && ChannelUtils.q(channel2)) {
            return updateMostRecentIds(channel2.getId(), channel.getId());
        }
        return false;
    }

    public final Map<Long, Long> getMostRecentIds() {
        return this.mostRecentIdsSnapshot;
    }

    @Store3
    public final void handleChannelCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        mostRecentIdsUpdateFromChannels(CollectionsJVM.listOf(channel));
    }

    @Store3
    public final void handleChannelUnreadUpdate(ModelChannelUnreadUpdate channelReadStateUpdate) {
        Intrinsics3.checkNotNullParameter(channelReadStateUpdate, "channelReadStateUpdate");
        mostRecentIdsUpdateFromChannels(channelReadStateUpdate);
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        Collection<Channel> privateChannels = payload.getPrivateChannels();
        Intrinsics3.checkNotNullExpressionValue(privateChannels, "payload.privateChannels");
        mostRecentIdsUpdateFromChannels(privateChannels);
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            Collection<Channel> collectionG = guild.g();
            if (collectionG != null) {
                mostRecentIdsUpdateFromChannels(collectionG);
            }
            List<Channel> listN = guild.N();
            if (listN != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : listN) {
                    if (ChannelUtils.H((Channel) obj)) {
                        arrayList.add(obj);
                    }
                }
                mostRecentIdsUpdateFromChannels(arrayList);
            }
        }
        markChanged();
    }

    @Store3
    public final void handleGuildAdd(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Collection<Channel> collectionG = guild.g();
        if (collectionG != null) {
            mostRecentIdsUpdateFromChannels(collectionG);
        }
        List<Channel> listN = guild.N();
        if (listN != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listN) {
                if (ChannelUtils.H((Channel) obj)) {
                    arrayList.add(obj);
                }
            }
            mostRecentIdsUpdateFromChannels(arrayList);
        }
    }

    @Store3
    public final void handleMessageCreate(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        mostRecentIdsUpdateFromMessage(message);
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.H(channel)) {
            mostRecentIdsUpdateFromChannels(CollectionsJVM.listOf(channel));
        }
    }

    @Store3
    public final void handleThreadListSync(ModelThreadListSync payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<Channel> threads = payload.getThreads();
        ArrayList arrayList = new ArrayList();
        for (Object obj : threads) {
            if (ChannelUtils.H((Channel) obj)) {
                arrayList.add(obj);
            }
        }
        mostRecentIdsUpdateFromChannels(arrayList);
    }

    public final Observable<Map<Long, Long>> observeRecentMessageIds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        HashMap mapSnapshot$default = CollectionExtensions.snapshot$default(this.mostRecentIds, 0, 0.0f, 3, null);
        this.mostRecentIdsSnapshot = mapSnapshot$default;
        Persister.set$default(this.mostRecentIdsCache, mapSnapshot$default, false, 2, null);
    }

    public StoreMessagesMostRecent(StoreChannels storeChannels, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeChannels = storeChannels;
        this.observationDeck = observationDeck;
        HashMap<Long, Long> map = new HashMap<>();
        this.mostRecentIds = map;
        this.mostRecentIdsSnapshot = Maps6.emptyMap();
        this.mostRecentIdsCache = new Persister<>("MOST_RECENT_MESSAGE_IDS", new HashMap(map));
    }

    public final Observable<Long> observeRecentMessageIds(long channelId) {
        Observable<Long> observableR = observeRecentMessageIds().G(new AnonymousClass2(channelId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeRecentMessageIds(…  .distinctUntilChanged()");
        return observableR;
    }

    @Store3
    private final void mostRecentIdsUpdateFromChannels(Collection<Channel> channels) {
        for (Channel channel : channels) {
            if (ChannelUtils.G(channel)) {
                boolean zUpdateMostRecentIds = updateMostRecentIds(channel.getId(), channel.getLastMessageId());
                boolean zUpdateParentChannelMostRecentIds = updateParentChannelMostRecentIds(channel);
                if (zUpdateMostRecentIds || zUpdateParentChannelMostRecentIds) {
                    markChanged();
                }
            }
        }
    }
}
