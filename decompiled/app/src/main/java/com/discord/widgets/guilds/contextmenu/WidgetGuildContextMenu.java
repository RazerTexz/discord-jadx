package com.discord.widgets.guilds.contextmenu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildContextMenuBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.contextmenu.GuildContextMenuViewModel;
import com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import com.discord.widgets.servers.WidgetServerNotifications;
import d0.d0._Ranges;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildContextMenu.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0002'&B\u0007¢\u0006\u0004\b%\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u000fR\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/WidgetGuildContextMenu;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState;)V", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$Event;)V", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState$Valid;", "configureValidUI", "(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState$Valid;)V", "doCircularReveal", "()V", "doCircularRemove", "onResume", "onDestroy", "Lcom/discord/databinding/WidgetGuildContextMenuBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildContextMenuBinding;", "binding", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel;", "viewModel", "Lcom/discord/widgets/guilds/contextmenu/WidgetGuildContextMenu$AnimationState;", "animationState", "Lcom/discord/widgets/guilds/contextmenu/WidgetGuildContextMenu$AnimationState;", "Landroid/animation/Animator;", "animator", "Landroid/animation/Animator;", "<init>", "Companion", "AnimationState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildContextMenu extends AppFragment {
    private static final String FRAGMENT_TAG = "WidgetGuildContextMenu";
    private static final String VIEW_CONTAINER_TAG = "WidgetGuildContextMenuViewContainer";
    private static boolean isShowingContextMenu;
    private AnimationState animationState;
    private Animator animator;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildContextMenu.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildContextMenuBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int SCREEN_BOTTOM_BUFFER = DimenUtils.dpToPixels(96);

    /* compiled from: WidgetGuildContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/WidgetGuildContextMenu$AnimationState;", "", "<init>", "(Ljava/lang/String;I)V", "ANIMATING_IN", "ANIMATING_OUT", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum AnimationState {
        ANIMATING_IN,
        ANIMATING_OUT
    }

    /* compiled from: WidgetGuildContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010!J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/WidgetGuildContextMenu$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/widgets/guilds/contextmenu/WidgetGuildContextMenu;", "newInstance", "(J)Lcom/discord/widgets/guilds/contextmenu/WidgetGuildContextMenu;", "Landroid/content/Context;", "context", "", "computeMaxContextMenuHeight", "(Landroid/content/Context;)I", "Landroidx/fragment/app/FragmentActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/graphics/PointF;", "absolutePosition", "", "show", "(Landroidx/fragment/app/FragmentActivity;Landroid/graphics/PointF;J)V", "", "animate", "hide", "(Landroidx/fragment/app/FragmentActivity;Z)V", "", "FRAGMENT_TAG", "Ljava/lang/String;", "SCREEN_BOTTOM_BUFFER", "I", "VIEW_CONTAINER_TAG", "isShowingContextMenu", "Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final int computeMaxContextMenuHeight(Context context) {
            WidgetGuildContextMenuBinding widgetGuildContextMenuBindingA = WidgetGuildContextMenuBinding.a(LayoutInflater.from(context).inflate(R.layout.widget_guild_context_menu, (ViewGroup) null, false));
            Intrinsics3.checkNotNullExpressionValue(widgetGuildContextMenuBindingA, "WidgetGuildContextMenuBi…om(context), null, false)");
            CardView cardView = widgetGuildContextMenuBindingA.a;
            Intrinsics3.checkNotNullExpressionValue(cardView, "WidgetGuildContextMenuBi…ntext), null, false).root");
            cardView.measure(0, 0);
            return cardView.getMeasuredHeight();
        }

        private final WidgetGuildContextMenu newInstance(long guildId) {
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            WidgetGuildContextMenu widgetGuildContextMenu = new WidgetGuildContextMenu();
            widgetGuildContextMenu.setArguments(bundleT);
            return widgetGuildContextMenu;
        }

        public final void hide(FragmentActivity activity, boolean animate) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Fragment fragmentFindFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(WidgetGuildContextMenu.FRAGMENT_TAG);
            if (!(fragmentFindFragmentByTag instanceof WidgetGuildContextMenu)) {
                fragmentFindFragmentByTag = null;
            }
            WidgetGuildContextMenu widgetGuildContextMenu = (WidgetGuildContextMenu) fragmentFindFragmentByTag;
            if (widgetGuildContextMenu != null) {
                if (animate) {
                    WidgetGuildContextMenu.access$doCircularRemove(widgetGuildContextMenu);
                    return;
                }
                activity.getSupportFragmentManager().beginTransaction().remove(widgetGuildContextMenu).commitAllowingStateLoss();
                Window window = activity.getWindow();
                Intrinsics3.checkNotNullExpressionValue(window, "activity.window");
                View decorView = window.getDecorView();
                Intrinsics3.checkNotNullExpressionValue(decorView, "activity.window.decorView");
                View rootView = decorView.getRootView();
                Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) rootView;
                Window window2 = activity.getWindow();
                Intrinsics3.checkNotNullExpressionValue(window2, "activity.window");
                View decorView2 = window2.getDecorView();
                Intrinsics3.checkNotNullExpressionValue(decorView2, "activity.window.decorView");
                FrameLayout frameLayout = (FrameLayout) decorView2.getRootView().findViewWithTag(WidgetGuildContextMenu.VIEW_CONTAINER_TAG);
                if (frameLayout != null) {
                    viewGroup.removeView(frameLayout);
                }
                WidgetGuildContextMenu.access$setShowingContextMenu$cp(false);
            }
        }

        public final void show(FragmentActivity activity, PointF absolutePosition, long guildId) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(absolutePosition, "absolutePosition");
            if (WidgetGuildContextMenu.access$isShowingContextMenu$cp()) {
                return;
            }
            WidgetGuildContextMenu.access$setShowingContextMenu$cp(true);
            computeMaxContextMenuHeight(activity);
            hide(activity, false);
            FrameLayout frameLayout = new FrameLayout(activity);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.setTag(WidgetGuildContextMenu.VIEW_CONTAINER_TAG);
            Window window = activity.getWindow();
            Intrinsics3.checkNotNullExpressionValue(window, "activity.window");
            View decorView = window.getDecorView();
            Intrinsics3.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            View rootView = decorView.getRootView();
            Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) rootView).addView(frameLayout);
            frameLayout.setOnClickListener(new WidgetGuildContextMenu2(activity));
            FrameLayout frameLayout2 = new FrameLayout(activity);
            frameLayout2.setId(View.generateViewId());
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            frameLayout.addView(frameLayout2);
            frameLayout2.setX(absolutePosition.x);
            frameLayout2.setY(_Ranges.coerceAtMost(absolutePosition.y, (r1.getHeight() - computeMaxContextMenuHeight(activity)) - WidgetGuildContextMenu.access$getSCREEN_BOTTOM_BUFFER$cp()));
            activity.getSupportFragmentManager().beginTransaction().add(frameLayout2.getId(), newInstance(guildId), WidgetGuildContextMenu.FRAGMENT_TAG).commit();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$configureValidUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildContextMenu.access$doCircularRemove(WidgetGuildContextMenu.this);
            WidgetGuildContextMenu.access$getViewModel$p(WidgetGuildContextMenu.this).onMarkAsReadClicked();
        }
    }

    /* compiled from: WidgetGuildContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$configureValidUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ GuildContextMenuViewModel.ViewState.Valid $viewState;

        public AnonymousClass2(GuildContextMenuViewModel.ViewState.Valid valid) {
            this.$viewState = valid;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildContextMenu.access$doCircularRemove(WidgetGuildContextMenu.this);
            WidgetServerNotifications.Companion companion = WidgetServerNotifications.INSTANCE;
            long id2 = this.$viewState.getGuild().getId();
            FragmentActivity fragmentActivityRequireActivity = WidgetGuildContextMenu.this.requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.launch(id2, fragmentActivityRequireActivity);
        }
    }

    /* compiled from: WidgetGuildContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$configureValidUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ GuildContextMenuViewModel.ViewState.Valid $viewState;

        public AnonymousClass3(GuildContextMenuViewModel.ViewState.Valid valid) {
            this.$viewState = valid;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildContextMenu.access$doCircularRemove(WidgetGuildContextMenu.this);
            WidgetLeaveGuildDialog.Companion companion = WidgetLeaveGuildDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetGuildContextMenu.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, this.$viewState.getGuild().getId());
        }
    }

    /* compiled from: WidgetGuildContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$configureValidUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ GuildContextMenuViewModel.ViewState.Valid $viewState;

        public AnonymousClass4(GuildContextMenuViewModel.ViewState.Valid valid) {
            this.$viewState = valid;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildContextMenu.access$doCircularRemove(WidgetGuildContextMenu.this);
            WidgetGuildProfileSheet.Companion companion = WidgetGuildProfileSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetGuildContextMenu.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetGuildProfileSheet.Companion.show$default(companion, parentFragmentManager, this.$viewState.isGuildSelected(), this.$viewState.getGuild().getId(), 0L, false, 24, null);
        }
    }

    /* compiled from: WidgetGuildContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/guilds/contextmenu/WidgetGuildContextMenu$doCircularRemove$1", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "(Landroid/animation/Animator;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$doCircularRemove$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            FragmentActivity activity = WidgetGuildContextMenu.this.getActivity();
            if (activity != null) {
                Companion companion = WidgetGuildContextMenu.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                companion.hide(activity, false);
            }
        }
    }

    /* compiled from: WidgetGuildContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/guilds/contextmenu/WidgetGuildContextMenu$doCircularReveal$1", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "(Landroid/animation/Animator;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$doCircularReveal$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            WidgetGuildContextMenu.access$setAnimationState$p(WidgetGuildContextMenu.this, null);
        }
    }

    /* compiled from: WidgetGuildContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildContextMenuViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildContextMenu widgetGuildContextMenu) {
            super(1, widgetGuildContextMenu, WidgetGuildContextMenu.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildContextMenuViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildContextMenuViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildContextMenu.access$configureUI((WidgetGuildContextMenu) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$onResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<GuildContextMenuViewModel.Event, Unit> {
        public AnonymousClass2(WidgetGuildContextMenu widgetGuildContextMenu) {
            super(1, widgetGuildContextMenu, WidgetGuildContextMenu.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildContextMenuViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildContextMenuViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildContextMenu.access$handleEvent((WidgetGuildContextMenu) this.receiver, event);
        }
    }

    public WidgetGuildContextMenu() {
        super(R.layout.widget_guild_context_menu);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildContextMenu3.INSTANCE, null, 2, null);
        WidgetGuildContextMenu4 widgetGuildContextMenu4 = new WidgetGuildContextMenu4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildContextMenuViewModel.class), new WidgetGuildContextMenu$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildContextMenu4));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildContextMenu widgetGuildContextMenu, GuildContextMenuViewModel.ViewState viewState) {
        widgetGuildContextMenu.configureUI(viewState);
    }

    public static final /* synthetic */ void access$doCircularRemove(WidgetGuildContextMenu widgetGuildContextMenu) {
        widgetGuildContextMenu.doCircularRemove();
    }

    public static final /* synthetic */ AnimationState access$getAnimationState$p(WidgetGuildContextMenu widgetGuildContextMenu) {
        return widgetGuildContextMenu.animationState;
    }

    public static final /* synthetic */ int access$getSCREEN_BOTTOM_BUFFER$cp() {
        return SCREEN_BOTTOM_BUFFER;
    }

    public static final /* synthetic */ GuildContextMenuViewModel access$getViewModel$p(WidgetGuildContextMenu widgetGuildContextMenu) {
        return widgetGuildContextMenu.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildContextMenu widgetGuildContextMenu, GuildContextMenuViewModel.Event event) {
        widgetGuildContextMenu.handleEvent(event);
    }

    public static final /* synthetic */ boolean access$isShowingContextMenu$cp() {
        return isShowingContextMenu;
    }

    public static final /* synthetic */ void access$setAnimationState$p(WidgetGuildContextMenu widgetGuildContextMenu, AnimationState animationState) {
        widgetGuildContextMenu.animationState = animationState;
    }

    public static final /* synthetic */ void access$setShowingContextMenu$cp(boolean z2) {
        isShowingContextMenu = z2;
    }

    private final void configureUI(GuildContextMenuViewModel.ViewState viewState) {
        if (viewState instanceof GuildContextMenuViewModel.ViewState.Valid) {
            configureValidUI((GuildContextMenuViewModel.ViewState.Valid) viewState);
        } else if (Intrinsics3.areEqual(viewState, GuildContextMenuViewModel.ViewState.Invalid.INSTANCE)) {
            Companion companion = INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.hide(fragmentActivityRequireActivity, false);
        }
    }

    private final void configureValidUI(GuildContextMenuViewModel.ViewState.Valid viewState) {
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildContextMenuHeader");
        textView.setText(viewState.getGuild().getName());
        getBinding().e.setOnClickListener(new AnonymousClass1());
        getBinding().g.setOnClickListener(new AnonymousClass2(viewState));
        getBinding().d.setOnClickListener(new AnonymousClass3(viewState));
        getBinding().f.setOnClickListener(new AnonymousClass4(viewState));
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildContextMenuLeaveGuild");
        textView2.setVisibility(viewState.getShowLeaveGuild() ? 0 : 8);
        TextView textView3 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildContextMenuMarkAsRead");
        textView3.setVisibility(viewState.getShowMarkAsRead() ? 0 : 8);
        getBinding().f2411b.setContentPadding(0, 0, 0, 0);
        CardView cardView = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.guildContextMenuCard");
        if (cardView.getVisibility() == 0) {
            return;
        }
        doCircularReveal();
    }

    private final void doCircularRemove() {
        AnimationState animationState = this.animationState;
        if (animationState == AnimationState.ANIMATING_IN) {
            Animator animator = this.animator;
            if (animator != null) {
                animator.cancel();
            }
            Companion companion = INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.hide(fragmentActivityRequireActivity, false);
            return;
        }
        AnimationState animationState2 = AnimationState.ANIMATING_OUT;
        if (animationState == animationState2) {
            return;
        }
        CardView cardView = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.guildContextMenuCard");
        int height = cardView.getHeight() / 2;
        CardView cardView2 = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.guildContextMenuCard");
        int width = cardView2.getWidth();
        Intrinsics3.checkNotNullExpressionValue(getBinding().f2411b, "binding.guildContextMenuCard");
        float fHypot = (float) Math.hypot(width, r5.getHeight() / 2);
        CardView cardView3 = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.guildContextMenuCard");
        if (!cardView3.isAttachedToWindow()) {
            CardView cardView4 = getBinding().f2411b;
            Intrinsics3.checkNotNullExpressionValue(cardView4, "binding.guildContextMenuCard");
            cardView4.setVisibility(8);
            return;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f2411b, 0, height, fHypot, 0.0f);
        this.animator = animatorCreateCircularReveal;
        this.animationState = animationState2;
        Intrinsics3.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new AnonymousClass1());
        animatorCreateCircularReveal.start();
    }

    private final void doCircularReveal() {
        CardView cardView = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.guildContextMenuCard");
        if (!cardView.isAttachedToWindow()) {
            CardView cardView2 = getBinding().f2411b;
            Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.guildContextMenuCard");
            cardView2.setVisibility(0);
            return;
        }
        CardView cardView3 = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.guildContextMenuCard");
        int height = cardView3.getHeight() / 2;
        CardView cardView4 = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView4, "binding.guildContextMenuCard");
        int width = cardView4.getWidth();
        Intrinsics3.checkNotNullExpressionValue(getBinding().f2411b, "binding.guildContextMenuCard");
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f2411b, 0, height, 0.0f, (float) Math.hypot(width, r4.getHeight() / 2));
        this.animator = animatorCreateCircularReveal;
        this.animationState = AnimationState.ANIMATING_IN;
        Intrinsics3.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new AnonymousClass1());
        CardView cardView5 = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView5, "binding.guildContextMenuCard");
        cardView5.setVisibility(0);
        animatorCreateCircularReveal.start();
    }

    private final WidgetGuildContextMenuBinding getBinding() {
        return (WidgetGuildContextMenuBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildContextMenuViewModel getViewModel() {
        return (GuildContextMenuViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(GuildContextMenuViewModel.Event event) {
        if (Intrinsics3.areEqual(event, GuildContextMenuViewModel.Event.Dismiss.INSTANCE)) {
            doCircularRemove();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        isShowingContextMenu = false;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildContextMenu.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildContextMenu.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
