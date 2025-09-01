package b.i.e.o.b;

import b.i.e.n.BitMatrix;
import b.i.e.n.BitSource;
import b.i.e.n.DecoderResult;
import b.i.e.n.l.GenericGF;
import b.i.e.n.l.ReedSolomonDecoder;
import b.i.e.o.b.Version2;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* compiled from: Decoder.java */
/* renamed from: b.i.e.o.b.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class Decoder3 {
    public final ReedSolomonDecoder a = new ReedSolomonDecoder(GenericGF.f);

    /* JADX WARN: Code restructure failed: missing block: B:234:0x03ae, code lost:
    
        r5 = r7;
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x03bf, code lost:
    
        throw com.google.zxing.FormatException.a();
     */
    /* JADX WARN: Removed duplicated region for block: B:440:0x065a  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0666 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:503:0x04fe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:504:? A[LOOP:15: B:201:0x0348->B:504:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DecoderResult a(BitMatrix bitMatrix) throws ChecksumException, FormatException {
        int iB;
        boolean z2;
        int iB2;
        int iB3;
        int i;
        BitMatrixParser bitMatrixParser = new BitMatrixParser(bitMatrix);
        Version2 version2 = bitMatrixParser.c;
        int i2 = version2.h;
        byte[] bArr = new byte[i2];
        BitMatrix bitMatrix2 = bitMatrixParser.a;
        int i3 = bitMatrix2.k;
        int i4 = bitMatrix2.j;
        int i5 = 0;
        int i6 = 4;
        int i7 = 0;
        boolean z3 = false;
        int i8 = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            if (i6 == i3 && i7 == 0 && !z3) {
                int i9 = i8 + 1;
                int i10 = i3 - 1;
                int i11 = (bitMatrixParser.a(i10, i5, i3, i4) ? 1 : 0) << 1;
                if (bitMatrixParser.a(i10, 1, i3, i4)) {
                    i11 |= 1;
                }
                int i12 = i11 << 1;
                if (bitMatrixParser.a(i10, 2, i3, i4)) {
                    i12 |= 1;
                }
                int i13 = i12 << 1;
                if (bitMatrixParser.a(0, i4 - 2, i3, i4)) {
                    i13 |= 1;
                }
                int i14 = i13 << 1;
                int i15 = i4 - 1;
                if (bitMatrixParser.a(0, i15, i3, i4)) {
                    i14 |= 1;
                }
                int i16 = i14 << 1;
                if (bitMatrixParser.a(1, i15, i3, i4)) {
                    i16 |= 1;
                }
                int i17 = i16 << 1;
                if (bitMatrixParser.a(2, i15, i3, i4)) {
                    i17 |= 1;
                }
                int i18 = i17 << 1;
                if (bitMatrixParser.a(3, i15, i3, i4)) {
                    i18 |= 1;
                }
                bArr[i8] = (byte) i18;
                i6 -= 2;
                i7 += 2;
                i8 = i9;
                z3 = true;
            } else {
                int i19 = i3 - 2;
                if (i6 == i19 && i7 == 0 && (i4 & 3) != 0 && !z4) {
                    int i20 = i8 + 1;
                    int i21 = (bitMatrixParser.a(i3 + (-3), 0, i3, i4) ? 1 : 0) << 1;
                    if (bitMatrixParser.a(i19, 0, i3, i4)) {
                        i21 |= 1;
                    }
                    int i22 = i21 << 1;
                    if (bitMatrixParser.a(i3 - 1, 0, i3, i4)) {
                        i22 |= 1;
                    }
                    int i23 = i22 << 1;
                    if (bitMatrixParser.a(0, i4 - 4, i3, i4)) {
                        i23 |= 1;
                    }
                    int i24 = i23 << 1;
                    if (bitMatrixParser.a(0, i4 - 3, i3, i4)) {
                        i24 |= 1;
                    }
                    int i25 = i24 << 1;
                    if (bitMatrixParser.a(0, i4 - 2, i3, i4)) {
                        i25 |= 1;
                    }
                    int i26 = i25 << 1;
                    int i27 = i4 - 1;
                    if (bitMatrixParser.a(0, i27, i3, i4)) {
                        i26 |= 1;
                    }
                    int i28 = i26 << 1;
                    if (bitMatrixParser.a(1, i27, i3, i4)) {
                        i28 |= 1;
                    }
                    bArr[i8] = (byte) i28;
                    i6 -= 2;
                    i7 += 2;
                    i8 = i20;
                    z4 = true;
                } else if (i6 == i3 + 4 && i7 == 2 && (i4 & 7) == 0 && !z5) {
                    int i29 = i8 + 1;
                    int i30 = i3 - 1;
                    int i31 = (bitMatrixParser.a(i30, 0, i3, i4) ? 1 : 0) << 1;
                    int i32 = i4 - 1;
                    if (bitMatrixParser.a(i30, i32, i3, i4)) {
                        i31 |= 1;
                    }
                    int i33 = i31 << 1;
                    int i34 = i4 - 3;
                    if (bitMatrixParser.a(0, i34, i3, i4)) {
                        i33 |= 1;
                    }
                    int i35 = i33 << 1;
                    int i36 = i4 - 2;
                    boolean z7 = z3;
                    if (bitMatrixParser.a(0, i36, i3, i4)) {
                        i35 |= 1;
                    }
                    boolean z8 = z4;
                    int i37 = i35 << 1;
                    if (bitMatrixParser.a(0, i32, i3, i4)) {
                        i37 |= 1;
                    }
                    int i38 = i37 << 1;
                    if (bitMatrixParser.a(1, i34, i3, i4)) {
                        i38 |= 1;
                    }
                    int i39 = i38 << 1;
                    if (bitMatrixParser.a(1, i36, i3, i4)) {
                        i39 |= 1;
                    }
                    int i40 = i39 << 1;
                    if (bitMatrixParser.a(1, i32, i3, i4)) {
                        i40 |= 1;
                    }
                    bArr[i8] = (byte) i40;
                    i6 -= 2;
                    i7 += 2;
                    i8 = i29;
                    z3 = z7;
                    z4 = z8;
                    z5 = true;
                } else {
                    boolean z9 = z3;
                    boolean z10 = z4;
                    if (i6 == i19 && i7 == 0 && (i4 & 7) == 4 && !z6) {
                        int i41 = i8 + 1;
                        int i42 = (bitMatrixParser.a(i3 + (-3), 0, i3, i4) ? 1 : 0) << 1;
                        if (bitMatrixParser.a(i19, 0, i3, i4)) {
                            i42 |= 1;
                        }
                        int i43 = i42 << 1;
                        if (bitMatrixParser.a(i3 - 1, 0, i3, i4)) {
                            i43 |= 1;
                        }
                        int i44 = i43 << 1;
                        if (bitMatrixParser.a(0, i4 - 2, i3, i4)) {
                            i44 |= 1;
                        }
                        int i45 = i44 << 1;
                        int i46 = i4 - 1;
                        if (bitMatrixParser.a(0, i46, i3, i4)) {
                            i45 |= 1;
                        }
                        int i47 = i45 << 1;
                        if (bitMatrixParser.a(1, i46, i3, i4)) {
                            i47 |= 1;
                        }
                        int i48 = i47 << 1;
                        if (bitMatrixParser.a(2, i46, i3, i4)) {
                            i48 |= 1;
                        }
                        int i49 = i48 << 1;
                        if (bitMatrixParser.a(3, i46, i3, i4)) {
                            i49 |= 1;
                        }
                        bArr[i8] = (byte) i49;
                        i6 -= 2;
                        i7 += 2;
                        i8 = i41;
                        z3 = z9;
                        z4 = z10;
                        z6 = true;
                    } else {
                        do {
                            if (i6 < i3 && i7 >= 0 && !bitMatrixParser.f1844b.f(i7, i6)) {
                                bArr[i8] = (byte) bitMatrixParser.b(i6, i7, i3, i4);
                                i8++;
                            }
                            i6 -= 2;
                            i7 += 2;
                            if (i6 < 0) {
                                break;
                            }
                        } while (i7 < i4);
                        int i50 = i6 + 1;
                        int i51 = i7 + 3;
                        do {
                            if (i50 >= 0 && i51 < i4 && !bitMatrixParser.f1844b.f(i51, i50)) {
                                bArr[i8] = (byte) bitMatrixParser.b(i50, i51, i3, i4);
                                i8++;
                            }
                            i50 += 2;
                            i51 -= 2;
                            if (i50 >= i3) {
                                break;
                            }
                        } while (i51 >= 0);
                        i6 = i50 + 3;
                        i7 = i51 + 1;
                        z3 = z9;
                        z4 = z10;
                    }
                }
            }
            if (i6 >= i3 && i7 >= i4) {
                break;
            }
            i5 = 0;
        }
        if (i8 != bitMatrixParser.c.h) {
            throw FormatException.a();
        }
        Version2.c cVar = version2.g;
        Version2.b[] bVarArr = cVar.f1849b;
        int i52 = 0;
        for (Version2.b bVar : bVarArr) {
            i52 += bVar.a;
        }
        DataBlock[] dataBlockArr = new DataBlock[i52];
        int i53 = 0;
        for (Version2.b bVar2 : bVarArr) {
            int i54 = 0;
            while (i54 < bVar2.a) {
                int i55 = bVar2.f1848b;
                dataBlockArr[i53] = new DataBlock(i55, new byte[cVar.a + i55]);
                i54++;
                i53++;
            }
        }
        int length = dataBlockArr[0].f1845b.length - cVar.a;
        int i56 = length - 1;
        int i57 = 0;
        for (int i58 = 0; i58 < i56; i58++) {
            int i59 = 0;
            while (i59 < i53) {
                dataBlockArr[i59].f1845b[i58] = bArr[i57];
                i59++;
                i57++;
            }
        }
        boolean z11 = version2.f1847b == 24;
        int i60 = 8;
        int i61 = z11 ? 8 : i53;
        int i62 = 0;
        while (i62 < i61) {
            dataBlockArr[i62].f1845b[i56] = bArr[i57];
            i62++;
            i57++;
        }
        int length2 = dataBlockArr[0].f1845b.length;
        while (length < length2) {
            int i63 = 0;
            while (i63 < i53) {
                int i64 = z11 ? (i63 + 8) % i53 : i63;
                dataBlockArr[i64].f1845b[(!z11 || i64 <= 7) ? length : length - 1] = bArr[i57];
                i63++;
                i57++;
            }
            length++;
        }
        if (i57 != i2) {
            throw new IllegalArgumentException();
        }
        int i65 = 0;
        for (int i66 = 0; i66 < i52; i66++) {
            i65 += dataBlockArr[i66].a;
        }
        byte[] bArr2 = new byte[i65];
        for (int i67 = 0; i67 < i52; i67++) {
            DataBlock dataBlock = dataBlockArr[i67];
            byte[] bArr3 = dataBlock.f1845b;
            int i68 = dataBlock.a;
            int length3 = bArr3.length;
            int[] iArr = new int[length3];
            for (int i69 = 0; i69 < length3; i69++) {
                iArr[i69] = bArr3[i69] & 255;
            }
            try {
                this.a.a(iArr, bArr3.length - i68);
                for (int i70 = 0; i70 < i68; i70++) {
                    bArr3[i70] = (byte) iArr[i70];
                }
                for (int i71 = 0; i71 < i68; i71++) {
                    bArr2[(i71 * i52) + i67] = bArr3[i71];
                }
            } catch (ReedSolomonException unused) {
                throw ChecksumException.a();
            }
        }
        BitSource bitSource = new BitSource(bArr2);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        int i72 = 2;
        while (true) {
            int i73 = 6;
            char c = 29;
            if (i72 == 2) {
                boolean z12 = false;
                while (true) {
                    int iB4 = bitSource.b(i60);
                    if (iB4 == 0) {
                        throw FormatException.a();
                    }
                    if (iB4 <= 128) {
                        if (z12) {
                            iB4 += 128;
                        }
                        sb.append((char) (iB4 - 1));
                    } else if (iB4 == 129) {
                        i73 = 1;
                    } else {
                        if (iB4 > 229) {
                            switch (iB4) {
                                case 230:
                                    i73 = 3;
                                    break;
                                case 231:
                                    i73 = 7;
                                    break;
                                case 232:
                                    sb.append((char) 29);
                                    if (bitSource.a() > 0) {
                                        break;
                                    }
                                case 233:
                                case 234:
                                case 241:
                                    break;
                                case 235:
                                    z12 = true;
                                    if (bitSource.a() > 0) {
                                    }
                                    break;
                                case 236:
                                    sb.append("[)>\u001e05\u001d");
                                    sb2.insert(0, "\u001e\u0004");
                                    if (bitSource.a() > 0) {
                                    }
                                    break;
                                case 237:
                                    sb.append("[)>\u001e06\u001d");
                                    sb2.insert(0, "\u001e\u0004");
                                    if (bitSource.a() > 0) {
                                    }
                                    break;
                                case 238:
                                    i73 = 5;
                                    break;
                                case 239:
                                    i73 = 4;
                                    break;
                                case 240:
                                    break;
                                default:
                                    if (iB4 != 254 || bitSource.a() != 0) {
                                        break;
                                    }
                                    if (bitSource.a() > 0) {
                                    }
                                    break;
                            }
                        } else {
                            int i74 = iB4 - 130;
                            if (i74 < 10) {
                                sb.append('0');
                            }
                            sb.append(i74);
                        }
                        if (bitSource.a() > 0) {
                        }
                    }
                }
            } else {
                int iH = b.c.a.y.b.h(i72);
                if (iH == 2) {
                    int[] iArr2 = new int[3];
                    boolean z13 = false;
                    int i75 = 0;
                    while (bitSource.a() != 8 && (iB = bitSource.b(8)) != 254) {
                        DecodedBitStreamParser.a(iB, bitSource.b(8), iArr2);
                        int i76 = 0;
                        int i77 = 3;
                        while (i76 < i77) {
                            int i78 = iArr2[i76];
                            if (i75 != 0) {
                                if (i75 != 1) {
                                    if (i75 == 2) {
                                        char[] cArr = DecodedBitStreamParser.f1846b;
                                        if (i78 < cArr.length) {
                                            char c2 = cArr[i78];
                                            if (z13) {
                                                sb.append((char) (c2 + 128));
                                                z13 = false;
                                                i75 = 0;
                                                i77 = 3;
                                            } else {
                                                sb.append(c2);
                                                z2 = z13;
                                                z13 = z2;
                                                i75 = 0;
                                                i77 = 3;
                                            }
                                        } else if (i78 == 27) {
                                            sb.append(c);
                                            i75 = 0;
                                            i77 = 3;
                                        } else {
                                            if (i78 != 30) {
                                                throw FormatException.a();
                                            }
                                            z2 = true;
                                            z13 = z2;
                                            i75 = 0;
                                            i77 = 3;
                                        }
                                    } else {
                                        if (i75 != i77) {
                                            throw FormatException.a();
                                        }
                                        if (z13) {
                                            sb.append((char) (i78 + 224));
                                            z13 = false;
                                            i75 = 0;
                                            i77 = 3;
                                        } else {
                                            sb.append((char) (i78 + 96));
                                            z2 = z13;
                                            z13 = z2;
                                            i75 = 0;
                                            i77 = 3;
                                        }
                                    }
                                } else if (z13) {
                                    sb.append((char) (i78 + 128));
                                    z13 = false;
                                    i75 = 0;
                                    i77 = 3;
                                } else {
                                    sb.append((char) i78);
                                    i75 = 0;
                                    i77 = 3;
                                }
                            } else if (i78 < i77) {
                                i75 = i78 + 1;
                            } else {
                                char[] cArr2 = DecodedBitStreamParser.a;
                                if (i78 >= cArr2.length) {
                                    throw FormatException.a();
                                }
                                char c3 = cArr2[i78];
                                if (z13) {
                                    sb.append((char) (c3 + 128));
                                    z13 = false;
                                } else {
                                    sb.append(c3);
                                }
                            }
                            i76++;
                            c = 29;
                        }
                        if (bitSource.a() <= 0) {
                            i72 = 2;
                            i = 1;
                            if (i72 != i && bitSource.a() > 0) {
                                i60 = 8;
                            }
                        } else {
                            c = 29;
                        }
                    }
                    i72 = 2;
                    i = 1;
                    if (i72 != i) {
                    }
                } else if (iH == 3) {
                    int i79 = 3;
                    int[] iArr3 = new int[3];
                    int i80 = 0;
                    boolean z14 = false;
                    for (int i81 = 254; bitSource.a() != i60 && (iB2 = bitSource.b(i60)) != i81; i81 = 254) {
                        DecodedBitStreamParser.a(iB2, bitSource.b(i60), iArr3);
                        boolean z15 = z14;
                        int i82 = 0;
                        while (i82 < i79) {
                            int i83 = iArr3[i82];
                            if (i80 != 0) {
                                if (i80 != 1) {
                                    if (i80 == 2) {
                                        char[] cArr3 = DecodedBitStreamParser.d;
                                        if (i83 < cArr3.length) {
                                            char c4 = cArr3[i83];
                                            if (z15) {
                                                sb.append((char) (c4 + 128));
                                                z15 = false;
                                            } else {
                                                sb.append(c4);
                                            }
                                        } else if (i83 == 27) {
                                            sb.append((char) 29);
                                        } else {
                                            if (i83 != 30) {
                                                throw FormatException.a();
                                            }
                                            z15 = true;
                                        }
                                        i80 = 0;
                                    } else {
                                        if (i80 != i79) {
                                            throw FormatException.a();
                                        }
                                        char[] cArr4 = DecodedBitStreamParser.e;
                                        if (i83 >= cArr4.length) {
                                            throw FormatException.a();
                                        }
                                        char c5 = cArr4[i83];
                                        if (z15) {
                                            sb.append((char) (c5 + 128));
                                            z15 = false;
                                            i80 = 0;
                                        } else {
                                            sb.append(c5);
                                            i80 = 0;
                                        }
                                    }
                                } else if (z15) {
                                    sb.append((char) (i83 + 128));
                                    z15 = false;
                                    i80 = 0;
                                } else {
                                    sb.append((char) i83);
                                    i80 = 0;
                                }
                            } else if (i83 < i79) {
                                i80 = i83 + 1;
                            } else {
                                char[] cArr5 = DecodedBitStreamParser.c;
                                if (i83 >= cArr5.length) {
                                    throw FormatException.a();
                                }
                                char c6 = cArr5[i83];
                                if (z15) {
                                    sb.append((char) (c6 + 128));
                                    z15 = false;
                                } else {
                                    sb.append(c6);
                                }
                            }
                            i82++;
                            i79 = 3;
                        }
                        if (bitSource.a() > 0) {
                            z14 = z15;
                            i79 = 3;
                            i60 = 8;
                        }
                    }
                } else if (iH == 4) {
                    int i84 = 3;
                    int[] iArr4 = new int[3];
                    while (bitSource.a() != i60 && (iB3 = bitSource.b(i60)) != 254) {
                        DecodedBitStreamParser.a(iB3, bitSource.b(i60), iArr4);
                        int i85 = 0;
                        while (i85 < i84) {
                            int i86 = iArr4[i85];
                            if (i86 == 0) {
                                sb.append('\r');
                            } else if (i86 == 1) {
                                sb.append('*');
                            } else if (i86 == 2) {
                                sb.append('>');
                            } else if (i86 == i84) {
                                sb.append(' ');
                            } else if (i86 < 14) {
                                sb.append((char) (i86 + 44));
                            } else {
                                if (i86 >= 40) {
                                    throw FormatException.a();
                                }
                                sb.append((char) (i86 + 51));
                            }
                            i85++;
                            i84 = 3;
                        }
                        if (bitSource.a() > 0) {
                            i84 = 3;
                        }
                    }
                } else if (iH == 5) {
                    while (true) {
                        if (bitSource.a() > 16) {
                            int i87 = 0;
                            while (true) {
                                if (i87 < 4) {
                                    int iB5 = bitSource.b(6);
                                    if (iB5 == 31) {
                                        int i88 = 8 - bitSource.c;
                                        if (i88 != i60) {
                                            bitSource.b(i88);
                                        }
                                    } else {
                                        if ((iB5 & 32) == 0) {
                                            iB5 |= 64;
                                        }
                                        sb.append((char) iB5);
                                        i87++;
                                    }
                                } else if (bitSource.a() <= 0) {
                                }
                            }
                        }
                    }
                } else {
                    if (iH != 6) {
                        throw FormatException.a();
                    }
                    int i89 = bitSource.f1830b + 1;
                    int i90 = i89 + 1;
                    int iB6 = DecodedBitStreamParser.b(bitSource.b(i60), i89);
                    if (iB6 == 0) {
                        iB6 = bitSource.a() / i60;
                    } else if (iB6 >= 250) {
                        iB6 = ((iB6 - 249) * 250) + DecodedBitStreamParser.b(bitSource.b(i60), i90);
                        i90++;
                    }
                    if (iB6 < 0) {
                        throw FormatException.a();
                    }
                    byte[] bArr4 = new byte[iB6];
                    int i91 = 0;
                    while (i91 < iB6) {
                        if (bitSource.a() < i60) {
                            throw FormatException.a();
                        }
                        bArr4[i91] = (byte) DecodedBitStreamParser.b(bitSource.b(i60), i90);
                        i91++;
                        i90++;
                    }
                    arrayList.add(bArr4);
                    try {
                        sb.append(new String(bArr4, "ISO8859_1"));
                    } catch (UnsupportedEncodingException e) {
                        throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e)));
                    }
                }
            }
            i72 = 2;
            i = 1;
            if (i72 != i) {
            }
        }
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String string = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new DecoderResult(bArr2, string, arrayList, null);
    }
}
