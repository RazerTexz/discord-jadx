package com.discord.widgets.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStickers;
import com.discord.widgets.stickers.StickerSheetViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: StickerSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/stores/StoreStickers$StickerPackState;", "stickerPack", "Lcom/discord/models/user/MeUser;", "meUser", "Lcom/discord/widgets/stickers/StickerSheetViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreStickers$StickerPackState;Lcom/discord/models/user/MeUser;)Lcom/discord/widgets/stickers/StickerSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stickers.StickerSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class StickerSheetViewModel2<T1, T2, R> implements Func2<StoreStickers.StickerPackState, MeUser, StickerSheetViewModel.StoreState> {
    public static final StickerSheetViewModel2 INSTANCE = new StickerSheetViewModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ StickerSheetViewModel.StoreState call(StoreStickers.StickerPackState stickerPackState, MeUser meUser) {
        return call2(stickerPackState, meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final StickerSheetViewModel.StoreState call2(StoreStickers.StickerPackState stickerPackState, MeUser meUser) {
        Intrinsics3.checkNotNullParameter(stickerPackState, "stickerPack");
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        return new StickerSheetViewModel.StoreState(stickerPackState, meUser);
    }
}
