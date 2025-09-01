package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.discord.R;
import com.discord.api.botuikit.SelectComponent2;
import com.discord.databinding.WidgetChatListAdapterItemBotComponentRowBinding;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.widgets.botuikit.ComponentProvider;
import com.discord.widgets.botuikit.views.ComponentView2;
import com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet;
import com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet2;
import com.discord.widgets.chat.list.entries.BotUiComponentEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WidgetChatListAdapterItemBotComponentRow.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00020\u00072\n\u0010\u000b\u001a\u00060\u0003j\u0002`\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJa\u0010\u0019\u001a\u00020\u00072\n\u0010\u000b\u001a\u00060\u0003j\u0002`\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemBotComponentRow;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "Lcom/discord/widgets/botuikit/views/ComponentActionListener;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lcom/discord/widgets/botuikit/ComponentIndex;", "componentIndex", "", "customId", "onButtonComponentClick", "(ILjava/lang/String;)V", "placeholder", "", "Lcom/discord/api/botuikit/SelectItem;", "options", "selectedItems", "minOptionsToSelect", "maxOptionsToSelect", "", "emojiAnimationsEnabled", "onSelectComponentClick", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;IIZ)V", "Lcom/discord/databinding/WidgetChatListAdapterItemBotComponentRowBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemBotComponentRowBinding;", "Lcom/discord/widgets/chat/list/entries/BotUiComponentEntry;", "entry", "Lcom/discord/widgets/chat/list/entries/BotUiComponentEntry;", "getEntry", "()Lcom/discord/widgets/chat/list/entries/BotUiComponentEntry;", "setEntry", "(Lcom/discord/widgets/chat/list/entries/BotUiComponentEntry;)V", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemBotComponentRow extends WidgetChatListItem implements ComponentView2 {
    private final WidgetChatListAdapterItemBotComponentRowBinding binding;
    public BotUiComponentEntry entry;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemBotComponentRow(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_bot_component_row, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_component_root;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.chat_list_adapter_item_component_root);
        if (linearLayout != null) {
            i = R.id.chat_list_adapter_item_gutter_bg;
            View viewFindViewById = view.findViewById(R.id.chat_list_adapter_item_gutter_bg);
            if (viewFindViewById != null) {
                i = R.id.chat_list_adapter_item_highlighted_bg;
                View viewFindViewById2 = view.findViewById(R.id.chat_list_adapter_item_highlighted_bg);
                if (viewFindViewById2 != null) {
                    WidgetChatListAdapterItemBotComponentRowBinding widgetChatListAdapterItemBotComponentRowBinding = new WidgetChatListAdapterItemBotComponentRowBinding((ConstraintLayout) view, linearLayout, viewFindViewById, viewFindViewById2);
                    Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemBotComponentRowBinding, "WidgetChatListAdapterIte…RowBinding.bind(itemView)");
                    this.binding = widgetChatListAdapterItemBotComponentRowBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public final BotUiComponentEntry getEntry() {
        BotUiComponentEntry botUiComponentEntry = this.entry;
        if (botUiComponentEntry == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("entry");
        }
        return botUiComponentEntry;
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView2
    public void onButtonComponentClick(int componentIndex, String customId) {
        Intrinsics3.checkNotNullParameter(customId, "customId");
        WidgetChatListAdapter widgetChatListAdapter = (WidgetChatListAdapter) this.adapter;
        BotUiComponentEntry botUiComponentEntry = this.entry;
        if (botUiComponentEntry == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("entry");
        }
        long applicationId = botUiComponentEntry.getApplicationId();
        BotUiComponentEntry botUiComponentEntry2 = this.entry;
        if (botUiComponentEntry2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("entry");
        }
        long id2 = botUiComponentEntry2.getMessage().getId();
        BotUiComponentEntry botUiComponentEntry3 = this.entry;
        if (botUiComponentEntry3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("entry");
        }
        widgetChatListAdapter.onBotUiComponentClicked(applicationId, id2, botUiComponentEntry3.getMessage().getFlags(), componentIndex, new RestAPIParams.ComponentInteractionData.ButtonComponentInteractionData(null, customId, 1, null));
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView2
    public void onSelectComponentClick(int componentIndex, String customId, String placeholder, List<SelectComponent2> options, List<SelectComponent2> selectedItems, int minOptionsToSelect, int maxOptionsToSelect, boolean emojiAnimationsEnabled) {
        Intrinsics3.checkNotNullParameter(customId, "customId");
        Intrinsics3.checkNotNullParameter(options, "options");
        Intrinsics3.checkNotNullParameter(selectedItems, "selectedItems");
        SelectComponentBottomSheet.Companion companion = SelectComponentBottomSheet.INSTANCE;
        FragmentManager fragmentManager = ((WidgetChatListAdapter) this.adapter).getFragmentManager();
        BotUiComponentEntry botUiComponentEntry = this.entry;
        if (botUiComponentEntry == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("entry");
        }
        Long guildId = botUiComponentEntry.getGuildId();
        BotUiComponentEntry botUiComponentEntry2 = this.entry;
        if (botUiComponentEntry2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("entry");
        }
        long id2 = botUiComponentEntry2.getMessage().getId();
        BotUiComponentEntry botUiComponentEntry3 = this.entry;
        if (botUiComponentEntry3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("entry");
        }
        long channelId = botUiComponentEntry3.getMessage().getChannelId();
        BotUiComponentEntry botUiComponentEntry4 = this.entry;
        if (botUiComponentEntry4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("entry");
        }
        Long flags = botUiComponentEntry4.getMessage().getFlags();
        BotUiComponentEntry botUiComponentEntry5 = this.entry;
        if (botUiComponentEntry5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("entry");
        }
        companion.show(fragmentManager, new SelectComponentBottomSheet2(guildId, id2, channelId, flags, botUiComponentEntry5.getApplicationId()), componentIndex, customId, placeholder, minOptionsToSelect, maxOptionsToSelect, options, selectedItems, emojiAnimationsEnabled);
    }

    public final void setEntry(BotUiComponentEntry botUiComponentEntry) {
        Intrinsics3.checkNotNullParameter(botUiComponentEntry, "<set-?>");
        this.entry = botUiComponentEntry;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        BotUiComponentEntry botUiComponentEntry = (BotUiComponentEntry) data;
        this.entry = botUiComponentEntry;
        if (botUiComponentEntry == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("entry");
        }
        Message message = botUiComponentEntry.getMessage();
        View view = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.chatListAdapterItemGutterBg");
        View view2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemHighlightedBg");
        configureCellHighlight(message, view2, view);
        BotUiComponentEntry botUiComponentEntry2 = this.entry;
        if (botUiComponentEntry2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("entry");
        }
        List<MessageComponent> messageComponents = botUiComponentEntry2.getMessageComponents();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(messageComponents, 10));
        int i = 0;
        for (Object obj : messageComponents) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            ComponentProvider botUiComponentProvider = ((WidgetChatListAdapter) this.adapter).getBotUiComponentProvider();
            LinearLayout linearLayout = this.binding.f2313b;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatListAdapterItemComponentRoot");
            arrayList.add(botUiComponentProvider.getConfiguredComponentView(this, (MessageComponent) obj, linearLayout, i));
            i = i2;
        }
        LinearLayout linearLayout2 = this.binding.f2313b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.chatListAdapterItemComponentRoot");
        WidgetChatListAdapterItemBotComponentRow2.replaceViews(linearLayout2, _Collections.filterNotNull(arrayList));
    }
}
