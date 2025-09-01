package b.i.e.q;

import b.i.e.BarcodeFormat;
import b.i.e.ResultMetadataType;
import b.i.e.ResultPoint;
import b.i.e.n.BitArray;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.EnumMap;

/* compiled from: UPCEANExtension5Support.java */
/* renamed from: b.i.e.q.n, reason: use source file name */
/* loaded from: classes3.dex */
public final class UPCEANExtension5Support {
    public static final int[] a = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: b, reason: collision with root package name */
    public final int[] f1859b = new int[4];
    public final StringBuilder c = new StringBuilder();

    /* JADX WARN: Removed duplicated region for block: B:67:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result a(int i, BitArray bitArray, int[] iArr) throws NotFoundException, NumberFormatException {
        EnumMap enumMap;
        String str;
        String str2;
        StringBuilder sb = this.c;
        sb.setLength(0);
        int[] iArr2 = this.f1859b;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = bitArray.k;
        int iG = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 5 && iG < i2; i4++) {
            int iH = UPCEANReader.h(bitArray, iArr2, iG, UPCEANReader.d);
            sb.append((char) ((iH % 10) + 48));
            for (int i5 : iArr2) {
                iG += i5;
            }
            if (iH >= 10) {
                i3 |= 1 << (4 - i4);
            }
            if (i4 != 4) {
                iG = bitArray.g(bitArray.f(iG));
            }
        }
        if (sb.length() != 5) {
            throw NotFoundException.l;
        }
        for (int i6 = 0; i6 < 10; i6++) {
            if (i3 == a[i6]) {
                int length = sb.toString().length();
                int iCharAt = 0;
                for (int i7 = length - 2; i7 >= 0; i7 -= 2) {
                    iCharAt += r4.charAt(i7) - '0';
                }
                int iCharAt2 = iCharAt * 3;
                for (int i8 = length - 1; i8 >= 0; i8 -= 2) {
                    iCharAt2 += r4.charAt(i8) - '0';
                }
                if ((iCharAt2 * 3) % 10 != i6) {
                    throw NotFoundException.l;
                }
                String string = sb.toString();
                if (string.length() == 5) {
                    char cCharAt = string.charAt(0);
                    if (cCharAt == '0') {
                        str = "£";
                    } else if (cCharAt != '5') {
                        if (cCharAt == '9') {
                            switch (string) {
                                case "90000":
                                    str2 = null;
                                    break;
                                case "99990":
                                    str2 = "Used";
                                    break;
                                case "99991":
                                    str2 = "0.00";
                                    break;
                            }
                            if (str2 != null) {
                                enumMap = null;
                            } else {
                                enumMap = new EnumMap(ResultMetadataType.class);
                                enumMap.put((EnumMap) ResultMetadataType.SUGGESTED_PRICE, (ResultMetadataType) str2);
                            }
                        }
                        str = "";
                    } else {
                        str = "$";
                    }
                    int i9 = Integer.parseInt(string.substring(1));
                    String strValueOf = String.valueOf(i9 / 100);
                    int i10 = i9 % 100;
                    str2 = str + strValueOf + '.' + (i10 < 10 ? "0".concat(String.valueOf(i10)) : String.valueOf(i10));
                    if (str2 != null) {
                    }
                }
                float f = i;
                Result result = new Result(string, null, new ResultPoint[]{new ResultPoint((iArr[0] + iArr[1]) / 2.0f, f), new ResultPoint(iG, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
                if (enumMap != null) {
                    result.a(enumMap);
                }
                return result;
            }
        }
        throw NotFoundException.l;
    }
}
