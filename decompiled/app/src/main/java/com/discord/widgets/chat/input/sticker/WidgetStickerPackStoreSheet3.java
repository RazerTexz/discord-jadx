package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetStickerPackStoreSheetBinding;
import com.discord.views.LoadingButton;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetStickerPackStoreSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetStickerPackStoreSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetStickerPackStoreSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetStickerPackStoreSheet3 extends FunctionReferenceImpl implements Function1<View, WidgetStickerPackStoreSheetBinding> {
    public static final WidgetStickerPackStoreSheet3 INSTANCE = new WidgetStickerPackStoreSheet3();

    public WidgetStickerPackStoreSheet3() {
        super(1, WidgetStickerPackStoreSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStickerPackStoreSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStickerPackStoreSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStickerPackStoreSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.sticker_pack_store_sheet_buy_button_container;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.sticker_pack_store_sheet_buy_button_container);
        if (frameLayout != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i = R.id.sticker_pack_store_sheet_recycler;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.sticker_pack_store_sheet_recycler);
            if (recyclerView != null) {
                i = R.id.sticker_pack_view_all_banner;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.sticker_pack_view_all_banner);
                if (simpleDraweeView != null) {
                    i = R.id.sticker_store_buy_button_premium;
                    LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.sticker_store_buy_button_premium);
                    if (loadingButton != null) {
                        return new WidgetStickerPackStoreSheetBinding(relativeLayout, frameLayout, relativeLayout, recyclerView, simpleDraweeView, loadingButton);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
