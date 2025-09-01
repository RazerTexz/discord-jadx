package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetEnableCommunityStepsBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.steps.StepsView;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import d0.LazyJVM;
import d0.t.Collections2;
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
import rx.Observable;
import rx.functions.Func0;

/* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001f\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR!\u0010\u0013\u001a\u00060\rj\u0002`\u000e8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunitySteps;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "", "Lcom/discord/primitives/GuildId;", "guildId$delegate", "Lkotlin/Lazy;", "getGuildId", "()J", "guildId", "Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel;", "viewModel", "Lcom/discord/databinding/WidgetEnableCommunityStepsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetEnableCommunityStepsBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunitySteps extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsEnableCommunitySteps.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableCommunityStepsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunitySteps$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "create", "(Landroid/content/Context;J)V", "", "INTENT_EXTRA_GUILD_ID", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsEnableCommunitySteps.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBound$1, reason: invalid class name */
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
            FragmentActivity activity = WidgetServerSettingsEnableCommunitySteps.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBound$2, reason: invalid class name */
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
            WidgetServerSettingsEnableCommunitySteps.access$getViewModel$p(WidgetServerSettingsEnableCommunitySteps.this).updateCurrentPage(i);
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3<R> implements Func0<Boolean> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetServerSettingsEnableCommunitySteps.access$getViewModel$p(WidgetServerSettingsEnableCommunitySteps.this).goBackToPreviousPage();
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
            super(1, widgetServerSettingsEnableCommunitySteps, WidgetServerSettingsEnableCommunitySteps.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetServerSettingsEnableCommunitySteps.access$configureUI((WidgetServerSettingsEnableCommunitySteps) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;", "it", "", "invoke", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "it");
            int currentPage = loaded.getCurrentPage();
            if (currentPage < 0) {
                WidgetServerSettingsEnableCommunitySteps.this.requireActivity().finish();
            } else {
                WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(WidgetServerSettingsEnableCommunitySteps.this).f2378b.b(currentPage);
            }
            WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(WidgetServerSettingsEnableCommunitySteps.this).f2378b.setIsNextButtonEnabled(loaded.getCommunityGuildConfig().getExplicitContentFilter() && loaded.getCommunityGuildConfig().getVerificationLevel());
            WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(WidgetServerSettingsEnableCommunitySteps.this).f2378b.setIsDoneButtonEnabled(loaded.getCommunityGuildConfig().isPrivacyPolicyAccepted());
            WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(WidgetServerSettingsEnableCommunitySteps.this).f2378b.setIsLoading(loaded.isLoading());
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$Event;", "event", "", "invoke", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.Event, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            if (!Intrinsics3.areEqual(event, WidgetServerSettingsEnableCommunityViewModel.Event.SaveSuccess.INSTANCE)) {
                if (Intrinsics3.areEqual(event, WidgetServerSettingsEnableCommunityViewModel.Event.Error.INSTANCE)) {
                    AppToast.i(WidgetServerSettingsEnableCommunitySteps.this, R.string.guild_settings_public_update_failed, 0, 4);
                }
            } else {
                WidgetServerSettingsEnableCommunitySteps.this.requireActivity().finish();
                WidgetServerSettingsCommunityOverview.Companion companion = WidgetServerSettingsCommunityOverview.INSTANCE;
                FragmentActivity fragmentActivityRequireActivity = WidgetServerSettingsEnableCommunitySteps.this.requireActivity();
                Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                companion.create(fragmentActivityRequireActivity, WidgetServerSettingsEnableCommunitySteps.this.getGuildId());
            }
        }
    }

    public WidgetServerSettingsEnableCommunitySteps() {
        super(R.layout.widget_enable_community_steps);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEnableCommunitySteps2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new WidgetServerSettingsEnableCommunitySteps$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetServerSettingsEnableCommunitySteps5(this)));
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsEnableCommunitySteps3(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps, WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
        widgetServerSettingsEnableCommunitySteps.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetEnableCommunityStepsBinding access$getBinding$p(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
        return widgetServerSettingsEnableCommunitySteps.getBinding();
    }

    public static final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel access$getViewModel$p(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
        return widgetServerSettingsEnableCommunitySteps.getViewModel();
    }

    private final void configureUI(WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, WidgetServerSettingsEnableCommunityViewModel.ViewState.Invalid.INSTANCE)) {
            requireActivity().finish();
        }
    }

    private final WidgetEnableCommunityStepsBinding getBinding() {
        return (WidgetEnableCommunityStepsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsEnableCommunityViewModel getViewModel() {
        return (WidgetServerSettingsEnableCommunityViewModel) this.viewModel.getValue();
    }

    public final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f2378b.a(new StepsView.d(this, Collections2.listOf((Object[]) new StepsView.b.a[]{new StepsView.b.a(WidgetServerSettingsEnableCommunity.class, 0, 0, 0, null, null, null, null, false, false, false, 254), new StepsView.b.a(WidgetServerSettingsCommunityFirstStep.class, 0, 0, 0, null, null, null, null, false, false, false, 510), new StepsView.b.a(WidgetServerSettingsCommunitySecondStep.class, 0, 0, 0, null, null, null, null, false, false, false, 510), new StepsView.b.a(WidgetServerSettingsCommunityThirdStep.class, 0, 0, R.string.enable_community_button_text, null, null, null, new WidgetServerSettingsEnableCommunitySteps4(this), false, false, false, 374)})), new AnonymousClass1(), new AnonymousClass2());
        AppFragment.setOnBackPressed$default(this, new AnonymousClass3(), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetServerSettingsEnableCommunityViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsEnableCommunitySteps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        Observable observableG = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).y(WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).G(WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(observableG, WidgetServerSettingsEnableCommunitySteps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetServerSettingsEnableCommunitySteps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }
}
