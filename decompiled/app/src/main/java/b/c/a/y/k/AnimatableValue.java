package b.c.a.y.k;

import b.c.a.c0.Keyframe;
import b.c.a.w.c.BaseKeyframeAnimation;
import java.util.List;

/* compiled from: AnimatableValue.java */
/* renamed from: b.c.a.y.k.m, reason: use source file name */
/* loaded from: classes.dex */
public interface AnimatableValue<K, A> {
    BaseKeyframeAnimation<K, A> a();

    List<Keyframe<K>> b();

    boolean isStatic();
}
