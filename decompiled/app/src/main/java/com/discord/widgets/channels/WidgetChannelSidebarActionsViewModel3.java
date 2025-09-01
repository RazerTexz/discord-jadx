package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.user.MeUser;
import com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel;
import com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel2;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: WidgetChannelSidebarActionsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\n \u0004*\u0004\u0018\u00010\n0\n2.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/domain/ModelNotificationSettings;", "kotlin.jvm.PlatformType", "guildNotificationSettings", "Lcom/discord/models/user/MeUser;", "user", "Lcom/discord/api/channel/Channel;", "parentChannel", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1$1$storeState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSidebarActionsViewModel3<T1, T2, T3, R> implements Func3<Map<Long, ? extends ModelNotificationSettings>, MeUser, Channel, WidgetChannelSidebarActionsViewModel.StoreState.ChannelFound> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetChannelSidebarActionsViewModel2.AnonymousClass1 this$0;

    public WidgetChannelSidebarActionsViewModel3(WidgetChannelSidebarActionsViewModel2.AnonymousClass1 anonymousClass1, Channel channel) {
        this.this$0 = anonymousClass1;
        this.$channel = channel;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetChannelSidebarActionsViewModel.StoreState.ChannelFound call(Map<Long, ? extends ModelNotificationSettings> map, MeUser meUser, Channel channel) {
        return call2(map, meUser, channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelSidebarActionsViewModel.StoreState.ChannelFound call2(Map<Long, ? extends ModelNotificationSettings> map, MeUser meUser, Channel channel) {
        boolean zIsGuildNsfwGateAgreed = WidgetChannelSidebarActionsViewModel2.this.$storeGuildNSFW.isGuildNsfwGateAgreed(this.$channel.getGuildId());
        Channel channel2 = this.$channel;
        return new WidgetChannelSidebarActionsViewModel.StoreState.ChannelFound(channel2, channel, (ModelNotificationSettings) outline.c(channel2, map), this.$channel.getNsfw() && (!zIsGuildNsfwGateAgreed || meUser.getNsfwAllowance() == NsfwAllowance.DISALLOWED));
    }
}
