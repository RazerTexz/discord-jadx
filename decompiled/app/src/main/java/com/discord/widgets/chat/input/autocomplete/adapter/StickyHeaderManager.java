package com.discord.widgets.chat.input.autocomplete.adapter;

import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChatInputCommandApplicationHeaderItemBinding;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StickyHeaderManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/adapter/StickyHeaderManager;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "layoutViews", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lcom/discord/widgets/chat/input/autocomplete/adapter/ChatInputAutocompleteAdapter;", "adapter", "Lcom/discord/widgets/chat/input/autocomplete/adapter/ChatInputAutocompleteAdapter;", "getAdapter", "()Lcom/discord/widgets/chat/input/autocomplete/adapter/ChatInputAutocompleteAdapter;", "Lcom/discord/widgets/chat/input/autocomplete/adapter/StickyHeaderHolder;", "stickyHeaderHolder", "Lcom/discord/widgets/chat/input/autocomplete/adapter/StickyHeaderHolder;", "getStickyHeaderHolder", "()Lcom/discord/widgets/chat/input/autocomplete/adapter/StickyHeaderHolder;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/discord/widgets/chat/input/autocomplete/adapter/ChatInputAutocompleteAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StickyHeaderManager {
    private final ChatInputAutocompleteAdapter adapter;
    private final RecyclerView recyclerView;
    private final StickyHeaderManager2 stickyHeaderHolder;

    public StickyHeaderManager(RecyclerView recyclerView, ChatInputAutocompleteAdapter chatInputAutocompleteAdapter) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(chatInputAutocompleteAdapter, "adapter");
        this.recyclerView = recyclerView;
        this.adapter = chatInputAutocompleteAdapter;
        WidgetChatInputCommandApplicationHeaderItemBinding widgetChatInputCommandApplicationHeaderItemBindingA = WidgetChatInputCommandApplicationHeaderItemBinding.a(LayoutInflater.from(recyclerView.getContext()), recyclerView, false);
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputCommandApplicationHeaderItemBindingA, "WidgetChatInputCommandAp…clerView, false\n        )");
        this.stickyHeaderHolder = new CommandHeaderViewHolder(widgetChatInputCommandApplicationHeaderItemBindingA);
    }

    public final ChatInputAutocompleteAdapter getAdapter() {
        return this.adapter;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final StickyHeaderManager2 getStickyHeaderHolder() {
        return this.stickyHeaderHolder;
    }

    public final void layoutViews(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        StickyHeaderItemDecoration.LayoutManager.layoutHeaderView(recyclerView, this.stickyHeaderHolder.getItemView());
    }
}
