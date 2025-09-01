package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00060\u0006 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052:\u0010\u0004\u001a6\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003 \u0002*\u001a\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/Pair;", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "kotlin.jvm.PlatformType", "Lcom/discord/api/channel/Channel;", "<name for destructuring parameter 0>", "Lrx/Observable;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Pair;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel3<T, R> implements Func1<Tuples2<? extends ArchivedThreadsStore.ThreadListingState, ? extends Channel>, Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ WidgetThreadBrowserArchivedViewModel.ViewMode $viewMode;

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\n\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u0005 \u0006*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u00010\u00000\u00002V\u0010\u0007\u001aR\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0000 \u0006*(\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0000\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "members", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends GuildMember>>, Map<Long, ? extends GuildMember>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends GuildMember> call(Map<Long, ? extends Map<Long, ? extends GuildMember>> map) {
            return call2((Map<Long, ? extends Map<Long, GuildMember>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, GuildMember> call2(Map<Long, ? extends Map<Long, GuildMember>> map) {
            Map<Long, GuildMember> map2 = map.get(Long.valueOf(WidgetThreadBrowserArchivedViewModel3.this.$guildId));
            return map2 != null ? map2 : Maps6.emptyMap();
        }
    }

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\r0\r26\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u00072.\u0010\n\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\t \u0005*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u00000\u00002\u000e\u0010\f\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u000bH\n¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "guildMembers", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/user/User;", "users", "Lcom/discord/api/permission/PermissionBit;", "parentChannelPermissions", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/lang/Long;)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, T3, T4, R> implements Func4<Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends User>, Long, WidgetThreadBrowserArchivedViewModel.StoreState> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ ArchivedThreadsStore.ThreadListingState $listingState;

        public AnonymousClass2(ArchivedThreadsStore.ThreadListingState threadListingState, Channel channel) {
            this.$listingState = threadListingState;
            this.$channel = channel;
        }

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetThreadBrowserArchivedViewModel.StoreState call(Map<Long, ? extends GuildMember> map, Guild guild, Map<Long, ? extends User> map2, Long l) {
            return call2((Map<Long, GuildMember>) map, guild, map2, l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetThreadBrowserArchivedViewModel.StoreState call2(Map<Long, GuildMember> map, Guild guild, Map<Long, ? extends User> map2, Long l) {
            boolean zCanViewAllPrivateThreads = ThreadUtils.INSTANCE.canViewAllPrivateThreads(l);
            WidgetThreadBrowserArchivedViewModel.ViewMode viewMode = WidgetThreadBrowserArchivedViewModel3.this.$viewMode;
            Intrinsics3.checkNotNullExpressionValue(map, "guildMembers");
            Intrinsics3.checkNotNullExpressionValue(map2, "users");
            ArchivedThreadsStore.ThreadListingState threadListingState = this.$listingState;
            Intrinsics3.checkNotNullExpressionValue(threadListingState, "listingState");
            return new WidgetThreadBrowserArchivedViewModel.StoreState(viewMode, map, map2, threadListingState, zCanViewAllPrivateThreads, this.$channel, guild, l);
        }
    }

    public WidgetThreadBrowserArchivedViewModel3(StoreUser storeUser, StoreGuilds storeGuilds, long j, StorePermissions storePermissions, WidgetThreadBrowserArchivedViewModel.ViewMode viewMode) {
        this.$storeUser = storeUser;
        this.$storeGuilds = storeGuilds;
        this.$guildId = j;
        this.$storePermissions = storePermissions;
        this.$viewMode = viewMode;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState> call(Tuples2<? extends ArchivedThreadsStore.ThreadListingState, ? extends Channel> tuples2) {
        return call2((Tuples2<? extends ArchivedThreadsStore.ThreadListingState, Channel>) tuples2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState> call2(Tuples2<? extends ArchivedThreadsStore.ThreadListingState, Channel> tuples2) {
        Observable<Map<Long, User>> scalarSynchronousObservable;
        ArchivedThreadsStore.ThreadListingState threadListingStateComponent1 = tuples2.component1();
        Channel channelComponent2 = tuples2.component2();
        if (threadListingStateComponent1 instanceof ArchivedThreadsStore.ThreadListingState.Listing) {
            StoreUser storeUser = this.$storeUser;
            List<Channel> threads = ((ArchivedThreadsStore.ThreadListingState.Listing) threadListingStateComponent1).getThreads();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(threads, 10));
            Iterator<T> it = threads.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Channel) it.next()).getOwnerId()));
            }
            scalarSynchronousObservable = storeUser.observeUsers(arrayList);
        } else {
            scalarSynchronousObservable = new ScalarSynchronousObservable(Maps6.emptyMap());
        }
        Observable<R> observableG = this.$storeGuilds.observeComputed().G(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableG, "storeGuilds\n            …[guildId] ?: emptyMap() }");
        Observable<T> observableR = ObservableExtensionsKt.leadingEdgeThrottle(observableG, 1L, TimeUnit.SECONDS).r();
        Observable<Guild> observableObserveGuild = this.$storeGuilds.observeGuild(this.$guildId);
        StorePermissions storePermissions = this.$storePermissions;
        Long lValueOf = channelComponent2 != null ? Long.valueOf(channelComponent2.getParentId()) : null;
        Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type com.discord.primitives.Snowflake /* = kotlin.Long */");
        return Observable.h(observableR, observableObserveGuild, scalarSynchronousObservable, storePermissions.observePermissionsForChannel(lValueOf.longValue()), new AnonymousClass2(threadListingStateComponent1, channelComponent2));
    }
}
