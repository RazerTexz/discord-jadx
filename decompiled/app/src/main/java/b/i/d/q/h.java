package b.i.d.q;

import b.d.b.a.outline;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ConstructorConstructor.java */
/* loaded from: classes3.dex */
public class h<T> implements ObjectConstructor<T> {
    public final /* synthetic */ Constructor a;

    public h(g gVar, Constructor constructor) {
        this.a = constructor;
    }

    @Override // b.i.d.q.ObjectConstructor
    public T a() {
        try {
            return (T) this.a.newInstance(null);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            StringBuilder sbU = outline.U("Failed to invoke ");
            sbU.append(this.a);
            sbU.append(" with no args");
            throw new RuntimeException(sbU.toString(), e2);
        } catch (InvocationTargetException e3) {
            StringBuilder sbU2 = outline.U("Failed to invoke ");
            sbU2.append(this.a);
            sbU2.append(" with no args");
            throw new RuntimeException(sbU2.toString(), e3.getTargetException());
        }
    }
}
