package com.discord.widgets.channels.permissions;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetStageChannelModeratorPermissionsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetStageChannelModeratorPermissions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetStageChannelModeratorPermissionsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetStageChannelModeratorPermissionsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$viewBinding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageChannelModeratorPermissions3 extends FunctionReferenceImpl implements Function1<View, WidgetStageChannelModeratorPermissionsBinding> {
    public static final WidgetStageChannelModeratorPermissions3 INSTANCE = new WidgetStageChannelModeratorPermissions3();

    public WidgetStageChannelModeratorPermissions3() {
        super(1, WidgetStageChannelModeratorPermissionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageChannelModeratorPermissionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStageChannelModeratorPermissionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStageChannelModeratorPermissionsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.add_permission_owner_button;
        AddPermissionOwnerView addPermissionOwnerView = (AddPermissionOwnerView) view.findViewById(R.id.add_permission_owner_button);
        if (addPermissionOwnerView != null) {
            i = R.id.members_permission_owners_list;
            PermissionOwnerListView permissionOwnerListView = (PermissionOwnerListView) view.findViewById(R.id.members_permission_owners_list);
            if (permissionOwnerListView != null) {
                i = R.id.roles_permission_owners_list;
                PermissionOwnerListView permissionOwnerListView2 = (PermissionOwnerListView) view.findViewById(R.id.roles_permission_owners_list);
                if (permissionOwnerListView2 != null) {
                    return new WidgetStageChannelModeratorPermissionsBinding((CoordinatorLayout) view, addPermissionOwnerView, permissionOwnerListView, permissionOwnerListView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
