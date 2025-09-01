package com.discord.widgets.user;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.user.WidgetUserMutualFriends;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetUserMutualFriends.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.WidgetUserMutualFriends$MutualFriendsAdapter$ViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserMutualFriends3 implements View.OnClickListener {
    public final /* synthetic */ WidgetUserMutualFriends.Model.Item.MutualFriend $data;
    public final /* synthetic */ WidgetUserMutualFriends.MutualFriendsAdapter.ViewHolder this$0;

    public WidgetUserMutualFriends3(WidgetUserMutualFriends.MutualFriendsAdapter.ViewHolder viewHolder, WidgetUserMutualFriends.Model.Item.MutualFriend mutualFriend) {
        this.this$0 = viewHolder;
        this.$data = mutualFriend;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
        long id2 = this.$data.getUser().getId();
        FragmentManager parentFragmentManager = WidgetUserMutualFriends.MutualFriendsAdapter.access$getFragment$p(WidgetUserMutualFriends.MutualFriendsAdapter.ViewHolder.access$getAdapter$p(this.this$0)).getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "adapter.fragment.parentFragmentManager");
        WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
    }
}
