package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.channel.GuildChannelIconUtils;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.widgets.channels.WidgetChannelTopicViewModel;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func5;

/* compiled from: WidgetChannelTopicViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0014\u001a\n \u0004*\u0004\u0018\u00010\u00110\u00112.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002.\u0010\b\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00000\u000026\u0010\u000b\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\b\u0012\u00060\tj\u0002`\n \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\b\u0012\u00060\tj\u0002`\n\u0018\u00010\u00000\u00002.\u0010\u000e\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\f\u0012\u0004\u0012\u00020\r \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u00000\u00002\u000e\u0010\u0010\u001a\n \u0004*\u0004\u0018\u00010\u000f0\u000fH\n¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channels", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "users", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "members", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "roles", "", "allowAnimatedEmojis", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$Guild;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;)Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState$Guild;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$Companion$mapChannelToGuildStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel3<T1, T2, T3, T4, T5, R> implements Func5<Map<Long, ? extends Channel>, Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Boolean, WidgetChannelTopicViewModel.StoreState.Guild> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetChannelTopicViewModel.Companion.NavState $navState;

    public WidgetChannelTopicViewModel3(Channel channel, WidgetChannelTopicViewModel.Companion.NavState navState) {
        this.$channel = channel;
        this.$navState = navState;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetChannelTopicViewModel.StoreState.Guild call(Map<Long, ? extends Channel> map, Map<Long, ? extends User> map2, Map<Long, ? extends GuildMember> map3, Map<Long, ? extends GuildRole> map4, Boolean bool) {
        return call2((Map<Long, Channel>) map, map2, (Map<Long, GuildMember>) map3, (Map<Long, GuildRole>) map4, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelTopicViewModel.StoreState.Guild call2(Map<Long, Channel> map, Map<Long, ? extends User> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, Boolean bool) {
        Channel channel = this.$channel;
        Intrinsics3.checkNotNullExpressionValue(map, "channels");
        GuildChannelIconUtils channelType = GuildChannelIconUtils2.getChannelType(this.$channel);
        Intrinsics3.checkNotNullExpressionValue(map2, "users");
        Intrinsics3.checkNotNullExpressionValue(map3, "members");
        Intrinsics3.checkNotNullExpressionValue(map4, "roles");
        Intrinsics3.checkNotNullExpressionValue(bool, "allowAnimatedEmojis");
        return new WidgetChannelTopicViewModel.StoreState.Guild.Topic(channel, map, channelType, map2, map3, map4, bool.booleanValue(), this.$navState.isRightPanelOpened(), this.$navState.isOnHomeTab());
    }
}
