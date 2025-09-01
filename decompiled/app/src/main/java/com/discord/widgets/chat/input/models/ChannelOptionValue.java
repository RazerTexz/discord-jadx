package com.discord.widgets.chat.input.models;

import com.discord.api.channel.Channel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: CommandOptionValue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/chat/input/models/ChannelOptionValue;", "Lcom/discord/widgets/chat/input/models/CommandOptionValue;", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/api/channel/Channel;", "getChannel", "()Lcom/discord/api/channel/Channel;", "<init>", "(Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelOptionValue extends CommandOptionValue {
    private final Channel channel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelOptionValue(Channel channel) {
        super(String.valueOf(channel.getId()), null);
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
    }

    public final Channel getChannel() {
        return this.channel;
    }
}
