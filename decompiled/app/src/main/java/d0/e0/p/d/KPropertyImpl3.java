package d0.e0.p.d;

import d0.e0.p.d.KPropertyImpl;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: KPropertyImpl.kt */
/* renamed from: d0.e0.p.d.u, reason: use source file name */
/* loaded from: classes3.dex */
public final class KPropertyImpl3 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ KPropertyImpl.a $this_computeCallerForAccessor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl3(KPropertyImpl.a aVar) {
        super(0);
        this.$this_computeCallerForAccessor = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return !TypeUtils.isNullableType(this.$this_computeCallerForAccessor.getProperty().getDescriptor().getType());
    }
}
