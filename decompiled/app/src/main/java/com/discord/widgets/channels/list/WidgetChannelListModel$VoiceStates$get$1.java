package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import d0.z.d.Intrinsics3;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func6;

/* compiled from: WidgetChannelListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0016\u001a6\u0012\b\u0012\u00060\u0001j\u0002`\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012 \u0004*\u001a\u0012\b\u0012\u00060\u0001j\u0002`\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0018\u00010\u00000\u00002.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002.\u0010\u0007\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0006 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00000\u00002.\u0010\t\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\b \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u00000\u000026\u0010\f\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\nj\u0002`\u000b \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\nj\u0002`\u000b\u0018\u00010\u00000\u00002.\u0010\u000f\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\r\u0012\u0004\u0012\u00020\u000e \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00000\u000026\u0010\u0011\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\r\u0012\b\u0012\u00060\u0001j\u0002`\u0010 \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\r\u0012\b\u0012\u00060\u0001j\u0002`\u0010\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0014\u0010\u0015"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/domain/ModelApplicationStream;", "kotlin.jvm.PlatformType", "guildStreams", "Lcom/discord/api/voice/state/VoiceState;", "voiceStates", "Lcom/discord/models/user/User;", "users", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "guildMembers", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "guildChannels", "Lcom/discord/api/permission/PermissionBit;", "guildPermissions", "", "Lcom/discord/widgets/channels/list/items/ChannelListItemVoiceUser;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelListModel$VoiceStates$get$1<T1, T2, T3, T4, T5, T6, R> implements Func6<Map<Long, ? extends ModelApplicationStream>, Map<Long, ? extends VoiceState>, Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<Long, ? extends List<? extends ChannelListItemVoiceUser>>> {
    public final /* synthetic */ Comparator $voiceUserComparator;

    public WidgetChannelListModel$VoiceStates$get$1(Comparator comparator) {
        this.$voiceUserComparator = comparator;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ Map<Long, ? extends List<? extends ChannelListItemVoiceUser>> call(Map<Long, ? extends ModelApplicationStream> map, Map<Long, ? extends VoiceState> map2, Map<Long, ? extends User> map3, Map<Long, ? extends GuildMember> map4, Map<Long, ? extends Channel> map5, Map<Long, ? extends Long> map6) {
        return call2(map, (Map<Long, VoiceState>) map2, map3, (Map<Long, GuildMember>) map4, (Map<Long, Channel>) map5, (Map<Long, Long>) map6);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, List<ChannelListItemVoiceUser>> call2(Map<Long, ? extends ModelApplicationStream> map, Map<Long, VoiceState> map2, Map<Long, ? extends User> map3, Map<Long, GuildMember> map4, Map<Long, Channel> map5, Map<Long, Long> map6) {
        WidgetChannelListModel.VoiceStates voiceStates = WidgetChannelListModel.VoiceStates.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(map2, "voiceStates");
        Intrinsics3.checkNotNullExpressionValue(map3, "users");
        Intrinsics3.checkNotNullExpressionValue(map4, "guildMembers");
        Intrinsics3.checkNotNullExpressionValue(map5, "guildChannels");
        Intrinsics3.checkNotNullExpressionValue(map, "guildStreams");
        Intrinsics3.checkNotNullExpressionValue(map6, "guildPermissions");
        return WidgetChannelListModel.VoiceStates.access$createVoiceStates(voiceStates, map2, map3, map4, map5, map, map6, this.$voiceUserComparator);
    }
}
