package com.discord.widgets.user.search;

import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchGuildsModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "invoke", "(Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel$Companion$asGuildItems$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsModel4 extends Lambda implements Function1<Guild, WidgetGlobalSearchGuildsModel.Item> {
    public final /* synthetic */ Map $channelIds;
    public final /* synthetic */ Map $guildSettings;
    public final /* synthetic */ Map $mentionCounts;
    public final /* synthetic */ Long $selectedGuildId;
    public final /* synthetic */ long $selectedVoiceChannelId;
    public final /* synthetic */ Set $unreadGuildIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsModel4(Map map, Map map2, Map map3, Set set, Long l, long j) {
        super(1);
        this.$channelIds = map;
        this.$mentionCounts = map2;
        this.$guildSettings = map3;
        this.$unreadGuildIds = set;
        this.$selectedGuildId = l;
        this.$selectedVoiceChannelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchGuildsModel.Item invoke(Guild guild) {
        return invoke2(guild);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchGuildsModel.Item invoke2(Guild guild) {
        int iSumOfInt;
        boolean z2;
        Intrinsics3.checkNotNullParameter(guild, "guild");
        long id2 = guild.getId();
        List list = (List) this.$channelIds.get(Long.valueOf(id2));
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) this.$mentionCounts.get(Long.valueOf(((Number) it.next()).longValue()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            iSumOfInt = _Collections.sumOfInt(arrayList);
        } else {
            iSumOfInt = 0;
        }
        ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) this.$guildSettings.get(Long.valueOf(id2));
        boolean zContains = (modelNotificationSettings == null || !modelNotificationSettings.isMuted()) ? this.$unreadGuildIds.contains(Long.valueOf(id2)) : false;
        Long l = this.$selectedGuildId;
        boolean z3 = (l == null || l == null || id2 != l.longValue()) ? false : true;
        if (z3 || this.$selectedVoiceChannelId <= 0 || list == null || list.isEmpty()) {
            z2 = false;
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (this.$selectedVoiceChannelId == ((Number) it2.next()).longValue()) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        return WidgetGlobalSearchGuildsModel.Item.INSTANCE.createGuild$app_productionGoogleRelease(guild, iSumOfInt, zContains, z3, z2);
    }
}
