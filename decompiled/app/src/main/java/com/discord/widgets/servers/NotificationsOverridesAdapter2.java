package com.discord.widgets.servers;

import android.view.View;
import com.discord.widgets.servers.NotificationsOverridesAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: NotificationsOverridesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.NotificationsOverridesAdapter$ViewHolder$onBind$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class NotificationsOverridesAdapter2 implements View.OnClickListener {
    public final /* synthetic */ NotificationsOverridesAdapter.Item $data;
    public final /* synthetic */ NotificationsOverridesAdapter.ViewHolder this$0;

    public NotificationsOverridesAdapter2(NotificationsOverridesAdapter.ViewHolder viewHolder, NotificationsOverridesAdapter.Item item) {
        this.this$0 = viewHolder;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function2<View, NotificationsOverridesAdapter.Item, Unit> onClick = this.this$0.getOnClick();
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        onClick.invoke(view, this.$data);
    }
}
