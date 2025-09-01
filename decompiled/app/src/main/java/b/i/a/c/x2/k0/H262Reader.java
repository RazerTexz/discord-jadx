package b.i.a.c.x2.k0;

import android.util.Pair;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* compiled from: H262Reader.java */
/* renamed from: b.i.a.c.x2.k0.p, reason: use source file name */
/* loaded from: classes3.dex */
public final class H262Reader implements ElementaryStreamReader {
    public static final double[] a = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: b, reason: collision with root package name */
    public String f1267b;
    public TrackOutput2 c;

    @Nullable
    public final UserDataReader d;

    @Nullable
    public final ParsableByteArray e;

    @Nullable
    public final NalUnitTargetBuffer f;
    public final boolean[] g = new boolean[4];
    public final a h = new a(128);
    public long i;
    public boolean j;
    public boolean k;
    public long l;
    public long m;
    public long n;
    public long o;
    public boolean p;
    public boolean q;

    /* compiled from: H262Reader.java */
    /* renamed from: b.i.a.c.x2.k0.p$a */
    public static final class a {
        public static final byte[] a = {0, 0, 1};

        /* renamed from: b, reason: collision with root package name */
        public boolean f1268b;
        public int c;
        public int d;
        public byte[] e;

        public a(int i) {
            this.e = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.f1268b) {
                int i3 = i2 - i;
                byte[] bArr2 = this.e;
                int length = bArr2.length;
                int i4 = this.c;
                if (length < i4 + i3) {
                    this.e = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.e, this.c, i3);
                this.c += i3;
            }
        }
    }

    public H262Reader(@Nullable UserDataReader userDataReader) {
        this.d = userDataReader;
        if (userDataReader != null) {
            this.f = new NalUnitTargetBuffer(Opcodes.GETSTATIC, 128);
            this.e = new ParsableByteArray();
        } else {
            this.f = null;
            this.e = null;
        }
        this.m = -9223372036854775807L;
        this.o = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x020b  */
    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        int i3;
        int i4;
        byte[] bArr;
        long j;
        long j2;
        int i5;
        boolean z2;
        float f;
        int i6;
        float f2;
        int i7;
        long j3;
        AnimatableValueParser.H(this.c);
        int i8 = parsableByteArray.f984b;
        int i9 = parsableByteArray.c;
        byte[] bArr2 = parsableByteArray.a;
        this.i += parsableByteArray.a();
        this.c.c(parsableByteArray, parsableByteArray.a());
        while (true) {
            int iB = NalUnitUtil.b(bArr2, i8, i9, this.g);
            if (iB == i9) {
                break;
            }
            int i10 = iB + 3;
            int i11 = parsableByteArray.a[i10] & 255;
            int i12 = iB - i8;
            if (this.k) {
                i = i11;
                i2 = i10;
            } else {
                if (i12 > 0) {
                    this.h.a(bArr2, i8, iB);
                }
                int i13 = i12 < 0 ? -i12 : 0;
                a aVar = this.h;
                if (aVar.f1268b) {
                    int i14 = aVar.c - i13;
                    aVar.c = i14;
                    if (aVar.d == 0 && i11 == 181) {
                        aVar.d = i14;
                    } else {
                        aVar.f1268b = false;
                        z2 = true;
                        if (!z2) {
                            a aVar2 = this.h;
                            String str = this.f1267b;
                            Objects.requireNonNull(str);
                            byte[] bArrCopyOf = Arrays.copyOf(aVar2.e, aVar2.c);
                            int i15 = bArrCopyOf[4] & 255;
                            int i16 = bArrCopyOf[5] & 255;
                            int i17 = (i15 << 4) | (i16 >> 4);
                            int i18 = ((i16 & 15) << 8) | (bArrCopyOf[6] & 255);
                            int i19 = (bArrCopyOf[7] & 240) >> 4;
                            if (i19 == 2) {
                                f = i18 * 4;
                                i6 = i17 * 3;
                            } else if (i19 == 3) {
                                f = i18 * 16;
                                i6 = i17 * 9;
                            } else if (i19 != 4) {
                                f2 = 1.0f;
                                Format2.b bVar = new Format2.b();
                                bVar.a = str;
                                bVar.k = "video/mpeg2";
                                bVar.p = i17;
                                bVar.q = i18;
                                bVar.t = f2;
                                bVar.m = Collections.singletonList(bArrCopyOf);
                                Format2 format2A = bVar.a();
                                i7 = (bArrCopyOf[7] & 15) - 1;
                                if (i7 < 0) {
                                    double[] dArr = a;
                                    if (i7 < dArr.length) {
                                        double d = dArr[i7];
                                        int i20 = aVar2.d + 9;
                                        int i21 = (bArrCopyOf[i20] & 96) >> 5;
                                        if (i21 != (bArrCopyOf[i20] & 31)) {
                                            i = i11;
                                            i2 = i10;
                                            d *= (i21 + 1.0d) / (r9 + 1);
                                        } else {
                                            i = i11;
                                            i2 = i10;
                                        }
                                        j3 = (long) (1000000.0d / d);
                                    } else {
                                        i = i11;
                                        i2 = i10;
                                        j3 = 0;
                                    }
                                    Pair pairCreate = Pair.create(format2A, Long.valueOf(j3));
                                    this.c.e((Format2) pairCreate.first);
                                    this.l = ((Long) pairCreate.second).longValue();
                                    this.k = true;
                                }
                            } else {
                                f = i18 * 121;
                                i6 = i17 * 100;
                            }
                            f2 = f / i6;
                            Format2.b bVar2 = new Format2.b();
                            bVar2.a = str;
                            bVar2.k = "video/mpeg2";
                            bVar2.p = i17;
                            bVar2.q = i18;
                            bVar2.t = f2;
                            bVar2.m = Collections.singletonList(bArrCopyOf);
                            Format2 format2A2 = bVar2.a();
                            i7 = (bArrCopyOf[7] & 15) - 1;
                            if (i7 < 0) {
                            }
                        }
                    }
                } else if (i11 == 179) {
                    aVar.f1268b = true;
                }
                byte[] bArr3 = a.a;
                aVar.a(bArr3, 0, bArr3.length);
                z2 = false;
                if (!z2) {
                }
            }
            NalUnitTargetBuffer nalUnitTargetBuffer = this.f;
            if (nalUnitTargetBuffer != null) {
                if (i12 > 0) {
                    nalUnitTargetBuffer.a(bArr2, i8, iB);
                    i5 = 0;
                } else {
                    i5 = -i12;
                }
                if (this.f.b(i5)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f;
                    int iF = NalUnitUtil.f(nalUnitTargetBuffer2.d, nalUnitTargetBuffer2.e);
                    ParsableByteArray parsableByteArray2 = this.e;
                    int i22 = Util2.a;
                    parsableByteArray2.C(this.f.d, iF);
                    this.d.a(this.o, this.e);
                }
                i3 = i;
                if (i3 == 178 && parsableByteArray.a[iB + 2] == 1) {
                    this.f.d(i3);
                }
            } else {
                i3 = i;
            }
            if (i3 == 0 || i3 == 179) {
                int i23 = i9 - iB;
                if (this.q && this.k) {
                    long j4 = this.o;
                    if (j4 != -9223372036854775807L) {
                        i4 = i9;
                        bArr = bArr2;
                        j = -9223372036854775807L;
                        this.c.d(j4, this.p ? 1 : 0, ((int) (this.i - this.n)) - i23, i23, null);
                    }
                    if (this.j) {
                        this.n = this.i - i23;
                        j2 = this.m;
                        if (j2 == j) {
                        }
                        this.o = j2;
                        this.p = false;
                        this.m = j;
                        this.j = true;
                        this.q = i3 != 0;
                    }
                } else {
                    i4 = i9;
                    bArr = bArr2;
                    j = -9223372036854775807L;
                    if (this.j || this.q) {
                        this.n = this.i - i23;
                        j2 = this.m;
                        if (j2 == j) {
                            long j5 = this.o;
                            j2 = j5 != j ? j5 + this.l : j;
                        }
                        this.o = j2;
                        this.p = false;
                        this.m = j;
                        this.j = true;
                    }
                    this.q = i3 != 0;
                }
            } else {
                if (i3 == 184) {
                    this.p = true;
                }
                i4 = i9;
                bArr = bArr2;
            }
            i9 = i4;
            bArr2 = bArr;
            i8 = i2;
        }
        if (!this.k) {
            this.h.a(bArr2, i8, i9);
        }
        NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f;
        if (nalUnitTargetBuffer3 != null) {
            nalUnitTargetBuffer3.a(bArr2, i8, i9);
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void c() {
        NalUnitUtil.a(this.g);
        a aVar = this.h;
        aVar.f1268b = false;
        aVar.c = 0;
        aVar.d = 0;
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.c();
        }
        this.i = 0L;
        this.j = false;
        this.m = -9223372036854775807L;
        this.o = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.a();
        this.f1267b = dVar.b();
        this.c = extractorOutput.p(dVar.c(), 2);
        UserDataReader userDataReader = this.d;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, dVar);
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void f(long j, int i) {
        this.m = j;
    }
}
