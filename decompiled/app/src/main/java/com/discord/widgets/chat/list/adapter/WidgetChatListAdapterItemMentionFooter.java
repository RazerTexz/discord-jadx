package com.discord.widgets.chat.list.adapter;

import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemMentionFooterBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: WidgetChatListAdapterItemMentionFooter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemMentionFooter;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "Lcom/discord/databinding/WidgetChatListAdapterItemMentionFooterBinding;", "", "tileBackgroundBitmapDrawable", "(Lcom/discord/databinding/WidgetChatListAdapterItemMentionFooterBinding;)V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemMentionFooterBinding;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMentionFooter extends WidgetChatListItem {
    private final WidgetChatListAdapterItemMentionFooterBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMentionFooter(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_mention_footer, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_item_mention_footer_divider;
        View viewFindViewById = view.findViewById(R.id.chat_list_item_mention_footer_divider);
        if (viewFindViewById != null) {
            i = R.id.chat_list_item_mention_footer_hand;
            ImageView imageView = (ImageView) view.findViewById(R.id.chat_list_item_mention_footer_hand);
            if (imageView != null) {
                i = R.id.chat_list_item_message_header_channel;
                TextView textView = (TextView) view.findViewById(R.id.chat_list_item_message_header_channel);
                if (textView != null) {
                    i = R.id.tile;
                    View viewFindViewById2 = view.findViewById(R.id.tile);
                    if (viewFindViewById2 != null) {
                        WidgetChatListAdapterItemMentionFooterBinding widgetChatListAdapterItemMentionFooterBinding = new WidgetChatListAdapterItemMentionFooterBinding((LinearLayout) view, viewFindViewById, imageView, textView, viewFindViewById2);
                        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemMentionFooterBinding, "WidgetChatListAdapterIte…terBinding.bind(itemView)");
                        this.binding = widgetChatListAdapterItemMentionFooterBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    private final void tileBackgroundBitmapDrawable(WidgetChatListAdapterItemMentionFooterBinding widgetChatListAdapterItemMentionFooterBinding) {
        View view = widgetChatListAdapterItemMentionFooterBinding.c;
        Intrinsics3.checkNotNullExpressionValue(view, "tile");
        Drawable background = view.getBackground();
        Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
        bitmapDrawable.mutate();
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        bitmapDrawable.setTileModeXY(tileMode, tileMode);
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
        boolean z2 = ((WidgetChatListAdapter) this.adapter).getData().getList().size() == 1;
        View view = this.binding.f2326b;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.chatListItemMentionFooterDivider");
        view.setVisibility(z2 ^ true ? 0 : 8);
        tileBackgroundBitmapDrawable(this.binding);
    }
}
