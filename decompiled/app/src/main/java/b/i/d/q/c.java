package b.i.d.q;

import java.util.TreeMap;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ConstructorConstructor.java */
/* loaded from: classes3.dex */
public class c<T> implements ObjectConstructor<T> {
    public c(g gVar) {
    }

    @Override // b.i.d.q.ObjectConstructor
    public T a() {
        return (T) new TreeMap();
    }
}
