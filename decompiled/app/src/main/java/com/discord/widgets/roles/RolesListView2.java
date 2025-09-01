package com.discord.widgets.roles;

import android.content.Context;
import android.view.View;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.role.GuildRole;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: RolesListView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/roles/RolesListView$updateView$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.roles.RolesListView$updateView$$inlined$forEach$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class RolesListView2 implements View.OnClickListener {
    public final /* synthetic */ boolean $developerModeEnabled$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ GuildRole $role;
    public final /* synthetic */ int $roleDefaultColor$inlined;
    public final /* synthetic */ RolesListView this$0;

    public RolesListView2(GuildRole guildRole, RolesListView rolesListView, int i, long j, boolean z2) {
        this.$role = guildRole;
        this.this$0 = rolesListView;
        this.$roleDefaultColor$inlined = i;
        this.$guildId$inlined = j;
        this.$developerModeEnabled$inlined = z2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context = this.this$0.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        AppToast.b(context, String.valueOf(this.$role.getId()), FormatUtils.j(this.this$0, R.string.role_id_copied, new Object[]{this.$role.getName()}, null, 4));
    }
}
