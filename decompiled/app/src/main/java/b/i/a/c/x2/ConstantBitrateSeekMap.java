package b.i.a.c.x2;

import b.i.a.c.x2.SeekMap;

/* compiled from: ConstantBitrateSeekMap.java */
/* renamed from: b.i.a.c.x2.d, reason: use source file name */
/* loaded from: classes3.dex */
public class ConstantBitrateSeekMap implements SeekMap {
    public final long a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1167b;
    public final int c;
    public final long d;
    public final int e;
    public final long f;
    public final boolean g;

    public ConstantBitrateSeekMap(long j, long j2, int i, int i2, boolean z2) {
        this.a = j;
        this.f1167b = j2;
        this.c = i2 == -1 ? 1 : i2;
        this.e = i;
        this.g = z2;
        if (j == -1) {
            this.d = -1L;
            this.f = -9223372036854775807L;
        } else {
            this.d = j - j2;
            this.f = e(j, j2, i);
        }
    }

    public static long e(long j, long j2, int i) {
        return ((Math.max(0L, j - j2) * 8) * 1000000) / i;
    }

    public long b(long j) {
        return e(j, this.f1167b, this.e);
    }

    @Override // b.i.a.c.x2.SeekMap
    public boolean c() {
        return this.d != -1 || this.g;
    }

    @Override // b.i.a.c.x2.SeekMap
    public SeekMap.a h(long j) {
        long j2 = this.d;
        if (j2 == -1 && !this.g) {
            return new SeekMap.a(new SeekPoint(0L, this.f1167b));
        }
        long j3 = this.c;
        long jMin = (((this.e * j) / 8000000) / j3) * j3;
        if (j2 != -1) {
            jMin = Math.min(jMin, j2 - j3);
        }
        long jMax = this.f1167b + Math.max(jMin, 0L);
        long jB = b(jMax);
        SeekPoint seekPoint = new SeekPoint(jB, jMax);
        if (this.d != -1 && jB < j) {
            int i = this.c;
            if (i + jMax < this.a) {
                long j4 = jMax + i;
                return new SeekMap.a(seekPoint, new SeekPoint(b(j4), j4));
            }
        }
        return new SeekMap.a(seekPoint);
    }

    @Override // b.i.a.c.x2.SeekMap
    public long i() {
        return this.f;
    }
}
