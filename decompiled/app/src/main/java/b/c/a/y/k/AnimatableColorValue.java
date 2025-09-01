package b.c.a.y.k;

import b.c.a.c0.Keyframe;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.ColorKeyframeAnimation;
import java.util.List;

/* compiled from: AnimatableColorValue.java */
/* renamed from: b.c.a.y.k.a, reason: use source file name */
/* loaded from: classes.dex */
public class AnimatableColorValue extends BaseAnimatableValue<Integer, Integer> {
    public AnimatableColorValue(List<Keyframe<Integer>> list) {
        super((List) list);
    }

    @Override // b.c.a.y.k.AnimatableValue
    public BaseKeyframeAnimation<Integer, Integer> a() {
        return new ColorKeyframeAnimation(this.a);
    }
}
