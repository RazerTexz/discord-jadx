package com.discord.widgets.servers;

import android.view.View;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.widgets.servers.WidgetServerSettingsRolesAdapter;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: WidgetServerSettingsRolesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter3 implements View.OnClickListener {
    public final /* synthetic */ WidgetServerSettingsRolesAdapter.RoleItem $roleItem;
    public final /* synthetic */ WidgetServerSettingsRolesAdapter.RoleListItem this$0;

    public WidgetServerSettingsRolesAdapter3(WidgetServerSettingsRolesAdapter.RoleListItem roleListItem, WidgetServerSettingsRolesAdapter.RoleItem roleItem) {
        this.this$0 = roleListItem;
        this.$roleItem = roleItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MGRecyclerAdapter mGRecyclerAdapterAccess$getAdapter$p = WidgetServerSettingsRolesAdapter.RoleListItem.access$getAdapter$p(this.this$0);
        Objects.requireNonNull(mGRecyclerAdapterAccess$getAdapter$p, "null cannot be cast to non-null type com.discord.widgets.servers.WidgetServerSettingsRolesAdapter");
        WidgetServerSettingsRolesAdapter.access$getRoleSelectedListener$p((WidgetServerSettingsRolesAdapter) mGRecyclerAdapterAccess$getAdapter$p).invoke(this.$roleItem.getRole());
    }
}
