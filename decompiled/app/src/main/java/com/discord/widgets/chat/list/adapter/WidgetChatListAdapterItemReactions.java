package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import b.a.i.ReactionQuickAddBinding;
import com.discord.R;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.databinding.WidgetChatListAdapterItemReactionsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.ReactionView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.ReactionsEntry;
import com.google.android.flexbox.FlexboxLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListAdapterItemReactions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J=\u0010\u0010\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemReactions;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "Lcom/discord/widgets/chat/list/entries/ReactionsEntry;", "data", "", "processReactions", "(Lcom/discord/widgets/chat/list/entries/ReactionsEntry;)V", "", "Lcom/discord/api/message/reaction/MessageReaction;", "reactions", "", "messageId", "", "canAddReactions", "canCreateReactions", "animateEmojis", "displayReactions", "(Ljava/util/Collection;JZZZ)V", "removeQuickAddReactionView", "()V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Landroid/widget/ImageView;", "quickAddReactionView", "Landroid/widget/ImageView;", "Lcom/discord/databinding/WidgetChatListAdapterItemReactionsBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemReactionsBinding;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemReactions extends WidgetChatListItem {
    private static final int REACTION_LIMIT = 20;
    private final WidgetChatListAdapterItemReactionsBinding binding;
    private final ImageView quickAddReactionView;
    private static final int REACTION_HORIZONTAL_PADDING = DimenUtils.dpToPixels(6);
    private static final int REACTION_VIEW_HEIGHT = DimenUtils.dpToPixels(26);

    /* compiled from: WidgetChatListAdapterItemReactions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemReactions$displayReactions$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ boolean $canAddReactions;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ MessageReaction $reaction;

        public AnonymousClass1(long j, MessageReaction messageReaction, boolean z2) {
            this.$messageId = j;
            this.$reaction = messageReaction;
            this.$canAddReactions = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemReactions.access$getAdapter$p(WidgetChatListAdapterItemReactions.this).onReactionClicked(this.$messageId, this.$reaction, this.$canAddReactions);
        }
    }

    /* compiled from: WidgetChatListAdapterItemReactions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemReactions$displayReactions$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ MessageReaction $reaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, MessageReaction messageReaction) {
            super(1);
            this.$messageId = j;
            this.$reaction = messageReaction;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetChatListAdapterItemReactions.access$getAdapter$p(WidgetChatListAdapterItemReactions.this).onReactionLongClicked(this.$messageId, this.$reaction);
        }
    }

    /* compiled from: WidgetChatListAdapterItemReactions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemReactions$displayReactions$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ long $messageId;

        public AnonymousClass3(long j) {
            this.$messageId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemReactions.access$getAdapter$p(WidgetChatListAdapterItemReactions.this).onQuickAddReactionClicked(this.$messageId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemReactions(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_reactions, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_gutter_bg;
        View viewFindViewById = view.findViewById(R.id.chat_list_adapter_item_gutter_bg);
        if (viewFindViewById != null) {
            i = R.id.chat_list_adapter_item_highlighted_bg;
            View viewFindViewById2 = view.findViewById(R.id.chat_list_adapter_item_highlighted_bg);
            if (viewFindViewById2 != null) {
                i = R.id.chat_list_item_reactions;
                FlexboxLayout flexboxLayout = (FlexboxLayout) view.findViewById(R.id.chat_list_item_reactions);
                if (flexboxLayout != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    WidgetChatListAdapterItemReactionsBinding widgetChatListAdapterItemReactionsBinding = new WidgetChatListAdapterItemReactionsBinding(constraintLayout, viewFindViewById, viewFindViewById2, flexboxLayout);
                    Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemReactionsBinding, "WidgetChatListAdapterIte…onsBinding.bind(itemView)");
                    this.binding = widgetChatListAdapterItemReactionsBinding;
                    Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
                    View viewInflate = LayoutInflater.from(constraintLayout.getContext()).inflate(R.layout.reaction_quick_add, (ViewGroup) null, false);
                    Objects.requireNonNull(viewInflate, "rootView");
                    ImageView imageView = (ImageView) viewInflate;
                    Intrinsics3.checkNotNullExpressionValue(new ReactionQuickAddBinding(imageView, imageView), "ReactionQuickAddBinding.…ot.context), null, false)");
                    Intrinsics3.checkNotNullExpressionValue(imageView, "ReactionQuickAddBinding.…ntext), null, false).root");
                    this.quickAddReactionView = imageView;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemReactions widgetChatListAdapterItemReactions) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemReactions.adapter;
    }

    private final void displayReactions(Collection<MessageReaction> reactions, long messageId, boolean canAddReactions, boolean canCreateReactions, boolean animateEmojis) {
        ReactionView reactionView;
        removeQuickAddReactionView();
        FlexboxLayout flexboxLayout = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(flexboxLayout, "binding.chatListItemReactions");
        int childCount = flexboxLayout.getChildCount();
        for (int size = reactions.size(); size < childCount; size++) {
            View childAt = this.binding.d.getChildAt(size);
            Intrinsics3.checkNotNullExpressionValue(childAt, "binding.chatListItemReactions.getChildAt(i)");
            childAt.setVisibility(8);
        }
        FlexboxLayout flexboxLayout2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(flexboxLayout2, "binding.chatListItemReactions");
        int childCount2 = flexboxLayout2.getChildCount();
        int i = 0;
        int i2 = 0;
        for (MessageReaction messageReaction : reactions) {
            if (i2 < childCount2) {
                View childAt2 = this.binding.d.getChildAt(i2);
                Objects.requireNonNull(childAt2, "null cannot be cast to non-null type com.discord.views.ReactionView");
                reactionView = (ReactionView) childAt2;
                reactionView.setVisibility(i);
                i2++;
            } else {
                FlexboxLayout flexboxLayout3 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(flexboxLayout3, "binding.chatListItemReactions");
                Context context = flexboxLayout3.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.chatListItemReactions.context");
                reactionView = new ReactionView(context, null, i, 6);
                int i3 = REACTION_HORIZONTAL_PADDING;
                reactionView.setPadding(i3, reactionView.getPaddingTop(), i3, reactionView.getPaddingBottom());
                Context context2 = reactionView.getContext();
                Context context3 = reactionView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context3, "view.context");
                reactionView.setBackground(ContextCompat.getDrawable(context2, DrawableCompat.getThemedDrawableRes$default(context3, R.attr.theme_chat_reaction_background, i, 2, (Object) null)));
                reactionView.setGravity(17);
                this.binding.d.addView(reactionView);
                reactionView.getLayoutParams().height = REACTION_VIEW_HEIGHT;
            }
            ReactionView reactionView2 = reactionView;
            reactionView2.setOnClickListener(new AnonymousClass1(messageId, messageReaction, canAddReactions));
            ViewExtensions.setOnLongClickListenerConsumeClick(reactionView2, new AnonymousClass2(messageId, messageReaction));
            reactionView2.a(messageReaction, messageId, animateEmojis);
            i2 = i2;
            i = 0;
        }
        if (reactions.size() >= 20 || !canCreateReactions) {
            return;
        }
        this.quickAddReactionView.setOnClickListener(new AnonymousClass3(messageId));
        this.binding.d.addView(this.quickAddReactionView);
    }

    private final void processReactions(ReactionsEntry data) {
        Message message = data.getMessage();
        View view = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.chatListAdapterItemHighlightedBg");
        View view2 = this.binding.f2329b;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemGutterBg");
        configureCellHighlight(message, view, view2);
        displayReactions(data.getMessage().getReactionsMap().values(), data.getMessage().getId(), data.getCanAddReactions(), data.getCanCreateReactions(), data.getAnimateEmojis());
    }

    private final void removeQuickAddReactionView() {
        FlexboxLayout flexboxLayout = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(flexboxLayout, "binding.chatListItemReactions");
        int childCount = flexboxLayout.getChildCount();
        if (childCount > 0) {
            int i = childCount - 1;
            if (this.binding.d.getChildAt(i) == this.quickAddReactionView) {
                this.binding.d.removeViewAt(i);
            }
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        processReactions((ReactionsEntry) data);
    }
}
