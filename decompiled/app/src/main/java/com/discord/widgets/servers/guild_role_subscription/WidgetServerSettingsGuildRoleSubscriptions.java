package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionsBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanDetailsViewModel;
import com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanDetails;
import com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanFormat;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b*\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001f\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010$\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010#R\u001d\u0010)\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/WidgetServerSettingsGuildRoleSubscriptions;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState;)V", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded;", "loadedViewState", "(Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded;)V", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event;", "event", "handleEvents", "(Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionsBinding;", "binding", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel;", "viewModel", "Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanDetailsViewModel;", "planDetailsViewModel$delegate", "getPlanDetailsViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanDetailsViewModel;", "planDetailsViewModel", "", "guildId$delegate", "getGuildId", "()J", "guildId", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsGuildRoleSubscriptions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_GUILD_ID = "INTENT_EXTRA_SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_GUILD_ID";
    private static final int SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTIONS_VIEW_FLIPPER_LOADING_STATE = 0;
    private static final int SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTIONS_VIEW_FLIPPER_OVERVIEW_STATE = 1;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: planDetailsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy planDetailsViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/WidgetServerSettingsGuildRoleSubscriptions$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "launch", "(Landroid/content/Context;J)V", "", WidgetServerSettingsGuildRoleSubscriptions.INTENT_EXTRA_SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_GUILD_ID, "Ljava/lang/String;", "", "SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTIONS_VIEW_FLIPPER_LOADING_STATE", "I", "SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTIONS_VIEW_FLIPPER_OVERVIEW_STATE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra(WidgetServerSettingsGuildRoleSubscriptions.INTENT_EXTRA_SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_GUILD_ID, guildId);
            AppScreen2.d(context, WidgetServerSettingsGuildRoleSubscriptions.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsGuildRoleSubscriptions.access$getViewModel$p(WidgetServerSettingsGuildRoleSubscriptions.this).submitChanges();
        }
    }

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ServerSettingsGuildRoleSubscriptionViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsGuildRoleSubscriptionViewModel.ViewState viewState) {
            WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions = WidgetServerSettingsGuildRoleSubscriptions.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetServerSettingsGuildRoleSubscriptions.access$configureUI(widgetServerSettingsGuildRoleSubscriptions, viewState);
        }
    }

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ServerSettingsGuildRoleSubscriptionViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsGuildRoleSubscriptionViewModel.Event event) {
            WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions = WidgetServerSettingsGuildRoleSubscriptions.this;
            Intrinsics3.checkNotNullExpressionValue(event, "it");
            WidgetServerSettingsGuildRoleSubscriptions.access$handleEvents(widgetServerSettingsGuildRoleSubscriptions, event);
        }
    }

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanDetailsViewModel$ViewState;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanDetailsViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<GuildRoleSubscriptionPlanDetailsViewModel.ViewState, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            WidgetServerSettingsGuildRoleSubscriptions.access$getViewModel$p(WidgetServerSettingsGuildRoleSubscriptions.this).onGuildRoleSubscriptionGroupUpdated(viewState.getDescription(), viewState.getCoverImage(), viewState.isFullServerGate());
        }
    }

    public WidgetServerSettingsGuildRoleSubscriptions() {
        super(R.layout.widget_server_settings_guild_role_subscriptions);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsGuildRoleSubscriptions2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsGuildRoleSubscriptions3(this));
        WidgetServerSettingsGuildRoleSubscriptions5 widgetServerSettingsGuildRoleSubscriptions5 = new WidgetServerSettingsGuildRoleSubscriptions5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ServerSettingsGuildRoleSubscriptionViewModel.class), new WidgetServerSettingsGuildRoleSubscriptions$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetServerSettingsGuildRoleSubscriptions5));
        this.planDetailsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionPlanDetailsViewModel.class), new WidgetServerSettingsGuildRoleSubscriptions$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetServerSettingsGuildRoleSubscriptions4.INSTANCE));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions, ServerSettingsGuildRoleSubscriptionViewModel.ViewState viewState) {
        widgetServerSettingsGuildRoleSubscriptions.configureUI(viewState);
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions) {
        return widgetServerSettingsGuildRoleSubscriptions.getGuildId();
    }

    public static final /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel access$getViewModel$p(WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions) {
        return widgetServerSettingsGuildRoleSubscriptions.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvents(WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions, ServerSettingsGuildRoleSubscriptionViewModel.Event event) {
        widgetServerSettingsGuildRoleSubscriptions.handleEvents(event);
    }

    private final void configureUI(ServerSettingsGuildRoleSubscriptionViewModel.ViewState viewState) {
        if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsGu…leSubscriptionViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Empty) {
            WidgetServerSettingsEmptyGuildRoleSubscriptions.INSTANCE.launch(requireContext(), getGuildId());
            requireActivity().finish();
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Loaded) {
            configureUI((ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Loaded) viewState);
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Failed) {
            AppToast.i(this, R.string.default_failure_to_perform_action_message, 0, 4);
            requireActivity().finish();
        }
    }

    private final WidgetServerSettingsGuildRoleSubscriptionsBinding getBinding() {
        return (WidgetServerSettingsGuildRoleSubscriptionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildRoleSubscriptionPlanDetailsViewModel getPlanDetailsViewModel() {
        return (GuildRoleSubscriptionPlanDetailsViewModel) this.planDetailsViewModel.getValue();
    }

    private final ServerSettingsGuildRoleSubscriptionViewModel getViewModel() {
        return (ServerSettingsGuildRoleSubscriptionViewModel) this.viewModel.getValue();
    }

    private final void handleEvents(ServerSettingsGuildRoleSubscriptionViewModel.Event event) {
        if (event instanceof ServerSettingsGuildRoleSubscriptionViewModel.Event.SubmitSuccess) {
            AppFragment.hideKeyboard$default(this, null, 1, null);
            return;
        }
        if (event instanceof ServerSettingsGuildRoleSubscriptionViewModel.Event.SubmitFailure) {
            AppToast.i(this, R.string.default_failure_to_perform_action_message, 0, 4);
            AppFragment.hideKeyboard$default(this, null, 1, null);
        } else if (event instanceof ServerSettingsGuildRoleSubscriptionViewModel.Event.StoreStateUpdate) {
            ServerSettingsGuildRoleSubscriptionViewModel.Event.StoreStateUpdate storeStateUpdate = (ServerSettingsGuildRoleSubscriptionViewModel.Event.StoreStateUpdate) event;
            getPlanDetailsViewModel().setGroupPlanDetails(storeStateUpdate.getGuildRoleSubscriptionGroupListing(), storeStateUpdate.getFullServerGatingOverwrite());
        }
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(R.string.guild_settings_role_subscriptions_title);
        getBinding().f2571b.setOnClickListener(new AnonymousClass1());
        getChildFragmentManager().beginTransaction().replace(R.id.guild_role_subscription_plan_details, WidgetGuildRoleSubscriptionPlanDetails.INSTANCE.newInstance(true)).replace(R.id.guild_role_subscription_plan_format, WidgetGuildRoleSubscriptionPlanFormat.INSTANCE.newInstance(true)).commit();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsGuildRoleSubscriptionViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsGuildRoleSubscriptions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        Observable<ServerSettingsGuildRoleSubscriptionViewModel.Event> observableR2 = getViewModel().observeEvents().r();
        Intrinsics3.checkNotNullExpressionValue(observableR2, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR2, this, null, 2, null), WidgetServerSettingsGuildRoleSubscriptions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        Observable<GuildRoleSubscriptionPlanDetailsViewModel.ViewState> observableR3 = getPlanDetailsViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR3, "planDetailsViewModel\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR3, this, null, 2, null), WidgetServerSettingsGuildRoleSubscriptions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }

    private final void configureUI(ServerSettingsGuildRoleSubscriptionViewModel.ViewState.Loaded loadedViewState) {
        AppViewFlipper appViewFlipper = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsGu…leSubscriptionViewFlipper");
        appViewFlipper.setDisplayedChild(1);
        FloatingActionButton floatingActionButton = getBinding().f2571b;
        floatingActionButton.setVisibility(loadedViewState.getHasChanges() ? 0 : 8);
        floatingActionButton.setEnabled(!loadedViewState.isSubmitting());
    }
}
