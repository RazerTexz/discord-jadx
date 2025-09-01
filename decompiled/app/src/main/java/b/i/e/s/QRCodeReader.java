package b.i.e.s;

import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import b.i.e.BarcodeFormat;
import b.i.e.BinaryBitmap;
import b.i.e.DecodeHintType;
import b.i.e.Reader;
import b.i.e.ResultMetadataType;
import b.i.e.ResultPoint;
import b.i.e.ResultPointCallback;
import b.i.e.n.BitMatrix;
import b.i.e.n.DecoderResult;
import b.i.e.n.DefaultGridSampler;
import b.i.e.n.PerspectiveTransform;
import b.i.e.s.b.Decoder5;
import b.i.e.s.b.QRCodeDecoderMetaData;
import b.i.e.s.b.Version3;
import b.i.e.s.c.AlignmentPattern;
import b.i.e.s.c.Detector4;
import b.i.e.s.c.FinderPattern2;
import b.i.e.s.c.FinderPatternFinder;
import b.i.e.s.c.FinderPatternInfo;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: QRCodeReader.java */
/* renamed from: b.i.e.s.a, reason: use source file name */
/* loaded from: classes3.dex */
public class QRCodeReader implements Reader {
    public static final ResultPoint[] a = new ResultPoint[0];

    /* renamed from: b, reason: collision with root package name */
    public final Decoder5 f1885b = new Decoder5();

