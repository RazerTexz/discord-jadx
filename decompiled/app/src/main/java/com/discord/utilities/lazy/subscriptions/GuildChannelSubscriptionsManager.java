package com.discord.utilities.lazy.subscriptions;

import android.util.LruCache;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.Ranges2;

/* compiled from: GuildChannelSubscriptionsManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B;\u00122\u0010\u001d\u001a.\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\r\u0012\u0004\u0012\u00020\n0\u001c¢\u0006\u0004\b\u001f\u0010 J3\u0010\u000b\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u000e\u001a\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\n2\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0007¢\u0006\u0004\b\u0015\u0010\u0016Rf\u0010\u001a\u001aR\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00180\u0017j(\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0018`\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bRB\u0010\u001d\u001a.\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\r\u0012\u0004\u0012\u00020\n0\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/discord/utilities/lazy/subscriptions/GuildChannelSubscriptionsManager;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "", "Lkotlin/ranges/IntRange;", "ranges", "", "subscribe", "(JJLjava/util/List;)V", "", "get", "(J)Ljava/util/Map;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET, "()V", "remove", "(J)V", "guildIds", "retainAll", "(Ljava/util/List;)V", "Ljava/util/HashMap;", "Landroid/util/LruCache;", "Lkotlin/collections/HashMap;", "subscriptions", "Ljava/util/HashMap;", "Lkotlin/Function2;", "changeHandler", "Lkotlin/jvm/functions/Function2;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildChannelSubscriptionsManager {
    private final Function2<Long, Map<Long, ? extends List<Ranges2>>, Unit> changeHandler;
    private final HashMap<Long, LruCache<Long, List<Ranges2>>> subscriptions;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildChannelSubscriptionsManager(Function2<? super Long, ? super Map<Long, ? extends List<Ranges2>>, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "changeHandler");
        this.changeHandler = function2;
        this.subscriptions = new HashMap<>();
    }

    public final Map<Long, List<Ranges2>> get(long guildId) {
        Map<Long, List<Ranges2>> mapSnapshot;
        LruCache<Long, List<Ranges2>> lruCache = this.subscriptions.get(Long.valueOf(guildId));
        return (lruCache == null || (mapSnapshot = lruCache.snapshot()) == null) ? Maps6.emptyMap() : mapSnapshot;
    }

    public final void remove(long guildId) {
        this.subscriptions.remove(Long.valueOf(guildId));
    }

    public final void reset() {
        this.subscriptions.clear();
    }

    public final void retainAll(List<Long> guildIds) {
        Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
        Iterator<Map.Entry<Long, LruCache<Long, List<Ranges2>>>> it = this.subscriptions.entrySet().iterator();
        while (it.hasNext()) {
            if (!guildIds.contains(Long.valueOf(it.next().getKey().longValue()))) {
                it.remove();
            }
        }
    }

    public final void subscribe(long guildId, long channelId, List<Ranges2> ranges) {
        Intrinsics3.checkNotNullParameter(ranges, "ranges");
        LruCache<Long, List<Ranges2>> lruCache = this.subscriptions.get(Long.valueOf(guildId));
        if (lruCache == null) {
            lruCache = new LruCache<>(5);
        }
        if (Intrinsics3.areEqual(lruCache.get(Long.valueOf(channelId)), ranges)) {
            return;
        }
        lruCache.put(Long.valueOf(channelId), ranges);
        this.subscriptions.put(Long.valueOf(guildId), lruCache);
        Function2<Long, Map<Long, ? extends List<Ranges2>>, Unit> function2 = this.changeHandler;
        Long lValueOf = Long.valueOf(guildId);
        Map<Long, List<Ranges2>> mapSnapshot = lruCache.snapshot();
        Intrinsics3.checkNotNullExpressionValue(mapSnapshot, "guildSubscriptions.snapshot()");
        function2.invoke(lValueOf, mapSnapshot);
    }
}
