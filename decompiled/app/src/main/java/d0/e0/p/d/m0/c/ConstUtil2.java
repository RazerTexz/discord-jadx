package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.b.UnsignedType3;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.z.d.Intrinsics3;

/* compiled from: ConstUtil.kt */
/* renamed from: d0.e0.p.d.m0.c.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class ConstUtil2 {
    /* JADX WARN: Removed duplicated region for block: B:6:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean canBeUsedForConstVal(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        if (!KotlinBuiltIns.isPrimitiveType(kotlinType)) {
            UnsignedType3 unsignedType3 = UnsignedType3.a;
            if (UnsignedType3.isUnsignedType(kotlinType)) {
                if (TypeUtils.isNullableType(kotlinType)) {
                    if (!KotlinBuiltIns.isString(kotlinType)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
