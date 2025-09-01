package com.discord.widgets.tabs;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTabsHostBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorState;
import com.discord.widgets.tabs.TabsHostViewModel;
import com.discord.widgets.user.WidgetUserStatusSheet;
import com.discord.widgets.user.search.WidgetGlobalSearchDialog;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.functions.Func0;

/* compiled from: WidgetTabsHost.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 E2\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\bD\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u0019\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\fJ)\u0010#\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b%\u0010\fJ\u001d\u0010(\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\"\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020&0.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001d\u00106\u001a\u0002018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001d\u0010@\u001a\u00020;8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/discord/widgets/tabs/WidgetTabsHost;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/tabs/TabsHostViewModel$ViewState;", "viewState", "", "updateViews", "(Lcom/discord/widgets/tabs/TabsHostViewModel$ViewState;)V", "Lcom/discord/widgets/tabs/TabsHostViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/tabs/TabsHostViewModel$Event;)V", "onSearchClick", "()V", "onSettingsLongPress", "handleFriendsListShown", "updateNavHostMargins", "", "isCallStatusVisible", "setPanelWindowInsetsListeners", "(Z)V", "configureSystemStatusBar", "Lcom/discord/widgets/tabs/NavigationTab;", "navigationTab", "navigateToTab", "(Lcom/discord/widgets/tabs/NavigationTab;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onDestroyView", "Lcom/discord/widgets/tabs/OnTabSelectedListener;", "onTabSelectedListener", "registerTabSelectionListener", "(Lcom/discord/widgets/tabs/NavigationTab;Lcom/discord/widgets/tabs/OnTabSelectedListener;)V", "previousShowBottomNav", "Ljava/lang/Boolean;", "previousBottomNavHeight", "I", "", "tabToTabSelectionListenerMap", "Ljava/util/Map;", "Lcom/discord/widgets/tabs/TabsHostViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/tabs/TabsHostViewModel;", "viewModel", "Lcom/discord/widgets/tabs/TabsHostViewModel$ViewState;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState;", "globalStatusIndicatorStateObserver", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState;", "Lcom/discord/databinding/WidgetTabsHostBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetTabsHostBinding;", "binding", "Landroid/animation/ValueAnimator;", "bottomNavAnimator", "Landroid/animation/ValueAnimator;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetTabsHost extends AppFragment {
    private static final long BOTTOM_TABS_DOWNWARD_ANIMATION_DURATION_MS = 200;
    private static final long BOTTOM_TABS_UPWARD_ANIMATION_DURATION_MS = 250;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ValueAnimator bottomNavAnimator;
    private final WidgetGlobalStatusIndicatorState globalStatusIndicatorStateObserver;
    private int previousBottomNavHeight;
    private Boolean previousShowBottomNav;
    private final Map<NavigationTab, OnTabSelectedListener> tabToTabSelectionListenerMap;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private TabsHostViewModel.ViewState viewState;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetTabsHost.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTabsHostBinding;", 0)};

    /* compiled from: WidgetTabsHost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;", "state", "", "invoke", "(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$configureSystemStatusBar$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetGlobalStatusIndicatorState.State, Unit> {
        public final /* synthetic */ int $defaultStatusBarColor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
            super(1);
            this.$defaultStatusBarColor = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorState.State state) {
            invoke2(state);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGlobalStatusIndicatorState.State state) {
            Intrinsics3.checkNotNullParameter(state, "state");
            WidgetTabsHost.access$setPanelWindowInsetsListeners(WidgetTabsHost.this, state.isVisible());
            int color = ColorCompat.getColor(WidgetTabsHost.this, R.color.transparent);
            if (!state.isVisible()) {
                color = this.$defaultStatusBarColor;
            }
            ColorCompat.setStatusBarColor$default((Fragment) WidgetTabsHost.this, color, false, 4, (Object) null);
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1<R> implements Func0<Boolean> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            return Boolean.valueOf(WidgetTabsHost.access$getViewModel$p(WidgetTabsHost.this).handleBackPress());
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/tabs/TabsHostViewModel$ViewState;", "kotlin.jvm.PlatformType", "viewState", "", "invoke", "(Lcom/discord/widgets/tabs/TabsHostViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<TabsHostViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TabsHostViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TabsHostViewModel.ViewState viewState) {
            WidgetTabsHost widgetTabsHost = WidgetTabsHost.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            WidgetTabsHost.access$updateViews(widgetTabsHost, viewState);
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/tabs/TabsHostViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/tabs/TabsHostViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<TabsHostViewModel.Event, Unit> {
        public AnonymousClass2(WidgetTabsHost widgetTabsHost) {
            super(1, widgetTabsHost, WidgetTabsHost.class, "handleEvent", "handleEvent(Lcom/discord/widgets/tabs/TabsHostViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TabsHostViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TabsHostViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetTabsHost.access$handleEvent((WidgetTabsHost) this.receiver, event);
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "v", "Landroidx/core/view/WindowInsetsCompat;", "insets", "kotlin.jvm.PlatformType", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$setPanelWindowInsetsListeners$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Sequence<View> children;
            Intrinsics3.checkNotNullParameter(view, "v");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), view.getPaddingTop(), windowInsetsCompat.getSystemWindowInsetRight(), view.getPaddingBottom());
            WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder().setSystemWindowInsets(Insets.of(0, windowInsetsCompat.getSystemWindowInsetTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom())).build();
            Intrinsics3.checkNotNullExpressionValue(windowInsetsCompatBuild, "WindowInsetsCompat.Build…        )\n      ).build()");
            if (!(view instanceof ViewGroup)) {
                view = null;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup != null && (children = androidx.core.view.ViewGroup.getChildren(viewGroup)) != null) {
                Iterator<View> it = children.iterator();
                while (it.hasNext()) {
                    ViewCompat.dispatchApplyWindowInsets(it.next(), windowInsetsCompatBuild);
                }
            }
            return windowInsetsCompatBuild;
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "view", "Landroidx/core/view/WindowInsetsCompat;", "insets", "kotlin.jvm.PlatformType", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$setPanelWindowInsetsListeners$2, reason: invalid class name */
    public static final class AnonymousClass2 implements OnApplyWindowInsetsListener {
        public final /* synthetic */ boolean $isCallStatusVisible;

        public AnonymousClass2(boolean z2) {
            this.$isCallStatusVisible = z2;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Sequence<View> children;
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            if (this.$isCallStatusVisible) {
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            } else {
                view.setPadding(view.getPaddingLeft(), windowInsetsCompat.getSystemWindowInsetTop(), view.getPaddingRight(), view.getPaddingBottom());
                windowInsetsCompat = new WindowInsetsCompat.Builder().setSystemWindowInsets(Insets.of(windowInsetsCompat.getSystemWindowInsetLeft(), 0, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom())).build();
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "WindowInsetsCompat.Build…      )\n        ).build()");
            }
            if (!(view instanceof ViewGroup)) {
                view = null;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup != null && (children = androidx.core.view.ViewGroup.getChildren(viewGroup)) != null) {
                Iterator<View> it = children.iterator();
                while (it.hasNext()) {
                    ViewCompat.dispatchApplyWindowInsets(it.next(), windowInsetsCompat);
                }
            }
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "Landroidx/core/view/WindowInsetsCompat;", "insets", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$setPanelWindowInsetsListeners$3, reason: invalid class name */
    public static final class AnonymousClass3 implements OnApplyWindowInsetsListener {
        public final /* synthetic */ boolean $isCallStatusVisible;

        public AnonymousClass3(boolean z2) {
            this.$isCallStatusVisible = z2;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int systemWindowInsetTop;
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            if (this.$isCallStatusVisible) {
                systemWindowInsetTop = 0;
            } else {
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            }
            view.setPadding(view.getPaddingLeft(), systemWindowInsetTop, view.getPaddingRight(), view.getPaddingBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "Landroidx/core/view/WindowInsetsCompat;", "insets", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$setPanelWindowInsetsListeners$4, reason: invalid class name */
    public static final class AnonymousClass4 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/tabs/NavigationTab;", "p1", "", "invoke", "(Lcom/discord/widgets/tabs/NavigationTab;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$updateViews$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<NavigationTab, Unit> {
        public AnonymousClass1(TabsHostViewModel tabsHostViewModel) {
            super(1, tabsHostViewModel, TabsHostViewModel.class, "selectTab", "selectTab(Lcom/discord/widgets/tabs/NavigationTab;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NavigationTab navigationTab) {
            invoke2(navigationTab);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavigationTab navigationTab) {
            Intrinsics3.checkNotNullParameter(navigationTab, "p1");
            ((TabsHostViewModel) this.receiver).selectTab(navigationTab);
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$updateViews$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(WidgetTabsHost widgetTabsHost) {
            super(0, widgetTabsHost, WidgetTabsHost.class, "onSearchClick", "onSearchClick()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetTabsHost.access$onSearchClick((WidgetTabsHost) this.receiver);
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$updateViews$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass3(WidgetTabsHost widgetTabsHost) {
            super(0, widgetTabsHost, WidgetTabsHost.class, "onSettingsLongPress", "onSettingsLongPress()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetTabsHost.access$onSettingsLongPress((WidgetTabsHost) this.receiver);
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$updateViews$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass4(WidgetTabsHost widgetTabsHost) {
            super(0, widgetTabsHost, WidgetTabsHost.class, "onSearchClick", "onSearchClick()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetTabsHost.access$onSearchClick((WidgetTabsHost) this.receiver);
        }
    }

    public WidgetTabsHost() {
        super(R.layout.widget_tabs_host);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetTabsHost4.INSTANCE, null, 2, null);
        this.tabToTabSelectionListenerMap = new LinkedHashMap();
        this.globalStatusIndicatorStateObserver = WidgetGlobalStatusIndicatorState.INSTANCE.get();
        WidgetTabsHost5 widgetTabsHost5 = WidgetTabsHost5.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(TabsHostViewModel.class), new WidgetTabsHost$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetTabsHost5));
    }

    public static final /* synthetic */ WidgetTabsHostBinding access$getBinding$p(WidgetTabsHost widgetTabsHost) {
        return widgetTabsHost.getBinding();
    }

    public static final /* synthetic */ TabsHostViewModel access$getViewModel$p(WidgetTabsHost widgetTabsHost) {
        return widgetTabsHost.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetTabsHost widgetTabsHost, TabsHostViewModel.Event event) {
        widgetTabsHost.handleEvent(event);
    }

    public static final /* synthetic */ void access$onSearchClick(WidgetTabsHost widgetTabsHost) {
        widgetTabsHost.onSearchClick();
    }

    public static final /* synthetic */ void access$onSettingsLongPress(WidgetTabsHost widgetTabsHost) {
        widgetTabsHost.onSettingsLongPress();
    }

    public static final /* synthetic */ void access$setPanelWindowInsetsListeners(WidgetTabsHost widgetTabsHost, boolean z2) {
        widgetTabsHost.setPanelWindowInsetsListeners(z2);
    }

    public static final /* synthetic */ void access$updateViews(WidgetTabsHost widgetTabsHost, TabsHostViewModel.ViewState viewState) {
        widgetTabsHost.updateViews(viewState);
    }

    private final void configureSystemStatusBar() {
        int themedColor = ColorCompat.getThemedColor(this, R.attr.colorBackgroundTertiary);
        ColorCompat.setStatusBarColor$default((Fragment) this, themedColor, false, 4, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(this.globalStatusIndicatorStateObserver.observeState(), this, null, 2, null), WidgetTabsHost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(themedColor), 62, (Object) null);
    }

    private final WidgetTabsHostBinding getBinding() {
        return (WidgetTabsHostBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final TabsHostViewModel getViewModel() {
        return (TabsHostViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(TabsHostViewModel.Event event) {
        if (Intrinsics3.areEqual(event, TabsHostViewModel.Event.TrackFriendsListShown.INSTANCE)) {
            handleFriendsListShown();
        } else if (Intrinsics3.areEqual(event, TabsHostViewModel.Event.DismissSearchDialog.INSTANCE)) {
            WidgetGlobalSearchDialog.Companion companion = WidgetGlobalSearchDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.dismiss(parentFragmentManager);
        }
    }

    private final void handleFriendsListShown() {
        AnalyticsTracker.INSTANCE.friendsListViewed();
    }

    private final void navigateToTab(NavigationTab navigationTab) {
        FragmentContainerView fragmentContainerView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.widgetTabsHostHome");
        fragmentContainerView.setVisibility(navigationTab == NavigationTab.HOME ? 0 : 8);
        FragmentContainerView fragmentContainerView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView2, "binding.widgetTabsHostFriends");
        fragmentContainerView2.setVisibility(navigationTab == NavigationTab.FRIENDS ? 0 : 8);
        FragmentContainerView fragmentContainerView3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView3, "binding.widgetTabsHostMentions");
        fragmentContainerView3.setVisibility(navigationTab == NavigationTab.MENTIONS ? 0 : 8);
        FragmentContainerView fragmentContainerView4 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView4, "binding.widgetTabsHostUserSettings");
        fragmentContainerView4.setVisibility(navigationTab == NavigationTab.SETTINGS ? 0 : 8);
        OnTabSelectedListener onTabSelectedListener = this.tabToTabSelectionListenerMap.get(navigationTab);
        if (onTabSelectedListener != null) {
            onTabSelectedListener.onTabSelected();
        }
    }

    private final void onSearchClick() {
        WidgetGlobalSearchDialog.Companion companion = WidgetGlobalSearchDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetGlobalSearchDialog.Companion.show$default(companion, parentFragmentManager, null, 2, null);
    }

    private final void onSettingsLongPress() {
        WidgetUserStatusSheet.INSTANCE.show(this);
    }

    private final void setPanelWindowInsetsListeners(boolean isCallStatusVisible) {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().c, AnonymousClass1.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().e, new AnonymousClass2(isCallStatusVisible));
        FrameLayout frameLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.widgetTabsHostNavHost");
        ViewExtensions.setForwardingWindowInsetsListener(frameLayout);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().h, new AnonymousClass3(isCallStatusVisible));
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f2664b, AnonymousClass4.INSTANCE);
        getBinding().c.requestApplyInsets();
    }

    public static /* synthetic */ void setPanelWindowInsetsListeners$default(WidgetTabsHost widgetTabsHost, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        widgetTabsHost.setPanelWindowInsetsListeners(z2);
    }

    private final void updateNavHostMargins(TabsHostViewModel.ViewState viewState) {
        NavigationTab selectedTab = viewState.getSelectedTab();
        FrameLayout frameLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.widgetTabsHostNavHost");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, selectedTab == NavigationTab.HOME ? 0 : viewState.getBottomNavHeight());
        FrameLayout frameLayout2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.widgetTabsHostNavHost");
        frameLayout2.setLayoutParams(marginLayoutParams);
    }

    private final void updateViews(TabsHostViewModel.ViewState viewState) {
        this.viewState = viewState;
        NavigationTab selectedTab = viewState.getSelectedTab();
        boolean showBottomNav = viewState.getShowBottomNav();
        int bottomNavHeight = viewState.getBottomNavHeight();
        navigateToTab(selectedTab);
        getBinding().f2664b.updateView(selectedTab, new AnonymousClass1(getViewModel()), showBottomNav, viewState.getMyUserId(), viewState.getVisibleTabs(), viewState.getNumHomeNotifications(), viewState.getNumFriendsNotifications(), new AnonymousClass2(this), new AnonymousClass3(this), new AnonymousClass4(this));
        updateNavHostMargins(viewState);
        boolean z2 = !Intrinsics3.areEqual(Boolean.valueOf(showBottomNav), this.previousShowBottomNav);
        boolean z3 = bottomNavHeight != this.previousBottomNavHeight;
        if (z2 || z3) {
            ValueAnimator valueAnimator = this.bottomNavAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            TabsHostBottomNavigationView tabsHostBottomNavigationView = getBinding().f2664b;
            Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationView, "binding.widgetTabsHostBottomNavigationView");
            float translationY = tabsHostBottomNavigationView.getTranslationY();
            if (showBottomNav) {
                TabsHostBottomNavigationView tabsHostBottomNavigationView2 = getBinding().f2664b;
                Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationView2, "binding.widgetTabsHostBottomNavigationView");
                tabsHostBottomNavigationView2.setVisibility(0);
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(translationY, 0.0f);
                valueAnimatorOfFloat.setInterpolator(new FastOutSlowInInterpolator());
                valueAnimatorOfFloat.setDuration(BOTTOM_TABS_UPWARD_ANIMATION_DURATION_MS);
                valueAnimatorOfFloat.addUpdateListener(new WidgetTabsHost2(this));
                valueAnimatorOfFloat.start();
                this.bottomNavAnimator = valueAnimatorOfFloat;
            } else if (bottomNavHeight > 0) {
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(translationY, bottomNavHeight);
                valueAnimatorOfFloat2.setInterpolator(new FastOutSlowInInterpolator());
                valueAnimatorOfFloat2.setDuration(BOTTOM_TABS_DOWNWARD_ANIMATION_DURATION_MS);
                valueAnimatorOfFloat2.addUpdateListener(new WidgetTabsHost3(this));
                valueAnimatorOfFloat2.start();
                this.bottomNavAnimator = valueAnimatorOfFloat2;
            } else {
                TabsHostBottomNavigationView tabsHostBottomNavigationView3 = getBinding().f2664b;
                Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationView3, "binding.widgetTabsHostBottomNavigationView");
                tabsHostBottomNavigationView3.setVisibility(4);
            }
        }
        this.previousBottomNavHeight = bottomNavHeight;
        this.previousShowBottomNav = Boolean.valueOf(showBottomNav);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) throws IOException {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4008) {
            GoogleSmartLockManager.INSTANCE.handleResult(resultCode, data);
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ValueAnimator valueAnimator = this.bottomNavAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        super.onDestroyView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f2664b.addHeightChangedListener(BottomNavViewObserver.INSTANCE.getINSTANCE());
        setPanelWindowInsetsListeners$default(this, false, 1, null);
        AppFragment.setOnBackPressed$default(this, new AnonymousClass1(), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<TabsHostViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetTabsHost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetTabsHost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
        configureSystemStatusBar();
    }

    public final void registerTabSelectionListener(NavigationTab navigationTab, OnTabSelectedListener onTabSelectedListener) {
        Intrinsics3.checkNotNullParameter(navigationTab, "navigationTab");
        Intrinsics3.checkNotNullParameter(onTabSelectedListener, "onTabSelectedListener");
        this.tabToTabSelectionListenerMap.put(navigationTab, onTabSelectedListener);
        TabsHostViewModel.ViewState viewState = this.viewState;
        NavigationTab selectedTab = viewState != null ? viewState.getSelectedTab() : null;
        if (selectedTab != null) {
            navigateToTab(selectedTab);
        }
    }
}
