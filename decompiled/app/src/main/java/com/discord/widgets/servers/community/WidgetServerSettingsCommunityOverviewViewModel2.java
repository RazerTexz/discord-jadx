package com.discord.widgets.servers.community;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lrx/Observable;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverviewViewModel2<T, R> implements Func1<Guild, Observable<? extends WidgetServerSettingsCommunityOverviewViewModel.StoreState>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUser $storeUsers;

    /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\f\u001a\n \u0001*\u0004\u0018\u00010\t0\t2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lcom/discord/api/channel/Channel;", "rulesChannel", "updatesChannel", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Ljava/lang/Long;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, R> implements Func4<MeUser, Long, Channel, Channel, WidgetServerSettingsCommunityOverviewViewModel.StoreState.Valid> {
        public final /* synthetic */ Guild $guild;

        public AnonymousClass1(Guild guild) {
            this.$guild = guild;
        }

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel.StoreState.Valid call(MeUser meUser, Long l, Channel channel, Channel channel2) {
            return call2(meUser, l, channel, channel2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsCommunityOverviewViewModel.StoreState.Valid call2(MeUser meUser, Long l, Channel channel, Channel channel2) {
            Guild guild = this.$guild;
            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
            return new WidgetServerSettingsCommunityOverviewViewModel.StoreState.Valid(guild, meUser, l, channel, channel2);
        }
    }

    public WidgetServerSettingsCommunityOverviewViewModel2(StoreUser storeUser, StorePermissions storePermissions, long j, StoreChannels storeChannels) {
        this.$storeUsers = storeUser;
        this.$storePermissions = storePermissions;
        this.$guildId = j;
        this.$storeChannels = storeChannels;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsCommunityOverviewViewModel.StoreState> call(Guild guild) {
        return call2(guild);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsCommunityOverviewViewModel.StoreState> call2(Guild guild) {
        if (guild == null) {
            return new ScalarSynchronousObservable(WidgetServerSettingsCommunityOverviewViewModel.StoreState.Invalid.INSTANCE);
        }
        Observable observableObserveMe$default = StoreUser.observeMe$default(this.$storeUsers, false, 1, null);
        Observable<Long> observableObservePermissionsForGuild = this.$storePermissions.observePermissionsForGuild(this.$guildId);
        StoreChannels storeChannels = this.$storeChannels;
        Long rulesChannelId = guild.getRulesChannelId();
        Observable<Channel> observableObserveChannel = storeChannels.observeChannel(rulesChannelId != null ? rulesChannelId.longValue() : 0L);
        StoreChannels storeChannels2 = this.$storeChannels;
        Long publicUpdatesChannelId = guild.getPublicUpdatesChannelId();
        return Observable.h(observableObserveMe$default, observableObservePermissionsForGuild, observableObserveChannel, storeChannels2.observeChannel(publicUpdatesChannelId != null ? publicUpdatesChannelId.longValue() : 0L), new AnonymousClass1(guild));
    }
}
