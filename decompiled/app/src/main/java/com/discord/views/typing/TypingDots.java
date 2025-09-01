package com.discord.views.typing;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.TypingDotsViewBinding;
import b.a.y.r0.TypingDots2;
import com.discord.R;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TypingDots.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\t\u0010\bR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/discord/views/typing/TypingDots;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "isReplay", "", "a", "(Z)V", "c", "()V", "onDetachedFromWindow", "n", "Z", "isRunning", "", "l", "I", "dotsAnimationTimeMs", "", "m", "J", "dotsAnimationStaggerTimeMs", "Lb/a/i/t1;", "k", "Lb/a/i/t1;", "binding", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class TypingDots extends ConstraintLayout {
    public static final /* synthetic */ int j = 0;

    /* renamed from: k, reason: from kotlin metadata */
    public final TypingDotsViewBinding binding;

    /* renamed from: l, reason: from kotlin metadata */
    public final int dotsAnimationTimeMs;

    /* renamed from: m, reason: from kotlin metadata */
    public final long dotsAnimationStaggerTimeMs;

    /* renamed from: n, reason: from kotlin metadata */
    public boolean isRunning;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypingDots(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.typing_dots_view, this);
        int i = R.id.view_typing_dots_1;
        TypingDot typingDot = (TypingDot) findViewById(R.id.view_typing_dots_1);
        if (typingDot != null) {
            i = R.id.view_typing_dots_2;
            TypingDot typingDot2 = (TypingDot) findViewById(R.id.view_typing_dots_2);
            if (typingDot2 != null) {
                i = R.id.view_typing_dots_3;
                TypingDot typingDot3 = (TypingDot) findViewById(R.id.view_typing_dots_3);
                if (typingDot3 != null) {
                    TypingDotsViewBinding typingDotsViewBinding = new TypingDotsViewBinding(this, typingDot, typingDot2, typingDot3);
                    Intrinsics3.checkNotNullExpressionValue(typingDotsViewBinding, "TypingDotsViewBinding.in…ater.from(context), this)");
                    this.binding = typingDotsViewBinding;
                    int integer = getResources().getInteger(R.integer.animation_time_standard);
                    this.dotsAnimationTimeMs = integer;
                    this.dotsAnimationStaggerTimeMs = (long) (integer / 1.5d);
                    typingDot3.setOnScaleDownCompleteListener(new TypingDots2(this));
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public static /* synthetic */ void b(TypingDots typingDots, boolean z2, int i) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        typingDots.a(z2);
    }

    public final void a(boolean isReplay) {
        if (this.isRunning && !isReplay) {
            return;
        }
        long j2 = isReplay ? this.dotsAnimationStaggerTimeMs : 0L;
        this.binding.f202b.a(j2);
        this.binding.c.a(this.dotsAnimationStaggerTimeMs + j2);
        TypingDot typingDot = this.binding.d;
        long j3 = this.dotsAnimationStaggerTimeMs;
        typingDot.a(j2 + j3 + j3);
        this.isRunning = true;
    }

    public final void c() {
        TypingDotsViewBinding typingDotsViewBinding = this.binding;
        for (TypingDot typingDot : Collections2.listOf((Object[]) new TypingDot[]{typingDotsViewBinding.f202b, typingDotsViewBinding.c, typingDotsViewBinding.d})) {
            typingDot.scaleAndFadeUpAnimation.cancel();
            typingDot.scaleAndFadeDownAnimation.cancel();
        }
        this.isRunning = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }
}
