package com.discord.views.typing;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.discord.R;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: TypingDot.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/views/typing/TypingDot;", "Landroid/view/View;", "", "onDetachedFromWindow", "()V", "", "delay", "a", "(J)V", "Landroid/view/animation/Animation;", "j", "Landroid/view/animation/Animation;", "scaleAndFadeUpAnimation", "k", "scaleAndFadeDownAnimation", "Lkotlin/Function0;", "l", "Lkotlin/jvm/functions/Function0;", "getOnScaleDownCompleteListener", "()Lkotlin/jvm/functions/Function0;", "setOnScaleDownCompleteListener", "(Lkotlin/jvm/functions/Function0;)V", "onScaleDownCompleteListener", "b", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class TypingDot extends View {

    /* renamed from: j, reason: from kotlin metadata */
    public final Animation scaleAndFadeUpAnimation;

    /* renamed from: k, reason: from kotlin metadata */
    public final Animation scaleAndFadeDownAnimation;

    /* renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onScaleDownCompleteListener;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.j = i;
            this.k = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.j;
            if (i == 0) {
                TypingDot typingDot = (TypingDot) this.k;
                typingDot.startAnimation(typingDot.scaleAndFadeDownAnimation);
                return Unit.a;
            }
            if (i != 1) {
                throw null;
            }
            Function0<Unit> onScaleDownCompleteListener = ((TypingDot) this.k).getOnScaleDownCompleteListener();
            if (onScaleDownCompleteListener != null) {
                onScaleDownCompleteListener.invoke();
            }
            return Unit.a;
        }
    }

    /* compiled from: TypingDot.kt */
    public static class b implements Animation.AnimationListener {
        public final Function0<Unit> j;

        public b(Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(function0, "onComplete");
            this.j = function0;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.j.invoke();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypingDot(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, R.anim.anim_typing_dots_scale_up);
        Intrinsics3.checkNotNullExpressionValue(animationLoadAnimation, "AnimationUtils.loadAnima…nim_typing_dots_scale_up)");
        this.scaleAndFadeUpAnimation = animationLoadAnimation;
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, R.anim.anim_typing_dots_scale_down);
        Intrinsics3.checkNotNullExpressionValue(animationLoadAnimation2, "AnimationUtils.loadAnima…m_typing_dots_scale_down)");
        this.scaleAndFadeDownAnimation = animationLoadAnimation2;
    }

    public final void a(long delay) {
        this.scaleAndFadeUpAnimation.setStartOffset(delay);
        this.scaleAndFadeUpAnimation.setAnimationListener(new b(new a(0, this)));
        this.scaleAndFadeDownAnimation.setAnimationListener(new b(new a(1, this)));
        startAnimation(this.scaleAndFadeUpAnimation);
    }

    public final Function0<Unit> getOnScaleDownCompleteListener() {
        return this.onScaleDownCompleteListener;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.scaleAndFadeUpAnimation.cancel();
        this.scaleAndFadeDownAnimation.cancel();
    }

    public final void setOnScaleDownCompleteListener(Function0<Unit> function0) {
        this.onScaleDownCompleteListener = function0;
    }
}
