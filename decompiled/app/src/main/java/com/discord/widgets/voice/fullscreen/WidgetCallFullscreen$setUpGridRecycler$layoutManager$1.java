package com.discord.widgets.voice.fullscreen;

import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetCallFullscreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetCallFullscreen$setUpGridRecycler$layoutManager$1 extends Lambda implements Function0<Integer> {
    public final /* synthetic */ int $layoutManagerOrientation;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$setUpGridRecycler$layoutManager$1(WidgetCallFullscreen widgetCallFullscreen, int i) {
        super(0);
        this.this$0 = widgetCallFullscreen;
        this.$layoutManagerOrientation = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        int i = this.$layoutManagerOrientation;
        if (i == 0) {
            RecyclerView recyclerView = WidgetCallFullscreen.access$getBinding$p(this.this$0).p;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callVideoRecycler");
            return recyclerView.getWidth();
        }
        if (i != 1) {
            throw new IllegalStateException();
        }
        RecyclerView recyclerView2 = WidgetCallFullscreen.access$getBinding$p(this.this$0).p;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.callVideoRecycler");
        return recyclerView2.getHeight();
    }
}
