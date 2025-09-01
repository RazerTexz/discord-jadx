package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.panels.PanelState;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreUserConnections;
import com.discord.widgets.home.WidgetHomeViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func8;

/* compiled from: WidgetHomeViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0012\u001a\n \u0001*\u0004\u0018\u00010\u000f0\u000f2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0005\u001a\n \u0001*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0001*\u0004\u0018\u00010\b0\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000e\u0010\r\u001a\n \u0001*\u0004\u0018\u00010\f0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\n¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lcom/discord/panels/PanelState;", "kotlin.jvm.PlatformType", "leftPanelState", "rightPanelState", "Lcom/discord/widgets/home/WidgetHomeViewModel$GuildInfo;", "guildInfo", "Lcom/discord/models/user/MeUser;", "me", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "selectedChannel", "Lcom/discord/models/experiments/domain/Experiment;", "eventsUpsellExperiment", "Lcom/discord/stores/StoreUserConnections$State;", "connectedAccounts", "<anonymous parameter 7>", "Lcom/discord/widgets/home/WidgetHomeViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/panels/PanelState;Lcom/discord/panels/PanelState;Lcom/discord/widgets/home/WidgetHomeViewModel$GuildInfo;Lcom/discord/models/user/MeUser;Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;Lcom/discord/models/experiments/domain/Experiment;Lcom/discord/stores/StoreUserConnections$State;Lcom/discord/models/experiments/domain/Experiment;)Lcom/discord/widgets/home/WidgetHomeViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.home.WidgetHomeViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHomeViewModel2<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<PanelState, PanelState, WidgetHomeViewModel.GuildInfo, MeUser, StoreChannelsSelected.ResolvedSelectedChannel, Experiment, StoreUserConnections.State, Experiment, WidgetHomeViewModel.StoreState> {
    public static final WidgetHomeViewModel2 INSTANCE = new WidgetHomeViewModel2();

    @Override // rx.functions.Func8
    public /* bridge */ /* synthetic */ WidgetHomeViewModel.StoreState call(PanelState panelState, PanelState panelState2, WidgetHomeViewModel.GuildInfo guildInfo, MeUser meUser, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Experiment experiment, StoreUserConnections.State state, Experiment experiment2) {
        return call2(panelState, panelState2, guildInfo, meUser, resolvedSelectedChannel, experiment, state, experiment2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetHomeViewModel.StoreState call2(PanelState panelState, PanelState panelState2, WidgetHomeViewModel.GuildInfo guildInfo, MeUser meUser, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Experiment experiment, StoreUserConnections.State state, Experiment experiment2) {
        StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel2;
        NsfwAllowance nsfwAllowance;
        Channel maybeChannel = resolvedSelectedChannel.getMaybeChannel();
        boolean z2 = maybeChannel != null && maybeChannel.getNsfw();
        if (meUser != null) {
            nsfwAllowance = meUser.getNsfwAllowance();
            resolvedSelectedChannel2 = resolvedSelectedChannel;
        } else {
            resolvedSelectedChannel2 = resolvedSelectedChannel;
            nsfwAllowance = null;
        }
        if (!(resolvedSelectedChannel2 instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel)) {
            resolvedSelectedChannel2 = null;
        }
        StoreChannelsSelected.ResolvedSelectedChannel.Channel channel = (StoreChannelsSelected.ResolvedSelectedChannel.Channel) resolvedSelectedChannel2;
        boolean z3 = (channel != null ? channel.getPeekParent() : null) != null;
        Intrinsics3.checkNotNullExpressionValue(panelState, "leftPanelState");
        Intrinsics3.checkNotNullExpressionValue(panelState2, "rightPanelState");
        Intrinsics3.checkNotNullExpressionValue(guildInfo, "guildInfo");
        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
        boolean z4 = experiment != null && experiment.getBucket() == 1;
        long guildId = guildInfo.getGuildId();
        Intrinsics3.checkNotNullExpressionValue(state, "connectedAccounts");
        return new WidgetHomeViewModel.StoreState(panelState, panelState2, guildInfo, meUser, z3, z4, z2, nsfwAllowance, guildId, state);
    }
}
