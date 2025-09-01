package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import b.d.b.a.outline;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ List val$awaitingContainerChanges;
        public final /* synthetic */ SpecialEffectsController.Operation val$operation;

        public AnonymousClass1(List list, SpecialEffectsController.Operation operation) {
            this.val$awaitingContainerChanges = list;
            this.val$operation = operation;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$awaitingContainerChanges.contains(this.val$operation)) {
                this.val$awaitingContainerChanges.remove(this.val$operation);
                DefaultSpecialEffectsController.this.applyContainerChanges(this.val$operation);
            }
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass10 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        static {
            SpecialEffectsController.Operation.State.values();
            int[] iArr = new int[4];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$2, reason: invalid class name */
    public class AnonymousClass2 extends AnimatorListenerAdapter {
        public final /* synthetic */ AnimationInfo val$animationInfo;
        public final /* synthetic */ ViewGroup val$container;
        public final /* synthetic */ boolean val$isHideOperation;
        public final /* synthetic */ SpecialEffectsController.Operation val$operation;
        public final /* synthetic */ View val$viewToAnimate;

        public AnonymousClass2(ViewGroup viewGroup, View view, boolean z2, SpecialEffectsController.Operation operation, AnimationInfo animationInfo) {
            this.val$container = viewGroup;
            this.val$viewToAnimate = view;
            this.val$isHideOperation = z2;
            this.val$operation = operation;
            this.val$animationInfo = animationInfo;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.val$container.endViewTransition(this.val$viewToAnimate);
            if (this.val$isHideOperation) {
                this.val$operation.getFinalState().applyState(this.val$viewToAnimate);
            }
            this.val$animationInfo.completeSpecialEffect();
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$3, reason: invalid class name */
    public class AnonymousClass3 implements CancellationSignal.OnCancelListener {
        public final /* synthetic */ Animator val$animator;

        public AnonymousClass3(Animator animator) {
            this.val$animator = animator;
        }

        @Override // androidx.core.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            this.val$animator.end();
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$4, reason: invalid class name */
    public class AnonymousClass4 implements Animation.AnimationListener {
        public final /* synthetic */ AnimationInfo val$animationInfo;
        public final /* synthetic */ ViewGroup val$container;
        public final /* synthetic */ View val$viewToAnimate;

        /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$4$1, reason: invalid class name */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                anonymousClass4.val$container.endViewTransition(anonymousClass4.val$viewToAnimate);
                AnonymousClass4.this.val$animationInfo.completeSpecialEffect();
            }
        }

        public AnonymousClass4(ViewGroup viewGroup, View view, AnimationInfo animationInfo) {
            this.val$container = viewGroup;
            this.val$viewToAnimate = view;
            this.val$animationInfo = animationInfo;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.val$container.post(new AnonymousClass1());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$5, reason: invalid class name */
    public class AnonymousClass5 implements CancellationSignal.OnCancelListener {
        public final /* synthetic */ AnimationInfo val$animationInfo;
        public final /* synthetic */ ViewGroup val$container;
        public final /* synthetic */ View val$viewToAnimate;

        public AnonymousClass5(View view, ViewGroup viewGroup, AnimationInfo animationInfo) {
            this.val$viewToAnimate = view;
            this.val$container = viewGroup;
            this.val$animationInfo = animationInfo;
        }

        @Override // androidx.core.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            this.val$viewToAnimate.clearAnimation();
            this.val$container.endViewTransition(this.val$viewToAnimate);
            this.val$animationInfo.completeSpecialEffect();
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$6, reason: invalid class name */
    public class AnonymousClass6 implements Runnable {
        public final /* synthetic */ SpecialEffectsController.Operation val$firstOut;
        public final /* synthetic */ boolean val$isPop;
        public final /* synthetic */ SpecialEffectsController.Operation val$lastIn;
        public final /* synthetic */ ArrayMap val$lastInViews;

        public AnonymousClass6(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z2, ArrayMap arrayMap) {
            this.val$lastIn = operation;
            this.val$firstOut = operation2;
            this.val$isPop = z2;
            this.val$lastInViews = arrayMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentTransition.callSharedElementStartEnd(this.val$lastIn.getFragment(), this.val$firstOut.getFragment(), this.val$isPop, this.val$lastInViews, false);
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$7, reason: invalid class name */
    public class AnonymousClass7 implements Runnable {
        public final /* synthetic */ FragmentTransitionImpl val$impl;
        public final /* synthetic */ Rect val$lastInEpicenterRect;
        public final /* synthetic */ View val$lastInEpicenterView;

        public AnonymousClass7(FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
            this.val$impl = fragmentTransitionImpl;
            this.val$lastInEpicenterView = view;
            this.val$lastInEpicenterRect = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$impl.getBoundsOnScreen(this.val$lastInEpicenterView, this.val$lastInEpicenterRect);
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$8, reason: invalid class name */
    public class AnonymousClass8 implements Runnable {
        public final /* synthetic */ ArrayList val$transitioningViews;

        public AnonymousClass8(ArrayList arrayList) {
            this.val$transitioningViews = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentTransition.setViewVisibility(this.val$transitioningViews, 4);
        }
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$9, reason: invalid class name */
    public class AnonymousClass9 implements Runnable {
        public final /* synthetic */ TransitionInfo val$transitionInfo;

        public AnonymousClass9(TransitionInfo transitionInfo) {
            this.val$transitionInfo = transitionInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$transitionInfo.completeSpecialEffect();
        }
    }

    public static class AnimationInfo extends SpecialEffectsInfo {

        @Nullable
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mLoadedAnim;

        public AnimationInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal) {
            super(operation, cancellationSignal);
            this.mLoadedAnim = false;
        }

        @Nullable
        public FragmentAnim.AnimationOrAnimator getAnimation(@NonNull Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            FragmentAnim.AnimationOrAnimator animationOrAnimatorLoadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE);
            this.mAnimation = animationOrAnimatorLoadAnimation;
            this.mLoadedAnim = true;
            return animationOrAnimatorLoadAnimation;
        }
    }

    public static class SpecialEffectsInfo {

        @NonNull
        private final SpecialEffectsController.Operation mOperation;

        @NonNull
        private final CancellationSignal mSignal;

        public SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        public void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        @NonNull
        public SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        @NonNull
        public CancellationSignal getSignal() {
            return this.mSignal;
        }

        public boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State stateFrom = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            return stateFrom == finalState || !(stateFrom == (state = SpecialEffectsController.Operation.State.VISIBLE) || finalState == state);
        }
    }

    public DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(@NonNull List<AnimationInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z2, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z3 = false;
        for (AnimationInfo animationInfo : list) {
            if (animationInfo.isVisibilityUnchanged()) {
                animationInfo.completeSpecialEffect();
            } else {
                FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
                if (animation == null) {
                    animationInfo.completeSpecialEffect();
                } else {
                    Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(animationInfo);
                    } else {
                        SpecialEffectsController.Operation operation = animationInfo.getOperation();
                        Fragment fragment = operation.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            animationInfo.completeSpecialEffect();
                        } else {
                            boolean z4 = operation.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                            if (z4) {
                                list2.remove(operation);
                            }
                            View view = fragment.mView;
                            container.startViewTransition(view);
                            animator.addListener(new AnonymousClass2(container, view, z4, operation, animationInfo));
                            animator.setTarget(view);
                            animator.start();
                            animationInfo.getSignal().setOnCancelListener(new AnonymousClass3(animator));
                            z3 = true;
                        }
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AnimationInfo animationInfo2 = (AnimationInfo) it.next();
            SpecialEffectsController.Operation operation2 = animationInfo2.getOperation();
            Fragment fragment2 = operation2.getFragment();
            if (z2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo2.completeSpecialEffect();
            } else if (z3) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo2.completeSpecialEffect();
            } else {
                View view2 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo2.getAnimation(context))).animation);
                if (operation2.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation2);
                    animationInfo2.completeSpecialEffect();
                } else {
                    container.startViewTransition(view2);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container, view2);
                    endViewTransitionAnimation.setAnimationListener(new AnonymousClass4(container, view2, animationInfo2));
                    view2.startAnimation(endViewTransitionAnimation);
                }
                animationInfo2.getSignal().setOnCancelListener(new AnonymousClass5(view2, container, animationInfo2));
            }
        }
    }

    @NonNull
    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(@NonNull List<TransitionInfo> list, boolean z2, @Nullable SpecialEffectsController.Operation operation, @Nullable SpecialEffectsController.Operation operation2) {
        SpecialEffectsController.Operation operation3;
        Object obj;
        View view;
        Object obj2;
        ArrayList arrayList;
        Rect rect;
        HashMap map;
        ArrayList<View> arrayList2;
        View view2;
        ArrayList arrayList3;
        Rect rect2;
        HashMap map2;
        Object objMergeTransitionsTogether;
        View view3;
        View view4;
        ArrayMap arrayMap;
        ArrayList<View> arrayList4;
        ArrayList<View> arrayList5;
        FragmentTransitionImpl fragmentTransitionImpl;
        HashMap map3;
        Rect rect3;
        View view5;
        SharedElementCallback enterTransitionCallback;
        SharedElementCallback exitTransitionCallback;
        ArrayList<String> arrayList6;
        View view6;
        String strFindKeyForValue;
        ArrayList<String> arrayList7;
        boolean z3 = z2;
        HashMap map4 = new HashMap();
        FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (TransitionInfo transitionInfo : list) {
            if (!transitionInfo.isVisibilityUnchanged()) {
                FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
                if (fragmentTransitionImpl2 == null) {
                    fragmentTransitionImpl2 = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionImpl2 != handlingImpl) {
                    StringBuilder sbU = outline.U("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    sbU.append(transitionInfo.getOperation().getFragment());
                    sbU.append(" returned Transition ");
                    sbU.append(transitionInfo.getTransition());
                    sbU.append(" which uses a different Transition  type than other Fragments.");
                    throw new IllegalArgumentException(sbU.toString());
                }
            }
        }
        if (fragmentTransitionImpl2 == null) {
            for (TransitionInfo transitionInfo2 : list) {
                map4.put(transitionInfo2.getOperation(), Boolean.FALSE);
                transitionInfo2.completeSpecialEffect();
            }
            return map4;
        }
        View view7 = new View(getContainer().getContext());
        Rect rect4 = new Rect();
        ArrayList<View> arrayList8 = new ArrayList<>();
        ArrayList<View> arrayList9 = new ArrayList<>();
        ArrayMap arrayMap2 = new ArrayMap();
        Object obj3 = null;
        SpecialEffectsController.Operation operation4 = operation2;
        View view8 = null;
        boolean z4 = false;
        SpecialEffectsController.Operation operation5 = operation;
        for (TransitionInfo transitionInfo3 : list) {
            if (!transitionInfo3.hasSharedElementTransition() || operation5 == null || operation4 == null) {
                view4 = view8;
                arrayMap = arrayMap2;
                arrayList4 = arrayList9;
                arrayList5 = arrayList8;
                fragmentTransitionImpl = fragmentTransitionImpl2;
            } else {
                Object objWrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(transitionInfo3.getSharedElementTransition()));
                ArrayList<String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                int i = 0;
                while (i < sharedElementTargetNames.size()) {
                    int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i));
                    ArrayList<String> arrayList10 = sharedElementTargetNames;
                    if (iIndexOf != -1) {
                        sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i));
                    }
                    i++;
                    sharedElementTargetNames = arrayList10;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                if (z3) {
                    enterTransitionCallback = operation.getFragment().getEnterTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getExitTransitionCallback();
                } else {
                    enterTransitionCallback = operation.getFragment().getExitTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getEnterTransitionCallback();
                }
                int size = sharedElementSourceNames.size();
                int i2 = 0;
                while (i2 < size) {
                    arrayMap2.put(sharedElementSourceNames.get(i2), sharedElementTargetNames2.get(i2));
                    i2++;
                    size = size;
                    view8 = view8;
                }
                view4 = view8;
                ArrayMap<String, View> arrayMap3 = new ArrayMap<>();
                findNamedViews(arrayMap3, operation.getFragment().mView);
                arrayMap3.retainAll(sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    enterTransitionCallback.onMapSharedElements(sharedElementSourceNames, arrayMap3);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        String str = sharedElementSourceNames.get(size2);
                        View view9 = arrayMap3.get(str);
                        if (view9 == null) {
                            arrayMap2.remove(str);
                            arrayList7 = sharedElementSourceNames;
                        } else {
                            arrayList7 = sharedElementSourceNames;
                            if (!str.equals(ViewCompat.getTransitionName(view9))) {
                                arrayMap2.put(ViewCompat.getTransitionName(view9), (String) arrayMap2.remove(str));
                            }
                        }
                        size2--;
                        sharedElementSourceNames = arrayList7;
                    }
                    arrayList6 = sharedElementSourceNames;
                } else {
                    arrayList6 = sharedElementSourceNames;
                    arrayMap2.retainAll(arrayMap3.keySet());
                }
                ArrayMap<String, View> arrayMap4 = new ArrayMap<>();
                findNamedViews(arrayMap4, operation2.getFragment().mView);
                arrayMap4.retainAll(sharedElementTargetNames2);
                arrayMap4.retainAll(arrayMap2.values());
                if (exitTransitionCallback != null) {
                    exitTransitionCallback.onMapSharedElements(sharedElementTargetNames2, arrayMap4);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        String str2 = sharedElementTargetNames2.get(size3);
                        View view10 = arrayMap4.get(str2);
                        if (view10 == null) {
                            String strFindKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap2, str2);
                            if (strFindKeyForValue2 != null) {
                                arrayMap2.remove(strFindKeyForValue2);
                            }
                        } else if (!str2.equals(ViewCompat.getTransitionName(view10)) && (strFindKeyForValue = FragmentTransition.findKeyForValue(arrayMap2, str2)) != null) {
                            arrayMap2.put(strFindKeyForValue, ViewCompat.getTransitionName(view10));
                        }
                    }
                } else {
                    FragmentTransition.retainValues(arrayMap2, arrayMap4);
                }
                retainMatchingViews(arrayMap3, arrayMap2.keySet());
                retainMatchingViews(arrayMap4, arrayMap2.values());
                if (arrayMap2.isEmpty()) {
                    arrayList8.clear();
                    arrayList9.clear();
                    obj3 = null;
                    operation5 = operation;
                    operation4 = operation2;
                    arrayMap = arrayMap2;
                    arrayList4 = arrayList9;
                    arrayList5 = arrayList8;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                } else {
                    FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z3, arrayMap3, true);
                    ArrayList<String> arrayList11 = arrayList6;
                    ArrayMap arrayMap5 = arrayMap2;
                    HashMap map5 = map4;
                    OneShotPreDrawListener.add(getContainer(), new AnonymousClass6(operation2, operation, z2, arrayMap4));
                    Iterator<View> it = arrayMap3.values().iterator();
                    while (it.hasNext()) {
                        captureTransitioningViews(arrayList8, it.next());
                    }
                    if (!arrayList11.isEmpty()) {
                        View view11 = arrayMap3.get(arrayList11.get(0));
                        fragmentTransitionImpl2.setEpicenter(objWrapTransitionInSet, view11);
                        view4 = view11;
                    }
                    Iterator<View> it2 = arrayMap4.values().iterator();
                    while (it2.hasNext()) {
                        captureTransitioningViews(arrayList9, it2.next());
                    }
                    if (!sharedElementTargetNames2.isEmpty() && (view6 = arrayMap4.get(sharedElementTargetNames2.get(0))) != null) {
                        OneShotPreDrawListener.add(getContainer(), new AnonymousClass7(fragmentTransitionImpl2, view6, rect4));
                        z4 = true;
                    }
                    fragmentTransitionImpl2.setSharedElementTargets(objWrapTransitionInSet, view7, arrayList8);
                    arrayMap = arrayMap5;
                    arrayList4 = arrayList9;
                    arrayList5 = arrayList8;
                    View view12 = view7;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    fragmentTransitionImpl2.scheduleRemoveTargets(objWrapTransitionInSet, null, null, null, null, objWrapTransitionInSet, arrayList4);
                    Boolean bool = Boolean.TRUE;
                    map3 = map5;
                    map3.put(operation, bool);
                    map3.put(operation2, bool);
                    rect3 = rect4;
                    obj3 = objWrapTransitionInSet;
                    operation4 = operation2;
                    view5 = view12;
                    operation5 = operation;
                    arrayMap2 = arrayMap;
                    arrayList9 = arrayList4;
                    arrayList8 = arrayList5;
                    rect4 = rect3;
                    view8 = view4;
                    z3 = z2;
                    view7 = view5;
                    map4 = map3;
                    fragmentTransitionImpl2 = fragmentTransitionImpl;
                }
            }
            map3 = map4;
            view5 = view7;
            rect3 = rect4;
            arrayMap2 = arrayMap;
            arrayList9 = arrayList4;
            arrayList8 = arrayList5;
            rect4 = rect3;
            view8 = view4;
            z3 = z2;
            view7 = view5;
            map4 = map3;
            fragmentTransitionImpl2 = fragmentTransitionImpl;
        }
        View view13 = view8;
        ArrayMap arrayMap6 = arrayMap2;
        ArrayList<View> arrayList12 = arrayList9;
        ArrayList<View> arrayList13 = arrayList8;
        FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
        HashMap map6 = map4;
        View view14 = view7;
        Rect rect5 = rect4;
        ArrayList arrayList14 = new ArrayList();
        Object objMergeTransitionsTogether2 = null;
        Object obj4 = null;
        for (TransitionInfo transitionInfo4 : list) {
            if (transitionInfo4.isVisibilityUnchanged()) {
                map6.put(transitionInfo4.getOperation(), Boolean.FALSE);
                transitionInfo4.completeSpecialEffect();
            } else {
                Object objCloneTransition = fragmentTransitionImpl3.cloneTransition(transitionInfo4.getTransition());
                SpecialEffectsController.Operation operation6 = transitionInfo4.getOperation();
                boolean z5 = obj3 != null && (operation6 == operation5 || operation6 == operation4);
                if (objCloneTransition == null) {
                    if (!z5) {
                        map6.put(operation6, Boolean.FALSE);
                        transitionInfo4.completeSpecialEffect();
                    }
                    view3 = view14;
                    rect2 = rect5;
                    map2 = map6;
                    arrayList3 = arrayList14;
                    objMergeTransitionsTogether = obj4;
                    view2 = view13;
                } else {
                    HashMap map7 = map6;
                    ArrayList<View> arrayList15 = new ArrayList<>();
                    Object obj5 = obj4;
                    captureTransitioningViews(arrayList15, operation6.getFragment().mView);
                    if (z5) {
                        if (operation6 == operation5) {
                            arrayList15.removeAll(arrayList13);
                        } else {
                            arrayList15.removeAll(arrayList12);
                        }
                    }
                    if (arrayList15.isEmpty()) {
                        fragmentTransitionImpl3.addTarget(objCloneTransition, view14);
                        obj = obj5;
                        operation3 = operation6;
                        obj2 = objMergeTransitionsTogether2;
                        arrayList = arrayList14;
                        rect = rect5;
                        arrayList2 = arrayList15;
                        view = view13;
                        map = map7;
                    } else {
                        fragmentTransitionImpl3.addTargets(objCloneTransition, arrayList15);
                        operation3 = operation6;
                        obj = obj5;
                        view = view13;
                        obj2 = objMergeTransitionsTogether2;
                        arrayList = arrayList14;
                        rect = rect5;
                        map = map7;
                        fragmentTransitionImpl3.scheduleRemoveTargets(objCloneTransition, objCloneTransition, arrayList15, null, null, null, null);
                        if (operation3.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            objCloneTransition = objCloneTransition;
                            arrayList2 = arrayList15;
                            fragmentTransitionImpl3.scheduleHideFragmentView(objCloneTransition, operation3.getFragment().mView, arrayList2);
                            OneShotPreDrawListener.add(getContainer(), new AnonymousClass8(arrayList2));
                        } else {
                            objCloneTransition = objCloneTransition;
                            arrayList2 = arrayList15;
                        }
                    }
                    if (operation3.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList3 = arrayList;
                        arrayList3.addAll(arrayList2);
                        rect2 = rect;
                        if (z4) {
                            fragmentTransitionImpl3.setEpicenter(objCloneTransition, rect2);
                        }
                        view2 = view;
                    } else {
                        view2 = view;
                        arrayList3 = arrayList;
                        rect2 = rect;
                        fragmentTransitionImpl3.setEpicenter(objCloneTransition, view2);
                    }
                    map2 = map;
                    map2.put(operation3, Boolean.TRUE);
                    if (transitionInfo4.isOverlapAllowed()) {
                        view3 = view14;
                        objMergeTransitionsTogether = fragmentTransitionImpl3.mergeTransitionsTogether(obj, objCloneTransition, null);
                        objMergeTransitionsTogether2 = obj2;
                    } else {
                        objMergeTransitionsTogether = obj;
                        view3 = view14;
                        objMergeTransitionsTogether2 = fragmentTransitionImpl3.mergeTransitionsTogether(obj2, objCloneTransition, null);
                    }
                }
                view13 = view2;
                obj4 = objMergeTransitionsTogether;
                arrayList14 = arrayList3;
                view14 = view3;
                map6 = map2;
                rect5 = rect2;
            }
        }
        HashMap map8 = map6;
        ArrayList arrayList16 = arrayList14;
        Object objMergeTransitionsInSequence = fragmentTransitionImpl3.mergeTransitionsInSequence(obj4, objMergeTransitionsTogether2, obj3);
        for (TransitionInfo transitionInfo5 : list) {
            if (!transitionInfo5.isVisibilityUnchanged()) {
                Object transition = transitionInfo5.getTransition();
                SpecialEffectsController.Operation operation7 = transitionInfo5.getOperation();
                boolean z6 = obj3 != null && (operation7 == operation5 || operation7 == operation4);
                if (transition != null || z6) {
                    fragmentTransitionImpl3.setListenerForTransitionEnd(transitionInfo5.getOperation().getFragment(), objMergeTransitionsInSequence, transitionInfo5.getSignal(), new AnonymousClass9(transitionInfo5));
                }
            }
        }
        FragmentTransition.setViewVisibility(arrayList16, 4);
        ArrayList<String> arrayListPrepareSetNameOverridesReordered = fragmentTransitionImpl3.prepareSetNameOverridesReordered(arrayList12);
        fragmentTransitionImpl3.beginDelayedTransition(getContainer(), objMergeTransitionsInSequence);
        fragmentTransitionImpl3.setNameOverridesReordered(getContainer(), arrayList13, arrayList12, arrayListPrepareSetNameOverridesReordered, arrayMap6);
        FragmentTransition.setViewVisibility(arrayList16, 0);
        fragmentTransitionImpl3.swapSharedElementTargets(obj3, arrayList13, arrayList12);
        return map8;
    }

    public void applyContainerChanges(@NonNull SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    public void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                captureTransitioningViews(arrayList, childAt);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007f  */
    @Override // androidx.fragment.app.SpecialEffectsController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void executeOperations(@NonNull List<SpecialEffectsController.Operation> list, boolean z2) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation operation3 : list) {
            SpecialEffectsController.Operation.State stateFrom = SpecialEffectsController.Operation.State.from(operation3.getFragment().mView);
            int iOrdinal = operation3.getFinalState().ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal == 2 || iOrdinal == 3) {
                    }
                } else if (stateFrom != SpecialEffectsController.Operation.State.VISIBLE) {
                    operation2 = operation3;
                }
            }
            if (stateFrom == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                operation = operation3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        for (SpecialEffectsController.Operation operation4 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new AnimationInfo(operation4, cancellationSignal));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal2);
            boolean z3 = false;
            if (z2) {
                if (operation4 == operation) {
                    z3 = true;
                }
            } else if (operation4 == operation2) {
            }
            arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z2, z3));
            operation4.addCompletionListener(new AnonymousClass1(arrayList3, operation4));
        }
        Map<SpecialEffectsController.Operation, Boolean> mapStartTransitions = startTransitions(arrayList2, z2, operation, operation2);
        startAnimations(arrayList, arrayList3, mapStartTransitions.containsValue(Boolean.TRUE), mapStartTransitions);
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            applyContainerChanges((SpecialEffectsController.Operation) it.next());
        }
        arrayList3.clear();
    }

    public void findNamedViews(Map<String, View> map, @NonNull View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    public void retainMatchingViews(@NonNull ArrayMap<String, View> arrayMap, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    public static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;

        @Nullable
        private final Object mSharedElementTransition;

        @Nullable
        private final Object mTransition;

        public TransitionInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z2, boolean z3) {
            super(operation, cancellationSignal);
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                this.mTransition = z2 ? operation.getFragment().getReenterTransition() : operation.getFragment().getEnterTransition();
                this.mOverlapAllowed = z2 ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap();
            } else {
                this.mTransition = z2 ? operation.getFragment().getReturnTransition() : operation.getFragment().getExitTransition();
                this.mOverlapAllowed = true;
            }
            if (!z3) {
                this.mSharedElementTransition = null;
            } else if (z2) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        @Nullable
        public FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            StringBuilder sbU = outline.U("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
            sbU.append(getOperation().getFragment());
            sbU.append(" returned Transition ");
            sbU.append(this.mTransition);
            sbU.append(" which uses a different Transition  type than its shared element transition ");
            sbU.append(this.mSharedElementTransition);
            throw new IllegalArgumentException(sbU.toString());
        }

        @Nullable
        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        @Nullable
        public Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        public boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        @Nullable
        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
