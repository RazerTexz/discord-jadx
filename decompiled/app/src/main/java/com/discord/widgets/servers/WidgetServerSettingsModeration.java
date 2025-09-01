package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsModerationBinding;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsModeration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 62\u00020\u0001:\u000267B\u0007¢\u0006\u0004\b5\u0010\u001bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\"8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\"8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010$R\u001c\u0010-\u001a\u00020,8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001d\u0010\u0012\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsModeration;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;)V", "Lcom/discord/views/CheckedSetting;", "radio", "Lcom/discord/api/guild/GuildVerificationLevel;", "verificationLevel", "configureVerificationLevelRadio", "(Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;Lcom/discord/views/CheckedSetting;Lcom/discord/api/guild/GuildVerificationLevel;)V", "Lcom/discord/api/guild/GuildExplicitContentFilter;", "explicitContentLevel", "configureExplicitContentRadio", "(Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;Lcom/discord/views/CheckedSetting;Lcom/discord/api/guild/GuildExplicitContentFilter;)V", "", "guildId", "Lcom/discord/restapi/RestAPIParams$UpdateGuild;", "updateGuild", "(JLcom/discord/restapi/RestAPIParams$UpdateGuild;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetServerSettingsModerationBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsModerationBinding;", "binding", "", "getExplicitContentViews", "()Ljava/util/List;", "explicitContentViews", "Lcom/discord/views/RadioManager;", "radioManagerExplicit", "Lcom/discord/views/RadioManager;", "radioManagerVerification", "getVerificationViews", "verificationViews", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "guildId$delegate", "Lkotlin/Lazy;", "getGuildId", "()J", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsModeration extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsModeration.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsModerationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String VERIFICATION_LEVEL_HIGH_MINUTES = "10";
    private static final String VERIFICATION_LEVEL_MEDIUM_MINUTES = "5";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final AppLogger2 loggingConfig;
    private RadioManager radioManagerExplicit;
    private RadioManager radioManagerVerification;

    /* compiled from: WidgetServerSettingsModeration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Companion;", "", "Landroid/content/Context;", "context", "", "guildId", "", "launch", "(Landroid/content/Context;J)V", "", "INTENT_EXTRA_GUILD_ID", "Ljava/lang/String;", "VERIFICATION_LEVEL_HIGH_MINUTES", "VERIFICATION_LEVEL_MEDIUM_MINUTES", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("MODERATION", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsModeration.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsModeration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "guild", "copy", "(Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Guild guild;

        /* compiled from: WidgetServerSettingsModeration.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model$Companion;", "", "", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;", "get", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getGuilds().observeGuild(guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForGuild(guildId), WidgetServerSettingsModeration2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n             …        }\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            this.guild = guild;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            return model.copy(guild);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final Model copy(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new Model(guild);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Model) && Intrinsics3.areEqual(this.guild, ((Model) other).guild);
            }
            return true;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public int hashCode() {
            Guild guild = this.guild;
            if (guild != null) {
                return guild.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetServerSettingsModeration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$configureExplicitContentRadio$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ GuildExplicitContentFilter $explicitContentLevel;
        public final /* synthetic */ Model $model;

        public AnonymousClass1(Model model, GuildExplicitContentFilter guildExplicitContentFilter) {
            this.$model = model;
            this.$explicitContentLevel = guildExplicitContentFilter;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsModeration.access$updateGuild(WidgetServerSettingsModeration.this, this.$model.getGuild().getId(), RestAPIParams.UpdateGuild.INSTANCE.createForExplicitContentFilter(this.$explicitContentLevel));
        }
    }

    /* compiled from: WidgetServerSettingsModeration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$configureVerificationLevelRadio$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $model;
        public final /* synthetic */ GuildVerificationLevel $verificationLevel;

        public AnonymousClass1(Model model, GuildVerificationLevel guildVerificationLevel) {
            this.$model = model;
            this.$verificationLevel = guildVerificationLevel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsModeration.access$updateGuild(WidgetServerSettingsModeration.this, this.$model.getGuild().getId(), RestAPIParams.UpdateGuild.INSTANCE.createForVerificationLevel(this.$verificationLevel));
        }
    }

    /* compiled from: WidgetServerSettingsModeration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsModeration widgetServerSettingsModeration) {
            super(1, widgetServerSettingsModeration, WidgetServerSettingsModeration.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettingsModeration.access$configureUI((WidgetServerSettingsModeration) this.receiver, model);
        }
    }

    /* compiled from: WidgetServerSettingsModeration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guild/Guild;", "it", "", "invoke", "(Lcom/discord/api/guild/Guild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$updateGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<com.discord.api.guild.Guild, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "it");
            AppToast.i(WidgetServerSettingsModeration.this, R.string.server_settings_updated, 0, 4);
        }
    }

    public WidgetServerSettingsModeration() {
        super(R.layout.widget_server_settings_moderation);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsModeration3.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsModeration4(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsModeration5.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsModeration widgetServerSettingsModeration, Model model) {
        widgetServerSettingsModeration.configureUI(model);
    }

    public static final /* synthetic */ void access$updateGuild(WidgetServerSettingsModeration widgetServerSettingsModeration, long j, RestAPIParams.UpdateGuild updateGuild) {
        widgetServerSettingsModeration.updateGuild(j, updateGuild);
    }

    private final void configureExplicitContentRadio(Model model, CheckedSetting radio, GuildExplicitContentFilter explicitContentLevel) {
        RadioManager radioManager;
        if (!model.getGuild().getFeatures().contains(GuildFeature.COMMUNITY) || explicitContentLevel.compareTo(GuildExplicitContentFilter.ALL) >= 0) {
            radio.e(new AnonymousClass1(model, explicitContentLevel));
        } else {
            radio.b(R.string.tooltip_community_feature_disabled);
        }
        if (this.radioManagerExplicit == null || model.getGuild().getExplicitContentFilter() != explicitContentLevel || (radioManager = this.radioManagerExplicit) == null) {
            return;
        }
        radioManager.a(radio);
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
        setActionBarSubtitle(model.getGuild().getName());
        configureVerificationLevelRadio(model, getVerificationViews().get(0), GuildVerificationLevel.NONE);
        configureVerificationLevelRadio(model, getVerificationViews().get(1), GuildVerificationLevel.LOW);
        configureVerificationLevelRadio(model, getVerificationViews().get(2), GuildVerificationLevel.MEDIUM);
        configureVerificationLevelRadio(model, getVerificationViews().get(3), GuildVerificationLevel.HIGH);
        configureVerificationLevelRadio(model, getVerificationViews().get(4), GuildVerificationLevel.HIGHEST);
        configureExplicitContentRadio(model, getExplicitContentViews().get(0), GuildExplicitContentFilter.NONE);
        configureExplicitContentRadio(model, getExplicitContentViews().get(1), GuildExplicitContentFilter.SOME);
        configureExplicitContentRadio(model, getExplicitContentViews().get(2), GuildExplicitContentFilter.ALL);
    }

    private final void configureVerificationLevelRadio(Model model, CheckedSetting radio, GuildVerificationLevel verificationLevel) {
        RadioManager radioManager;
        if (model.getGuild().getFeatures().contains(GuildFeature.COMMUNITY) && verificationLevel == GuildVerificationLevel.NONE) {
            radio.b(R.string.tooltip_community_feature_disabled);
        } else {
            radio.e(new AnonymousClass1(model, verificationLevel));
        }
        if (this.radioManagerVerification == null || model.getGuild().getVerificationLevel() != verificationLevel || (radioManager = this.radioManagerVerification) == null) {
            return;
        }
        radioManager.a(radio);
    }

    private final WidgetServerSettingsModerationBinding getBinding() {
        return (WidgetServerSettingsModerationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getExplicitContentViews() {
        CheckedSetting checkedSetting = getBinding().f2580b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.serverSettingsModerationExplicit1");
        CheckedSetting checkedSetting2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.serverSettingsModerationExplicit2");
        CheckedSetting checkedSetting3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.serverSettingsModerationExplicit3");
        return Collections2.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3});
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final List<CheckedSetting> getVerificationViews() {
        CheckedSetting checkedSetting = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.serverSettingsModerationVerification1");
        CheckedSetting checkedSetting2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.serverSettingsModerationVerification2");
        CheckedSetting checkedSetting3 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.serverSettingsModerationVerification3");
        CheckedSetting checkedSetting4 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.serverSettingsModerationVerification4");
        CheckedSetting checkedSetting5 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.serverSettingsModerationVerification5");
        return Collections2.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3, checkedSetting4, checkedSetting5});
    }

    private final void updateGuild(long guildId, RestAPIParams.UpdateGuild updateGuild) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateGuild(guildId, updateGuild), false, 1, null), this, null, 2, null), WidgetServerSettingsModeration.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 60, (Object) null);
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
        setActionBarTitle(R.string.moderation);
        TextView textView = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsModerationVerificationHelp");
        FormatUtils.n(textView, R.string.form_help_verification_level, new Object[0], null, 4);
        TextView textView2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsModerationExplicitHelp");
        FormatUtils.n(textView2, R.string.form_help_explicit_content_filter, new Object[0], null, 4);
        this.radioManagerVerification = new RadioManager(getVerificationViews());
        this.radioManagerExplicit = new RadioManager(getExplicitContentViews());
        CheckedSetting.i(getVerificationViews().get(2), FormatUtils.k(this, R.string.verification_level_medium_criteria, new Object[]{VERIFICATION_LEVEL_MEDIUM_MINUTES}, null, 4), false, 2);
        CheckedSetting.i(getVerificationViews().get(3), FormatUtils.k(this, R.string.verification_level_high_criteria, new Object[]{VERIFICATION_LEVEL_HIGH_MINUTES}, null, 4), false, 2);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getGuildId()), this, null, 2, null), WidgetServerSettingsModeration.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
