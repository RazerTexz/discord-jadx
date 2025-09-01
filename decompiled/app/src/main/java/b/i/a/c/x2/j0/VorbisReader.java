package b.i.a.c.x2.j0;

import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.VorbisBitArray;
import b.i.a.c.x2.VorbisUtil;
import b.i.a.c.x2.VorbisUtil2;
import b.i.a.c.x2.VorbisUtil3;
import b.i.a.c.x2.j0.StreamReader;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: VorbisReader.java */
/* renamed from: b.i.a.c.x2.j0.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class VorbisReader extends StreamReader {

    @Nullable
    public a n;
    public int o;
    public boolean p;

    @Nullable
    public VorbisUtil2 q;

    @Nullable
    public VorbisUtil3 r;

    /* compiled from: VorbisReader.java */
    /* renamed from: b.i.a.c.x2.j0.j$a */
    public static final class a {
        public final VorbisUtil2 a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f1241b;
        public final VorbisUtil[] c;
        public final int d;

        public a(VorbisUtil2 vorbisUtil2, VorbisUtil3 vorbisUtil3, byte[] bArr, VorbisUtil[] vorbisUtilArr, int i) {
            this.a = vorbisUtil2;
            this.f1241b = bArr;
            this.c = vorbisUtilArr;
            this.d = i;
        }
    }

    @Override // b.i.a.c.x2.j0.StreamReader
    public void b(long j) {
        this.g = j;
        this.p = j != 0;
        VorbisUtil2 vorbisUtil2 = this.q;
        this.o = vorbisUtil2 != null ? vorbisUtil2.e : 0;
    }

    @Override // b.i.a.c.x2.j0.StreamReader
    public long c(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.a;
        if ((bArr[0] & 1) == 1) {
            return -1L;
        }
        byte b2 = bArr[0];
        a aVar = this.n;
        AnimatableValueParser.H(aVar);
        a aVar2 = aVar;
        int i = !aVar2.c[(b2 >> 1) & (255 >>> (8 - aVar2.d))].a ? aVar2.a.e : aVar2.a.f;
        long j = this.p ? (this.o + i) / 4 : 0;
        byte[] bArr2 = parsableByteArray.a;
        int length = bArr2.length;
        int i2 = parsableByteArray.c + 4;
        if (length < i2) {
            parsableByteArray.B(Arrays.copyOf(bArr2, i2));
        } else {
            parsableByteArray.D(i2);
        }
        byte[] bArr3 = parsableByteArray.a;
        int i3 = parsableByteArray.c;
        bArr3[i3 - 4] = (byte) (j & 255);
        bArr3[i3 - 3] = (byte) ((j >>> 8) & 255);
        bArr3[i3 - 2] = (byte) ((j >>> 16) & 255);
        bArr3[i3 - 1] = (byte) ((j >>> 24) & 255);
        this.p = true;
        this.o = i;
        return j;
    }

    @Override // b.i.a.c.x2.j0.StreamReader
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean d(ParsableByteArray parsableByteArray, long j, StreamReader.b bVar) throws IOException {
        a aVar;
        int i;
        int iB;
        int i2;
        int i3;
        int i4;
        if (this.n != null) {
            Objects.requireNonNull(bVar.a);
            return false;
        }
        VorbisUtil2 vorbisUtil2 = this.q;
        if (vorbisUtil2 == null) {
            AnimatableValueParser.n2(1, parsableByteArray, false);
            int iK = parsableByteArray.k();
            int iT = parsableByteArray.t();
            int iK2 = parsableByteArray.k();
            int iH = parsableByteArray.h();
            int i5 = iH <= 0 ? -1 : iH;
            int iH2 = parsableByteArray.h();
            int i6 = iH2 <= 0 ? -1 : iH2;
            int iH3 = parsableByteArray.h();
            int i7 = iH3 <= 0 ? -1 : iH3;
            int iT2 = parsableByteArray.t();
            this.q = new VorbisUtil2(iK, iT, iK2, i5, i6, i7, (int) Math.pow(2.0d, iT2 & 15), (int) Math.pow(2.0d, (iT2 & 240) >> 4), (parsableByteArray.t() & 1) > 0, Arrays.copyOf(parsableByteArray.a, parsableByteArray.c));
        } else {
            VorbisUtil3 vorbisUtil3 = this.r;
            if (vorbisUtil3 == null) {
                this.r = AnimatableValueParser.N1(parsableByteArray, true, true);
            } else {
                int i8 = parsableByteArray.c;
                byte[] bArr = new byte[i8];
                System.arraycopy(parsableByteArray.a, 0, bArr, 0, i8);
                int i9 = vorbisUtil2.a;
                int i10 = 5;
                AnimatableValueParser.n2(5, parsableByteArray, false);
                int iT3 = parsableByteArray.t() + 1;
                VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.a);
                vorbisBitArray.c(parsableByteArray.f984b * 8);
                int i11 = 0;
                while (true) {
                    int i12 = 16;
                    if (i11 >= iT3) {
                        VorbisUtil3 vorbisUtil32 = vorbisUtil3;
                        byte[] bArr2 = bArr;
                        int i13 = 6;
                        int iB2 = vorbisBitArray.b(6) + 1;
                        for (int i14 = 0; i14 < iB2; i14++) {
                            if (vorbisBitArray.b(16) != 0) {
                                throw ParserException.a("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int i15 = 1;
                        int iB3 = vorbisBitArray.b(6) + 1;
                        int i16 = 0;
                        while (true) {
                            int i17 = 3;
                            if (i16 < iB3) {
                                int iB4 = vorbisBitArray.b(i12);
                                if (iB4 == 0) {
                                    i2 = iB3;
                                    int i18 = 8;
                                    vorbisBitArray.c(8);
                                    vorbisBitArray.c(16);
                                    vorbisBitArray.c(16);
                                    vorbisBitArray.c(6);
                                    vorbisBitArray.c(8);
                                    int iB5 = vorbisBitArray.b(4) + 1;
                                    int i19 = 0;
                                    while (i19 < iB5) {
                                        vorbisBitArray.c(i18);
                                        i19++;
                                        i18 = 8;
                                    }
                                } else {
                                    if (iB4 != i15) {
                                        throw outline.w0(52, "floor type greater than 1 not decodable: ", iB4, null);
                                    }
                                    int iB6 = vorbisBitArray.b(5);
                                    int[] iArr = new int[iB6];
                                    int i20 = -1;
                                    for (int i21 = 0; i21 < iB6; i21++) {
                                        iArr[i21] = vorbisBitArray.b(4);
                                        if (iArr[i21] > i20) {
                                            i20 = iArr[i21];
                                        }
                                    }
                                    int i22 = i20 + 1;
                                    int[] iArr2 = new int[i22];
                                    int i23 = 0;
                                    while (i23 < i22) {
                                        iArr2[i23] = vorbisBitArray.b(i17) + 1;
                                        int iB7 = vorbisBitArray.b(2);
                                        int i24 = 8;
                                        if (iB7 > 0) {
                                            vorbisBitArray.c(8);
                                        }
                                        int i25 = iB3;
                                        int i26 = 0;
                                        for (int i27 = 1; i26 < (i27 << iB7); i27 = 1) {
                                            vorbisBitArray.c(i24);
                                            i26++;
                                            i24 = 8;
                                        }
                                        i23++;
                                        i17 = 3;
                                        iB3 = i25;
                                    }
                                    i2 = iB3;
                                    vorbisBitArray.c(2);
                                    int iB8 = vorbisBitArray.b(4);
                                    int i28 = 0;
                                    int i29 = 0;
                                    for (int i30 = 0; i30 < iB6; i30++) {
                                        i28 += iArr2[iArr[i30]];
                                        while (i29 < i28) {
                                            vorbisBitArray.c(iB8);
                                            i29++;
                                        }
                                    }
                                }
                                i16++;
                                i13 = 6;
                                i15 = 1;
                                i12 = 16;
                                iB3 = i2;
                            } else {
                                int i31 = 1;
                                int iB9 = vorbisBitArray.b(i13) + 1;
                                int i32 = 0;
                                while (i32 < iB9) {
                                    if (vorbisBitArray.b(16) > 2) {
                                        throw ParserException.a("residueType greater than 2 is not decodable", null);
                                    }
                                    vorbisBitArray.c(24);
                                    vorbisBitArray.c(24);
                                    vorbisBitArray.c(24);
                                    int iB10 = vorbisBitArray.b(i13) + i31;
                                    int i33 = 8;
                                    vorbisBitArray.c(8);
                                    int[] iArr3 = new int[iB10];
                                    for (int i34 = 0; i34 < iB10; i34++) {
                                        iArr3[i34] = ((vorbisBitArray.a() ? vorbisBitArray.b(5) : 0) * 8) + vorbisBitArray.b(3);
                                    }
                                    int i35 = 0;
                                    while (i35 < iB10) {
                                        int i36 = 0;
                                        while (i36 < i33) {
                                            if ((iArr3[i35] & (1 << i36)) != 0) {
                                                vorbisBitArray.c(i33);
                                            }
                                            i36++;
                                            i33 = 8;
                                        }
                                        i35++;
                                        i33 = 8;
                                    }
                                    i32++;
                                    i13 = 6;
                                    i31 = 1;
                                }
                                int iB11 = vorbisBitArray.b(i13) + 1;
                                for (int i37 = 0; i37 < iB11; i37++) {
                                    int iB12 = vorbisBitArray.b(16);
                                    if (iB12 != 0) {
                                        StringBuilder sb = new StringBuilder(52);
                                        sb.append("mapping type other than 0 not supported: ");
                                        sb.append(iB12);
                                        Log.e("VorbisUtil", sb.toString());
                                    } else {
                                        if (vorbisBitArray.a()) {
                                            i = 1;
                                            iB = vorbisBitArray.b(4) + 1;
                                        } else {
                                            i = 1;
                                            iB = 1;
                                        }
                                        if (vorbisBitArray.a()) {
                                            int iB13 = vorbisBitArray.b(8) + i;
                                            for (int i38 = 0; i38 < iB13; i38++) {
                                                int i39 = i9 - 1;
                                                vorbisBitArray.c(AnimatableValueParser.M0(i39));
                                                vorbisBitArray.c(AnimatableValueParser.M0(i39));
                                            }
                                        }
                                        if (vorbisBitArray.b(2) != 0) {
                                            throw ParserException.a("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iB > 1) {
                                            for (int i40 = 0; i40 < i9; i40++) {
                                                vorbisBitArray.c(4);
                                            }
                                        }
                                        for (int i41 = 0; i41 < iB; i41++) {
                                            vorbisBitArray.c(8);
                                            vorbisBitArray.c(8);
                                            vorbisBitArray.c(8);
                                        }
                                    }
                                }
                                int iB14 = vorbisBitArray.b(6) + 1;
                                VorbisUtil[] vorbisUtilArr = new VorbisUtil[iB14];
                                for (int i42 = 0; i42 < iB14; i42++) {
                                    vorbisUtilArr[i42] = new VorbisUtil(vorbisBitArray.a(), vorbisBitArray.b(16), vorbisBitArray.b(16), vorbisBitArray.b(8));
                                }
                                if (!vorbisBitArray.a()) {
                                    throw ParserException.a("framing bit after modes not set as expected", null);
                                }
                                aVar = new a(vorbisUtil2, vorbisUtil32, bArr2, vorbisUtilArr, AnimatableValueParser.M0(iB14 - 1));
                            }
                        }
                    } else {
                        if (vorbisBitArray.b(24) != 5653314) {
                            throw outline.w0(66, "expected code book to start with [0x56, 0x43, 0x42] at ", (vorbisBitArray.c * 8) + vorbisBitArray.d, null);
                        }
                        int iB15 = vorbisBitArray.b(16);
                        int iB16 = vorbisBitArray.b(24);
                        long[] jArr = new long[iB16];
                        if (vorbisBitArray.a()) {
                            i3 = iT3;
                            int iB17 = vorbisBitArray.b(5) + 1;
                            int i43 = 0;
                            while (i43 < iB16) {
                                int iB18 = vorbisBitArray.b(AnimatableValueParser.M0(iB16 - i43));
                                int i44 = 0;
                                while (i44 < iB18 && i43 < iB16) {
                                    jArr[i43] = iB17;
                                    i43++;
                                    i44++;
                                    vorbisUtil3 = vorbisUtil3;
                                    bArr = bArr;
                                }
                                iB17++;
                                vorbisUtil3 = vorbisUtil3;
                                bArr = bArr;
                            }
                        } else {
                            boolean zA = vorbisBitArray.a();
                            int i45 = 0;
                            while (i45 < iB16) {
                                if (!zA) {
                                    i4 = iT3;
                                    jArr[i45] = vorbisBitArray.b(5) + 1;
                                } else if (vorbisBitArray.a()) {
                                    i4 = iT3;
                                    jArr[i45] = vorbisBitArray.b(i10) + 1;
                                } else {
                                    i4 = iT3;
                                    jArr[i45] = 0;
                                }
                                i45++;
                                i10 = 5;
                                iT3 = i4;
                            }
                            i3 = iT3;
                        }
                        VorbisUtil3 vorbisUtil33 = vorbisUtil3;
                        byte[] bArr3 = bArr;
                        int iB19 = vorbisBitArray.b(4);
                        if (iB19 > 2) {
                            throw outline.w0(53, "lookup type greater than 2 not decodable: ", iB19, null);
                        }
                        if (iB19 == 1 || iB19 == 2) {
                            vorbisBitArray.c(32);
                            vorbisBitArray.c(32);
                            int iB20 = vorbisBitArray.b(4) + 1;
                            vorbisBitArray.c(1);
                            vorbisBitArray.c((int) (iB20 * (iB19 == 1 ? iB15 != 0 ? (long) Math.floor(Math.pow(iB16, 1.0d / iB15)) : 0L : iB16 * iB15)));
                        }
                        i11++;
                        i10 = 5;
                        iT3 = i3;
                        vorbisUtil3 = vorbisUtil33;
                        bArr = bArr3;
                    }
                }
            }
        }
        aVar = null;
        this.n = aVar;
        if (aVar == null) {
            return true;
        }
        VorbisUtil2 vorbisUtil22 = aVar.a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(vorbisUtil22.g);
        arrayList.add(aVar.f1241b);
        Format2.b bVar2 = new Format2.b();
        bVar2.k = "audio/vorbis";
        bVar2.f = vorbisUtil22.d;
        bVar2.g = vorbisUtil22.c;
        bVar2.f1023x = vorbisUtil22.a;
        bVar2.f1024y = vorbisUtil22.f1163b;
        bVar2.m = arrayList;
        bVar.a = bVar2.a();
        return true;
    }

    @Override // b.i.a.c.x2.j0.StreamReader
    public void e(boolean z2) {
        super.e(z2);
        if (z2) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }
}
