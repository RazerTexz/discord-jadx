package b.i.a.c.x2.h0;

import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.t2.MpegAudioUtil;
import b.i.a.c.x2.DummyTrackOutput;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.GaplessInfoHolder;
import b.i.a.c.x2.Id3Peeker;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.h0.Seeker;
import b.i.a.c.z2.k.Id3Decoder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* compiled from: Mp3Extractor.java */
/* renamed from: b.i.a.c.x2.h0.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class Mp3Extractor implements Extractor {
    public static final Id3Decoder.a a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1205b;
    public final long c;
    public final ParsableByteArray d;
    public final MpegAudioUtil.a e;
    public final GaplessInfoHolder f;
    public final Id3Peeker g;
    public final TrackOutput2 h;
    public ExtractorOutput i;
    public TrackOutput2 j;
    public TrackOutput2 k;
    public int l;

    @Nullable
    public Metadata m;
    public long n;
    public long o;
    public long p;
    public int q;
    public Seeker r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1206s;
    public boolean t;
    public long u;

    static {
        a aVar = a.a;
        a = b.a;
    }

    public Mp3Extractor() {
        this(0);
    }

    public static long d(@Nullable Metadata metadata) {
        if (metadata == null) {
            return -9223372036854775807L;
        }
        int length = metadata.j.length;
        for (int i = 0; i < length; i++) {
            Metadata.Entry entry = metadata.j[i];
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                if (textInformationFrame.j.equals("TLEN")) {
                    return Util2.B(Long.parseLong(textInformationFrame.l));
                }
            }
        }
        return -9223372036854775807L;
    }

    public static boolean h(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    public final long a(long j) {
        return ((j * 1000000) / this.e.d) + this.n;
    }

    @Override // b.i.a.c.x2.Extractor
    public boolean b(ExtractorInput extractorInput) throws IOException {
        return j(extractorInput, true);
    }

    public final Seeker c(ExtractorInput extractorInput, boolean z2) throws IOException {
        extractorInput.o(this.d.a, 0, 4);
        this.d.E(0);
        this.e.a(this.d.f());
        return new ConstantBitrateSeeker(extractorInput.b(), extractorInput.getPosition(), this.e, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    @Override // b.i.a.c.x2.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Mp3Extractor mp3Extractor;
        int i;
        ExtractorInput extractorInput2;
        int iB;
        int i2;
        Seeker seekerC;
        int iW;
        XingSeeker xingSeeker;
        MlltSeeker mlltSeeker;
        long jD;
        long jI;
        long jA;
        int iT;
        AnimatableValueParser.H(this.j);
        int i3 = Util2.a;
        if (this.l == 0) {
            try {
                j(extractorInput, false);
                if (this.r != null) {
                    ParsableByteArray parsableByteArray = new ParsableByteArray(this.e.c);
                    extractorInput.o(parsableByteArray.a, 0, this.e.c);
                    MpegAudioUtil.a aVar = this.e;
                    int i4 = 21;
                    if ((aVar.a & 1) != 0) {
                        if (aVar.e != 1) {
                            i4 = 36;
                        }
                    } else if (aVar.e == 1) {
                        i4 = 13;
                    }
                    if (parsableByteArray.c >= i4 + 4) {
                        parsableByteArray.E(i4);
                        int iF = parsableByteArray.f();
                        if (iF != 1483304551 && iF != 1231971951) {
                            if (parsableByteArray.c >= 40) {
                                parsableByteArray.E(36);
                                iF = parsableByteArray.f() == 1447187017 ? 1447187017 : 0;
                            }
                        }
                        String str = ", ";
                        if (iF == 1483304551 || iF == 1231971951) {
                            mp3Extractor = this;
                            long jB = extractorInput.b();
                            long position = extractorInput.getPosition();
                            MpegAudioUtil.a aVar2 = mp3Extractor.e;
                            int i5 = aVar2.g;
                            int i6 = aVar2.d;
                            int iF2 = parsableByteArray.f();
                            if ((iF2 & 1) != 1 || (iW = parsableByteArray.w()) == 0) {
                                i2 = i4;
                                seekerC = null;
                            } else {
                                i2 = i4;
                                long jF = Util2.F(iW, i5 * 1000000, i6);
                                if ((iF2 & 6) != 6) {
                                    xingSeeker = new XingSeeker(position, aVar2.c, jF, -1L, null);
                                } else {
                                    long jU = parsableByteArray.u();
                                    long[] jArr = new long[100];
                                    for (int i7 = 0; i7 < 100; i7++) {
                                        jArr[i7] = parsableByteArray.t();
                                    }
                                    if (jB != -1) {
                                        long j = position + jU;
                                        if (jB != j) {
                                            StringBuilder sbR = outline.R(67, "XING data size mismatch: ", jB, ", ");
                                            sbR.append(j);
                                            Log.w("XingSeeker", sbR.toString());
                                        }
                                    }
                                    xingSeeker = new XingSeeker(position, aVar2.c, jF, jU, jArr);
                                }
                                seekerC = xingSeeker;
                            }
                            if (seekerC != null) {
                                GaplessInfoHolder gaplessInfoHolder = mp3Extractor.f;
                                if ((gaplessInfoHolder.f1294b == -1 || gaplessInfoHolder.c == -1) ? false : true) {
                                    extractorInput2 = extractorInput;
                                } else {
                                    extractorInput.k();
                                    extractorInput2 = extractorInput;
                                    extractorInput2.g(i2 + Opcodes.F2D);
                                    extractorInput2.o(mp3Extractor.d.a, 0, 3);
                                    mp3Extractor.d.E(0);
                                    GaplessInfoHolder gaplessInfoHolder2 = mp3Extractor.f;
                                    int iV = mp3Extractor.d.v();
                                    Objects.requireNonNull(gaplessInfoHolder2);
                                    int i8 = iV >> 12;
                                    int i9 = iV & 4095;
                                    if (i8 > 0 || i9 > 0) {
                                        gaplessInfoHolder2.f1294b = i8;
                                        gaplessInfoHolder2.c = i9;
                                    }
                                }
                                extractorInput2.l(mp3Extractor.e.c);
                                if (seekerC != null && !seekerC.c() && iF == 1231971951) {
                                    seekerC = mp3Extractor.c(extractorInput2, false);
                                }
                            }
                        } else if (iF == 1447187017) {
                            long jB2 = extractorInput.b();
                            long position2 = extractorInput.getPosition();
                            MpegAudioUtil.a aVar3 = this.e;
                            parsableByteArray.F(10);
                            int iF3 = parsableByteArray.f();
                            if (iF3 <= 0) {
                                seekerC = null;
                                mp3Extractor = this;
                                extractorInput.l(mp3Extractor.e.c);
                                extractorInput2 = extractorInput;
                            } else {
                                int i10 = aVar3.d;
                                long jF2 = Util2.F(iF3, (i10 >= 32000 ? 1152 : 576) * 1000000, i10);
                                int iY = parsableByteArray.y();
                                int iY2 = parsableByteArray.y();
                                int iY3 = parsableByteArray.y();
                                parsableByteArray.F(2);
                                long j2 = aVar3.c + position2;
                                long[] jArr2 = new long[iY];
                                long[] jArr3 = new long[iY];
                                int i11 = 0;
                                long j3 = position2;
                                while (i11 < iY) {
                                    String str2 = str;
                                    long j4 = jB2;
                                    jArr2[i11] = (i11 * jF2) / iY;
                                    jArr3[i11] = Math.max(j3, j2);
                                    if (iY3 == 1) {
                                        iT = parsableByteArray.t();
                                    } else if (iY3 == 2) {
                                        iT = parsableByteArray.y();
                                    } else if (iY3 == 3) {
                                        iT = parsableByteArray.v();
                                    } else {
                                        if (iY3 != 4) {
                                            seekerC = null;
                                            break;
                                        }
                                        iT = parsableByteArray.w();
                                    }
                                    j3 += iT * iY2;
                                    i11++;
                                    str = str2;
                                    jB2 = j4;
                                }
                                String str3 = str;
                                long j5 = jB2;
                                if (j5 != -1 && j5 != j3) {
                                    StringBuilder sbR2 = outline.R(67, "VBRI data size mismatch: ", j5, str3);
                                    sbR2.append(j3);
                                    Log.w("VbriSeeker", sbR2.toString());
                                }
                                seekerC = new VbriSeeker(jArr2, jArr3, jF2, j3);
                                mp3Extractor = this;
                                extractorInput.l(mp3Extractor.e.c);
                                extractorInput2 = extractorInput;
                            }
                        } else {
                            mp3Extractor = this;
                            extractorInput.k();
                            extractorInput2 = extractorInput;
                            seekerC = null;
                        }
                        Metadata metadata = mp3Extractor.m;
                        long position3 = extractorInput.getPosition();
                        if (metadata != null) {
                            int length = metadata.j.length;
                            for (int i12 = 0; i12 < length; i12++) {
                                Metadata.Entry entry = metadata.j[i12];
                                if (entry instanceof MlltFrame) {
                                    long jD2 = d(metadata);
                                    int length2 = ((MlltFrame) entry).n.length;
                                    int i13 = length2 + 1;
                                    long[] jArr4 = new long[i13];
                                    long[] jArr5 = new long[i13];
                                    jArr4[0] = position3;
                                    jArr5[0] = 0;
                                    long j6 = 0;
                                    for (int i14 = 1; i14 <= length2; i14++) {
                                        int i15 = i14 - 1;
                                        position3 += r8.l + r8.n[i15];
                                        j6 += r8.m + r8.o[i15];
                                        jArr4[i14] = position3;
                                        jArr5[i14] = j6;
                                    }
                                    mlltSeeker = new MlltSeeker(jArr4, jArr5, jD2);
                                    if (mp3Extractor.f1206s) {
                                        seekerC = new Seeker.a();
                                    } else {
                                        if ((mp3Extractor.f1205b & 4) != 0) {
                                            if (mlltSeeker != null) {
                                                jD = mlltSeeker.c;
                                            } else if (seekerC != null) {
                                                jI = seekerC.i();
                                                jA = seekerC.a();
                                                seekerC = new IndexSeeker(jI, extractorInput.getPosition(), jA);
                                            } else {
                                                jD = d(mp3Extractor.m);
                                            }
                                            jI = jD;
                                            jA = -1;
                                            seekerC = new IndexSeeker(jI, extractorInput.getPosition(), jA);
                                        } else if (mlltSeeker != null) {
                                            seekerC = mlltSeeker;
                                        } else if (seekerC == null) {
                                            seekerC = null;
                                        }
                                        if (seekerC == null || (!seekerC.c() && (mp3Extractor.f1205b & 1) != 0)) {
                                            seekerC = mp3Extractor.c(extractorInput2, (mp3Extractor.f1205b & 2) != 0);
                                        }
                                    }
                                    mp3Extractor.r = seekerC;
                                    mp3Extractor.i.a(seekerC);
                                    TrackOutput2 trackOutput2 = mp3Extractor.k;
                                    Format2.b bVar = new Format2.b();
                                    MpegAudioUtil.a aVar4 = mp3Extractor.e;
                                    bVar.k = aVar4.f1116b;
                                    bVar.l = 4096;
                                    bVar.f1023x = aVar4.e;
                                    bVar.f1024y = aVar4.d;
                                    GaplessInfoHolder gaplessInfoHolder3 = mp3Extractor.f;
                                    bVar.A = gaplessInfoHolder3.f1294b;
                                    bVar.B = gaplessInfoHolder3.c;
                                    bVar.i = (mp3Extractor.f1205b & 8) != 0 ? null : mp3Extractor.m;
                                    trackOutput2.e(bVar.a());
                                    mp3Extractor.p = extractorInput.getPosition();
                                }
                            }
                            mlltSeeker = null;
                            if (mp3Extractor.f1206s) {
                            }
                            mp3Extractor.r = seekerC;
                            mp3Extractor.i.a(seekerC);
                            TrackOutput2 trackOutput22 = mp3Extractor.k;
                            Format2.b bVar2 = new Format2.b();
                            MpegAudioUtil.a aVar42 = mp3Extractor.e;
                            bVar2.k = aVar42.f1116b;
                            bVar2.l = 4096;
                            bVar2.f1023x = aVar42.e;
                            bVar2.f1024y = aVar42.d;
                            GaplessInfoHolder gaplessInfoHolder32 = mp3Extractor.f;
                            bVar2.A = gaplessInfoHolder32.f1294b;
                            bVar2.B = gaplessInfoHolder32.c;
                            bVar2.i = (mp3Extractor.f1205b & 8) != 0 ? null : mp3Extractor.m;
                            trackOutput22.e(bVar2.a());
                            mp3Extractor.p = extractorInput.getPosition();
                        } else {
                            mlltSeeker = null;
                            if (mp3Extractor.f1206s) {
                            }
                            mp3Extractor.r = seekerC;
                            mp3Extractor.i.a(seekerC);
                            TrackOutput2 trackOutput222 = mp3Extractor.k;
                            Format2.b bVar22 = new Format2.b();
                            MpegAudioUtil.a aVar422 = mp3Extractor.e;
                            bVar22.k = aVar422.f1116b;
                            bVar22.l = 4096;
                            bVar22.f1023x = aVar422.e;
                            bVar22.f1024y = aVar422.d;
                            GaplessInfoHolder gaplessInfoHolder322 = mp3Extractor.f;
                            bVar22.A = gaplessInfoHolder322.f1294b;
                            bVar22.B = gaplessInfoHolder322.c;
                            bVar22.i = (mp3Extractor.f1205b & 8) != 0 ? null : mp3Extractor.m;
                            trackOutput222.e(bVar22.a());
                            mp3Extractor.p = extractorInput.getPosition();
                        }
                    }
                } else {
                    extractorInput2 = extractorInput;
                    mp3Extractor = this;
                    if (mp3Extractor.p != 0) {
                        long position4 = extractorInput.getPosition();
                        long j7 = mp3Extractor.p;
                        if (position4 < j7) {
                            extractorInput2.l((int) (j7 - position4));
                        }
                    }
                }
            } catch (EOFException unused) {
                mp3Extractor = this;
            }
            if (mp3Extractor.q != 0) {
                extractorInput.k();
                if (!i(extractorInput)) {
                    mp3Extractor.d.E(0);
                    int iF4 = mp3Extractor.d.f();
                    if (!h(iF4, mp3Extractor.l) || MpegAudioUtil.a(iF4) == -1) {
                        extractorInput2.l(1);
                        mp3Extractor.l = 0;
                        i = 0;
                    } else {
                        mp3Extractor.e.a(iF4);
                        if (mp3Extractor.n == -9223372036854775807L) {
                            mp3Extractor.n = mp3Extractor.r.d(extractorInput.getPosition());
                            if (mp3Extractor.c != -9223372036854775807L) {
                                mp3Extractor.n = (mp3Extractor.c - mp3Extractor.r.d(0L)) + mp3Extractor.n;
                            }
                        }
                        mp3Extractor.q = mp3Extractor.e.c;
                        Seeker seeker = mp3Extractor.r;
                        if (seeker instanceof IndexSeeker) {
                            IndexSeeker indexSeeker = (IndexSeeker) seeker;
                            long jA2 = mp3Extractor.a(mp3Extractor.o + r0.g);
                            long position5 = extractorInput.getPosition() + mp3Extractor.e.c;
                            if (!indexSeeker.b(jA2)) {
                                indexSeeker.f1203b.a(jA2);
                                indexSeeker.c.a(position5);
                            }
                            if (mp3Extractor.t && indexSeeker.b(mp3Extractor.u)) {
                                mp3Extractor.t = false;
                                mp3Extractor.k = mp3Extractor.j;
                            }
                        }
                        iB = mp3Extractor.k.b(extractorInput2, mp3Extractor.q, true);
                        if (iB != -1) {
                            int i16 = mp3Extractor.q - iB;
                            mp3Extractor.q = i16;
                            if (i16 <= 0) {
                                mp3Extractor.k.d(mp3Extractor.a(mp3Extractor.o), 1, mp3Extractor.e.c, 0, null);
                                mp3Extractor.o += mp3Extractor.e.g;
                                mp3Extractor.q = 0;
                            }
                            i = 0;
                        }
                    }
                }
                i = -1;
            } else {
                iB = mp3Extractor.k.b(extractorInput2, mp3Extractor.q, true);
                if (iB != -1) {
                }
                i = -1;
            }
        } else {
            if (this.r != null) {
            }
            if (mp3Extractor.q != 0) {
            }
        }
        if (i == -1 && (mp3Extractor.r instanceof IndexSeeker)) {
            long jA3 = mp3Extractor.a(mp3Extractor.o);
            if (mp3Extractor.r.i() != jA3) {
                Seeker seeker2 = mp3Extractor.r;
                ((IndexSeeker) seeker2).d = jA3;
                mp3Extractor.i.a(seeker2);
            }
        }
        return i;
    }

    @Override // b.i.a.c.x2.Extractor
    public void f(ExtractorOutput extractorOutput) {
        this.i = extractorOutput;
        TrackOutput2 trackOutput2P = extractorOutput.p(0, 1);
        this.j = trackOutput2P;
        this.k = trackOutput2P;
        this.i.j();
    }

    @Override // b.i.a.c.x2.Extractor
    public void g(long j, long j2) {
        this.l = 0;
        this.n = -9223372036854775807L;
        this.o = 0L;
        this.q = 0;
        this.u = j2;
        Seeker seeker = this.r;
        if (!(seeker instanceof IndexSeeker) || ((IndexSeeker) seeker).b(j2)) {
            return;
        }
        this.t = true;
        this.k = this.h;
    }

    public final boolean i(ExtractorInput extractorInput) throws IOException {
        Seeker seeker = this.r;
        if (seeker != null) {
            long jA = seeker.a();
            if (jA != -1 && extractorInput.f() > jA - 4) {
                return true;
            }
        }
        try {
            return !extractorInput.e(this.d.a, 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    public final boolean j(ExtractorInput extractorInput, boolean z2) throws IOException {
        int i;
        int iF;
        int iA;
        int i2 = z2 ? 32768 : 131072;
        extractorInput.k();
        if (extractorInput.getPosition() == 0) {
            Metadata metadataA = this.g.a(extractorInput, (this.f1205b & 8) == 0 ? null : a);
            this.m = metadataA;
            if (metadataA != null) {
                this.f.b(metadataA);
            }
            iF = (int) extractorInput.f();
            if (!z2) {
                extractorInput.l(iF);
            }
            i = 0;
        } else {
            i = 0;
            iF = 0;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (!i(extractorInput)) {
                this.d.E(0);
                int iF2 = this.d.f();
                if ((i == 0 || h(iF2, i)) && (iA = MpegAudioUtil.a(iF2)) != -1) {
                    i3++;
                    if (i3 != 1) {
                        if (i3 == 4) {
                            break;
                        }
                    } else {
                        this.e.a(iF2);
                        i = iF2;
                    }
                    extractorInput.g(iA - 4);
                } else {
                    int i5 = i4 + 1;
                    if (i4 == i2) {
                        if (z2) {
                            return false;
                        }
                        throw ParserException.a("Searched too many bytes.", null);
                    }
                    if (z2) {
                        extractorInput.k();
                        extractorInput.g(iF + i5);
                    } else {
                        extractorInput.l(1);
                    }
                    i4 = i5;
                    i = 0;
                    i3 = 0;
                }
            } else if (i3 <= 0) {
                throw new EOFException();
            }
        }
        if (z2) {
            extractorInput.l(iF + i4);
        } else {
            extractorInput.k();
        }
        this.l = i;
        return true;
    }

    @Override // b.i.a.c.x2.Extractor
    public void release() {
    }

    public Mp3Extractor(int i) {
        this.f1205b = (i & 2) != 0 ? i | 1 : i;
        this.c = -9223372036854775807L;
        this.d = new ParsableByteArray(10);
        this.e = new MpegAudioUtil.a();
        this.f = new GaplessInfoHolder();
        this.n = -9223372036854775807L;
        this.g = new Id3Peeker();
        DummyTrackOutput dummyTrackOutput = new DummyTrackOutput();
        this.h = dummyTrackOutput;
        this.k = dummyTrackOutput;
    }
}
