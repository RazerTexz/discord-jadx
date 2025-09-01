package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "it", "", "invoke", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$results$1 extends Lambda implements Function1<WidgetGlobalSearchModel.ItemDataPayload, Boolean> {
    public final /* synthetic */ Channel $lastChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$results$1(Channel channel) {
        super(1);
        this.$lastChannel = channel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
        return Boolean.valueOf(invoke2(itemDataPayload));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
        Intrinsics3.checkNotNullParameter(itemDataPayload, "it");
        long id2 = this.$lastChannel.getId();
        Channel channel = itemDataPayload.getChannel();
        return channel != null && id2 == channel.getId();
    }
}
