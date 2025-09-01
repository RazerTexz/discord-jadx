package b.i.e.s.b;

import b.i.e.DecodeHintType;
import b.i.e.n.BitSource;
import b.i.e.n.CharacterSetECI;
import b.i.e.n.StringUtils;
import com.google.zxing.FormatException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* compiled from: DecodedBitStreamParser.java */
/* renamed from: b.i.e.s.b.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class DecodedBitStreamParser4 {
    public static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(BitSource bitSource, StringBuilder sb, int i, boolean z2) throws FormatException {
        while (i > 1) {
            if (bitSource.a() < 11) {
                throw FormatException.a();
            }
            int iB = bitSource.b(11);
            sb.append(f(iB / 45));
            sb.append(f(iB % 45));
            i -= 2;
        }
        if (i == 1) {
            if (bitSource.a() < 6) {
                throw FormatException.a();
            }
            sb.append(f(bitSource.b(6)));
        }
        if (z2) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        } else {
                            sb.setCharAt(length, (char) 29);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2 A[PHI: r10 r20
      0x00a2: PHI (r10v6 int) = (r10v1 int), (r10v5 int), (r10v1 int) binds: [B:37:0x0085, B:45:0x009d, B:32:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r20v6 byte[]) = (r20v5 byte[]), (r20v5 byte[]), (r20v7 byte[]) binds: [B:37:0x0085, B:45:0x009d, B:32:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(BitSource bitSource, StringBuilder sb, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        byte[] bArr;
        String strName;
        byte[] bArr2;
        if ((i << 3) > bitSource.a()) {
            throw FormatException.a();
        }
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            bArr3[i3] = (byte) bitSource.b(8);
        }
        if (characterSetECI == null) {
            String str = StringUtils.a;
            if (map != null) {
                DecodeHintType decodeHintType = DecodeHintType.CHARACTER_SET;
                if (map.containsKey(decodeHintType)) {
                    strName = map.get(decodeHintType).toString();
                    bArr = bArr3;
                } else {
                    boolean z2 = true;
                    boolean z3 = i > 3 && bArr3[0] == -17 && bArr3[1] == -69 && bArr3[2] == -65;
                    int i4 = 0;
                    boolean z4 = true;
                    boolean z5 = true;
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    while (i5 < i && (z2 || z4 || z5)) {
                        int i15 = bArr3[i5] & 255;
                        if (!z5) {
                            bArr2 = bArr3;
                        } else if (i6 > 0) {
                            bArr2 = bArr3;
                            if ((i15 & 128) != 0) {
                                i6--;
                            } else {
                                z5 = false;
                            }
                        } else {
                            bArr2 = bArr3;
                            if ((i15 & 128) != 0) {
                                if ((i15 & 64) != 0) {
                                    i6++;
                                    if ((i15 & 32) == 0) {
                                        i8++;
                                    } else {
                                        i6++;
                                        if ((i15 & 16) == 0) {
                                            i9++;
                                        } else {
                                            i6++;
                                            if ((i15 & 8) == 0) {
                                                i10++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (z2) {
                            if (i15 > 127 && i15 < 160) {
                                z2 = false;
                            } else if (i15 > 159 && (i15 < 192 || i15 == 215 || i15 == 247)) {
                                i12++;
                            }
                        }
                        if (z4) {
                            if (i7 > 0) {
                                if (i15 < 64 || i15 == 127 || i15 > 252) {
                                    z4 = false;
                                } else {
                                    i7--;
                                }
                            } else if (i15 != 128 && i15 != 160 && i15 <= 239) {
                                if (i15 <= 160 || i15 >= 224) {
                                    if (i15 > 127) {
                                        i7++;
                                        int i16 = i13 + 1;
                                        if (i16 > i2) {
                                            i2 = i16;
                                            i13 = i2;
                                        } else {
                                            i13 = i16;
                                        }
                                    } else {
                                        i13 = 0;
                                    }
                                    i14 = 0;
                                } else {
                                    i4++;
                                    int i17 = i14 + 1;
                                    if (i17 > i11) {
                                        i11 = i17;
                                    }
                                    i14 = i17;
                                    i13 = 0;
                                }
                            }
                        }
                        i5++;
                        bArr3 = bArr2;
                    }
                    bArr = bArr3;
                    if (z5 && i6 > 0) {
                        z5 = false;
                    }
                    boolean z6 = (!z4 || i7 <= 0) ? z4 : false;
                    if (!z5 || (!z3 && i8 + i9 + i10 <= 0)) {
                        if (!z6 || (!StringUtils.f1839b && i11 < 3 && i2 < 3)) {
                            if (!z2 || !z6) {
                                strName = z2 ? "ISO8859_1" : z6 ? "SJIS" : z5 ? "UTF8" : StringUtils.a;
                            } else if ((i11 != 2 || i4 != 2) && i12 * 10 < i) {
                            }
                        }
                    }
                }
            }
        } else {
            bArr = bArr3;
            strName = characterSetECI.name();
        }
        try {
            byte[] bArr4 = bArr;
            sb.append(new String(bArr4, strName));
            collection.add(bArr4);
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.a();
        }
    }

    public static void c(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > bitSource.a()) {
            throw FormatException.a();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iB = bitSource.b(13);
            int i3 = (iB % 96) | ((iB / 96) << 8);
            int i4 = i3 + (i3 < 959 ? 41377 : 42657);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.a();
        }
    }

    public static void d(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > bitSource.a()) {
            throw FormatException.a();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iB = bitSource.b(13);
            int i3 = (iB % Opcodes.CHECKCAST) | ((iB / Opcodes.CHECKCAST) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.a();
        }
    }

    public static void e(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        while (i >= 3) {
            if (bitSource.a() < 10) {
                throw FormatException.a();
            }
            int iB = bitSource.b(10);
            if (iB >= 1000) {
                throw FormatException.a();
            }
            sb.append(f(iB / 100));
            sb.append(f((iB / 10) % 10));
            sb.append(f(iB % 10));
            i -= 3;
        }
        if (i == 2) {
            if (bitSource.a() < 7) {
                throw FormatException.a();
            }
            int iB2 = bitSource.b(7);
            if (iB2 >= 100) {
                throw FormatException.a();
            }
            sb.append(f(iB2 / 10));
            sb.append(f(iB2 % 10));
            return;
        }
        if (i == 1) {
            if (bitSource.a() < 4) {
                throw FormatException.a();
            }
            int iB3 = bitSource.b(4);
            if (iB3 >= 10) {
                throw FormatException.a();
            }
            sb.append(f(iB3));
        }
    }

    public static char f(int i) throws FormatException {
        char[] cArr = a;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw FormatException.a();
    }
}
