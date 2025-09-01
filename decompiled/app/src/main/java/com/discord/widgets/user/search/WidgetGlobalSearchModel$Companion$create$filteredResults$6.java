package com.discord.widgets.user.search;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$6 extends Lambda implements Function1<Channel, Boolean> {
    public final /* synthetic */ WidgetGlobalSearchModel.ChannelContext $channelContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$6(WidgetGlobalSearchModel.ChannelContext channelContext) {
        super(1);
        this.$channelContext = channelContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "it");
        Object objD = outline.d(channel, this.$channelContext.getChannelPerms());
        if (objD == null) {
            objD = 0L;
        }
        long jLongValue = ((Number) objD).longValue();
        return PermissionUtils.can(Permission.VIEW_CHANNEL, Long.valueOf(jLongValue)) && PermissionUtils.can(Permission.CONNECT, Long.valueOf(jLongValue));
    }
}
