package b.i.a.g.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: DropdownMenuEndIconDelegate.java */
/* renamed from: b.i.a.g.j.l, reason: use source file name */
/* loaded from: classes3.dex */
public class DropdownMenuEndIconDelegate5 extends AnimatorListenerAdapter {
    public final /* synthetic */ DropdownMenuEndIconDelegate a;

    public DropdownMenuEndIconDelegate5(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.a = dropdownMenuEndIconDelegate;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = this.a;
        dropdownMenuEndIconDelegate.c.setChecked(dropdownMenuEndIconDelegate.j);
        this.a.p.start();
    }
}
