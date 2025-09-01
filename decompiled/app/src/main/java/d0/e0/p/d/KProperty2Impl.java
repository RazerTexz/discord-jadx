package d0.e0.p.d;

import d0.e0.p.d.KPropertyImpl;
import d0.e0.p.d.ReflectProperties;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty4;
import kotlin.reflect.full.exceptions;

/* compiled from: KProperty2Impl.kt */
/* renamed from: d0.e0.p.d.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class KProperty2Impl<D, E, V> extends KProperty2Impl2<D, E, V> implements KProperty, Function2 {
    public final ReflectProperties.b<a<D, E, V>> w;

    /* compiled from: KProperty2Impl.kt */
    /* renamed from: d0.e0.p.d.m$a */
    public static final class a<D, E, V> extends KPropertyImpl.d<V> implements KProperty4, Function3 {
        public final KProperty2Impl<D, E, V> q;

        public a(KProperty2Impl<D, E, V> kProperty2Impl) {
            Intrinsics3.checkNotNullParameter(kProperty2Impl, "property");
            this.q = kProperty2Impl;
        }

        @Override // d0.e0.p.d.KPropertyImpl.a
        public KProperty2Impl<D, E, V> getProperty() {
            return this.q;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) throws exceptions {
            m81invoke((a<D, E, V>) obj, obj2, obj3);
            return Unit.a;
        }

        @Override // d0.e0.p.d.KPropertyImpl.a
        public /* bridge */ /* synthetic */ KPropertyImpl getProperty() {
            return getProperty();
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public void m81invoke(D d, E e, V v) throws exceptions {
            getProperty().set(d, e, v);
        }
    }

    /* compiled from: KProperty2Impl.kt */
    /* renamed from: d0.e0.p.d.m$b */
    public static final class b extends Lambda implements Function0<a<D, E, V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<D, E, V> invoke() {
            return new a<>(KProperty2Impl.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty2Impl(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
        ReflectProperties.b<a<D, E, V>> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.w = bVarLazy;
    }

    public a<D, E, V> getSetter() {
        a<D, E, V> aVarInvoke = this.w.invoke();
        Intrinsics3.checkNotNullExpressionValue(aVarInvoke, "_setter()");
        return aVarInvoke;
    }

    public void set(D d, E e, V v) throws exceptions {
        getSetter().call(d, e, v);
    }
}
