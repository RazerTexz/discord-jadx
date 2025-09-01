package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildsSorted;
import com.discord.utilities.streams.StreamContext;
import com.discord.widgets.guilds.list.WidgetGuildsListViewModel;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import rx.functions.Func9;

/* compiled from: WidgetGuildsListViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0019\u001a\n \u0001*\u0004\u0018\u00010\u00160\u00162\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\"\u0010\b\u001a\u001e\u0012\b\u0012\u00060\u0006j\u0002`\u0007 \u0001*\u000e\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0018\u00010\u00050\u00052\"\u0010\n\u001a\u001e\u0012\b\u0012\u00060\u0006j\u0002`\t \u0001*\u000e\u0012\b\u0012\u00060\u0006j\u0002`\t\u0018\u00010\u00050\u00052\u000e\u0010\f\u001a\n \u0001*\u0004\u0018\u00010\u000b0\u000b2.\u0010\u0010\u001a*\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f \u0001*\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r0\r26\u0010\u0013\u001a2\u0012\b\u0012\u00060\u0006j\u0002`\u0011\u0012\b\u0012\u00060\u0006j\u0002`\u0012 \u0001*\u0018\u0012\b\u0012\u00060\u0006j\u0002`\u0011\u0012\b\u0012\u00060\u0006j\u0002`\u0012\u0018\u00010\r0\r2\u000e\u0010\u0014\u001a\n \u0001*\u0004\u0018\u00010\u000b0\u000b2\u000e\u0010\u0015\u001a\n \u0001*\u0004\u0018\u00010\u000b0\u000bH\n¢\u0006\u0004\b\u0017\u0010\u0018"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Companion$Chunk;", "kotlin.jvm.PlatformType", "chunk", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Companion$SecondChunk;", "secondChunk", "", "", "Lcom/discord/primitives/GuildId;", "lurkingGuildIds", "Lcom/discord/primitives/FolderId;", "openFolderIds", "", "isNewUser", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/utilities/streams/StreamContext;", "allApplicationStreamContexts", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/permission/PermissionBit;", "allChannelPermissions", "isLeftPanelOpened", "isOnHomeTab", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Companion$Chunk;Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Companion$SecondChunk;Ljava/util/Set;Ljava/util/Set;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$6, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildsListViewModel7<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<WidgetGuildsListViewModel.Companion.Chunk, WidgetGuildsListViewModel.Companion.SecondChunk, Set<? extends Long>, Set<? extends Long>, Boolean, Map<Long, ? extends StreamContext>, Map<Long, ? extends Long>, Boolean, Boolean, WidgetGuildsListViewModel.StoreState> {
    public static final WidgetGuildsListViewModel7 INSTANCE = new WidgetGuildsListViewModel7();

    @Override // rx.functions.Func9
    public /* bridge */ /* synthetic */ WidgetGuildsListViewModel.StoreState call(WidgetGuildsListViewModel.Companion.Chunk chunk, WidgetGuildsListViewModel.Companion.SecondChunk secondChunk, Set<? extends Long> set, Set<? extends Long> set2, Boolean bool, Map<Long, ? extends StreamContext> map, Map<Long, ? extends Long> map2, Boolean bool2, Boolean bool3) {
        return call2(chunk, secondChunk, (Set<Long>) set, (Set<Long>) set2, bool, (Map<Long, StreamContext>) map, (Map<Long, Long>) map2, bool2, bool3);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildsListViewModel.StoreState call2(WidgetGuildsListViewModel.Companion.Chunk chunk, WidgetGuildsListViewModel.Companion.SecondChunk secondChunk, Set<Long> set, Set<Long> set2, Boolean bool, Map<Long, StreamContext> map, Map<Long, Long> map2, Boolean bool2, Boolean bool3) {
        long selectedGuildId = chunk.getSelectedGuildId();
        long selectedVoiceChannelId = chunk.getSelectedVoiceChannelId();
        Map<Long, ModelNotificationSettings> guildSettings = chunk.getGuildSettings();
        Set<Long> unreadGuildIds = chunk.getUnreadGuildIds();
        Map<Long, Integer> mentionCounts = chunk.getMentionCounts();
        Map<Long, List<Long>> channelIds = chunk.getChannelIds();
        Set<Long> unavailableGuilds = chunk.getUnavailableGuilds();
        Map<Long, Channel> privateChannels = chunk.getPrivateChannels();
        List<StoreGuildsSorted.Entry> sortedGuilds = chunk.getSortedGuilds();
        Map<Long, GuildJoinRequest> guildJoinRequests = secondChunk.getGuildJoinRequests();
        List<Guild> pendingGuilds = secondChunk.getPendingGuilds();
        Set<Long> guildIds = secondChunk.getGuildIds();
        Intrinsics3.checkNotNullExpressionValue(set, "lurkingGuildIds");
        Set<Long> guildIdsWithActiveStageEvents = secondChunk.getGuildIdsWithActiveStageEvents();
        Set<Long> guildIdsWithActiveScheduledEvents = secondChunk.getGuildIdsWithActiveScheduledEvents();
        Map<Long, Channel> channels = secondChunk.getChannels();
        Intrinsics3.checkNotNullExpressionValue(set2, "openFolderIds");
        Intrinsics3.checkNotNullExpressionValue(bool, "isNewUser");
        boolean zBooleanValue = bool.booleanValue();
        Intrinsics3.checkNotNullExpressionValue(map, "allApplicationStreamContexts");
        Intrinsics3.checkNotNullExpressionValue(map2, "allChannelPermissions");
        Intrinsics3.checkNotNullExpressionValue(bool2, "isLeftPanelOpened");
        boolean zBooleanValue2 = bool2.booleanValue();
        Intrinsics3.checkNotNullExpressionValue(bool3, "isOnHomeTab");
        return new WidgetGuildsListViewModel.StoreState(selectedGuildId, selectedVoiceChannelId, guildSettings, unreadGuildIds, mentionCounts, channelIds, unavailableGuilds, privateChannels, sortedGuilds, guildJoinRequests, pendingGuilds, guildIds, set, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, channels, set2, zBooleanValue, map, map2, zBooleanValue2, bool3.booleanValue(), secondChunk.getShowHubSparkle());
    }
}
