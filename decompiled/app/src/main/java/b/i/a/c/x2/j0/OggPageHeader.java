package b.i.a.c.x2.j0;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.ExtractorInput;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;

/* compiled from: OggPageHeader.java */
/* renamed from: b.i.a.c.x2.j0.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class OggPageHeader {
    public int a;

    /* renamed from: b, reason: collision with root package name */
    public int f1238b;
    public long c;
    public int d;
    public int e;
    public int f;
    public final int[] g = new int[255];
    public final ParsableByteArray h = new ParsableByteArray(255);

    public boolean a(ExtractorInput extractorInput, boolean z2) throws IOException {
        b();
        this.h.A(27);
        if (!AnimatableValueParser.x1(extractorInput, this.h.a, 0, 27, z2) || this.h.u() != 1332176723) {
            return false;
        }
        int iT = this.h.t();
        this.a = iT;
        if (iT != 0) {
            if (z2) {
                return false;
            }
            throw ParserException.b("unsupported bit stream revision");
        }
        this.f1238b = this.h.t();
        ParsableByteArray parsableByteArray = this.h;
        byte[] bArr = parsableByteArray.a;
        int i = parsableByteArray.f984b + 1;
        parsableByteArray.f984b = i;
        long j = bArr[r3] & 255;
        int i2 = i + 1;
        parsableByteArray.f984b = i2;
        int i3 = i2 + 1;
        parsableByteArray.f984b = i3;
        long j2 = j | ((bArr[i] & 255) << 8) | ((bArr[i2] & 255) << 16);
        int i4 = i3 + 1;
        parsableByteArray.f984b = i4;
        long j3 = j2 | ((bArr[i3] & 255) << 24);
        int i5 = i4 + 1;
        parsableByteArray.f984b = i5;
        long j4 = j3 | ((bArr[i4] & 255) << 32);
        int i6 = i5 + 1;
        parsableByteArray.f984b = i6;
        long j5 = j4 | ((bArr[i5] & 255) << 40);
        int i7 = i6 + 1;
        parsableByteArray.f984b = i7;
        parsableByteArray.f984b = i7 + 1;
        this.c = j5 | ((bArr[i6] & 255) << 48) | ((bArr[i7] & 255) << 56);
        parsableByteArray.j();
        this.h.j();
        this.h.j();
        int iT2 = this.h.t();
        this.d = iT2;
        this.e = iT2 + 27;
        this.h.A(iT2);
        if (!AnimatableValueParser.x1(extractorInput, this.h.a, 0, this.d, z2)) {
            return false;
        }
        for (int i8 = 0; i8 < this.d; i8++) {
            this.g[i8] = this.h.t();
            this.f += this.g[i8];
        }
        return true;
    }

    public void b() {
        this.a = 0;
        this.f1238b = 0;
        this.c = 0L;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
    
        if (r10 == (-1)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        if (r9.getPosition() >= r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
    
        if (r9.h(1) == (-1)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(ExtractorInput extractorInput, long j) throws IOException {
        AnimatableValueParser.j(extractorInput.getPosition() == extractorInput.f());
        this.h.A(4);
        while (true) {
            if ((j != -1 && extractorInput.getPosition() + 4 >= j) || !AnimatableValueParser.x1(extractorInput, this.h.a, 0, 4, true)) {
                break;
            }
            this.h.E(0);
            if (this.h.u() == 1332176723) {
                extractorInput.k();
                return true;
            }
            extractorInput.l(1);
        }
    }
}
