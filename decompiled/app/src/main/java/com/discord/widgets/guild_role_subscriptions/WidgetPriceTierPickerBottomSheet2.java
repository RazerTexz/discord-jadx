package com.discord.widgets.guild_role_subscriptions;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.DialogSimpleSelectorItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetPriceTierPickerBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/guild_role_subscriptions/PriceTierViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/guild_role_subscriptions/PriceTierViewHolder;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Lcom/discord/widgets/guild_role_subscriptions/PriceTierViewHolder;I)V", "getItemCount", "()I", "", "newItems", "setItems", "(Ljava/util/List;)V", "items", "Ljava/util/List;", "Lkotlin/Function1;", "itemClickListener", "Lkotlin/jvm/functions/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.PriceTierPickerAdapter, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetPriceTierPickerBottomSheet2 extends RecyclerView.Adapter<WidgetPriceTierPickerBottomSheet3> {
    private final Function1<Integer, Unit> itemClickListener;
    private List<Integer> items;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetPriceTierPickerBottomSheet2(Function1<? super Integer, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "itemClickListener");
        this.itemClickListener = function1;
        this.items = Collections2.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((WidgetPriceTierPickerBottomSheet3) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<Integer> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.items = newItems;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(WidgetPriceTierPickerBottomSheet3 holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.configureUI(this.items.get(position).intValue(), this.itemClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WidgetPriceTierPickerBottomSheet3 onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBindingA = DialogSimpleSelectorItemBinding.a(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics3.checkNotNullExpressionValue(dialogSimpleSelectorItemBindingA, "DialogSimpleSelectorItem…rent,\n        false\n    )");
        return new WidgetPriceTierPickerBottomSheet3(dialogSimpleSelectorItemBindingA);
    }
}
