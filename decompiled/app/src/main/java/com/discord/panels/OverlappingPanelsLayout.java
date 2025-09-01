package com.discord.panels;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import b.a.o.LocaleProvider;
import com.discord.panels.PanelState;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PrimitiveCompanionObjects2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OverlappingPanelsLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 \u0098\u00012\u00020\u0001:\n\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001\u009c\u0001B\u0015\b\u0016\u0012\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001B!\b\u0016\u0012\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\b\u0093\u0001\u0010\u0095\u0001B,\b\u0016\u0012\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010\u0096\u0001\u001a\u00020A¢\u0006\u0006\b\u0093\u0001\u0010\u0097\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001f\u0010\u0017J\u0017\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\u00020 2\u0006\u0010(\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020 2\u0006\u0010+\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b,\u0010*J+\u00100\u001a\u00020\u00042\u0006\u0010-\u001a\u00020 2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00042\u0006\u0010-\u001a\u00020 H\u0002¢\u0006\u0004\b2\u00103J\u001f\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020 2\u0006\u0010-\u001a\u00020 H\u0002¢\u0006\u0004\b5\u00106J\u001f\u00108\u001a\u0002072\u0006\u00104\u001a\u00020 2\u0006\u0010-\u001a\u00020 H\u0002¢\u0006\u0004\b8\u00109J\u001f\u0010:\u001a\u0002072\u0006\u00104\u001a\u00020 2\u0006\u0010-\u001a\u00020 H\u0002¢\u0006\u0004\b:\u00109J\u000f\u0010;\u001a\u00020\u0004H\u0002¢\u0006\u0004\b;\u0010\bJ\u0017\u0010<\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b<\u0010%J\u0017\u0010=\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b=\u0010%J\u000f\u0010>\u001a\u00020\u0004H\u0002¢\u0006\u0004\b>\u0010\bJ\u000f\u0010?\u001a\u00020\u0004H\u0002¢\u0006\u0004\b?\u0010\bJ7\u0010F\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020A2\u0006\u0010E\u001a\u00020AH\u0014¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\bH\u0010%J\u0017\u0010I\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\bI\u0010%J\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\bJ\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\bJ\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\bJ\u0015\u0010K\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u001b¢\u0006\u0004\bK\u0010LJ\u0015\u0010M\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u001b¢\u0006\u0004\bM\u0010LJ\u0015\u0010O\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u000e¢\u0006\u0004\bO\u0010\u0011J\u001b\u0010S\u001a\u00020\u00042\f\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0P¢\u0006\u0004\bS\u0010TJ!\u0010X\u001a\u00020\u00042\u0012\u0010W\u001a\n\u0012\u0006\b\u0001\u0012\u00020V0U\"\u00020V¢\u0006\u0004\bX\u0010YJ!\u0010Z\u001a\u00020\u00042\u0012\u0010W\u001a\n\u0012\u0006\b\u0001\u0012\u00020V0U\"\u00020V¢\u0006\u0004\bZ\u0010YJ\r\u0010[\u001a\u00020\n¢\u0006\u0004\b[\u0010\u0019J\u0015\u0010]\u001a\u00020\u00042\u0006\u0010\\\u001a\u000207¢\u0006\u0004\b]\u0010^J\u0015\u0010`\u001a\u00020\u00042\u0006\u0010_\u001a\u000207¢\u0006\u0004\b`\u0010^R\u0016\u0010a\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010bR\u0016\u0010d\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010bR\u0016\u0010e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR&\u0010i\u001a\u0012\u0012\u0004\u0012\u00020V0gj\b\u0012\u0004\u0012\u00020V`h8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010kR\u0016\u0010m\u001a\u00020l8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010o\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010q\u001a\u00020l8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bq\u0010nR\u0016\u0010r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010t\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010bR\u0016\u0010u\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010pR\u0016\u0010v\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010bR\u0016\u0010w\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010fR\u0016\u0010_\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010xR\u0016\u0010\\\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010xR\u0016\u0010y\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010pR\u0018\u0010{\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u001e\u0010~\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0080\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010pR\u0018\u0010\u0081\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010pR\u0018\u0010\u0082\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010bR\u0019\u0010\u0083\u0001\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0085\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010pR\u0018\u0010\u0086\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010bR\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\u008a\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010bR(\u0010\u008b\u0001\u001a\u0012\u0012\u0004\u0012\u00020V0gj\b\u0012\u0004\u0012\u00020V`h8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010jR\u0018\u0010\u008c\u0001\u001a\u00020l8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010nR\u001c\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0018\u0010\u0090\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010b¨\u0006\u009d\u0001"}, d2 = {"Lcom/discord/panels/OverlappingPanelsLayout;", "Landroid/widget/FrameLayout;", "Landroid/util/AttributeSet;", "attrs", "", "initialize", "(Landroid/util/AttributeSet;)V", "resetStartPanelWidth", "()V", "resetEndPanelWidth", "Lcom/discord/panels/OverlappingPanelsLayout$Panel;", "panel", "openPanel", "(Lcom/discord/panels/OverlappingPanelsLayout$Panel;)V", "", "isFling", "openStartPanel", "(Z)V", "openEndPanel", "closePanels", "Landroid/view/MotionEvent;", "event", "snapOpenOrClose", "(Landroid/view/MotionEvent;)V", "getLeftPanel", "()Lcom/discord/panels/OverlappingPanelsLayout$Panel;", "getRightPanel", "Lcom/discord/panels/OverlappingPanelsLayout$LockState;", "getLeftPanelLockState", "()Lcom/discord/panels/OverlappingPanelsLayout$LockState;", "getRightPanelLockState", "translateCenterPanel", "", "targetedX", "getNormalizedX", "(F)F", "shouldHandleActionMoveEvent", "(Landroid/view/MotionEvent;)Z", "getTargetedX", "(Landroid/view/MotionEvent;)F", "startX", "calculateDistanceX", "(FLandroid/view/MotionEvent;)F", "startY", "calculateDistanceY", "x", "", "animationDurationMs", "updateCenterPanelXWithAnimation", "(FZJ)V", "updateCenterPanelX", "(F)V", "previousX", "handleCenterPanelX", "(FF)V", "Lcom/discord/panels/PanelState;", "getStartPanelState", "(FF)Lcom/discord/panels/PanelState;", "getEndPanelState", "initPanels", "isTouchingCenterPanelWhileSidePanelOpen", "isTouchingChildGestureRegion", "handleStartPanelWidthUpdate", "handleEndPanelWidthUpdate", "changed", "", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "onInterceptTouchEvent", "onTouchEvent", "lockState", "setStartPanelLockState", "(Lcom/discord/panels/OverlappingPanelsLayout$LockState;)V", "setEndPanelLockState", "useFullPortraitWidth", "setStartPanelUseFullPortraitWidth", "", "Landroid/graphics/Rect;", "childGestureRegions", "setChildGestureRegions", "(Ljava/util/List;)V", "", "Lcom/discord/panels/OverlappingPanelsLayout$PanelStateListener;", "panelStateListenerArgs", "registerStartPanelStateListeners", "([Lcom/discord/panels/OverlappingPanelsLayout$PanelStateListener;)V", "registerEndPanelStateListeners", "getSelectedPanel", "startPanelState", "handleStartPanelState", "(Lcom/discord/panels/PanelState;)V", "endPanelState", "handleEndPanelState", "homeGestureFromBottomThreshold", "F", "endPanelOpenedCenterPanelX", "startPanelOpenedCenterPanelX", "endPanelLockState", "Lcom/discord/panels/OverlappingPanelsLayout$LockState;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "endPanelStateListeners", "Ljava/util/ArrayList;", "Ljava/util/List;", "Landroid/view/View;", "endPanel", "Landroid/view/View;", "isSystemGestureNavigationPossible", "Z", "centerPanel", "selectedPanel", "Lcom/discord/panels/OverlappingPanelsLayout$Panel;", "scrollingSlopPx", "useFullWidthForStartPanel", "centerPanelAnimationEndX", "startPanelLockState", "Lcom/discord/panels/PanelState;", "wasActionDownOnClosedCenterPanel", "Lcom/discord/panels/OverlappingPanelsLayout$SwipeDirection;", "swipeDirection", "Lcom/discord/panels/OverlappingPanelsLayout$SwipeDirection;", "Lkotlin/Function0;", "pendingUpdate", "Lkotlin/jvm/functions/Function0;", "isLeftToRight", "isHomeSystemGesture", "minFlingPxPerSecond", "nonFullScreenSidePanelWidth", "I", "isScrollingHorizontally", "centerPanelDiffX", "Landroid/view/VelocityTracker;", "velocityTracker", "Landroid/view/VelocityTracker;", "yFromInterceptActionDown", "startPanelStateListeners", "startPanel", "Landroid/animation/ValueAnimator;", "centerPanelXAnimator", "Landroid/animation/ValueAnimator;", "xFromInterceptActionDown", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "LockState", "Panel", "PanelStateListener", "SwipeDirection", "overlapping_panels_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public class OverlappingPanelsLayout extends FrameLayout {
    private static final long SIDE_PANEL_CLOSE_DURATION_MS = 200;
    private static final long SIDE_PANEL_OPEN_DURATION_MS = 250;
    private HashMap _$_findViewCache;
    private View centerPanel;
    private float centerPanelAnimationEndX;
    private float centerPanelDiffX;
    private ValueAnimator centerPanelXAnimator;
    private List<Rect> childGestureRegions;
    private View endPanel;
    private LockState endPanelLockState;
    private float endPanelOpenedCenterPanelX;
    private PanelState endPanelState;
    private final ArrayList<PanelStateListener> endPanelStateListeners;
    private float homeGestureFromBottomThreshold;
    private boolean isHomeSystemGesture;
    private boolean isLeftToRight;
    private boolean isScrollingHorizontally;
    private final boolean isSystemGestureNavigationPossible;
    private float minFlingPxPerSecond;
    private int nonFullScreenSidePanelWidth;
    private Function0<Unit> pendingUpdate;
    private float scrollingSlopPx;
    private Panel selectedPanel;
    private View startPanel;
    private LockState startPanelLockState;
    private float startPanelOpenedCenterPanelX;
    private PanelState startPanelState;
    private final ArrayList<PanelStateListener> startPanelStateListeners;
    private SwipeDirection swipeDirection;
    private boolean useFullWidthForStartPanel;
    private VelocityTracker velocityTracker;
    private boolean wasActionDownOnClosedCenterPanel;
    private float xFromInterceptActionDown;
    private float yFromInterceptActionDown;

    /* compiled from: OverlappingPanelsLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/panels/OverlappingPanelsLayout$LockState;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "CLOSE", "UNLOCKED", "overlapping_panels_release"}, k = 1, mv = {1, 4, 0})
    public enum LockState {
        OPEN,
        CLOSE,
        UNLOCKED
    }

    /* compiled from: OverlappingPanelsLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/panels/OverlappingPanelsLayout$Panel;", "", "<init>", "(Ljava/lang/String;I)V", "START", "CENTER", "END", "overlapping_panels_release"}, k = 1, mv = {1, 4, 0})
    public enum Panel {
        START,
        CENTER,
        END
    }

    /* compiled from: OverlappingPanelsLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/panels/OverlappingPanelsLayout$PanelStateListener;", "", "Lcom/discord/panels/PanelState;", "panelState", "", "onPanelStateChange", "(Lcom/discord/panels/PanelState;)V", "overlapping_panels_release"}, k = 1, mv = {1, 4, 0})
    public interface PanelStateListener {
        void onPanelStateChange(PanelState panelState);
    }

    /* compiled from: OverlappingPanelsLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/panels/OverlappingPanelsLayout$SwipeDirection;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "overlapping_panels_release"}, k = 1, mv = {1, 4, 0})
    public enum SwipeDirection {
        LEFT,
        RIGHT
    }

    /* compiled from: java-style lambda group */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f2757b;

        public a(int i, Object obj) {
            this.a = i;
            this.f2757b = obj;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i = this.a;
            if (i == 0) {
                OverlappingPanelsLayout overlappingPanelsLayout = (OverlappingPanelsLayout) this.f2757b;
                Intrinsics3.checkExpressionValueIsNotNull(valueAnimator, "animator");
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
                }
                OverlappingPanelsLayout.access$updateCenterPanelX(overlappingPanelsLayout, ((Float) animatedValue).floatValue());
                return;
            }
            if (i != 1) {
                throw null;
            }
            OverlappingPanelsLayout overlappingPanelsLayout2 = (OverlappingPanelsLayout) this.f2757b;
            Intrinsics3.checkExpressionValueIsNotNull(valueAnimator, "animator");
            Object animatedValue2 = valueAnimator.getAnimatedValue();
            if (animatedValue2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
            }
            OverlappingPanelsLayout.access$updateCenterPanelX(overlappingPanelsLayout2, ((Float) animatedValue2).floatValue());
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public b(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws Resources.NotFoundException {
            int i9 = this.j;
            if (i9 == 0) {
                if (OverlappingPanelsLayout.access$isLeftToRight$p((OverlappingPanelsLayout) this.k) && i3 != i7) {
                    OverlappingPanelsLayout.access$handleStartPanelWidthUpdate((OverlappingPanelsLayout) this.k);
                    return;
                } else {
                    if (OverlappingPanelsLayout.access$isLeftToRight$p((OverlappingPanelsLayout) this.k) || i == i5) {
                        return;
                    }
                    OverlappingPanelsLayout.access$handleStartPanelWidthUpdate((OverlappingPanelsLayout) this.k);
                    return;
                }
            }
            if (i9 != 1) {
                throw null;
            }
            if (OverlappingPanelsLayout.access$isLeftToRight$p((OverlappingPanelsLayout) this.k) && i != i5) {
                OverlappingPanelsLayout.access$handleEndPanelWidthUpdate((OverlappingPanelsLayout) this.k);
            } else {
                if (OverlappingPanelsLayout.access$isLeftToRight$p((OverlappingPanelsLayout) this.k) || i3 == i7) {
                    return;
                }
                OverlappingPanelsLayout.access$handleEndPanelWidthUpdate((OverlappingPanelsLayout) this.k);
            }
        }
    }

    /* compiled from: OverlappingPanelsLayout.kt */
    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $isFling;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z2) {
            super(0);
            this.$isFling = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            OverlappingPanelsLayout.access$closePanels(OverlappingPanelsLayout.this, this.$isFling);
            return Unit.a;
        }
    }

    /* compiled from: OverlappingPanelsLayout.kt */
    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $isFling;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(boolean z2) {
            super(0);
            this.$isFling = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            OverlappingPanelsLayout.access$openEndPanel(OverlappingPanelsLayout.this, this.$isFling);
            return Unit.a;
        }
    }

    /* compiled from: OverlappingPanelsLayout.kt */
    public static final class e extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $isFling;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(boolean z2) {
            super(0);
            this.$isFling = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            OverlappingPanelsLayout.access$openStartPanel(OverlappingPanelsLayout.this, this.$isFling);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlappingPanelsLayout(Context context) {
        super(context);
        Intrinsics3.checkParameterIsNotNull(context, "context");
        this.isLeftToRight = true;
        PrimitiveCompanionObjects2 primitiveCompanionObjects2 = PrimitiveCompanionObjects2.a;
        this.startPanelOpenedCenterPanelX = primitiveCompanionObjects2.getMIN_VALUE();
        this.endPanelOpenedCenterPanelX = primitiveCompanionObjects2.getMAX_VALUE();
        this.startPanelStateListeners = new ArrayList<>();
        this.endPanelStateListeners = new ArrayList<>();
        this.selectedPanel = Panel.CENTER;
        LockState lockState = LockState.UNLOCKED;
        this.startPanelLockState = lockState;
        this.endPanelLockState = lockState;
        PanelState.a aVar = PanelState.a.a;
        this.startPanelState = aVar;
        this.endPanelState = aVar;
        this.childGestureRegions = Collections2.emptyList();
        this.isSystemGestureNavigationPossible = Build.VERSION.SDK_INT >= 29;
    }

    public static final /* synthetic */ void access$closePanels(OverlappingPanelsLayout overlappingPanelsLayout, boolean z2) {
        overlappingPanelsLayout.closePanels(z2);
    }

    public static final /* synthetic */ View access$getCenterPanel$p(OverlappingPanelsLayout overlappingPanelsLayout) {
        View view = overlappingPanelsLayout.centerPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        return view;
    }

    public static final /* synthetic */ View access$getStartPanel$p(OverlappingPanelsLayout overlappingPanelsLayout) {
        View view = overlappingPanelsLayout.startPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
        }
        return view;
    }

    public static final /* synthetic */ void access$handleEndPanelWidthUpdate(OverlappingPanelsLayout overlappingPanelsLayout) throws Resources.NotFoundException {
        overlappingPanelsLayout.handleEndPanelWidthUpdate();
    }

    public static final /* synthetic */ void access$handleStartPanelWidthUpdate(OverlappingPanelsLayout overlappingPanelsLayout) throws Resources.NotFoundException {
        overlappingPanelsLayout.handleStartPanelWidthUpdate();
    }

    public static final /* synthetic */ boolean access$isLeftToRight$p(OverlappingPanelsLayout overlappingPanelsLayout) {
        return overlappingPanelsLayout.isLeftToRight;
    }

    public static final /* synthetic */ void access$openEndPanel(OverlappingPanelsLayout overlappingPanelsLayout, boolean z2) {
        overlappingPanelsLayout.openEndPanel(z2);
    }

    public static final /* synthetic */ void access$openStartPanel(OverlappingPanelsLayout overlappingPanelsLayout, boolean z2) {
        overlappingPanelsLayout.openStartPanel(z2);
    }

    public static final /* synthetic */ void access$setCenterPanel$p(OverlappingPanelsLayout overlappingPanelsLayout, View view) {
        overlappingPanelsLayout.centerPanel = view;
    }

    public static final /* synthetic */ void access$setLeftToRight$p(OverlappingPanelsLayout overlappingPanelsLayout, boolean z2) {
        overlappingPanelsLayout.isLeftToRight = z2;
    }

    public static final /* synthetic */ void access$setStartPanel$p(OverlappingPanelsLayout overlappingPanelsLayout, View view) {
        overlappingPanelsLayout.startPanel = view;
    }

    public static final /* synthetic */ void access$updateCenterPanelX(OverlappingPanelsLayout overlappingPanelsLayout, float f) {
        overlappingPanelsLayout.updateCenterPanelX(f);
    }

    private final float calculateDistanceX(float startX, MotionEvent event) {
        return event.getX() - startX;
    }

    private final float calculateDistanceY(float startY, MotionEvent event) {
        return event.getY() - startY;
    }

    public static /* synthetic */ void closePanels$default(OverlappingPanelsLayout overlappingPanelsLayout, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closePanels");
        }
        if ((i & 1) != 0) {
            z2 = false;
        }
        overlappingPanelsLayout.closePanels(z2);
    }

    private final PanelState getEndPanelState(float previousX, float x2) {
        boolean z2 = this.isLeftToRight;
        return (!z2 || x2 < 0.0f) ? (z2 || x2 > 0.0f) ? x2 == this.endPanelOpenedCenterPanelX ? PanelState.c.a : (!z2 || x2 >= previousX) ? (z2 || x2 <= previousX) ? PanelState.b.a : PanelState.d.a : PanelState.d.a : PanelState.a.a : PanelState.a.a;
    }

    private final Panel getLeftPanel() {
        return this.isLeftToRight ? Panel.START : Panel.END;
    }

    private final LockState getLeftPanelLockState() {
        return this.isLeftToRight ? this.startPanelLockState : this.endPanelLockState;
    }

    private final float getNormalizedX(float targetedX) {
        LockState lockState = this.startPanelLockState;
        LockState lockState2 = LockState.OPEN;
        if (lockState == lockState2) {
            return this.startPanelOpenedCenterPanelX;
        }
        if (this.endPanelLockState == lockState2) {
            return this.endPanelOpenedCenterPanelX;
        }
        LockState leftPanelLockState = getLeftPanelLockState();
        LockState lockState3 = LockState.CLOSE;
        float fMin = 0.0f;
        float fMax = (leftPanelLockState == lockState3 || (this.selectedPanel == Panel.CENTER && this.swipeDirection == SwipeDirection.LEFT)) ? 0.0f : Math.max(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        if (getRightPanelLockState() != lockState3 && (this.selectedPanel != Panel.CENTER || this.swipeDirection != SwipeDirection.RIGHT)) {
            fMin = Math.min(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        }
        return targetedX > fMax ? fMax : targetedX < fMin ? fMin : targetedX;
    }

    private final Panel getRightPanel() {
        return this.isLeftToRight ? Panel.END : Panel.START;
    }

    private final LockState getRightPanelLockState() {
        return this.isLeftToRight ? this.endPanelLockState : this.startPanelLockState;
    }

    private final PanelState getStartPanelState(float previousX, float x2) {
        boolean z2 = this.isLeftToRight;
        return (!z2 || x2 > 0.0f) ? (z2 || x2 < 0.0f) ? x2 == this.startPanelOpenedCenterPanelX ? PanelState.c.a : (!z2 || x2 <= previousX) ? (z2 || x2 >= previousX) ? PanelState.b.a : PanelState.d.a : PanelState.d.a : PanelState.a.a : PanelState.a.a;
    }

    private final float getTargetedX(MotionEvent event) {
        return event.getRawX() + this.centerPanelDiffX;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleCenterPanelX(float previousX, float x2) {
        int i;
        int i2;
        View view = this.startPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
        }
        if (this.isLeftToRight) {
            View view2 = this.centerPanel;
            if (view2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
            }
            if (view2.getX() <= 0) {
            }
        } else {
            if (!this.isLeftToRight) {
                View view3 = this.centerPanel;
                if (view3 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
                }
                i = view3.getX() < ((float) 0) ? 0 : 4;
            }
        }
        view.setVisibility(i);
        View view4 = this.endPanel;
        if (view4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("endPanel");
        }
        if (this.isLeftToRight) {
            View view5 = this.centerPanel;
            if (view5 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
            }
            if (view5.getX() >= 0) {
            }
        } else {
            if (!this.isLeftToRight) {
                View view6 = this.centerPanel;
                if (view6 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
                }
                i2 = view6.getX() > ((float) 0) ? 0 : 4;
            }
        }
        view4.setVisibility(i2);
        if (x2 == 0.0f) {
            this.selectedPanel = Panel.CENTER;
        } else if (x2 == this.startPanelOpenedCenterPanelX) {
            this.selectedPanel = Panel.START;
        } else if (x2 == this.endPanelOpenedCenterPanelX) {
            this.selectedPanel = Panel.END;
        }
        boolean z2 = x2 == this.endPanelOpenedCenterPanelX || x2 == this.startPanelOpenedCenterPanelX;
        View view7 = this.centerPanel;
        if (view7 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        boolean z3 = !z2;
        Intrinsics3.checkParameterIsNotNull(view7, "$this$setEnabledAlpha");
        view7.setAlpha(z3 ? 1.0f : 0.5f);
        View view8 = this.centerPanel;
        if (view8 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        view8.setImportantForAccessibility(z2 ? 4 : 0);
        boolean z4 = x2 == 0.0f || z2;
        View view9 = this.centerPanel;
        if (view9 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        view9.setElevation(z4 ? 0.0f : getResources().getDimension(R.a.overlapping_panels_center_panel_non_resting_elevation));
        this.startPanelState = getStartPanelState(previousX, x2);
        Iterator<PanelStateListener> it = this.startPanelStateListeners.iterator();
        while (it.hasNext()) {
            it.next().onPanelStateChange(this.startPanelState);
        }
        this.endPanelState = getEndPanelState(previousX, x2);
        Iterator<PanelStateListener> it2 = this.endPanelStateListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onPanelStateChange(this.endPanelState);
        }
    }

    private final void handleEndPanelWidthUpdate() throws Resources.NotFoundException {
        float f = this.endPanelOpenedCenterPanelX;
        float dimension = getResources().getDimension(R.a.overlapping_panels_margin_between_panels);
        if (this.endPanel == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("endPanel");
        }
        float f2 = -(r2.getWidth() + dimension);
        this.endPanelOpenedCenterPanelX = f2;
        if (!this.isLeftToRight) {
            f2 = -f2;
        }
        this.endPanelOpenedCenterPanelX = f2;
        View view = this.centerPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        if (view.getX() == f || this.centerPanelAnimationEndX == f) {
            openEndPanel();
        }
    }

    private final void handleStartPanelWidthUpdate() throws Resources.NotFoundException {
        float f = this.startPanelOpenedCenterPanelX;
        float dimension = getResources().getDimension(R.a.overlapping_panels_margin_between_panels);
        if (this.startPanel == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
        }
        float width = r2.getWidth() + dimension;
        this.startPanelOpenedCenterPanelX = width;
        if (!this.isLeftToRight) {
            width = -width;
        }
        this.startPanelOpenedCenterPanelX = width;
        View view = this.centerPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        if (view.getX() == f || this.centerPanelAnimationEndX == f) {
            openStartPanel();
        }
    }

    private final void initPanels() throws Resources.NotFoundException {
        View childAt = getChildAt(0);
        Intrinsics3.checkExpressionValueIsNotNull(childAt, "getChildAt(0)");
        this.startPanel = childAt;
        View childAt2 = getChildAt(1);
        Intrinsics3.checkExpressionValueIsNotNull(childAt2, "getChildAt(1)");
        this.centerPanel = childAt2;
        View childAt3 = getChildAt(2);
        Intrinsics3.checkExpressionValueIsNotNull(childAt3, "getChildAt(2)");
        this.endPanel = childAt3;
        View view = this.startPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
        }
        view.setVisibility(4);
        View view2 = this.startPanel;
        if (view2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
        }
        view2.setElevation(0.0f);
        View view3 = this.centerPanel;
        if (view3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        view3.setVisibility(0);
        View view4 = this.centerPanel;
        if (view4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        view4.setElevation(0.0f);
        View view5 = this.endPanel;
        if (view5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("endPanel");
        }
        view5.setVisibility(4);
        View view6 = this.endPanel;
        if (view6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("endPanel");
        }
        view6.setElevation(0.0f);
        resetStartPanelWidth();
        resetEndPanelWidth();
        handleStartPanelWidthUpdate();
        handleEndPanelWidthUpdate();
        Function0<Unit> function0 = this.pendingUpdate;
        if (function0 != null) {
            function0.invoke();
        }
        this.pendingUpdate = null;
        View view7 = this.startPanel;
        if (view7 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
        }
        view7.addOnLayoutChangeListener(new b(0, this));
        View view8 = this.endPanel;
        if (view8 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("endPanel");
        }
        view8.addOnLayoutChangeListener(new b(1, this));
    }

    private final void initialize(AttributeSet attrs) {
        int i;
        LocaleProvider localeProvider = LocaleProvider.f251b;
        Context context = getContext();
        Intrinsics3.checkExpressionValueIsNotNull(context, "context");
        Intrinsics3.checkParameterIsNotNull(context, "context");
        this.isLeftToRight = TextUtils.getLayoutDirectionFromLocale(LocaleProvider.a.invoke(context)) == 0;
        this.scrollingSlopPx = getResources().getDimension(R.a.overlapping_panels_scroll_slop);
        this.homeGestureFromBottomThreshold = getResources().getDimension(R.a.overlapping_panels_home_gesture_from_bottom_threshold);
        this.minFlingPxPerSecond = getResources().getDimension(R.a.overlapping_panels_min_fling_dp_per_second);
        Resources resources = getResources();
        Intrinsics3.checkExpressionValueIsNotNull(resources, "resources");
        if (resources.getConfiguration().orientation == 1) {
            Resources resources2 = getResources();
            Intrinsics3.checkExpressionValueIsNotNull(resources2, "resources");
            i = resources2.getDisplayMetrics().widthPixels;
        } else {
            Resources resources3 = getResources();
            Intrinsics3.checkExpressionValueIsNotNull(resources3, "resources");
            i = resources3.getDisplayMetrics().heightPixels;
        }
        this.nonFullScreenSidePanelWidth = (int) ((i - getResources().getDimension(R.a.overlapping_panels_margin_between_panels)) - getResources().getDimension(R.a.overlapping_panels_closed_center_panel_visible_width));
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.b.OverlappingPanelsLayout, 0, 0);
        try {
            this.nonFullScreenSidePanelWidth = Math.min(this.nonFullScreenSidePanelWidth, (int) typedArrayObtainStyledAttributes.getDimension(R.b.OverlappingPanelsLayout_maxSidePanelNonFullScreenWidth, Integer.MAX_VALUE));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final boolean isTouchingCenterPanelWhileSidePanelOpen(MotionEvent event) {
        float x2 = event.getX();
        View view = this.centerPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        float x3 = view.getX();
        float fMax = Math.max(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        float fMin = Math.min(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        if (this.centerPanel == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        float width = r4.getWidth() + fMin;
        boolean z2 = x2 > fMax;
        boolean z3 = x2 < width;
        boolean z4 = x3 == fMax;
        boolean z5 = x3 == fMin;
        if (z4 && z2) {
            return true;
        }
        return z5 && z3;
    }

    private final boolean isTouchingChildGestureRegion(MotionEvent event) {
        boolean z2;
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        Iterator<T> it = this.childGestureRegions.iterator();
        do {
            z2 = false;
            if (!it.hasNext()) {
                return false;
            }
            Rect rect = (Rect) it.next();
            boolean z3 = rawX >= ((float) rect.left) && rawX <= ((float) rect.right);
            boolean z4 = rawY <= ((float) rect.bottom) && rawY >= ((float) rect.top);
            if (z3 && z4) {
                z2 = true;
            }
        } while (!z2);
        return true;
    }

    public static /* synthetic */ void openEndPanel$default(OverlappingPanelsLayout overlappingPanelsLayout, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openEndPanel");
        }
        if ((i & 1) != 0) {
            z2 = false;
        }
        overlappingPanelsLayout.openEndPanel(z2);
    }

    private final void openPanel(Panel panel) {
        int iOrdinal = panel.ordinal();
        if (iOrdinal == 0) {
            openStartPanel(false);
        } else if (iOrdinal == 1) {
            closePanels(false);
        } else {
            if (iOrdinal != 2) {
                return;
            }
            openEndPanel(false);
        }
    }

    public static /* synthetic */ void openStartPanel$default(OverlappingPanelsLayout overlappingPanelsLayout, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openStartPanel");
        }
        if ((i & 1) != 0) {
            z2 = false;
        }
        overlappingPanelsLayout.openStartPanel(z2);
    }

    private final void resetEndPanelWidth() {
        View view = this.endPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("endPanel");
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = this.nonFullScreenSidePanelWidth;
        View view2 = this.endPanel;
        if (view2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("endPanel");
        }
        view2.setLayoutParams(layoutParams);
    }

    private final void resetStartPanelWidth() {
        View view = this.startPanel;
        if (view != null) {
            if (view == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = this.useFullWidthForStartPanel ? -1 : this.nonFullScreenSidePanelWidth;
            View view2 = this.startPanel;
            if (view2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
            }
            view2.setLayoutParams(layoutParams);
        }
    }

    private final boolean shouldHandleActionMoveEvent(MotionEvent event) {
        float normalizedX = getNormalizedX(getTargetedX(event));
        View view = this.centerPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        float fAbs = Math.abs(normalizedX - view.getX());
        Resources resources = getResources();
        Intrinsics3.checkExpressionValueIsNotNull(resources, "resources");
        return normalizedX == 0.0f || normalizedX == this.startPanelOpenedCenterPanelX || normalizedX == this.endPanelOpenedCenterPanelX || ((fAbs > resources.getDisplayMetrics().density ? 1 : (fAbs == resources.getDisplayMetrics().density ? 0 : -1)) > 0);
    }

    private final void snapOpenOrClose(MotionEvent event) {
        float targetedX = getTargetedX(event);
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(1000);
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        float xVelocity = velocityTracker2 != null ? velocityTracker2.getXVelocity() : PrimitiveCompanionObjects2.a.getMIN_VALUE();
        boolean z2 = false;
        boolean z3 = Math.abs(xVelocity) > this.minFlingPxPerSecond;
        if (!this.isLeftToRight ? xVelocity < 0 : xVelocity > 0) {
            z2 = true;
        }
        if (z3) {
            if (z2) {
                Panel panel = this.selectedPanel;
                if (panel == Panel.END) {
                    closePanels(true);
                    return;
                } else if (panel == Panel.CENTER) {
                    openStartPanel(true);
                    return;
                }
            } else {
                Panel panel2 = this.selectedPanel;
                if (panel2 == Panel.START) {
                    closePanels(true);
                    return;
                } else if (panel2 == Panel.CENTER) {
                    openEndPanel(true);
                    return;
                }
            }
        }
        float fMax = Math.max(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        float fMin = Math.min(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        float f = 2;
        if (targetedX > fMax / f) {
            openPanel(getLeftPanel());
        } else if (targetedX < fMin / f) {
            openPanel(getRightPanel());
        } else {
            closePanels();
        }
    }

    private final void translateCenterPanel(MotionEvent event) {
        updateCenterPanelX(getNormalizedX(getTargetedX(event)));
    }

    private final void updateCenterPanelX(float x2) {
        View view = this.centerPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        float x3 = view.getX();
        View view2 = this.centerPanel;
        if (view2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        view2.setX(x2);
        handleCenterPanelX(x3, x2);
    }

    private final void updateCenterPanelXWithAnimation(float x2, boolean isFling, long animationDurationMs) {
        View view = this.centerPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        float x3 = view.getX();
        ValueAnimator valueAnimator = this.centerPanelXAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float normalizedX = getNormalizedX(x2);
        this.centerPanelAnimationEndX = normalizedX;
        if (isFling) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(x3, normalizedX);
            valueAnimatorOfFloat.setInterpolator(new LinearOutSlowInInterpolator());
            valueAnimatorOfFloat.setDuration(animationDurationMs);
            this.centerPanelXAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new a(0, this));
        } else {
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(x3, normalizedX);
            valueAnimatorOfFloat2.setInterpolator(new FastOutSlowInInterpolator());
            valueAnimatorOfFloat2.setDuration(animationDurationMs);
            this.centerPanelXAnimator = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.addUpdateListener(new a(1, this));
        }
        ValueAnimator valueAnimator2 = this.centerPanelXAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.start();
        }
    }

    public static /* synthetic */ void updateCenterPanelXWithAnimation$default(OverlappingPanelsLayout overlappingPanelsLayout, float f, boolean z2, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCenterPanelXWithAnimation");
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            j = SIDE_PANEL_OPEN_DURATION_MS;
        }
        overlappingPanelsLayout.updateCenterPanelXWithAnimation(f, z2, j);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void closePanels() {
        closePanels(false);
    }

    public final Panel getSelectedPanel() {
        return this.selectedPanel;
    }

    public final void handleEndPanelState(PanelState endPanelState) {
        Intrinsics3.checkParameterIsNotNull(endPanelState, "endPanelState");
        PanelState panelState = this.endPanelState;
        PanelState.c cVar = PanelState.c.a;
        if (Intrinsics3.areEqual(endPanelState, cVar) && (!Intrinsics3.areEqual(panelState, cVar))) {
            openEndPanel();
        } else if ((endPanelState instanceof PanelState.a) && Intrinsics3.areEqual(panelState, cVar)) {
            closePanels();
        }
        this.endPanelState = endPanelState;
    }

    public final void handleStartPanelState(PanelState startPanelState) {
        Intrinsics3.checkParameterIsNotNull(startPanelState, "startPanelState");
        PanelState panelState = this.startPanelState;
        PanelState.c cVar = PanelState.c.a;
        if (Intrinsics3.areEqual(startPanelState, cVar) && (!Intrinsics3.areEqual(panelState, cVar))) {
            openStartPanel();
        } else if (Intrinsics3.areEqual(startPanelState, PanelState.a.a) && Intrinsics3.areEqual(panelState, cVar)) {
            closePanels();
        }
        this.startPanelState = startPanelState;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent event) {
        VelocityTracker velocityTracker;
        Intrinsics3.checkParameterIsNotNull(event, "event");
        int actionMasked = event.getActionMasked();
        boolean z2 = false;
        if (actionMasked == 0) {
            this.isScrollingHorizontally = false;
            this.wasActionDownOnClosedCenterPanel = isTouchingCenterPanelWhileSidePanelOpen(event);
            View view = this.centerPanel;
            if (view == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
            }
            this.centerPanelDiffX = view.getX() - event.getRawX();
            this.xFromInterceptActionDown = event.getX();
            float y2 = event.getY();
            this.yFromInterceptActionDown = y2;
            Intrinsics3.checkExpressionValueIsNotNull(getResources(), "resources");
            if (Math.abs(y2 - r3.getDisplayMetrics().heightPixels) < this.homeGestureFromBottomThreshold && this.isSystemGestureNavigationPossible) {
                z2 = true;
            }
            this.isHomeSystemGesture = z2;
            VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 == null) {
                VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                this.velocityTracker = velocityTrackerObtain;
                if (velocityTrackerObtain != null) {
                    velocityTrackerObtain.addMovement(event);
                }
            } else if (velocityTracker2 != null) {
                velocityTracker2.clear();
            }
            return this.wasActionDownOnClosedCenterPanel;
        }
        if (actionMasked == 1) {
            velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.velocityTracker = null;
            if (this.isScrollingHorizontally && !this.wasActionDownOnClosedCenterPanel) {
                return false;
            }
        } else if (actionMasked != 2) {
            if (actionMasked != 3) {
                return this.wasActionDownOnClosedCenterPanel;
            }
            velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
            }
            this.velocityTracker = null;
            if (this.isScrollingHorizontally) {
            }
        } else if (!this.isScrollingHorizontally) {
            float fCalculateDistanceX = calculateDistanceX(this.xFromInterceptActionDown, event);
            float fCalculateDistanceY = calculateDistanceY(this.yFromInterceptActionDown, event);
            boolean zIsTouchingChildGestureRegion = isTouchingChildGestureRegion(event);
            if (Math.abs(fCalculateDistanceX) <= this.scrollingSlopPx || Math.abs(fCalculateDistanceX) <= Math.abs(fCalculateDistanceY) || zIsTouchingChildGestureRegion) {
                return false;
            }
            this.isScrollingHorizontally = true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) throws Resources.NotFoundException {
        super.onLayout(changed, left, top, right, bottom);
        if (getChildCount() == 3 && this.centerPanel == null) {
            initPanels();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics3.checkParameterIsNotNull(event, "event");
        if (this.isHomeSystemGesture) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if ((this.wasActionDownOnClosedCenterPanel || Math.abs(event.getX() - this.xFromInterceptActionDown) >= this.scrollingSlopPx || this.isScrollingHorizontally) ? false : true) {
                    VelocityTracker velocityTracker = this.velocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(event);
                    }
                    snapOpenOrClose(event);
                } else {
                    closePanels();
                }
                this.wasActionDownOnClosedCenterPanel = false;
                this.isScrollingHorizontally = false;
                this.swipeDirection = null;
            } else if (actionMasked != 2) {
                if (actionMasked != 3) {
                    return false;
                }
                if (this.wasActionDownOnClosedCenterPanel) {
                    if ((this.wasActionDownOnClosedCenterPanel || Math.abs(event.getX() - this.xFromInterceptActionDown) >= this.scrollingSlopPx || this.isScrollingHorizontally) ? false : true) {
                    }
                    this.wasActionDownOnClosedCenterPanel = false;
                    this.isScrollingHorizontally = false;
                    this.swipeDirection = null;
                }
            } else {
                if (isTouchingChildGestureRegion(event)) {
                    return false;
                }
                float fCalculateDistanceX = calculateDistanceX(this.xFromInterceptActionDown, event);
                if (Math.abs(fCalculateDistanceX) > this.scrollingSlopPx && this.swipeDirection == null) {
                    this.swipeDirection = fCalculateDistanceX > ((float) 0) ? SwipeDirection.RIGHT : SwipeDirection.LEFT;
                }
                VelocityTracker velocityTracker2 = this.velocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(event);
                }
                if (shouldHandleActionMoveEvent(event)) {
                    translateCenterPanel(event);
                }
            }
        }
        return true;
    }

    public final void openEndPanel() {
        openEndPanel(false);
    }

    public final void openStartPanel() {
        openStartPanel(false);
    }

    public final void registerEndPanelStateListeners(PanelStateListener... panelStateListenerArgs) {
        Intrinsics3.checkParameterIsNotNull(panelStateListenerArgs, "panelStateListenerArgs");
        for (PanelStateListener panelStateListener : panelStateListenerArgs) {
            this.endPanelStateListeners.add(panelStateListener);
        }
    }

    public final void registerStartPanelStateListeners(PanelStateListener... panelStateListenerArgs) {
        Intrinsics3.checkParameterIsNotNull(panelStateListenerArgs, "panelStateListenerArgs");
        for (PanelStateListener panelStateListener : panelStateListenerArgs) {
            this.startPanelStateListeners.add(panelStateListener);
        }
    }

    public final void setChildGestureRegions(List<Rect> childGestureRegions) {
        Intrinsics3.checkParameterIsNotNull(childGestureRegions, "childGestureRegions");
        this.childGestureRegions = childGestureRegions;
    }

    public final void setEndPanelLockState(LockState lockState) {
        Intrinsics3.checkParameterIsNotNull(lockState, "lockState");
        this.endPanelLockState = lockState;
        if (lockState == LockState.OPEN) {
            openEndPanel();
        }
    }

    public final void setStartPanelLockState(LockState lockState) {
        Intrinsics3.checkParameterIsNotNull(lockState, "lockState");
        this.startPanelLockState = lockState;
        if (lockState == LockState.OPEN) {
            openStartPanel();
        }
    }

    public final void setStartPanelUseFullPortraitWidth(boolean useFullPortraitWidth) {
        this.useFullWidthForStartPanel = useFullPortraitWidth;
        resetStartPanelWidth();
    }

    private final void closePanels(boolean isFling) {
        if (this.centerPanel == null) {
            this.pendingUpdate = new c(isFling);
        } else {
            updateCenterPanelXWithAnimation(0.0f, isFling, SIDE_PANEL_CLOSE_DURATION_MS);
        }
    }

    private final void openEndPanel(boolean isFling) {
        if (this.centerPanel == null) {
            this.pendingUpdate = new d(isFling);
        } else {
            updateCenterPanelXWithAnimation(this.endPanelOpenedCenterPanelX, isFling, SIDE_PANEL_OPEN_DURATION_MS);
        }
    }

    private final void openStartPanel(boolean isFling) {
        if (this.centerPanel == null) {
            this.pendingUpdate = new e(isFling);
        } else if (this.startPanelLockState == LockState.OPEN) {
            updateCenterPanelX(this.startPanelOpenedCenterPanelX);
        } else {
            updateCenterPanelXWithAnimation(this.startPanelOpenedCenterPanelX, isFling, SIDE_PANEL_OPEN_DURATION_MS);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlappingPanelsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkParameterIsNotNull(context, "context");
        this.isLeftToRight = true;
        PrimitiveCompanionObjects2 primitiveCompanionObjects2 = PrimitiveCompanionObjects2.a;
        this.startPanelOpenedCenterPanelX = primitiveCompanionObjects2.getMIN_VALUE();
        this.endPanelOpenedCenterPanelX = primitiveCompanionObjects2.getMAX_VALUE();
        this.startPanelStateListeners = new ArrayList<>();
        this.endPanelStateListeners = new ArrayList<>();
        this.selectedPanel = Panel.CENTER;
        LockState lockState = LockState.UNLOCKED;
        this.startPanelLockState = lockState;
        this.endPanelLockState = lockState;
        PanelState.a aVar = PanelState.a.a;
        this.startPanelState = aVar;
        this.endPanelState = aVar;
        this.childGestureRegions = Collections2.emptyList();
        this.isSystemGestureNavigationPossible = Build.VERSION.SDK_INT >= 29;
        initialize(attributeSet);
    }

    public /* synthetic */ OverlappingPanelsLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlappingPanelsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkParameterIsNotNull(context, "context");
        this.isLeftToRight = true;
        PrimitiveCompanionObjects2 primitiveCompanionObjects2 = PrimitiveCompanionObjects2.a;
        this.startPanelOpenedCenterPanelX = primitiveCompanionObjects2.getMIN_VALUE();
        this.endPanelOpenedCenterPanelX = primitiveCompanionObjects2.getMAX_VALUE();
        this.startPanelStateListeners = new ArrayList<>();
        this.endPanelStateListeners = new ArrayList<>();
        this.selectedPanel = Panel.CENTER;
        LockState lockState = LockState.UNLOCKED;
        this.startPanelLockState = lockState;
        this.endPanelLockState = lockState;
        PanelState.a aVar = PanelState.a.a;
        this.startPanelState = aVar;
        this.endPanelState = aVar;
        this.childGestureRegions = Collections2.emptyList();
        this.isSystemGestureNavigationPossible = Build.VERSION.SDK_INT >= 29;
        initialize(attributeSet);
    }

    public /* synthetic */ OverlappingPanelsLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
