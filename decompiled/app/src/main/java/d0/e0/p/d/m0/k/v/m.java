package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.z.d.Intrinsics3;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public final class m extends p<Integer> {
    public m(int i) {
        super(Integer.valueOf(i));
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
        return getType(moduleDescriptor2);
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public KotlinType4 getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        KotlinType4 intType = moduleDescriptor2.getBuiltIns().getIntType();
        Intrinsics3.checkNotNullExpressionValue(intType, "module.builtIns.intType");
        return intType;
    }
}
