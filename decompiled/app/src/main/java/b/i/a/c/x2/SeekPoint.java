package b.i.a.c.x2;

import androidx.annotation.Nullable;
import b.d.b.a.outline;

/* compiled from: SeekPoint.java */
/* renamed from: b.i.a.c.x2.u, reason: use source file name */
/* loaded from: classes3.dex */
public final class SeekPoint {
    public static final SeekPoint a = new SeekPoint(0, 0);

    /* renamed from: b, reason: collision with root package name */
    public final long f1298b;
    public final long c;

    public SeekPoint(long j, long j2) {
        this.f1298b = j;
        this.c = j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SeekPoint.class != obj.getClass()) {
            return false;
        }
        SeekPoint seekPoint = (SeekPoint) obj;
        return this.f1298b == seekPoint.f1298b && this.c == seekPoint.c;
    }

    public int hashCode() {
        return (((int) this.f1298b) * 31) + ((int) this.c);
    }

    public String toString() {
        long j = this.f1298b;
        return outline.C(outline.R(60, "[timeUs=", j, ", position="), this.c, "]");
    }
}
