package com.discord.widgets.channels.threads.browser;

import android.view.View;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserAdapter;
import kotlin.Metadata;

/* compiled from: WidgetThreadBrowserAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onLongClick", "(Landroid/view/View;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserAdapter$ThreadItem$onConfigure$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserAdapter3 implements View.OnLongClickListener {
    public final /* synthetic */ WidgetThreadBrowserAdapter.Item.Thread $item;
    public final /* synthetic */ WidgetThreadBrowserAdapter.ThreadItem this$0;

    public WidgetThreadBrowserAdapter3(WidgetThreadBrowserAdapter.ThreadItem threadItem, WidgetThreadBrowserAdapter.Item.Thread thread) {
        this.this$0 = threadItem;
        this.$item = thread;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        WidgetThreadBrowserAdapter.ThreadItem.access$getAdapter$p(this.this$0).onThreadLongClicked(this.$item.getThreadData().getChannel());
        return true;
    }
}
