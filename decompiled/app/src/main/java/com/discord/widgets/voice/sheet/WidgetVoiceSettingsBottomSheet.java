package com.discord.widgets.voice.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetVoiceSettingsBottomSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import com.discord.widgets.settings.WidgetSettingsVoice;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheetViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.LazyJVM;
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

/* compiled from: WidgetVoiceSettingsBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b#\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u00020\u001e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheet$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheet$ViewState;)V", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel;", "viewModel", "Lcom/discord/databinding/WidgetVoiceSettingsBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetVoiceSettingsBottomSheetBinding;", "binding", "", "channelId$delegate", "getChannelId", "()J", "channelId", "<init>", "Companion", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet extends AppBottomSheet {
    private static final String ANALYTICS_SOURCE = "Voice Call";
    private static final String ARG_CHANNEL_ID = "ARG_CHANNEL_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetVoiceSettingsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceSettingsBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheet$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "show", "(Ljava/lang/Long;Landroidx/fragment/app/FragmentManager;)V", "", "ANALYTICS_SOURCE", "Ljava/lang/String;", WidgetVoiceSettingsBottomSheet.ARG_CHANNEL_ID, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, Long l, FragmentManager fragmentManager, int i, Object obj) {
            if ((i & 1) != 0) {
                l = null;
            }
            companion.show(l, fragmentManager);
        }

        public final void show(Long channelId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet = new WidgetVoiceSettingsBottomSheet();
            Bundle bundle = new Bundle();
            if (channelId != null) {
                bundle.putLong(WidgetVoiceSettingsBottomSheet.ARG_CHANNEL_ID, channelId.longValue());
            }
            widgetVoiceSettingsBottomSheet.setArguments(bundle);
            widgetVoiceSettingsBottomSheet.show(fragmentManager, WidgetVoiceSettingsBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheet$ViewState;", "", "", "getNoiseCancellationEnabled", "()Z", "noiseCancellationEnabled", "Lcom/discord/models/guild/Guild;", "getGuild", "()Lcom/discord/models/guild/Guild;", "guild", "getShowVoiceParticipantsToggle", "showVoiceParticipantsToggle", "getShowVoiceParticipants", "showVoiceParticipants", "getShowInviteItem", "showInviteItem", "getShowReportItem", "showReportItem", "getShowStageSettings", "showStageSettings", "Lcom/discord/api/channel/Channel;", "getChannel", "()Lcom/discord/api/channel/Channel;", "channel", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface ViewState {
        Channel getChannel();

        Guild getGuild();

        boolean getNoiseCancellationEnabled();

        boolean getShowInviteItem();

        boolean getShowReportItem();

        boolean getShowStageSettings();

        boolean getShowVoiceParticipants();

        boolean getShowVoiceParticipantsToggle();
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ViewState $viewState;

        public AnonymousClass1(ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceSettingsBottomSheet.this.dismiss();
            ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, WidgetVoiceSettingsBottomSheet.this, this.$viewState.getChannel(), WidgetVoiceSettingsBottomSheet.ANALYTICS_SOURCE, null, null, 24, null);
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceSettingsBottomSheet.access$getViewModel$p(WidgetVoiceSettingsBottomSheet.this).onToggleVoiceParticipantsHidden();
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceSettingsBottomSheet.this.dismiss();
            WidgetStageStartEventBottomSheet.Companion companion = WidgetStageStartEventBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetVoiceSettingsBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetStageStartEventBottomSheet.Companion.show$default(companion, parentFragmentManager, WidgetVoiceSettingsBottomSheet.access$getChannelId$p(WidgetVoiceSettingsBottomSheet.this), null, 4, null);
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ ViewState $viewState;

        public AnonymousClass4(ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceSettingsBottomSheet.this.dismiss();
            WidgetGuildScheduledEventListBottomSheet.Companion companion = WidgetGuildScheduledEventListBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetVoiceSettingsBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, this.$viewState.getChannel().getGuildId(), Long.valueOf(this.$viewState.getChannel().getId()));
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceSettingsBottomSheet.this.dismiss();
            WidgetSettingsVoice.Companion companion = WidgetSettingsVoice.INSTANCE;
            TextView textView = WidgetVoiceSettingsBottomSheet.access$getBinding$p(WidgetVoiceSettingsBottomSheet.this).i;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.voiceSettingsVoiceSettings");
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.voiceSettingsVoiceSettings.context");
            WidgetSettingsVoice.Companion.launch$default(companion, context, null, false, 6, null);
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceSettingsBottomSheet.access$getViewModel$p(WidgetVoiceSettingsBottomSheet.this).onToggleNoiseCancellation();
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {
        public final /* synthetic */ ViewState $viewState;

        public AnonymousClass8(ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetMobileReports.Companion companion = WidgetMobileReports.INSTANCE;
            Context contextRequireContext = WidgetVoiceSettingsBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.launchStageChannelReport(contextRequireContext, this.$viewState.getChannel().getId());
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetVoiceSettingsBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceSettingsBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetVoiceSettingsBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetVoiceSettingsBottomSheet.access$configureUI(WidgetVoiceSettingsBottomSheet.this, viewState);
        }
    }

    public WidgetVoiceSettingsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetVoiceSettingsBottomSheet3.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetVoiceSettingsBottomSheet4(this));
        WidgetVoiceSettingsBottomSheet5 widgetVoiceSettingsBottomSheet5 = new WidgetVoiceSettingsBottomSheet5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetVoiceSettingsBottomSheetViewModel.class), new WidgetVoiceSettingsBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetVoiceSettingsBottomSheet5));
    }

    public static final /* synthetic */ void access$configureUI(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet, ViewState viewState) {
        widgetVoiceSettingsBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetVoiceSettingsBottomSheetBinding access$getBinding$p(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        return widgetVoiceSettingsBottomSheet.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        return widgetVoiceSettingsBottomSheet.getChannelId();
    }

    public static final /* synthetic */ WidgetVoiceSettingsBottomSheetViewModel access$getViewModel$p(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        return widgetVoiceSettingsBottomSheet.getViewModel();
    }

    private final void configureUI(ViewState viewState) {
        Guild guild;
        getBinding().c.setOnClickListener(new AnonymousClass1(viewState));
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.voiceSettingsInvite");
        textView.setVisibility(viewState.getShowInviteItem() ? 0 : 8);
        getBinding().h.setOnClickListener(new AnonymousClass2());
        SwitchMaterial switchMaterial = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial, "binding.voiceSettingsToggleVideoParticipants");
        switchMaterial.setChecked(viewState.getShowVoiceParticipants());
        SwitchMaterial switchMaterial2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial2, "binding.voiceSettingsToggleVideoParticipants");
        switchMaterial2.setVisibility(viewState.getShowVoiceParticipantsToggle() ? 0 : 8);
        TextView textView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.voiceSettingsStageSettings");
        textView2.setVisibility(viewState.getShowStageSettings() ? 0 : 8);
        getBinding().g.setOnClickListener(new AnonymousClass3());
        TextView textView3 = getBinding().f2705b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.voiceSettingsEvents");
        textView3.setVisibility(ChannelUtils.w(viewState.getChannel()) ? 0 : 8);
        getBinding().f2705b.setOnClickListener(new AnonymousClass4(viewState));
        getBinding().i.setOnClickListener(new AnonymousClass5());
        TextView textView4 = getBinding().e;
        textView4.setVisibility(ChannelUtils.D(viewState.getChannel()) && (guild = viewState.getGuild()) != null && guild.hasFeature(GuildFeature.COMMUNITY) ? 0 : 8);
        textView4.setOnClickListener(new WidgetVoiceSettingsBottomSheet2(this, viewState));
        getBinding().d.setOnClickListener(new AnonymousClass7());
        SwitchMaterial switchMaterial3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial3, "binding.voiceSettingsNoiseSuppression");
        switchMaterial3.setChecked(viewState.getNoiseCancellationEnabled());
        TextView textView5 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.voiceSettingsReport");
        textView5.setVisibility(viewState.getShowReportItem() ? 0 : 8);
        getBinding().f.setOnClickListener(new AnonymousClass8(viewState));
    }

    private final WidgetVoiceSettingsBottomSheetBinding getBinding() {
        return (WidgetVoiceSettingsBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final WidgetVoiceSettingsBottomSheetViewModel getViewModel() {
        return (WidgetVoiceSettingsBottomSheetViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_voice_settings_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetVoiceSettingsBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetState(3);
    }
}
