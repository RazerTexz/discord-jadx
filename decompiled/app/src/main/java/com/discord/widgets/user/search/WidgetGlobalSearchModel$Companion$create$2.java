package com.discord.widgets.user.search;

import android.annotation.SuppressLint;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/user/User;", "", "userFilter", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemUser;", "invoke", "(Lcom/discord/models/user/User;Ljava/lang/String;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemUser;", "toItemUser"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$2 extends Lambda implements Function3<User, String, Channel, WidgetGlobalSearchModel.ItemUser> {
    public final /* synthetic */ WidgetGlobalSearchModel.ChannelContext $channelContext;
    public final /* synthetic */ WidgetGlobalSearchModel.SearchContext $searchContext;
    public final /* synthetic */ WidgetGlobalSearchModel.UsersContext $usersContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$2(WidgetGlobalSearchModel.UsersContext usersContext, WidgetGlobalSearchModel.SearchContext searchContext, WidgetGlobalSearchModel.ChannelContext channelContext) {
        super(3);
        this.$usersContext = usersContext;
        this.$searchContext = searchContext;
        this.$channelContext = channelContext;
    }

    public static /* synthetic */ WidgetGlobalSearchModel.ItemUser invoke$default(WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2, User user, String str, Channel channel, int i, Object obj) {
        if ((i & 2) != 0) {
            channel = null;
        }
        return widgetGlobalSearchModel$Companion$create$2.invoke2(user, str, channel);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ItemUser invoke(User user, String str, Channel channel) {
        return invoke2(user, str, channel);
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.ItemUser invoke2(User user, String str, Channel channel) {
        String username;
        Integer num;
        Intrinsics3.checkNotNullParameter(user, "$this$toItemUser");
        Intrinsics3.checkNotNullParameter(str, "userFilter");
        Collection<Map<Long, GuildMember>> collectionValues = this.$usersContext.getMembers().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            GuildMember guildMember = (GuildMember) outline.f(user, (Map) it.next());
            String nick = guildMember != null ? guildMember.getNick() : null;
            if (nick != null) {
                arrayList.add(nick);
            }
        }
        List listDistinct = _Collections.distinct(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = listDistinct.iterator();
        while (it2.hasNext()) {
            WidgetGlobalSearchModel.MatchedResult matchedResult = WidgetGlobalSearchModel.INSTANCE.toMatchedResult((String) it2.next(), str);
            if (matchedResult != null) {
                arrayList2.add(matchedResult);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = listDistinct.iterator();
        while (it3.hasNext()) {
            WidgetGlobalSearchModel.MatchedResult fuzzyMatchedResult = WidgetGlobalSearchModel.INSTANCE.toFuzzyMatchedResult((String) it3.next(), str);
            if (fuzzyMatchedResult != null) {
                arrayList3.add(fuzzyMatchedResult);
            }
        }
        if (this.$searchContext.getHasDiscriminator()) {
            username = user.getUsername() + UserUtils.INSTANCE.getDiscriminatorWithPadding(user);
        } else {
            username = user.getUsername();
        }
        WidgetGlobalSearchModel.Companion companion = WidgetGlobalSearchModel.INSTANCE;
        WidgetGlobalSearchModel.MatchedResult matchedResult2 = companion.toMatchedResult(username, str);
        WidgetGlobalSearchModel.MatchedResult fuzzyMatchedResult2 = companion.toFuzzyMatchedResult(username, str);
        if (matchedResult2 == null) {
            if (!arrayList2.isEmpty()) {
                fuzzyMatchedResult2 = (WidgetGlobalSearchModel.MatchedResult) _Collections.first((List) arrayList2);
            } else if (fuzzyMatchedResult2 == null) {
                if (!arrayList3.isEmpty()) {
                    fuzzyMatchedResult2 = (WidgetGlobalSearchModel.MatchedResult) _Collections.first((List) arrayList3);
                } else {
                    matchedResult2 = null;
                }
            }
            matchedResult2 = fuzzyMatchedResult2;
        }
        if (matchedResult2 == null) {
            return null;
        }
        Integer num2 = (Integer) outline.f(user, this.$usersContext.getRelationships());
        boolean z2 = num2 != null && num2.intValue() == 1;
        List listListOf = CollectionsJVM.listOf(user.getUsername() + UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
        ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList2, 10));
        Iterator it4 = arrayList2.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((WidgetGlobalSearchModel.MatchedResult) it4.next()).getValue());
        }
        List listPlus = _Collections.plus((Collection) listListOf, (Iterable) arrayList4);
        ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList3, 10));
        Iterator it5 = arrayList3.iterator();
        while (it5.hasNext()) {
            arrayList5.add(((WidgetGlobalSearchModel.MatchedResult) it5.next()).getValue());
        }
        return new WidgetGlobalSearchModel.ItemUser(matchedResult2, user, _Collections.distinct(_Collections.plus((Collection) listPlus, (Iterable) arrayList5)), z2, (Presence) outline.f(user, this.$usersContext.getPresences()), channel, (channel == null || (num = (Integer) outline.d(channel, this.$searchContext.getMentionCounts())) == null) ? 0 : num.intValue(), channel != null ? this.$channelContext.getUnreadChannelIds().contains(Long.valueOf(channel.getId())) : false);
    }
}
