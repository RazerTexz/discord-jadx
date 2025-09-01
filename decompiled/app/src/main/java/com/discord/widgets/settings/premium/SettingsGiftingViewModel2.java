package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreGifting;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: SettingsGiftingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u0002*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0005 \u0002* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u0002*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "meId", "Lrx/Observable;", "", "Lcom/discord/models/domain/ModelGift;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SettingsGiftingViewModel2<T, R> implements Func1<Long, Observable<? extends List<? extends ModelGift>>> {
    public static final SettingsGiftingViewModel2 INSTANCE = new SettingsGiftingViewModel2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends List<? extends ModelGift>> call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<ModelGift>> call2(Long l) {
        StoreGifting gifting = StoreStream.INSTANCE.getGifting();
        Intrinsics3.checkNotNullExpressionValue(l, "meId");
        return gifting.getMyResolvedGifts(l.longValue());
    }
}
