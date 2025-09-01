package b.i.a.c.x2.k0;

import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.k0.TsPayloadReader;
import java.io.IOException;

/* compiled from: Ac4Extractor.java */
/* renamed from: b.i.a.c.x2.k0.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class Ac4Extractor implements Extractor {
    public final Ac4Reader a = new Ac4Reader(null);

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f1251b = new ParsableByteArray(16384);
    public boolean c;

    static {
        b bVar = b.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        r15.k();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
    
        if ((r4 - r3) < 8192) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
    
        return false;
     */
    @Override // b.i.a.c.x2.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(ExtractorInput extractorInput) throws IOException {
        int i;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int i2 = 0;
        while (true) {
            extractorInput.o(parsableByteArray.a, 0, 10);
            parsableByteArray.E(0);
            if (parsableByteArray.v() != 4801587) {
                break;
            }
            parsableByteArray.F(3);
            int iS = parsableByteArray.s();
            i2 += iS + 10;
            extractorInput.g(iS);
        }
        extractorInput.k();
        extractorInput.g(i2);
        int i3 = i2;
        while (true) {
            int i4 = 0;
            while (true) {
                int i5 = 7;
                extractorInput.o(parsableByteArray.a, 0, 7);
                parsableByteArray.E(0);
                int iY = parsableByteArray.y();
                if (iY != 44096 && iY != 44097) {
                    break;
                }
                i4++;
                if (i4 >= 4) {
                    return true;
                }
                byte[] bArr = parsableByteArray.a;
                if (bArr.length < 7) {
                    i = -1;
                } else {
                    int i6 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                    if (i6 == 65535) {
                        i6 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
                    } else {
                        i5 = 4;
                    }
                    if (iY == 44097) {
                        i5 += 2;
                    }
                    i = i6 + i5;
                }
                if (i == -1) {
                    return false;
                }
                extractorInput.g(i - 7);
            }
            extractorInput.g(i3);
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i = extractorInput.read(this.f1251b.a, 0, 16384);
        if (i == -1) {
            return -1;
        }
        this.f1251b.E(0);
        this.f1251b.D(i);
        if (!this.c) {
            this.a.f(0L, 4);
            this.c = true;
        }
        this.a.b(this.f1251b);
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
