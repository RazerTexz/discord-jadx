package b.i.a.c.x2.k0;

import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.CodecSpecificDataUtil;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.ParsableNalUnitBitArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: H265Reader.java */
/* renamed from: b.i.a.c.x2.k0.s, reason: use source file name */
/* loaded from: classes3.dex */
public final class H265Reader implements ElementaryStreamReader {
    public final SeiReader a;

    /* renamed from: b, reason: collision with root package name */
    public String f1275b;
    public TrackOutput2 c;
    public a d;
    public boolean e;
    public long l;
    public final boolean[] f = new boolean[3];
    public final NalUnitTargetBuffer g = new NalUnitTargetBuffer(32, 128);
    public final NalUnitTargetBuffer h = new NalUnitTargetBuffer(33, 128);
    public final NalUnitTargetBuffer i = new NalUnitTargetBuffer(34, 128);
    public final NalUnitTargetBuffer j = new NalUnitTargetBuffer(39, 128);
    public final NalUnitTargetBuffer k = new NalUnitTargetBuffer(40, 128);
    public long m = -9223372036854775807L;
    public final ParsableByteArray n = new ParsableByteArray();

    /* compiled from: H265Reader.java */
    /* renamed from: b.i.a.c.x2.k0.s$a */
    public static final class a {
        public final TrackOutput2 a;

        /* renamed from: b, reason: collision with root package name */
        public long f1276b;
        public boolean c;
        public int d;
        public long e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public long k;
        public long l;
        public boolean m;

        public a(TrackOutput2 trackOutput2) {
            this.a = trackOutput2;
        }

        public final void a(int i) {
            long j = this.l;
            if (j == -9223372036854775807L) {
                return;
            }
            boolean z2 = this.m;
            this.a.d(j, z2 ? 1 : 0, (int) (this.f1276b - this.k), i, null);
        }
    }

    public H265Reader(SeiReader seiReader) {
        this.a = seiReader;
    }

