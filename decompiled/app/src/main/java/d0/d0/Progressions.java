package d0.d0;

import d0.x.progressionUtil;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Progressions.kt */
/* renamed from: d0.d0.c, reason: use source file name */
/* loaded from: classes3.dex */
public class Progressions implements Iterable<Long>, KMarkers {
    public final long j;
    public final long k;
    public final long l;

    /* compiled from: Progressions.kt */
    /* renamed from: d0.d0.c$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
    }

    public Progressions(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.j = j;
        this.k = progressionUtil.getProgressionLastElement(j, j2, j3);
        this.l = j3;
    }

    public final long getFirst() {
        return this.j;
    }

    public final long getLast() {
        return this.k;
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Long> iterator2() {
        return iterator();
    }

    @Override // java.lang.Iterable
    public Iterator<Long> iterator() {
        return new ProgressionIterators2(this.j, this.k, this.l);
    }
}
