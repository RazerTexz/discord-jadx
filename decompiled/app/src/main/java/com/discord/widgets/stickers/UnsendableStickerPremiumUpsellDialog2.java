package com.discord.widgets.stickers;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.StickerPremiumUpsellDialogBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: UnsendableStickerPremiumUpsellDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/StickerPremiumUpsellDialogBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/StickerPremiumUpsellDialogBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stickers.UnsendableStickerPremiumUpsellDialog$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class UnsendableStickerPremiumUpsellDialog2 extends FunctionReferenceImpl implements Function1<View, StickerPremiumUpsellDialogBinding> {
    public static final UnsendableStickerPremiumUpsellDialog2 INSTANCE = new UnsendableStickerPremiumUpsellDialog2();

    public UnsendableStickerPremiumUpsellDialog2() {
        super(1, StickerPremiumUpsellDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/StickerPremiumUpsellDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StickerPremiumUpsellDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StickerPremiumUpsellDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.sticker_premium_upsell_close_button;
        TextView textView = (TextView) view.findViewById(R.id.sticker_premium_upsell_close_button);
        if (textView != null) {
            i = R.id.sticker_premium_upsell_description;
            TextView textView2 = (TextView) view.findViewById(R.id.sticker_premium_upsell_description);
            if (textView2 != null) {
                i = R.id.sticker_premium_upsell_subscribe_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.sticker_premium_upsell_subscribe_button);
                if (materialButton != null) {
                    return new StickerPremiumUpsellDialogBinding((RelativeLayout) view, textView, textView2, materialButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
