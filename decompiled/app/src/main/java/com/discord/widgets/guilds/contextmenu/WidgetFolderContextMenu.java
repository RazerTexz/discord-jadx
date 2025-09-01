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
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetFolderContextMenuBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.WidgetGuildFolderSettings;
import com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel;
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

/* compiled from: WidgetFolderContextMenu.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0002'&B\u0007¢\u0006\u0004\b%\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010$\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/WidgetFolderContextMenu;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$ViewState;)V", "Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$Event;)V", "Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$ViewState$Valid;", "configureValidUI", "(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$ViewState$Valid;)V", "doCircularReveal", "()V", "doCircularRemove", "onResume", "onDestroy", "Lcom/discord/widgets/guilds/contextmenu/WidgetFolderContextMenu$AnimationState;", "animationState", "Lcom/discord/widgets/guilds/contextmenu/WidgetFolderContextMenu$AnimationState;", "Lcom/discord/databinding/WidgetFolderContextMenuBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetFolderContextMenuBinding;", "binding", "Landroid/animation/Animator;", "animator", "Landroid/animation/Animator;", "Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel;", "viewModel", "<init>", "Companion", "AnimationState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetFolderContextMenu extends AppFragment {
    private static final String FRAGMENT_TAG = "WidgetFolderContextMenu";
    private static final String VIEW_CONTAINER_TAG = "WidgetFolderContextMenuViewContainer";
    private static boolean isShowingContextMenu;
    private AnimationState animationState;
    private Animator animator;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetFolderContextMenu.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFolderContextMenuBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int SCREEN_BOTTOM_BUFFER = DimenUtils.dpToPixels(96);

    /* compiled from: WidgetFolderContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/WidgetFolderContextMenu$AnimationState;", "", "<init>", "(Ljava/lang/String;I)V", "ANIMATING_IN", "ANIMATING_OUT", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum AnimationState {
        ANIMATING_IN,
        ANIMATING_OUT
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010!J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/WidgetFolderContextMenu$Companion;", "", "", "Lcom/discord/primitives/FolderId;", "folderId", "Lcom/discord/widgets/guilds/contextmenu/WidgetFolderContextMenu;", "newInstance", "(J)Lcom/discord/widgets/guilds/contextmenu/WidgetFolderContextMenu;", "Landroid/content/Context;", "context", "", "computeMaxContextMenuHeight", "(Landroid/content/Context;)I", "Landroidx/fragment/app/FragmentActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/graphics/PointF;", "absolutePosition", "", "show", "(Landroidx/fragment/app/FragmentActivity;Landroid/graphics/PointF;J)V", "", "animate", "hide", "(Landroidx/fragment/app/FragmentActivity;Z)V", "", "FRAGMENT_TAG", "Ljava/lang/String;", "SCREEN_BOTTOM_BUFFER", "I", "VIEW_CONTAINER_TAG", "isShowingContextMenu", "Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final int computeMaxContextMenuHeight(Context context) {
            WidgetFolderContextMenuBinding widgetFolderContextMenuBindingA = WidgetFolderContextMenuBinding.a(LayoutInflater.from(context).inflate(R.layout.widget_folder_context_menu, (ViewGroup) null, false));
            Intrinsics3.checkNotNullExpressionValue(widgetFolderContextMenuBindingA, "WidgetFolderContextMenuB…om(context), null, false)");
            CardView cardView = widgetFolderContextMenuBindingA.a;
            Intrinsics3.checkNotNullExpressionValue(cardView, "WidgetFolderContextMenuB…ntext), null, false).root");
            cardView.measure(0, 0);
            return cardView.getMeasuredHeight();
        }

        private final WidgetFolderContextMenu newInstance(long folderId) {
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_GUILD_FOLDER_ID", folderId);
            WidgetFolderContextMenu widgetFolderContextMenu = new WidgetFolderContextMenu();
            widgetFolderContextMenu.setArguments(bundleT);
            return widgetFolderContextMenu;
        }

        public final void hide(FragmentActivity activity, boolean animate) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Fragment fragmentFindFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(WidgetFolderContextMenu.FRAGMENT_TAG);
            if (!(fragmentFindFragmentByTag instanceof WidgetFolderContextMenu)) {
                fragmentFindFragmentByTag = null;
            }
            WidgetFolderContextMenu widgetFolderContextMenu = (WidgetFolderContextMenu) fragmentFindFragmentByTag;
            if (widgetFolderContextMenu != null) {
                if (animate) {
                    WidgetFolderContextMenu.access$doCircularRemove(widgetFolderContextMenu);
                    return;
                }
                activity.getSupportFragmentManager().beginTransaction().remove(widgetFolderContextMenu).commitAllowingStateLoss();
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
                FrameLayout frameLayout = (FrameLayout) decorView2.getRootView().findViewWithTag(WidgetFolderContextMenu.VIEW_CONTAINER_TAG);
                if (frameLayout != null) {
                    viewGroup.removeView(frameLayout);
                }
                WidgetFolderContextMenu.access$setShowingContextMenu$cp(false);
            }
        }

        public final void show(FragmentActivity activity, PointF absolutePosition, long folderId) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(absolutePosition, "absolutePosition");
            if (WidgetFolderContextMenu.access$isShowingContextMenu$cp()) {
                return;
            }
            WidgetFolderContextMenu.access$setShowingContextMenu$cp(true);
            computeMaxContextMenuHeight(activity);
            hide(activity, false);
            FrameLayout frameLayout = new FrameLayout(activity);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.setTag(WidgetFolderContextMenu.VIEW_CONTAINER_TAG);
            Window window = activity.getWindow();
            Intrinsics3.checkNotNullExpressionValue(window, "activity.window");
            View decorView = window.getDecorView();
            Intrinsics3.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            View rootView = decorView.getRootView();
            Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) rootView).addView(frameLayout);
            frameLayout.setOnClickListener(new WidgetFolderContextMenu2(activity));
            FrameLayout frameLayout2 = new FrameLayout(activity);
            frameLayout2.setId(View.generateViewId());
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            frameLayout.addView(frameLayout2);
            frameLayout2.setX(absolutePosition.x);
            frameLayout2.setY(_Ranges.coerceAtMost(absolutePosition.y, (r1.getHeight() - computeMaxContextMenuHeight(activity)) - WidgetFolderContextMenu.access$getSCREEN_BOTTOM_BUFFER$cp()));
            activity.getSupportFragmentManager().beginTransaction().add(frameLayout2.getId(), newInstance(folderId), WidgetFolderContextMenu.FRAGMENT_TAG).commit();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$configureValidUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFolderContextMenu.access$doCircularRemove(WidgetFolderContextMenu.this);
            WidgetFolderContextMenu.access$getViewModel$p(WidgetFolderContextMenu.this).onMarkAsReadClicked();
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$configureValidUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ FolderContextMenuViewModel.ViewState.Valid $viewState;

        public AnonymousClass2(FolderContextMenuViewModel.ViewState.Valid valid) {
            this.$viewState = valid;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFolderContextMenu.access$doCircularRemove(WidgetFolderContextMenu.this);
            Long id2 = this.$viewState.getFolder().getId();
            if (id2 != null) {
                WidgetGuildFolderSettings.INSTANCE.create(outline.I(WidgetFolderContextMenu.access$getBinding$p(WidgetFolderContextMenu.this).e, "binding.folderContextMenuSettings", "binding.folderContextMenuSettings.context"), id2.longValue());
            }
            WidgetFolderContextMenu.access$getViewModel$p(WidgetFolderContextMenu.this).onSettingsClicked();
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/guilds/contextmenu/WidgetFolderContextMenu$doCircularRemove$1", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "(Landroid/animation/Animator;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$doCircularRemove$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            FragmentActivity activity = WidgetFolderContextMenu.this.getActivity();
            if (activity != null) {
                Companion companion = WidgetFolderContextMenu.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                companion.hide(activity, false);
            }
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/guilds/contextmenu/WidgetFolderContextMenu$doCircularReveal$1", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "(Landroid/animation/Animator;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$doCircularReveal$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            WidgetFolderContextMenu.access$setAnimationState$p(WidgetFolderContextMenu.this, null);
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<FolderContextMenuViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetFolderContextMenu widgetFolderContextMenu) {
            super(1, widgetFolderContextMenu, WidgetFolderContextMenu.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FolderContextMenuViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FolderContextMenuViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetFolderContextMenu.access$configureUI((WidgetFolderContextMenu) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetFolderContextMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$onResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<FolderContextMenuViewModel.Event, Unit> {
        public AnonymousClass2(WidgetFolderContextMenu widgetFolderContextMenu) {
            super(1, widgetFolderContextMenu, WidgetFolderContextMenu.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FolderContextMenuViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FolderContextMenuViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetFolderContextMenu.access$handleEvent((WidgetFolderContextMenu) this.receiver, event);
        }
    }

    public WidgetFolderContextMenu() {
        super(R.layout.widget_folder_context_menu);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFolderContextMenu3.INSTANCE, null, 2, null);
        WidgetFolderContextMenu4 widgetFolderContextMenu4 = new WidgetFolderContextMenu4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(FolderContextMenuViewModel.class), new WidgetFolderContextMenu$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetFolderContextMenu4));
    }

    public static final /* synthetic */ void access$configureUI(WidgetFolderContextMenu widgetFolderContextMenu, FolderContextMenuViewModel.ViewState viewState) {
        widgetFolderContextMenu.configureUI(viewState);
    }

    public static final /* synthetic */ void access$doCircularRemove(WidgetFolderContextMenu widgetFolderContextMenu) {
        widgetFolderContextMenu.doCircularRemove();
    }

    public static final /* synthetic */ AnimationState access$getAnimationState$p(WidgetFolderContextMenu widgetFolderContextMenu) {
        return widgetFolderContextMenu.animationState;
    }

    public static final /* synthetic */ WidgetFolderContextMenuBinding access$getBinding$p(WidgetFolderContextMenu widgetFolderContextMenu) {
        return widgetFolderContextMenu.getBinding();
    }

    public static final /* synthetic */ int access$getSCREEN_BOTTOM_BUFFER$cp() {
        return SCREEN_BOTTOM_BUFFER;
    }

    public static final /* synthetic */ FolderContextMenuViewModel access$getViewModel$p(WidgetFolderContextMenu widgetFolderContextMenu) {
        return widgetFolderContextMenu.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetFolderContextMenu widgetFolderContextMenu, FolderContextMenuViewModel.Event event) {
        widgetFolderContextMenu.handleEvent(event);
    }

    public static final /* synthetic */ boolean access$isShowingContextMenu$cp() {
        return isShowingContextMenu;
    }

    public static final /* synthetic */ void access$setAnimationState$p(WidgetFolderContextMenu widgetFolderContextMenu, AnimationState animationState) {
        widgetFolderContextMenu.animationState = animationState;
    }

    public static final /* synthetic */ void access$setShowingContextMenu$cp(boolean z2) {
        isShowingContextMenu = z2;
    }

    private final void configureUI(FolderContextMenuViewModel.ViewState viewState) {
        if (viewState instanceof FolderContextMenuViewModel.ViewState.Valid) {
            configureValidUI((FolderContextMenuViewModel.ViewState.Valid) viewState);
        } else if (Intrinsics3.areEqual(viewState, FolderContextMenuViewModel.ViewState.Invalid.INSTANCE)) {
            Companion companion = INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.hide(fragmentActivityRequireActivity, false);
        }
    }

    private final void configureValidUI(FolderContextMenuViewModel.ViewState.Valid viewState) {
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.folderContextMenuHeader");
        CharSequence name = viewState.getFolder().getName();
        if (name == null) {
            name = FormatUtils.k(this, R.string.guild_folder_unnamed, new Object[0], null, 4);
        }
        textView.setText(name);
        getBinding().d.setOnClickListener(new AnonymousClass1());
        getBinding().e.setOnClickListener(new AnonymousClass2(viewState));
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.folderContextMenuMarkAsRead");
        textView2.setVisibility(viewState.getShowMarkAsRead() ? 0 : 8);
        getBinding().f2386b.setContentPadding(0, 0, 0, 0);
        CardView cardView = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
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
        CardView cardView = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
        int height = cardView.getHeight() / 2;
        CardView cardView2 = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.folderContextMenuCard");
        int width = cardView2.getWidth();
        Intrinsics3.checkNotNullExpressionValue(getBinding().f2386b, "binding.folderContextMenuCard");
        float fHypot = (float) Math.hypot(width, r5.getHeight() / 2);
        CardView cardView3 = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.folderContextMenuCard");
        if (!cardView3.isAttachedToWindow()) {
            CardView cardView4 = getBinding().f2386b;
            Intrinsics3.checkNotNullExpressionValue(cardView4, "binding.folderContextMenuCard");
            cardView4.setVisibility(8);
            return;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f2386b, 0, height, fHypot, 0.0f);
        this.animator = animatorCreateCircularReveal;
        this.animationState = animationState2;
        Intrinsics3.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new AnonymousClass1());
        animatorCreateCircularReveal.start();
    }

    private final void doCircularReveal() {
        CardView cardView = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
        if (!cardView.isAttachedToWindow()) {
            CardView cardView2 = getBinding().f2386b;
            Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.folderContextMenuCard");
            cardView2.setVisibility(0);
            return;
        }
        CardView cardView3 = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.folderContextMenuCard");
        int height = cardView3.getHeight() / 2;
        CardView cardView4 = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView4, "binding.folderContextMenuCard");
        int width = cardView4.getWidth();
        Intrinsics3.checkNotNullExpressionValue(getBinding().f2386b, "binding.folderContextMenuCard");
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f2386b, 0, height, 0.0f, (float) Math.hypot(width, r4.getHeight() / 2));
        this.animator = animatorCreateCircularReveal;
        this.animationState = AnimationState.ANIMATING_IN;
        Intrinsics3.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new AnonymousClass1());
        CardView cardView5 = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView5, "binding.folderContextMenuCard");
        cardView5.setVisibility(0);
        animatorCreateCircularReveal.start();
    }

    private final WidgetFolderContextMenuBinding getBinding() {
        return (WidgetFolderContextMenuBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final FolderContextMenuViewModel getViewModel() {
        return (FolderContextMenuViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(FolderContextMenuViewModel.Event event) {
        if (Intrinsics3.areEqual(event, FolderContextMenuViewModel.Event.Dismiss.INSTANCE)) {
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetFolderContextMenu.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetFolderContextMenu.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
