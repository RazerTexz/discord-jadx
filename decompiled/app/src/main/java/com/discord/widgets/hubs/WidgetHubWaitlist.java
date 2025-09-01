package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.hubs.WaitlistSignup;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubWaitlistBinding;
import com.discord.stores.utilities.RestCallState4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputEditText;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: WidgetHubWaitlist.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\u001d\u0010\u000f\u001a\u00020\n8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0015\u001a\u00020\u00108F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u00020\u001b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubWaitlist;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/hubs/HubWaitlistState;", "state", "", "configureUI", "(Lcom/discord/widgets/hubs/HubWaitlistState;)V", "maybeSubmitSchoolName", "()V", "onViewBoundOrOnResume", "Lcom/discord/widgets/hubs/HubWaitlistArgs;", "args$delegate", "Lkotlin/Lazy;", "getArgs", "()Lcom/discord/widgets/hubs/HubWaitlistArgs;", "args", "Lcom/discord/databinding/WidgetHubWaitlistBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetHubWaitlistBinding;", "binding", "Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager$delegate", "getValidationManager", "()Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager", "Lcom/discord/widgets/hubs/WidgetHubWaitlistViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/hubs/WidgetHubWaitlistViewModel;", "viewModel", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHubWaitlist extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetHubWaitlist.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubWaitlistBinding;", 0)};

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubWaitlist.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/utilities/Success;", "Lcom/discord/api/hubs/WaitlistSignup;", "it", "", "invoke", "(Lcom/discord/stores/utilities/Success;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubWaitlist$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestCallState6<? extends WaitlistSignup>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends WaitlistSignup> restCallState6) {
            invoke2((RestCallState6<WaitlistSignup>) restCallState6);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<WaitlistSignup> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            FragmentActivity activity = WidgetHubWaitlist.this.getActivity();
            if (activity != null) {
                activity.setResult(-1, AnimatableValueParser.g2(new WidgetHubWaitlist2(restCallState6.invoke().getSchool())));
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetHubWaitlist.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/hubs/HubWaitlistState;", "it", "", "invoke", "(Lcom/discord/widgets/hubs/HubWaitlistState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubWaitlist$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetHubWaitlistViewModel3, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubWaitlistViewModel3 widgetHubWaitlistViewModel3) {
            invoke2(widgetHubWaitlistViewModel3);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubWaitlistViewModel3 widgetHubWaitlistViewModel3) {
            Intrinsics3.checkNotNullParameter(widgetHubWaitlistViewModel3, "it");
            WidgetHubWaitlist.access$configureUI(WidgetHubWaitlist.this, widgetHubWaitlistViewModel3);
        }
    }

    /* compiled from: WidgetHubWaitlist.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubWaitlist$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubWaitlist.access$maybeSubmitSchoolName(WidgetHubWaitlist.this);
        }
    }

    public WidgetHubWaitlist() {
        super(R.layout.widget_hub_waitlist);
        this.args = LazyJVM.lazy(new WidgetHubWaitlist$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubWaitlist3.INSTANCE, null, 2, null);
        WidgetHubWaitlist5 widgetHubWaitlist5 = new WidgetHubWaitlist5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubWaitlistViewModel.class), new WidgetHubWaitlist$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHubWaitlist5));
        this.validationManager = LazyJVM.lazy(new WidgetHubWaitlist4(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetHubWaitlist widgetHubWaitlist, WidgetHubWaitlistViewModel3 widgetHubWaitlistViewModel3) {
        widgetHubWaitlist.configureUI(widgetHubWaitlistViewModel3);
    }

    public static final /* synthetic */ void access$maybeSubmitSchoolName(WidgetHubWaitlist widgetHubWaitlist) {
        widgetHubWaitlist.maybeSubmitSchoolName();
    }

    private final void configureUI(WidgetHubWaitlistViewModel3 state) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            getBinding().f2478b.setIsLoading(state.getWaitlistAsync() instanceof RestCallState4);
            RestCallState5.handleResponse$default(state.getWaitlistAsync(), context, null, null, new AnonymousClass1(), 6, null);
        }
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void maybeSubmitSchoolName() {
        if (getValidationManager().validate(true)) {
            WidgetHubWaitlistViewModel viewModel = getViewModel();
            TextInputEditText textInputEditText = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.hubWaitlistEditText");
            viewModel.joinWaitlist(String.valueOf(textInputEditText.getText()));
        }
        hideKeyboard(getView());
    }

    public final WidgetHubWaitlistViewModel2 getArgs() {
        return (WidgetHubWaitlistViewModel2) this.args.getValue();
    }

    public final WidgetHubWaitlistBinding getBinding() {
        return (WidgetHubWaitlistBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetHubWaitlistViewModel getViewModel() {
        return (WidgetHubWaitlistViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null)), WidgetHubWaitlist.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        getBinding().f2478b.setOnClickListener(new AnonymousClass2());
        TextInputEditText textInputEditText = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.hubWaitlistEditText");
        showKeyboard(textInputEditText);
    }
}
