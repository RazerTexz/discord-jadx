package d0.f0;

import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class t<T> implements Sequence<T> {
    public final Sequence<T> a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1<T, Boolean> f3577b;

    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, KMarkers {
        public final Iterator<T> j;
        public int k = -1;
        public T l;

        public a() {
            this.j = t.access$getSequence$p(t.this).iterator();
        }

        public final void a() {
            if (this.j.hasNext()) {
                T next = this.j.next();
                if (((Boolean) t.access$getPredicate$p(t.this).invoke(next)).booleanValue()) {
                    this.k = 1;
                    this.l = next;
                    return;
                }
            }
            this.k = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.k == -1) {
                a();
            }
            return this.k == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.k == -1) {
                a();
            }
            if (this.k == 0) {
                throw new NoSuchElementException();
            }
            T t = this.l;
            this.l = null;
            this.k = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "sequence");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        this.a = sequence;
        this.f3577b = function1;
    }

    public static final /* synthetic */ Function1 access$getPredicate$p(t tVar) {
        return tVar.f3577b;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(t tVar) {
        return tVar.a;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a();
    }
}
