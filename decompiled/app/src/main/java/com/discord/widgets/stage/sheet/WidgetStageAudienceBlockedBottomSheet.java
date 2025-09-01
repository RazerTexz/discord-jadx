package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageAudienceBlockedBottomSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.stage.StageChannelJoinHelper;
import com.discord.widgets.stage.sheet.StageAudienceBlockedBottomSheetViewModel;
import d0.LazyJVM;
import d0.Tuples;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b+\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u00020\u001e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010*\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageAudienceBlockedBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState;)V", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "Lcom/discord/databinding/WidgetStageAudienceBlockedBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetStageAudienceBlockedBottomSheetBinding;", "binding", "", "launchStageFullScreen$delegate", "Lkotlin/Lazy;", "getLaunchStageFullScreen", "()Z", "launchStageFullScreen", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel;", "viewModel", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter;", "adapter", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter;", "", "channelId$delegate", "getChannelId", "()J", "channelId", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetStageAudienceBlockedBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStageAudienceBlockedBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageAudienceBlockedBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_LAUNCH_FULL_SCREEN = "LAUNCH_FULL_SCREEN";
    private StageAudienceBlockedBottomSheetAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: launchStageFullScreen$delegate, reason: from kotlin metadata */
    private final Lazy launchStageFullScreen;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageAudienceBlockedBottomSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "launchStageFullScreen", "", "show", "(Landroidx/fragment/app/FragmentManager;JZ)V", "", "EXTRA_LAUNCH_FULL_SCREEN", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId, boolean launchStageFullScreen) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet = new WidgetStageAudienceBlockedBottomSheet();
            widgetStageAudienceBlockedBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId)), Tuples.to(WidgetStageAudienceBlockedBottomSheet.EXTRA_LAUNCH_FULL_SCREEN, Boolean.valueOf(launchStageFullScreen))));
            widgetStageAudienceBlockedBottomSheet.show(fragmentManager, WidgetStageAudienceBlockedBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ StageAudienceBlockedBottomSheetViewModel.ViewState $viewState;

        /* compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03431 extends Lambda implements Function0<Unit> {
            public C03431() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetStageAudienceBlockedBottomSheet.this.dismiss();
            }
        }

        public AnonymousClass1(StageAudienceBlockedBottomSheetViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StageChannelJoinHelper stageChannelJoinHelper = StageChannelJoinHelper.INSTANCE;
            Context contextRequireContext = WidgetStageAudienceBlockedBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            FragmentManager parentFragmentManager = WidgetStageAudienceBlockedBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            StageChannelJoinHelper.connectToStage$default(stageChannelJoinHelper, contextRequireContext, parentFragmentManager, ((StageAudienceBlockedBottomSheetViewModel.ViewState.Loaded) this.$viewState).getChannel().getId(), true, WidgetStageAudienceBlockedBottomSheet.access$getLaunchStageFullScreen$p(WidgetStageAudienceBlockedBottomSheet.this), null, null, null, null, new C03431(), 480, null);
        }
    }

    /* compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetStageAudienceBlockedBottomSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StageAudienceBlockedBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
            super(1, widgetStageAudienceBlockedBottomSheet, WidgetStageAudienceBlockedBottomSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageAudienceBlockedBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageAudienceBlockedBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetStageAudienceBlockedBottomSheet.access$configureUI((WidgetStageAudienceBlockedBottomSheet) this.receiver, viewState);
        }
    }

    public WidgetStageAudienceBlockedBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStageAudienceBlockedBottomSheet2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetStageAudienceBlockedBottomSheet3(this));
        this.launchStageFullScreen = LazyJVM.lazy(new WidgetStageAudienceBlockedBottomSheet4(this));
        WidgetStageAudienceBlockedBottomSheet5 widgetStageAudienceBlockedBottomSheet5 = new WidgetStageAudienceBlockedBottomSheet5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(StageAudienceBlockedBottomSheetViewModel.class), new WidgetStageAudienceBlockedBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetStageAudienceBlockedBottomSheet5));
    }

    public static final /* synthetic */ void access$configureUI(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet, StageAudienceBlockedBottomSheetViewModel.ViewState viewState) {
        widgetStageAudienceBlockedBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
        return widgetStageAudienceBlockedBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
        return widgetStageAudienceBlockedBottomSheet.getChannelId();
    }

    public static final /* synthetic */ boolean access$getLaunchStageFullScreen$p(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
        return widgetStageAudienceBlockedBottomSheet.getLaunchStageFullScreen();
    }

    private final void configureUI(StageAudienceBlockedBottomSheetViewModel.ViewState viewState) {
        if (viewState instanceof StageAudienceBlockedBottomSheetViewModel.ViewState.Invalid) {
            dismiss();
            return;
        }
        if (!(viewState instanceof StageAudienceBlockedBottomSheetViewModel.ViewState.Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        getBinding().f2647b.setOnClickListener(new AnonymousClass1(viewState));
        getBinding().d.setOnClickListener(new AnonymousClass2());
        StageAudienceBlockedBottomSheetAdapter stageAudienceBlockedBottomSheetAdapter = this.adapter;
        if (stageAudienceBlockedBottomSheetAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        stageAudienceBlockedBottomSheetAdapter.setData(((StageAudienceBlockedBottomSheetViewModel.ViewState.Loaded) viewState).getListItems());
    }

    private final WidgetStageAudienceBlockedBottomSheetBinding getBinding() {
        return (WidgetStageAudienceBlockedBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final boolean getLaunchStageFullScreen() {
        return ((Boolean) this.launchStageFullScreen.getValue()).booleanValue();
    }

    private final StageAudienceBlockedBottomSheetViewModel getViewModel() {
        return (StageAudienceBlockedBottomSheetViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_stage_audience_blocked_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetStageAudienceBlockedBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        WidgetStageAudienceBlockedBottomSheetBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        setPeekHeightBottomView(binding.a);
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.blockedUsers");
        this.adapter = new StageAudienceBlockedBottomSheetAdapter(maxHeightRecyclerView);
    }
}
