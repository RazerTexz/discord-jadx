package b.i.a.g.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: CircularIndeterminateAnimatorDelegate.java */
/* renamed from: b.i.a.g.g.b, reason: use source file name */
/* loaded from: classes3.dex */
public class CircularIndeterminateAnimatorDelegate extends AnimatorListenerAdapter {
    public final /* synthetic */ CircularIndeterminateAnimatorDelegate3 a;

    public CircularIndeterminateAnimatorDelegate(CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3) {
        this.a = circularIndeterminateAnimatorDelegate3;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3 = this.a;
        circularIndeterminateAnimatorDelegate3.m = (circularIndeterminateAnimatorDelegate3.m + 4) % circularIndeterminateAnimatorDelegate3.l.indicatorColors.length;
    }
}
