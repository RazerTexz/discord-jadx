package com.discord.widgets.chat.input;

import com.discord.api.sticker.Sticker;
import com.discord.widgets.chat.input.sticker.StickerPickerListener;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetChatInputAttachments.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/chat/input/WidgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1", "Lcom/discord/widgets/chat/input/sticker/StickerPickerListener;", "Lcom/discord/api/sticker/Sticker;", "sticker", "", "onStickerPicked", "(Lcom/discord/api/sticker/Sticker;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1 implements StickerPickerListener {
    public final /* synthetic */ WidgetChatInputAttachments this$0;

    public WidgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1(WidgetChatInputAttachments widgetChatInputAttachments) {
        this.this$0 = widgetChatInputAttachments;
    }

    @Override // com.discord.widgets.chat.input.sticker.StickerPickerListener
    public void onStickerPicked(Sticker sticker) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        FlexInputViewModel flexInputViewModel = WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0).viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.hideExpressionTray();
        }
    }
}
