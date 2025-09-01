package com.discord.widgets.settings;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsBinding;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.debugging.WidgetDebugging;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.SettingsViewModel;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.OnTabSelectedListener;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.functions.Action2;

/* compiled from: WidgetSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0005R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010'\u001a\u00020#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettings;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/tabs/OnTabSelectedListener;", "", "configureToolbar", "()V", "Lcom/discord/widgets/settings/SettingsViewModel$ViewState;", "model", "configureUI", "(Lcom/discord/widgets/settings/SettingsViewModel$ViewState;)V", "Lcom/discord/widgets/settings/SettingsViewModel$ViewState$Loaded;", "configureLoaded", "(Lcom/discord/widgets/settings/SettingsViewModel$ViewState$Loaded;)V", "Landroid/content/Context;", "context", "showLogoutDialog", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "onTabSelected", "Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel;", "viewModelUserProfileHeader$delegate", "Lkotlin/Lazy;", "getViewModelUserProfileHeader", "()Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel;", "viewModelUserProfileHeader", "Lcom/discord/databinding/WidgetSettingsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsBinding;", "binding", "Lcom/discord/widgets/settings/SettingsViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/settings/SettingsViewModel;", "viewModel", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettings extends AppFragment implements OnTabSelectedListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: viewModelUserProfileHeader$delegate, reason: from kotlin metadata */
    private final Lazy viewModelUserProfileHeader;

    /* compiled from: WidgetSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "context", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettings$configureToolbar$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case R.id.menu_settings_debugging /* 2131364408 */:
                    WidgetDebugging.Companion companion = WidgetDebugging.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    companion.launch(context);
                    break;
                case R.id.menu_settings_log_out /* 2131364409 */:
                    WidgetSettings widgetSettings = WidgetSettings.this;
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    WidgetSettings.access$showLogoutDialog(widgetSettings, context);
                    break;
            }
        }
    }

    /* compiled from: WidgetSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/SettingsViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/settings/SettingsViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<SettingsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetSettings widgetSettings) {
            super(1, widgetSettings, WidgetSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/SettingsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetSettings.access$configureUI((WidgetSettings) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettings$showLogoutDialog$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            StoreStream.INSTANCE.getAuthentication().logout();
        }
    }

    public WidgetSettings() {
        super(R.layout.widget_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettings$binding$2.INSTANCE, null, 2, null);
        WidgetSettings$viewModel$2 widgetSettings$viewModel$2 = WidgetSettings$viewModel$2.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(SettingsViewModel.class), new WidgetSettings$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetSettings$viewModel$2));
        WidgetSettings$viewModelUserProfileHeader$2 widgetSettings$viewModelUserProfileHeader$2 = WidgetSettings$viewModelUserProfileHeader$2.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates32 = new AppViewModelDelegates3(this);
        this.viewModelUserProfileHeader = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(UserProfileHeaderViewModel.class), new WidgetSettings$appViewModels$$inlined$viewModels$2(appViewModelDelegates32), new AppViewModelDelegates5(widgetSettings$viewModelUserProfileHeader$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettings widgetSettings, SettingsViewModel.ViewState viewState) {
        widgetSettings.configureUI(viewState);
    }

    public static final /* synthetic */ SettingsViewModel access$getViewModel$p(WidgetSettings widgetSettings) {
        return widgetSettings.getViewModel();
    }

    public static final /* synthetic */ UserProfileHeaderViewModel access$getViewModelUserProfileHeader$p(WidgetSettings widgetSettings) {
        return widgetSettings.getViewModelUserProfileHeader();
    }

    public static final /* synthetic */ void access$showLogoutDialog(WidgetSettings widgetSettings, Context context) {
        widgetSettings.showLogoutDialog(context);
    }

    private final void configureLoaded(SettingsViewModel.ViewState.Loaded model) {
        MeUser meUser = model.getMeUser();
        UserUtils userUtils = UserUtils.INSTANCE;
        boolean z2 = userUtils.isStaff(meUser);
        boolean zIsVerified = meUser.isVerified();
        boolean hasSubscription = userUtils.getHasSubscription(meUser);
        WidgetSettingsBinding binding = getBinding();
        View view = binding.n;
        Intrinsics3.checkNotNullExpressionValue(view, "developerOptionsDivider");
        view.setVisibility(z2 ? 0 : 8);
        TextView textView = binding.o;
        Intrinsics3.checkNotNullExpressionValue(textView, "developerOptionsHeader");
        textView.setVisibility(z2 ? 0 : 8);
        TextView textView2 = binding.m;
        Intrinsics3.checkNotNullExpressionValue(textView2, "developerOptions");
        textView2.setVisibility(z2 ? 0 : 8);
        binding.m.setOnClickListener(WidgetSettings$configureLoaded$1$1.INSTANCE);
        LinearLayout linearLayout = binding.u;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "nitroSettingsContainer");
        linearLayout.setVisibility(zIsVerified ? 0 : 8);
        TextView textView3 = binding.E;
        Intrinsics3.checkNotNullExpressionValue(textView3, "settingsNitro");
        textView3.setText(getString(hasSubscription ? R.string.billing_manage_subscription : R.string.premium_settings_subscribe_today));
        TextView textView4 = binding.q;
        Intrinsics3.checkNotNullExpressionValue(textView4, "nitroBoosting");
        textView4.setText(getString(hasSubscription ? R.string.premium_guild_perks_modal_manage_your_subscriptions : R.string.premium_settings_premium_guild_subscriptions));
        Presence presence = model.getPresence();
        binding.G.setPresence(presence);
        TextView textView5 = binding.F;
        Intrinsics3.checkNotNullExpressionValue(textView5, "settingsPresenceText");
        textView5.setText(getString(PresenceUtils.INSTANCE.getStatusStringResForPresence(presence)));
        TextView textView6 = binding.C;
        Intrinsics3.checkNotNullExpressionValue(textView6, "roleSubscriptions");
        textView6.setVisibility(model.getShowRoleSubscriptionsButton() ? 0 : 8);
        if (model.getPromoCount() > 0) {
            TextView textView7 = binding.r;
            Intrinsics3.checkNotNullExpressionValue(textView7, "nitroGiftingBadge");
            textView7.setText(String.valueOf(model.getPromoCount()));
            TextView textView8 = binding.r;
            Intrinsics3.checkNotNullExpressionValue(textView8, "nitroGiftingBadge");
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(new ShapeAppearanceModel.Builder().setAllCornerSizes(ShapeAppearanceModel.PILL).build());
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.status_red_500)));
            textView8.setBackground(materialShapeDrawable);
            TextView textView9 = binding.r;
            Intrinsics3.checkNotNullExpressionValue(textView9, "nitroGiftingBadge");
            textView9.setVisibility(0);
        } else {
            TextView textView10 = binding.r;
            Intrinsics3.checkNotNullExpressionValue(textView10, "nitroGiftingBadge");
            textView10.setVisibility(8);
        }
        LinearLayout linearLayout2 = binding.v;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "notificationUpsell");
        linearLayout2.setVisibility((NotificationManagerCompat.from(requireContext()).areNotificationsEnabled() || model.getPushNotificationUpsellDismissed()) ? false : true ? 0 : 8);
    }

    private final void configureToolbar() {
        AppFragment.bindToolbar$default(this, null, 1, null);
        setActionBarTitle(R.string.user_settings);
        setActionBarTitleLayoutMinimumTappableArea();
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_settings, new AnonymousClass1(), null, 4, null);
    }

    private final void configureUI(SettingsViewModel.ViewState model) {
        Unit unit;
        if (model instanceof SettingsViewModel.ViewState.Uninitialized) {
            unit = Unit.a;
        } else {
            if (!(model instanceof SettingsViewModel.ViewState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            configureLoaded((SettingsViewModel.ViewState.Loaded) model);
            unit = Unit.a;
        }
        KotlinExtensions.getExhaustive(unit);
    }

    private final WidgetSettingsBinding getBinding() {
        return (WidgetSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SettingsViewModel getViewModel() {
        return (SettingsViewModel) this.viewModel.getValue();
    }

    private final UserProfileHeaderViewModel getViewModelUserProfileHeader() {
        return (UserProfileHeaderViewModel) this.viewModelUserProfileHeader.getValue();
    }

    private final void showLogoutDialog(Context context) {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(context).setTitle(R.string.logout).setMessage(R.string.user_settings_confirm_logout).setDialogAttrTheme(R.attr.notice_theme_positive_red).setPositiveButton(R.string.logout, AnonymousClass1.INSTANCE), R.string.cancel, (Function1) null, 2, (Object) null).show(parentFragmentManager);
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        configureToolbar();
        setActionBarTitleAccessibilityViewFocused();
        getViewModel().refreshSubscriptions();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetTabsHost)) {
            parentFragment = null;
        }
        WidgetTabsHost widgetTabsHost = (WidgetTabsHost) parentFragment;
        if (widgetTabsHost != null) {
            widgetTabsHost.registerTabSelectionListener(NavigationTab.SETTINGS, this);
        }
        WidgetSettingsBinding binding = getBinding();
        binding.D.setOnClickListener(new WidgetSettings$onViewBound$$inlined$with$lambda$1(this));
        UserProfileHeaderView userProfileHeaderView = binding.L;
        Badge.Companion companion = Badge.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        userProfileHeaderView.setOnBadgeClick(companion.onBadgeClick(parentFragmentManager, requireContext()));
        binding.L.setOnBannerPress(new WidgetSettings$onViewBound$$inlined$with$lambda$2(this));
        TextView textView = binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "appInfoHeader");
        textView.setText(getString(R.string.app_information) + " - 126.21 - Stable (126021)");
        binding.B.setOnClickListener(new WidgetSettings$onViewBound$$inlined$with$lambda$3(this));
        binding.u.setOnClickListener(WidgetSettings$onViewBound$1$5.INSTANCE);
        binding.q.setOnClickListener(WidgetSettings$onViewBound$1$6.INSTANCE);
        binding.C.setOnClickListener(new WidgetSettings$onViewBound$$inlined$with$lambda$4(this));
        binding.f2607s.setOnClickListener(WidgetSettings$onViewBound$1$8.INSTANCE);
        binding.c.setOnClickListener(WidgetSettings$onViewBound$1$9.INSTANCE);
        binding.A.setOnClickListener(WidgetSettings$onViewBound$1$10.INSTANCE);
        binding.i.setOnClickListener(WidgetSettings$onViewBound$1$11.INSTANCE);
        binding.f2610z.setOnClickListener(WidgetSettings$onViewBound$1$12.INSTANCE);
        binding.l.setOnClickListener(WidgetSettings$onViewBound$1$13.INSTANCE);
        binding.h.setOnClickListener(WidgetSettings$onViewBound$1$14.INSTANCE);
        binding.f2606b.setOnClickListener(WidgetSettings$onViewBound$1$15.INSTANCE);
        binding.j.setOnClickListener(WidgetSettings$onViewBound$1$16.INSTANCE);
        binding.p.setOnClickListener(WidgetSettings$onViewBound$1$17.INSTANCE);
        binding.e.setOnClickListener(WidgetSettings$onViewBound$1$18.INSTANCE);
        binding.f2609y.setOnClickListener(new WidgetSettings$onViewBound$$inlined$with$lambda$5(this));
        binding.I.setOnClickListener(WidgetSettings$onViewBound$1$20.INSTANCE);
        binding.M.setOnClickListener(WidgetSettings$onViewBound$1$21.INSTANCE);
        binding.H.setOnClickListener(WidgetSettings$onViewBound$1$22.INSTANCE);
        binding.J.setOnClickListener(new WidgetSettings$onViewBound$$inlined$with$lambda$6(binding, this));
        binding.d.setOnClickListener(WidgetSettings$onViewBound$1$24.INSTANCE);
        binding.k.setOnClickListener(WidgetSettings$onViewBound$1$25.INSTANCE);
        binding.f2608x.setOnClickListener(WidgetSettings$onViewBound$1$26.INSTANCE);
        binding.w.setOnClickListener(WidgetSettings$onViewBound$1$27.INSTANCE);
        for (TextView textView2 : Collections2.listOf((Object[]) new TextView[]{binding.K, binding.t, binding.g, binding.o, binding.f})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView2, "header");
            accessibilityUtils.setViewIsHeading(textView2);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        UserProfileHeaderView.Companion companion = UserProfileHeaderView.INSTANCE;
        UserProfileHeaderView userProfileHeaderView = getBinding().L;
        Intrinsics3.checkNotNullExpressionValue(userProfileHeaderView, "binding.userSettingsProfileHeaderView");
        companion.bind(userProfileHeaderView, this, getViewModelUserProfileHeader().observeViewState());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
