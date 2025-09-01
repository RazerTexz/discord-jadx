package com.discord.widgets.chat.input.sticker;

import android.os.Bundle;
import com.discord.api.sticker.Sticker;
import com.discord.widgets.stickers.StickerPurchaseLocation;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetStickerPackStoreSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel;", "invoke", "()Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStickerPackStoreSheet4 extends Lambda implements Function0<StickerPackStoreSheetViewModel> {
    public final /* synthetic */ WidgetStickerPackStoreSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStickerPackStoreSheet4(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet) {
        super(0);
        this.this$0 = widgetStickerPackStoreSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StickerPackStoreSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StickerPackStoreSheetViewModel invoke() {
        Bundle arguments = this.this$0.getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("com.discord.intent.extra.EXTRA_STICKER") : null;
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.api.sticker.Sticker");
        Sticker sticker = (Sticker) serializable;
        Bundle arguments2 = this.this$0.getArguments();
        Serializable serializable2 = arguments2 != null ? arguments2.getSerializable("widget_sticker_pack_store_sheet_view_type") : null;
        Objects.requireNonNull(serializable2, "null cannot be cast to non-null type com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewType");
        WidgetStickerPackStoreSheet2 widgetStickerPackStoreSheet2 = (WidgetStickerPackStoreSheet2) serializable2;
        Bundle arguments3 = this.this$0.getArguments();
        String string = arguments3 != null ? arguments3.getString("widget_sticker_pack_Store_sheet_analytics_location") : null;
        Bundle arguments4 = this.this$0.getArguments();
        Serializable serializable3 = arguments4 != null ? arguments4.getSerializable("widget_sticker_pack_Store_sheet_analytics_location_section") : null;
        Objects.requireNonNull(serializable3, "null cannot be cast to non-null type com.discord.widgets.stickers.StickerPurchaseLocation");
        StickerPackStoreSheetViewModel2 stickerPackStoreSheetViewModel2 = new StickerPackStoreSheetViewModel2(sticker, widgetStickerPackStoreSheet2, string, ((StickerPurchaseLocation) serializable3).getAnalyticsValue());
        Long packId = sticker.getPackId();
        Intrinsics3.checkNotNull(packId);
        return new StickerPackStoreSheetViewModel(packId.longValue(), null, stickerPackStoreSheetViewModel2, null, 10, null);
    }
}
