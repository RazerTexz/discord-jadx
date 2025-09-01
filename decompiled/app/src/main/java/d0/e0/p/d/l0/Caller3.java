package d0.e0.p.d.l0;

import d0.z.d.Intrinsics3;

/* compiled from: Caller.kt */
/* renamed from: d0.e0.p.d.l0.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class Caller3 {
    public static final int getArity(Caller2<?> caller2) {
        Intrinsics3.checkNotNullParameter(caller2, "$this$arity");
        return caller2.getParameterTypes().size();
    }
}
