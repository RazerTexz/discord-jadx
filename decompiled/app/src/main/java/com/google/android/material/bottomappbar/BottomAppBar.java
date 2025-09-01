package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.motion.widget.Key;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final long ANIMATION_DURATION = 300;
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_BottomAppBar;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    private static final int NO_MENU_RES_ID = 0;
    private int animatingModeChangeCounter;
    private ArrayList<j> animationListeners;
    private Behavior behavior;
    private int bottomInset;
    private int fabAlignmentMode;

    @NonNull
    public AnimatorListenerAdapter fabAnimationListener;
    private int fabAnimationMode;
    private boolean fabAttached;
    private final int fabOffsetEndMode;

    @NonNull
    public TransformationCallback<FloatingActionButton> fabTransformationCallback;
    private boolean hideOnScroll;
    private int leftInset;
    private final MaterialShapeDrawable materialShapeDrawable;
    private boolean menuAnimatingWithFabAlignmentMode;

    @Nullable
    private Animator menuAnimator;

    @Nullable
    private Animator modeAnimator;
    private final boolean paddingBottomSystemWindowInsets;
    private final boolean paddingLeftSystemWindowInsets;
    private final boolean paddingRightSystemWindowInsets;

    @MenuRes
    private int pendingMenuResId;
    private int rightInset;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        @NonNull
        private final Rect fabContentRect;
        private final View.OnLayoutChangeListener fabLayoutListener;
        private int originalBottomMargin;
        private WeakReference<BottomAppBar> viewRef;

        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.access$2400(Behavior.this).get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.getMeasuredContentRect(Behavior.access$2500(Behavior.this));
                int iHeight = Behavior.access$2500(Behavior.this).height();
                bottomAppBar.setFabDiameter(iHeight);
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                if (Behavior.access$2600(Behavior.this) == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = BottomAppBar.access$2700(bottomAppBar) + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = BottomAppBar.access$2800(bottomAppBar);
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = BottomAppBar.access$2900(bottomAppBar);
                    if (ViewUtils.isLayoutRtl(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = BottomAppBar.access$3000(bottomAppBar) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = BottomAppBar.access$3000(bottomAppBar) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    }
                }
            }
        }

        public Behavior() {
            this.fabLayoutListener = new a();
            this.fabContentRect = new Rect();
        }

        public static /* synthetic */ WeakReference access$2400(Behavior behavior) {
            return behavior.viewRef;
        }

        public static /* synthetic */ Rect access$2500(Behavior behavior) {
            return behavior.fabContentRect;
        }

        public static /* synthetic */ int access$2600(Behavior behavior) {
            return behavior.originalBottomMargin;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
            return onLayoutChild(coordinatorLayout, (BottomAppBar) view, i);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, int i, int i2) {
            return onStartNestedScroll(coordinatorLayout, (BottomAppBar) view, view2, view3, i, i2);
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i) {
            this.viewRef = new WeakReference<>(bottomAppBar);
            View viewAccess$3100 = BottomAppBar.access$3100(bottomAppBar);
            if (viewAccess$3100 != null && !ViewCompat.isLaidOut(viewAccess$3100)) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) viewAccess$3100.getLayoutParams();
                layoutParams.anchorGravity = 49;
                this.originalBottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                if (viewAccess$3100 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewAccess$3100;
                    floatingActionButton.addOnLayoutChangeListener(this.fabLayoutListener);
                    BottomAppBar.access$3200(bottomAppBar, floatingActionButton);
                }
                BottomAppBar.access$1300(bottomAppBar);
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i);
            return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) bottomAppBar, i);
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) bottomAppBar, view, view2, i, i2);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.fabLayoutListener = new a();
            this.fabContentRect = new Rect();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int j;
        public boolean k;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.j = parcel.readInt();
            this.k = parcel.readInt() != 0;
        }
    }

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (BottomAppBar.access$000(BottomAppBar.this)) {
                return;
            }
            BottomAppBar bottomAppBar = BottomAppBar.this;
            BottomAppBar.access$300(bottomAppBar, BottomAppBar.access$100(bottomAppBar), BottomAppBar.access$200(BottomAppBar.this));
        }
    }

    public class b implements TransformationCallback<FloatingActionButton> {
        public b() {
        }

        @Override // com.google.android.material.animation.TransformationCallback
        public void onScaleChanged(@NonNull View view) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            BottomAppBar.access$400(BottomAppBar.this).setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // com.google.android.material.animation.TransformationCallback
        public void onTranslationChanged(@NonNull View view) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.access$500(BottomAppBar.this).getHorizontalOffset() != translationX) {
                BottomAppBar.access$500(BottomAppBar.this).setHorizontalOffset(translationX);
                BottomAppBar.access$400(BottomAppBar.this).invalidateSelf();
            }
            float fMax = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.access$500(BottomAppBar.this).getCradleVerticalOffset() != fMax) {
                BottomAppBar.access$500(BottomAppBar.this).setCradleVerticalOffset(fMax);
                BottomAppBar.access$400(BottomAppBar.this).invalidateSelf();
            }
            BottomAppBar.access$400(BottomAppBar.this).setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    public class c implements ViewUtils.OnApplyWindowInsetsListener {
        public c() {
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
            boolean z2;
            if (BottomAppBar.access$600(BottomAppBar.this)) {
                BottomAppBar.access$702(BottomAppBar.this, windowInsetsCompat.getSystemWindowInsetBottom());
            }
            boolean z3 = false;
            if (BottomAppBar.access$800(BottomAppBar.this)) {
                z2 = BottomAppBar.access$900(BottomAppBar.this) != windowInsetsCompat.getSystemWindowInsetLeft();
                BottomAppBar.access$902(BottomAppBar.this, windowInsetsCompat.getSystemWindowInsetLeft());
            } else {
                z2 = false;
            }
            if (BottomAppBar.access$1000(BottomAppBar.this)) {
                boolean z4 = BottomAppBar.access$1100(BottomAppBar.this) != windowInsetsCompat.getSystemWindowInsetRight();
                BottomAppBar.access$1102(BottomAppBar.this, windowInsetsCompat.getSystemWindowInsetRight());
                z3 = z4;
            }
            if (z2 || z3) {
                BottomAppBar.access$1200(BottomAppBar.this);
                BottomAppBar.access$1300(BottomAppBar.this);
                BottomAppBar.access$1400(BottomAppBar.this);
            }
            return windowInsetsCompat;
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.access$1600(BottomAppBar.this);
            BottomAppBar.access$1702(BottomAppBar.this, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.access$1500(BottomAppBar.this);
        }
    }

    public class e extends FloatingActionButton.OnVisibilityChangedListener {
        public final /* synthetic */ int a;

        public class a extends FloatingActionButton.OnVisibilityChangedListener {
            public a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
            public void onShown(FloatingActionButton floatingActionButton) {
                BottomAppBar.access$1600(BottomAppBar.this);
            }
        }

        public e(int i) {
            this.a = i;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
        public void onHidden(@NonNull FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.access$1800(BottomAppBar.this, this.a));
            floatingActionButton.show(new a());
        }
    }

    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.access$1600(BottomAppBar.this);
            BottomAppBar.access$002(BottomAppBar.this, false);
            BottomAppBar.access$1902(BottomAppBar.this, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.access$1500(BottomAppBar.this);
        }
    }

    public class g extends AnimatorListenerAdapter {
        public boolean a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f3030b;
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;

        public g(ActionMenuView actionMenuView, int i, boolean z2) {
            this.f3030b = actionMenuView;
            this.c = i;
            this.d = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            boolean z2 = BottomAppBar.access$2000(BottomAppBar.this) != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.replaceMenu(BottomAppBar.access$2000(bottomAppBar));
            BottomAppBar.access$2100(BottomAppBar.this, this.f3030b, this.c, this.d, z2);
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ ActionMenuView j;
        public final /* synthetic */ int k;
        public final /* synthetic */ boolean l;

        public h(ActionMenuView actionMenuView, int i, boolean z2) {
            this.j = actionMenuView;
            this.k = i;
            this.l = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.j.setTranslationX(BottomAppBar.this.getActionMenuViewTranslationX(r0, this.k, this.l));
        }
    }

    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.fabAnimationListener.onAnimationStart(animator);
            FloatingActionButton floatingActionButtonAccess$2200 = BottomAppBar.access$2200(BottomAppBar.this);
            if (floatingActionButtonAccess$2200 != null) {
                floatingActionButtonAccess$2200.setTranslationX(BottomAppBar.access$2300(BottomAppBar.this));
            }
        }
    }

    public interface j {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    public BottomAppBar(@NonNull Context context) {
        this(context, null, 0);
    }

    public static /* synthetic */ boolean access$000(BottomAppBar bottomAppBar) {
        return bottomAppBar.menuAnimatingWithFabAlignmentMode;
    }

    public static /* synthetic */ boolean access$002(BottomAppBar bottomAppBar, boolean z2) {
        bottomAppBar.menuAnimatingWithFabAlignmentMode = z2;
        return z2;
    }

    public static /* synthetic */ int access$100(BottomAppBar bottomAppBar) {
        return bottomAppBar.fabAlignmentMode;
    }

    public static /* synthetic */ boolean access$1000(BottomAppBar bottomAppBar) {
        return bottomAppBar.paddingRightSystemWindowInsets;
    }

    public static /* synthetic */ int access$1100(BottomAppBar bottomAppBar) {
        return bottomAppBar.rightInset;
    }

    public static /* synthetic */ int access$1102(BottomAppBar bottomAppBar, int i2) {
        bottomAppBar.rightInset = i2;
        return i2;
    }

    public static /* synthetic */ void access$1200(BottomAppBar bottomAppBar) {
        bottomAppBar.cancelAnimations();
    }

    public static /* synthetic */ void access$1300(BottomAppBar bottomAppBar) {
        bottomAppBar.setCutoutState();
    }

    public static /* synthetic */ void access$1400(BottomAppBar bottomAppBar) {
        bottomAppBar.setActionMenuViewPosition();
    }

    public static /* synthetic */ void access$1500(BottomAppBar bottomAppBar) {
        bottomAppBar.dispatchAnimationStart();
    }

    public static /* synthetic */ void access$1600(BottomAppBar bottomAppBar) {
        bottomAppBar.dispatchAnimationEnd();
    }

    public static /* synthetic */ Animator access$1702(BottomAppBar bottomAppBar, Animator animator) {
        bottomAppBar.modeAnimator = animator;
        return animator;
    }

    public static /* synthetic */ float access$1800(BottomAppBar bottomAppBar, int i2) {
        return bottomAppBar.getFabTranslationX(i2);
    }

    public static /* synthetic */ Animator access$1902(BottomAppBar bottomAppBar, Animator animator) {
        bottomAppBar.menuAnimator = animator;
        return animator;
    }

    public static /* synthetic */ boolean access$200(BottomAppBar bottomAppBar) {
        return bottomAppBar.fabAttached;
    }

    public static /* synthetic */ int access$2000(BottomAppBar bottomAppBar) {
        return bottomAppBar.pendingMenuResId;
    }

    public static /* synthetic */ void access$2100(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i2, boolean z2, boolean z3) {
        bottomAppBar.translateActionMenuView(actionMenuView, i2, z2, z3);
    }

    public static /* synthetic */ FloatingActionButton access$2200(BottomAppBar bottomAppBar) {
        return bottomAppBar.findDependentFab();
    }

    public static /* synthetic */ float access$2300(BottomAppBar bottomAppBar) {
        return bottomAppBar.getFabTranslationX();
    }

    public static /* synthetic */ int access$2700(BottomAppBar bottomAppBar) {
        return bottomAppBar.getBottomInset();
    }

    public static /* synthetic */ int access$2800(BottomAppBar bottomAppBar) {
        return bottomAppBar.getLeftInset();
    }

    public static /* synthetic */ int access$2900(BottomAppBar bottomAppBar) {
        return bottomAppBar.getRightInset();
    }

    public static /* synthetic */ void access$300(BottomAppBar bottomAppBar, int i2, boolean z2) {
        bottomAppBar.maybeAnimateMenuView(i2, z2);
    }

    public static /* synthetic */ int access$3000(BottomAppBar bottomAppBar) {
        return bottomAppBar.fabOffsetEndMode;
    }

    public static /* synthetic */ View access$3100(BottomAppBar bottomAppBar) {
        return bottomAppBar.findDependentView();
    }

    public static /* synthetic */ void access$3200(BottomAppBar bottomAppBar, FloatingActionButton floatingActionButton) {
        bottomAppBar.addFabAnimationListeners(floatingActionButton);
    }

    public static /* synthetic */ MaterialShapeDrawable access$400(BottomAppBar bottomAppBar) {
        return bottomAppBar.materialShapeDrawable;
    }

    public static /* synthetic */ BottomAppBarTopEdgeTreatment access$500(BottomAppBar bottomAppBar) {
        return bottomAppBar.getTopEdgeTreatment();
    }

    public static /* synthetic */ boolean access$600(BottomAppBar bottomAppBar) {
        return bottomAppBar.paddingBottomSystemWindowInsets;
    }

    public static /* synthetic */ int access$702(BottomAppBar bottomAppBar, int i2) {
        bottomAppBar.bottomInset = i2;
        return i2;
    }

    public static /* synthetic */ boolean access$800(BottomAppBar bottomAppBar) {
        return bottomAppBar.paddingLeftSystemWindowInsets;
    }

    public static /* synthetic */ int access$900(BottomAppBar bottomAppBar) {
        return bottomAppBar.leftInset;
    }

    public static /* synthetic */ int access$902(BottomAppBar bottomAppBar, int i2) {
        bottomAppBar.leftInset = i2;
        return i2;
    }

    private void addFabAnimationListeners(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.addOnHideAnimationListener(this.fabAnimationListener);
        floatingActionButton.addOnShowAnimationListener(new i());
        floatingActionButton.addTransformationCallback(this.fabTransformationCallback);
    }

    private void cancelAnimations() {
        Animator animator = this.menuAnimator;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.modeAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void createFabTranslationXAnimation(int i2, @NonNull List<Animator> list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(findDependentFab(), Key.TRANSLATION_X, getFabTranslationX(i2));
        objectAnimatorOfFloat.setDuration(300L);
        list.add(objectAnimatorOfFloat);
    }

    private void createMenuViewTranslationAnimation(int i2, boolean z2, @NonNull List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator animatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, Key.ALPHA, 1.0f);
        if (Math.abs(actionMenuView.getTranslationX() - getActionMenuViewTranslationX(actionMenuView, i2, z2)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, Key.ALPHA, 0.0f);
            objectAnimatorOfFloat.addListener(new g(actionMenuView, i2, z2));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    private void dispatchAnimationEnd() {
        ArrayList<j> arrayList;
        int i2 = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = i2;
        if (i2 != 0 || (arrayList = this.animationListeners) == null) {
            return;
        }
        Iterator<j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    private void dispatchAnimationStart() {
        ArrayList<j> arrayList;
        int i2 = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = i2 + 1;
        if (i2 != 0 || (arrayList = this.animationListeners) == null) {
            return;
        }
        Iterator<j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    @Nullable
    private FloatingActionButton findDependentFab() {
        View viewFindDependentView = findDependentView();
        if (viewFindDependentView instanceof FloatingActionButton) {
            return (FloatingActionButton) viewFindDependentView;
        }
        return null;
    }

    @Nullable
    private View findDependentView() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private int getBottomInset() {
        return this.bottomInset;
    }

    private float getFabTranslationX(int i2) {
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        if (i2 == 1) {
            return ((getMeasuredWidth() / 2) - (this.fabOffsetEndMode + (zIsLayoutRtl ? this.leftInset : this.rightInset))) * (zIsLayoutRtl ? -1 : 1);
        }
        return 0.0f;
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().getCradleVerticalOffset();
    }

    private int getLeftInset() {
        return this.leftInset;
    }

    private int getRightInset() {
        return this.rightInset;
    }

    @NonNull
    private BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.materialShapeDrawable.getShapeAppearanceModel().getTopEdge();
    }

    private boolean isFabVisibleOrWillBeShown() {
        FloatingActionButton floatingActionButtonFindDependentFab = findDependentFab();
        return floatingActionButtonFindDependentFab != null && floatingActionButtonFindDependentFab.isOrWillBeShown();
    }

    private void maybeAnimateMenuView(int i2, boolean z2) {
        if (!ViewCompat.isLaidOut(this)) {
            this.menuAnimatingWithFabAlignmentMode = false;
            replaceMenu(this.pendingMenuResId);
            return;
        }
        Animator animator = this.menuAnimator;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!isFabVisibleOrWillBeShown()) {
            i2 = 0;
            z2 = false;
        }
        createMenuViewTranslationAnimation(i2, z2, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.menuAnimator = animatorSet;
        animatorSet.addListener(new f());
        this.menuAnimator.start();
    }

    private void maybeAnimateModeChange(int i2) {
        if (this.fabAlignmentMode == i2 || !ViewCompat.isLaidOut(this)) {
            return;
        }
        Animator animator = this.modeAnimator;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.fabAnimationMode == 1) {
            createFabTranslationXAnimation(i2, arrayList);
        } else {
            createFabDefaultXAnimation(i2, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.modeAnimator = animatorSet;
        animatorSet.addListener(new d());
        this.modeAnimator.start();
    }

    private void setActionMenuViewPosition() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.menuAnimator != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (isFabVisibleOrWillBeShown()) {
            translateActionMenuView(actionMenuView, this.fabAlignmentMode, this.fabAttached);
        } else {
            translateActionMenuView(actionMenuView, 0, false);
        }
    }

    private void setCutoutState() {
        getTopEdgeTreatment().setHorizontalOffset(getFabTranslationX());
        View viewFindDependentView = findDependentView();
        this.materialShapeDrawable.setInterpolation((this.fabAttached && isFabVisibleOrWillBeShown()) ? 1.0f : 0.0f);
        if (viewFindDependentView != null) {
            viewFindDependentView.setTranslationY(getFabTranslationY());
            viewFindDependentView.setTranslationX(getFabTranslationX());
        }
    }

    private void translateActionMenuView(@NonNull ActionMenuView actionMenuView, int i2, boolean z2) {
        translateActionMenuView(actionMenuView, i2, z2, false);
    }

    public void addAnimationListener(@NonNull j jVar) {
        if (this.animationListeners == null) {
            this.animationListeners = new ArrayList<>();
        }
        this.animationListeners.add(jVar);
    }

    public void createFabDefaultXAnimation(int i2, List<Animator> list) {
        FloatingActionButton floatingActionButtonFindDependentFab = findDependentFab();
        if (floatingActionButtonFindDependentFab == null || floatingActionButtonFindDependentFab.isOrWillBeHidden()) {
            return;
        }
        dispatchAnimationStart();
        floatingActionButtonFindDependentFab.hide(new e(i2));
    }

    public int getActionMenuViewTranslationX(@NonNull ActionMenuView actionMenuView, int i2, boolean z2) {
        if (i2 != 1 || !z2) {
            return 0;
        }
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        int measuredWidth = zIsLayoutRtl ? getMeasuredWidth() : 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                measuredWidth = zIsLayoutRtl ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((zIsLayoutRtl ? actionMenuView.getRight() : actionMenuView.getLeft()) + (zIsLayoutRtl ? this.rightInset : -this.leftInset));
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public /* bridge */ /* synthetic */ CoordinatorLayout.Behavior getBehavior() {
        return getBehavior();
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().getCradleVerticalOffset();
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().getFabCradleMargin();
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().getFabCradleRoundedCornerRadius();
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialShapeDrawable);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            cancelAnimations();
            setCutoutState();
        }
        setActionMenuViewPosition();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.fabAlignmentMode = savedState.j;
        this.fabAttached = savedState.k;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.j = this.fabAlignmentMode;
        savedState.k = this.fabAttached;
        return savedState;
    }

    public void performHide() {
        getBehavior().slideDown(this);
    }

    public void performShow() {
        getBehavior().slideUp(this);
    }

    public void removeAnimationListener(@NonNull j jVar) {
        ArrayList<j> arrayList = this.animationListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(jVar);
    }

    public void replaceMenu(@MenuRes int i2) {
        if (i2 != 0) {
            this.pendingMenuResId = 0;
            getMenu().clear();
            inflateMenu(i2);
        }
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.materialShapeDrawable, colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().setCradleVerticalOffset(f2);
            this.materialShapeDrawable.invalidateSelf();
            setCutoutState();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        this.materialShapeDrawable.setElevation(f2);
        getBehavior().setAdditionalHiddenOffsetY(this, this.materialShapeDrawable.getShadowRadius() - this.materialShapeDrawable.getShadowOffsetY());
    }

    public void setFabAlignmentMode(int i2) {
        setFabAlignmentModeAndReplaceMenu(i2, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int i2, @MenuRes int i3) {
        this.pendingMenuResId = i3;
        this.menuAnimatingWithFabAlignmentMode = true;
        maybeAnimateMenuView(i2, this.fabAttached);
        maybeAnimateModeChange(i2);
        this.fabAlignmentMode = i2;
    }

    public void setFabAnimationMode(int i2) {
        this.fabAnimationMode = i2;
    }

    public void setFabCradleMargin(@Dimension float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().setFabCradleMargin(f2);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().setFabCradleRoundedCornerRadius(f2);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public boolean setFabDiameter(@Px int i2) {
        float f2 = i2;
        if (f2 == getTopEdgeTreatment().getFabDiameter()) {
            return false;
        }
        getTopEdgeTreatment().setFabDiameter(f2);
        this.materialShapeDrawable.invalidateSelf();
        return true;
    }

    public void setHideOnScroll(boolean z2) {
        this.hideOnScroll = z2;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    private void translateActionMenuView(@NonNull ActionMenuView actionMenuView, int i2, boolean z2, boolean z3) {
        h hVar = new h(actionMenuView, i2, z2);
        if (z3) {
            actionMenuView.post(hVar);
        } else {
            hVar.run();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        if (this.behavior == null) {
            this.behavior = new Behavior();
        }
        return this.behavior;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i2, i3), attributeSet, i2);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.materialShapeDrawable = materialShapeDrawable;
        this.animatingModeChangeCounter = 0;
        this.pendingMenuResId = 0;
        this.menuAnimatingWithFabAlignmentMode = false;
        this.fabAttached = true;
        this.fabAnimationListener = new a();
        this.fabTransformationCallback = new b();
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.BottomAppBar, i2, i3, new int[0]);
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, R.styleable.BottomAppBar_backgroundTint);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.fabAlignmentMode = typedArrayObtainStyledAttributes.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = typedArrayObtainStyledAttributes.getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.hideOnScroll = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        this.paddingBottomSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        materialShapeDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setTopEdge(new BottomAppBarTopEdgeTreatment(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3)).build());
        materialShapeDrawable.setShadowCompatibilityMode(2);
        materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
        materialShapeDrawable.initializeElevationOverlay(context2);
        setElevation(dimensionPixelSize);
        DrawableCompat.setTintList(materialShapeDrawable, colorStateList);
        ViewCompat.setBackground(this, materialShapeDrawable);
        ViewUtils.doOnApplyWindowInsets(this, attributeSet, i2, i3, new c());
    }

    private float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }
}
