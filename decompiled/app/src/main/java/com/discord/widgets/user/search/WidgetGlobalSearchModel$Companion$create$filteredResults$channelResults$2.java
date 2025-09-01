package com.discord.widgets.user.search;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.User;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "invoke", "(Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$channelResults$2 extends Lambda implements Function1<Channel, WidgetGlobalSearchModel.ItemDataPayload> {
    public final /* synthetic */ String $sanitizedFilter;
    public final /* synthetic */ HashSet $seenUsersIds;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$4 $toItemChannel$4;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$2 $toItemUser$2;
    public final /* synthetic */ WidgetGlobalSearchModel.UsersContext $usersContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$channelResults$2(HashSet hashSet, WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2, WidgetGlobalSearchModel.UsersContext usersContext, String str, WidgetGlobalSearchModel$Companion$create$4 widgetGlobalSearchModel$Companion$create$4) {
        super(1);
        this.$seenUsersIds = hashSet;
        this.$toItemUser$2 = widgetGlobalSearchModel$Companion$create$2;
        this.$usersContext = usersContext;
        this.$sanitizedFilter = str;
        this.$toItemChannel$4 = widgetGlobalSearchModel$Companion$create$4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload invoke(Channel channel) {
        return invoke2(channel);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.ItemDataPayload invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        User userA = ChannelUtils.a(channel);
        if (userA != null) {
            this.$seenUsersIds.add(Long.valueOf(userA.getId()));
            WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2 = this.$toItemUser$2;
            User user = (User) outline.f(userA, this.$usersContext.getUsers());
            if (user != null) {
                userA = user;
            }
            WidgetGlobalSearchModel.ItemUser itemUserInvoke2 = widgetGlobalSearchModel$Companion$create$2.invoke2(userA, this.$sanitizedFilter, channel);
            if (itemUserInvoke2 != null) {
                return itemUserInvoke2;
            }
        }
        return this.$toItemChannel$4.invoke2(channel, this.$sanitizedFilter);
    }
}
