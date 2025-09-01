package com.discord.widgets.chat.managereactions;

import android.view.View;
import com.discord.widgets.chat.managereactions.ManageReactionsEmojisAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ManageReactionsEmojisAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsEmojisAdapter$ReactionEmojiViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ManageReactionsEmojisAdapter2 implements View.OnClickListener {
    public final /* synthetic */ ManageReactionsEmojisAdapter.ReactionEmojiItem $data;
    public final /* synthetic */ ManageReactionsEmojisAdapter.ReactionEmojiViewHolder this$0;

    public ManageReactionsEmojisAdapter2(ManageReactionsEmojisAdapter.ReactionEmojiViewHolder reactionEmojiViewHolder, ManageReactionsEmojisAdapter.ReactionEmojiItem reactionEmojiItem) {
        this.this$0 = reactionEmojiViewHolder;
        this.$data = reactionEmojiItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1<String, Unit> onEmojiSelectedListener = ManageReactionsEmojisAdapter.ReactionEmojiViewHolder.access$getAdapter$p(this.this$0).getOnEmojiSelectedListener();
        if (onEmojiSelectedListener != null) {
            onEmojiSelectedListener.invoke(this.$data.getReaction().getEmoji().c());
        }
    }
}
