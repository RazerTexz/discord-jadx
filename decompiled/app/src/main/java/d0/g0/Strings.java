package d0.g0;

import d0.d0._Ranges;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.Ranges2;
import kotlin.sequences.Sequence;

/* compiled from: Strings.kt */
/* renamed from: d0.g0.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class Strings implements Sequence<Ranges2> {
    public final CharSequence a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3580b;
    public final int c;
    public final Function2<CharSequence, Integer, Tuples2<Integer, Integer>> d;

    /* compiled from: Strings.kt */
    /* renamed from: d0.g0.d$a */
    public static final class a implements Iterator<Ranges2>, KMarkers {
        public int j = -1;
        public int k;
        public int l;
        public Ranges2 m;
        public int n;

        public a() {
            int iCoerceIn = _Ranges.coerceIn(Strings.access$getStartIndex$p(Strings.this), 0, Strings.access$getInput$p(Strings.this).length());
            this.k = iCoerceIn;
            this.l = iCoerceIn;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a() {
            Tuples2 tuples2;
            if (this.l < 0) {
                this.j = 0;
                this.m = null;
                return;
            }
            if (Strings.access$getLimit$p(Strings.this) > 0) {
                int i = this.n + 1;
                this.n = i;
                if (i >= Strings.access$getLimit$p(Strings.this)) {
                    this.m = new Ranges2(this.k, Strings4.getLastIndex(Strings.access$getInput$p(Strings.this)));
                    this.l = -1;
                } else if (this.l <= Strings.access$getInput$p(Strings.this).length() && (tuples2 = (Tuples2) Strings.access$getGetNextMatch$p(Strings.this).invoke(Strings.access$getInput$p(Strings.this), Integer.valueOf(this.l))) != null) {
                    int iIntValue = ((Number) tuples2.component1()).intValue();
                    int iIntValue2 = ((Number) tuples2.component2()).intValue();
                    this.m = _Ranges.until(this.k, iIntValue);
                    int i2 = iIntValue + iIntValue2;
                    this.k = i2;
                    this.l = i2 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.m = new Ranges2(this.k, Strings4.getLastIndex(Strings.access$getInput$p(Strings.this)));
                    this.l = -1;
                }
            }
            this.j = 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.j == -1) {
                a();
            }
            return this.j == 1;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Ranges2 next() {
            return next2();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        /* renamed from: next, reason: avoid collision after fix types in other method */
        public Ranges2 next2() {
            if (this.j == -1) {
                a();
            }
            if (this.j == 0) {
                throw new NoSuchElementException();
            }
            Ranges2 ranges2 = this.m;
            Objects.requireNonNull(ranges2, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.m = null;
            this.j = -1;
            return ranges2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Strings(CharSequence charSequence, int i, int i2, Function2<? super CharSequence, ? super Integer, Tuples2<Integer, Integer>> function2) {
        Intrinsics3.checkNotNullParameter(charSequence, "input");
        Intrinsics3.checkNotNullParameter(function2, "getNextMatch");
        this.a = charSequence;
        this.f3580b = i;
        this.c = i2;
        this.d = function2;
    }

    public static final /* synthetic */ Function2 access$getGetNextMatch$p(Strings strings) {
        return strings.d;
    }

    public static final /* synthetic */ CharSequence access$getInput$p(Strings strings) {
        return strings.a;
    }

    public static final /* synthetic */ int access$getLimit$p(Strings strings) {
        return strings.c;
    }

    public static final /* synthetic */ int access$getStartIndex$p(Strings strings) {
        return strings.f3580b;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Ranges2> iterator() {
        return new a();
    }
}
