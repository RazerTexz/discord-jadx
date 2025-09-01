package b.c.a.w.c;

import b.c.a.b0.MiscUtils;
import b.c.a.c0.Keyframe;
import b.c.a.c0.LottieValueCallback;
import b.c.a.c0.ScaleXY;
import java.util.List;

/* compiled from: ScaleKeyframeAnimation.java */
/* renamed from: b.c.a.w.c.k, reason: use source file name */
/* loaded from: classes.dex */
public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {
    public final ScaleXY i;

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
        this.i = new ScaleXY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public Object f(Keyframe keyframe, float f) {
        T t;
        ScaleXY scaleXY;
        T t2 = keyframe.f347b;
        if (t2 == 0 || (t = keyframe.c) == 0) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ScaleXY scaleXY2 = (ScaleXY) t2;
        ScaleXY scaleXY3 = (ScaleXY) t;
        LottieValueCallback<A> lottieValueCallback = this.e;
        if (lottieValueCallback != 0 && (scaleXY = (ScaleXY) lottieValueCallback.a(keyframe.e, keyframe.f.floatValue(), scaleXY2, scaleXY3, f, d(), this.d)) != null) {
            return scaleXY;
        }
        ScaleXY scaleXY4 = this.i;
        float fE = MiscUtils.e(scaleXY2.a, scaleXY3.a, f);
        float fE2 = MiscUtils.e(scaleXY2.f350b, scaleXY3.f350b, f);
        scaleXY4.a = fE;
        scaleXY4.f350b = fE2;
        return this.i;
    }
}
