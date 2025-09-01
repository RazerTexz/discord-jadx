package b.c.a.w.c;

import b.c.a.b0.MiscUtils;
import b.c.a.c0.Keyframe;
import b.c.a.c0.LottieValueCallback;
import java.util.List;

/* compiled from: FloatKeyframeAnimation.java */
/* renamed from: b.c.a.w.c.c, reason: use source file name */
/* loaded from: classes.dex */
public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public Object f(Keyframe keyframe, float f) {
        return Float.valueOf(k(keyframe, f));
    }

    public float j() {
        return k(a(), c());
    }

    public float k(Keyframe<Float> keyframe, float f) {
        Float f2;
        if (keyframe.f347b == null || keyframe.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback<A> lottieValueCallback = this.e;
        if (lottieValueCallback != 0 && (f2 = (Float) lottieValueCallback.a(keyframe.e, keyframe.f.floatValue(), keyframe.f347b, keyframe.c, f, d(), this.d)) != null) {
            return f2.floatValue();
        }
        if (keyframe.g == -3987645.8f) {
            keyframe.g = keyframe.f347b.floatValue();
        }
        float f3 = keyframe.g;
        if (keyframe.h == -3987645.8f) {
            keyframe.h = keyframe.c.floatValue();
        }
        return MiscUtils.e(f3, keyframe.h, f);
    }
}
