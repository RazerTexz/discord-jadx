package b.i.a.c.x2.j0;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.j0.StreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: OpusReader.java */
/* renamed from: b.i.a.c.x2.j0.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class OpusReader extends StreamReader {
    public static final byte[] n = {79, 112, 117, 115, 72, 101, 97, 100};
    public boolean o;

    @Override // b.i.a.c.x2.j0.StreamReader
    public long c(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.a;
        int i = bArr[0] & 255;
        int i2 = i & 3;
        int i3 = 2;
        if (i2 == 0) {
            i3 = 1;
        } else if (i2 != 1 && i2 != 2) {
            i3 = bArr[1] & 63;
        }
        int i4 = i >> 3;
        return a(i3 * (i4 >= 16 ? 2500 << r1 : i4 >= 12 ? 10000 << (r1 & 1) : (i4 & 3) == 3 ? 60000 : 10000 << r1));
    }

    @Override // b.i.a.c.x2.j0.StreamReader
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean d(ParsableByteArray parsableByteArray, long j, StreamReader.b bVar) {
        if (this.o) {
            Objects.requireNonNull(bVar.a);
            boolean z2 = parsableByteArray.f() == 1332770163;
            parsableByteArray.E(0);
            return z2;
        }
        byte[] bArrCopyOf = Arrays.copyOf(parsableByteArray.a, parsableByteArray.c);
        int i = bArrCopyOf[9] & 255;
        List<byte[]> listG = AnimatableValueParser.g(bArrCopyOf);
        Format2.b bVar2 = new Format2.b();
        bVar2.k = "audio/opus";
        bVar2.f1023x = i;
        bVar2.f1024y = 48000;
        bVar2.m = listG;
        bVar.a = bVar2.a();
        this.o = true;
        return true;
    }

    @Override // b.i.a.c.x2.j0.StreamReader
    public void e(boolean z2) {
        super.e(z2);
        if (z2) {
            this.o = false;
        }
    }
}
