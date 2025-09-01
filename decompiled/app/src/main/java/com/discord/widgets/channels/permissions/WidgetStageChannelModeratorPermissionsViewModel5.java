package com.discord.widgets.channels.permissions;

import com.discord.api.permission.PermissionOverwrite;
import com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/permission/PermissionOverwrite;", "it", "", "invoke", "(Lcom/discord/api/permission/PermissionOverwrite;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel5 extends Lambda implements Function1<PermissionOverwrite, Boolean> {
    public final /* synthetic */ WidgetStageChannelModeratorPermissionsViewModel.StoreState $storeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageChannelModeratorPermissionsViewModel5(WidgetStageChannelModeratorPermissionsViewModel.StoreState storeState) {
        super(1);
        this.$storeState = storeState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(PermissionOverwrite permissionOverwrite) {
        return Boolean.valueOf(invoke2(permissionOverwrite));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(PermissionOverwrite permissionOverwrite) {
        Intrinsics3.checkNotNullParameter(permissionOverwrite, "it");
        return !((WidgetStageChannelModeratorPermissionsViewModel.StoreState.Valid) this.$storeState).getGuild().isOwner(permissionOverwrite.e());
    }
}
