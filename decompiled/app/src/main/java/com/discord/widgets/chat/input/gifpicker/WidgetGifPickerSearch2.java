package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGifPickerSearchBinding;
import com.discord.views.SearchInputView;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGifPickerSearch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGifPickerSearchBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGifPickerSearchBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGifPickerSearch2 extends FunctionReferenceImpl implements Function1<View, WidgetGifPickerSearchBinding> {
    public static final WidgetGifPickerSearch2 INSTANCE = new WidgetGifPickerSearch2();

    public WidgetGifPickerSearch2() {
        super(1, WidgetGifPickerSearchBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGifPickerSearchBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGifPickerSearchBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGifPickerSearchBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.gif_search_app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.gif_search_app_bar);
        if (appBarLayout != null) {
            i = R.id.gif_search_gif_recycler;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.gif_search_gif_recycler);
            if (recyclerView != null) {
                i = R.id.gif_search_loading_view;
                GifLoadingView gifLoadingView = (GifLoadingView) view.findViewById(R.id.gif_search_loading_view);
                if (gifLoadingView != null) {
                    i = R.id.gif_search_toolbar;
                    Toolbar toolbar = (Toolbar) view.findViewById(R.id.gif_search_toolbar);
                    if (toolbar != null) {
                        i = R.id.gif_search_view_flipper;
                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.gif_search_view_flipper);
                        if (appViewFlipper != null) {
                            i = R.id.search_input;
                            SearchInputView searchInputView = (SearchInputView) view.findViewById(R.id.search_input);
                            if (searchInputView != null) {
                                return new WidgetGifPickerSearchBinding((CoordinatorLayout) view, appBarLayout, recyclerView, gifLoadingView, toolbar, appViewFlipper, searchInputView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
