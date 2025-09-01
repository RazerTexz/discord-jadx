package b.i.a.c.x2.k0;

import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.t2.Ac3Util;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.k0.TsPayloadReader;
import java.io.IOException;

/* compiled from: Ac3Extractor.java */
/* renamed from: b.i.a.c.x2.k0.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class Ac3Extractor implements Extractor {
    public final Ac3Reader a = new Ac3Reader(null);

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f1247b = new ParsableByteArray(2786);
    public boolean c;

    static {
        a aVar = a.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003d, code lost:
    
        if ((r5 - r3) < 8192) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0034, code lost:
    
        r14.k();
        r5 = r5 + 1;
     */
    @Override // b.i.a.c.x2.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(ExtractorInput extractorInput) throws IOException {
        int iA;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int i = 0;
        while (true) {
            extractorInput.o(parsableByteArray.a, 0, 10);
            parsableByteArray.E(0);
            if (parsableByteArray.v() != 4801587) {
                break;
            }
            parsableByteArray.F(3);
            int iS = parsableByteArray.s();
            i += iS + 10;
            extractorInput.g(iS);
        }
        extractorInput.k();
        extractorInput.g(i);
        int i2 = i;
        while (true) {
            int i3 = 0;
            while (true) {
                extractorInput.o(parsableByteArray.a, 0, 6);
                parsableByteArray.E(0);
                if (parsableByteArray.y() != 2935) {
                    break;
                }
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] bArr = parsableByteArray.a;
                if (bArr.length < 6) {
                    iA = -1;
                } else {
                    iA = ((bArr[5] & 248) >> 3) > 10 ? ((((bArr[2] & 7) << 8) | (bArr[3] & 255)) + 1) * 2 : Ac3Util.a((bArr[4] & 192) >> 6, bArr[4] & 63);
                }
                if (iA == -1) {
                    return false;
                }
                extractorInput.g(iA - 6);
            }
            extractorInput.g(i2);
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i = extractorInput.read(this.f1247b.a, 0, 2786);
        if (i == -1) {
            return -1;
        }
        this.f1247b.E(0);
        this.f1247b.D(i);
        if (!this.c) {
            this.a.f(0L, 4);
            this.c = true;
        }
        this.a.b(this.f1247b);
        return 0;
    }

    @Override // b.i.a.c.x2.Extractor
    public void f(ExtractorOutput extractorOutput) {
        this.a.e(extractorOutput, new TsPayloadReader.d(Integer.MIN_VALUE, 0, 1));
        extractorOutput.j();
        extractorOutput.a(new SeekMap.b(-9223372036854775807L, 0L));
    }

    @Override // b.i.a.c.x2.Extractor
    public void g(long j, long j2) {
        this.c = false;
        this.a.c();
    }

    @Override // b.i.a.c.x2.Extractor
    public void release() {
    }
}
