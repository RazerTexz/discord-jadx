package com.discord.widgets.channels.permissions;

import a0.a.a.b;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSettingsPermissionsAdvancedBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.SimpleMembersAdapter;
import com.discord.widgets.channels.SimpleRolesAdapter;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001b\u0010\u000eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsAdvanced;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsAdvanced$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsAdvanced$Model;)V", "configureRoles", "configureMembers", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/widgets/channels/SimpleRolesAdapter;", "rolesAdapter", "Lcom/discord/widgets/channels/SimpleRolesAdapter;", "Lcom/discord/databinding/WidgetChannelSettingsPermissionsAdvancedBinding;", "viewBinding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getViewBinding", "()Lcom/discord/databinding/WidgetChannelSettingsPermissionsAdvancedBinding;", "viewBinding", "Lcom/discord/widgets/channels/SimpleMembersAdapter;", "membersAdapter", "Lcom/discord/widgets/channels/SimpleMembersAdapter;", "<init>", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelSettingsPermissionsAdvanced.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetChannelSettingsPermissionsAdvancedBinding;", 0)};
    private SimpleMembersAdapter membersAdapter;
    private SimpleRolesAdapter rolesAdapter;

    /* renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0082\b\u0018\u0000 @2\u00020\u0001:\u0001@BI\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\f\u0012\u0006\u0010\u001b\u001a\u00020\u000f\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u0002¢\u0006\u0004\b>\u0010?J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0005J^\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u00122\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)R\u0019\u0010\u0018\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b+\u0010\bR\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b-\u0010\u0005R\u0019\u0010\u001b\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b/\u0010\u0011R%\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00100\u001a\u0004\b1\u0010\u0015R\u0019\u00102\u001a\u00020'8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0019\u0010\u001a\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00106\u001a\u0004\b7\u0010\u000eR\u001f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010,\u001a\u0004\b9\u0010\u0005R\u0019\u0010:\u001a\u00020'8\u0006@\u0006¢\u0006\f\n\u0004\b:\u00103\u001a\u0004\b;\u00105R\u0019\u0010\u0019\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010<\u001a\u0004\b=\u0010\u000b¨\u0006A"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsAdvanced$Model;", "", "", "Lcom/discord/widgets/channels/SimpleRolesAdapter$RoleItem;", "buildRoleItems", "()Ljava/util/List;", "Lcom/discord/models/user/MeUser;", "component1", "()Lcom/discord/models/user/MeUser;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/channel/Channel;", "component3", "()Lcom/discord/api/channel/Channel;", "", "component4", "()J", "", "Lcom/discord/api/role/GuildRole;", "component5", "()Ljava/util/Map;", "Lcom/discord/widgets/channels/SimpleMembersAdapter$MemberItem;", "component6", "me", "guild", "channel", "myPermissions", "guildRoles", "memberItems", "copy", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;JLjava/util/Map;Ljava/util/List;)Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsAdvanced$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/user/MeUser;", "getMe", "Ljava/util/List;", "getMemberItems", "J", "getMyPermissions", "Ljava/util/Map;", "getGuildRoles", "canAddRole", "Z", "getCanAddRole", "()Z", "Lcom/discord/api/channel/Channel;", "getChannel", "roleItems", "getRoleItems", "canManage", "getCanManage", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;JLjava/util/Map;Ljava/util/List;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canAddRole;
        private final boolean canManage;
        private final Channel channel;
        private final Guild guild;
        private final Map<Long, GuildRole> guildRoles;
        private final MeUser me;
        private final List<SimpleMembersAdapter.MemberItem> memberItems;
        private final long myPermissions;
        private final List<SimpleRolesAdapter.RoleItem> roleItems;

        /* compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ$\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\n\u0010\u000b\u001a\u00060\u0007j\u0002`\nH\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0016\u001a\u00020\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsAdvanced$Model$Companion;", "", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/api/permission/PermissionOverwrite$Type;", "type", "", "", "getOverwriteIds", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/permission/PermissionOverwrite$Type;)Ljava/util/Collection;", "Lcom/discord/primitives/ChannelId;", "channelId", "Lrx/Observable;", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsAdvanced$Model;", "get", "(J)Lrx/Observable;", "Lcom/discord/models/user/MeUser;", "me", "Lcom/discord/models/guild/Guild;", "guild", "myPermissionsForChannel", "", "isValid", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/lang/Long;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ Collection access$getOverwriteIds(Companion companion, Channel channel, PermissionOverwrite.Type type) {
                return companion.getOverwriteIds(channel, type);
            }

            private final Collection<Long> getOverwriteIds(Channel channel, PermissionOverwrite.Type type) {
                List<PermissionOverwrite> listV = channel.v();
                if (listV == null) {
                    return Collections2.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : listV) {
                    if (((PermissionOverwrite) obj).getType() == type) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Long.valueOf(((PermissionOverwrite) it.next()).e()));
                }
                return arrayList2;
            }

            public final Observable<Model> get(long channelId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                StoreChannels channels = companion.getChannels();
                StoreUser users = companion.getUsers();
                StorePermissions permissions = companion.getPermissions();
                StoreGuilds guilds = companion.getGuilds();
                return ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{channels, users, permissions, guilds}, false, null, null, new WidgetChannelSettingsPermissionsAdvanced2(channels, channelId, guilds, users, permissions), 14, null);
            }

            public final boolean isValid(MeUser me2, Guild guild, Channel channel, Long myPermissionsForChannel) {
                return (me2 == null || guild == null || channel == null || myPermissionsForChannel == null) ? false : true;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, Guild guild, Channel channel, long j, Map<Long, GuildRole> map, List<SimpleMembersAdapter.MemberItem> list) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(map, "guildRoles");
            Intrinsics3.checkNotNullParameter(list, "memberItems");
            this.me = meUser;
            this.guild = guild;
            this.channel = channel;
            this.myPermissions = j;
            this.guildRoles = map;
            this.memberItems = list;
            this.canManage = guild.getOwnerId() == meUser.getId() || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, Long.valueOf(j), meUser.getMfaEnabled(), guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, Long.valueOf(j), meUser.getMfaEnabled(), guild.getMfaLevel());
            List<SimpleRolesAdapter.RoleItem> listBuildRoleItems = buildRoleItems();
            this.roleItems = listBuildRoleItems;
            this.canAddRole = map.size() > listBuildRoleItems.size();
        }

        private final List<SimpleRolesAdapter.RoleItem> buildRoleItems() {
            ArrayList arrayList = new ArrayList();
            Iterator it = Companion.access$getOverwriteIds(INSTANCE, this.channel, PermissionOverwrite.Type.ROLE).iterator();
            while (it.hasNext()) {
                GuildRole guildRole = this.guildRoles.get(Long.valueOf(((Number) it.next()).longValue()));
                if (guildRole != null) {
                    arrayList.add(new SimpleRolesAdapter.RoleItem(guildRole));
                }
            }
            return _Collections.sorted(arrayList);
        }

        public static /* synthetic */ Model copy$default(Model model, MeUser meUser, Guild guild, Channel channel, long j, Map map, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = model.me;
            }
            if ((i & 2) != 0) {
                guild = model.guild;
            }
            Guild guild2 = guild;
            if ((i & 4) != 0) {
                channel = model.channel;
            }
            Channel channel2 = channel;
            if ((i & 8) != 0) {
                j = model.myPermissions;
            }
            long j2 = j;
            if ((i & 16) != 0) {
                map = model.guildRoles;
            }
            Map map2 = map;
            if ((i & 32) != 0) {
                list = model.memberItems;
            }
            return model.copy(meUser, guild2, channel2, j2, map2, list);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component4, reason: from getter */
        public final long getMyPermissions() {
            return this.myPermissions;
        }

        public final Map<Long, GuildRole> component5() {
            return this.guildRoles;
        }

        public final List<SimpleMembersAdapter.MemberItem> component6() {
            return this.memberItems;
        }

        public final Model copy(MeUser me2, Guild guild, Channel channel, long myPermissions, Map<Long, GuildRole> guildRoles, List<SimpleMembersAdapter.MemberItem> memberItems) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
            Intrinsics3.checkNotNullParameter(memberItems, "memberItems");
            return new Model(me2, guild, channel, myPermissions, guildRoles, memberItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.me, model.me) && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.channel, model.channel) && this.myPermissions == model.myPermissions && Intrinsics3.areEqual(this.guildRoles, model.guildRoles) && Intrinsics3.areEqual(this.memberItems, model.memberItems);
        }

        public final boolean getCanAddRole() {
            return this.canAddRole;
        }

        public final boolean getCanManage() {
            return this.canManage;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, GuildRole> getGuildRoles() {
            return this.guildRoles;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final List<SimpleMembersAdapter.MemberItem> getMemberItems() {
            return this.memberItems;
        }

        public final long getMyPermissions() {
            return this.myPermissions;
        }

        public final List<SimpleRolesAdapter.RoleItem> getRoleItems() {
            return this.roleItems;
        }

        public int hashCode() {
            MeUser meUser = this.me;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iA = (b.a(this.myPermissions) + ((iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
            Map<Long, GuildRole> map = this.guildRoles;
            int iHashCode3 = (iA + (map != null ? map.hashCode() : 0)) * 31;
            List<SimpleMembersAdapter.MemberItem> list = this.memberItems;
            return iHashCode3 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(me=");
            sbU.append(this.me);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", myPermissions=");
            sbU.append(this.myPermissions);
            sbU.append(", guildRoles=");
            sbU.append(this.guildRoles);
            sbU.append(", memberItems=");
            return outline.L(sbU, this.memberItems, ")");
        }
    }

    /* compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/User;", "user", "", "invoke", "(Lcom/discord/models/user/User;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$configureMembers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<User, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            WidgetChannelSettingsEditPermissions.INSTANCE.createForUser(WidgetChannelSettingsPermissionsAdvanced.this.requireContext(), this.$model.getGuild().getId(), this.$model.getChannel().getId(), user.getId());
        }
    }

    /* compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/role/GuildRole;", "role", "", "invoke", "(Lcom/discord/api/role/GuildRole;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$configureRoles$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRole, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRole guildRole) {
            invoke2(guildRole);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRole guildRole) {
            WidgetChannelSettingsEditPermissions.Companion companion = WidgetChannelSettingsEditPermissions.INSTANCE;
            Context contextRequireContext = WidgetChannelSettingsPermissionsAdvanced.this.requireContext();
            long id2 = this.$model.getGuild().getId();
            long id3 = this.$model.getChannel().getId();
            Intrinsics3.checkNotNull(guildRole);
            companion.createForRole(contextRequireContext, id2, id3, guildRole.getId());
        }
    }

    /* compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass1(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$model.getCanAddRole()) {
                WidgetChannelSettingsPermissionsAddRole.create(WidgetChannelSettingsPermissionsAdvanced.this.getContext(), this.$model.getChannel().getId());
            } else {
                AppToast.i(WidgetChannelSettingsPermissionsAdvanced.this, R.string.overwrite_no_role_to_add, 0, 4);
            }
        }
    }

    /* compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSettingsPermissionsAddMember.create(WidgetChannelSettingsPermissionsAdvanced.this.getContext(), this.$model.getGuild().getId(), this.$model.getChannel().getId());
        }
    }

    /* compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsAdvanced$Model;", "model", "", "invoke", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsAdvanced$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetChannelSettingsPermissionsAdvanced.access$configureUI(WidgetChannelSettingsPermissionsAdvanced.this, model);
        }
    }

    public WidgetChannelSettingsPermissionsAdvanced() {
        super(R.layout.widget_channel_settings_permissions_advanced);
        this.viewBinding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelSettingsPermissionsAdvanced5.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelSettingsPermissionsAdvanced widgetChannelSettingsPermissionsAdvanced, Model model) {
        widgetChannelSettingsPermissionsAdvanced.configureUI(model);
    }

    private final void configureMembers(Model model) {
        if (model.getMemberItems().isEmpty()) {
            LinearLayout linearLayout = getViewBinding().d;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "viewBinding.membersContainer");
            linearLayout.setVisibility(8);
            return;
        }
        SimpleMembersAdapter simpleMembersAdapter = this.membersAdapter;
        if (simpleMembersAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("membersAdapter");
        }
        simpleMembersAdapter.setData(model.getMemberItems(), new AnonymousClass1(model));
        LinearLayout linearLayout2 = getViewBinding().d;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "viewBinding.membersContainer");
        linearLayout2.setVisibility(0);
    }

    private final void configureRoles(Model model) {
        if (model.getRoleItems().isEmpty()) {
            LinearLayout linearLayout = getViewBinding().f;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "viewBinding.rolesContainer");
            linearLayout.setVisibility(8);
            return;
        }
        SimpleRolesAdapter simpleRolesAdapter = this.rolesAdapter;
        if (simpleRolesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("rolesAdapter");
        }
        simpleRolesAdapter.setData(model.getRoleItems(), new AnonymousClass1(model));
        LinearLayout linearLayout2 = getViewBinding().f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "viewBinding.rolesContainer");
        linearLayout2.setVisibility(0);
    }

    private final void configureUI(Model model) {
        if (model == null || !model.getCanManage()) {
            return;
        }
        getViewBinding().c.setOnClickListener(new AnonymousClass1(model));
        getViewBinding().f2278b.setOnClickListener(new AnonymousClass2(model));
        configureRoles(model);
        configureMembers(model);
    }

    private final WidgetChannelSettingsPermissionsAdvancedBinding getViewBinding() {
        return (WidgetChannelSettingsPermissionsAdvancedBinding) this.viewBinding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getViewBinding().g;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "viewBinding.rolesRecycler");
        this.rolesAdapter = (SimpleRolesAdapter) companion.configure(new SimpleRolesAdapter(recyclerView));
        RecyclerView recyclerView2 = getViewBinding().g;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "viewBinding.rolesRecycler");
        recyclerView2.setNestedScrollingEnabled(false);
        getViewBinding().g.setHasFixedSize(false);
        RecyclerView recyclerView3 = getViewBinding().e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "viewBinding.membersRecycler");
        this.membersAdapter = (SimpleMembersAdapter) companion.configure(new SimpleMembersAdapter(recyclerView3));
        RecyclerView recyclerView4 = getViewBinding().e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "viewBinding.membersRecycler");
        recyclerView4.setNestedScrollingEnabled(false);
        getViewBinding().e.setHasFixedSize(false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observableR = Model.INSTANCE.get(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L)).p(1L, TimeUnit.SECONDS).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Model[channelId]\n       …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetChannelSettingsPermissionsAdvanced.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
