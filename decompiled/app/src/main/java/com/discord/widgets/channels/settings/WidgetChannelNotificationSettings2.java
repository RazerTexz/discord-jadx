package com.discord.widgets.channels.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.NotificationTextUtils;
import com.discord.stores.StoreGuildProfiles;
import com.discord.stores.StoreThreadsJoined;
import com.discord.utilities.channel.ChannelNotificationSettingsUtils;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func6;

/* compiled from: WidgetChannelNotificationSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bH\n¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "joinedThread", "Lcom/discord/api/channel/Channel;", "parentChannel", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/domain/ModelNotificationSettings;", "kotlin.jvm.PlatformType", "guildSettings", "Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "guildProfile", "", "canAccessRedesignedForumChannels", "Lcom/discord/widgets/channels/settings/WidgetChannelNotificationSettings$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreThreadsJoined$JoinedThread;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Lcom/discord/models/domain/ModelNotificationSettings;Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;Ljava/lang/Boolean;)Lcom/discord/widgets/channels/settings/WidgetChannelNotificationSettings$Model;", "com/discord/widgets/channels/settings/WidgetChannelNotificationSettings$Model$Companion$get$1$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$Model$Companion$get$1$$special$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings2<T1, T2, T3, T4, T5, T6, R> implements Func6<StoreThreadsJoined.JoinedThread, Channel, Guild, ModelNotificationSettings, StoreGuildProfiles.GuildProfileData, Boolean, WidgetChannelNotificationSettings.Model> {
    public final /* synthetic */ Channel $channel$inlined;

    public WidgetChannelNotificationSettings2(Channel channel) {
        this.$channel$inlined = channel;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetChannelNotificationSettings.Model call(StoreThreadsJoined.JoinedThread joinedThread, Channel channel, Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData, Boolean bool) {
        return call2(joinedThread, channel, guild, modelNotificationSettings, guildProfileData, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelNotificationSettings.Model call2(StoreThreadsJoined.JoinedThread joinedThread, Channel channel, Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData, Boolean bool) {
        int iComputeNotificationSetting;
        String muteEndTime;
        String str;
        GuildPreview data;
        ModelMuteConfig muteConfig;
        if (guild == null) {
            return null;
        }
        NotificationTextUtils notificationTextUtils = NotificationTextUtils.INSTANCE;
        Integer numChannelMessageNotificationLevel = notificationTextUtils.channelMessageNotificationLevel(modelNotificationSettings, channel, guild);
        if (ChannelUtils.H(this.$channel$inlined)) {
            int iComputeThreadNotificationSetting = ThreadUtils.INSTANCE.computeThreadNotificationSetting(joinedThread, notificationTextUtils.isGuildOrCategoryOrChannelMuted(modelNotificationSettings, channel), numChannelMessageNotificationLevel);
            iComputeNotificationSetting = iComputeThreadNotificationSetting != 4 ? iComputeThreadNotificationSetting != 8 ? ModelNotificationSettings.FREQUENCY_ALL : ModelNotificationSettings.FREQUENCY_NOTHING : ModelNotificationSettings.FREQUENCY_MENTIONS;
        } else {
            ChannelNotificationSettingsUtils channelNotificationSettingsUtils = ChannelNotificationSettingsUtils.INSTANCE;
            Channel channel2 = this.$channel$inlined;
            Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "guildSettings");
            iComputeNotificationSetting = channelNotificationSettingsUtils.computeNotificationSetting(guild, channel2, modelNotificationSettings);
        }
        int i = iComputeNotificationSetting;
        ModelNotificationSettings.ChannelOverride channelOverride = modelNotificationSettings.getChannelOverride(this.$channel$inlined.getId());
        boolean z2 = !ChannelUtils.H(this.$channel$inlined) ? channelOverride == null || !channelOverride.isMuted() : joinedThread == null || !joinedThread.getMuted();
        if (ChannelUtils.H(this.$channel$inlined)) {
            if (joinedThread != null && (muteConfig = joinedThread.getMuteConfig()) != null) {
                muteEndTime = muteConfig.getEndTime();
                str = muteEndTime;
            }
            str = null;
        } else {
            if (channelOverride != null) {
                muteEndTime = channelOverride.getMuteEndTime();
                str = muteEndTime;
            }
            str = null;
        }
        boolean z3 = i == ModelNotificationSettings.FREQUENCY_UNSET;
        Integer numValueOf = channelOverride != null ? Integer.valueOf(channelOverride.getForumPostNotificationSetting()) : null;
        Integer approximateMemberCount = (guildProfileData == null || (data = guildProfileData.getData()) == null) ? null : data.getApproximateMemberCount();
        boolean z4 = approximateMemberCount != null && approximateMemberCount.intValue() > 2500;
        Channel channel3 = this.$channel$inlined;
        Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "guildSettings");
        boolean zIsMuted = modelNotificationSettings.isMuted();
        Integer numValueOf2 = channelOverride != null ? Integer.valueOf(channelOverride.getFlags()) : null;
        Intrinsics3.checkNotNullExpressionValue(bool, "canAccessRedesignedForumChannels");
        return new WidgetChannelNotificationSettings.Model(channel3, z2, str, zIsMuted, i, numValueOf2, numValueOf, numChannelMessageNotificationLevel, z3, z4, bool.booleanValue());
    }
}
