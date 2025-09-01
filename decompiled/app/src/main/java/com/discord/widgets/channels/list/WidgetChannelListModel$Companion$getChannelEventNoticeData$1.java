package com.discord.widgets.channels.list;

import com.discord.widgets.stage.model.StageChannel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/stage/model/StageChannel;", "it", "", "invoke", "(Lcom/discord/widgets/stage/model/StageChannel;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$getChannelEventNoticeData$1 extends Lambda implements Function1<StageChannel, Boolean> {
    public static final WidgetChannelListModel$Companion$getChannelEventNoticeData$1 INSTANCE = new WidgetChannelListModel$Companion$getChannelEventNoticeData$1();

    public WidgetChannelListModel$Companion$getChannelEventNoticeData$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StageChannel stageChannel) {
        return Boolean.valueOf(invoke2(stageChannel));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StageChannel stageChannel) {
        Intrinsics3.checkNotNullParameter(stageChannel, "it");
        return stageChannel.getCanAccess() && stageChannel.getHasActiveStageInstance() && !stageChannel.getContainsMe();
    }
}
