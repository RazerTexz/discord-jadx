package com.discord.widgets.mobile_reports;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.report.NodeElementResult;
import com.discord.api.report.ReportNodeChild;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetMobileReportsBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.mobile_reports.MobileReportsViewModel;
import com.discord.widgets.mobile_reports.WidgetMobileReports2;
import d0.LazyJVM;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetMobileReports.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b!\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/discord/widgets/mobile_reports/WidgetMobileReports;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ViewState$Menu;", "viewState", "Lcom/discord/widgets/mobile_reports/ReportsMenuNode;", "createNodeView", "(Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ViewState$Menu;)Lcom/discord/widgets/mobile_reports/ReportsMenuNode;", "", "configureUI", "(Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ViewState$Menu;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/widgets/mobile_reports/MobileReportArgs;", "args$delegate", "Lkotlin/Lazy;", "getArgs", "()Lcom/discord/widgets/mobile_reports/MobileReportArgs;", "args", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel;", "viewModel", "Lcom/discord/databinding/WidgetMobileReportsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetMobileReportsBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetMobileReports extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetMobileReports.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMobileReportsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetMobileReports.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\b\u001a\u00060\u0004j\u0002`\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0004j\u0002`\u0007¢\u0006\u0004\b\f\u0010\rJ9\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u000f\u001a\u00060\u0004j\u0002`\u000e2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u000e2\n\u0010\b\u001a\u00060\u0004j\u0002`\u0007¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u000f\u001a\u00060\u0004j\u0002`\u000e2\n\u0010\u0014\u001a\u00060\u0004j\u0002`\u0013¢\u0006\u0004\b\u0015\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/mobile_reports/WidgetMobileReports$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/MessageId;", "messageId", "Lcom/discord/primitives/ChannelId;", "channelId", "", "launchMessageReport", "(Landroid/content/Context;JJ)V", "launchStageChannelReport", "(Landroid/content/Context;J)V", "Lcom/discord/primitives/GuildId;", "guildId", "hubId", "launchDirectoryServerReport", "(Landroid/content/Context;JJJ)V", "Lcom/discord/primitives/GuildScheduledEventId;", "eventId", "launchGuildScheduledEventReport", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launchDirectoryServerReport(Context context, long guildId, long hubId, long channelId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetMobileReports.class, new WidgetMobileReports2.DirectoryServer(guildId, hubId, channelId));
        }

        public final void launchGuildScheduledEventReport(Context context, long guildId, long eventId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetMobileReports.class, new WidgetMobileReports2.GuildScheduledEvent(guildId, eventId));
        }

        public final void launchMessageReport(Context context, long messageId, long channelId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetMobileReports.class, new WidgetMobileReports2.Message(messageId, channelId));
        }

        public final void launchStageChannelReport(Context context, long channelId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetMobileReports.class, new WidgetMobileReports2.StageChannel(channelId));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MobileReportsViewModel.ViewState.Menu $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MobileReportsViewModel.ViewState.Menu menu) {
            super(0);
            this.$viewState = menu;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetMobileReports.this.setActionBarDisplayHomeAsUpEnabled(!this.$viewState.shouldHideBackArrow());
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ReportsMenuNode $nextNodeView;
        public final /* synthetic */ MobileReportsViewModel.ViewState.Menu $viewState;

        /* compiled from: WidgetMobileReports.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$configureUI$2$1, reason: invalid class name */
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
                WidgetMobileReports.this.setActionBarDisplayHomeAsUpEnabled(!r0.$viewState.shouldHideBackArrow());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ReportsMenuNode reportsMenuNode, MobileReportsViewModel.ViewState.Menu menu) {
            super(0);
            this.$nextNodeView = reportsMenuNode;
            this.$viewState = menu;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetMobileReports.access$getBinding$p(WidgetMobileReports.this).f2496b.removeAllViewsInLayout();
            WidgetMobileReports.access$getBinding$p(WidgetMobileReports.this).f2496b.addView(this.$nextNodeView);
            ViewExtensions.fadeIn$default(this.$nextNodeView, 0L, null, null, new AnonymousClass1(), 7, null);
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/report/ReportNodeChild;", "destination", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeState;", "nodeState", "", "invoke", "(Lcom/discord/api/report/ReportNodeChild;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$createNodeView$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<ReportNodeChild, MobileReportsViewModel.NodeState, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(ReportNodeChild reportNodeChild, MobileReportsViewModel.NodeState nodeState) {
            invoke2(reportNodeChild, nodeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ReportNodeChild reportNodeChild, MobileReportsViewModel.NodeState nodeState) {
            Intrinsics3.checkNotNullParameter(reportNodeChild, "destination");
            Intrinsics3.checkNotNullParameter(nodeState, "nodeState");
            MobileReportsViewModel mobileReportsViewModelAccess$getViewModel$p = WidgetMobileReports.access$getViewModel$p(WidgetMobileReports.this);
            MobileReportsViewModel.CheckboxElement checkboxElement = nodeState.getCheckboxElement();
            mobileReportsViewModelAccess$getViewModel$p.handleNext(reportNodeChild, checkboxElement != null ? new NodeElementResult(checkboxElement.getName(), _Collections.toList(checkboxElement.getSelections())) : null);
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$createNodeView$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetMobileReports.access$getViewModel$p(WidgetMobileReports.this).handleBlockUser();
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$createNodeView$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppActivity appActivity = WidgetMobileReports.this.getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$createNodeView$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetMobileReports.access$getViewModel$p(WidgetMobileReports.this).handleSubmit();
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$onViewBound$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Boolean> {
        public AnonymousClass1(MobileReportsViewModel mobileReportsViewModel) {
            super(0, mobileReportsViewModel, MobileReportsViewModel.class, "handleBack", "handleBack()Z", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return ((MobileReportsViewModel) this.receiver).handleBack();
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<MobileReportsViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MobileReportsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MobileReportsViewModel.ViewState viewState) {
            AppActivity appActivity;
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            if (viewState instanceof MobileReportsViewModel.ViewState.Menu) {
                WidgetMobileReports.access$configureUI(WidgetMobileReports.this, (MobileReportsViewModel.ViewState.Menu) viewState);
            } else {
                if (!(viewState instanceof MobileReportsViewModel.ViewState.Invalid) || (appActivity = WidgetMobileReports.this.getAppActivity()) == null) {
                    return;
                }
                appActivity.finish();
            }
        }
    }

    public WidgetMobileReports() {
        super(R.layout.widget_mobile_reports);
        this.args = LazyJVM.lazy(new WidgetMobileReports$$special$$inlined$args$1(this, "intent_args_key"));
        WidgetMobileReports5 widgetMobileReports5 = new WidgetMobileReports5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(MobileReportsViewModel.class), new WidgetMobileReports$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetMobileReports5));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetMobileReports3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetMobileReports widgetMobileReports, MobileReportsViewModel.ViewState.Menu menu) {
        widgetMobileReports.configureUI(menu);
    }

    public static final /* synthetic */ WidgetMobileReports2 access$getArgs$p(WidgetMobileReports widgetMobileReports) {
        return widgetMobileReports.getArgs();
    }

    public static final /* synthetic */ WidgetMobileReportsBinding access$getBinding$p(WidgetMobileReports widgetMobileReports) {
        return widgetMobileReports.getBinding();
    }

    public static final /* synthetic */ MobileReportsViewModel access$getViewModel$p(WidgetMobileReports widgetMobileReports) {
        return widgetMobileReports.getViewModel();
    }

    private final void configureUI(MobileReportsViewModel.ViewState.Menu viewState) {
        setActionBarDisplayHomeAsUpEnabled(!viewState.shouldHideBackArrow());
        ProgressBar progressBar = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.mobileReportsProgressBar");
        progressBar.setVisibility(8);
        ReportsMenuNode reportsMenuNode = (ReportsMenuNode) getBinding().f2496b.getChildAt(0);
        MobileReportsViewModel.NodeState nodeStateGenNodeState = viewState.genNodeState();
        if (reportsMenuNode == null) {
            ReportsMenuNode reportsMenuNodeCreateNodeView = createNodeView(viewState);
            reportsMenuNodeCreateNodeView.setVisibility(8);
            getBinding().f2496b.addView(reportsMenuNodeCreateNodeView);
            ViewExtensions.fadeIn$default(reportsMenuNodeCreateNodeView, 0L, null, null, new AnonymousClass1(viewState), 7, null);
            return;
        }
        if (!(!Intrinsics3.areEqual(reportsMenuNode.getPrevViewState() != null ? r3.getNode() : null, nodeStateGenNodeState.getNode()))) {
            reportsMenuNode.setup(nodeStateGenNodeState);
            setActionBarDisplayHomeAsUpEnabled(!viewState.shouldHideBackArrow());
        } else {
            ReportsMenuNode reportsMenuNodeCreateNodeView2 = createNodeView(viewState);
            reportsMenuNodeCreateNodeView2.setVisibility(8);
            ViewExtensions.fadeOut$default(reportsMenuNode, 0L, null, new AnonymousClass2(reportsMenuNodeCreateNodeView2, viewState), 3, null);
        }
    }

    private final ReportsMenuNode createNodeView(MobileReportsViewModel.ViewState.Menu viewState) {
        ReportsMenuNode reportsMenuNode = new ReportsMenuNode(requireContext());
        reportsMenuNode.setHandleSelectChild(new AnonymousClass1());
        reportsMenuNode.setHandleBlock(new AnonymousClass2());
        reportsMenuNode.setHandleCancel(new AnonymousClass3());
        reportsMenuNode.setHandleSubmit(new AnonymousClass4());
        reportsMenuNode.setup(viewState.genNodeState());
        return reportsMenuNode;
    }

    private final WidgetMobileReports2 getArgs() {
        return (WidgetMobileReports2) this.args.getValue();
    }

    private final WidgetMobileReportsBinding getBinding() {
        return (WidgetMobileReportsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final MobileReportsViewModel getViewModel() {
        return (MobileReportsViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(false);
        AppFragment.setOnBackPressed$default(this, new WidgetMobileReports4(new AnonymousClass1(getViewModel())), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetMobileReports.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
