package com.discord.widgets.servers;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsChannels.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)Z", "com/discord/widgets/servers/WidgetServerSettingsChannels$Model$Companion$getSortedGuildChannels$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$Model$Companion$getSortedGuildChannels$$inlined$also$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsChannels2 extends Lambda implements Function1<Channel, Boolean> {
    public final /* synthetic */ int $channelType$inlined;
    public final /* synthetic */ Map $guildChannels$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsChannels2(Map map, int i) {
        super(1);
        this.$guildChannels$inlined = map;
        this.$channelType$inlined = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        int i = this.$channelType$inlined;
        if (i == 0) {
            return ChannelUtils.v(channel);
        }
        if (i == 2) {
            return ChannelUtils.w(channel);
        }
        int type = channel.getType();
        int i2 = this.$channelType$inlined;
        return type == i2 || i2 == -1;
    }
}
