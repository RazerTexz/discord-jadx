package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsCommunitySetupFirstStepBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.ToastManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
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

/* compiled from: WidgetServerSettingsCommunityFirstStep.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityFirstStep;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;", "viewState", "", "configureUI", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", "onViewBoundOrOnResume", "()V", "onDestroyView", "Lcom/discord/utilities/view/ToastManager;", "toastManager", "Lcom/discord/utilities/view/ToastManager;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel;", "viewModel", "Lcom/discord/databinding/WidgetServerSettingsCommunitySetupFirstStepBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsCommunitySetupFirstStepBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityFirstStep extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsCommunityFirstStep.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunitySetupFirstStepBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ToastManager toastManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsCommunityFirstStep.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityFirstStep$Companion;", "", "Landroid/content/Context;", "context", "", "create", "(Landroid/content/Context;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetServerSettingsCommunityFirstStep.class, new Intent());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsCommunityFirstStep.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ boolean $guildVerificationLevel;
        public final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded $viewState;

        /* compiled from: WidgetServerSettingsCommunityFirstStep.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig;", "it", "invoke", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig;)Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03181 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig> {
            public C03181() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                return invoke2(communityGuildConfig);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke2(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                Intrinsics3.checkNotNullParameter(communityGuildConfig, "it");
                Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsCommunityFirstStep.access$getBinding$p(WidgetServerSettingsCommunityFirstStep.this).c, "binding.communitySettingsVerifiedEmailedSwitch");
                return WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig.copy$default(communityGuildConfig, null, null, null, null, false, false, !r2.isChecked(), false, null, false, null, null, 4031, null);
            }
        }

        public AnonymousClass1(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded, boolean z2) {
            this.$viewState = loaded;
            this.$guildVerificationLevel = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$viewState.getCommunityGuildConfig().getVerificationLevel() && this.$guildVerificationLevel) {
                AppToast.d(WidgetServerSettingsCommunityFirstStep.this.getContext(), R.string.enable_community_modal_requirement_satisfied_tooltip, 0, WidgetServerSettingsCommunityFirstStep.access$getToastManager$p(WidgetServerSettingsCommunityFirstStep.this));
            } else {
                WidgetServerSettingsCommunityFirstStep.access$getViewModel$p(WidgetServerSettingsCommunityFirstStep.this).modifyGuildConfig(new C03181());
            }
        }
    }

    /* compiled from: WidgetServerSettingsCommunityFirstStep.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ boolean $guildExplicitContentFilter;
        public final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded $viewState;

        /* compiled from: WidgetServerSettingsCommunityFirstStep.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig;", "it", "invoke", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig;)Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$configureUI$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                return invoke2(communityGuildConfig);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke2(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                Intrinsics3.checkNotNullParameter(communityGuildConfig, "it");
                Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsCommunityFirstStep.access$getBinding$p(WidgetServerSettingsCommunityFirstStep.this).f2554b, "binding.communitySettingsScanMessagesSwitch");
                return WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig.copy$default(communityGuildConfig, null, null, null, null, false, false, false, !r2.isChecked(), null, false, null, null, 3967, null);
            }
        }

        public AnonymousClass2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded, boolean z2) {
            this.$viewState = loaded;
            this.$guildExplicitContentFilter = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$viewState.getCommunityGuildConfig().getExplicitContentFilter() && this.$guildExplicitContentFilter) {
                AppToast.d(WidgetServerSettingsCommunityFirstStep.this.getContext(), R.string.enable_community_modal_requirement_satisfied_tooltip, 0, WidgetServerSettingsCommunityFirstStep.access$getToastManager$p(WidgetServerSettingsCommunityFirstStep.this));
            } else {
                WidgetServerSettingsCommunityFirstStep.access$getViewModel$p(WidgetServerSettingsCommunityFirstStep.this).modifyGuildConfig(new AnonymousClass1());
            }
        }
    }

    /* compiled from: WidgetServerSettingsCommunityFirstStep.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass1(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep) {
            super(1, widgetServerSettingsCommunityFirstStep, WidgetServerSettingsCommunityFirstStep.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "p1");
            WidgetServerSettingsCommunityFirstStep.access$configureUI((WidgetServerSettingsCommunityFirstStep) this.receiver, loaded);
        }
    }

    public WidgetServerSettingsCommunityFirstStep() {
        super(R.layout.widget_server_settings_community_setup_first_step);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsCommunityFirstStep2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new WidgetServerSettingsCommunityFirstStep$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetServerSettingsCommunityFirstStep3.INSTANCE));
        this.toastManager = new ToastManager();
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep, WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
        widgetServerSettingsCommunityFirstStep.configureUI(loaded);
    }

    public static final /* synthetic */ WidgetServerSettingsCommunitySetupFirstStepBinding access$getBinding$p(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep) {
        return widgetServerSettingsCommunityFirstStep.getBinding();
    }

    public static final /* synthetic */ ToastManager access$getToastManager$p(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep) {
        return widgetServerSettingsCommunityFirstStep.toastManager;
    }

    public static final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel access$getViewModel$p(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep) {
        return widgetServerSettingsCommunityFirstStep.getViewModel();
    }

    public static final /* synthetic */ void access$setToastManager$p(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep, ToastManager toastManager) {
        widgetServerSettingsCommunityFirstStep.toastManager = toastManager;
    }

    private final void configureUI(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded viewState) {
        CheckedSetting checkedSetting = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.communitySettingsVerifiedEmailedSwitch");
        checkedSetting.setChecked(viewState.getCommunityGuildConfig().getVerificationLevel());
        CheckedSetting checkedSetting2 = getBinding().f2554b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.communitySettingsScanMessagesSwitch");
        checkedSetting2.setChecked(viewState.getCommunityGuildConfig().getExplicitContentFilter());
        Guild guild = viewState.getCommunityGuildConfig().getGuild();
        boolean z2 = guild != null && guild.getVerificationLevel().compareTo(GuildVerificationLevel.NONE) > 0;
        boolean z3 = guild != null && guild.getExplicitContentFilter().compareTo(GuildExplicitContentFilter.NONE) > 0;
        getBinding().c.e(new AnonymousClass1(viewState, z2));
        getBinding().f2554b.e(new AnonymousClass2(viewState, z3));
    }

    public static final void create(Context context) {
        INSTANCE.create(context);
    }

    private final WidgetServerSettingsCommunitySetupFirstStepBinding getBinding() {
        return (WidgetServerSettingsCommunitySetupFirstStepBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsEnableCommunityViewModel getViewModel() {
        return (WidgetServerSettingsEnableCommunityViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.toastManager.close();
        super.onDestroyView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableG = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).y(WidgetServerSettingsCommunityFirstStep$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).G(WidgetServerSettingsCommunityFirstStep$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(observableG, WidgetServerSettingsCommunityFirstStep.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
