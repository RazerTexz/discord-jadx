package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.y.DividerDecoration2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetPriceTierPickerBottomSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.PriceTierPickerBottomSheetViewModel;
import d0.Tuples;
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
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetPriceTierPickerBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001f\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/WidgetPriceTierPickerBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState;)V", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lrx/subscriptions/CompositeSubscription;", "compositeSubscription", "bindSubscriptions", "(Lrx/subscriptions/CompositeSubscription;)V", "Lcom/discord/databinding/WidgetPriceTierPickerBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetPriceTierPickerBottomSheetBinding;", "binding", "Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel;", "viewModel", "Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerAdapter;", "adapter", "Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerAdapter;", "Lkotlin/Function1;", "itemClickListener", "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetPriceTierPickerBottomSheet extends AppBottomSheet {
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final int PRICE_TIER_PICKER_VIEW_FLIPPER_LOADING_STATE = 0;
    private static final int PRICE_TIER_PICKER_VIEW_FLIPPER_RESULT = 1;
    private static final String RESULT_EXTRA_PRICE_TIER = "RESULT_EXTRA_PRICE_TIER";
    private WidgetPriceTierPickerBottomSheet2 adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Function1<Integer, Unit> itemClickListener;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetPriceTierPickerBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPriceTierPickerBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetPriceTierPickerBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/WidgetPriceTierPickerBottomSheet$Companion;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "requestKey", "Lkotlin/Function1;", "", "", "onPriceTierSelected", "registerForResult", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "launch", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "ARG_REQUEST_KEY", "Ljava/lang/String;", "PRICE_TIER_PICKER_VIEW_FLIPPER_LOADING_STATE", "I", "PRICE_TIER_PICKER_VIEW_FLIPPER_RESULT", WidgetPriceTierPickerBottomSheet.RESULT_EXTRA_PRICE_TIER, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Fragment fragment, String requestKey) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet = new WidgetPriceTierPickerBottomSheet();
            widgetPriceTierPickerBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to(WidgetPriceTierPickerBottomSheet.ARG_REQUEST_KEY, requestKey)));
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetPriceTierPickerBottomSheet.show(parentFragmentManager, WidgetPriceTierPickerBottomSheet.class.getName());
        }

        public final void registerForResult(Fragment fragment, String requestKey, Function1<? super Integer, Unit> onPriceTierSelected) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onPriceTierSelected, "onPriceTierSelected");
            Fragment2.setFragmentResultListener(fragment, requestKey, new WidgetPriceTierPickerBottomSheet4(requestKey, onPriceTierSelected));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetPriceTierPickerBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.WidgetPriceTierPickerBottomSheet$bindSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<PriceTierPickerBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PriceTierPickerBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PriceTierPickerBottomSheetViewModel.ViewState viewState) {
            WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet = WidgetPriceTierPickerBottomSheet.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetPriceTierPickerBottomSheet.access$configureUI(widgetPriceTierPickerBottomSheet, viewState);
        }
    }

    public WidgetPriceTierPickerBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetPriceTierPickerBottomSheet5.INSTANCE, null, 2, null);
        WidgetPriceTierPickerBottomSheet7 widgetPriceTierPickerBottomSheet7 = WidgetPriceTierPickerBottomSheet7.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(PriceTierPickerBottomSheetViewModel.class), new WidgetPriceTierPickerBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetPriceTierPickerBottomSheet7));
        this.itemClickListener = new WidgetPriceTierPickerBottomSheet6(this);
    }

    public static final /* synthetic */ void access$configureUI(WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet, PriceTierPickerBottomSheetViewModel.ViewState viewState) {
        widgetPriceTierPickerBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet) {
        return widgetPriceTierPickerBottomSheet.getArgumentsOrDefault();
    }

    private final void configureUI(PriceTierPickerBottomSheetViewModel.ViewState viewState) {
        if (viewState instanceof PriceTierPickerBottomSheetViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f2513b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.priceTierPickerAppFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else {
            if (!(viewState instanceof PriceTierPickerBottomSheetViewModel.ViewState.Loaded)) {
                if (viewState instanceof PriceTierPickerBottomSheetViewModel.ViewState.Failed) {
                    AppToast.g(requireContext(), R.string.default_failure_to_perform_action_message, 0, null, 12);
                    dismiss();
                    return;
                }
                return;
            }
            AppViewFlipper appViewFlipper2 = getBinding().f2513b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.priceTierPickerAppFlipper");
            appViewFlipper2.setDisplayedChild(1);
            WidgetPriceTierPickerBottomSheet2 widgetPriceTierPickerBottomSheet2 = this.adapter;
            if (widgetPriceTierPickerBottomSheet2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            widgetPriceTierPickerBottomSheet2.setItems(((PriceTierPickerBottomSheetViewModel.ViewState.Loaded) viewState).getPriceTiers());
        }
    }

    private final WidgetPriceTierPickerBottomSheetBinding getBinding() {
        return (WidgetPriceTierPickerBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final PriceTierPickerBottomSheetViewModel getViewModel() {
        return (PriceTierPickerBottomSheetViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        Observable<PriceTierPickerBottomSheetViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetPriceTierPickerBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_price_tier_picker_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.adapter = new WidgetPriceTierPickerBottomSheet2(this.itemClickListener);
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.priceTierPickerRecycler");
        WidgetPriceTierPickerBottomSheet2 widgetPriceTierPickerBottomSheet2 = this.adapter;
        if (widgetPriceTierPickerBottomSheet2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(widgetPriceTierPickerBottomSheet2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.guild_role_subscription_setup_default_padding);
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        getBinding().c.addItemDecoration(new DividerDecoration2(contextRequireContext, 1, 0, dimensionPixelSize, dimensionPixelSize, 4));
    }
}
