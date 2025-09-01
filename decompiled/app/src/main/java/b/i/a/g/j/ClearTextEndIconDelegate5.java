package b.i.a.g.j;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* compiled from: ClearTextEndIconDelegate.java */
/* renamed from: b.i.a.g.j.e, reason: use source file name */
/* loaded from: classes3.dex */
public class ClearTextEndIconDelegate5 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ClearTextEndIconDelegate a;

    public ClearTextEndIconDelegate5(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.a = clearTextEndIconDelegate;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.c.setScaleX(fFloatValue);
        this.a.c.setScaleY(fFloatValue);
    }
}
