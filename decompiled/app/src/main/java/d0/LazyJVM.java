package d0;

import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;

/* compiled from: LazyJVM.kt */
/* renamed from: d0.g, reason: use source file name */
/* loaded from: classes3.dex */
public class LazyJVM {
    public static final <T> Lazy<T> lazy(Function0<? extends T> function0) {
        Intrinsics3.checkNotNullParameter(function0, "initializer");
        return new LazyJVM3(function0, null, 2, null);
    }

    public static final <T> Lazy<T> lazy(Lazy5 lazy5, Function0<? extends T> function0) {
        Intrinsics3.checkNotNullParameter(lazy5, "mode");
        Intrinsics3.checkNotNullParameter(function0, "initializer");
        int iOrdinal = lazy5.ordinal();
        if (iOrdinal == 0) {
            return new LazyJVM3(function0, null, 2, null);
        }
        if (iOrdinal == 1) {
            return new LazyJVM2(function0);
        }
        if (iOrdinal == 2) {
            return new Lazy7(function0);
        }
        throw new NoWhenBranchMatchedException();
    }
}