    /* JADX WARN: Removed duplicated region for block: B:116:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03c7  */
    @Override // b.i.e.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Result a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int i;
        AlignmentPattern alignmentPatternB;
        float f;
        float f2;
        float f3;
        DecoderResult decoderResultA;
        ResultPoint[] resultPointArr;
        int i2;
        int i3;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            BitMatrix bitMatrixA = binaryBitmap.a();
            Detector4 detector4 = new Detector4(bitMatrixA);
            ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            detector4.f1894b = resultPointCallback;
            FinderPatternFinder finderPatternFinder = new FinderPatternFinder(bitMatrixA, resultPointCallback);
            boolean z2 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
            int i4 = bitMatrixA.k;
            int i5 = bitMatrixA.j;
            int i6 = (i4 * 3) / 388;
            if (i6 < 3 || z2) {
                i6 = 3;
            }
            int[] iArr = new int[5];
            int i7 = i6 - 1;
            boolean zF = false;
            while (true) {
                int i8 = 4;
                if (i7 >= i4 || zF) {
                    break;
                }
                finderPatternFinder.b(iArr);
                int i9 = 0;
                int i10 = 0;
                while (i9 < i5) {
                    if (finderPatternFinder.a.f(i9, i7)) {
                        if ((i10 & 1) == 1) {
                            i10++;
                        }
                        iArr[i10] = iArr[i10] + 1;
                    } else if ((i10 & 1) != 0) {
                        iArr[i10] = iArr[i10] + 1;
                    } else if (i10 != i8) {
                        i10++;
                        iArr[i10] = iArr[i10] + 1;
                    } else if (FinderPatternFinder.c(iArr) && finderPatternFinder.e(iArr, i7, i9)) {
                        if (finderPatternFinder.c) {
                            zF = finderPatternFinder.f();
                        } else if (finderPatternFinder.f1895b.size() <= 1) {
                            i2 = 2;
                            i3 = 0;
                            if (i3 > iArr[i2]) {
                                i7 += (i3 - iArr[i2]) - i2;
                                i9 = i5 - 1;
                            }
                        } else {
                            FinderPattern2 finderPattern2 = null;
                            for (FinderPattern2 finderPattern22 : finderPatternFinder.f1895b) {
                                if (finderPattern22.d >= 2) {
                                    if (finderPattern2 != null) {
                                        finderPatternFinder.c = true;
                                        int iAbs = (int) (Math.abs(finderPattern2.a - finderPattern22.a) - Math.abs(finderPattern2.f1826b - finderPattern22.f1826b));
                                        i2 = 2;
                                        i3 = iAbs / 2;
                                        break;
                                    }
                                    finderPattern2 = finderPattern22;
                                }
                            }
                            i2 = 2;
                            i3 = 0;
                            if (i3 > iArr[i2]) {
                            }
                        }
                        finderPatternFinder.b(iArr);
                        i6 = 2;
                        i10 = 0;
                    } else {
                        finderPatternFinder.g(iArr);
                        i10 = 3;
                    }
                    i9++;
                    i8 = 4;
                }
                if (FinderPatternFinder.c(iArr) && finderPatternFinder.e(iArr, i7, i5)) {
                    i6 = iArr[0];
                    if (finderPatternFinder.c) {
                        zF = finderPatternFinder.f();
                    }
                }
                i7 += i6;
            }
            int size = finderPatternFinder.f1895b.size();
            if (size < 3) {
                throw NotFoundException.l;
            }
            float f4 = 0.0f;
            if (size > 3) {
                Iterator<FinderPattern2> it = finderPatternFinder.f1895b.iterator();
                float f5 = 0.0f;
                float f6 = 0.0f;
                while (it.hasNext()) {
                    float f7 = it.next().c;
                    f5 += f7;
                    f6 += f7 * f7;
                }
                float f8 = f5 / size;
                float fSqrt = (float) Math.sqrt((f6 / r3) - (f8 * f8));
                Collections.sort(finderPatternFinder.f1895b, new FinderPatternFinder.c(f8, null));
                float fMax = Math.max(0.2f * f8, fSqrt);
                int i11 = 0;
                while (i11 < finderPatternFinder.f1895b.size() && finderPatternFinder.f1895b.size() > 3) {
                    if (Math.abs(finderPatternFinder.f1895b.get(i11).c - f8) > fMax) {
                        finderPatternFinder.f1895b.remove(i11);
                        i11--;
                    }
                    i11++;
                }
            }
            if (finderPatternFinder.f1895b.size() > 3) {
                Iterator<FinderPattern2> it2 = finderPatternFinder.f1895b.iterator();
                while (it2.hasNext()) {
                    f4 += it2.next().c;
                }
                Collections.sort(finderPatternFinder.f1895b, new FinderPatternFinder.b(f4 / finderPatternFinder.f1895b.size(), null));
                List<FinderPattern2> list = finderPatternFinder.f1895b;
                i = 3;
                list.subList(3, list.size()).clear();
            } else {
                i = 3;
            }
            FinderPattern2[] finderPattern2Arr = new FinderPattern2[i];
            finderPattern2Arr[0] = finderPatternFinder.f1895b.get(0);
            finderPattern2Arr[1] = finderPatternFinder.f1895b.get(1);
            finderPattern2Arr[2] = finderPatternFinder.f1895b.get(2);
            ResultPoint.b(finderPattern2Arr);
            FinderPatternInfo finderPatternInfo = new FinderPatternInfo(finderPattern2Arr);
            FinderPattern2 finderPattern23 = finderPatternInfo.f1896b;
            FinderPattern2 finderPattern24 = finderPatternInfo.c;
            FinderPattern2 finderPattern25 = finderPatternInfo.a;
            float fA = (detector4.a(finderPattern23, finderPattern25) + detector4.a(finderPattern23, finderPattern24)) / 2.0f;
            if (fA < 1.0f) {
                throw NotFoundException.l;
            }
            int iZ0 = ((f.Z0(f.Q(finderPattern23.a, finderPattern23.f1826b, finderPattern25.a, finderPattern25.f1826b) / fA) + f.Z0(f.Q(finderPattern23.a, finderPattern23.f1826b, finderPattern24.a, finderPattern24.f1826b) / fA)) / 2) + 7;
            int i12 = iZ0 & 3;
            if (i12 == 0) {
                iZ0++;
            } else if (i12 == 2) {
                iZ0--;
            } else if (i12 == 3) {
                throw NotFoundException.l;
            }
            int[] iArr2 = Version3.a;
            if (iZ0 % 4 != 1) {
                throw FormatException.a();
            }
            try {
                Version3 version3D = Version3.d((iZ0 - 17) / 4);
                int iC = version3D.c() - 7;
                if (version3D.d.length > 0) {
                    float f9 = finderPattern24.a;
                    float f10 = finderPattern23.a;
                    float f11 = (f9 - f10) + finderPattern25.a;
                    float f12 = finderPattern24.f1826b;
                    float f13 = finderPattern23.f1826b;
                    float f14 = (f12 - f13) + finderPattern25.f1826b;
                    float f15 = 1.0f - (3.0f / iC);
                    int iA = (int) outline.a(f11, f10, f15, f10);
                    int iA2 = (int) outline.a(f14, f13, f15, f13);
                    for (int i13 = 4; i13 <= 16; i13 <<= 1) {
                        try {
                            alignmentPatternB = detector4.b(fA, iA, iA2, i13);
                            break;
                        } catch (NotFoundException unused) {
                        }
                    }
                    alignmentPatternB = null;
                    float f16 = iZ0 - 3.5f;
                    if (alignmentPatternB == null) {
                        f = alignmentPatternB.a;
                        f2 = alignmentPatternB.f1826b;
                        f3 = f16 - 3.0f;
                    } else {
                        f = (finderPattern24.a - finderPattern23.a) + finderPattern25.a;
                        f2 = (finderPattern24.f1826b - finderPattern23.f1826b) + finderPattern25.f1826b;
                        f3 = f16;
                    }
                    BitMatrix bitMatrixA2 = DefaultGridSampler.a.a(detector4.a, iZ0, iZ0, PerspectiveTransform.a(3.5f, 3.5f, f16, 3.5f, f3, f3, 3.5f, f16, finderPattern23.a, finderPattern23.f1826b, finderPattern24.a, finderPattern24.f1826b, f, f2, finderPattern25.a, finderPattern25.f1826b));
                    ResultPoint[] resultPointArr2 = alignmentPatternB != null ? new ResultPoint[]{finderPattern25, finderPattern23, finderPattern24} : new ResultPoint[]{finderPattern25, finderPattern23, finderPattern24, alignmentPatternB};
                    decoderResultA = this.f1885b.a(bitMatrixA2, map);
                    resultPointArr = resultPointArr2;
                } else {
                    alignmentPatternB = null;
                    float f162 = iZ0 - 3.5f;
                    if (alignmentPatternB == null) {
                    }
                    BitMatrix bitMatrixA22 = DefaultGridSampler.a.a(detector4.a, iZ0, iZ0, PerspectiveTransform.a(3.5f, 3.5f, f162, 3.5f, f3, f3, 3.5f, f162, finderPattern23.a, finderPattern23.f1826b, finderPattern24.a, finderPattern24.f1826b, f, f2, finderPattern25.a, finderPattern25.f1826b));
                    if (alignmentPatternB != null) {
                    }
                    decoderResultA = this.f1885b.a(bitMatrixA22, map);
                    resultPointArr = resultPointArr2;
                }
            } catch (IllegalArgumentException unused2) {
                throw FormatException.a();
            }
        } else {
            BitMatrix bitMatrixA3 = binaryBitmap.a();
            int[] iArrI = bitMatrixA3.i();
            int[] iArrG = bitMatrixA3.g();
            if (iArrI == null || iArrG == null) {
                throw NotFoundException.l;
            }
            int i14 = bitMatrixA3.k;
            int i15 = bitMatrixA3.j;
            int i16 = iArrI[0];
            int i17 = iArrI[1];
            boolean z3 = true;
            int i18 = 0;
            while (i16 < i15 && i17 < i14) {
                if (z3 != bitMatrixA3.f(i16, i17)) {
                    i18++;
                    if (i18 == 5) {
                        break;
                    }
                    z3 = !z3;
                }
                i16++;
                i17++;
            }
            if (i16 == i15 || i17 == i14) {
                throw NotFoundException.l;
            }
            float f17 = (i16 - iArrI[0]) / 7.0f;
            int i19 = iArrI[1];
            int i20 = iArrG[1];
            int i21 = iArrI[0];
            int i22 = iArrG[0];
            if (i21 >= i22 || i19 >= i20) {
                throw NotFoundException.l;
            }
            int i23 = i20 - i19;
            if (i23 != i22 - i21 && (i22 = i21 + i23) >= bitMatrixA3.j) {
                throw NotFoundException.l;
            }
            int iRound = Math.round(((i22 - i21) + 1) / f17);
            int iRound2 = Math.round((i23 + 1) / f17);
            if (iRound <= 0 || iRound2 <= 0) {
                throw NotFoundException.l;
            }
            if (iRound2 != iRound) {
                throw NotFoundException.l;
            }
            int i24 = (int) (f17 / 2.0f);
            int i25 = i19 + i24;
            int i26 = i21 + i24;
            int i27 = (((int) ((iRound - 1) * f17)) + i26) - i22;
            if (i27 > 0) {
                if (i27 > i24) {
                    throw NotFoundException.l;
                }
                i26 -= i27;
            }
            int i28 = (((int) ((iRound2 - 1) * f17)) + i25) - i20;
            if (i28 > 0) {
                if (i28 > i24) {
                    throw NotFoundException.l;
                }
                i25 -= i28;
            }
            BitMatrix bitMatrix = new BitMatrix(iRound, iRound2);
            for (int i29 = 0; i29 < iRound2; i29++) {
                int i30 = ((int) (i29 * f17)) + i25;
                for (int i31 = 0; i31 < iRound; i31++) {
                    if (bitMatrixA3.f(((int) (i31 * f17)) + i26, i30)) {
                        bitMatrix.j(i31, i29);
                    }
                }
            }
            decoderResultA = this.f1885b.a(bitMatrix, map);
            resultPointArr = a;
        }
        Object obj = decoderResultA.f;
        if ((obj instanceof QRCodeDecoderMetaData) && ((QRCodeDecoderMetaData) obj).a && resultPointArr.length >= 3) {
            ResultPoint resultPoint = resultPointArr[0];
            resultPointArr[0] = resultPointArr[2];
            resultPointArr[2] = resultPoint;
        }
        Result result = new Result(decoderResultA.c, decoderResultA.a, resultPointArr, BarcodeFormat.QR_CODE);
        List<byte[]> list2 = decoderResultA.d;
        if (list2 != null) {
            result.b(ResultMetadataType.BYTE_SEGMENTS, list2);
        }
        String str = decoderResultA.e;
        if (str != null) {
            result.b(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
        }
        if (decoderResultA.g >= 0 && decoderResultA.h >= 0) {
            result.b(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decoderResultA.h));
            result.b(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decoderResultA.g));
        }
        return result;
    }

    @Override // b.i.e.Reader
    public void reset() {
    }
}
