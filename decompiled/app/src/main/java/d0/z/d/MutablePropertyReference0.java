package d0.z.d;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty4;
import kotlin.reflect.KProperty5;
import kotlin.reflect.KProperty6;

/* compiled from: MutablePropertyReference0.java */
/* renamed from: d0.z.d.p, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements KProperty5 {
    public MutablePropertyReference0() {
    }

    @Override // d0.z.d.CallableReference
    public KCallable computeReflected() {
        return Reflection2.mutableProperty0(this);
    }

    @Override // kotlin.reflect.KProperty6
    public Object getDelegate() {
        return ((KProperty5) getReflected()).getDelegate();
    }

    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return mo112getGetter();
    }

    public /* bridge */ /* synthetic */ KProperty4 getSetter() {
        return mo113getSetter();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.KProperty6
    /* renamed from: getGetter, reason: collision with other method in class */
    public KProperty6.Getter mo112getGetter() {
        return ((KProperty5) getReflected()).mo112getGetter();
    }

    @Override // kotlin.reflect.KProperty5
    /* renamed from: getSetter, reason: collision with other method in class */
    public KProperty5.Setter mo113getSetter() {
        return ((KProperty5) getReflected()).mo113getSetter();
    }

    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
