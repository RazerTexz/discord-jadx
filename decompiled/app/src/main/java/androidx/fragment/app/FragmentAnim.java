package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R;
import androidx.fragment.app.FragmentTransition;

/* loaded from: classes.dex */
public class FragmentAnim {

    /* renamed from: androidx.fragment.app.FragmentAnim$1, reason: invalid class name */
    public class AnonymousClass1 implements CancellationSignal.OnCancelListener {
        public final /* synthetic */ Fragment val$fragment;

        public AnonymousClass1(Fragment fragment) {
            this.val$fragment = fragment;
        }

        @Override // androidx.core.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            if (this.val$fragment.getAnimatingAway() != null) {
                View animatingAway = this.val$fragment.getAnimatingAway();
                this.val$fragment.setAnimatingAway(null);
                animatingAway.clearAnimation();
            }
            this.val$fragment.setAnimator(null);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentAnim$2, reason: invalid class name */
    public class AnonymousClass2 implements Animation.AnimationListener {
        public final /* synthetic */ FragmentTransition.Callback val$callback;
        public final /* synthetic */ ViewGroup val$container;
        public final /* synthetic */ Fragment val$fragment;
        public final /* synthetic */ CancellationSignal val$signal;

        /* renamed from: androidx.fragment.app.FragmentAnim$2$1, reason: invalid class name */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (AnonymousClass2.this.val$fragment.getAnimatingAway() != null) {
                    AnonymousClass2.this.val$fragment.setAnimatingAway(null);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    anonymousClass2.val$callback.onComplete(anonymousClass2.val$fragment, anonymousClass2.val$signal);
                }
            }
        }

        public AnonymousClass2(ViewGroup viewGroup, Fragment fragment, FragmentTransition.Callback callback, CancellationSignal cancellationSignal) {
            this.val$container = viewGroup;
            this.val$fragment = fragment;
            this.val$callback = callback;
            this.val$signal = cancellationSignal;
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

    /* renamed from: androidx.fragment.app.FragmentAnim$3, reason: invalid class name */
    public class AnonymousClass3 extends AnimatorListenerAdapter {
        public final /* synthetic */ FragmentTransition.Callback val$callback;
        public final /* synthetic */ ViewGroup val$container;
        public final /* synthetic */ Fragment val$fragment;
        public final /* synthetic */ CancellationSignal val$signal;
        public final /* synthetic */ View val$viewToAnimate;

        public AnonymousClass3(ViewGroup viewGroup, View view, Fragment fragment, FragmentTransition.Callback callback, CancellationSignal cancellationSignal) {
            this.val$container = viewGroup;
            this.val$viewToAnimate = view;
            this.val$fragment = fragment;
            this.val$callback = callback;
            this.val$signal = cancellationSignal;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.val$container.endViewTransition(this.val$viewToAnimate);
            Animator animator2 = this.val$fragment.getAnimator();
            this.val$fragment.setAnimator(null);
            if (animator2 == null || this.val$container.indexOfChild(this.val$viewToAnimate) >= 0) {
                return;
            }
            this.val$callback.onComplete(this.val$fragment, this.val$signal);
        }
    }

    private FragmentAnim() {
    }

    public static void animateRemoveFragment(@NonNull Fragment fragment, @NonNull AnimationOrAnimator animationOrAnimator, @NonNull FragmentTransition.Callback callback) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        CancellationSignal cancellationSignal = new CancellationSignal();
        cancellationSignal.setOnCancelListener(new AnonymousClass1(fragment));
        callback.onStart(fragment, cancellationSignal);
        if (animationOrAnimator.animation != null) {
            EndViewTransitionAnimation endViewTransitionAnimation = new EndViewTransitionAnimation(animationOrAnimator.animation, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            endViewTransitionAnimation.setAnimationListener(new AnonymousClass2(viewGroup, fragment, callback, cancellationSignal));
            fragment.mView.startAnimation(endViewTransitionAnimation);
            return;
        }
        Animator animator = animationOrAnimator.animator;
        fragment.setAnimator(animator);
        animator.addListener(new AnonymousClass3(viewGroup, view, fragment, callback, cancellationSignal));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    public static AnimationOrAnimator loadAnimation(@NonNull Context context, @NonNull Fragment fragment, boolean z2) {
        int nextTransition = fragment.getNextTransition();
        int nextAnim = fragment.getNextAnim();
        boolean z3 = false;
        fragment.setNextAnim(0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i = R.id.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i) != null) {
                fragment.mContainer.setTag(i, null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationOnCreateAnimation = fragment.onCreateAnimation(nextTransition, z2, nextAnim);
        if (animationOnCreateAnimation != null) {
            return new AnimationOrAnimator(animationOnCreateAnimation);
        }
        Animator animatorOnCreateAnimator = fragment.onCreateAnimator(nextTransition, z2, nextAnim);
        if (animatorOnCreateAnimator != null) {
            return new AnimationOrAnimator(animatorOnCreateAnimator);
        }
        if (nextAnim == 0 && nextTransition != 0) {
            nextAnim = transitToAnimResourceId(nextTransition, z2);
        }
        if (nextAnim != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(nextAnim));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, nextAnim);
                    if (animationLoadAnimation != null) {
                        return new AnimationOrAnimator(animationLoadAnimation);
                    }
                    z3 = true;
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, nextAnim);
                    if (animatorLoadAnimator != null) {
                        return new AnimationOrAnimator(animatorLoadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (zEquals) {
                        throw e2;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, nextAnim);
                    if (animationLoadAnimation2 != null) {
                        return new AnimationOrAnimator(animationLoadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    @AnimRes
    private static int transitToAnimResourceId(int i, boolean z2) {
        if (i == 4097) {
            return z2 ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
        }
        if (i == 4099) {
            return z2 ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit;
        }
        if (i != 8194) {
            return -1;
        }
        return z2 ? R.animator.fragment_close_enter : R.animator.fragment_close_exit;
    }

    public static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        public AnimationOrAnimator(Animation animation) {
            this.animation = animation;
            this.animator = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public AnimationOrAnimator(Animator animator) {
            this.animation = null;
            this.animator = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    public static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        public EndViewTransitionAnimation(@NonNull Animation animation, @NonNull ViewGroup viewGroup, @NonNull View view) {
            super(false);
            this.mAnimating = true;
            this.mParent = viewGroup;
            this.mChild = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, @NonNull Transformation transformation) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j, transformation)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mEnded || !this.mAnimating) {
                this.mParent.endViewTransition(this.mChild);
                this.mTransitionEnded = true;
            } else {
                this.mAnimating = false;
                this.mParent.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, @NonNull Transformation transformation, float f) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }
    }
}
