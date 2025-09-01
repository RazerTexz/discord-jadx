package com.discord.widgets.chat.input.sticker;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: View.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010¸\u0006\u0011"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1 implements View.OnLayoutChangeListener {
    public final /* synthetic */ long $packId$inlined;
    public final /* synthetic */ String $searchText$inlined;
    public final /* synthetic */ WidgetStickerPicker this$0;

    public WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1(WidgetStickerPicker widgetStickerPicker, String str, long j) {
        this.this$0 = widgetStickerPicker;
        this.$searchText$inlined = str;
        this.$packId$inlined = j;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        WidgetStickerPicker.access$getViewModel$p(this.this$0).setSearchText(this.$searchText$inlined);
        WidgetStickerPicker.access$getViewModel$p(this.this$0).setSelectedCategoryId(this.$packId$inlined);
        RecyclerView recyclerView = WidgetStickerPicker.access$getBinding$p(this.this$0).k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatInputStickerPickerRecycler");
        if (!ViewCompat.isLaidOut(recyclerView) || recyclerView.isLayoutRequested()) {
            recyclerView.addOnLayoutChangeListener(new WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1$lambda$1(this));
        } else {
            this.this$0.scrollToPack(Long.valueOf(this.$packId$inlined));
        }
    }
}
