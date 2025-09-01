package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierBenefitsBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.PaddedItemDecorator;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitsViewModel;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.LazyJVM;
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

/* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001:\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b=\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bR\u001d\u0010\u0015\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010$\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010#R\u001d\u0010)\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010(R\u001d\u0010.\u001a\u00020*8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0012\u001a\u0004\b,\u0010-R\u001d\u00103\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0012\u001a\u0004\b1\u00102R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/WidgetGuildRoleSubscriptionTierBenefits;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$ViewState;)V", "setupUIForChannelBenefits", "()V", "setupUIForIntangibleBenefits", "setUpBenefitsRecycler", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitListType;", "benefitListType$delegate", "Lkotlin/Lazy;", "getBenefitListType", "()Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitListType;", "benefitListType", "Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitsBinding;", "binding", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "benefitLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "guildId$delegate", "getGuildId", "()J", "guildId", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel;", "viewModel", "", "hideHeader$delegate", "getHideHeader", "()Z", "hideHeader", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel;", "benefitsViewModel$delegate", "getBenefitsViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel;", "benefitsViewModel", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "channelBenefitSettingsCheckedChangeListener", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapter;", "benefitsAdapter", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapter;", "com/discord/widgets/guild_role_subscriptions/tier/create/benefits/WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1", "itemClickListener", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildRoleSubscriptionTierBenefits.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_BENEFITS_HIDE_HEADER = "INTENT_EXTRA_BENEFITS_HIDE_HEADER";
    public static final String INTENT_EXTRA_BENEFIT_LIST_TYPE = "INTENT_EXTRA_BENEFIT_LIST_TYPE";
    private final ActivityResultLauncher<Intent> benefitLauncher;

    /* renamed from: benefitListType$delegate, reason: from kotlin metadata */
    private final Lazy benefitListType;
    private GuildRoleSubscriptionBenefitAdapter benefitsAdapter;

    /* renamed from: benefitsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy benefitsViewModel;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final RadioGroup.OnCheckedChangeListener channelBenefitSettingsCheckedChangeListener;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: hideHeader$delegate, reason: from kotlin metadata */
    private final Lazy hideHeader;
    private final WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 itemClickListener;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/WidgetGuildRoleSubscriptionTierBenefits$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitListType;", "benefitListType", "", "hideHeader", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/WidgetGuildRoleSubscriptionTierBenefits;", "newInstance", "(JLcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitListType;Z)Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/WidgetGuildRoleSubscriptionTierBenefits;", "", "INTENT_EXTRA_BENEFITS_HIDE_HEADER", "Ljava/lang/String;", WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits newInstance$default(Companion companion, long j, GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            return companion.newInstance(j, guildRoleSubscriptionTierBenefitListType, z2);
        }

        public final WidgetGuildRoleSubscriptionTierBenefits newInstance(long guildId, GuildRoleSubscriptionTierBenefitListType benefitListType, boolean hideHeader) {
            Intrinsics3.checkNotNullParameter(benefitListType, "benefitListType");
            WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits = new WidgetGuildRoleSubscriptionTierBenefits();
            widgetGuildRoleSubscriptionTierBenefits.setArguments(Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(guildId)), Tuples.to("INTENT_EXTRA_BENEFITS_HIDE_HEADER", Boolean.valueOf(hideHeader)), Tuples.to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, benefitListType)));
            return widgetGuildRoleSubscriptionTierBenefits;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildRoleSubscriptionTierBenefitListType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildRoleSubscriptionTierBenefitListType.CHANNEL.ordinal()] = 1;
            iArr[GuildRoleSubscriptionTierBenefitListType.INTANGIBLE.ordinal()] = 2;
            iArr[GuildRoleSubscriptionTierBenefitListType.ALL.ordinal()] = 3;
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$onViewBoundOrOnResume$1, reason: invalid class name */
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
            WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitsViewModel$p(WidgetGuildRoleSubscriptionTierBenefits.this).updateBenefits(viewState.getGuildRoleSubscriptionTier(), viewState.isFullServerGating());
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildRoleSubscriptionTierBenefitsViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionTierBenefits.access$configureUI(WidgetGuildRoleSubscriptionTierBenefits.this, viewState);
        }
    }

    public WidgetGuildRoleSubscriptionTierBenefits() {
        super(R.layout.widget_guild_role_subscription_tier_benefits);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionTierBenefits$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetGuildRoleSubscriptionTierBenefits$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionTierBenefits$viewModel$2.INSTANCE));
        this.guildId = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefits$guildId$2(this));
        this.hideHeader = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefits$hideHeader$2(this));
        WidgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2 widgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2 = new WidgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.benefitsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierBenefitsViewModel.class), new WidgetGuildRoleSubscriptionTierBenefits$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2));
        this.benefitListType = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefits$benefitListType$2(this));
        this.benefitLauncher = WidgetGuildRoleSubscriptionTierBenefit.INSTANCE.registerForResult(this, new WidgetGuildRoleSubscriptionTierBenefits$benefitLauncher$1(this));
        this.itemClickListener = new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1(this);
        this.channelBenefitSettingsCheckedChangeListener = new WidgetGuildRoleSubscriptionTierBenefits$channelBenefitSettingsCheckedChangeListener$1(this);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits, GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionTierBenefits.configureUI(viewState);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getBenefitLauncher$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.benefitLauncher;
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierBenefitListType access$getBenefitListType$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.getBenefitListType();
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierBenefitsViewModel access$getBenefitsViewModel$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.getBenefitsViewModel();
    }

    public static final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefitsBinding access$getBinding$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.getBinding();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.getGuildId();
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierViewModel access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.getViewModel();
    }

    private final void configureUI(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        guildRoleSubscriptionBenefitAdapter.setItems(viewState.getItems());
        RadioGroup radioGroup = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildRoleSubscri…TierChannelBenefitSetting");
        radioGroup.setVisibility(viewState.getCanChangeChannelSettings() ? 0 : 8);
        if (viewState.getCanAccessAllChannels() == null) {
            return;
        }
        getBinding().f.setOnCheckedChangeListener(null);
        if (viewState.getCanAccessAllChannels().booleanValue()) {
            MaterialRadioButton materialRadioButton = getBinding().f2439b;
            Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.guildRoleSubscriptionTierAllChannels");
            materialRadioButton.setChecked(true);
        } else {
            MaterialRadioButton materialRadioButton2 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.guildRoleSubscriptionTierManualChannels");
            materialRadioButton2.setChecked(true);
        }
        getBinding().f.setOnCheckedChangeListener(this.channelBenefitSettingsCheckedChangeListener);
    }

    private final GuildRoleSubscriptionTierBenefitListType getBenefitListType() {
        return (GuildRoleSubscriptionTierBenefitListType) this.benefitListType.getValue();
    }

    private final GuildRoleSubscriptionTierBenefitsViewModel getBenefitsViewModel() {
        return (GuildRoleSubscriptionTierBenefitsViewModel) this.benefitsViewModel.getValue();
    }

    private final WidgetGuildRoleSubscriptionTierBenefitsBinding getBinding() {
        return (WidgetGuildRoleSubscriptionTierBenefitsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final boolean getHideHeader() {
        return ((Boolean) this.hideHeader.getValue()).booleanValue();
    }

    private final GuildRoleSubscriptionTierViewModel getViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.viewModel.getValue();
    }

    private final void setUpBenefitsRecycler() {
        this.benefitsAdapter = new GuildRoleSubscriptionBenefitAdapter(this.itemClickListener, this, null, 4, null);
        PaddedItemDecorator paddedItemDecorator = new PaddedItemDecorator(1, 0, DimenUtils.dpToPixels(8), true);
        RecyclerView recyclerView = getBinding().h;
        RecyclerView recyclerView2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.subscriptionTierBenefitsRecycler");
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        recyclerView.setLayoutManager(new SelfHealingLinearLayoutManager(recyclerView2, guildRoleSubscriptionBenefitAdapter, 0, false, 12, null));
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter2 = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        recyclerView.setAdapter(guildRoleSubscriptionBenefitAdapter2);
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter3 = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        StickyHeaderItemDecoration stickyHeaderItemDecoration = new StickyHeaderItemDecoration(guildRoleSubscriptionBenefitAdapter3);
        recyclerView.addItemDecoration(paddedItemDecorator);
        recyclerView.addItemDecoration(stickyHeaderItemDecoration);
    }

    private final void setupUIForChannelBenefits() {
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitsTitle");
        textView.setText(getString(R.string.guild_role_subscription_create_tier_channel_benefits_title));
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitsSubTitle");
        textView2.setText(getString(R.string.guild_role_subscription_create_tier_channel_benefits_description));
        RadioGroup radioGroup = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildRoleSubscri…TierChannelBenefitSetting");
        radioGroup.setVisibility(0);
        getBinding().f.setOnCheckedChangeListener(this.channelBenefitSettingsCheckedChangeListener);
    }

    private final void setupUIForIntangibleBenefits() {
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitsTitle");
        textView.setText(getString(R.string.guild_role_subscription_create_tier_intangible_benefits_title));
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitsSubTitle");
        textView2.setText(getString(R.string.guild_role_subscription_create_tier_intangible_benefits_description));
        RadioGroup radioGroup = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildRoleSubscri…TierChannelBenefitSetting");
        radioGroup.setVisibility(8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setUpBenefitsRecycler();
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitsTitle");
        textView.setVisibility(getHideHeader() ^ true ? 0 : 8);
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitsSubTitle");
        textView2.setVisibility(getHideHeader() ^ true ? 0 : 8);
        View view2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.guildRoleSubscriptionTierBenefitsDivider");
        view2.setVisibility(getHideHeader() ^ true ? 0 : 8);
        int iOrdinal = getBenefitListType().ordinal();
        if (iOrdinal == 0) {
            setupUIForChannelBenefits();
            return;
        }
        if (iOrdinal == 1) {
            setupUIForIntangibleBenefits();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            setupUIForChannelBenefits();
            setupUIForIntangibleBenefits();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionTierBenefits.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getBenefitsViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionTierBenefits.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
