package com.discord.widgets.guild_role_subscriptions.setup;

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
import com.discord.databinding.WidgetGuildSubscriptionPlanSetupBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.steps.StepsView;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanDetailsViewModel;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanSetupViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitListType;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptionTierList;
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

/* compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b,\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010 R\u001d\u0010&\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010%R\u001d\u0010+\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/setup/WidgetGuildRoleSubscriptionPlanSetup;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$ViewState;)V", "Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$Event;", "event", "handleEvents", "(Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$Event;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanDetailsViewModel;", "subscriptionPlanDetailsViewModel$delegate", "Lkotlin/Lazy;", "getSubscriptionPlanDetailsViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanDetailsViewModel;", "subscriptionPlanDetailsViewModel", "Lcom/discord/databinding/WidgetGuildSubscriptionPlanSetupBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildSubscriptionPlanSetupBinding;", "binding", "", "guildId$delegate", "getGuildId", "()J", "guildId", "Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel;", "setupViewModel$delegate", "getSetupViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel;", "setupViewModel", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel;", "createTierViewModel$delegate", "getCreateTierViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel;", "createTierViewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanSetup extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildRoleSubscriptionPlanSetup.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildSubscriptionPlanSetupBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: createTierViewModel$delegate, reason: from kotlin metadata */
    private final Lazy createTierViewModel;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: setupViewModel$delegate, reason: from kotlin metadata */
    private final Lazy setupViewModel;

    /* renamed from: subscriptionPlanDetailsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionPlanDetailsViewModel;

    /* compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/setup/WidgetGuildRoleSubscriptionPlanSetup$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "launch", "(Landroid/content/Context;J)V", "", "INTENT_EXTRA_GUILD_ID", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            AppScreen2.d(context, WidgetGuildRoleSubscriptionPlanSetup.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2<R> implements Func0<Boolean> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetGuildRoleSubscriptionPlanSetup.access$getSetupViewModel$p(WidgetGuildRoleSubscriptionPlanSetup.this).goToPreviousStep();
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionPlanSetupViewModel.ViewState, Unit> {
        public AnonymousClass1() {
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
            WidgetGuildRoleSubscriptionPlanSetup.access$configureUI(WidgetGuildRoleSubscriptionPlanSetup.this, viewState);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$Event;", "it", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanSetupViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildRoleSubscriptionPlanSetupViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanSetupViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanSetupViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetGuildRoleSubscriptionPlanSetup.access$handleEvents(WidgetGuildRoleSubscriptionPlanSetup.this, event);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;", "kotlin.jvm.PlatformType", "viewState", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            WidgetGuildRoleSubscriptionPlanSetup.access$getSetupViewModel$p(WidgetGuildRoleSubscriptionPlanSetup.this).onTierUpdated(viewState.getGuildRoleSubscriptionTier());
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanDetailsViewModel$ViewState;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/setup/GuildRoleSubscriptionPlanDetailsViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<GuildRoleSubscriptionPlanDetailsViewModel.ViewState, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            WidgetGuildRoleSubscriptionPlanSetup.access$getSetupViewModel$p(WidgetGuildRoleSubscriptionPlanSetup.this).onSubscriptionPlanUpdated(viewState.getCoverImage(), viewState.getDescription(), viewState.isFullServerGate());
            WidgetGuildRoleSubscriptionPlanSetup.access$getCreateTierViewModel$p(WidgetGuildRoleSubscriptionPlanSetup.this).setFullServerGating(viewState.isFullServerGate());
        }
    }

    public WidgetGuildRoleSubscriptionPlanSetup() {
        super(R.layout.widget_guild_subscription_plan_setup);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionPlanSetup$binding$2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetGuildRoleSubscriptionPlanSetup$guildId$2(this));
        this.setupViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionPlanSetupViewModel.class), new WidgetGuildRoleSubscriptionPlanSetup$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetGuildRoleSubscriptionPlanSetup$setupViewModel$2(this)));
        this.createTierViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetGuildRoleSubscriptionPlanSetup$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionPlanSetup$createTierViewModel$2.INSTANCE));
        this.subscriptionPlanDetailsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionPlanDetailsViewModel.class), new WidgetGuildRoleSubscriptionPlanSetup$appActivityViewModels$$inlined$activityViewModels$5(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionPlanSetup$subscriptionPlanDetailsViewModel$2.INSTANCE));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup, GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionPlanSetup.configureUI(viewState);
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierViewModel access$getCreateTierViewModel$p(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup) {
        return widgetGuildRoleSubscriptionPlanSetup.getCreateTierViewModel();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup) {
        return widgetGuildRoleSubscriptionPlanSetup.getGuildId();
    }

    public static final /* synthetic */ GuildRoleSubscriptionPlanSetupViewModel access$getSetupViewModel$p(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup) {
        return widgetGuildRoleSubscriptionPlanSetup.getSetupViewModel();
    }

    public static final /* synthetic */ void access$handleEvents(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup, GuildRoleSubscriptionPlanSetupViewModel.Event event) {
        widgetGuildRoleSubscriptionPlanSetup.handleEvents(event);
    }

    private final void configureUI(GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
        StepsView stepsView = getBinding().f2454b;
        stepsView.setIsNextButtonEnabled(viewState.getCanProceedToNextStep());
        stepsView.setIsDoneButtonEnabled(!viewState.isSubmitting());
        stepsView.setIsLoading(viewState.isSubmitting());
        stepsView.b(viewState.getCurrentStep());
    }

    private final WidgetGuildSubscriptionPlanSetupBinding getBinding() {
        return (WidgetGuildSubscriptionPlanSetupBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildRoleSubscriptionTierViewModel getCreateTierViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.createTierViewModel.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildRoleSubscriptionPlanSetupViewModel getSetupViewModel() {
        return (GuildRoleSubscriptionPlanSetupViewModel) this.setupViewModel.getValue();
    }

    private final GuildRoleSubscriptionPlanDetailsViewModel getSubscriptionPlanDetailsViewModel() {
        return (GuildRoleSubscriptionPlanDetailsViewModel) this.subscriptionPlanDetailsViewModel.getValue();
    }

    private final void handleEvents(GuildRoleSubscriptionPlanSetupViewModel.Event event) {
        if (!(event instanceof GuildRoleSubscriptionPlanSetupViewModel.Event.SubmitSuccess)) {
            if (event instanceof GuildRoleSubscriptionPlanSetupViewModel.Event.SubmitFailure) {
                ((GuildRoleSubscriptionPlanSetupViewModel.Event.SubmitFailure) event).getError().showToasts(requireContext());
            }
        } else {
            WidgetServerSettingsGuildRoleSubscriptionTierList.INSTANCE.launch(requireContext(), getGuildId());
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        List listListOf = Collections2.listOf((Object[]) new StepsView.b.a[]{new StepsView.b.a(WidgetGuildRoleSubscriptionPlanFormat.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$1(this), null, null, false, false, false, 476), new StepsView.b.a(WidgetGuildRoleSubscriptionPlanDetails.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$2(this), null, null, false, false, false, 476), new StepsView.b.a(WidgetGuildRoleSubscriptionTierDetails.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$3(this), null, null, false, false, false, 476), new StepsView.b.a(WidgetGuildRoleSubscriptionTierBenefits.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), Tuples.to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.CHANNEL)), new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$4(this), null, null, false, false, false, 460), new StepsView.b.a(WidgetGuildRoleSubscriptionTierBenefits.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), Tuples.to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.INTANGIBLE)), new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$5(this), null, null, false, false, false, 460), new StepsView.b.a(WidgetGuildRoleSubscriptionTierDesign.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$6(this), null, null, false, false, false, 476), new StepsView.b.a(WidgetGuildRoleSubscriptionReview.class, 0, 0, R.string.guild_role_subscription_plan_finish, Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), Tuples.to(WidgetGuildRoleSubscriptionReview.ARG_IS_SUBSCRIPTION_GROUP_PLAN_REVIEW_MODE, Boolean.TRUE)), null, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$7(this), false, false, false, 358)});
        StepsView stepsView = getBinding().f2454b;
        StepsView.d dVar = new StepsView.d(this, listListOf);
        WidgetGuildRoleSubscriptionPlanSetup$onViewBound$$inlined$apply$lambda$1 widgetGuildRoleSubscriptionPlanSetup$onViewBound$$inlined$apply$lambda$1 = new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$$inlined$apply$lambda$1(this, listListOf);
        int i = StepsView.j;
        stepsView.a(dVar, widgetGuildRoleSubscriptionPlanSetup$onViewBound$$inlined$apply$lambda$1, StepsView2.j);
        stepsView.setStepProgressIndicatorVisible(true);
        AppFragment.setOnBackPressed$default(this, new AnonymousClass2(), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getSetupViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionPlanSetup.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getSetupViewModel().observeEvents(), this, null, 2, null), WidgetGuildRoleSubscriptionPlanSetup.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        Observable<GuildRoleSubscriptionTierViewModel.ViewState> observableR = getCreateTierViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "createTierViewModel\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetGuildRoleSubscriptionPlanSetup.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
        Observable<GuildRoleSubscriptionPlanDetailsViewModel.ViewState> observableR2 = getSubscriptionPlanDetailsViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR2, "subscriptionPlanDetailsV…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR2, this, null, 2, null), WidgetGuildRoleSubscriptionPlanSetup.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(), 62, (Object) null);
    }
}
