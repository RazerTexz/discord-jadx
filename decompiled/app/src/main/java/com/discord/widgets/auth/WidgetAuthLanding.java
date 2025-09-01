package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetAuthLandingBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.auth.WidgetAuthLandingViewModel;
import com.discord.widgets.home.HomeConfig;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.io.IOException;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: WidgetAuthLanding.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b5\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\"\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#R\u001d\u0010)\u001a\u00020$8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010+\u001a\u00020*8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001d\u00104\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthLanding;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState;)V", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Event;)V", "", "ageGateError", "configureRegisterButton", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "onRegisterPressed", "(Landroid/content/Context;)V", ModelAuditLogEntry.CHANGE_KEY_ID, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "loginWithSmartLock", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/discord/databinding/WidgetAuthLandingBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetAuthLandingBinding;", "binding", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/auth/WidgetAuthLandingViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetAuthLanding extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetAuthLanding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthLandingBinding;", 0)};
    private static final int VIEW_INDEX_HAS_INVITE = 1;
    private static final int VIEW_INDEX_NO_INVITE = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetAuthLanding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$configureRegisterButton$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ String $ageGateError;

        public AnonymousClass1(String str) {
            this.$ageGateError = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthAgeGated.INSTANCE.start(outline.x(view, "it", "it.context"), this.$ageGateError);
        }
    }

    /* compiled from: WidgetAuthLanding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$configureRegisterButton$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthLanding widgetAuthLanding = WidgetAuthLanding.this;
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            WidgetAuthLanding.access$onRegisterPressed(widgetAuthLanding, context);
        }
    }

    /* compiled from: WidgetAuthLanding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$onViewBound$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetAuthLandingViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetAuthLanding widgetAuthLanding) {
            super(1, widgetAuthLanding, WidgetAuthLanding.class, "configureUI", "configureUI(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthLandingViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAuthLandingViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetAuthLanding.access$configureUI((WidgetAuthLanding) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetAuthLanding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            AppScreen2.e(context, WidgetAuthLogin.class, null, 4);
        }
    }

    /* compiled from: WidgetAuthLanding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthLanding widgetAuthLanding = WidgetAuthLanding.this;
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            WidgetAuthLanding.access$onRegisterPressed(widgetAuthLanding, context);
        }
    }

    /* compiled from: WidgetAuthLanding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetAuthLandingViewModel.Event, Unit> {
        public AnonymousClass1(WidgetAuthLanding widgetAuthLanding) {
            super(1, widgetAuthLanding, WidgetAuthLanding.class, "handleEvent", "handleEvent(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthLandingViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAuthLandingViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetAuthLanding.access$handleEvent((WidgetAuthLanding) this.receiver, event);
        }
    }

    public WidgetAuthLanding() {
        super(R.layout.widget_auth_landing);
        this.loggingConfig = new AppLogger2(false, null, WidgetAuthLanding3.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthLanding2.INSTANCE, null, 2, null);
        WidgetAuthLanding4 widgetAuthLanding4 = new WidgetAuthLanding4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetAuthLandingViewModel.class), new WidgetAuthLanding$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetAuthLanding4));
    }

    public static final /* synthetic */ void access$configureUI(WidgetAuthLanding widgetAuthLanding, WidgetAuthLandingViewModel.ViewState viewState) {
        widgetAuthLanding.configureUI(viewState);
    }

    public static final /* synthetic */ void access$handleEvent(WidgetAuthLanding widgetAuthLanding, WidgetAuthLandingViewModel.Event event) {
        widgetAuthLanding.handleEvent(event);
    }

    public static final /* synthetic */ void access$onRegisterPressed(WidgetAuthLanding widgetAuthLanding, Context context) {
        widgetAuthLanding.onRegisterPressed(context);
    }

    private final void configureRegisterButton(String ageGateError) {
        if (ageGateError == null) {
            getBinding().d.setOnClickListener(new AnonymousClass2());
            return;
        }
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra("com.discord.intent.extra.EXTRA_HOME_CONFIG");
        if (!(serializableExtra instanceof HomeConfig)) {
            serializableExtra = null;
        }
        HomeConfig homeConfig = (HomeConfig) serializableExtra;
        if (homeConfig != null && homeConfig.getAgeGated()) {
            WidgetAuthAgeGated.INSTANCE.start(requireContext(), ageGateError);
        }
        getBinding().d.setOnClickListener(new AnonymousClass1(ageGateError));
    }

    private final void configureUI(WidgetAuthLandingViewModel.ViewState viewState) {
        if (viewState instanceof WidgetAuthLandingViewModel.ViewState.Empty) {
            WidgetAuthLandingBinding binding = getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
            binding.a.setBackgroundColor(ColorCompat.getThemedColor(getContext(), R.attr.colorBackgroundPrimary));
            AppViewFlipper appViewFlipper = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.authLandingSwitchFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else {
            AppViewFlipper appViewFlipper2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.authLandingSwitchFlipper");
            appViewFlipper2.setDisplayedChild(1);
            if (viewState instanceof WidgetAuthLandingViewModel.ViewState.Invite) {
                getBinding().f2231b.configureInvite(((WidgetAuthLandingViewModel.ViewState.Invite) viewState).getInvite());
            } else if (viewState instanceof WidgetAuthLandingViewModel.ViewState.GuildTemplate) {
                getBinding().f2231b.configureGuildTemplate(((WidgetAuthLandingViewModel.ViewState.GuildTemplate) viewState).getGuildTemplate());
            }
        }
        configureRegisterButton(viewState.getAgeGateError());
    }

    private final WidgetAuthLandingBinding getBinding() {
        return (WidgetAuthLandingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetAuthLandingViewModel getViewModel() {
        return (WidgetAuthLandingViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetAuthLandingViewModel.Event event) {
        if (event instanceof WidgetAuthLandingViewModel.Event.SmartLockLogin) {
            GoogleSmartLockManager.SmartLockCredentials smartLockCredentials = ((WidgetAuthLandingViewModel.Event.SmartLockLogin) event).getSmartLockCredentials();
            getViewModel().getGoogleSmartLockManager().getSmartLockRepo().setAttemptToSignInWithSmartLock(false);
            loginWithSmartLock(smartLockCredentials.getId(), smartLockCredentials.getPassword());
        }
    }

    private final void loginWithSmartLock(String id2, String password) {
        Bundle bundle = new Bundle();
        bundle.putString(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID, id2);
        bundle.putString(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_PASSWORD, password);
        AppScreen2.d(requireContext(), WidgetAuthLogin.class, new Intent().putExtras(bundle));
    }

    private final void onRegisterPressed(Context context) {
        RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
        companion.getINSTANCE().setRegistering(true);
        companion.getINSTANCE().clear();
        AppScreen2.e(context, WidgetAuthRegisterIdentity.class, null, 4);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) throws IOException {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4009) {
            GoogleSmartLockManager.INSTANCE.handleResult(resultCode, data);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetAuthLanding.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        getBinding().c.setOnClickListener(AnonymousClass2.INSTANCE);
        getBinding().d.setOnClickListener(new AnonymousClass3());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetAuthLanding.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        GrowthTeamFeatures.INSTANCE.imbalancedAndroidSplashNoop();
    }
}
