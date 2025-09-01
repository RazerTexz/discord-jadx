package com.discord.utilities.lazy.subscriptions;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.Ranges2;

/* compiled from: GuildSubscriptionsManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u001c\u0010D\u001a\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\n0C¢\u0006\u0004\bK\u0010LJ9\u0010\u000b\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u001c\u0010\t\u001a\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\u0012\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0015\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00060\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u001b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001f\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u001e\u001a\u00060\u0002j\u0002`\u000e¢\u0006\u0004\b\u001f\u0010 J%\u0010!\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u001e\u001a\u00060\u0002j\u0002`\u000e¢\u0006\u0004\b!\u0010 J3\u0010$\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\"\u001a\u00060\u0002j\u0002`\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b$\u0010%J%\u0010'\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010&\u001a\u00060\u0002j\u0002`\u0006¢\u0006\u0004\b'\u0010 J\u0019\u0010(\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b*\u0010)J\u0019\u0010+\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b+\u0010)J\u0019\u0010,\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b,\u0010)J\r\u0010-\u001a\u00020\n¢\u0006\u0004\b-\u0010.J\u001f\u00100\u001a\u00020\n2\u0010\u0010/\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0007¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\n¢\u0006\u0004\b2\u0010.J\r\u00103\u001a\u00020\n¢\u0006\u0004\b3\u0010.R.\u00106\u001a\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u000304j\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`58\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R.\u0010;\u001a\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u000304j\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`58\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00107R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R:\u0010A\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u001b0?j\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u001b`@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR,\u0010D\u001a\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\n0C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER.\u0010F\u001a\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u000304j\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`58\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u00107R\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR.\u0010J\u001a\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u000304j\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`58\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u00107¨\u0006M"}, d2 = {"Lcom/discord/utilities/lazy/subscriptions/GuildSubscriptionsManager;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "Lcom/discord/primitives/ChannelId;", "", "Lkotlin/ranges/IntRange;", "channelSubscriptions", "", "handleChannelSubscriptionsChange", "(JLjava/util/Map;)V", "", "Lcom/discord/primitives/UserId;", "users", "", "forceUpdate", "handleMemberSubscriptionsChange", "(JLjava/util/Set;Z)V", "threadSubscriptions", "handleThreadSubscriptionsChange", "(JLjava/util/List;)V", "Lkotlin/Function0;", "flushUnsubscriptions", "requestFlushUnsubscriptions", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/utilities/lazy/subscriptions/GuildSubscriptions;", "get", "(J)Lcom/discord/utilities/lazy/subscriptions/GuildSubscriptions;", "userId", "subscribeMember", "(JJ)V", "unsubscribeMember", "channelId", "ranges", "subscribeChannel", "(JJLjava/util/List;)V", "threadId", "subscribeThread", "subscribeTyping", "(J)V", "subscribeActivities", "subscribeThreads", "remove", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET, "()V", "guildIds", "retainAll", "(Ljava/util/List;)V", "flush", "queueExistingSubscriptions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "subscribedGuilds", "Ljava/util/HashSet;", "Lcom/discord/utilities/lazy/subscriptions/GuildMemberSubscriptionsManager;", "guildMemberSubscriptionsManager", "Lcom/discord/utilities/lazy/subscriptions/GuildMemberSubscriptionsManager;", "threadGuilds", "Lcom/discord/utilities/lazy/subscriptions/GuildThreadSubscriptionsManager;", "guildThreadSubscriptionManager", "Lcom/discord/utilities/lazy/subscriptions/GuildThreadSubscriptionsManager;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "pendingEmissions", "Ljava/util/HashMap;", "Lkotlin/Function2;", "onChange", "Lkotlin/jvm/functions/Function2;", "typingGuilds", "Lcom/discord/utilities/lazy/subscriptions/GuildChannelSubscriptionsManager;", "guildChannelSubscriptionsManager", "Lcom/discord/utilities/lazy/subscriptions/GuildChannelSubscriptionsManager;", "activityGuilds", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildSubscriptionsManager {
    private final HashSet<Long> activityGuilds;
    private final GuildChannelSubscriptionsManager guildChannelSubscriptionsManager;
    private final GuildMemberSubscriptionsManager guildMemberSubscriptionsManager;
    private final GuildThreadSubscriptionsManager guildThreadSubscriptionManager;
    private final Function2<Long, GuildSubscriptions, Unit> onChange;
    private final HashMap<Long, GuildSubscriptions> pendingEmissions;
    private final HashSet<Long> subscribedGuilds;
    private final HashSet<Long> threadGuilds;
    private final HashSet<Long> typingGuilds;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildSubscriptionsManager(Function2<? super Long, ? super GuildSubscriptions, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "onChange");
        this.onChange = function2;
        this.typingGuilds = new HashSet<>();
        this.activityGuilds = new HashSet<>();
        this.threadGuilds = new HashSet<>();
        this.guildChannelSubscriptionsManager = new GuildChannelSubscriptionsManager(new GuildSubscriptionsManager2(this));
        this.guildMemberSubscriptionsManager = new GuildMemberSubscriptionsManager(new GuildSubscriptionsManager3(this), new GuildSubscriptionsManager4(this), null, 4, null);
        this.guildThreadSubscriptionManager = new GuildThreadSubscriptionsManager(new GuildSubscriptionsManager5(this));
        this.pendingEmissions = new HashMap<>();
        this.subscribedGuilds = new HashSet<>();
    }

    public static final /* synthetic */ void access$handleChannelSubscriptionsChange(GuildSubscriptionsManager guildSubscriptionsManager, long j, Map map) {
        guildSubscriptionsManager.handleChannelSubscriptionsChange(j, map);
    }

    public static final /* synthetic */ void access$handleMemberSubscriptionsChange(GuildSubscriptionsManager guildSubscriptionsManager, long j, Set set, boolean z2) {
        guildSubscriptionsManager.handleMemberSubscriptionsChange(j, set, z2);
    }

    public static final /* synthetic */ void access$handleThreadSubscriptionsChange(GuildSubscriptionsManager guildSubscriptionsManager, long j, List list) {
        guildSubscriptionsManager.handleThreadSubscriptionsChange(j, list);
    }

    public static final /* synthetic */ void access$requestFlushUnsubscriptions(GuildSubscriptionsManager guildSubscriptionsManager, Function0 function0) {
        guildSubscriptionsManager.requestFlushUnsubscriptions(function0);
    }

    private final synchronized void handleChannelSubscriptionsChange(long guildId, Map<Long, ? extends List<Ranges2>> channelSubscriptions) {
        GuildSubscriptions guildSubscriptions;
        HashMap<Long, GuildSubscriptions> map = this.pendingEmissions;
        Long lValueOf = Long.valueOf(guildId);
        GuildSubscriptions guildSubscriptions2 = this.pendingEmissions.get(Long.valueOf(guildId));
        if (guildSubscriptions2 == null || (guildSubscriptions = GuildSubscriptions.copy$default(guildSubscriptions2, channelSubscriptions, null, null, null, null, null, 62, null)) == null) {
            guildSubscriptions = new GuildSubscriptions(channelSubscriptions, null, null, null, null, null, 62, null);
        }
        map.put(lValueOf, guildSubscriptions);
    }

    private final synchronized void handleMemberSubscriptionsChange(long guildId, Set<Long> users, boolean forceUpdate) {
        GuildSubscriptions guildSubscriptions;
        HashMap<Long, GuildSubscriptions> map = this.pendingEmissions;
        Long lValueOf = Long.valueOf(guildId);
        GuildSubscriptions guildSubscriptions2 = this.pendingEmissions.get(Long.valueOf(guildId));
        if (guildSubscriptions2 == null || (guildSubscriptions = GuildSubscriptions.copy$default(guildSubscriptions2, null, null, null, users, null, null, 55, null)) == null) {
            guildSubscriptions = new GuildSubscriptions(null, null, null, users, null, null, 55, null);
        }
        map.put(lValueOf, guildSubscriptions);
        if (forceUpdate) {
            flush();
        }
    }

    private final synchronized void handleThreadSubscriptionsChange(long guildId, List<Long> threadSubscriptions) {
        GuildSubscriptions guildSubscriptions;
        HashMap<Long, GuildSubscriptions> map = this.pendingEmissions;
        Long lValueOf = Long.valueOf(guildId);
        GuildSubscriptions guildSubscriptions2 = this.pendingEmissions.get(Long.valueOf(guildId));
        if (guildSubscriptions2 == null || (guildSubscriptions = GuildSubscriptions.copy$default(guildSubscriptions2, null, null, null, null, null, threadSubscriptions, 31, null)) == null) {
            guildSubscriptions = new GuildSubscriptions(null, null, null, null, null, threadSubscriptions, 31, null);
        }
        map.put(lValueOf, guildSubscriptions);
    }

    private final synchronized void requestFlushUnsubscriptions(Function0<Unit> flushUnsubscriptions) {
        flushUnsubscriptions.invoke();
    }

    public final synchronized void flush() {
        for (Map.Entry<Long, GuildSubscriptions> entry : this.pendingEmissions.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            GuildSubscriptions value = entry.getValue();
            this.subscribedGuilds.add(Long.valueOf(jLongValue));
            this.onChange.invoke(Long.valueOf(jLongValue), value);
        }
        this.pendingEmissions.clear();
    }

    public final synchronized GuildSubscriptions get(long guildId) {
        return new GuildSubscriptions(this.guildChannelSubscriptionsManager.get(guildId), Boolean.valueOf(this.typingGuilds.contains(Long.valueOf(guildId))), Boolean.valueOf(this.activityGuilds.contains(Long.valueOf(guildId))), this.guildMemberSubscriptionsManager.get(guildId), Boolean.valueOf(this.threadGuilds.contains(Long.valueOf(guildId))), this.guildThreadSubscriptionManager.get(guildId));
    }

    public final synchronized void queueExistingSubscriptions() {
        Iterator<T> it = this.subscribedGuilds.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            this.pendingEmissions.put(Long.valueOf(jLongValue), get(jLongValue));
        }
    }

    public final synchronized void remove(long guildId) {
        this.subscribedGuilds.remove(Long.valueOf(guildId));
        this.pendingEmissions.remove(Long.valueOf(guildId));
        this.typingGuilds.remove(Long.valueOf(guildId));
        this.activityGuilds.remove(Long.valueOf(guildId));
        this.threadGuilds.remove(Long.valueOf(guildId));
        this.guildMemberSubscriptionsManager.remove(guildId);
        this.guildChannelSubscriptionsManager.remove(guildId);
        this.guildThreadSubscriptionManager.remove(guildId);
    }

    public final synchronized void reset() {
        this.subscribedGuilds.clear();
        this.pendingEmissions.clear();
        this.typingGuilds.clear();
        this.activityGuilds.clear();
        this.threadGuilds.clear();
        this.guildChannelSubscriptionsManager.reset();
        this.guildMemberSubscriptionsManager.reset();
        this.guildThreadSubscriptionManager.reset();
    }

    public final synchronized void retainAll(List<Long> guildIds) {
        Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
        this.subscribedGuilds.retainAll(guildIds);
        Iterator<Map.Entry<Long, GuildSubscriptions>> it = this.pendingEmissions.entrySet().iterator();
        while (it.hasNext()) {
            if (!guildIds.contains(Long.valueOf(it.next().getKey().longValue()))) {
                it.remove();
            }
        }
        this.typingGuilds.retainAll(guildIds);
        this.activityGuilds.retainAll(guildIds);
        this.threadGuilds.retainAll(guildIds);
        this.guildChannelSubscriptionsManager.retainAll(guildIds);
        this.guildMemberSubscriptionsManager.retainAll(guildIds);
        this.guildThreadSubscriptionManager.retainAll(guildIds);
    }

    public final synchronized void subscribeActivities(long guildId) {
        GuildSubscriptions guildSubscriptions;
        if (this.activityGuilds.contains(Long.valueOf(guildId))) {
            return;
        }
        this.activityGuilds.add(Long.valueOf(guildId));
        HashMap<Long, GuildSubscriptions> map = this.pendingEmissions;
        Long lValueOf = Long.valueOf(guildId);
        GuildSubscriptions guildSubscriptions2 = this.pendingEmissions.get(Long.valueOf(guildId));
        if (guildSubscriptions2 == null || (guildSubscriptions = GuildSubscriptions.copy$default(guildSubscriptions2, null, null, Boolean.TRUE, null, null, null, 59, null)) == null) {
            guildSubscriptions = new GuildSubscriptions(null, null, Boolean.TRUE, null, null, null, 59, null);
        }
        map.put(lValueOf, guildSubscriptions);
    }

    public final synchronized void subscribeChannel(long guildId, long channelId, List<Ranges2> ranges) {
        Intrinsics3.checkNotNullParameter(ranges, "ranges");
        this.guildChannelSubscriptionsManager.subscribe(guildId, channelId, ranges);
    }

    public final synchronized void subscribeMember(long guildId, long userId) {
        this.guildMemberSubscriptionsManager.subscribe(guildId, userId);
    }

    public final synchronized void subscribeThread(long guildId, long threadId) {
        this.guildThreadSubscriptionManager.subscribe(guildId, threadId);
    }

    public final synchronized void subscribeThreads(long guildId) {
        GuildSubscriptions guildSubscriptions;
        if (this.threadGuilds.contains(Long.valueOf(guildId))) {
            return;
        }
        this.threadGuilds.add(Long.valueOf(guildId));
        HashMap<Long, GuildSubscriptions> map = this.pendingEmissions;
        Long lValueOf = Long.valueOf(guildId);
        GuildSubscriptions guildSubscriptions2 = this.pendingEmissions.get(Long.valueOf(guildId));
        if (guildSubscriptions2 == null || (guildSubscriptions = GuildSubscriptions.copy$default(guildSubscriptions2, null, null, null, null, Boolean.TRUE, null, 47, null)) == null) {
            guildSubscriptions = new GuildSubscriptions(null, null, null, null, Boolean.TRUE, null, 47, null);
        }
        map.put(lValueOf, guildSubscriptions);
    }

    public final synchronized void subscribeTyping(long guildId) {
        GuildSubscriptions guildSubscriptions;
        if (this.typingGuilds.contains(Long.valueOf(guildId))) {
            return;
        }
        this.typingGuilds.add(Long.valueOf(guildId));
        HashMap<Long, GuildSubscriptions> map = this.pendingEmissions;
        Long lValueOf = Long.valueOf(guildId);
        GuildSubscriptions guildSubscriptions2 = this.pendingEmissions.get(Long.valueOf(guildId));
        if (guildSubscriptions2 == null || (guildSubscriptions = GuildSubscriptions.copy$default(guildSubscriptions2, null, Boolean.TRUE, null, null, null, null, 61, null)) == null) {
            guildSubscriptions = new GuildSubscriptions(null, Boolean.TRUE, null, null, null, null, 61, null);
        }
        map.put(lValueOf, guildSubscriptions);
    }

    public final synchronized void unsubscribeMember(long guildId, long userId) {
        this.guildMemberSubscriptionsManager.unsubscribe(guildId, userId);
    }
}
