package b.i.a.g.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
/* renamed from: b.i.a.g.g.k, reason: use source file name */
/* loaded from: classes3.dex */
public class LinearIndeterminateDisjointAnimatorDelegate extends AnimatorListenerAdapter {
    public final /* synthetic */ LinearIndeterminateDisjointAnimatorDelegate2 a;

    public LinearIndeterminateDisjointAnimatorDelegate(LinearIndeterminateDisjointAnimatorDelegate2 linearIndeterminateDisjointAnimatorDelegate2) {
        this.a = linearIndeterminateDisjointAnimatorDelegate2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        LinearIndeterminateDisjointAnimatorDelegate2 linearIndeterminateDisjointAnimatorDelegate2 = this.a;
        if (linearIndeterminateDisjointAnimatorDelegate2.m) {
            linearIndeterminateDisjointAnimatorDelegate2.g.setRepeatCount(-1);
            LinearIndeterminateDisjointAnimatorDelegate2 linearIndeterminateDisjointAnimatorDelegate22 = this.a;
            linearIndeterminateDisjointAnimatorDelegate22.n.onAnimationEnd(linearIndeterminateDisjointAnimatorDelegate22.a);
            this.a.m = false;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        LinearIndeterminateDisjointAnimatorDelegate2 linearIndeterminateDisjointAnimatorDelegate2 = this.a;
        linearIndeterminateDisjointAnimatorDelegate2.j = (linearIndeterminateDisjointAnimatorDelegate2.j + 1) % linearIndeterminateDisjointAnimatorDelegate2.i.indicatorColors.length;
        linearIndeterminateDisjointAnimatorDelegate2.k = true;
    }
}
