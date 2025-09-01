package d0.e0.p.d.m0.m;

/* compiled from: SingleThreadValue.java */
/* renamed from: d0.e0.p.d.m0.m.m, reason: use source file name */
/* loaded from: classes3.dex */
public class SingleThreadValue<T> {
    public final T a;

    /* renamed from: b, reason: collision with root package name */
    public final Thread f3517b = Thread.currentThread();

    public SingleThreadValue(T t) {
        this.a = t;
    }

    public T getValue() {
        if (hasValue()) {
            return this.a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean hasValue() {
        return this.f3517b == Thread.currentThread();
    }
}
