package com.discord.widgets.chat.managereactions;

import android.view.View;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter;
import kotlin.Metadata;

/* compiled from: ManageReactionsResultsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter$ReactionUserViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ManageReactionsResultsAdapter3 implements View.OnClickListener {
    public final /* synthetic */ MGRecyclerDataPayload $data;

    public ManageReactionsResultsAdapter3(MGRecyclerDataPayload mGRecyclerDataPayload) {
        this.$data = mGRecyclerDataPayload;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StoreStream.INSTANCE.getMessageReactions().deleteEmoji(((ManageReactionsResultsAdapter.ReactionUserItem) this.$data).getChannelId(), ((ManageReactionsResultsAdapter.ReactionUserItem) this.$data).getMessageId(), ((ManageReactionsResultsAdapter.ReactionUserItem) this.$data).getEmoji(), ((ManageReactionsResultsAdapter.ReactionUserItem) this.$data).getUser().getId());
    }
}
