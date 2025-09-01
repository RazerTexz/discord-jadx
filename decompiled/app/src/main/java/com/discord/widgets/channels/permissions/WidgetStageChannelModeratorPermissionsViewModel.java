package com.discord.widgets.channels.permissions;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
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
import com.discord.widgets.channels.permissions.PermissionOwner;
import com.discord.widgets.channels.permissions.PermissionOwnerListView;
import d0.d0._Ranges;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.p.Schedulers2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u0013\u0012\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState;", "Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState;)V", "Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid;", "Lcom/discord/api/role/GuildRole;", "role", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus;", "getRoleRemoveStatus", "(Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid;Lcom/discord/api/role/GuildRole;)Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus;", "", "isOwner", "getMemberRemoveStatus", "(Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid;Z)Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "<init>", "(J)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetStageChannelModeratorPermissionsViewModel widgetStageChannelModeratorPermissionsViewModel = WidgetStageChannelModeratorPermissionsViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            WidgetStageChannelModeratorPermissionsViewModel.access$handleStoreState(widgetStageChannelModeratorPermissionsViewModel, storeState);
        }
    }

    /* compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JI\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreGuilds;", "guildStore", "Lcom/discord/stores/StoreChannels;", "channelStore", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StorePermissions;", "permissionStore", "Lrx/Observable;", "Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState;", "observeStores", "(JLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StorePermissions;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(long channelId, StoreGuilds guildStore, StoreChannels channelStore, StoreUser userStore, StorePermissions permissionStore) {
            return ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{guildStore, channelStore, userStore, permissionStore}, false, null, null, new WidgetStageChannelModeratorPermissionsViewModel2(channelStore, channelId, guildStore, userStore, permissionStore), 14, null);
        }

        public static /* synthetic */ Observable observeStores$default(Companion companion, long j, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, StorePermissions storePermissions, int i, Object obj) {
            if ((i & 2) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            StoreGuilds storeGuilds2 = storeGuilds;
            if ((i & 4) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 8) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            StoreUser storeUser2 = storeUser;
            if ((i & 16) != 0) {
                storePermissions = StoreStream.INSTANCE.getPermissions();
            }
            return companion.observeStores(j, storeGuilds2, storeChannels2, storeUser2, storePermissions);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid;", "Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState$Invalid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState$Invalid;", "Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\t\u0012\u0016\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000f\u0012\u0004\u0012\u00020\u00100\t\u0012\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000f\u0012\u0004\u0012\u00020\u00120\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0016¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ \u0010\r\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000f\u0012\u0004\u0012\u00020\u00100\tHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000eJ \u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000f\u0012\u0004\u0012\u00020\u00120\tHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000eJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u008e\u0001\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\t2\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000f\u0012\u0004\u0012\u00020\u00100\t2\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000f\u0012\u0004\u0012\u00020\u00120\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u0016HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b-\u0010\bR)\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000f\u0012\u0004\u0012\u00020\u00100\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010.\u001a\u0004\b/\u0010\u000eR\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u0010\u0004R\u0019\u0010\u001f\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00102\u001a\u0004\b3\u0010\u0018R)\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000f\u0012\u0004\u0012\u00020\u00120\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010.\u001a\u0004\b4\u0010\u000eR)\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b5\u0010\u000eR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00106\u001a\u0004\b7\u0010\u0015¨\u0006:"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid;", "Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "Lcom/discord/api/permission/PermissionOverwrite;", "component2", "()Ljava/util/List;", "", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "component3", "()Ljava/util/Map;", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "component4", "Lcom/discord/models/member/GuildMember;", "component5", "component6", "()Lcom/discord/models/user/User;", "", "component7", "()Z", "guild", "channelPermissionOverwrites", "guildRoles", "usersWithOverwrites", "guildMembers", "guildOwnerUser", "canEditModerators", "copy", "(Lcom/discord/models/guild/Guild;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/discord/models/user/User;Z)Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getChannelPermissionOverwrites", "Ljava/util/Map;", "getUsersWithOverwrites", "Lcom/discord/models/guild/Guild;", "getGuild", "Z", "getCanEditModerators", "getGuildMembers", "getGuildRoles", "Lcom/discord/models/user/User;", "getGuildOwnerUser", "<init>", "(Lcom/discord/models/guild/Guild;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/discord/models/user/User;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends StoreState {
            private final boolean canEditModerators;
            private final List<PermissionOverwrite> channelPermissionOverwrites;
            private final Guild guild;
            private final Map<Long, GuildMember> guildMembers;
            private final User guildOwnerUser;
            private final Map<Long, GuildRole> guildRoles;
            private final Map<Long, User> usersWithOverwrites;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Valid(Guild guild, List<PermissionOverwrite> list, Map<Long, GuildRole> map, Map<Long, ? extends User> map2, Map<Long, GuildMember> map3, User user, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(list, "channelPermissionOverwrites");
                Intrinsics3.checkNotNullParameter(map, "guildRoles");
                Intrinsics3.checkNotNullParameter(map2, "usersWithOverwrites");
                Intrinsics3.checkNotNullParameter(map3, "guildMembers");
                this.guild = guild;
                this.channelPermissionOverwrites = list;
                this.guildRoles = map;
                this.usersWithOverwrites = map2;
                this.guildMembers = map3;
                this.guildOwnerUser = user;
                this.canEditModerators = z2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, List list, Map map, Map map2, Map map3, User user, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    list = valid.channelPermissionOverwrites;
                }
                List list2 = list;
                if ((i & 4) != 0) {
                    map = valid.guildRoles;
                }
                Map map4 = map;
                if ((i & 8) != 0) {
                    map2 = valid.usersWithOverwrites;
                }
                Map map5 = map2;
                if ((i & 16) != 0) {
                    map3 = valid.guildMembers;
                }
                Map map6 = map3;
                if ((i & 32) != 0) {
                    user = valid.guildOwnerUser;
                }
                User user2 = user;
                if ((i & 64) != 0) {
                    z2 = valid.canEditModerators;
                }
                return valid.copy(guild, list2, map4, map5, map6, user2, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final List<PermissionOverwrite> component2() {
                return this.channelPermissionOverwrites;
            }

            public final Map<Long, GuildRole> component3() {
                return this.guildRoles;
            }

            public final Map<Long, User> component4() {
                return this.usersWithOverwrites;
            }

            public final Map<Long, GuildMember> component5() {
                return this.guildMembers;
            }

            /* renamed from: component6, reason: from getter */
            public final User getGuildOwnerUser() {
                return this.guildOwnerUser;
            }

            /* renamed from: component7, reason: from getter */
            public final boolean getCanEditModerators() {
                return this.canEditModerators;
            }

            public final Valid copy(Guild guild, List<PermissionOverwrite> channelPermissionOverwrites, Map<Long, GuildRole> guildRoles, Map<Long, ? extends User> usersWithOverwrites, Map<Long, GuildMember> guildMembers, User guildOwnerUser, boolean canEditModerators) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(channelPermissionOverwrites, "channelPermissionOverwrites");
                Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
                Intrinsics3.checkNotNullParameter(usersWithOverwrites, "usersWithOverwrites");
                Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                return new Valid(guild, channelPermissionOverwrites, guildRoles, usersWithOverwrites, guildMembers, guildOwnerUser, canEditModerators);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.guild, valid.guild) && Intrinsics3.areEqual(this.channelPermissionOverwrites, valid.channelPermissionOverwrites) && Intrinsics3.areEqual(this.guildRoles, valid.guildRoles) && Intrinsics3.areEqual(this.usersWithOverwrites, valid.usersWithOverwrites) && Intrinsics3.areEqual(this.guildMembers, valid.guildMembers) && Intrinsics3.areEqual(this.guildOwnerUser, valid.guildOwnerUser) && this.canEditModerators == valid.canEditModerators;
            }

            public final boolean getCanEditModerators() {
                return this.canEditModerators;
            }

            public final List<PermissionOverwrite> getChannelPermissionOverwrites() {
                return this.channelPermissionOverwrites;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            public final User getGuildOwnerUser() {
                return this.guildOwnerUser;
            }

            public final Map<Long, GuildRole> getGuildRoles() {
                return this.guildRoles;
            }

            public final Map<Long, User> getUsersWithOverwrites() {
                return this.usersWithOverwrites;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                List<PermissionOverwrite> list = this.channelPermissionOverwrites;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                Map<Long, GuildRole> map = this.guildRoles;
                int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
                Map<Long, User> map2 = this.usersWithOverwrites;
                int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
                Map<Long, GuildMember> map3 = this.guildMembers;
                int iHashCode5 = (iHashCode4 + (map3 != null ? map3.hashCode() : 0)) * 31;
                User user = this.guildOwnerUser;
                int iHashCode6 = (iHashCode5 + (user != null ? user.hashCode() : 0)) * 31;
                boolean z2 = this.canEditModerators;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode6 + i;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(guild=");
                sbU.append(this.guild);
                sbU.append(", channelPermissionOverwrites=");
                sbU.append(this.channelPermissionOverwrites);
                sbU.append(", guildRoles=");
                sbU.append(this.guildRoles);
                sbU.append(", usersWithOverwrites=");
                sbU.append(this.usersWithOverwrites);
                sbU.append(", guildMembers=");
                sbU.append(this.guildMembers);
                sbU.append(", guildOwnerUser=");
                sbU.append(this.guildOwnerUser);
                sbU.append(", canEditModerators=");
                return outline.O(sbU, this.canEditModerators, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid;", "Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState$Invalid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState$Invalid;", "Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ:\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\tR\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001d\u0010\u0005¨\u0006 "}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid;", "Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState;", "", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$Item;", "component1", "()Ljava/util/List;", "component2", "", "component3", "()Z", "roleItems", "memberItems", "canEditModerators", "copy", "(Ljava/util/List;Ljava/util/List;Z)Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getRoleItems", "Z", "getCanEditModerators", "getMemberItems", "<init>", "(Ljava/util/List;Ljava/util/List;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends ViewState {
            private final boolean canEditModerators;
            private final List<PermissionOwnerListView.Item> memberItems;
            private final List<PermissionOwnerListView.Item> roleItems;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(List<PermissionOwnerListView.Item> list, List<PermissionOwnerListView.Item> list2, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "roleItems");
                Intrinsics3.checkNotNullParameter(list2, "memberItems");
                this.roleItems = list;
                this.memberItems = list2;
                this.canEditModerators = z2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Valid copy$default(Valid valid, List list, List list2, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = valid.roleItems;
                }
                if ((i & 2) != 0) {
                    list2 = valid.memberItems;
                }
                if ((i & 4) != 0) {
                    z2 = valid.canEditModerators;
                }
                return valid.copy(list, list2, z2);
            }

            public final List<PermissionOwnerListView.Item> component1() {
                return this.roleItems;
            }

            public final List<PermissionOwnerListView.Item> component2() {
                return this.memberItems;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getCanEditModerators() {
                return this.canEditModerators;
            }

            public final Valid copy(List<PermissionOwnerListView.Item> roleItems, List<PermissionOwnerListView.Item> memberItems, boolean canEditModerators) {
                Intrinsics3.checkNotNullParameter(roleItems, "roleItems");
                Intrinsics3.checkNotNullParameter(memberItems, "memberItems");
                return new Valid(roleItems, memberItems, canEditModerators);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.roleItems, valid.roleItems) && Intrinsics3.areEqual(this.memberItems, valid.memberItems) && this.canEditModerators == valid.canEditModerators;
            }

            public final boolean getCanEditModerators() {
                return this.canEditModerators;
            }

            public final List<PermissionOwnerListView.Item> getMemberItems() {
                return this.memberItems;
            }

            public final List<PermissionOwnerListView.Item> getRoleItems() {
                return this.roleItems;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                List<PermissionOwnerListView.Item> list = this.roleItems;
                int iHashCode = (list != null ? list.hashCode() : 0) * 31;
                List<PermissionOwnerListView.Item> list2 = this.memberItems;
                int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
                boolean z2 = this.canEditModerators;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode2 + i;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(roleItems=");
                sbU.append(this.roleItems);
                sbU.append(", memberItems=");
                sbU.append(this.memberItems);
                sbU.append(", canEditModerators=");
                return outline.O(sbU, this.canEditModerators, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetStageChannelModeratorPermissionsViewModel(long j) {
        super(null, 1, null);
        Observable observableR = Companion.observeStores$default(INSTANCE, j, null, null, null, null, 30, null).X(Schedulers2.a()).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeStores(channelId)…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), WidgetStageChannelModeratorPermissionsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetStageChannelModeratorPermissionsViewModel widgetStageChannelModeratorPermissionsViewModel, StoreState storeState) {
        widgetStageChannelModeratorPermissionsViewModel.handleStoreState(storeState);
    }

    private final PermissionOwnerListView.RemoveStatus getMemberRemoveStatus(StoreState.Valid storeState, boolean isOwner) {
        return !storeState.getCanEditModerators() ? new PermissionOwnerListView.RemoveStatus.CannotRemove(PermissionOwnerListView.RemoveStatus.CannotRemove.Reason.HAS_NO_PERMISSION) : isOwner ? new PermissionOwnerListView.RemoveStatus.CannotRemove(PermissionOwnerListView.RemoveStatus.CannotRemove.Reason.IS_GUILD_OWNER) : PermissionOwnerListView.RemoveStatus.CanRemove.INSTANCE;
    }

    private final PermissionOwnerListView.RemoveStatus getRoleRemoveStatus(StoreState.Valid storeState, GuildRole role) {
        return !storeState.getCanEditModerators() ? new PermissionOwnerListView.RemoveStatus.CannotRemove(PermissionOwnerListView.RemoveStatus.CannotRemove.Reason.HAS_NO_PERMISSION) : PermissionUtils.INSTANCE.canRole(20971536L, role, null) ? new PermissionOwnerListView.RemoveStatus.CannotRemove(PermissionOwnerListView.RemoveStatus.CannotRemove.Reason.IS_NOT_OVERRIDE) : (role.getPermissions() & 8) == 8 ? new PermissionOwnerListView.RemoveStatus.CannotRemove(PermissionOwnerListView.RemoveStatus.CannotRemove.Reason.IS_ADMINISTRATOR) : PermissionOwnerListView.RemoveStatus.CanRemove.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0187  */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.discord.widgets.channels.permissions.PermissionOwnerListView$Item] */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleStoreState(StoreState storeState) {
        List listEmptyList;
        if (!(storeState instanceof StoreState.Valid)) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        List<PermissionOverwrite> channelPermissionOverwrites = valid.getChannelPermissionOverwrites();
        ArrayList arrayList = new ArrayList();
        Iterator it = channelPermissionOverwrites.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((PermissionOverwrite) next).getType() == PermissionOverwrite.Type.ROLE) {
                arrayList.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(Long.valueOf(((PermissionOverwrite) obj).e()), obj);
        }
        Collection<GuildRole> collectionValues = valid.getGuildRoles().values();
        ArrayList<GuildRole> arrayList2 = new ArrayList();
        for (Object obj2 : collectionValues) {
            GuildRole guildRole = (GuildRole) obj2;
            if ((guildRole.getPermissions() & 8) == 8 || PermissionUtils.INSTANCE.canRole(20971536L, guildRole, (PermissionOverwrite) linkedHashMap.get(Long.valueOf(guildRole.getId())))) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList2, 10));
        for (GuildRole guildRole2 : arrayList2) {
            arrayList3.add(new PermissionOwnerListView.Item(new PermissionOwner.Role(guildRole2), getRoleRemoveStatus(valid, guildRole2)));
        }
        Set set = _Sequences2.toSet(_Sequences2.map(_Sequences2.filter(_Sequences2.filter(_Sequences2.filter(_Collections.asSequence(valid.getChannelPermissionOverwrites()), WidgetStageChannelModeratorPermissionsViewModel3.INSTANCE), WidgetStageChannelModeratorPermissionsViewModel4.INSTANCE), new WidgetStageChannelModeratorPermissionsViewModel5(storeState)), WidgetStageChannelModeratorPermissionsViewModel6.INSTANCE));
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = set.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            long jLongValue = ((Number) it2.next()).longValue();
            User user = valid.getUsersWithOverwrites().get(Long.valueOf(jLongValue));
            if (user != null) {
                GuildMember guildMember = valid.getGuildMembers().get(Long.valueOf(jLongValue));
                item = new PermissionOwnerListView.Item(new PermissionOwner.Member(user, guildMember != null ? guildMember.getNick() : null, false), getMemberRemoveStatus(valid, false));
            }
            if (item != null) {
                arrayList4.add(item);
            }
        }
        User guildOwnerUser = valid.getGuildOwnerUser();
        if (guildOwnerUser == null) {
            listEmptyList = Collections2.emptyList();
        } else {
            GuildMember guildMember2 = (GuildMember) outline.f(guildOwnerUser, valid.getGuildMembers());
            listEmptyList = CollectionsJVM.listOf(new PermissionOwnerListView.Item(new PermissionOwner.Member(guildOwnerUser, guildMember2 != null ? guildMember2.getNick() : null, true), getMemberRemoveStatus(valid, true)));
            if (listEmptyList == null) {
            }
        }
        updateViewState(new ViewState.Valid(arrayList3, _Collections.plus((Collection) arrayList4, (Iterable) listEmptyList), valid.getCanEditModerators()));
    }
}
