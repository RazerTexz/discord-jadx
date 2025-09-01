package com.discord.widgets.search;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import com.discord.R;
import com.discord.databinding.WidgetSearchBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSearch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSearchBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSearchBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.search.WidgetSearch$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSearch3 extends FunctionReferenceImpl implements Function1<View, WidgetSearchBinding> {
    public static final WidgetSearch3 INSTANCE = new WidgetSearch3();

    public WidgetSearch3() {
        super(1, WidgetSearchBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSearchBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSearchBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSearchBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.search_send_query_fab;
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.search_send_query_fab);
        if (floatingActionButton != null) {
            i = R.id.widget_search_input;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.widget_search_input);
            if (textInputLayout != null) {
                i = R.id.widget_search_results;
                FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.widget_search_results);
                if (fragmentContainerView != null) {
                    i = R.id.widget_search_suggestions;
                    FragmentContainerView fragmentContainerView2 = (FragmentContainerView) view.findViewById(R.id.widget_search_suggestions);
                    if (fragmentContainerView2 != null) {
                        return new WidgetSearchBinding((CoordinatorLayout) view, floatingActionButton, textInputLayout, fragmentContainerView, fragmentContainerView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
