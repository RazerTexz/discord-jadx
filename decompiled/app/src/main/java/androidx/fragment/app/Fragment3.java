package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: Fragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
/* renamed from: androidx.fragment.app.FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0, reason: use source file name */
/* loaded from: classes.dex */
public final class Fragment3 implements FragmentResultListener {
    private final /* synthetic */ Function2 function;

    public Fragment3(Function2 function2) {
        this.function = function2;
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public final /* synthetic */ void onFragmentResult(@NonNull String str, @NonNull Bundle bundle) {
        Intrinsics3.checkNotNullParameter(str, "p0");
        Intrinsics3.checkNotNullParameter(bundle, "p1");
        Intrinsics3.checkNotNullExpressionValue(this.function.invoke(str, bundle), "invoke(...)");
    }
}
