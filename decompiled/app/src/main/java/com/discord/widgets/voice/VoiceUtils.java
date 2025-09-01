package com.discord.widgets.voice;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.c.a.a0.AnimatableValueParser;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppComponent;
import com.discord.app.AppFragment;
import com.discord.app.AppPermissions2;
import com.discord.app.AppTransitionActivity;
import com.discord.stores.StoreStream;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stage.StageChannelUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.stage.StageChannelAPI;
import com.discord.widgets.stage.StageChannelJoinHelper;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: VoiceUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0007\u0010\u000bJ7\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0007\u0010\u0014J/\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0019J=\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/voice/VoiceUtils;", "", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/app/AppBottomSheet;", "appBottomSheet", "", "handleCallChannel", "(Lcom/discord/api/channel/Channel;Lcom/discord/app/AppBottomSheet;)V", "Lcom/discord/app/AppFragment;", "appFragment", "(Lcom/discord/api/channel/Channel;Lcom/discord/app/AppFragment;)V", "Lcom/discord/app/AppComponent;", "appComponent", "Lcom/discord/app/AppPermissionsRequests;", "appPermissionsRequests", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "(Lcom/discord/api/channel/Channel;Lcom/discord/app/AppComponent;Lcom/discord/app/AppPermissionsRequests;Landroid/content/Context;Landroidx/fragment/app/FragmentManager;)V", "Lkotlin/Function0;", "onEventStarted", "handleConnectToEventChannel", "(Lcom/discord/api/channel/Channel;Lcom/discord/app/AppBottomSheet;Lkotlin/jvm/functions/Function0;)V", "(Lcom/discord/api/channel/Channel;Lcom/discord/app/AppFragment;Lkotlin/jvm/functions/Function0;)V", "(Lcom/discord/api/channel/Channel;Lcom/discord/app/AppPermissionsRequests;Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Lkotlin/jvm/functions/Function0;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class VoiceUtils {
    public static final VoiceUtils INSTANCE = new VoiceUtils();

    /* compiled from: VoiceUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.VoiceUtils$handleCallChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ AppPermissions2 $appPermissionsRequests;
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ boolean $hasUserSeenVoiceChannelOnboarding;
        public final /* synthetic */ boolean $isNewUser;
        public final /* synthetic */ Channel $selectedVoiceChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel, AppPermissions2 appPermissions2, AppComponent appComponent, Context context, FragmentManager fragmentManager, boolean z2, boolean z3, Channel channel2) {
            super(0);
            this.$channel = channel;
            this.$appPermissionsRequests = appPermissions2;
            this.$appComponent = appComponent;
            this.$context = context;
            this.$fragmentManager = fragmentManager;
            this.$hasUserSeenVoiceChannelOnboarding = z2;
            this.$isNewUser = z3;
            this.$selectedVoiceChannel = channel2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (ChannelUtils.B(this.$channel)) {
                new PrivateCallLauncher(this.$appPermissionsRequests, this.$appComponent, this.$context, this.$fragmentManager).launchVoiceCall(this.$channel.getId());
                return;
            }
            if (ChannelUtils.D(this.$channel)) {
                StageChannelUtils.INSTANCE.connectToStageChannel(this.$channel, this.$context, this.$fragmentManager);
                return;
            }
            if (!this.$hasUserSeenVoiceChannelOnboarding && this.$isNewUser) {
                WidgetGuildCallOnboardingSheet.INSTANCE.show(this.$fragmentManager, this.$channel.getId());
                return;
            }
            if (!TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(this.$channel.getGuildId()))) {
                WidgetVoiceBottomSheet.INSTANCE.show(this.$fragmentManager, this.$channel.getId(), true, WidgetVoiceBottomSheet.FeatureContext.HOME);
                return;
            }
            Channel channel = this.$selectedVoiceChannel;
            if (channel == null || ChannelUtils.B(channel) || this.$selectedVoiceChannel.getId() != this.$channel.getId()) {
                WidgetCallPreviewFullscreen.INSTANCE.launch(this.$context, this.$channel.getId(), AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE);
            } else {
                WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, this.$context, this.$channel.getId(), false, null, AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE, 12, null);
            }
        }
    }

    /* compiled from: VoiceUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
        }
    }

    /* compiled from: VoiceUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

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
        }
    }

    /* compiled from: VoiceUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AppPermissions2 $appPermissionsRequests;
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Function0 $onEventStarted;

        /* compiled from: VoiceUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {

            /* compiled from: VoiceUtils.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$3$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C03561 extends Lambda implements Function1<Void, Unit> {
                public static final C03561 INSTANCE = new C03561();

                public C03561() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                    invoke2(r1);
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Void r1) {
                }
            }

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
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.setUserSuppressedInChannel$default(StageChannelAPI.INSTANCE, AnonymousClass3.this.$channel, StoreStream.INSTANCE.getUsers().getMeSnapshot().getId(), false, 0L, 8, null), false, 1, null), VoiceUtils.INSTANCE.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, C03561.INSTANCE, 62, (Object) null);
                AnonymousClass3.this.$onEventStarted.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AppPermissions2 appPermissions2, Channel channel, Function0 function0) {
            super(0);
            this.$appPermissionsRequests = appPermissions2;
            this.$channel = channel;
            this.$onEventStarted = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AnimatableValueParser.S1(this.$appPermissionsRequests, null, new AnonymousClass1(), 1, null);
        }
    }

    /* compiled from: VoiceUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ Function0 $onEventStarted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Channel channel, Context context, FragmentManager fragmentManager, Function0 function0) {
            super(0);
            this.$channel = channel;
            this.$context = context;
            this.$fragmentManager = fragmentManager;
            this.$onEventStarted = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStream.INSTANCE.getVoiceChannelSelected().selectVoiceChannel(this.$channel.getId());
            if (TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(this.$channel.getGuildId()))) {
                WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, this.$context, this.$channel.getId(), false, null, null, 28, null);
            } else {
                WidgetVoiceBottomSheet.INSTANCE.show(this.$fragmentManager, this.$channel.getId(), true, WidgetVoiceBottomSheet.FeatureContext.HOME);
            }
            this.$onEventStarted.invoke();
        }
    }

    private VoiceUtils() {
    }

    public static final void handleCallChannel(Channel channel, AppBottomSheet appBottomSheet) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(appBottomSheet, "appBottomSheet");
        Context contextRequireContext = appBottomSheet.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "appBottomSheet.requireContext()");
        FragmentManager parentFragmentManager = appBottomSheet.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "appBottomSheet.parentFragmentManager");
        handleCallChannel(channel, appBottomSheet, appBottomSheet, contextRequireContext, parentFragmentManager);
    }

    public static final void handleConnectToEventChannel(Channel channel, AppBottomSheet appBottomSheet, Function0<Unit> onEventStarted) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(appBottomSheet, "appBottomSheet");
        Intrinsics3.checkNotNullParameter(onEventStarted, "onEventStarted");
        Context contextRequireContext = appBottomSheet.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "appBottomSheet.requireContext()");
        FragmentManager parentFragmentManager = appBottomSheet.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "appBottomSheet.parentFragmentManager");
        handleConnectToEventChannel(channel, appBottomSheet, contextRequireContext, parentFragmentManager, onEventStarted);
    }

    public static /* synthetic */ void handleConnectToEventChannel$default(Channel channel, AppBottomSheet appBottomSheet, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = AnonymousClass1.INSTANCE;
        }
        handleConnectToEventChannel(channel, appBottomSheet, (Function0<Unit>) function0);
    }

    public static /* synthetic */ void handleConnectToEventChannel$default(Channel channel, AppFragment appFragment, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = AnonymousClass2.INSTANCE;
        }
        handleConnectToEventChannel(channel, appFragment, (Function0<Unit>) function0);
    }

    public static final void handleCallChannel(Channel channel, AppFragment appFragment) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(appFragment, "appFragment");
        Context contextRequireContext = appFragment.requireContext();
        FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
        handleCallChannel(channel, appFragment, appFragment, contextRequireContext, parentFragmentManager);
    }

    public static final void handleConnectToEventChannel(Channel channel, AppFragment appFragment, Function0<Unit> onEventStarted) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(appFragment, "appFragment");
        Intrinsics3.checkNotNullParameter(onEventStarted, "onEventStarted");
        Context contextRequireContext = appFragment.requireContext();
        FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
        handleConnectToEventChannel(channel, appFragment, contextRequireContext, parentFragmentManager, onEventStarted);
    }

    public static final void handleCallChannel(Channel channel, AppComponent appComponent, AppPermissions2 appPermissionsRequests, Context context, FragmentManager fragmentManager) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(appPermissionsRequests, "appPermissionsRequests");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        UserUtils userUtils = UserUtils.INSTANCE;
        StoreStream.Companion companion = StoreStream.INSTANCE;
        boolean zIsNewUser$default = UserUtils.isNewUser$default(userUtils, companion.getUsers().getMeSnapshot(), null, 1, null);
        Channel selectedVoiceChannel = companion.getVoiceChannelSelected().getSelectedVoiceChannel();
        MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, context, fragmentManager, channel.getGuildId(), "Guild Voice", null, null, new AnonymousClass1(channel, appPermissionsRequests, appComponent, context, fragmentManager, WidgetGuildCallOnboardingSheet.INSTANCE.hasUserSeenVoiceChannelOnboarding(context), zIsNewUser$default, selectedVoiceChannel), 48, null);
    }

    public static final void handleConnectToEventChannel(Channel channel, AppPermissions2 appPermissionsRequests, Context context, FragmentManager fragmentManager, Function0<Unit> onEventStarted) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(appPermissionsRequests, "appPermissionsRequests");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(onEventStarted, "onEventStarted");
        if (ChannelUtils.D(channel)) {
            StageChannelJoinHelper.connectToStage$default(StageChannelJoinHelper.INSTANCE, context, fragmentManager, channel.getId(), false, false, null, null, null, null, new AnonymousClass3(appPermissionsRequests, channel, onEventStarted), 504, null);
        } else if (ChannelUtils.J(channel)) {
            AnimatableValueParser.S1(appPermissionsRequests, null, new AnonymousClass4(channel, context, fragmentManager, onEventStarted), 1, null);
        }
    }
}
