package b.i.d.q;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator.java */
/* renamed from: b.i.d.q.u, reason: use source file name */
/* loaded from: classes3.dex */
public class UnsafeAllocator3 extends UnsafeAllocator5 {
    public final /* synthetic */ Method a;

    public UnsafeAllocator3(Method method) {
        this.a = method;
    }

    @Override // b.i.d.q.UnsafeAllocator5
    public <T> T b(Class<T> cls) throws Exception {
        UnsafeAllocator5.a(cls);
        return (T) this.a.invoke(null, cls, Object.class);
    }
}
