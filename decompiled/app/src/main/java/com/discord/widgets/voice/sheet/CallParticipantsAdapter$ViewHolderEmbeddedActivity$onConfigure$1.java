package com.discord.widgets.voice.sheet;

import android.view.View;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;
import kotlin.Metadata;

/* compiled from: CallParticipantsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderEmbeddedActivity$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ CallParticipantsAdapter.ViewHolderEmbeddedActivity this$0;

    public CallParticipantsAdapter$ViewHolderEmbeddedActivity$onConfigure$1(CallParticipantsAdapter.ViewHolderEmbeddedActivity viewHolderEmbeddedActivity) {
        this.this$0 = viewHolderEmbeddedActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CallParticipantsAdapter.ViewHolderEmbeddedActivity.access$getAdapter$p(this.this$0).getOnEmbeddedActivityClicked().invoke();
    }
}
