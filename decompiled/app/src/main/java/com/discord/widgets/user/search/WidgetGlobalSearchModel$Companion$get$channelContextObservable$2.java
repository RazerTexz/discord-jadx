package com.discord.widgets.user.search;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.t.Maps6;
import j0.k.Func1;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0005\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;", "kotlin.jvm.PlatformType", "channelContext", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$get$channelContextObservable$2<T, R> implements Func1<WidgetGlobalSearchModel.ChannelContext, WidgetGlobalSearchModel.ChannelContext> {
    public final /* synthetic */ Function2 $permissionsPredicate;

    public WidgetGlobalSearchModel$Companion$get$channelContextObservable$2(Function2 function2) {
        this.$permissionsPredicate = function2;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ChannelContext call(WidgetGlobalSearchModel.ChannelContext channelContext) {
        return call2(channelContext);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.ChannelContext call2(WidgetGlobalSearchModel.ChannelContext channelContext) {
        Map mapPlus = Maps6.plus(channelContext.getChannels(), channelContext.getActiveJoinedThreads());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapPlus.entrySet()) {
            if (((Boolean) this.$permissionsPredicate.invoke((Channel) entry.getValue(), channelContext.getChannelPerms())).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return WidgetGlobalSearchModel.ChannelContext.copy$default(channelContext, null, linkedHashMap, null, null, null, null, null, null, 253, null);
    }
}
