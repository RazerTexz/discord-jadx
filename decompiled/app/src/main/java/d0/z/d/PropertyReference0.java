package d0.z.d;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty6;

/* compiled from: PropertyReference0.java */
/* renamed from: d0.z.d.v, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class PropertyReference0 extends PropertyReference implements KProperty6 {
    public PropertyReference0() {
    }

    @Override // d0.z.d.CallableReference
    public KCallable computeReflected() {
        return Reflection2.property0(this);
    }

    @Override // kotlin.reflect.KProperty6
    public Object getDelegate() {
        return ((KProperty6) getReflected()).getDelegate();
    }

    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return mo112getGetter();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.KProperty6
    /* renamed from: getGetter */
    public KProperty6.Getter mo112getGetter() {
        return ((KProperty6) getReflected()).mo112getGetter();
    }

    public PropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
