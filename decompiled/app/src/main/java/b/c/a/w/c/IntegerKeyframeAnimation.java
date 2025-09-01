package b.c.a.w.c;

import android.graphics.PointF;
import b.c.a.b0.MiscUtils;
import b.c.a.c0.Keyframe;
import b.c.a.c0.LottieValueCallback;
import java.util.List;

/* compiled from: IntegerKeyframeAnimation.java */
/* renamed from: b.c.a.w.c.e, reason: use source file name */
/* loaded from: classes.dex */
public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    public IntegerKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public Object f(Keyframe keyframe, float f) {
        return Integer.valueOf(j(keyframe, f));
    }

    public int j(Keyframe<Integer> keyframe, float f) {
        Integer num;
        if (keyframe.f347b == null || keyframe.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback<A> lottieValueCallback = this.e;
        if (lottieValueCallback != 0 && (num = (Integer) lottieValueCallback.a(keyframe.e, keyframe.f.floatValue(), keyframe.f347b, keyframe.c, f, d(), this.d)) != null) {
            return num.intValue();
        }
        if (keyframe.i == 784923401) {
            keyframe.i = keyframe.f347b.intValue();
        }
        int i = keyframe.i;
        if (keyframe.j == 784923401) {
            keyframe.j = keyframe.c.intValue();
        }
        int i2 = keyframe.j;
        PointF pointF = MiscUtils.a;
        return (int) ((f * (i2 - i)) + i);
    }
}
