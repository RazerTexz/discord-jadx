package com.discord.widgets.channels;

import android.view.View;
import com.discord.api.role.GuildRole;
import com.discord.widgets.channels.WidgetCreateChannel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetCreateChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetCreateChannel$RolesAdapter$RoleListItem$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ GuildRole $role;
    public final /* synthetic */ WidgetCreateChannel.RolesAdapter.RoleListItem this$0;

    public WidgetCreateChannel$RolesAdapter$RoleListItem$onConfigure$1(WidgetCreateChannel.RolesAdapter.RoleListItem roleListItem, GuildRole guildRole) {
        this.this$0 = roleListItem;
        this.$role = guildRole;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetCreateChannel.RolesAdapter rolesAdapterAccess$getAdapter$p = WidgetCreateChannel.RolesAdapter.RoleListItem.access$getAdapter$p(this.this$0);
        Intrinsics3.checkNotNullExpressionValue(WidgetCreateChannel.RolesAdapter.RoleListItem.access$getBinding$p(this.this$0).f2180b, "binding.roleItemCheckedSetting");
        WidgetCreateChannel.RolesAdapter.access$onRoleClicked(rolesAdapterAccess$getAdapter$p, !r0.isChecked(), this.this$0.getAdapterPosition(), this.$role.getId());
    }
}
