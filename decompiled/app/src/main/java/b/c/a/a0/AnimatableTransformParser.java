package b.c.a.a0;

import android.graphics.PointF;
import b.c.a.LottieComposition;
import b.c.a.a0.i0.JsonReader2;
import b.c.a.c0.Keyframe;
import b.c.a.c0.ScaleXY;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatableIntegerValue;
import b.c.a.y.k.AnimatablePathValue;
import b.c.a.y.k.AnimatableScaleValue;
import b.c.a.y.k.AnimatableSplitDimensionPathValue;
import b.c.a.y.k.AnimatableTransform;
import b.c.a.y.k.AnimatableValue;
import java.io.IOException;

/* compiled from: AnimatableTransformParser.java */
/* renamed from: b.c.a.a0.c, reason: use source file name */
/* loaded from: classes.dex */
public class AnimatableTransformParser {
    public static JsonReader2.a a = JsonReader2.a.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* renamed from: b, reason: collision with root package name */
    public static JsonReader2.a f328b = JsonReader2.a.a("k");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AnimatableTransform a(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        AnimatableFloatValue animatableFloatValue;
        AnimatableScaleValue animatableScaleValue;
        boolean z2;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableScaleValue animatableScaleValue2;
        AnimatableFloatValue animatableFloatValue3;
        AnimatableValue<PointF, PointF> animatableValue;
        AnimatableFloatValue animatableFloatValueR1;
        AnimatableFloatValue animatableFloatValue4;
        boolean z3 = false;
        boolean z4 = jsonReader2.u() == JsonReader2.b.BEGIN_OBJECT;
        if (z4) {
            jsonReader2.b();
        }
        AnimatableFloatValue animatableFloatValue5 = null;
        AnimatableScaleValue animatableScaleValue3 = null;
        AnimatableValue<PointF, PointF> animatableValueB = null;
        AnimatableFloatValue animatableFloatValueR12 = null;
        AnimatableFloatValue animatableFloatValueR13 = null;
        AnimatablePathValue animatablePathValueA = null;
        AnimatableIntegerValue animatableIntegerValueS1 = null;
        AnimatableFloatValue animatableFloatValueR14 = null;
        AnimatableFloatValue animatableFloatValueR15 = null;
        while (jsonReader2.e()) {
            switch (jsonReader2.y(a)) {
                case 0:
                    animatableScaleValue2 = animatableScaleValue3;
                    animatableFloatValue3 = animatableFloatValueR12;
                    animatableValue = animatableValueB;
                    jsonReader2.b();
                    while (jsonReader2.e()) {
                        if (jsonReader2.y(f328b) != 0) {
                            jsonReader2.A();
                            jsonReader2.C();
                        } else {
                            animatablePathValueA = AnimatablePathValueParser.a(jsonReader2, lottieComposition);
                        }
                    }
                    jsonReader2.d();
                    animatableScaleValue3 = animatableScaleValue2;
                    animatableValueB = animatableValue;
                    animatableFloatValueR12 = animatableFloatValue3;
                    z3 = false;
                    break;
                case 1:
                    animatableFloatValue3 = animatableFloatValueR12;
                    animatableValueB = AnimatablePathValueParser.b(jsonReader2, lottieComposition);
                    animatableFloatValueR12 = animatableFloatValue3;
                    z3 = false;
                    break;
                case 2:
                    animatableFloatValue3 = animatableFloatValueR12;
                    animatableValue = animatableValueB;
                    animatableScaleValue3 = new AnimatableScaleValue(AnimatableValueParser.o1(jsonReader2, lottieComposition, ScaleXYParser.a));
                    animatableValueB = animatableValue;
                    animatableFloatValueR12 = animatableFloatValue3;
                    z3 = false;
                    break;
                case 3:
                    lottieComposition.a("Lottie doesn't support 3D layers.");
                    animatableFloatValueR1 = AnimatableValueParser.r1(jsonReader2, lottieComposition, z3);
                    if (animatableFloatValueR1.a.isEmpty()) {
                        animatableFloatValue4 = animatableFloatValueR1;
                        animatableScaleValue2 = animatableScaleValue3;
                        animatableFloatValue3 = animatableFloatValueR12;
                        animatableValue = animatableValueB;
                        if (((Keyframe) animatableFloatValue4.a.get(0)).f347b == 0) {
                            animatableFloatValue4.a.set(0, new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.l)));
                        }
                    } else {
                        animatableFloatValue4 = animatableFloatValueR1;
                        animatableScaleValue2 = animatableScaleValue3;
                        animatableFloatValue3 = animatableFloatValueR12;
                        animatableValue = animatableValueB;
                        animatableFloatValueR1.a.add(new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.l)));
                    }
                    animatableFloatValue5 = animatableFloatValue4;
                    animatableScaleValue3 = animatableScaleValue2;
                    animatableValueB = animatableValue;
                    animatableFloatValueR12 = animatableFloatValue3;
                    z3 = false;
                    break;
                case 4:
                    animatableFloatValueR1 = AnimatableValueParser.r1(jsonReader2, lottieComposition, z3);
                    if (animatableFloatValueR1.a.isEmpty()) {
                    }
                    animatableFloatValue5 = animatableFloatValue4;
                    animatableScaleValue3 = animatableScaleValue2;
                    animatableValueB = animatableValue;
                    animatableFloatValueR12 = animatableFloatValue3;
                    z3 = false;
                    break;
                case 5:
                    animatableIntegerValueS1 = AnimatableValueParser.s1(jsonReader2, lottieComposition);
                    break;
                case 6:
                    animatableFloatValueR14 = AnimatableValueParser.r1(jsonReader2, lottieComposition, z3);
                    break;
                case 7:
                    animatableFloatValueR15 = AnimatableValueParser.r1(jsonReader2, lottieComposition, z3);
                    break;
                case 8:
                    animatableFloatValueR13 = AnimatableValueParser.r1(jsonReader2, lottieComposition, z3);
                    break;
                case 9:
                    animatableFloatValueR12 = AnimatableValueParser.r1(jsonReader2, lottieComposition, z3);
                    break;
                default:
                    animatableFloatValue3 = animatableFloatValueR12;
                    jsonReader2.A();
                    jsonReader2.C();
                    animatableFloatValueR12 = animatableFloatValue3;
                    z3 = false;
                    break;
            }
        }
        AnimatableScaleValue animatableScaleValue4 = animatableScaleValue3;
        AnimatableFloatValue animatableFloatValue6 = animatableFloatValueR12;
        AnimatableValue<PointF, PointF> animatableValue2 = animatableValueB;
        if (z4) {
            jsonReader2.d();
        }
        if (animatablePathValueA == null || (animatablePathValueA.isStatic() && animatablePathValueA.a.get(0).f347b.equals(0.0f, 0.0f))) {
            animatablePathValueA = null;
        }
        if (animatableValue2 == null || (!(animatableValue2 instanceof AnimatableSplitDimensionPathValue) && animatableValue2.isStatic() && animatableValue2.b().get(0).f347b.equals(0.0f, 0.0f))) {
            animatableValue2 = null;
        }
        if (animatableFloatValue5 == null || (animatableFloatValue5.isStatic() && ((Float) ((Keyframe) animatableFloatValue5.a.get(0)).f347b).floatValue() == 0.0f)) {
            animatableScaleValue = animatableScaleValue4;
            animatableFloatValue = null;
        } else {
            animatableFloatValue = animatableFloatValue5;
            animatableScaleValue = animatableScaleValue4;
        }
        if (animatableScaleValue == null) {
            z2 = true;
        } else {
            if (animatableScaleValue.isStatic()) {
                ScaleXY scaleXY = (ScaleXY) ((Keyframe) animatableScaleValue.a.get(0)).f347b;
                if (scaleXY.a == 1.0f && scaleXY.f350b == 1.0f) {
                }
            }
            z2 = false;
        }
        AnimatableScaleValue animatableScaleValue5 = z2 ? null : animatableScaleValue;
        if (animatableFloatValueR13 == null || (animatableFloatValueR13.isStatic() && ((Float) ((Keyframe) animatableFloatValueR13.a.get(0)).f347b).floatValue() == 0.0f)) {
            animatableFloatValueR13 = null;
        }
        if (animatableFloatValue6 != null) {
            animatableFloatValue2 = animatableFloatValue6;
            boolean z5 = animatableFloatValue6.isStatic() && ((Float) ((Keyframe) animatableFloatValue2.a.get(0)).f347b).floatValue() == 0.0f;
            return new AnimatableTransform(animatablePathValueA, animatableValue2, animatableScaleValue5, animatableFloatValue, animatableIntegerValueS1, animatableFloatValueR14, animatableFloatValueR15, animatableFloatValueR13, !z5 ? null : animatableFloatValue2);
        }
        animatableFloatValue2 = animatableFloatValue6;
        return new AnimatableTransform(animatablePathValueA, animatableValue2, animatableScaleValue5, animatableFloatValue, animatableIntegerValueS1, animatableFloatValueR14, animatableFloatValueR15, animatableFloatValueR13, !z5 ? null : animatableFloatValue2);
    }
}
