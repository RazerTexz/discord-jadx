package androidx.core.view;

import android.view.ViewParent;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: View.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public /* synthetic */ class ViewKt$ancestors$1 extends FunctionReferenceImpl implements Function1<ViewParent, ViewParent> {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    public ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ViewParent invoke2(ViewParent viewParent) {
        Intrinsics3.checkNotNullParameter(viewParent, "p0");
        return viewParent.getParent();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ViewParent invoke(ViewParent viewParent) {
        return invoke2(viewParent);
    }
}
