package b.c.a.w.c;

import android.graphics.PointF;
import b.c.a.c0.Keyframe;
import b.c.a.c0.LottieValueCallback;
import b.d.b.a.outline;
import java.util.List;

/* compiled from: PointKeyframeAnimation.java */
/* renamed from: b.c.a.w.c.j, reason: use source file name */
/* loaded from: classes.dex */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {
    public final PointF i;

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
        this.i = new PointF();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public Object f(Keyframe keyframe, float f) {
        T t;
        PointF pointF;
        T t2 = keyframe.f347b;
        if (t2 == 0 || (t = keyframe.c) == 0) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = (PointF) t2;
        PointF pointF3 = (PointF) t;
        LottieValueCallback<A> lottieValueCallback = this.e;
        if (lottieValueCallback != 0 && (pointF = (PointF) lottieValueCallback.a(keyframe.e, keyframe.f.floatValue(), pointF2, pointF3, f, d(), this.d)) != null) {
            return pointF;
        }
        PointF pointF4 = this.i;
        float f2 = pointF2.x;
        float fA = outline.a(pointF3.x, f2, f, f2);
        float f3 = pointF2.y;
        pointF4.set(fA, ((pointF3.y - f3) * f) + f3);
        return this.i;
    }
}
