package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.servers.SettingsChannelListAdapter;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func7;

/* compiled from: WidgetServerSettingsChannels.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062.\u0010\u000b\u001a*\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\u0004\u0012\u00020\n \u0001*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b0\b2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\n \u0001*\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f0\f26\u0010\u000e\u001a2\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0001*\u0018\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\b0\b2\u000e\u0010\u0010\u001a\n \u0001*\u0004\u0018\u00010\u000f0\u000fH\n¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "", "Lcom/discord/api/permission/PermissionBit;", "myPermissions", "Lcom/discord/models/guild/Guild;", "guild", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "guildChannels", "", "categories", "channelPermissions", "", "sortType", "Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Ljava/lang/Long;Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Ljava/lang/Integer;)Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsChannels3<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<MeUser, Long, Guild, Map<Long, ? extends Channel>, List<? extends Channel>, Map<Long, ? extends Long>, Integer, WidgetServerSettingsChannels.Model> {
    public static final WidgetServerSettingsChannels3 INSTANCE = new WidgetServerSettingsChannels3();

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ WidgetServerSettingsChannels.Model call(MeUser meUser, Long l, Guild guild, Map<Long, ? extends Channel> map, List<? extends Channel> list, Map<Long, ? extends Long> map2, Integer num) {
        return call2(meUser, l, guild, (Map<Long, Channel>) map, (List<Channel>) list, (Map<Long, Long>) map2, num);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d6  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WidgetServerSettingsChannels.Model call2(MeUser meUser, Long l, Guild guild, Map<Long, Channel> map, List<Channel> list, Map<Long, Long> map2, Integer num) {
        List list2;
        List list3;
        HashSet hashSet;
        if (guild == null || l == null || map2 == null) {
            return null;
        }
        WidgetServerSettingsChannels.Model.Companion companion = WidgetServerSettingsChannels.Model.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(map, "guildChannels");
        Intrinsics3.checkNotNullExpressionValue(num, "sortType");
        LinkedHashMap<Long, Channel> sortedGuildChannels = companion.getSortedGuildChannels(map, num.intValue());
        boolean z2 = num.intValue() != -1;
        long j = 16;
        boolean zCanAndIsElevated = PermissionUtils.canAndIsElevated(16L, l, meUser.getMfaEnabled(), guild.getMfaLevel());
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashSet hashSet2 = new HashSet();
        if (!z2 || zCanAndIsElevated) {
            hashSet2.add(0L);
            linkedHashMap.put(0L, new ArrayList());
            List list4 = (List) linkedHashMap.get(0L);
            if (list4 != null) {
                list4.add(new SettingsChannelListAdapter.CategoryItem(null, 0L, 0, false, false, true));
            }
        }
        Collections.sort(list, ChannelUtils.h(Channel.INSTANCE));
        for (Channel channel : list) {
            if (PermissionUtils.hasAccess(channel, map2) || channel.getId() == 0) {
                ArrayList arrayList2 = new ArrayList();
                boolean zCan = PermissionUtils.can(j, (Long) outline.d(channel, map2));
                if (zCan || zCanAndIsElevated) {
                    hashSet2.add(Long.valueOf(channel.getId()));
                }
                if (!z2 || zCan) {
                    hashSet = hashSet2;
                    arrayList2.add(new SettingsChannelListAdapter.CategoryItem(ChannelUtils.c(channel), channel.getId(), channel.getPosition(), num.intValue() == 4, zCanAndIsElevated, zCan));
                    linkedHashMap.put(Long.valueOf(channel.getId()), arrayList2);
                } else {
                    hashSet = hashSet2;
                }
            }
            hashSet2 = hashSet;
            j = 16;
        }
        HashSet hashSet3 = hashSet2;
        if (hashSet3.isEmpty()) {
            return null;
        }
        ArrayList<SettingsChannelListAdapter.ChannelItem> arrayList3 = new ArrayList();
        ArrayList<SettingsChannelListAdapter.ChannelItem> arrayList4 = new ArrayList();
        Iterator<Channel> it = sortedGuildChannels.values().iterator();
        while (it.hasNext()) {
            Channel next = it.next();
            Intrinsics3.checkNotNullExpressionValue(next, "channel");
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            Iterator<Channel> it2 = it;
            LinkedHashMap<Long, Channel> linkedHashMap3 = sortedGuildChannels;
            HashSet hashSet4 = hashSet3;
            SettingsChannelListAdapter.ChannelItem channelItem = new SettingsChannelListAdapter.ChannelItem(next, z2, next.getParentId(), hashSet3.contains(Long.valueOf(next.getParentId())));
            if (!z2 || hashSet4.contains(Long.valueOf(next.getParentId()))) {
                if (ChannelUtils.v(next) && PermissionUtils.hasAccess(next, map2)) {
                    arrayList3.add(channelItem);
                } else if (ChannelUtils.w(next) && PermissionUtils.hasAccess(next, map2)) {
                    arrayList4.add(channelItem);
                }
            }
            hashSet3 = hashSet4;
            linkedHashMap = linkedHashMap2;
            it = it2;
            sortedGuildChannels = linkedHashMap3;
        }
        LinkedHashMap<Long, Channel> linkedHashMap4 = sortedGuildChannels;
        LinkedHashMap linkedHashMap5 = linkedHashMap;
        for (SettingsChannelListAdapter.ChannelItem channelItem2 : arrayList3) {
            if (linkedHashMap5.containsKey(Long.valueOf(channelItem2.getChannel().getParentId())) && (list3 = (List) linkedHashMap5.get(Long.valueOf(channelItem2.getChannel().getParentId()))) != null) {
                list3.add(channelItem2);
            }
        }
        for (SettingsChannelListAdapter.ChannelItem channelItem3 : arrayList4) {
            if (linkedHashMap5.containsKey(Long.valueOf(channelItem3.getChannel().getParentId())) && (list2 = (List) linkedHashMap5.get(Long.valueOf(channelItem3.getChannel().getParentId()))) != null) {
                list2.add(channelItem3);
            }
        }
        for (List list5 : linkedHashMap5.values()) {
            Intrinsics3.checkNotNullExpressionValue(list5, "list");
            arrayList.addAll(list5);
        }
        return new WidgetServerSettingsChannels.Model(guild, arrayList, z2, linkedHashMap4, map2);
    }
}
