package com.discord.widgets.guild_role_subscriptions;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetPriceTierPickerBottomSheetBinding;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetPriceTierPickerBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetPriceTierPickerBottomSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetPriceTierPickerBottomSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.WidgetPriceTierPickerBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetPriceTierPickerBottomSheet5 extends FunctionReferenceImpl implements Function1<View, WidgetPriceTierPickerBottomSheetBinding> {
    public static final WidgetPriceTierPickerBottomSheet5 INSTANCE = new WidgetPriceTierPickerBottomSheet5();

    public WidgetPriceTierPickerBottomSheet5() {
        super(1, WidgetPriceTierPickerBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPriceTierPickerBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetPriceTierPickerBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetPriceTierPickerBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.price_tier_picker_app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.price_tier_picker_app_bar);
        if (appBarLayout != null) {
            i = R.id.price_tier_picker_app_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.price_tier_picker_app_flipper);
            if (appViewFlipper != null) {
                i = R.id.price_tier_picker_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.price_tier_picker_recycler);
                if (recyclerView != null) {
                    i = R.id.price_tier_picker_toolbar;
                    Toolbar toolbar = (Toolbar) view.findViewById(R.id.price_tier_picker_toolbar);
                    if (toolbar != null) {
                        return new WidgetPriceTierPickerBottomSheetBinding((CoordinatorLayout) view, appBarLayout, appViewFlipper, recyclerView, toolbar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
