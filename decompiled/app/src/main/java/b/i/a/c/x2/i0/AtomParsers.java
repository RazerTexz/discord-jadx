package b.i.a.c.x2.i0;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.AvcConfig;
import b.i.a.c.g3.ColorInfo;
import b.i.a.c.g3.DolbyVisionConfig;
import b.i.a.c.g3.HevcConfig;
import b.i.a.c.t2.AacUtil;
import b.i.a.c.t2.Ac3Util;
import b.i.a.c.x2.GaplessInfoHolder;
import b.i.a.c.x2.i0.Atom;
import b.i.b.a.Function2;
import b.i.b.b.ImmutableList2;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* compiled from: AtomParsers.java */
/* renamed from: b.i.a.c.x2.i0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class AtomParsers {
    public static final byte[] a = Util2.w("OpusHead");

    /* compiled from: AtomParsers.java */
    /* renamed from: b.i.a.c.x2.i0.e$a */
    public interface a {
        int a();

        int b();

        int c();
    }

    /* compiled from: AtomParsers.java */
    /* renamed from: b.i.a.c.x2.i0.e$b */
    public static final class b {
        public final TrackEncryptionBox[] a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public Format2 f1211b;
        public int c;
        public int d = 0;

        public b(int i) {
            this.a = new TrackEncryptionBox[i];
        }
    }

    /* compiled from: AtomParsers.java */
    /* renamed from: b.i.a.c.x2.i0.e$c */
    public static final class c implements a {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1212b;
        public final ParsableByteArray c;

        public c(Atom.b bVar, Format2 format2) {
            ParsableByteArray parsableByteArray = bVar.f1210b;
            this.c = parsableByteArray;
            parsableByteArray.E(12);
            int iW = parsableByteArray.w();
            if ("audio/raw".equals(format2.w)) {
                int iS = Util2.s(format2.L, format2.J);
                if (iW == 0 || iW % iS != 0) {
                    Log.w("AtomParsers", outline.h(88, "Audio sample size mismatch. stsd sample size: ", iS, ", stsz sample size: ", iW));
                    iW = iS;
                }
            }
            this.a = iW == 0 ? -1 : iW;
            this.f1212b = parsableByteArray.w();
        }

        @Override // b.i.a.c.x2.i0.AtomParsers.a
        public int a() {
            return this.a;
        }

        @Override // b.i.a.c.x2.i0.AtomParsers.a
        public int b() {
            return this.f1212b;
        }

        @Override // b.i.a.c.x2.i0.AtomParsers.a
        public int c() {
            int i = this.a;
            return i == -1 ? this.c.w() : i;
        }
    }

    /* compiled from: AtomParsers.java */
    /* renamed from: b.i.a.c.x2.i0.e$d */
    public static final class d implements a {
        public final ParsableByteArray a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1213b;
        public final int c;
        public int d;
        public int e;

        public d(Atom.b bVar) {
            ParsableByteArray parsableByteArray = bVar.f1210b;
            this.a = parsableByteArray;
            parsableByteArray.E(12);
            this.c = parsableByteArray.w() & 255;
            this.f1213b = parsableByteArray.w();
        }

        @Override // b.i.a.c.x2.i0.AtomParsers.a
        public int a() {
            return -1;
        }

        @Override // b.i.a.c.x2.i0.AtomParsers.a
        public int b() {
            return this.f1213b;
        }

        @Override // b.i.a.c.x2.i0.AtomParsers.a
        public int c() {
            int i = this.c;
            if (i == 8) {
                return this.a.t();
            }
            if (i == 16) {
                return this.a.y();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.e & 15;
            }
            int iT = this.a.t();
            this.e = iT;
            return (iT & 240) >> 4;
        }
    }

    public static Pair<String, byte[]> a(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.E(i + 8 + 4);
        parsableByteArray.F(1);
        b(parsableByteArray);
        parsableByteArray.F(2);
        int iT = parsableByteArray.t();
        if ((iT & 128) != 0) {
            parsableByteArray.F(2);
        }
        if ((iT & 64) != 0) {
            parsableByteArray.F(parsableByteArray.y());
        }
        if ((iT & 32) != 0) {
            parsableByteArray.F(2);
        }
        parsableByteArray.F(1);
        b(parsableByteArray);
        String strD = MimeTypes.d(parsableByteArray.t());
        if ("audio/mpeg".equals(strD) || "audio/vnd.dts".equals(strD) || "audio/vnd.dts.hd".equals(strD)) {
            return Pair.create(strD, null);
        }
        parsableByteArray.F(12);
        parsableByteArray.F(1);
        int iB = b(parsableByteArray);
        byte[] bArr = new byte[iB];
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, iB);
        parsableByteArray.f984b += iB;
        return Pair.create(strD, bArr);
    }

    public static int b(ParsableByteArray parsableByteArray) {
        int iT = parsableByteArray.t();
        int i = iT & Opcodes.LAND;
        while ((iT & 128) == 128) {
            iT = parsableByteArray.t();
            i = (i << 7) | (iT & Opcodes.LAND);
        }
        return i;
    }

    @Nullable
    public static Pair<Integer, TrackEncryptionBox> c(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        Integer num;
        TrackEncryptionBox trackEncryptionBox;
        Pair<Integer, TrackEncryptionBox> pairCreate;
        int i3;
        int i4;
        byte[] bArr;
        int i5 = parsableByteArray.f984b;
        while (i5 - i < i2) {
            parsableByteArray.E(i5);
            int iF = parsableByteArray.f();
            int i6 = 1;
            AnimatableValueParser.q(iF > 0, "childAtomSize must be positive");
            if (parsableByteArray.f() == 1936289382) {
                int i7 = i5 + 8;
                int i8 = -1;
                int i9 = 0;
                String strQ = null;
                Integer numValueOf = null;
                while (i7 - i5 < iF) {
                    parsableByteArray.E(i7);
                    int iF2 = parsableByteArray.f();
                    int iF3 = parsableByteArray.f();
                    if (iF3 == 1718775137) {
                        numValueOf = Integer.valueOf(parsableByteArray.f());
                    } else if (iF3 == 1935894637) {
                        parsableByteArray.F(4);
                        strQ = parsableByteArray.q(4);
                    } else if (iF3 == 1935894633) {
                        i8 = i7;
                        i9 = iF2;
                    }
                    i7 += iF2;
                }
                if ("cenc".equals(strQ) || "cbc1".equals(strQ) || "cens".equals(strQ) || "cbcs".equals(strQ)) {
                    AnimatableValueParser.q(numValueOf != null, "frma atom is mandatory");
                    AnimatableValueParser.q(i8 != -1, "schi atom is mandatory");
                    int i10 = i8 + 8;
                    while (true) {
                        if (i10 - i8 >= i9) {
                            num = numValueOf;
                            trackEncryptionBox = null;
                            break;
                        }
                        parsableByteArray.E(i10);
                        int iF4 = parsableByteArray.f();
                        if (parsableByteArray.f() == 1952804451) {
                            int iF5 = (parsableByteArray.f() >> 24) & 255;
                            parsableByteArray.F(i6);
                            if (iF5 == 0) {
                                parsableByteArray.F(i6);
                                i3 = 0;
                                i4 = 0;
                            } else {
                                int iT = parsableByteArray.t();
                                int i11 = (iT & 240) >> 4;
                                i3 = iT & 15;
                                i4 = i11;
                            }
                            boolean z2 = parsableByteArray.t() == i6;
                            int iT2 = parsableByteArray.t();
                            byte[] bArr2 = new byte[16];
                            System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr2, 0, 16);
                            parsableByteArray.f984b += 16;
                            if (z2 && iT2 == 0) {
                                int iT3 = parsableByteArray.t();
                                byte[] bArr3 = new byte[iT3];
                                System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr3, 0, iT3);
                                parsableByteArray.f984b += iT3;
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            num = numValueOf;
                            trackEncryptionBox = new TrackEncryptionBox(z2, strQ, iT2, bArr2, i4, i3, bArr);
                        } else {
                            i10 += iF4;
                            i6 = 1;
                        }
                    }
                    AnimatableValueParser.q(trackEncryptionBox != null, "tenc atom is mandatory");
                    int i12 = Util2.a;
                    pairCreate = Pair.create(num, trackEncryptionBox);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            i5 += iF;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:232:0x0374  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b d(ParsableByteArray parsableByteArray, int i, int i2, String str, @Nullable DrmInitData drmInitData, boolean z2) throws ParserException {
        int i3;
        int i4;
        int i5;
        int i6;
        DrmInitData drmInitDataA;
        byte[] bArr;
        int i7;
        int i8;
        b bVar;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        b bVar2;
        int i14;
        int i15;
        b bVar3;
        int i16;
        int i17;
        int i18;
        float f;
        List<byte[]> listU;
        int i19;
        List<byte[]> list;
        String str2;
        int iY;
        int iRound;
        int iW;
        int i20;
        int i21;
        int i22;
        DrmInitData drmInitDataA2;
        String str3;
        int i23;
        int iIntValue;
        String str4;
        int i24;
        String str5;
        List<byte[]> listU2;
        int i25;
        int i26;
        int i27;
        boolean z3;
        int i28;
        String str6;
        int i29;
        int i30;
        int i31;
        List<byte[]> listG;
        int i32;
        int i33;
        String str7;
        int iIntValue2;
        ImmutableList2 immutableList2U;
        ImmutableList2 immutableList2U2;
        String str8;
        String str9 = str;
        DrmInitData drmInitData2 = drmInitData;
        parsableByteArray.E(12);
        int iF = parsableByteArray.f();
        b bVar4 = new b(iF);
        int i34 = 0;
        while (i34 < iF) {
            int i35 = parsableByteArray.f984b;
            int iF2 = parsableByteArray.f();
            String str10 = "childAtomSize must be positive";
            AnimatableValueParser.q(iF2 > 0, "childAtomSize must be positive");
            int iF3 = parsableByteArray.f();
            if (iF3 == 1635148593 || iF3 == 1635148595 || iF3 == 1701733238 || iF3 == 1831958048 || iF3 == 1836070006 || iF3 == 1752589105 || iF3 == 1751479857 || iF3 == 1932670515 || iF3 == 1211250227 || iF3 == 1987063864 || iF3 == 1987063865 || iF3 == 1635135537 || iF3 == 1685479798 || iF3 == 1685479729 || iF3 == 1685481573 || iF3 == 1685481521) {
                i3 = iF;
                i4 = i34;
                parsableByteArray.E(i35 + 8 + 8);
                parsableByteArray.F(16);
                int iY2 = parsableByteArray.y();
                int iY3 = parsableByteArray.y();
                parsableByteArray.F(50);
                int i36 = parsableByteArray.f984b;
                if (iF3 == 1701733238) {
                    i5 = i35;
                    i6 = iF2;
                    Pair<Integer, TrackEncryptionBox> pairC = c(parsableByteArray, i5, i6);
                    if (pairC != null) {
                        iF3 = ((Integer) pairC.first).intValue();
                        drmInitDataA = drmInitData == null ? null : drmInitData.a(((TrackEncryptionBox) pairC.second).f1231b);
                        bVar4.a[i4] = (TrackEncryptionBox) pairC.second;
                    } else {
                        drmInitDataA = drmInitData;
                    }
                    parsableByteArray.E(i36);
                } else {
                    i5 = i35;
                    i6 = iF2;
                    drmInitDataA = drmInitData;
                }
                String str11 = iF3 == 1831958048 ? "video/mpeg" : iF3 == 1211250227 ? "video/3gpp" : null;
                float fW = 1.0f;
                ByteBuffer byteBufferOrder = null;
                boolean z4 = false;
                DrmInitData drmInitData3 = drmInitDataA;
                byte[] bArrCopyOfRange = null;
                String str12 = null;
                List<byte[]> list2 = null;
                int iB = -1;
                int i37 = -1;
                int i38 = -1;
                int i39 = -1;
                while (true) {
                    if (i36 - i5 >= i6) {
                        bArr = bArrCopyOfRange;
                        i7 = iY2;
                        i8 = iY3;
                        bVar = bVar4;
                        i9 = i5;
                        i10 = i6;
                        i11 = i39;
                        break;
                    }
                    parsableByteArray.E(i36);
                    int i40 = parsableByteArray.f984b;
                    i11 = i39;
                    int iF4 = parsableByteArray.f();
                    bArr = bArrCopyOfRange;
                    if (iF4 == 0 && parsableByteArray.f984b - i5 == i6) {
                        i7 = iY2;
                        i8 = iY3;
                        bVar = bVar4;
                        i9 = i5;
                        i10 = i6;
                        break;
                    }
                    AnimatableValueParser.q(iF4 > 0, str10);
                    int iF5 = parsableByteArray.f();
                    String str13 = str10;
                    if (iF5 == 1635148611) {
                        AnimatableValueParser.q(str11 == null, null);
                        parsableByteArray.E(i40 + 8);
                        AvcConfig avcConfigB = AvcConfig.b(parsableByteArray);
                        list = avcConfigB.a;
                        bVar4.c = avcConfigB.f986b;
                        if (!z4) {
                            fW = avcConfigB.e;
                        }
                        str12 = avcConfigB.f;
                        str2 = "video/avc";
                    } else if (iF5 == 1752589123) {
                        AnimatableValueParser.q(str11 == null, null);
                        parsableByteArray.E(i40 + 8);
                        HevcConfig hevcConfigA = HevcConfig.a(parsableByteArray);
                        list = hevcConfigA.a;
                        bVar4.c = hevcConfigA.f989b;
                        if (!z4) {
                            fW = hevcConfigA.c;
                        }
                        str12 = hevcConfigA.d;
                        str2 = "video/hevc";
                    } else {
                        if (iF5 == 1685480259 || iF5 == 1685485123) {
                            i14 = iY2;
                            i15 = iY3;
                            bVar3 = bVar4;
                            i16 = i5;
                            i17 = i6;
                            i18 = iF3;
                            f = fW;
                            DolbyVisionConfig dolbyVisionConfigA = DolbyVisionConfig.a(parsableByteArray);
                            if (dolbyVisionConfigA != null) {
                                str11 = "video/dolby-vision";
                                str12 = dolbyVisionConfigA.a;
                            }
                        } else if (iF5 == 1987076931) {
                            AnimatableValueParser.q(str11 == null, null);
                            str2 = iF3 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                            list = list2;
                        } else {
                            if (iF5 == 1635135811) {
                                AnimatableValueParser.q(str11 == null, null);
                                str11 = "video/av01";
                            } else if (iF5 == 1668050025) {
                                if (byteBufferOrder == null) {
                                    byteBufferOrder = ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
                                }
                                ByteBuffer byteBuffer = byteBufferOrder;
                                byteBuffer.position(21);
                                byteBuffer.putShort(parsableByteArray.p());
                                byteBuffer.putShort(parsableByteArray.p());
                                byteBufferOrder = byteBuffer;
                            } else if (iF5 == 1835295606) {
                                if (byteBufferOrder == null) {
                                    byteBufferOrder = ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
                                }
                                ByteBuffer byteBuffer2 = byteBufferOrder;
                                short sP = parsableByteArray.p();
                                short sP2 = parsableByteArray.p();
                                i18 = iF3;
                                short sP3 = parsableByteArray.p();
                                i16 = i5;
                                short sP4 = parsableByteArray.p();
                                i17 = i6;
                                short sP5 = parsableByteArray.p();
                                bVar3 = bVar4;
                                short sP6 = parsableByteArray.p();
                                float f2 = fW;
                                short sP7 = parsableByteArray.p();
                                i15 = iY3;
                                short sP8 = parsableByteArray.p();
                                long jU = parsableByteArray.u();
                                long jU2 = parsableByteArray.u();
                                i14 = iY2;
                                byteBuffer2.position(1);
                                byteBuffer2.putShort(sP5);
                                byteBuffer2.putShort(sP6);
                                byteBuffer2.putShort(sP);
                                byteBuffer2.putShort(sP2);
                                byteBuffer2.putShort(sP3);
                                byteBuffer2.putShort(sP4);
                                byteBuffer2.putShort(sP7);
                                byteBuffer2.putShort(sP8);
                                byteBuffer2.putShort((short) (jU / 10000));
                                byteBuffer2.putShort((short) (jU2 / 10000));
                                byteBufferOrder = byteBuffer2;
                                list = list2;
                                fW = f2;
                                list2 = list;
                                bArrCopyOfRange = bArr;
                                i36 += iF4;
                                i39 = i11;
                                str10 = str13;
                                iF3 = i18;
                                i5 = i16;
                                i6 = i17;
                                bVar4 = bVar3;
                                iY3 = i15;
                                iY2 = i14;
                            } else {
                                i14 = iY2;
                                i15 = iY3;
                                bVar3 = bVar4;
                                i16 = i5;
                                i17 = i6;
                                i18 = iF3;
                                f = fW;
                                if (iF5 == 1681012275) {
                                    AnimatableValueParser.q(str11 == null, null);
                                    str11 = "video/3gpp";
                                } else if (iF5 == 1702061171) {
                                    AnimatableValueParser.q(str11 == null, null);
                                    Pair<String, byte[]> pairA = a(parsableByteArray, i40);
                                    str11 = (String) pairA.first;
                                    byte[] bArr2 = (byte[]) pairA.second;
                                    listU = bArr2 != null ? ImmutableList2.u(bArr2) : list2;
                                    bArrCopyOfRange = bArr;
                                    list2 = listU;
                                    fW = f;
                                    i36 += iF4;
                                    i39 = i11;
                                    str10 = str13;
                                    iF3 = i18;
                                    i5 = i16;
                                    i6 = i17;
                                    bVar4 = bVar3;
                                    iY3 = i15;
                                    iY2 = i14;
                                } else if (iF5 == 1885434736) {
                                    parsableByteArray.E(i40 + 8);
                                    fW = parsableByteArray.w() / parsableByteArray.w();
                                    bArrCopyOfRange = bArr;
                                    z4 = true;
                                    i36 += iF4;
                                    i39 = i11;
                                    str10 = str13;
                                    iF3 = i18;
                                    i5 = i16;
                                    i6 = i17;
                                    bVar4 = bVar3;
                                    iY3 = i15;
                                    iY2 = i14;
                                } else if (iF5 == 1937126244) {
                                    int i41 = i40 + 8;
                                    while (true) {
                                        if (i41 - i40 >= iF4) {
                                            bArrCopyOfRange = null;
                                            break;
                                        }
                                        parsableByteArray.E(i41);
                                        int iF6 = parsableByteArray.f();
                                        if (parsableByteArray.f() == 1886547818) {
                                            bArrCopyOfRange = Arrays.copyOfRange(parsableByteArray.a, i41, iF6 + i41);
                                            break;
                                        }
                                        i41 += iF6;
                                    }
                                    listU = list2;
                                    list2 = listU;
                                    fW = f;
                                    i36 += iF4;
                                    i39 = i11;
                                    str10 = str13;
                                    iF3 = i18;
                                    i5 = i16;
                                    i6 = i17;
                                    bVar4 = bVar3;
                                    iY3 = i15;
                                    iY2 = i14;
                                } else if (iF5 == 1936995172) {
                                    int iT = parsableByteArray.t();
                                    parsableByteArray.F(3);
                                    if (iT == 0) {
                                        int iT2 = parsableByteArray.t();
                                        if (iT2 == 0) {
                                            i19 = 0;
                                        } else if (iT2 == 1) {
                                            i19 = 1;
                                        } else if (iT2 == 2) {
                                            i19 = 2;
                                        } else if (iT2 == 3) {
                                            i19 = 3;
                                        }
                                        i11 = i19;
                                        bArrCopyOfRange = bArr;
                                        list2 = listU;
                                        fW = f;
                                    }
                                    i36 += iF4;
                                    i39 = i11;
                                    str10 = str13;
                                    iF3 = i18;
                                    i5 = i16;
                                    i6 = i17;
                                    bVar4 = bVar3;
                                    iY3 = i15;
                                    iY2 = i14;
                                } else if (iF5 == 1668246642) {
                                    int iF7 = parsableByteArray.f();
                                    if (iF7 == 1852009592 || iF7 == 1852009571) {
                                        int iY4 = parsableByteArray.y();
                                        int iY5 = parsableByteArray.y();
                                        parsableByteArray.F(2);
                                        boolean z5 = iF4 == 19 && (parsableByteArray.t() & 128) != 0;
                                        int iA = ColorInfo.a(iY4);
                                        int i42 = z5 ? 1 : 2;
                                        i38 = iA;
                                        iB = ColorInfo.b(iY5);
                                        i37 = i42;
                                    } else {
                                        String strValueOf = String.valueOf(Atom.a(iF7));
                                        Log.w("AtomParsers", strValueOf.length() != 0 ? "Unsupported color type: ".concat(strValueOf) : new String("Unsupported color type: "));
                                    }
                                }
                            }
                            list = list2;
                            i14 = iY2;
                            i15 = iY3;
                            bVar3 = bVar4;
                            i16 = i5;
                            i17 = i6;
                            i18 = iF3;
                            list2 = list;
                            bArrCopyOfRange = bArr;
                            i36 += iF4;
                            i39 = i11;
                            str10 = str13;
                            iF3 = i18;
                            i5 = i16;
                            i6 = i17;
                            bVar4 = bVar3;
                            iY3 = i15;
                            iY2 = i14;
                        }
                        i19 = i11;
                        i11 = i19;
                        bArrCopyOfRange = bArr;
                        list2 = listU;
                        fW = f;
                        i36 += iF4;
                        i39 = i11;
                        str10 = str13;
                        iF3 = i18;
                        i5 = i16;
                        i6 = i17;
                        bVar4 = bVar3;
                        iY3 = i15;
                        iY2 = i14;
                    }
                    str11 = str2;
                    i14 = iY2;
                    i15 = iY3;
                    bVar3 = bVar4;
                    i16 = i5;
                    i17 = i6;
                    i18 = iF3;
                    list2 = list;
                    bArrCopyOfRange = bArr;
                    i36 += iF4;
                    i39 = i11;
                    str10 = str13;
                    iF3 = i18;
                    i5 = i16;
                    i6 = i17;
                    bVar4 = bVar3;
                    iY3 = i15;
                    iY2 = i14;
                }
                float f3 = fW;
                if (str11 == null) {
                    bVar2 = bVar;
                } else {
                    Format2.b bVar5 = new Format2.b();
                    bVar5.b(i);
                    bVar5.k = str11;
                    bVar5.h = str12;
                    bVar5.p = i7;
                    bVar5.q = i8;
                    bVar5.t = f3;
                    bVar5.f1022s = i2;
                    bVar5.u = bArr;
                    bVar5.v = i11;
                    bVar5.m = list2;
                    bVar5.n = drmInitData3;
                    int i43 = i38;
                    if (i43 == -1) {
                        i13 = i37;
                        i12 = iB;
                        if (i13 != -1 || i12 != -1 || byteBufferOrder != null) {
                        }
                        Format2 format2A = bVar5.a();
                        bVar2 = bVar;
                        bVar2.f1211b = format2A;
                    } else {
                        i12 = iB;
                        i13 = i37;
                    }
                    bVar5.w = new ColorInfo(i43, i13, i12, byteBufferOrder != null ? byteBufferOrder.array() : null);
                    Format2 format2A2 = bVar5.a();
                    bVar2 = bVar;
                    bVar2.f1211b = format2A2;
                }
            } else if (iF3 == 1836069985 || iF3 == 1701733217 || iF3 == 1633889587 || iF3 == 1700998451 || iF3 == 1633889588 || iF3 == 1835823201 || iF3 == 1685353315 || iF3 == 1685353317 || iF3 == 1685353320 || iF3 == 1685353324 || iF3 == 1685353336 || iF3 == 1935764850 || iF3 == 1935767394 || iF3 == 1819304813 || iF3 == 1936684916 || iF3 == 1953984371 || iF3 == 778924082 || iF3 == 778924083 || iF3 == 1835557169 || iF3 == 1835560241 || iF3 == 1634492771 || iF3 == 1634492791 || iF3 == 1970037111 || iF3 == 1332770163 || iF3 == 1716281667) {
                parsableByteArray.E(i35 + 8 + 8);
                if (z2) {
                    iY = parsableByteArray.y();
                    parsableByteArray.F(6);
                } else {
                    parsableByteArray.F(8);
                    iY = 0;
                }
                if (iY == 0 || iY == 1) {
                    int iY6 = parsableByteArray.y();
                    parsableByteArray.F(6);
                    byte[] bArr3 = parsableByteArray.a;
                    int i44 = parsableByteArray.f984b;
                    int i45 = i44 + 1;
                    parsableByteArray.f984b = i45;
                    int i46 = (bArr3[i44] & 255) << 8;
                    i3 = iF;
                    int i47 = i45 + 1;
                    parsableByteArray.f984b = i47;
                    iRound = (bArr3[i45] & 255) | i46;
                    int i48 = i47 + 2;
                    parsableByteArray.f984b = i48;
                    parsableByteArray.E(i48 - 4);
                    int iF8 = parsableByteArray.f();
                    if (iY == 1) {
                        parsableByteArray.F(16);
                    }
                    iW = iY6;
                    i20 = iF8;
                } else if (iY == 2) {
                    parsableByteArray.F(16);
                    iRound = (int) Math.round(Double.longBitsToDouble(parsableByteArray.m()));
                    iW = parsableByteArray.w();
                    parsableByteArray.F(20);
                    i20 = 0;
                    i3 = iF;
                } else {
                    i3 = iF;
                    i4 = i34;
                    i22 = i35;
                    i21 = iF2;
                    bVar2 = bVar4;
                    i9 = i22;
                    i10 = i21;
                }
                int i49 = parsableByteArray.f984b;
                if (iF3 == 1701733217) {
                    Pair<Integer, TrackEncryptionBox> pairC2 = c(parsableByteArray, i35, iF2);
                    if (pairC2 != null) {
                        int iIntValue3 = ((Integer) pairC2.first).intValue();
                        drmInitDataA2 = drmInitData2 == null ? null : drmInitData2.a(((TrackEncryptionBox) pairC2.second).f1231b);
                        bVar4.a[i34] = (TrackEncryptionBox) pairC2.second;
                        iF3 = iIntValue3;
                    } else {
                        drmInitDataA2 = drmInitData2;
                    }
                    parsableByteArray.E(i49);
                } else {
                    drmInitDataA2 = drmInitData2;
                }
                String str14 = "audio/ac3";
                String str15 = "audio/raw";
                int i50 = iW;
                if (iF3 == 1633889587) {
                    str15 = "audio/ac3";
                } else if (iF3 == 1700998451) {
                    str15 = "audio/eac3";
                } else if (iF3 == 1633889588) {
                    str15 = "audio/ac4";
                } else {
                    if (iF3 == 1685353315) {
                        str3 = "audio/vnd.dts";
                    } else if (iF3 == 1685353320 || iF3 == 1685353324) {
                        str3 = "audio/vnd.dts.hd";
                    } else if (iF3 == 1685353317) {
                        str3 = "audio/vnd.dts.hd;profile=lbr";
                    } else if (iF3 == 1685353336) {
                        str3 = "audio/vnd.dts.uhd;profile=p2";
                    } else if (iF3 == 1935764850) {
                        str3 = "audio/3gpp";
                    } else if (iF3 == 1935767394) {
                        str3 = "audio/amr-wb";
                    } else {
                        if (iF3 == 1819304813 || iF3 == 1936684916) {
                            i23 = 2;
                        } else if (iF3 == 1953984371) {
                            i23 = 268435456;
                        } else if (iF3 == 778924082 || iF3 == 778924083) {
                            str3 = "audio/mpeg";
                        } else if (iF3 == 1835557169) {
                            str3 = "audio/mha1";
                        } else if (iF3 == 1835560241) {
                            str3 = "audio/mhm1";
                        } else if (iF3 == 1634492771) {
                            str3 = "audio/alac";
                        } else if (iF3 == 1634492791) {
                            str3 = "audio/g711-alaw";
                        } else if (iF3 == 1970037111) {
                            str3 = "audio/g711-mlaw";
                        } else if (iF3 == 1332770163) {
                            str3 = "audio/opus";
                        } else if (iF3 == 1716281667) {
                            str3 = "audio/flac";
                        } else if (iF3 == 1835823201) {
                            str3 = "audio/true-hd";
                        } else {
                            i23 = -1;
                            str15 = null;
                        }
                        int i51 = iRound;
                        iIntValue = i50;
                        str4 = null;
                        i4 = i34;
                        String str16 = str15;
                        i24 = i23;
                        str5 = str16;
                        listU2 = null;
                        i25 = i49;
                        while (i25 - i35 < iF2) {
                            parsableByteArray.E(i25);
                            int iF9 = parsableByteArray.f();
                            if (iF9 > 0) {
                                i27 = iF2;
                                z3 = true;
                            } else {
                                i27 = iF2;
                                z3 = false;
                            }
                            AnimatableValueParser.q(z3, str10);
                            int iF10 = parsableByteArray.f();
                            int i52 = i35;
                            if (iF10 == 1835557187) {
                                int i53 = iF9 - 13;
                                byte[] bArr4 = new byte[i53];
                                parsableByteArray.E(i25 + 13);
                                System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr4, 0, i53);
                                parsableByteArray.f984b += i53;
                                listU2 = ImmutableList2.u(bArr4);
                                str10 = str10;
                                i31 = iF9;
                                i51 = i51;
                                str6 = str14;
                                i30 = i20;
                            } else {
                                int i54 = i51;
                                int i55 = iF9;
                                String str17 = str10;
                                if (iF10 == 1702061171) {
                                    i28 = i54;
                                    str6 = str14;
                                    i29 = 1702061171;
                                } else if (z2 && iF10 == 2002876005) {
                                    i29 = 1702061171;
                                    i28 = i54;
                                    str6 = str14;
                                } else {
                                    if (iF10 == 1684103987) {
                                        parsableByteArray.E(i25 + 8);
                                        String string = Integer.toString(i);
                                        int i56 = Ac3Util.f1123b[(parsableByteArray.t() & Opcodes.CHECKCAST) >> 6];
                                        int iT3 = parsableByteArray.t();
                                        int i57 = Ac3Util.d[(iT3 & 56) >> 3];
                                        if ((iT3 & 4) != 0) {
                                            i57++;
                                        }
                                        Format2.b bVar6 = new Format2.b();
                                        bVar6.a = string;
                                        bVar6.k = str14;
                                        bVar6.f1023x = i57;
                                        bVar6.f1024y = i56;
                                        bVar6.n = drmInitDataA2;
                                        bVar6.c = str9;
                                        bVar4.f1211b = bVar6.a();
                                    } else if (iF10 == 1684366131) {
                                        parsableByteArray.E(i25 + 8);
                                        String string2 = Integer.toString(i);
                                        parsableByteArray.F(2);
                                        int i58 = Ac3Util.f1123b[(parsableByteArray.t() & Opcodes.CHECKCAST) >> 6];
                                        int iT4 = parsableByteArray.t();
                                        int i59 = Ac3Util.d[(iT4 & 14) >> 1];
                                        if ((iT4 & 1) != 0) {
                                            i59++;
                                        }
                                        if (((parsableByteArray.t() & 30) >> 1) > 0 && (parsableByteArray.t() & 2) != 0) {
                                            i59 += 2;
                                        }
                                        String str18 = (parsableByteArray.a() <= 0 || (parsableByteArray.t() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc";
                                        Format2.b bVar7 = new Format2.b();
                                        bVar7.a = string2;
                                        bVar7.k = str18;
                                        bVar7.f1023x = i59;
                                        bVar7.f1024y = i58;
                                        bVar7.n = drmInitDataA2;
                                        bVar7.c = str9;
                                        bVar4.f1211b = bVar7.a();
                                    } else if (iF10 == 1684103988) {
                                        parsableByteArray.E(i25 + 8);
                                        String string3 = Integer.toString(i);
                                        parsableByteArray.F(1);
                                        int i60 = ((parsableByteArray.t() & 32) >> 5) == 1 ? 48000 : 44100;
                                        Format2.b bVar8 = new Format2.b();
                                        bVar8.a = string3;
                                        bVar8.k = "audio/ac4";
                                        bVar8.f1023x = 2;
                                        bVar8.f1024y = i60;
                                        bVar8.n = drmInitDataA2;
                                        bVar8.c = str9;
                                        bVar4.f1211b = bVar8.a();
                                    } else {
                                        if (iF10 == 1684892784) {
                                            if (i20 <= 0) {
                                                throw outline.w0(60, "Invalid sample rate for Dolby TrueHD MLP stream: ", i20, null);
                                            }
                                            iIntValue = 2;
                                            i51 = i20;
                                            listG = listU2;
                                        } else if (iF10 == 1684305011) {
                                            Format2.b bVar9 = new Format2.b();
                                            bVar9.b(i);
                                            bVar9.k = str5;
                                            bVar9.f1023x = iIntValue;
                                            iIntValue2 = i54;
                                            bVar9.f1024y = iIntValue2;
                                            bVar9.n = drmInitDataA2;
                                            bVar9.c = str9;
                                            bVar4.f1211b = bVar9.a();
                                            str6 = str14;
                                            i51 = iIntValue2;
                                            listG = listU2;
                                            str10 = str17;
                                            i31 = i55;
                                            i30 = i20;
                                            listU2 = listG;
                                        } else {
                                            iIntValue2 = i54;
                                            if (iF10 == 1682927731) {
                                                int i61 = i55 - 8;
                                                byte[] bArr5 = a;
                                                byte[] bArrCopyOf = Arrays.copyOf(bArr5, bArr5.length + i61);
                                                parsableByteArray.E(i25 + 8);
                                                parsableByteArray.e(bArrCopyOf, bArr5.length, i61);
                                                listG = AnimatableValueParser.g(bArrCopyOf);
                                                i51 = iIntValue2;
                                            } else {
                                                if (iF10 == 1684425825) {
                                                    int i62 = i55 - 12;
                                                    byte[] bArr6 = new byte[i62 + 4];
                                                    bArr6[0] = 102;
                                                    bArr6[1] = 76;
                                                    bArr6[2] = 97;
                                                    bArr6[3] = 67;
                                                    parsableByteArray.E(i25 + 12);
                                                    str6 = str14;
                                                    System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr6, 4, i62);
                                                    parsableByteArray.f984b += i62;
                                                    immutableList2U = ImmutableList2.u(bArr6);
                                                } else {
                                                    str6 = str14;
                                                    if (iF10 == 1634492771) {
                                                        int i63 = i55 - 12;
                                                        byte[] bArr7 = new byte[i63];
                                                        parsableByteArray.E(i25 + 12);
                                                        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr7, 0, i63);
                                                        parsableByteArray.f984b += i63;
                                                        ParsableByteArray parsableByteArray2 = new ParsableByteArray(bArr7);
                                                        parsableByteArray2.E(9);
                                                        int iT5 = parsableByteArray2.t();
                                                        parsableByteArray2.E(20);
                                                        Pair pairCreate = Pair.create(Integer.valueOf(parsableByteArray2.w()), Integer.valueOf(iT5));
                                                        iIntValue2 = ((Integer) pairCreate.first).intValue();
                                                        iIntValue = ((Integer) pairCreate.second).intValue();
                                                        immutableList2U = ImmutableList2.u(bArr7);
                                                    }
                                                    i51 = iIntValue2;
                                                    listG = listU2;
                                                    str10 = str17;
                                                    i31 = i55;
                                                    i30 = i20;
                                                    listU2 = listG;
                                                }
                                                int i64 = iIntValue2;
                                                listG = immutableList2U;
                                                i51 = i64;
                                                str10 = str17;
                                                i31 = i55;
                                                i30 = i20;
                                                listU2 = listG;
                                            }
                                        }
                                        str6 = str14;
                                        str10 = str17;
                                        i31 = i55;
                                        i30 = i20;
                                        listU2 = listG;
                                    }
                                    iIntValue2 = i54;
                                    str6 = str14;
                                    i51 = iIntValue2;
                                    listG = listU2;
                                    str10 = str17;
                                    i31 = i55;
                                    i30 = i20;
                                    listU2 = listG;
                                }
                                if (iF10 != i29) {
                                    i32 = parsableByteArray.f984b;
                                    AnimatableValueParser.q(i32 >= i25, null);
                                    while (true) {
                                        i31 = i55;
                                        if (i32 - i25 >= i31) {
                                            str10 = str17;
                                            i30 = i20;
                                            i33 = -1;
                                            i32 = -1;
                                            break;
                                        }
                                        parsableByteArray.E(i32);
                                        int iF11 = parsableByteArray.f();
                                        str10 = str17;
                                        AnimatableValueParser.q(iF11 > 0, str10);
                                        i30 = i20;
                                        if (parsableByteArray.f() == 1702061171) {
                                            break;
                                        }
                                        i32 += iF11;
                                        i55 = i31;
                                        i20 = i30;
                                        str17 = str10;
                                    }
                                } else {
                                    i32 = i25;
                                    str10 = str17;
                                    i31 = i55;
                                    i30 = i20;
                                }
                                i33 = -1;
                                if (i32 != i33) {
                                    Pair<String, byte[]> pairA2 = a(parsableByteArray, i32);
                                    str5 = (String) pairA2.first;
                                    byte[] bArr8 = (byte[]) pairA2.second;
                                    if (bArr8 != null) {
                                        if ("audio/mp4a-latm".equals(str5)) {
                                            AacUtil.b bVarB = AacUtil.b(new ParsableBitArray(bArr8), false);
                                            i28 = bVarB.a;
                                            iIntValue = bVarB.f1122b;
                                            str7 = bVarB.c;
                                        } else {
                                            str7 = str4;
                                        }
                                        listU2 = ImmutableList2.u(bArr8);
                                        str4 = str7;
                                        i51 = i28;
                                    }
                                }
                                i51 = i28;
                                listG = listU2;
                                listU2 = listG;
                            }
                            i25 += i31;
                            i35 = i52;
                            iF2 = i27;
                            i20 = i30;
                            str14 = str6;
                        }
                        i26 = i51;
                        i22 = i35;
                        i21 = iF2;
                        if (bVar4.f1211b == null && str5 != null) {
                            Format2.b bVar10 = new Format2.b();
                            bVar10.b(i);
                            bVar10.k = str5;
                            bVar10.h = str4;
                            bVar10.f1023x = iIntValue;
                            bVar10.f1024y = i26;
                            bVar10.f1025z = i24;
                            bVar10.m = listU2;
                            bVar10.n = drmInitDataA2;
                            bVar10.c = str9;
                            bVar4.f1211b = bVar10.a();
                        }
                        bVar2 = bVar4;
                        i9 = i22;
                        i10 = i21;
                    }
                    str15 = str3;
                }
                i23 = -1;
                int i512 = iRound;
                iIntValue = i50;
                str4 = null;
                i4 = i34;
                String str162 = str15;
                i24 = i23;
                str5 = str162;
                listU2 = null;
                i25 = i49;
                while (i25 - i35 < iF2) {
                }
                i26 = i512;
                i22 = i35;
                i21 = iF2;
                if (bVar4.f1211b == null) {
                    Format2.b bVar102 = new Format2.b();
                    bVar102.b(i);
                    bVar102.k = str5;
                    bVar102.h = str4;
                    bVar102.f1023x = iIntValue;
                    bVar102.f1024y = i26;
                    bVar102.f1025z = i24;
                    bVar102.m = listU2;
                    bVar102.n = drmInitDataA2;
                    bVar102.c = str9;
                    bVar4.f1211b = bVar102.a();
                }
                bVar2 = bVar4;
                i9 = i22;
                i10 = i21;
            } else {
                if (iF3 == 1414810956 || iF3 == 1954034535 || iF3 == 2004251764 || iF3 == 1937010800 || iF3 == 1664495672) {
                    parsableByteArray.E(i35 + 8 + 8);
                    long j = RecyclerView.FOREVER_NS;
                    String str19 = "application/ttml+xml";
                    if (iF3 == 1414810956) {
                        immutableList2U2 = null;
                        str8 = str19;
                        Format2.b bVar11 = new Format2.b();
                        bVar11.b(i);
                        bVar11.k = str8;
                        bVar11.c = str9;
                        bVar11.o = j;
                        bVar11.m = immutableList2U2;
                        bVar4.f1211b = bVar11.a();
                    } else if (iF3 == 1954034535) {
                        int i65 = (iF2 - 8) - 8;
                        byte[] bArr9 = new byte[i65];
                        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr9, 0, i65);
                        parsableByteArray.f984b += i65;
                        immutableList2U2 = ImmutableList2.u(bArr9);
                        str8 = "application/x-quicktime-tx3g";
                        Format2.b bVar112 = new Format2.b();
                        bVar112.b(i);
                        bVar112.k = str8;
                        bVar112.c = str9;
                        bVar112.o = j;
                        bVar112.m = immutableList2U2;
                        bVar4.f1211b = bVar112.a();
                    } else {
                        if (iF3 == 2004251764) {
                            str19 = "application/x-mp4-vtt";
                        } else if (iF3 == 1937010800) {
                            j = 0;
                        } else {
                            if (iF3 != 1664495672) {
                                throw new IllegalStateException();
                            }
                            bVar4.d = 1;
                            str19 = "application/x-mp4-cea-608";
                        }
                        immutableList2U2 = null;
                        str8 = str19;
                        Format2.b bVar1122 = new Format2.b();
                        bVar1122.b(i);
                        bVar1122.k = str8;
                        bVar1122.c = str9;
                        bVar1122.o = j;
                        bVar1122.m = immutableList2U2;
                        bVar4.f1211b = bVar1122.a();
                    }
                } else if (iF3 == 1835365492) {
                    parsableByteArray.E(i35 + 8 + 8);
                    if (iF3 == 1835365492) {
                        parsableByteArray.n();
                        String strN = parsableByteArray.n();
                        if (strN != null) {
                            Format2.b bVar12 = new Format2.b();
                            bVar12.b(i);
                            bVar12.k = strN;
                            bVar4.f1211b = bVar12.a();
                        }
                    }
                } else if (iF3 == 1667329389) {
                    Format2.b bVar13 = new Format2.b();
                    bVar13.b(i);
                    bVar13.k = "application/x-camera-motion";
                    bVar4.f1211b = bVar13.a();
                }
                i3 = iF;
                bVar2 = bVar4;
                i4 = i34;
                i9 = i35;
                i10 = iF2;
            }
            parsableByteArray.E(i9 + i10);
            i34 = i4 + 1;
            str9 = str;
            bVar4 = bVar2;
            iF = i3;
            drmInitData2 = drmInitData;
        }
        return bVar4;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x05e3  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x05ee  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0652  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0664  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<TrackSampleTable> e(Atom.a aVar, GaplessInfoHolder gaplessInfoHolder, long j, @Nullable DrmInitData drmInitData, boolean z2, boolean z3, Function2<Track, Track> function2) throws ParserException {
        Track track;
        Function2<Track, Track> function22;
        Track trackApply;
        a dVar;
        boolean z4;
        int iW;
        int iW2;
        int iW3;
        int i;
        int iA;
        ArrayList arrayList;
        String str;
        long[] jArrCopyOf;
        boolean z5;
        int i2;
        Track track2;
        int[] iArr;
        int i3;
        long[] jArr;
        int[] iArr2;
        long j2;
        int i4;
        long[] jArr2;
        int i5;
        int[] iArr3;
        long[] jArr3;
        TrackSampleTable trackSampleTable;
        long[] jArr4;
        int i6;
        int[] iArr4;
        int[] iArr5;
        TrackSampleTable trackSampleTable2;
        boolean z6;
        ArrayList arrayList2;
        boolean z7;
        long jU;
        int i7;
        b bVarD;
        long[] jArr5;
        long[] jArr6;
        Atom.a aVarB;
        Pair pairCreate;
        int i8;
        int i9;
        long jF;
        Atom.a aVar2 = aVar;
        ArrayList arrayList3 = new ArrayList();
        int i10 = 0;
        while (i10 < aVar2.d.size()) {
            Atom.a aVar3 = aVar2.d.get(i10);
            if (aVar3.a != 1953653099) {
                arrayList2 = arrayList3;
                i = i10;
            } else {
                Atom.b bVarC = aVar2.c(1836476516);
                Objects.requireNonNull(bVarC);
                Atom.a aVarB2 = aVar3.b(1835297121);
                Objects.requireNonNull(aVarB2);
                Atom.b bVarC2 = aVarB2.c(1751411826);
                Objects.requireNonNull(bVarC2);
                ParsableByteArray parsableByteArray = bVarC2.f1210b;
                parsableByteArray.E(16);
                int iF = parsableByteArray.f();
                int i11 = iF == 1936684398 ? 1 : iF == 1986618469 ? 2 : (iF == 1952807028 || iF == 1935832172 || iF == 1937072756 || iF == 1668047728) ? 3 : iF == 1835365473 ? 5 : -1;
                if (i11 == -1) {
                    track = null;
                    function22 = function2;
                    trackApply = function22.apply(track);
                    if (trackApply == null) {
                        Atom.a aVarB3 = aVar3.b(1835297121);
                        Objects.requireNonNull(aVarB3);
                        Atom.a aVarB4 = aVarB3.b(1835626086);
                        Objects.requireNonNull(aVarB4);
                        Atom.a aVarB5 = aVarB4.b(1937007212);
                        Objects.requireNonNull(aVarB5);
                        Atom.b bVarC3 = aVarB5.c(1937011578);
                        if (bVarC3 != null) {
                            dVar = new c(bVarC3, trackApply.f);
                        } else {
                            Atom.b bVarC4 = aVarB5.c(1937013298);
                            if (bVarC4 == null) {
                                throw ParserException.a("Track has no sample table size information", null);
                            }
                            dVar = new d(bVarC4);
                        }
                        int iB = dVar.b();
                        if (iB == 0) {
                            trackSampleTable = new TrackSampleTable(trackApply, new long[0], new int[0], 0, new long[0], new int[0], 0L);
                            arrayList = arrayList3;
                            i = i10;
                        } else {
                            Atom.b bVarC5 = aVarB5.c(1937007471);
                            if (bVarC5 == null) {
                                bVarC5 = aVarB5.c(1668232756);
                                Objects.requireNonNull(bVarC5);
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            ParsableByteArray parsableByteArray2 = bVarC5.f1210b;
                            Atom.b bVarC6 = aVarB5.c(1937011555);
                            Objects.requireNonNull(bVarC6);
                            ParsableByteArray parsableByteArray3 = bVarC6.f1210b;
                            Atom.b bVarC7 = aVarB5.c(1937011827);
                            Objects.requireNonNull(bVarC7);
                            ParsableByteArray parsableByteArray4 = bVarC7.f1210b;
                            Atom.b bVarC8 = aVarB5.c(1937011571);
                            ParsableByteArray parsableByteArray5 = bVarC8 != null ? bVarC8.f1210b : null;
                            Atom.b bVarC9 = aVarB5.c(1668576371);
                            ParsableByteArray parsableByteArray6 = bVarC9 != null ? bVarC9.f1210b : null;
                            parsableByteArray2.E(12);
                            int iW4 = parsableByteArray2.w();
                            parsableByteArray3.E(12);
                            int iW5 = parsableByteArray3.w();
                            AnimatableValueParser.q(parsableByteArray3.f() == 1, "first_chunk must be 1");
                            parsableByteArray4.E(12);
                            int iW6 = parsableByteArray4.w() - 1;
                            int iW7 = parsableByteArray4.w();
                            int i12 = iW5;
                            int iW8 = parsableByteArray4.w();
                            if (parsableByteArray6 != null) {
                                parsableByteArray6.E(12);
                                iW = parsableByteArray6.w();
                            } else {
                                iW = 0;
                            }
                            if (parsableByteArray5 != null) {
                                parsableByteArray5.E(12);
                                iW2 = parsableByteArray5.w();
                                if (iW2 > 0) {
                                    iW3 = parsableByteArray5.w() - 1;
                                    i = i10;
                                    iA = dVar.a();
                                    arrayList = arrayList3;
                                    str = trackApply.f.w;
                                    if (iA == -1 && ("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && iW6 == 0 && iW == 0 && iW2 == 0) {
                                        long[] jArrCopyOf2 = new long[iB];
                                        int[] iArrCopyOf = new int[iB];
                                        jArrCopyOf = new long[iB];
                                        int i13 = iW2;
                                        int[] iArrCopyOf2 = new int[iB];
                                        int i14 = 0;
                                        int i15 = 0;
                                        int iW9 = 0;
                                        long j3 = 0;
                                        long j4 = 0;
                                        long jX = 0;
                                        int i16 = -1;
                                        int i17 = iW8;
                                        int iW10 = iW7;
                                        int i18 = iW3;
                                        int i19 = i13;
                                        int iF2 = 0;
                                        int iW11 = 0;
                                        int i20 = iW6;
                                        int i21 = iW;
                                        int i22 = 0;
                                        int i23 = 0;
                                        while (true) {
                                            if (i22 >= iB) {
                                                break;
                                            }
                                            boolean z8 = true;
                                            int i24 = i14;
                                            int i25 = iB;
                                            int iW12 = i24;
                                            while (true) {
                                                if (i15 != 0) {
                                                    i4 = i18;
                                                    break;
                                                }
                                                i4 = i18;
                                                int i26 = i16 + 1;
                                                if (i26 == iW4) {
                                                    z8 = false;
                                                } else {
                                                    jX = z4 ? parsableByteArray2.x() : parsableByteArray2.u();
                                                    if (i26 == iW12) {
                                                        iW9 = parsableByteArray3.w();
                                                        parsableByteArray3.F(4);
                                                        i12--;
                                                        iW12 = i12 > 0 ? parsableByteArray3.w() - 1 : -1;
                                                    }
                                                    z8 = true;
                                                }
                                                i16 = i26;
                                                if (!z8) {
                                                    break;
                                                }
                                                i15 = iW9;
                                                j4 = jX;
                                                i18 = i4;
                                            }
                                            if (!z8) {
                                                Log.w("AtomParsers", "Unexpected end of chunk data");
                                                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i22);
                                                iArrCopyOf = Arrays.copyOf(iArrCopyOf, i22);
                                                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i22);
                                                iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i22);
                                                iB = i22;
                                                break;
                                            }
                                            if (parsableByteArray6 != null) {
                                                while (iW11 == 0 && i21 > 0) {
                                                    iW11 = parsableByteArray6.w();
                                                    iF2 = parsableByteArray6.f();
                                                    i21--;
                                                }
                                                iW11--;
                                            }
                                            int i27 = iF2;
                                            jArrCopyOf2[i22] = j4;
                                            iArrCopyOf[i22] = dVar.c();
                                            if (iArrCopyOf[i22] > i23) {
                                                i23 = iArrCopyOf[i22];
                                            }
                                            ParsableByteArray parsableByteArray7 = parsableByteArray2;
                                            boolean z9 = z4;
                                            jArrCopyOf[i22] = j3 + i27;
                                            iArrCopyOf2[i22] = parsableByteArray5 == null ? 1 : 0;
                                            int iW13 = i4;
                                            if (i22 == iW13) {
                                                iArrCopyOf2[i22] = 1;
                                                i19--;
                                                if (i19 > 0) {
                                                    Objects.requireNonNull(parsableByteArray5);
                                                    iW13 = parsableByteArray5.w() - 1;
                                                }
                                            }
                                            long[] jArr7 = jArrCopyOf;
                                            int iF3 = i17;
                                            int i28 = iW12;
                                            j3 += iF3;
                                            iW10--;
                                            if (iW10 == 0 && i20 > 0) {
                                                i20--;
                                                iW10 = parsableByteArray4.w();
                                                iF3 = parsableByteArray4.f();
                                            }
                                            j4 += iArrCopyOf[i22];
                                            i15--;
                                            i22++;
                                            iF2 = i27;
                                            iB = i25;
                                            i14 = i28;
                                            jArrCopyOf = jArr7;
                                            i17 = iF3;
                                            z4 = z9;
                                            i18 = iW13;
                                            parsableByteArray2 = parsableByteArray7;
                                        }
                                        int i29 = i15;
                                        long j5 = j3 + iF2;
                                        if (parsableByteArray6 != null) {
                                            while (i21 > 0) {
                                                if (parsableByteArray6.w() != 0) {
                                                    z5 = false;
                                                    break;
                                                }
                                                parsableByteArray6.f();
                                                i21--;
                                            }
                                            z5 = true;
                                            if (i19 != 0 && iW10 == 0 && i29 == 0 && i20 == 0) {
                                                i2 = iW11;
                                                if (i2 == 0 && z5) {
                                                    track2 = trackApply;
                                                }
                                                iArr = iArrCopyOf;
                                                i3 = i23;
                                                jArr = jArrCopyOf2;
                                                iArr2 = iArrCopyOf2;
                                                j2 = j5;
                                            } else {
                                                i2 = iW11;
                                            }
                                            track2 = trackApply;
                                            int i30 = track2.a;
                                            String str2 = z5 ? ", ctts invalid" : "";
                                            StringBuilder sb = new StringBuilder(str2.length() + 262);
                                            sb.append("Inconsistent stbl box for track ");
                                            sb.append(i30);
                                            sb.append(": remainingSynchronizationSamples ");
                                            sb.append(i19);
                                            sb.append(", remainingSamplesAtTimestampDelta ");
                                            sb.append(iW10);
                                            sb.append(", remainingSamplesInChunk ");
                                            sb.append(i29);
                                            sb.append(", remainingTimestampDeltaChanges ");
                                            sb.append(i20);
                                            sb.append(", remainingSamplesAtTimestampOffset ");
                                            sb.append(i2);
                                            outline.r0(sb, str2, "AtomParsers");
                                            iArr = iArrCopyOf;
                                            i3 = i23;
                                            jArr = jArrCopyOf2;
                                            iArr2 = iArrCopyOf2;
                                            j2 = j5;
                                        } else {
                                            z5 = true;
                                            if (i19 != 0) {
                                                i2 = iW11;
                                                track2 = trackApply;
                                                int i302 = track2.a;
                                                if (z5) {
                                                }
                                                StringBuilder sb2 = new StringBuilder(str2.length() + 262);
                                                sb2.append("Inconsistent stbl box for track ");
                                                sb2.append(i302);
                                                sb2.append(": remainingSynchronizationSamples ");
                                                sb2.append(i19);
                                                sb2.append(", remainingSamplesAtTimestampDelta ");
                                                sb2.append(iW10);
                                                sb2.append(", remainingSamplesInChunk ");
                                                sb2.append(i29);
                                                sb2.append(", remainingTimestampDeltaChanges ");
                                                sb2.append(i20);
                                                sb2.append(", remainingSamplesAtTimestampOffset ");
                                                sb2.append(i2);
                                                outline.r0(sb2, str2, "AtomParsers");
                                                iArr = iArrCopyOf;
                                                i3 = i23;
                                                jArr = jArrCopyOf2;
                                                iArr2 = iArrCopyOf2;
                                                j2 = j5;
                                            }
                                        }
                                    } else {
                                        long[] jArr8 = new long[iW4];
                                        int[] iArr6 = new int[iW4];
                                        int iW14 = 0;
                                        long jX2 = 0;
                                        int i31 = -1;
                                        int iW15 = 0;
                                        while (true) {
                                            i31++;
                                            if (i31 == iW4) {
                                                z6 = false;
                                            } else {
                                                jX2 = z4 ? parsableByteArray2.x() : parsableByteArray2.u();
                                                if (i31 == iW14) {
                                                    iW15 = parsableByteArray3.w();
                                                    parsableByteArray3.F(4);
                                                    i12--;
                                                    iW14 = i12 > 0 ? parsableByteArray3.w() - 1 : -1;
                                                }
                                                z6 = true;
                                            }
                                            if (!z6) {
                                                break;
                                            }
                                            jArr8[i31] = jX2;
                                            iArr6[i31] = iW15;
                                        }
                                        long j6 = iW8;
                                        int i32 = 8192 / iA;
                                        int iF4 = 0;
                                        for (int i33 = 0; i33 < iW4; i33++) {
                                            iF4 += Util2.f(iArr6[i33], i32);
                                        }
                                        jArr = new long[iF4];
                                        int[] iArr7 = new int[iF4];
                                        long[] jArr9 = new long[iF4];
                                        int[] iArr8 = new int[iF4];
                                        int i34 = 0;
                                        int i35 = 0;
                                        int i36 = 0;
                                        int i37 = 0;
                                        while (i34 < iW4) {
                                            int i38 = iArr6[i34];
                                            long j7 = jArr8[i34];
                                            long[] jArr10 = jArr8;
                                            int[] iArr9 = iArr6;
                                            int iMax = i37;
                                            int i39 = i38;
                                            long j8 = j7;
                                            while (i39 > 0) {
                                                int iMin = Math.min(i32, i39);
                                                jArr[i36] = j8;
                                                iArr7[i36] = iA * iMin;
                                                iMax = Math.max(iMax, iArr7[i36]);
                                                jArr9[i36] = i35 * j6;
                                                iArr8[i36] = 1;
                                                j8 += iArr7[i36];
                                                i35 += iMin;
                                                i39 -= iMin;
                                                i36++;
                                                i32 = i32;
                                                iA = iA;
                                            }
                                            i34++;
                                            i37 = iMax;
                                            jArr8 = jArr10;
                                            iArr6 = iArr9;
                                        }
                                        j2 = j6 * i35;
                                        iArr2 = iArr8;
                                        iArr = iArr7;
                                        jArrCopyOf = jArr9;
                                        i3 = i37;
                                        track2 = trackApply;
                                    }
                                    long jF2 = Util2.F(j2, 1000000L, track2.c);
                                    jArr2 = track2.h;
                                    if (jArr2 != null) {
                                        Util2.G(jArrCopyOf, 1000000L, track2.c);
                                        trackSampleTable = new TrackSampleTable(track2, jArr, iArr, i3, jArrCopyOf, iArr2, jF2);
                                    } else {
                                        if (jArr2.length == 1 && track2.f1230b == 1 && jArrCopyOf.length >= 2) {
                                            long[] jArr11 = track2.i;
                                            Objects.requireNonNull(jArr11);
                                            long j9 = jArr11[0];
                                            jArr3 = jArr;
                                            i5 = i3;
                                            iArr3 = iArr2;
                                            long jF3 = Util2.F(track2.h[0], track2.c, track2.d) + j9;
                                            int length = jArrCopyOf.length - 1;
                                            if (jArrCopyOf[0] <= j9 && j9 < jArrCopyOf[Util2.h(4, 0, length)] && jArrCopyOf[Util2.h(jArrCopyOf.length - 4, 0, length)] < jF3 && jF3 <= j2) {
                                                long j10 = j2 - jF3;
                                                long jF4 = Util2.F(j9 - jArrCopyOf[0], track2.f.K, track2.c);
                                                long jF5 = Util2.F(j10, track2.f.K, track2.c);
                                                if ((jF4 != 0 || jF5 != 0) && jF4 <= 2147483647L && jF5 <= 2147483647L) {
                                                    gaplessInfoHolder.f1294b = (int) jF4;
                                                    gaplessInfoHolder.c = (int) jF5;
                                                    Util2.G(jArrCopyOf, 1000000L, track2.c);
                                                    trackSampleTable2 = new TrackSampleTable(track2, jArr3, iArr, i5, jArrCopyOf, iArr3, Util2.F(track2.h[0], 1000000L, track2.d));
                                                }
                                                trackSampleTable = trackSampleTable2;
                                            }
                                        } else {
                                            i5 = i3;
                                            iArr3 = iArr2;
                                            jArr3 = jArr;
                                        }
                                        long[] jArr12 = track2.h;
                                        if (jArr12.length == 1 && jArr12[0] == 0) {
                                            long[] jArr13 = track2.i;
                                            Objects.requireNonNull(jArr13);
                                            long j11 = jArr13[0];
                                            for (int i40 = 0; i40 < jArrCopyOf.length; i40++) {
                                                jArrCopyOf[i40] = Util2.F(jArrCopyOf[i40] - j11, 1000000L, track2.c);
                                            }
                                            trackSampleTable2 = new TrackSampleTable(track2, jArr3, iArr, i5, jArrCopyOf, iArr3, Util2.F(j2 - j11, 1000000L, track2.c));
                                            trackSampleTable = trackSampleTable2;
                                        } else {
                                            boolean z10 = track2.f1230b == 1;
                                            int[] iArr10 = new int[jArr12.length];
                                            int[] iArr11 = new int[jArr12.length];
                                            long[] jArr14 = track2.i;
                                            Objects.requireNonNull(jArr14);
                                            int i41 = 0;
                                            boolean z11 = false;
                                            int i42 = 0;
                                            int i43 = 0;
                                            while (true) {
                                                long[] jArr15 = track2.h;
                                                if (i41 >= jArr15.length) {
                                                    break;
                                                }
                                                boolean z12 = z11;
                                                int i44 = i42;
                                                long j12 = jArr14[i41];
                                                if (j12 != -1) {
                                                    iArr5 = iArr11;
                                                    long jF6 = Util2.F(jArr15[i41], track2.c, track2.d);
                                                    iArr10[i41] = Util2.e(jArrCopyOf, j12, true, true);
                                                    iArr5[i41] = Util2.b(jArrCopyOf, j12 + jF6, z10, false);
                                                    while (iArr10[i41] < iArr5[i41] && (iArr3[iArr10[i41]] & 1) == 0) {
                                                        iArr10[i41] = iArr10[i41] + 1;
                                                    }
                                                    int i45 = (iArr5[i41] - iArr10[i41]) + i44;
                                                    boolean z13 = i43 != iArr10[i41];
                                                    i42 = i45;
                                                    i43 = iArr5[i41];
                                                    z11 = z12 | z13;
                                                } else {
                                                    iArr5 = iArr11;
                                                    i42 = i44;
                                                    z11 = z12;
                                                }
                                                i41++;
                                                iArr11 = iArr5;
                                            }
                                            int[] iArr12 = iArr11;
                                            boolean z14 = z11 | (i42 != iB);
                                            long[] jArr16 = z14 ? new long[i42] : jArr3;
                                            int[] iArr13 = z14 ? new int[i42] : iArr;
                                            int i46 = z14 ? 0 : i5;
                                            int[] iArr14 = z14 ? new int[i42] : iArr3;
                                            long[] jArr17 = new long[i42];
                                            int i47 = 0;
                                            int i48 = 0;
                                            long j13 = 0;
                                            while (i47 < track2.h.length) {
                                                long j14 = track2.i[i47];
                                                int i49 = iArr10[i47];
                                                int[] iArr15 = iArr10;
                                                int i50 = iArr12[i47];
                                                if (z14) {
                                                    i6 = i46;
                                                    int i51 = i50 - i49;
                                                    System.arraycopy(jArr3, i49, jArr16, i48, i51);
                                                    System.arraycopy(iArr, i49, iArr13, i48, i51);
                                                    jArr4 = jArr3;
                                                    iArr4 = iArr3;
                                                    System.arraycopy(iArr4, i49, iArr14, i48, i51);
                                                } else {
                                                    jArr4 = jArr3;
                                                    i6 = i46;
                                                    iArr4 = iArr3;
                                                }
                                                i46 = i6;
                                                while (i49 < i50) {
                                                    int[] iArr16 = iArr14;
                                                    int i52 = i50;
                                                    int[] iArr17 = iArr4;
                                                    long[] jArr18 = jArrCopyOf;
                                                    long j15 = j13;
                                                    jArr17[i48] = Util2.F(j13, 1000000L, track2.d) + Util2.F(Math.max(0L, jArrCopyOf[i49] - j14), 1000000L, track2.c);
                                                    if (z14 && iArr13[i48] > i46) {
                                                        i46 = iArr[i49];
                                                    }
                                                    i48++;
                                                    i49++;
                                                    iArr14 = iArr16;
                                                    j13 = j15;
                                                    jArrCopyOf = jArr18;
                                                    iArr4 = iArr17;
                                                    i50 = i52;
                                                }
                                                j13 += track2.h[i47];
                                                i47++;
                                                iArr10 = iArr15;
                                                iArr14 = iArr14;
                                                iArr3 = iArr4;
                                                jArr3 = jArr4;
                                            }
                                            trackSampleTable = new TrackSampleTable(track2, jArr16, iArr13, i46, jArr17, iArr14, Util2.F(j13, 1000000L, track2.d));
                                        }
                                    }
                                } else {
                                    parsableByteArray5 = null;
                                }
                            } else {
                                iW2 = 0;
                            }
                            iW3 = -1;
                            i = i10;
                            iA = dVar.a();
                            arrayList = arrayList3;
                            str = trackApply.f.w;
                            if (iA == -1) {
                                if (iA == -1 && ("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && iW6 == 0 && iW == 0 && iW2 == 0) {
                                }
                                long jF22 = Util2.F(j2, 1000000L, track2.c);
                                jArr2 = track2.h;
                                if (jArr2 != null) {
                                }
                            }
                        }
                        arrayList2 = arrayList;
                        arrayList2.add(trackSampleTable);
                    }
                } else {
                    Atom.b bVarC10 = aVar3.c(1953196132);
                    Objects.requireNonNull(bVarC10);
                    ParsableByteArray parsableByteArray8 = bVarC10.f1210b;
                    parsableByteArray8.E(8);
                    int iF5 = (parsableByteArray8.f() >> 24) & 255;
                    parsableByteArray8.F(iF5 != 0 ? 16 : 8);
                    int iF6 = parsableByteArray8.f();
                    parsableByteArray8.F(4);
                    int i53 = parsableByteArray8.f984b;
                    int i54 = iF5 == 0 ? 4 : 8;
                    int i55 = 0;
                    while (true) {
                        if (i55 >= i54) {
                            z7 = true;
                            break;
                        }
                        if (parsableByteArray8.a[i53 + i55] != -1) {
                            z7 = false;
                            break;
                        }
                        i55++;
                    }
                    if (z7) {
                        parsableByteArray8.F(i54);
                    } else {
                        jU = iF5 == 0 ? parsableByteArray8.u() : parsableByteArray8.x();
                        if (jU != 0) {
                            i7 = 16;
                        }
                        parsableByteArray8.F(i7);
                        int iF7 = parsableByteArray8.f();
                        int iF8 = parsableByteArray8.f();
                        parsableByteArray8.F(4);
                        int iF9 = parsableByteArray8.f();
                        int iF10 = parsableByteArray8.f();
                        int i56 = (iF7 != 0 && iF8 == 65536 && iF9 == -65536 && iF10 == 0) ? 90 : (iF7 != 0 && iF8 == -65536 && iF9 == 65536 && iF10 == 0) ? 270 : (iF7 != -65536 && iF8 == 0 && iF9 == 0 && iF10 == -65536) ? 180 : 0;
                        long j16 = j != -9223372036854775807L ? jU : j;
                        ParsableByteArray parsableByteArray9 = bVarC.f1210b;
                        parsableByteArray9.E(8);
                        parsableByteArray9.F(((parsableByteArray9.f() >> 24) & 255) != 0 ? 8 : 16);
                        long jU2 = parsableByteArray9.u();
                        long jF7 = j16 != -9223372036854775807L ? Util2.F(j16, 1000000L, jU2) : -9223372036854775807L;
                        Atom.a aVarB6 = aVarB2.b(1835626086);
                        Objects.requireNonNull(aVarB6);
                        Atom.a aVarB7 = aVarB6.b(1937007212);
                        Objects.requireNonNull(aVarB7);
                        Atom.b bVarC11 = aVarB2.c(1835296868);
                        Objects.requireNonNull(bVarC11);
                        ParsableByteArray parsableByteArray10 = bVarC11.f1210b;
                        parsableByteArray10.E(8);
                        int iF11 = (parsableByteArray10.f() >> 24) & 255;
                        parsableByteArray10.F(iF11 != 0 ? 8 : 16);
                        long jU3 = parsableByteArray10.u();
                        parsableByteArray10.F(iF11 != 0 ? 4 : 8);
                        int iY = parsableByteArray10.y();
                        StringBuilder sb3 = new StringBuilder(3);
                        sb3.append((char) (((iY >> 10) & 31) + 96));
                        sb3.append((char) (((iY >> 5) & 31) + 96));
                        sb3.append((char) ((iY & 31) + 96));
                        Pair pairCreate2 = Pair.create(Long.valueOf(jU3), sb3.toString());
                        Atom.b bVarC12 = aVarB7.c(1937011556);
                        Objects.requireNonNull(bVarC12);
                        bVarD = d(bVarC12.f1210b, iF6, i56, (String) pairCreate2.second, drmInitData, z3);
                        if (!z2 || (aVarB = aVar3.b(1701082227)) == null) {
                            jArr5 = null;
                            jArr6 = null;
                            if (bVarD.f1211b != null) {
                                Track track3 = new Track(iF6, i11, ((Long) pairCreate2.first).longValue(), jU2, jF7, bVarD.f1211b, bVarD.d, bVarD.a, bVarD.c, jArr5, jArr6);
                                function22 = function2;
                                track = track3;
                            }
                            trackApply = function22.apply(track);
                            if (trackApply == null) {
                            }
                        } else {
                            Atom.b bVarC13 = aVarB.c(1701606260);
                            if (bVarC13 == null) {
                                pairCreate = null;
                            } else {
                                ParsableByteArray parsableByteArray11 = bVarC13.f1210b;
                                parsableByteArray11.E(8);
                                int iF12 = (parsableByteArray11.f() >> 24) & 255;
                                int iW16 = parsableByteArray11.w();
                                long[] jArr19 = new long[iW16];
                                long[] jArr20 = new long[iW16];
                                int i57 = 0;
                                while (i57 < iW16) {
                                    jArr19[i57] = iF12 == 1 ? parsableByteArray11.x() : parsableByteArray11.u();
                                    if (iF12 == 1) {
                                        i9 = iW16;
                                        i8 = iF12;
                                        jF = parsableByteArray11.m();
                                    } else {
                                        i8 = iF12;
                                        i9 = iW16;
                                        jF = parsableByteArray11.f();
                                    }
                                    jArr20[i57] = jF;
                                    if (parsableByteArray11.p() != 1) {
                                        throw new IllegalArgumentException("Unsupported media rate.");
                                    }
                                    parsableByteArray11.F(2);
                                    i57++;
                                    iF12 = i8;
                                    iW16 = i9;
                                }
                                pairCreate = Pair.create(jArr19, jArr20);
                            }
                            if (pairCreate != null) {
                                long[] jArr21 = (long[]) pairCreate.first;
                                jArr6 = (long[]) pairCreate.second;
                                jArr5 = jArr21;
                            }
                            if (bVarD.f1211b != null) {
                            }
                            trackApply = function22.apply(track);
                            if (trackApply == null) {
                            }
                        }
                    }
                    i7 = 16;
                    jU = -9223372036854775807L;
                    parsableByteArray8.F(i7);
                    int iF72 = parsableByteArray8.f();
                    int iF82 = parsableByteArray8.f();
                    parsableByteArray8.F(4);
                    int iF92 = parsableByteArray8.f();
                    int iF102 = parsableByteArray8.f();
                    if (iF72 != 0) {
                        if (iF72 != 0) {
                            if (iF72 != -65536) {
                                if (j != -9223372036854775807L) {
                                }
                                ParsableByteArray parsableByteArray92 = bVarC.f1210b;
                                parsableByteArray92.E(8);
                                parsableByteArray92.F(((parsableByteArray92.f() >> 24) & 255) != 0 ? 8 : 16);
                                long jU22 = parsableByteArray92.u();
                                long jF72 = j16 != -9223372036854775807L ? Util2.F(j16, 1000000L, jU22) : -9223372036854775807L;
                                Atom.a aVarB62 = aVarB2.b(1835626086);
                                Objects.requireNonNull(aVarB62);
                                Atom.a aVarB72 = aVarB62.b(1937007212);
                                Objects.requireNonNull(aVarB72);
                                Atom.b bVarC112 = aVarB2.c(1835296868);
                                Objects.requireNonNull(bVarC112);
                                ParsableByteArray parsableByteArray102 = bVarC112.f1210b;
                                parsableByteArray102.E(8);
                                int iF112 = (parsableByteArray102.f() >> 24) & 255;
                                parsableByteArray102.F(iF112 != 0 ? 8 : 16);
                                long jU32 = parsableByteArray102.u();
                                parsableByteArray102.F(iF112 != 0 ? 4 : 8);
                                int iY2 = parsableByteArray102.y();
                                StringBuilder sb32 = new StringBuilder(3);
                                sb32.append((char) (((iY2 >> 10) & 31) + 96));
                                sb32.append((char) (((iY2 >> 5) & 31) + 96));
                                sb32.append((char) ((iY2 & 31) + 96));
                                Pair pairCreate22 = Pair.create(Long.valueOf(jU32), sb32.toString());
                                Atom.b bVarC122 = aVarB72.c(1937011556);
                                Objects.requireNonNull(bVarC122);
                                bVarD = d(bVarC122.f1210b, iF6, i56, (String) pairCreate22.second, drmInitData, z3);
                                if (z2) {
                                    jArr5 = null;
                                    jArr6 = null;
                                    if (bVarD.f1211b != null) {
                                    }
                                    trackApply = function22.apply(track);
                                    if (trackApply == null) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            i10 = i + 1;
            aVar2 = aVar;
            arrayList3 = arrayList2;
        }
        return arrayList3;
    }
}
