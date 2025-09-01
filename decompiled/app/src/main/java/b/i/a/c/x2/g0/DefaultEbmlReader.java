package b.i.a.c.x2.g0;

import b.i.a.c.x2.ExtractorInput;
import java.io.IOException;
import java.util.ArrayDeque;

/* compiled from: DefaultEbmlReader.java */
/* renamed from: b.i.a.c.x2.g0.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultEbmlReader implements EbmlReader {
    public final byte[] a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque<b> f1183b = new ArrayDeque<>();
    public final VarintReader c = new VarintReader();
    public EbmlProcessor d;
    public int e;
    public int f;
    public long g;

    /* compiled from: DefaultEbmlReader.java */
    /* renamed from: b.i.a.c.x2.g0.b$b */
    public static final class b {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final long f1184b;

        public b(int i, long j, a aVar) {
            this.a = i;
            this.f1184b = j;
        }
    }

    public final long a(ExtractorInput extractorInput, int i) throws IOException {
        extractorInput.readFully(this.a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.a[i2] & 255);
        }
        return j;
    }
}
