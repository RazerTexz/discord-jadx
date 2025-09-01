package com.discord.widgets.channels.permissions;

import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverviewViewModel;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import kotlin.Metadata;

/* compiled from: WidgetChannelSettingsPermissionsOverviewViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "isStageChannel", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$ViewState;", "generateInitialViewState", "(Z)Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$ViewState;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverviewViewModelKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverviewViewModel2 {
    public static final /* synthetic */ WidgetChannelSettingsPermissionsOverviewViewModel.ViewState access$generateInitialViewState(boolean z2) {
        return generateInitialViewState(z2);
    }

    private static final WidgetChannelSettingsPermissionsOverviewViewModel.ViewState generateInitialViewState(boolean z2) {
        if (z2) {
            WidgetChannelSettingsPermissionsOverviewViewModel.Tab tab = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.MODERATOR;
            return new WidgetChannelSettingsPermissionsOverviewViewModel.ViewState(tab, Collections2.listOf((Object[]) new WidgetChannelSettingsPermissionsOverviewViewModel.Tab[]{tab, WidgetChannelSettingsPermissionsOverviewViewModel.Tab.ADVANCED}));
        }
        WidgetChannelSettingsPermissionsOverviewViewModel.Tab tab2 = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.ADVANCED;
        return new WidgetChannelSettingsPermissionsOverviewViewModel.ViewState(tab2, CollectionsJVM.listOf(tab2));
    }
}
