package com.discord.widgets.chat.input.gifpicker;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ViewScalingOnTouchListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/ViewScalingOnTouchListener;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "view", "Landroid/view/MotionEvent;", "event", "", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "", "scaledownFactor", "F", "<init>", "(F)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ViewScalingOnTouchListener implements View.OnTouchListener {
    private final float scaledownFactor;

    public ViewScalingOnTouchListener(float f) {
        this.scaledownFactor = f;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.SCALE_X, this.scaledownFactor);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, Key.SCALE_Y, this.scaledownFactor);
            Intrinsics3.checkNotNullExpressionValue(objectAnimatorOfFloat, "scaleDownX");
            objectAnimatorOfFloat.setDuration(200L);
            Intrinsics3.checkNotNullExpressionValue(objectAnimatorOfFloat2, "scaleDownY");
            objectAnimatorOfFloat2.setDuration(200L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
            animatorSet.start();
        } else if (action == 1 || action == 3) {
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, Key.SCALE_X, 1.0f);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, Key.SCALE_Y, 1.0f);
            Intrinsics3.checkNotNullExpressionValue(objectAnimatorOfFloat3, "scaleUpX");
            objectAnimatorOfFloat3.setDuration(200L);
            Intrinsics3.checkNotNullExpressionValue(objectAnimatorOfFloat4, "scaleUpY");
            objectAnimatorOfFloat4.setDuration(200L);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.play(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4);
            animatorSet2.start();
        }
        return false;
    }
}
