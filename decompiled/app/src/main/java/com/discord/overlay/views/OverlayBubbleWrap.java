package com.discord.overlay.views;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import b.d.b.a.outline;
import com.discord.overlay.R;
import com.discord.utilities.display.DisplayUtils;
import d0.b0.ObservableProperty;
import d0.z.d.Intrinsics3;
import d0.z.d.MutablePropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.Interfaces;
import kotlin.reflect.KProperty;

/* compiled from: OverlayBubbleWrap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bw\u0010xJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001dH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u001dH\u0016¢\u0006\u0004\b#\u0010\u001fJ\u0017\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u001dH\u0016¢\u0006\u0004\b%\u0010\"J\u0017\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020&H\u0004¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0019\u0010/\u001a\u00020\t2\b\b\u0002\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b/\u0010\u000bJ\u000f\u00100\u001a\u00020\tH\u0002¢\u0006\u0004\b0\u00101R0\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R+\u0010@\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00078V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010\u000bR\u0013\u0010C\u001a\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\bA\u0010BR\"\u0010J\u001a\u00020D8\u0004@\u0004X\u0084\u0004¢\u0006\u0012\n\u0004\bE\u0010F\u0012\u0004\bI\u00101\u001a\u0004\bG\u0010HR\u0019\u0010N\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010BR\u001c\u0010T\u001a\u00020O8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010LR\u0019\u0010[\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\"\u0010c\u001a\u00020\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0016\u0010f\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0019\u0010l\u001a\u00020g8\u0006@\u0006¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0018\u0010n\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010eR\u0013\u0010p\u001a\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\bo\u0010BR\u0016\u0010r\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010LR\"\u0010v\u001a\u00020D8\u0004@\u0004X\u0084\u0004¢\u0006\u0012\n\u0004\bs\u0010F\u0012\u0004\bu\u00101\u001a\u0004\bt\u0010H¨\u0006y"}, d2 = {"Lcom/discord/overlay/views/OverlayBubbleWrap;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/graphics/Rect;", "e", "(Landroid/content/Context;)Landroid/graphics/Rect;", "", "isTouchable", "", "setBubbleTouchable", "(Z)V", "changed", "", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/MotionEvent;", "motionEvent", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "onInterceptTouchEvent", "", "getX", "()F", "x", "setX", "(F)V", "getY", "y", "setY", "Landroid/graphics/Point;", "newAnchorPoint", "setAnchorAt", "(Landroid/graphics/Point;)V", "Landroid/view/View;", "targetView", "b", "(Landroid/view/View;)V", "animate", "a", "d", "()V", "Lkotlin/Function1;", "p", "Lkotlin/jvm/functions/Function1;", "getOnMovingStateChanged", "()Lkotlin/jvm/functions/Function1;", "setOnMovingStateChanged", "(Lkotlin/jvm/functions/Function1;)V", "onMovingStateChanged", "<set-?>", "o", "Lkotlin/properties/ReadWriteProperty;", "f", "()Z", "setMoving", "isMoving", "getCenterY", "()I", "centerY", "Landroidx/dynamicanimation/animation/SpringAnimation;", "u", "Landroidx/dynamicanimation/animation/SpringAnimation;", "getSpringAnimationY", "()Landroidx/dynamicanimation/animation/SpringAnimation;", "getSpringAnimationY$annotations", "springAnimationY", "n", "I", "getMoveThresholdPx", "moveThresholdPx", "Landroid/view/WindowManager;", "k", "Landroid/view/WindowManager;", "getWindowManager", "()Landroid/view/WindowManager;", "windowManager", "r", "deltaX", "m", "Landroid/graphics/Rect;", "getInsetMargins", "()Landroid/graphics/Rect;", "insetMargins", "Landroid/view/WindowManager$LayoutParams;", "l", "Landroid/view/WindowManager$LayoutParams;", "getWindowLayoutParams", "()Landroid/view/WindowManager$LayoutParams;", "setWindowLayoutParams", "(Landroid/view/WindowManager$LayoutParams;)V", "windowLayoutParams", "v", "Landroid/graphics/Point;", "actualPosition", "", "q", "[I", "getScreenOffset", "()[I", "screenOffset", "w", "anchorPosition", "getCenterX", "centerX", "s", "deltaY", "t", "getSpringAnimationX", "getSpringAnimationX$annotations", "springAnimationX", "<init>", "(Landroid/content/Context;)V", "overlay_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public class OverlayBubbleWrap extends FrameLayout {
    public static final /* synthetic */ KProperty[] j = {Reflection2.mutableProperty1(new MutablePropertyReference1Impl(OverlayBubbleWrap.class, "isMoving", "isMoving()Z", 0))};

    /* renamed from: k, reason: from kotlin metadata */
    public final WindowManager windowManager;

    /* renamed from: l, reason: from kotlin metadata */
    public WindowManager.LayoutParams windowLayoutParams;

    /* renamed from: m, reason: from kotlin metadata */
    public final Rect insetMargins;

    /* renamed from: n, reason: from kotlin metadata */
    public final int moveThresholdPx;

    /* renamed from: o, reason: from kotlin metadata */
    public final Interfaces isMoving;

    /* renamed from: p, reason: from kotlin metadata */
    public Function1<? super Boolean, Unit> onMovingStateChanged;

    /* renamed from: q, reason: from kotlin metadata */
    public final int[] screenOffset;

    /* renamed from: r, reason: from kotlin metadata */
    public int deltaX;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public int deltaY;

    /* renamed from: t, reason: from kotlin metadata */
    public final SpringAnimation springAnimationX;

    /* renamed from: u, reason: from kotlin metadata */
    public final SpringAnimation springAnimationY;

    /* renamed from: v, reason: from kotlin metadata */
    public Point actualPosition;

    /* renamed from: w, reason: from kotlin metadata */
    public Point anchorPosition;

    /* compiled from: Delegates.kt */
    public static final class a extends ObservableProperty<Boolean> {
        public final /* synthetic */ OverlayBubbleWrap a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, Object obj2, OverlayBubbleWrap overlayBubbleWrap) {
            super(obj2);
            this.a = overlayBubbleWrap;
        }

        @Override // d0.b0.ObservableProperty
        public void afterChange(KProperty<?> kProperty, Boolean bool, Boolean bool2) {
            Intrinsics3.checkNotNullParameter(kProperty, "property");
            boolean zBooleanValue = bool2.booleanValue();
            if (bool.booleanValue() == zBooleanValue) {
                return;
            }
            Function1<Boolean, Unit> onMovingStateChanged = this.a.getOnMovingStateChanged();
            if (onMovingStateChanged != null) {
                onMovingStateChanged.invoke(Boolean.valueOf(zBooleanValue));
            }
            if (zBooleanValue) {
                this.a.performHapticFeedback(1);
                this.a.getSpringAnimationX().cancel();
                this.a.getSpringAnimationY().cancel();
            }
            this.a.setPressed(zBooleanValue);
        }
    }

    /* compiled from: View.kt */
    public static final class b implements View.OnLayoutChangeListener {
        public b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Intrinsics3.checkNotNullParameter(view, "view");
            view.removeOnLayoutChangeListener(this);
            OverlayBubbleWrap overlayBubbleWrap = OverlayBubbleWrap.this;
            KProperty[] kPropertyArr = OverlayBubbleWrap.j;
            overlayBubbleWrap.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayBubbleWrap(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        Object systemService = getContext().getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) systemService;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, Build.VERSION.SDK_INT <= 25 ? 2007 : 2038, 16777768, -3);
        layoutParams.gravity = 51;
        this.windowLayoutParams = layoutParams;
        this.insetMargins = new Rect();
        this.moveThresholdPx = getResources().getDimensionPixelOffset(R.b.movement_threshold_dp);
        setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), R.c.bubble_state_selector));
        Boolean bool = Boolean.FALSE;
        this.isMoving = new a(bool, bool, this);
        this.screenOffset = new int[2];
        SpringAnimation springAnimation = new SpringAnimation(this, DynamicAnimation.X, 0.0f);
        springAnimation.setStartVelocity(50.0f);
        SpringForce spring = springAnimation.getSpring();
        Intrinsics3.checkNotNullExpressionValue(spring, "spring");
        spring.setStiffness(200.0f);
        SpringForce spring2 = springAnimation.getSpring();
        Intrinsics3.checkNotNullExpressionValue(spring2, "spring");
        spring2.setDampingRatio(0.75f);
        this.springAnimationX = springAnimation;
        SpringAnimation springAnimation2 = new SpringAnimation(this, DynamicAnimation.Y, 0.0f);
        springAnimation2.setStartVelocity(50.0f);
        SpringForce spring3 = springAnimation2.getSpring();
        Intrinsics3.checkNotNullExpressionValue(spring3, "spring");
        spring3.setDampingRatio(0.75f);
        SpringForce spring4 = springAnimation2.getSpring();
        Intrinsics3.checkNotNullExpressionValue(spring4, "spring");
        spring4.setStiffness(200.0f);
        this.springAnimationY = springAnimation2;
        WindowManager.LayoutParams layoutParams2 = this.windowLayoutParams;
        this.actualPosition = new Point(layoutParams2.x, layoutParams2.y);
    }

    public static void c(OverlayBubbleWrap overlayBubbleWrap, int i, int i2, Rect rect, int i3, Object obj) {
        Rect rectE;
        if ((i3 & 4) != 0) {
            Context context = overlayBubbleWrap.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            rectE = overlayBubbleWrap.e(context);
        } else {
            rectE = null;
        }
        Intrinsics3.checkNotNullParameter(rectE, "screenBounds");
        int iMin = Math.min(Math.max(rectE.left, i), rectE.right - overlayBubbleWrap.getWidth());
        SpringAnimation springAnimation = overlayBubbleWrap.springAnimationX;
        float f = overlayBubbleWrap.windowLayoutParams.x;
        Intrinsics3.checkNotNullParameter(springAnimation, "$this$animateTo");
        springAnimation.cancel();
        springAnimation.setStartValue(f);
        springAnimation.animateToFinalPosition(iMin);
        int iMin2 = Math.min(Math.max(rectE.top - overlayBubbleWrap.screenOffset[1], i2), rectE.bottom - overlayBubbleWrap.getHeight());
        SpringAnimation springAnimation2 = overlayBubbleWrap.springAnimationY;
        float f2 = overlayBubbleWrap.windowLayoutParams.y;
        Intrinsics3.checkNotNullParameter(springAnimation2, "$this$animateTo");
        springAnimation2.cancel();
        springAnimation2.setStartValue(f2);
        springAnimation2.animateToFinalPosition(iMin2);
    }

    public static /* synthetic */ void getSpringAnimationX$annotations() {
    }

    public static /* synthetic */ void getSpringAnimationY$annotations() {
    }

    public void a(boolean animate) {
        String simpleName = getClass().getSimpleName();
        StringBuilder sbU = outline.U("Unanchoring[");
        sbU.append(this.anchorPosition);
        sbU.append("] -> ");
        sbU.append(this.actualPosition);
        Log.d(simpleName, sbU.toString());
        this.anchorPosition = null;
        this.springAnimationX.cancel();
        this.springAnimationY.cancel();
        if (animate) {
            Point point = this.actualPosition;
            c(this, point.x, point.y, null, 4, null);
            return;
        }
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        Point point2 = this.actualPosition;
        layoutParams.x = point2.x;
        layoutParams.y = point2.y;
        this.windowManager.updateViewLayout(this, layoutParams);
    }

    public void b(View targetView) {
        Intrinsics3.checkNotNullParameter(targetView, "targetView");
        Intrinsics3.checkNotNullParameter(targetView, "view");
        int[] iArr = {(targetView.getWidth() / 2) + i, (targetView.getHeight() / 2) + i};
        Intrinsics3.checkNotNullParameter(iArr, "outLocation");
        targetView.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[0];
        int[] iArr2 = this.screenOffset;
        Point point = new Point((i3 - iArr2[0]) - (getWidth() / 2), (iArr[1] - iArr2[1]) - (getHeight() / 2));
        setAnchorAt(point);
        c(this, point.x, point.y, null, 4, null);
        String simpleName = getClass().getSimpleName();
        StringBuilder sbU = outline.U("Anchored[");
        sbU.append(this.actualPosition);
        sbU.append("] -> ");
        sbU.append(targetView);
        Log.d(simpleName, sbU.toString());
    }

    public final void d() {
        getLocationOnScreen(this.screenOffset);
        int[] iArr = this.screenOffset;
        int i = iArr[0];
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        iArr[0] = i - layoutParams.x;
        iArr[1] = iArr[1] - layoutParams.y;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics3.checkNotNullParameter(motionEvent, "motionEvent");
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (f()) {
                        this.actualPosition.x = ((int) motionEvent.getRawX()) - this.deltaX;
                        this.actualPosition.y = ((int) motionEvent.getRawY()) - this.deltaY;
                        if (ViewCompat.isAttachedToWindow(this) && this.anchorPosition == null) {
                            WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
                            Point point = this.actualPosition;
                            layoutParams.x = point.x;
                            layoutParams.y = point.y;
                            this.windowManager.updateViewLayout(this, layoutParams);
                        }
                    } else {
                        if (Math.abs((this.deltaX + this.windowLayoutParams.x) - ((int) motionEvent.getRawX())) > this.moveThresholdPx) {
                            setMoving(true);
                        }
                    }
                }
            } else if (f()) {
                setMoving(false);
            }
        } else {
            this.deltaX = ((int) motionEvent.getRawX()) - this.windowLayoutParams.x;
            this.deltaY = ((int) motionEvent.getRawY()) - this.windowLayoutParams.y;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final Rect e(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Rect screenSize = DisplayUtils.getScreenSize(context);
        int i = screenSize.left;
        Rect rect = this.insetMargins;
        screenSize.left = i + rect.left;
        screenSize.right -= rect.right;
        screenSize.top += rect.top;
        screenSize.bottom -= rect.bottom;
        return screenSize;
    }

    public boolean f() {
        return ((Boolean) this.isMoving.getValue(this, j[0])).booleanValue();
    }

    public final int getCenterX() {
        return (getWidth() / 2) + this.windowLayoutParams.x;
    }

    public final int getCenterY() {
        return (getHeight() / 2) + this.windowLayoutParams.y;
    }

    public final Rect getInsetMargins() {
        return this.insetMargins;
    }

    public final int getMoveThresholdPx() {
        return this.moveThresholdPx;
    }

    public final Function1<Boolean, Unit> getOnMovingStateChanged() {
        return this.onMovingStateChanged;
    }

    public final int[] getScreenOffset() {
        return this.screenOffset;
    }

    public final SpringAnimation getSpringAnimationX() {
        return this.springAnimationX;
    }

    public final SpringAnimation getSpringAnimationY() {
        return this.springAnimationY;
    }

    public final WindowManager.LayoutParams getWindowLayoutParams() {
        return this.windowLayoutParams;
    }

    public final WindowManager getWindowManager() {
        return this.windowManager;
    }

    @Override // android.view.View
    public float getX() {
        return this.windowLayoutParams.x;
    }

    @Override // android.view.View
    public float getY() {
        return this.windowLayoutParams.y;
    }

    @Override // android.view.View
    @CallSuper
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.windowManager.updateViewLayout(this, this.windowLayoutParams);
        if (!ViewCompat.isLaidOut(this) || isLayoutRequested()) {
            addOnLayoutChangeListener(new b());
        } else {
            d();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Intrinsics3.checkNotNullParameter(motionEvent, "motionEvent");
        return motionEvent.getAction() != 2 ? super.onInterceptTouchEvent(motionEvent) : f();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            d();
        }
    }

    public final void setAnchorAt(Point newAnchorPoint) {
        Intrinsics3.checkNotNullParameter(newAnchorPoint, "newAnchorPoint");
        this.actualPosition.x = (int) getX();
        this.actualPosition.y = (int) getY();
        this.anchorPosition = newAnchorPoint;
        String simpleName = getClass().getSimpleName();
        StringBuilder sbU = outline.U("Anchoring[");
        sbU.append(this.actualPosition);
        sbU.append("] -> ");
        sbU.append(this.anchorPosition);
        Log.d(simpleName, sbU.toString());
    }

    public final void setBubbleTouchable(boolean isTouchable) {
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        Intrinsics3.checkNotNullParameter(layoutParams, "$this$setFlagTouchable");
        if (isTouchable) {
            Intrinsics3.checkNotNullParameter(layoutParams, "$this$removeFlag");
            layoutParams.flags &= -17;
        } else {
            Intrinsics3.checkNotNullParameter(layoutParams, "$this$addFlag");
            layoutParams.flags = 16 | layoutParams.flags;
        }
        this.windowManager.updateViewLayout(this, this.windowLayoutParams);
    }

    public void setMoving(boolean z2) {
        this.isMoving.setValue(this, j[0], Boolean.valueOf(z2));
    }

    public final void setOnMovingStateChanged(Function1<? super Boolean, Unit> function1) {
        this.onMovingStateChanged = function1;
    }

    public final void setWindowLayoutParams(WindowManager.LayoutParams layoutParams) {
        Intrinsics3.checkNotNullParameter(layoutParams, "<set-?>");
        this.windowLayoutParams = layoutParams;
    }

    @Override // android.view.View
    public void setX(float x2) {
        this.windowLayoutParams.x = (int) x2;
        if (ViewCompat.isAttachedToWindow(this)) {
            this.windowManager.updateViewLayout(this, this.windowLayoutParams);
        }
    }

    @Override // android.view.View
    public void setY(float y2) {
        this.windowLayoutParams.y = (int) y2;
        if (ViewCompat.isAttachedToWindow(this)) {
            this.windowManager.updateViewLayout(this, this.windowLayoutParams);
        }
    }
}
