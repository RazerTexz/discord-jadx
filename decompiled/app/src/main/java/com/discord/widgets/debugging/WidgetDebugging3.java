package com.discord.widgets.debugging;

import android.view.View;
import android.widget.TextView;
import com.discord.widgets.debugging.WidgetDebugging;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetDebugging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.debugging.WidgetDebugging$Adapter$Item$onConfigure$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetDebugging3 implements View.OnClickListener {
    public final /* synthetic */ WidgetDebugging.Adapter.Item this$0;

    public WidgetDebugging3(WidgetDebugging.Adapter.Item item) {
        this.this$0 = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView = WidgetDebugging.Adapter.Item.access$getBinding$p(this.this$0).f2361b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.logMessage");
        TextView textView2 = WidgetDebugging.Adapter.Item.access$getBinding$p(this.this$0).f2361b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.logMessage");
        textView.setMaxLines(textView2.getMaxLines() == Integer.MAX_VALUE ? 2 : Integer.MAX_VALUE);
        this.this$0.itemView.requestLayout();
    }
}
