package com.discord.widgets.voice.controls;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.VoiceControlsSheetViewBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.press.OnPressListener;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.NumericBadgingView;
import com.discord.views.calls.VolumeSliderView;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.model.CallModel;
import com.google.android.material.textview.MaterialTextView;
import d0.a0.MathJVM;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VoiceControlsSheetView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\bO\u0010PB\u001d\b\u0016\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010Q¢\u0006\u0004\bO\u0010SB'\b\u0016\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010Q\u0012\b\b\u0002\u0010T\u001a\u00020\u0017¢\u0006\u0004\bO\u0010UJ-\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016JE\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ5\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J-\u0010#\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b#\u0010\u0016J-\u0010&\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00112\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b&\u0010\u0016J9\u0010,\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\r2\u0006\u0010)\u001a\u00020(2\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050*H\u0002¢\u0006\u0004\b,\u0010-J\u001f\u00101\u001a\u00020\u00172\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\rH\u0002¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u00020\u00172\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\rH\u0002¢\u0006\u0004\b3\u00102J\u000f\u00104\u001a\u00020\u0005H\u0014¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u0017¢\u0006\u0004\b6\u00107J\u0015\u0010:\u001a\u00020\u00052\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J£\u0002\u0010F\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\r2\u0006\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020\r2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010'\u001a\u00020\r2\u0006\u0010)\u001a\u00020(2\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050*2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010EJ\u0015\u0010H\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0017¢\u0006\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010N\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006V"}, d2 = {"Lcom/discord/widgets/voice/controls/VoiceControlsSheetView;", "Landroid/widget/LinearLayout;", "Lcom/discord/widgets/stage/StageRoles;", "stageRoles", "Lkotlin/Function0;", "", "onMoveToAudienceClick", "configureMoveToAudienceButton-yox5PQY", "(Lcom/discord/widgets/stage/StageRoles;Lkotlin/jvm/functions/Function0;)V", "configureMoveToAudienceButton", "Lcom/discord/widgets/voice/controls/VoiceControlsOutputSelectorState;", "outputSelectorState", "onAudioOutputClick", "", "showInTopRow", "configureOutputSelectors", "(Lcom/discord/widgets/voice/controls/VoiceControlsOutputSelectorState;Lkotlin/jvm/functions/Function0;Z)V", "Lcom/discord/widgets/voice/model/CallModel;", "model", "onVideoClick", "isVideoEnabledForCall", "configureVideoButton", "(Lcom/discord/widgets/voice/model/CallModel;Lkotlin/jvm/functions/Function0;Z)V", "", "requestingToSpeakCount", "isUpdatingRequestToSpeak", "onRaiseHandClick", "configureRaiseHandButton-fw_bWyM", "(Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/widgets/stage/StageRoles;IZLkotlin/jvm/functions/Function0;)V", "configureRaiseHandButton", "onMuteClick", "configureMuteButton-P2fzehM", "(Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/widgets/stage/StageRoles;Lkotlin/jvm/functions/Function0;)V", "configureMuteButton", "onScreenshareClick", "configureScreenshareButtons", "callModel", "onInviteClick", "configureInviteButtons", "showStreamVolume", "", "perceptualStreamVolume", "Lkotlin/Function2;", "onStreamVolumeChange", "configureStreamVolume", "(ZFLkotlin/jvm/functions/Function2;)V", "Landroid/content/Context;", "context", "isActive", "getDefaultButtonIconTint", "(Landroid/content/Context;Z)I", "getDefaultButtonBackgroundTint", "onAttachedToWindow", "()V", "getPeekHeight", "()I", "Lcom/discord/utilities/press/OnPressListener;", "listener", "setOnPTTListener", "(Lcom/discord/utilities/press/OnPressListener;)V", "isPttEnabled", "isDeafened", "startedAsVideo", "showStopWatching", "showDisconnect", "onStopWatchingClick", "onDisconnectClick", "onDeafenPressed", "configureUI-3jxq49Y", "(Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/widgets/voice/controls/VoiceControlsOutputSelectorState;ZZZZZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLcom/discord/widgets/stage/StageRoles;)V", "configureUI", "bottomSheetState", "handleSheetState", "(I)V", "isGestureNavigationEnabled", "Z", "Lcom/discord/databinding/VoiceControlsSheetViewBinding;", "binding", "Lcom/discord/databinding/VoiceControlsSheetViewBinding;", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class VoiceControlsSheetView extends LinearLayout {
    private final VoiceControlsSheetViewBinding binding;
    private boolean isGestureNavigationEnabled;

    /* compiled from: VoiceControlsSheetView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureInviteButtons$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onInviteClick;

        public AnonymousClass1(Function0 function0) {
            this.$onInviteClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onInviteClick.invoke();
        }
    }

    /* compiled from: VoiceControlsSheetView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureInviteButtons$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onInviteClick;

        public AnonymousClass2(Function0 function0) {
            this.$onInviteClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onInviteClick.invoke();
        }
    }

    /* compiled from: VoiceControlsSheetView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureOutputSelectors$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onAudioOutputClick;

        public AnonymousClass1(Function0 function0) {
            this.$onAudioOutputClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onAudioOutputClick.invoke();
        }
    }

    /* compiled from: VoiceControlsSheetView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureOutputSelectors$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onAudioOutputClick;

        public AnonymousClass2(Function0 function0) {
            this.$onAudioOutputClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onAudioOutputClick.invoke();
        }
    }

    /* compiled from: VoiceControlsSheetView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureScreenshareButtons$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onScreenshareClick;

        public AnonymousClass1(Function0 function0) {
            this.$onScreenshareClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onScreenshareClick.invoke();
        }
    }

    /* compiled from: VoiceControlsSheetView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureScreenshareButtons$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onScreenshareClick;

        public AnonymousClass2(Function0 function0) {
            this.$onScreenshareClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onScreenshareClick.invoke();
        }
    }

    /* compiled from: VoiceControlsSheetView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureVideoButton$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onVideoClick;

        public AnonymousClass1(Function0 function0) {
            this.$onVideoClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onVideoClick.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceControlsSheetView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        VoiceControlsSheetViewBinding voiceControlsSheetViewBindingA = VoiceControlsSheetViewBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(voiceControlsSheetViewBindingA, "VoiceControlsSheetViewBi…ater.from(context), this)");
        this.binding = voiceControlsSheetViewBindingA;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        this.isGestureNavigationEnabled = DisplayUtils.isGestureNavigationEnabled(resources);
        CardView cardView = voiceControlsSheetViewBindingA.r;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility(this.isGestureNavigationEnabled ? 0 : 4);
    }

    private final void configureInviteButtons(CallModel callModel, Function0<Unit> onInviteClick, boolean showInTopRow) {
        this.binding.h.setOnClickListener(new AnonymousClass1(onInviteClick));
        this.binding.i.setOnClickListener(new AnonymousClass2(onInviteClick));
        ImageView imageView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.inviteButton");
        imageView.setVisibility(callModel.canInvite() && showInTopRow ? 0 : 8);
        TextView textView = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.inviteSecondaryButton");
        textView.setVisibility(callModel.canInvite() && !showInTopRow ? 0 : 8);
        ImageView imageView2 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.inviteButton");
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        imageView2.setBackgroundTintList(ColorStateList.valueOf(getDefaultButtonBackgroundTint(context, false)));
    }

    /* renamed from: configureMoveToAudienceButton-yox5PQY, reason: not valid java name */
    private final void m61configureMoveToAudienceButtonyox5PQY(StageRoles stageRoles, Function0<Unit> onMoveToAudienceClick) {
        ImageView imageView = this.binding.j;
        imageView.setVisibility((stageRoles == null || !StageRoles.m33isSpeakerimpl(stageRoles.m35unboximpl()) || StageRoles.m32isModeratorimpl(stageRoles.m35unboximpl())) ? false : true ? 0 : 8);
        ImageView imageView2 = this.binding.j;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.moveToAudienceButton");
        imageView2.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(imageView.getContext(), R.color.white_alpha_24)));
        imageView.setOnClickListener(new VoiceControlsSheetView2(this, stageRoles, onMoveToAudienceClick));
    }

    /* renamed from: configureMuteButton-P2fzehM, reason: not valid java name */
    private final void m62configureMuteButtonP2fzehM(CallModel model, StageRoles stageRoles, Function0<Unit> onMuteClick) {
        if (stageRoles != null && !StageRoles.m33isSpeakerimpl(stageRoles.m35unboximpl())) {
            ImageView imageView = this.binding.k;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.muteButton");
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.binding.k;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.muteButton");
        imageView2.setVisibility(0);
        boolean zIsMeMutedByAnySource = model.isMeMutedByAnySource();
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, zIsMeMutedByAnySource);
        ImageView imageView3 = this.binding.k;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.muteButton");
        imageView3.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        this.binding.k.setImageResource(zIsMeMutedByAnySource ? R.drawable.ic_mic_mute_red_strike_24dp : R.drawable.ic_mic_white_24dp);
        this.binding.k.setOnClickListener(new VoiceControlsSheetView6(onMuteClick));
        ImageView imageView4 = this.binding.k;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.muteButton");
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        imageView4.setContentDescription(FormatUtils.h(context2, zIsMeMutedByAnySource ? R.string.unmute : R.string.mute, new Object[0], null, 4));
    }

    private final void configureOutputSelectors(VoiceControlsOutputSelectorState outputSelectorState, Function0<Unit> onAudioOutputClick, boolean showInTopRow) {
        FrameLayout frameLayout = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.audioOutputContainer");
        frameLayout.setVisibility(showInTopRow ? 0 : 8);
        this.binding.f2217b.setImageDrawable(ContextCompat.getDrawable(getContext(), outputSelectorState.getAudioOutputIconRes()));
        ImageView imageView = this.binding.f2217b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.audioOutputButton");
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        imageView.setBackgroundTintList(ColorStateList.valueOf(getDefaultButtonBackgroundTint(context, outputSelectorState.getIsButtonActive())));
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.audioOutputSecondaryButton");
        textView.setVisibility(showInTopRow ^ true ? 0 : 8);
        TextView textView2 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.audioOutputSecondaryButton");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, outputSelectorState.getAudioOutputIconRes(), 0, 0, 0, 14, null);
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        int defaultButtonIconTint = getDefaultButtonIconTint(context2, outputSelectorState.getIsButtonActive());
        ImageView imageView2 = this.binding.f2217b;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.audioOutputButton");
        ColorCompat2.tintWithColor(imageView2, defaultButtonIconTint);
        ImageView imageView3 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.audioOutputMore");
        ColorCompat2.tintWithColor(imageView3, defaultButtonIconTint);
        ImageView imageView4 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.audioOutputMore");
        imageView4.setVisibility(outputSelectorState.getShowMoreOptions() ? 0 : 8);
        this.binding.f2217b.setOnClickListener(new AnonymousClass1(onAudioOutputClick));
        this.binding.e.setOnClickListener(new AnonymousClass2(onAudioOutputClick));
    }

    /* renamed from: configureRaiseHandButton-fw_bWyM, reason: not valid java name */
    private final void m63configureRaiseHandButtonfw_bWyM(CallModel model, StageRoles stageRoles, int requestingToSpeakCount, boolean isUpdatingRequestToSpeak, Function0<Unit> onRaiseHandClick) {
        if (stageRoles == null || !(StageRoles.m32isModeratorimpl(stageRoles.m35unboximpl()) || StageRoles.m30isAudienceimpl(stageRoles.m35unboximpl()))) {
            NumericBadgingView numericBadgingView = this.binding.n;
            Intrinsics3.checkNotNullExpressionValue(numericBadgingView, "binding.raiseHandBadge");
            numericBadgingView.setVisibility(8);
            return;
        }
        NumericBadgingView numericBadgingView2 = this.binding.n;
        boolean z2 = false;
        numericBadgingView2.setVisibility(0);
        if (!StageRoles.m32isModeratorimpl(stageRoles.m35unboximpl())) {
            requestingToSpeakCount = 0;
        }
        numericBadgingView2.setBadgeNumber(requestingToSpeakCount);
        ImageView imageView = this.binding.o;
        if (StageRoles.m32isModeratorimpl(stageRoles.m35unboximpl())) {
            imageView.setContentDescription(imageView.getResources().getString(R.string.request_to_speak_area_title));
            ViewExtensions.setEnabledAndAlpha$default(imageView, true, 0.0f, 2, null);
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ic_stage_raised_hand_list));
        } else {
            imageView.setContentDescription(imageView.getResources().getString(!model.canRequestToSpeak() ? R.string.audience_raise_hand_no_permission : model.isMyHandRaised() ? R.string.audience_lower_hand : R.string.audience_raise_hand_cta));
            ViewExtensions.setEnabledAndAlpha(imageView, !isUpdatingRequestToSpeak && model.canRequestToSpeak(), 0.2f);
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ic_stage_raised_hand));
        }
        if (model.isMyHandRaised() && !StageRoles.m32isModeratorimpl(stageRoles.m35unboximpl())) {
            z2 = true;
        }
        Context context = imageView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, z2);
        Context context2 = imageView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        int defaultButtonIconTint = getDefaultButtonIconTint(context2, z2);
        imageView.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        ColorCompat2.tintWithColor(imageView, defaultButtonIconTint);
        imageView.setOnClickListener(new VoiceControlsSheetView3(this, stageRoles, model, isUpdatingRequestToSpeak, onRaiseHandClick));
    }

    private final void configureScreenshareButtons(CallModel model, Function0<Unit> onScreenshareClick, boolean showInTopRow) {
        boolean z2 = !ChannelUtils.D(model.getChannel());
        boolean zIsStreaming = model.isStreaming();
        int i = zIsStreaming ? R.string.stop_streaming : R.string.mobile_stream_screen_share;
        ImageView imageView = this.binding.p;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.screenShareButton");
        imageView.setVisibility(z2 && showInTopRow ? 0 : 8);
        int i2 = zIsStreaming ? R.drawable.ic_mobile_screenshare_end_24dp : R.drawable.ic_mobile_screenshare_24dp;
        int i3 = zIsStreaming ? ViewCompat.MEASURED_STATE_MASK : -1;
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, zIsStreaming);
        this.binding.p.setImageResource(i2);
        ImageView imageView2 = this.binding.p;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.screenShareButton");
        imageView2.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        ImageView imageView3 = this.binding.p;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.screenShareButton");
        imageView3.setImageTintList(ColorStateList.valueOf(i3));
        this.binding.p.setOnClickListener(new AnonymousClass1(onScreenshareClick));
        TextView textView = this.binding.q;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.screenShareSecondaryButton");
        textView.setVisibility(z2 && !showInTopRow ? 0 : 8);
        this.binding.q.setOnClickListener(new AnonymousClass2(onScreenshareClick));
        TextView textView2 = this.binding.q;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.screenShareSecondaryButton");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, i2, 0, 0, 0, 14, null);
        this.binding.q.setText(i);
    }

    private final void configureStreamVolume(boolean showStreamVolume, float perceptualStreamVolume, Function2<? super Float, ? super Boolean, Unit> onStreamVolumeChange) {
        TextView textView = this.binding.u;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.streamVolumeLabel");
        textView.setVisibility(showStreamVolume ? 0 : 8);
        VolumeSliderView volumeSliderView = this.binding.v;
        Intrinsics3.checkNotNullExpressionValue(volumeSliderView, "binding.streamVolumeSlider");
        volumeSliderView.setVisibility(showStreamVolume ? 0 : 8);
        VolumeSliderView volumeSliderView2 = this.binding.v;
        int iRoundToInt = MathJVM.roundToInt(perceptualStreamVolume);
        SeekBar seekBar = volumeSliderView2.binding.d;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.volumeSliderSeekBar");
        seekBar.setProgress(iRoundToInt);
        this.binding.v.setOnVolumeChange(onStreamVolumeChange);
    }

    private final void configureVideoButton(CallModel model, Function0<Unit> onVideoClick, boolean isVideoEnabledForCall) {
        boolean z2 = model.getSelectedVideoDevice() != null;
        boolean z3 = !model.getVideoDevices().isEmpty();
        ImageView imageView = this.binding.w;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.videoButton");
        imageView.setVisibility(z3 && isVideoEnabledForCall ? 0 : 8);
        int i = z2 ? ViewCompat.MEASURED_STATE_MASK : -1;
        ImageView imageView2 = this.binding.w;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.videoButton");
        imageView2.setImageTintList(ColorStateList.valueOf(i));
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, z2);
        ImageView imageView3 = this.binding.w;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.videoButton");
        imageView3.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        this.binding.w.setOnClickListener(new AnonymousClass1(onVideoClick));
    }

    private final int getDefaultButtonBackgroundTint(Context context, boolean isActive) {
        if (isActive) {
            return ColorCompat.getColor(context, R.color.white);
        }
        if (isActive) {
            throw new NoWhenBranchMatchedException();
        }
        return ColorCompat.getColor(context, R.color.white_alpha_24);
    }

    private final int getDefaultButtonIconTint(Context context, boolean isActive) {
        if (!isActive) {
            return ColorCompat.getColor(context, R.color.white);
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.call_controls_active_button_icon_color, typedValue, true);
        return ColorCompat.getColor(context, typedValue.resourceId);
    }

    /* renamed from: configureUI-3jxq49Y, reason: not valid java name */
    public final void m64configureUI3jxq49Y(CallModel model, VoiceControlsOutputSelectorState outputSelectorState, boolean isVideoEnabledForCall, boolean isPttEnabled, boolean isDeafened, boolean startedAsVideo, boolean showStopWatching, boolean showDisconnect, Function0<Unit> onStopWatchingClick, Function0<Unit> onDisconnectClick, Function0<Unit> onAudioOutputClick, Function0<Unit> onVideoClick, Function0<Unit> onMuteClick, Function0<Unit> onInviteClick, Function0<Unit> onScreenshareClick, boolean showStreamVolume, float perceptualStreamVolume, Function2<? super Float, ? super Boolean, Unit> onStreamVolumeChange, Function0<Unit> onDeafenPressed, int requestingToSpeakCount, Function0<Unit> onRaiseHandClick, Function0<Unit> onMoveToAudienceClick, boolean isUpdatingRequestToSpeak, StageRoles stageRoles) {
        int i;
        Intrinsics3.checkNotNullParameter(model, "model");
        Intrinsics3.checkNotNullParameter(outputSelectorState, "outputSelectorState");
        Intrinsics3.checkNotNullParameter(onStopWatchingClick, "onStopWatchingClick");
        Intrinsics3.checkNotNullParameter(onDisconnectClick, "onDisconnectClick");
        Intrinsics3.checkNotNullParameter(onAudioOutputClick, "onAudioOutputClick");
        Intrinsics3.checkNotNullParameter(onVideoClick, "onVideoClick");
        Intrinsics3.checkNotNullParameter(onMuteClick, "onMuteClick");
        Intrinsics3.checkNotNullParameter(onInviteClick, "onInviteClick");
        Intrinsics3.checkNotNullParameter(onScreenshareClick, "onScreenshareClick");
        Intrinsics3.checkNotNullParameter(onStreamVolumeChange, "onStreamVolumeChange");
        Intrinsics3.checkNotNullParameter(onDeafenPressed, "onDeafenPressed");
        Intrinsics3.checkNotNullParameter(onRaiseHandClick, "onRaiseHandClick");
        Intrinsics3.checkNotNullParameter(onMoveToAudienceClick, "onMoveToAudienceClick");
        ImageView imageView = this.binding.t;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.stopWatchingButton");
        imageView.setVisibility(showStopWatching ? 0 : 8);
        this.binding.t.setOnClickListener(new VoiceControlsSheetView7(onStopWatchingClick));
        if (stageRoles == null || StageRoles.m33isSpeakerimpl(stageRoles.m35unboximpl())) {
            MaterialTextView materialTextView = this.binding.f2218s;
            Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.stageDisconnectButtonLarge");
            i = 8;
            materialTextView.setVisibility(8);
            ImageView imageView2 = this.binding.g;
            imageView2.setImageResource(stageRoles == null ? R.drawable.ic_call_disconnect_24dp : R.drawable.ic_stage_leave_20dp);
            imageView2.setVisibility(showDisconnect ? 0 : 8);
            imageView2.setOnClickListener(new VoiceControlsSheetView5(stageRoles, showDisconnect, onDisconnectClick));
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.disconnectButton…sconnectClick() }\n      }");
        } else {
            ImageView imageView3 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.disconnectButton");
            imageView3.setVisibility(8);
            MaterialTextView materialTextView2 = this.binding.f2218s;
            materialTextView2.setVisibility(showDisconnect ? 0 : 8);
            materialTextView2.setOnClickListener(new VoiceControlsSheetView4(showDisconnect, onDisconnectClick));
            Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.stageDisconnectB…Click()\n        }\n      }");
            i = 8;
        }
        Button button = this.binding.m;
        Intrinsics3.checkNotNullExpressionValue(button, "binding.pushToTalkButton");
        if ((stageRoles == null || StageRoles.m33isSpeakerimpl(stageRoles.m35unboximpl())) && isPttEnabled) {
            i = 0;
        }
        button.setVisibility(i);
        TextView textView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.deafenSecondaryButton");
        FormatUtils.n(textView, isDeafened ? R.string.undeafen : R.string.deafen, new Object[0], null, 4);
        this.binding.f.setOnClickListener(new VoiceControlsSheetView8(onDeafenPressed));
        TextView textView2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.deafenSecondaryButton");
        textView2.setActivated(isDeafened);
        m61configureMoveToAudienceButtonyox5PQY(stageRoles, onMoveToAudienceClick);
        m63configureRaiseHandButtonfw_bWyM(model, stageRoles, requestingToSpeakCount, isUpdatingRequestToSpeak, onRaiseHandClick);
        m62configureMuteButtonP2fzehM(model, stageRoles, onMuteClick);
        configureOutputSelectors(outputSelectorState, onAudioOutputClick, (startedAsVideo || ChannelUtils.D(model.getChannel())) ? false : true);
        configureVideoButton(model, onVideoClick, isVideoEnabledForCall);
        configureScreenshareButtons(model, onScreenshareClick, startedAsVideo);
        configureStreamVolume(showStreamVolume, perceptualStreamVolume, onStreamVolumeChange);
        configureInviteButtons(model, onInviteClick, ChannelUtils.D(model.getChannel()));
    }

    public final int getPeekHeight() {
        LinearLayout linearLayout = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.peekContainer");
        return linearLayout.getMeasuredHeight();
    }

    public final void handleSheetState(int bottomSheetState) {
        CardView cardView = this.binding.r;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility((bottomSheetState != 4 || this.isGestureNavigationEnabled) ? 0 : 4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i;
        super.onAttachedToWindow();
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        if (resources.getConfiguration().orientation == 1) {
            Resources resources2 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
            i = resources2.getDisplayMetrics().widthPixels;
        } else {
            Resources resources3 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
            i = resources3.getDisplayMetrics().heightPixels;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    public final void setOnPTTListener(OnPressListener listener) {
        Intrinsics3.checkNotNullParameter(listener, "listener");
        this.binding.m.setOnTouchListener(listener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceControlsSheetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        VoiceControlsSheetViewBinding voiceControlsSheetViewBindingA = VoiceControlsSheetViewBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(voiceControlsSheetViewBindingA, "VoiceControlsSheetViewBi…ater.from(context), this)");
        this.binding = voiceControlsSheetViewBindingA;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        this.isGestureNavigationEnabled = DisplayUtils.isGestureNavigationEnabled(resources);
        CardView cardView = voiceControlsSheetViewBindingA.r;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility(this.isGestureNavigationEnabled ? 0 : 4);
    }

    public /* synthetic */ VoiceControlsSheetView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceControlsSheetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        VoiceControlsSheetViewBinding voiceControlsSheetViewBindingA = VoiceControlsSheetViewBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(voiceControlsSheetViewBindingA, "VoiceControlsSheetViewBi…ater.from(context), this)");
        this.binding = voiceControlsSheetViewBindingA;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        this.isGestureNavigationEnabled = DisplayUtils.isGestureNavigationEnabled(resources);
        CardView cardView = voiceControlsSheetViewBindingA.r;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility(this.isGestureNavigationEnabled ? 0 : 4);
    }

    public /* synthetic */ VoiceControlsSheetView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
