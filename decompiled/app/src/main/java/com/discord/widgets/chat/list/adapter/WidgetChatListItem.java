package com.discord.widgets.chat.list.adapter;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetChatListItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lcom/discord/models/message/Message;", "message", "Landroid/view/View;", "highlightView", "gutterView", "configureCellHighlight", "(Lcom/discord/models/message/Message;Landroid/view/View;Landroid/view/View;)V", "Landroid/graphics/drawable/Drawable;", "backgroundBlockedExpanded", "Landroid/graphics/drawable/Drawable;", "defaultBackground", "layout", "adapter", "<init>", "(ILcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class WidgetChatListItem extends MGRecyclerViewHolder<WidgetChatListAdapter, ChatListEntry> {
    private final Drawable backgroundBlockedExpanded;
    private Drawable defaultBackground;

    /* compiled from: WidgetChatListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/discord/widgets/chat/list/adapter/WidgetChatListItem$1", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Landroid/view/GestureDetector;", "tapGestureDetector", "Landroid/view/GestureDetector;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListItem$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnTouchListener {
        public final /* synthetic */ WidgetChatListAdapter $adapter;
        private final GestureDetector tapGestureDetector;

        public AnonymousClass1(WidgetChatListAdapter widgetChatListAdapter) {
            this.$adapter = widgetChatListAdapter;
            View view = WidgetChatListItem.this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            this.tapGestureDetector = new GestureDetector(view.getContext(), new WidgetChatListItem2(this));
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            return this.tapGestureDetector.onTouchEvent(event);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListItem(int i, WidgetChatListAdapter widgetChatListAdapter) {
        super(i, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        this.defaultBackground = view.getBackground();
        View view2 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
        this.backgroundBlockedExpanded = new ColorDrawable(ColorCompat.getThemedColor(view2, R.attr.theme_chat_blocked_bg));
        this.itemView.setOnTouchListener(new AnonymousClass1(widgetChatListAdapter));
    }

    public final void configureCellHighlight(Message message, View highlightView, View gutterView) {
        int themedColor;
        int themedColor2;
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(highlightView, "highlightView");
        Intrinsics3.checkNotNullParameter(gutterView, "gutterView");
        boolean z2 = true;
        if (message.isEphemeralMessage() || message.isFailed()) {
            themedColor = ColorCompat.getThemedColor(highlightView.getContext(), R.attr.colorBackgroundModifierHover);
            themedColor2 = ColorCompat.getThemedColor(gutterView, R.attr.color_brand);
        } else if (WidgetChatListItem3.isUserMentioned((WidgetChatListAdapter) this.adapter, message)) {
            themedColor = ColorCompat.getThemedColor(highlightView.getContext(), R.attr.theme_chat_mentioned_me);
            themedColor2 = ColorCompat.getColor(gutterView, R.color.status_yellow_500);
        } else {
            themedColor = 0;
            themedColor2 = 0;
            z2 = false;
        }
        highlightView.setVisibility(z2 ? 0 : 8);
        gutterView.setVisibility(z2 ? 0 : 8);
        if (z2) {
            highlightView.setBackgroundColor(themedColor);
            gutterView.setBackgroundColor(themedColor2);
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        view.setBackground(data.isInExpandedBlockedMessageChunk() ? this.backgroundBlockedExpanded : this.defaultBackground);
    }
}
