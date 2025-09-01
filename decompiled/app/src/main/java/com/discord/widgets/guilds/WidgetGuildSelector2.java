package com.discord.widgets.guilds;

import android.view.View;
import com.discord.widgets.guilds.WidgetGuildSelector;
import kotlin.Metadata;

/* compiled from: WidgetGuildSelector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.WidgetGuildSelector$Adapter$ItemGuild$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildSelector2 implements View.OnClickListener {
    public final /* synthetic */ WidgetGuildSelector.Item $data;
    public final /* synthetic */ WidgetGuildSelector.Adapter.ItemGuild this$0;

    public WidgetGuildSelector2(WidgetGuildSelector.Adapter.ItemGuild itemGuild, WidgetGuildSelector.Item item) {
        this.this$0 = itemGuild;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildSelector.access$onGuildSelected(WidgetGuildSelector.Adapter.access$getDialog$p(WidgetGuildSelector.Adapter.ItemGuild.access$getAdapter$p(this.this$0)), this.$data.getGuild());
    }
}
