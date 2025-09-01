package b.i.a.c.x2.k0;

import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.t2.AacUtil;
import b.i.a.c.x2.DummyTrackOutput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;
import com.google.android.exoplayer2.ParserException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/* compiled from: AdtsReader.java */
/* renamed from: b.i.a.c.x2.k0.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class AdtsReader implements ElementaryStreamReader {
    public static final byte[] a = {73, 68, 51};

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1262b;
    public final ParsableBitArray c = new ParsableBitArray(new byte[7]);
    public final ParsableByteArray d = new ParsableByteArray(Arrays.copyOf(a, 10));

    @Nullable
    public final String e;
    public String f;
    public TrackOutput2 g;
    public TrackOutput2 h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public long r;

    /* renamed from: s, reason: collision with root package name */
    public int f1263s;
    public long t;
    public TrackOutput2 u;
    public long v;

    public AdtsReader(boolean z2, @Nullable String str) {
        h();
        this.n = -1;
        this.o = -1;
        this.r = -9223372036854775807L;
        this.t = -9223372036854775807L;
        this.f1262b = z2;
        this.e = str;
    }

    public static boolean g(int i) {
        return (i & 65526) == 65520;
    }

    public final boolean a(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int iMin = Math.min(parsableByteArray.a(), i - this.j);
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, this.j, iMin);
        parsableByteArray.f984b += iMin;
        int i2 = this.j + iMin;
        this.j = i2;
        return i2 == i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x0275, code lost:
    
        r17.p = (r11 & 8) >> 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x027c, code lost:
    
        if ((r11 & 1) != 0) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x027e, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0280, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0281, code lost:
    
        r17.l = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0285, code lost:
    
        if (r17.m != false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0287, code lost:
    
        r17.i = 1;
        r17.j = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x028d, code lost:
    
        r17.i = 3;
        r17.j = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0292, code lost:
    
        r18.E(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0275 A[EDGE_INSN: B:160:0x0275->B:111:0x0275 BREAK  A[LOOP:1: B:52:0x01a6->B:137:0x02e4], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x021d  */
    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ParsableByteArray parsableByteArray) throws ParserException {
        int i;
        boolean z2;
        int i2;
        int i3;
        int i4;
        Objects.requireNonNull(this.g);
        int i5 = Util2.a;
        while (parsableByteArray.a() > 0) {
            int i6 = this.i;
            int i7 = 13;
            int i8 = 2;
            if (i6 == 0) {
                byte[] bArr = parsableByteArray.a;
                int i9 = parsableByteArray.f984b;
                int i10 = parsableByteArray.c;
                while (true) {
                    if (i9 >= i10) {
                        parsableByteArray.E(i9);
                        break;
                    }
                    int i11 = i9 + 1;
                    int i12 = bArr[i9] & 255;
                    if (this.k != 512 || !g((((byte) i12) & 255) | 65280)) {
                        int i13 = this.k;
                        i = i12 | i13;
                        if (i == 329) {
                            this.k = 768;
                        } else if (i == 511) {
                            this.k = 512;
                        } else if (i == 836) {
                            this.k = 1024;
                        } else {
                            if (i == 1075) {
                                this.i = 2;
                                this.j = a.length;
                                this.f1263s = 0;
                                this.d.E(0);
                                parsableByteArray.E(i11);
                                break;
                            }
                            if (i13 != 256) {
                                this.k = 256;
                                i9 = i11 - 1;
                                i7 = 13;
                                i8 = 2;
                            }
                        }
                        i9 = i11;
                        i7 = 13;
                        i8 = 2;
                    } else {
                        if (this.m) {
                            break;
                        }
                        int i14 = i11 - 2;
                        parsableByteArray.E(i14 + 1);
                        if (i(parsableByteArray, this.c.a, 1)) {
                            this.c.k(4);
                            int iG = this.c.g(1);
                            int i15 = this.n;
                            if (i15 == -1 || iG == i15) {
                                if (this.o == -1) {
                                    if (i(parsableByteArray, this.c.a, 4)) {
                                        this.c.k(14);
                                        int iG2 = this.c.g(i7);
                                        if (iG2 >= 7) {
                                            byte[] bArr2 = parsableByteArray.a;
                                            int i16 = parsableByteArray.c;
                                            int i17 = i14 + iG2;
                                            if (i17 < i16 && (bArr2[i17] != -1 ? !(bArr2[i17] == 73 && ((i2 = i17 + 1) == i16 || (bArr2[i2] == 68 && ((i3 = i17 + 2) == i16 || bArr2[i3] == 51)))) : !((i4 = i17 + 1) == i16 || (g((bArr2[i4] & 255) | 65280) && ((bArr2[i4] & 8) >> 3) == iG)))) {
                                            }
                                            if (z2) {
                                            }
                                            int i132 = this.k;
                                            i = i12 | i132;
                                            if (i == 329) {
                                            }
                                            i9 = i11;
                                            i7 = 13;
                                            i8 = 2;
                                        }
                                        z2 = false;
                                        if (z2) {
                                        }
                                        int i1322 = this.k;
                                        i = i12 | i1322;
                                        if (i == 329) {
                                        }
                                        i9 = i11;
                                        i7 = 13;
                                        i8 = 2;
                                    }
                                    z2 = true;
                                    if (z2) {
                                    }
                                    int i13222 = this.k;
                                    i = i12 | i13222;
                                    if (i == 329) {
                                    }
                                    i9 = i11;
                                    i7 = 13;
                                    i8 = 2;
                                } else {
                                    if (i(parsableByteArray, this.c.a, 1)) {
                                        this.c.k(i8);
                                        if (this.c.g(4) == this.o) {
                                            parsableByteArray.E(i14 + 2);
                                            if (i(parsableByteArray, this.c.a, 4)) {
                                            }
                                        }
                                        z2 = false;
                                        if (z2) {
                                        }
                                        int i132222 = this.k;
                                        i = i12 | i132222;
                                        if (i == 329) {
                                        }
                                        i9 = i11;
                                        i7 = 13;
                                        i8 = 2;
                                    }
                                    z2 = true;
                                    if (z2) {
                                    }
                                    int i1322222 = this.k;
                                    i = i12 | i1322222;
                                    if (i == 329) {
                                    }
                                    i9 = i11;
                                    i7 = 13;
                                    i8 = 2;
                                }
                            }
                        } else {
                            z2 = false;
                            if (z2) {
                                break;
                            }
                            int i13222222 = this.k;
                            i = i12 | i13222222;
                            if (i == 329) {
                            }
                            i9 = i11;
                            i7 = 13;
                            i8 = 2;
                        }
                    }
                }
            } else if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 == 3) {
                        if (a(parsableByteArray, this.c.a, this.l ? 7 : 5)) {
                            this.c.k(0);
                            if (this.q) {
                                this.c.m(10);
                            } else {
                                int iG3 = this.c.g(2) + 1;
                                if (iG3 != 2) {
                                    StringBuilder sb = new StringBuilder(61);
                                    sb.append("Detected audio object type: ");
                                    sb.append(iG3);
                                    sb.append(", but assuming AAC LC.");
                                    Log.w("AdtsReader", sb.toString());
                                    iG3 = 2;
                                }
                                this.c.m(5);
                                int iG4 = this.c.g(3);
                                int i18 = this.o;
                                byte[] bArr3 = {(byte) (((iG3 << 3) & 248) | ((i18 >> 1) & 7)), (byte) (((i18 << 7) & 128) | ((iG4 << 3) & 120))};
                                AacUtil.b bVarB = AacUtil.b(new ParsableBitArray(bArr3), false);
                                Format2.b bVar = new Format2.b();
                                bVar.a = this.f;
                                bVar.k = "audio/mp4a-latm";
                                bVar.h = bVarB.c;
                                bVar.f1023x = bVarB.f1122b;
                                bVar.f1024y = bVarB.a;
                                bVar.m = Collections.singletonList(bArr3);
                                bVar.c = this.e;
                                Format2 format2A = bVar.a();
                                this.r = 1024000000 / format2A.K;
                                this.g.e(format2A);
                                this.q = true;
                            }
                            this.c.m(4);
                            int iG5 = (this.c.g(13) - 2) - 5;
                            if (this.l) {
                                iG5 -= 2;
                            }
                            TrackOutput2 trackOutput2 = this.g;
                            long j = this.r;
                            this.i = 4;
                            this.j = 0;
                            this.u = trackOutput2;
                            this.v = j;
                            this.f1263s = iG5;
                        }
                    } else {
                        if (i6 != 4) {
                            throw new IllegalStateException();
                        }
                        int iMin = Math.min(parsableByteArray.a(), this.f1263s - this.j);
                        this.u.c(parsableByteArray, iMin);
                        int i19 = this.j + iMin;
                        this.j = i19;
                        int i20 = this.f1263s;
                        if (i19 == i20) {
                            long j2 = this.t;
                            if (j2 != -9223372036854775807L) {
                                this.u.d(j2, 1, i20, 0, null);
                                this.t += this.v;
                            }
                            h();
                        }
                    }
                } else if (a(parsableByteArray, this.d.a, 10)) {
                    this.h.c(this.d, 10);
                    this.d.E(6);
                    TrackOutput2 trackOutput22 = this.h;
                    int iS = this.d.s() + 10;
                    this.i = 4;
                    this.j = 10;
                    this.u = trackOutput22;
                    this.v = 0L;
                    this.f1263s = iS;
                }
            } else if (parsableByteArray.a() != 0) {
                ParsableBitArray parsableBitArray = this.c;
                parsableBitArray.a[0] = parsableByteArray.a[parsableByteArray.f984b];
                parsableBitArray.k(2);
                int iG6 = this.c.g(4);
                int i21 = this.o;
                if (i21 == -1 || iG6 == i21) {
                    if (!this.m) {
                        this.m = true;
                        this.n = this.p;
                        this.o = iG6;
                    }
                    this.i = 3;
                    this.j = 0;
                } else {
                    this.m = false;
                    h();
                }
            }
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void c() {
        this.t = -9223372036854775807L;
        this.m = false;
        h();
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.a();
        this.f = dVar.b();
        TrackOutput2 trackOutput2P = extractorOutput.p(dVar.c(), 1);
        this.g = trackOutput2P;
        this.u = trackOutput2P;
        if (!this.f1262b) {
            this.h = new DummyTrackOutput();
            return;
        }
        dVar.a();
        TrackOutput2 trackOutput2P2 = extractorOutput.p(dVar.c(), 5);
        this.h = trackOutput2P2;
        Format2.b bVar = new Format2.b();
        bVar.a = dVar.b();
        bVar.k = "application/id3";
        trackOutput2P2.e(bVar.a());
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.t = j;
        }
    }

    public final void h() {
        this.i = 0;
        this.j = 0;
        this.k = 256;
    }

    public final boolean i(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        if (parsableByteArray.a() < i) {
            return false;
        }
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, i);
        parsableByteArray.f984b += i;
        return true;
    }
}
