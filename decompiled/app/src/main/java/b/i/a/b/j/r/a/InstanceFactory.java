package b.i.a.b.j.r.a;

import c0.a.Provider3;

/* compiled from: InstanceFactory.java */
/* renamed from: b.i.a.b.j.r.a.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class InstanceFactory<T> implements Provider3 {
    public final T a;

    public InstanceFactory(T t) {
        this.a = t;
    }

    @Override // c0.a.Provider3
    public T get() {
        return this.a;
    }
}
