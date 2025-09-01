package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierReviewBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanSetupViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierAdapter;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierItemDecoration;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionReviewViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import d0.LazyJVM;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildRoleSubscriptionReview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b6\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u000eR\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010!\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010 R!\u0010'\u001a\u00060\"j\u0002`#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020(8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001d\u0010/\u001a\u00020+8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010.R\u001d\u00105\u001a\u0002008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/WidgetGuildRoleSubscriptionReview;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;", "viewState", "", "updateTier", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;)V", "Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$ViewState;", "updatePlanDetails", "(Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$ViewState;)V", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionReviewViewModel$ViewState;", "configureUI", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionReviewViewModel$ViewState;)V", "setupRecyclerView", "()V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel;", "viewModel", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapter;", "adapter", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapter;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionReviewViewModel;", "reviewViewModel$delegate", "getReviewViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionReviewViewModel;", "reviewViewModel", "", "Lcom/discord/primitives/GuildId;", "guildId$delegate", "getGuildId", "()J", "guildId", "", "isPlanReviewMode", "()Z", "Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel;", "planSetupViewModel$delegate", "getPlanSetupViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel;", "planSetupViewModel", "Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierReviewBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierReviewBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionReview extends AppFragment {
    public static final String ARG_IS_SUBSCRIPTION_GROUP_PLAN_REVIEW_MODE = "ARG_IS_SUBSCRIPTION_GROUP_PLAN_REVIEW_MODE";
    private GuildRoleSubscriptionTierAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: planSetupViewModel$delegate, reason: from kotlin metadata */
    private final Lazy planSetupViewModel;

    /* renamed from: reviewViewModel$delegate, reason: from kotlin metadata */
    private final Lazy reviewViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildRoleSubscriptionReview.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierReviewBinding;", 0)};

    /* compiled from: WidgetGuildRoleSubscriptionReview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionReview.access$updateTier(WidgetGuildRoleSubscriptionReview.this, viewState);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionReview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionReviewViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionReviewViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildRoleSubscriptionReviewViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionReviewViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionReviewViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionReview.access$configureUI(WidgetGuildRoleSubscriptionReview.this, viewState);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionReview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<GuildRoleSubscriptionPlanSetupViewModel.ViewState, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionReview.access$updatePlanDetails(WidgetGuildRoleSubscriptionReview.this, viewState);
        }
    }

    public WidgetGuildRoleSubscriptionReview() {
        super(R.layout.widget_guild_role_subscription_tier_review);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionReview2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetGuildRoleSubscriptionReview3(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetGuildRoleSubscriptionReview$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionReview6.INSTANCE));
        WidgetGuildRoleSubscriptionReview5 widgetGuildRoleSubscriptionReview5 = new WidgetGuildRoleSubscriptionReview5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.reviewViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionReviewViewModel.class), new WidgetGuildRoleSubscriptionReview$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildRoleSubscriptionReview5));
        this.planSetupViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionPlanSetupViewModel.class), new WidgetGuildRoleSubscriptionReview$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(new WidgetGuildRoleSubscriptionReview4(this)));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionReview widgetGuildRoleSubscriptionReview, GuildRoleSubscriptionReviewViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionReview.configureUI(viewState);
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildRoleSubscriptionReview widgetGuildRoleSubscriptionReview) {
        return widgetGuildRoleSubscriptionReview.getGuildId();
    }

    public static final /* synthetic */ void access$updatePlanDetails(WidgetGuildRoleSubscriptionReview widgetGuildRoleSubscriptionReview, GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionReview.updatePlanDetails(viewState);
    }

    public static final /* synthetic */ void access$updateTier(WidgetGuildRoleSubscriptionReview widgetGuildRoleSubscriptionReview, GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionReview.updateTier(viewState);
    }

    private final void configureUI(GuildRoleSubscriptionReviewViewModel.ViewState viewState) {
        GuildRoleSubscriptionTierAdapter guildRoleSubscriptionTierAdapter = this.adapter;
        if (guildRoleSubscriptionTierAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        guildRoleSubscriptionTierAdapter.setItems(viewState.getItems());
    }

    private final WidgetGuildRoleSubscriptionTierReviewBinding getBinding() {
        return (WidgetGuildRoleSubscriptionTierReviewBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildRoleSubscriptionPlanSetupViewModel getPlanSetupViewModel() {
        return (GuildRoleSubscriptionPlanSetupViewModel) this.planSetupViewModel.getValue();
    }

    private final GuildRoleSubscriptionReviewViewModel getReviewViewModel() {
        return (GuildRoleSubscriptionReviewViewModel) this.reviewViewModel.getValue();
    }

    private final GuildRoleSubscriptionTierViewModel getViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.viewModel.getValue();
    }

    private final boolean isPlanReviewMode() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getBoolean(ARG_IS_SUBSCRIPTION_GROUP_PLAN_REVIEW_MODE, false);
        }
        return false;
    }

    private final void setupRecyclerView() throws Resources.NotFoundException {
        this.adapter = new GuildRoleSubscriptionTierAdapter(this, null, 2, null);
        GuildRoleSubscriptionTierItemDecoration guildRoleSubscriptionTierItemDecoration = new GuildRoleSubscriptionTierItemDecoration(DimenUtils.dpToPixels(8), getResources().getDimensionPixelSize(R.dimen.guild_role_subscription_setup_default_padding));
        RecyclerView recyclerView = getBinding().f2441b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "this");
        GuildRoleSubscriptionTierAdapter guildRoleSubscriptionTierAdapter = this.adapter;
        if (guildRoleSubscriptionTierAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setLayoutManager(new SelfHealingLinearLayoutManager(recyclerView, guildRoleSubscriptionTierAdapter, 0, false, 12, null));
        GuildRoleSubscriptionTierAdapter guildRoleSubscriptionTierAdapter2 = this.adapter;
        if (guildRoleSubscriptionTierAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(guildRoleSubscriptionTierAdapter2);
        recyclerView.addItemDecoration(guildRoleSubscriptionTierItemDecoration);
    }

    private final void updatePlanDetails(GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
        String planDescription = viewState.getPlanDescription();
        if (planDescription == null || StringsJVM.isBlank(planDescription)) {
            return;
        }
        String coverImage = viewState.getCoverImage();
        if (coverImage == null || StringsJVM.isBlank(coverImage)) {
            return;
        }
        getReviewViewModel().updatePlanDetails(viewState.getPlanDescription(), viewState.getCoverImage());
    }

    private final void updateTier(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        String name = viewState.getGuildRoleSubscriptionTier().getName();
        if ((name == null || StringsJVM.isBlank(name)) || viewState.getGuildRoleSubscriptionTier().getMemberColor() == null || viewState.getGuildRoleSubscriptionTier().getPriceTier() == null) {
            return;
        }
        getReviewViewModel().updateTier(viewState.getGuildRoleSubscriptionTier(), viewState.isFullServerGating());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setupRecyclerView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionReview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getReviewViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionReview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        if (isPlanReviewMode()) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getPlanSetupViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionReview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
        }
    }
}
