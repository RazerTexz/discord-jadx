package com.discord.widgets.channels.permissions;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: PermissionOwnerListView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/PermissionOwner;", "it", "", "invoke", "(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.PermissionOwnerListView$Adapter$onRemoveClicked$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class PermissionOwnerListView3 extends Lambda implements Function1<PermissionOwner, Unit> {
    public static final PermissionOwnerListView3 INSTANCE = new PermissionOwnerListView3();

    public PermissionOwnerListView3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PermissionOwner permissionOwner) {
        invoke2(permissionOwner);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PermissionOwner permissionOwner) {
        Intrinsics3.checkNotNullParameter(permissionOwner, "it");
    }
}
