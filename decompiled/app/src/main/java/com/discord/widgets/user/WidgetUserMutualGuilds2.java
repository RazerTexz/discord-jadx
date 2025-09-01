package com.discord.widgets.user;

import android.view.View;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreStream;
import com.discord.widgets.user.WidgetUserMutualGuilds;
import kotlin.Metadata;

/* compiled from: WidgetUserMutualGuilds.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.WidgetUserMutualGuilds$Adapter$ViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserMutualGuilds2 implements View.OnClickListener {
    public final /* synthetic */ WidgetUserMutualGuilds.Model.Item $data;
    public final /* synthetic */ WidgetUserMutualGuilds.Adapter.ViewHolder this$0;

    public WidgetUserMutualGuilds2(WidgetUserMutualGuilds.Adapter.ViewHolder viewHolder, WidgetUserMutualGuilds.Model.Item item) {
        this.this$0 = viewHolder;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StoreGuildSelected guildSelected = StoreStream.INSTANCE.getGuildSelected();
        Guild guild = this.$data.getGuild();
        guildSelected.set(guild != null ? guild.getId() : 0L);
        WidgetUserMutualGuilds.Adapter.access$getGuildSelectedCallback$p(WidgetUserMutualGuilds.Adapter.ViewHolder.access$getAdapter$p(this.this$0)).call();
    }
}
