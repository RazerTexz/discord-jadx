package b.i.a.g.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ClearTextEndIconDelegate.java */
/* renamed from: b.i.a.g.j.b, reason: use source file name */
/* loaded from: classes3.dex */
public class ClearTextEndIconDelegate2 extends AnimatorListenerAdapter {
    public final /* synthetic */ ClearTextEndIconDelegate a;

    public ClearTextEndIconDelegate2(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.a = clearTextEndIconDelegate;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.a.a.setEndIconVisible(true);
    }
}
