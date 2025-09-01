package h0.b.a.b;

import h0.b.a.ObjectInstantiator;
import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;

/* compiled from: Android17Instantiator.java */
/* renamed from: h0.b.a.b.b, reason: use source file name */
/* loaded from: classes3.dex */
public class Android17Instantiator<T> implements ObjectInstantiator<T> {
    public final Class<T> a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f3729b;
    public final Integer c;

    public Android17Instantiator(Class<T> cls) throws NoSuchMethodException, SecurityException {
        this.a = cls;
        try {
            Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod.setAccessible(true);
            this.f3729b = declaredMethod;
            try {
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod2.setAccessible(true);
                this.c = (Integer) declaredMethod2.invoke(null, Object.class);
            } catch (IllegalAccessException e) {
                throw new ObjenesisException(e);
            } catch (NoSuchMethodException e2) {
                throw new ObjenesisException(e2);
            } catch (RuntimeException e3) {
                throw new ObjenesisException(e3);
            } catch (InvocationTargetException e4) {
                throw new ObjenesisException(e4);
            }
        } catch (NoSuchMethodException e5) {
            throw new ObjenesisException(e5);
        } catch (RuntimeException e6) {
            throw new ObjenesisException(e6);
        }
    }

    @Override // h0.b.a.ObjectInstantiator
    public T newInstance() {
        try {
            Class<T> cls = this.a;
            return cls.cast(this.f3729b.invoke(null, cls, this.c));
        } catch (Exception e) {
            throw new ObjenesisException(e);
        }
    }
}
