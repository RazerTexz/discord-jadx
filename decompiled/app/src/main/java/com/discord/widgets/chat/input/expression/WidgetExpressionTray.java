package com.discord.widgets.chat.input.expression;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates2;
import b.b.a.FlexInputExpressionTrayStateChangeListener;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetExpressionTrayBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ContentResizingCoordinatorLayout;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.OnBackspacePressedListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerMode;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import com.discord.widgets.chat.input.emoji.WidgetEmojiPicker;
import com.discord.widgets.chat.input.expression.ExpressionDetailPage;
import com.discord.widgets.chat.input.expression.ExpressionTrayViewModel;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import com.discord.widgets.chat.input.gifpicker.WidgetGifCategory;
import com.discord.widgets.chat.input.gifpicker.WidgetGifPicker;
import com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSheet;
import com.discord.widgets.chat.input.sticker.StickerPickerListener;
import com.discord.widgets.chat.input.sticker.StickerPickerMode;
import com.discord.widgets.chat.input.sticker.WidgetStickerPicker;
import com.discord.widgets.chat.input.sticker.WidgetStickerPickerSheet;
import com.google.android.material.appbar.AppBarLayout;
import d0.Tuples;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetExpressionTray.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 n2\u00020\u00012\u00020\u0002:\u0001nB\u0007¢\u0006\u0004\bm\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\tJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J'\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H\u0002¢\u0006\u0004\b \u0010\u0005J\u000f\u0010!\u001a\u00020\u0003H\u0002¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\"\u0010\u0005J\u0017\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0003H\u0002¢\u0006\u0004\b'\u0010\u0005J\u0017\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0010H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00032\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0003H\u0016¢\u0006\u0004\b/\u0010\u0005J\u0017\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020#H\u0016¢\u0006\u0004\b1\u0010&J\u001b\u00104\u001a\u00020\u00032\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000302¢\u0006\u0004\b4\u00105J\u0015\u00108\u001a\u00020\u00032\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0015\u0010<\u001a\u00020\u00032\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\u00032\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b@\u0010AR\u001e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bE\u0010FR\u001d\u0010L\u001a\u00020G8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010MR\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010NR\u0016\u0010O\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\"\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020+0Q8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010TR\u0016\u0010U\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010PR\u0016\u0010V\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010PR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bX\u0010YR:\u0010\\\u001a&\u0012\f\u0012\n [*\u0004\u0018\u00010#0# [*\u0012\u0012\f\u0012\n [*\u0004\u0018\u00010#0#\u0018\u00010Z0Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u001d\u0010c\u001a\u00020^8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u0016\u0010d\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010PR\u001d\u0010i\u001a\u00020e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010`\u001a\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020j8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bk\u0010l¨\u0006o"}, d2 = {"Lcom/discord/widgets/chat/input/expression/WidgetExpressionTray;", "Lb/b/a/c;", "Lcom/discord/app/AppFragment;", "", "fetchDataForTrayOpen", "()V", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$ViewState;", "viewState", "handleViewState", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$ViewState;)V", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event;)V", "configureLandingPage", "configureDetailPage", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;", "tab", "", "getTabIndexFromTabType", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;)I", "setUpTabs", "initializeExpressionTabToViewsMap", "setUpEmojiPicker", "setUpGifPicker", "setUpStickerPicker", "fragmentId", "fragment", "", "fragmentName", "setupTabFragment", "(ILcom/discord/app/AppFragment;Ljava/lang/String;)V", "setWindowInsetsListeners", "onGifSelected", "onGifSearchSheetCanceled", "", "show", "showStickersSearchBar", "(Z)V", "trackExpressionPickerOpened", "clickedTab", "trackExpressionPickerTabClicked", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "isActive", "isShown", "Lkotlin/Function0;", "callback", "setOnEmojiSearchOpenedListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerListener;", "emojiPickerListener", "setEmojiPickerListener", "(Lcom/discord/widgets/chat/input/emoji/EmojiPickerListener;)V", "Lcom/discord/widgets/chat/input/sticker/StickerPickerListener;", "stickerPickerListener", "setStickerPickerListener", "(Lcom/discord/widgets/chat/input/sticker/StickerPickerListener;)V", "Lcom/discord/widgets/chat/input/OnBackspacePressedListener;", "onBackspacePressedListener", "setOnBackspacePressedListener", "(Lcom/discord/widgets/chat/input/OnBackspacePressedListener;)V", "onEmojiSearchOpenedListener", "Lkotlin/jvm/functions/Function0;", "Lcom/discord/widgets/chat/input/gifpicker/WidgetGifPicker;", "gifPickerFragment", "Lcom/discord/widgets/chat/input/gifpicker/WidgetGifPicker;", "Lcom/discord/databinding/WidgetExpressionTrayBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetExpressionTrayBinding;", "binding", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerListener;", "Lcom/discord/widgets/chat/input/OnBackspacePressedListener;", "gifPickerInitialized", "Z", "", "expressionTabToContentViewsMap", "Ljava/util/Map;", "Lcom/discord/widgets/chat/input/sticker/StickerPickerListener;", "emojiPickerInitialized", "stickerPickerInitialized", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiPicker;", "emojiPickerFragment", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiPicker;", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "isAtInitialScrollPositionSubject", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "flexInputViewModel$delegate", "Lkotlin/Lazy;", "getFlexInputViewModel", "()Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "flexInputViewModel", "wasActive", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel;", "expressionTrayViewModel$delegate", "getExpressionTrayViewModel", "()Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel;", "expressionTrayViewModel", "Lcom/discord/widgets/chat/input/sticker/WidgetStickerPicker;", "stickerPickerFragment", "Lcom/discord/widgets/chat/input/sticker/WidgetStickerPicker;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetExpressionTray extends AppFragment implements FlexInputExpressionTrayStateChangeListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetExpressionTray.class, "binding", "getBinding()Lcom/discord/databinding/WidgetExpressionTrayBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BehaviorSubject<Boolean> isExpressionTrayActiveSubject;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetEmojiPicker emojiPickerFragment;
    private boolean emojiPickerInitialized;
    private EmojiPickerListener emojiPickerListener;
    private Map<ExpressionTrayTab, ? extends View> expressionTabToContentViewsMap;

    /* renamed from: expressionTrayViewModel$delegate, reason: from kotlin metadata */
    private final Lazy expressionTrayViewModel;

    /* renamed from: flexInputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy flexInputViewModel;
    private WidgetGifPicker gifPickerFragment;
    private boolean gifPickerInitialized;
    private final BehaviorSubject<Boolean> isAtInitialScrollPositionSubject;
    private OnBackspacePressedListener onBackspacePressedListener;
    private Function0<Unit> onEmojiSearchOpenedListener;
    private WidgetStickerPicker stickerPickerFragment;
    private boolean stickerPickerInitialized;
    private StickerPickerListener stickerPickerListener;
    private boolean wasActive;

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/chat/input/expression/WidgetExpressionTray$Companion;", "", "Lrx/subjects/BehaviorSubject;", "", "isExpressionTrayActiveSubject", "Lrx/subjects/BehaviorSubject;", "()Lrx/subjects/BehaviorSubject;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final BehaviorSubject<Boolean> isExpressionTrayActiveSubject() {
            return WidgetExpressionTray.access$isExpressionTrayActiveSubject$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            ExpressionTrayTab.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            ExpressionTrayTab expressionTrayTab = ExpressionTrayTab.EMOJI;
            iArr[expressionTrayTab.ordinal()] = 1;
            ExpressionTrayTab expressionTrayTab2 = ExpressionTrayTab.GIF;
            iArr[expressionTrayTab2.ordinal()] = 2;
            ExpressionTrayTab expressionTrayTab3 = ExpressionTrayTab.STICKER;
            iArr[expressionTrayTab3.ordinal()] = 3;
            ExpressionTrayTab.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[expressionTrayTab.ordinal()] = 1;
            iArr2[expressionTrayTab2.ordinal()] = 2;
            iArr2[expressionTrayTab3.ordinal()] = 3;
            ExpressionTrayTab.values();
            int[] iArr3 = new int[3];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[expressionTrayTab.ordinal()] = 1;
            iArr3[expressionTrayTab2.ordinal()] = 2;
            iArr3[expressionTrayTab3.ordinal()] = 3;
            ExpressionTrayTab.values();
            int[] iArr4 = new int[3];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[expressionTrayTab.ordinal()] = 1;
            iArr4[expressionTrayTab2.ordinal()] = 2;
            iArr4[expressionTrayTab3.ordinal()] = 3;
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$handleEvent$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(WidgetExpressionTray widgetExpressionTray) {
            super(0, widgetExpressionTray, WidgetExpressionTray.class, "onGifSelected", "onGifSelected()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetExpressionTray.access$onGifSelected((WidgetExpressionTray) this.receiver);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$handleEvent$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(WidgetExpressionTray widgetExpressionTray) {
            super(0, widgetExpressionTray, WidgetExpressionTray.class, "onGifSearchSheetCanceled", "onGifSearchSheetCanceled()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetExpressionTray.access$onGifSearchSheetCanceled((WidgetExpressionTray) this.receiver);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0005\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "invoke", "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$handleEvent$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ ExpressionTrayViewModel.Event $event;
        public final /* synthetic */ WidgetStickerPickerSheet $pickerSheet;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(WidgetStickerPickerSheet widgetStickerPickerSheet, ExpressionTrayViewModel.Event event) {
            super(1);
            this.$pickerSheet = widgetStickerPickerSheet;
            this.$event = event;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            this.$pickerSheet.scrollToPack(((ExpressionTrayViewModel.Event.ShowStickerPicker) this.$event).getStickerPackId());
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ExpressionTrayViewModel expressionTrayViewModelAccess$getExpressionTrayViewModel$p = WidgetExpressionTray.access$getExpressionTrayViewModel$p(WidgetExpressionTray.this);
            TextView textView = WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).j;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
            expressionTrayViewModelAccess$getExpressionTrayViewModel$p.clickSearch(textView.getText().toString());
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/google/android/material/appbar/AppBarLayout;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "verticalOffset", "", "onOffsetChanged", "(Lcom/google/android/material/appbar/AppBarLayout;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements AppBarLayout.OnOffsetChangedListener {
        public AnonymousClass2() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            WidgetExpressionTray.access$isAtInitialScrollPositionSubject$p(WidgetExpressionTray.this).onNext(Boolean.valueOf(i == 0));
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ExpressionTrayViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel.ViewState viewState) throws Resources.NotFoundException {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ExpressionTrayViewModel.ViewState viewState) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetExpressionTray.access$handleViewState(WidgetExpressionTray.this, viewState);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event;", "event", "", "invoke", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ExpressionTrayViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ExpressionTrayViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetExpressionTray.access$handleEvent(WidgetExpressionTray.this, event);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setUpGifPicker$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GifCategoryItem, Unit> {
        public AnonymousClass1(ExpressionTrayViewModel expressionTrayViewModel) {
            super(1, expressionTrayViewModel, ExpressionTrayViewModel.class, "selectGifCategory", "selectGifCategory(Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifCategoryItem gifCategoryItem) {
            invoke2(gifCategoryItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifCategoryItem gifCategoryItem) {
            Intrinsics3.checkNotNullParameter(gifCategoryItem, "p1");
            ((ExpressionTrayViewModel) this.receiver).selectGifCategory(gifCategoryItem);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setUpStickerPicker$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(WidgetExpressionTray widgetExpressionTray) {
            super(1, widgetExpressionTray, WidgetExpressionTray.class, "showStickersSearchBar", "showStickersSearchBar(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetExpressionTray.access$showStickersSearchBar((WidgetExpressionTray) this.receiver, z2);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setUpStickerPicker$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
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
            WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).n.scrollTo(0, 0);
            WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).n.setExpanded(true, false);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "index", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setUpTabs$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            ExpressionTrayTab expressionTrayTab = ExpressionTrayTab.values()[i];
            TextView textView = WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).j;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
            textView.setText("");
            if (WidgetExpressionTray.access$getStickerPickerInitialized$p(WidgetExpressionTray.this) && WidgetExpressionTray.access$getStickerPickerFragment$p(WidgetExpressionTray.this).isVisible()) {
                WidgetExpressionTray.access$getStickerPickerFragment$p(WidgetExpressionTray.this).clearSearchInput();
            }
            WidgetExpressionTray.access$getExpressionTrayViewModel$p(WidgetExpressionTray.this).selectTab(expressionTrayTab);
            WidgetExpressionTray.access$trackExpressionPickerTabClicked(WidgetExpressionTray.this, expressionTrayTab);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "Landroidx/core/view/WindowInsetsCompat;", "insets", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setWindowInsetsListeners$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnApplyWindowInsetsListener {
        public AnonymousClass1() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            ViewCompat.dispatchApplyWindowInsets(WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).e, windowInsetsCompat);
            ViewCompat.dispatchApplyWindowInsets(WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).g, windowInsetsCompat);
            return ViewCompat.dispatchApplyWindowInsets(WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).m, windowInsetsCompat);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "Landroidx/core/view/WindowInsetsCompat;", "insets", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$setWindowInsetsListeners$2, reason: invalid class name */
    public static final class AnonymousClass2 implements OnApplyWindowInsetsListener {
        public AnonymousClass2() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return ViewCompat.dispatchApplyWindowInsets(WidgetExpressionTray.access$getBinding$p(WidgetExpressionTray.this).c, windowInsetsCompat);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$ViewState;", "kotlin.jvm.PlatformType", "viewState", "", "invoke", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$trackExpressionPickerOpened$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ExpressionTrayViewModel.ViewState, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ExpressionTrayViewModel.ViewState viewState) {
            String str;
            int iOrdinal = viewState.getSelectedExpressionTab().ordinal();
            if (iOrdinal == 0) {
                str = "emoji";
            } else if (iOrdinal == 1) {
                str = IconUtils.ANIMATED_IMAGE_EXTENSION;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "sticker";
            }
            AnalyticsTracker.INSTANCE.expressionPickerOpened(str, false);
        }
    }

    /* compiled from: WidgetExpressionTray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$ViewState;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$trackExpressionPickerTabClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ExpressionTrayViewModel.ViewState, Unit> {
        public final /* synthetic */ ExpressionTrayTab $clickedTab;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ExpressionTrayTab expressionTrayTab) {
            super(1);
            this.$clickedTab = expressionTrayTab;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ExpressionTrayViewModel.ViewState viewState) {
            String str;
            int iOrdinal = this.$clickedTab.ordinal();
            if (iOrdinal == 0) {
                str = "emoji";
            } else if (iOrdinal == 1) {
                str = IconUtils.ANIMATED_IMAGE_EXTENSION;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "sticker";
            }
            AnalyticsTracker.INSTANCE.expressionPickerTabClicked(str, false);
        }
    }

    static {
        BehaviorSubject<Boolean> behaviorSubjectL0 = BehaviorSubject.l0(Boolean.FALSE);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(false)");
        isExpressionTrayActiveSubject = behaviorSubjectL0;
    }

    public WidgetExpressionTray() {
        super(R.layout.widget_expression_tray);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetExpressionTray2.INSTANCE, null, 2, null);
        this.expressionTrayViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ExpressionTrayViewModel.class), new WidgetExpressionTray$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetExpressionTray4.INSTANCE));
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(AppFlexInputViewModel.class), new WidgetExpressionTray$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(new WidgetExpressionTray5(this)));
        this.isAtInitialScrollPositionSubject = BehaviorSubject.l0(Boolean.TRUE);
    }

    public static final /* synthetic */ WidgetExpressionTrayBinding access$getBinding$p(WidgetExpressionTray widgetExpressionTray) {
        return widgetExpressionTray.getBinding();
    }

    public static final /* synthetic */ ExpressionTrayViewModel access$getExpressionTrayViewModel$p(WidgetExpressionTray widgetExpressionTray) {
        return widgetExpressionTray.getExpressionTrayViewModel();
    }

    public static final /* synthetic */ AppFlexInputViewModel access$getFlexInputViewModel$p(WidgetExpressionTray widgetExpressionTray) {
        return widgetExpressionTray.getFlexInputViewModel();
    }

    public static final /* synthetic */ WidgetStickerPicker access$getStickerPickerFragment$p(WidgetExpressionTray widgetExpressionTray) {
        WidgetStickerPicker widgetStickerPicker = widgetExpressionTray.stickerPickerFragment;
        if (widgetStickerPicker == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        return widgetStickerPicker;
    }

    public static final /* synthetic */ boolean access$getStickerPickerInitialized$p(WidgetExpressionTray widgetExpressionTray) {
        return widgetExpressionTray.stickerPickerInitialized;
    }

    public static final /* synthetic */ void access$handleEvent(WidgetExpressionTray widgetExpressionTray, ExpressionTrayViewModel.Event event) {
        widgetExpressionTray.handleEvent(event);
    }

    public static final /* synthetic */ void access$handleViewState(WidgetExpressionTray widgetExpressionTray, ExpressionTrayViewModel.ViewState viewState) throws Resources.NotFoundException {
        widgetExpressionTray.handleViewState(viewState);
    }

    public static final /* synthetic */ BehaviorSubject access$isAtInitialScrollPositionSubject$p(WidgetExpressionTray widgetExpressionTray) {
        return widgetExpressionTray.isAtInitialScrollPositionSubject;
    }

    public static final /* synthetic */ BehaviorSubject access$isExpressionTrayActiveSubject$cp() {
        return isExpressionTrayActiveSubject;
    }

    public static final /* synthetic */ void access$onGifSearchSheetCanceled(WidgetExpressionTray widgetExpressionTray) {
        widgetExpressionTray.onGifSearchSheetCanceled();
    }

    public static final /* synthetic */ void access$onGifSelected(WidgetExpressionTray widgetExpressionTray) {
        widgetExpressionTray.onGifSelected();
    }

    public static final /* synthetic */ void access$setStickerPickerFragment$p(WidgetExpressionTray widgetExpressionTray, WidgetStickerPicker widgetStickerPicker) {
        widgetExpressionTray.stickerPickerFragment = widgetStickerPicker;
    }

    public static final /* synthetic */ void access$setStickerPickerInitialized$p(WidgetExpressionTray widgetExpressionTray, boolean z2) {
        widgetExpressionTray.stickerPickerInitialized = z2;
    }

    public static final /* synthetic */ void access$showStickersSearchBar(WidgetExpressionTray widgetExpressionTray, boolean z2) {
        widgetExpressionTray.showStickersSearchBar(z2);
    }

    public static final /* synthetic */ void access$trackExpressionPickerTabClicked(WidgetExpressionTray widgetExpressionTray, ExpressionTrayTab expressionTrayTab) {
        widgetExpressionTray.trackExpressionPickerTabClicked(expressionTrayTab);
    }

    private final void configureDetailPage(ExpressionTrayViewModel.ViewState viewState) {
        Fragment fragmentFindFragmentById;
        ExpressionDetailPage expressionDetailPage = viewState.getExpressionDetailPage();
        if (!(expressionDetailPage instanceof ExpressionDetailPage.GifCategoryPage)) {
            if (expressionDetailPage != null || (fragmentFindFragmentById = getChildFragmentManager().findFragmentById(R.id.expression_tray_detail_page)) == null) {
                return;
            }
            getChildFragmentManager().beginTransaction().remove(fragmentFindFragmentById).commit();
            return;
        }
        WidgetGifCategory widgetGifCategory = new WidgetGifCategory();
        Bundle bundle = new Bundle();
        bundle.putSerializable(WidgetGifCategory.ARG_GIF_CATEGORY_ITEM, ((ExpressionDetailPage.GifCategoryPage) expressionDetailPage).getGifCategoryItem());
        widgetGifCategory.setArguments(bundle);
        widgetGifCategory.setOnGifSelected(new WidgetExpressionTray3(this));
        String simpleName = WidgetGifCategory.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "gifCategoryFragment.javaClass.simpleName");
        setupTabFragment(R.id.expression_tray_detail_page, widgetGifCategory, simpleName);
    }

    private final void configureLandingPage(ExpressionTrayViewModel.ViewState viewState) throws Resources.NotFoundException {
        int i;
        ExpressionTrayTab selectedExpressionTab = viewState.getSelectedExpressionTab();
        int iOrdinal = selectedExpressionTab.ordinal();
        if (iOrdinal == 0) {
            setUpEmojiPicker();
        } else if (iOrdinal == 1) {
            setUpGifPicker();
        } else if (iOrdinal == 2) {
            setUpStickerPicker();
        }
        getBinding().k.setSelectedIndex(getTabIndexFromTabType(selectedExpressionTab));
        Map<ExpressionTrayTab, ? extends View> map = this.expressionTabToContentViewsMap;
        if (map == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("expressionTabToContentViewsMap");
        }
        for (Map.Entry<ExpressionTrayTab, ? extends View> entry : map.entrySet()) {
            ExpressionTrayTab key = entry.getKey();
            View value = entry.getValue();
            int i2 = 0;
            if (!(key == selectedExpressionTab)) {
                i2 = 8;
            }
            value.setVisibility(i2);
        }
        int iOrdinal2 = selectedExpressionTab.ordinal();
        if (iOrdinal2 == 0) {
            i = R.string.search_for_emoji;
        } else if (iOrdinal2 == 1) {
            i = R.string.search_tenor;
        } else {
            if (iOrdinal2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.search_for_stickers;
        }
        String string = getResources().getString(i);
        Intrinsics3.checkNotNullExpressionValue(string, "resources.getString(searchTextStringRes)");
        TextView textView = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
        textView.setHint(string);
        RoundedRelativeLayout roundedRelativeLayout = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(roundedRelativeLayout, "binding.expressionTraySearchBar");
        roundedRelativeLayout.setContentDescription(string);
    }

    private final void fetchDataForTrayOpen() {
        StoreStream.INSTANCE.getStickers().fetchEnabledStickerDirectory();
    }

    private final WidgetExpressionTrayBinding getBinding() {
        return (WidgetExpressionTrayBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ExpressionTrayViewModel getExpressionTrayViewModel() {
        return (ExpressionTrayViewModel) this.expressionTrayViewModel.getValue();
    }

    private final AppFlexInputViewModel getFlexInputViewModel() {
        return (AppFlexInputViewModel) this.flexInputViewModel.getValue();
    }

    private final int getTabIndexFromTabType(ExpressionTrayTab tab) {
        Map<ExpressionTrayTab, ? extends View> map = this.expressionTabToContentViewsMap;
        if (map == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("expressionTabToContentViewsMap");
        }
        return _Collections.indexOf(map.keySet(), tab);
    }

    private final void handleEvent(ExpressionTrayViewModel.Event event) {
        if (Intrinsics3.areEqual(event, ExpressionTrayViewModel.Event.HideExpressionTray.INSTANCE)) {
            getFlexInputViewModel().hideExpressionTray();
            return;
        }
        if (Intrinsics3.areEqual(event, ExpressionTrayViewModel.Event.ShowEmojiPickerSheet.INSTANCE)) {
            Function0<Unit> function0 = this.onEmojiSearchOpenedListener;
            if (function0 != null) {
                function0.invoke();
            }
            AnalyticsTracker.INSTANCE.chatInputComponentViewed(ChatInputComponentTypes.EMOJI_SEARCH);
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            EmojiPickerNavigator.launchBottomSheet$default(parentFragmentManager, this.emojiPickerListener, EmojiPickerContextType.Chat.INSTANCE, null, 8, null);
            return;
        }
        if (Intrinsics3.areEqual(event, ExpressionTrayViewModel.Event.ShowGifPickerSheet.INSTANCE)) {
            AnalyticsTracker.INSTANCE.chatInputComponentViewed(ChatInputComponentTypes.GIF_SEARCH);
            WidgetGifPickerSheet.Companion companion = WidgetGifPickerSheet.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            companion.show(parentFragmentManager2, new AnonymousClass1(this), new AnonymousClass2(this));
            return;
        }
        if (event instanceof ExpressionTrayViewModel.Event.ShowStickerPicker) {
            ExpressionTrayViewModel.Event.ShowStickerPicker showStickerPicker = (ExpressionTrayViewModel.Event.ShowStickerPicker) event;
            if (!showStickerPicker.getInline()) {
                AnalyticsTracker.INSTANCE.chatInputComponentViewed(ChatInputComponentTypes.STICKER_SEARCH);
                WidgetStickerPickerSheet.Companion companion2 = WidgetStickerPickerSheet.INSTANCE;
                FragmentManager parentFragmentManager3 = getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
                WidgetStickerPickerSheet widgetStickerPickerSheetShow = companion2.show(parentFragmentManager3, this.stickerPickerListener, showStickerPicker.getStickerPackId(), showStickerPicker.getSearchText(), new WidgetExpressionTray6(this));
                Observable<T> observableQ = new ScalarSynchronousObservable(Unit.a).q(500L, TimeUnit.MILLISECONDS);
                Intrinsics3.checkNotNullExpressionValue(observableQ, "Observable.just(Unit)\n  …0, TimeUnit.MILLISECONDS)");
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableQ, this, null, 2, null), WidgetExpressionTray.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(widgetStickerPickerSheetShow, event), 62, (Object) null);
                return;
            }
            AnalyticsTracker.INSTANCE.chatInputComponentViewed("sticker");
            setUpStickerPicker();
            getFlexInputViewModel().showExpressionTray();
            TextView textView = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
            textView.setText(showStickerPicker.getSearchText());
            hideKeyboard(getView());
            WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
            if (widgetStickerPicker == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
            }
            String searchText = showStickerPicker.getSearchText();
            if (searchText == null) {
                searchText = "";
            }
            Long stickerPackId = showStickerPicker.getStickerPackId();
            widgetStickerPicker.setupForInlineSearchAndScroll(searchText, stickerPackId != null ? stickerPackId.longValue() : -1L);
        }
    }

    private final void handleViewState(ExpressionTrayViewModel.ViewState viewState) throws Resources.NotFoundException {
        configureLandingPage(viewState);
        configureDetailPage(viewState);
        ContentResizingCoordinatorLayout contentResizingCoordinatorLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(contentResizingCoordinatorLayout, "binding.expressionTrayLandingPage");
        contentResizingCoordinatorLayout.setVisibility(viewState.getShowLandingPage() ? 0 : 8);
        FragmentContainerView fragmentContainerView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.expressionTrayDetailPage");
        boolean z2 = true;
        fragmentContainerView.setVisibility(viewState.getShowLandingPage() ^ true ? 0 : 8);
        RoundedRelativeLayout roundedRelativeLayout = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(roundedRelativeLayout, "binding.expressionTraySearchBar");
        roundedRelativeLayout.setVisibility(viewState.getShowSearchBar() ? 0 : 8);
        boolean showGifsAndStickers = viewState.getShowGifsAndStickers();
        boolean showGifsAndStickers2 = viewState.getShowGifsAndStickers();
        CardSegment cardSegment = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(cardSegment, "binding.expressionTrayStickerCard");
        if ((cardSegment.getVisibility() == 0) && !showGifsAndStickers && viewState.getSelectedExpressionTab() == ExpressionTrayTab.STICKER) {
            getExpressionTrayViewModel().selectTab(ExpressionTrayTab.EMOJI);
        }
        CardSegment cardSegment2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(cardSegment2, "binding.expressionTrayGifCard");
        if ((cardSegment2.getVisibility() == 0) && !showGifsAndStickers2 && viewState.getSelectedExpressionTab() == ExpressionTrayTab.GIF) {
            getExpressionTrayViewModel().selectTab(ExpressionTrayTab.EMOJI);
        }
        CardSegment cardSegment3 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(cardSegment3, "binding.expressionTrayStickerCard");
        cardSegment3.setVisibility(showGifsAndStickers ? 0 : 8);
        CardSegment cardSegment4 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(cardSegment4, "binding.expressionTrayGifCard");
        cardSegment4.setVisibility(showGifsAndStickers2 ? 0 : 8);
        SegmentedControlContainer segmentedControlContainer = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(segmentedControlContainer, "binding.expressionTraySegmentedControl");
        if (!showGifsAndStickers2 && !showGifsAndStickers) {
            z2 = false;
        }
        segmentedControlContainer.setVisibility(z2 ? 0 : 8);
    }

    private final void initializeExpressionTabToViewsMap() {
        this.expressionTabToContentViewsMap = Maps6.linkedMapOf(Tuples.to(ExpressionTrayTab.EMOJI, getBinding().e), Tuples.to(ExpressionTrayTab.GIF, getBinding().g), Tuples.to(ExpressionTrayTab.STICKER, getBinding().m));
    }

    private final void onGifSearchSheetCanceled() {
        if (isAdded()) {
            getFlexInputViewModel().showKeyboardAndHideExpressionTray();
        }
    }

    private final void onGifSelected() {
        if (isAdded()) {
            getFlexInputViewModel().showKeyboardAndHideExpressionTray();
        }
    }

    private final void setUpEmojiPicker() {
        if (this.emojiPickerInitialized) {
            return;
        }
        this.emojiPickerInitialized = true;
        WidgetEmojiPicker widgetEmojiPicker = new WidgetEmojiPicker();
        widgetEmojiPicker.setListener(this.emojiPickerListener);
        widgetEmojiPicker.setOnBackspacePressedListener(this.onBackspacePressedListener);
        Bundle bundle = new Bundle();
        bundle.putSerializable("MODE", EmojiPickerMode.INLINE);
        bundle.putSerializable(EmojiPickerNavigator.ARG_EMOJI_PICKER_CONTEXT_TYPE, EmojiPickerContextType.Chat.INSTANCE);
        widgetEmojiPicker.setArguments(bundle);
        String simpleName = WidgetEmojiPicker.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "emojiPickerFragment.javaClass.simpleName");
        setupTabFragment(R.id.expression_tray_emoji_picker_content, widgetEmojiPicker, simpleName);
        this.emojiPickerFragment = widgetEmojiPicker;
    }

    private final void setUpGifPicker() {
        if (this.gifPickerInitialized) {
            return;
        }
        this.gifPickerInitialized = true;
        WidgetGifPicker widgetGifPicker = new WidgetGifPicker();
        widgetGifPicker.setOnSelectGifCategory(new AnonymousClass1(getExpressionTrayViewModel()));
        String simpleName = WidgetGifPicker.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "gifPickerFragment.javaClass.simpleName");
        setupTabFragment(R.id.expression_tray_gif_picker_content, widgetGifPicker, simpleName);
        this.gifPickerFragment = widgetGifPicker;
    }

    private final void setUpStickerPicker() {
        if (this.stickerPickerInitialized) {
            return;
        }
        this.stickerPickerInitialized = true;
        WidgetStickerPicker widgetStickerPicker = new WidgetStickerPicker();
        widgetStickerPicker.setListener(this.stickerPickerListener);
        widgetStickerPicker.setOnBackspacePressedListener(this.onBackspacePressedListener);
        widgetStickerPicker.setShowSearchBar(new AnonymousClass1(this));
        widgetStickerPicker.setScrollExpressionPickerToTop(new AnonymousClass2());
        Bundle bundle = new Bundle();
        bundle.putSerializable("MODE", StickerPickerMode.INLINE);
        widgetStickerPicker.setArguments(bundle);
        String simpleName = WidgetStickerPicker.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "stickerPickerFragment.javaClass.simpleName");
        setupTabFragment(R.id.expression_tray_sticker_picker_content, widgetStickerPicker, simpleName);
        this.stickerPickerFragment = widgetStickerPicker;
    }

    private final void setUpTabs() {
        getBinding().k.a(getTabIndexFromTabType(ExpressionTrayTab.EMOJI));
        getBinding().k.setOnSegmentSelectedChangeListener(new AnonymousClass1());
    }

    private final void setWindowInsetsListeners() {
        FragmentContainerView fragmentContainerView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.expressionTrayEmojiPickerContent");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView);
        FragmentContainerView fragmentContainerView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView2, "binding.expressionTrayGifPickerContent");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView2);
        FragmentContainerView fragmentContainerView3 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView3, "binding.expressionTrayStickerPickerContent");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView3);
        FragmentContainerView fragmentContainerView4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView4, "binding.expressionTrayDetailPage");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView4);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().c, new AnonymousClass1());
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().h, new AnonymousClass2());
        FrameLayout frameLayout = getBinding().f2383b;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.expressionTrayContainer");
        ViewExtensions.setForwardingWindowInsetsListener(frameLayout);
    }

    private final void setupTabFragment(int fragmentId, AppFragment fragment, String fragmentName) {
        if (isStateSaved()) {
            return;
        }
        getChildFragmentManager().beginTransaction().replace(fragmentId, fragment, fragmentName).commit();
    }

    private final void showStickersSearchBar(boolean show) {
        getExpressionTrayViewModel().showStickersSearchBar(show);
    }

    private final void trackExpressionPickerOpened() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(getExpressionTrayViewModel().observeViewState(), 0L, false, 3, null), WidgetExpressionTray.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
    }

    private final void trackExpressionPickerTabClicked(ExpressionTrayTab clickedTab) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(getExpressionTrayViewModel().observeViewState(), 0L, false, 3, null), WidgetExpressionTray.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(clickedTab), 62, (Object) null);
    }

    @Override // b.b.a.FlexInputExpressionTrayStateChangeListener
    public void isShown(boolean isActive) {
        getExpressionTrayViewModel().handleIsActive(isActive);
        isExpressionTrayActiveSubject.onNext(Boolean.valueOf(isActive));
        if (isActive && !this.wasActive) {
            getBinding().n.setExpanded(true);
            if (this.emojiPickerInitialized) {
                WidgetEmojiPicker widgetEmojiPicker = this.emojiPickerFragment;
                if (widgetEmojiPicker == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("emojiPickerFragment");
                }
                widgetEmojiPicker.scrollToTop();
            }
            if (this.gifPickerInitialized) {
                WidgetGifPicker widgetGifPicker = this.gifPickerFragment;
                if (widgetGifPicker == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("gifPickerFragment");
                }
                widgetGifPicker.scrollToTop();
            }
            if (this.stickerPickerInitialized) {
                WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
                if (widgetStickerPicker == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
                }
                widgetStickerPicker.scrollToTop();
            }
            fetchDataForTrayOpen();
            trackExpressionPickerOpened();
        } else if (!isActive && this.wasActive) {
            getExpressionTrayViewModel().clickBack();
        }
        if (!isActive) {
            TextView textView = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
            textView.setText("");
            if (this.stickerPickerInitialized) {
                WidgetStickerPicker widgetStickerPicker2 = this.stickerPickerFragment;
                if (widgetStickerPicker2 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
                }
                if (widgetStickerPicker2.isVisible()) {
                    WidgetStickerPicker widgetStickerPicker3 = this.stickerPickerFragment;
                    if (widgetStickerPicker3 == null) {
                        Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
                    }
                    widgetStickerPicker3.clearSearchInput();
                }
            }
        }
        if (this.stickerPickerInitialized) {
            WidgetStickerPicker widgetStickerPicker4 = this.stickerPickerFragment;
            if (widgetStickerPicker4 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
            }
            if (widgetStickerPicker4.getCanHandleIsShown()) {
                WidgetStickerPicker widgetStickerPicker5 = this.stickerPickerFragment;
                if (widgetStickerPicker5 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
                }
                widgetStickerPicker5.isShown(isActive);
            }
        }
        this.wasActive = isActive;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        initializeExpressionTabToViewsMap();
        setUpTabs();
        getBinding().i.setOnClickListener(new AnonymousClass1());
        setWindowInsetsListeners();
        getBinding().n.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getExpressionTrayViewModel().observeViewState(), this, null, 2, null), WidgetExpressionTray.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getExpressionTrayViewModel().observeEvents(), this, null, 2, null), WidgetExpressionTray.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    public final void setEmojiPickerListener(EmojiPickerListener emojiPickerListener) {
        Intrinsics3.checkNotNullParameter(emojiPickerListener, "emojiPickerListener");
        this.emojiPickerListener = emojiPickerListener;
    }

    public final void setOnBackspacePressedListener(OnBackspacePressedListener onBackspacePressedListener) {
        this.onBackspacePressedListener = onBackspacePressedListener;
    }

    public final void setOnEmojiSearchOpenedListener(Function0<Unit> callback) {
        Intrinsics3.checkNotNullParameter(callback, "callback");
        this.onEmojiSearchOpenedListener = callback;
    }

    public final void setStickerPickerListener(StickerPickerListener stickerPickerListener) {
        Intrinsics3.checkNotNullParameter(stickerPickerListener, "stickerPickerListener");
        this.stickerPickerListener = stickerPickerListener;
    }
}
