package com.discord.widgets.servers.community;

import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetServerSettingsCommunityOverview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel;", "invoke", "()Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverview5 extends Lambda implements Function0<WidgetServerSettingsCommunityOverviewViewModel> {
    public final /* synthetic */ WidgetServerSettingsCommunityOverview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCommunityOverview5(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview) {
        super(0);
        this.this$0 = widgetServerSettingsCommunityOverview;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetServerSettingsCommunityOverviewViewModel invoke() {
        return new WidgetServerSettingsCommunityOverviewViewModel(this.this$0.getMostRecentIntent().getLongExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, -1L), null, 2, null);
    }
}
