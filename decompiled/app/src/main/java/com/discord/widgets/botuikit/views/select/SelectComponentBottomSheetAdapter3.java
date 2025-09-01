package com.discord.widgets.botuikit.views.select;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.botuikit.ComponentEmoji;
import com.discord.api.botuikit.SelectComponent2;
import com.discord.databinding.WidgetSelectComponentBottomSheetItemBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.botuikit.views.ComponentViewUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: SelectComponentBottomSheetAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0011¢\u0006\u0004\b\u0015\u0010\u0016JE\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetItem;", "data", "", "isMultiSelect", "hasIcons", "hasDescriptions", "lastItem", "maxSelected", "emojiAnimationsEnabled", "", "bind", "(Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetItem;ZZZZZZ)V", "Lcom/discord/databinding/WidgetSelectComponentBottomSheetItemBinding;", "binding", "Lcom/discord/databinding/WidgetSelectComponentBottomSheetItemBinding;", "Lkotlin/Function2;", "Lcom/discord/api/botuikit/SelectItem;", "onItemSelected", "Lkotlin/jvm/functions/Function2;", "<init>", "(Lcom/discord/databinding/WidgetSelectComponentBottomSheetItemBinding;Lkotlin/jvm/functions/Function2;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheetItemViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class SelectComponentBottomSheetAdapter3 extends RecyclerView.ViewHolder {
    private final WidgetSelectComponentBottomSheetItemBinding binding;
    private final Function2<SelectComponent2, Boolean, Unit> onItemSelected;

    /* compiled from: SelectComponentBottomSheetAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheetItemViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ SelectComponentBottomSheetAdapter2 $data;

        public AnonymousClass1(SelectComponentBottomSheetAdapter2 selectComponentBottomSheetAdapter2) {
            this.$data = selectComponentBottomSheetAdapter2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SelectComponentBottomSheetAdapter3.access$getOnItemSelected$p(SelectComponentBottomSheetAdapter3.this).invoke(this.$data.getSelectItem(), Boolean.valueOf(!this.$data.getSelected()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectComponentBottomSheetAdapter3(WidgetSelectComponentBottomSheetItemBinding widgetSelectComponentBottomSheetItemBinding, Function2<? super SelectComponent2, ? super Boolean, Unit> function2) {
        super(widgetSelectComponentBottomSheetItemBinding.a);
        Intrinsics3.checkNotNullParameter(widgetSelectComponentBottomSheetItemBinding, "binding");
        Intrinsics3.checkNotNullParameter(function2, "onItemSelected");
        this.binding = widgetSelectComponentBottomSheetItemBinding;
        this.onItemSelected = function2;
    }

    public static final /* synthetic */ Function2 access$getOnItemSelected$p(SelectComponentBottomSheetAdapter3 selectComponentBottomSheetAdapter3) {
        return selectComponentBottomSheetAdapter3.onItemSelected;
    }

    public final void bind(SelectComponentBottomSheetAdapter2 data, boolean isMultiSelect, boolean hasIcons, boolean hasDescriptions, boolean lastItem, boolean maxSelected, boolean emojiAnimationsEnabled) {
        Intrinsics3.checkNotNullParameter(data, "data");
        boolean z2 = maxSelected && !data.getSelected() && isMultiSelect;
        ConstraintLayout constraintLayout = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        constraintLayout.setEnabled(!z2);
        this.binding.a.setOnClickListener(new AnonymousClass1(data));
        ConstraintLayout constraintLayout2 = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.root");
        ViewExtensions.setEnabledAlpha(constraintLayout2, !z2, 0.3f);
        MaterialTextView materialTextView = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.selectComponentSheetItemTitle");
        materialTextView.setText(data.getSelectItem().getLabel());
        String description = data.getSelectItem().getDescription();
        MaterialTextView materialTextView2 = this.binding.f2533b;
        Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.selectComponentSheetItemDescription");
        ViewExtensions.setTextAndVisibilityBy(materialTextView2, description);
        MaterialCheckBox materialCheckBox = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.selectComponentSheetItemSelected");
        materialCheckBox.setChecked(data.getSelected());
        MaterialCheckBox materialCheckBox2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(materialCheckBox2, "binding.selectComponentSheetItemSelected");
        materialCheckBox2.setVisibility(isMultiSelect ^ true ? 4 : 0);
        MaterialCheckBox materialCheckBox3 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(materialCheckBox3, "binding.selectComponentSheetItemSelected");
        materialCheckBox3.setEnabled(!z2);
        ComponentEmoji emoji = data.getSelectItem().getEmoji();
        ComponentViewUtils componentViewUtils = ComponentViewUtils.INSTANCE;
        SimpleDraweeView simpleDraweeView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.selectComponentSheetItemIcon");
        componentViewUtils.setEmojiOrHide(simpleDraweeView, emoji, emojiAnimationsEnabled);
        int iDpToPixels = DimenUtils.dpToPixels(12);
        int iDpToPixels2 = data.getSelectItem().getDescription() == null ? DimenUtils.dpToPixels(12) : 0;
        int iDpToPixels3 = (hasIcons && data.getSelectItem().getEmoji() == null) ? DimenUtils.dpToPixels(40) : 0;
        this.binding.g.setPadding(iDpToPixels3, iDpToPixels, 0, iDpToPixels2);
        this.binding.f2533b.setPadding(iDpToPixels3, 0, 0, DimenUtils.dpToPixels(12));
        View view = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.selectComponentSheetItemDividerIcon");
        view.setVisibility(hasIcons && !lastItem ? 0 : 8);
        View view2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.selectComponentSheetItemDivider");
        view2.setVisibility((hasIcons || lastItem) ? false : true ? 0 : 8);
        int iDpToPixels4 = DimenUtils.dpToPixels(hasDescriptions ? 62 : 46);
        ConstraintLayout constraintLayout3 = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout3, "binding.root");
        constraintLayout3.setMinHeight(iDpToPixels4);
    }
}
