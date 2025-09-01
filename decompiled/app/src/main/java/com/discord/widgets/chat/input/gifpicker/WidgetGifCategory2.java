package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetGifCategoryBinding;
import com.discord.utilities.views.ContentResizingCoordinatorLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGifCategory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGifCategoryBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGifCategoryBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGifCategory2 extends FunctionReferenceImpl implements Function1<View, WidgetGifCategoryBinding> {
    public static final WidgetGifCategory2 INSTANCE = new WidgetGifCategory2();

    public WidgetGifCategory2() {
        super(1, WidgetGifCategoryBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGifCategoryBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGifCategoryBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGifCategoryBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        ContentResizingCoordinatorLayout contentResizingCoordinatorLayout = (ContentResizingCoordinatorLayout) view;
        int i = R.id.gif_category_gif_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.gif_category_gif_recycler);
        if (recyclerView != null) {
            i = R.id.gif_category_loading_view;
            GifLoadingView gifLoadingView = (GifLoadingView) view.findViewById(R.id.gif_category_loading_view);
            if (gifLoadingView != null) {
                i = R.id.gif_category_title;
                TextView textView = (TextView) view.findViewById(R.id.gif_category_title);
                if (textView != null) {
                    return new WidgetGifCategoryBinding((ContentResizingCoordinatorLayout) view, contentResizingCoordinatorLayout, recyclerView, gifLoadingView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
