package d0.e0.p.d;

import d0.e0.p.d.KPropertyImpl;
import d0.e0.p.d.l0.CallerImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.jvm.functions.Function1;

/* compiled from: KPropertyImpl.kt */
/* renamed from: d0.e0.p.d.v, reason: use source file name */
/* loaded from: classes3.dex */
public final class KPropertyImpl4 extends Lambda implements Function1<Field, CallerImpl<? extends Field>> {
    public final /* synthetic */ boolean $isGetter;
    public final /* synthetic */ KPropertyImpl2 $isJvmStaticProperty$1;
    public final /* synthetic */ KPropertyImpl3 $isNotNullProperty$2;
    public final /* synthetic */ KPropertyImpl.a $this_computeCallerForAccessor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl4(KPropertyImpl.a aVar, boolean z2, KPropertyImpl3 kPropertyImpl3, KPropertyImpl2 kPropertyImpl2) {
        super(1);
        this.$this_computeCallerForAccessor = aVar;
        this.$isGetter = z2;
        this.$isNotNullProperty$2 = kPropertyImpl3;
        this.$isJvmStaticProperty$1 = kPropertyImpl2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CallerImpl<Field> invoke2(Field field) {
        Intrinsics3.checkNotNullParameter(field, "field");
        return (KPropertyImpl5.access$isJvmFieldPropertyInCompanionObject(this.$this_computeCallerForAccessor.getProperty().getDescriptor()) || !Modifier.isStatic(field.getModifiers())) ? this.$isGetter ? this.$this_computeCallerForAccessor.isBound() ? new CallerImpl.f.a(field, KPropertyImpl5.getBoundReceiver(this.$this_computeCallerForAccessor)) : new CallerImpl.f.c(field) : this.$this_computeCallerForAccessor.isBound() ? new CallerImpl.g.a(field, this.$isNotNullProperty$2.invoke2(), KPropertyImpl5.getBoundReceiver(this.$this_computeCallerForAccessor)) : new CallerImpl.g.c(field, this.$isNotNullProperty$2.invoke2()) : this.$isJvmStaticProperty$1.invoke2() ? this.$isGetter ? this.$this_computeCallerForAccessor.isBound() ? new CallerImpl.f.b(field) : new CallerImpl.f.d(field) : this.$this_computeCallerForAccessor.isBound() ? new CallerImpl.g.b(field, this.$isNotNullProperty$2.invoke2()) : new CallerImpl.g.d(field, this.$isNotNullProperty$2.invoke2()) : this.$isGetter ? new CallerImpl.f.e(field) : new CallerImpl.g.e(field, this.$isNotNullProperty$2.invoke2());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CallerImpl<? extends Field> invoke(Field field) {
        return invoke2(field);
    }
}
