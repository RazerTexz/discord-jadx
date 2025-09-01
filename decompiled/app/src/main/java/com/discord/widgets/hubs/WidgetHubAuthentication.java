package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerification2;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubAuthenticationBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CodeVerificationView;
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
import kotlin.reflect.KProperty;

/* compiled from: WidgetHubAuthentication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubAuthentication;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/hubs/HubAuthenticationState;", "state", "", "configureUi", "(Lcom/discord/widgets/hubs/HubAuthenticationState;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/widgets/hubs/HubAuthenticationArgs;", "args$delegate", "Lkotlin/Lazy;", "getArgs", "()Lcom/discord/widgets/hubs/HubAuthenticationArgs;", "args", "Lcom/discord/databinding/WidgetHubAuthenticationBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetHubAuthenticationBinding;", "binding", "Lcom/discord/widgets/hubs/WidgetHubAuthenticationViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/hubs/WidgetHubAuthenticationViewModel;", "viewModel", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHubAuthentication extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetHubAuthentication.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubAuthenticationBinding;", 0)};

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/utilities/Success;", "Lcom/discord/api/hubs/EmailVerificationCode;", "response", "", "invoke", "(Lcom/discord/stores/utilities/Success;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$configureUi$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestCallState6<? extends EmailVerification2>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends EmailVerification2> restCallState6) {
            invoke2((RestCallState6<EmailVerification2>) restCallState6);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<EmailVerification2> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "response");
            WidgetHubAuthentication widgetHubAuthentication = WidgetHubAuthentication.this;
            widgetHubAuthentication.hideKeyboard(widgetHubAuthentication.getView());
            EmailVerification2 emailVerification2Invoke = restCallState6.invoke();
            if (!emailVerification2Invoke.getJoined()) {
                AppToast.i(WidgetHubAuthentication.this, R.string.error_generic_title, 0, 4);
                return;
            }
            FragmentActivity activity = WidgetHubAuthentication.this.getActivity();
            if (activity != null) {
                activity.setResult(-1, AnimatableValueParser.g2(new WidgetHubAuthenticationlViewModel(emailVerification2Invoke.getGuild().getId())));
                activity.finish();
            }
            StoreStream.INSTANCE.getNux().updateNux(WidgetHubAuthentication3.INSTANCE);
        }
    }

    /* compiled from: WidgetHubAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/utilities/Success;", "Lcom/discord/api/hubs/EmailVerification;", "it", "", "invoke", "(Lcom/discord/stores/utilities/Success;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$configureUi$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestCallState6<? extends EmailVerification>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends EmailVerification> restCallState6) {
            invoke2((RestCallState6<EmailVerification>) restCallState6);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<EmailVerification> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            AppToast.i(WidgetHubAuthentication.this, R.string.member_verification_email_verification_email_sent, 0, 4);
        }
    }

    /* compiled from: WidgetHubAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ModelAuditLogEntry.CHANGE_KEY_CODE, "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBound$1, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            WidgetHubAuthentication.access$getViewModel$p(WidgetHubAuthentication.this).verifyCode(str);
        }
    }

    /* compiled from: WidgetHubAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {

        /* compiled from: WidgetHubAuthentication.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBound$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
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
                WidgetHubAuthentication.access$getViewModel$p(WidgetHubAuthentication.this).resendEmail();
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onClick", new AnonymousClass1());
        }
    }

    /* compiled from: WidgetHubAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/hubs/HubAuthenticationState;", "p1", "", "invoke", "(Lcom/discord/widgets/hubs/HubAuthenticationState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetHubAuthenticationlViewModel3, Unit> {
        public AnonymousClass1(WidgetHubAuthentication widgetHubAuthentication) {
            super(1, widgetHubAuthentication, WidgetHubAuthentication.class, "configureUi", "configureUi(Lcom/discord/widgets/hubs/HubAuthenticationState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubAuthenticationlViewModel3 widgetHubAuthenticationlViewModel3) {
            invoke2(widgetHubAuthenticationlViewModel3);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubAuthenticationlViewModel3 widgetHubAuthenticationlViewModel3) {
            Intrinsics3.checkNotNullParameter(widgetHubAuthenticationlViewModel3, "p1");
            WidgetHubAuthentication.access$configureUi((WidgetHubAuthentication) this.receiver, widgetHubAuthenticationlViewModel3);
        }
    }

    public WidgetHubAuthentication() {
        super(R.layout.widget_hub_authentication);
        this.args = LazyJVM.lazy(new WidgetHubAuthentication$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubAuthentication2.INSTANCE, null, 2, null);
        WidgetHubAuthentication4 widgetHubAuthentication4 = new WidgetHubAuthentication4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubAuthenticationlViewModel4.class), new WidgetHubAuthentication$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHubAuthentication4));
    }

    public static final /* synthetic */ void access$configureUi(WidgetHubAuthentication widgetHubAuthentication, WidgetHubAuthenticationlViewModel3 widgetHubAuthenticationlViewModel3) {
        widgetHubAuthentication.configureUi(widgetHubAuthenticationlViewModel3);
    }

    public static final /* synthetic */ WidgetHubAuthenticationlViewModel4 access$getViewModel$p(WidgetHubAuthentication widgetHubAuthentication) {
        return widgetHubAuthentication.getViewModel();
    }

    private final void configureUi(WidgetHubAuthenticationlViewModel3 state) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            RestCallState5.handleResponse$default(state.getAuthenticationAsync(), context, null, null, new AnonymousClass1(), 6, null);
            RestCallState5.handleResponse$default(state.getResendEmailAsync(), context, null, null, new AnonymousClass2(), 6, null);
        }
    }

    private final WidgetHubAuthenticationBinding getBinding() {
        return (WidgetHubAuthenticationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetHubAuthenticationlViewModel4 getViewModel() {
        return (WidgetHubAuthenticationlViewModel4) this.viewModel.getValue();
    }

    public final WidgetHubAuthenticationlViewModel2 getArgs() {
        return (WidgetHubAuthenticationlViewModel2) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.setOnCodeEntered(new AnonymousClass1());
        LinkifiedTextView linkifiedTextView = getBinding().f2469b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.description");
        linkifiedTextView.setText(FormatUtils.e(this, R.string.hub_pin_description, new Object[]{getArgs().getEmail()}, new AnonymousClass2()));
        CodeVerificationView codeVerificationView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(codeVerificationView, "binding.verification");
        showKeyboard(codeVerificationView);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetHubAuthentication.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
