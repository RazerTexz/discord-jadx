package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite;
import com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: GuildInviteSettingsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\n \u0001*\u0004\u0018\u00010\b0\b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002.\u0010\u0007\u001a*\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006 \u0001*\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/discord/models/domain/ModelInvite$Settings;", "kotlin.jvm.PlatformType", "inviteSettings", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "invitableChannels", "Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelInvite$Settings;Ljava/util/Map;)Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildInviteSettingsViewModel2<T1, T2, R> implements Func2<ModelInvite.Settings, Map<Long, ? extends Channel>, GuildInviteSettingsViewModel.StoreState> {
    public static final GuildInviteSettingsViewModel2 INSTANCE = new GuildInviteSettingsViewModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ GuildInviteSettingsViewModel.StoreState call(ModelInvite.Settings settings, Map<Long, ? extends Channel> map) {
        return call2(settings, (Map<Long, Channel>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildInviteSettingsViewModel.StoreState call2(ModelInvite.Settings settings, Map<Long, Channel> map) {
        Intrinsics3.checkNotNullExpressionValue(settings, "inviteSettings");
        Intrinsics3.checkNotNullExpressionValue(map, "invitableChannels");
        return new GuildInviteSettingsViewModel.StoreState(settings, map);
    }
}
