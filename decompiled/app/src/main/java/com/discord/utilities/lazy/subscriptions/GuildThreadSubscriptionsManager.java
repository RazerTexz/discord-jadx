package com.discord.utilities.lazy.subscriptions;

import android.util.LruCache;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: GuildThreadSubscriptionsManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012&\u0010\u001a\u001a\"\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00050\n\u0012\u0004\u0012\u00020\u00070\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0005¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00050\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00072\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\n¢\u0006\u0004\b\u0012\u0010\u0013Rb\u0010\u0017\u001aN\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0005\u0012\b\u0012\u00060\u0002j\u0002`\u00050\u00150\u0014j&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0005\u0012\b\u0012\u00060\u0002j\u0002`\u00050\u0015`\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R6\u0010\u001a\u001a\"\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00050\n\u0012\u0004\u0012\u00020\u00070\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/discord/utilities/lazy/subscriptions/GuildThreadSubscriptionsManager;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "", "subscribe", "(JJ)V", "", "get", "(J)Ljava/util/List;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET, "()V", "remove", "(J)V", "guildIds", "retainAll", "(Ljava/util/List;)V", "Ljava/util/HashMap;", "Landroid/util/LruCache;", "Lkotlin/collections/HashMap;", "subscriptions", "Ljava/util/HashMap;", "Lkotlin/Function2;", "changeHandler", "Lkotlin/jvm/functions/Function2;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildThreadSubscriptionsManager {
    private final Function2<Long, List<Long>, Unit> changeHandler;
    private final HashMap<Long, LruCache<Long, Long>> subscriptions;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildThreadSubscriptionsManager(Function2<? super Long, ? super List<Long>, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "changeHandler");
        this.changeHandler = function2;
        this.subscriptions = new HashMap<>();
    }

    public final List<Long> get(long guildId) {
        Map<Long, Long> mapSnapshot;
        Set<Long> setKeySet;
        List<Long> list;
        LruCache<Long, Long> lruCache = this.subscriptions.get(Long.valueOf(guildId));
        return (lruCache == null || (mapSnapshot = lruCache.snapshot()) == null || (setKeySet = mapSnapshot.keySet()) == null || (list = _Collections.toList(setKeySet)) == null) ? Collections2.emptyList() : list;
    }

    public final void remove(long guildId) {
        this.subscriptions.remove(Long.valueOf(guildId));
    }

    public final void reset() {
        this.subscriptions.clear();
    }

    public final void retainAll(List<Long> guildIds) {
        Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
        Iterator<Map.Entry<Long, LruCache<Long, Long>>> it = this.subscriptions.entrySet().iterator();
        while (it.hasNext()) {
            if (!guildIds.contains(Long.valueOf(it.next().getKey().longValue()))) {
                it.remove();
            }
        }
    }

    public final void subscribe(long guildId, long channelId) {
        LruCache<Long, Long> lruCache = this.subscriptions.get(Long.valueOf(guildId));
        if (lruCache == null) {
            lruCache = new LruCache<>(3);
        }
        if (lruCache.get(Long.valueOf(channelId)) != null) {
            return;
        }
        lruCache.put(Long.valueOf(channelId), Long.valueOf(channelId));
        this.subscriptions.put(Long.valueOf(guildId), lruCache);
        this.changeHandler.invoke(Long.valueOf(guildId), _Collections.toList(lruCache.snapshot().keySet()));
    }
}
