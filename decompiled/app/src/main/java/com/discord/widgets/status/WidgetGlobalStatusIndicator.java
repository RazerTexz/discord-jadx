package com.discord.widgets.status;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.stageinstance.StageInstance;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetGlobalStatusIndicatorBinding;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.textprocessing.SpannableUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.voice.VoiceViewUtils;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorState;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetGlobalStatusIndicator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u00011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b<\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J=\u0010\n\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b\u0018\u00010\u00070\u0007*\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b!\u0010\u0006J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u0018R\u001d\u0010\u0003\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001d\u00109\u001a\u0002048B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicator;", "Lcom/discord/app/AppFragment;", "Lcom/discord/databinding/WidgetGlobalStatusIndicatorBinding;", "binding", "", "onViewBindingDestroy", "(Lcom/discord/databinding/WidgetGlobalStatusIndicatorBinding;)V", "Lrx/Observable;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;", "kotlin.jvm.PlatformType", "bindDelay", "(Lrx/Observable;)Lrx/Observable;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;", "state", "configureUIVisibility", "(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;)V", "viewState", "configureUI", "(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;)V", "", "isAirplaneMode", "setupOfflineState", "(Z)V", "setupConnectingState", "()V", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing;", "setupContainerClicks", "(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing;)V", "setupIndicatorStatus", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing;", "setupStageContainerClicks", "(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing;)V", "setupStageIndicatorStatus", "resetContentVisibility", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGlobalStatusIndicatorBinding;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState;", "indicatorState", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState;", "Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;", "connectingVector", "Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;", "com/discord/widgets/status/WidgetGlobalStatusIndicator$connectingVectorReplayCallback$1", "connectingVectorReplayCallback", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicator$connectingVectorReplayCallback$1;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel;", "viewModel", "lastIndicatorState", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicator extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGlobalStatusIndicator.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGlobalStatusIndicatorBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private AnimatedVectorDrawableCompat connectingVector;
    private final WidgetGlobalStatusIndicator4 connectingVectorReplayCallback;
    private final WidgetGlobalStatusIndicatorState indicatorState;
    private WidgetGlobalStatusIndicatorState.State lastIndicatorState;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGlobalStatusIndicator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;", "kotlin.jvm.PlatformType", "viewState", "Lrx/Observable;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$bindDelay$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<WidgetGlobalStatusIndicatorViewModel.ViewState, Observable<? extends WidgetGlobalStatusIndicatorViewModel.ViewState>> {
        public final /* synthetic */ Observable $this_bindDelay;

        public AnonymousClass1(Observable observable) {
            this.$this_bindDelay = observable;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends WidgetGlobalStatusIndicatorViewModel.ViewState> call(WidgetGlobalStatusIndicatorViewModel.ViewState viewState) {
            return call2(viewState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends WidgetGlobalStatusIndicatorViewModel.ViewState> call2(WidgetGlobalStatusIndicatorViewModel.ViewState viewState) {
            Long lValueOf = viewState instanceof WidgetGlobalStatusIndicatorViewModel.ViewState.Offline ? Long.valueOf(((WidgetGlobalStatusIndicatorViewModel.ViewState.Offline) viewState).getDelay()) : viewState instanceof WidgetGlobalStatusIndicatorViewModel.ViewState.Connecting ? Long.valueOf(((WidgetGlobalStatusIndicatorViewModel.ViewState.Connecting) viewState).getDelay()) : null;
            if (lValueOf == null) {
                return this.$this_bindDelay;
            }
            lValueOf.longValue();
            return new ScalarSynchronousObservable(viewState).q(lValueOf.longValue(), TimeUnit.MILLISECONDS);
        }
    }

    /* compiled from: WidgetGlobalStatusIndicator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "container", "Landroidx/core/view/WindowInsetsCompat;", "insets", "kotlin.jvm.PlatformType", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullParameter(view, "container");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            view.setPadding(view.getPaddingLeft(), windowInsetsCompat.getSystemWindowInsetTop(), view.getPaddingRight(), view.getPaddingBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* compiled from: WidgetGlobalStatusIndicator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;", "p1", "", "invoke", "(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetGlobalStatusIndicatorState.State, Unit> {
        public AnonymousClass1(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
            super(1, widgetGlobalStatusIndicator, WidgetGlobalStatusIndicator.class, "configureUIVisibility", "configureUIVisibility(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorState.State state) {
            invoke2(state);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGlobalStatusIndicatorState.State state) {
            Intrinsics3.checkNotNullParameter(state, "p1");
            WidgetGlobalStatusIndicator.access$configureUIVisibility((WidgetGlobalStatusIndicator) this.receiver, state);
        }
    }

    /* compiled from: WidgetGlobalStatusIndicator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetGlobalStatusIndicatorViewModel.ViewState, Unit> {
        public AnonymousClass2(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
            super(1, widgetGlobalStatusIndicator, WidgetGlobalStatusIndicator.class, "configureUI", "configureUI(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGlobalStatusIndicatorViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGlobalStatusIndicator.access$configureUI((WidgetGlobalStatusIndicator) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGlobalStatusIndicator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$setupContainerClicks$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetGlobalStatusIndicatorViewModel.ViewState.CallOngoing $viewState;

        public AnonymousClass1(WidgetGlobalStatusIndicatorViewModel.ViewState.CallOngoing callOngoing) {
            this.$viewState = callOngoing;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelApplicationStream stream;
            ModelApplicationStream stream2;
            StreamContext streamContext;
            if (ChannelUtils.B(this.$viewState.getSelectedVoiceChannel())) {
                WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, WidgetGlobalStatusIndicator.this.requireContext(), this.$viewState.getSelectedVoiceChannel().getId(), false, null, null, 28, null);
                return;
            }
            TextInVoiceFeatureFlag instance = TextInVoiceFeatureFlag.INSTANCE.getINSTANCE();
            Channel selectedTextChannel = this.$viewState.getSelectedTextChannel();
            String encodedStreamKey = null;
            if (!instance.isEnabled(selectedTextChannel != null ? Long.valueOf(selectedTextChannel.getGuildId()) : null) && ((streamContext = this.$viewState.getStreamContext()) == null || !streamContext.isCurrentUserParticipating())) {
                WidgetVoiceBottomSheet.Companion companion = WidgetVoiceBottomSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetGlobalStatusIndicator.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, this.$viewState.getSelectedVoiceChannel().getId(), true, WidgetVoiceBottomSheet.FeatureContext.HOME);
                return;
            }
            Channel selectedTextChannel2 = this.$viewState.getSelectedTextChannel();
            AppTransitionActivity.Transition transition = (selectedTextChannel2 == null || !ChannelUtils.J(selectedTextChannel2)) ? AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE : AppTransitionActivity.Transition.TYPE_SLIDE_HORIZONTAL_REVERSE;
            WidgetCallFullscreen.Companion companion2 = WidgetCallFullscreen.INSTANCE;
            Context contextRequireContext = WidgetGlobalStatusIndicator.this.requireContext();
            StreamContext streamContext2 = this.$viewState.getStreamContext();
            long id2 = (streamContext2 == null || (stream2 = streamContext2.getStream()) == null) ? this.$viewState.getSelectedVoiceChannel().getId() : stream2.getChannelId();
            StreamContext streamContext3 = this.$viewState.getStreamContext();
            if (streamContext3 != null && (stream = streamContext3.getStream()) != null) {
                encodedStreamKey = stream.getEncodedStreamKey();
            }
            WidgetCallFullscreen.Companion.launch$default(companion2, contextRequireContext, id2, false, encodedStreamKey, transition, 4, null);
        }
    }

    /* compiled from: WidgetGlobalStatusIndicator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$setupStageContainerClicks$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetGlobalStatusIndicatorViewModel.ViewState.StageChannelOngoing $viewState;

        public AnonymousClass1(WidgetGlobalStatusIndicatorViewModel.ViewState.StageChannelOngoing stageChannelOngoing) {
            this.$viewState = stageChannelOngoing;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, WidgetGlobalStatusIndicator.this.requireContext(), this.$viewState.getSelectedVoiceChannel().getId(), false, null, null, 28, null);
        }
    }

    /* compiled from: WidgetGlobalStatusIndicator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$setupStageContainerClicks$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {

        /* compiled from: WidgetGlobalStatusIndicator.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$setupStageContainerClicks$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
                AppToast.g(WidgetGlobalStatusIndicator.this.getContext(), R.string.stage_channel_permission_microphone_denied, 0, null, 12);
            }
        }

        /* compiled from: WidgetGlobalStatusIndicator.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$setupStageContainerClicks$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C03482 extends Lambda implements Function0<Unit> {
            public C03482() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetGlobalStatusIndicator.access$getViewModel$p(WidgetGlobalStatusIndicator.this).ackStageInvitationToSpeak(true);
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGlobalStatusIndicator.this.requestMicrophone(new AnonymousClass1(), new C03482());
        }
    }

    /* compiled from: WidgetGlobalStatusIndicator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$setupStageContainerClicks$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGlobalStatusIndicator.access$getViewModel$p(WidgetGlobalStatusIndicator.this).ackStageInvitationToSpeak(false);
        }
    }

    public WidgetGlobalStatusIndicator() {
        super(R.layout.widget_global_status_indicator);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetGlobalStatusIndicator2.INSTANCE, new WidgetGlobalStatusIndicator3(this));
        this.indicatorState = WidgetGlobalStatusIndicatorState.INSTANCE.get();
        WidgetGlobalStatusIndicator5 widgetGlobalStatusIndicator5 = WidgetGlobalStatusIndicator5.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGlobalStatusIndicatorViewModel.class), new WidgetGlobalStatusIndicator$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGlobalStatusIndicator5));
        this.connectingVectorReplayCallback = new WidgetGlobalStatusIndicator4(this);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator, WidgetGlobalStatusIndicatorViewModel.ViewState viewState) {
        widgetGlobalStatusIndicator.configureUI(viewState);
    }

    public static final /* synthetic */ void access$configureUIVisibility(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator, WidgetGlobalStatusIndicatorState.State state) {
        widgetGlobalStatusIndicator.configureUIVisibility(state);
    }

    public static final /* synthetic */ AnimatedVectorDrawableCompat access$getConnectingVector$p(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
        return widgetGlobalStatusIndicator.connectingVector;
    }

    public static final /* synthetic */ WidgetGlobalStatusIndicatorViewModel access$getViewModel$p(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
        return widgetGlobalStatusIndicator.getViewModel();
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator, WidgetGlobalStatusIndicatorBinding widgetGlobalStatusIndicatorBinding) {
        widgetGlobalStatusIndicator.onViewBindingDestroy(widgetGlobalStatusIndicatorBinding);
    }

    public static final /* synthetic */ void access$setConnectingVector$p(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator, AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        widgetGlobalStatusIndicator.connectingVector = animatedVectorDrawableCompat;
    }

    private final Observable<WidgetGlobalStatusIndicatorViewModel.ViewState> bindDelay(Observable<WidgetGlobalStatusIndicatorViewModel.ViewState> observable) {
        return observable.Y(new AnonymousClass1(observable));
    }

    private final void configureUI(WidgetGlobalStatusIndicatorViewModel.ViewState viewState) {
        WidgetGlobalStatusIndicatorState.updateState$default(this.indicatorState, !Intrinsics3.areEqual(viewState, WidgetGlobalStatusIndicatorViewModel.ViewState.Inactive.INSTANCE), viewState.getIsSpeakingInOngoingCall(), false, 4, null);
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.connectingVector;
        if (animatedVectorDrawableCompat != null) {
            animatedVectorDrawableCompat.unregisterAnimationCallback(this.connectingVectorReplayCallback);
        }
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = this.connectingVector;
        if (animatedVectorDrawableCompat2 != null) {
            animatedVectorDrawableCompat2.stop();
        }
        if (viewState instanceof WidgetGlobalStatusIndicatorViewModel.ViewState.Offline) {
            setupOfflineState(((WidgetGlobalStatusIndicatorViewModel.ViewState.Offline) viewState).getAirplaneMode());
        } else if (viewState instanceof WidgetGlobalStatusIndicatorViewModel.ViewState.Connecting) {
            setupConnectingState();
        } else if (viewState instanceof WidgetGlobalStatusIndicatorViewModel.ViewState.CallOngoing) {
            WidgetGlobalStatusIndicatorViewModel.ViewState.CallOngoing callOngoing = (WidgetGlobalStatusIndicatorViewModel.ViewState.CallOngoing) viewState;
            setupContainerClicks(callOngoing);
            setupIndicatorStatus(callOngoing);
        } else if (viewState instanceof WidgetGlobalStatusIndicatorViewModel.ViewState.StageChannelOngoing) {
            WidgetGlobalStatusIndicatorViewModel.ViewState.StageChannelOngoing stageChannelOngoing = (WidgetGlobalStatusIndicatorViewModel.ViewState.StageChannelOngoing) viewState;
            setupStageContainerClicks(stageChannelOngoing);
            setupStageIndicatorStatus(stageChannelOngoing);
        } else {
            resetContentVisibility(getBinding());
        }
        WidgetGlobalStatusIndicatorState.State state = this.lastIndicatorState;
        if (state == null || !state.isViewingCall()) {
            return;
        }
        LinearLayout linearLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.indicator");
        LinearLayout linearLayout2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.indicatorActions");
        linearLayout.setVisibility(linearLayout2.getVisibility() == 0 ? 0 : 8);
    }

    private final void configureUIVisibility(WidgetGlobalStatusIndicatorState.State state) {
        this.lastIndicatorState = state;
        LinearLayout linearLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.indicator");
        linearLayout.setVisibility(state.isVisible() ? 0 : 8);
    }

    private final WidgetGlobalStatusIndicatorBinding getBinding() {
        return (WidgetGlobalStatusIndicatorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGlobalStatusIndicatorViewModel getViewModel() {
        return (WidgetGlobalStatusIndicatorViewModel) this.viewModel.getValue();
    }

    private final void onViewBindingDestroy(WidgetGlobalStatusIndicatorBinding binding) {
        resetContentVisibility(binding);
    }

    private final void resetContentVisibility(WidgetGlobalStatusIndicatorBinding binding) {
        LinearLayout linearLayout = binding.f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.indicatorContent");
        linearLayout.setVisibility(0);
        TextView textView = binding.f2405b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.alertText");
        textView.setVisibility(8);
    }

    private final void setupConnectingState() {
        resetContentVisibility(getBinding());
        getBinding().c.setBackgroundColor(ColorCompat.getThemedColor(requireContext(), R.attr.colorBackgroundTertiary));
        getBinding().i.setTextColor(ColorCompat.getThemedColor(requireContext(), R.attr.colorHeaderPrimary));
        TextView textView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.indicatorText");
        textView.setText(getString(R.string.connecting));
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = null;
        if (this.connectingVector == null && Build.VERSION.SDK_INT != 28) {
            this.connectingVector = AnimatedVectorDrawableCompat.create(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.ic_network_connecting_animated_vector, 0, 2, (Object) null));
        }
        ImageView imageView = getBinding().h;
        imageView.setVisibility(0);
        if (Build.VERSION.SDK_INT == 28) {
            imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.ic_network_connecting, 0, 2, (Object) null));
            return;
        }
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = this.connectingVector;
        if (animatedVectorDrawableCompat2 != null) {
            animatedVectorDrawableCompat2.registerAnimationCallback(this.connectingVectorReplayCallback);
            animatedVectorDrawableCompat2.start();
            animatedVectorDrawableCompat = animatedVectorDrawableCompat2;
        }
        imageView.setImageDrawable(animatedVectorDrawableCompat);
    }

    private final void setupContainerClicks(WidgetGlobalStatusIndicatorViewModel.ViewState.CallOngoing viewState) {
        getBinding().c.setOnClickListener(new AnonymousClass1(viewState));
    }

    private final void setupIndicatorStatus(WidgetGlobalStatusIndicatorViewModel.ViewState.CallOngoing viewState) {
        String name;
        String strY;
        LinearLayout linearLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.indicatorActions");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = getBinding().c;
        VoiceViewUtils voiceViewUtils = VoiceViewUtils.INSTANCE;
        linearLayout2.setBackgroundColor(voiceViewUtils.getConnectionStatusColor(viewState.getConnectionState(), viewState.getConnectionQuality(), requireContext()));
        String strE = ChannelUtils.e(viewState.getSelectedVoiceChannel(), requireContext(), false, 2);
        CharSequence connectedText = voiceViewUtils.getConnectedText(requireContext(), viewState.getConnectionState(), viewState.getStreamContext(), viewState.getHasVideo());
        Guild guild = viewState.getGuild();
        if (guild != null && (name = guild.getName()) != null && (strY = outline.y(name, " / ", strE)) != null) {
            strE = strY;
        }
        String str = connectedText + ": " + strE;
        TextView textView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.indicatorText");
        textView.setText(str);
        getBinding().i.setTextColor(ColorCompat.getColor(getContext(), R.color.white));
        ImageView imageView = getBinding().h;
        imageView.setVisibility(0);
        imageView.setImageResource(voiceViewUtils.getCallIndicatorIcon(viewState.getHasVideo(), viewState.getStreamContext()));
    }

    private final void setupOfflineState(boolean isAirplaneMode) {
        resetContentVisibility(getBinding());
        getBinding().c.setBackgroundColor(ColorCompat.getThemedColor(requireContext(), R.attr.colorBackgroundTertiary));
        getBinding().i.setTextColor(ColorCompat.getThemedColor(requireContext(), R.attr.colorHeaderPrimary));
        getBinding().i.setText(isAirplaneMode ? R.string.network_offline_airplane_mode : R.string.network_offline);
        ImageView imageView = getBinding().h;
        imageView.setVisibility(0);
        imageView.setImageResource(isAirplaneMode ? DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.ic_network_airplane_mode, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.ic_network_offline, 0, 2, (Object) null));
    }

    private final void setupStageContainerClicks(WidgetGlobalStatusIndicatorViewModel.ViewState.StageChannelOngoing viewState) {
        getBinding().c.setOnClickListener(new AnonymousClass1(viewState));
        getBinding().d.setOnClickListener(new AnonymousClass2());
        getBinding().g.setOnClickListener(new AnonymousClass3());
    }

    private final void setupStageIndicatorStatus(WidgetGlobalStatusIndicatorViewModel.ViewState.StageChannelOngoing viewState) {
        resetContentVisibility(getBinding());
        int color = viewState.getIsSpeakingInOngoingCall() ? ContextCompat.getColor(requireContext(), R.color.white) : ColorCompat.getThemedColor(requireContext(), R.attr.colorHeaderPrimary);
        getBinding().c.setBackgroundColor(viewState.getIsSpeakingInOngoingCall() ? ContextCompat.getColor(requireContext(), R.color.status_green_600) : ColorCompat.getThemedColor(requireContext(), R.attr.colorBackgroundTertiary));
        getBinding().i.setTextColor(color);
        getBinding().g.setTextColor(color);
        LinearLayout linearLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.indicatorActions");
        linearLayout.setVisibility(viewState.isInvitedToSpeak() ? 0 : 8);
        ImageView imageView = getBinding().h;
        WidgetGlobalStatusIndicatorState.State state = this.lastIndicatorState;
        imageView.setVisibility(state != null && !state.isViewingCall() ? 0 : 8);
        Drawable drawable = ContextCompat.getDrawable(imageView.getContext(), R.drawable.ic_channel_stage_16dp);
        if (drawable != null) {
            Intrinsics3.checkNotNullExpressionValue(drawable, "drawable");
            ColorCompat2.setTint(drawable, color, false);
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
        if (!viewState.isInvitedToSpeak()) {
            StageInstance stageInstance = viewState.getStageInstance();
            String topic = stageInstance != null ? stageInstance.getTopic() : null;
            Guild guild = viewState.getGuild();
            name = guild != null ? guild.getName() : null;
            String name = viewState.getSelectedVoiceChannel().getName();
            Context contextRequireContext = requireContext();
            TextView textView = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.indicatorText");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (topic != null) {
                SpannableUtils.appendWithFont(spannableStringBuilder, contextRequireContext, R.attr.font_primary_semibold, topic);
                SpannableUtils.appendWithFont(spannableStringBuilder, contextRequireContext, R.attr.font_primary_semibold, ": ");
            }
            if (name != null) {
                SpannableUtils.appendWithFont(spannableStringBuilder, contextRequireContext, R.attr.font_primary_normal, name);
                SpannableUtils.appendWithFont(spannableStringBuilder, contextRequireContext, R.attr.font_primary_normal, ": ");
            }
            if (name != null) {
                SpannableUtils.appendWithFont(spannableStringBuilder, contextRequireContext, R.attr.font_primary_normal, name);
            }
            textView.setText(spannableStringBuilder);
            return;
        }
        getBinding().i.setText(R.string.stage_speak_invite_header);
        getBinding().d.setText(R.string.stage_speak_invite_accept);
        MaterialButton materialButton = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.indicatorAccept");
        materialButton.setEnabled(!viewState.isAckingInvitation());
        getBinding().g.setText(R.string.stage_speak_invite_decline);
        MaterialButton materialButton2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.indicatorDecline");
        materialButton2.setEnabled(!viewState.isAckingInvitation());
        TextView textView2 = getBinding().f2405b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.alertText");
        textView2.setVisibility(viewState.getBlockedUsersOnStage() != 0 ? 0 : 8);
        TextView textView3 = getBinding().f2405b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.alertText");
        Context context = getContext();
        if (context != null) {
            Object[] objArr = new Object[1];
            Context context2 = getContext();
            objArr[0] = context2 != null ? StringResourceUtils.getI18nPluralString(context2, R.plurals.stage_speak_invite_blocked_users_number, viewState.getBlockedUsersOnStage(), Integer.valueOf(viewState.getBlockedUsersOnStage())) : null;
            name = FormatUtils.h(context, R.string.stage_speak_invite_blocked_users, objArr, null, 4);
        }
        textView3.setText(name);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ViewCompat.setOnApplyWindowInsetsListener(view, AnonymousClass1.INSTANCE);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(this.indicatorState.observeState(), this, null, 2, null), WidgetGlobalStatusIndicator.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        Observable<WidgetGlobalStatusIndicatorViewModel.ViewState> observableBindDelay = bindDelay(getViewModel().observeViewState());
        Intrinsics3.checkNotNullExpressionValue(observableBindDelay, "viewModel\n        .obser…te()\n        .bindDelay()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableBindDelay, this, null, 2, null), WidgetGlobalStatusIndicator.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
