package com.discord.widgets.channels.permissions;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelSettingsPermissionsOverviewBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverviewViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b$\u0010\u0017J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010#\u001a\u00020\u001e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverview;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverview$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverview$Model;)V", "Lcom/discord/api/channel/Channel;", "channel", "configureToolbar", "(Lcom/discord/api/channel/Channel;)V", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$ViewState;", "viewState", "configureTabs", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$ViewState;)V", "", "getChannelIdFromIntent", "()J", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel;", "viewModel", "Lcom/discord/databinding/WidgetChannelSettingsPermissionsOverviewBinding;", "viewBinding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getViewBinding", "()Lcom/discord/databinding/WidgetChannelSettingsPermissionsOverviewBinding;", "viewBinding", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelSettingsPermissionsOverview.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetChannelSettingsPermissionsOverviewBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TAB_INDEX_ADVANCED = 1;
    private static final int TAB_INDEX_MODERATOR = 0;
    private static final int VIEW_INDEX_ADVANCED = 1;
    private static final int VIEW_INDEX_STAGE_MODERATOR = 0;

    /* renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverview$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "launch", "(Landroid/content/Context;J)V", "", "TAB_INDEX_ADVANCED", "I", "TAB_INDEX_MODERATOR", "VIEW_INDEX_ADVANCED", "VIEW_INDEX_STAGE_MODERATOR", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long channelId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            AppScreen2.d(context, WidgetChannelSettingsPermissionsOverview.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0082\b\u0018\u0000 32\u00020\u0001:\u00013B;\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JN\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010\rR%\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\u0011R\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\nR\u0019\u0010)\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b.\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010/\u001a\u0004\b0\u0010\u0004¨\u00064"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverview$Model;", "", "Lcom/discord/models/user/MeUser;", "component1", "()Lcom/discord/models/user/MeUser;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/channel/Channel;", "component3", "()Lcom/discord/api/channel/Channel;", "", "component4", "()J", "", "Lcom/discord/api/role/GuildRole;", "component5", "()Ljava/util/Map;", "me", "guild", "channel", "myPermissions", "guildRoles", "copy", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;JLjava/util/Map;)Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverview$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getMyPermissions", "Ljava/util/Map;", "getGuildRoles", "Lcom/discord/api/channel/Channel;", "getChannel", "canManage", "Z", "getCanManage", "()Z", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/models/user/MeUser;", "getMe", "<init>", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;JLjava/util/Map;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManage;
        private final Channel channel;
        private final Guild guild;
        private final Map<Long, GuildRole> guildRoles;
        private final MeUser me;
        private final long myPermissions;

        /* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\u0010\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverview$Model$Companion;", "", "", "channelId", "Lrx/Observable;", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverview$Model;", "get", "(J)Lrx/Observable;", "Lcom/discord/models/user/MeUser;", "me", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/channel/Channel;", "channel", "myPermissionsForChannel", "", "isValid", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/lang/Long;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                Observable observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new WidgetChannelSettingsPermissionsOverview2(channelId));
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream.getChannels(…          }\n            }");
                return observableY;
            }

            public final boolean isValid(MeUser me2, Guild guild, Channel channel, Long myPermissionsForChannel) {
                return (me2 == null || guild == null || channel == null || myPermissionsForChannel == null) ? false : true;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, Guild guild, Channel channel, long j, Map<Long, GuildRole> map) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(map, "guildRoles");
            this.me = meUser;
            this.guild = guild;
            this.channel = channel;
            this.myPermissions = j;
            this.guildRoles = map;
            this.canManage = guild.getOwnerId() == meUser.getId() || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, Long.valueOf(j), meUser.getMfaEnabled(), guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, Long.valueOf(j), meUser.getMfaEnabled(), guild.getMfaLevel());
        }

        public static /* synthetic */ Model copy$default(Model model, MeUser meUser, Guild guild, Channel channel, long j, Map map, int i, Object obj) {
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
            return model.copy(meUser, guild2, channel2, j2, map);
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

        public final Model copy(MeUser me2, Guild guild, Channel channel, long myPermissions, Map<Long, GuildRole> guildRoles) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
            return new Model(me2, guild, channel, myPermissions, guildRoles);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.me, model.me) && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.channel, model.channel) && this.myPermissions == model.myPermissions && Intrinsics3.areEqual(this.guildRoles, model.guildRoles);
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

        public final long getMyPermissions() {
            return this.myPermissions;
        }

        public int hashCode() {
            MeUser meUser = this.me;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iA = (b.a(this.myPermissions) + ((iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
            Map<Long, GuildRole> map = this.guildRoles;
            return iA + (map != null ? map.hashCode() : 0);
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
            return outline.M(sbU, this.guildRoles, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            WidgetChannelSettingsPermissionsOverviewViewModel.Tab.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            WidgetChannelSettingsPermissionsOverviewViewModel.Tab tab = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.MODERATOR;
            iArr[tab.ordinal()] = 1;
            WidgetChannelSettingsPermissionsOverviewViewModel.Tab tab2 = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.ADVANCED;
            iArr[tab2.ordinal()] = 2;
            WidgetChannelSettingsPermissionsOverviewViewModel.Tab.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[tab.ordinal()] = 1;
            iArr2[tab2.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "index", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$configureTabs$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetChannelSettingsPermissionsOverviewViewModel.Tab tab;
            if (i == 0) {
                tab = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.MODERATOR;
            } else {
                if (i != 1) {
                    throw new IllegalArgumentException(outline.q("illegal index: ", i));
                }
                tab = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.ADVANCED;
            }
            WidgetChannelSettingsPermissionsOverview.access$getViewModel$p(WidgetChannelSettingsPermissionsOverview.this).selectTab(tab);
        }
    }

    /* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverview$Model;", "model", "", "invoke", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverview$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$onViewBoundOrOnResume$1, reason: invalid class name */
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
            WidgetChannelSettingsPermissionsOverview.access$configureUI(WidgetChannelSettingsPermissionsOverview.this, model);
        }
    }

    /* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetChannelSettingsPermissionsOverviewViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsPermissionsOverviewViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelSettingsPermissionsOverviewViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetChannelSettingsPermissionsOverview.access$configureTabs(WidgetChannelSettingsPermissionsOverview.this, viewState);
        }
    }

    public WidgetChannelSettingsPermissionsOverview() {
        super(R.layout.widget_channel_settings_permissions_overview);
        this.viewBinding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelSettingsPermissionsOverview3.INSTANCE, null, 2, null);
        WidgetChannelSettingsPermissionsOverview4 widgetChannelSettingsPermissionsOverview4 = new WidgetChannelSettingsPermissionsOverview4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChannelSettingsPermissionsOverviewViewModel.class), new WidgetChannelSettingsPermissionsOverview$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetChannelSettingsPermissionsOverview4));
    }

    public static final /* synthetic */ void access$configureTabs(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview, WidgetChannelSettingsPermissionsOverviewViewModel.ViewState viewState) {
        widgetChannelSettingsPermissionsOverview.configureTabs(viewState);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview, Model model) {
        widgetChannelSettingsPermissionsOverview.configureUI(model);
    }

    public static final /* synthetic */ long access$getChannelIdFromIntent(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview) {
        return widgetChannelSettingsPermissionsOverview.getChannelIdFromIntent();
    }

    public static final /* synthetic */ WidgetChannelSettingsPermissionsOverviewViewModel access$getViewModel$p(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview) {
        return widgetChannelSettingsPermissionsOverview.getViewModel();
    }

    private final void configureTabs(WidgetChannelSettingsPermissionsOverviewViewModel.ViewState viewState) {
        int i;
        int iOrdinal = viewState.getSelectedTab().ordinal();
        if (iOrdinal == 0) {
            AppViewFlipper appViewFlipper = getViewBinding().f2279b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "viewBinding.flipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (iOrdinal == 1) {
            AppViewFlipper appViewFlipper2 = getViewBinding().f2279b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "viewBinding.flipper");
            appViewFlipper2.setDisplayedChild(1);
        }
        SegmentedControlContainer segmentedControlContainer = getViewBinding().c;
        int iOrdinal2 = viewState.getSelectedTab().ordinal();
        if (iOrdinal2 == 0) {
            i = 0;
        } else {
            if (iOrdinal2 != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i = 1;
        }
        segmentedControlContainer.a(i);
        getViewBinding().c.setOnSegmentSelectedChangeListener(new AnonymousClass1());
        SegmentedControlContainer segmentedControlContainer2 = getViewBinding().c;
        Intrinsics3.checkNotNullExpressionValue(segmentedControlContainer2, "viewBinding.segmentedControl");
        segmentedControlContainer2.setVisibility(viewState.getAvailableTabs().size() > 1 ? 0 : 8);
    }

    private final void configureToolbar(Channel channel) {
        setActionBarTitle(ChannelUtils.k(channel) ? R.string.category_settings : R.string.channel_settings);
        setActionBarSubtitle(ChannelUtils.d(channel, requireContext(), true));
    }

    private final void configureUI(Model model) {
        if (model == null || !model.getCanManage()) {
            requireActivity().finish();
        } else {
            configureToolbar(model.getChannel());
        }
    }

    private final long getChannelIdFromIntent() {
        return getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
    }

    private final WidgetChannelSettingsPermissionsOverviewBinding getViewBinding() {
        return (WidgetChannelSettingsPermissionsOverviewBinding) this.viewBinding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetChannelSettingsPermissionsOverviewViewModel getViewModel() {
        return (WidgetChannelSettingsPermissionsOverviewViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observableR = Model.INSTANCE.get(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Model\n        .get(chann…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetChannelSettingsPermissionsOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelSettingsPermissionsOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
