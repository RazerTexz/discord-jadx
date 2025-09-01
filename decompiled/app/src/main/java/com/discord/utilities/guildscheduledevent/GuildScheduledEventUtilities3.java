package com.discord.utilities.guildscheduledevent;

import androidx.fragment.app.Fragment;
import com.discord.api.channel.Channel;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildScheduledEventUtilities.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "defaultChannel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities$Companion$launchInvite$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildScheduledEventUtilities3 extends Lambda implements Function1<Channel, Unit> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Fragment $fragment;
    public final /* synthetic */ long $guildEventId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventUtilities3(Fragment fragment, Channel channel, long j) {
        super(1);
        this.$fragment = fragment;
        this.$channel = channel;
        this.$guildEventId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        ChannelInviteLaunchUtils channelInviteLaunchUtils = ChannelInviteLaunchUtils.INSTANCE;
        Fragment fragment = this.$fragment;
        Channel channel2 = this.$channel;
        if (channel2 == null) {
            channel2 = channel;
        }
        ChannelInviteLaunchUtils.inviteToChannel$default(channelInviteLaunchUtils, fragment, channel2, GuildScheduledEventUtilities.ANALYTICS_SOURCE, Long.valueOf(this.$guildEventId), null, 16, null);
    }
}
