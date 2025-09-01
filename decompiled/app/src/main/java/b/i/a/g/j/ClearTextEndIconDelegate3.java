package b.i.a.g.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ClearTextEndIconDelegate.java */
/* renamed from: b.i.a.g.j.c, reason: use source file name */
/* loaded from: classes3.dex */
public class ClearTextEndIconDelegate3 extends AnimatorListenerAdapter {
    public final /* synthetic */ ClearTextEndIconDelegate a;

    public ClearTextEndIconDelegate3(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.a = clearTextEndIconDelegate;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.a.setEndIconVisible(false);
    }
}
