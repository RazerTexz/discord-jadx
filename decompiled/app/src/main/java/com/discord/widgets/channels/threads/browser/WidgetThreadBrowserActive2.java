package com.discord.widgets.channels.threads.browser;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.ThreadBrowserEmptyBinding;
import com.discord.R;
import com.discord.databinding.WidgetThreadBrowserActiveBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetThreadBrowserActive.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetThreadBrowserActiveBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserActiveBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActive$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowserActive2 extends FunctionReferenceImpl implements Function1<View, WidgetThreadBrowserActiveBinding> {
    public static final WidgetThreadBrowserActive2 INSTANCE = new WidgetThreadBrowserActive2();

    public WidgetThreadBrowserActive2() {
        super(1, WidgetThreadBrowserActiveBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserActiveBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetThreadBrowserActiveBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetThreadBrowserActiveBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.empty_view;
        View viewFindViewById = view.findViewById(R.id.empty_view);
        if (viewFindViewById != null) {
            ThreadBrowserEmptyBinding threadBrowserEmptyBindingA = ThreadBrowserEmptyBinding.a(viewFindViewById);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                return new WidgetThreadBrowserActiveBinding((ConstraintLayout) view, threadBrowserEmptyBindingA, recyclerView);
            }
            i = R.id.recycler_view;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
