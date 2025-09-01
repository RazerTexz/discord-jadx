package b.c.a.a0;

import android.graphics.Color;
import b.c.a.LottieComposition;
import b.c.a.a0.i0.JsonReader2;
import b.c.a.b0.Logger2;
import b.c.a.b0.Utils;
import b.c.a.c0.Keyframe;
import b.c.a.y.k.AnimatableColorValue;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatableIntegerValue;
import b.c.a.y.k.AnimatableShapeValue;
import b.c.a.y.k.AnimatableTextFrame;
import b.c.a.y.k.AnimatableTextProperties;
import b.c.a.y.k.AnimatableTransform;
import b.c.a.y.l.ContentModel2;
import b.c.a.y.l.Mask;
import b.c.a.y.m.Layer2;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: LayerParser.java */
/* renamed from: b.c.a.a0.s, reason: use source file name */
/* loaded from: classes.dex */
public class LayerParser {
    public static final JsonReader2.a a = JsonReader2.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader2.a f342b = JsonReader2.a.a("d", "a");
    public static final JsonReader2.a c = JsonReader2.a.a("nm");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0055. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02e4  */
    /* JADX WARN: Type inference failed for: r6v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Layer2 a(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str;
        String str2;
        long j;
        char c2;
        char c3;
        String str3;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader2.b();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        int i = 1;
        boolean z2 = false;
        long jQ = -1;
        float fN = 0.0f;
        String strT = null;
        Layer2.a aVar = null;
        String strT2 = null;
        AnimatableTransform animatableTransformA = null;
        int iC = 0;
        int iC2 = 0;
        int color = 0;
        float fN2 = 1.0f;
        float fN3 = 0.0f;
        int iC3 = 0;
        int iC4 = 0;
        AnimatableTextFrame animatableTextFrame = null;
        AnimatableTextProperties animatableTextProperties = null;
        int i2 = 1;
        AnimatableFloatValue animatableFloatValueR1 = null;
        boolean zF = false;
        long jQ2 = 0;
        String strT3 = "UNSET";
        float fN4 = 0.0f;
        while (jsonReader2.e()) {
            switch (jsonReader2.y(a)) {
                case 0:
                    str2 = strT;
                    strT3 = jsonReader2.t();
                    strT = str2;
                    break;
                case 1:
                    str2 = strT;
                    jQ2 = jsonReader2.q();
                    strT = str2;
                    break;
                case 2:
                    str2 = strT;
                    strT2 = jsonReader2.t();
                    strT = str2;
                    break;
                case 3:
                    str2 = strT;
                    j = jQ2;
                    int iQ = jsonReader2.q();
                    aVar = iQ < 6 ? Layer2.a.values()[iQ] : Layer2.a.UNKNOWN;
                    jQ2 = j;
                    strT = str2;
                    break;
                case 4:
                    str2 = strT;
                    j = jQ2;
                    jQ = jsonReader2.q();
                    jQ2 = j;
                    strT = str2;
                    break;
                case 5:
                    str2 = strT;
                    iC = (int) (Utils.c() * jsonReader2.q());
                    strT = str2;
                    break;
                case 6:
                    str2 = strT;
                    iC2 = (int) (Utils.c() * jsonReader2.q());
                    strT = str2;
                    break;
                case 7:
                    str2 = strT;
                    color = Color.parseColor(jsonReader2.t());
                    strT = str2;
                    break;
                case 8:
                    str2 = strT;
                    animatableTransformA = AnimatableTransformParser.a(jsonReader2, lottieComposition);
                    strT = str2;
                    break;
                case 9:
                    str2 = strT;
                    j = jQ2;
                    i2 = b.c.a.y.b.com$airbnb$lottie$model$layer$Layer$MatteType$s$values()[jsonReader2.q()];
                    lottieComposition.o++;
                    jQ2 = j;
                    strT = str2;
                    break;
                case 10:
                    str2 = strT;
                    AnimatableShapeValue animatableShapeValue = null;
                    jsonReader2.a();
                    while (jsonReader2.e()) {
                        jsonReader2.b();
                        AnimatableShapeValue animatableShapeValue2 = animatableShapeValue;
                        AnimatableIntegerValue animatableIntegerValueS1 = animatableShapeValue2;
                        int i3 = 0;
                        boolean zF2 = false;
                        while (jsonReader2.e()) {
                            String strS = jsonReader2.s();
                            strS.hashCode();
                            long j2 = jQ2;
                            int iHashCode = strS.hashCode();
                            if (iHashCode != 111) {
                                if (iHashCode != 3588) {
                                    if (iHashCode != 104433) {
                                        c2 = (iHashCode == 3357091 && strS.equals("mode")) ? (char) 3 : (char) 65535;
                                    } else if (strS.equals("inv")) {
                                        c2 = 2;
                                    }
                                } else if (strS.equals("pt")) {
                                    c2 = 1;
                                }
                            } else if (strS.equals("o")) {
                                c2 = 0;
                            }
                            if (c2 == 0) {
                                animatableIntegerValueS1 = AnimatableValueParser.s1(jsonReader2, lottieComposition);
                            } else if (c2 == 1) {
                                animatableShapeValue2 = new AnimatableShapeValue(KeyframesParser.a(jsonReader2, lottieComposition, Utils.c(), ShapeDataParser.a));
                            } else if (c2 == 2) {
                                zF2 = jsonReader2.f();
                            } else if (c2 != 3) {
                                jsonReader2.C();
                            } else {
                                String strT4 = jsonReader2.t();
                                strT4.hashCode();
                                int iHashCode2 = strT4.hashCode();
                                if (iHashCode2 == 97) {
                                    if (strT4.equals("a")) {
                                        c3 = 0;
                                    }
                                    if (c3 != 0) {
                                    }
                                    i3 = 1;
                                } else if (iHashCode2 == 105) {
                                    if (strT4.equals("i")) {
                                        c3 = 1;
                                    }
                                    if (c3 != 0) {
                                    }
                                    i3 = 1;
                                } else if (iHashCode2 != 110) {
                                    c3 = (iHashCode2 == 115 && strT4.equals("s")) ? (char) 3 : (char) 65535;
                                    if (c3 != 0) {
                                        if (c3 == 1) {
                                            lottieComposition.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                                            i3 = 3;
                                        } else if (c3 == 2) {
                                            i3 = 4;
                                        } else if (c3 != 3) {
                                            Logger2.b("Unknown mask mode " + strS + ". Defaulting to Add.");
                                        } else {
                                            i3 = 2;
                                        }
                                    }
                                    i3 = 1;
                                } else {
                                    if (strT4.equals("n")) {
                                        c3 = 2;
                                    }
                                    if (c3 != 0) {
                                    }
                                    i3 = 1;
                                }
                            }
                            jQ2 = j2;
                            animatableIntegerValueS1 = animatableIntegerValueS1;
                        }
                        jsonReader2.d();
                        arrayList3.add(new Mask(i3, animatableShapeValue2, animatableIntegerValueS1, zF2));
                        jQ2 = jQ2;
                        animatableShapeValue = null;
                    }
                    j = jQ2;
                    lottieComposition.o += arrayList3.size();
                    jsonReader2.c();
                    jQ2 = j;
                    strT = str2;
                    break;
                case 11:
                    str2 = strT;
                    jsonReader2.a();
                    while (jsonReader2.e()) {
                        ContentModel2 contentModel2A = ContentModelParser.a(jsonReader2, lottieComposition);
                        if (contentModel2A != null) {
                            arrayList4.add(contentModel2A);
                        }
                    }
                    jsonReader2.c();
                    j = jQ2;
                    jQ2 = j;
                    strT = str2;
                    break;
                case 12:
                    jsonReader2.b();
                    while (jsonReader2.e()) {
                        int iY = jsonReader2.y(f342b);
                        if (iY == 0) {
                            str3 = strT;
                            animatableTextFrame = new AnimatableTextFrame(AnimatableValueParser.o1(jsonReader2, lottieComposition, DocumentDataParser.a));
                        } else if (iY != i) {
                            jsonReader2.A();
                            jsonReader2.C();
                        } else {
                            jsonReader2.a();
                            if (jsonReader2.e()) {
                                JsonReader2.a aVar2 = AnimatableTextPropertiesParser.a;
                                jsonReader2.b();
                                AnimatableTextProperties animatableTextProperties2 = null;
                                while (jsonReader2.e()) {
                                    if (jsonReader2.y(AnimatableTextPropertiesParser.a) != 0) {
                                        jsonReader2.A();
                                        jsonReader2.C();
                                    } else {
                                        jsonReader2.b();
                                        AnimatableFloatValue animatableFloatValueQ1 = null;
                                        AnimatableFloatValue animatableFloatValueQ12 = null;
                                        AnimatableColorValue animatableColorValueP1 = null;
                                        AnimatableColorValue animatableColorValueP12 = null;
                                        while (jsonReader2.e()) {
                                            int iY2 = jsonReader2.y(AnimatableTextPropertiesParser.f326b);
                                            if (iY2 == 0) {
                                                animatableColorValueP1 = AnimatableValueParser.p1(jsonReader2, lottieComposition);
                                            } else if (iY2 == i) {
                                                animatableColorValueP12 = AnimatableValueParser.p1(jsonReader2, lottieComposition);
                                            } else if (iY2 == 2) {
                                                animatableFloatValueQ1 = AnimatableValueParser.q1(jsonReader2, lottieComposition);
                                            } else if (iY2 != 3) {
                                                jsonReader2.A();
                                                jsonReader2.C();
                                            } else {
                                                animatableFloatValueQ12 = AnimatableValueParser.q1(jsonReader2, lottieComposition);
                                            }
                                            i = 1;
                                        }
                                        jsonReader2.d();
                                        animatableTextProperties2 = new AnimatableTextProperties(animatableColorValueP1, animatableColorValueP12, animatableFloatValueQ1, animatableFloatValueQ12);
                                        strT = strT;
                                        i = 1;
                                    }
                                }
                                str3 = strT;
                                jsonReader2.d();
                                animatableTextProperties = animatableTextProperties2 == null ? new AnimatableTextProperties(null, null, null, null) : animatableTextProperties2;
                            } else {
                                str3 = strT;
                            }
                            while (jsonReader2.e()) {
                                jsonReader2.C();
                            }
                            jsonReader2.c();
                        }
                        strT = str3;
                        i = 1;
                    }
                    str2 = strT;
                    jsonReader2.d();
                    strT = str2;
                    break;
                case 13:
                    jsonReader2.a();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader2.e()) {
                        jsonReader2.b();
                        while (jsonReader2.e()) {
                            if (jsonReader2.y(c) != 0) {
                                jsonReader2.A();
                                jsonReader2.C();
                            } else {
                                arrayList5.add(jsonReader2.t());
                            }
                        }
                        jsonReader2.d();
                    }
                    jsonReader2.c();
                    lottieComposition.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    str2 = strT;
                    j = jQ2;
                    jQ2 = j;
                    strT = str2;
                    break;
                case 14:
                    fN2 = (float) jsonReader2.n();
                    str2 = strT;
                    strT = str2;
                    break;
                case 15:
                    fN3 = (float) jsonReader2.n();
                    str2 = strT;
                    strT = str2;
                    break;
                case 16:
                    iC3 = (int) (Utils.c() * jsonReader2.q());
                    str2 = strT;
                    strT = str2;
                    break;
                case 17:
                    iC4 = (int) (Utils.c() * jsonReader2.q());
                    str2 = strT;
                    strT = str2;
                    break;
                case 18:
                    fN = (float) jsonReader2.n();
                    str2 = strT;
                    strT = str2;
                    break;
                case 19:
                    fN4 = (float) jsonReader2.n();
                    break;
                case 20:
                    animatableFloatValueR1 = AnimatableValueParser.r1(jsonReader2, lottieComposition, z2);
                    break;
                case 21:
                    strT = jsonReader2.t();
                    break;
                case 22:
                    zF = jsonReader2.f();
                    break;
                default:
                    str2 = strT;
                    j = jQ2;
                    jsonReader2.A();
                    jsonReader2.C();
                    jQ2 = j;
                    strT = str2;
                    break;
            }
            i = 1;
            z2 = false;
        }
        String str4 = strT;
        long j3 = jQ2;
        jsonReader2.d();
        float f = fN / fN2;
        float f2 = fN4 / fN2;
        ArrayList arrayList6 = new ArrayList();
        if (f > 0.0f) {
            arrayList = arrayList4;
            arrayList2 = arrayList3;
            str = str4;
            arrayList6.add(new Keyframe(lottieComposition, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f)));
        } else {
            arrayList = arrayList4;
            arrayList2 = arrayList3;
            str = str4;
        }
        if (f2 <= 0.0f) {
            f2 = lottieComposition.l;
        }
        arrayList6.add(new Keyframe(lottieComposition, fValueOf, fValueOf, null, f, Float.valueOf(f2)));
        arrayList6.add(new Keyframe(lottieComposition, fValueOf2, fValueOf2, null, f2, Float.valueOf(Float.MAX_VALUE)));
        if (strT3.endsWith(".ai") || "ai".equals(str)) {
            lottieComposition.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer2(arrayList, lottieComposition, strT3, j3, aVar, jQ, strT2, arrayList2, animatableTransformA, iC, iC2, color, fN2, fN3, iC3, iC4, animatableTextFrame, animatableTextProperties, arrayList6, i2, animatableFloatValueR1, zF);
    }
}
