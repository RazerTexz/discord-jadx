package com.discord.widgets.friends;

import android.view.View;
import com.discord.models.user.User;
import com.discord.widgets.friends.FriendsListViewModel;
import com.discord.widgets.friends.WidgetFriendsListAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetFriendsListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemPendingUser$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ FriendsListViewModel.Item $data;
    public final /* synthetic */ WidgetFriendsListAdapter.ItemPendingUser this$0;

    public WidgetFriendsListAdapter$ItemPendingUser$onConfigure$1(WidgetFriendsListAdapter.ItemPendingUser itemPendingUser, FriendsListViewModel.Item item) {
        this.this$0 = itemPendingUser;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function2<View, User, Unit> onClickUserProfile = WidgetFriendsListAdapter.ItemPendingUser.access$getAdapter$p(this.this$0).getOnClickUserProfile();
        Intrinsics3.checkNotNullExpressionValue(view, "view");
        onClickUserProfile.invoke(view, ((FriendsListViewModel.Item.PendingFriendRequest) this.$data).getUser());
    }
}
