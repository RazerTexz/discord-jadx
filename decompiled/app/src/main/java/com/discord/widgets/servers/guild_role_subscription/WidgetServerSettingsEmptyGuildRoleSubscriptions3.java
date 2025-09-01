package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import kotlin.Metadata;

/* compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/servers/guild_role_subscription/WidgetServerSettingsEmptyGuildRoleSubscriptions$configureUI$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions$configureUI$$inlined$let$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEmptyGuildRoleSubscriptions3 implements View.OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEmptyGuildRoleSubscriptions this$0;

    public WidgetServerSettingsEmptyGuildRoleSubscriptions3(WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions) {
        this.this$0 = widgetServerSettingsEmptyGuildRoleSubscriptions;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsEnableMonetizationUnavailable.INSTANCE.launch(this.this$0.requireContext());
    }
}
