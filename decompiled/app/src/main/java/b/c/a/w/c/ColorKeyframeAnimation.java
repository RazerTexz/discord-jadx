package b.c.a.w.c;

import b.c.a.a0.AnimatableValueParser;
import b.c.a.b0.MiscUtils;
import b.c.a.c0.Keyframe;
import b.c.a.c0.LottieValueCallback;
import java.util.List;

/* compiled from: ColorKeyframeAnimation.java */
/* renamed from: b.c.a.w.c.b, reason: use source file name */
/* loaded from: classes.dex */
public class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
    public ColorKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public Object f(Keyframe keyframe, float f) {
        return Integer.valueOf(j(keyframe, f));
    }

    public int j(Keyframe<Integer> keyframe, float f) {
        Integer num;
        Integer num2 = keyframe.f347b;
        if (num2 == null || keyframe.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int iIntValue = num2.intValue();
        int iIntValue2 = keyframe.c.intValue();
        LottieValueCallback<A> lottieValueCallback = this.e;
        return (lottieValueCallback == 0 || (num = (Integer) lottieValueCallback.a(keyframe.e, keyframe.f.floatValue(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), f, d(), this.d)) == null) ? AnimatableValueParser.i0(MiscUtils.b(f, 0.0f, 1.0f), iIntValue, iIntValue2) : num.intValue();
    }
}
