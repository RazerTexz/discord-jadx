package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsEditIntegrationBinding;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.servers.WidgetServerSettingsEditRole;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsEditIntegration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 .2\u00020\u0001:\u0002./B\u0007¢\u0006\u0004\b-\u0010\u0017J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0010\u001a\u00020\u000f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0017R#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001d\u0010&\u001a\u00020!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R#\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u001cR\u0016\u0010*\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010+¨\u00060"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration$Model;)V", "", "gracePeriodDays", "getGracePeriodPosition", "(I)I", "", "Lcom/discord/views/CheckedSetting;", "checkedSettings", "stateKey", "Lcom/discord/views/RadioManager;", "setupRadioManager", "(Ljava/util/List;I)Lcom/discord/views/RadioManager;", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "onPause", "expiryBehaviorRadios$delegate", "Lkotlin/Lazy;", "getExpiryBehaviorRadios", "()Ljava/util/List;", "expiryBehaviorRadios", "Lcom/discord/utilities/stateful/StatefulViews;", "state", "Lcom/discord/utilities/stateful/StatefulViews;", "Lcom/discord/databinding/WidgetServerSettingsEditIntegrationBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsEditIntegrationBinding;", "binding", "gracePeriodRadios$delegate", "getGracePeriodRadios", "gracePeriodRadios", "expiryBehaviorRadioManager", "Lcom/discord/views/RadioManager;", "gracePeriodRadioManager", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration extends AppFragment {
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_INTEGRATION_ID = "INTENT_EXTRA_INTEGRATION_ID";
    private static final int STATE_KEY_ENABLE_TWITCH_EMOTES = 2131363149;
    private static final int STATE_KEY_EXPIRE_BEHAVIOR = 2131363152;
    private static final int STATE_KEY_GRACE_PERIOD = 2131363153;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager expiryBehaviorRadioManager;

    /* renamed from: expiryBehaviorRadios$delegate, reason: from kotlin metadata */
    private final Lazy expiryBehaviorRadios;
    private RadioManager gracePeriodRadioManager;

    /* renamed from: gracePeriodRadios$delegate, reason: from kotlin metadata */
    private final Lazy gracePeriodRadios;
    private final StatefulViews state;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsEditIntegration.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEditIntegrationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] gracePeriodDays = {1, 3, 7, 14, 30};

    /* compiled from: WidgetServerSettingsEditIntegration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "integrationId", "Landroid/content/Context;", "context", "", "launch", "(JJLandroid/content/Context;)V", "", "INTENT_EXTRA_GUILD_ID", "Ljava/lang/String;", WidgetServerSettingsEditIntegration.INTENT_EXTRA_INTEGRATION_ID, "", "STATE_KEY_ENABLE_TWITCH_EMOTES", "I", "STATE_KEY_EXPIRE_BEHAVIOR", "STATE_KEY_GRACE_PERIOD", "", "gracePeriodDays", "[I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long guildId, long integrationId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetServerSettingsEditIntegration.INTENT_EXTRA_INTEGRATION_ID, integrationId);
            AppScreen2.d(context, WidgetServerSettingsEditIntegration.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsEditIntegration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\n¨\u0006#"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration$Model;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/models/domain/ModelGuildIntegration;", "component2", "()Lcom/discord/models/domain/ModelGuildIntegration;", "Lcom/discord/api/role/GuildRole;", "component3", "()Lcom/discord/api/role/GuildRole;", "guild", "integration", "role", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/domain/ModelGuildIntegration;Lcom/discord/api/role/GuildRole;)Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelGuildIntegration;", "getIntegration", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/api/role/GuildRole;", "getRole", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/domain/ModelGuildIntegration;Lcom/discord/api/role/GuildRole;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Guild guild;
        private final ModelGuildIntegration integration;
        private final GuildRole role;

        /* compiled from: WidgetServerSettingsEditIntegration.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration$Model$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "integrationId", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration$Model;", "get", "(JJ)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId, long integrationId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableG = Observable.g(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), companion.getGuilds().observeRoles(guildId), companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuildIntegrations().get(guildId, integrationId), WidgetServerSettingsEditIntegration3.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableG, "Observable.combineLatest…  }\n          }\n        }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, ModelGuildIntegration modelGuildIntegration, GuildRole guildRole) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(modelGuildIntegration, "integration");
            this.guild = guild;
            this.integration = modelGuildIntegration;
            this.role = guildRole;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, ModelGuildIntegration modelGuildIntegration, GuildRole guildRole, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                modelGuildIntegration = model.integration;
            }
            if ((i & 4) != 0) {
                guildRole = model.role;
            }
            return model.copy(guild, modelGuildIntegration, guildRole);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final ModelGuildIntegration getIntegration() {
            return this.integration;
        }

        /* renamed from: component3, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        public final Model copy(Guild guild, ModelGuildIntegration integration, GuildRole role) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(integration, "integration");
            return new Model(guild, integration, role);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.integration, model.integration) && Intrinsics3.areEqual(this.role, model.role);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final ModelGuildIntegration getIntegration() {
            return this.integration;
        }

        public final GuildRole getRole() {
            return this.role;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            ModelGuildIntegration modelGuildIntegration = this.integration;
            int iHashCode2 = (iHashCode + (modelGuildIntegration != null ? modelGuildIntegration.hashCode() : 0)) * 31;
            GuildRole guildRole = this.role;
            return iHashCode2 + (guildRole != null ? guildRole.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", integration=");
            sbU.append(this.integration);
            sbU.append(", role=");
            sbU.append(this.role);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetServerSettingsEditIntegration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        /* compiled from: WidgetServerSettingsEditIntegration.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03071 extends Lambda implements Function1<Void, Unit> {
            public C03071() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r5) {
                DimmerView.setDimmed$default(WidgetServerSettingsEditIntegration.access$getBinding$p(WidgetServerSettingsEditIntegration.this).f2560b, true, false, 2, null);
            }
        }

        public AnonymousClass1(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().syncIntegration(this.$model.getGuild().getId(), this.$model.getIntegration().getId()), false, 1, null), WidgetServerSettingsEditIntegration.this, null, 2, null);
            Class<?> cls = WidgetServerSettingsEditIntegration.this.getClass();
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, cls, view.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C03071(), 60, (Object) null);
        }
    }

    /* compiled from: WidgetServerSettingsEditIntegration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditRole.Companion companion = WidgetServerSettingsEditRole.INSTANCE;
            long id2 = this.$model.getGuild().getId();
            long id3 = this.$model.getRole().getId();
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "v.context");
            companion.launch(id2, id3, context);
        }
    }

    /* compiled from: WidgetServerSettingsEditIntegration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        /* compiled from: WidgetServerSettingsEditIntegration.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        public AnonymousClass3(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int iB = WidgetServerSettingsEditIntegration.access$getExpiryBehaviorRadioManager$p(WidgetServerSettingsEditIntegration.this).b();
            int i = WidgetServerSettingsEditIntegration.access$getGracePeriodDays$cp()[WidgetServerSettingsEditIntegration.access$getGracePeriodRadioManager$p(WidgetServerSettingsEditIntegration.this).b()];
            CheckedSetting checkedSetting = WidgetServerSettingsEditIntegration.access$getBinding$p(WidgetServerSettingsEditIntegration.this).d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.editIntegrationCustomEmotesToggle");
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateGuildIntegration(this.$model.getGuild().getId(), this.$model.getIntegration().getId(), new RestAPIParams.GuildIntegration(iB, i, checkedSetting.isChecked())), false, 1, null), WidgetServerSettingsEditIntegration.this, null, 2, null);
            Class<?> cls = WidgetServerSettingsEditIntegration.this.getClass();
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, cls, view.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 60, (Object) null);
        }
    }

    /* compiled from: WidgetServerSettingsEditIntegration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditIntegration.access$getBinding$p(WidgetServerSettingsEditIntegration.this).d.toggle();
            StatefulViews statefulViewsAccess$getState$p = WidgetServerSettingsEditIntegration.access$getState$p(WidgetServerSettingsEditIntegration.this);
            CheckedSetting checkedSetting = WidgetServerSettingsEditIntegration.access$getBinding$p(WidgetServerSettingsEditIntegration.this).d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.editIntegrationCustomEmotesToggle");
            statefulViewsAccess$getState$p.put(R.id.edit_integration_custom_emotes_toggle, Boolean.valueOf(checkedSetting.isChecked()));
            WidgetServerSettingsEditIntegration.access$getState$p(WidgetServerSettingsEditIntegration.this).configureSaveActionView(WidgetServerSettingsEditIntegration.access$getBinding$p(WidgetServerSettingsEditIntegration.this).o);
        }
    }

    /* compiled from: WidgetServerSettingsEditIntegration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
            super(1, widgetServerSettingsEditIntegration, WidgetServerSettingsEditIntegration.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettingsEditIntegration.access$configureUI((WidgetServerSettingsEditIntegration) this.receiver, model);
        }
    }

    public WidgetServerSettingsEditIntegration() {
        super(R.layout.widget_server_settings_edit_integration);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEditIntegration4.INSTANCE, null, 2, null);
        this.expiryBehaviorRadios = LazyJVM.lazy(new WidgetServerSettingsEditIntegration5(this));
        this.gracePeriodRadios = LazyJVM.lazy(new WidgetServerSettingsEditIntegration6(this));
        this.state = new StatefulViews(R.id.edit_integration_custom_emotes_toggle, R.id.edit_integration_expired_sub_container, R.id.edit_integration_grace_period_container);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration, Model model) {
        widgetServerSettingsEditIntegration.configureUI(model);
    }

    public static final /* synthetic */ WidgetServerSettingsEditIntegrationBinding access$getBinding$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        return widgetServerSettingsEditIntegration.getBinding();
    }

    public static final /* synthetic */ RadioManager access$getExpiryBehaviorRadioManager$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        RadioManager radioManager = widgetServerSettingsEditIntegration.expiryBehaviorRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("expiryBehaviorRadioManager");
        }
        return radioManager;
    }

    public static final /* synthetic */ int[] access$getGracePeriodDays$cp() {
        return gracePeriodDays;
    }

    public static final /* synthetic */ RadioManager access$getGracePeriodRadioManager$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        RadioManager radioManager = widgetServerSettingsEditIntegration.gracePeriodRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gracePeriodRadioManager");
        }
        return radioManager;
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        return widgetServerSettingsEditIntegration.state;
    }

    public static final /* synthetic */ void access$setExpiryBehaviorRadioManager$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration, RadioManager radioManager) {
        widgetServerSettingsEditIntegration.expiryBehaviorRadioManager = radioManager;
    }

    public static final /* synthetic */ void access$setGracePeriodRadioManager$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration, RadioManager radioManager) {
        widgetServerSettingsEditIntegration.gracePeriodRadioManager = radioManager;
    }

    private final void configureUI(Model model) {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        setActionBarTitle(R.string.integration_settings);
        setActionBarSubtitle(model.getGuild().getName());
        boolean zAreEqual = Intrinsics3.areEqual(model.getIntegration().getType(), "twitch");
        TextView textView = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.editIntegrationName");
        textView.setText(model.getIntegration().getDisplayName());
        TextView textView2 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.editIntegrationOwnerName");
        textView2.setText(model.getIntegration().getUser().getUsername());
        getBinding().l.setImageResource(zAreEqual ? R.drawable.asset_account_sync_twitch : R.drawable.asset_account_sync_youtube);
        getBinding().p.d.setOnClickListener(new AnonymousClass1(model));
        DimmerView.setDimmed$default(getBinding().f2560b, model.getIntegration().isSyncing(), false, 2, null);
        TextView textView3 = getBinding().p.f96b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.syncSettings.editIntegrationLastSyncTime");
        WidgetServerSettingsEditIntegrationBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        CoordinatorLayout coordinatorLayout = binding.a;
        Intrinsics3.checkNotNullExpressionValue(coordinatorLayout, "binding.root");
        Context context = coordinatorLayout.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
        textView3.setText(TimeUtils.toReadableTimeString$default(context, TimeUtils.parseUTCDate(model.getIntegration().getSyncedAt()), null, 4, null));
        TextView textView4 = getBinding().p.c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.syncSettings.edi…ntegrationSubscriberCount");
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        WidgetServerSettingsEditIntegrationBinding binding2 = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding2, "binding");
        CoordinatorLayout coordinatorLayout2 = binding2.a;
        Intrinsics3.checkNotNullExpressionValue(coordinatorLayout2, "binding.root");
        Context context2 = coordinatorLayout2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "binding.root.context");
        textView4.setText(FormatUtils.l(StringResourceUtils.getQuantityString(resources, context2, zAreEqual ? R.plurals.num_subscribers_subscribers : R.plurals.num_members_subscribers, model.getIntegration().getSubscriberCount(), Integer.valueOf(model.getIntegration().getSubscriberCount())), new Object[0], null, 2));
        getBinding().p.f.setOnClickListener(model.getRole() != null ? new AnonymousClass2(model) : null);
        TextView textView5 = getBinding().p.e;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.syncSettings.editIntegrationSyncedRole");
        textView5.setText(model.getRole() != null ? model.getRole().getName() : "None");
        getBinding().p.e.setTextColor(RoleUtils.getOpaqueColor(model.getRole(), ColorCompat.getColor(this, R.color.primary_300)));
        int iIntValue = ((Number) this.state.get(R.id.edit_integration_expired_sub_container, Integer.valueOf(model.getIntegration().getExpireBehavior()))).intValue();
        RadioManager radioManager = this.expiryBehaviorRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("expiryBehaviorRadioManager");
        }
        radioManager.a(getExpiryBehaviorRadios().get(iIntValue));
        int iIntValue2 = ((Number) this.state.get(R.id.edit_integration_grace_period_container, Integer.valueOf(getGracePeriodPosition(model.getIntegration().getExpireGracePeriod())))).intValue();
        RadioManager radioManager2 = this.gracePeriodRadioManager;
        if (radioManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gracePeriodRadioManager");
        }
        radioManager2.a(getGracePeriodRadios().get(iIntValue2));
        LinearLayout linearLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.editIntegrationCustomEmotesContainer");
        linearLayout.setVisibility(zAreEqual ? 0 : 8);
        CheckedSetting checkedSetting = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.editIntegrationCustomEmotesToggle");
        StatefulViews statefulViews = this.state;
        CheckedSetting checkedSetting2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.editIntegrationCustomEmotesToggle");
        checkedSetting.setChecked(((Boolean) statefulViews.get(checkedSetting2.getId(), Boolean.valueOf(model.getIntegration().isEnableEmoticons()))).booleanValue());
        this.state.configureSaveActionView(getBinding().o);
        getBinding().o.setOnClickListener(new AnonymousClass3(model));
    }

    private final WidgetServerSettingsEditIntegrationBinding getBinding() {
        return (WidgetServerSettingsEditIntegrationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getExpiryBehaviorRadios() {
        return (List) this.expiryBehaviorRadios.getValue();
    }

    private final int getGracePeriodPosition(int gracePeriodDays2) {
        if (gracePeriodDays2 == 1) {
            return 0;
        }
        if (gracePeriodDays2 == 3) {
            return 1;
        }
        if (gracePeriodDays2 == 7) {
            return 2;
        }
        if (gracePeriodDays2 != 14) {
            return gracePeriodDays2 != 30 ? 0 : 4;
        }
        return 3;
    }

    private final List<CheckedSetting> getGracePeriodRadios() {
        return (List) this.gracePeriodRadios.getValue();
    }

    private final RadioManager setupRadioManager(List<CheckedSetting> checkedSettings, int stateKey) {
        RadioManager radioManager = new RadioManager(checkedSettings);
        int i = 0;
        for (Object obj : checkedSettings) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            CheckedSetting checkedSetting = (CheckedSetting) obj;
            checkedSetting.e(new WidgetServerSettingsEditIntegration2(checkedSetting, i, this, radioManager, stateKey));
            i = i2;
        }
        return radioManager;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        StoreStream.INSTANCE.getGuildIntegrations().onIntegrationScreenClosed();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.expiryBehaviorRadioManager = setupRadioManager(getExpiryBehaviorRadios(), R.id.edit_integration_expired_sub_container);
        this.gracePeriodRadioManager = setupRadioManager(getGracePeriodRadios(), R.id.edit_integration_grace_period_container);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.state.setupUnsavedChangesConfirmation(this);
        List<CheckedSetting> gracePeriodRadios = getGracePeriodRadios();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(gracePeriodRadios, 10));
        int i = 0;
        for (Object obj : gracePeriodRadios) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            CheckedSetting checkedSetting = (CheckedSetting) obj;
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            Context context = checkedSetting.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "radio.context");
            int[] iArr = gracePeriodDays;
            checkedSetting.setText(StringResourceUtils.getQuantityString(resources, context, R.plurals.n_days_days, iArr[i], Integer.valueOf(iArr[i])));
            arrayList.add(Unit.a);
            i = i2;
        }
        getBinding().d.e(new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        long longExtra2 = getMostRecentIntent().getLongExtra(INTENT_EXTRA_INTEGRATION_ID, -1L);
        StoreStream.INSTANCE.getGuildIntegrations().onIntegrationScreenOpened(longExtra);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra, longExtra2), this, null, 2, null), WidgetServerSettingsEditIntegration.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
