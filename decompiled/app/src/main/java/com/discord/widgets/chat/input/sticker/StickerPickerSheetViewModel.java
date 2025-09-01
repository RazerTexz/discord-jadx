package com.discord.widgets.chat.input.sticker;

import com.discord.widgets.chat.MessageManager;
import d0.z.d.Intrinsics3;
import java.util.Locale;
import kotlin.Metadata;

/* compiled from: StickerPickerSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerPickerSheetViewModel;", "Lcom/discord/widgets/chat/input/sticker/StickerPickerViewModel;", "Ljava/util/Locale;", "locale", "Lcom/discord/widgets/chat/MessageManager;", "messageManager", "", "Lcom/discord/primitives/StickerPackId;", "initialStickerPackId", "<init>", "(Ljava/util/Locale;Lcom/discord/widgets/chat/MessageManager;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StickerPickerSheetViewModel extends StickerPickerViewModel {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPickerSheetViewModel(Locale locale, MessageManager messageManager, long j) {
        super(null, null, locale, messageManager, null, j, null, null, null, null, null, 2003, null);
        Intrinsics3.checkNotNullParameter(locale, "locale");
        Intrinsics3.checkNotNullParameter(messageManager, "messageManager");
    }
}
