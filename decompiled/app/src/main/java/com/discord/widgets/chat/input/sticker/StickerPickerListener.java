package com.discord.widgets.chat.input.sticker;

import com.discord.api.sticker.Sticker;
import kotlin.Metadata;

/* compiled from: StickerPickerListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerPickerListener;", "", "Lcom/discord/api/sticker/Sticker;", "sticker", "", "onStickerPicked", "(Lcom/discord/api/sticker/Sticker;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface StickerPickerListener {
    void onStickerPicked(Sticker sticker);
}
