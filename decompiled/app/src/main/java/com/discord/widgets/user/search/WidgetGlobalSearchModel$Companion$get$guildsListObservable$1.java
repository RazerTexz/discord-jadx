package com.discord.widgets.user.search;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import rx.functions.Func4;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0011\u001a\n \u0001*\u0004\u0018\u00010\u000e0\u000e2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032.\u0010\t\u001a*\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b \u0001*\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00050\u00052X\u0010\r\u001aT\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u000b \u0001**\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f0\nj\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u000b`\fH\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;", "kotlin.jvm.PlatformType", "searchContext", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;", "channelsContext", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/domain/ModelNotificationSettings;", "guildSettings", "Ljava/util/LinkedHashMap;", "Lcom/discord/models/guild/Guild;", "Lkotlin/collections/LinkedHashMap;", "sortedGuilds", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;Ljava/util/Map;Ljava/util/LinkedHashMap;)Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$get$guildsListObservable$1<T1, T2, T3, T4, R> implements Func4<WidgetGlobalSearchModel.SearchContext, WidgetGlobalSearchModel.ChannelContext, Map<Long, ? extends ModelNotificationSettings>, LinkedHashMap<Long, Guild>, WidgetGlobalSearchGuildsModel> {
    public static final WidgetGlobalSearchModel$Companion$get$guildsListObservable$1 INSTANCE = new WidgetGlobalSearchModel$Companion$get$guildsListObservable$1();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetGlobalSearchGuildsModel call(WidgetGlobalSearchModel.SearchContext searchContext, WidgetGlobalSearchModel.ChannelContext channelContext, Map<Long, ? extends ModelNotificationSettings> map, LinkedHashMap<Long, Guild> linkedHashMap) {
        return call2(searchContext, channelContext, map, linkedHashMap);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchGuildsModel call2(WidgetGlobalSearchModel.SearchContext searchContext, WidgetGlobalSearchModel.ChannelContext channelContext, Map<Long, ? extends ModelNotificationSettings> map, LinkedHashMap<Long, Guild> linkedHashMap) {
        WidgetGlobalSearchGuildsModel.Companion companion = WidgetGlobalSearchGuildsModel.INSTANCE;
        List<Long> recentGuildIds = searchContext.getRecentGuildIds();
        long selectedVoiceChannelId = searchContext.getSelectedVoiceChannelId();
        Set<Long> unreadGuildIds = channelContext.getUnreadGuildIds();
        Map<Long, Integer> mentionCounts = searchContext.getMentionCounts();
        Map<Long, Channel> channelsPrivate = channelContext.getChannelsPrivate();
        Intrinsics3.checkNotNullExpressionValue(linkedHashMap, "sortedGuilds");
        Map<Long, List<Long>> guildToChannels = channelContext.getGuildToChannels();
        Intrinsics3.checkNotNullExpressionValue(map, "guildSettings");
        return companion.create(recentGuildIds, selectedVoiceChannelId, unreadGuildIds, mentionCounts, channelsPrivate, linkedHashMap, guildToChannels, map);
    }
}
