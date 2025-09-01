package com.discord.widgets.friends;

import android.view.View;
import com.discord.widgets.friends.FriendsListViewModel;
import com.discord.widgets.friends.WidgetFriendsListAdapter;
import kotlin.Metadata;

/* compiled from: WidgetFriendsListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemUser$onConfigure$3 implements View.OnClickListener {
    public final /* synthetic */ FriendsListViewModel.Item.Friend $item;
    public final /* synthetic */ WidgetFriendsListAdapter.ItemUser this$0;

    public WidgetFriendsListAdapter$ItemUser$onConfigure$3(WidgetFriendsListAdapter.ItemUser itemUser, FriendsListViewModel.Item.Friend friend) {
        this.this$0 = itemUser;
        this.$item = friend;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetFriendsListAdapter.ItemUser.access$getAdapter$p(this.this$0).getOnClickChat().invoke(this.$item.getUser());
    }
}
