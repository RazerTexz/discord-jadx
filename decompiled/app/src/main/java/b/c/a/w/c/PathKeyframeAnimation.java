package b.c.a.w.c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import b.c.a.c0.Keyframe;
import b.c.a.c0.LottieValueCallback;
import java.util.List;

/* compiled from: PathKeyframeAnimation.java */
/* renamed from: b.c.a.w.c.i, reason: use source file name */
/* loaded from: classes.dex */
public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {
    public final PointF i;
    public final float[] j;
    public PathKeyframe k;
    public PathMeasure l;

    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> list) {
        super(list);
        this.i = new PointF();
        this.j = new float[2];
        this.l = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public Object f(Keyframe keyframe, float f) {
        PointF pointF;
        PathKeyframe pathKeyframe = (PathKeyframe) keyframe;
        Path path = pathKeyframe.o;
        if (path == null) {
            return (PointF) keyframe.f347b;
        }
        LottieValueCallback<A> lottieValueCallback = this.e;
        if (lottieValueCallback != 0 && (pointF = (PointF) lottieValueCallback.a(pathKeyframe.e, pathKeyframe.f.floatValue(), pathKeyframe.f347b, pathKeyframe.c, d(), f, this.d)) != null) {
            return pointF;
        }
        if (this.k != pathKeyframe) {
            this.l.setPath(path, false);
            this.k = pathKeyframe;
        }
        PathMeasure pathMeasure = this.l;
        pathMeasure.getPosTan(pathMeasure.getLength() * f, this.j, null);
        PointF pointF2 = this.i;
        float[] fArr = this.j;
        pointF2.set(fArr[0], fArr[1]);
        return this.i;
    }
}
