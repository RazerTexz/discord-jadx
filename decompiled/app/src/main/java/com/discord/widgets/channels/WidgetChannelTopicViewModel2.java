package com.discord.widgets.channels;

import android.content.Context;
import b.a.d.AppToast;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelTopicViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "com/discord/widgets/channels/WidgetChannelTopicViewModel$handleClosePrivateChannel$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$handleClosePrivateChannel$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel2 extends Lambda implements Function1<Channel, Unit> {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ WidgetChannelTopicViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelTopicViewModel2(WidgetChannelTopicViewModel widgetChannelTopicViewModel, Context context) {
        super(1);
        this.this$0 = widgetChannelTopicViewModel;
        this.$context$inlined = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Integer numB = ChannelUtils.b(channel);
        if (numB != null) {
            AppToast.g(this.$context$inlined, numB.intValue(), 0, null, 12);
        }
    }
}
