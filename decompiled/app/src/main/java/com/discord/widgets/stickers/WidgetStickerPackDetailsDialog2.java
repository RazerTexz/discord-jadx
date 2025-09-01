package com.discord.widgets.stickers;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.StickerPackDetailsDialogBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetStickerPackDetailsDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/StickerPackDetailsDialogBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/StickerPackDetailsDialogBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stickers.WidgetStickerPackDetailsDialog$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetStickerPackDetailsDialog2 extends FunctionReferenceImpl implements Function1<View, StickerPackDetailsDialogBinding> {
    public static final WidgetStickerPackDetailsDialog2 INSTANCE = new WidgetStickerPackDetailsDialog2();

    public WidgetStickerPackDetailsDialog2() {
        super(1, StickerPackDetailsDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/StickerPackDetailsDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StickerPackDetailsDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StickerPackDetailsDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.sticker_pack_details_animated;
        TextView textView = (TextView) view.findViewById(R.id.sticker_pack_details_animated);
        if (textView != null) {
            i = R.id.sticker_pack_details_close;
            TextView textView2 = (TextView) view.findViewById(R.id.sticker_pack_details_close);
            if (textView2 != null) {
                i = R.id.sticker_pack_details_limited;
                TextView textView3 = (TextView) view.findViewById(R.id.sticker_pack_details_limited);
                if (textView3 != null) {
                    i = R.id.sticker_pack_details_pack;
                    TextView textView4 = (TextView) view.findViewById(R.id.sticker_pack_details_pack);
                    if (textView4 != null) {
                        i = R.id.sticker_pack_details_premium;
                        TextView textView5 = (TextView) view.findViewById(R.id.sticker_pack_details_premium);
                        if (textView5 != null) {
                            return new StickerPackDetailsDialogBinding((FrameLayout) view, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
