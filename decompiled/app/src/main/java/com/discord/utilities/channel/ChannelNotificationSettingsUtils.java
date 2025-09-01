package com.discord.utilities.channel;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChannelNotificationSettingsUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/utilities/channel/ChannelNotificationSettingsUtils;", "", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/models/domain/ModelNotificationSettings;", "guildSettings", "", "computeNotificationSetting", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Lcom/discord/models/domain/ModelNotificationSettings;)I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelNotificationSettingsUtils {
    public static final ChannelNotificationSettingsUtils INSTANCE = new ChannelNotificationSettingsUtils();

    private ChannelNotificationSettingsUtils() {
    }

    public final int computeNotificationSetting(Guild guild, Channel channel, ModelNotificationSettings guildSettings) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(guildSettings, "guildSettings");
        ModelNotificationSettings.ChannelOverride channelOverride = guildSettings.getChannelOverride(channel.getId());
        int messageNotifications = channelOverride != null ? channelOverride.getMessageNotifications() : ModelNotificationSettings.FREQUENCY_UNSET;
        if (messageNotifications != ModelNotificationSettings.FREQUENCY_UNSET) {
            return messageNotifications;
        }
        int messageNotifications2 = guildSettings.getMessageNotifications();
        return messageNotifications2 == ModelNotificationSettings.FREQUENCY_UNSET ? guild.getDefaultMessageNotifications() : messageNotifications2;
    }
}
