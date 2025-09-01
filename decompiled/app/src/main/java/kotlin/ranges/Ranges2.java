package kotlin.ranges;

import d0.d0.Range3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Ranges.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001bB\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001c"}, d2 = {"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Ld0/d0/a;", "", "value", "", "contains", "(I)Z", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getStart", "()Ljava/lang/Integer;", "start", "getEndInclusive", "endInclusive", "<init>", "(II)V", "o", "a", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* renamed from: kotlin.ranges.IntRange, reason: use source file name */
/* loaded from: classes3.dex */
public final class Ranges2 extends Progressions2 implements Range3<Integer> {

    /* renamed from: o, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Ranges2 n = new Ranges2(1, 0);

    /* compiled from: Ranges.kt */
    /* renamed from: kotlin.ranges.IntRange$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Ranges2 getEMPTY() {
            return Ranges2.access$getEMPTY$cp();
        }
    }

    public Ranges2(int i, int i2) {
        super(i, i2, 1);
    }

    public static final /* synthetic */ Ranges2 access$getEMPTY$cp() {
        return n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.d0.Range3
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).intValue());
    }

    @Override // kotlin.ranges.Progressions2
    public boolean equals(Object other) {
        if (other instanceof Ranges2) {
            if (!isEmpty() || !((Ranges2) other).isEmpty()) {
                Ranges2 ranges2 = (Ranges2) other;
                if (getFirst() != ranges2.getFirst() || getLast() != ranges2.getLast()) {
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

    @Override // kotlin.ranges.Progressions2
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // kotlin.ranges.Progressions2
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // kotlin.ranges.Progressions2
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    public boolean contains(int value) {
        return getFirst() <= value && value <= getLast();
    }

    @Override // d0.d0.Range3
    public Integer getEndInclusive() {
        return Integer.valueOf(getLast());
    }

    @Override // d0.d0.Range3
    public Integer getStart() {
        return Integer.valueOf(getFirst());
    }
}
