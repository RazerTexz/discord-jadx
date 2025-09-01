package com.discord.widgets.channels.permissions;

import android.view.View;
import com.discord.widgets.channels.permissions.AddMemberAdapter;
import kotlin.Metadata;

/* compiled from: AddMemberAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.AddMemberAdapter$AddMemberAdapterItemItem$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AddMemberAdapter2 implements View.OnClickListener {
    public final /* synthetic */ AddMemberAdapter.Item.PermissionOwnerItem $item;
    public final /* synthetic */ AddMemberAdapter.AddMemberAdapterItemItem this$0;

    public AddMemberAdapter2(AddMemberAdapter.AddMemberAdapterItemItem addMemberAdapterItemItem, AddMemberAdapter.Item.PermissionOwnerItem permissionOwnerItem) {
        this.this$0 = addMemberAdapterItemItem;
        this.$item = permissionOwnerItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AddMemberAdapter.AddMemberAdapterItemItem.access$handleClick(this.this$0, this.$item);
    }
}
