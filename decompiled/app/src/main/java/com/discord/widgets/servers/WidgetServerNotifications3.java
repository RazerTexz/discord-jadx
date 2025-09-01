package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.widgets.servers.NotificationsOverridesAdapter;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: WidgetServerNotifications.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\f \u0002*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00030\u00032*\u0010\u0004\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00030\u00002.\u0010\t\u001a*\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b \u0002*\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00050\u00052\u000e\u0010\u000b\u001a\n \u0002*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"", "Lcom/discord/models/domain/ModelNotificationSettings$ChannelOverride;", "kotlin.jvm.PlatformType", "", "channelOverrides", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "guildChannels", "Lcom/discord/utilities/channel/GuildChannelsInfo;", "guildChannelsInfo", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter$Item;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Ljava/util/Map;Lcom/discord/utilities/channel/GuildChannelsInfo;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerNotifications$Companion$getNotificationOverrides$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerNotifications3<T1, T2, T3, R> implements Func3<List<ModelNotificationSettings.ChannelOverride>, Map<Long, ? extends Channel>, GuildChannelsInfo, List<? extends NotificationsOverridesAdapter.Item>> {
    public static final WidgetServerNotifications3 INSTANCE = new WidgetServerNotifications3();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ List<? extends NotificationsOverridesAdapter.Item> call(List<ModelNotificationSettings.ChannelOverride> list, Map<Long, ? extends Channel> map, GuildChannelsInfo guildChannelsInfo) {
        return call2(list, (Map<Long, Channel>) map, guildChannelsInfo);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<NotificationsOverridesAdapter.Item> call2(List<ModelNotificationSettings.ChannelOverride> list, Map<Long, Channel> map, GuildChannelsInfo guildChannelsInfo) {
        Intrinsics3.checkNotNullExpressionValue(map, "guildChannels");
        List<Channel> sortedVisibleChannels = guildChannelsInfo.getSortedVisibleChannels(map);
        Intrinsics3.checkNotNullExpressionValue(list, "channelOverrides");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ModelNotificationSettings.ChannelOverride channelOverride = (ModelNotificationSettings.ChannelOverride) next;
            Intrinsics3.checkNotNullExpressionValue(channelOverride, "it");
            if (channelOverride.getMessageNotifications() != ModelNotificationSettings.FREQUENCY_UNSET || channelOverride.isMuted()) {
                arrayList.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            ModelNotificationSettings.ChannelOverride channelOverride2 = (ModelNotificationSettings.ChannelOverride) obj;
            Intrinsics3.checkNotNullExpressionValue(channelOverride2, "override");
            linkedHashMap.put(Long.valueOf(channelOverride2.getChannelId()), obj);
        }
        ArrayList<Channel> arrayList2 = new ArrayList();
        for (Object obj2 : sortedVisibleChannels) {
            Channel channel = (Channel) obj2;
            if (ChannelUtils.k(channel) || ChannelUtils.F(channel)) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Channel channel2 : arrayList2) {
            ModelNotificationSettings.ChannelOverride channelOverride3 = (ModelNotificationSettings.ChannelOverride) linkedHashMap.get(Long.valueOf(channel2.getId()));
            NotificationsOverridesAdapter.Item item = channelOverride3 != null ? new NotificationsOverridesAdapter.Item(channel2, map.get(Long.valueOf(channel2.getParentId())), channelOverride3) : null;
            if (item != null) {
                arrayList3.add(item);
            }
        }
        return arrayList3;
    }
}
