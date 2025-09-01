package com.discord.widgets.user.search;

import android.view.View;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import kotlin.Metadata;

/* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter$Item$onConfigure$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter2 implements View.OnClickListener {
    public final /* synthetic */ WidgetGlobalSearchGuildsModel.Item $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ WidgetGlobalSearchGuildsAdapter.Item this$0;

    public WidgetGlobalSearchGuildsAdapter2(WidgetGlobalSearchGuildsAdapter.Item item, int i, WidgetGlobalSearchGuildsModel.Item item2) {
        this.this$0 = item;
        this.$position = i;
        this.$data = item2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGlobalSearchGuildsAdapter.Item.access$getAdapter$p(this.this$0).getOnClickListener().invoke(Integer.valueOf(this.this$0.getItemViewType()), Integer.valueOf(this.$position), this.$data);
    }
}
