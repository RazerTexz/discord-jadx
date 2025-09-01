package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates2;
import b.a.y.p0.StepsView2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetCreateGuildRoleSubscriptionTierBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.steps.StepsView;
import com.discord.widgets.guild_role_subscriptions.tier.create.CreateGuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitListType;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits;
import d0.LazyJVM;
import d0.Tuples;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Func0;

/* compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b-\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001f\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010$\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010#R\u001d\u0010'\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u001d\u0010,\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/WidgetCreateGuildRoleSubscriptionTier;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;", "viewState", "", "updateCreateTierViewModel", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;)V", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$ViewState;", "configureUI", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$ViewState;)V", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "", "groupListingId$delegate", "Lkotlin/Lazy;", "getGroupListingId", "()J", "groupListingId", "Lcom/discord/databinding/WidgetCreateGuildRoleSubscriptionTierBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetCreateGuildRoleSubscriptionTierBinding;", "binding", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel;", "viewModel", "guildId$delegate", "getGuildId", "guildId", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel;", "createTierViewModel$delegate", "getCreateTierViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel;", "createTierViewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetCreateGuildRoleSubscriptionTier extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetCreateGuildRoleSubscriptionTier.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreateGuildRoleSubscriptionTierBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GROUP_LISTING_ID = "INTENT_EXTRA_GROUP_LISTING_ID";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: createTierViewModel$delegate, reason: from kotlin metadata */
    private final Lazy createTierViewModel;

    /* renamed from: groupListingId$delegate, reason: from kotlin metadata */
    private final Lazy groupListingId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/WidgetCreateGuildRoleSubscriptionTier$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "groupListingId", "", "launch", "(Landroid/content/Context;JJ)V", "", WidgetCreateGuildRoleSubscriptionTier.INTENT_EXTRA_GROUP_LISTING_ID, "Ljava/lang/String;", "INTENT_EXTRA_GUILD_ID", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId, long groupListingId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetCreateGuildRoleSubscriptionTier.INTENT_EXTRA_GROUP_LISTING_ID, groupListingId);
            AppScreen2.d(context, WidgetCreateGuildRoleSubscriptionTier.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2<R> implements Func0<Boolean> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetCreateGuildRoleSubscriptionTier.access$getCreateTierViewModel$p(WidgetCreateGuildRoleSubscriptionTier.this).goToPreviousStep();
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;", "kotlin.jvm.PlatformType", "viewState", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$1, reason: invalid class name */
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
            WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier = WidgetCreateGuildRoleSubscriptionTier.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            WidgetCreateGuildRoleSubscriptionTier.access$updateCreateTierViewModel(widgetCreateGuildRoleSubscriptionTier, viewState);
        }
    }

    /* compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$ViewState;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<CreateGuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CreateGuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CreateGuildRoleSubscriptionTierViewModel.ViewState viewState) {
            WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier = WidgetCreateGuildRoleSubscriptionTier.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetCreateGuildRoleSubscriptionTier.access$configureUI(widgetCreateGuildRoleSubscriptionTier, viewState);
        }
    }

    /* compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<CreateGuildRoleSubscriptionTierViewModel.Event, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CreateGuildRoleSubscriptionTierViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CreateGuildRoleSubscriptionTierViewModel.Event event) {
            WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier = WidgetCreateGuildRoleSubscriptionTier.this;
            Intrinsics3.checkNotNullExpressionValue(event, "it");
            WidgetCreateGuildRoleSubscriptionTier.access$handleEvent(widgetCreateGuildRoleSubscriptionTier, event);
        }
    }

    public WidgetCreateGuildRoleSubscriptionTier() {
        super(R.layout.widget_create_guild_role_subscription_tier);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCreateGuildRoleSubscriptionTier$binding$2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetCreateGuildRoleSubscriptionTier$guildId$2(this));
        this.groupListingId = LazyJVM.lazy(new WidgetCreateGuildRoleSubscriptionTier$groupListingId$2(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetCreateGuildRoleSubscriptionTier$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetCreateGuildRoleSubscriptionTier$viewModel$2.INSTANCE));
        this.createTierViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(CreateGuildRoleSubscriptionTierViewModel.class), new WidgetCreateGuildRoleSubscriptionTier$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(new WidgetCreateGuildRoleSubscriptionTier$createTierViewModel$2(this)));
    }

    public static final /* synthetic */ void access$configureUI(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier, CreateGuildRoleSubscriptionTierViewModel.ViewState viewState) {
        widgetCreateGuildRoleSubscriptionTier.configureUI(viewState);
    }

    public static final /* synthetic */ CreateGuildRoleSubscriptionTierViewModel access$getCreateTierViewModel$p(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier) {
        return widgetCreateGuildRoleSubscriptionTier.getCreateTierViewModel();
    }

    public static final /* synthetic */ long access$getGroupListingId$p(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier) {
        return widgetCreateGuildRoleSubscriptionTier.getGroupListingId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier) {
        return widgetCreateGuildRoleSubscriptionTier.getGuildId();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier, CreateGuildRoleSubscriptionTierViewModel.Event event) {
        widgetCreateGuildRoleSubscriptionTier.handleEvent(event);
    }

    public static final /* synthetic */ void access$updateCreateTierViewModel(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier, GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        widgetCreateGuildRoleSubscriptionTier.updateCreateTierViewModel(viewState);
    }

    private final void configureUI(CreateGuildRoleSubscriptionTierViewModel.ViewState viewState) {
        int currentStep = viewState.getCurrentStep();
        if (currentStep < 0) {
            requireActivity().finish();
            return;
        }
        getBinding().f2359b.b(currentStep);
        getBinding().f2359b.setIsNextButtonEnabled(viewState.getCanProceed());
        getBinding().f2359b.setIsDoneButtonEnabled(!viewState.isSubmitting());
        getBinding().f2359b.setIsLoading(viewState.isSubmitting());
    }

    private final WidgetCreateGuildRoleSubscriptionTierBinding getBinding() {
        return (WidgetCreateGuildRoleSubscriptionTierBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CreateGuildRoleSubscriptionTierViewModel getCreateTierViewModel() {
        return (CreateGuildRoleSubscriptionTierViewModel) this.createTierViewModel.getValue();
    }

    private final long getGroupListingId() {
        return ((Number) this.groupListingId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildRoleSubscriptionTierViewModel getViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(CreateGuildRoleSubscriptionTierViewModel.Event event) {
        if (event instanceof CreateGuildRoleSubscriptionTierViewModel.Event.SubmitSuccess) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (event instanceof CreateGuildRoleSubscriptionTierViewModel.Event.SubmitFailure) {
            ((CreateGuildRoleSubscriptionTierViewModel.Event.SubmitFailure) event).getError().showToasts(requireContext());
        } else if (event instanceof CreateGuildRoleSubscriptionTierViewModel.Event.ServerGatingUpdate) {
            getViewModel().setFullServerGating(((CreateGuildRoleSubscriptionTierViewModel.Event.ServerGatingUpdate) event).isFullServerGating());
        }
    }

    public static final void launch(Context context, long j, long j2) {
        INSTANCE.launch(context, j, j2);
    }

    private final void updateCreateTierViewModel(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        getCreateTierViewModel().onTierUpdated(viewState.getGuildRoleSubscriptionTier());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        List listListOf = Collections2.listOf((Object[]) new StepsView.b.a[]{new StepsView.b.a(WidgetGuildRoleSubscriptionTierDetails.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$1(this), null, null, false, false, false, 476), new StepsView.b.a(WidgetGuildRoleSubscriptionTierBenefits.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), Tuples.to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.CHANNEL)), new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$2(this), null, null, false, false, false, 460), new StepsView.b.a(WidgetGuildRoleSubscriptionTierBenefits.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), Tuples.to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.INTANGIBLE)), new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$3(this), null, null, false, false, false, 460), new StepsView.b.a(WidgetGuildRoleSubscriptionTierDesign.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$4(this), null, null, false, false, false, 476), new StepsView.b.a(WidgetGuildRoleSubscriptionReview.class, 0, 0, R.string.guild_role_subscription_plan_finish, Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId()))), null, null, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$5(this), false, false, false, 358)});
        StepsView stepsView = getBinding().f2359b;
        StepsView.d dVar = new StepsView.d(this, listListOf);
        WidgetCreateGuildRoleSubscriptionTier$onViewBound$$inlined$apply$lambda$1 widgetCreateGuildRoleSubscriptionTier$onViewBound$$inlined$apply$lambda$1 = new WidgetCreateGuildRoleSubscriptionTier$onViewBound$$inlined$apply$lambda$1(this, listListOf);
        int i = StepsView.j;
        stepsView.a(dVar, widgetCreateGuildRoleSubscriptionTier$onViewBound$$inlined$apply$lambda$1, StepsView2.j);
        stepsView.setStepProgressIndicatorVisible(true);
        AppFragment.setOnBackPressed$default(this, new AnonymousClass2(), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildRoleSubscriptionTierViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetCreateGuildRoleSubscriptionTier.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        Observable<CreateGuildRoleSubscriptionTierViewModel.ViewState> observableR2 = getCreateTierViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR2, "createTierViewModel\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR2, this, null, 2, null), WidgetCreateGuildRoleSubscriptionTier.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        Observable<CreateGuildRoleSubscriptionTierViewModel.Event> observableR3 = getCreateTierViewModel().observeEvents().r();
        Intrinsics3.checkNotNullExpressionValue(observableR3, "createTierViewModel\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR3, this, null, 2, null), WidgetCreateGuildRoleSubscriptionTier.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }
}
