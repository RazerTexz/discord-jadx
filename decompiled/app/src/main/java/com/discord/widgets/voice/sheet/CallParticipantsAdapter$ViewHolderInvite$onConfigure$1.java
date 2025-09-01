package com.discord.widgets.voice.sheet;

import android.view.View;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: CallParticipantsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderInvite$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ CallParticipantsAdapter.ViewHolderInvite this$0;

    public CallParticipantsAdapter$ViewHolderInvite$onConfigure$1(CallParticipantsAdapter.ViewHolderInvite viewHolderInvite) {
        this.this$0 = viewHolderInvite;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1<View, Unit> onInviteFriendsClicked = CallParticipantsAdapter.ViewHolderInvite.access$getAdapter$p(this.this$0).getOnInviteFriendsClicked();
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        onInviteFriendsClicked.invoke(view);
    }
}
