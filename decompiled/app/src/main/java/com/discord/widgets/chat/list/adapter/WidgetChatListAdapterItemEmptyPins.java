package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemEmptyPinsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.EmptyPinsEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetChatListAdapterItemEmptyPins.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemEmptyPins;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lcom/discord/databinding/WidgetChatListAdapterItemEmptyPinsBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemEmptyPinsBinding;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmptyPins extends WidgetChatListItem {
    private final WidgetChatListAdapterItemEmptyPinsBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEmptyPins(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_empty_pins, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_empty_image;
        ImageView imageView = (ImageView) view.findViewById(R.id.chat_list_empty_image);
        if (imageView != null) {
            i = R.id.chat_list_empty_pins_text;
            TextView textView = (TextView) view.findViewById(R.id.chat_list_empty_pins_text);
            if (textView != null) {
                WidgetChatListAdapterItemEmptyPinsBinding widgetChatListAdapterItemEmptyPinsBinding = new WidgetChatListAdapterItemEmptyPinsBinding((RelativeLayout) view, imageView, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemEmptyPinsBinding, "WidgetChatListAdapterIte…insBinding.bind(itemView)");
                this.binding = widgetChatListAdapterItemEmptyPinsBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
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
        TextView textView = this.binding.f2317b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListEmptyPinsText");
        textView.setText(((EmptyPinsEntry) data).getText());
    }
}
