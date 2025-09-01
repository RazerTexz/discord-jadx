package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.KPropertyImpl;
import d0.e0.p.d.ReflectProperties;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty5;
import kotlin.reflect.full.exceptions;

/* compiled from: KProperty0Impl.kt */
/* renamed from: d0.e0.p.d.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class KProperty0Impl<V> extends KProperty0Impl2<V> implements KProperty5<V> {
    public final ReflectProperties.b<a<V>> w;

    /* compiled from: KProperty0Impl.kt */
    /* renamed from: d0.e0.p.d.k$a */
    public static final class a<R> extends KPropertyImpl.d<R> implements KProperty5.Setter<R> {
        public final KProperty0Impl<R> q;

        public a(KProperty0Impl<R> kProperty0Impl) {
            Intrinsics3.checkNotNullParameter(kProperty0Impl, "property");
            this.q = kProperty0Impl;
        }

        @Override // d0.e0.p.d.KPropertyImpl.a
        public KProperty0Impl<R> getProperty() {
            return this.q;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) throws exceptions {
            invoke2((a<R>) obj);
            return Unit.a;
        }

        @Override // d0.e0.p.d.KPropertyImpl.a
        public /* bridge */ /* synthetic */ KPropertyImpl getProperty() {
            return getProperty();
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(R r) throws exceptions {
            getProperty().set(r);
        }
    }

    /* compiled from: KProperty0Impl.kt */
    /* renamed from: d0.e0.p.d.k$b */
    public static final class b extends Lambda implements Function0<a<V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<V> invoke() {
            return new a<>(KProperty0Impl.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty0Impl(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
        ReflectProperties.b<a<V>> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.w = bVarLazy;
    }

    @Override // kotlin.reflect.KProperty5
    /* renamed from: getSetter */
    public /* bridge */ /* synthetic */ KProperty5.Setter mo113getSetter() {
        return mo113getSetter();
    }

    public void set(V v) throws exceptions {
        mo113getSetter().call(v);
    }

    @Override // kotlin.reflect.KProperty5
    /* renamed from: getSetter */
    public a<V> mo113getSetter() {
        a<V> aVarInvoke = this.w.invoke();
        Intrinsics3.checkNotNullExpressionValue(aVarInvoke, "_setter()");
        return aVarInvoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty0Impl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "signature");
        ReflectProperties.b<a<V>> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.w = bVarLazy;
    }
}
