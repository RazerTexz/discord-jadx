package b.a.z.a.a;

import com.discord.api.role.GuildRole;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddRole;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class u implements Function1 {
    public final /* synthetic */ WidgetChannelSettingsPermissionsAddRole j;
    public final /* synthetic */ WidgetChannelSettingsPermissionsAddRole.Model k;

    public /* synthetic */ u(WidgetChannelSettingsPermissionsAddRole widgetChannelSettingsPermissionsAddRole, WidgetChannelSettingsPermissionsAddRole.Model model) {
        this.j = widgetChannelSettingsPermissionsAddRole;
        this.k = model;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        WidgetChannelSettingsPermissionsAddRole widgetChannelSettingsPermissionsAddRole = this.j;
        WidgetChannelSettingsPermissionsAddRole.Model model = this.k;
        WidgetChannelSettingsEditPermissions.createForRole(widgetChannelSettingsPermissionsAddRole.getContext(), WidgetChannelSettingsPermissionsAddRole.Model.access$200(model).getGuildId(), WidgetChannelSettingsPermissionsAddRole.Model.access$200(model).getId(), ((GuildRole) obj).getId());
        return Unit.a;
    }
}
