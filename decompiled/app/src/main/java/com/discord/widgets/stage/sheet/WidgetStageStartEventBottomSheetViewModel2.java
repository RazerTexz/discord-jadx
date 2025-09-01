package com.discord.widgets.stage.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channel", "Lcom/discord/api/stageinstance/StageInstance;", "stageInstance", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;Lcom/discord/api/stageinstance/StageInstance;)Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheetViewModel2<T1, T2, R> implements Func2<Channel, StageInstance, WidgetStageStartEventBottomSheetViewModel.StoreState> {
    public static final WidgetStageStartEventBottomSheetViewModel2 INSTANCE = new WidgetStageStartEventBottomSheetViewModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetStageStartEventBottomSheetViewModel.StoreState call(Channel channel, StageInstance stageInstance) {
        return call2(channel, stageInstance);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetStageStartEventBottomSheetViewModel.StoreState call2(Channel channel, StageInstance stageInstance) {
        Intrinsics3.checkNotNullExpressionValue(channel, "channel");
        return new WidgetStageStartEventBottomSheetViewModel.StoreState(channel, stageInstance);
    }
}
