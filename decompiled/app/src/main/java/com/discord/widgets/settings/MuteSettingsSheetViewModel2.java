package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreThreadsJoined;
import com.discord.widgets.settings.MuteSettingsSheetViewModel;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func4;

/* compiled from: MuteSettingsSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000f\u001a\n \b*\u0004\u0018\u00010\f0\f2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022.\u0010\t\u001a*\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007 \b*\u0014\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00040\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/channel/Channel;", "channel", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/domain/ModelNotificationSettings;", "kotlin.jvm.PlatformType", "guildNotificationSettings", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "joinedThread", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/util/Map;Lcom/discord/stores/StoreThreadsJoined$JoinedThread;)Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.MuteSettingsSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MuteSettingsSheetViewModel2<T1, T2, T3, T4, R> implements Func4<Guild, Channel, Map<Long, ? extends ModelNotificationSettings>, StoreThreadsJoined.JoinedThread, MuteSettingsSheetViewModel.StoreState> {
    public static final MuteSettingsSheetViewModel2 INSTANCE = new MuteSettingsSheetViewModel2();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ MuteSettingsSheetViewModel.StoreState call(Guild guild, Channel channel, Map<Long, ? extends ModelNotificationSettings> map, StoreThreadsJoined.JoinedThread joinedThread) {
        return call2(guild, channel, map, joinedThread);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MuteSettingsSheetViewModel.StoreState call2(Guild guild, Channel channel, Map<Long, ? extends ModelNotificationSettings> map, StoreThreadsJoined.JoinedThread joinedThread) {
        Long lValueOf;
        long guildId;
        if (guild != null) {
            guildId = guild.getId();
        } else {
            if (channel == null) {
                lValueOf = null;
                return new MuteSettingsSheetViewModel.StoreState(guild, channel, map.get(Long.valueOf(lValueOf == null ? lValueOf.longValue() : 0L)), joinedThread);
            }
            guildId = channel.getGuildId();
        }
        lValueOf = Long.valueOf(guildId);
        return new MuteSettingsSheetViewModel.StoreState(guild, channel, map.get(Long.valueOf(lValueOf == null ? lValueOf.longValue() : 0L)), joinedThread);
    }
}
