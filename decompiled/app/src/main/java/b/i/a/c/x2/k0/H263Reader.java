package b.i.a.c.x2.k0;

import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* compiled from: H263Reader.java */
/* renamed from: b.i.a.c.x2.k0.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class H263Reader implements ElementaryStreamReader {
    public static final float[] a = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final UserDataReader f1269b;
    public b g;
    public long h;
    public String i;
    public TrackOutput2 j;
    public boolean k;
    public final boolean[] d = new boolean[4];
    public final a e = new a(128);
    public long l = -9223372036854775807L;

    @Nullable
    public final NalUnitTargetBuffer f = new NalUnitTargetBuffer(Opcodes.GETSTATIC, 128);

    @Nullable
    public final ParsableByteArray c = new ParsableByteArray();

    /* compiled from: H263Reader.java */
    /* renamed from: b.i.a.c.x2.k0.q$a */
    public static final class a {
        public static final byte[] a = {0, 0, 1};

        /* renamed from: b, reason: collision with root package name */
        public boolean f1270b;
        public int c;
        public int d;
        public int e;
        public byte[] f;

        public a(int i) {
            this.f = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.f1270b) {
                int i3 = i2 - i;
                byte[] bArr2 = this.f;
                int length = bArr2.length;
                int i4 = this.d;
                if (length < i4 + i3) {
                    this.f = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f, this.d, i3);
                this.d += i3;
            }
        }

        public void b() {
            this.f1270b = false;
            this.d = 0;
            this.c = 0;
        }
    }

    /* compiled from: H263Reader.java */
    /* renamed from: b.i.a.c.x2.k0.q$b */
    public static final class b {
        public final TrackOutput2 a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1271b;
        public boolean c;
        public boolean d;
        public int e;
        public int f;
        public long g;
        public long h;

        public b(TrackOutput2 trackOutput2) {
            this.a = trackOutput2;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.c) {
                int i3 = this.f;
                int i4 = (i + 1) - i3;
                if (i4 >= i2) {
                    this.f = (i2 - i) + i3;
                } else {
                    this.d = ((bArr[i4] & 192) >> 6) == 0;
                    this.c = false;
                }
            }
        }
    }

    public H263Reader(@Nullable UserDataReader userDataReader) {
        this.f1269b = userDataReader;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x022d  */
    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        int i3;
        boolean z2;
        float f;
        AnimatableValueParser.H(this.g);
        AnimatableValueParser.H(this.j);
        int i4 = parsableByteArray.f984b;
        int i5 = parsableByteArray.c;
        byte[] bArr = parsableByteArray.a;
        this.h += parsableByteArray.a();
        this.j.c(parsableByteArray, parsableByteArray.a());
        while (true) {
            int iB = NalUnitUtil.b(bArr, i4, i5, this.d);
            if (iB == i5) {
                if (!this.k) {
                    this.e.a(bArr, i4, i5);
                }
                this.g.a(bArr, i4, i5);
                NalUnitTargetBuffer nalUnitTargetBuffer = this.f;
                if (nalUnitTargetBuffer != null) {
                    nalUnitTargetBuffer.a(bArr, i4, i5);
                    return;
                }
                return;
            }
            int i6 = iB + 3;
            int i7 = parsableByteArray.a[i6] & 255;
            int i8 = iB - i4;
            if (this.k) {
                i = i5;
                i2 = i6;
            } else {
                if (i8 > 0) {
                    this.e.a(bArr, i4, iB);
                }
                int i9 = i8 < 0 ? -i8 : 0;
                a aVar = this.e;
                int i10 = aVar.c;
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 != 3) {
                                if (i10 != 4) {
                                    throw new IllegalStateException();
                                }
                                if (i7 == 179 || i7 == 181) {
                                    aVar.d -= i9;
                                    aVar.f1270b = false;
                                    z2 = true;
                                }
                                if (!z2) {
                                    TrackOutput2 trackOutput2 = this.j;
                                    a aVar2 = this.e;
                                    int i11 = aVar2.e;
                                    String str = this.i;
                                    Objects.requireNonNull(str);
                                    byte[] bArrCopyOf = Arrays.copyOf(aVar2.f, aVar2.d);
                                    ParsableBitArray parsableBitArray = new ParsableBitArray(bArrCopyOf);
                                    parsableBitArray.n(i11);
                                    parsableBitArray.n(4);
                                    parsableBitArray.l();
                                    parsableBitArray.m(8);
                                    if (parsableBitArray.f()) {
                                        parsableBitArray.m(4);
                                        parsableBitArray.m(3);
                                    }
                                    int iG = parsableBitArray.g(4);
                                    i2 = i6;
                                    if (iG == 15) {
                                        int iG2 = parsableBitArray.g(8);
                                        int iG3 = parsableBitArray.g(8);
                                        if (iG3 == 0) {
                                            Log.w("H263Reader", "Invalid aspect ratio");
                                            i = i5;
                                            f = 1.0f;
                                            if (parsableBitArray.f()) {
                                                parsableBitArray.m(2);
                                                parsableBitArray.m(1);
                                                if (parsableBitArray.f()) {
                                                    parsableBitArray.m(15);
                                                    parsableBitArray.l();
                                                    parsableBitArray.m(15);
                                                    parsableBitArray.l();
                                                    parsableBitArray.m(15);
                                                    parsableBitArray.l();
                                                    parsableBitArray.m(3);
                                                    parsableBitArray.m(11);
                                                    parsableBitArray.l();
                                                    parsableBitArray.m(15);
                                                    parsableBitArray.l();
                                                }
                                            }
                                            if (parsableBitArray.g(2) != 0) {
                                                Log.w("H263Reader", "Unhandled video object layer shape");
                                            }
                                            parsableBitArray.l();
                                            int iG4 = parsableBitArray.g(16);
                                            parsableBitArray.l();
                                            if (parsableBitArray.f()) {
                                                if (iG4 == 0) {
                                                    Log.w("H263Reader", "Invalid vop_increment_time_resolution");
                                                } else {
                                                    int i12 = 0;
                                                    for (int i13 = iG4 - 1; i13 > 0; i13 >>= 1) {
                                                        i12++;
                                                    }
                                                    parsableBitArray.m(i12);
                                                }
                                            }
                                            parsableBitArray.l();
                                            int iG5 = parsableBitArray.g(13);
                                            parsableBitArray.l();
                                            int iG6 = parsableBitArray.g(13);
                                            parsableBitArray.l();
                                            parsableBitArray.l();
                                            Format2.b bVar = new Format2.b();
                                            bVar.a = str;
                                            bVar.k = "video/mp4v-es";
                                            bVar.p = iG5;
                                            bVar.q = iG6;
                                            bVar.t = f;
                                            bVar.m = Collections.singletonList(bArrCopyOf);
                                            trackOutput2.e(bVar.a());
                                            this.k = true;
                                        } else {
                                            f = iG2 / iG3;
                                            i = i5;
                                            if (parsableBitArray.f()) {
                                            }
                                            if (parsableBitArray.g(2) != 0) {
                                            }
                                            parsableBitArray.l();
                                            int iG42 = parsableBitArray.g(16);
                                            parsableBitArray.l();
                                            if (parsableBitArray.f()) {
                                            }
                                            parsableBitArray.l();
                                            int iG52 = parsableBitArray.g(13);
                                            parsableBitArray.l();
                                            int iG62 = parsableBitArray.g(13);
                                            parsableBitArray.l();
                                            parsableBitArray.l();
                                            Format2.b bVar2 = new Format2.b();
                                            bVar2.a = str;
                                            bVar2.k = "video/mp4v-es";
                                            bVar2.p = iG52;
                                            bVar2.q = iG62;
                                            bVar2.t = f;
                                            bVar2.m = Collections.singletonList(bArrCopyOf);
                                            trackOutput2.e(bVar2.a());
                                            this.k = true;
                                        }
                                    } else {
                                        float[] fArr = a;
                                        i = i5;
                                        if (iG < fArr.length) {
                                            f = fArr[iG];
                                            if (parsableBitArray.f()) {
                                            }
                                            if (parsableBitArray.g(2) != 0) {
                                            }
                                            parsableBitArray.l();
                                            int iG422 = parsableBitArray.g(16);
                                            parsableBitArray.l();
                                            if (parsableBitArray.f()) {
                                            }
                                            parsableBitArray.l();
                                            int iG522 = parsableBitArray.g(13);
                                            parsableBitArray.l();
                                            int iG622 = parsableBitArray.g(13);
                                            parsableBitArray.l();
                                            parsableBitArray.l();
                                            Format2.b bVar22 = new Format2.b();
                                            bVar22.a = str;
                                            bVar22.k = "video/mp4v-es";
                                            bVar22.p = iG522;
                                            bVar22.q = iG622;
                                            bVar22.t = f;
                                            bVar22.m = Collections.singletonList(bArrCopyOf);
                                            trackOutput2.e(bVar22.a());
                                            this.k = true;
                                        } else {
                                            Log.w("H263Reader", "Invalid aspect ratio");
                                            f = 1.0f;
                                            if (parsableBitArray.f()) {
                                            }
                                            if (parsableBitArray.g(2) != 0) {
                                            }
                                            parsableBitArray.l();
                                            int iG4222 = parsableBitArray.g(16);
                                            parsableBitArray.l();
                                            if (parsableBitArray.f()) {
                                            }
                                            parsableBitArray.l();
                                            int iG5222 = parsableBitArray.g(13);
                                            parsableBitArray.l();
                                            int iG6222 = parsableBitArray.g(13);
                                            parsableBitArray.l();
                                            parsableBitArray.l();
                                            Format2.b bVar222 = new Format2.b();
                                            bVar222.a = str;
                                            bVar222.k = "video/mp4v-es";
                                            bVar222.p = iG5222;
                                            bVar222.q = iG6222;
                                            bVar222.t = f;
                                            bVar222.m = Collections.singletonList(bArrCopyOf);
                                            trackOutput2.e(bVar222.a());
                                            this.k = true;
                                        }
                                    }
                                }
                            } else if ((i7 & 240) != 32) {
                                Log.w("H263Reader", "Unexpected start code value");
                                aVar.b();
                            } else {
                                aVar.e = aVar.d;
                                aVar.c = 4;
                            }
                        } else if (i7 > 31) {
                            Log.w("H263Reader", "Unexpected start code value");
                            aVar.b();
                        } else {
                            aVar.c = 3;
                        }
                    } else if (i7 != 181) {
                        Log.w("H263Reader", "Unexpected start code value");
                        aVar.b();
                    } else {
                        aVar.c = 2;
                    }
                } else if (i7 == 176) {
                    aVar.c = 1;
                    aVar.f1270b = true;
                }
                byte[] bArr2 = a.a;
                aVar.a(bArr2, 0, bArr2.length);
                z2 = false;
                if (!z2) {
                }
            }
            this.g.a(bArr, i4, iB);
            NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f;
            if (nalUnitTargetBuffer2 != null) {
                if (i8 > 0) {
                    nalUnitTargetBuffer2.a(bArr, i4, iB);
                    i3 = 0;
                } else {
                    i3 = -i8;
                }
                if (this.f.b(i3)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f;
                    int iF = NalUnitUtil.f(nalUnitTargetBuffer3.d, nalUnitTargetBuffer3.e);
                    ParsableByteArray parsableByteArray2 = this.c;
                    int i14 = Util2.a;
                    parsableByteArray2.C(this.f.d, iF);
                    this.f1269b.a(this.l, this.c);
                }
                if (i7 == 178) {
                    if (parsableByteArray.a[iB + 2] == 1) {
                        this.f.d(i7);
                    }
                }
            }
            int i15 = i - iB;
            long j = this.h - i15;
            b bVar3 = this.g;
            boolean z3 = this.k;
            if (bVar3.e == 182 && z3 && bVar3.f1271b) {
                long j2 = bVar3.h;
                if (j2 != -9223372036854775807L) {
                    bVar3.a.d(j2, bVar3.d ? 1 : 0, (int) (j - bVar3.g), i15, null);
                }
            }
            if (bVar3.e != 179) {
                bVar3.g = j;
            }
            b bVar4 = this.g;
            long j3 = this.l;
            bVar4.e = i7;
            bVar4.d = false;
            bVar4.f1271b = i7 == 182 || i7 == 179;
            bVar4.c = i7 == 182;
            bVar4.f = 0;
            bVar4.h = j3;
            i5 = i;
            i4 = i2;
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void c() {
        NalUnitUtil.a(this.d);
        this.e.b();
        b bVar = this.g;
        if (bVar != null) {
            bVar.f1271b = false;
            bVar.c = false;
            bVar.d = false;
            bVar.e = -1;
        }
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.c();
        }
        this.h = 0L;
        this.l = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.a();
        this.i = dVar.b();
        TrackOutput2 trackOutput2P = extractorOutput.p(dVar.c(), 2);
        this.j = trackOutput2P;
        this.g = new b(trackOutput2P);
        UserDataReader userDataReader = this.f1269b;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, dVar);
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }
}
