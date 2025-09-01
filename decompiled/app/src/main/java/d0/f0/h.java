package d0.f0;

import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class h<T, R, E> implements Sequence<E> {
    public final Sequence<T> a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1<T, R> f3572b;
    public final Function1<R, Iterator<E>> c;

    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<E>, KMarkers {
        public final Iterator<T> j;
        public Iterator<? extends E> k;

        public a() {
            this.j = h.access$getSequence$p(h.this).iterator();
        }

        public final boolean a() {
            Iterator<? extends E> it = this.k;
            if (it != null && !it.hasNext()) {
                this.k = null;
            }
            while (true) {
                if (this.k != null) {
                    break;
                }
                if (!this.j.hasNext()) {
                    return false;
                }
                Iterator<? extends E> it2 = (Iterator) h.access$getIterator$p(h.this).invoke(h.access$getTransformer$p(h.this).invoke(this.j.next()));
                if (it2.hasNext()) {
                    this.k = it2;
                    break;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return a();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends E> it = this.k;
            Intrinsics3.checkNotNull(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1, Function1<? super R, ? extends Iterator<? extends E>> function12) {
        Intrinsics3.checkNotNullParameter(sequence, "sequence");
        Intrinsics3.checkNotNullParameter(function1, "transformer");
        Intrinsics3.checkNotNullParameter(function12, "iterator");
        this.a = sequence;
        this.f3572b = function1;
        this.c = function12;
    }

    public static final /* synthetic */ Function1 access$getIterator$p(h hVar) {
        return hVar.c;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(h hVar) {
        return hVar.a;
    }

    public static final /* synthetic */ Function1 access$getTransformer$p(h hVar) {
        return hVar.f3572b;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<E> iterator() {
        return new a();
    }
}
