package com.discord.widgets.channels.invite;

import android.view.View;
import com.discord.models.user.User;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetAdapter;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GroupInviteFriendsSheetAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GroupInviteFriendsSheetAdapter2 implements View.OnClickListener {
    public final /* synthetic */ User $modelUser;
    public final /* synthetic */ GroupInviteFriendsSheetAdapter.GroupInviteFriendsListItem this$0;

    public GroupInviteFriendsSheetAdapter2(GroupInviteFriendsSheetAdapter.GroupInviteFriendsListItem groupInviteFriendsListItem, User user) {
        this.this$0 = groupInviteFriendsListItem;
        this.$modelUser = user;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MaterialCheckBox materialCheckBox = GroupInviteFriendsSheetAdapter.GroupInviteFriendsListItem.access$getBinding$p(this.this$0).d;
        Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.userSelectedCheckbox");
        GroupInviteFriendsSheetAdapter.GroupInviteFriendsListItem.access$getAdapter$p(this.this$0).getOnUserChecked().invoke(this.$modelUser, Boolean.valueOf(materialCheckBox.isChecked()));
    }
}
