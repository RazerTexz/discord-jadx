package com.discord.widgets.chat.input.autocomplete.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChatInputSlashLoadingItemBinding;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ApplicationCommandLoadingViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/adapter/ApplicationCommandLoadingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/databinding/WidgetChatInputSlashLoadingItemBinding;", "binding", "Lcom/discord/databinding/WidgetChatInputSlashLoadingItemBinding;", "<init>", "(Lcom/discord/databinding/WidgetChatInputSlashLoadingItemBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ApplicationCommandLoadingViewHolder extends RecyclerView.ViewHolder {
    private final WidgetChatInputSlashLoadingItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationCommandLoadingViewHolder(WidgetChatInputSlashLoadingItemBinding widgetChatInputSlashLoadingItemBinding) {
        super(widgetChatInputSlashLoadingItemBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChatInputSlashLoadingItemBinding, "binding");
        this.binding = widgetChatInputSlashLoadingItemBinding;
    }
}
