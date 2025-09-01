package com.discord.widgets.channels.permissions;

import com.discord.api.permission.PermissionOverwrite;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/permission/PermissionOverwrite;", "it", "", "invoke", "(Lcom/discord/api/permission/PermissionOverwrite;)J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$4, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel6 extends Lambda implements Function1<PermissionOverwrite, Long> {
    public static final WidgetStageChannelModeratorPermissionsViewModel6 INSTANCE = new WidgetStageChannelModeratorPermissionsViewModel6();

    public WidgetStageChannelModeratorPermissionsViewModel6() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(PermissionOverwrite permissionOverwrite) {
        return Long.valueOf(invoke2(permissionOverwrite));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(PermissionOverwrite permissionOverwrite) {
        Intrinsics3.checkNotNullParameter(permissionOverwrite, "it");
        return permissionOverwrite.e();
    }
}
