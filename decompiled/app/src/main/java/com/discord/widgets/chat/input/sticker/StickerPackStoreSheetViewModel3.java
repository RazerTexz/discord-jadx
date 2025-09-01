package com.discord.widgets.chat.input.sticker;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStickers;
import com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: StickerPackStoreSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/stores/StoreStickers$StickerPackState;", "stickerPack", "", "stickerAnimationSettings", "Lcom/discord/models/user/MeUser;", "meUser", "Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreStickers$StickerPackState;ILcom/discord/models/user/MeUser;)Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StickerPackStoreSheetViewModel3<T1, T2, T3, R> implements Func3<StoreStickers.StickerPackState, Integer, MeUser, StickerPackStoreSheetViewModel.StoreState> {
    public static final StickerPackStoreSheetViewModel3 INSTANCE = new StickerPackStoreSheetViewModel3();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ StickerPackStoreSheetViewModel.StoreState call(StoreStickers.StickerPackState stickerPackState, Integer num, MeUser meUser) {
        return call(stickerPackState, num.intValue(), meUser);
    }

    public final StickerPackStoreSheetViewModel.StoreState call(StoreStickers.StickerPackState stickerPackState, int i, MeUser meUser) {
        Intrinsics3.checkNotNullParameter(stickerPackState, "stickerPack");
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        return new StickerPackStoreSheetViewModel.StoreState(stickerPackState, i, meUser);
    }
}
