package d0.z.d;

import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ArrayIterator.kt */
/* renamed from: d0.z.d.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class ArrayIterator3<T> implements Iterator<T>, KMarkers {
    public int j;
    public final T[] k;

    public ArrayIterator3(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "array");
        this.k = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.j < this.k.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.k;
            int i = this.j;
            this.j = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.j--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
