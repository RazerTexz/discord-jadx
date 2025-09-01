package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.api.message.MessageReference;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.message.Message;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreMessageReplies.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0003EFGB!\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00102\u001a\u000201\u0012\b\b\u0002\u00109\u001a\u000208¢\u0006\u0004\bC\u0010DJ+\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\b\u0010\tJ/\u0010\r\u001a\u00020\f2\n\u0010\n\u001a\u00060\u0002j\u0002`\u00062\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0010\u001a\u00020\u000f2\n\u0010\n\u001a\u00060\u0002j\u0002`\u00062\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0012H\u0003¢\u0006\u0004\b\u0018\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\fH\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ/\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u001e2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010!\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b!\u0010\"J\u001d\u0010%\u001a\u00020\f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120#H\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b)\u0010(J\u0017\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020*H\u0007¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\fH\u0016¢\u0006\u0004\b.\u0010\u001cR6\u0010/\u001a\"\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R&\u00107\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00100R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R&\u0010<\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=RN\u0010A\u001a:\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00060?0>j\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00060?`@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006H"}, d2 = {"Lcom/discord/stores/StoreMessageReplies;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "Lcom/discord/primitives/MessageId;", "Lcom/discord/stores/StoreMessageReplies$MessageState;", "getCachedChannelMessages", "(J)Ljava/util/Map;", "messageId", "messageState", "", "updateCache", "(JJLcom/discord/stores/StoreMessageReplies$MessageState;)V", "", "deleteMessage", "(JJ)Z", "Lcom/discord/models/message/Message;", "referencedMessage", "processReferencedMessage", "(Lcom/discord/models/message/Message;)V", "Lcom/discord/api/message/Message;", "message", "processMessage", "(Lcom/discord/api/message/Message;)Z", "(Lcom/discord/models/message/Message;)Z", "snapShotChannelMessages", "()V", "snapShotAllMessages", "Lrx/Observable;", "observeMessageReferencesForChannel", "(J)Lrx/Observable;", "getAllMessageReferences", "()Ljava/util/Map;", "", "messages", "handleLoadMessages", "(Ljava/util/Collection;)V", "handleMessageCreate", "(Lcom/discord/api/message/Message;)V", "handleMessageUpdate", "Lcom/discord/models/domain/ModelMessageDelete;", "messageDeleteBulk", "handleMessageDelete", "(Lcom/discord/models/domain/ModelMessageDelete;)V", "snapshotData", "repliedChannelMessagesCacheSnapshot", "Ljava/util/Map;", "Lcom/discord/stores/StoreMessages;", "storeMessages", "Lcom/discord/stores/StoreMessages;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "repliedMessagesCacheSnapshot", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreMessageReplies$MessageCache;", "repliedMessagesCache", "Lcom/discord/stores/StoreMessageReplies$MessageCache;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "channelMap", "Ljava/util/HashMap;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreMessages;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "MessageCache", "MessageState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreMessageReplies extends StoreV2 {
    private static final Map<Long, MessageState> NO_RESULTS = Maps6.emptyMap();
    private final HashMap<Long, Set<Long>> channelMap;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private Map<Long, ? extends Map<Long, ? extends MessageState>> repliedChannelMessagesCacheSnapshot;
    private final MessageCache<Long, MessageState> repliedMessagesCache;
    private Map<Long, ? extends MessageState> repliedMessagesCacheSnapshot;
    private final StoreMessages storeMessages;

    /* compiled from: StoreMessageReplies.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0004B\u0007¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/stores/StoreMessageReplies$MessageCache;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "", "eldest", "", "removeEldestEntry", "(Ljava/util/Map$Entry;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class MessageCache<K, V> extends LinkedHashMap<K, V> {
        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
            return getEntries();
        }

        public /* bridge */ Set getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set getKeys() {
            return super.keySet();
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<K> keySet() {
            return getKeys();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > 1000;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<V> values() {
            return getValues();
        }
    }

    /* compiled from: StoreMessageReplies.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/stores/StoreMessageReplies$MessageState;", "", "<init>", "()V", "Deleted", "Loaded", "Unloaded", "Lcom/discord/stores/StoreMessageReplies$MessageState$Deleted;", "Lcom/discord/stores/StoreMessageReplies$MessageState$Unloaded;", "Lcom/discord/stores/StoreMessageReplies$MessageState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class MessageState {

        /* compiled from: StoreMessageReplies.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreMessageReplies$MessageState$Deleted;", "Lcom/discord/stores/StoreMessageReplies$MessageState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Deleted extends MessageState {
            public static final Deleted INSTANCE = new Deleted();

            private Deleted() {
                super(null);
            }
        }

        /* compiled from: StoreMessageReplies.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/stores/StoreMessageReplies$MessageState$Loaded;", "Lcom/discord/stores/StoreMessageReplies$MessageState;", "Lcom/discord/models/message/Message;", "component1", "()Lcom/discord/models/message/Message;", "message", "copy", "(Lcom/discord/models/message/Message;)Lcom/discord/stores/StoreMessageReplies$MessageState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/message/Message;", "getMessage", "<init>", "(Lcom/discord/models/message/Message;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends MessageState {
            private final Message message;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Message message) {
                super(null);
                Intrinsics3.checkNotNullParameter(message, "message");
                this.message = message;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Message message, int i, Object obj) {
                if ((i & 1) != 0) {
                    message = loaded.message;
                }
                return loaded.copy(message);
            }

            /* renamed from: component1, reason: from getter */
            public final Message getMessage() {
                return this.message;
            }

            public final Loaded copy(Message message) {
                Intrinsics3.checkNotNullParameter(message, "message");
                return new Loaded(message);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.message, ((Loaded) other).message);
                }
                return true;
            }

            public final Message getMessage() {
                return this.message;
            }

            public int hashCode() {
                Message message = this.message;
                if (message != null) {
                    return message.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(message=");
                sbU.append(this.message);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: StoreMessageReplies.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreMessageReplies$MessageState$Unloaded;", "Lcom/discord/stores/StoreMessageReplies$MessageState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Unloaded extends MessageState {
            public static final Unloaded INSTANCE = new Unloaded();

            private Unloaded() {
                super(null);
            }
        }

        private MessageState() {
        }

        public /* synthetic */ MessageState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreMessageReplies.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/MessageId;", "Lcom/discord/stores/StoreMessageReplies$MessageState;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageReplies$observeMessageReferencesForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends MessageState>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends MessageState> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends MessageState> invoke2() {
            return StoreMessageReplies.access$getCachedChannelMessages(StoreMessageReplies.this, this.$channelId);
        }
    }

    public /* synthetic */ StoreMessageReplies(Dispatcher dispatcher, StoreMessages storeMessages, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeMessages, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ Map access$getCachedChannelMessages(StoreMessageReplies storeMessageReplies, long j) {
        return storeMessageReplies.getCachedChannelMessages(j);
    }

    @Store3
    private final boolean deleteMessage(long messageId, long channelId) {
        if (!this.repliedMessagesCache.containsKey(Long.valueOf(messageId))) {
            return false;
        }
        updateCache(messageId, channelId, MessageState.Deleted.INSTANCE);
        return true;
    }

    private final Map<Long, MessageState> getCachedChannelMessages(long channelId) {
        Map<Long, MessageState> map = (Map) this.repliedChannelMessagesCacheSnapshot.get(Long.valueOf(channelId));
        return map != null ? map : NO_RESULTS;
    }

    @Store3
    private final boolean processMessage(com.discord.api.message.Message message) {
        return processMessage(new Message(message));
    }

    private final void processReferencedMessage(Message referencedMessage) {
        updateCache(referencedMessage.getId(), referencedMessage.getChannelId(), new MessageState.Loaded(referencedMessage));
        Integer type = referencedMessage.getType();
        if (type != null && type.intValue() == 19) {
            processMessage(referencedMessage);
        }
    }

    private final void snapShotAllMessages() {
        this.repliedMessagesCacheSnapshot = new HashMap(this.repliedMessagesCache);
    }

    @Store3
    private final void snapShotChannelMessages() {
        HashMap<Long, Set<Long>> map = this.channelMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Set set = (Set) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(set, 10)), 16));
            for (Object obj : set) {
                Object obj2 = (MessageState) this.repliedMessagesCache.get(Long.valueOf(((Number) obj).longValue()));
                if (obj2 == null) {
                    obj2 = MessageState.Unloaded.INSTANCE;
                }
                linkedHashMap2.put(obj, obj2);
            }
            linkedHashMap.put(key, linkedHashMap2);
        }
        this.repliedChannelMessagesCacheSnapshot = linkedHashMap;
    }

    @Store3
    private final void updateCache(long messageId, long channelId, MessageState messageState) {
        this.repliedMessagesCache.put(Long.valueOf(messageId), messageState);
        HashMap<Long, Set<Long>> map = this.channelMap;
        Long lValueOf = Long.valueOf(channelId);
        Set of = SetsJVM.setOf(Long.valueOf(messageId));
        Set<Long> setEmptySet = this.channelMap.get(Long.valueOf(channelId));
        if (setEmptySet == null) {
            setEmptySet = Sets5.emptySet();
        }
        map.put(lValueOf, _Collections.union(of, setEmptySet));
    }

    public final Map<Long, MessageState> getAllMessageReferences() {
        return this.repliedMessagesCacheSnapshot;
    }

    @Store3
    public final void handleLoadMessages(Collection<Message> messages) {
        Intrinsics3.checkNotNullParameter(messages, "messages");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(messages, 10));
        Iterator<T> it = messages.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(processMessage((Message) it.next())));
        }
        if (arrayList.contains(Boolean.TRUE)) {
            markChanged();
        }
    }

    @Store3
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        if (processMessage(message)) {
            markChanged();
        }
    }

    @Store3
    public final void handleMessageDelete(ModelMessageDelete messageDeleteBulk) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(messageDeleteBulk, "messageDeleteBulk");
        List<Long> messageIds = messageDeleteBulk.getMessageIds();
        Intrinsics3.checkNotNullExpressionValue(messageIds, "messageDeleteBulk.messageIds");
        loop0: while (true) {
            for (Long l : messageIds) {
                Intrinsics3.checkNotNullExpressionValue(l, "messageId");
                z2 = deleteMessage(l.longValue(), messageDeleteBulk.getChannelId()) || z2;
            }
        }
        if (z2) {
            markChanged();
        }
    }

    @Store3
    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        MessageState messageState;
        Intrinsics3.checkNotNullParameter(message, "message");
        if (this.repliedMessagesCache.containsKey(Long.valueOf(message.getId())) && (messageState = this.repliedMessagesCache.get(Long.valueOf(message.getId()))) != null && (messageState instanceof MessageState.Loaded)) {
            Message messageMerge = ((MessageState.Loaded) messageState).getMessage().merge(message);
            updateCache(messageMerge.getId(), messageMerge.getChannelId(), new MessageState.Loaded(messageMerge));
            markChanged();
        }
    }

    public final Observable<Map<Long, MessageState>> observeMessageReferencesForChannel(long channelId) {
        Observable<Map<Long, MessageState>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        snapShotChannelMessages();
        snapShotAllMessages();
    }

    public StoreMessageReplies(Dispatcher dispatcher, StoreMessages storeMessages, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeMessages, "storeMessages");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeMessages = storeMessages;
        this.observationDeck = observationDeck;
        this.repliedMessagesCache = new MessageCache<>();
        this.channelMap = new HashMap<>();
        this.repliedChannelMessagesCacheSnapshot = Maps6.emptyMap();
        this.repliedMessagesCacheSnapshot = Maps6.emptyMap();
    }

    @Store3
    private final boolean processMessage(Message message) {
        boolean z2;
        MessageReference messageReference;
        if (this.repliedMessagesCache.containsKey(Long.valueOf(message.getId()))) {
            updateCache(message.getId(), message.getChannelId(), new MessageState.Loaded(message));
            z2 = true;
        } else {
            z2 = false;
        }
        if (!message.isEmbeddedMessageType() || (messageReference = message.getMessageReference()) == null) {
            return z2;
        }
        com.discord.api.message.Message referencedMessage = message.getReferencedMessage();
        Long channelId = messageReference.getChannelId();
        Long messageId = messageReference.getMessageId();
        if (referencedMessage != null) {
            processReferencedMessage(new Message(referencedMessage));
            return true;
        }
        if (channelId == null || messageId == null) {
            return true;
        }
        Message message2 = this.storeMessages.getMessage(channelId.longValue(), messageId.longValue());
        if (message2 != null) {
            processReferencedMessage(message2);
            return true;
        }
        updateCache(messageId.longValue(), channelId.longValue(), MessageState.Unloaded.INSTANCE);
        return true;
    }
}
