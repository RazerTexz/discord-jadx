package d0.z.d;

import d0.e0.KClass;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: MutablePropertyReference0Impl.java */
/* renamed from: d0.z.d.q, reason: use source file name */
/* loaded from: classes3.dex */
public class MutablePropertyReference0Impl extends MutablePropertyReference0 {
    public MutablePropertyReference0Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    public Object get() {
        return mo112getGetter().call(new Object[0]);
    }

    public void set(Object obj) {
        mo113getSetter().call(obj);
    }

    public MutablePropertyReference0Impl(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    public MutablePropertyReference0Impl(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
