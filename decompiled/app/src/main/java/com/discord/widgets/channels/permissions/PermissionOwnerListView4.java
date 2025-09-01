package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.widgets.channels.permissions.PermissionOwnerListView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: PermissionOwnerListView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.PermissionOwnerListView$PermissionOwnerViewHolder$configure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class PermissionOwnerListView4 implements View.OnClickListener {
    public final /* synthetic */ PermissionOwnerListView.Item $item;
    public final /* synthetic */ Function0 $onRemoveClicked;
    public final /* synthetic */ PermissionOwnerListView.PermissionOwnerViewHolder this$0;

    public PermissionOwnerListView4(PermissionOwnerListView.PermissionOwnerViewHolder permissionOwnerViewHolder, PermissionOwnerListView.Item item, Function0 function0) {
        this.this$0 = permissionOwnerViewHolder;
        this.$item = item;
        this.$onRemoveClicked = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PermissionOwnerListView.RemoveStatus removeStatus = this.$item.getRemoveStatus();
        if (Intrinsics3.areEqual(removeStatus, PermissionOwnerListView.RemoveStatus.CanRemove.INSTANCE)) {
            this.$onRemoveClicked.invoke();
            return;
        }
        if (!Intrinsics3.areEqual(removeStatus, PermissionOwnerListView.RemoveStatus.IsRemoving.INSTANCE) && (removeStatus instanceof PermissionOwnerListView.RemoveStatus.CannotRemove)) {
            int iOrdinal = ((PermissionOwnerListView.RemoveStatus.CannotRemove) this.$item.getRemoveStatus()).getReason().ordinal();
            if (iOrdinal == 2) {
                ConstraintLayout constraintLayout = PermissionOwnerListView.PermissionOwnerViewHolder.access$getBinding$p(this.this$0).a;
                Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
                Toast.makeText(constraintLayout.getContext(), R.string.channel_permissions_remove_not_overwrite, 0).show();
            } else {
                if (iOrdinal != 3) {
                    return;
                }
                ConstraintLayout constraintLayout2 = PermissionOwnerListView.PermissionOwnerViewHolder.access$getBinding$p(this.this$0).a;
                Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.root");
                Toast.makeText(constraintLayout2.getContext(), R.string.channel_permissions_cannot_edit_moderators, 0).show();
            }
        }
    }
}
