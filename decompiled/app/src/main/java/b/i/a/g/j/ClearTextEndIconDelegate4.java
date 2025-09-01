package b.i.a.g.j;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* compiled from: ClearTextEndIconDelegate.java */
/* renamed from: b.i.a.g.j.d, reason: use source file name */
/* loaded from: classes3.dex */
public class ClearTextEndIconDelegate4 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ClearTextEndIconDelegate a;

    public ClearTextEndIconDelegate4(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.a = clearTextEndIconDelegate;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.a.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
