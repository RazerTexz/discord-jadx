package b.a.z.a.a;

import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddMember;
import rx.functions.Action1;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Action1 {
    public final /* synthetic */ WidgetChannelSettingsPermissionsAddMember j;

    public /* synthetic */ a(WidgetChannelSettingsPermissionsAddMember widgetChannelSettingsPermissionsAddMember) {
        this.j = widgetChannelSettingsPermissionsAddMember;
    }

    @Override // rx.functions.Action1
    public final void call(Object obj) {
        WidgetChannelSettingsPermissionsAddMember.g(this.j, (WidgetChannelSettingsPermissionsAddMember.Model) obj);
    }
}
