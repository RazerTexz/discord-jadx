package b.i.d.q;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator.java */
/* renamed from: b.i.d.q.t, reason: use source file name */
/* loaded from: classes3.dex */
public class UnsafeAllocator2 extends UnsafeAllocator5 {
    public final /* synthetic */ Method a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1812b;

    public UnsafeAllocator2(Method method, int i) {
        this.a = method;
        this.f1812b = i;
    }

    @Override // b.i.d.q.UnsafeAllocator5
    public <T> T b(Class<T> cls) throws Exception {
        UnsafeAllocator5.a(cls);
        return (T) this.a.invoke(null, cls, Integer.valueOf(this.f1812b));
    }
}
