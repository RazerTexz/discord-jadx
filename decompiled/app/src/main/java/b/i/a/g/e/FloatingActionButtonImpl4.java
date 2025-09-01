package b.i.a.g.e;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

/* compiled from: FloatingActionButtonImpl.java */
/* renamed from: b.i.a.g.e.g, reason: use source file name */
/* loaded from: classes3.dex */
public class FloatingActionButtonImpl4 implements TypeEvaluator<Float> {
    public FloatEvaluator a = new FloatEvaluator();

    public FloatingActionButtonImpl4(FloatingActionButtonImpl3 floatingActionButtonImpl3) {
    }

    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f, Float f2, Float f3) {
        float fFloatValue = this.a.evaluate(f, (Number) f2, (Number) f3).floatValue();
        if (fFloatValue < 0.1f) {
            fFloatValue = 0.0f;
        }
        return Float.valueOf(fFloatValue);
    }
}
