package b.c.a.a0;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import b.c.a.LottieComposition;
import b.c.a.a0.i0.JsonReader2;
import b.c.a.b0.Logger2;
import b.c.a.b0.Utils;
import b.c.a.y.k.AnimatableColorValue;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatableGradientColorValue;
import b.c.a.y.k.AnimatableIntegerValue;
import b.c.a.y.k.AnimatablePointValue;
import b.c.a.y.k.AnimatableShapeValue;
import b.c.a.y.k.AnimatableTransform;
import b.c.a.y.k.AnimatableValue;
import b.c.a.y.l.CircleShape;
import b.c.a.y.l.ContentModel2;
import b.c.a.y.l.GradientFill;
import b.c.a.y.l.GradientStroke;
import b.c.a.y.l.MergePaths;
import b.c.a.y.l.PolystarShape;
import b.c.a.y.l.RectangleShape;
import b.c.a.y.l.Repeater;
import b.c.a.y.l.ShapeFill;
import b.c.a.y.l.ShapeGroup;
import b.c.a.y.l.ShapePath2;
import b.c.a.y.l.ShapeStroke;
import b.c.a.y.l.ShapeTrimPath;
import b.d.b.a.outline;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ContentModelParser.java */
/* renamed from: b.c.a.a0.g, reason: use source file name */
/* loaded from: classes.dex */
public class ContentModelParser {
    public static JsonReader2.a a = JsonReader2.a.a("ty", "d");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x069f A[LOOP:1: B:386:0x0699->B:388:0x069f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e3  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ContentModel2 a(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        String strT;
        String strT2;
        boolean zF;
        ContentModel2 circleShape;
        ContentModel2 shapeGroup;
        boolean zF2;
        String strT3;
        int iQ;
        String strT4;
        char c;
        jsonReader2.b();
        int iQ2 = 2;
        while (true) {
            strT = null;
            circleShape = null;
            strT4 = null;
            strT3 = null;
            if (!jsonReader2.e()) {
                strT2 = null;
                break;
            }
            int iY = jsonReader2.y(a);
            if (iY == 0) {
                strT2 = jsonReader2.t();
                break;
            }
            if (iY != 1) {
                jsonReader2.A();
                jsonReader2.C();
            } else {
                iQ2 = jsonReader2.q();
            }
        }
        if (strT2 == null) {
            return null;
        }
        zF = false;
        iQ = 0;
        zF2 = false;
        switch (strT2) {
            case "el":
                JsonReader2.a aVar = CircleShapeParser.a;
                boolean z2 = iQ2 == 3;
                String strT5 = null;
                AnimatableValue<PointF, PointF> animatableValueB = null;
                AnimatablePointValue animatablePointValueU1 = null;
                boolean zF3 = false;
                while (jsonReader2.e()) {
                    int iY2 = jsonReader2.y(CircleShapeParser.a);
                    if (iY2 == 0) {
                        strT5 = jsonReader2.t();
                    } else if (iY2 == 1) {
                        animatableValueB = AnimatablePathValueParser.b(jsonReader2, lottieComposition);
                    } else if (iY2 == 2) {
                        animatablePointValueU1 = AnimatableValueParser.u1(jsonReader2, lottieComposition);
                    } else if (iY2 == 3) {
                        zF3 = jsonReader2.f();
                    } else if (iY2 != 4) {
                        jsonReader2.A();
                        jsonReader2.C();
                    } else {
                        z2 = jsonReader2.q() == 3;
                    }
                }
                circleShape = new CircleShape(strT5, animatableValueB, animatablePointValueU1, z2, zF3);
                while (jsonReader2.e()) {
                    jsonReader2.C();
                }
                jsonReader2.d();
                return circleShape;
            case "fl":
                JsonReader2.a aVar2 = ShapeFillParser.a;
                int iQ3 = 1;
                String strT6 = null;
                AnimatableColorValue animatableColorValueP1 = null;
                AnimatableIntegerValue animatableIntegerValueS1 = null;
                boolean zF4 = false;
                boolean zF5 = false;
                while (jsonReader2.e()) {
                    int iY3 = jsonReader2.y(ShapeFillParser.a);
                    if (iY3 == 0) {
                        strT6 = jsonReader2.t();
                    } else if (iY3 == 1) {
                        animatableColorValueP1 = AnimatableValueParser.p1(jsonReader2, lottieComposition);
                    } else if (iY3 == 2) {
                        animatableIntegerValueS1 = AnimatableValueParser.s1(jsonReader2, lottieComposition);
                    } else if (iY3 == 3) {
                        zF4 = jsonReader2.f();
                    } else if (iY3 == 4) {
                        iQ3 = jsonReader2.q();
                    } else if (iY3 != 5) {
                        jsonReader2.A();
                        jsonReader2.C();
                    } else {
                        zF5 = jsonReader2.f();
                    }
                }
                circleShape = new ShapeFill(strT6, zF4, iQ3 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, animatableColorValueP1, animatableIntegerValueS1, zF5);
                while (jsonReader2.e()) {
                }
                jsonReader2.d();
                return circleShape;
            case "gf":
                JsonReader2.a aVar3 = GradientFillParser.a;
                Path.FillType fillType = Path.FillType.WINDING;
                String strT7 = null;
                AnimatableGradientColorValue animatableGradientColorValue = null;
                AnimatableIntegerValue animatableIntegerValueS12 = null;
                AnimatablePointValue animatablePointValueU12 = null;
                AnimatablePointValue animatablePointValueU13 = null;
                int i = 0;
                boolean zF6 = false;
                while (jsonReader2.e()) {
                    switch (jsonReader2.y(GradientFillParser.a)) {
                        case 0:
                            strT7 = jsonReader2.t();
                            break;
                        case 1:
                            jsonReader2.b();
                            int iQ4 = -1;
                            while (jsonReader2.e()) {
                                int iY4 = jsonReader2.y(GradientFillParser.f339b);
                                if (iY4 == 0) {
                                    iQ4 = jsonReader2.q();
                                } else if (iY4 != 1) {
                                    jsonReader2.A();
                                    jsonReader2.C();
                                } else {
                                    animatableGradientColorValue = new AnimatableGradientColorValue(AnimatableValueParser.o1(jsonReader2, lottieComposition, new GradientColorParser(iQ4)));
                                }
                            }
                            jsonReader2.d();
                            break;
                        case 2:
                            animatableIntegerValueS12 = AnimatableValueParser.s1(jsonReader2, lottieComposition);
                            break;
                        case 3:
                            if (jsonReader2.q() != 1) {
                                i = 2;
                                break;
                            } else {
                                i = 1;
                                break;
                            }
                        case 4:
                            animatablePointValueU12 = AnimatableValueParser.u1(jsonReader2, lottieComposition);
                            break;
                        case 5:
                            animatablePointValueU13 = AnimatableValueParser.u1(jsonReader2, lottieComposition);
                            break;
                        case 6:
                            fillType = jsonReader2.q() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                            break;
                        case 7:
                            zF6 = jsonReader2.f();
                            break;
                        default:
                            jsonReader2.A();
                            jsonReader2.C();
                            break;
                    }
                }
                circleShape = new GradientFill(strT7, i, fillType, animatableGradientColorValue, animatableIntegerValueS12, animatablePointValueU12, animatablePointValueU13, null, null, zF6);
                while (jsonReader2.e()) {
                }
                jsonReader2.d();
                return circleShape;
            case "gr":
                JsonReader2.a aVar4 = ShapeGroupParser.a;
                ArrayList arrayList = new ArrayList();
                while (jsonReader2.e()) {
                    int iY5 = jsonReader2.y(ShapeGroupParser.a);
                    if (iY5 == 0) {
                        strT = jsonReader2.t();
                    } else if (iY5 == 1) {
                        zF = jsonReader2.f();
                    } else if (iY5 != 2) {
                        jsonReader2.C();
                    } else {
                        jsonReader2.a();
                        while (jsonReader2.e()) {
                            ContentModel2 contentModel2A = a(jsonReader2, lottieComposition);
                            if (contentModel2A != null) {
                                arrayList.add(contentModel2A);
                            }
                        }
                        jsonReader2.c();
                    }
                }
                shapeGroup = new ShapeGroup(strT, arrayList, zF);
                circleShape = shapeGroup;
                while (jsonReader2.e()) {
                }
                jsonReader2.d();
                return circleShape;
            case "gs":
                JsonReader2.a aVar5 = GradientStrokeParser.a;
                ArrayList arrayList2 = new ArrayList();
                String strT8 = null;
                AnimatableGradientColorValue animatableGradientColorValue2 = null;
                AnimatableIntegerValue animatableIntegerValueS13 = null;
                AnimatablePointValue animatablePointValueU14 = null;
                AnimatablePointValue animatablePointValueU15 = null;
                AnimatableFloatValue animatableFloatValueQ1 = null;
                AnimatableFloatValue animatableFloatValue = null;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                float fN = 0.0f;
                boolean zF7 = false;
                while (jsonReader2.e()) {
                    switch (jsonReader2.y(GradientStrokeParser.a)) {
                        case 0:
                            strT8 = jsonReader2.t();
                            break;
                        case 1:
                            jsonReader2.b();
                            int iQ5 = -1;
                            while (jsonReader2.e()) {
                                int iY6 = jsonReader2.y(GradientStrokeParser.f340b);
                                if (iY6 == 0) {
                                    iQ5 = jsonReader2.q();
                                } else if (iY6 != 1) {
                                    jsonReader2.A();
                                    jsonReader2.C();
                                } else {
                                    animatableGradientColorValue2 = new AnimatableGradientColorValue(AnimatableValueParser.o1(jsonReader2, lottieComposition, new GradientColorParser(iQ5)));
                                }
                            }
                            jsonReader2.d();
                            break;
                        case 2:
                            animatableIntegerValueS13 = AnimatableValueParser.s1(jsonReader2, lottieComposition);
                            break;
                        case 3:
                            if (jsonReader2.q() != 1) {
                                i2 = 2;
                                break;
                            } else {
                                i2 = 1;
                                break;
                            }
                        case 4:
                            animatablePointValueU14 = AnimatableValueParser.u1(jsonReader2, lottieComposition);
                            break;
                        case 5:
                            animatablePointValueU15 = AnimatableValueParser.u1(jsonReader2, lottieComposition);
                            break;
                        case 6:
                            animatableFloatValueQ1 = AnimatableValueParser.q1(jsonReader2, lottieComposition);
                            break;
                        case 7:
                            i3 = b.c.a.y.b.com$airbnb$lottie$model$content$ShapeStroke$LineCapType$s$values()[jsonReader2.q() - 1];
                            break;
                        case 8:
                            i4 = b.c.a.y.b.com$airbnb$lottie$model$content$ShapeStroke$LineJoinType$s$values()[jsonReader2.q() - 1];
                            break;
                        case 9:
                            fN = (float) jsonReader2.n();
                            break;
                        case 10:
                            zF7 = jsonReader2.f();
                            break;
                        case 11:
                            jsonReader2.a();
                            while (jsonReader2.e()) {
                                jsonReader2.b();
                                AnimatableFloatValue animatableFloatValueQ12 = null;
                                String strT9 = null;
                                while (jsonReader2.e()) {
                                    int iY7 = jsonReader2.y(GradientStrokeParser.c);
                                    if (iY7 == 0) {
                                        strT9 = jsonReader2.t();
                                    } else if (iY7 != 1) {
                                        jsonReader2.A();
                                        jsonReader2.C();
                                    } else {
                                        animatableFloatValueQ12 = AnimatableValueParser.q1(jsonReader2, lottieComposition);
                                    }
                                }
                                jsonReader2.d();
                                if (strT9.equals("o")) {
                                    animatableFloatValue = animatableFloatValueQ12;
                                } else if (strT9.equals("d") || strT9.equals("g")) {
                                    lottieComposition.n = true;
                                    arrayList2.add(animatableFloatValueQ12);
                                }
                            }
                            jsonReader2.c();
                            if (arrayList2.size() != 1) {
                                break;
                            } else {
                                arrayList2.add(arrayList2.get(0));
                                break;
                            }
                            break;
                        default:
                            jsonReader2.A();
                            jsonReader2.C();
                            break;
                    }
                }
                circleShape = new GradientStroke(strT8, i2, animatableGradientColorValue2, animatableIntegerValueS13, animatablePointValueU14, animatablePointValueU15, animatableFloatValueQ1, i3, i4, fN, arrayList2, animatableFloatValue, zF7);
                while (jsonReader2.e()) {
                }
                jsonReader2.d();
                return circleShape;
            case "mm":
                JsonReader2.a aVar6 = MergePathsParser.a;
                MergePaths.a aVar7 = null;
                while (jsonReader2.e()) {
                    int iY8 = jsonReader2.y(MergePathsParser.a);
                    if (iY8 == 0) {
                        strT3 = jsonReader2.t();
                    } else if (iY8 == 1) {
                        int iQ6 = jsonReader2.q();
                        MergePaths.a aVar8 = MergePaths.a.MERGE;
                        if (iQ6 != 1) {
                            if (iQ6 == 2) {
                                aVar7 = MergePaths.a.ADD;
                            } else if (iQ6 == 3) {
                                aVar7 = MergePaths.a.SUBTRACT;
                            } else if (iQ6 == 4) {
                                aVar7 = MergePaths.a.INTERSECT;
                            } else if (iQ6 == 5) {
                                aVar7 = MergePaths.a.EXCLUDE_INTERSECTIONS;
                            }
                        }
                        aVar7 = aVar8;
                    } else if (iY8 != 2) {
                        jsonReader2.A();
                        jsonReader2.C();
                    } else {
                        zF2 = jsonReader2.f();
                    }
                }
                MergePaths mergePaths = new MergePaths(strT3, aVar7, zF2);
                lottieComposition.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                circleShape = mergePaths;
                while (jsonReader2.e()) {
                }
                jsonReader2.d();
                return circleShape;
            case "rc":
                JsonReader2.a aVar9 = RectangleShapeParser.a;
                String strT10 = null;
                AnimatableValue<PointF, PointF> animatableValueB2 = null;
                AnimatablePointValue animatablePointValueU16 = null;
                AnimatableFloatValue animatableFloatValueQ13 = null;
                boolean zF8 = false;
                while (jsonReader2.e()) {
                    int iY9 = jsonReader2.y(RectangleShapeParser.a);
                    if (iY9 == 0) {
                        strT10 = jsonReader2.t();
                    } else if (iY9 == 1) {
                        animatableValueB2 = AnimatablePathValueParser.b(jsonReader2, lottieComposition);
                    } else if (iY9 == 2) {
                        animatablePointValueU16 = AnimatableValueParser.u1(jsonReader2, lottieComposition);
                    } else if (iY9 == 3) {
                        animatableFloatValueQ13 = AnimatableValueParser.q1(jsonReader2, lottieComposition);
                    } else if (iY9 != 4) {
                        jsonReader2.C();
                    } else {
                        zF8 = jsonReader2.f();
                    }
                }
                circleShape = new RectangleShape(strT10, animatableValueB2, animatablePointValueU16, animatableFloatValueQ13, zF8);
                while (jsonReader2.e()) {
                }
                jsonReader2.d();
                return circleShape;
            case "rp":
                JsonReader2.a aVar10 = RepeaterParser.a;
                String strT11 = null;
                AnimatableFloatValue animatableFloatValueR1 = null;
                AnimatableFloatValue animatableFloatValueR12 = null;
                AnimatableTransform animatableTransformA = null;
                boolean zF9 = false;
                while (jsonReader2.e()) {
                    int iY10 = jsonReader2.y(RepeaterParser.a);
                    if (iY10 == 0) {
                        strT11 = jsonReader2.t();
                    } else if (iY10 == 1) {
                        animatableFloatValueR1 = AnimatableValueParser.r1(jsonReader2, lottieComposition, false);
                    } else if (iY10 == 2) {
                        animatableFloatValueR12 = AnimatableValueParser.r1(jsonReader2, lottieComposition, false);
                    } else if (iY10 == 3) {
                        animatableTransformA = AnimatableTransformParser.a(jsonReader2, lottieComposition);
                    } else if (iY10 != 4) {
                        jsonReader2.C();
                    } else {
                        zF9 = jsonReader2.f();
                    }
                }
                circleShape = new Repeater(strT11, animatableFloatValueR1, animatableFloatValueR12, animatableTransformA, zF9);
                while (jsonReader2.e()) {
                }
                jsonReader2.d();
                return circleShape;
            case "sh":
                JsonReader2.a aVar11 = ShapePathParser.a;
                boolean zF10 = false;
                AnimatableShapeValue animatableShapeValue = null;
                while (jsonReader2.e()) {
                    int iY11 = jsonReader2.y(ShapePathParser.a);
                    if (iY11 == 0) {
                        strT4 = jsonReader2.t();
                    } else if (iY11 == 1) {
                        iQ = jsonReader2.q();
                    } else if (iY11 == 2) {
                        animatableShapeValue = new AnimatableShapeValue(KeyframesParser.a(jsonReader2, lottieComposition, Utils.c(), ShapeDataParser.a));
                    } else if (iY11 != 3) {
                        jsonReader2.C();
                    } else {
                        zF10 = jsonReader2.f();
                    }
                }
                shapeGroup = new ShapePath2(strT4, iQ, animatableShapeValue, zF10);
                circleShape = shapeGroup;
                while (jsonReader2.e()) {
                }
                jsonReader2.d();
                return circleShape;
            case "sr":
                JsonReader2.a aVar12 = PolystarShapeParser.a;
                String strT12 = null;
                PolystarShape.a aVarF = null;
                AnimatableFloatValue animatableFloatValueR13 = null;
                AnimatableValue<PointF, PointF> animatableValueB3 = null;
                AnimatableFloatValue animatableFloatValueR14 = null;
                AnimatableFloatValue animatableFloatValueQ14 = null;
                AnimatableFloatValue animatableFloatValueQ15 = null;
                AnimatableFloatValue animatableFloatValueR15 = null;
                AnimatableFloatValue animatableFloatValueR16 = null;
                boolean zF11 = false;
                while (jsonReader2.e()) {
                    switch (jsonReader2.y(PolystarShapeParser.a)) {
                        case 0:
                            strT12 = jsonReader2.t();
                            break;
                        case 1:
                            aVarF = PolystarShape.a.f(jsonReader2.q());
                            break;
                        case 2:
                            animatableFloatValueR13 = AnimatableValueParser.r1(jsonReader2, lottieComposition, false);
                            break;
                        case 3:
                            animatableValueB3 = AnimatablePathValueParser.b(jsonReader2, lottieComposition);
                            break;
                        case 4:
                            animatableFloatValueR14 = AnimatableValueParser.r1(jsonReader2, lottieComposition, false);
                            break;
                        case 5:
                            animatableFloatValueQ15 = AnimatableValueParser.q1(jsonReader2, lottieComposition);
                            break;
                        case 6:
                            animatableFloatValueR16 = AnimatableValueParser.r1(jsonReader2, lottieComposition, false);
                            break;
                        case 7:
                            animatableFloatValueQ14 = AnimatableValueParser.q1(jsonReader2, lottieComposition);
                            break;
                        case 8:
                            animatableFloatValueR15 = AnimatableValueParser.r1(jsonReader2, lottieComposition, false);
                            break;
                        case 9:
                            zF11 = jsonReader2.f();
                            break;
                        default:
                            jsonReader2.A();
                            jsonReader2.C();
                            break;
                    }
                }
                shapeGroup = new PolystarShape(strT12, aVarF, animatableFloatValueR13, animatableValueB3, animatableFloatValueR14, animatableFloatValueQ14, animatableFloatValueQ15, animatableFloatValueR15, animatableFloatValueR16, zF11);
                circleShape = shapeGroup;
                while (jsonReader2.e()) {
                }
                jsonReader2.d();
                return circleShape;
            case "st":
                JsonReader2.a aVar13 = ShapeStrokeParser.a;
                ArrayList arrayList3 = new ArrayList();
                String strT13 = null;
                AnimatableFloatValue animatableFloatValue2 = null;
                AnimatableColorValue animatableColorValueP12 = null;
                AnimatableIntegerValue animatableIntegerValueS14 = null;
                AnimatableFloatValue animatableFloatValueQ16 = null;
                int i5 = 0;
                int i6 = 0;
                float fN2 = 0.0f;
                boolean zF12 = false;
                while (jsonReader2.e()) {
                    switch (jsonReader2.y(ShapeStrokeParser.a)) {
                        case 0:
                            strT13 = jsonReader2.t();
                            break;
                        case 1:
                            animatableColorValueP12 = AnimatableValueParser.p1(jsonReader2, lottieComposition);
                            break;
                        case 2:
                            animatableFloatValueQ16 = AnimatableValueParser.q1(jsonReader2, lottieComposition);
                            break;
                        case 3:
                            animatableIntegerValueS14 = AnimatableValueParser.s1(jsonReader2, lottieComposition);
                            break;
                        case 4:
                            i5 = b.c.a.y.b.com$airbnb$lottie$model$content$ShapeStroke$LineCapType$s$values()[jsonReader2.q() - 1];
                            break;
                        case 5:
                            i6 = b.c.a.y.b.com$airbnb$lottie$model$content$ShapeStroke$LineJoinType$s$values()[jsonReader2.q() - 1];
                            break;
                        case 6:
                            fN2 = (float) jsonReader2.n();
                            break;
                        case 7:
                            zF12 = jsonReader2.f();
                            break;
                        case 8:
                            jsonReader2.a();
                            while (jsonReader2.e()) {
                                jsonReader2.b();
                                AnimatableFloatValue animatableFloatValueQ17 = null;
                                String strT14 = null;
                                while (jsonReader2.e()) {
                                    int iY12 = jsonReader2.y(ShapeStrokeParser.f331b);
                                    if (iY12 == 0) {
                                        strT14 = jsonReader2.t();
                                    } else if (iY12 != 1) {
                                        jsonReader2.A();
                                        jsonReader2.C();
                                    } else {
                                        animatableFloatValueQ17 = AnimatableValueParser.q1(jsonReader2, lottieComposition);
                                    }
                                }
                                jsonReader2.d();
                                strT14.hashCode();
                                int iHashCode = strT14.hashCode();
                                if (iHashCode != 100) {
                                    if (iHashCode != 103) {
                                        c = (iHashCode == 111 && strT14.equals("o")) ? (char) 2 : (char) 65535;
                                    } else if (strT14.equals("g")) {
                                        c = 1;
                                    }
                                } else if (strT14.equals("d")) {
                                    c = 0;
                                }
                                if (c == 0 || c == 1) {
                                    lottieComposition.n = true;
                                    arrayList3.add(animatableFloatValueQ17);
                                } else if (c == 2) {
                                    animatableFloatValue2 = animatableFloatValueQ17;
                                }
                            }
                            jsonReader2.c();
                            if (arrayList3.size() != 1) {
                                break;
                            } else {
                                arrayList3.add(arrayList3.get(0));
                                break;
                            }
                            break;
                        default:
                            jsonReader2.C();
                            break;
                    }
                }
                circleShape = new ShapeStroke(strT13, animatableFloatValue2, arrayList3, animatableColorValueP12, animatableIntegerValueS14, animatableFloatValueQ16, i5, i6, fN2, zF12);
                while (jsonReader2.e()) {
                }
                jsonReader2.d();
                return circleShape;
            case "tm":
                JsonReader2.a aVar14 = ShapeTrimPathParser.a;
                String strT15 = null;
                AnimatableFloatValue animatableFloatValueR17 = null;
                AnimatableFloatValue animatableFloatValueR18 = null;
                AnimatableFloatValue animatableFloatValueR19 = null;
                int i7 = 0;
                boolean zF13 = false;
                while (jsonReader2.e()) {
                    int iY13 = jsonReader2.y(ShapeTrimPathParser.a);
                    if (iY13 == 0) {
                        animatableFloatValueR17 = AnimatableValueParser.r1(jsonReader2, lottieComposition, false);
                    } else if (iY13 == 1) {
                        animatableFloatValueR18 = AnimatableValueParser.r1(jsonReader2, lottieComposition, false);
                    } else if (iY13 == 2) {
                        animatableFloatValueR19 = AnimatableValueParser.r1(jsonReader2, lottieComposition, false);
                    } else if (iY13 == 3) {
                        strT15 = jsonReader2.t();
                    } else if (iY13 == 4) {
                        int iQ7 = jsonReader2.q();
                        if (iQ7 == 1) {
                            i7 = 1;
                        } else {
                            if (iQ7 != 2) {
                                throw new IllegalArgumentException(outline.q("Unknown trim path type ", iQ7));
                            }
                            i7 = 2;
                        }
                    } else if (iY13 != 5) {
                        jsonReader2.C();
                    } else {
                        zF13 = jsonReader2.f();
                    }
                }
                circleShape = new ShapeTrimPath(strT15, i7, animatableFloatValueR17, animatableFloatValueR18, animatableFloatValueR19, zF13);
                while (jsonReader2.e()) {
                }
                jsonReader2.d();
                return circleShape;
            case "tr":
                circleShape = AnimatableTransformParser.a(jsonReader2, lottieComposition);
                while (jsonReader2.e()) {
                }
                jsonReader2.d();
                return circleShape;
            default:
                Logger2.b("Unknown shape type " + strT2);
                while (jsonReader2.e()) {
                }
                jsonReader2.d();
                return circleShape;
        }
    }
}
