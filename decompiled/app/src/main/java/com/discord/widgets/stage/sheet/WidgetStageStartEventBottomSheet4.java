package com.discord.widgets.stage.sheet;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetStageStartEventBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel;", "invoke", "()Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheet4 extends Lambda implements Function0<WidgetStageStartEventBottomSheetViewModel> {
    public final /* synthetic */ WidgetStageStartEventBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageStartEventBottomSheet4(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        super(0);
        this.this$0 = widgetStageStartEventBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetStageStartEventBottomSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetStageStartEventBottomSheetViewModel invoke() {
        return new WidgetStageStartEventBottomSheetViewModel(WidgetStageStartEventBottomSheet.access$getChannelId$p(this.this$0), null, null, null, 14, null);
    }
}
