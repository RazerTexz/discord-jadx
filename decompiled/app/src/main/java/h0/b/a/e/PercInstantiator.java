package h0.b.a.e;

import h0.b.a.ObjectInstantiator;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;

/* compiled from: PercInstantiator.java */
/* renamed from: h0.b.a.e.a, reason: use source file name */
/* loaded from: classes3.dex */
public class PercInstantiator<T> implements ObjectInstantiator<T> {
    public final Method a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f3732b;

    public PercInstantiator(Class<T> cls) throws NoSuchMethodException, SecurityException {
        Object[] objArr = {null, Boolean.FALSE};
        this.f3732b = objArr;
        objArr[0] = cls;
        try {
            Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Boolean.TYPE);
            this.a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new ObjenesisException(e);
        } catch (RuntimeException e2) {
            throw new ObjenesisException(e2);
        }
    }

    @Override // h0.b.a.ObjectInstantiator
    public T newInstance() {
        try {
            return (T) this.a.invoke(null, this.f3732b);
        } catch (Exception e) {
            throw new ObjenesisException(e);
        }
    }
}
