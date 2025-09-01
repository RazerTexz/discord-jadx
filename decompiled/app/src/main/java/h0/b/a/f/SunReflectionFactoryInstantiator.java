package h0.b.a.f;

import h0.b.a.ObjectInstantiator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.objenesis.ObjenesisException;

/* compiled from: SunReflectionFactoryInstantiator.java */
/* renamed from: h0.b.a.f.a, reason: use source file name */
/* loaded from: classes3.dex */
public class SunReflectionFactoryInstantiator<T> implements ObjectInstantiator<T> {
    public final Constructor<T> a;

    public SunReflectionFactoryInstantiator(Class<T> cls) throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Constructor constructor = Object.class.getConstructor(null);
            try {
                Class<?> cls2 = Class.forName("sun.reflect.ReflectionFactory");
                try {
                    try {
                        try {
                            Constructor<T> constructor2 = (Constructor) cls2.getDeclaredMethod("newConstructorForSerialization", Class.class, Constructor.class).invoke(cls2.getDeclaredMethod("getReflectionFactory", new Class[0]).invoke(null, new Object[0]), cls, constructor);
                            this.a = constructor2;
                            constructor2.setAccessible(true);
                        } catch (IllegalAccessException e) {
                            throw new ObjenesisException(e);
                        } catch (IllegalArgumentException e2) {
                            throw new ObjenesisException(e2);
                        } catch (InvocationTargetException e3) {
                            throw new ObjenesisException(e3);
                        }
                    } catch (NoSuchMethodException e4) {
                        throw new ObjenesisException(e4);
                    }
                } catch (IllegalAccessException e5) {
                    throw new ObjenesisException(e5);
                } catch (IllegalArgumentException e6) {
                    throw new ObjenesisException(e6);
                } catch (NoSuchMethodException e7) {
                    throw new ObjenesisException(e7);
                } catch (InvocationTargetException e8) {
                    throw new ObjenesisException(e8);
                }
            } catch (ClassNotFoundException e9) {
                throw new ObjenesisException(e9);
            }
        } catch (NoSuchMethodException e10) {
            throw new ObjenesisException(e10);
        }
    }

    @Override // h0.b.a.ObjectInstantiator
    public T newInstance() {
        try {
            return this.a.newInstance(null);
        } catch (Exception e) {
            throw new ObjenesisException(e);
        }
    }
}
