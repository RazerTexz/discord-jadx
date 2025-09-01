package b.a.g;

import d0.z.d.Intrinsics3;

/* compiled from: ColorUtils.kt */
/* renamed from: b.a.g.c, reason: use source file name */
/* loaded from: classes.dex */
public final class ColorUtils2 {
    public static final void a(int i, int i2, int i3, float[] fArr) {
        float f;
        float fAbs;
        Intrinsics3.checkNotNullParameter(fArr, "hsl");
        float f2 = i / 255.0f;
        float f3 = i2 / 255.0f;
        float f4 = i3 / 255.0f;
        float fMax = Math.max(f2, Math.max(f3, f4));
        float fMin = Math.min(f2, Math.min(f3, f4));
        float f5 = fMax - fMin;
        float f6 = (fMax + fMin) / 2.0f;
        if (fMax == fMin) {
            f = 0.0f;
            fAbs = 0.0f;
        } else {
            f = fMax == f2 ? ((f3 - f4) / f5) % 6.0f : fMax == f3 ? ((f4 - f2) / f5) + 2.0f : ((f2 - f3) / f5) + 4.0f;
            fAbs = f5 / (1.0f - Math.abs((2.0f * f6) - 1.0f));
        }
        fArr[0] = (f * 60.0f) % 360.0f;
        fArr[1] = fAbs;
        fArr[2] = f6;
    }
}
