package com.discord.utilities.anim;

import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: RingAnimator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/utilities/anim/RingAnimator;", "", "", "onUpdate", "()V", "", "isAnimating", "Z", "Lkotlin/Function0;", "ringingPredicate", "Lkotlin/jvm/functions/Function0;", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "fadeAnim", "Landroid/animation/ObjectAnimator;", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RingAnimator {
    private final ObjectAnimator fadeAnim;
    private boolean isAnimating;
    private final Function0<Boolean> ringingPredicate;
    private final View view;

    public RingAnimator(View view, Function0<Boolean> function0) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(function0, "ringingPredicate");
        this.view = view;
        this.ringingPredicate = function0;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.1f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new RingAnimator$$special$$inlined$apply$lambda$1(this));
        this.fadeAnim = objectAnimatorOfFloat;
    }

    public static final /* synthetic */ boolean access$isAnimating$p(RingAnimator ringAnimator) {
        return ringAnimator.isAnimating;
    }

    public static final /* synthetic */ void access$setAnimating$p(RingAnimator ringAnimator, boolean z2) {
        ringAnimator.isAnimating = z2;
    }

    public final View getView() {
        return this.view;
    }

    public final void onUpdate() {
        boolean zBooleanValue = this.ringingPredicate.invoke().booleanValue();
        boolean z2 = this.isAnimating;
        if (!z2 && zBooleanValue) {
            this.isAnimating = true;
            this.fadeAnim.start();
        } else {
            if (!z2 || zBooleanValue) {
                return;
            }
            this.fadeAnim.cancel();
            ObjectAnimator objectAnimator = this.fadeAnim;
            Intrinsics3.checkNotNullExpressionValue(objectAnimator, "fadeAnim");
            objectAnimator.setDuration(0L);
        }
    }
}
