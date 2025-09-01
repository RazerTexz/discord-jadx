package com.discord.widgets.chat.managereactions;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.databinding.WidgetManageReactionsEmojiBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ManageReactionsEmojisAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/chat/managereactions/ManageReactionsEmojisAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/chat/managereactions/ManageReactionsEmojisAdapter$ReactionEmojiItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function1;", "", "", "onEmojiSelectedListener", "Lkotlin/jvm/functions/Function1;", "getOnEmojiSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnEmojiSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Companion", "ReactionEmojiItem", "ReactionEmojiViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ManageReactionsEmojisAdapter extends MGRecyclerAdapterSimple<ReactionEmojiItem> {
    private static final int TYPE_REACTION_EMOJI_ITEM = 0;
    private Function1<? super String, Unit> onEmojiSelectedListener;

    /* compiled from: ManageReactionsEmojisAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\u0019\u001a\u00020\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0011R\u001c\u0010\u001c\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u000e¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/managereactions/ManageReactionsEmojisAdapter$ReactionEmojiItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/api/message/reaction/MessageReaction;", "component1", "()Lcom/discord/api/message/reaction/MessageReaction;", "", "component2", "()Z", "reaction", "isSelected", "copy", "(Lcom/discord/api/message/reaction/MessageReaction;Z)Lcom/discord/widgets/chat/managereactions/ManageReactionsEmojisAdapter$ReactionEmojiItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/api/message/reaction/MessageReaction;", "getReaction", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "<init>", "(Lcom/discord/api/message/reaction/MessageReaction;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ReactionEmojiItem implements MGRecyclerDataPayload {
        private final boolean isSelected;
        private final String key;
        private final MessageReaction reaction;
        private final int type;

        public ReactionEmojiItem(MessageReaction messageReaction, boolean z2) {
            Intrinsics3.checkNotNullParameter(messageReaction, "reaction");
            this.reaction = messageReaction;
            this.isSelected = z2;
            this.key = messageReaction.getEmoji().c();
        }

        public static /* synthetic */ ReactionEmojiItem copy$default(ReactionEmojiItem reactionEmojiItem, MessageReaction messageReaction, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                messageReaction = reactionEmojiItem.reaction;
            }
            if ((i & 2) != 0) {
                z2 = reactionEmojiItem.isSelected;
            }
            return reactionEmojiItem.copy(messageReaction, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final MessageReaction getReaction() {
            return this.reaction;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public final ReactionEmojiItem copy(MessageReaction reaction, boolean isSelected) {
            Intrinsics3.checkNotNullParameter(reaction, "reaction");
            return new ReactionEmojiItem(reaction, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReactionEmojiItem)) {
                return false;
            }
            ReactionEmojiItem reactionEmojiItem = (ReactionEmojiItem) other;
            return Intrinsics3.areEqual(this.reaction, reactionEmojiItem.reaction) && this.isSelected == reactionEmojiItem.isSelected;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final MessageReaction getReaction() {
            return this.reaction;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MessageReaction messageReaction = this.reaction;
            int iHashCode = (messageReaction != null ? messageReaction.hashCode() : 0) * 31;
            boolean z2 = this.isSelected;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ReactionEmojiItem(reaction=");
            sbU.append(this.reaction);
            sbU.append(", isSelected=");
            return outline.O(sbU, this.isSelected, ")");
        }
    }

    /* compiled from: ManageReactionsEmojisAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/chat/managereactions/ManageReactionsEmojisAdapter$ReactionEmojiViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/chat/managereactions/ManageReactionsEmojisAdapter;", "Lcom/discord/widgets/chat/managereactions/ManageReactionsEmojisAdapter$ReactionEmojiItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/chat/managereactions/ManageReactionsEmojisAdapter$ReactionEmojiItem;)V", "Lcom/discord/databinding/WidgetManageReactionsEmojiBinding;", "binding", "Lcom/discord/databinding/WidgetManageReactionsEmojiBinding;", "adapter", "<init>", "(Lcom/discord/widgets/chat/managereactions/ManageReactionsEmojisAdapter;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ReactionEmojiViewHolder extends MGRecyclerViewHolder<ManageReactionsEmojisAdapter, ReactionEmojiItem> {
        private static final int emojiSizePx = DimenUtils.dpToPixels(20);
        private final WidgetManageReactionsEmojiBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReactionEmojiViewHolder(ManageReactionsEmojisAdapter manageReactionsEmojisAdapter) {
            super(R.layout.widget_manage_reactions_emoji, manageReactionsEmojisAdapter);
            Intrinsics3.checkNotNullParameter(manageReactionsEmojisAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.manage_reactions_emoji_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.manage_reactions_emoji_container);
            if (linearLayout != null) {
                i = R.id.manage_reactions_emoji_counter;
                TextView textView = (TextView) view.findViewById(R.id.manage_reactions_emoji_counter);
                if (textView != null) {
                    i = R.id.manage_reactions_emoji_emoji_textview;
                    SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R.id.manage_reactions_emoji_emoji_textview);
                    if (simpleDraweeSpanTextView != null) {
                        i = R.id.manage_reactions_emoji_selected_indicator;
                        View viewFindViewById = view.findViewById(R.id.manage_reactions_emoji_selected_indicator);
                        if (viewFindViewById != null) {
                            WidgetManageReactionsEmojiBinding widgetManageReactionsEmojiBinding = new WidgetManageReactionsEmojiBinding((RelativeLayout) view, linearLayout, textView, simpleDraweeSpanTextView, viewFindViewById);
                            Intrinsics3.checkNotNullExpressionValue(widgetManageReactionsEmojiBinding, "WidgetManageReactionsEmojiBinding.bind(itemView)");
                            this.binding = widgetManageReactionsEmojiBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ ManageReactionsEmojisAdapter access$getAdapter$p(ReactionEmojiViewHolder reactionEmojiViewHolder) {
            return (ManageReactionsEmojisAdapter) reactionEmojiViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ReactionEmojiItem reactionEmojiItem) {
            onConfigure2(i, reactionEmojiItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ReactionEmojiItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            EmojiNode.Companion companion = EmojiNode.INSTANCE;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.manageReactionsEmojiEmojiTextview");
            companion.renderEmoji(simpleDraweeSpanTextView, data.getReaction().getEmoji(), true, emojiSizePx);
            TextView textView = this.binding.f2483b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.manageReactionsEmojiCounter");
            textView.setText(String.valueOf(data.getReaction().getCount()));
            View view = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.manageReactionsEmojiSelectedIndicator");
            view.setVisibility(data.isSelected() ? 0 : 4);
            this.binding.a.setOnClickListener(new ManageReactionsEmojisAdapter2(this, data));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageReactionsEmojisAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    public final Function1<String, Unit> getOnEmojiSelectedListener() {
        return this.onEmojiSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnEmojiSelectedListener(Function1<? super String, Unit> function1) {
        this.onEmojiSelectedListener = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, ReactionEmojiItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new ReactionEmojiViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