    @RequiresNonNull({"sampleReader"})
    public final void a(byte[] bArr, int i, int i2) {
        a aVar = this.d;
        if (aVar.f) {
            int i3 = aVar.d;
            int i4 = (i + 2) - i3;
            if (i4 < i2) {
                aVar.g = (bArr[i4] & 128) != 0;
                aVar.f = false;
            } else {
                aVar.d = (i2 - i) + i3;
            }
        }
        if (!this.e) {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x0347  */
    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        byte[] bArr;
        int i3;
        int i4;
        long j;
        long j2;
        long j3;
        int i5;
        long j4;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        AnimatableValueParser.H(this.c);
        int i6 = Util2.a;
        while (parsableByteArray.a() > 0) {
            int i7 = parsableByteArray2.c;
            byte[] bArr2 = parsableByteArray2.a;
            this.l += parsableByteArray.a();
            this.c.c(parsableByteArray2, parsableByteArray.a());
            for (int i8 = parsableByteArray2.f984b; i8 < i7; i8 = i3) {
                int iB = NalUnitUtil.b(bArr2, i8, i7, this.f);
                if (iB == i7) {
                    a(bArr2, i8, i7);
                    return;
                }
                int i9 = iB + 3;
                int i10 = (bArr2[i9] & 126) >> 1;
                int i11 = iB - i8;
                if (i11 > 0) {
                    a(bArr2, i8, iB);
                }
                int i12 = i7 - iB;
                long j5 = this.l - i12;
                int i13 = i11 < 0 ? -i11 : 0;
                long j6 = this.m;
                a aVar = this.d;
                boolean z2 = this.e;
                if (aVar.j && aVar.g) {
                    aVar.m = aVar.c;
                    aVar.j = false;
                } else if (aVar.h || aVar.g) {
                    if (z2 && aVar.i) {
                        aVar.a(((int) (j5 - aVar.f1276b)) + i12);
                    }
                    aVar.k = aVar.f1276b;
                    aVar.l = aVar.e;
                    aVar.m = aVar.c;
                    aVar.i = true;
                }
                if (!this.e) {
                    this.g.b(i13);
                    this.h.b(i13);
                    this.i.b(i13);
                    NalUnitTargetBuffer nalUnitTargetBuffer = this.g;
                    if (nalUnitTargetBuffer.c) {
                        NalUnitTargetBuffer nalUnitTargetBuffer2 = this.h;
                        if (nalUnitTargetBuffer2.c) {
                            NalUnitTargetBuffer nalUnitTargetBuffer3 = this.i;
                            if (nalUnitTargetBuffer3.c) {
                                TrackOutput2 trackOutput2 = this.c;
                                String str = this.f1275b;
                                i2 = i7;
                                int i14 = nalUnitTargetBuffer.e;
                                bArr = bArr2;
                                i3 = i9;
                                byte[] bArr3 = new byte[nalUnitTargetBuffer2.e + i14 + nalUnitTargetBuffer3.e];
                                i = i12;
                                System.arraycopy(nalUnitTargetBuffer.d, 0, bArr3, 0, i14);
                                i4 = i10;
                                System.arraycopy(nalUnitTargetBuffer2.d, 0, bArr3, nalUnitTargetBuffer.e, nalUnitTargetBuffer2.e);
                                System.arraycopy(nalUnitTargetBuffer3.d, 0, bArr3, nalUnitTargetBuffer.e + nalUnitTargetBuffer2.e, nalUnitTargetBuffer3.e);
                                ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(nalUnitTargetBuffer2.d, 0, nalUnitTargetBuffer2.e);
                                parsableNalUnitBitArray.j(44);
                                int iE = parsableNalUnitBitArray.e(3);
                                parsableNalUnitBitArray.i();
                                int iE2 = parsableNalUnitBitArray.e(2);
                                boolean zD = parsableNalUnitBitArray.d();
                                int iE3 = parsableNalUnitBitArray.e(5);
                                int i15 = 0;
                                int i16 = 0;
                                for (int i17 = 32; i15 < i17; i17 = 32) {
                                    if (parsableNalUnitBitArray.d()) {
                                        i16 |= 1 << i15;
                                    }
                                    i15++;
                                }
                                int[] iArr = new int[6];
                                for (int i18 = 0; i18 < 6; i18++) {
                                    iArr[i18] = parsableNalUnitBitArray.e(8);
                                }
                                int iE4 = parsableNalUnitBitArray.e(8);
                                int i19 = 0;
                                for (int i20 = 0; i20 < iE; i20++) {
                                    if (parsableNalUnitBitArray.d()) {
                                        i19 += 89;
                                    }
                                    if (parsableNalUnitBitArray.d()) {
                                        i19 += 8;
                                    }
                                }
                                parsableNalUnitBitArray.j(i19);
                                if (iE > 0) {
                                    parsableNalUnitBitArray.j((8 - iE) * 2);
                                }
                                parsableNalUnitBitArray.f();
                                int iF = parsableNalUnitBitArray.f();
                                if (iF == 3) {
                                    parsableNalUnitBitArray.i();
                                }
                                int iF2 = parsableNalUnitBitArray.f();
                                int iF3 = parsableNalUnitBitArray.f();
                                if (parsableNalUnitBitArray.d()) {
                                    int iF4 = parsableNalUnitBitArray.f();
                                    int iF5 = parsableNalUnitBitArray.f();
                                    int iF6 = parsableNalUnitBitArray.f();
                                    int iF7 = parsableNalUnitBitArray.f();
                                    j = j5;
                                    iF2 -= (iF4 + iF5) * ((iF == 1 || iF == 2) ? 2 : 1);
                                    iF3 -= (iF6 + iF7) * (iF == 1 ? 2 : 1);
                                } else {
                                    j = j5;
                                }
                                parsableNalUnitBitArray.f();
                                parsableNalUnitBitArray.f();
                                int iF8 = parsableNalUnitBitArray.f();
                                for (int i21 = parsableNalUnitBitArray.d() ? 0 : iE; i21 <= iE; i21++) {
                                    parsableNalUnitBitArray.f();
                                    parsableNalUnitBitArray.f();
                                    parsableNalUnitBitArray.f();
                                }
                                parsableNalUnitBitArray.f();
                                parsableNalUnitBitArray.f();
                                parsableNalUnitBitArray.f();
                                parsableNalUnitBitArray.f();
                                parsableNalUnitBitArray.f();
                                parsableNalUnitBitArray.f();
                                if (parsableNalUnitBitArray.d() && parsableNalUnitBitArray.d()) {
                                    int i22 = 0;
                                    for (int i23 = 4; i22 < i23; i23 = 4) {
                                        int i24 = 0;
                                        while (i24 < 6) {
                                            if (parsableNalUnitBitArray.d()) {
                                                j4 = j6;
                                                int iMin = Math.min(64, 1 << ((i22 << 1) + 4));
                                                if (i22 > 1) {
                                                    parsableNalUnitBitArray.g();
                                                }
                                                for (int i25 = 0; i25 < iMin; i25++) {
                                                    parsableNalUnitBitArray.g();
                                                }
                                            } else {
                                                parsableNalUnitBitArray.f();
                                                j4 = j6;
                                            }
                                            i24 += i22 == 3 ? 3 : 1;
                                            j6 = j4;
                                        }
                                        i22++;
                                    }
                                }
                                j2 = j6;
                                parsableNalUnitBitArray.j(2);
                                if (parsableNalUnitBitArray.d()) {
                                    parsableNalUnitBitArray.j(8);
                                    parsableNalUnitBitArray.f();
                                    parsableNalUnitBitArray.f();
                                    parsableNalUnitBitArray.i();
                                }
                                int iF9 = parsableNalUnitBitArray.f();
                                int i26 = 0;
                                boolean zD2 = false;
                                int i27 = 0;
                                while (i26 < iF9) {
                                    if (i26 != 0) {
                                        zD2 = parsableNalUnitBitArray.d();
                                    }
                                    if (zD2) {
                                        parsableNalUnitBitArray.i();
                                        parsableNalUnitBitArray.f();
                                        for (int i28 = 0; i28 <= i27; i28++) {
                                            if (parsableNalUnitBitArray.d()) {
                                                parsableNalUnitBitArray.i();
                                            }
                                        }
                                        i5 = iF9;
                                    } else {
                                        int iF10 = parsableNalUnitBitArray.f();
                                        int iF11 = parsableNalUnitBitArray.f();
                                        int i29 = iF10 + iF11;
                                        i5 = iF9;
                                        for (int i30 = 0; i30 < iF10; i30++) {
                                            parsableNalUnitBitArray.f();
                                            parsableNalUnitBitArray.i();
                                        }
                                        for (int i31 = 0; i31 < iF11; i31++) {
                                            parsableNalUnitBitArray.f();
                                            parsableNalUnitBitArray.i();
                                        }
                                        i27 = i29;
                                    }
                                    i26++;
                                    iF9 = i5;
                                }
                                if (parsableNalUnitBitArray.d()) {
                                    for (int i32 = 0; i32 < parsableNalUnitBitArray.f(); i32++) {
                                        parsableNalUnitBitArray.j(iF8 + 4 + 1);
                                    }
                                }
                                parsableNalUnitBitArray.j(2);
                                float f = 1.0f;
                                if (parsableNalUnitBitArray.d()) {
                                    if (parsableNalUnitBitArray.d()) {
                                        int iE5 = parsableNalUnitBitArray.e(8);
                                        if (iE5 == 255) {
                                            int iE6 = parsableNalUnitBitArray.e(16);
                                            int iE7 = parsableNalUnitBitArray.e(16);
                                            if (iE6 != 0 && iE7 != 0) {
                                                f = iE6 / iE7;
                                            }
                                        } else {
                                            float[] fArr = NalUnitUtil.f978b;
                                            if (iE5 < fArr.length) {
                                                f = fArr[iE5];
                                            } else {
                                                outline.g0(46, "Unexpected aspect_ratio_idc value: ", iE5, "H265Reader");
                                            }
                                        }
                                    }
                                    if (parsableNalUnitBitArray.d()) {
                                        parsableNalUnitBitArray.i();
                                    }
                                    if (parsableNalUnitBitArray.d()) {
                                        parsableNalUnitBitArray.j(4);
                                        if (parsableNalUnitBitArray.d()) {
                                            parsableNalUnitBitArray.j(24);
                                        }
                                    }
                                    if (parsableNalUnitBitArray.d()) {
                                        parsableNalUnitBitArray.f();
                                        parsableNalUnitBitArray.f();
                                    }
                                    parsableNalUnitBitArray.i();
                                    if (parsableNalUnitBitArray.d()) {
                                        iF3 *= 2;
                                    }
                                }
                                String strB = CodecSpecificDataUtil.b(iE2, zD, iE3, i16, iArr, iE4);
                                Format2.b bVar = new Format2.b();
                                bVar.a = str;
                                bVar.k = "video/hevc";
                                bVar.h = strB;
                                bVar.p = iF2;
                                bVar.q = iF3;
                                bVar.t = f;
                                bVar.m = Collections.singletonList(bArr3);
                                trackOutput2.e(bVar.a());
                                this.e = true;
                            } else {
                                i = i12;
                                i2 = i7;
                                bArr = bArr2;
                                i3 = i9;
                                i4 = i10;
                                j = j5;
                                j2 = j6;
                            }
                        }
                    }
                }
                if (this.j.b(i13)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer4 = this.j;
                    this.n.C(this.j.d, NalUnitUtil.f(nalUnitTargetBuffer4.d, nalUnitTargetBuffer4.e));
                    this.n.F(5);
                    j3 = j2;
                    AnimatableValueParser.J(j3, this.n, this.a.f1246b);
                } else {
                    j3 = j2;
                }
                if (this.k.b(i13)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer5 = this.k;
                    this.n.C(this.k.d, NalUnitUtil.f(nalUnitTargetBuffer5.d, nalUnitTargetBuffer5.e));
                    this.n.F(5);
                    AnimatableValueParser.J(j3, this.n, this.a.f1246b);
                }
                long j7 = this.m;
                a aVar2 = this.d;
                boolean z3 = this.e;
                aVar2.g = false;
                aVar2.h = false;
                aVar2.e = j7;
                aVar2.d = 0;
                aVar2.f1276b = j;
                int i33 = i4;
                if (!(i33 < 32 || i33 == 40)) {
                    if (aVar2.i && !aVar2.j) {
                        if (z3) {
                            aVar2.a(i);
                        }
                        aVar2.i = false;
                    }
                    if ((32 <= i33 && i33 <= 35) || i33 == 39) {
                        aVar2.h = !aVar2.j;
                        aVar2.j = true;
                    }
                }
                boolean z4 = i33 >= 16 && i33 <= 21;
                aVar2.c = z4;
                aVar2.f = z4 || i33 <= 9;
                if (!this.e) {
                    this.g.d(i33);
                    this.h.d(i33);
                    this.i.d(i33);
                }
                this.j.d(i33);
                this.k.d(i33);
                i7 = i2;
                bArr2 = bArr;
            }
            parsableByteArray2 = parsableByteArray;
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void c() {
        this.l = 0L;
        this.m = -9223372036854775807L;
        NalUnitUtil.a(this.f);
        this.g.c();
        this.h.c();
        this.i.c();
        this.j.c();
        this.k.c();
        a aVar = this.d;
        if (aVar != null) {
            aVar.f = false;
            aVar.g = false;
            aVar.h = false;
            aVar.i = false;
            aVar.j = false;
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.a();
        this.f1275b = dVar.b();
        TrackOutput2 trackOutput2P = extractorOutput.p(dVar.c(), 2);
        this.c = trackOutput2P;
        this.d = new a(trackOutput2P);
        this.a.a(extractorOutput, dVar);
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
    }
}
