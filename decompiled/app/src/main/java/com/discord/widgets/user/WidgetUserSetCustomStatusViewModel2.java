package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelCustomStatusSetting;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.widgets.user.WidgetUserSetCustomStatusViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: WidgetUserSetCustomStatusViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/domain/ModelCustomStatusSetting;", "kotlin.jvm.PlatformType", "customStatusSetting", "Lcom/discord/models/domain/emoji/EmojiSet;", "emojiSet", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelCustomStatusSetting;Lcom/discord/models/domain/emoji/EmojiSet;)Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatusViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserSetCustomStatusViewModel2<T1, T2, R> implements Func2<ModelCustomStatusSetting, EmojiSet, WidgetUserSetCustomStatusViewModel.StoreState> {
    public static final WidgetUserSetCustomStatusViewModel2 INSTANCE = new WidgetUserSetCustomStatusViewModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetUserSetCustomStatusViewModel.StoreState call(ModelCustomStatusSetting modelCustomStatusSetting, EmojiSet emojiSet) {
        return call2(modelCustomStatusSetting, emojiSet);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetUserSetCustomStatusViewModel.StoreState call2(ModelCustomStatusSetting modelCustomStatusSetting, EmojiSet emojiSet) {
        Intrinsics3.checkNotNullExpressionValue(modelCustomStatusSetting, "customStatusSetting");
        Intrinsics3.checkNotNullExpressionValue(emojiSet, "emojiSet");
        return new WidgetUserSetCustomStatusViewModel.StoreState(modelCustomStatusSetting, emojiSet);
    }
}
