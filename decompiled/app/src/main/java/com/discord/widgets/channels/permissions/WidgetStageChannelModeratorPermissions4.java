package com.discord.widgets.channels.permissions;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetStageChannelModeratorPermissions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel;", "invoke", "()Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissions4 extends Lambda implements Function0<WidgetStageChannelModeratorPermissionsViewModel> {
    public final /* synthetic */ WidgetStageChannelModeratorPermissions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageChannelModeratorPermissions4(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
        super(0);
        this.this$0 = widgetStageChannelModeratorPermissions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetStageChannelModeratorPermissionsViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetStageChannelModeratorPermissionsViewModel invoke() {
        return new WidgetStageChannelModeratorPermissionsViewModel(WidgetStageChannelModeratorPermissions.access$getChannelId$p(this.this$0));
    }
}
