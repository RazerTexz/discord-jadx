package com.discord.widgets.channels.permissions;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel;", "invoke", "()Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview4 extends Lambda implements Function0<WidgetChannelSettingsPermissionsOverviewViewModel> {
    public final /* synthetic */ WidgetChannelSettingsPermissionsOverview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsPermissionsOverview4(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview) {
        super(0);
        this.this$0 = widgetChannelSettingsPermissionsOverview;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChannelSettingsPermissionsOverviewViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelSettingsPermissionsOverviewViewModel invoke() {
        long jAccess$getChannelIdFromIntent = WidgetChannelSettingsPermissionsOverview.access$getChannelIdFromIntent(this.this$0);
        Channel channel = StoreStream.INSTANCE.getChannels().getChannel(jAccess$getChannelIdFromIntent);
        return new WidgetChannelSettingsPermissionsOverviewViewModel(jAccess$getChannelIdFromIntent, channel != null && channel.getType() == 13);
    }
}
