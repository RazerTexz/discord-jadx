package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.permissions.PermissionsContexts;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.servers.WidgetServerDeleteDialog;
import com.discord.widgets.servers.WidgetServerSettingsOverview;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptionTierList;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions;
import com.discord.widgets.servers.guild_role_subscription.payments.WidgetServerSettingsGuildRoleSubscriptionEarnings;
import com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action2;

/* compiled from: WidgetServerSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\tJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\tR\u001d\u0010\u0014\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u00020\u00188\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettings;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/WidgetServerSettings$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/servers/WidgetServerSettings$Model;)V", "configureToolbar", "configureSectionsVisibility", "()V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/databinding/WidgetServerSettingsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsBinding;", "binding", "", "guildId", "J", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long guildId;
    private final AppLogger2 loggingConfig;

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettings$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "create", "(Landroid/content/Context;J)V", "", "INTENT_EXTRA_GUILD_ID", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetServerSettings.class, new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0082\b\u0018\u0000 $2\u00020\u0001:\u0001$B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b!\u0010\n¨\u0006%"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettings$Model;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/utilities/permissions/ManageGuildContext;", "component2", "()Lcom/discord/utilities/permissions/ManageGuildContext;", "", "component3", "()Z", "component4", "guild", "manageGuildContext", "canManageGuildRoleSubscriptions", "hasGuildRoleSubscriptions", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/utilities/permissions/ManageGuildContext;ZZ)Lcom/discord/widgets/servers/WidgetServerSettings$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "Z", "getCanManageGuildRoleSubscriptions", "Lcom/discord/utilities/permissions/ManageGuildContext;", "getManageGuildContext", "getHasGuildRoleSubscriptions", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/utilities/permissions/ManageGuildContext;ZZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManageGuildRoleSubscriptions;
        private final Guild guild;
        private final boolean hasGuildRoleSubscriptions;
        private final PermissionsContexts manageGuildContext;

        /* compiled from: WidgetServerSettings.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettings$Model$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettings$Model;", "get", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableF = Observable.f(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), companion.getPermissions().observePermissionsForGuild(guildId), companion.getChannels().observeChannelCategories(guildId), companion.getPermissions().observeChannelPermissionsForGuild(guildId), GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildSeeGuildRoleSubscriptionsSettings(guildId), WidgetServerSettings2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableF, "Observable\n          .co…            )\n          }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableF).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, PermissionsContexts permissionsContexts, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(permissionsContexts, "manageGuildContext");
            this.guild = guild;
            this.manageGuildContext = permissionsContexts;
            this.canManageGuildRoleSubscriptions = z2;
            this.hasGuildRoleSubscriptions = z3;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, PermissionsContexts permissionsContexts, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                permissionsContexts = model.manageGuildContext;
            }
            if ((i & 4) != 0) {
                z2 = model.canManageGuildRoleSubscriptions;
            }
            if ((i & 8) != 0) {
                z3 = model.hasGuildRoleSubscriptions;
            }
            return model.copy(guild, permissionsContexts, z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final PermissionsContexts getManageGuildContext() {
            return this.manageGuildContext;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCanManageGuildRoleSubscriptions() {
            return this.canManageGuildRoleSubscriptions;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getHasGuildRoleSubscriptions() {
            return this.hasGuildRoleSubscriptions;
        }

        public final Model copy(Guild guild, PermissionsContexts manageGuildContext, boolean canManageGuildRoleSubscriptions, boolean hasGuildRoleSubscriptions) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(manageGuildContext, "manageGuildContext");
            return new Model(guild, manageGuildContext, canManageGuildRoleSubscriptions, hasGuildRoleSubscriptions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.manageGuildContext, model.manageGuildContext) && this.canManageGuildRoleSubscriptions == model.canManageGuildRoleSubscriptions && this.hasGuildRoleSubscriptions == model.hasGuildRoleSubscriptions;
        }

        public final boolean getCanManageGuildRoleSubscriptions() {
            return this.canManageGuildRoleSubscriptions;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final boolean getHasGuildRoleSubscriptions() {
            return this.hasGuildRoleSubscriptions;
        }

        public final PermissionsContexts getManageGuildContext() {
            return this.manageGuildContext;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            PermissionsContexts permissionsContexts = this.manageGuildContext;
            int iHashCode2 = (iHashCode + (permissionsContexts != null ? permissionsContexts.hashCode() : 0)) * 31;
            boolean z2 = this.canManageGuildRoleSubscriptions;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.hasGuildRoleSubscriptions;
            return i2 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", manageGuildContext=");
            sbU.append(this.manageGuildContext);
            sbU.append(", canManageGuildRoleSubscriptions=");
            sbU.append(this.canManageGuildRoleSubscriptions);
            sbU.append(", hasGuildRoleSubscriptions=");
            return outline.O(sbU, this.hasGuildRoleSubscriptions, ")");
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureToolbar$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ Guild $guild;

        public AnonymousClass1(Guild guild) {
            this.$guild = guild;
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_server_settings_delete) {
                return;
            }
            WidgetServerDeleteDialog.Companion companion = WidgetServerDeleteDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetServerSettings.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, this.$guild.getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass1(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsOverview.Companion.create$default(WidgetServerSettingsOverview.INSTANCE, outline.x(view, "v", "v.context"), this.$model.getGuild().getId(), false, 4, null);
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$10, reason: invalid class name */
    public static final class AnonymousClass10 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass10(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsMembers.INSTANCE.create(outline.x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$11, reason: invalid class name */
    public static final class AnonymousClass11 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass11(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsRoles.INSTANCE.create(outline.x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$12, reason: invalid class name */
    public static final class AnonymousClass12 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass12(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsInstantInvites.INSTANCE.create(outline.x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$13, reason: invalid class name */
    public static final class AnonymousClass13 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass13(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsBans.INSTANCE.create(outline.x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$14, reason: invalid class name */
    public static final class AnonymousClass14 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass14(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEmojis.INSTANCE.create(outline.x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$15, reason: invalid class name */
    public static final class AnonymousClass15 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass15(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$model.getGuild().hasFeature(GuildFeature.CREATOR_MONETIZABLE)) {
                WidgetServerSettingsEmptyGuildRoleSubscriptions.INSTANCE.launch(WidgetServerSettings.this.requireContext(), this.$model.getGuild().getId());
            } else {
                WidgetServerSettingsCreatorMonetizationOnboarding.INSTANCE.launch(WidgetServerSettings.this.requireContext(), this.$model.getGuild().getId());
            }
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$16, reason: invalid class name */
    public static final class AnonymousClass16 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass16(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsGuildRoleSubscriptions.INSTANCE.launch(WidgetServerSettings.this.requireContext(), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$17, reason: invalid class name */
    public static final class AnonymousClass17 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass17(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsGuildRoleSubscriptionTierList.INSTANCE.launch(WidgetServerSettings.this.requireContext(), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$18, reason: invalid class name */
    public static final class AnonymousClass18 implements View.OnClickListener {
        public AnonymousClass18() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsGuildRoleSubscriptionEarnings.INSTANCE.launch(WidgetServerSettings.this.requireContext());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsModeration.INSTANCE.launch(outline.x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass3(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsAuditLog.INSTANCE.create(outline.x(view, "v", "v.context"), this.$model.getGuild().getId(), this.$model.getGuild().getName());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass4(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsChannels.INSTANCE.show(outline.x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass5(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsSecurity.INSTANCE.create(outline.x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass6(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsIntegrations.INSTANCE.create(outline.x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass7(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsVanityUrl.INSTANCE.create(outline.x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass8(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsCommunityOverview.INSTANCE.create(outline.x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$9, reason: invalid class name */
    public static final class AnonymousClass9 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass9(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEnableCommunitySteps.INSTANCE.create(outline.x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettings$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/WidgetServerSettings$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettings widgetServerSettings) {
            super(1, widgetServerSettings, WidgetServerSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettings$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettings.access$configureUI((WidgetServerSettings) this.receiver, model);
        }
    }

    public WidgetServerSettings() {
        super(R.layout.widget_server_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettings3.INSTANCE, null, 2, null);
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettings4.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettings widgetServerSettings, Model model) {
        widgetServerSettings.configureUI(model);
    }

    private final void configureSectionsVisibility() {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        List<TextView> listListOf = Collections2.listOf((Object[]) new TextView[]{getBinding().p, getBinding().m, getBinding().n, getBinding().q, getBinding().r, getBinding().l, getBinding().d});
        List<TextView> listListOf2 = Collections2.listOf((Object[]) new TextView[]{getBinding().k, getBinding().f2546s, getBinding().j, getBinding().f2545b});
        List<TextView> listListOf3 = Collections2.listOf((Object[]) new TextView[]{getBinding().h, getBinding().f, getBinding().i, getBinding().g});
        LinearLayout linearLayout = getBinding().u;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsSectionGeneralSettings");
        boolean z6 = listListOf instanceof Collection;
        if (z6 && listListOf.isEmpty()) {
            z2 = false;
        } else {
            for (TextView textView : listListOf) {
                Intrinsics3.checkNotNullExpressionValue(textView, "view");
                if (textView.getVisibility() == 0) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        linearLayout.setVisibility(z2 ? 0 : 8);
        View view = getBinding().f2547x;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.serverSettingsSectionUserManagementDivider");
        if (z6 && listListOf.isEmpty()) {
            z3 = false;
        } else {
            for (TextView textView2 : listListOf) {
                Intrinsics3.checkNotNullExpressionValue(textView2, "view");
                if (textView2.getVisibility() == 0) {
                    z3 = true;
                    break;
                }
            }
            z3 = false;
        }
        view.setVisibility(z3 ? 0 : 8);
        LinearLayout linearLayout2 = getBinding().w;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.serverSettingsSectionUserManagement");
        if ((listListOf2 instanceof Collection) && listListOf2.isEmpty()) {
            z4 = false;
        } else {
            for (TextView textView3 : listListOf2) {
                Intrinsics3.checkNotNullExpressionValue(textView3, "view");
                if (textView3.getVisibility() == 0) {
                    z4 = true;
                    break;
                }
            }
            z4 = false;
        }
        linearLayout2.setVisibility(z4 ? 0 : 8);
        LinearLayout linearLayout3 = getBinding().v;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.serverSettingsSectionServerMonetization");
        if ((listListOf3 instanceof Collection) && listListOf3.isEmpty()) {
            z5 = false;
        } else {
            for (TextView textView4 : listListOf3) {
                Intrinsics3.checkNotNullExpressionValue(textView4, "view");
                if (textView4.getVisibility() == 0) {
                    break;
                }
            }
            z5 = false;
        }
        linearLayout3.setVisibility(z5 ? 0 : 8);
    }

    private final void configureToolbar(Model model) {
        Guild guild = model.getGuild();
        String forGuild$default = IconUtils.getForGuild$default(guild, null, true, null, 10, null);
        TextView textView = getBinding().A;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsServerName");
        textView.setText(guild.getName());
        SimpleDraweeView simpleDraweeView = getBinding().f2548y;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.serverSettingsServerIcon");
        IconUtils.setIcon$default(simpleDraweeView, forGuild$default, R.dimen.avatar_size_large, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        TextView textView2 = getBinding().f2549z;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsServerIconText");
        textView2.setVisibility(forGuild$default == null ? 0 : 8);
        TextView textView3 = getBinding().f2549z;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.serverSettingsServerIconText");
        textView3.setText(guild.getShortName());
        AppFragment.setActionBarOptionsMenu$default(this, model.getManageGuildContext().isOwnerWithRequiredMFALevel() ? R.menu.menu_server_settings : R.menu.menu_empty, new AnonymousClass1(guild), null, 4, null);
    }

    private final void configureUI(Model model) {
        if (model == null || !model.getManageGuildContext().canManage()) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        configureToolbar(model);
        PermissionsContexts manageGuildContext = model.getManageGuildContext();
        TextView textView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsOptionOverview");
        textView.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().p.setOnClickListener(new AnonymousClass1(model));
        TextView textView2 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsOptionModeration");
        textView2.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().o.setOnClickListener(new AnonymousClass2(model));
        TextView textView3 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.serverSettingsOptionAuditLog");
        textView3.setVisibility(manageGuildContext.getCanViewAuditLogs() ? 0 : 8);
        getBinding().l.setOnClickListener(new AnonymousClass3(model));
        TextView textView4 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.serverSettingsOptionChannels");
        textView4.setVisibility(manageGuildContext.getCanManageChannels() ? 0 : 8);
        getBinding().m.setOnClickListener(new AnonymousClass4(model));
        TextView textView5 = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.serverSettingsOptionSecurity");
        textView5.setVisibility(manageGuildContext.isOwnerWithRequiredMFALevel() ? 0 : 8);
        getBinding().q.setOnClickListener(new AnonymousClass5(model));
        TextView textView6 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.serverSettingsOptionIntegrations");
        textView6.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().n.setOnClickListener(new AnonymousClass6(model));
        TextView textView7 = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.serverSettingsOptionVanityUrl");
        textView7.setVisibility(manageGuildContext.getCanManageServer() && model.getGuild().getFeatures().contains(GuildFeature.VANITY_URL) ? 0 : 8);
        getBinding().r.setOnClickListener(new AnonymousClass7(model));
        LinearLayout linearLayout = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsSectionCommunity");
        linearLayout.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        TextView textView8 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.serverSettingsCommunityOverviewOption");
        Set<GuildFeature> features = model.getGuild().getFeatures();
        GuildFeature guildFeature = GuildFeature.COMMUNITY;
        textView8.setVisibility(features.contains(guildFeature) ? 0 : 8);
        getBinding().c.setOnClickListener(new AnonymousClass8(model));
        TextView textView9 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView9, "binding.serverSettingsEnableCommunityOption");
        textView9.setVisibility(model.getGuild().getFeatures().contains(guildFeature) ^ true ? 0 : 8);
        getBinding().e.setOnClickListener(new AnonymousClass9(model));
        getBinding().k.setOnClickListener(new AnonymousClass10(model));
        TextView textView10 = getBinding().f2546s;
        Intrinsics3.checkNotNullExpressionValue(textView10, "binding.serverSettingsRolesOption");
        textView10.setVisibility(manageGuildContext.getCanManageRoles() ? 0 : 8);
        getBinding().f2546s.setOnClickListener(new AnonymousClass11(model));
        TextView textView11 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView11, "binding.serverSettingsInstantInvitesOption");
        textView11.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().j.setOnClickListener(new AnonymousClass12(model));
        TextView textView12 = getBinding().f2545b;
        Intrinsics3.checkNotNullExpressionValue(textView12, "binding.serverSettingsBansOption");
        textView12.setVisibility(manageGuildContext.getCanManageBans() ? 0 : 8);
        getBinding().f2545b.setOnClickListener(new AnonymousClass13(model));
        TextView textView13 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView13, "binding.serverSettingsEmojisOption");
        textView13.setVisibility(manageGuildContext.getCanManageEmojisAndStickers() ? 0 : 8);
        getBinding().d.setOnClickListener(new AnonymousClass14(model));
        TextView textView14 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView14, "binding.serverSettingsGu…oleSubscriptionGetStarted");
        textView14.setVisibility(model.getCanManageGuildRoleSubscriptions() && !model.getHasGuildRoleSubscriptions() ? 0 : 8);
        getBinding().h.setOnClickListener(new AnonymousClass15(model));
        boolean z2 = model.getCanManageGuildRoleSubscriptions() && model.getHasGuildRoleSubscriptions();
        TextView textView15 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView15, "binding.serverSettingsGu…RoleSubscriptionBasicInfo");
        textView15.setVisibility(z2 ? 0 : 8);
        getBinding().f.setOnClickListener(new AnonymousClass16(model));
        TextView textView16 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView16, "binding.serverSettingsGuildRoleSubscriptionTiers");
        textView16.setVisibility(z2 ? 0 : 8);
        getBinding().i.setOnClickListener(new AnonymousClass17(model));
        TextView textView17 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView17, "binding.serverSettingsGu…dRoleSubscriptionEarnings");
        textView17.setVisibility(z2 ? 0 : 8);
        getBinding().g.setOnClickListener(new AnonymousClass18());
        configureSectionsVisibility();
    }

    private final WidgetServerSettingsBinding getBinding() {
        return (WidgetServerSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.server_settings);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        this.guildId = longExtra;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra), this, null, 2, null), WidgetServerSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
