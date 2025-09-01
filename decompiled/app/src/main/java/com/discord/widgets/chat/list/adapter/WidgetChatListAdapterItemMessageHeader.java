package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemMessageHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageHeaderEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetChatListAdapterItemMessageHeader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemMessageHeader;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lcom/discord/databinding/WidgetChatListAdapterItemMessageHeaderBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemMessageHeaderBinding;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessageHeader extends WidgetChatListItem {
    private final WidgetChatListAdapterItemMessageHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMessageHeader(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_message_header, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_item_message_header_channel;
        TextView textView = (TextView) view.findViewById(R.id.chat_list_item_message_header_channel);
        if (textView != null) {
            i = R.id.chat_list_item_message_header_divider;
            View viewFindViewById = view.findViewById(R.id.chat_list_item_message_header_divider);
            if (viewFindViewById != null) {
                i = R.id.chat_list_item_message_header_guild;
                TextView textView2 = (TextView) view.findViewById(R.id.chat_list_item_message_header_guild);
                if (textView2 != null) {
                    i = R.id.chat_list_item_message_header_spacer;
                    Space space = (Space) view.findViewById(R.id.chat_list_item_message_header_spacer);
                    if (space != null) {
                        WidgetChatListAdapterItemMessageHeaderBinding widgetChatListAdapterItemMessageHeaderBinding = new WidgetChatListAdapterItemMessageHeaderBinding((RelativeLayout) view, textView, viewFindViewById, textView2, space);
                        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemMessageHeaderBinding, "WidgetChatListAdapterIte…derBinding.bind(itemView)");
                        this.binding = widgetChatListAdapterItemMessageHeaderBinding;
                        return;
                    }
                }
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
        MessageHeaderEntry messageHeaderEntry = (MessageHeaderEntry) data;
        String strComponent2 = messageHeaderEntry.getText();
        String strComponent3 = messageHeaderEntry.getChannelName();
        View view = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.chatListItemMessageHeaderDivider");
        view.setVisibility(position > 0 ? 0 : 8);
        Space space = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(space, "binding.chatListItemMessageHeaderSpacer");
        space.setVisibility(position <= 0 ? 0 : 8);
        TextView textView = this.binding.f2327b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListItemMessageHeaderChannel");
        textView.setText(strComponent3);
        TextView textView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatListItemMessageHeaderGuild");
        textView2.setText(strComponent2);
    }
}
