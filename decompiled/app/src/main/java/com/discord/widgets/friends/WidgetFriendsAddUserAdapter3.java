package com.discord.widgets.friends;

import android.view.View;
import com.discord.widgets.friends.WidgetFriendsAddUserAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetFriendsAddUserAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.friends.WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetFriendsAddUserAdapter3 implements View.OnClickListener {
    public final /* synthetic */ boolean $incomingFriendRequest;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ WidgetFriendsAddUserAdapter.UserViewHolder this$0;

    public WidgetFriendsAddUserAdapter3(WidgetFriendsAddUserAdapter.UserViewHolder userViewHolder, long j, boolean z2) {
        this.this$0 = userViewHolder;
        this.$userId = j;
        this.$incomingFriendRequest = z2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function2 function2Access$getDeclineHandler$p = WidgetFriendsAddUserAdapter.access$getDeclineHandler$p(WidgetFriendsAddUserAdapter.UserViewHolder.access$getAdapter$p(this.this$0));
        if (function2Access$getDeclineHandler$p != null) {
        }
    }
}
