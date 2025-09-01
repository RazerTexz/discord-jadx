package g0;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import d0.g0.Charsets2;
import d0.t._ArraysJvm;
import d0.z.d.Intrinsics3;
import g0.z.Buffer5;
import g0.z.ByteString4;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;
import okio.BufferedSink;
import okio.ByteString;
import org.objectweb.asm.Opcodes;

/* compiled from: Buffer.kt */
/* renamed from: g0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class Buffer3 implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public Segment2 j;
    public long k;

    /* compiled from: Buffer.kt */
    /* renamed from: g0.e$a */
    public static final class a implements Closeable {
        public Buffer3 j;
        public boolean k;
        public Segment2 l;
        public byte[] n;
        public long m = -1;
        public int o = -1;
        public int p = -1;

        public final long a(long j) {
            Buffer3 buffer3 = this.j;
            if (buffer3 == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.k) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            long j2 = buffer3.k;
            int i = 1;
            if (j <= j2) {
                if (!(j >= 0)) {
                    throw new IllegalArgumentException(outline.t("newSize < 0: ", j).toString());
                }
                long j3 = j2 - j;
                while (true) {
                    if (j3 > 0) {
                        Segment2 segment2 = buffer3.j;
                        if (segment2 == null) {
                            Intrinsics3.throwNpe();
                        }
                        Segment2 segment22 = segment2.g;
                        if (segment22 == null) {
                            Intrinsics3.throwNpe();
                        }
                        int i2 = segment22.c;
                        long j4 = i2 - segment22.f3693b;
                        if (j4 > j3) {
                            segment22.c = i2 - ((int) j3);
                            break;
                        }
                        buffer3.j = segment22.a();
                        SegmentPool.a(segment22);
                        j3 -= j4;
                    } else {
                        break;
                    }
                }
                this.l = null;
                this.m = j;
                this.n = null;
                this.o = -1;
                this.p = -1;
            } else if (j > j2) {
                long j5 = j - j2;
                boolean z2 = true;
                while (j5 > 0) {
                    Segment2 segment2N = buffer3.N(i);
                    int iMin = (int) Math.min(j5, 8192 - segment2N.c);
                    int i3 = segment2N.c + iMin;
                    segment2N.c = i3;
                    j5 -= iMin;
                    if (z2) {
                        this.l = segment2N;
                        this.m = j2;
                        this.n = segment2N.a;
                        this.o = i3 - iMin;
                        this.p = i3;
                        z2 = false;
                    }
                    i = 1;
                }
            }
            buffer3.k = j;
            return j2;
        }

        public final int b(long j) {
            long j2;
            Segment2 segment2;
            Buffer3 buffer3 = this.j;
            if (buffer3 == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (j >= -1) {
                long j3 = buffer3.k;
                if (j <= j3) {
                    if (j == -1 || j == j3) {
                        this.l = null;
                        this.m = j;
                        this.n = null;
                        this.o = -1;
                        this.p = -1;
                        return -1;
                    }
                    Segment2 segment22 = buffer3.j;
                    Segment2 segment23 = this.l;
                    if (segment23 != null) {
                        long j4 = this.m;
                        int i = this.o;
                        if (segment23 == null) {
                            Intrinsics3.throwNpe();
                        }
                        j2 = j4 - (i - segment23.f3693b);
                        if (j2 > j) {
                            segment2 = segment22;
                            segment22 = this.l;
                            j3 = j2;
                            j2 = 0;
                        } else {
                            segment2 = this.l;
                        }
                    } else {
                        j2 = 0;
                        segment2 = segment22;
                    }
                    if (j3 - j > j - j2) {
                        while (true) {
                            if (segment2 == null) {
                                Intrinsics3.throwNpe();
                            }
                            int i2 = segment2.c;
                            int i3 = segment2.f3693b;
                            if (j < (i2 - i3) + j2) {
                                break;
                            }
                            j2 += i2 - i3;
                            segment2 = segment2.f;
                        }
                    } else {
                        while (j3 > j) {
                            if (segment22 == null) {
                                Intrinsics3.throwNpe();
                            }
                            segment22 = segment22.g;
                            if (segment22 == null) {
                                Intrinsics3.throwNpe();
                            }
                            j3 -= segment22.c - segment22.f3693b;
                        }
                        segment2 = segment22;
                        j2 = j3;
                    }
                    if (this.k) {
                        if (segment2 == null) {
                            Intrinsics3.throwNpe();
                        }
                        if (segment2.d) {
                            byte[] bArr = segment2.a;
                            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                            Intrinsics3.checkExpressionValueIsNotNull(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                            Segment2 segment24 = new Segment2(bArrCopyOf, segment2.f3693b, segment2.c, false, true);
                            if (buffer3.j == segment2) {
                                buffer3.j = segment24;
                            }
                            segment2.b(segment24);
                            Segment2 segment25 = segment24.g;
                            if (segment25 == null) {
                                Intrinsics3.throwNpe();
                            }
                            segment25.a();
                            segment2 = segment24;
                        }
                    }
                    this.l = segment2;
                    this.m = j;
                    if (segment2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    this.n = segment2.a;
                    int i4 = segment2.f3693b + ((int) (j - j2));
                    this.o = i4;
                    int i5 = segment2.c;
                    this.p = i5;
                    return i5 - i4;
                }
            }
            String str = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(j), Long.valueOf(buffer3.k)}, 2));
            Intrinsics3.checkExpressionValueIsNotNull(str, "java.lang.String.format(format, *args)");
            throw new ArrayIndexOutOfBoundsException(str);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.j != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.j = null;
            this.l = null;
            this.m = -1L;
            this.n = null;
            this.o = -1;
            this.p = -1;
        }
    }

    public String A(long j, Charset charset) throws EOFException {
        Intrinsics3.checkParameterIsNotNull(charset, "charset");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(outline.t("byteCount: ", j).toString());
        }
        if (this.k < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        Segment2 segment2 = this.j;
        if (segment2 == null) {
            Intrinsics3.throwNpe();
        }
        int i = segment2.f3693b;
        if (i + j > segment2.c) {
            return new String(Z(j), charset);
        }
        int i2 = (int) j;
        String str = new String(segment2.a, i, i2, charset);
        int i3 = segment2.f3693b + i2;
        segment2.f3693b = i3;
        this.k -= j;
        if (i3 == segment2.c) {
            this.j = segment2.a();
            SegmentPool.a(segment2);
        }
        return str;
    }

    @Override // g0.BufferedSource
    public void B(Buffer3 buffer3, long j) throws EOFException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        long j2 = this.k;
        if (j2 >= j) {
            buffer3.write(this, j);
        } else {
            buffer3.write(this, j2);
            throw new EOFException();
        }
    }

    public String D() {
        return A(this.k, Charsets2.a);
    }

    @Override // g0.BufferedSource
    public long E(ByteString byteString) {
        Intrinsics3.checkParameterIsNotNull(byteString, "targetBytes");
        return t(byteString, 0L);
    }

    @Override // okio.BufferedSink
    public BufferedSink F() {
        return this;
    }

    @Override // g0.BufferedSource
    public String G(long j) throws EOFException {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.t("limit < 0: ", j).toString());
        }
        long j2 = RecyclerView.FOREVER_NS;
        if (j != RecyclerView.FOREVER_NS) {
            j2 = j + 1;
        }
        byte b2 = (byte) 10;
        long jS = s(b2, 0L, j2);
        if (jS != -1) {
            return Buffer5.a(this, jS);
        }
        if (j2 < this.k && q(j2 - 1) == ((byte) 13) && q(j2) == b2) {
            return Buffer5.a(this, j2);
        }
        Buffer3 buffer3 = new Buffer3();
        n(buffer3, 0L, Math.min(32, this.k));
        throw new EOFException("\\n not found: limit=" + Math.min(this.k, j) + " content=" + buffer3.x().k() + (char) 8230);
    }

    public String H(long j) throws EOFException {
        return A(j, Charsets2.a);
    }

    public int I() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.k == 0) {
            throw new EOFException();
        }
        byte bQ = q(0L);
        if ((bQ & 128) == 0) {
            i = bQ & 127;
            i2 = 1;
            i3 = 0;
        } else if ((bQ & 224) == 192) {
            i = bQ & 31;
            i2 = 2;
            i3 = 128;
        } else if ((bQ & 240) == 224) {
            i = bQ & 15;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((bQ & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i = bQ & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.k < j) {
            StringBuilder sbV = outline.V("size < ", i2, ": ");
            sbV.append(this.k);
            sbV.append(" (to read code point prefixed 0x");
            sbV.append(b.i.a.f.e.o.f.t1(bQ));
            sbV.append(')');
            throw new EOFException(sbV.toString());
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte bQ2 = q(j2);
            if ((bQ2 & 192) != 128) {
                skip(j2);
                return 65533;
            }
            i = (i << 6) | (bQ2 & 63);
        }
        skip(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((55296 <= i && 57343 >= i) || i < i3) {
            return 65533;
        }
        return i;
    }

    public final ByteString J(int i) {
        if (i == 0) {
            return ByteString.j;
        }
        b.i.a.f.e.o.f.B(this.k, 0L, i);
        Segment2 segment2 = this.j;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            int i5 = segment2.c;
            int i6 = segment2.f3693b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            segment2 = segment2.f;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        Segment2 segment22 = this.j;
        int i7 = 0;
        while (i2 < i) {
            if (segment22 == null) {
                Intrinsics3.throwNpe();
            }
            bArr[i7] = segment22.a;
            i2 += segment22.c - segment22.f3693b;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = segment22.f3693b;
            segment22.d = true;
            i7++;
            segment22 = segment22.f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink K(String str) {
        b0(str);
        return this;
    }

    @Override // g0.BufferedSource
    public String M(Charset charset) {
        Intrinsics3.checkParameterIsNotNull(charset, "charset");
        return A(this.k, charset);
    }

    public final Segment2 N(int i) {
        if (!(i >= 1 && i <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        Segment2 segment2 = this.j;
        if (segment2 == null) {
            Segment2 segment2B = SegmentPool.b();
            this.j = segment2B;
            segment2B.g = segment2B;
            segment2B.f = segment2B;
            return segment2B;
        }
        if (segment2 == null) {
            Intrinsics3.throwNpe();
        }
        Segment2 segment22 = segment2.g;
        if (segment22 == null) {
            Intrinsics3.throwNpe();
        }
        if (segment22.c + i <= 8192 && segment22.e) {
            return segment22;
        }
        Segment2 segment2B2 = SegmentPool.b();
        segment22.b(segment2B2);
        return segment2B2;
    }

    public Buffer3 O(ByteString byteString) {
        Intrinsics3.checkParameterIsNotNull(byteString, "byteString");
        byteString.s(this, 0, byteString.j());
        return this;
    }

    @Override // okio.BufferedSink
    public long P(Source2 source2) throws IOException {
        Intrinsics3.checkParameterIsNotNull(source2, "source");
        long j = 0;
        while (true) {
            long jI0 = source2.i0(this, 8192);
            if (jI0 == -1) {
                return j;
            }
            j += jI0;
        }
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink Q(long j) {
        return V(j);
    }

    public Buffer3 R(byte[] bArr) {
        Intrinsics3.checkParameterIsNotNull(bArr, "source");
        S(bArr, 0, bArr.length);
        return this;
    }

    public Buffer3 S(byte[] bArr, int i, int i2) {
        Intrinsics3.checkParameterIsNotNull(bArr, "source");
        long j = i2;
        b.i.a.f.e.o.f.B(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment2 segment2N = N(1);
            int iMin = Math.min(i3 - i, 8192 - segment2N.c);
            int i4 = i + iMin;
            _ArraysJvm.copyInto(bArr, segment2N.a, segment2N.c, i, i4);
            segment2N.c += iMin;
            i = i4;
        }
        this.k += j;
        return this;
    }

    public Buffer3 T(int i) {
        Segment2 segment2N = N(1);
        byte[] bArr = segment2N.a;
        int i2 = segment2N.c;
        segment2N.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.k++;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f5 A[LOOP:0: B:69:0x00f1->B:71:0x00f5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Buffer3 U(long j) {
        if (j == 0) {
            T(48);
        } else {
            boolean z2 = false;
            int i = 1;
            if (j < 0) {
                j = -j;
                if (j < 0) {
                    b0("-9223372036854775808");
                } else {
                    z2 = true;
                    if (j < 100000000) {
                        i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
                    } else if (j >= 10000) {
                        i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
                    } else if (j >= 100) {
                        i = j < 1000 ? 3 : 4;
                    } else if (j >= 10) {
                        i = 2;
                    }
                    if (z2) {
                        i++;
                    }
                    Segment2 segment2N = N(i);
                    byte[] bArr = segment2N.a;
                    int i2 = segment2N.c + i;
                    while (j != 0) {
                        long j2 = 10;
                        i2--;
                        bArr[i2] = Buffer5.a[(int) (j % j2)];
                        j /= j2;
                    }
                    if (z2) {
                        bArr[i2 - 1] = (byte) 45;
                    }
                    segment2N.c += i;
                    this.k += i;
                }
            } else {
                if (j < 100000000) {
                }
                if (z2) {
                }
                Segment2 segment2N2 = N(i);
                byte[] bArr2 = segment2N2.a;
                int i22 = segment2N2.c + i;
                while (j != 0) {
                }
                if (z2) {
                }
                segment2N2.c += i;
                this.k += i;
            }
        }
        return this;
    }

    public Buffer3 V(long j) {
        if (j == 0) {
            T(48);
        } else {
            long j2 = (j >>> 1) | j;
            long j3 = j2 | (j2 >>> 2);
            long j4 = j3 | (j3 >>> 4);
            long j5 = j4 | (j4 >>> 8);
            long j6 = j5 | (j5 >>> 16);
            long j7 = j6 | (j6 >>> 32);
            long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
            long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
            long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
            long j11 = j10 + (j10 >>> 8);
            long j12 = j11 + (j11 >>> 16);
            int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
            Segment2 segment2N = N(i);
            byte[] bArr = segment2N.a;
            int i2 = segment2N.c;
            for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
                bArr[i3] = Buffer5.a[(int) (15 & j)];
                j >>>= 4;
            }
            segment2N.c += i;
            this.k += i;
        }
        return this;
    }

    public Buffer3 W(int i) {
        Segment2 segment2N = N(4);
        byte[] bArr = segment2N.a;
        int i2 = segment2N.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        segment2N.c = i5 + 1;
        this.k += 4;
        return this;
    }

    public Buffer3 X(int i) {
        Segment2 segment2N = N(2);
        byte[] bArr = segment2N.a;
        int i2 = segment2N.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        segment2N.c = i3 + 1;
        this.k += 2;
        return this;
    }

    @Override // g0.BufferedSource
    public String Y() throws EOFException {
        return G(RecyclerView.FOREVER_NS);
    }

    @Override // g0.BufferedSource
    public byte[] Z(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(outline.t("byteCount: ", j).toString());
        }
        if (this.k < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    public Buffer3 b() {
        Buffer3 buffer3 = new Buffer3();
        if (this.k != 0) {
            Segment2 segment2 = this.j;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            Segment2 segment2C = segment2.c();
            buffer3.j = segment2C;
            segment2C.g = segment2C;
            segment2C.f = segment2C;
            for (Segment2 segment22 = segment2.f; segment22 != segment2; segment22 = segment22.f) {
                Segment2 segment23 = segment2C.g;
                if (segment23 == null) {
                    Intrinsics3.throwNpe();
                }
                if (segment22 == null) {
                    Intrinsics3.throwNpe();
                }
                segment23.b(segment22.c());
            }
            buffer3.k = this.k;
        }
        return buffer3;
    }

    public Buffer3 b0(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "string");
        c0(str, 0, str.length());
        return this;
    }

    public Buffer3 c0(String str, int i, int i2) {
        char cCharAt;
        Intrinsics3.checkParameterIsNotNull(str, "string");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(outline.q("beginIndex < 0: ", i).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(outline.s("endIndex < beginIndex: ", i2, " < ", i).toString());
        }
        if (!(i2 <= str.length())) {
            StringBuilder sbV = outline.V("endIndex > string.length: ", i2, " > ");
            sbV.append(str.length());
            throw new IllegalArgumentException(sbV.toString().toString());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                Segment2 segment2N = N(1);
                byte[] bArr = segment2N.a;
                int i3 = segment2N.c - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = segment2N.c;
                int i6 = (i3 + i) - i5;
                segment2N.c = i5 + i6;
                this.k += i6;
            } else {
                if (cCharAt2 < 2048) {
                    Segment2 segment2N2 = N(2);
                    byte[] bArr2 = segment2N2.a;
                    int i7 = segment2N2.c;
                    bArr2[i7] = (byte) ((cCharAt2 >> 6) | Opcodes.CHECKCAST);
                    bArr2[i7 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    segment2N2.c = i7 + 2;
                    this.k += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    Segment2 segment2N3 = N(3);
                    byte[] bArr3 = segment2N3.a;
                    int i8 = segment2N3.c;
                    bArr3[i8] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    segment2N3.c = i8 + 3;
                    this.k += 3;
                } else {
                    int i9 = i + 1;
                    char cCharAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || 57343 < cCharAt3) {
                        T(63);
                        i = i9;
                    } else {
                        int i10 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        Segment2 segment2N4 = N(4);
                        byte[] bArr4 = segment2N4.a;
                        int i11 = segment2N4.c;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        segment2N4.c = i11 + 4;
                        this.k += 4;
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    @Override // g0.Source2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public Buffer3 d0(int i) {
        String str;
        if (i < 128) {
            T(i);
        } else if (i < 2048) {
            Segment2 segment2N = N(2);
            byte[] bArr = segment2N.a;
            int i2 = segment2N.c;
            bArr[i2] = (byte) ((i >> 6) | Opcodes.CHECKCAST);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            segment2N.c = i2 + 2;
            this.k += 2;
        } else if (55296 <= i && 57343 >= i) {
            T(63);
        } else if (i < 65536) {
            Segment2 segment2N2 = N(3);
            byte[] bArr2 = segment2N2.a;
            int i3 = segment2N2.c;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            segment2N2.c = i3 + 3;
            this.k += 3;
        } else {
            if (i > 1114111) {
                StringBuilder sbU = outline.U("Unexpected code point: 0x");
                if (i != 0) {
                    char[] cArr = ByteString4.a;
                    int i4 = 0;
                    char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
                    while (i4 < 8 && cArr2[i4] == '0') {
                        i4++;
                    }
                    str = new String(cArr2, i4, 8 - i4);
                } else {
                    str = "0";
                }
                sbU.append(str);
                throw new IllegalArgumentException(sbU.toString());
            }
            Segment2 segment2N3 = N(4);
            byte[] bArr3 = segment2N3.a;
            int i5 = segment2N3.c;
            bArr3[i5] = (byte) ((i >> 18) | 240);
            bArr3[i5 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i5 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i5 + 3] = (byte) ((i & 63) | 128);
            segment2N3.c = i5 + 4;
            this.k += 4;
        }
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink e0(ByteString byteString) {
        O(byteString);
        return this;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof Buffer3)) {
                return false;
            }
            long j = this.k;
            Buffer3 buffer3 = (Buffer3) obj;
            if (j != buffer3.k) {
                return false;
            }
            if (j != 0) {
                Segment2 segment2 = this.j;
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                Segment2 segment22 = buffer3.j;
                if (segment22 == null) {
                    Intrinsics3.throwNpe();
                }
                int i = segment2.f3693b;
                int i2 = segment22.f3693b;
                long j2 = 0;
                while (j2 < this.k) {
                    long jMin = Math.min(segment2.c - i, segment22.c - i2);
                    long j3 = 0;
                    while (j3 < jMin) {
                        int i3 = i + 1;
                        int i4 = i2 + 1;
                        if (segment2.a[i] != segment22.a[i2]) {
                            return false;
                        }
                        j3++;
                        i = i3;
                        i2 = i4;
                    }
                    if (i == segment2.c) {
                        segment2 = segment2.f;
                        if (segment2 == null) {
                            Intrinsics3.throwNpe();
                        }
                        i = segment2.f3693b;
                    }
                    if (i2 == segment22.c) {
                        segment22 = segment22.f;
                        if (segment22 == null) {
                            Intrinsics3.throwNpe();
                        }
                        i2 = segment22.f3693b;
                    }
                    j2 += jMin;
                }
            }
        }
        return true;
    }

    public final long f() {
        long j = this.k;
        if (j == 0) {
            return 0L;
        }
        Segment2 segment2 = this.j;
        if (segment2 == null) {
            Intrinsics3.throwNpe();
        }
        Segment2 segment22 = segment2.g;
        if (segment22 == null) {
            Intrinsics3.throwNpe();
        }
        if (segment22.c < 8192 && segment22.e) {
            j -= r3 - segment22.f3693b;
        }
        return j;
    }

    @Override // okio.BufferedSink, g0.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // g0.BufferedSource, okio.BufferedSink
    public Buffer3 g() {
        return this;
    }

    public int hashCode() {
        Segment2 segment2 = this.j;
        if (segment2 == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment2.c;
            for (int i3 = segment2.f3693b; i3 < i2; i3++) {
                i = (i * 31) + segment2.a[i3];
            }
            segment2 = segment2.f;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
        } while (segment2 != this.j);
        return i;
    }

    @Override // g0.Source2
    public long i0(Buffer3 buffer3, long j) {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.t("byteCount < 0: ", j).toString());
        }
        long j2 = this.k;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        buffer3.write(this, j);
        return j;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // g0.BufferedSource
    public boolean j(long j) {
        return this.k >= j;
    }

    @Override // g0.BufferedSource
    public long k0(Sink sink) throws IOException {
        Intrinsics3.checkParameterIsNotNull(sink, "sink");
        long j = this.k;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public final Buffer3 n(Buffer3 buffer3, long j, long j2) {
        Intrinsics3.checkParameterIsNotNull(buffer3, "out");
        b.i.a.f.e.o.f.B(this.k, j, j2);
        if (j2 != 0) {
            buffer3.k += j2;
            Segment2 segment2 = this.j;
            while (true) {
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                int i = segment2.c;
                int i2 = segment2.f3693b;
                if (j < i - i2) {
                    break;
                }
                j -= i - i2;
                segment2 = segment2.f;
            }
            while (j2 > 0) {
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                Segment2 segment2C = segment2.c();
                int i3 = segment2C.f3693b + ((int) j);
                segment2C.f3693b = i3;
                segment2C.c = Math.min(i3 + ((int) j2), segment2C.c);
                Segment2 segment22 = buffer3.j;
                if (segment22 == null) {
                    segment2C.g = segment2C;
                    segment2C.f = segment2C;
                    buffer3.j = segment2C;
                } else {
                    if (segment22 == null) {
                        Intrinsics3.throwNpe();
                    }
                    Segment2 segment23 = segment22.g;
                    if (segment23 == null) {
                        Intrinsics3.throwNpe();
                    }
                    segment23.b(segment2C);
                }
                j2 -= segment2C.c - segment2C.f3693b;
                segment2 = segment2.f;
                j = 0;
            }
        }
        return this;
    }

    @Override // g0.BufferedSource
    public ByteString o(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(outline.t("byteCount: ", j).toString());
        }
        if (this.k < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new ByteString(Z(j));
        }
        ByteString byteStringJ = J((int) j);
        skip(j);
        return byteStringJ;
    }

    @Override // okio.BufferedSink
    public BufferedSink p() {
        return this;
    }

    @Override // g0.BufferedSource
    public void p0(long j) throws EOFException {
        if (this.k < j) {
            throw new EOFException();
        }
    }

    public final byte q(long j) {
        b.i.a.f.e.o.f.B(this.k, j, 1L);
        Segment2 segment2 = this.j;
        if (segment2 == null) {
            Intrinsics3.throwNpe();
            throw null;
        }
        long j2 = this.k;
        if (j2 - j < j) {
            while (j2 > j) {
                segment2 = segment2.g;
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                j2 -= segment2.c - segment2.f3693b;
            }
            return segment2.a[(int) ((segment2.f3693b + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            int i = segment2.c;
            int i2 = segment2.f3693b;
            long j4 = (i - i2) + j3;
            if (j4 > j) {
                return segment2.a[(int) ((i2 + j) - j3)];
            }
            segment2 = segment2.f;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            j3 = j4;
        }
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink q0(long j) {
        return U(j);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Intrinsics3.checkParameterIsNotNull(byteBuffer, "sink");
        Segment2 segment2 = this.j;
        if (segment2 == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), segment2.c - segment2.f3693b);
        byteBuffer.put(segment2.a, segment2.f3693b, iMin);
        int i = segment2.f3693b + iMin;
        segment2.f3693b = i;
        this.k -= iMin;
        if (i == segment2.c) {
            this.j = segment2.a();
            SegmentPool.a(segment2);
        }
        return iMin;
    }

    @Override // g0.BufferedSource
    public byte readByte() throws EOFException {
        if (this.k == 0) {
            throw new EOFException();
        }
        Segment2 segment2 = this.j;
        if (segment2 == null) {
            Intrinsics3.throwNpe();
        }
        int i = segment2.f3693b;
        int i2 = segment2.c;
        int i3 = i + 1;
        byte b2 = segment2.a[i];
        this.k--;
        if (i3 == i2) {
            this.j = segment2.a();
            SegmentPool.a(segment2);
        } else {
            segment2.f3693b = i3;
        }
        return b2;
    }

    @Override // g0.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        Intrinsics3.checkParameterIsNotNull(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int i2 = read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    @Override // g0.BufferedSource
    public int readInt() throws EOFException {
        if (this.k < 4) {
            throw new EOFException();
        }
        Segment2 segment2 = this.j;
        if (segment2 == null) {
            Intrinsics3.throwNpe();
        }
        int i = segment2.f3693b;
        int i2 = segment2.c;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment2.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.k -= 4;
        if (i8 == i2) {
            this.j = segment2.a();
            SegmentPool.a(segment2);
        } else {
            segment2.f3693b = i8;
        }
        return i9;
    }

    @Override // g0.BufferedSource
    public long readLong() throws EOFException {
        if (this.k < 8) {
            throw new EOFException();
        }
        Segment2 segment2 = this.j;
        if (segment2 == null) {
            Intrinsics3.throwNpe();
        }
        int i = segment2.f3693b;
        int i2 = segment2.c;
        if (i2 - i < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = segment2.a;
        long j = (bArr[i] & 255) << 56;
        long j2 = j | ((bArr[r6] & 255) << 48);
        long j3 = j2 | ((bArr[r1] & 255) << 40);
        int i3 = i + 1 + 1 + 1 + 1;
        long j4 = ((bArr[r6] & 255) << 32) | j3;
        long j5 = j4 | ((bArr[i3] & 255) << 24);
        long j6 = j5 | ((bArr[r8] & 255) << 16);
        long j7 = j6 | ((bArr[r1] & 255) << 8);
        int i4 = i3 + 1 + 1 + 1 + 1;
        long j8 = j7 | (bArr[r8] & 255);
        this.k -= 8;
        if (i4 == i2) {
            this.j = segment2.a();
            SegmentPool.a(segment2);
        } else {
            segment2.f3693b = i4;
        }
        return j8;
    }

    @Override // g0.BufferedSource
    public short readShort() throws EOFException {
        if (this.k < 2) {
            throw new EOFException();
        }
        Segment2 segment2 = this.j;
        if (segment2 == null) {
            Intrinsics3.throwNpe();
        }
        int i = segment2.f3693b;
        int i2 = segment2.c;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment2.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.k -= 2;
        if (i4 == i2) {
            this.j = segment2.a();
            SegmentPool.a(segment2);
        } else {
            segment2.f3693b = i4;
        }
        return (short) i5;
    }

    public long s(byte b2, long j, long j2) {
        Segment2 segment2;
        long j3 = 0;
        if (!(0 <= j && j2 >= j)) {
            StringBuilder sbU = outline.U("size=");
            sbU.append(this.k);
            sbU.append(" fromIndex=");
            sbU.append(j);
            sbU.append(" toIndex=");
            sbU.append(j2);
            throw new IllegalArgumentException(sbU.toString().toString());
        }
        long j4 = this.k;
        if (j2 > j4) {
            j2 = j4;
        }
        if (j != j2 && (segment2 = this.j) != null) {
            if (j4 - j < j) {
                while (j4 > j) {
                    segment2 = segment2.g;
                    if (segment2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    j4 -= segment2.c - segment2.f3693b;
                }
                while (j4 < j2) {
                    byte[] bArr = segment2.a;
                    int iMin = (int) Math.min(segment2.c, (segment2.f3693b + j2) - j4);
                    for (int i = (int) ((segment2.f3693b + j) - j4); i < iMin; i++) {
                        if (bArr[i] == b2) {
                            return (i - segment2.f3693b) + j4;
                        }
                    }
                    j4 += segment2.c - segment2.f3693b;
                    segment2 = segment2.f;
                    if (segment2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    j = j4;
                }
            } else {
                while (true) {
                    long j5 = (segment2.c - segment2.f3693b) + j3;
                    if (j5 > j) {
                        break;
                    }
                    segment2 = segment2.f;
                    if (segment2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    j3 = j5;
                }
                while (j3 < j2) {
                    byte[] bArr2 = segment2.a;
                    int iMin2 = (int) Math.min(segment2.c, (segment2.f3693b + j2) - j3);
                    for (int i2 = (int) ((segment2.f3693b + j) - j3); i2 < iMin2; i2++) {
                        if (bArr2[i2] == b2) {
                            return (i2 - segment2.f3693b) + j3;
                        }
                    }
                    j3 += segment2.c - segment2.f3693b;
                    segment2 = segment2.f;
                    if (segment2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    j = j3;
                }
            }
        }
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a3 A[EDGE_INSN: B:46:0x00a3->B:40:0x00a3 BREAK  A[LOOP:0: B:5:0x000b->B:48:?], SYNTHETIC] */
    @Override // g0.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long s0() throws EOFException {
        int i;
        if (this.k == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z2 = false;
        long j = 0;
        do {
            Segment2 segment2 = this.j;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            byte[] bArr = segment2.a;
            int i3 = segment2.f3693b;
            int i4 = segment2.c;
            while (i3 < i4) {
                byte b2 = bArr[i3];
                byte b3 = (byte) 48;
                if (b2 < b3 || b2 > ((byte) 57)) {
                    byte b4 = (byte) 97;
                    if ((b2 >= b4 && b2 <= ((byte) 102)) || (b2 >= (b4 = (byte) 65) && b2 <= ((byte) 70))) {
                        i = (b2 - b4) + 10;
                    } else {
                        if (i2 == 0) {
                            StringBuilder sbU = outline.U("Expected leading [0-9a-fA-F] character but was 0x");
                            sbU.append(b.i.a.f.e.o.f.t1(b2));
                            throw new NumberFormatException(sbU.toString());
                        }
                        z2 = true;
                        if (i3 != i4) {
                            this.j = segment2.a();
                            SegmentPool.a(segment2);
                        } else {
                            segment2.f3693b = i3;
                        }
                        if (!z2) {
                            break;
                        }
                    }
                } else {
                    i = b2 - b3;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    Buffer3 buffer3 = new Buffer3();
                    buffer3.V(j);
                    buffer3.T(b2);
                    StringBuilder sbU2 = outline.U("Number too large: ");
                    sbU2.append(buffer3.D());
                    throw new NumberFormatException(sbU2.toString());
                }
                j = (j << 4) | i;
                i3++;
                i2++;
            }
            if (i3 != i4) {
            }
            if (!z2) {
            }
        } while (this.j != null);
        this.k -= i2;
        return j;
    }

    @Override // g0.BufferedSource
    public void skip(long j) throws EOFException {
        while (j > 0) {
            Segment2 segment2 = this.j;
            if (segment2 == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, segment2.c - segment2.f3693b);
            long j2 = iMin;
            this.k -= j2;
            j -= j2;
            int i = segment2.f3693b + iMin;
            segment2.f3693b = i;
            if (i == segment2.c) {
                this.j = segment2.a();
                SegmentPool.a(segment2);
            }
        }
    }

    public long t(ByteString byteString, long j) {
        int i;
        int i2;
        int i3;
        int i4;
        long j2 = j;
        Intrinsics3.checkParameterIsNotNull(byteString, "targetBytes");
        long j3 = 0;
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(outline.t("fromIndex < 0: ", j2).toString());
        }
        Segment2 segment2 = this.j;
        if (segment2 == null) {
            return -1L;
        }
        long j4 = this.k;
        if (j4 - j2 < j2) {
            while (j4 > j2) {
                segment2 = segment2.g;
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                j4 -= segment2.c - segment2.f3693b;
            }
            if (byteString.j() == 2) {
                byte bM = byteString.m(0);
                byte bM2 = byteString.m(1);
                while (j4 < this.k) {
                    byte[] bArr = segment2.a;
                    i3 = (int) ((segment2.f3693b + j2) - j4);
                    int i5 = segment2.c;
                    while (i3 < i5) {
                        byte b2 = bArr[i3];
                        if (b2 == bM || b2 == bM2) {
                            i4 = segment2.f3693b;
                        } else {
                            i3++;
                        }
                    }
                    j4 += segment2.c - segment2.f3693b;
                    segment2 = segment2.f;
                    if (segment2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    j2 = j4;
                }
                return -1L;
            }
            byte[] bArrL = byteString.l();
            while (j4 < this.k) {
                byte[] bArr2 = segment2.a;
                i3 = (int) ((segment2.f3693b + j2) - j4);
                int i6 = segment2.c;
                while (i3 < i6) {
                    byte b3 = bArr2[i3];
                    for (byte b4 : bArrL) {
                        if (b3 == b4) {
                            i4 = segment2.f3693b;
                        }
                    }
                    i3++;
                }
                j4 += segment2.c - segment2.f3693b;
                segment2 = segment2.f;
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                j2 = j4;
            }
            return -1L;
            return (i3 - i4) + j4;
        }
        while (true) {
            long j5 = (segment2.c - segment2.f3693b) + j3;
            if (j5 > j2) {
                break;
            }
            segment2 = segment2.f;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            j3 = j5;
        }
        if (byteString.j() == 2) {
            byte bM3 = byteString.m(0);
            byte bM4 = byteString.m(1);
            while (j3 < this.k) {
                byte[] bArr3 = segment2.a;
                i = (int) ((segment2.f3693b + j2) - j3);
                int i7 = segment2.c;
                while (i < i7) {
                    byte b5 = bArr3[i];
                    if (b5 == bM3 || b5 == bM4) {
                        i2 = segment2.f3693b;
                    } else {
                        i++;
                    }
                }
                j3 += segment2.c - segment2.f3693b;
                segment2 = segment2.f;
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                j2 = j3;
            }
            return -1L;
        }
        byte[] bArrL2 = byteString.l();
        while (j3 < this.k) {
            byte[] bArr4 = segment2.a;
            i = (int) ((segment2.f3693b + j2) - j3);
            int i8 = segment2.c;
            while (i < i8) {
                byte b6 = bArr4[i];
                for (byte b7 : bArrL2) {
                    if (b6 == b7) {
                        i2 = segment2.f3693b;
                    }
                }
                i++;
            }
            j3 += segment2.c - segment2.f3693b;
            segment2 = segment2.f;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            j2 = j3;
        }
        return -1L;
        return (i - i2) + j3;
    }

    @Override // g0.Source2
    public Timeout2 timeout() {
        return Timeout2.a;
    }

    public String toString() {
        long j = this.k;
        if (j <= ((long) Integer.MAX_VALUE)) {
            return J((int) j).toString();
        }
        StringBuilder sbU = outline.U("size > Int.MAX_VALUE: ");
        sbU.append(this.k);
        throw new IllegalStateException(sbU.toString().toString());
    }

    public final a u(a aVar) {
        Intrinsics3.checkParameterIsNotNull(aVar, "unsafeCursor");
        if (!(aVar.j == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        aVar.j = this;
        aVar.k = true;
        return aVar;
    }

    @Override // g0.BufferedSource
    public InputStream u0() {
        return new b();
    }

    @Override // g0.BufferedSource
    public int v0(Options2 options2) throws EOFException {
        Intrinsics3.checkParameterIsNotNull(options2, "options");
        int iB = Buffer5.b(this, options2, false);
        if (iB == -1) {
            return -1;
        }
        skip(options2.l[iB].j());
        return iB;
    }

    @Override // g0.BufferedSource
    public boolean w() {
        return this.k == 0;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] bArr) {
        R(bArr);
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeByte(int i) {
        T(i);
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeInt(int i) {
        W(i);
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShort(int i) {
        X(i);
        return this;
    }

    public ByteString x() {
        return o(this.k);
    }

    public short y() throws EOFException {
        int i = readShort() & 65535;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] bArr, int i, int i2) {
        S(bArr, i, i2);
        return this;
    }

    /* compiled from: Buffer.kt */
    /* renamed from: g0.e$b */
    public static final class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(Buffer3.this.k, Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            Buffer3 buffer3 = Buffer3.this;
            if (buffer3.k > 0) {
                return buffer3.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return Buffer3.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            Intrinsics3.checkParameterIsNotNull(bArr, "sink");
            return Buffer3.this.read(bArr, i, i2);
        }
    }

    @Override // g0.Sink
    public void write(Buffer3 buffer3, long j) {
        int i;
        Segment2 segment2;
        Segment2 segment2B;
        Intrinsics3.checkParameterIsNotNull(buffer3, "source");
        if (buffer3 != this) {
            b.i.a.f.e.o.f.B(buffer3.k, 0L, j);
            long j2 = j;
            while (j2 > 0) {
                Segment2 segment22 = buffer3.j;
                if (segment22 == null) {
                    Intrinsics3.throwNpe();
                }
                int i2 = segment22.c;
                if (buffer3.j == null) {
                    Intrinsics3.throwNpe();
                }
                if (j2 < i2 - r7.f3693b) {
                    Segment2 segment23 = this.j;
                    if (segment23 != null) {
                        if (segment23 == null) {
                            Intrinsics3.throwNpe();
                        }
                        segment2 = segment23.g;
                    } else {
                        segment2 = null;
                    }
                    if (segment2 != null && segment2.e) {
                        if ((segment2.c + j2) - (segment2.d ? 0 : segment2.f3693b) <= 8192) {
                            Segment2 segment24 = buffer3.j;
                            if (segment24 == null) {
                                Intrinsics3.throwNpe();
                            }
                            segment24.d(segment2, (int) j2);
                            buffer3.k -= j2;
                            this.k += j2;
                            return;
                        }
                    }
                    Segment2 segment25 = buffer3.j;
                    if (segment25 == null) {
                        Intrinsics3.throwNpe();
                    }
                    int i3 = (int) j2;
                    Objects.requireNonNull(segment25);
                    if (i3 > 0 && i3 <= segment25.c - segment25.f3693b) {
                        if (i3 >= 1024) {
                            segment2B = segment25.c();
                        } else {
                            segment2B = SegmentPool.b();
                            byte[] bArr = segment25.a;
                            byte[] bArr2 = segment2B.a;
                            int i4 = segment25.f3693b;
                            _ArraysJvm.copyInto$default(bArr, bArr2, 0, i4, i4 + i3, 2, (Object) null);
                        }
                        segment2B.c = segment2B.f3693b + i3;
                        segment25.f3693b += i3;
                        Segment2 segment26 = segment25.g;
                        if (segment26 == null) {
                            Intrinsics3.throwNpe();
                        }
                        segment26.b(segment2B);
                        buffer3.j = segment2B;
                    } else {
                        throw new IllegalArgumentException("byteCount out of range".toString());
                    }
                }
                Segment2 segment27 = buffer3.j;
                if (segment27 == null) {
                    Intrinsics3.throwNpe();
                }
                long j3 = segment27.c - segment27.f3693b;
                buffer3.j = segment27.a();
                Segment2 segment28 = this.j;
                if (segment28 == null) {
                    this.j = segment27;
                    segment27.g = segment27;
                    segment27.f = segment27;
                } else {
                    if (segment28 == null) {
                        Intrinsics3.throwNpe();
                    }
                    Segment2 segment29 = segment28.g;
                    if (segment29 == null) {
                        Intrinsics3.throwNpe();
                    }
                    segment29.b(segment27);
                    Segment2 segment210 = segment27.g;
                    if (!(segment210 != segment27)) {
                        throw new IllegalStateException("cannot compact".toString());
                    }
                    if (segment210 == null) {
                        Intrinsics3.throwNpe();
                    }
                    if (segment210.e) {
                        int i5 = segment27.c - segment27.f3693b;
                        Segment2 segment211 = segment27.g;
                        if (segment211 == null) {
                            Intrinsics3.throwNpe();
                        }
                        int i6 = 8192 - segment211.c;
                        Segment2 segment212 = segment27.g;
                        if (segment212 == null) {
                            Intrinsics3.throwNpe();
                        }
                        if (segment212.d) {
                            i = 0;
                        } else {
                            Segment2 segment213 = segment27.g;
                            if (segment213 == null) {
                                Intrinsics3.throwNpe();
                            }
                            i = segment213.f3693b;
                        }
                        if (i5 <= i6 + i) {
                            Segment2 segment214 = segment27.g;
                            if (segment214 == null) {
                                Intrinsics3.throwNpe();
                            }
                            segment27.d(segment214, i5);
                            segment27.a();
                            SegmentPool.a(segment27);
                        }
                    }
                }
                buffer3.k -= j3;
                this.k += j3;
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public int read(byte[] bArr, int i, int i2) {
        Intrinsics3.checkParameterIsNotNull(bArr, "sink");
        b.i.a.f.e.o.f.B(bArr.length, i, i2);
        Segment2 segment2 = this.j;
        if (segment2 == null) {
            return -1;
        }
        int iMin = Math.min(i2, segment2.c - segment2.f3693b);
        byte[] bArr2 = segment2.a;
        int i3 = segment2.f3693b;
        _ArraysJvm.copyInto(bArr2, bArr, i, i3, i3 + iMin);
        int i4 = segment2.f3693b + iMin;
        segment2.f3693b = i4;
        this.k -= iMin;
        if (i4 != segment2.c) {
            return iMin;
        }
        this.j = segment2.a();
        SegmentPool.a(segment2);
        return iMin;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        Intrinsics3.checkParameterIsNotNull(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            Segment2 segment2N = N(1);
            int iMin = Math.min(i, 8192 - segment2N.c);
            byteBuffer.get(segment2N.a, segment2N.c, iMin);
            i -= iMin;
            segment2N.c += iMin;
        }
        this.k += iRemaining;
        return iRemaining;
    }
}
