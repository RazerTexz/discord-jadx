package com.discord.utilities;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Tuples2;

/* compiled from: PermissionOverwriteUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0005\u001a;\u0010\u000b\u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0007\u0012\b\u0012\u00060\u0001j\u0002`\u00070\n*\u0004\u0018\u00010\u00002\n\u0010\b\u001a\u00060\u0001j\u0002`\u00072\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0019\u0010\u0011\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/discord/api/permission/PermissionOverwrite;", "", "permission", "", "allows", "(Lcom/discord/api/permission/PermissionOverwrite;J)Z", "denies", "Lcom/discord/api/permission/PermissionBit;", "bit", "isAllowed", "Lkotlin/Pair;", "computeAllowDenyUpdateBits", "(Lcom/discord/api/permission/PermissionOverwrite;JZ)Lkotlin/Pair;", "Lcom/discord/api/channel/Channel;", "channel", "grantsAccessTo", "(Lcom/discord/api/permission/PermissionOverwrite;Lcom/discord/api/channel/Channel;)Z", "deniesAccessTo", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.PermissionOverwriteUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class PermissionOverwriteUtils {
    public static final boolean allows(PermissionOverwrite permissionOverwrite, long j) {
        Intrinsics3.checkNotNullParameter(permissionOverwrite, "$this$allows");
        return (j & permissionOverwrite.getAllow()) != 0;
    }

    public static final Tuples2<Long, Long> computeAllowDenyUpdateBits(PermissionOverwrite permissionOverwrite, long j, boolean z2) {
        long allow = permissionOverwrite != null ? permissionOverwrite.getAllow() : 0L;
        long deny = permissionOverwrite != null ? permissionOverwrite.getDeny() : 0L;
        return z2 ? Tuples.to(Long.valueOf(allow | j), Long.valueOf((~j) & deny)) : Tuples.to(Long.valueOf(allow & (~j)), Long.valueOf(j | deny));
    }

    public static final boolean denies(PermissionOverwrite permissionOverwrite, long j) {
        Intrinsics3.checkNotNullParameter(permissionOverwrite, "$this$denies");
        return (j & permissionOverwrite.getDeny()) != 0;
    }

    public static final boolean deniesAccessTo(PermissionOverwrite permissionOverwrite, Channel channel) {
        Intrinsics3.checkNotNullParameter(permissionOverwrite, "$this$deniesAccessTo");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return denies(permissionOverwrite, Permission.VIEW_CHANNEL) || (ChannelUtils.w(channel) && denies(permissionOverwrite, Permission.CONNECT));
    }

    public static final boolean grantsAccessTo(PermissionOverwrite permissionOverwrite, Channel channel) {
        Intrinsics3.checkNotNullParameter(permissionOverwrite, "$this$grantsAccessTo");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return !deniesAccessTo(permissionOverwrite, channel) && ((ChannelUtils.u(channel) && allows(permissionOverwrite, Permission.VIEW_CHANNEL)) || (ChannelUtils.w(channel) && allows(permissionOverwrite, Permission.CONNECT)));
    }
}
