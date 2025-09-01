package com.discord.widgets.share;

import com.discord.api.channel.Channel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetIncomingShare.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.share.WidgetIncomingShare$onSendClicked$filter$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetIncomingShare9 extends Lambda implements Function1<Channel, Boolean> {
    public final /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload $receiver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare9(WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
        super(1);
        this.$receiver = itemDataPayload;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        return channel != null && channel.getGuildId() == ((WidgetGlobalSearchModel.ItemGuild) this.$receiver).getGuild().getId();
    }
}
