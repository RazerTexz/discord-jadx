package com.discord.widgets.channels.permissions;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.NewThreadsPermissionsFeatureFlag;
import d0.z.d.Intrinsics3;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00182\u00020\u0001:\u0003\u0018\u0019\u001aB)\b\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u0082\u0001\u0002\u001b\u001c¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;", "", "", "type", "I", "getType", "()I", "", "useNewThreadsPermissions", "Z", "getUseNewThreadsPermissions", "()Z", "", "targetId", "J", "getTargetId", "()J", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/api/channel/Channel;", "getChannel", "()Lcom/discord/api/channel/Channel;", "<init>", "(Lcom/discord/api/channel/Channel;JIZ)V", "Companion", "ModelForRole", "ModelForUser", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel$ModelForRole;", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel$ModelForUser;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class WidgetChannelSettingsEditPermissionsModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Channel channel;
    private final long targetId;
    private final int type;
    private final boolean useNewThreadsPermissions;

    /* compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b'\u0010(Jc\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\n\u0010\b\u001a\u00060\u0002j\u0002`\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J;\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\n\u0010\u0016\u001a\u00060\u0002j\u0002`\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\n\u0010\u001e\u001a\u00060\u0002j\u0002`\u001dH\u0002¢\u0006\u0004\b \u0010!J5\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/UserId;", "targetUserId", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lrx/Observable;", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;", "getForUser", "(JJJLcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StorePermissions;)Lrx/Observable;", "Lcom/discord/primitives/RoleId;", "targetRoleId", "getForRole", "(JJJ)Lrx/Observable;", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/user/MeUser;", "meUser", "Lcom/discord/api/permission/PermissionBit;", "myPermissionsForChannel", "", "isAbleToManagePerms", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;J)Z", "targetId", "", "type", "get", "(JJJI)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ boolean access$isAbleToManagePerms(Companion companion, Guild guild, MeUser meUser, long j) {
            return companion.isAbleToManagePerms(guild, meUser, j);
        }

        private final Observable<WidgetChannelSettingsEditPermissionsModel> getForRole(long guildId, long channelId, long targetRoleId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableE = Observable.e(companion.getChannels().observeChannel(channelId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), companion.getPermissions().observePermissionsForChannel(channelId), companion.getGuilds().observeRoles(guildId), companion.getGuilds().observeComputed(guildId), NewThreadsPermissionsFeatureFlag.INSTANCE.getINSTANCE().observeEnabled(guildId), new WidgetChannelSettingsEditPermissionsModel2(targetRoleId));
            Intrinsics3.checkNotNullExpressionValue(observableE, "Observable\n            .…          }\n            }");
            Observable<WidgetChannelSettingsEditPermissionsModel> observableR = ObservableExtensionsKt.computationLatest(observableE).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
            return observableR;
        }

        private final Observable<WidgetChannelSettingsEditPermissionsModel> getForUser(long guildId, long channelId, long targetUserId, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StorePermissions storePermissions) {
            Observable<WidgetChannelSettingsEditPermissionsModel> observableR = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{storeChannels, storeUser, storeGuilds, storePermissions}, false, null, null, new WidgetChannelSettingsEditPermissionsModel3(storeChannels, channelId, storeUser, targetUserId, storeGuilds, guildId, storePermissions), 14, null)).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.…  .distinctUntilChanged()");
            return observableR;
        }

        public static /* synthetic */ Observable getForUser$default(Companion companion, long j, long j2, long j3, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StorePermissions storePermissions, int i, Object obj) {
            return companion.getForUser(j, j2, j3, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 32) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 64) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions);
        }

        private final boolean isAbleToManagePerms(Guild guild, MeUser meUser, long myPermissionsForChannel) {
            return ((guild.getOwnerId() > meUser.getId() ? 1 : (guild.getOwnerId() == meUser.getId() ? 0 : -1)) == 0) || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, Long.valueOf(myPermissionsForChannel), meUser.getMfaEnabled(), guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, Long.valueOf(myPermissionsForChannel), meUser.getMfaEnabled(), guild.getMfaLevel());
        }

        public final Observable<WidgetChannelSettingsEditPermissionsModel> get(long guildId, long channelId, long targetId, int type) {
            if (type == 0) {
                return getForUser$default(this, guildId, channelId, targetId, null, null, null, null, 120, null);
            }
            if (type == 1) {
                return getForRole(guildId, channelId, targetId);
            }
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n              .just(null)");
            return scalarSynchronousObservable;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\n\u0010\u0019\u001a\u00060\u0002j\u0002`\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0004¢\u0006\u0004\b9\u0010:J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\f\u001a\u00060\u0002j\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0015Jn\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\b2\f\b\u0002\u0010\u0019\u001a\u00060\u0002j\u0002`\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003¢\u0006\u0004\b+\u0010,R\u0019\u0010\u001f\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010-\u001a\u0004\b\u001f\u0010\u0015R\u0019\u0010\u001e\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b.\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b0\u0010\rR\u001c\u0010 \u001a\u00020\u00048\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010-\u001a\u0004\b1\u0010\u0015R\u001c\u0010\u0018\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u00102\u001a\u0004\b3\u0010\nR\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b4\u0010\rR\u001c\u0010\u001b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b5\u0010\rR\u001d\u0010\u0019\u001a\u00060\u0002j\u0002`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b6\u0010\rR\u0019\u0010\u001a\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00107\u001a\u0004\b8\u0010\u0010¨\u0006;"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel$ModelForRole;", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;", "", "permission", "", "canNeutralizeRolePermission", "(J)Z", "canDenyRolePermission", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/api/permission/PermissionBit;", "component2", "()J", "Lcom/discord/api/role/GuildRole;", "component3", "()Lcom/discord/api/role/GuildRole;", "component4", "component5", "component6", "component7", "()Z", "component8", "component9", "channel", "myPermissionsForChannel", "guildRole", "targetId", "myPermissionsWithRoleNeutral", "myPermissionsWithRoleDenied", "meHasRole", "isEveryoneRole", "useNewThreadsPermissions", "copy", "(Lcom/discord/api/channel/Channel;JLcom/discord/api/role/GuildRole;JJJZZZ)Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel$ModelForRole;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getMeHasRole", "J", "getMyPermissionsWithRoleNeutral", "getUseNewThreadsPermissions", "Lcom/discord/api/channel/Channel;", "getChannel", "getMyPermissionsWithRoleDenied", "getTargetId", "getMyPermissionsForChannel", "Lcom/discord/api/role/GuildRole;", "getGuildRole", "<init>", "(Lcom/discord/api/channel/Channel;JLcom/discord/api/role/GuildRole;JJJZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ModelForRole extends WidgetChannelSettingsEditPermissionsModel {
        private final Channel channel;
        private final GuildRole guildRole;
        private final boolean isEveryoneRole;
        private final boolean meHasRole;
        private final long myPermissionsForChannel;
        private final long myPermissionsWithRoleDenied;
        private final long myPermissionsWithRoleNeutral;
        private final long targetId;
        private final boolean useNewThreadsPermissions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModelForRole(Channel channel, long j, GuildRole guildRole, long j2, long j3, long j4, boolean z2, boolean z3, boolean z4) {
            super(channel, j2, 1, z4, null);
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(guildRole, "guildRole");
            this.channel = channel;
            this.myPermissionsForChannel = j;
            this.guildRole = guildRole;
            this.targetId = j2;
            this.myPermissionsWithRoleNeutral = j3;
            this.myPermissionsWithRoleDenied = j4;
            this.meHasRole = z2;
            this.isEveryoneRole = z3;
            this.useNewThreadsPermissions = z4;
        }

        public static /* synthetic */ ModelForRole copy$default(ModelForRole modelForRole, Channel channel, long j, GuildRole guildRole, long j2, long j3, long j4, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            return modelForRole.copy((i & 1) != 0 ? modelForRole.getChannel() : channel, (i & 2) != 0 ? modelForRole.myPermissionsForChannel : j, (i & 4) != 0 ? modelForRole.guildRole : guildRole, (i & 8) != 0 ? modelForRole.getTargetId() : j2, (i & 16) != 0 ? modelForRole.myPermissionsWithRoleNeutral : j3, (i & 32) != 0 ? modelForRole.myPermissionsWithRoleDenied : j4, (i & 64) != 0 ? modelForRole.meHasRole : z2, (i & 128) != 0 ? modelForRole.isEveryoneRole : z3, (i & 256) != 0 ? modelForRole.getUseNewThreadsPermissions() : z4);
        }

        public final boolean canDenyRolePermission(long permission) {
            return (this.myPermissionsWithRoleDenied & permission) == (permission & this.myPermissionsForChannel);
        }

        public final boolean canNeutralizeRolePermission(long permission) {
            return (this.myPermissionsWithRoleNeutral & permission) == (permission & this.myPermissionsForChannel);
        }

        public final Channel component1() {
            return getChannel();
        }

        /* renamed from: component2, reason: from getter */
        public final long getMyPermissionsForChannel() {
            return this.myPermissionsForChannel;
        }

        /* renamed from: component3, reason: from getter */
        public final GuildRole getGuildRole() {
            return this.guildRole;
        }

        public final long component4() {
            return getTargetId();
        }

        /* renamed from: component5, reason: from getter */
        public final long getMyPermissionsWithRoleNeutral() {
            return this.myPermissionsWithRoleNeutral;
        }

        /* renamed from: component6, reason: from getter */
        public final long getMyPermissionsWithRoleDenied() {
            return this.myPermissionsWithRoleDenied;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getMeHasRole() {
            return this.meHasRole;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getIsEveryoneRole() {
            return this.isEveryoneRole;
        }

        public final boolean component9() {
            return getUseNewThreadsPermissions();
        }

        public final ModelForRole copy(Channel channel, long myPermissionsForChannel, GuildRole guildRole, long targetId, long myPermissionsWithRoleNeutral, long myPermissionsWithRoleDenied, boolean meHasRole, boolean isEveryoneRole, boolean useNewThreadsPermissions) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(guildRole, "guildRole");
            return new ModelForRole(channel, myPermissionsForChannel, guildRole, targetId, myPermissionsWithRoleNeutral, myPermissionsWithRoleDenied, meHasRole, isEveryoneRole, useNewThreadsPermissions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModelForRole)) {
                return false;
            }
            ModelForRole modelForRole = (ModelForRole) other;
            return Intrinsics3.areEqual(getChannel(), modelForRole.getChannel()) && this.myPermissionsForChannel == modelForRole.myPermissionsForChannel && Intrinsics3.areEqual(this.guildRole, modelForRole.guildRole) && getTargetId() == modelForRole.getTargetId() && this.myPermissionsWithRoleNeutral == modelForRole.myPermissionsWithRoleNeutral && this.myPermissionsWithRoleDenied == modelForRole.myPermissionsWithRoleDenied && this.meHasRole == modelForRole.meHasRole && this.isEveryoneRole == modelForRole.isEveryoneRole && getUseNewThreadsPermissions() == modelForRole.getUseNewThreadsPermissions();
        }

        @Override // com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel
        public Channel getChannel() {
            return this.channel;
        }

        public final GuildRole getGuildRole() {
            return this.guildRole;
        }

        public final boolean getMeHasRole() {
            return this.meHasRole;
        }

        public final long getMyPermissionsForChannel() {
            return this.myPermissionsForChannel;
        }

        public final long getMyPermissionsWithRoleDenied() {
            return this.myPermissionsWithRoleDenied;
        }

        public final long getMyPermissionsWithRoleNeutral() {
            return this.myPermissionsWithRoleNeutral;
        }

        @Override // com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel
        public long getTargetId() {
            return this.targetId;
        }

        @Override // com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel
        public boolean getUseNewThreadsPermissions() {
            return this.useNewThreadsPermissions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = getChannel();
            int iA = (b.a(this.myPermissionsForChannel) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
            GuildRole guildRole = this.guildRole;
            int iA2 = (b.a(this.myPermissionsWithRoleDenied) + ((b.a(this.myPermissionsWithRoleNeutral) + ((b.a(getTargetId()) + ((iA + (guildRole != null ? guildRole.hashCode() : 0)) * 31)) * 31)) * 31)) * 31;
            boolean z2 = this.meHasRole;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iA2 + i) * 31;
            boolean z3 = this.isEveryoneRole;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean useNewThreadsPermissions = getUseNewThreadsPermissions();
            return i4 + (useNewThreadsPermissions ? 1 : useNewThreadsPermissions);
        }

        public final boolean isEveryoneRole() {
            return this.isEveryoneRole;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModelForRole(channel=");
            sbU.append(getChannel());
            sbU.append(", myPermissionsForChannel=");
            sbU.append(this.myPermissionsForChannel);
            sbU.append(", guildRole=");
            sbU.append(this.guildRole);
            sbU.append(", targetId=");
            sbU.append(getTargetId());
            sbU.append(", myPermissionsWithRoleNeutral=");
            sbU.append(this.myPermissionsWithRoleNeutral);
            sbU.append(", myPermissionsWithRoleDenied=");
            sbU.append(this.myPermissionsWithRoleDenied);
            sbU.append(", meHasRole=");
            sbU.append(this.meHasRole);
            sbU.append(", isEveryoneRole=");
            sbU.append(this.isEveryoneRole);
            sbU.append(", useNewThreadsPermissions=");
            sbU.append(getUseNewThreadsPermissions());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\n\u0010\u0014\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJR\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\f\b\u0002\u0010\u0014\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b#\u0010$R\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u0004R\u001d\u0010\u0014\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\bR\u001c\u0010\u0018\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b*\u0010\u000bR\u0019\u0010\u0016\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b\u0015\u0010\u000bR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b.\u0010\u0011¨\u00061"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel$ModelForUser;", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "Lcom/discord/api/permission/PermissionBit;", "component2", "()J", "", "component3", "()Z", "Lcom/discord/models/user/User;", "component4", "()Lcom/discord/models/user/User;", "Lcom/discord/models/member/GuildMember;", "component5", "()Lcom/discord/models/member/GuildMember;", "component6", "channel", "myPermissionsForChannel", "isMe", "user", "guildMember", "useNewThreadsPermissions", "copy", "(Lcom/discord/api/channel/Channel;JZLcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;Z)Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel$ModelForUser;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "J", "getMyPermissionsForChannel", "Z", "getUseNewThreadsPermissions", "Lcom/discord/models/user/User;", "getUser", "Lcom/discord/models/member/GuildMember;", "getGuildMember", "<init>", "(Lcom/discord/api/channel/Channel;JZLcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ModelForUser extends WidgetChannelSettingsEditPermissionsModel {
        private final Channel channel;
        private final GuildMember guildMember;
        private final boolean isMe;
        private final long myPermissionsForChannel;
        private final boolean useNewThreadsPermissions;
        private final User user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModelForUser(Channel channel, long j, boolean z2, User user, GuildMember guildMember, boolean z3) {
            super(channel, user.getId(), 0, z3, null);
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(user, "user");
            this.channel = channel;
            this.myPermissionsForChannel = j;
            this.isMe = z2;
            this.user = user;
            this.guildMember = guildMember;
            this.useNewThreadsPermissions = z3;
        }

        public static /* synthetic */ ModelForUser copy$default(ModelForUser modelForUser, Channel channel, long j, boolean z2, User user, GuildMember guildMember, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = modelForUser.getChannel();
            }
            if ((i & 2) != 0) {
                j = modelForUser.myPermissionsForChannel;
            }
            long j2 = j;
            if ((i & 4) != 0) {
                z2 = modelForUser.isMe;
            }
            boolean z4 = z2;
            if ((i & 8) != 0) {
                user = modelForUser.user;
            }
            User user2 = user;
            if ((i & 16) != 0) {
                guildMember = modelForUser.guildMember;
            }
            GuildMember guildMember2 = guildMember;
            if ((i & 32) != 0) {
                z3 = modelForUser.getUseNewThreadsPermissions();
            }
            return modelForUser.copy(channel, j2, z4, user2, guildMember2, z3);
        }

        public final Channel component1() {
            return getChannel();
        }

        /* renamed from: component2, reason: from getter */
        public final long getMyPermissionsForChannel() {
            return this.myPermissionsForChannel;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsMe() {
            return this.isMe;
        }

        /* renamed from: component4, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component5, reason: from getter */
        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final boolean component6() {
            return getUseNewThreadsPermissions();
        }

        public final ModelForUser copy(Channel channel, long myPermissionsForChannel, boolean isMe, User user, GuildMember guildMember, boolean useNewThreadsPermissions) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(user, "user");
            return new ModelForUser(channel, myPermissionsForChannel, isMe, user, guildMember, useNewThreadsPermissions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModelForUser)) {
                return false;
            }
            ModelForUser modelForUser = (ModelForUser) other;
            return Intrinsics3.areEqual(getChannel(), modelForUser.getChannel()) && this.myPermissionsForChannel == modelForUser.myPermissionsForChannel && this.isMe == modelForUser.isMe && Intrinsics3.areEqual(this.user, modelForUser.user) && Intrinsics3.areEqual(this.guildMember, modelForUser.guildMember) && getUseNewThreadsPermissions() == modelForUser.getUseNewThreadsPermissions();
        }

        @Override // com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel
        public Channel getChannel() {
            return this.channel;
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final long getMyPermissionsForChannel() {
            return this.myPermissionsForChannel;
        }

        @Override // com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel
        public boolean getUseNewThreadsPermissions() {
            return this.useNewThreadsPermissions;
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = getChannel();
            int iA = (b.a(this.myPermissionsForChannel) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
            boolean z2 = this.isMe;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iA + i) * 31;
            User user = this.user;
            int iHashCode = (i2 + (user != null ? user.hashCode() : 0)) * 31;
            GuildMember guildMember = this.guildMember;
            int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            boolean useNewThreadsPermissions = getUseNewThreadsPermissions();
            return iHashCode2 + (useNewThreadsPermissions ? 1 : useNewThreadsPermissions);
        }

        public final boolean isMe() {
            return this.isMe;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModelForUser(channel=");
            sbU.append(getChannel());
            sbU.append(", myPermissionsForChannel=");
            sbU.append(this.myPermissionsForChannel);
            sbU.append(", isMe=");
            sbU.append(this.isMe);
            sbU.append(", user=");
            sbU.append(this.user);
            sbU.append(", guildMember=");
            sbU.append(this.guildMember);
            sbU.append(", useNewThreadsPermissions=");
            sbU.append(getUseNewThreadsPermissions());
            sbU.append(")");
            return sbU.toString();
        }
    }

    private WidgetChannelSettingsEditPermissionsModel(Channel channel, long j, int i, boolean z2) {
        this.channel = channel;
        this.targetId = j;
        this.type = i;
        this.useNewThreadsPermissions = z2;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public long getTargetId() {
        return this.targetId;
    }

    public final int getType() {
        return this.type;
    }

    public boolean getUseNewThreadsPermissions() {
        return this.useNewThreadsPermissions;
    }

    public /* synthetic */ WidgetChannelSettingsEditPermissionsModel(Channel channel, long j, int i, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, j, i, z2);
    }
}
