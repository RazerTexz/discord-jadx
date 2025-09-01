package com.discord.widgets.chat.input;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R;
import com.discord.databinding.StickerAutocompleteItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.sticker.StickerView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetChatInputAutocompleteStickerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/chat/input/StickerViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/chat/input/WidgetChatInputAutocompleteStickerAdapter;", "Lcom/discord/widgets/chat/input/AutocompleteStickerItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/chat/input/AutocompleteStickerItem;)V", "Lcom/discord/databinding/StickerAutocompleteItemBinding;", "binding", "Lcom/discord/databinding/StickerAutocompleteItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/chat/input/WidgetChatInputAutocompleteStickerAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.StickerViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatInputAutocompleteStickerAdapter3 extends MGRecyclerViewHolder<WidgetChatInputAutocompleteStickerAdapter, WidgetChatInputAutocompleteStickerAdapter2> {
    private final StickerAutocompleteItemBinding binding;

    /* compiled from: WidgetChatInputAutocompleteStickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.StickerViewHolder$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetChatInputAutocompleteStickerAdapter2 $data;

        public AnonymousClass1(WidgetChatInputAutocompleteStickerAdapter2 widgetChatInputAutocompleteStickerAdapter2) {
            this.$data = widgetChatInputAutocompleteStickerAdapter2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatInputAutocompleteStickerAdapter3.access$getAdapter$p(WidgetChatInputAutocompleteStickerAdapter3.this).getOnClickSticker().invoke(this.$data.getSticker());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAutocompleteStickerAdapter3(WidgetChatInputAutocompleteStickerAdapter widgetChatInputAutocompleteStickerAdapter) {
        super(R.layout.sticker_autocomplete_item, widgetChatInputAutocompleteStickerAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatInputAutocompleteStickerAdapter, "adapter");
        View view = this.itemView;
        StickerView stickerView = (StickerView) view.findViewById(R.id.sticker_autocomplete_sticker);
        if (stickerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.sticker_autocomplete_sticker)));
        }
        StickerAutocompleteItemBinding stickerAutocompleteItemBinding = new StickerAutocompleteItemBinding((FrameLayout) view, stickerView);
        Intrinsics3.checkNotNullExpressionValue(stickerAutocompleteItemBinding, "StickerAutocompleteItemBinding.bind(itemView)");
        this.binding = stickerAutocompleteItemBinding;
    }

    public static final /* synthetic */ WidgetChatInputAutocompleteStickerAdapter access$getAdapter$p(WidgetChatInputAutocompleteStickerAdapter3 widgetChatInputAutocompleteStickerAdapter3) {
        return (WidgetChatInputAutocompleteStickerAdapter) widgetChatInputAutocompleteStickerAdapter3.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetChatInputAutocompleteStickerAdapter2 widgetChatInputAutocompleteStickerAdapter2) {
        onConfigure2(i, widgetChatInputAutocompleteStickerAdapter2);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetChatInputAutocompleteStickerAdapter2 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        StickerView.e(this.binding.f2147b, data.getSticker(), null, 2);
        this.binding.f2147b.b();
        this.binding.a.setOnClickListener(new AnonymousClass1(data));
    }
}
