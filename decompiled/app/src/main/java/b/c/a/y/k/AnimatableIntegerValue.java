package b.c.a.y.k;

import b.c.a.c0.Keyframe;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.IntegerKeyframeAnimation;
import java.util.List;

/* compiled from: AnimatableIntegerValue.java */
/* renamed from: b.c.a.y.k.d, reason: use source file name */
/* loaded from: classes.dex */
public class AnimatableIntegerValue extends BaseAnimatableValue<Integer, Integer> {
    public AnimatableIntegerValue(List<Keyframe<Integer>> list) {
        super((List) list);
    }

    @Override // b.c.a.y.k.AnimatableValue
    public BaseKeyframeAnimation<Integer, Integer> a() {
        return new IntegerKeyframeAnimation(this.a);
    }
}
