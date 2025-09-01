package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.ExpressionPickerHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter;
import com.discord.widgets.chat.input.sticker.StickerAdapterItems2;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: StickerAdapterViewHolders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000e\u0010\nR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/OwnedHeaderViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/chat/input/sticker/WidgetStickerAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$StickyHeaderViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "bind", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "onConfigure", "Lcom/discord/databinding/ExpressionPickerHeaderItemBinding;", "binding", "Lcom/discord/databinding/ExpressionPickerHeaderItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/chat/input/sticker/WidgetStickerAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.sticker.OwnedHeaderViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class StickerAdapterViewHolders extends MGRecyclerViewHolder<WidgetStickerAdapter, MGRecyclerDataPayload> implements WidgetExpressionPickerAdapter.StickyHeaderViewHolder {
    private final ExpressionPickerHeaderItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerAdapterViewHolders(WidgetStickerAdapter widgetStickerAdapter) {
        super(R.layout.expression_picker_header_item, widgetStickerAdapter);
        Intrinsics3.checkNotNullParameter(widgetStickerAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        ExpressionPickerHeaderItemBinding expressionPickerHeaderItemBinding = new ExpressionPickerHeaderItemBinding(textView, textView);
        Intrinsics3.checkNotNullExpressionValue(expressionPickerHeaderItemBinding, "ExpressionPickerHeaderItemBinding.bind(itemView)");
        this.binding = expressionPickerHeaderItemBinding;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter.StickyHeaderViewHolder
    public void bind(int position, MGRecyclerDataPayload data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        onConfigure2(position, data);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter.StickyHeaderViewHolder
    public View getItemView() {
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        return view;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        StickerAdapterItems2 headerType;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        if (!(data instanceof StickerAdapterItems)) {
            data = null;
        }
        StickerAdapterItems stickerAdapterItems = (StickerAdapterItems) data;
        if (stickerAdapterItems == null || (headerType = stickerAdapterItems.getHeaderType()) == null) {
            return;
        }
        if (headerType instanceof StickerAdapterItems2.PackItem) {
            TextView textView = this.binding.f2105b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.headerItemText");
            StickerAdapterItems2.PackItem packItem = (StickerAdapterItems2.PackItem) headerType;
            textView.setText(packItem.getPack().getName());
            TextView textView2 = this.binding.f2105b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.headerItemText");
            textView2.setContentDescription(FormatUtils.h(outline.x(this.itemView, "itemView", "itemView.context"), R.string.sticker_category_a11y_label, new Object[]{packItem.getPack().getName()}, null, 4));
            return;
        }
        if (headerType instanceof StickerAdapterItems2.Recent) {
            this.binding.f2105b.setText(R.string.sticker_picker_categories_recent);
            TextView textView3 = this.binding.f2105b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.headerItemText");
            Context contextI = outline.I(this.binding.f2105b, "binding.headerItemText", "binding.headerItemText.context");
            TextView textView4 = this.binding.f2105b;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.headerItemText");
            textView3.setContentDescription(FormatUtils.h(contextI, R.string.sticker_category_a11y_label, new Object[]{textView4.getText()}, null, 4));
            return;
        }
        if (headerType instanceof StickerAdapterItems2.GuildItem) {
            TextView textView5 = this.binding.f2105b;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.headerItemText");
            StickerAdapterItems2.GuildItem guildItem = (StickerAdapterItems2.GuildItem) headerType;
            textView5.setText(guildItem.getGuild().getName());
            TextView textView6 = this.binding.f2105b;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.headerItemText");
            textView6.setContentDescription(FormatUtils.h(outline.I(this.binding.f2105b, "binding.headerItemText", "binding.headerItemText.context"), R.string.sticker_category_a11y_label, new Object[]{guildItem.getGuild().getName()}, null, 4));
        }
    }
}
