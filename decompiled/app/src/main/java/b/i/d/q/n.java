package b.i.d.q;

import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ConstructorConstructor.java */
/* loaded from: classes3.dex */
public class n<T> implements ObjectConstructor<T> {
    public n(g gVar) {
    }

    @Override // b.i.d.q.ObjectConstructor
    public T a() {
        return (T) new ConcurrentSkipListMap();
    }
}
