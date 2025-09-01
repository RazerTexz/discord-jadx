package com.discord.widgets.search.results;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetSearchResultsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSearchResults.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSearchResultsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSearchResultsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.search.results.WidgetSearchResults$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSearchResults3 extends FunctionReferenceImpl implements Function1<View, WidgetSearchResultsBinding> {
    public static final WidgetSearchResults3 INSTANCE = new WidgetSearchResults3();

    public WidgetSearchResults3() {
        super(1, WidgetSearchResultsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSearchResultsBinding;", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSearchResultsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        RecyclerView recyclerView = (RecyclerView) view;
        return new WidgetSearchResultsBinding(recyclerView, recyclerView);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSearchResultsBinding invoke(View view) {
        return invoke2(view);
    }
}
