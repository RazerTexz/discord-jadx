package kotlin.ranges;

import d0.d0.Progressions;
import d0.d0.Range3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Ranges.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u001b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001cB\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001d"}, d2 = {"Lkotlin/ranges/LongRange;", "Ld0/d0/c;", "Ld0/d0/a;", "", "value", "", "contains", "(J)Z", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getStart", "()Ljava/lang/Long;", "start", "getEndInclusive", "endInclusive", "<init>", "(JJ)V", "n", "a", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* renamed from: kotlin.ranges.LongRange, reason: use source file name */
/* loaded from: classes3.dex */
public final class Ranges3 extends Progressions implements Range3<Long> {

    /* renamed from: n, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Ranges3 m = new Ranges3(1, 0);

    /* compiled from: Ranges.kt */
    /* renamed from: kotlin.ranges.LongRange$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Ranges3 getEMPTY() {
            return Ranges3.access$getEMPTY$cp();
        }
    }

    public Ranges3(long j, long j2) {
        super(j, j2, 1L);
    }

    public static final /* synthetic */ Ranges3 access$getEMPTY$cp() {
        return m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.d0.Range3
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).longValue());
    }

    public boolean equals(Object other) {
        if (other instanceof Ranges3) {
            if (!isEmpty() || !((Ranges3) other).isEmpty()) {
                Ranges3 ranges3 = (Ranges3) other;
                if (getFirst() != ranges3.getFirst() || getLast() != ranges3.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // d0.d0.Range3
    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return getEndInclusive();
    }

    @Override // d0.d0.Range3
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return getStart();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (getFirst() ^ (getFirst() >>> 32))) + (getLast() ^ (getLast() >>> 32)));
    }

    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    public String toString() {
        return getFirst() + ".." + getLast();
    }

    public boolean contains(long value) {
        return getFirst() <= value && value <= getLast();
    }

    @Override // d0.d0.Range3
    public Long getEndInclusive() {
        return Long.valueOf(getLast());
    }

    @Override // d0.d0.Range3
    public Long getStart() {
        return Long.valueOf(getFirst());
    }
}
