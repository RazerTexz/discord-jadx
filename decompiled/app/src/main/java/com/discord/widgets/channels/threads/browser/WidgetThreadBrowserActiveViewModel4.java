package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function10;
import rx.Observable;

/* compiled from: WidgetThreadBrowserActiveViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a*\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00010\b0\b \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00010\b0\b\u0018\u00010\u00070\u00072Ç\u0001\u0010\u0006\u001aÂ\u0001\u0012,\u0012*\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0004 \u0005*\u0014\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00010\u0001\u0012,\u0012*\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0004 \u0005*\u0014\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00010\u0001 \u0005*`\u0012,\u0012*\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0004 \u0005*\u0014\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00010\u0001\u0012,\u0012*\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0004 \u0005*\u0014\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lkotlin/Pair;", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lrx/Observable;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserActiveViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Pair;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel4<T, R> implements Func1<Tuples2<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>>, Observable<? extends WidgetThreadBrowserActiveViewModel.StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreThreadMessages $storeThreadMessages;
    public final /* synthetic */ StoreUser $storeUser;

    /* compiled from: WidgetThreadBrowserActiveViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0001\u001a\u00020\u00002\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0016\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u000226\u0010\r\u001a2\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\nj\u0002`\u000b \f*\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\nj\u0002`\u000b\u0018\u00010\u00020\u00022\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u00022\u0016\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0007\u0012\u0004\u0012\u00020\u00110\u00022\u000e\u0010\u0014\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00132\u001a\u0010\u0017\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0015j\u0002`\u00160\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\n¢\u0006\u0004\b\u001d\u0010\u001e"}, d2 = {"Lcom/discord/models/user/MeUser;", "meUser", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "users", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreThreadMessages$ThreadState;", "threadStates", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "guildMembers", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "", "channelNames", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "", "Lcom/discord/primitives/RelationshipType;", "blockedUsers", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserActiveViewModel$StoreState;", "invoke", "(Lcom/discord/models/user/MeUser;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;Ljava/util/Map;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserActiveViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function10<MeUser, Map<Long, ? extends User>, Map<Long, ? extends StoreThreadMessages.ThreadState>, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Map<Long, ? extends String>, Long, Map<Long, ? extends Integer>, Channel, Guild, WidgetThreadBrowserActiveViewModel.StoreState> {
        public final /* synthetic */ Map $activeJoinedThreads;
        public final /* synthetic */ Map $activeThreads;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Map map, Map map2) {
            super(10);
            this.$activeJoinedThreads = map;
            this.$activeThreads = map2;
        }

        @Override // kotlin.jvm.functions.Function10
        public /* bridge */ /* synthetic */ WidgetThreadBrowserActiveViewModel.StoreState invoke(MeUser meUser, Map<Long, ? extends User> map, Map<Long, ? extends StoreThreadMessages.ThreadState> map2, Map<Long, ? extends GuildMember> map3, Map<Long, ? extends GuildRole> map4, Map<Long, ? extends String> map5, Long l, Map<Long, ? extends Integer> map6, Channel channel, Guild guild) {
            return invoke2(meUser, map, (Map<Long, StoreThreadMessages.ThreadState>) map2, (Map<Long, GuildMember>) map3, (Map<Long, GuildRole>) map4, (Map<Long, String>) map5, l, (Map<Long, Integer>) map6, channel, guild);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetThreadBrowserActiveViewModel.StoreState invoke2(MeUser meUser, Map<Long, ? extends User> map, Map<Long, StoreThreadMessages.ThreadState> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, Map<Long, String> map5, Long l, Map<Long, Integer> map6, Channel channel, Guild guild) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(map, "users");
            Intrinsics3.checkNotNullParameter(map2, "threadStates");
            Intrinsics3.checkNotNullParameter(map4, "guildRoles");
            Intrinsics3.checkNotNullParameter(map5, "channelNames");
            Intrinsics3.checkNotNullParameter(map6, "blockedUsers");
            Map map7 = this.$activeJoinedThreads;
            Intrinsics3.checkNotNullExpressionValue(map7, "activeJoinedThreads");
            Map map8 = this.$activeThreads;
            Intrinsics3.checkNotNullExpressionValue(map8, "activeThreads");
            Intrinsics3.checkNotNullExpressionValue(map3, "guildMembers");
            return new WidgetThreadBrowserActiveViewModel.StoreState(meUser, map7, map8, map2, map3, map, map4, map5, l, map6, channel, guild);
        }
    }

    public WidgetThreadBrowserActiveViewModel4(StoreUser storeUser, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, long j, StoreChannels storeChannels, StorePermissions storePermissions, long j2) {
        this.$storeUser = storeUser;
        this.$storeThreadMessages = storeThreadMessages;
        this.$storeGuilds = storeGuilds;
        this.$guildId = j;
        this.$storeChannels = storeChannels;
        this.$storePermissions = storePermissions;
        this.$channelId = j2;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadBrowserActiveViewModel.StoreState> call(Tuples2<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>> tuples2) {
        return call2((Tuples2<? extends Map<Long, Channel>, ? extends Map<Long, Channel>>) tuples2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetThreadBrowserActiveViewModel.StoreState> call2(Tuples2<? extends Map<Long, Channel>, ? extends Map<Long, Channel>> tuples2) {
        Map<Long, Channel> mapComponent1 = tuples2.component1();
        Map<Long, Channel> mapComponent2 = tuples2.component2();
        Observable observableObserveMe$default = StoreUser.observeMe$default(this.$storeUser, false, 1, null);
        StoreUser storeUser = this.$storeUser;
        HashSet hashSet = new HashSet();
        Intrinsics3.checkNotNullExpressionValue(mapComponent1, "activeJoinedThreads");
        Iterator<Map.Entry<Long, Channel>> it = mapComponent1.entrySet().iterator();
        while (it.hasNext()) {
            hashSet.add(Long.valueOf(it.next().getValue().getOwnerId()));
        }
        Intrinsics3.checkNotNullExpressionValue(mapComponent2, "activeThreads");
        Iterator<Map.Entry<Long, Channel>> it2 = mapComponent2.entrySet().iterator();
        while (it2.hasNext()) {
            hashSet.add(Long.valueOf(it2.next().getValue().getOwnerId()));
        }
        Observable<Map<Long, User>> observableObserveUsers = storeUser.observeUsers(hashSet);
        Observable<Map<Long, StoreThreadMessages.ThreadState>> observableObserveThreadCountAndLatestMessage = this.$storeThreadMessages.observeThreadCountAndLatestMessage();
        Observable<Map<Long, GuildMember>> observableObserveGuildMembers = this.$storeGuilds.observeGuildMembers(this.$guildId);
        Intrinsics3.checkNotNullExpressionValue(observableObserveGuildMembers, "storeGuilds\n            …erveGuildMembers(guildId)");
        Observable<T> observableR = ObservableExtensionsKt.leadingEdgeThrottle(observableObserveGuildMembers, 1L, TimeUnit.SECONDS).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeGuilds\n            …  .distinctUntilChanged()");
        return ObservableCombineLatestOverloads2.combineLatest(observableObserveMe$default, observableObserveUsers, observableObserveThreadCountAndLatestMessage, observableR, this.$storeGuilds.observeRoles(this.$guildId), this.$storeChannels.observeNames(), this.$storePermissions.observePermissionsForChannel(this.$channelId), StoreStream.INSTANCE.getUserRelationships().observeForType(2), this.$storeChannels.observeChannel(this.$channelId), this.$storeGuilds.observeGuild(this.$guildId), new AnonymousClass2(mapComponent1, mapComponent2));
    }
}
