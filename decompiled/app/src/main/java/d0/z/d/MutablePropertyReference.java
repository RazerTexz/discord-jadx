package d0.z.d;

import kotlin.reflect.KProperty;

/* compiled from: MutablePropertyReference.java */
/* renamed from: d0.z.d.t, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class MutablePropertyReference extends PropertyReference implements KProperty {
    public MutablePropertyReference() {
    }

    public MutablePropertyReference(Object obj) {
        super(obj);
    }

    public MutablePropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
