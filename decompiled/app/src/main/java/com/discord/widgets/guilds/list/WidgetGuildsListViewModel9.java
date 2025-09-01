package com.discord.widgets.guilds.list;

import com.discord.api.channel.Channel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildsSorted;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.WidgetGuildsListViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildsListViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildsSorted$Entry$SingletonGuild;", "folder", "Lcom/discord/widgets/guilds/list/GuildListItem$GuildItem;", "invoke", "(Lcom/discord/stores/StoreGuildsSorted$Entry$SingletonGuild;)Lcom/discord/widgets/guilds/list/GuildListItem$GuildItem;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$handleStoreState$lurkerGuildItems$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildsListViewModel9 extends Lambda implements Function1<StoreGuildsSorted.Entry.SingletonGuild, GuildListItem.GuildItem> {
    public final /* synthetic */ HashMap $mentionCountsByGuild;
    public final /* synthetic */ WidgetGuildsListViewModel.StoreState $storeState;
    public final /* synthetic */ WidgetGuildsListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsListViewModel9(WidgetGuildsListViewModel widgetGuildsListViewModel, WidgetGuildsListViewModel.StoreState storeState, HashMap map) {
        super(1);
        this.this$0 = widgetGuildsListViewModel;
        this.$storeState = storeState;
        this.$mentionCountsByGuild = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ GuildListItem.GuildItem invoke(StoreGuildsSorted.Entry.SingletonGuild singletonGuild) {
        return invoke2(singletonGuild);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GuildListItem.GuildItem invoke2(StoreGuildsSorted.Entry.SingletonGuild singletonGuild) {
        Intrinsics3.checkNotNullParameter(singletonGuild, "folder");
        WidgetGuildsListViewModel widgetGuildsListViewModel = this.this$0;
        Guild guild = singletonGuild.getGuild();
        long selectedGuildId = this.$storeState.getSelectedGuildId();
        long selectedVoiceChannelId = this.$storeState.getSelectedVoiceChannelId();
        Set<Long> unreadGuildIds = this.$storeState.getUnreadGuildIds();
        Map<Long, ModelNotificationSettings> guildSettings = this.$storeState.getGuildSettings();
        Integer num = (Integer) this.$mentionCountsByGuild.get(Long.valueOf(singletonGuild.getGuild().getId()));
        if (num == null) {
            num = 0;
        }
        Intrinsics3.checkNotNullExpressionValue(num, "mentionCountsByGuild[folder.guild.id] ?: 0");
        int iIntValue = num.intValue();
        Map<Long, List<Long>> channelIds = this.$storeState.getChannelIds();
        Map<Long, Channel> channels = this.$storeState.getChannels();
        Set<Long> lurkingGuildIds = this.$storeState.getLurkingGuildIds();
        Set<Long> guildIdsWithActiveStageEvents = this.$storeState.getGuildIdsWithActiveStageEvents();
        Set<Long> guildIdsWithActiveScheduledEvents = this.$storeState.getGuildIdsWithActiveScheduledEvents();
        Map<Long, Long> allChannelPermissions = this.$storeState.getAllChannelPermissions();
        GuildJoinRequest guildJoinRequest = this.$storeState.getGuildJoinRequests().get(Long.valueOf(singletonGuild.getGuild().getId()));
        return WidgetGuildsListViewModel.createGuildItem$default(widgetGuildsListViewModel, guild, selectedGuildId, selectedVoiceChannelId, unreadGuildIds, guildSettings, iIntValue, channelIds, channels, lurkingGuildIds, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, null, null, null, allChannelPermissions, guildJoinRequest != null ? guildJoinRequest.getApplicationStatus() : null, false, 65536, null);
    }
}
