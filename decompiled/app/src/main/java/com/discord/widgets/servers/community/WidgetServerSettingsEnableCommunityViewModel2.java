package com.discord.widgets.servers.community;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func5;

/* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lrx/Observable;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunityViewModel2<T, R> implements Func1<Guild, Observable<? extends WidgetServerSettingsEnableCommunityViewModel.StoreState>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUser $storeUsers;

    /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0010\u001a\n \u0001*\u0004\u0018\u00010\r0\r2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042.\u0010\t\u001a*\u0012\b\u0012\u00060\u0003j\u0002`\u0007\u0012\u0004\u0012\u00020\b \u0001*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00060\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\n¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "roles", "Lcom/discord/api/channel/Channel;", "rulesChannel", "updatesChannel", "Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Ljava/lang/Long;Ljava/util/Map;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, R> implements Func5<MeUser, Long, Map<Long, ? extends GuildRole>, Channel, Channel, WidgetServerSettingsEnableCommunityViewModel.StoreState.Valid> {
        public final /* synthetic */ Guild $guild;

        public AnonymousClass1(Guild guild) {
            this.$guild = guild;
        }

        @Override // rx.functions.Func5
        public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.StoreState.Valid call(MeUser meUser, Long l, Map<Long, ? extends GuildRole> map, Channel channel, Channel channel2) {
            return call2(meUser, l, (Map<Long, GuildRole>) map, channel, channel2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsEnableCommunityViewModel.StoreState.Valid call2(MeUser meUser, Long l, Map<Long, GuildRole> map, Channel channel, Channel channel2) {
            Guild guild = this.$guild;
            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
            return new WidgetServerSettingsEnableCommunityViewModel.StoreState.Valid(guild, meUser, l, map, channel, channel2);
        }
    }

    public WidgetServerSettingsEnableCommunityViewModel2(StoreUser storeUser, StorePermissions storePermissions, long j, StoreChannels storeChannels) {
        this.$storeUsers = storeUser;
        this.$storePermissions = storePermissions;
        this.$guildId = j;
        this.$storeChannels = storeChannels;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsEnableCommunityViewModel.StoreState> call(Guild guild) {
        return call2(guild);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsEnableCommunityViewModel.StoreState> call2(Guild guild) {
        if (guild == null) {
            return new ScalarSynchronousObservable(WidgetServerSettingsEnableCommunityViewModel.StoreState.Invalid.INSTANCE);
        }
        Observable observableObserveMe$default = StoreUser.observeMe$default(this.$storeUsers, false, 1, null);
        Observable<Long> observableObservePermissionsForGuild = this.$storePermissions.observePermissionsForGuild(this.$guildId);
        Observable<Map<Long, GuildRole>> observableObserveRoles = StoreStream.INSTANCE.getGuilds().observeRoles(this.$guildId);
        StoreChannels storeChannels = this.$storeChannels;
        Long rulesChannelId = guild.getRulesChannelId();
        Observable<Channel> observableObserveChannel = storeChannels.observeChannel(rulesChannelId != null ? rulesChannelId.longValue() : 0L);
        StoreChannels storeChannels2 = this.$storeChannels;
        Long publicUpdatesChannelId = guild.getPublicUpdatesChannelId();
        return Observable.g(observableObserveMe$default, observableObservePermissionsForGuild, observableObserveRoles, observableObserveChannel, storeChannels2.observeChannel(publicUpdatesChannelId != null ? publicUpdatesChannelId.longValue() : 0L), new AnonymousClass1(guild));
    }
}
