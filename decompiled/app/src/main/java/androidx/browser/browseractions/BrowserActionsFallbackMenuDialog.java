package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@Deprecated
/* loaded from: classes.dex */
public class BrowserActionsFallbackMenuDialog extends Dialog {
    private static final long ENTER_ANIMATION_DURATION_MS = 250;
    private static final long EXIT_ANIMATION_DURATION_MS = 150;
    private final View mContentView;

    /* renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuDialog$1, reason: invalid class name */
    public class AnonymousClass1 extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean val$isEnterAnimation;

        public AnonymousClass1(boolean z2) {
            this.val$isEnterAnimation = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.val$isEnterAnimation) {
                return;
            }
            BrowserActionsFallbackMenuDialog.access$001(BrowserActionsFallbackMenuDialog.this);
        }
    }

    public BrowserActionsFallbackMenuDialog(Context context, View view) {
        super(context);
        this.mContentView = view;
    }

    public static /* synthetic */ void access$001(BrowserActionsFallbackMenuDialog browserActionsFallbackMenuDialog) {
        super.dismiss();
    }

    private void startAnimation(boolean z2) {
        float f = z2 ? 0.0f : 1.0f;
        float f2 = z2 ? 1.0f : 0.0f;
        long j = z2 ? ENTER_ANIMATION_DURATION_MS : 150L;
        this.mContentView.setScaleX(f);
        this.mContentView.setScaleY(f);
        this.mContentView.animate().scaleX(f2).scaleY(f2).setDuration(j).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new AnonymousClass1(z2)).start();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        startAnimation(false);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // android.app.Dialog
    public void show() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        startAnimation(true);
        super.show();
    }
}
