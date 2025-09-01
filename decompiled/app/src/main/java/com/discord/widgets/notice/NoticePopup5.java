package com.discord.widgets.notice;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: NoticePopup.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "Landroid/view/MotionEvent;", "event", "", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.notice.NoticePopup$enqueue$notice$1$3$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class NoticePopup5 implements View.OnTouchListener {
    public final /* synthetic */ ValueAnimator $viewAutoDismissAnimator;

    public NoticePopup5(ValueAnimator valueAnimator) {
        this.$viewAutoDismissAnimator = valueAnimator;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics3.checkNotNullExpressionValue(motionEvent, "event");
        if (motionEvent.getAction() != 0) {
            return false;
        }
        NoticePopup.access$cancelCountdown(NoticePopup.INSTANCE, this.$viewAutoDismissAnimator);
        return false;
    }
}
