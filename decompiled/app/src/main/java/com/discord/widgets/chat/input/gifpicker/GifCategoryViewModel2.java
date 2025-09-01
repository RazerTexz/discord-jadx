package com.discord.widgets.chat.input.gifpicker;

import androidx.core.app.NotificationCompat;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.widgets.chat.input.gifpicker.GifCategoryViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.List;
import kotlin.Metadata;

/* compiled from: GifCategoryViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/models/gifpicker/dto/ModelGif;", "kotlin.jvm.PlatformType", "gifs", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.gifpicker.GifCategoryViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GifCategoryViewModel2<T, R> implements Func1<List<? extends ModelGif>, GifCategoryViewModel.StoreState> {
    public static final GifCategoryViewModel2 INSTANCE = new GifCategoryViewModel2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ GifCategoryViewModel.StoreState call(List<? extends ModelGif> list) {
        return call2((List<ModelGif>) list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GifCategoryViewModel.StoreState call2(List<ModelGif> list) {
        Intrinsics3.checkNotNullExpressionValue(list, "gifs");
        return new GifCategoryViewModel.StoreState(list);
    }
}
