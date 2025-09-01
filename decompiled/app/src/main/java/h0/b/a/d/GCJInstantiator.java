package h0.b.a.d;

import java.lang.reflect.InvocationTargetException;
import org.objenesis.ObjenesisException;

/* compiled from: GCJInstantiator.java */
/* renamed from: h0.b.a.d.a, reason: use source file name */
/* loaded from: classes3.dex */
public class GCJInstantiator<T> extends GCJInstantiatorBase<T> {
    public GCJInstantiator(Class<T> cls) {
        super(cls);
    }

    @Override // h0.b.a.ObjectInstantiator
    public T newInstance() {
        try {
            Class<T> cls = this.c;
            return cls.cast(GCJInstantiatorBase.a.invoke(GCJInstantiatorBase.f3731b, cls, Object.class));
        } catch (IllegalAccessException e) {
            throw new ObjenesisException(e);
        } catch (RuntimeException e2) {
            throw new ObjenesisException(e2);
        } catch (InvocationTargetException e3) {
            throw new ObjenesisException(e3);
        }
    }
}
