package com.discord.widgets.botuikit.views.select;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.api.botuikit.SelectComponent2;
import com.discord.databinding.WidgetSelectComponentBottomSheetItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: SelectComponentBottomSheetAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0!¢\u0006\u0004\b&\u0010'J+\u0010\u000b\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001bR(\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001b¨\u0006("}, d2 = {"Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetItem;", "items", "", "maxSelections", "", "emojiAnimationsEnabled", "", "setItems", "(Ljava/util/List;IZ)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "getItemCount", "()I", "", "getItemId", "(I)J", "Z", "isMultiSelect", "isMaxSelected", "data", "Ljava/util/List;", "hasDescriptions", "Lkotlin/Function2;", "Lcom/discord/api/botuikit/SelectItem;", "onItemSelected", "Lkotlin/jvm/functions/Function2;", "hasIcons", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SelectComponentBottomSheetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SelectComponentBottomSheetAdapter2> data;
    private boolean emojiAnimationsEnabled;
    private boolean hasDescriptions;
    private boolean hasIcons;
    private boolean isMaxSelected;
    private boolean isMultiSelect;
    private final Function2<SelectComponent2, Boolean, Unit> onItemSelected;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectComponentBottomSheetAdapter(Function2<? super SelectComponent2, ? super Boolean, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "onItemSelected");
        this.onItemSelected = function2;
        setHasStableIds(true);
        this.data = Collections2.emptyList();
        this.emojiAnimationsEnabled = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        ((SelectComponentBottomSheetAdapter3) holder).bind(this.data.get(position), this.isMultiSelect, this.hasIcons, this.hasDescriptions, position == this.data.size() - 1, this.isMaxSelected, this.emojiAnimationsEnabled);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_select_component_bottom_sheet_item, parent, false);
        int i = R.id.select_component_sheet_item_description;
        MaterialTextView materialTextView = (MaterialTextView) viewInflate.findViewById(R.id.select_component_sheet_item_description);
        if (materialTextView != null) {
            i = R.id.select_component_sheet_item_divider;
            View viewFindViewById = viewInflate.findViewById(R.id.select_component_sheet_item_divider);
            if (viewFindViewById != null) {
                i = R.id.select_component_sheet_item_divider_icon;
                View viewFindViewById2 = viewInflate.findViewById(R.id.select_component_sheet_item_divider_icon);
                if (viewFindViewById2 != null) {
                    i = R.id.select_component_sheet_item_icon;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.select_component_sheet_item_icon);
                    if (simpleDraweeView != null) {
                        i = R.id.select_component_sheet_item_selected;
                        MaterialCheckBox materialCheckBox = (MaterialCheckBox) viewInflate.findViewById(R.id.select_component_sheet_item_selected);
                        if (materialCheckBox != null) {
                            i = R.id.select_component_sheet_item_title;
                            MaterialTextView materialTextView2 = (MaterialTextView) viewInflate.findViewById(R.id.select_component_sheet_item_title);
                            if (materialTextView2 != null) {
                                WidgetSelectComponentBottomSheetItemBinding widgetSelectComponentBottomSheetItemBinding = new WidgetSelectComponentBottomSheetItemBinding((ConstraintLayout) viewInflate, materialTextView, viewFindViewById, viewFindViewById2, simpleDraweeView, materialCheckBox, materialTextView2);
                                Intrinsics3.checkNotNullExpressionValue(widgetSelectComponentBottomSheetItemBinding, "WidgetSelectComponentBot…          false\n        )");
                                return new SelectComponentBottomSheetAdapter3(widgetSelectComponentBottomSheetItemBinding, this.onItemSelected);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setItems(List<SelectComponentBottomSheetAdapter2> items, int maxSelections, boolean emojiAnimationsEnabled) {
        boolean z2;
        boolean z3;
        int i;
        Intrinsics3.checkNotNullParameter(items, "items");
        this.data = items;
        boolean z4 = items instanceof Collection;
        if (z4 && items.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                if (((SelectComponentBottomSheetAdapter2) it.next()).getSelectItem().getEmoji() != null) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        this.hasIcons = z2;
        if (z4 && items.isEmpty()) {
            z3 = false;
        } else {
            Iterator<T> it2 = items.iterator();
            while (it2.hasNext()) {
                if (((SelectComponentBottomSheetAdapter2) it2.next()).getSelectItem().getDescription() != null) {
                    z3 = true;
                    break;
                }
            }
            z3 = false;
        }
        this.hasDescriptions = z3;
        this.isMultiSelect = maxSelections > 1;
        if (z4 && items.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it3 = items.iterator();
            i = 0;
            while (it3.hasNext()) {
                if (((SelectComponentBottomSheetAdapter2) it3.next()).getSelected() && (i = i + 1) < 0) {
                    Collections2.throwCountOverflow();
                }
            }
        }
        this.isMaxSelected = i == maxSelections;
        this.emojiAnimationsEnabled = emojiAnimationsEnabled;
        notifyDataSetChanged();
    }
}
