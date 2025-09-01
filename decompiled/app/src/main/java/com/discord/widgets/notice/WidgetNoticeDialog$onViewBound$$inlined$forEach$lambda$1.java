package com.discord.widgets.notice;

import android.view.View;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetNoticeDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/notice/WidgetNoticeDialog$onViewBound$6$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetNoticeDialog$onViewBound$$inlined$forEach$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ Map.Entry $entry;
    public final /* synthetic */ View $view$inlined;
    public final /* synthetic */ WidgetNoticeDialog this$0;

    public WidgetNoticeDialog$onViewBound$$inlined$forEach$lambda$1(Map.Entry entry, WidgetNoticeDialog widgetNoticeDialog, View view) {
        this.$entry = entry;
        this.this$0 = widgetNoticeDialog;
        this.$view$inlined = view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ((Function1) this.$entry.getValue()).invoke(this.$view$inlined);
        this.this$0.dismiss();
    }
}
