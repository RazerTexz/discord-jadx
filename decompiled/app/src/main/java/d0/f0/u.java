package d0.f0;

import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class u<T, R> implements Sequence<R> {
    public final Sequence<T> a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1<T, R> f3578b;

    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<R>, KMarkers {
        public final Iterator<T> j;

        public a() {
            this.j = u.access$getSequence$p(u.this).iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) u.access$getTransformer$p(u.this).invoke(this.j.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "sequence");
        Intrinsics3.checkNotNullParameter(function1, "transformer");
        this.a = sequence;
        this.f3578b = function1;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(u uVar) {
        return uVar.a;
    }

    public static final /* synthetic */ Function1 access$getTransformer$p(u uVar) {
        return uVar.f3578b;
    }

    public final <E> Sequence<E> flatten$kotlin_stdlib(Function1<? super R, ? extends Iterator<? extends E>> function1) {
        Intrinsics3.checkNotNullParameter(function1, "iterator");
        return new h(this.a, this.f3578b, function1);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<R> iterator() {
        return new a();
    }
}
