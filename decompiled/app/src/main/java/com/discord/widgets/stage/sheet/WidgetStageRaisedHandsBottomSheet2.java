package com.discord.widgets.stage.sheet;

import android.widget.CompoundButton;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel;
import kotlin.Metadata;

/* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "isEnabled", "", "onCheckedChanged", "(Landroid/widget/CompoundButton;Z)V", "com/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheet$configureUI$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$configureUI$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheet2 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel.ViewState $viewState$inlined;
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheet this$0;

    public WidgetStageRaisedHandsBottomSheet2(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet, WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
        this.this$0 = widgetStageRaisedHandsBottomSheet;
        this.$viewState$inlined = viewState;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        WidgetStageRaisedHandsBottomSheet.access$getViewModel$p(this.this$0).setRequestToSpeakEnabled(z2);
    }
}
