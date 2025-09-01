package com.discord.stores;

import android.content.SharedPreferences;
import b.a.b.TypeAdapterRegistrar;
import b.i.d.GsonBuilder;
import com.discord.app.AppLog;
import com.discord.models.message.Message;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.MessageUtils;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Metadata;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/* compiled from: StoreLocalMessagesHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\n0\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0006J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001b\u001a\u0004\u0018\u00010\r2\n\u0010\u0018\u001a\u00060\u000bj\u0002`\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\rH\u0007¢\u0006\u0004\b\u001d\u0010\u0016J#\u0010\u001d\u001a\u00020\u00042\n\u0010\u0018\u001a\u00060\u000bj\u0002`\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001f\u0010\bR.\u0010\"\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0!0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010$RF\u0010&\u001a2\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\n\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\n0%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010-\u001a\n ,*\u0004\u0018\u00010+0+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R(\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u00103R(\u00104\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00100¨\u00066"}, d2 = {"Lcom/discord/stores/StoreLocalMessagesHolder;", "", "", "force", "", "publishIfUpdated", "(Z)V", "messageCacheTryPersist", "()V", "Lrx/Observable;", "", "", "", "Lcom/discord/models/message/Message;", "getMessagesPublisher", "()Lrx/Observable;", "cacheEnabled", "init", "getFlattenedMessages", "()Ljava/util/List;", "message", "addMessage", "(Lcom/discord/models/message/Message;)V", "Lcom/discord/primitives/ChannelId;", "channelId", "", "nonce", "getMessage", "(JLjava/lang/String;)Lcom/discord/models/message/Message;", "deleteMessage", "(JLjava/lang/String;)V", "clearCache", "Ljava/util/HashMap;", "Ljava/util/TreeMap;", "messages", "Ljava/util/HashMap;", "Z", "Lrx/subjects/Subject;", "messagesPublisher", "Lrx/subjects/Subject;", "", "updatedChannels", "Ljava/util/Set;", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "messagesSnapshot", "Ljava/util/Map;", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "cacheSnapshot", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreLocalMessagesHolder {
    private boolean cacheEnabled;
    private final Gson gson;
    private SharedPreferences sharedPreferences;
    private final HashMap<Long, TreeMap<Long, Message>> messages = new HashMap<>();
    private final Subject<Map<Long, List<Message>>, Map<Long, List<Message>>> messagesPublisher = new SerializedSubject(BehaviorSubject.k0());
    private Map<Long, ? extends List<Message>> messagesSnapshot = Maps6.emptyMap();
    private Map<Long, ? extends List<Message>> cacheSnapshot = Maps6.emptyMap();
    private final Set<Long> updatedChannels = new HashSet();

    public StoreLocalMessagesHolder() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        TypeAdapterRegistrar.a(gsonBuilder);
        this.gson = gsonBuilder.a();
    }

    public static /* synthetic */ void init$default(StoreLocalMessagesHolder storeLocalMessagesHolder, boolean z2, int i, Object obj) throws JsonIOException {
        if ((i & 1) != 0) {
            z2 = true;
        }
        storeLocalMessagesHolder.init(z2);
    }

    @Store3
    private final void messageCacheTryPersist() throws JsonIOException {
        if (this.cacheEnabled) {
            HashMap map = new HashMap();
            for (Map.Entry<Long, TreeMap<Long, Message>> entry : this.messages.entrySet()) {
                Long key = entry.getKey();
                Collection<Message> collectionValues = entry.getValue().values();
                Intrinsics3.checkNotNullExpressionValue(collectionValues, "entry.value.values");
                map.put(key, _Collections.toList(collectionValues));
            }
            if (!Intrinsics3.areEqual(this.cacheSnapshot, map)) {
                this.cacheSnapshot = map;
                String strM = this.gson.m(map);
                SharedPreferences sharedPreferences = this.sharedPreferences;
                if (sharedPreferences == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("sharedPreferences");
                }
                sharedPreferences.edit().putString("STORE_LOCAL_MESSAGES_CACHE_V11", strM).apply();
            }
        }
    }

    private final void publishIfUpdated(boolean force) throws JsonIOException {
        Collection<Message> collectionEmptyList;
        if (!this.updatedChannels.isEmpty() || force) {
            HashMap map = new HashMap(this.messagesSnapshot);
            Iterator<Long> it = this.updatedChannels.iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                Long lValueOf = Long.valueOf(jLongValue);
                TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(jLongValue));
                if (treeMap == null || (collectionEmptyList = treeMap.values()) == null) {
                    collectionEmptyList = Collections2.emptyList();
                }
                map.put(lValueOf, new ArrayList(collectionEmptyList));
            }
            this.updatedChannels.clear();
            this.messagesSnapshot = map;
            this.messagesPublisher.onNext(map);
            messageCacheTryPersist();
        }
    }

    public static /* synthetic */ void publishIfUpdated$default(StoreLocalMessagesHolder storeLocalMessagesHolder, boolean z2, int i, Object obj) throws JsonIOException {
        if ((i & 1) != 0) {
            z2 = false;
        }
        storeLocalMessagesHolder.publishIfUpdated(z2);
    }

    @Store3
    public final void addMessage(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        long channelId = message.getChannelId();
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
        if (treeMap == null) {
            treeMap = new TreeMap<>();
        }
        treeMap.put(Long.valueOf(message.getId()), message);
        this.messages.put(Long.valueOf(channelId), treeMap);
        this.updatedChannels.add(Long.valueOf(channelId));
        publishIfUpdated$default(this, false, 1, null);
    }

    @Store3
    public final void clearCache() throws JsonIOException {
        for (Map.Entry<Long, TreeMap<Long, Message>> entry : this.messages.entrySet()) {
            Long key = entry.getKey();
            TreeMap<Long, Message> value = entry.getValue();
            Set<Long> set = this.updatedChannels;
            Intrinsics3.checkNotNullExpressionValue(key, "channelId");
            set.add(key);
            value.clear();
        }
        publishIfUpdated$default(this, false, 1, null);
    }

    @Store3
    public final void deleteMessage(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        long id2 = message.getId();
        long channelId = message.getChannelId();
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
        if (treeMap != null) {
            Intrinsics3.checkNotNullExpressionValue(treeMap, "messages[channelId] ?: return");
            if (treeMap.containsKey(Long.valueOf(id2))) {
                treeMap.remove(Long.valueOf(id2));
                this.updatedChannels.add(Long.valueOf(channelId));
                if (treeMap.isEmpty()) {
                    this.messages.remove(Long.valueOf(channelId));
                }
            }
            publishIfUpdated$default(this, false, 1, null);
        }
    }

    @Store3
    public final List<Message> getFlattenedMessages() {
        return Iterables2.flatten(this.messagesSnapshot.values());
    }

    @Store3
    public final Message getMessage(long channelId, String nonce) {
        Collection<Message> collectionValues;
        Intrinsics3.checkNotNullParameter(nonce, "nonce");
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
        Object obj = null;
        if (treeMap == null || (collectionValues = treeMap.values()) == null) {
            return null;
        }
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics3.areEqual(((Message) next).getNonce(), nonce)) {
                obj = next;
                break;
            }
        }
        return (Message) obj;
    }

    public final Observable<Map<Long, List<Message>>> getMessagesPublisher() {
        return this.messagesPublisher;
    }

    @Store3
    public final void init(boolean cacheEnabled) throws JsonIOException {
        if (cacheEnabled) {
            try {
                SharedPreferences sharedPreferences = SharedPreferencesProvider.INSTANCE.get();
                this.sharedPreferences = sharedPreferences;
                if (sharedPreferences == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("sharedPreferences");
                }
                String string = sharedPreferences.getString("STORE_LOCAL_MESSAGES_CACHE_V11", null);
                for (Map.Entry entry : (string != null ? (Map) this.gson.g(string, new StoreLocalMessagesHolder2().getType()) : Maps6.emptyMap()).entrySet()) {
                    long jLongValue = ((Number) entry.getKey()).longValue();
                    this.messages.put(Long.valueOf(jLongValue), new TreeMap<>(MessageUtils.getSORT_BY_IDS_COMPARATOR()));
                    TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(jLongValue));
                    if (treeMap == null) {
                        treeMap = new TreeMap<>();
                    }
                    for (Message message : (List) entry.getValue()) {
                        treeMap.put(Long.valueOf(message.getId()), message);
                    }
                    this.messages.put(Long.valueOf(jLongValue), treeMap);
                    this.updatedChannels.add(Long.valueOf(jLongValue));
                }
            } catch (Exception e) {
                clearCache();
                Logger.e$default(AppLog.g, "Error restoring cached local messages", e, null, 4, null);
            }
        }
        this.cacheEnabled = cacheEnabled;
        publishIfUpdated(true);
    }

    @Store3
    public final void deleteMessage(long channelId, String nonce) {
        Object next;
        Intrinsics3.checkNotNullParameter(nonce, "nonce");
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
        if (treeMap != null) {
            Intrinsics3.checkNotNullExpressionValue(treeMap, "messages[channelId] ?: return");
            Collection<Message> collectionValues = treeMap.values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "messagesForChannel.values");
            Iterator<T> it = collectionValues.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics3.areEqual(((Message) next).getNonce(), nonce)) {
                        break;
                    }
                }
            }
            Message message = (Message) next;
            if (message != null) {
                Intrinsics3.checkNotNullExpressionValue(message, "messagesForChannel.value…once == nonce } ?: return");
                deleteMessage(message);
            }
        }
    }
}
