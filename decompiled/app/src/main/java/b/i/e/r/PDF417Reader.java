package b.i.e.r;

import b.i.e.BinaryBitmap;
import b.i.e.DecodeHintType;
import b.i.e.Reader;
import b.i.e.ResultPoint;
import b.i.e.n.BitArray;
import b.i.e.n.BitMatrix;
import b.i.e.n.DecoderResult;
import b.i.e.r.d.BarcodeMetadata;
import b.i.e.r.d.BarcodeValue;
import b.i.e.r.d.BoundingBox;
import b.i.e.r.d.Codeword;
import b.i.e.r.d.DetectionResult;
import b.i.e.r.d.DetectionResultColumn;
import b.i.e.r.d.DetectionResultRowIndicatorColumn;
import b.i.e.r.d.PDF417ScanningDecoder;
import b.i.e.r.d.k.ErrorCorrection;
import b.i.e.r.e.Detector3;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: PDF417Reader.java */
/* renamed from: b.i.e.r.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class PDF417Reader implements Reader {
    public static int b(ResultPoint resultPoint, ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return 0;
        }
        return (int) Math.abs(resultPoint.a - resultPoint2.a);
    }

    public static int c(ResultPoint resultPoint, ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(resultPoint.a - resultPoint2.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:325:0x064c, code lost:
    
        r3 = new com.google.zxing.Result(r2.c, r2.a, r4, b.i.e.BarcodeFormat.PDF_417);
        r3.b(b.i.e.ResultMetadataType.ERROR_CORRECTION_LEVEL, r2.e);
        r2 = (b.i.e.r.PDF417ResultMetadata) r2.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0662, code lost:
    
        if (r2 == null) goto L367;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0664, code lost:
    
        r3.b(b.i.e.ResultMetadataType.PDF417_EXTRA_METADATA, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x0669, code lost:
    
        r0.add(r3);
        r3 = r25;
        r2 = 0;
        r5 = 2;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x01c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a2  */
    @Override // b.i.e.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, NumberFormatException, FormatException {
        BoundingBox boundingBox;
        DetectionResult detectionResult;
        int i;
        boolean z2;
        int i2;
        Iterator<ResultPoint[]> it;
        BoundingBox boundingBox2;
        int i3;
        Iterator<ResultPoint[]> it2;
        int i4;
        Codeword codeword;
        int i5;
        int i6;
        int i7;
        DetectionResultColumn detectionResultColumn;
        int i8;
        int i9;
        int i10;
        BoundingBox boundingBox3;
        int i11;
        int i12;
        BoundingBox boundingBox4;
        BarcodeMetadata barcodeMetadataC;
        BarcodeMetadata barcodeMetadataC2;
        ArrayList arrayList = new ArrayList();
        BitMatrix bitMatrixA = binaryBitmap.a();
        char c = 0;
        List<ResultPoint[]> listA = Detector3.a(false, bitMatrixA);
        int i13 = 2;
        if (((ArrayList) listA).isEmpty()) {
            int i14 = bitMatrixA.j;
            int i15 = bitMatrixA.k;
            BitMatrix bitMatrix = new BitMatrix(i14, i15, bitMatrixA.l, (int[]) bitMatrixA.m.clone());
            BitArray bitArray = new BitArray(i14);
            BitArray bitArray2 = new BitArray(i14);
            for (int i16 = 0; i16 < (i15 + 1) / 2; i16++) {
                bitArray = bitMatrix.h(i16, bitArray);
                int i17 = (i15 - 1) - i16;
                bitArray2 = bitMatrix.h(i17, bitArray2);
                bitArray.i();
                bitArray2.i();
                int[] iArr = bitArray2.j;
                int[] iArr2 = bitMatrix.m;
                int i18 = bitMatrix.l;
                System.arraycopy(iArr, 0, iArr2, i16 * i18, i18);
                int[] iArr3 = bitArray.j;
                int[] iArr4 = bitMatrix.m;
                int i19 = bitMatrix.l;
                System.arraycopy(iArr3, 0, iArr4, i17 * i19, i19);
            }
            listA = Detector3.a(false, bitMatrix);
            bitMatrixA = bitMatrix;
        }
        Iterator<ResultPoint[]> it3 = listA.iterator();
        while (it3.hasNext()) {
            ResultPoint[] next = it3.next();
            ResultPoint resultPoint = next[4];
            ResultPoint resultPoint2 = next[5];
            ResultPoint resultPoint3 = next[6];
            ResultPoint resultPoint4 = next[7];
            int iMin = Math.min(Math.min(c(next[c], next[4]), (c(next[6], next[i13]) * 17) / 18), Math.min(c(next[1], next[5]), (c(next[7], next[3]) * 17) / 18));
            int iMax = Math.max(Math.max(b(next[c], next[4]), (b(next[6], next[i13]) * 17) / 18), Math.max(b(next[1], next[5]), (b(next[7], next[3]) * 17) / 18));
            ErrorCorrection errorCorrection = PDF417ScanningDecoder.a;
            BoundingBox boundingBox5 = new BoundingBox(bitMatrixA, resultPoint, resultPoint2, resultPoint3, resultPoint4);
            DetectionResult detectionResult2 = null;
            DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumnD = null;
            DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumnD2 = null;
            int i20 = 0;
            while (i20 < i13) {
                if (resultPoint != null) {
                    i12 = i20;
                    boundingBox4 = boundingBox5;
                    detectionResultRowIndicatorColumnD = PDF417ScanningDecoder.d(bitMatrixA, boundingBox5, resultPoint, true, iMin, iMax);
                } else {
                    i12 = i20;
                    boundingBox4 = boundingBox5;
                }
                DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = detectionResultRowIndicatorColumnD;
                if (resultPoint3 != null) {
                    detectionResultRowIndicatorColumnD2 = PDF417ScanningDecoder.d(bitMatrixA, boundingBox4, resultPoint3, false, iMin, iMax);
                }
                if (detectionResultRowIndicatorColumn != null || detectionResultRowIndicatorColumnD2 != null) {
                    if (detectionResultRowIndicatorColumn == null || (barcodeMetadataC = detectionResultRowIndicatorColumn.c()) == null) {
                        barcodeMetadataC = detectionResultRowIndicatorColumnD2 == null ? null : detectionResultRowIndicatorColumnD2.c();
                        if (barcodeMetadataC != null) {
                            detectionResult2 = null;
                        } else {
                            BoundingBox boundingBoxA = PDF417ScanningDecoder.a(detectionResultRowIndicatorColumn);
                            BoundingBox boundingBoxA2 = PDF417ScanningDecoder.a(detectionResultRowIndicatorColumnD2);
                            if (boundingBoxA == null) {
                                boundingBoxA = boundingBoxA2;
                            } else if (boundingBoxA2 != null) {
                                boundingBoxA = new BoundingBox(boundingBoxA.a, boundingBoxA.f1877b, boundingBoxA.c, boundingBoxA2.d, boundingBoxA2.e);
                            }
                            detectionResult2 = new DetectionResult(barcodeMetadataC, boundingBoxA);
                        }
                        if (detectionResult2 != null) {
                            throw NotFoundException.l;
                        }
                        if (i12 != 0 || (boundingBox5 = detectionResult2.c) == null) {
                            boundingBox = boundingBox4;
                            detectionResult2.c = boundingBox;
                            detectionResult = detectionResult2;
                            detectionResultRowIndicatorColumnD = detectionResultRowIndicatorColumn;
                            break;
                        }
                        boundingBox = boundingBox4;
                        if (boundingBox5.h >= boundingBox.h && boundingBox5.i <= boundingBox.i) {
                            detectionResult2.c = boundingBox;
                            detectionResult = detectionResult2;
                            detectionResultRowIndicatorColumnD = detectionResultRowIndicatorColumn;
                            break;
                        }
                        i20 = i12 + 1;
                        detectionResultRowIndicatorColumnD = detectionResultRowIndicatorColumn;
                        i13 = 2;
                    } else {
                        if (detectionResultRowIndicatorColumnD2 != null && (barcodeMetadataC2 = detectionResultRowIndicatorColumnD2.c()) != null && barcodeMetadataC.a != barcodeMetadataC2.a && barcodeMetadataC.f1876b != barcodeMetadataC2.f1876b && barcodeMetadataC.e != barcodeMetadataC2.e) {
                        }
                        if (barcodeMetadataC != null) {
                        }
                        if (detectionResult2 != null) {
                        }
                    }
                }
            }
            boundingBox = boundingBox5;
            detectionResult = detectionResult2;
            int i21 = detectionResult.d + 1;
            DetectionResultColumn[] detectionResultColumnArr = detectionResult.f1880b;
            detectionResultColumnArr[c] = detectionResultRowIndicatorColumnD;
            detectionResultColumnArr[i21] = detectionResultRowIndicatorColumnD2;
            boolean z3 = detectionResultRowIndicatorColumnD != null;
            int i22 = iMin;
            int i23 = 1;
            while (i23 <= i21) {
                int i24 = z3 ? i23 : i21 - i23;
                if (detectionResult.f1880b[i24] == null) {
                    DetectionResultColumn detectionResultRowIndicatorColumn2 = (i24 == 0 || i24 == i21) ? new DetectionResultRowIndicatorColumn(boundingBox, i24 == 0) : new DetectionResultColumn(boundingBox);
                    detectionResult.f1880b[i24] = detectionResultRowIndicatorColumn2;
                    int i25 = boundingBox.h;
                    int i26 = i22;
                    int iMax2 = iMax;
                    int i27 = -1;
                    while (i25 <= boundingBox.i) {
                        int i28 = z3 ? 1 : -1;
                        int i29 = i24 - i28;
                        if (PDF417ScanningDecoder.e(detectionResult, i29)) {
                            it2 = it3;
                            DetectionResultColumn detectionResultColumn2 = detectionResult.f1880b[i29];
                            i4 = iMax2;
                            codeword = detectionResultColumn2.f1881b[i25 - detectionResultColumn2.a.h];
                        } else {
                            it2 = it3;
                            i4 = iMax2;
                            codeword = null;
                        }
                        if (codeword != null) {
                            i6 = z3 ? codeword.f1878b : codeword.a;
                        } else {
                            Codeword codewordA = detectionResult.f1880b[i24].a(i25);
                            if (codewordA != null) {
                                i6 = z3 ? codewordA.a : codewordA.f1878b;
                            } else {
                                if (PDF417ScanningDecoder.e(detectionResult, i29)) {
                                    codewordA = detectionResult.f1880b[i29].a(i25);
                                }
                                if (codewordA != null) {
                                    i6 = z3 ? codewordA.f1878b : codewordA.a;
                                } else {
                                    int i30 = i24;
                                    int i31 = 0;
                                    while (true) {
                                        int i32 = i30 - i28;
                                        if (PDF417ScanningDecoder.e(detectionResult, i32)) {
                                            Codeword[] codewordArr = detectionResult.f1880b[i32].f1881b;
                                            int length = codewordArr.length;
                                            i5 = i25;
                                            int i33 = 0;
                                            while (i33 < length) {
                                                int i34 = length;
                                                Codeword codeword2 = codewordArr[i33];
                                                if (codeword2 != null) {
                                                    i6 = ((codeword2.f1878b - codeword2.a) * i28 * i31) + (z3 ? codeword2.f1878b : codeword2.a);
                                                } else {
                                                    i33++;
                                                    length = i34;
                                                }
                                            }
                                            i31++;
                                            i30 = i32;
                                            i25 = i5;
                                        } else {
                                            i5 = i25;
                                            i6 = z3 ? detectionResult.c.f : detectionResult.c.g;
                                        }
                                    }
                                    if (i6 < 0 && i6 <= boundingBox.g) {
                                        i11 = i6;
                                    } else if (i27 == -1) {
                                        i11 = i27;
                                    } else {
                                        i7 = i26;
                                        detectionResultColumn = detectionResultRowIndicatorColumn2;
                                        i8 = i24;
                                        i9 = i21;
                                        iMax2 = i4;
                                        i10 = i5;
                                        boundingBox3 = boundingBox;
                                        i26 = i7;
                                        i25 = i10 + 1;
                                        detectionResultRowIndicatorColumn2 = detectionResultColumn;
                                        it3 = it2;
                                        boundingBox = boundingBox3;
                                        i24 = i8;
                                        i21 = i9;
                                    }
                                    int i35 = i4;
                                    i10 = i5;
                                    int i36 = i26;
                                    boundingBox3 = boundingBox;
                                    i8 = i24;
                                    detectionResultColumn = detectionResultRowIndicatorColumn2;
                                    i9 = i21;
                                    Codeword codewordC = PDF417ScanningDecoder.c(bitMatrixA, boundingBox.f, boundingBox.g, z3, i11, i10, i36, i35);
                                    if (codewordC != null) {
                                        detectionResultColumn.f1881b[i10 - detectionResultColumn.a.h] = codewordC;
                                        int iMin2 = Math.min(i36, codewordC.f1878b - codewordC.a);
                                        iMax2 = Math.max(i35, codewordC.f1878b - codewordC.a);
                                        i26 = iMin2;
                                        i27 = i11;
                                        i25 = i10 + 1;
                                        detectionResultRowIndicatorColumn2 = detectionResultColumn;
                                        it3 = it2;
                                        boundingBox = boundingBox3;
                                        i24 = i8;
                                        i21 = i9;
                                    } else {
                                        iMax2 = i35;
                                        i7 = i36;
                                        i26 = i7;
                                        i25 = i10 + 1;
                                        detectionResultRowIndicatorColumn2 = detectionResultColumn;
                                        it3 = it2;
                                        boundingBox = boundingBox3;
                                        i24 = i8;
                                        i21 = i9;
                                    }
                                }
                            }
                        }
                        i5 = i25;
                        if (i6 < 0) {
                            if (i27 == -1) {
                            }
                        }
                        i25 = i10 + 1;
                        detectionResultRowIndicatorColumn2 = detectionResultColumn;
                        it3 = it2;
                        boundingBox = boundingBox3;
                        i24 = i8;
                        i21 = i9;
                    }
                    it = it3;
                    boundingBox2 = boundingBox;
                    i3 = i21;
                    iMax = iMax2;
                    i22 = i26;
                } else {
                    it = it3;
                    boundingBox2 = boundingBox;
                    i3 = i21;
                }
                i23++;
                it3 = it;
                boundingBox = boundingBox2;
                i21 = i3;
            }
            Iterator<ResultPoint[]> it4 = it3;
            BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance((Class<?>) BarcodeValue.class, detectionResult.a.e, detectionResult.d + 2);
            for (int i37 = 0; i37 < barcodeValueArr.length; i37++) {
                for (int i38 = 0; i38 < barcodeValueArr[i37].length; i38++) {
                    barcodeValueArr[i37][i38] = new BarcodeValue();
                }
            }
            char c2 = 0;
            detectionResult.a(detectionResult.f1880b[0]);
            int i39 = 1;
            detectionResult.a(detectionResult.f1880b[detectionResult.d + 1]);
            int i40 = 928;
            while (true) {
                DetectionResultColumn[] detectionResultColumnArr2 = detectionResult.f1880b;
                if (detectionResultColumnArr2[c2] != null) {
                    int i41 = detectionResult.d + i39;
                    if (detectionResultColumnArr2[i41] != null) {
                        Codeword[] codewordArr2 = detectionResultColumnArr2[c2].f1881b;
                        Codeword[] codewordArr3 = detectionResultColumnArr2[i41].f1881b;
                        for (int i42 = 0; i42 < codewordArr2.length; i42++) {
                            if (codewordArr2[i42] != null && codewordArr3[i42] != null && codewordArr2[i42].e == codewordArr3[i42].e) {
                                for (int i43 = 1; i43 <= detectionResult.d; i43++) {
                                    Codeword codeword3 = detectionResult.f1880b[i43].f1881b[i42];
                                    if (codeword3 != null) {
                                        codeword3.e = codewordArr2[i42].e;
                                        if (!codeword3.a()) {
                                            detectionResult.f1880b[i43].f1881b[i42] = null;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                DetectionResultColumn[] detectionResultColumnArr3 = detectionResult.f1880b;
                int i44 = 0;
                if (detectionResultColumnArr3[0] != null) {
                    Codeword[] codewordArr4 = detectionResultColumnArr3[0].f1881b;
                    int i45 = 0;
                    for (int i46 = 0; i46 < codewordArr4.length; i46++) {
                        if (codewordArr4[i46] != null) {
                            int i47 = codewordArr4[i46].e;
                            int i48 = i45;
                            int iB = 0;
                            for (int i49 = 1; i49 < detectionResult.d + 1 && iB < 2; i49++) {
                                Codeword codeword4 = detectionResult.f1880b[i49].f1881b[i46];
                                if (codeword4 != null) {
                                    iB = DetectionResult.b(i47, iB, codeword4);
                                    if (!codeword4.a()) {
                                        i48++;
                                    }
                                }
                            }
                            i45 = i48;
                        }
                    }
                    i44 = i45;
                }
                DetectionResultColumn[] detectionResultColumnArr4 = detectionResult.f1880b;
                int i50 = detectionResult.d + 1;
                if (detectionResultColumnArr4[i50] == null) {
                    i = 0;
                } else {
                    Codeword[] codewordArr5 = detectionResultColumnArr4[i50].f1881b;
                    i = 0;
                    for (int i51 = 0; i51 < codewordArr5.length; i51++) {
                        if (codewordArr5[i51] != null) {
                            int i52 = codewordArr5[i51].e;
                            int i53 = i;
                            int iB2 = 0;
                            for (int i54 = detectionResult.d + 1; i54 > 0 && iB2 < 2; i54--) {
                                Codeword codeword5 = detectionResult.f1880b[i54].f1881b[i51];
                                if (codeword5 != null) {
                                    iB2 = DetectionResult.b(i52, iB2, codeword5);
                                    if (!codeword5.a()) {
                                        i53++;
                                    }
                                }
                            }
                            i = i53;
                        }
                    }
                }
                int i55 = i44 + i;
                if (i55 == 0) {
                    i55 = 0;
                } else {
                    for (int i56 = 1; i56 < detectionResult.d + 1; i56++) {
                        Codeword[] codewordArr6 = detectionResult.f1880b[i56].f1881b;
                        for (int i57 = 0; i57 < codewordArr6.length; i57++) {
                            if (codewordArr6[i57] != null && !codewordArr6[i57].a()) {
                                Codeword codeword6 = codewordArr6[i57];
                                DetectionResultColumn[] detectionResultColumnArr5 = detectionResult.f1880b;
                                Codeword[] codewordArr7 = detectionResultColumnArr5[i56 - 1].f1881b;
                                int i58 = i56 + 1;
                                Codeword[] codewordArr8 = detectionResultColumnArr5[i58] != null ? detectionResultColumnArr5[i58].f1881b : codewordArr7;
                                Codeword[] codewordArr9 = new Codeword[14];
                                codewordArr9[2] = codewordArr7[i57];
                                codewordArr9[3] = codewordArr8[i57];
                                if (i57 > 0) {
                                    int i59 = i57 - 1;
                                    codewordArr9[0] = codewordArr6[i59];
                                    codewordArr9[4] = codewordArr7[i59];
                                    codewordArr9[5] = codewordArr8[i59];
                                }
                                if (i57 > 1) {
                                    int i60 = i57 - 2;
                                    codewordArr9[8] = codewordArr6[i60];
                                    codewordArr9[10] = codewordArr7[i60];
                                    codewordArr9[11] = codewordArr8[i60];
                                }
                                if (i57 < codewordArr6.length - 1) {
                                    int i61 = i57 + 1;
                                    codewordArr9[1] = codewordArr6[i61];
                                    codewordArr9[6] = codewordArr7[i61];
                                    codewordArr9[7] = codewordArr8[i61];
                                }
                                if (i57 < codewordArr6.length - 2) {
                                    int i62 = i57 + 2;
                                    codewordArr9[9] = codewordArr6[i62];
                                    codewordArr9[12] = codewordArr7[i62];
                                    codewordArr9[13] = codewordArr8[i62];
                                }
                                int i63 = 0;
                                for (int i64 = 14; i63 < i64; i64 = 14) {
                                    Codeword codeword7 = codewordArr9[i63];
                                    if (codeword7 != null && codeword7.a() && codeword7.c == codeword6.c) {
                                        codeword6.e = codeword7.e;
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        break;
                                    }
                                    i63++;
                                }
                            }
                        }
                    }
                }
                if (i55 <= 0 || i55 >= i40) {
                    break;
                }
                i40 = i55;
                c2 = 0;
                i39 = 1;
            }
            int i65 = 0;
            for (DetectionResultColumn detectionResultColumn3 : detectionResult.f1880b) {
                if (detectionResultColumn3 != null) {
                    for (Codeword codeword8 : detectionResultColumn3.f1881b) {
                        if (codeword8 != null && (i2 = codeword8.e) >= 0 && i2 < barcodeValueArr.length) {
                            barcodeValueArr[i2][i65].b(codeword8.d);
                        }
                    }
                }
                i65++;
            }
            BarcodeValue barcodeValue = barcodeValueArr[0][1];
            int[] iArrA = barcodeValue.a();
            int i66 = detectionResult.d;
            BarcodeMetadata barcodeMetadata = detectionResult.a;
            int i67 = (i66 * barcodeMetadata.e) - (2 << barcodeMetadata.f1876b);
            if (iArrA.length == 0) {
                if (i67 <= 0 || i67 > 928) {
                    throw NotFoundException.l;
                }
                barcodeValue.b(i67);
            } else if (iArrA[0] != i67) {
                barcodeValue.b(i67);
            }
            ArrayList arrayList2 = new ArrayList();
            int[] iArr5 = new int[detectionResult.a.e * detectionResult.d];
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (int i68 = 0; i68 < detectionResult.a.e; i68++) {
                int i69 = 0;
                while (i69 < detectionResult.d) {
                    int i70 = i69 + 1;
                    int[] iArrA2 = barcodeValueArr[i68][i70].a();
                    int i71 = (detectionResult.d * i68) + i69;
                    if (iArrA2.length == 0) {
                        arrayList2.add(Integer.valueOf(i71));
                    } else if (iArrA2.length == 1) {
                        iArr5[i71] = iArrA2[0];
                    } else {
                        arrayList4.add(Integer.valueOf(i71));
                        arrayList3.add(iArrA2);
                    }
                    i69 = i70;
                }
            }
            int size = arrayList3.size();
            int[][] iArr6 = new int[size][];
            for (int i72 = 0; i72 < size; i72++) {
                iArr6[i72] = (int[]) arrayList3.get(i72);
            }
            int i73 = detectionResult.a.f1876b;
            int[] iArrB = PDF417Common.b(arrayList2);
            int[] iArrB2 = PDF417Common.b(arrayList4);
            int length2 = iArrB2.length;
            int[] iArr7 = new int[length2];
            int i74 = 100;
            while (true) {
                int i75 = i74 - 1;
                if (i74 <= 0) {
                    throw ChecksumException.a();
                }
                for (int i76 = 0; i76 < length2; i76++) {
                    iArr5[iArrB2[i76]] = iArr6[i76][iArr7[i76]];
                }
                try {
                    DecoderResult decoderResultB = PDF417ScanningDecoder.b(iArr5, i73, iArrB);
                    break;
                } catch (ChecksumException unused) {
                    if (length2 == 0) {
                        throw ChecksumException.a();
                    }
                    int i77 = 0;
                    while (true) {
                        if (i77 >= length2) {
                            break;
                        }
                        if (iArr7[i77] < iArr6[i77].length - 1) {
                            iArr7[i77] = iArr7[i77] + 1;
                            break;
                        }
                        iArr7[i77] = 0;
                        if (i77 == length2 - 1) {
                            throw ChecksumException.a();
                        }
                        i77++;
                    }
                    i74 = i75;
                }
            }
        }
        Result[] resultArr = (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        if (resultArr == null || resultArr.length == 0 || resultArr[0] == null) {
            throw NotFoundException.l;
        }
        return resultArr[0];
    }

    @Override // b.i.e.Reader
    public void reset() {
    }
}
