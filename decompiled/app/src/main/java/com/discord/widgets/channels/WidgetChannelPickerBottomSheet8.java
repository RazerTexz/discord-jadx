package com.discord.widgets.channels;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelPickerBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel;", "invoke", "()Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet8 extends Lambda implements Function0<WidgetChannelPickerBottomSheetViewModel> {
    public final /* synthetic */ WidgetChannelPickerBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheet8(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        super(0);
        this.this$0 = widgetChannelPickerBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChannelPickerBottomSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelPickerBottomSheetViewModel invoke() {
        return new WidgetChannelPickerBottomSheetViewModel(WidgetChannelPickerBottomSheet.access$getGuildId$p(this.this$0), WidgetChannelPickerBottomSheet.access$getSelectedChannelId$p(this.this$0), WidgetChannelPickerBottomSheet.access$getHideAnnouncementChannels$p(this.this$0), null, null, null, 56, null);
    }
}
