package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetRemoteAuthBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.auth.WidgetRemoteAuthViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
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

/* compiled from: WidgetRemoteAuth.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/auth/WidgetRemoteAuth;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel;", "viewModel", "Lcom/discord/databinding/WidgetRemoteAuthBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetRemoteAuthBinding;", "binding", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetRemoteAuth extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetRemoteAuth.class, "binding", "getBinding()Lcom/discord/databinding/WidgetRemoteAuthBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_REMOTE_AUTH_FINGERPRINT = "REMOTE_AUTH_FINGERPRINT";
    private static final int VIEW_LOADED = 0;
    private static final int VIEW_LOADING = 2;
    private static final int VIEW_NOT_FOUND = 1;
    private static final int VIEW_SUCCEEDED = 3;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetRemoteAuth.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/auth/WidgetRemoteAuth$Companion;", "", "Landroid/content/Context;", "context", "", "fingerprint", "", "launch", "(Landroid/content/Context;Ljava/lang/String;)V", "EXTRA_REMOTE_AUTH_FINGERPRINT", "Ljava/lang/String;", "", "VIEW_LOADED", "I", "VIEW_LOADING", "VIEW_NOT_FOUND", "VIEW_SUCCEEDED", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, String fingerprint) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(fingerprint, "fingerprint");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra(WidgetRemoteAuth.EXTRA_REMOTE_AUTH_FINGERPRINT, fingerprint);
            AppScreen2.d(context, WidgetRemoteAuth.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetRemoteAuth.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuth$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetRemoteAuth.this.requireActivity().finish();
        }
    }

    /* compiled from: WidgetRemoteAuth.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuth$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetRemoteAuth.this.requireActivity().finish();
        }
    }

    /* compiled from: WidgetRemoteAuth.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuth$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetRemoteAuth.access$getViewModel$p(WidgetRemoteAuth.this).remoteLogin();
        }
    }

    /* compiled from: WidgetRemoteAuth.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuth$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetRemoteAuth.access$getViewModel$p(WidgetRemoteAuth.this).cancelLogin();
            WidgetRemoteAuth.this.requireActivity().finish();
        }
    }

    /* compiled from: WidgetRemoteAuth.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "isPermanent", "", "onCheckedChanged", "(Landroid/widget/CompoundButton;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuth$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements CompoundButton.OnCheckedChangeListener {
        public AnonymousClass5() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            WidgetRemoteAuth.access$getViewModel$p(WidgetRemoteAuth.this).toggleTemporary(!z2);
        }
    }

    /* compiled from: WidgetRemoteAuth.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuth$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetRemoteAuthViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetRemoteAuthViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetRemoteAuthViewModel.ViewState viewState) {
            WidgetRemoteAuth widgetRemoteAuth = WidgetRemoteAuth.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetRemoteAuth.access$configureUI(widgetRemoteAuth, viewState);
        }
    }

    public WidgetRemoteAuth() {
        super(R.layout.widget_remote_auth);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetRemoteAuth2.INSTANCE, null, 2, null);
        WidgetRemoteAuth3 widgetRemoteAuth3 = new WidgetRemoteAuth3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetRemoteAuthViewModel.class), new WidgetRemoteAuth$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetRemoteAuth3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetRemoteAuth widgetRemoteAuth, WidgetRemoteAuthViewModel.ViewState viewState) {
        widgetRemoteAuth.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetRemoteAuthViewModel access$getViewModel$p(WidgetRemoteAuth widgetRemoteAuth) {
        return widgetRemoteAuth.getViewModel();
    }

    private final void configureUI(WidgetRemoteAuthViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, WidgetRemoteAuthViewModel.ViewState.Loading.INSTANCE)) {
            AppViewFlipper appViewFlipper = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.remoteAuthViewFlipper");
            appViewFlipper.setDisplayedChild(2);
            return;
        }
        if (Intrinsics3.areEqual(viewState, WidgetRemoteAuthViewModel.ViewState.Failed.INSTANCE)) {
            AppViewFlipper appViewFlipper2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.remoteAuthViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            getBinding().c.f219b.setOnClickListener(new AnonymousClass1());
            return;
        }
        if (Intrinsics3.areEqual(viewState, WidgetRemoteAuthViewModel.ViewState.Succeeded.INSTANCE)) {
            AppViewFlipper appViewFlipper3 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.remoteAuthViewFlipper");
            appViewFlipper3.setDisplayedChild(3);
            getBinding().f2519b.f231b.setOnClickListener(new AnonymousClass2());
            return;
        }
        if (viewState instanceof WidgetRemoteAuthViewModel.ViewState.Loaded) {
            AppViewFlipper appViewFlipper4 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.remoteAuthViewFlipper");
            appViewFlipper4.setDisplayedChild(0);
            if (((WidgetRemoteAuthViewModel.ViewState.Loaded) viewState).getLoginAllowed()) {
                MaterialButton materialButton = getBinding().d.c;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.pendingLogin.remoteAuthLoginButton");
                materialButton.setEnabled(true);
                getBinding().d.c.setOnClickListener(new AnonymousClass3());
            } else {
                MaterialButton materialButton2 = getBinding().d.c;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.pendingLogin.remoteAuthLoginButton");
                materialButton2.setEnabled(false);
            }
            getBinding().d.f225b.setOnClickListener(new AnonymousClass4());
            getBinding().d.d.setOnCheckedChangeListener(null);
            SwitchMaterial switchMaterial = getBinding().d.d;
            Intrinsics3.checkNotNullExpressionValue(switchMaterial, "binding.pendingLogin.remoteAuthTemporarySwitch");
            switchMaterial.setChecked(!r5.isTemporary());
            getBinding().d.d.setOnCheckedChangeListener(new AnonymousClass5());
        }
    }

    private final WidgetRemoteAuthBinding getBinding() {
        return (WidgetRemoteAuthBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetRemoteAuthViewModel getViewModel() {
        return (WidgetRemoteAuthViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Observable<WidgetRemoteAuthViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetRemoteAuth.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 60, (Object) null);
    }
}
