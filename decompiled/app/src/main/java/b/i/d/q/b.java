package b.i.d.q;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ConstructorConstructor.java */
/* loaded from: classes3.dex */
public class b<T> implements ObjectConstructor<T> {
    public b(g gVar) {
    }

    @Override // b.i.d.q.ObjectConstructor
    public T a() {
        return (T) new ConcurrentHashMap();
    }
}
