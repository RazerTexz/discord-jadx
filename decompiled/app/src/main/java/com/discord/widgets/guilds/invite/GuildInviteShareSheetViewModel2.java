package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func7;

/* compiled from: GuildInviteShareSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0015\u001a\n \u0001*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002.\u0010\u0007\u001a*\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006 \u0001*\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00030\u00032\u000e\u0010\t\u001a\n \u0001*\u0004\u0018\u00010\b0\b2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0006 \u0001*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n0\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000e \u0001*\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\n0\n2.\u0010\u0011\u001a*\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0010 \u0001*\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0013\u0010\u0014"}, d2 = {"Lcom/discord/models/domain/ModelInvite$Settings;", "kotlin.jvm.PlatformType", "inviteSettings", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "invitableChannels", "Lcom/discord/models/user/MeUser;", "me", "", "dms", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/widgets/guilds/invite/InviteSuggestion;", "inviteSuggestions", "Lcom/discord/api/stageinstance/StageInstance;", "guildStageInstances", "Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelInvite$Settings;Ljava/util/Map;Lcom/discord/models/user/MeUser;Ljava/util/List;Lcom/discord/models/guild/Guild;Ljava/util/List;Ljava/util/Map;)Lcom/discord/widgets/guilds/invite/GuildInviteShareSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildInviteShareSheetViewModel2<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<ModelInvite.Settings, Map<Long, ? extends Channel>, MeUser, List<? extends Channel>, Guild, List<? extends InviteSuggestion>, Map<Long, ? extends StageInstance>, GuildInviteShareSheetViewModel.StoreState> {
    public static final GuildInviteShareSheetViewModel2 INSTANCE = new GuildInviteShareSheetViewModel2();

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ GuildInviteShareSheetViewModel.StoreState call(ModelInvite.Settings settings, Map<Long, ? extends Channel> map, MeUser meUser, List<? extends Channel> list, Guild guild, List<? extends InviteSuggestion> list2, Map<Long, ? extends StageInstance> map2) {
        return call2(settings, (Map<Long, Channel>) map, meUser, (List<Channel>) list, guild, list2, (Map<Long, StageInstance>) map2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildInviteShareSheetViewModel.StoreState call2(ModelInvite.Settings settings, Map<Long, Channel> map, MeUser meUser, List<Channel> list, Guild guild, List<? extends InviteSuggestion> list2, Map<Long, StageInstance> map2) {
        if (guild == null) {
            return GuildInviteShareSheetViewModel.StoreState.Invalid.INSTANCE;
        }
        Intrinsics3.checkNotNullExpressionValue(settings, "inviteSettings");
        Intrinsics3.checkNotNullExpressionValue(map, "invitableChannels");
        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
        Intrinsics3.checkNotNullExpressionValue(list, "dms");
        Intrinsics3.checkNotNullExpressionValue(list2, "inviteSuggestions");
        Intrinsics3.checkNotNullExpressionValue(map2, "guildStageInstances");
        return new GuildInviteShareSheetViewModel.StoreState.Valid(settings, map, meUser, list, guild, list2, map2);
    }
}
