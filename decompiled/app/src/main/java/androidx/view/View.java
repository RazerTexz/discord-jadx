package androidx.view;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: View.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/view/View;", "Landroidx/savedstate/SavedStateRegistryOwner;", "findViewTreeSavedStateRegistryOwner", "(Landroid/view/View;)Landroidx/savedstate/SavedStateRegistryOwner;", "savedstate-ktx_release"}, k = 2, mv = {1, 4, 1})
/* renamed from: androidx.savedstate.ViewKt, reason: from Kotlin metadata */
/* loaded from: classes.dex */
public final class View {
    public static final SavedStateRegistryOwner findViewTreeSavedStateRegistryOwner(android.view.View view) {
        Intrinsics3.checkNotNullParameter(view, "$this$findViewTreeSavedStateRegistryOwner");
        return ViewTreeSavedStateRegistryOwner.get(view);
    }
}
