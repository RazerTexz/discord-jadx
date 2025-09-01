package androidx.view;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: LifecycleOwner.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "getLifecycleScope", "(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 4, 1})
/* renamed from: androidx.lifecycle.LifecycleOwnerKt, reason: use source file name */
/* loaded from: classes.dex */
public final class LifecycleOwner2 {
    public static final Lifecycle2 getLifecycleScope(LifecycleOwner lifecycleOwner) {
        Intrinsics3.checkNotNullParameter(lifecycleOwner, "$this$lifecycleScope");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "lifecycle");
        return Lifecycle4.getCoroutineScope(lifecycle);
    }
}
