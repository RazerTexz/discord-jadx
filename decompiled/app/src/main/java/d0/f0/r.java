package d0.f0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.sequences.Sequence;

/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class r<T> implements Sequence<T>, e<T> {
    public final Sequence<T> a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3575b;
    public final int c;

    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, KMarkers {
        public final Iterator<T> j;
        public int k;

        public a() {
            this.j = r.access$getSequence$p(r.this).iterator();
        }

        public final void a() {
            while (this.k < r.access$getStartIndex$p(r.this) && this.j.hasNext()) {
                this.j.next();
                this.k++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.k < r.access$getEndIndex$p(r.this) && this.j.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (this.k >= r.access$getEndIndex$p(r.this)) {
                throw new NoSuchElementException();
            }
            this.k++;
            return this.j.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(Sequence<? extends T> sequence, int i, int i2) {
        Intrinsics3.checkNotNullParameter(sequence, "sequence");
        this.a = sequence;
        this.f3575b = i;
        this.c = i2;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(outline.q("startIndex should be non-negative, but is ", i).toString());
        }
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(outline.q("endIndex should be non-negative, but is ", i2).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(outline.s("endIndex should be not less than startIndex, but was ", i2, " < ", i).toString());
        }
    }

    public static final /* synthetic */ int access$getEndIndex$p(r rVar) {
        return rVar.c;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(r rVar) {
        return rVar.a;
    }

    public static final /* synthetic */ int access$getStartIndex$p(r rVar) {
        return rVar.f3575b;
    }

    @Override // d0.f0.e
    public Sequence<T> drop(int i) {
        int i2 = this.c;
        int i3 = this.f3575b;
        return i >= i2 - i3 ? n.emptySequence() : new r(this.a, i3 + i, i2);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a();
    }

    @Override // d0.f0.e
    public Sequence<T> take(int i) {
        int i2 = this.c;
        int i3 = this.f3575b;
        return i >= i2 - i3 ? this : new r(this.a, i3, i + i3);
    }
}
