package b.i.e.s.c;

import b.i.e.ResultPoint;
import b.i.e.ResultPointCallback;
import b.i.e.n.BitMatrix;
import com.google.zxing.NotFoundException;

/* compiled from: Detector.java */
/* renamed from: b.i.e.s.c.c, reason: use source file name */
/* loaded from: classes3.dex */
public class Detector4 {
    public final BitMatrix a;

    /* renamed from: b, reason: collision with root package name */
    public ResultPointCallback f1894b;

    public Detector4(BitMatrix bitMatrix) {
        this.a = bitMatrix;
    }

    public final float a(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float fD = d((int) resultPoint.a, (int) resultPoint.f1826b, (int) resultPoint2.a, (int) resultPoint2.f1826b);
        float fD2 = d((int) resultPoint2.a, (int) resultPoint2.f1826b, (int) resultPoint.a, (int) resultPoint.f1826b);
        return Float.isNaN(fD) ? fD2 / 7.0f : Float.isNaN(fD2) ? fD / 7.0f : (fD + fD2) / 14.0f;
    }

    public final AlignmentPattern b(float f, int i, int i2, float f2) throws NotFoundException {
        AlignmentPattern alignmentPatternC;
        AlignmentPattern alignmentPatternC2;
        int i3 = (int) (f2 * f);
        int iMax = Math.max(0, i - i3);
        int iMin = Math.min(this.a.j - 1, i + i3) - iMax;
        float f3 = 3.0f * f;
        if (iMin < f3) {
            throw NotFoundException.l;
        }
        int iMax2 = Math.max(0, i2 - i3);
        int iMin2 = Math.min(this.a.k - 1, i2 + i3) - iMax2;
        if (iMin2 < f3) {
            throw NotFoundException.l;
        }
        AlignmentPatternFinder alignmentPatternFinder = new AlignmentPatternFinder(this.a, iMax, iMax2, iMin, iMin2, f, this.f1894b);
        int i4 = alignmentPatternFinder.c;
        int i5 = alignmentPatternFinder.f;
        int i6 = alignmentPatternFinder.e + i4;
        int i7 = (i5 / 2) + alignmentPatternFinder.d;
        int[] iArr = new int[3];
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = ((i8 & 1) == 0 ? (i8 + 1) / 2 : -((i8 + 1) / 2)) + i7;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i10 = i4;
            while (i10 < i6 && !alignmentPatternFinder.a.f(i10, i9)) {
                i10++;
            }
            int i11 = 0;
            while (i10 < i6) {
                if (!alignmentPatternFinder.a.f(i10, i9)) {
                    if (i11 == 1) {
                        i11++;
                    }
                    iArr[i11] = iArr[i11] + 1;
                } else if (i11 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i11 != 2) {
                    i11++;
                    iArr[i11] = iArr[i11] + 1;
                } else {
                    if (alignmentPatternFinder.b(iArr) && (alignmentPatternC2 = alignmentPatternFinder.c(iArr, i9, i10)) != null) {
                        return alignmentPatternC2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i11 = 1;
                }
                i10++;
            }
            if (alignmentPatternFinder.b(iArr) && (alignmentPatternC = alignmentPatternFinder.c(iArr, i9, i6)) != null) {
                return alignmentPatternC;
            }
        }
        if (alignmentPatternFinder.f1893b.isEmpty()) {
            throw NotFoundException.l;
        }
        return alignmentPatternFinder.f1893b.get(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0084, code lost:
    
        if (r15 != 2) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008c, code lost:
    
        return b.i.a.f.e.o.f.R(r19, r6, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008d, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float c(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Detector4 detector4;
        boolean z2;
        boolean z3;
        int i10 = 1;
        boolean z4 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z4) {
            i6 = i;
            i5 = i2;
            i8 = i3;
            i7 = i4;
        } else {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
        }
        int iAbs = Math.abs(i7 - i5);
        int iAbs2 = Math.abs(i8 - i6);
        int i11 = (-iAbs) / 2;
        int i12 = i5 < i7 ? 1 : -1;
        int i13 = i6 < i8 ? 1 : -1;
        int i14 = i7 + i12;
        int i15 = i5;
        int i16 = i6;
        int i17 = 0;
        while (true) {
            if (i15 == i14) {
                i9 = i14;
                break;
            }
            int i18 = z4 ? i16 : i15;
            int i19 = z4 ? i15 : i16;
            if (i17 == i10) {
                detector4 = this;
                z2 = z4;
                i9 = i14;
                z3 = true;
            } else {
                detector4 = this;
                z2 = z4;
                i9 = i14;
                z3 = false;
            }
            if (z3 == detector4.a.f(i18, i19)) {
                if (i17 == 2) {
                    return b.i.a.f.e.o.f.R(i15, i16, i5, i6);
                }
                i17++;
            }
            i11 += iAbs2;
            if (i11 > 0) {
                if (i16 == i8) {
                    break;
                }
                i16 += i13;
                i11 -= iAbs;
            }
            i15 += i12;
            i14 = i9;
            z4 = z2;
            i10 = 1;
        }
    }

    public final float d(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float fC = c(i, i2, i3, i4);
        int i5 = i - (i3 - i);
        int i6 = 0;
        if (i5 < 0) {
            f = i / (i - i5);
            i5 = 0;
        } else {
            int i7 = this.a.j;
            if (i5 >= i7) {
                float f3 = ((i7 - 1) - i) / (i5 - i);
                int i8 = i7 - 1;
                f = f3;
                i5 = i8;
            } else {
                f = 1.0f;
            }
        }
        float f4 = i2;
        int i9 = (int) (f4 - ((i4 - i2) * f));
        if (i9 < 0) {
            f2 = f4 / (i2 - i9);
        } else {
            int i10 = this.a.k;
            if (i9 >= i10) {
                f2 = ((i10 - 1) - i2) / (i9 - i2);
                i6 = i10 - 1;
            } else {
                i6 = i9;
                f2 = 1.0f;
            }
        }
        return (c(i, i2, (int) (((i5 - i) * f2) + i), i6) + fC) - 1.0f;
    }
}
