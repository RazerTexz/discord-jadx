package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetGifPickerBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGifPicker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGifPickerBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGifPickerBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPicker$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGifPicker2 extends FunctionReferenceImpl implements Function1<View, WidgetGifPickerBinding> {
    public static final WidgetGifPicker2 INSTANCE = new WidgetGifPicker2();

    public WidgetGifPicker2() {
        super(1, WidgetGifPickerBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGifPickerBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGifPickerBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGifPickerBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.gif_picker_category_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.gif_picker_category_recycler);
        if (recyclerView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            GifLoadingView gifLoadingView = (GifLoadingView) view.findViewById(R.id.gif_picker_loading_view);
            if (gifLoadingView != null) {
                return new WidgetGifPickerBinding(frameLayout, recyclerView, frameLayout, gifLoadingView);
            }
            i = R.id.gif_picker_loading_view;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
