package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildProfiles;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.widgets.servers.WidgetServerSettingsOverview;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func5;

/* compiled from: WidgetServerSettingsOverview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003 \u0004*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettingsOverview$Model;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsOverview5<T, R> implements Func1<Guild, Observable<? extends WidgetServerSettingsOverview.Model>> {
    public final /* synthetic */ long $guildId;

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a\n \u0001*\u0004\u0018\u00010\u000b0\u000b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "Lcom/discord/api/channel/Channel;", "afkChannel", "systemChannel", "", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "guildProfile", "Lcom/discord/widgets/servers/WidgetServerSettingsOverview$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Ljava/lang/Long;Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;)Lcom/discord/widgets/servers/WidgetServerSettingsOverview$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, R> implements Func5<MeUser, Channel, Channel, Long, StoreGuildProfiles.GuildProfileData, WidgetServerSettingsOverview.Model> {
        public final /* synthetic */ Guild $guild;

        public AnonymousClass1(Guild guild) {
            this.$guild = guild;
        }

        @Override // rx.functions.Func5
        public /* bridge */ /* synthetic */ WidgetServerSettingsOverview.Model call(MeUser meUser, Channel channel, Channel channel2, Long l, StoreGuildProfiles.GuildProfileData guildProfileData) {
            return call2(meUser, channel, channel2, l, guildProfileData);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsOverview.Model call2(MeUser meUser, Channel channel, Channel channel2, Long l, StoreGuildProfiles.GuildProfileData guildProfileData) {
            Guild guild = this.$guild;
            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
            return new WidgetServerSettingsOverview.Model(guild, meUser, channel, channel2, l, guildProfileData);
        }
    }

    public WidgetServerSettingsOverview5(long j) {
        this.$guildId = j;
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsOverview.Model> call2(Guild guild) {
        if (guild == null) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
        StoreChannels channels = companion.getChannels();
        Long afkChannelId = guild.getAfkChannelId();
        Observable<Channel> observableObserveChannel = channels.observeChannel(afkChannelId != null ? afkChannelId.longValue() : 0L);
        StoreChannels channels2 = companion.getChannels();
        Long systemChannelId = guild.getSystemChannelId();
        return Observable.g(observableObserveMe$default, observableObserveChannel, channels2.observeChannel(systemChannelId != null ? systemChannelId.longValue() : 0L), companion.getPermissions().observePermissionsForGuild(this.$guildId), companion.getGuildProfiles().observeGuildProfile(this.$guildId), new AnonymousClass1(guild));
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsOverview.Model> call(Guild guild) {
        return call2(guild);
    }
}
