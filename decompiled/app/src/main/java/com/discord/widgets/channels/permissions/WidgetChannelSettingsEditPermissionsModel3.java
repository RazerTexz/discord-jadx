package com.discord.widgets.channels.permissions;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel;
import com.discord.widgets.chat.list.NewThreadsPermissionsFeatureFlag;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;", "invoke", "()Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel$Companion$getForUser$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissionsModel3 extends Lambda implements Function0<WidgetChannelSettingsEditPermissionsModel> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ long $targetUserId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsEditPermissionsModel3(StoreChannels storeChannels, long j, StoreUser storeUser, long j2, StoreGuilds storeGuilds, long j3, StorePermissions storePermissions) {
        super(0);
        this.$storeChannels = storeChannels;
        this.$channelId = j;
        this.$storeUser = storeUser;
        this.$targetUserId = j2;
        this.$storeGuilds = storeGuilds;
        this.$guildId = j3;
        this.$storePermissions = storePermissions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChannelSettingsEditPermissionsModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelSettingsEditPermissionsModel invoke() {
        Channel channel = this.$storeChannels.getChannel(this.$channelId);
        MeUser meSnapshot = this.$storeUser.getMeSnapshot();
        User user = this.$storeUser.getUsers().get(Long.valueOf(this.$targetUserId));
        Guild guild = this.$storeGuilds.getGuild(this.$guildId);
        Long l = this.$storePermissions.getPermissionsByChannel().get(Long.valueOf(this.$channelId));
        boolean zIsEnabled = NewThreadsPermissionsFeatureFlag.INSTANCE.getINSTANCE().isEnabled(this.$guildId);
        if (channel == null || guild == null || user == null || l == null || !WidgetChannelSettingsEditPermissionsModel.Companion.access$isAbleToManagePerms(WidgetChannelSettingsEditPermissionsModel.INSTANCE, guild, meSnapshot, l.longValue())) {
            return null;
        }
        return new WidgetChannelSettingsEditPermissionsModel.ModelForUser(channel, l.longValue(), user.getId() == meSnapshot.getId(), user, this.$storeGuilds.getMember(this.$guildId, user.getId()), zIsEnabled);
    }
}
