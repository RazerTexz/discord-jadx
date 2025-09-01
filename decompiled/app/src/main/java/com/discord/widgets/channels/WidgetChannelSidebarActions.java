package com.discord.widgets.channels;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSidebarActionsBinding;
import com.discord.utilities.device.DeviceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.channelsidebar.GuildChannelSideBarActionsView;
import com.discord.views.channelsidebar.PrivateChannelSideBarActionsView;
import com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.channels.settings.WidgetThreadSettings;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowser;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.discord.widgets.search.WidgetSearch;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: WidgetChannelSidebarActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u000fJ#\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSidebarActions;", "Lcom/discord/app/AppFragment;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "useVideo", "", "startPrivateCall", "(JZ)V", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState;", "viewState", "configureUI", "(Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetChannelSidebarActionsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChannelSidebarActionsBinding;", "binding", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel;", "viewModel", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelSidebarActions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelSidebarActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSidebarActionsBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetChannelSidebarActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        public AnonymousClass1(WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSidebarActions.access$startPrivateCall(WidgetChannelSidebarActions.this, ((WidgetChannelSidebarActionsViewModel.ViewState.Private) this.$viewState).getChannelId(), false);
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        public AnonymousClass2(WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSidebarActions.access$startPrivateCall(WidgetChannelSidebarActions.this, ((WidgetChannelSidebarActionsViewModel.ViewState.Private) this.$viewState).getChannelId(), true);
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ long $channelId;

        public AnonymousClass3(long j) {
            this.$channelId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
            long j = this.$channelId;
            FragmentManager parentFragmentManager = WidgetChannelSidebarActions.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForChannel(j, parentFragmentManager);
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;

        public AnonymousClass4(long j, Context context) {
            this.$channelId = j;
            this.$context = context;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSearch.INSTANCE.launchForChannel(this.$channelId, this.$context);
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(WidgetChannelSidebarActionsViewModel.ViewState viewState, Context context) {
            super(1);
            this.$viewState = viewState;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetSearch.INSTANCE.launchForGuild(((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).getGuildId(), this.$context);
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(Context context, WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            super(1);
            this.$context = context;
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetThreadBrowser.INSTANCE.show(this.$context, ((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).getGuildId(), ((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).getChannelId(), "Channel Side Bar");
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$7, reason: invalid class name */
    public static final class AnonymousClass7 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(Context context, long j) {
            super(1);
            this.$context = context;
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetChannelPinnedMessages.INSTANCE.show(this.$context, this.$channelId);
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$8, reason: invalid class name */
    public static final class AnonymousClass8 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
            long j = this.$channelId;
            FragmentManager parentFragmentManager = WidgetChannelSidebarActions.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForChannel(j, parentFragmentManager);
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$9, reason: invalid class name */
    public static final class AnonymousClass9 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass9(WidgetChannelSidebarActionsViewModel.ViewState viewState, long j, Context context) {
            super(1);
            this.$viewState = viewState;
            this.$channelId = j;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            if (((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).isThread()) {
                WidgetThreadSettings.INSTANCE.launch(this.$channelId, this.$context);
            } else {
                WidgetTextChannelSettings.INSTANCE.launch(this.$channelId, this.$context);
            }
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetChannelSidebarActionsViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetChannelSidebarActions.access$configureUI(WidgetChannelSidebarActions.this, viewState);
        }
    }

    public WidgetChannelSidebarActions() {
        super(R.layout.widget_channel_sidebar_actions);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelSidebarActions2.INSTANCE, null, 2, null);
        WidgetChannelSidebarActions3 widgetChannelSidebarActions3 = WidgetChannelSidebarActions3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChannelSidebarActionsViewModel.class), new WidgetChannelSidebarActions$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetChannelSidebarActions3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelSidebarActions widgetChannelSidebarActions, WidgetChannelSidebarActionsViewModel.ViewState viewState) {
        widgetChannelSidebarActions.configureUI(viewState);
    }

    public static final /* synthetic */ void access$startPrivateCall(WidgetChannelSidebarActions widgetChannelSidebarActions, long j, boolean z2) {
        widgetChannelSidebarActions.startPrivateCall(j, z2);
    }

    private final void configureUI(WidgetChannelSidebarActionsViewModel.ViewState viewState) {
        DeviceUtils deviceUtils = DeviceUtils.INSTANCE;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        boolean zIsSmallScreen = deviceUtils.isSmallScreen(resources);
        if (Intrinsics3.areEqual(viewState, WidgetChannelSidebarActionsViewModel.ViewState.Uninitialized.INSTANCE)) {
            View view = getView();
            if (view != null) {
                ViewKt.setVisible(view, false);
                return;
            }
            return;
        }
        if (viewState instanceof WidgetChannelSidebarActionsViewModel.ViewState.Private) {
            View view2 = getView();
            if (view2 != null) {
                ViewKt.setVisible(view2, true);
            }
            GuildChannelSideBarActionsView guildChannelSideBarActionsView = getBinding().f2280b;
            Intrinsics3.checkNotNullExpressionValue(guildChannelSideBarActionsView, "binding.widgetChannelSidebarActionsGuildView");
            guildChannelSideBarActionsView.setVisibility(8);
            PrivateChannelSideBarActionsView privateChannelSideBarActionsView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(privateChannelSideBarActionsView, "binding.widgetChannelSidebarActionsPrivateView");
            privateChannelSideBarActionsView.setVisibility(0);
            WidgetChannelSidebarActionsViewModel.ViewState.Private r2 = (WidgetChannelSidebarActionsViewModel.ViewState.Private) viewState;
            long channelId = r2.getChannelId();
            getBinding().c.a(new AnonymousClass1(viewState), new AnonymousClass2(viewState), new AnonymousClass3(channelId), new AnonymousClass4(channelId, requireContext()), r2.isMuted());
            return;
        }
        if (viewState instanceof WidgetChannelSidebarActionsViewModel.ViewState.Guild) {
            WidgetChannelSidebarActionsViewModel.ViewState.Guild guild = (WidgetChannelSidebarActionsViewModel.ViewState.Guild) viewState;
            long channelId2 = guild.getChannelId();
            Context contextRequireContext = requireContext();
            GuildChannelSideBarActionsView guildChannelSideBarActionsView2 = getBinding().f2280b;
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(viewState, contextRequireContext);
            AnonymousClass6 anonymousClass6 = new AnonymousClass6(contextRequireContext, viewState);
            AnonymousClass7 anonymousClass7 = new AnonymousClass7(contextRequireContext, channelId2);
            guildChannelSideBarActionsView2.a(anonymousClass5, anonymousClass6, new AnonymousClass8(channelId2), anonymousClass7, new AnonymousClass9(viewState, channelId2, contextRequireContext), guild.getHasUnreadPins(), guild.isMuted(), guild.getDisablePins(), zIsSmallScreen || guild.isGuildForumPost() || guild.isGuildForumChannel());
            View view3 = getView();
            if (view3 != null) {
                ViewKt.setVisible(view3, true);
            }
            PrivateChannelSideBarActionsView privateChannelSideBarActionsView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(privateChannelSideBarActionsView2, "binding.widgetChannelSidebarActionsPrivateView");
            privateChannelSideBarActionsView2.setVisibility(8);
            GuildChannelSideBarActionsView guildChannelSideBarActionsView3 = getBinding().f2280b;
            Intrinsics3.checkNotNullExpressionValue(guildChannelSideBarActionsView3, "binding.widgetChannelSidebarActionsGuildView");
            guildChannelSideBarActionsView3.setVisibility(guild.getShouldHideChannelSidebar() ^ true ? 0 : 8);
        }
    }

    private final WidgetChannelSidebarActionsBinding getBinding() {
        return (WidgetChannelSidebarActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetChannelSidebarActionsViewModel getViewModel() {
        return (WidgetChannelSidebarActionsViewModel) this.viewModel.getValue();
    }

    private final void startPrivateCall(long channelId, boolean useVideo) {
        Context contextRequireContext = requireContext();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        PrivateCallLauncher privateCallLauncher = new PrivateCallLauncher(this, this, contextRequireContext, parentFragmentManager);
        if (useVideo) {
            privateCallLauncher.launchVideoCall(channelId);
        } else {
            privateCallLauncher.launchVoiceCall(channelId);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelSidebarActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
