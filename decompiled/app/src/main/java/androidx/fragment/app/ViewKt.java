package androidx.fragment.app;

import android.view.View;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: View.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/fragment/app/Fragment;", "F", "Landroid/view/View;", "findFragment", "(Landroid/view/View;)Landroidx/fragment/app/Fragment;", "fragment-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class ViewKt {
    public static final <F extends Fragment> F findFragment(View view) {
        Intrinsics3.checkNotNullParameter(view, "$this$findFragment");
        F f = (F) FragmentManager.findFragment(view);
        Intrinsics3.checkNotNullExpressionValue(f, "FragmentManager.findFragment(this)");
        return f;
    }
}
