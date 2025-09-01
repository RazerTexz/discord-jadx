package b.i.a.c.x2.g0;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.C;
import b.i.a.c.Format2;
import b.i.a.c.f3.LongArray;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.AvcConfig;
import b.i.a.c.g3.ColorInfo;
import b.i.a.c.g3.DolbyVisionConfig;
import b.i.a.c.g3.HevcConfig;
import b.i.a.c.t2.AacUtil;
import b.i.a.c.x2.ChunkIndex;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.TrueHdSampleRechunker;
import b.i.a.c.x2.g0.DefaultEbmlReader;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableList2;
import com.discord.api.permission.Permission;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.objectweb.asm.Opcodes;

/* compiled from: MatroskaExtractor.java */
/* renamed from: b.i.a.c.x2.g0.e, reason: use source file name */
/* loaded from: classes3.dex */
public class MatroskaExtractor implements Extractor {
    public static final byte[] a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f1185b;
    public static final byte[] c;
    public static final UUID d;
    public static final Map<String, Integer> e;
    public boolean A;
    public int B;
    public long C;
    public boolean D;
    public long E;
    public long F;
    public long G;

    @Nullable
    public LongArray H;

    @Nullable
    public LongArray I;
    public boolean J;
    public boolean K;
    public int L;
    public long M;
    public long N;
    public int O;
    public int P;
    public int[] Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public boolean V;
    public int W;
    public int X;
    public int Y;
    public boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f1186a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f1187b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f1188c0;

    /* renamed from: d0, reason: collision with root package name */
    public byte f1189d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f1190e0;
    public final EbmlReader f;

    /* renamed from: f0, reason: collision with root package name */
    public ExtractorOutput f1191f0;
    public final VarintReader g;
    public final SparseArray<c> h;
    public final boolean i;
    public final ParsableByteArray j;
    public final ParsableByteArray k;
    public final ParsableByteArray l;
    public final ParsableByteArray m;
    public final ParsableByteArray n;
    public final ParsableByteArray o;
    public final ParsableByteArray p;
    public final ParsableByteArray q;
    public final ParsableByteArray r;

    /* renamed from: s, reason: collision with root package name */
    public final ParsableByteArray f1192s;
    public ByteBuffer t;
    public long u;
    public long v;
    public long w;

    /* renamed from: x, reason: collision with root package name */
    public long f1193x;

    /* renamed from: y, reason: collision with root package name */
    public long f1194y;

    /* renamed from: z, reason: collision with root package name */
    @Nullable
    public c f1195z;

    /* compiled from: MatroskaExtractor.java */
    /* renamed from: b.i.a.c.x2.g0.e$b */
    public final class b implements EbmlProcessor {
        public b(a aVar) {
        }
    }

