package com.discord.widgets.user.search;

import b.d.b.a.outline;
import com.discord.models.guild.Guild;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/guild/Guild;", "", "guildFilter", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemGuild;", "invoke", "(Lcom/discord/models/guild/Guild;Ljava/lang/String;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemGuild;", "toItemGuild"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$3 extends Lambda implements Function2<Guild, String, WidgetGlobalSearchModel.ItemGuild> {
    public final /* synthetic */ WidgetGlobalSearchModel.ChannelContext $channelContext;
    public final /* synthetic */ WidgetGlobalSearchModel.SearchContext $searchContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$3(WidgetGlobalSearchModel.ChannelContext channelContext, WidgetGlobalSearchModel.SearchContext searchContext) {
        super(2);
        this.$channelContext = channelContext;
        this.$searchContext = searchContext;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ItemGuild invoke(Guild guild, String str) {
        return invoke2(guild, str);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.ItemGuild invoke2(Guild guild, String str) {
        int i;
        boolean z2;
        Intrinsics3.checkNotNullParameter(guild, "$this$toItemGuild");
        Intrinsics3.checkNotNullParameter(str, "guildFilter");
        WidgetGlobalSearchModel.MatchedResult matchedResult = WidgetGlobalSearchModel.INSTANCE.toMatchedResult(guild.getName(), str);
        if (matchedResult == null) {
            return null;
        }
        List list = (List) outline.e(guild, this.$channelContext.getGuildToChannels());
        if (list != null) {
            Iterator it = list.iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                Integer num = this.$searchContext.getMentionCounts().get(Long.valueOf(((Number) it.next()).longValue()));
                iIntValue += num != null ? num.intValue() : 0;
            }
            i = iIntValue;
        } else {
            i = 0;
        }
        if (list == null || list.isEmpty()) {
            z2 = false;
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (this.$channelContext.getUnreadChannelIds().contains(Long.valueOf(((Number) it2.next()).longValue()))) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        return new WidgetGlobalSearchModel.ItemGuild(matchedResult, guild, null, i, z2, 4, null);
    }
}
