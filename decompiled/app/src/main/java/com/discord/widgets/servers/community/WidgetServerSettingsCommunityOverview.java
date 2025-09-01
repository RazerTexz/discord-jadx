package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsCommunityOverviewBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.servers.community.WidgetConfirmRemoveCommunityDialog;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps;
import com.discord.widgets.settings.WidgetSettingsLanguage;
import com.discord.widgets.settings.WidgetSettingsLanguageSelect;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsCommunityOverview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b'\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R!\u0010 \u001a\u00060\u001bj\u0002`\u001c8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010&\u001a\u00020!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverview;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;)V", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded;", "configureValidUI", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel;", "viewModel", "", "Lcom/discord/primitives/GuildId;", "guildId$delegate", "getGuildId", "()J", "guildId", "Lcom/discord/databinding/WidgetServerSettingsCommunityOverviewBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsCommunityOverviewBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverview extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsCommunityOverview.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunityOverviewBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String REQUEST_KEY_RULES_CHANNEL = "REQUEST_KEY_RULES_CHANNEL";
    private static final String REQUEST_KEY_UPDATES_CHANNEL = "REQUEST_KEY_UPDATES_CHANNEL";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final AppLogger2 loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverview$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "create", "(Landroid/content/Context;J)V", "", "INTENT_EXTRA_GUILD_ID", "Ljava/lang/String;", WidgetServerSettingsCommunityOverview.REQUEST_KEY_RULES_CHANNEL, WidgetServerSettingsCommunityOverview.REQUEST_KEY_UPDATES_CHANNEL, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("COMMUNITY_OVERVIEW", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsCommunityOverview.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$configureValidUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded $viewState;

        public AnonymousClass1(WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSelector.Companion.launchForText$default(WidgetChannelSelector.INSTANCE, WidgetServerSettingsCommunityOverview.this, this.$viewState.getGuild().getId(), WidgetServerSettingsCommunityOverview.REQUEST_KEY_RULES_CHANNEL, false, 0, 24, null);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$configureValidUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded $viewState;

        public AnonymousClass2(WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSelector.Companion.launchForText$default(WidgetChannelSelector.INSTANCE, WidgetServerSettingsCommunityOverview.this, this.$viewState.getGuild().getId(), WidgetServerSettingsCommunityOverview.REQUEST_KEY_UPDATES_CHANNEL, false, 0, 24, null);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$configureValidUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsLanguageSelect.INSTANCE.show(WidgetServerSettingsCommunityOverview.this);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$configureValidUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded $viewState;

        public AnonymousClass4(WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppActivity appActivity = WidgetServerSettingsCommunityOverview.this.getAppActivity();
            if (appActivity != null) {
                WidgetConfirmRemoveCommunityDialog.Companion companion = WidgetConfirmRemoveCommunityDialog.INSTANCE;
                FragmentManager supportFragmentManager = appActivity.getSupportFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
                companion.show(supportFragmentManager, this.$viewState.getGuild().getId());
            }
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "locale", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "locale");
            WidgetServerSettingsCommunityOverview.access$getViewModel$p(WidgetServerSettingsCommunityOverview.this).saveLocale(str);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "", "<anonymous parameter 1>", "", "invoke", "(JLjava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function2<Long, String, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunityOverview.access$getViewModel$p(WidgetServerSettingsCommunityOverview.this).saveRulesChannel(j);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "", "<anonymous parameter 1>", "", "invoke", "(JLjava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function2<Long, String, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunityOverview.access$getViewModel$p(WidgetServerSettingsCommunityOverview.this).saveCommunityUpdatesChannel(j);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetServerSettingsCommunityOverviewViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview) {
            super(1, widgetServerSettingsCommunityOverview, WidgetServerSettingsCommunityOverview.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetServerSettingsCommunityOverview.access$configureUI((WidgetServerSettingsCommunityOverview) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$Event;", "event", "", "invoke", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetServerSettingsCommunityOverviewViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsCommunityOverviewViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsCommunityOverviewViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            if (Intrinsics3.areEqual(event, WidgetServerSettingsCommunityOverviewViewModel.Event.DisableCommunitySuccess.INSTANCE)) {
                WidgetServerSettingsCommunityOverview.this.requireActivity().finish();
                WidgetServerSettingsEnableCommunitySteps.Companion companion = WidgetServerSettingsEnableCommunitySteps.INSTANCE;
                FragmentActivity fragmentActivityRequireActivity = WidgetServerSettingsCommunityOverview.this.requireActivity();
                Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                companion.create(fragmentActivityRequireActivity, WidgetServerSettingsCommunityOverview.this.getGuildId());
                return;
            }
            if (Intrinsics3.areEqual(event, WidgetServerSettingsCommunityOverviewViewModel.Event.SaveSuccess.INSTANCE)) {
                AppToast.i(WidgetServerSettingsCommunityOverview.this, R.string.server_settings_updated, 0, 4);
            } else if (Intrinsics3.areEqual(event, WidgetServerSettingsCommunityOverviewViewModel.Event.Error.INSTANCE)) {
                AppToast.i(WidgetServerSettingsCommunityOverview.this, R.string.guild_settings_public_update_failed, 0, 4);
            }
        }
    }

    public WidgetServerSettingsCommunityOverview() {
        super(R.layout.widget_server_settings_community_overview);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsCommunityOverview2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsCommunityOverviewViewModel.class), new WidgetServerSettingsCommunityOverview$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetServerSettingsCommunityOverview5(this)));
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsCommunityOverview3(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsCommunityOverview4.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview, WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
        widgetServerSettingsCommunityOverview.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel access$getViewModel$p(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview) {
        return widgetServerSettingsCommunityOverview.getViewModel();
    }

    private final void configureUI(WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, WidgetServerSettingsCommunityOverviewViewModel.ViewState.Invalid.INSTANCE)) {
            requireActivity().finish();
        } else if (viewState instanceof WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded) {
            configureValidUI((WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded) viewState);
        } else if (viewState instanceof WidgetServerSettingsCommunityOverviewViewModel.ViewState.DisableCommunityLoading) {
            getBinding().e.setIsLoading(((WidgetServerSettingsCommunityOverviewViewModel.ViewState.DisableCommunityLoading) viewState).isLoading());
        }
    }

    private final void configureValidUI(WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded viewState) {
        String strE;
        getBinding().e.setIsLoading(false);
        String string = viewState.getRulesChannel() == null ? requireContext().getString(R.string.guild_settings_public_no_option_selected) : ChannelUtils.e(viewState.getRulesChannel(), requireContext(), false, 2);
        Intrinsics3.checkNotNullExpressionValue(string, "when (viewState.rulesCha…t(requireContext())\n    }");
        if (viewState.getUpdatesChannel() == null) {
            strE = requireContext().getString(R.string.guild_settings_public_no_option_selected);
        } else {
            Channel updatesChannel = viewState.getUpdatesChannel();
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            strE = ChannelUtils.e(updatesChannel, fragmentActivityRequireActivity, false, 2);
        }
        Intrinsics3.checkNotNullExpressionValue(strE, "when (viewState.updatesC…(requireActivity())\n    }");
        getBinding().f2553b.setSubtitle(string);
        getBinding().c.setSubtitle(strE);
        getBinding().d.setSubtitle(WidgetSettingsLanguage.INSTANCE.getAsStringInLocale(viewState.getGuild().getPreferredLocale()));
        getBinding().f2553b.setOnClickListener(new AnonymousClass1(viewState));
        getBinding().c.setOnClickListener(new AnonymousClass2(viewState));
        getBinding().d.setOnClickListener(new AnonymousClass3());
        getBinding().e.setOnClickListener(new AnonymousClass4(viewState));
    }

    public static final void create(Context context, long j) {
        INSTANCE.create(context, j);
    }

    private final WidgetServerSettingsCommunityOverviewBinding getBinding() {
        return (WidgetServerSettingsCommunityOverviewBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsCommunityOverviewViewModel getViewModel() {
        return (WidgetServerSettingsCommunityOverviewViewModel) this.viewModel.getValue();
    }

    public final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetSettingsLanguageSelect.INSTANCE.registerForResult(this, new AnonymousClass1());
        WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_RULES_CHANNEL, false, new AnonymousClass2(), 4, null);
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_UPDATES_CHANNEL, false, new AnonymousClass3(), 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.guild_settings_community);
        Observable<WidgetServerSettingsCommunityOverviewViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsCommunityOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetServerSettingsCommunityOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
