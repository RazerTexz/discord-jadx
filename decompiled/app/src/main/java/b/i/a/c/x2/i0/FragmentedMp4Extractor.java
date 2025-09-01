package b.i.a.c.x2.i0;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.t2.Ac4Util;
import b.i.a.c.x2.ChunkIndex;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.GaplessInfoHolder;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.i0.Atom;
import b.i.a.c.z2.i.EventMessageEncoder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.objectweb.asm.Opcodes;

/* compiled from: FragmentedMp4Extractor.java */
/* renamed from: b.i.a.c.x2.i0.g, reason: use source file name */
/* loaded from: classes3.dex */
public class FragmentedMp4Extractor implements Extractor {
    public static final byte[] a = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};

    /* renamed from: b, reason: collision with root package name */
    public static final Format2 f1215b;
    public int A;
    public int B;
    public boolean C;
    public ExtractorOutput D;
    public TrackOutput2[] E;
    public TrackOutput2[] F;
    public boolean G;
    public final int c;
    public final List<Format2> d;
    public final SparseArray<b> e;
    public final ParsableByteArray f;
    public final ParsableByteArray g;
    public final ParsableByteArray h;
    public final byte[] i;
    public final ParsableByteArray j;
    public final EventMessageEncoder k;
    public final ParsableByteArray l;
    public final ArrayDeque<Atom.a> m;
    public final ArrayDeque<a> n;
    public int o;
    public int p;
    public long q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public ParsableByteArray f1216s;
    public long t;
    public int u;
    public long v;
    public long w;

    /* renamed from: x, reason: collision with root package name */
    public long f1217x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public b f1218y;

    /* renamed from: z, reason: collision with root package name */
    public int f1219z;

    /* compiled from: FragmentedMp4Extractor.java */
    /* renamed from: b.i.a.c.x2.i0.g$a */
    public static final class a {
        public final long a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1220b;

        public a(long j, int i) {
            this.a = j;
            this.f1220b = i;
        }
    }

    /* compiled from: FragmentedMp4Extractor.java */
    /* renamed from: b.i.a.c.x2.i0.g$b */
    public static final class b {
        public final TrackOutput2 a;
        public TrackSampleTable d;
        public DefaultSampleValues e;
        public int f;
        public int g;
        public int h;
        public int i;
        public boolean l;

        /* renamed from: b, reason: collision with root package name */
        public final TrackFragment f1221b = new TrackFragment();
        public final ParsableByteArray c = new ParsableByteArray();
        public final ParsableByteArray j = new ParsableByteArray(1);
        public final ParsableByteArray k = new ParsableByteArray();

        public b(TrackOutput2 trackOutput2, TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues) {
            this.a = trackOutput2;
            this.d = trackSampleTable;
            this.e = defaultSampleValues;
            this.d = trackSampleTable;
            this.e = defaultSampleValues;
            trackOutput2.e(trackSampleTable.a.f);
            e();
        }

        public long a() {
            return !this.l ? this.d.c[this.f] : this.f1221b.f[this.h];
        }

        @Nullable
        public TrackEncryptionBox b() {
            if (!this.l) {
                return null;
            }
            TrackFragment trackFragment = this.f1221b;
            DefaultSampleValues defaultSampleValues = trackFragment.a;
            int i = Util2.a;
            int i2 = defaultSampleValues.a;
            TrackEncryptionBox trackEncryptionBoxA = trackFragment.m;
            if (trackEncryptionBoxA == null) {
                trackEncryptionBoxA = this.d.a.a(i2);
            }
            if (trackEncryptionBoxA == null || !trackEncryptionBoxA.a) {
                return null;
            }
            return trackEncryptionBoxA;
        }

        public boolean c() {
            this.f++;
            if (!this.l) {
                return false;
            }
            int i = this.g + 1;
            this.g = i;
            int[] iArr = this.f1221b.g;
            int i2 = this.h;
            if (i != iArr[i2]) {
                return true;
            }
            this.h = i2 + 1;
            this.g = 0;
            return false;
        }

        public int d(int i, int i2) {
            ParsableByteArray parsableByteArray;
            TrackEncryptionBox trackEncryptionBoxB = b();
            if (trackEncryptionBoxB == null) {
                return 0;
            }
            int length = trackEncryptionBoxB.d;
            if (length != 0) {
                parsableByteArray = this.f1221b.n;
            } else {
                byte[] bArr = trackEncryptionBoxB.e;
                int i3 = Util2.a;
                ParsableByteArray parsableByteArray2 = this.k;
                int length2 = bArr.length;
                parsableByteArray2.a = bArr;
                parsableByteArray2.c = length2;
                parsableByteArray2.f984b = 0;
                length = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            TrackFragment trackFragment = this.f1221b;
            boolean z2 = trackFragment.k && trackFragment.l[this.f];
            boolean z3 = z2 || i2 != 0;
            ParsableByteArray parsableByteArray3 = this.j;
            parsableByteArray3.a[0] = (byte) ((z3 ? 128 : 0) | length);
            parsableByteArray3.E(0);
            this.a.f(this.j, 1, 1);
            this.a.f(parsableByteArray, length, 1);
            if (!z3) {
                return length + 1;
            }
            if (!z2) {
                this.c.A(8);
                ParsableByteArray parsableByteArray4 = this.c;
                byte[] bArr2 = parsableByteArray4.a;
                bArr2[0] = 0;
                bArr2[1] = 1;
                bArr2[2] = (byte) ((i2 >> 8) & 255);
                bArr2[3] = (byte) (i2 & 255);
                bArr2[4] = (byte) ((i >> 24) & 255);
                bArr2[5] = (byte) ((i >> 16) & 255);
                bArr2[6] = (byte) ((i >> 8) & 255);
                bArr2[7] = (byte) (i & 255);
                this.a.f(parsableByteArray4, 8, 1);
                return length + 1 + 8;
            }
            ParsableByteArray parsableByteArray5 = this.f1221b.n;
            int iY = parsableByteArray5.y();
            parsableByteArray5.F(-2);
            int i4 = (iY * 6) + 2;
            if (i2 != 0) {
                this.c.A(i4);
                byte[] bArr3 = this.c.a;
                parsableByteArray5.e(bArr3, 0, i4);
                int i5 = (((bArr3[2] & 255) << 8) | (bArr3[3] & 255)) + i2;
                bArr3[2] = (byte) ((i5 >> 8) & 255);
                bArr3[3] = (byte) (i5 & 255);
                parsableByteArray5 = this.c;
            }
            this.a.f(parsableByteArray5, i4, 1);
            return length + 1 + i4;
        }

        public void e() {
            TrackFragment trackFragment = this.f1221b;
            trackFragment.d = 0;
            trackFragment.p = 0L;
            trackFragment.q = false;
            trackFragment.k = false;
            trackFragment.o = false;
            trackFragment.m = null;
            this.f = 0;
            this.h = 0;
            this.g = 0;
            this.i = 0;
            this.l = false;
        }
    }

    static {
        Format2.b bVar = new Format2.b();
        bVar.k = "application/x-emsg";
        f1215b = bVar.a();
    }

    public FragmentedMp4Extractor(int i) {
        List listEmptyList = Collections.emptyList();
        this.c = i;
        this.d = Collections.unmodifiableList(listEmptyList);
        this.k = new EventMessageEncoder();
        this.l = new ParsableByteArray(16);
        this.f = new ParsableByteArray(NalUnitUtil.a);
        this.g = new ParsableByteArray(5);
        this.h = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.i = bArr;
        this.j = new ParsableByteArray(bArr);
        this.m = new ArrayDeque<>();
        this.n = new ArrayDeque<>();
        this.e = new SparseArray<>();
        this.w = -9223372036854775807L;
        this.v = -9223372036854775807L;
        this.f1217x = -9223372036854775807L;
        this.D = ExtractorOutput.d;
        this.E = new TrackOutput2[0];
        this.F = new TrackOutput2[0];
    }

    public static int a(int i) throws ParserException {
        if (i >= 0) {
            return i;
        }
        throw outline.w0(38, "Unexpected negative value: ", i, null);
    }

    @Nullable
    public static DrmInitData h(List<Atom.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Atom.b bVar = list.get(i);
            if (bVar.a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.f1210b.a;
                PsshAtomUtil psshAtomUtilV1 = AnimatableValueParser.v1(bArr);
                UUID uuid = psshAtomUtilV1 == null ? null : psshAtomUtilV1.a;
                if (uuid == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuid, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(null, false, (DrmInitData.SchemeData[]) arrayList.toArray(new DrmInitData.SchemeData[0]));
    }

    public static void i(ParsableByteArray parsableByteArray, int i, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.E(i + 8);
        int iF = parsableByteArray.f() & ViewCompat.MEASURED_SIZE_MASK;
        if ((iF & 1) != 0) {
            throw ParserException.b("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z2 = (iF & 2) != 0;
        int iW = parsableByteArray.w();
        if (iW == 0) {
            Arrays.fill(trackFragment.l, 0, trackFragment.e, false);
            return;
        }
        int i2 = trackFragment.e;
        if (iW != i2) {
            throw ParserException.a(outline.h(80, "Senc sample count ", iW, " is different from fragment sample count", i2), null);
        }
        Arrays.fill(trackFragment.l, 0, iW, z2);
        int iA = parsableByteArray.a();
        ParsableByteArray parsableByteArray2 = trackFragment.n;
        byte[] bArr = parsableByteArray2.a;
        if (bArr.length < iA) {
            bArr = new byte[iA];
        }
        parsableByteArray2.a = bArr;
        parsableByteArray2.c = iA;
        parsableByteArray2.f984b = 0;
        trackFragment.k = true;
        trackFragment.o = true;
        parsableByteArray.e(bArr, 0, iA);
        trackFragment.n.E(0);
        trackFragment.o = false;
    }

    @Override // b.i.a.c.x2.Extractor
    public boolean b(ExtractorInput extractorInput) throws IOException {
        return Sniffer2.a(extractorInput, true, false);
    }

    public final void c() {
        this.o = 0;
        this.r = 0;
    }

    public final DefaultSampleValues d(SparseArray<DefaultSampleValues> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        DefaultSampleValues defaultSampleValues = sparseArray.get(i);
        Objects.requireNonNull(defaultSampleValues);
        return defaultSampleValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0236 A[LOOP:10: B:106:0x0236->B:108:0x023c, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x02cb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0759 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0762 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ca  */
    @Override // b.i.a.c.x2.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i;
        int iB;
        String strN;
        String strN2;
        long jF;
        long j;
        long jU;
        long jX;
        long jX2;
        long j2;
        boolean z2;
        while (true) {
            int i2 = this.o;
            int i3 = 1;
            if (i2 != 0) {
                if (i2 == 1) {
                    int i4 = ((int) this.q) - this.r;
                    ParsableByteArray parsableByteArray = this.f1216s;
                    if (parsableByteArray != null) {
                        extractorInput.readFully(parsableByteArray.a, 8, i4);
                        int i5 = this.p;
                        Atom.b bVar = new Atom.b(i5, parsableByteArray);
                        long position = extractorInput.getPosition();
                        if (!this.m.isEmpty()) {
                            this.m.peek().c.add(bVar);
                        } else if (i5 == 1936286840) {
                            parsableByteArray.E(8);
                            int iF = (parsableByteArray.f() >> 24) & 255;
                            parsableByteArray.F(4);
                            long jU2 = parsableByteArray.u();
                            if (iF == 0) {
                                jX = parsableByteArray.u();
                                jX2 = parsableByteArray.u();
                            } else {
                                jX = parsableByteArray.x();
                                jX2 = parsableByteArray.x();
                            }
                            long j3 = position + jX2;
                            long jF2 = Util2.F(jX, 1000000L, jU2);
                            parsableByteArray.F(2);
                            int iY = parsableByteArray.y();
                            int[] iArr = new int[iY];
                            long[] jArr = new long[iY];
                            long[] jArr2 = new long[iY];
                            long[] jArr3 = new long[iY];
                            int i6 = 0;
                            long jF3 = jF2;
                            while (i6 < iY) {
                                int iF2 = parsableByteArray.f();
                                if ((iF2 & Integer.MIN_VALUE) != 0) {
                                    throw ParserException.a("Unhandled indirect reference", null);
                                }
                                long jU3 = parsableByteArray.u();
                                iArr[i6] = iF2 & Integer.MAX_VALUE;
                                jArr[i6] = j3;
                                jArr3[i6] = jF3;
                                long j4 = jX + jU3;
                                int i7 = i6;
                                int i8 = iY;
                                long[] jArr4 = jArr2;
                                long[] jArr5 = jArr3;
                                jF3 = Util2.F(j4, 1000000L, jU2);
                                jArr4[i7] = jF3 - jArr5[i7];
                                parsableByteArray.F(4);
                                j3 += iArr[i7];
                                i6 = i7 + 1;
                                jArr2 = jArr4;
                                jArr3 = jArr5;
                                jArr = jArr;
                                jX = j4;
                                iY = i8;
                            }
                            Pair pairCreate = Pair.create(Long.valueOf(jF2), new ChunkIndex(iArr, jArr, jArr2, jArr3));
                            this.f1217x = ((Long) pairCreate.first).longValue();
                            this.D.a((SeekMap) pairCreate.second);
                            this.G = true;
                        } else if (i5 == 1701671783 && this.E.length != 0) {
                            parsableByteArray.E(8);
                            int iF3 = (parsableByteArray.f() >> 24) & 255;
                            if (iF3 == 0) {
                                strN = parsableByteArray.n();
                                Objects.requireNonNull(strN);
                                strN2 = parsableByteArray.n();
                                Objects.requireNonNull(strN2);
                                long jU4 = parsableByteArray.u();
                                long jF4 = Util2.F(parsableByteArray.u(), 1000000L, jU4);
                                long j5 = this.f1217x;
                                j = j5 != -9223372036854775807L ? j5 + jF4 : -9223372036854775807L;
                                jF = Util2.F(parsableByteArray.u(), 1000L, jU4);
                                j = j;
                                j = jF4;
                                jU = parsableByteArray.u();
                            } else if (iF3 != 1) {
                                outline.g0(46, "Skipping unsupported emsg version: ", iF3, "FragmentedMp4Extractor");
                            } else {
                                long jU5 = parsableByteArray.u();
                                long jF5 = Util2.F(parsableByteArray.x(), 1000000L, jU5);
                                jF = Util2.F(parsableByteArray.u(), 1000L, jU5);
                                jU = parsableByteArray.u();
                                strN = parsableByteArray.n();
                                Objects.requireNonNull(strN);
                                strN2 = parsableByteArray.n();
                                Objects.requireNonNull(strN2);
                                j = jF5;
                            }
                            byte[] bArr = new byte[parsableByteArray.a()];
                            int iA = parsableByteArray.a();
                            System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, iA);
                            parsableByteArray.f984b += iA;
                            EventMessageEncoder eventMessageEncoder = this.k;
                            eventMessageEncoder.a.reset();
                            try {
                                DataOutputStream dataOutputStream = eventMessageEncoder.f1322b;
                                dataOutputStream.writeBytes(strN);
                                dataOutputStream.writeByte(0);
                                DataOutputStream dataOutputStream2 = eventMessageEncoder.f1322b;
                                dataOutputStream2.writeBytes(strN2);
                                dataOutputStream2.writeByte(0);
                                eventMessageEncoder.f1322b.writeLong(jF);
                                eventMessageEncoder.f1322b.writeLong(jU);
                                eventMessageEncoder.f1322b.write(bArr);
                                eventMessageEncoder.f1322b.flush();
                                ParsableByteArray parsableByteArray2 = new ParsableByteArray(eventMessageEncoder.a.toByteArray());
                                int iA2 = parsableByteArray2.a();
                                for (TrackOutput2 trackOutput2 : this.E) {
                                    parsableByteArray2.E(0);
                                    trackOutput2.c(parsableByteArray2, iA2);
                                }
                                if (j == -9223372036854775807L) {
                                    this.n.addLast(new a(j, iA2));
                                    this.u += iA2;
                                } else {
                                    for (TrackOutput2 trackOutput22 : this.E) {
                                        trackOutput22.d(j, 1, iA2, 0, null);
                                    }
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } else {
                        extractorInput.l(i4);
                    }
                    j(extractorInput.getPosition());
                } else if (i2 != 2) {
                    b bVar2 = this.f1218y;
                    if (bVar2 == null) {
                        SparseArray<b> sparseArray = this.e;
                        int size = sparseArray.size();
                        long j6 = Long.MAX_VALUE;
                        b bVar3 = null;
                        for (int i9 = 0; i9 < size; i9++) {
                            b bVarValueAt = sparseArray.valueAt(i9);
                            boolean z3 = bVarValueAt.l;
                            if ((z3 || bVarValueAt.f != bVarValueAt.d.f1233b) && (!z3 || bVarValueAt.h != bVarValueAt.f1221b.d)) {
                                long jA = bVarValueAt.a();
                                if (jA < j6) {
                                    bVar3 = bVarValueAt;
                                    j6 = jA;
                                }
                            }
                        }
                        if (bVar3 == null) {
                            int position2 = (int) (this.t - extractorInput.getPosition());
                            if (position2 < 0) {
                                throw ParserException.a("Offset to end of mdat was negative.", null);
                            }
                            extractorInput.l(position2);
                            c();
                            i3 = 0;
                            if (i3 == 0) {
                                return 0;
                            }
                        } else {
                            int iA3 = (int) (bVar3.a() - extractorInput.getPosition());
                            if (iA3 < 0) {
                                Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                iA3 = 0;
                            }
                            extractorInput.l(iA3);
                            this.f1218y = bVar3;
                            bVar2 = bVar3;
                            char c = 6;
                            if (this.o != 3) {
                                TrackSampleTable trackSampleTable = bVar2.d;
                                Track track = trackSampleTable.a;
                                TrackOutput2 trackOutput23 = bVar2.a;
                                long j7 = bVar2.l ? trackSampleTable.f[bVar2.f] : bVar2.f1221b.i[bVar2.f];
                                i = track.j;
                                if (i != 0) {
                                    while (true) {
                                        int i10 = this.A;
                                        int i11 = this.f1219z;
                                        if (i10 >= i11) {
                                            break;
                                        }
                                        this.A += trackOutput23.b(extractorInput, i11 - i10, false);
                                    }
                                } else {
                                    byte[] bArr2 = this.g.a;
                                    bArr2[0] = 0;
                                    bArr2[1] = 0;
                                    bArr2[2] = 0;
                                    int i12 = i + 1;
                                    int i13 = 4 - i;
                                    while (this.A < this.f1219z) {
                                        int i14 = this.B;
                                        if (i14 == 0) {
                                            extractorInput.readFully(bArr2, i13, i12);
                                            this.g.E(0);
                                            int iF4 = this.g.f();
                                            if (iF4 < i3) {
                                                throw ParserException.a("Invalid NAL length", null);
                                            }
                                            this.B = iF4 - 1;
                                            this.f.E(0);
                                            trackOutput23.c(this.f, 4);
                                            trackOutput23.c(this.g, i3);
                                            if (this.F.length > 0) {
                                                String str = track.f.w;
                                                byte b2 = bArr2[4];
                                                byte[] bArr3 = NalUnitUtil.a;
                                                boolean z4 = ("video/avc".equals(str) && (b2 & 31) == c) || ("video/hevc".equals(str) && ((b2 & 126) >> i3) == 39);
                                                this.C = z4;
                                                this.A += 5;
                                                this.f1219z += i13;
                                            }
                                        } else {
                                            if (this.C) {
                                                this.h.A(i14);
                                                extractorInput.readFully(this.h.a, 0, this.B);
                                                trackOutput23.c(this.h, this.B);
                                                iB = this.B;
                                                ParsableByteArray parsableByteArray3 = this.h;
                                                int iF5 = NalUnitUtil.f(parsableByteArray3.a, parsableByteArray3.c);
                                                this.h.E("video/hevc".equals(track.f.w) ? 1 : 0);
                                                this.h.D(iF5);
                                                AnimatableValueParser.J(j7, this.h, this.F);
                                            } else {
                                                iB = trackOutput23.b(extractorInput, i14, false);
                                            }
                                            this.A += iB;
                                            this.B -= iB;
                                            c = 6;
                                            i3 = 1;
                                        }
                                    }
                                }
                                int i15 = bVar2.l ? bVar2.d.g[bVar2.f] : bVar2.f1221b.j[bVar2.f] ? 1 : 0;
                                if (bVar2.b() != null) {
                                    i15 |= BasicMeasure.EXACTLY;
                                }
                                int i16 = i15;
                                TrackEncryptionBox trackEncryptionBoxB = bVar2.b();
                                trackOutput23.d(j7, i16, this.f1219z, 0, trackEncryptionBoxB == null ? trackEncryptionBoxB.c : null);
                                while (!this.n.isEmpty()) {
                                    a aVarRemoveFirst = this.n.removeFirst();
                                    this.u -= aVarRemoveFirst.f1220b;
                                    long j8 = aVarRemoveFirst.a + j7;
                                    TrackOutput2[] trackOutput2Arr = this.E;
                                    int i17 = 0;
                                    for (int length = trackOutput2Arr.length; i17 < length; length = length) {
                                        trackOutput2Arr[i17].d(j8, 1, aVarRemoveFirst.f1220b, this.u, null);
                                        i17++;
                                    }
                                }
                                if (!bVar2.c()) {
                                    this.f1218y = null;
                                }
                                this.o = 3;
                                i3 = 1;
                                if (i3 == 0) {
                                }
                            } else {
                                int i18 = !bVar2.l ? bVar2.d.d[bVar2.f] : bVar2.f1221b.h[bVar2.f];
                                this.f1219z = i18;
                                if (bVar2.f < bVar2.i) {
                                    extractorInput.l(i18);
                                    TrackEncryptionBox trackEncryptionBoxB2 = bVar2.b();
                                    if (trackEncryptionBoxB2 != null) {
                                        ParsableByteArray parsableByteArray4 = bVar2.f1221b.n;
                                        int i19 = trackEncryptionBoxB2.d;
                                        if (i19 != 0) {
                                            parsableByteArray4.F(i19);
                                        }
                                        TrackFragment trackFragment = bVar2.f1221b;
                                        if (trackFragment.k && trackFragment.l[bVar2.f]) {
                                            parsableByteArray4.F(parsableByteArray4.y() * 6);
                                        }
                                    }
                                    if (!bVar2.c()) {
                                        this.f1218y = null;
                                    }
                                    this.o = 3;
                                    if (i3 == 0) {
                                    }
                                } else {
                                    if (bVar2.d.a.g == 1) {
                                        this.f1219z = i18 - 8;
                                        extractorInput.l(8);
                                    }
                                    if ("audio/ac4".equals(bVar2.d.a.f.w)) {
                                        this.A = bVar2.d(this.f1219z, 7);
                                        Ac4Util.a(this.f1219z, this.j);
                                        bVar2.a.c(this.j, 7);
                                        this.A += 7;
                                    } else {
                                        this.A = bVar2.d(this.f1219z, 0);
                                    }
                                    this.f1219z += this.A;
                                    this.o = 4;
                                    this.B = 0;
                                    TrackSampleTable trackSampleTable2 = bVar2.d;
                                    Track track2 = trackSampleTable2.a;
                                    TrackOutput2 trackOutput232 = bVar2.a;
                                    long j72 = bVar2.l ? trackSampleTable2.f[bVar2.f] : bVar2.f1221b.i[bVar2.f];
                                    i = track2.j;
                                    if (i != 0) {
                                    }
                                    if (bVar2.l) {
                                    }
                                    if (bVar2.b() != null) {
                                    }
                                    int i162 = i15;
                                    TrackEncryptionBox trackEncryptionBoxB3 = bVar2.b();
                                    trackOutput232.d(j72, i162, this.f1219z, 0, trackEncryptionBoxB3 == null ? trackEncryptionBoxB3.c : null);
                                    while (!this.n.isEmpty()) {
                                    }
                                    if (!bVar2.c()) {
                                    }
                                    this.o = 3;
                                    i3 = 1;
                                    if (i3 == 0) {
                                    }
                                }
                            }
                        }
                    } else {
                        char c2 = 6;
                        if (this.o != 3) {
                        }
                    }
                } else {
                    int size2 = this.e.size();
                    long j9 = Long.MAX_VALUE;
                    b bVarValueAt2 = null;
                    for (int i20 = 0; i20 < size2; i20++) {
                        TrackFragment trackFragment2 = this.e.valueAt(i20).f1221b;
                        if (trackFragment2.o) {
                            long j10 = trackFragment2.c;
                            if (j10 < j9) {
                                bVarValueAt2 = this.e.valueAt(i20);
                                j9 = j10;
                            }
                        }
                    }
                    if (bVarValueAt2 == null) {
                        this.o = 3;
                    } else {
                        int position3 = (int) (j9 - extractorInput.getPosition());
                        if (position3 < 0) {
                            throw ParserException.a("Offset to encryption data was negative.", null);
                        }
                        extractorInput.l(position3);
                        TrackFragment trackFragment3 = bVarValueAt2.f1221b;
                        ParsableByteArray parsableByteArray5 = trackFragment3.n;
                        extractorInput.readFully(parsableByteArray5.a, 0, parsableByteArray5.c);
                        trackFragment3.n.E(0);
                        trackFragment3.o = false;
                    }
                }
            } else if (this.r != 0) {
                j2 = this.q;
                if (j2 != 1) {
                    extractorInput.readFully(this.l.a, 8, 8);
                    this.r += 8;
                    this.q = this.l.x();
                } else if (j2 == 0) {
                    long jB = extractorInput.b();
                    if (jB == -1 && !this.m.isEmpty()) {
                        jB = this.m.peek().f1209b;
                    }
                    if (jB != -1) {
                        this.q = (jB - extractorInput.getPosition()) + this.r;
                    }
                }
                if (this.q >= this.r) {
                    throw ParserException.b("Atom size less than header length (unsupported).");
                }
                long position4 = extractorInput.getPosition() - this.r;
                int i21 = this.p;
                if ((i21 == 1836019558 || i21 == 1835295092) && !this.G) {
                    this.D.a(new SeekMap.b(this.w, position4));
                    this.G = true;
                }
                if (this.p == 1836019558) {
                    int size3 = this.e.size();
                    for (int i22 = 0; i22 < size3; i22++) {
                        TrackFragment trackFragment4 = this.e.valueAt(i22).f1221b;
                        Objects.requireNonNull(trackFragment4);
                        trackFragment4.c = position4;
                        trackFragment4.f1232b = position4;
                    }
                }
                int i23 = this.p;
                if (i23 == 1835295092) {
                    this.f1218y = null;
                    this.t = position4 + this.q;
                    this.o = 2;
                } else if (i23 == 1836019574 || i23 == 1953653099 || i23 == 1835297121 || i23 == 1835626086 || i23 == 1937007212 || i23 == 1836019558 || i23 == 1953653094 || i23 == 1836475768 || i23 == 1701082227) {
                    long position5 = (extractorInput.getPosition() + this.q) - 8;
                    this.m.push(new Atom.a(this.p, position5));
                    if (this.q == this.r) {
                        j(position5);
                    } else {
                        c();
                    }
                } else if (i23 == 1751411826 || i23 == 1835296868 || i23 == 1836476516 || i23 == 1936286840 || i23 == 1937011556 || i23 == 1937011827 || i23 == 1668576371 || i23 == 1937011555 || i23 == 1937011578 || i23 == 1937013298 || i23 == 1937007471 || i23 == 1668232756 || i23 == 1937011571 || i23 == 1952867444 || i23 == 1952868452 || i23 == 1953196132 || i23 == 1953654136 || i23 == 1953658222 || i23 == 1886614376 || i23 == 1935763834 || i23 == 1935763823 || i23 == 1936027235 || i23 == 1970628964 || i23 == 1935828848 || i23 == 1936158820 || i23 == 1701606260 || i23 == 1835362404 || i23 == 1701671783) {
                    if (this.r != 8) {
                        throw ParserException.b("Leaf atom defines extended atom size (unsupported).");
                    }
                    long j11 = this.q;
                    if (j11 > 2147483647L) {
                        throw ParserException.b("Leaf atom with length > 2147483647 (unsupported).");
                    }
                    ParsableByteArray parsableByteArray6 = new ParsableByteArray((int) j11);
                    System.arraycopy(this.l.a, 0, parsableByteArray6.a, 0, 8);
                    this.f1216s = parsableByteArray6;
                    this.o = 1;
                } else {
                    if (this.q > 2147483647L) {
                        throw ParserException.b("Skipping atom with length > 2147483647 (unsupported).");
                    }
                    this.f1216s = null;
                    this.o = 1;
                }
                z2 = true;
                if (z2) {
                    return -1;
                }
            } else if (extractorInput.c(this.l.a, 0, 8, true)) {
                this.r = 8;
                this.l.E(0);
                this.q = this.l.u();
                this.p = this.l.f();
                j2 = this.q;
                if (j2 != 1) {
                }
                if (this.q >= this.r) {
                }
            } else {
                z2 = false;
                if (z2) {
                }
            }
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public void f(ExtractorOutput extractorOutput) {
        int i;
        this.D = extractorOutput;
        c();
        TrackOutput2[] trackOutput2Arr = new TrackOutput2[2];
        this.E = trackOutput2Arr;
        int i2 = 100;
        int i3 = 0;
        if ((this.c & 4) != 0) {
            trackOutput2Arr[0] = this.D.p(100, 5);
            i2 = 101;
            i = 1;
        } else {
            i = 0;
        }
        TrackOutput2[] trackOutput2Arr2 = (TrackOutput2[]) Util2.D(this.E, i);
        this.E = trackOutput2Arr2;
        for (TrackOutput2 trackOutput2 : trackOutput2Arr2) {
            trackOutput2.e(f1215b);
        }
        this.F = new TrackOutput2[this.d.size()];
        while (i3 < this.F.length) {
            TrackOutput2 trackOutput2P = this.D.p(i2, 3);
            trackOutput2P.e(this.d.get(i3));
            this.F[i3] = trackOutput2P;
            i3++;
            i2++;
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public void g(long j, long j2) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.valueAt(i).e();
        }
        this.n.clear();
        this.u = 0;
        this.v = j2;
        this.m.clear();
        c();
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0680  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(long j) throws ParserException {
        FragmentedMp4Extractor fragmentedMp4Extractor;
        byte[] bArr;
        SparseArray<b> sparseArray;
        Atom.a aVar;
        int i;
        int i2;
        int i3;
        int i4;
        byte[] bArr2;
        int i5;
        byte[] bArr3;
        int i6;
        Atom.a aVar2;
        int i7;
        List<Atom.b> list;
        int i8;
        Atom.a aVar3;
        TrackFragment trackFragment;
        int i9;
        int i10;
        long j2;
        int i11;
        int i12;
        boolean z2;
        int iF;
        boolean z3;
        int iF2;
        boolean z4;
        int iF3;
        boolean z5;
        boolean z6;
        int iF4;
        int i13;
        ParsableByteArray parsableByteArray;
        FragmentedMp4Extractor fragmentedMp4Extractor2 = this;
        FragmentedMp4Extractor fragmentedMp4Extractor3 = fragmentedMp4Extractor2;
        while (!fragmentedMp4Extractor3.m.isEmpty() && fragmentedMp4Extractor3.m.peek().f1209b == j) {
            Atom.a aVarPop = fragmentedMp4Extractor3.m.pop();
            int i14 = aVarPop.a;
            int i15 = 12;
            if (i14 == 1836019574) {
                AnimatableValueParser.E(true, "Unexpected moov box.");
                DrmInitData drmInitDataH = h(aVarPop.c);
                Atom.a aVarB = aVarPop.b(1836475768);
                Objects.requireNonNull(aVarB);
                SparseArray<DefaultSampleValues> sparseArray2 = new SparseArray<>();
                int size = aVarB.c.size();
                long jU = -9223372036854775807L;
                int i16 = 0;
                while (i16 < size) {
                    Atom.b bVar = aVarB.c.get(i16);
                    int i17 = bVar.a;
                    if (i17 == 1953654136) {
                        ParsableByteArray parsableByteArray2 = bVar.f1210b;
                        parsableByteArray2.E(i15);
                        Pair pairCreate = Pair.create(Integer.valueOf(parsableByteArray2.f()), new DefaultSampleValues(parsableByteArray2.f() - 1, parsableByteArray2.f(), parsableByteArray2.f(), parsableByteArray2.f()));
                        sparseArray2.put(((Integer) pairCreate.first).intValue(), (DefaultSampleValues) pairCreate.second);
                    } else {
                        if (i17 == 1835362404) {
                            ParsableByteArray parsableByteArray3 = bVar.f1210b;
                            parsableByteArray3.E(8);
                            jU = ((parsableByteArray3.f() >> 24) & 255) == 0 ? parsableByteArray3.u() : parsableByteArray3.x();
                        }
                        i16++;
                        i15 = 12;
                    }
                    i16++;
                    i15 = 12;
                }
                ArrayList arrayList = (ArrayList) AtomParsers.e(aVarPop, new GaplessInfoHolder(), jU, drmInitDataH, (fragmentedMp4Extractor3.c & 16) != 0, false, new c(fragmentedMp4Extractor3));
                int size2 = arrayList.size();
                if (fragmentedMp4Extractor3.e.size() == 0) {
                    for (int i18 = 0; i18 < size2; i18++) {
                        TrackSampleTable trackSampleTable = (TrackSampleTable) arrayList.get(i18);
                        Track track = trackSampleTable.a;
                        fragmentedMp4Extractor3.e.put(track.a, new b(fragmentedMp4Extractor3.D.p(i18, track.f1230b), trackSampleTable, fragmentedMp4Extractor3.d(sparseArray2, track.a)));
                        fragmentedMp4Extractor3.w = Math.max(fragmentedMp4Extractor3.w, track.e);
                    }
                    fragmentedMp4Extractor3.D.j();
                } else {
                    AnimatableValueParser.D(fragmentedMp4Extractor3.e.size() == size2);
                    for (int i19 = 0; i19 < size2; i19++) {
                        TrackSampleTable trackSampleTable2 = (TrackSampleTable) arrayList.get(i19);
                        Track track2 = trackSampleTable2.a;
                        b bVar2 = fragmentedMp4Extractor3.e.get(track2.a);
                        DefaultSampleValues defaultSampleValuesD = fragmentedMp4Extractor3.d(sparseArray2, track2.a);
                        bVar2.d = trackSampleTable2;
                        bVar2.e = defaultSampleValuesD;
                        bVar2.a.e(trackSampleTable2.a.f);
                        bVar2.e();
                    }
                }
                fragmentedMp4Extractor = fragmentedMp4Extractor2;
            } else {
                int i20 = 8;
                if (i14 == 1836019558) {
                    SparseArray<b> sparseArray3 = fragmentedMp4Extractor3.e;
                    int i21 = fragmentedMp4Extractor3.c;
                    byte[] bArr4 = fragmentedMp4Extractor3.i;
                    int size3 = aVarPop.d.size();
                    int i22 = 0;
                    while (i22 < size3) {
                        Atom.a aVar4 = aVarPop.d.get(i22);
                        if (aVar4.a == 1953653094) {
                            Atom.b bVarC = aVar4.c(1952868452);
                            Objects.requireNonNull(bVarC);
                            ParsableByteArray parsableByteArray4 = bVarC.f1210b;
                            parsableByteArray4.E(i20);
                            int iF5 = parsableByteArray4.f() & ViewCompat.MEASURED_SIZE_MASK;
                            b bVar3 = sparseArray3.get(parsableByteArray4.f());
                            if (bVar3 == null) {
                                bVar3 = null;
                            } else {
                                if ((iF5 & 1) != 0) {
                                    long jX = parsableByteArray4.x();
                                    TrackFragment trackFragment2 = bVar3.f1221b;
                                    trackFragment2.f1232b = jX;
                                    trackFragment2.c = jX;
                                }
                                DefaultSampleValues defaultSampleValues = bVar3.e;
                                bVar3.f1221b.a = new DefaultSampleValues((iF5 & 2) != 0 ? parsableByteArray4.f() - 1 : defaultSampleValues.a, (iF5 & 8) != 0 ? parsableByteArray4.f() : defaultSampleValues.f1214b, (iF5 & 16) != 0 ? parsableByteArray4.f() : defaultSampleValues.c, (iF5 & 32) != 0 ? parsableByteArray4.f() : defaultSampleValues.d);
                            }
                            if (bVar3 == null) {
                                bArr = bArr4;
                                sparseArray = sparseArray3;
                                aVar = aVarPop;
                                i = i21;
                                i2 = size3;
                                i3 = i22;
                            } else {
                                TrackFragment trackFragment3 = bVar3.f1221b;
                                long j3 = trackFragment3.p;
                                boolean z7 = trackFragment3.q;
                                bVar3.e();
                                bVar3.l = true;
                                Atom.b bVarC2 = aVar4.c(1952867444);
                                if (bVarC2 == null || (i21 & 2) != 0) {
                                    trackFragment3.p = j3;
                                    trackFragment3.q = z7;
                                } else {
                                    ParsableByteArray parsableByteArray5 = bVarC2.f1210b;
                                    parsableByteArray5.E(i20);
                                    trackFragment3.p = ((parsableByteArray5.f() >> 24) & 255) == 1 ? parsableByteArray5.x() : parsableByteArray5.u();
                                    trackFragment3.q = true;
                                }
                                List<Atom.b> list2 = aVar4.c;
                                int size4 = list2.size();
                                int i23 = 0;
                                int i24 = 0;
                                int i25 = 0;
                                while (true) {
                                    i4 = 1953658222;
                                    if (i23 >= size4) {
                                        break;
                                    }
                                    SparseArray<b> sparseArray4 = sparseArray3;
                                    Atom.b bVar4 = list2.get(i23);
                                    int i26 = size3;
                                    if (bVar4.a == 1953658222) {
                                        ParsableByteArray parsableByteArray6 = bVar4.f1210b;
                                        parsableByteArray6.E(12);
                                        int iW = parsableByteArray6.w();
                                        if (iW > 0) {
                                            i25 += iW;
                                            i24++;
                                        }
                                    }
                                    i23++;
                                    size3 = i26;
                                    sparseArray3 = sparseArray4;
                                }
                                sparseArray = sparseArray3;
                                i2 = size3;
                                bVar3.h = 0;
                                bVar3.g = 0;
                                bVar3.f = 0;
                                TrackFragment trackFragment4 = bVar3.f1221b;
                                trackFragment4.d = i24;
                                trackFragment4.e = i25;
                                if (trackFragment4.g.length < i24) {
                                    trackFragment4.f = new long[i24];
                                    trackFragment4.g = new int[i24];
                                }
                                if (trackFragment4.h.length < i25) {
                                    int i27 = (i25 * Opcodes.LUSHR) / 100;
                                    trackFragment4.h = new int[i27];
                                    trackFragment4.i = new long[i27];
                                    trackFragment4.j = new boolean[i27];
                                    trackFragment4.l = new boolean[i27];
                                }
                                int i28 = 0;
                                int i29 = 0;
                                int i30 = 0;
                                while (i28 < size4) {
                                    Atom.b bVar5 = list2.get(i28);
                                    if (bVar5.a == i4) {
                                        int i31 = i30 + 1;
                                        ParsableByteArray parsableByteArray7 = bVar5.f1210b;
                                        parsableByteArray7.E(8);
                                        int iF6 = parsableByteArray7.f() & ViewCompat.MEASURED_SIZE_MASK;
                                        list = list2;
                                        Track track3 = bVar3.d.a;
                                        i9 = size4;
                                        TrackFragment trackFragment5 = bVar3.f1221b;
                                        DefaultSampleValues defaultSampleValues2 = trackFragment5.a;
                                        int i32 = Util2.a;
                                        trackFragment5.g[i30] = parsableByteArray7.w();
                                        long[] jArr = trackFragment5.f;
                                        i8 = i22;
                                        aVar3 = aVar4;
                                        jArr[i30] = trackFragment5.f1232b;
                                        if ((iF6 & 1) != 0) {
                                            aVar2 = aVarPop;
                                            bArr3 = bArr4;
                                            i6 = i28;
                                            jArr[i30] = jArr[i30] + parsableByteArray7.f();
                                        } else {
                                            bArr3 = bArr4;
                                            i6 = i28;
                                            aVar2 = aVarPop;
                                        }
                                        boolean z8 = (iF6 & 4) != 0;
                                        int iF7 = defaultSampleValues2.d;
                                        if (z8) {
                                            iF7 = parsableByteArray7.f();
                                        }
                                        boolean z9 = (iF6 & 256) != 0;
                                        boolean z10 = (iF6 & 512) != 0;
                                        boolean z11 = (iF6 & 1024) != 0;
                                        boolean z12 = (iF6 & 2048) != 0;
                                        long[] jArr2 = track3.h;
                                        if (jArr2 != null) {
                                            i10 = iF7;
                                            trackFragment = trackFragment3;
                                            if (jArr2.length == 1 && jArr2[0] == 0) {
                                                j2 = track3.i[0];
                                            }
                                            int[] iArr = trackFragment5.h;
                                            long[] jArr3 = trackFragment5.i;
                                            boolean[] zArr = trackFragment5.j;
                                            boolean z13 = (track3.f1230b == 2 || (i21 & 1) == 0) ? false : true;
                                            i11 = trackFragment5.g[i30] + i29;
                                            i7 = i21;
                                            long j4 = track3.c;
                                            long j5 = trackFragment5.p;
                                            i12 = i29;
                                            while (i12 < i11) {
                                                if (z9) {
                                                    z2 = z9;
                                                    iF = parsableByteArray7.f();
                                                } else {
                                                    z2 = z9;
                                                    iF = defaultSampleValues2.f1214b;
                                                }
                                                a(iF);
                                                if (z10) {
                                                    z3 = z10;
                                                    iF2 = parsableByteArray7.f();
                                                } else {
                                                    z3 = z10;
                                                    iF2 = defaultSampleValues2.c;
                                                }
                                                a(iF2);
                                                if (z11) {
                                                    z4 = z8;
                                                    iF3 = parsableByteArray7.f();
                                                } else if (i12 == 0 && z8) {
                                                    z4 = z8;
                                                    iF3 = i10;
                                                } else {
                                                    z4 = z8;
                                                    iF3 = defaultSampleValues2.d;
                                                }
                                                if (z12) {
                                                    z5 = z11;
                                                    z6 = z12;
                                                    iF4 = parsableByteArray7.f();
                                                } else {
                                                    z5 = z11;
                                                    z6 = z12;
                                                    iF4 = 0;
                                                }
                                                jArr3[i12] = Util2.F((iF4 + j5) - j2, 1000000L, j4);
                                                if (trackFragment5.q) {
                                                    i13 = i11;
                                                    parsableByteArray = parsableByteArray7;
                                                } else {
                                                    i13 = i11;
                                                    parsableByteArray = parsableByteArray7;
                                                    jArr3[i12] = jArr3[i12] + bVar3.d.h;
                                                }
                                                iArr[i12] = iF2;
                                                zArr[i12] = ((iF3 >> 16) & 1) == 0 && (!z13 || i12 == 0);
                                                j5 += iF;
                                                i12++;
                                                i11 = i13;
                                                parsableByteArray7 = parsableByteArray;
                                                z9 = z2;
                                                z10 = z3;
                                                z8 = z4;
                                                z11 = z5;
                                                z12 = z6;
                                            }
                                            int i33 = i11;
                                            trackFragment5.p = j5;
                                            i30 = i31;
                                            i29 = i33;
                                        } else {
                                            i10 = iF7;
                                            trackFragment = trackFragment3;
                                        }
                                        j2 = 0;
                                        int[] iArr2 = trackFragment5.h;
                                        long[] jArr32 = trackFragment5.i;
                                        boolean[] zArr2 = trackFragment5.j;
                                        if (track3.f1230b == 2) {
                                            i11 = trackFragment5.g[i30] + i29;
                                            i7 = i21;
                                            long j42 = track3.c;
                                            long j52 = trackFragment5.p;
                                            i12 = i29;
                                            while (i12 < i11) {
                                            }
                                            int i332 = i11;
                                            trackFragment5.p = j52;
                                            i30 = i31;
                                            i29 = i332;
                                        }
                                    } else {
                                        bArr3 = bArr4;
                                        i6 = i28;
                                        aVar2 = aVarPop;
                                        i7 = i21;
                                        list = list2;
                                        i8 = i22;
                                        aVar3 = aVar4;
                                        trackFragment = trackFragment3;
                                        i9 = size4;
                                    }
                                    i28 = i6 + 1;
                                    i21 = i7;
                                    list2 = list;
                                    size4 = i9;
                                    i22 = i8;
                                    aVar4 = aVar3;
                                    aVarPop = aVar2;
                                    bArr4 = bArr3;
                                    trackFragment3 = trackFragment;
                                    i4 = 1953658222;
                                }
                                byte[] bArr5 = bArr4;
                                aVar = aVarPop;
                                i = i21;
                                i3 = i22;
                                TrackFragment trackFragment6 = trackFragment3;
                                Track track4 = bVar3.d.a;
                                DefaultSampleValues defaultSampleValues3 = trackFragment6.a;
                                Objects.requireNonNull(defaultSampleValues3);
                                TrackEncryptionBox trackEncryptionBoxA = track4.a(defaultSampleValues3.a);
                                Atom.b bVarC3 = aVar4.c(1935763834);
                                if (bVarC3 != null) {
                                    Objects.requireNonNull(trackEncryptionBoxA);
                                    ParsableByteArray parsableByteArray8 = bVarC3.f1210b;
                                    int i34 = trackEncryptionBoxA.d;
                                    parsableByteArray8.E(8);
                                    if ((parsableByteArray8.f() & ViewCompat.MEASURED_SIZE_MASK & 1) == 1) {
                                        parsableByteArray8.F(8);
                                    }
                                    int iT = parsableByteArray8.t();
                                    int iW2 = parsableByteArray8.w();
                                    int i35 = trackFragment6.e;
                                    if (iW2 > i35) {
                                        throw ParserException.a(outline.h(78, "Saiz sample count ", iW2, " is greater than fragment sample count", i35), null);
                                    }
                                    if (iT == 0) {
                                        boolean[] zArr3 = trackFragment6.l;
                                        i5 = 0;
                                        for (int i36 = 0; i36 < iW2; i36++) {
                                            int iT2 = parsableByteArray8.t();
                                            i5 += iT2;
                                            zArr3[i36] = iT2 > i34;
                                        }
                                    } else {
                                        i5 = (iT * iW2) + 0;
                                        Arrays.fill(trackFragment6.l, 0, iW2, iT > i34);
                                    }
                                    Arrays.fill(trackFragment6.l, iW2, trackFragment6.e, false);
                                    if (i5 > 0) {
                                        ParsableByteArray parsableByteArray9 = trackFragment6.n;
                                        byte[] bArr6 = parsableByteArray9.a;
                                        if (bArr6.length < i5) {
                                            bArr6 = new byte[i5];
                                        }
                                        parsableByteArray9.C(bArr6, i5);
                                        trackFragment6.k = true;
                                        trackFragment6.o = true;
                                    }
                                }
                                Atom.b bVarC4 = aVar4.c(1935763823);
                                if (bVarC4 != null) {
                                    ParsableByteArray parsableByteArray10 = bVarC4.f1210b;
                                    parsableByteArray10.E(8);
                                    int iF8 = parsableByteArray10.f();
                                    if ((16777215 & iF8 & 1) == 1) {
                                        parsableByteArray10.F(8);
                                    }
                                    int iW3 = parsableByteArray10.w();
                                    if (iW3 != 1) {
                                        throw outline.w0(40, "Unexpected saio entry count: ", iW3, null);
                                    }
                                    trackFragment6.c += ((iF8 >> 24) & 255) == 0 ? parsableByteArray10.u() : parsableByteArray10.x();
                                }
                                byte[] bArr7 = null;
                                Atom.b bVarC5 = aVar4.c(1936027235);
                                if (bVarC5 != null) {
                                    i(bVarC5.f1210b, 0, trackFragment6);
                                }
                                String str = trackEncryptionBoxA != null ? trackEncryptionBoxA.f1231b : null;
                                ParsableByteArray parsableByteArray11 = null;
                                ParsableByteArray parsableByteArray12 = null;
                                for (int i37 = 0; i37 < aVar4.c.size(); i37++) {
                                    Atom.b bVar6 = aVar4.c.get(i37);
                                    ParsableByteArray parsableByteArray13 = bVar6.f1210b;
                                    int i38 = bVar6.a;
                                    if (i38 == 1935828848) {
                                        parsableByteArray13.E(12);
                                        if (parsableByteArray13.f() == 1936025959) {
                                            parsableByteArray11 = parsableByteArray13;
                                        }
                                    } else if (i38 == 1936158820) {
                                        parsableByteArray13.E(12);
                                        if (parsableByteArray13.f() == 1936025959) {
                                            parsableByteArray12 = parsableByteArray13;
                                        }
                                    }
                                }
                                if (parsableByteArray11 != null && parsableByteArray12 != null) {
                                    parsableByteArray11.E(8);
                                    int iF9 = (parsableByteArray11.f() >> 24) & 255;
                                    parsableByteArray11.F(4);
                                    if (iF9 == 1) {
                                        parsableByteArray11.F(4);
                                    }
                                    if (parsableByteArray11.f() != 1) {
                                        throw ParserException.b("Entry count in sbgp != 1 (unsupported).");
                                    }
                                    parsableByteArray12.E(8);
                                    int iF10 = (parsableByteArray12.f() >> 24) & 255;
                                    parsableByteArray12.F(4);
                                    if (iF10 == 1) {
                                        if (parsableByteArray12.u() == 0) {
                                            throw ParserException.b("Variable length description in sgpd found (unsupported)");
                                        }
                                    } else if (iF10 >= 2) {
                                        parsableByteArray12.F(4);
                                    }
                                    if (parsableByteArray12.u() != 1) {
                                        throw ParserException.b("Entry count in sgpd != 1 (unsupported).");
                                    }
                                    parsableByteArray12.F(1);
                                    int iT3 = parsableByteArray12.t();
                                    int i39 = (iT3 & 240) >> 4;
                                    int i40 = iT3 & 15;
                                    boolean z14 = parsableByteArray12.t() == 1;
                                    if (z14) {
                                        int iT4 = parsableByteArray12.t();
                                        byte[] bArr8 = new byte[16];
                                        System.arraycopy(parsableByteArray12.a, parsableByteArray12.f984b, bArr8, 0, 16);
                                        parsableByteArray12.f984b += 16;
                                        if (iT4 == 0) {
                                            int iT5 = parsableByteArray12.t();
                                            bArr7 = new byte[iT5];
                                            System.arraycopy(parsableByteArray12.a, parsableByteArray12.f984b, bArr7, 0, iT5);
                                            parsableByteArray12.f984b += iT5;
                                        }
                                        trackFragment6.k = true;
                                        trackFragment6.m = new TrackEncryptionBox(z14, str, iT4, bArr8, i39, i40, bArr7);
                                    }
                                }
                                int size5 = aVar4.c.size();
                                int i41 = 0;
                                while (i41 < size5) {
                                    Atom.b bVar7 = aVar4.c.get(i41);
                                    if (bVar7.a == 1970628964) {
                                        ParsableByteArray parsableByteArray14 = bVar7.f1210b;
                                        parsableByteArray14.E(8);
                                        bArr2 = bArr5;
                                        System.arraycopy(parsableByteArray14.a, parsableByteArray14.f984b, bArr2, 0, 16);
                                        parsableByteArray14.f984b += 16;
                                        if (Arrays.equals(bArr2, a)) {
                                            i(parsableByteArray14, 16, trackFragment6);
                                        }
                                    } else {
                                        bArr2 = bArr5;
                                    }
                                    i41++;
                                    bArr5 = bArr2;
                                }
                                bArr = bArr5;
                            }
                        }
                        i22 = i3 + 1;
                        i20 = 8;
                        bArr4 = bArr;
                        i21 = i;
                        size3 = i2;
                        sparseArray3 = sparseArray;
                        aVarPop = aVar;
                    }
                    DrmInitData drmInitDataH2 = h(aVarPop.c);
                    fragmentedMp4Extractor = this;
                    if (drmInitDataH2 != null) {
                        int size6 = fragmentedMp4Extractor.e.size();
                        for (int i42 = 0; i42 < size6; i42++) {
                            b bVarValueAt = fragmentedMp4Extractor.e.valueAt(i42);
                            Track track5 = bVarValueAt.d.a;
                            DefaultSampleValues defaultSampleValues4 = bVarValueAt.f1221b.a;
                            int i43 = Util2.a;
                            TrackEncryptionBox trackEncryptionBoxA2 = track5.a(defaultSampleValues4.a);
                            DrmInitData drmInitDataA = drmInitDataH2.a(trackEncryptionBoxA2 != null ? trackEncryptionBoxA2.f1231b : null);
                            Format2.b bVarA = bVarValueAt.d.a.f.a();
                            bVarA.n = drmInitDataA;
                            bVarValueAt.a.e(bVarA.a());
                        }
                    }
                    if (fragmentedMp4Extractor.v != -9223372036854775807L) {
                        int size7 = fragmentedMp4Extractor.e.size();
                        for (int i44 = 0; i44 < size7; i44++) {
                            b bVarValueAt2 = fragmentedMp4Extractor.e.valueAt(i44);
                            long j6 = fragmentedMp4Extractor.v;
                            int i45 = bVarValueAt2.f;
                            while (true) {
                                TrackFragment trackFragment7 = bVarValueAt2.f1221b;
                                if (i45 >= trackFragment7.e || trackFragment7.i[i45] >= j6) {
                                    break;
                                }
                                if (trackFragment7.j[i45]) {
                                    bVarValueAt2.i = i45;
                                }
                                i45++;
                            }
                        }
                        fragmentedMp4Extractor.v = -9223372036854775807L;
                    }
                    fragmentedMp4Extractor3 = fragmentedMp4Extractor;
                } else {
                    fragmentedMp4Extractor = fragmentedMp4Extractor2;
                    if (!fragmentedMp4Extractor3.m.isEmpty()) {
                        fragmentedMp4Extractor3.m.peek().d.add(aVarPop);
                    }
                }
            }
            fragmentedMp4Extractor2 = fragmentedMp4Extractor;
        }
        c();
    }

    @Override // b.i.a.c.x2.Extractor
    public void release() {
    }
}
