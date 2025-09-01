package com.discord.widgets.channels;

import android.view.View;
import com.discord.models.user.User;
import com.discord.widgets.channels.SimpleMembersAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: SimpleMembersAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.SimpleMembersAdapter$MemberAdapterItem$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SimpleMembersAdapter2 implements View.OnClickListener {
    public final /* synthetic */ User $user;
    public final /* synthetic */ SimpleMembersAdapter.MemberAdapterItem this$0;

    public SimpleMembersAdapter2(SimpleMembersAdapter.MemberAdapterItem memberAdapterItem, User user) {
        this.this$0 = memberAdapterItem;
        this.$user = user;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1 function1Access$getOnUserClickedListener$p = SimpleMembersAdapter.access$getOnUserClickedListener$p(SimpleMembersAdapter.MemberAdapterItem.access$getAdapter$p(this.this$0));
        if (function1Access$getOnUserClickedListener$p != null) {
        }
    }
}
