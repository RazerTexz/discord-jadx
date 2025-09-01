package com.discord.widgets.share;

import android.net.Uri;
import android.view.View;
import com.discord.widgets.share.WidgetIncomingShare;
import kotlin.Metadata;

/* compiled from: WidgetIncomingShare.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.share.WidgetIncomingShare$Adapter$ViewHolder$bind$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetIncomingShare5 implements View.OnClickListener {
    public final /* synthetic */ Uri $uri;
    public final /* synthetic */ WidgetIncomingShare.Adapter.ViewHolder this$0;

    public WidgetIncomingShare5(WidgetIncomingShare.Adapter.ViewHolder viewHolder, Uri uri) {
        this.this$0 = viewHolder;
        this.$uri = uri;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetIncomingShare.Adapter.access$getOnItemClickListener$p(this.this$0.this$0).invoke(this.$uri);
    }
}
