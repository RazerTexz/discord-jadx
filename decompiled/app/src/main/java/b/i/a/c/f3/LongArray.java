package b.i.a.c.f3;

import b.d.b.a.outline;
import java.util.Arrays;

/* compiled from: LongArray.java */
/* renamed from: b.i.a.c.f3.r, reason: use source file name */
/* loaded from: classes3.dex */
public final class LongArray {
    public int a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f975b = new long[32];

    public void a(long j) {
        int i = this.a;
        long[] jArr = this.f975b;
        if (i == jArr.length) {
            this.f975b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.f975b;
        int i2 = this.a;
        this.a = i2 + 1;
        jArr2[i2] = j;
    }

    public long b(int i) {
        if (i < 0 || i >= this.a) {
            throw new IndexOutOfBoundsException(outline.h(46, "Invalid index ", i, ", size is ", this.a));
        }
        return this.f975b[i];
    }
}
