package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.StickerStoreHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter;
import com.google.android.material.chip.Chip;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: StickerAdapterViewHolders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000e\u0010\nR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StoreHeaderViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/chat/input/sticker/WidgetStickerAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$StickyHeaderViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "bind", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "onConfigure", "Lcom/discord/databinding/StickerStoreHeaderItemBinding;", "binding", "Lcom/discord/databinding/StickerStoreHeaderItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/chat/input/sticker/WidgetStickerAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.sticker.StoreHeaderViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class StickerAdapterViewHolders3 extends MGRecyclerViewHolder<WidgetStickerAdapter, MGRecyclerDataPayload> implements WidgetExpressionPickerAdapter.StickyHeaderViewHolder {
    private final StickerStoreHeaderItemBinding binding;

    /* compiled from: StickerAdapterViewHolders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.StoreHeaderViewHolder$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ MGRecyclerDataPayload $data;

        public AnonymousClass1(MGRecyclerDataPayload mGRecyclerDataPayload) {
            this.$data = mGRecyclerDataPayload;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1<StickerAdapterItems4, Unit> onStickerHeaderItemsClicked = StickerAdapterViewHolders3.access$getAdapter$p(StickerAdapterViewHolders3.this).getOnStickerHeaderItemsClicked();
            if (onStickerHeaderItemsClicked != 0) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerAdapterViewHolders3(WidgetStickerAdapter widgetStickerAdapter) {
        super(R.layout.sticker_store_header_item, widgetStickerAdapter);
        Intrinsics3.checkNotNullParameter(widgetStickerAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.sticker_store_header_item_animated;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.sticker_store_header_item_animated);
        if (frameLayout != null) {
            i = R.id.sticker_store_header_item_container;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.sticker_store_header_item_container);
            if (relativeLayout != null) {
                i = R.id.sticker_store_header_item_description;
                TextView textView = (TextView) view.findViewById(R.id.sticker_store_header_item_description);
                if (textView != null) {
                    i = R.id.sticker_store_header_item_new;
                    Chip chip = (Chip) view.findViewById(R.id.sticker_store_header_item_new);
                    if (chip != null) {
                        i = R.id.sticker_store_header_item_premium;
                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.sticker_store_header_item_premium);
                        if (frameLayout2 != null) {
                            i = R.id.sticker_store_header_item_subtitle;
                            TextView textView2 = (TextView) view.findViewById(R.id.sticker_store_header_item_subtitle);
                            if (textView2 != null) {
                                i = R.id.sticker_store_header_item_title;
                                TextView textView3 = (TextView) view.findViewById(R.id.sticker_store_header_item_title);
                                if (textView3 != null) {
                                    StickerStoreHeaderItemBinding stickerStoreHeaderItemBinding = new StickerStoreHeaderItemBinding((LinearLayout) view, frameLayout, relativeLayout, textView, chip, frameLayout2, textView2, textView3);
                                    Intrinsics3.checkNotNullExpressionValue(stickerStoreHeaderItemBinding, "StickerStoreHeaderItemBinding.bind(itemView)");
                                    this.binding = stickerStoreHeaderItemBinding;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetStickerAdapter access$getAdapter$p(StickerAdapterViewHolders3 stickerAdapterViewHolders3) {
        return (WidgetStickerAdapter) stickerAdapterViewHolders3.adapter;
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
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        if (data instanceof StickerAdapterItems4) {
            TextView textView = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.stickerStoreHeaderItemTitle");
            StickerAdapterItems4 stickerAdapterItems4 = (StickerAdapterItems4) data;
            textView.setText(stickerAdapterItems4.getPack().getName());
            CharSequence i18nPluralString = StringResourceUtils.getI18nPluralString(outline.x(this.itemView, "itemView", "itemView.context"), R.plurals.sticker_pack_sticker_count_numStickers, stickerAdapterItems4.getPack().getStickers().size(), Integer.valueOf(stickerAdapterItems4.getPack().getStickers().size()));
            TextView textView2 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.stickerStoreHeaderItemSubtitle");
            textView2.setText(i18nPluralString);
            FrameLayout frameLayout = this.binding.f2155b;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.stickerStoreHeaderItemAnimated");
            frameLayout.setVisibility(stickerAdapterItems4.getPack().isAnimatedPack() ? 0 : 8);
            FrameLayout frameLayout2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.stickerStoreHeaderItemPremium");
            frameLayout2.setVisibility(stickerAdapterItems4.getPack().isPremiumPack() ? 0 : 8);
            if (((WidgetStickerAdapter) this.adapter).getShowStickerPackDescriptions()) {
                TextView textView3 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.stickerStoreHeaderItemDescription");
                ViewExtensions.setTextAndVisibilityBy(textView3, stickerAdapterItems4.getPack().getDescription());
            } else {
                TextView textView4 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.stickerStoreHeaderItemDescription");
                textView4.setVisibility(8);
            }
            if (stickerAdapterItems4.getPack().isAnimatedPack() || stickerAdapterItems4.getPack().isPremiumPack() || stickerAdapterItems4.getPack().isLimitedPack()) {
                this.binding.c.setOnClickListener(new AnonymousClass1(data));
            }
        }
    }
}
