package b.g.a.b.p;

import b.g.a.b.t.TextBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: JsonStringEncoder.java */
/* renamed from: b.g.a.b.p.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class JsonStringEncoder {
    public static final char[] a = (char[]) CharTypes.a.clone();

    /* renamed from: b, reason: collision with root package name */
    public static final JsonStringEncoder f667b;

    static {
        CharTypes.f664b.clone();
        f667b = new JsonStringEncoder();
    }

    public char[] a(String str) {
        int i;
        char[] cArrE = new char[120];
        int[] iArr = CharTypes.f;
        int length = iArr.length;
        int length2 = str.length();
        TextBuffer textBuffer = null;
        char[] cArr = null;
        int i2 = 0;
        int i3 = 0;
        loop0: while (i2 < length2) {
            do {
                char cCharAt = str.charAt(i2);
                if (cCharAt >= length || iArr[cCharAt] == 0) {
                    if (i3 >= cArrE.length) {
                        if (textBuffer == null) {
                            textBuffer = new TextBuffer(null, cArrE);
                        }
                        cArrE = textBuffer.e();
                        i3 = 0;
                    }
                    cArrE[i3] = cCharAt;
                    i2++;
                    i3++;
                } else {
                    int i4 = 2;
                    if (cArr == null) {
                        cArr = new char[]{'\\', 0, '0', '0', 0, 0};
                    }
                    int i5 = i2 + 1;
                    char cCharAt2 = str.charAt(i2);
                    int i6 = iArr[cCharAt2];
                    if (i6 < 0) {
                        cArr[1] = 'u';
                        char[] cArr2 = a;
                        cArr[4] = cArr2[cCharAt2 >> 4];
                        cArr[5] = cArr2[cCharAt2 & 15];
                        i4 = 6;
                    } else {
                        cArr[1] = (char) i6;
                    }
                    int i7 = i3 + i4;
                    if (i7 > cArrE.length) {
                        int length3 = cArrE.length - i3;
                        if (length3 > 0) {
                            System.arraycopy(cArr, 0, cArrE, i3, length3);
                        }
                        if (textBuffer == null) {
                            textBuffer = new TextBuffer(null, cArrE);
                        }
                        cArrE = textBuffer.e();
                        int i8 = i4 - length3;
                        System.arraycopy(cArr, length3, cArrE, 0, i8);
                        i3 = i8;
                    } else {
                        System.arraycopy(cArr, 0, cArrE, i3, i4);
                        i3 = i7;
                    }
                    i2 = i5;
                }
            } while (i2 < length2);
        }
        if (textBuffer == null) {
            return Arrays.copyOfRange(cArrE, 0, i3);
        }
        textBuffer.h = i3;
        char[] charArray = textBuffer.j;
        if (charArray == null) {
            String str2 = textBuffer.i;
            if (str2 != null) {
                charArray = str2.toCharArray();
            } else {
                int i9 = textBuffer.c;
                if (i9 >= 0) {
                    charArray = TextBuffer.a;
                } else {
                    int length4 = i9 >= 0 ? 0 : charArray != null ? charArray.length : str2 != null ? str2.length() : textBuffer.f + i3;
                    if (length4 < 1) {
                        charArray = TextBuffer.a;
                    } else {
                        charArray = new char[length4];
                        ArrayList<char[]> arrayList = textBuffer.d;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            i = 0;
                            for (int i10 = 0; i10 < size; i10++) {
                                char[] cArr3 = textBuffer.d.get(i10);
                                int length5 = cArr3.length;
                                System.arraycopy(cArr3, 0, charArray, i, length5);
                                i += length5;
                            }
                        } else {
                            i = 0;
                        }
                        System.arraycopy(textBuffer.g, 0, charArray, i, textBuffer.h);
                    }
                }
            }
            textBuffer.j = charArray;
        }
        return charArray;
    }
}