    static {
        b.i.a.c.x2.g0.a aVar = b.i.a.c.x2.g0.a.a;
        a = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        f1185b = Util2.w("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
        c = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        d = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        e = Collections.unmodifiableMap(map);
    }

    public MatroskaExtractor(int i) {
        DefaultEbmlReader defaultEbmlReader = new DefaultEbmlReader();
        this.v = -1L;
        this.w = -9223372036854775807L;
        this.f1193x = -9223372036854775807L;
        this.f1194y = -9223372036854775807L;
        this.E = -1L;
        this.F = -1L;
        this.G = -9223372036854775807L;
        this.f = defaultEbmlReader;
        defaultEbmlReader.d = new b(null);
        this.i = (i & 1) == 0;
        this.g = new VarintReader();
        this.h = new SparseArray<>();
        this.l = new ParsableByteArray(4);
        this.m = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.n = new ParsableByteArray(4);
        this.j = new ParsableByteArray(NalUnitUtil.a);
        this.k = new ParsableByteArray(4);
        this.o = new ParsableByteArray();
        this.p = new ParsableByteArray();
        this.q = new ParsableByteArray(8);
        this.r = new ParsableByteArray();
        this.f1192s = new ParsableByteArray();
        this.Q = new int[1];
    }

    public static int[] i(@Nullable int[] iArr, int i) {
        return iArr == null ? new int[i] : iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    public static byte[] j(long j, String str, long j2) {
        AnimatableValueParser.j(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - ((i * 3600) * 1000000);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - ((i2 * 60) * 1000000);
        int i3 = (int) (j4 / 1000000);
        return Util2.w(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (i3 * 1000000)) / j2))));
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    public final void a(int i) throws ParserException {
        if (this.H == null || this.I == null) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Element ");
            sb.append(i);
            sb.append(" must be in a Cues");
            throw ParserException.a(sb.toString(), null);
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public final boolean b(ExtractorInput extractorInput) throws IOException {
        Sniffer sniffer = new Sniffer();
        long jB = extractorInput.b();
        long j = Permission.VIEW_CHANNEL;
        if (jB != -1 && jB <= Permission.VIEW_CHANNEL) {
            j = jB;
        }
        int i = (int) j;
        extractorInput.o(sniffer.a.a, 0, 4);
        sniffer.f1201b = 4;
        for (long jU = sniffer.a.u(); jU != 440786851; jU = ((jU << 8) & (-256)) | (sniffer.a.a[0] & 255)) {
            int i2 = sniffer.f1201b + 1;
            sniffer.f1201b = i2;
            if (i2 == i) {
                return false;
            }
            extractorInput.o(sniffer.a.a, 0, 1);
        }
        long jA = sniffer.a(extractorInput);
        long j2 = sniffer.f1201b;
        if (jA == Long.MIN_VALUE) {
            return false;
        }
        if (jB != -1 && j2 + jA >= jB) {
            return false;
        }
        while (true) {
            long j3 = sniffer.f1201b;
            long j4 = j2 + jA;
            if (j3 >= j4) {
                return j3 == j4;
            }
            if (sniffer.a(extractorInput) == Long.MIN_VALUE) {
                return false;
            }
            long jA2 = sniffer.a(extractorInput);
            if (jA2 < 0 || jA2 > 2147483647L) {
                return false;
            }
            if (jA2 != 0) {
                int i3 = (int) jA2;
                extractorInput.g(i3);
                sniffer.f1201b += i3;
            }
        }
    }

    @EnsuresNonNull({"currentTrack"})
    public final void c(int i) throws ParserException {
        if (this.f1195z != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(43);
        sb.append("Element ");
        sb.append(i);
        sb.append(" must be in a TrackEntry");
        throw ParserException.a(sb.toString(), null);
    }

    @RequiresNonNull({"#1.output"})
    public final void d(c cVar, long j, int i, int i2, int i3) {
        byte[] bArrJ;
        int i4;
        TrueHdSampleRechunker trueHdSampleRechunker = cVar.T;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.b(cVar.X, j, i, i2, i3, cVar.j);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f1196b) || "S_TEXT/ASS".equals(cVar.f1196b)) {
                if (this.P > 1) {
                    Log.w("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.N;
                    if (j2 == -9223372036854775807L) {
                        Log.w("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        String str = cVar.f1196b;
                        byte[] bArr = this.p.a;
                        str.hashCode();
                        if (str.equals("S_TEXT/ASS")) {
                            bArrJ = j(j2, "%01d:%02d:%02d:%02d", 10000L);
                            i4 = 21;
                        } else {
                            if (!str.equals("S_TEXT/UTF8")) {
                                throw new IllegalArgumentException();
                            }
                            bArrJ = j(j2, "%02d:%02d:%02d,%03d", 1000L);
                            i4 = 19;
                        }
                        System.arraycopy(bArrJ, 0, bArr, i4, bArrJ.length);
                        int i5 = this.p.f984b;
                        while (true) {
                            ParsableByteArray parsableByteArray = this.p;
                            if (i5 >= parsableByteArray.c) {
                                break;
                            }
                            if (parsableByteArray.a[i5] == 0) {
                                parsableByteArray.D(i5);
                                break;
                            }
                            i5++;
                        }
                        TrackOutput2 trackOutput2 = cVar.X;
                        ParsableByteArray parsableByteArray2 = this.p;
                        trackOutput2.c(parsableByteArray2, parsableByteArray2.c);
                        i2 += this.p.c;
                    }
                }
            }
            if ((268435456 & i) != 0) {
                if (this.P > 1) {
                    i &= -268435457;
                } else {
                    ParsableByteArray parsableByteArray3 = this.f1192s;
                    int i6 = parsableByteArray3.c;
                    cVar.X.f(parsableByteArray3, i6, 2);
                    i2 += i6;
                }
            }
            cVar.X.d(j, i, i2, i3, cVar.j);
        }
        this.K = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:414:0x08a8, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x08aa, code lost:
    
        if (r5 == false) goto L464;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x08ac, code lost:
    
        r3 = r29.getPosition();
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x08b2, code lost:
    
        if (r28.D == false) goto L419;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x08b4, code lost:
    
        r28.F = r3;
        r30.a = r28.E;
        r28.D = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x08c0, code lost:
    
        if (r28.A == false) goto L425;
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x08c2, code lost:
    
        r3 = r28.F;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x08c8, code lost:
    
        if (r3 == (-1)) goto L425;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x08ca, code lost:
    
        r30.a = r3;
        r28.F = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x08ce, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x08d0, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x08d1, code lost:
    
        if (r3 == false) goto L465;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x08d3, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x08d5, code lost:
    
        r3 = false;
        r4 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v6, types: [int[]] */
    /* JADX WARN: Type inference failed for: r3v145 */
    /* JADX WARN: Type inference failed for: r3v68 */
    /* JADX WARN: Type inference failed for: r3v79 */
    /* JADX WARN: Type inference failed for: r4v124 */
    /* JADX WARN: Type inference failed for: r4v139 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v89, types: [b.i.a.c.x2.g0.g] */
    /* JADX WARN: Type inference failed for: r5v90, types: [b.i.a.c.x2.g0.g] */
    /* JADX WARN: Type inference failed for: r8v28, types: [b.i.a.c.x2.g0.g] */
    @Override // b.i.a.c.x2.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i;
        int i2;
        String str;
        long j;
        int i3;
        int[] iArr;
        boolean z2 = false;
        this.K = false;
        boolean z3 = true;
        boolean z4 = true;
        while (z4 && !this.K) {
            DefaultEbmlReader defaultEbmlReader = (DefaultEbmlReader) this.f;
            AnimatableValueParser.H(defaultEbmlReader.d);
            boolean z5 = z2;
            ?? r4 = z3;
            while (true) {
                DefaultEbmlReader.b bVarPeek = defaultEbmlReader.f1183b.peek();
                if (bVarPeek == null || extractorInput.getPosition() < bVarPeek.f1184b) {
                    if (defaultEbmlReader.e == 0) {
                        long jC = defaultEbmlReader.c.c(extractorInput, r4, z5, 4);
                        if (jC == -2) {
                            extractorInput.k();
                            while (true) {
                                extractorInput.o(defaultEbmlReader.a, z5 ? 1 : 0, 4);
                                int iB = VarintReader.b(defaultEbmlReader.a[z5 ? 1 : 0]);
                                if (iB != -1 && iB <= 4) {
                                    int iA = (int) VarintReader.a(defaultEbmlReader.a, iB, z5);
                                    Objects.requireNonNull(MatroskaExtractor.this);
                                    if (iA == 357149030 || iA == 524531317 || iA == 475249515 || iA == 374648427) {
                                        extractorInput.l(iB);
                                        jC = iA;
                                    }
                                }
                                extractorInput.l(r4 == true ? 1 : 0);
                            }
                        }
                        if (jC == -1) {
                            z4 = false;
                        } else {
                            defaultEbmlReader.f = (int) jC;
                            defaultEbmlReader.e = r4 == true ? 1 : 0;
                        }
                    }
                    if (defaultEbmlReader.e == r4) {
                        defaultEbmlReader.g = defaultEbmlReader.c.c(extractorInput, z5, r4, 8);
                        defaultEbmlReader.e = 2;
                    }
                    EbmlProcessor ebmlProcessor = defaultEbmlReader.d;
                    int i4 = defaultEbmlReader.f;
                    Objects.requireNonNull(MatroskaExtractor.this);
                    switch (i4) {
                        case Opcodes.LXOR /* 131 */:
                        case Opcodes.L2I /* 136 */:
                        case 155:
                        case Opcodes.IF_ICMPEQ /* 159 */:
                        case Opcodes.ARETURN /* 176 */:
                        case Opcodes.PUTSTATIC /* 179 */:
                        case Opcodes.INVOKEDYNAMIC /* 186 */:
                        case 215:
                        case 231:
                        case 238:
                        case 241:
                        case 251:
                        case 16871:
                        case 16980:
                        case 17029:
                        case 17143:
                        case 18401:
                        case 18408:
                        case 20529:
                        case 20530:
                        case 21420:
                        case 21432:
                        case 21680:
                        case 21682:
                        case 21690:
                        case 21930:
                        case 21945:
                        case 21946:
                        case 21947:
                        case 21948:
                        case 21949:
                        case 21998:
                        case 22186:
                        case 22203:
                        case 25188:
                        case 30321:
                        case 2352003:
                        case 2807729:
                            i = 2;
                            break;
                        case Opcodes.I2F /* 134 */:
                        case 17026:
                        case 21358:
                        case 2274716:
                            i = 3;
                            break;
                        case Opcodes.IF_ICMPNE /* 160 */:
                        case Opcodes.IF_ACMPNE /* 166 */:
                        case Opcodes.FRETURN /* 174 */:
                        case Opcodes.INVOKESPECIAL /* 183 */:
                        case Opcodes.NEW /* 187 */:
                        case 224:
                        case HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION /* 225 */:
                        case 16868:
                        case 18407:
                        case 19899:
                        case 20532:
                        case 20533:
                        case 21936:
                        case 21968:
                        case 25152:
                        case 28032:
                        case 30113:
                        case 30320:
                        case 290298740:
                        case 357149030:
                        case 374648427:
                        case 408125543:
                        case 440786851:
                        case 475249515:
                        case 524531317:
                            i = 1;
                            break;
                        case Opcodes.IF_ICMPLT /* 161 */:
                        case Opcodes.IF_ICMPGT /* 163 */:
                        case Opcodes.IF_ACMPEQ /* 165 */:
                        case 16877:
                        case 16981:
                        case 18402:
                        case 21419:
                        case 25506:
                        case 30322:
                            i = 4;
                            break;
                        case Opcodes.PUTFIELD /* 181 */:
                        case 17545:
                        case 21969:
                        case 21970:
                        case 21971:
                        case 21972:
                        case 21973:
                        case 21974:
                        case 21975:
                        case 21976:
                        case 21977:
                        case 21978:
                        case 30323:
                        case 30324:
                        case 30325:
                            i = 5;
                            break;
                        default:
                            i = 0;
                            break;
                    }
                    if (i == 0) {
                        extractorInput.l((int) defaultEbmlReader.g);
                        z5 = false;
                        defaultEbmlReader.e = 0;
                        r4 = 1;
                    } else if (i == r4) {
                        long position = extractorInput.getPosition();
                        defaultEbmlReader.f1183b.push(new DefaultEbmlReader.b(defaultEbmlReader.f, defaultEbmlReader.g + position, null));
                        EbmlProcessor ebmlProcessor2 = defaultEbmlReader.d;
                        int i5 = defaultEbmlReader.f;
                        long j2 = defaultEbmlReader.g;
                        MatroskaExtractor matroskaExtractor = MatroskaExtractor.this;
                        AnimatableValueParser.H(matroskaExtractor.f1191f0);
                        if (i5 == 160) {
                            i2 = 0;
                            matroskaExtractor.V = false;
                        } else if (i5 == 174) {
                            i2 = 0;
                            matroskaExtractor.f1195z = new c(null);
                        } else if (i5 != 187) {
                            if (i5 == 19899) {
                                matroskaExtractor.B = -1;
                                matroskaExtractor.C = -1L;
                            } else if (i5 == 20533) {
                                matroskaExtractor.c(i5);
                                matroskaExtractor.f1195z.h = true;
                            } else if (i5 == 21968) {
                                matroskaExtractor.c(i5);
                                matroskaExtractor.f1195z.f1198x = true;
                            } else if (i5 == 408125543) {
                                long j3 = matroskaExtractor.v;
                                if (j3 != -1 && j3 != position) {
                                    throw ParserException.a("Multiple Segment elements not supported", null);
                                }
                                matroskaExtractor.v = position;
                                matroskaExtractor.u = j2;
                            } else if (i5 == 475249515) {
                                matroskaExtractor.H = new LongArray();
                                matroskaExtractor.I = new LongArray();
                            } else if (i5 == 524531317 && !matroskaExtractor.A) {
                                if (!matroskaExtractor.i || matroskaExtractor.E == -1) {
                                    matroskaExtractor.f1191f0.a(new SeekMap.b(matroskaExtractor.f1194y, 0L));
                                    matroskaExtractor.A = true;
                                } else {
                                    matroskaExtractor.D = true;
                                }
                            }
                            i2 = 0;
                        } else {
                            i2 = 0;
                            matroskaExtractor.J = false;
                        }
                        defaultEbmlReader.e = i2;
                    } else if (i == 2) {
                        long j4 = defaultEbmlReader.g;
                        if (j4 > 8) {
                            StringBuilder sb = new StringBuilder(42);
                            sb.append("Invalid integer size: ");
                            sb.append(j4);
                            throw ParserException.a(sb.toString(), null);
                        }
                        EbmlProcessor ebmlProcessor3 = defaultEbmlReader.d;
                        int i6 = defaultEbmlReader.f;
                        long jA = defaultEbmlReader.a(extractorInput, (int) j4);
                        MatroskaExtractor matroskaExtractor2 = MatroskaExtractor.this;
                        Objects.requireNonNull(matroskaExtractor2);
                        if (i6 != 20529) {
                            if (i6 != 20530) {
                                switch (i6) {
                                    case Opcodes.LXOR /* 131 */:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.d = (int) jA;
                                        break;
                                    case Opcodes.L2I /* 136 */:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.V = jA == 1;
                                        break;
                                    case 155:
                                        matroskaExtractor2.N = matroskaExtractor2.m(jA);
                                        break;
                                    case Opcodes.IF_ICMPEQ /* 159 */:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.O = (int) jA;
                                        break;
                                    case Opcodes.ARETURN /* 176 */:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.m = (int) jA;
                                        break;
                                    case Opcodes.PUTSTATIC /* 179 */:
                                        matroskaExtractor2.a(i6);
                                        matroskaExtractor2.H.a(matroskaExtractor2.m(jA));
                                        break;
                                    case Opcodes.INVOKEDYNAMIC /* 186 */:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.n = (int) jA;
                                        break;
                                    case 215:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.c = (int) jA;
                                        break;
                                    case 231:
                                        matroskaExtractor2.G = matroskaExtractor2.m(jA);
                                        break;
                                    case 238:
                                        matroskaExtractor2.U = (int) jA;
                                        break;
                                    case 241:
                                        if (!matroskaExtractor2.J) {
                                            matroskaExtractor2.a(i6);
                                            matroskaExtractor2.I.a(jA);
                                            matroskaExtractor2.J = true;
                                            break;
                                        }
                                        break;
                                    case 251:
                                        matroskaExtractor2.V = true;
                                        break;
                                    case 16871:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.g = (int) jA;
                                        break;
                                    case 16980:
                                        if (jA != 3) {
                                            throw ParserException.a(outline.i(50, "ContentCompAlgo ", jA, " not supported"), null);
                                        }
                                        break;
                                    case 17029:
                                        if (jA < 1 || jA > 2) {
                                            throw ParserException.a(outline.i(53, "DocTypeReadVersion ", jA, " not supported"), null);
                                        }
                                        break;
                                    case 17143:
                                        if (jA != 1) {
                                            throw ParserException.a(outline.i(50, "EBMLReadVersion ", jA, " not supported"), null);
                                        }
                                        break;
                                    case 18401:
                                        if (jA != 5) {
                                            throw ParserException.a(outline.i(49, "ContentEncAlgo ", jA, " not supported"), null);
                                        }
                                        break;
                                    case 18408:
                                        if (jA != 1) {
                                            throw ParserException.a(outline.i(56, "AESSettingsCipherMode ", jA, " not supported"), null);
                                        }
                                        break;
                                    case 21420:
                                        matroskaExtractor2.C = jA + matroskaExtractor2.v;
                                        break;
                                    case 21432:
                                        int i7 = (int) jA;
                                        matroskaExtractor2.c(i6);
                                        if (i7 != 0) {
                                            if (i7 != 1) {
                                                if (i7 != 3) {
                                                    if (i7 == 15) {
                                                        matroskaExtractor2.f1195z.w = 3;
                                                        break;
                                                    }
                                                } else {
                                                    matroskaExtractor2.f1195z.w = 1;
                                                    break;
                                                }
                                            } else {
                                                matroskaExtractor2.f1195z.w = 2;
                                                break;
                                            }
                                        } else {
                                            matroskaExtractor2.f1195z.w = 0;
                                            break;
                                        }
                                        break;
                                    case 21680:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.o = (int) jA;
                                        break;
                                    case 21682:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.q = (int) jA;
                                        break;
                                    case 21690:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.p = (int) jA;
                                        break;
                                    case 21930:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.U = jA == 1;
                                        break;
                                    case 21998:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.f = (int) jA;
                                        break;
                                    case 22186:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.R = jA;
                                        break;
                                    case 22203:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.S = jA;
                                        break;
                                    case 25188:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.P = (int) jA;
                                        break;
                                    case 30321:
                                        matroskaExtractor2.c(i6);
                                        int i8 = (int) jA;
                                        if (i8 != 0) {
                                            if (i8 != 1) {
                                                if (i8 != 2) {
                                                    if (i8 == 3) {
                                                        matroskaExtractor2.f1195z.r = 3;
                                                        break;
                                                    }
                                                } else {
                                                    matroskaExtractor2.f1195z.r = 2;
                                                    break;
                                                }
                                            } else {
                                                matroskaExtractor2.f1195z.r = 1;
                                                break;
                                            }
                                        } else {
                                            matroskaExtractor2.f1195z.r = 0;
                                            break;
                                        }
                                        break;
                                    case 2352003:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.e = (int) jA;
                                        break;
                                    case 2807729:
                                        matroskaExtractor2.w = jA;
                                        break;
                                    default:
                                        switch (i6) {
                                            case 21945:
                                                matroskaExtractor2.c(i6);
                                                int i9 = (int) jA;
                                                if (i9 != 1) {
                                                    if (i9 == 2) {
                                                        matroskaExtractor2.f1195z.A = 1;
                                                        break;
                                                    }
                                                } else {
                                                    matroskaExtractor2.f1195z.A = 2;
                                                    break;
                                                }
                                                break;
                                            case 21946:
                                                matroskaExtractor2.c(i6);
                                                int iB2 = ColorInfo.b((int) jA);
                                                if (iB2 != -1) {
                                                    matroskaExtractor2.f1195z.f1200z = iB2;
                                                    break;
                                                }
                                                break;
                                            case 21947:
                                                matroskaExtractor2.c(i6);
                                                matroskaExtractor2.f1195z.f1198x = true;
                                                int iA2 = ColorInfo.a((int) jA);
                                                if (iA2 != -1) {
                                                    matroskaExtractor2.f1195z.f1199y = iA2;
                                                    break;
                                                }
                                                break;
                                            case 21948:
                                                matroskaExtractor2.c(i6);
                                                matroskaExtractor2.f1195z.B = (int) jA;
                                                break;
                                            case 21949:
                                                matroskaExtractor2.c(i6);
                                                matroskaExtractor2.f1195z.C = (int) jA;
                                                break;
                                        }
                                }
                            } else if (jA != 1) {
                                throw ParserException.a(outline.i(55, "ContentEncodingScope ", jA, " not supported"), null);
                            }
                        } else if (jA != 0) {
                            throw ParserException.a(outline.i(55, "ContentEncodingOrder ", jA, " not supported"), null);
                        }
                        defaultEbmlReader.e = 0;
                    } else if (i == 3) {
                        long j5 = defaultEbmlReader.g;
                        if (j5 > 2147483647L) {
                            StringBuilder sb2 = new StringBuilder(41);
                            sb2.append("String element size: ");
                            sb2.append(j5);
                            throw ParserException.a(sb2.toString(), null);
                        }
                        EbmlProcessor ebmlProcessor4 = defaultEbmlReader.d;
                        int i10 = defaultEbmlReader.f;
                        int i11 = (int) j5;
                        if (i11 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i11];
                            extractorInput.readFully(bArr, 0, i11);
                            while (i11 > 0) {
                                int i12 = i11 - 1;
                                if (bArr[i12] == 0) {
                                    i11 = i12;
                                } else {
                                    str = new String(bArr, 0, i11);
                                }
                            }
                            str = new String(bArr, 0, i11);
                        }
                        MatroskaExtractor matroskaExtractor3 = MatroskaExtractor.this;
                        Objects.requireNonNull(matroskaExtractor3);
                        if (i10 == 134) {
                            matroskaExtractor3.c(i10);
                            matroskaExtractor3.f1195z.f1196b = str;
                        } else if (i10 != 17026) {
                            if (i10 == 21358) {
                                matroskaExtractor3.c(i10);
                                matroskaExtractor3.f1195z.a = str;
                            } else if (i10 == 2274716) {
                                matroskaExtractor3.c(i10);
                                matroskaExtractor3.f1195z.W = str;
                            }
                        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
                            StringBuilder sb3 = new StringBuilder(str.length() + 22);
                            sb3.append("DocType ");
                            sb3.append(str);
                            sb3.append(" not supported");
                            throw ParserException.a(sb3.toString(), null);
                        }
                        defaultEbmlReader.e = 0;
                    } else if (i == 4) {
                        EbmlProcessor ebmlProcessor5 = defaultEbmlReader.d;
                        int i13 = defaultEbmlReader.f;
                        int i14 = (int) defaultEbmlReader.g;
                        MatroskaExtractor matroskaExtractor4 = MatroskaExtractor.this;
                        Objects.requireNonNull(matroskaExtractor4);
                        if (i13 == 161 || i13 == 163) {
                            if (matroskaExtractor4.L == 0) {
                                matroskaExtractor4.R = (int) matroskaExtractor4.g.c(extractorInput, z5, r4, 8);
                                matroskaExtractor4.S = matroskaExtractor4.g.d;
                                matroskaExtractor4.N = -9223372036854775807L;
                                matroskaExtractor4.L = r4 == true ? 1 : 0;
                                matroskaExtractor4.l.A(z5 ? 1 : 0);
                            }
                            c cVar = matroskaExtractor4.h.get(matroskaExtractor4.R);
                            if (cVar == null) {
                                extractorInput.l(i14 - matroskaExtractor4.S);
                                matroskaExtractor4.L = z5 ? 1 : 0;
                            } else {
                                Objects.requireNonNull(cVar.X);
                                if (matroskaExtractor4.L == r4) {
                                    matroskaExtractor4.k(extractorInput, 3);
                                    int i15 = (matroskaExtractor4.l.a[2] & 6) >> (r4 == true ? 1 : 0);
                                    byte b2 = 255;
                                    if (i15 == 0) {
                                        matroskaExtractor4.P = r4 == true ? 1 : 0;
                                        int[] iArrI = i(matroskaExtractor4.Q, r4 == true ? 1 : 0);
                                        matroskaExtractor4.Q = iArrI;
                                        iArrI[z5 ? 1 : 0] = (i14 - matroskaExtractor4.S) - 3;
                                    } else {
                                        matroskaExtractor4.k(extractorInput, 4);
                                        int i16 = (matroskaExtractor4.l.a[3] & 255) + (r4 == true ? 1 : 0);
                                        matroskaExtractor4.P = i16;
                                        int[] iArrI2 = i(matroskaExtractor4.Q, i16);
                                        matroskaExtractor4.Q = iArrI2;
                                        if (i15 == 2) {
                                            int i17 = (i14 - matroskaExtractor4.S) - 4;
                                            int i18 = matroskaExtractor4.P;
                                            Arrays.fill(iArrI2, z5 ? 1 : 0, i18, i17 / i18);
                                        } else {
                                            int i19 = 4;
                                            if (i15 != r4) {
                                                if (i15 != 3) {
                                                    throw outline.w0(36, "Unexpected lacing value: ", i15, null);
                                                }
                                                int i20 = 0;
                                                int i21 = 0;
                                                ?? r3 = z5;
                                                int i22 = r4;
                                                while (true) {
                                                    int i23 = matroskaExtractor4.P;
                                                    if (i20 < i23 - 1) {
                                                        matroskaExtractor4.Q[i20] = r3;
                                                        i19++;
                                                        matroskaExtractor4.k(extractorInput, i19);
                                                        int i24 = i19 - 1;
                                                        if (matroskaExtractor4.l.a[i24] == 0) {
                                                            throw ParserException.a("No valid varint length mask found", null);
                                                        }
                                                        int i25 = 8;
                                                        int i26 = 0;
                                                        int i27 = i22;
                                                        while (true) {
                                                            if (i26 < i25) {
                                                                int i28 = i27 << (7 - i26);
                                                                if ((matroskaExtractor4.l.a[i24] & i28) != 0) {
                                                                    int i29 = i19 + i26;
                                                                    matroskaExtractor4.k(extractorInput, i29);
                                                                    j = (~i28) & matroskaExtractor4.l.a[i24] & b2;
                                                                    int i30 = i24 + 1;
                                                                    while (i30 < i29) {
                                                                        j = (j << 8) | (matroskaExtractor4.l.a[i30] & 255);
                                                                        i30++;
                                                                        i29 = i29;
                                                                    }
                                                                    int i31 = i29;
                                                                    if (i20 > 0) {
                                                                        j -= (1 << ((i26 * 7) + 6)) - 1;
                                                                    }
                                                                    i19 = i31;
                                                                } else {
                                                                    i26++;
                                                                    i25 = 8;
                                                                    i27 = 1;
                                                                    b2 = 255;
                                                                }
                                                            } else {
                                                                j = 0;
                                                            }
                                                        }
                                                        if (j >= -2147483648L && j <= 2147483647L) {
                                                            int i32 = (int) j;
                                                            int[] iArr2 = matroskaExtractor4.Q;
                                                            if (i20 != 0) {
                                                                i32 += iArr2[i20 - 1];
                                                            }
                                                            iArr2[i20] = i32;
                                                            i21 += iArr2[i20];
                                                            i20++;
                                                            r3 = 0;
                                                            i22 = 1;
                                                            b2 = 255;
                                                        }
                                                    } else {
                                                        matroskaExtractor4.Q[i23 - 1] = ((i14 - matroskaExtractor4.S) - i19) - i21;
                                                    }
                                                }
                                                throw ParserException.a("EBML lacing sample size out of range.", null);
                                            }
                                            int i33 = 0;
                                            int i34 = 0;
                                            while (true) {
                                                int i35 = matroskaExtractor4.P;
                                                if (i33 < i35 - 1) {
                                                    matroskaExtractor4.Q[i33] = z5 ? 1 : 0;
                                                    do {
                                                        i19 += r4 == true ? 1 : 0;
                                                        matroskaExtractor4.k(extractorInput, i19);
                                                        i3 = matroskaExtractor4.l.a[i19 - 1] & 255;
                                                        iArr = matroskaExtractor4.Q;
                                                        iArr[i33] = iArr[i33] + i3;
                                                    } while (i3 == 255);
                                                    i34 += iArr[i33];
                                                    i33++;
                                                } else {
                                                    matroskaExtractor4.Q[i35 - 1] = ((i14 - matroskaExtractor4.S) - i19) - i34;
                                                }
                                            }
                                        }
                                    }
                                    byte[] bArr2 = matroskaExtractor4.l.a;
                                    matroskaExtractor4.M = matroskaExtractor4.m((bArr2[1] & 255) | (bArr2[0] << 8)) + matroskaExtractor4.G;
                                    matroskaExtractor4.T = (cVar.d == 2 || (i13 == 163 && (matroskaExtractor4.l.a[2] & 128) == 128)) ? 1 : 0;
                                    matroskaExtractor4.L = 2;
                                    matroskaExtractor4.O = 0;
                                }
                                if (i13 == 163) {
                                    while (true) {
                                        int i36 = matroskaExtractor4.O;
                                        if (i36 < matroskaExtractor4.P) {
                                            matroskaExtractor4.d(cVar, ((matroskaExtractor4.O * cVar.e) / 1000) + matroskaExtractor4.M, matroskaExtractor4.T, matroskaExtractor4.n(extractorInput, cVar, matroskaExtractor4.Q[i36]), 0);
                                            matroskaExtractor4.O++;
                                        } else {
                                            matroskaExtractor4.L = 0;
                                        }
                                    }
                                } else {
                                    while (true) {
                                        int i37 = matroskaExtractor4.O;
                                        if (i37 < matroskaExtractor4.P) {
                                            int[] iArr3 = matroskaExtractor4.Q;
                                            iArr3[i37] = matroskaExtractor4.n(extractorInput, cVar, iArr3[i37]);
                                            matroskaExtractor4.O++;
                                        }
                                    }
                                }
                            }
                        } else if (i13 != 165) {
                            if (i13 == 16877) {
                                matroskaExtractor4.c(i13);
                                c cVar2 = matroskaExtractor4.f1195z;
                                int i38 = cVar2.g;
                                if (i38 == 1685485123 || i38 == 1685480259) {
                                    byte[] bArr3 = new byte[i14];
                                    cVar2.N = bArr3;
                                    extractorInput.readFully(bArr3, z5 ? 1 : 0, i14);
                                } else {
                                    extractorInput.l(i14);
                                }
                            } else if (i13 == 16981) {
                                matroskaExtractor4.c(i13);
                                byte[] bArr4 = new byte[i14];
                                matroskaExtractor4.f1195z.i = bArr4;
                                extractorInput.readFully(bArr4, z5 ? 1 : 0, i14);
                            } else if (i13 == 18402) {
                                byte[] bArr5 = new byte[i14];
                                extractorInput.readFully(bArr5, z5 ? 1 : 0, i14);
                                matroskaExtractor4.c(i13);
                                matroskaExtractor4.f1195z.j = new TrackOutput2.a(r4 == true ? 1 : 0, bArr5, z5 ? 1 : 0, z5 ? 1 : 0);
                            } else if (i13 == 21419) {
                                Arrays.fill(matroskaExtractor4.n.a, z5 ? (byte) 1 : (byte) 0);
                                extractorInput.readFully(matroskaExtractor4.n.a, 4 - i14, i14);
                                matroskaExtractor4.n.E(z5 ? 1 : 0);
                                matroskaExtractor4.B = (int) matroskaExtractor4.n.u();
                            } else if (i13 == 25506) {
                                matroskaExtractor4.c(i13);
                                byte[] bArr6 = new byte[i14];
                                matroskaExtractor4.f1195z.k = bArr6;
                                extractorInput.readFully(bArr6, z5 ? 1 : 0, i14);
                            } else {
                                if (i13 != 30322) {
                                    throw outline.w0(26, "Unexpected id: ", i13, null);
                                }
                                matroskaExtractor4.c(i13);
                                byte[] bArr7 = new byte[i14];
                                matroskaExtractor4.f1195z.v = bArr7;
                                extractorInput.readFully(bArr7, z5 ? 1 : 0, i14);
                            }
                        } else if (matroskaExtractor4.L == 2) {
                            c cVar3 = matroskaExtractor4.h.get(matroskaExtractor4.R);
                            if (matroskaExtractor4.U == 4 && "V_VP9".equals(cVar3.f1196b)) {
                                ParsableByteArray parsableByteArray = matroskaExtractor4.f1192s;
                                byte[] bArr8 = parsableByteArray.a;
                                if (bArr8.length < i14) {
                                    bArr8 = new byte[i14];
                                }
                                parsableByteArray.C(bArr8, i14);
                                extractorInput.readFully(matroskaExtractor4.f1192s.a, z5 ? 1 : 0, i14);
                            } else {
                                extractorInput.l(i14);
                            }
                        }
                        defaultEbmlReader.e = 0;
                    } else {
                        if (i != 5) {
                            throw outline.w0(32, "Invalid element type ", i, null);
                        }
                        long j6 = defaultEbmlReader.g;
                        if (j6 != 4 && j6 != 8) {
                            StringBuilder sb4 = new StringBuilder(40);
                            sb4.append("Invalid float size: ");
                            sb4.append(j6);
                            throw ParserException.a(sb4.toString(), null);
                        }
                        EbmlProcessor ebmlProcessor6 = defaultEbmlReader.d;
                        int i39 = defaultEbmlReader.f;
                        int i40 = (int) j6;
                        double dIntBitsToFloat = i40 == 4 ? Float.intBitsToFloat((int) r9) : Double.longBitsToDouble(defaultEbmlReader.a(extractorInput, i40));
                        MatroskaExtractor matroskaExtractor5 = MatroskaExtractor.this;
                        Objects.requireNonNull(matroskaExtractor5);
                        if (i39 == 181) {
                            matroskaExtractor5.c(i39);
                            matroskaExtractor5.f1195z.Q = (int) dIntBitsToFloat;
                        } else if (i39 != 17545) {
                            switch (i39) {
                                case 21969:
                                    matroskaExtractor5.c(i39);
                                    matroskaExtractor5.f1195z.D = (float) dIntBitsToFloat;
                                    break;
                                case 21970:
                                    matroskaExtractor5.c(i39);
                                    matroskaExtractor5.f1195z.E = (float) dIntBitsToFloat;
                                    break;
                                case 21971:
                                    matroskaExtractor5.c(i39);
                                    matroskaExtractor5.f1195z.F = (float) dIntBitsToFloat;
                                    break;
                                case 21972:
                                    matroskaExtractor5.c(i39);
                                    matroskaExtractor5.f1195z.G = (float) dIntBitsToFloat;
                                    break;
                                case 21973:
                                    matroskaExtractor5.c(i39);
                                    matroskaExtractor5.f1195z.H = (float) dIntBitsToFloat;
                                    break;
                                case 21974:
                                    matroskaExtractor5.c(i39);
                                    matroskaExtractor5.f1195z.I = (float) dIntBitsToFloat;
                                    break;
                                case 21975:
                                    matroskaExtractor5.c(i39);
                                    matroskaExtractor5.f1195z.J = (float) dIntBitsToFloat;
                                    break;
                                case 21976:
                                    matroskaExtractor5.c(i39);
                                    matroskaExtractor5.f1195z.K = (float) dIntBitsToFloat;
                                    break;
                                case 21977:
                                    matroskaExtractor5.c(i39);
                                    matroskaExtractor5.f1195z.L = (float) dIntBitsToFloat;
                                    break;
                                case 21978:
                                    matroskaExtractor5.c(i39);
                                    matroskaExtractor5.f1195z.M = (float) dIntBitsToFloat;
                                    break;
                                default:
                                    switch (i39) {
                                        case 30323:
                                            matroskaExtractor5.c(i39);
                                            matroskaExtractor5.f1195z.f1197s = (float) dIntBitsToFloat;
                                            break;
                                        case 30324:
                                            matroskaExtractor5.c(i39);
                                            matroskaExtractor5.f1195z.t = (float) dIntBitsToFloat;
                                            break;
                                        case 30325:
                                            matroskaExtractor5.c(i39);
                                            matroskaExtractor5.f1195z.u = (float) dIntBitsToFloat;
                                            break;
                                    }
                            }
                        } else {
                            matroskaExtractor5.f1193x = (long) dIntBitsToFloat;
                        }
                        defaultEbmlReader.e = z5 ? 1 : 0;
                    }
                } else {
                    MatroskaExtractor.this.h(defaultEbmlReader.f1183b.pop().a);
                }
            }
        }
        if (z4) {
            return 0;
        }
        for (int i41 = 0; i41 < this.h.size(); i41++) {
            c cVarValueAt = this.h.valueAt(i41);
            Objects.requireNonNull(cVarValueAt.X);
            TrueHdSampleRechunker trueHdSampleRechunker = cVarValueAt.T;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.a(cVarValueAt.X, cVarValueAt.j);
            }
        }
        return -1;
    }

    @Override // b.i.a.c.x2.Extractor
    public final void f(ExtractorOutput extractorOutput) {
        this.f1191f0 = extractorOutput;
    }

    @Override // b.i.a.c.x2.Extractor
    @CallSuper
    public void g(long j, long j2) {
        this.G = -9223372036854775807L;
        this.L = 0;
        DefaultEbmlReader defaultEbmlReader = (DefaultEbmlReader) this.f;
        defaultEbmlReader.e = 0;
        defaultEbmlReader.f1183b.clear();
        VarintReader varintReader = defaultEbmlReader.c;
        varintReader.c = 0;
        varintReader.d = 0;
        VarintReader varintReader2 = this.g;
        varintReader2.c = 0;
        varintReader2.d = 0;
        l();
        for (int i = 0; i < this.h.size(); i++) {
            TrueHdSampleRechunker trueHdSampleRechunker = this.h.valueAt(i).T;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.f1300b = false;
                trueHdSampleRechunker.c = 0;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:210:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x080e  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x083c  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0866  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x087d  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x087f  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x088c  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x0899  */
    /* JADX WARN: Removed duplicated region for block: B:553:0x09c6  */
    /* JADX WARN: Removed duplicated region for block: B:575:0x0a19  */
    /* JADX WARN: Removed duplicated region for block: B:593:0x0a69  */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v9, types: [b.i.a.c.x2.g0.e$c, java.lang.Object] */
    @CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(int i) throws ParserException {
        boolean z2;
        char c2;
        boolean z3;
        int iR;
        List<byte[]> listSingletonList;
        int i2;
        List<byte[]> list;
        String str;
        String str2;
        String str3;
        ArrayList arrayList;
        Pair pair;
        Pair pair2;
        String str4;
        List<byte[]> list2;
        String str5;
        String str6;
        String str7;
        int i3;
        String str8;
        List<byte[]> list3;
        List<byte[]> list4;
        List<byte[]> listU;
        byte[] bArr;
        Format2.b bVar;
        int i4;
        int i5;
        ColorInfo colorInfo;
        int i6;
        byte[] bArr2;
        int i7;
        String str9;
        DolbyVisionConfig dolbyVisionConfigA;
        List<byte[]> list5;
        List<byte[]> list6;
        SeekMap bVar2;
        int i8;
        int i9;
        AnimatableValueParser.H(this.f1191f0);
        int i10 = 0;
        if (i == 160) {
            if (this.L != 2) {
                return;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.P; i12++) {
                i11 += this.Q[i12];
            }
            c cVar = this.h.get(this.R);
            Objects.requireNonNull(cVar.X);
            int i13 = 0;
            while (i13 < this.P) {
                long j = this.M + ((cVar.e * i13) / 1000);
                int i14 = this.T;
                if (i13 == 0 && !this.V) {
                    i14 |= 1;
                }
                int i15 = this.Q[i13];
                int i16 = i11 - i15;
                d(cVar, j, i14, i15, i16);
                i13++;
                i11 = i16;
            }
            this.L = 0;
            return;
        }
        if (i != 174) {
            if (i == 19899) {
                int i17 = this.B;
                if (i17 != -1) {
                    long j2 = this.C;
                    if (j2 != -1) {
                        if (i17 == 475249515) {
                            this.E = j2;
                            return;
                        }
                        return;
                    }
                }
                throw ParserException.a("Mandatory element SeekID or SeekPosition not found", null);
            }
            if (i == 25152) {
                c(i);
                c cVar2 = this.f1195z;
                if (cVar2.h) {
                    TrackOutput2.a aVar = cVar2.j;
                    if (aVar == null) {
                        throw ParserException.a("Encrypted Track found but ContentEncKeyID was not found", null);
                    }
                    cVar2.l = new DrmInitData(null, true, new DrmInitData.SchemeData(C.a, "video/webm", aVar.f1299b));
                    return;
                }
                return;
            }
            if (i == 28032) {
                c(i);
                c cVar3 = this.f1195z;
                if (cVar3.h && cVar3.i != null) {
                    throw ParserException.a("Combining encryption and compression is not supported", null);
                }
                return;
            }
            if (i == 357149030) {
                if (this.w == -9223372036854775807L) {
                    this.w = 1000000L;
                }
                long j3 = this.f1193x;
                if (j3 != -9223372036854775807L) {
                    this.f1194y = m(j3);
                    return;
                }
                return;
            }
            if (i == 374648427) {
                if (this.h.size() == 0) {
                    throw ParserException.a("No valid tracks were found", null);
                }
                this.f1191f0.j();
                return;
            }
            if (i != 475249515) {
                return;
            }
            if (!this.A) {
                ExtractorOutput extractorOutput = this.f1191f0;
                LongArray longArray = this.H;
                LongArray longArray2 = this.I;
                if (this.v == -1 || this.f1194y == -9223372036854775807L || longArray == null || (i8 = longArray.a) == 0 || longArray2 == null || longArray2.a != i8) {
                    bVar2 = new SeekMap.b(this.f1194y, 0L);
                } else {
                    int[] iArrCopyOf = new int[i8];
                    long[] jArrCopyOf = new long[i8];
                    long[] jArrCopyOf2 = new long[i8];
                    long[] jArrCopyOf3 = new long[i8];
                    for (int i18 = 0; i18 < i8; i18++) {
                        jArrCopyOf3[i18] = longArray.b(i18);
                        jArrCopyOf[i18] = longArray2.b(i18) + this.v;
                    }
                    while (true) {
                        i9 = i8 - 1;
                        if (i10 >= i9) {
                            break;
                        }
                        int i19 = i10 + 1;
                        iArrCopyOf[i10] = (int) (jArrCopyOf[i19] - jArrCopyOf[i10]);
                        jArrCopyOf2[i10] = jArrCopyOf3[i19] - jArrCopyOf3[i10];
                        i10 = i19;
                    }
                    iArrCopyOf[i9] = (int) ((this.v + this.u) - jArrCopyOf[i9]);
                    jArrCopyOf2[i9] = this.f1194y - jArrCopyOf3[i9];
                    long j4 = jArrCopyOf2[i9];
                    if (j4 <= 0) {
                        StringBuilder sb = new StringBuilder(72);
                        sb.append("Discarding last cue point with unexpected duration: ");
                        sb.append(j4);
                        Log.w("MatroskaExtractor", sb.toString());
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i9);
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i9);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i9);
                        jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i9);
                    }
                    bVar2 = new ChunkIndex(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
                }
                extractorOutput.a(bVar2);
                this.A = true;
            }
            this.H = null;
            this.I = null;
            return;
        }
        ?? r0 = this.f1195z;
        AnimatableValueParser.H(r0);
        String str10 = r0.f1196b;
        if (str10 == null) {
            throw ParserException.a("CodecId is missing in TrackEntry element", null);
        }
        switch (str10) {
            case "V_MPEG4/ISO/AP":
            case "V_MPEG4/ISO/SP":
            case "A_MS/ACM":
            case "A_TRUEHD":
            case "A_VORBIS":
            case "A_MPEG/L2":
            case "A_MPEG/L3":
            case "V_MS/VFW/FOURCC":
            case "S_DVBSUB":
            case "V_MPEG4/ISO/ASP":
            case "V_MPEG4/ISO/AVC":
            case "S_VOBSUB":
            case "A_DTS/LOSSLESS":
            case "A_AAC":
            case "A_AC3":
            case "A_DTS":
            case "V_AV1":
            case "V_VP8":
            case "V_VP9":
            case "S_HDMV/PGS":
            case "V_THEORA":
            case "A_DTS/EXPRESS":
            case "A_PCM/FLOAT/IEEE":
            case "A_PCM/INT/BIG":
            case "A_PCM/INT/LIT":
            case "S_TEXT/ASS":
            case "V_MPEGH/ISO/HEVC":
            case "S_TEXT/UTF8":
            case "V_MPEG2":
            case "A_EAC3":
            case "A_FLAC":
            case "A_OPUS":
                z2 = true;
                break;
            default:
                z2 = false;
                break;
        }
        if (z2) {
            ExtractorOutput extractorOutput2 = this.f1191f0;
            int i20 = r0.c;
            String str11 = r0.f1196b;
            str11.hashCode();
            switch (str11.hashCode()) {
                case -2095576542:
                    if (str11.equals("V_MPEG4/ISO/AP")) {
                        c2 = 0;
                        break;
                    } else {
                        c2 = 65535;
                        break;
                    }
                case -2095575984:
                    if (str11.equals("V_MPEG4/ISO/SP")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1985379776:
                    if (str11.equals("A_MS/ACM")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1784763192:
                    if (str11.equals("A_TRUEHD")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1730367663:
                    if (str11.equals("A_VORBIS")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1482641358:
                    if (str11.equals("A_MPEG/L2")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1482641357:
                    if (str11.equals("A_MPEG/L3")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -1373388978:
                    if (str11.equals("V_MS/VFW/FOURCC")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -933872740:
                    if (str11.equals("S_DVBSUB")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -538363189:
                    if (str11.equals("V_MPEG4/ISO/ASP")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case -538363109:
                    if (str11.equals("V_MPEG4/ISO/AVC")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case -425012669:
                    if (str11.equals("S_VOBSUB")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case -356037306:
                    if (str11.equals("A_DTS/LOSSLESS")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 62923557:
                    if (str11.equals("A_AAC")) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case 62923603:
                    if (str11.equals("A_AC3")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case 62927045:
                    if (str11.equals("A_DTS")) {
                        c2 = 15;
                        break;
                    }
                    break;
                case 82318131:
                    if (str11.equals("V_AV1")) {
                        c2 = 16;
                        break;
                    }
                    break;
                case 82338133:
                    if (str11.equals("V_VP8")) {
                        c2 = 17;
                        break;
                    }
                    break;
                case 82338134:
                    if (str11.equals("V_VP9")) {
                        c2 = 18;
                        break;
                    }
                    break;
                case 99146302:
                    if (str11.equals("S_HDMV/PGS")) {
                        c2 = 19;
                        break;
                    }
                    break;
                case 444813526:
                    if (str11.equals("V_THEORA")) {
                        c2 = 20;
                        break;
                    }
                    break;
                case 542569478:
                    if (str11.equals("A_DTS/EXPRESS")) {
                        c2 = 21;
                        break;
                    }
                    break;
                case 635596514:
                    if (str11.equals("A_PCM/FLOAT/IEEE")) {
                        c2 = 22;
                        break;
                    }
                    break;
                case 725948237:
                    if (str11.equals("A_PCM/INT/BIG")) {
                        c2 = 23;
                        break;
                    }
                    break;
                case 725957860:
                    if (str11.equals("A_PCM/INT/LIT")) {
                        c2 = 24;
                        break;
                    }
                    break;
                case 738597099:
                    if (str11.equals("S_TEXT/ASS")) {
                        c2 = 25;
                        break;
                    }
                    break;
                case 855502857:
                    if (str11.equals("V_MPEGH/ISO/HEVC")) {
                        c2 = 26;
                        break;
                    }
                    break;
                case 1422270023:
                    if (str11.equals("S_TEXT/UTF8")) {
                        c2 = 27;
                        break;
                    }
                    break;
                case 1809237540:
                    if (str11.equals("V_MPEG2")) {
                        c2 = 28;
                        break;
                    }
                    break;
                case 1950749482:
                    if (str11.equals("A_EAC3")) {
                        c2 = 29;
                        break;
                    }
                    break;
                case 1950789798:
                    if (str11.equals("A_FLAC")) {
                        c2 = 30;
                        break;
                    }
                    break;
                case 1951062397:
                    if (str11.equals("A_OPUS")) {
                        c2 = 31;
                        break;
                    }
                    break;
            }
            String str12 = "video/x-unknown";
            String str13 = "audio/x-unknown";
            switch (c2) {
                case 0:
                case 1:
                case '\t':
                    byte[] bArr3 = r0.k;
                    str13 = "video/mp4v-es";
                    listSingletonList = bArr3 == null ? null : Collections.singletonList(bArr3);
                    i2 = -1;
                    list = listSingletonList;
                    str = null;
                    list5 = list;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null && (dolbyVisionConfigA = DolbyVisionConfig.a(new ParsableByteArray(bArr))) != null) {
                        str8 = dolbyVisionConfigA.a;
                        str13 = "video/dolby-vision";
                    }
                    int i21 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i4 = 1;
                    } else if (MimeTypes.j(str13)) {
                        if (r0.q == 0) {
                            int i22 = r0.o;
                            i5 = -1;
                            if (i22 == -1) {
                                i22 = r0.m;
                            }
                            r0.o = i22;
                            int i23 = r0.p;
                            if (i23 == -1) {
                                i23 = r0.n;
                            }
                            r0.p = i23;
                        } else {
                            i5 = -1;
                        }
                        float f = -1.0f;
                        if (r0.o != i5 && (i7 = r0.p) != i5) {
                            f = (r0.n * r8) / (r0.m * i7);
                        }
                        if (r0.f1198x) {
                            if (r0.D == -1.0f || r0.E == -1.0f || r0.F == -1.0f || r0.G == -1.0f || r0.H == -1.0f || r0.I == -1.0f || r0.J == -1.0f || r0.K == -1.0f || r0.L == -1.0f || r0.M == -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = new byte[25];
                                ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder.put((byte) 0);
                                byteBufferOrder.putShort((short) ((r0.D * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.E * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.F * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.G * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.H * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.I * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.J * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.K * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) (r0.L + 0.5f));
                                byteBufferOrder.putShort((short) (r0.M + 0.5f));
                                byteBufferOrder.putShort((short) r0.B);
                                byteBufferOrder.putShort((short) r0.C);
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        String str14 = r0.a;
                        if (str14 != null) {
                            Map<String, Integer> map = e;
                            int iIntValue = map.containsKey(str14) ? map.get(r0.a).intValue() : -1;
                            if (r0.r == 0 && Float.compare(r0.f1197s, 0.0f) == 0 && Float.compare(r0.t, 0.0f) == 0) {
                                if (Float.compare(r0.u, 0.0f) == 0) {
                                    i6 = 0;
                                } else if (Float.compare(r0.t, 90.0f) == 0) {
                                    i6 = 90;
                                } else if (Float.compare(r0.t, -180.0f) == 0 || Float.compare(r0.t, 180.0f) == 0) {
                                    i6 = 180;
                                } else if (Float.compare(r0.t, -90.0f) == 0) {
                                    i6 = 270;
                                }
                                bVar.p = r0.m;
                                bVar.q = r0.n;
                                bVar.t = f;
                                bVar.f1022s = i6;
                                bVar.u = r0.v;
                                bVar.v = r0.w;
                                bVar.w = colorInfo;
                                i4 = 2;
                            } else {
                                i6 = iIntValue;
                                bVar.p = r0.m;
                                bVar.q = r0.n;
                                bVar.t = f;
                                bVar.f1022s = i6;
                                bVar.u = r0.v;
                                bVar.v = r0.w;
                                bVar.w = colorInfo;
                                i4 = 2;
                            }
                        }
                    } else {
                        if (!"application/x-subrip".equals(str13) && !"text/x-ssa".equals(str13) && !"application/vobsub".equals(str13) && !"application/pgs".equals(str13) && !"application/dvbsubs".equals(str13)) {
                            throw ParserException.a("Unexpected MIME type.", null);
                        }
                        i4 = 3;
                    }
                    str9 = r0.a;
                    if (str9 != null && !e.containsKey(str9)) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i21;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A = bVar.a();
                    TrackOutput2 trackOutput2P = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P;
                    trackOutput2P.e(format2A);
                    this.h.put(r0.c, r0);
                    break;
                case 2:
                    ParsableByteArray parsableByteArray = new ParsableByteArray(r0.a(r0.f1196b));
                    try {
                        int iL = parsableByteArray.l();
                        if (iL != 1) {
                            if (iL == 65534) {
                                parsableByteArray.E(24);
                                long jM = parsableByteArray.m();
                                UUID uuid = d;
                                if (jM == uuid.getMostSignificantBits()) {
                                    if (parsableByteArray.m() == uuid.getLeastSignificantBits()) {
                                    }
                                    if (z3) {
                                        iR = Util2.r(r0.P);
                                        if (iR == 0) {
                                            int i24 = r0.P;
                                            StringBuilder sb2 = new StringBuilder(75);
                                            sb2.append("Unsupported PCM bit depth: ");
                                            sb2.append(i24);
                                            sb2.append(". Setting mimeType to ");
                                            sb2.append("audio/x-unknown");
                                            Log.w("MatroskaExtractor", sb2.toString());
                                        }
                                        str13 = "audio/raw";
                                        list2 = null;
                                        i3 = -1;
                                        str8 = null;
                                        bArr = r0.N;
                                        if (bArr != null) {
                                            str8 = dolbyVisionConfigA.a;
                                            str13 = "video/dolby-vision";
                                            break;
                                        }
                                        int i212 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                                        bVar = new Format2.b();
                                        if (MimeTypes.h(str13)) {
                                        }
                                        str9 = r0.a;
                                        if (str9 != null) {
                                            bVar.f1021b = r0.a;
                                            break;
                                        }
                                        bVar.b(i20);
                                        bVar.k = str13;
                                        bVar.l = i3;
                                        bVar.c = r0.W;
                                        bVar.d = i212;
                                        bVar.m = list2;
                                        bVar.h = str8;
                                        bVar.n = r0.l;
                                        Format2 format2A2 = bVar.a();
                                        TrackOutput2 trackOutput2P2 = extractorOutput2.p(r0.c, i4);
                                        r0.X = trackOutput2P2;
                                        trackOutput2P2.e(format2A2);
                                        this.h.put(r0.c, r0);
                                        break;
                                    } else {
                                        Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat("audio/x-unknown"));
                                    }
                                    listSingletonList = null;
                                    i2 = -1;
                                    list = listSingletonList;
                                    str = null;
                                    list5 = list;
                                    str8 = str;
                                    i3 = i2;
                                    list2 = list5;
                                    iR = -1;
                                    bArr = r0.N;
                                    if (bArr != null) {
                                    }
                                    int i2122 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                                    bVar = new Format2.b();
                                    if (MimeTypes.h(str13)) {
                                    }
                                    str9 = r0.a;
                                    if (str9 != null) {
                                    }
                                    bVar.b(i20);
                                    bVar.k = str13;
                                    bVar.l = i3;
                                    bVar.c = r0.W;
                                    bVar.d = i2122;
                                    bVar.m = list2;
                                    bVar.h = str8;
                                    bVar.n = r0.l;
                                    Format2 format2A22 = bVar.a();
                                    TrackOutput2 trackOutput2P22 = extractorOutput2.p(r0.c, i4);
                                    r0.X = trackOutput2P22;
                                    trackOutput2P22.e(format2A22);
                                    this.h.put(r0.c, r0);
                                }
                            }
                            z3 = false;
                            if (z3) {
                            }
                            listSingletonList = null;
                            i2 = -1;
                            list = listSingletonList;
                            str = null;
                            list5 = list;
                            str8 = str;
                            i3 = i2;
                            list2 = list5;
                            iR = -1;
                            bArr = r0.N;
                            if (bArr != null) {
                            }
                            int i21222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                            bVar = new Format2.b();
                            if (MimeTypes.h(str13)) {
                            }
                            str9 = r0.a;
                            if (str9 != null) {
                            }
                            bVar.b(i20);
                            bVar.k = str13;
                            bVar.l = i3;
                            bVar.c = r0.W;
                            bVar.d = i21222;
                            bVar.m = list2;
                            bVar.h = str8;
                            bVar.n = r0.l;
                            Format2 format2A222 = bVar.a();
                            TrackOutput2 trackOutput2P222 = extractorOutput2.p(r0.c, i4);
                            r0.X = trackOutput2P222;
                            trackOutput2P222.e(format2A222);
                            this.h.put(r0.c, r0);
                        }
                        z3 = true;
                        if (z3) {
                        }
                        listSingletonList = null;
                        i2 = -1;
                        list = listSingletonList;
                        str = null;
                        list5 = list;
                        str8 = str;
                        i3 = i2;
                        list2 = list5;
                        iR = -1;
                        bArr = r0.N;
                        if (bArr != null) {
                        }
                        int i212222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                        bVar = new Format2.b();
                        if (MimeTypes.h(str13)) {
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                        }
                        bVar.b(i20);
                        bVar.k = str13;
                        bVar.l = i3;
                        bVar.c = r0.W;
                        bVar.d = i212222;
                        bVar.m = list2;
                        bVar.h = str8;
                        bVar.n = r0.l;
                        Format2 format2A2222 = bVar.a();
                        TrackOutput2 trackOutput2P2222 = extractorOutput2.p(r0.c, i4);
                        r0.X = trackOutput2P2222;
                        trackOutput2P2222.e(format2A2222);
                        this.h.put(r0.c, r0);
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw ParserException.a("Error parsing MS/ACM codec private", null);
                    }
                    break;
                case 3:
                    r0.T = new TrueHdSampleRechunker();
                    str13 = "audio/true-hd";
                    listSingletonList = null;
                    i2 = -1;
                    list = listSingletonList;
                    str = null;
                    list5 = list;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i2122222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i2122222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A22222 = bVar.a();
                    TrackOutput2 trackOutput2P22222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P22222;
                    trackOutput2P22222.e(format2A22222);
                    this.h.put(r0.c, r0);
                    break;
                case 4:
                    byte[] bArrA = r0.a(r0.f1196b);
                    try {
                        try {
                            if (bArrA[0] != 2) {
                                throw ParserException.a("Error parsing vorbis codec private", null);
                            }
                            int i25 = 1;
                            int i26 = 0;
                            while ((bArrA[i25] & 255) == 255) {
                                i26 += 255;
                                i25++;
                            }
                            int i27 = i25 + 1;
                            int i28 = i26 + (bArrA[i25] & 255);
                            int i29 = 0;
                            while ((bArrA[i27] & 255) == 255) {
                                i29 += 255;
                                i27++;
                            }
                            int i30 = i27 + 1;
                            int i31 = i29 + (bArrA[i27] & 255);
                            if (bArrA[i30] != 1) {
                                throw ParserException.a("Error parsing vorbis codec private", null);
                            }
                            byte[] bArr4 = new byte[i28];
                            System.arraycopy(bArrA, i30, bArr4, 0, i28);
                            int i32 = i30 + i28;
                            if (bArrA[i32] != 3) {
                                throw ParserException.a("Error parsing vorbis codec private", null);
                            }
                            int i33 = i32 + i31;
                            if (bArrA[i33] != 5) {
                                throw ParserException.a("Error parsing vorbis codec private", null);
                            }
                            byte[] bArr5 = new byte[bArrA.length - i33];
                            System.arraycopy(bArrA, i33, bArr5, 0, bArrA.length - i33);
                            ArrayList arrayList2 = new ArrayList(2);
                            arrayList2.add(bArr4);
                            arrayList2.add(bArr5);
                            i2 = 8192;
                            str13 = "audio/vorbis";
                            list = arrayList2;
                            str = null;
                            list5 = list;
                            str8 = str;
                            i3 = i2;
                            list2 = list5;
                            iR = -1;
                            bArr = r0.N;
                            if (bArr != null) {
                            }
                            int i21222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                            bVar = new Format2.b();
                            if (MimeTypes.h(str13)) {
                            }
                            str9 = r0.a;
                            if (str9 != null) {
                            }
                            bVar.b(i20);
                            bVar.k = str13;
                            bVar.l = i3;
                            bVar.c = r0.W;
                            bVar.d = i21222222;
                            bVar.m = list2;
                            bVar.h = str8;
                            bVar.n = r0.l;
                            Format2 format2A222222 = bVar.a();
                            TrackOutput2 trackOutput2P222222 = extractorOutput2.p(r0.c, i4);
                            r0.X = trackOutput2P222222;
                            trackOutput2P222222.e(format2A222222);
                            this.h.put(r0.c, r0);
                            break;
                        } catch (ArrayIndexOutOfBoundsException unused2) {
                            throw ParserException.a("Error parsing vorbis codec private", r0);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused3) {
                        r0 = 0;
                    }
                    break;
                case 5:
                    str2 = "audio/mpeg-L2";
                    str3 = str2;
                    i2 = 4096;
                    arrayList = null;
                    str = null;
                    list6 = arrayList;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i212222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i212222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A2222222 = bVar.a();
                    TrackOutput2 trackOutput2P2222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P2222222;
                    trackOutput2P2222222.e(format2A2222222);
                    this.h.put(r0.c, r0);
                    break;
                case 6:
                    str2 = "audio/mpeg";
                    str3 = str2;
                    i2 = 4096;
                    arrayList = null;
                    str = null;
                    list6 = arrayList;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i2122222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i2122222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A22222222 = bVar.a();
                    TrackOutput2 trackOutput2P22222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P22222222;
                    trackOutput2P22222222.e(format2A22222222);
                    this.h.put(r0.c, r0);
                    break;
                case 7:
                    byte[] bArrA2 = r0.a(r0.f1196b);
                    try {
                        AnimatableValueParser.j(16 <= bArrA2.length);
                        long j5 = (bArrA2[16] & 255) | ((bArrA2[17] & 255) << 8) | ((bArrA2[18] & 255) << 16) | ((255 & bArrA2[19]) << 24);
                        if (j5 == 1482049860) {
                            pair2 = new Pair("video/divx", null);
                        } else if (j5 == 859189832) {
                            pair2 = new Pair("video/3gpp", null);
                        } else {
                            if (j5 == 826496599) {
                                for (int i34 = 40; i34 < bArrA2.length - 4; i34++) {
                                    if (bArrA2[i34] == 0 && bArrA2[i34 + 1] == 0 && bArrA2[i34 + 2] == 1) {
                                        if (bArrA2[i34 + 3] == 15) {
                                            pair = new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrA2, i34, bArrA2.length)));
                                        }
                                    }
                                }
                                throw ParserException.a("Failed to find FourCC VC1 initialization data", null);
                            }
                            Log.w("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                            pair = new Pair("video/x-unknown", null);
                            pair2 = pair;
                        }
                        str4 = (String) pair2.first;
                        listU = (List) pair2.second;
                        str3 = str4;
                        list3 = listU;
                        str7 = null;
                        list4 = list3;
                        str = str7;
                        i2 = -1;
                        list6 = list4;
                        str13 = str3;
                        list5 = list6;
                        str8 = str;
                        i3 = i2;
                        list2 = list5;
                        iR = -1;
                        bArr = r0.N;
                        if (bArr != null) {
                        }
                        int i21222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                        bVar = new Format2.b();
                        if (MimeTypes.h(str13)) {
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                        }
                        bVar.b(i20);
                        bVar.k = str13;
                        bVar.l = i3;
                        bVar.c = r0.W;
                        bVar.d = i21222222222;
                        bVar.m = list2;
                        bVar.h = str8;
                        bVar.n = r0.l;
                        Format2 format2A222222222 = bVar.a();
                        TrackOutput2 trackOutput2P222222222 = extractorOutput2.p(r0.c, i4);
                        r0.X = trackOutput2P222222222;
                        trackOutput2P222222222.e(format2A222222222);
                        this.h.put(r0.c, r0);
                        break;
                    } catch (ArrayIndexOutOfBoundsException unused4) {
                        throw ParserException.a("Error parsing FourCC private data", null);
                    }
                    break;
                case '\b':
                    byte[] bArr6 = new byte[4];
                    System.arraycopy(r0.a(r0.f1196b), 0, bArr6, 0, 4);
                    ImmutableList2 immutableList2U = ImmutableList2.u(bArr6);
                    str4 = "application/dvbsubs";
                    listU = immutableList2U;
                    str3 = str4;
                    list3 = listU;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i212222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i212222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A2222222222 = bVar.a();
                    TrackOutput2 trackOutput2P2222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P2222222222;
                    trackOutput2P2222222222.e(format2A2222222222);
                    this.h.put(r0.c, r0);
                    break;
                case '\n':
                    AvcConfig avcConfigB = AvcConfig.b(new ParsableByteArray(r0.a(r0.f1196b)));
                    list2 = avcConfigB.a;
                    r0.Y = avcConfigB.f986b;
                    str5 = avcConfigB.f;
                    str6 = "video/avc";
                    str8 = str5;
                    str13 = str6;
                    iR = -1;
                    i3 = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i2122222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i2122222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A22222222222 = bVar.a();
                    TrackOutput2 trackOutput2P22222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P22222222222;
                    trackOutput2P22222222222.e(format2A22222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 11:
                    str4 = "application/vobsub";
                    listU = ImmutableList2.u(r0.a(r0.f1196b));
                    str3 = str4;
                    list3 = listU;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i21222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i21222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P222222222222;
                    trackOutput2P222222222222.e(format2A222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case '\f':
                    str12 = "audio/vnd.dts.hd";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i212222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i212222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A2222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P2222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P2222222222222;
                    trackOutput2P2222222222222.e(format2A2222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case '\r':
                    List<byte[]> listSingletonList2 = Collections.singletonList(r0.a(r0.f1196b));
                    AacUtil.b bVarC = AacUtil.c(r0.k);
                    r0.Q = bVarC.a;
                    r0.O = bVarC.f1122b;
                    str7 = bVarC.c;
                    str3 = "audio/mp4a-latm";
                    list4 = listSingletonList2;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i2122222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i2122222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A22222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P22222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P22222222222222;
                    trackOutput2P22222222222222.e(format2A22222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 14:
                    str12 = "audio/ac3";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i21222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i21222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P222222222222222;
                    trackOutput2P222222222222222.e(format2A222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 15:
                case 21:
                    str12 = "audio/vnd.dts";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i212222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i212222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A2222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P2222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P2222222222222222;
                    trackOutput2P2222222222222222.e(format2A2222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 16:
                    str12 = "video/av01";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i2122222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i2122222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A22222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P22222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P22222222222222222;
                    trackOutput2P22222222222222222.e(format2A22222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 17:
                    str12 = "video/x-vnd.on2.vp8";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i21222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i21222222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A222222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P222222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P222222222222222222;
                    trackOutput2P222222222222222222.e(format2A222222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 18:
                    str12 = "video/x-vnd.on2.vp9";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i212222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i212222222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A2222222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P2222222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P2222222222222222222;
                    trackOutput2P2222222222222222222.e(format2A2222222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 19:
                    str12 = "application/pgs";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i2122222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i2122222222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A22222222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P22222222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P22222222222222222222;
                    trackOutput2P22222222222222222222.e(format2A22222222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 20:
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i21222222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i21222222222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A222222222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P222222222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P222222222222222222222;
                    trackOutput2P222222222222222222222.e(format2A222222222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 22:
                    int i35 = r0.P;
                    if (i35 == 32) {
                        iR = 4;
                        str13 = "audio/raw";
                        list2 = null;
                        i3 = -1;
                        str8 = null;
                        bArr = r0.N;
                        if (bArr != null) {
                        }
                        int i212222222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                        bVar = new Format2.b();
                        if (MimeTypes.h(str13)) {
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                        }
                        bVar.b(i20);
                        bVar.k = str13;
                        bVar.l = i3;
                        bVar.c = r0.W;
                        bVar.d = i212222222222222222222222;
                        bVar.m = list2;
                        bVar.h = str8;
                        bVar.n = r0.l;
                        Format2 format2A2222222222222222222222 = bVar.a();
                        TrackOutput2 trackOutput2P2222222222222222222222 = extractorOutput2.p(r0.c, i4);
                        r0.X = trackOutput2P2222222222222222222222;
                        trackOutput2P2222222222222222222222.e(format2A2222222222222222222222);
                        this.h.put(r0.c, r0);
                        break;
                    } else {
                        StringBuilder sb3 = new StringBuilder(90);
                        sb3.append("Unsupported floating point PCM bit depth: ");
                        sb3.append(i35);
                        sb3.append(". Setting mimeType to ");
                        sb3.append("audio/x-unknown");
                        Log.w("MatroskaExtractor", sb3.toString());
                        str3 = str13;
                        list3 = null;
                        str7 = null;
                        list4 = list3;
                        str = str7;
                        i2 = -1;
                        list6 = list4;
                        str13 = str3;
                        list5 = list6;
                        str8 = str;
                        i3 = i2;
                        list2 = list5;
                        iR = -1;
                        bArr = r0.N;
                        if (bArr != null) {
                        }
                        int i2122222222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                        bVar = new Format2.b();
                        if (MimeTypes.h(str13)) {
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                        }
                        bVar.b(i20);
                        bVar.k = str13;
                        bVar.l = i3;
                        bVar.c = r0.W;
                        bVar.d = i2122222222222222222222222;
                        bVar.m = list2;
                        bVar.h = str8;
                        bVar.n = r0.l;
                        Format2 format2A22222222222222222222222 = bVar.a();
                        TrackOutput2 trackOutput2P22222222222222222222222 = extractorOutput2.p(r0.c, i4);
                        r0.X = trackOutput2P22222222222222222222222;
                        trackOutput2P22222222222222222222222.e(format2A22222222222222222222222);
                        this.h.put(r0.c, r0);
                    }
                    break;
                case 23:
                    int i36 = r0.P;
                    if (i36 == 8) {
                        iR = 3;
                    } else if (i36 != 16) {
                        StringBuilder sb4 = new StringBuilder(86);
                        sb4.append("Unsupported big endian PCM bit depth: ");
                        sb4.append(i36);
                        sb4.append(". Setting mimeType to ");
                        sb4.append("audio/x-unknown");
                        Log.w("MatroskaExtractor", sb4.toString());
                        str3 = str13;
                        list3 = null;
                        str7 = null;
                        list4 = list3;
                        str = str7;
                        i2 = -1;
                        list6 = list4;
                        str13 = str3;
                        list5 = list6;
                        str8 = str;
                        i3 = i2;
                        list2 = list5;
                        iR = -1;
                        bArr = r0.N;
                        if (bArr != null) {
                        }
                        int i21222222222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                        bVar = new Format2.b();
                        if (MimeTypes.h(str13)) {
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                        }
                        bVar.b(i20);
                        bVar.k = str13;
                        bVar.l = i3;
                        bVar.c = r0.W;
                        bVar.d = i21222222222222222222222222;
                        bVar.m = list2;
                        bVar.h = str8;
                        bVar.n = r0.l;
                        Format2 format2A222222222222222222222222 = bVar.a();
                        TrackOutput2 trackOutput2P222222222222222222222222 = extractorOutput2.p(r0.c, i4);
                        r0.X = trackOutput2P222222222222222222222222;
                        trackOutput2P222222222222222222222222.e(format2A222222222222222222222222);
                        this.h.put(r0.c, r0);
                        break;
                    } else {
                        iR = 268435456;
                    }
                    str13 = "audio/raw";
                    list2 = null;
                    i3 = -1;
                    str8 = null;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i212222222222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i212222222222222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A2222222222222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P2222222222222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P2222222222222222222222222;
                    trackOutput2P2222222222222222222222222.e(format2A2222222222222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 24:
                    iR = Util2.r(r0.P);
                    if (iR == 0) {
                        int i37 = r0.P;
                        StringBuilder sb5 = new StringBuilder(89);
                        sb5.append("Unsupported little endian PCM bit depth: ");
                        sb5.append(i37);
                        sb5.append(". Setting mimeType to ");
                        sb5.append("audio/x-unknown");
                        Log.w("MatroskaExtractor", sb5.toString());
                        str3 = str13;
                        list3 = null;
                        str7 = null;
                        list4 = list3;
                        str = str7;
                        i2 = -1;
                        list6 = list4;
                        str13 = str3;
                        list5 = list6;
                        str8 = str;
                        i3 = i2;
                        list2 = list5;
                        iR = -1;
                        bArr = r0.N;
                        if (bArr != null) {
                        }
                        int i2122222222222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                        bVar = new Format2.b();
                        if (MimeTypes.h(str13)) {
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                        }
                        bVar.b(i20);
                        bVar.k = str13;
                        bVar.l = i3;
                        bVar.c = r0.W;
                        bVar.d = i2122222222222222222222222222;
                        bVar.m = list2;
                        bVar.h = str8;
                        bVar.n = r0.l;
                        Format2 format2A22222222222222222222222222 = bVar.a();
                        TrackOutput2 trackOutput2P22222222222222222222222222 = extractorOutput2.p(r0.c, i4);
                        r0.X = trackOutput2P22222222222222222222222222;
                        trackOutput2P22222222222222222222222222.e(format2A22222222222222222222222222);
                        this.h.put(r0.c, r0);
                        break;
                    }
                    str13 = "audio/raw";
                    list2 = null;
                    i3 = -1;
                    str8 = null;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i21222222222222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i21222222222222222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A222222222222222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P222222222222222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P222222222222222222222222222;
                    trackOutput2P222222222222222222222222222.e(format2A222222222222222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 25:
                    byte[] bArr7 = f1185b;
                    byte[] bArrA3 = r0.a(r0.f1196b);
                    AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
                    Object[] objArr = {bArr7, bArrA3};
                    str4 = "text/x-ssa";
                    listU = ImmutableList2.m(objArr);
                    str3 = str4;
                    list3 = listU;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i212222222222222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i212222222222222222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A2222222222222222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P2222222222222222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P2222222222222222222222222222;
                    trackOutput2P2222222222222222222222222222.e(format2A2222222222222222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 26:
                    HevcConfig hevcConfigA = HevcConfig.a(new ParsableByteArray(r0.a(r0.f1196b)));
                    list2 = hevcConfigA.a;
                    r0.Y = hevcConfigA.f989b;
                    str5 = hevcConfigA.d;
                    str6 = "video/hevc";
                    str8 = str5;
                    str13 = str6;
                    iR = -1;
                    i3 = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i2122222222222222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i2122222222222222222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A22222222222222222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P22222222222222222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P22222222222222222222222222222;
                    trackOutput2P22222222222222222222222222222.e(format2A22222222222222222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 27:
                    str12 = "application/x-subrip";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i21222222222222222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i21222222222222222222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A222222222222222222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P222222222222222222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P222222222222222222222222222222;
                    trackOutput2P222222222222222222222222222222.e(format2A222222222222222222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 28:
                    str12 = "video/mpeg2";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i212222222222222222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i212222222222222222222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A2222222222222222222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P2222222222222222222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P2222222222222222222222222222222;
                    trackOutput2P2222222222222222222222222222222.e(format2A2222222222222222222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 29:
                    str12 = "audio/eac3";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i2122222222222222222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i2122222222222222222222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A22222222222222222222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P22222222222222222222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P22222222222222222222222222222222;
                    trackOutput2P22222222222222222222222222222222.e(format2A22222222222222222222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 30:
                    str4 = "audio/flac";
                    listU = Collections.singletonList(r0.a(r0.f1196b));
                    str3 = str4;
                    list3 = listU;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i21222222222222222222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i21222222222222222222222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A222222222222222222222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P222222222222222222222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P222222222222222222222222222222222;
                    trackOutput2P222222222222222222222222222222222.e(format2A222222222222222222222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                case 31:
                    ArrayList arrayList3 = new ArrayList(3);
                    arrayList3.add(r0.a(r0.f1196b));
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    arrayList3.add(byteBufferAllocate.order(byteOrder).putLong(r0.R).array());
                    arrayList3.add(ByteBuffer.allocate(8).order(byteOrder).putLong(r0.S).array());
                    i2 = 5760;
                    str3 = "audio/opus";
                    arrayList = arrayList3;
                    str = null;
                    list6 = arrayList;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                    }
                    int i212222222222222222222222222222222222 = (r0.V ? 1 : 0) | 0 | (r0.U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.h(str13)) {
                    }
                    str9 = r0.a;
                    if (str9 != null) {
                    }
                    bVar.b(i20);
                    bVar.k = str13;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i212222222222222222222222222222222222;
                    bVar.m = list2;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A2222222222222222222222222222222222 = bVar.a();
                    TrackOutput2 trackOutput2P2222222222222222222222222222222222 = extractorOutput2.p(r0.c, i4);
                    r0.X = trackOutput2P2222222222222222222222222222222222;
                    trackOutput2P2222222222222222222222222222222222.e(format2A2222222222222222222222222222222222);
                    this.h.put(r0.c, r0);
                    break;
                default:
                    throw ParserException.a("Unrecognized codec identifier.", null);
            }
        }
        this.f1195z = null;
    }

    public final void k(ExtractorInput extractorInput, int i) throws IOException {
        ParsableByteArray parsableByteArray = this.l;
        if (parsableByteArray.c >= i) {
            return;
        }
        byte[] bArr = parsableByteArray.a;
        if (bArr.length < i) {
            parsableByteArray.b(Math.max(bArr.length * 2, i));
        }
        ParsableByteArray parsableByteArray2 = this.l;
        byte[] bArr2 = parsableByteArray2.a;
        int i2 = parsableByteArray2.c;
        extractorInput.readFully(bArr2, i2, i - i2);
        this.l.D(i);
    }

    public final void l() {
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = false;
        this.f1186a0 = false;
        this.f1187b0 = false;
        this.f1188c0 = 0;
        this.f1189d0 = (byte) 0;
        this.f1190e0 = false;
        this.o.A(0);
    }

    public final long m(long j) throws ParserException {
        long j2 = this.w;
        if (j2 != -9223372036854775807L) {
            return Util2.F(j, j2, 1000L);
        }
        throw ParserException.a("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @RequiresNonNull({"#2.output"})
    public final int n(ExtractorInput extractorInput, c cVar, int i) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(cVar.f1196b)) {
            o(extractorInput, a, i);
            int i3 = this.X;
            l();
            return i3;
        }
        if ("S_TEXT/ASS".equals(cVar.f1196b)) {
            o(extractorInput, c, i);
            int i4 = this.X;
            l();
            return i4;
        }
        TrackOutput2 trackOutput2 = cVar.X;
        if (!this.Z) {
            if (cVar.h) {
                this.T &= -1073741825;
                if (!this.f1186a0) {
                    extractorInput.readFully(this.l.a, 0, 1);
                    this.W++;
                    byte[] bArr = this.l.a;
                    if ((bArr[0] & 128) == 128) {
                        throw ParserException.a("Extension bit is set in signal byte", null);
                    }
                    this.f1189d0 = bArr[0];
                    this.f1186a0 = true;
                }
                byte b2 = this.f1189d0;
                if ((b2 & 1) == 1) {
                    boolean z2 = (b2 & 2) == 2;
                    this.T |= BasicMeasure.EXACTLY;
                    if (!this.f1190e0) {
                        extractorInput.readFully(this.q.a, 0, 8);
                        this.W += 8;
                        this.f1190e0 = true;
                        ParsableByteArray parsableByteArray = this.l;
                        parsableByteArray.a[0] = (byte) ((z2 ? 128 : 0) | 8);
                        parsableByteArray.E(0);
                        trackOutput2.f(this.l, 1, 1);
                        this.X++;
                        this.q.E(0);
                        trackOutput2.f(this.q, 8, 1);
                        this.X += 8;
                    }
                    if (z2) {
                        if (!this.f1187b0) {
                            extractorInput.readFully(this.l.a, 0, 1);
                            this.W++;
                            this.l.E(0);
                            this.f1188c0 = this.l.t();
                            this.f1187b0 = true;
                        }
                        int i5 = this.f1188c0 * 4;
                        this.l.A(i5);
                        extractorInput.readFully(this.l.a, 0, i5);
                        this.W += i5;
                        short s2 = (short) ((this.f1188c0 / 2) + 1);
                        int i6 = (s2 * 6) + 2;
                        ByteBuffer byteBuffer = this.t;
                        if (byteBuffer == null || byteBuffer.capacity() < i6) {
                            this.t = ByteBuffer.allocate(i6);
                        }
                        this.t.position(0);
                        this.t.putShort(s2);
                        int i7 = 0;
                        int i8 = 0;
                        while (true) {
                            i2 = this.f1188c0;
                            if (i7 >= i2) {
                                break;
                            }
                            int iW = this.l.w();
                            if (i7 % 2 == 0) {
                                this.t.putShort((short) (iW - i8));
                            } else {
                                this.t.putInt(iW - i8);
                            }
                            i7++;
                            i8 = iW;
                        }
                        int i9 = (i - this.W) - i8;
                        if (i2 % 2 == 1) {
                            this.t.putInt(i9);
                        } else {
                            this.t.putShort((short) i9);
                            this.t.putInt(0);
                        }
                        this.r.C(this.t.array(), i6);
                        trackOutput2.f(this.r, i6, 1);
                        this.X += i6;
                    }
                }
            } else {
                byte[] bArr2 = cVar.i;
                if (bArr2 != null) {
                    ParsableByteArray parsableByteArray2 = this.o;
                    int length = bArr2.length;
                    parsableByteArray2.a = bArr2;
                    parsableByteArray2.c = length;
                    parsableByteArray2.f984b = 0;
                }
            }
            if (cVar.f > 0) {
                this.T |= 268435456;
                this.f1192s.A(0);
                this.l.A(4);
                ParsableByteArray parsableByteArray3 = this.l;
                byte[] bArr3 = parsableByteArray3.a;
                bArr3[0] = (byte) ((i >> 24) & 255);
                bArr3[1] = (byte) ((i >> 16) & 255);
                bArr3[2] = (byte) ((i >> 8) & 255);
                bArr3[3] = (byte) (i & 255);
                trackOutput2.f(parsableByteArray3, 4, 2);
                this.X += 4;
            }
            this.Z = true;
        }
        int i10 = i + this.o.c;
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f1196b) && !"V_MPEGH/ISO/HEVC".equals(cVar.f1196b)) {
            if (cVar.T != null) {
                AnimatableValueParser.D(this.o.c == 0);
                cVar.T.c(extractorInput);
            }
            while (true) {
                int i11 = this.W;
                if (i11 >= i10) {
                    break;
                }
                int iP = p(extractorInput, trackOutput2, i10 - i11);
                this.W += iP;
                this.X += iP;
            }
        } else {
            byte[] bArr4 = this.k.a;
            bArr4[0] = 0;
            bArr4[1] = 0;
            bArr4[2] = 0;
            int i12 = cVar.Y;
            int i13 = 4 - i12;
            while (this.W < i10) {
                int i14 = this.Y;
                if (i14 == 0) {
                    int iMin = Math.min(i12, this.o.a());
                    extractorInput.readFully(bArr4, i13 + iMin, i12 - iMin);
                    if (iMin > 0) {
                        ParsableByteArray parsableByteArray4 = this.o;
                        System.arraycopy(parsableByteArray4.a, parsableByteArray4.f984b, bArr4, i13, iMin);
                        parsableByteArray4.f984b += iMin;
                    }
                    this.W += i12;
                    this.k.E(0);
                    this.Y = this.k.w();
                    this.j.E(0);
                    trackOutput2.c(this.j, 4);
                    this.X += 4;
                } else {
                    int iP2 = p(extractorInput, trackOutput2, i14);
                    this.W += iP2;
                    this.X += iP2;
                    this.Y -= iP2;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f1196b)) {
            this.m.E(0);
            trackOutput2.c(this.m, 4);
            this.X += 4;
        }
        int i15 = this.X;
        l();
        return i15;
    }

    public final void o(ExtractorInput extractorInput, byte[] bArr, int i) throws IOException {
        int length = bArr.length + i;
        ParsableByteArray parsableByteArray = this.p;
        byte[] bArr2 = parsableByteArray.a;
        if (bArr2.length < length) {
            parsableByteArray.B(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        extractorInput.readFully(this.p.a, bArr.length, i);
        this.p.E(0);
        this.p.D(length);
    }

    public final int p(ExtractorInput extractorInput, TrackOutput2 trackOutput2, int i) throws IOException {
        int iA = this.o.a();
        if (iA <= 0) {
            return trackOutput2.b(extractorInput, i, false);
        }
        int iMin = Math.min(i, iA);
        trackOutput2.c(this.o, iMin);
        return iMin;
    }

    @Override // b.i.a.c.x2.Extractor
    public final void release() {
    }

    /* compiled from: MatroskaExtractor.java */
    /* renamed from: b.i.a.c.x2.g0.e$c */
    public static final class c {
        public byte[] N;
        public TrueHdSampleRechunker T;
        public boolean U;
        public TrackOutput2 X;
        public int Y;
        public String a;

        /* renamed from: b, reason: collision with root package name */
        public String f1196b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public byte[] i;
        public TrackOutput2.a j;
        public byte[] k;
        public DrmInitData l;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = 0;
        public int r = -1;

        /* renamed from: s, reason: collision with root package name */
        public float f1197s = 0.0f;
        public float t = 0.0f;
        public float u = 0.0f;
        public byte[] v = null;
        public int w = -1;

        /* renamed from: x, reason: collision with root package name */
        public boolean f1198x = false;

        /* renamed from: y, reason: collision with root package name */
        public int f1199y = -1;

        /* renamed from: z, reason: collision with root package name */
        public int f1200z = -1;
        public int A = -1;
        public int B = 1000;
        public int C = 200;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public int O = 1;
        public int P = -1;
        public int Q = 8000;
        public long R = 0;
        public long S = 0;
        public boolean V = true;
        public String W = "eng";

        public c() {
        }

        @EnsuresNonNull({"codecPrivate"})
        public final byte[] a(String str) throws ParserException {
            byte[] bArr = this.k;
            if (bArr != null) {
                return bArr;
            }
            String strValueOf = String.valueOf(str);
            throw ParserException.a(strValueOf.length() != 0 ? "Missing CodecPrivate for codec ".concat(strValueOf) : new String("Missing CodecPrivate for codec "), null);
        }

        public c(a aVar) {
        }
    }
}
