package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.a.g.l.TransitionUtils3;

/* loaded from: classes3.dex */
public final class FadeThroughProvider implements VisibilityAnimatorProvider {
    public static final float PROGRESS_THRESHOLD = 0.35f;

    public static class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f3083b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ float e;

        public a(View view, float f, float f2, float f3, float f4) {
            this.a = view;
            this.f3083b = f;
            this.c = f2;
            this.d = f3;
            this.e = f4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.setAlpha(TransitionUtils3.e(this.f3083b, this.c, this.d, this.e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    public static class b extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f3084b;

        public b(View view, float f) {
            this.a = view;
            this.f3084b = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setAlpha(this.f3084b);
        }
    }

    private static Animator createFadeThroughAnimator(View view, float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, float f5) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new a(view, f, f2, f3, f4));
        valueAnimatorOfFloat.addListener(new b(view, f5));
        return valueAnimatorOfFloat;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeThroughAnimator(view, 0.0f, alpha, 0.35f, 1.0f, alpha);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeThroughAnimator(view, alpha, 0.0f, 0.0f, 0.35f, alpha);
    }
}
