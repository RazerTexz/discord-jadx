package b.i.b.b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractIterator.java */
/* renamed from: b.i.b.b.b, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractIterator2<T> extends UnmodifiableIterator<T> {
    public int j = 2;

    @NullableDecl
    public T k;

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final boolean hasNext() {
        T t;
        int i = this.j;
        if (!(i != 4)) {
            throw new IllegalStateException();
        }
        int iH = b.c.a.y.b.h(i);
        if (iH == 0) {
            return true;
        }
        if (iH == 2) {
            return false;
        }
        this.j = 4;
        Sets2 sets2 = (Sets2) this;
        while (true) {
            if (!sets2.l.hasNext()) {
                sets2.j = 3;
                t = null;
                break;
            }
            t = (T) sets2.l.next();
            if (sets2.m.k.contains(t)) {
                break;
            }
        }
        this.k = t;
        if (this.j == 3) {
            return false;
        }
        this.j = 1;
        return true;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.j = 2;
        T t = this.k;
        this.k = null;
        return t;
    }
}
