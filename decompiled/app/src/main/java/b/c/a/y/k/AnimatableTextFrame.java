package b.c.a.y.k;

import b.c.a.c0.Keyframe;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.TextKeyframeAnimation;
import b.c.a.y.DocumentData;
import java.util.List;

/* compiled from: AnimatableTextFrame.java */
/* renamed from: b.c.a.y.k.j, reason: use source file name */
/* loaded from: classes.dex */
public class AnimatableTextFrame extends BaseAnimatableValue<DocumentData, DocumentData> {
    public AnimatableTextFrame(List<Keyframe<DocumentData>> list) {
        super((List) list);
    }

    @Override // b.c.a.y.k.AnimatableValue
    public BaseKeyframeAnimation a() {
        return new TextKeyframeAnimation(this.a);
    }
}
