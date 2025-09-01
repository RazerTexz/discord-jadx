package b.i.a.c.e3.b0;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import java.io.File;

/* compiled from: CacheSpan.java */
/* renamed from: b.i.a.c.e3.b0.h, reason: use source file name */
/* loaded from: classes3.dex */
public class CacheSpan implements Comparable<CacheSpan> {
    public final String j;
    public final long k;
    public final long l;
    public final boolean m;

    @Nullable
    public final File n;
    public final long o;

    public CacheSpan(String str, long j, long j2, long j3, @Nullable File file) {
        this.j = str;
        this.k = j;
        this.l = j2;
        this.m = file != null;
        this.n = file;
        this.o = j3;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CacheSpan cacheSpan) {
        return f(cacheSpan);
    }

    public int f(CacheSpan cacheSpan) {
        if (!this.j.equals(cacheSpan.j)) {
            return this.j.compareTo(cacheSpan.j);
        }
        long j = this.k - cacheSpan.k;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }

    public String toString() {
        long j = this.k;
        return outline.C(outline.R(44, "[", j, ", "), this.l, "]");
    }
}
