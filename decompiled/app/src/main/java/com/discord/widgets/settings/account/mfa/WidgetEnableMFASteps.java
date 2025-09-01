package com.discord.widgets.settings.account.mfa;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.WidgetEnableTwoFactorPasswordDialog;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetEnableMfaStepsBinding;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.steps.StepsView;
import com.discord.widgets.settings.account.mfa.WidgetEnableMFAViewModel;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetEnableMFASteps.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u0019\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\rR\u001d\u0010\u0015\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/settings/account/mfa/WidgetEnableMFASteps;", "Lcom/discord/app/AppFragment;", "", "showPasswordModal", "()V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Landroid/os/Bundle;", "savedInstanceState", "onViewStateRestored", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Lcom/discord/databinding/WidgetEnableMfaStepsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetEnableMfaStepsBinding;", "binding", "Lcom/discord/widgets/settings/account/mfa/WidgetEnableMFAViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/settings/account/mfa/WidgetEnableMFAViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetEnableMFASteps extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEnableMFASteps.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableMfaStepsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int KEY_SCREEN = 2;
    private static final String STATE_TOTP_PASSWORD_KEY = "STATE_TOTP_PASSWORD_KEY";
    private static final String STATE_TOTP_SECRET_KEY = "STATE_TOTP_SECRET_KEY";
    public static final int SUCCESS_SCREEN = 3;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetEnableMFASteps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/settings/account/mfa/WidgetEnableMFASteps$Companion;", "", "Landroid/content/Context;", "context", "", "launch", "(Landroid/content/Context;)V", "", "KEY_SCREEN", "I", "", WidgetEnableMFASteps.STATE_TOTP_PASSWORD_KEY, "Ljava/lang/String;", WidgetEnableMFASteps.STATE_TOTP_SECRET_KEY, "SUCCESS_SCREEN", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetEnableMFASteps.class, new Intent());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetEnableMFASteps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentActivity activity = WidgetEnableMFASteps.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetEnableMFASteps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetEnableMFASteps.access$getViewModel$p(WidgetEnableMFASteps.this).updateScreenIndex(i);
        }
    }

    /* compiled from: WidgetEnableMFASteps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/account/mfa/WidgetEnableMFAViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/settings/account/mfa/WidgetEnableMFAViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetEnableMFAViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetEnableMFAViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetEnableMFAViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            DimmerView.setDimmed$default(WidgetEnableMFASteps.access$getBinding$p(WidgetEnableMFASteps.this).f2380b, viewState.isLoading(), false, 2, null);
            Integer screenIndex = viewState.getScreenIndex();
            if (screenIndex != null) {
                WidgetEnableMFASteps.access$getBinding$p(WidgetEnableMFASteps.this).c.b(screenIndex.intValue());
            }
        }
    }

    /* compiled from: WidgetEnableMFASteps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "newPassword", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$showPasswordModal$1, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(str, "newPassword");
            WidgetEnableMFASteps.access$getViewModel$p(WidgetEnableMFASteps.this).setPassword(str);
            AppFragment.hideKeyboard$default(WidgetEnableMFASteps.this, null, 1, null);
        }
    }

    public WidgetEnableMFASteps() {
        super(R.layout.widget_enable_mfa_steps);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEnableMFASteps2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetEnableMFAViewModel.class), new WidgetEnableMFASteps$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetEnableMFASteps3.INSTANCE));
    }

    public static final /* synthetic */ WidgetEnableMfaStepsBinding access$getBinding$p(WidgetEnableMFASteps widgetEnableMFASteps) {
        return widgetEnableMFASteps.getBinding();
    }

    public static final /* synthetic */ WidgetEnableMFAViewModel access$getViewModel$p(WidgetEnableMFASteps widgetEnableMFASteps) {
        return widgetEnableMFASteps.getViewModel();
    }

    private final WidgetEnableMfaStepsBinding getBinding() {
        return (WidgetEnableMfaStepsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetEnableMFAViewModel getViewModel() {
        return (WidgetEnableMFAViewModel) this.viewModel.getValue();
    }

    private final void showPasswordModal() {
        WidgetEnableTwoFactorPasswordDialog.Companion aVar = WidgetEnableTwoFactorPasswordDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        Objects.requireNonNull(aVar);
        Intrinsics3.checkNotNullParameter(childFragmentManager, "supportFragmentManager");
        Intrinsics3.checkNotNullParameter(anonymousClass1, "onValidPasswordEntered");
        WidgetEnableTwoFactorPasswordDialog widgetEnableTwoFactorPasswordDialog = new WidgetEnableTwoFactorPasswordDialog();
        widgetEnableTwoFactorPasswordDialog.onValidPasswordEntered = anonymousClass1;
        widgetEnableTwoFactorPasswordDialog.show(childFragmentManager, WidgetEnableTwoFactorPasswordDialog.class.getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics3.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TOTP_SECRET_KEY, getViewModel().getTotpSecret());
        outState.putString(STATE_TOTP_PASSWORD_KEY, getViewModel().getPassword());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.a(new StepsView.d(this, Collections2.listOf((Object[]) new StepsView.b.a[]{new StepsView.b.a(WidgetEnableMFADownload.class, 0, R.string.cancel, 0, null, null, null, null, false, false, false, 2042), new StepsView.b.a(WidgetEnableMFAKey.class, 0, 0, 0, null, null, null, null, false, false, false, 2046), new StepsView.b.a(WidgetEnableMFAInput.class, 0, 0, 0, null, null, null, null, false, false, false, 766), new StepsView.b.a(WidgetEnableMFASuccess.class, 0, 0, 0, null, null, null, null, false, false, false, 1022)})), new AnonymousClass1(), new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetEnableMFASteps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        String string = savedInstanceState != null ? savedInstanceState.getString(STATE_TOTP_SECRET_KEY) : null;
        String string2 = savedInstanceState != null ? savedInstanceState.getString(STATE_TOTP_PASSWORD_KEY) : null;
        if (string != null) {
            getViewModel().setTotpSecret(string);
        } else {
            getViewModel().setTotpSecret(AuthUtils.INSTANCE.generateNewTotpKey());
        }
        if (string2 != null) {
            getViewModel().setPassword(string2);
        } else {
            showPasswordModal();
        }
    }
}
