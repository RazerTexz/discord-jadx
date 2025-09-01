package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreUserSettings;
import com.discord.widgets.channels.WidgetChannelTopicViewModel;
import j0.k.Func1;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: WidgetChannelTopicViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\b0\b2V\u0010\u0007\u001aR\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0000 \u0006*(\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0000\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "allMembersByGuild", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$Companion$mapChannelToPrivateStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel4<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends GuildMember>>, WidgetChannelTopicViewModel.StoreState> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetChannelTopicViewModel.Companion.NavState $navState;
    public final /* synthetic */ StoreUserSettings $storeUserSettings;

    public WidgetChannelTopicViewModel4(Channel channel, StoreUserSettings storeUserSettings, WidgetChannelTopicViewModel.Companion.NavState navState) {
        this.$channel = channel;
        this.$storeUserSettings = storeUserSettings;
        this.$navState = navState;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ WidgetChannelTopicViewModel.StoreState call(Map<Long, ? extends Map<Long, ? extends GuildMember>> map) {
        return call2((Map<Long, ? extends Map<Long, GuildMember>>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelTopicViewModel.StoreState call2(Map<Long, ? extends Map<Long, GuildMember>> map) {
        return new WidgetChannelTopicViewModel.StoreState.DM(this.$channel, map.values(), this.$storeUserSettings.getIsDeveloperMode(), this.$navState.isRightPanelOpened(), this.$navState.isOnHomeTab());
    }
}
