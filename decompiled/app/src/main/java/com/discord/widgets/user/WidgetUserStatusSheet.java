package com.discord.widgets.user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.ViewUserStatusPresenceBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.presence.ClientStatus;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUserStatusUpdateBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.WidgetUserStatusSheetViewModel;
import d0.z.d.FunctionReferenceImpl;
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

/* compiled from: WidgetUserStatusSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b(\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0010J\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0010R\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010'\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/discord/widgets/user/WidgetUserStatusSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState;", "viewState", "", "updateView", "(Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState;)V", "Lcom/discord/api/presence/ClientStatus;", "status", "updateStateAndDismiss", "(Lcom/discord/api/presence/ClientStatus;)V", "Landroid/content/Context;", "context", "openCustomStatusAndDismiss", "(Landroid/content/Context;)V", "clearCustomStatus", "()V", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel;", "viewModel", "Lcom/discord/databinding/WidgetUserStatusUpdateBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetUserStatusUpdateBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserStatusSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserStatusSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserStatusUpdateBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetUserStatusSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/user/WidgetUserStatusSheet$Companion;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "show", "(Landroidx/fragment/app/Fragment;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(Fragment fragment) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            WidgetUserStatusSheet widgetUserStatusSheet = new WidgetUserStatusSheet();
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetUserStatusSheet.show(parentFragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserStatusSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetUserStatusSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetUserStatusSheet widgetUserStatusSheet) {
            super(1, widgetUserStatusSheet, WidgetUserStatusSheet.class, "updateView", "updateView(Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserStatusSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserStatusSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetUserStatusSheet.access$updateView((WidgetUserStatusSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetUserStatusSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserStatusSheet.access$updateStateAndDismiss(WidgetUserStatusSheet.this, ClientStatus.ONLINE);
        }
    }

    /* compiled from: WidgetUserStatusSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserStatusSheet.access$updateStateAndDismiss(WidgetUserStatusSheet.this, ClientStatus.IDLE);
        }
    }

    /* compiled from: WidgetUserStatusSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserStatusSheet.access$updateStateAndDismiss(WidgetUserStatusSheet.this, ClientStatus.DND);
        }
    }

    /* compiled from: WidgetUserStatusSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserStatusSheet.access$updateStateAndDismiss(WidgetUserStatusSheet.this, ClientStatus.INVISIBLE);
        }
    }

    /* compiled from: WidgetUserStatusSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserStatusSheet widgetUserStatusSheet = WidgetUserStatusSheet.this;
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            WidgetUserStatusSheet.access$openCustomStatusAndDismiss(widgetUserStatusSheet, context);
        }
    }

    /* compiled from: WidgetUserStatusSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function0<Unit> {
        public AnonymousClass6() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserStatusSheet.access$clearCustomStatus(WidgetUserStatusSheet.this);
        }
    }

    public WidgetUserStatusSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserStatusSheet2.INSTANCE, null, 2, null);
        WidgetUserStatusSheet3 widgetUserStatusSheet3 = WidgetUserStatusSheet3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetUserStatusSheetViewModel.class), new WidgetUserStatusSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetUserStatusSheet3));
    }

    public static final /* synthetic */ void access$clearCustomStatus(WidgetUserStatusSheet widgetUserStatusSheet) {
        widgetUserStatusSheet.clearCustomStatus();
    }

    public static final /* synthetic */ void access$openCustomStatusAndDismiss(WidgetUserStatusSheet widgetUserStatusSheet, Context context) {
        widgetUserStatusSheet.openCustomStatusAndDismiss(context);
    }

    public static final /* synthetic */ void access$updateStateAndDismiss(WidgetUserStatusSheet widgetUserStatusSheet, ClientStatus clientStatus) {
        widgetUserStatusSheet.updateStateAndDismiss(clientStatus);
    }

    public static final /* synthetic */ void access$updateView(WidgetUserStatusSheet widgetUserStatusSheet, WidgetUserStatusSheetViewModel.ViewState viewState) {
        widgetUserStatusSheet.updateView(viewState);
    }

    @MainThread
    private final void clearCustomStatus() {
        getViewModel().clearCustomStatus();
    }

    private final WidgetUserStatusUpdateBinding getBinding() {
        return (WidgetUserStatusUpdateBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetUserStatusSheetViewModel getViewModel() {
        return (WidgetUserStatusSheetViewModel) this.viewModel.getValue();
    }

    @MainThread
    private final void openCustomStatusAndDismiss(Context context) {
        AnalyticsTracker.INSTANCE.openModal("Custom Status Modal", new Traits.Source(null, "Account Panel", "Avatar", null, null, 25, null));
        WidgetUserSetCustomStatus.INSTANCE.launch(context);
        dismiss();
    }

    @MainThread
    private final void updateStateAndDismiss(ClientStatus status) {
        getViewModel().setStatus(status);
        dismiss();
    }

    private final void updateView(WidgetUserStatusSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetUserStatusSheetViewModel.ViewState.Loaded) {
            getBinding().f2698b.updateViewState(((WidgetUserStatusSheetViewModel.ViewState.Loaded) viewState).getCustomStatusViewState());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_user_status_update;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        dismiss();
        super.onPause();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetUserStatusSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f.f106b.setImageResource(R.drawable.ic_status_online_16dp);
        getBinding().f.d.setText(R.string.status_online);
        ViewUserStatusPresenceBinding viewUserStatusPresenceBinding = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(viewUserStatusPresenceBinding, "binding.userStatusUpdateOnline");
        viewUserStatusPresenceBinding.a.setOnClickListener(new AnonymousClass1());
        getBinding().d.f106b.setImageResource(R.drawable.ic_status_idle_16dp);
        getBinding().d.d.setText(R.string.status_idle);
        ViewUserStatusPresenceBinding viewUserStatusPresenceBinding2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(viewUserStatusPresenceBinding2, "binding.userStatusUpdateIdle");
        viewUserStatusPresenceBinding2.a.setOnClickListener(new AnonymousClass2());
        getBinding().c.f106b.setImageResource(R.drawable.ic_status_dnd_16dp);
        getBinding().c.d.setText(R.string.status_dnd);
        getBinding().c.c.setText(R.string.status_dnd_help);
        ViewUserStatusPresenceBinding viewUserStatusPresenceBinding3 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(viewUserStatusPresenceBinding3, "binding.userStatusUpdateDnd");
        viewUserStatusPresenceBinding3.a.setOnClickListener(new AnonymousClass3());
        getBinding().e.f106b.setImageResource(R.drawable.ic_status_invisible_16dp);
        getBinding().e.d.setText(R.string.status_invisible);
        getBinding().e.c.setText(R.string.status_invisible_helper);
        ViewUserStatusPresenceBinding viewUserStatusPresenceBinding4 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(viewUserStatusPresenceBinding4, "binding.userStatusUpdateInvisible");
        viewUserStatusPresenceBinding4.a.setOnClickListener(new AnonymousClass4());
        getBinding().f2698b.setOnClickListener(new AnonymousClass5());
        getBinding().f2698b.setOnClear(new AnonymousClass6());
    }
}
