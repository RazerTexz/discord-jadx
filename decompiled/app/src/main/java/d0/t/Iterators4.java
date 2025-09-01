package d0.t;

import d0.z.d.g0.KMarkers;
import java.util.Iterator;

/* compiled from: Iterators.kt */
/* renamed from: d0.t.c0, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Iterators4 implements Iterator<Integer>, KMarkers {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Integer next() {
        return next();
    }

    public abstract int nextInt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Integer next() {
        return Integer.valueOf(nextInt());
    }
}
