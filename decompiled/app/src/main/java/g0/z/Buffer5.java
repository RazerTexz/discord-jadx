package g0.z;

import d0.g0.Charsets2;
import d0.z.d.Intrinsics3;
import g0.Buffer3;
import g0.Options2;
import g0.Segment2;
import java.io.EOFException;

/* compiled from: Buffer.kt */
/* renamed from: g0.z.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class Buffer5 {
    public static final byte[] a;

    static {
        Intrinsics3.checkParameterIsNotNull("0123456789abcdef", "$this$asUtf8ToByteArray");
        byte[] bytes = "0123456789abcdef".getBytes(Charsets2.a);
        Intrinsics3.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        a = bytes;
    }

    public static final String a(Buffer3 buffer3, long j) throws EOFException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "$this$readUtf8Line");
        if (j > 0) {
            long j2 = j - 1;
            if (buffer3.q(j2) == ((byte) 13)) {
                String strH = buffer3.H(j2);
                buffer3.skip(2L);
                return strH;
            }
        }
        String strH2 = buffer3.H(j);
        buffer3.skip(1L);
        return strH2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        if (r19 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0061, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int b(Buffer3 buffer3, Options2 options2, boolean z2) {
        int i;
        int i2;
        int i3;
        int i4;
        Segment2 segment2;
        Intrinsics3.checkParameterIsNotNull(buffer3, "$this$selectPrefix");
        Intrinsics3.checkParameterIsNotNull(options2, "options");
        Segment2 segment22 = buffer3.j;
        if (segment22 == null) {
            return z2 ? -2 : -1;
        }
        byte[] bArr = segment22.a;
        int i5 = segment22.f3693b;
        int i6 = segment22.c;
        int[] iArr = options2.m;
        Segment2 segment23 = segment22;
        int i7 = 0;
        int i8 = -1;
        loop0: while (true) {
            int i9 = i7 + 1;
            int i10 = iArr[i7];
            int i11 = i9 + 1;
            int i12 = iArr[i9];
            if (i12 != -1) {
                i8 = i12;
            }
            if (segment23 == null) {
                break;
            }
            if (i10 >= 0) {
                i = i5 + 1;
                int i13 = bArr[i5] & 255;
                int i14 = i11 + i10;
                while (i11 != i14) {
                    if (i13 == iArr[i11]) {
                        i2 = iArr[i11 + i10];
                        if (i == i6) {
                            segment23 = segment23.f;
                            if (segment23 == null) {
                                Intrinsics3.throwNpe();
                            }
                            i = segment23.f3693b;
                            bArr = segment23.a;
                            i6 = segment23.c;
                            if (segment23 == segment22) {
                                segment23 = null;
                            }
                        }
                    } else {
                        i11++;
                    }
                }
                return i8;
            }
            int i15 = (i10 * (-1)) + i11;
            while (true) {
                int i16 = i5 + 1;
                int i17 = i11 + 1;
                if ((bArr[i5] & 255) != iArr[i11]) {
                    return i8;
                }
                boolean z3 = i17 == i15;
                if (i16 == i6) {
                    if (segment23 == null) {
                        Intrinsics3.throwNpe();
                    }
                    Segment2 segment24 = segment23.f;
                    if (segment24 == null) {
                        Intrinsics3.throwNpe();
                    }
                    i4 = segment24.f3693b;
                    byte[] bArr2 = segment24.a;
                    i3 = segment24.c;
                    if (segment24 != segment22) {
                        segment2 = segment24;
                        bArr = bArr2;
                    } else {
                        if (!z3) {
                            break loop0;
                        }
                        bArr = bArr2;
                        segment2 = null;
                    }
                } else {
                    Segment2 segment25 = segment23;
                    i3 = i6;
                    i4 = i16;
                    segment2 = segment25;
                }
                if (z3) {
                    i2 = iArr[i17];
                    i = i4;
                    i6 = i3;
                    segment23 = segment2;
                    break;
                }
                i5 = i4;
                i6 = i3;
                i11 = i17;
                segment23 = segment2;
            }
            if (i2 >= 0) {
                return i2;
            }
            i7 = -i2;
            i5 = i;
        }
    }
}
