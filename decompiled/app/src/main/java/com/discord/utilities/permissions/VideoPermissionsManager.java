package com.discord.utilities.permissions;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VideoPermissionsManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u000e\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/utilities/permissions/VideoPermissionsManager;", "", "Lcom/discord/api/channel/Channel;", "channel", "", "Lcom/discord/primitives/ChannelId;", "channelIdAFK", "Lcom/discord/api/permission/PermissionBit;", "computedPermissions", "", "hasVideoPermission", "(Lcom/discord/api/channel/Channel;Ljava/lang/Long;Ljava/lang/Long;)Z", "Lcom/discord/utilities/permissions/PermissionsManager;", "permissionsManager", "Lcom/discord/utilities/permissions/PermissionsManager;", "<init>", "(Lcom/discord/utilities/permissions/PermissionsManager;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class VideoPermissionsManager {
    private final PermissionsManager permissionsManager;

    public VideoPermissionsManager() {
        this(null, 1, null);
    }

    public VideoPermissionsManager(PermissionsManager permissionsManager) {
        Intrinsics3.checkNotNullParameter(permissionsManager, "permissionsManager");
        this.permissionsManager = permissionsManager;
    }

    public final boolean hasVideoPermission(Channel channel, Long channelIdAFK, Long computedPermissions) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        long id2 = channel.getId();
        if (channelIdAFK != null && id2 == channelIdAFK.longValue()) {
            return false;
        }
        if (ChannelUtils.B(channel)) {
            return true;
        }
        return this.permissionsManager.can(512L, computedPermissions);
    }

    public /* synthetic */ VideoPermissionsManager(PermissionsManager permissionsManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new PermissionsManager() : permissionsManager);
    }
}
