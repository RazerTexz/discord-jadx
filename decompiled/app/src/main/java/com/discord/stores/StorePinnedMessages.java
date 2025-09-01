package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.message.Message;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StorePinnedMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u00013B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b1\u00102J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u000b\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0003¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0010¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0016\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0014\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00100\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010$\u001a\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R,\u0010)\u001a\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R,\u0010-\u001a\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0,0+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010*R \u0010/\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/discord/stores/StorePinnedMessages;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "loadPinnedMessages", "(J)V", "", "Lcom/discord/models/message/Message;", "messages", "handlePinnedMessagesLoaded", "(JLjava/util/List;)V", "Lrx/Observable;", "observeForChannel", "(J)Lrx/Observable;", "Lcom/discord/primitives/MessageId;", "messageId", "observePinnedMessage", "(JJ)Lrx/Observable;", "", "messageIds", "handleMessageDeleteBulk", "(JLjava/util/Collection;)V", "Lcom/discord/api/message/Message;", "updatedMessage", "handleMessageUpdate", "(Lcom/discord/api/message/Message;)V", "snapshotData", "()V", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "getDispatcher", "()Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "getObservationDeck", "()Lcom/discord/stores/updates/ObservationDeck;", "", "pinnedMessagesSnapshot", "Ljava/util/Map;", "", "", "pinnedMessages", "", "updatedChannelIds", "Ljava/util/Set;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StorePinnedMessages extends StoreV2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Map<Long, List<Message>> pinnedMessages;
    private Map<Long, ? extends List<Message>> pinnedMessagesSnapshot;
    private final Set<Long> updatedChannelIds;

    /* compiled from: StorePinnedMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ-\u0010\f\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/stores/StorePinnedMessages$Companion;", "", "", "Lcom/discord/models/message/Message;", "channelPinnedMessages", "", "Lcom/discord/primitives/MessageId;", "messageId", "", "getMessageIndex", "(Ljava/util/List;J)I", "channelMessages", "getMessage", "(Ljava/util/List;J)Lcom/discord/models/message/Message;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Message access$getMessage(Companion companion, List list, long j) {
            return companion.getMessage(list, j);
        }

        public static final /* synthetic */ int access$getMessageIndex(Companion companion, List list, long j) {
            return companion.getMessageIndex(list, j);
        }

        private final Message getMessage(List<Message> channelMessages, long messageId) {
            Object obj = null;
            if (channelMessages == null) {
                return null;
            }
            Iterator<T> it = channelMessages.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((Message) next).getId() == messageId) {
                    obj = next;
                    break;
                }
            }
            return (Message) obj;
        }

        private final int getMessageIndex(List<Message> channelPinnedMessages, long messageId) {
            Iterator<Message> it = channelPinnedMessages.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().getId() == messageId) {
                    return i;
                }
                i++;
            }
            return -1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StorePinnedMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0002*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00000\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/api/message/Message;", "kotlin.jvm.PlatformType", "messages", "Lcom/discord/models/message/Message;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StorePinnedMessages$loadPinnedMessages$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<List<? extends com.discord.api.message.Message>, List<? extends Message>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends Message> call(List<? extends com.discord.api.message.Message> list) {
            return call2((List<com.discord.api.message.Message>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Message> call2(List<com.discord.api.message.Message> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "messages");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Message((com.discord.api.message.Message) it.next()));
            }
            return arrayList;
        }
    }

    /* compiled from: StorePinnedMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/models/message/Message;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StorePinnedMessages$loadPinnedMessages$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends Message>, Unit> {
        public final /* synthetic */ long $channelId;

        /* compiled from: StorePinnedMessages.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StorePinnedMessages$loadPinnedMessages$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$it = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StorePinnedMessages storePinnedMessages = StorePinnedMessages.this;
                long j = anonymousClass2.$channelId;
                List list = this.$it;
                Intrinsics3.checkNotNullExpressionValue(list, "it");
                StorePinnedMessages.access$handlePinnedMessagesLoaded(storePinnedMessages, j, list);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Message> list) {
            invoke2((List<Message>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Message> list) {
            StorePinnedMessages.this.getDispatcher().schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StorePinnedMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/models/message/Message;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StorePinnedMessages$observeForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends Message>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends Message> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends Message> invoke2() {
            List<? extends Message> list = (List) StorePinnedMessages.access$getPinnedMessages$p(StorePinnedMessages.this).get(Long.valueOf(this.$channelId));
            return list != null ? list : Collections2.emptyList();
        }
    }

    /* compiled from: StorePinnedMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/models/message/Message;", "invoke", "()Lcom/discord/models/message/Message;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StorePinnedMessages$observePinnedMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Message> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$channelId = j;
            this.$messageId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Message invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Message invoke() {
            List listEmptyList = (List) StorePinnedMessages.access$getPinnedMessages$p(StorePinnedMessages.this).get(Long.valueOf(this.$channelId));
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            return Companion.access$getMessage(StorePinnedMessages.INSTANCE, listEmptyList, this.$messageId);
        }
    }

    public StorePinnedMessages(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.pinnedMessages = new HashMap();
        this.pinnedMessagesSnapshot = new HashMap();
        this.updatedChannelIds = new HashSet();
    }

    public static final /* synthetic */ Map access$getPinnedMessages$p(StorePinnedMessages storePinnedMessages) {
        return storePinnedMessages.pinnedMessages;
    }

    public static final /* synthetic */ void access$handlePinnedMessagesLoaded(StorePinnedMessages storePinnedMessages, long j, List list) {
        storePinnedMessages.handlePinnedMessagesLoaded(j, list);
    }

    @Store3
    private final void handlePinnedMessagesLoaded(long channelId, List<Message> messages) {
        this.pinnedMessages.put(Long.valueOf(channelId), _Collections.toMutableList((Collection) messages));
        this.updatedChannelIds.add(Long.valueOf(channelId));
        markChanged();
    }

    private final void loadPinnedMessages(long channelId) {
        if (this.pinnedMessagesSnapshot.containsKey(Long.valueOf(channelId))) {
            return;
        }
        Observable observableG = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getChannelPins(channelId), false, 1, null).G(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "api\n        .getChannelP…messages.map(::Message) }");
        ObservableExtensionsKt.appSubscribe$default(observableG, StorePinnedMessages.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(channelId), 62, (Object) null);
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    @Store3
    public final void handleMessageDeleteBulk(long channelId, Collection<Long> messageIds) {
        Intrinsics3.checkNotNullParameter(messageIds, "messageIds");
        List<Message> list = this.pinnedMessages.get(Long.valueOf(channelId));
        if (list != null) {
            Iterator<Message> it = list.iterator();
            while (it.hasNext()) {
                if (messageIds.contains(Long.valueOf(it.next().getId()))) {
                    it.remove();
                    this.updatedChannelIds.add(Long.valueOf(channelId));
                }
            }
            if (!this.updatedChannelIds.isEmpty()) {
                markChanged();
            }
        }
    }

    @Store3
    public final void handleMessageUpdate(com.discord.api.message.Message updatedMessage) {
        UtcDateTime timestamp;
        Intrinsics3.checkNotNullParameter(updatedMessage, "updatedMessage");
        long channelId = updatedMessage.getChannelId();
        long id2 = updatedMessage.getId();
        boolean zAreEqual = Intrinsics3.areEqual(updatedMessage.getPinned(), Boolean.TRUE);
        List<Message> list = this.pinnedMessages.get(Long.valueOf(channelId));
        if (list != null) {
            int iAccess$getMessageIndex = Companion.access$getMessageIndex(INSTANCE, list, id2);
            if (iAccess$getMessageIndex != -1) {
                if (zAreEqual) {
                    list.set(iAccess$getMessageIndex, list.get(iAccess$getMessageIndex).merge(updatedMessage));
                } else {
                    list.remove(iAccess$getMessageIndex);
                }
                this.updatedChannelIds.add(Long.valueOf(channelId));
                markChanged();
                return;
            }
            if (zAreEqual) {
                UtcDateTime timestamp2 = updatedMessage.getTimestamp();
                long dateTimeMillis = 0;
                long dateTimeMillis2 = timestamp2 != null ? timestamp2.getDateTimeMillis() : 0L;
                int i = 0;
                if (list.size() > 0 && (timestamp = list.get(0).getTimestamp()) != null) {
                    dateTimeMillis = timestamp.getDateTimeMillis();
                }
                while (i < list.size() && dateTimeMillis2 < dateTimeMillis) {
                    i++;
                }
                list.add(i, new Message(updatedMessage));
                this.updatedChannelIds.add(Long.valueOf(channelId));
                markChanged();
            }
        }
    }

    public final Observable<List<Message>> observeForChannel(long channelId) {
        loadPinnedMessages(channelId);
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null);
    }

    public final Observable<Message> observePinnedMessage(long channelId, long messageId) {
        Observable<Message> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId, messageId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        HashMap map = new HashMap(this.pinnedMessages);
        Iterator<Long> it = this.updatedChannelIds.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            Long lValueOf = Long.valueOf(jLongValue);
            List listEmptyList = (List) map.get(Long.valueOf(jLongValue));
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            map.put(lValueOf, new ArrayList(listEmptyList));
        }
        this.pinnedMessagesSnapshot = map;
        this.updatedChannelIds.clear();
    }
}
