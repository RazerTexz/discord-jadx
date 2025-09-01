package com.discord.widgets.voice.fullscreen;

import android.view.View;
import com.discord.widgets.voice.controls.VoiceControlsSheetSwipeTooltip;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetCallFullscreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/discord/widgets/voice/fullscreen/WidgetCallFullscreen$bottomSheetCallback$1", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "(Landroid/view/View;I)V", "", "slideOffset", "onSlide", "(Landroid/view/View;F)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetCallFullscreen$bottomSheetCallback$1 extends BottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$bottomSheetCallback$1(WidgetCallFullscreen widgetCallFullscreen) {
        this.this$0 = widgetCallFullscreen;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public void onSlide(View bottomSheet, float slideOffset) {
        Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
        WidgetCallFullscreen.access$getViewModel$p(this.this$0).stopIdle();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public void onStateChanged(View bottomSheet, int newState) {
        Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
        WidgetCallFullscreen.access$getBinding$p(this.this$0).f2248y.handleSheetState(newState);
        WidgetCallFullscreen.access$getViewModel$p(this.this$0).handleBottomSheetState(newState);
        if (newState == 3) {
            WidgetCallFullscreen.access$getViewModel$p(this.this$0).stopIdle();
            WidgetCallFullscreen.access$getTooltipManager$p(this.this$0).a(VoiceControlsSheetSwipeTooltip.INSTANCE);
        } else {
            if (newState != 4) {
                return;
            }
            WidgetCallFullscreen.access$getViewModel$p(this.this$0).startIdle();
        }
    }
}
