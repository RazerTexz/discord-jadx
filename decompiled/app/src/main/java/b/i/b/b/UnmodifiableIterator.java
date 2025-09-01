package b.i.b.b;

import java.util.Iterator;

/* compiled from: UnmodifiableIterator.java */
/* renamed from: b.i.b.b.s0, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class UnmodifiableIterator<E> implements Iterator<E> {
    @Override // java.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
