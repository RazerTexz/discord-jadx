package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsCommunitySetupSecondStepBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.WidgetChannelSelector;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunitySecondStep;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;", "viewState", "", "configureUI", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetServerSettingsCommunitySetupSecondStepBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsCommunitySetupSecondStepBinding;", "binding", "Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCommunitySecondStep extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsCommunitySecondStep.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunitySetupSecondStepBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String REQUEST_KEY_RULES_CHANNEL = "REQUEST_KEY_RULES_CHANNEL";
    private static final String REQUEST_KEY_UPDATES_CHANNEL = "REQUEST_KEY_UPDATES_CHANNEL";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunitySecondStep$Companion;", "", "Landroid/content/Context;", "context", "", "create", "(Landroid/content/Context;)V", "", WidgetServerSettingsCommunitySecondStep.REQUEST_KEY_RULES_CHANNEL, "Ljava/lang/String;", WidgetServerSettingsCommunitySecondStep.REQUEST_KEY_UPDATES_CHANNEL, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetServerSettingsCommunitySecondStep.class, new Intent());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
            WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep = WidgetServerSettingsCommunitySecondStep.this;
            WidgetChannelSelector.Companion.launchForText$default(companion, widgetServerSettingsCommunitySecondStep, WidgetServerSettingsCommunitySecondStep.access$getViewModel$p(widgetServerSettingsCommunitySecondStep).getGuildId(), WidgetServerSettingsCommunitySecondStep.REQUEST_KEY_RULES_CHANNEL, false, 0, 24, null);
        }
    }

    /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
            WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep = WidgetServerSettingsCommunitySecondStep.this;
            WidgetChannelSelector.Companion.launchForText$default(companion, widgetServerSettingsCommunitySecondStep, WidgetServerSettingsCommunitySecondStep.access$getViewModel$p(widgetServerSettingsCommunitySecondStep).getGuildId(), WidgetServerSettingsCommunitySecondStep.REQUEST_KEY_UPDATES_CHANNEL, false, 0, 24, null);
        }
    }

    /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "", "<anonymous parameter 1>", "", "invoke", "(JLjava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<Long, String, Unit> {

        /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig;", "guildConfig", "invoke", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig;)Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBound$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03191 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig> {
            public final /* synthetic */ Channel $channel;
            public final /* synthetic */ long $channelId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03191(long j, Channel channel) {
                super(1);
                this.$channelId = j;
                this.$channel = channel;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                return invoke2(communityGuildConfig);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke2(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                Intrinsics3.checkNotNullParameter(communityGuildConfig, "guildConfig");
                return WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig.copy$default(communityGuildConfig, this.$channel, null, Long.valueOf(this.$channelId), null, false, false, false, false, null, false, null, null, 4090, null);
            }
        }

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunitySecondStep.access$getViewModel$p(WidgetServerSettingsCommunitySecondStep.this).modifyGuildConfig(new C03191(j, StoreStream.INSTANCE.getChannels().getChannel(j)));
        }
    }

    /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "", "<anonymous parameter 1>", "", "invoke", "(JLjava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function2<Long, String, Unit> {

        /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig;", "guildConfig", "invoke", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig;)Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBound$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig> {
            public final /* synthetic */ Channel $channel;
            public final /* synthetic */ long $channelId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(long j, Channel channel) {
                super(1);
                this.$channelId = j;
                this.$channel = channel;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                return invoke2(communityGuildConfig);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke2(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                Intrinsics3.checkNotNullParameter(communityGuildConfig, "guildConfig");
                return WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig.copy$default(communityGuildConfig, null, this.$channel, null, Long.valueOf(this.$channelId), false, false, false, false, null, false, null, null, 4085, null);
            }
        }

        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunitySecondStep.access$getViewModel$p(WidgetServerSettingsCommunitySecondStep.this).modifyGuildConfig(new AnonymousClass1(j, StoreStream.INSTANCE.getChannels().getChannel(j)));
        }
    }

    /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass1(WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep) {
            super(1, widgetServerSettingsCommunitySecondStep, WidgetServerSettingsCommunitySecondStep.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "p1");
            WidgetServerSettingsCommunitySecondStep.access$configureUI((WidgetServerSettingsCommunitySecondStep) this.receiver, loaded);
        }
    }

    public WidgetServerSettingsCommunitySecondStep() {
        super(R.layout.widget_server_settings_community_setup_second_step);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsCommunitySecondStep2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new WidgetServerSettingsCommunitySecondStep$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetServerSettingsCommunitySecondStep3.INSTANCE));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep, WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
        widgetServerSettingsCommunitySecondStep.configureUI(loaded);
    }

    public static final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel access$getViewModel$p(WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep) {
        return widgetServerSettingsCommunitySecondStep.getViewModel();
    }

    private final void configureUI(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded viewState) {
        String string = viewState.getCommunityGuildConfig().getRulesChannel() == null ? requireContext().getString(R.string.enable_public_modal_create_channel) : ChannelUtils.e(viewState.getCommunityGuildConfig().getRulesChannel(), requireContext(), false, 2);
        Intrinsics3.checkNotNullExpressionValue(string, "when (viewState.communit…t(requireContext())\n    }");
        String string2 = viewState.getCommunityGuildConfig().getUpdatesChannel() == null ? requireContext().getString(R.string.enable_public_modal_create_channel) : ChannelUtils.e(viewState.getCommunityGuildConfig().getUpdatesChannel(), requireContext(), false, 2);
        Intrinsics3.checkNotNullExpressionValue(string2, "when (viewState.communit…t(requireContext())\n    }");
        getBinding().f2555b.setSubtitle(string);
        getBinding().c.setSubtitle(string2);
        getBinding().f2555b.setOnClickListener(new AnonymousClass1());
        getBinding().c.setOnClickListener(new AnonymousClass2());
    }

    public static final void create(Context context) {
        INSTANCE.create(context);
    }

    private final WidgetServerSettingsCommunitySetupSecondStepBinding getBinding() {
        return (WidgetServerSettingsCommunitySetupSecondStepBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsEnableCommunityViewModel getViewModel() {
        return (WidgetServerSettingsEnableCommunityViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_RULES_CHANNEL, false, new AnonymousClass1(), 4, null);
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_UPDATES_CHANNEL, false, new AnonymousClass2(), 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableG = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).y(WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).G(WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(observableG, WidgetServerSettingsCommunitySecondStep.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
