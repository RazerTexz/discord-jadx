package b.i.a.c.d3;

import android.animation.ValueAnimator;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DefaultTimeBar a;

    public /* synthetic */ c(DefaultTimeBar defaultTimeBar) {
        this.a = defaultTimeBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        DefaultTimeBar defaultTimeBar = this.a;
        Objects.requireNonNull(defaultTimeBar);
        defaultTimeBar.O = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        defaultTimeBar.invalidate(defaultTimeBar.j);
    }
}
