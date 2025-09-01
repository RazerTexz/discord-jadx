package com.discord.widgets.stickers;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildStickerSheetBinding;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildStickerSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildStickerSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildStickerSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stickers.WidgetGuildStickerSheet$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetGuildStickerSheet4 extends FunctionReferenceImpl implements Function1<View, WidgetGuildStickerSheetBinding> {
    public static final WidgetGuildStickerSheet4 INSTANCE = new WidgetGuildStickerSheet4();

    public WidgetGuildStickerSheet4() {
        super(1, WidgetGuildStickerSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildStickerSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildStickerSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildStickerSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.divider;
        View viewFindViewById = view.findViewById(R.id.divider);
        if (viewFindViewById != null) {
            i = R.id.guild_sticker_sheet_button_container;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.guild_sticker_sheet_button_container);
            if (frameLayout != null) {
                i = R.id.guild_sticker_sheet_description;
                TextView textView = (TextView) view.findViewById(R.id.guild_sticker_sheet_description);
                if (textView != null) {
                    AppViewFlipper appViewFlipper = (AppViewFlipper) view;
                    i = R.id.guild_sticker_sheet_guild_container;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.guild_sticker_sheet_guild_container);
                    if (linearLayout != null) {
                        i = R.id.guild_sticker_sheet_guild_header;
                        TextView textView2 = (TextView) view.findViewById(R.id.guild_sticker_sheet_guild_header);
                        if (textView2 != null) {
                            i = R.id.guild_sticker_sheet_guild_icon;
                            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.guild_sticker_sheet_guild_icon);
                            if (simpleDraweeView != null) {
                                i = R.id.guild_sticker_sheet_guild_icon_text;
                                TextView textView3 = (TextView) view.findViewById(R.id.guild_sticker_sheet_guild_icon_text);
                                if (textView3 != null) {
                                    i = R.id.guild_sticker_sheet_guild_icon_wrapper;
                                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.guild_sticker_sheet_guild_icon_wrapper);
                                    if (frameLayout2 != null) {
                                        i = R.id.guild_sticker_sheet_guild_info;
                                        TextView textView4 = (TextView) view.findViewById(R.id.guild_sticker_sheet_guild_info);
                                        if (textView4 != null) {
                                            i = R.id.guild_sticker_sheet_guild_name;
                                            TextView textView5 = (TextView) view.findViewById(R.id.guild_sticker_sheet_guild_name);
                                            if (textView5 != null) {
                                                i = R.id.guild_sticker_sheet_join_btn;
                                                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_sticker_sheet_join_btn);
                                                if (materialButton != null) {
                                                    i = R.id.guild_sticker_sheet_premium_btn;
                                                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.guild_sticker_sheet_premium_btn);
                                                    if (materialButton2 != null) {
                                                        i = R.id.guild_sticker_sheet_sticker;
                                                        StickerView stickerView = (StickerView) view.findViewById(R.id.guild_sticker_sheet_sticker);
                                                        if (stickerView != null) {
                                                            i = R.id.guild_sticker_sheet_sticker_name;
                                                            TextView textView6 = (TextView) view.findViewById(R.id.guild_sticker_sheet_sticker_name);
                                                            if (textView6 != null) {
                                                                return new WidgetGuildStickerSheetBinding(appViewFlipper, viewFindViewById, frameLayout, textView, appViewFlipper, linearLayout, textView2, simpleDraweeView, textView3, frameLayout2, textView4, textView5, materialButton, materialButton2, stickerView, textView6);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
