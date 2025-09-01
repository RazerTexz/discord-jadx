package b.c.a.y.k;

import b.c.a.c0.Keyframe;
import b.c.a.c0.ScaleXY;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.ScaleKeyframeAnimation;
import java.util.List;

/* compiled from: AnimatableScaleValue.java */
/* renamed from: b.c.a.y.k.g, reason: use source file name */
/* loaded from: classes.dex */
public class AnimatableScaleValue extends BaseAnimatableValue<ScaleXY, ScaleXY> {
    public AnimatableScaleValue(List<Keyframe<ScaleXY>> list) {
        super((List) list);
    }

    @Override // b.c.a.y.k.AnimatableValue
    public BaseKeyframeAnimation<ScaleXY, ScaleXY> a() {
        return new ScaleKeyframeAnimation(this.a);
    }
}
