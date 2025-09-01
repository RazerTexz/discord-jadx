package d0.e0.p.d.m0.n;

import d0.z.d.Intrinsics3;

/* compiled from: dynamicTypes.kt */
/* renamed from: d0.e0.p.d.m0.n.r, reason: use source file name */
/* loaded from: classes3.dex */
public final class dynamicTypes2 {
    public static final boolean isDynamic(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.unwrap() instanceof dynamicTypes;
    }
}
