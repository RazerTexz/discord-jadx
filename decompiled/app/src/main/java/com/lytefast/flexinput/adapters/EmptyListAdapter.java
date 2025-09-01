package com.lytefast.flexinput.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: EmptyListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018B#\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/lytefast/flexinput/adapters/EmptyListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/lytefast/flexinput/adapters/EmptyListAdapter$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/lytefast/flexinput/adapters/EmptyListAdapter$ViewHolder;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Lcom/lytefast/flexinput/adapters/EmptyListAdapter$ViewHolder;I)V", "getItemCount", "()I", "actionBtnId", "I", "itemLayoutId", "Landroid/view/View$OnClickListener;", "onClickListener", "Landroid/view/View$OnClickListener;", "<init>", "(IILandroid/view/View$OnClickListener;)V", "ViewHolder", "flexinput_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class EmptyListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final int actionBtnId;
    private final int itemLayoutId;
    private final View.OnClickListener onClickListener;

    /* compiled from: EmptyListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0007\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/lytefast/flexinput/adapters/EmptyListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "a", "Landroid/view/View;", "getActionBtn$flexinput_release", "()Landroid/view/View;", "actionBtn", "itemView", "<init>", "(Lcom/lytefast/flexinput/adapters/EmptyListAdapter;Landroid/view/View;)V", "flexinput_release"}, k = 1, mv = {1, 4, 2})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: from kotlin metadata */
        public final View actionBtn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(EmptyListAdapter emptyListAdapter, View view) {
            super(view);
            Intrinsics3.checkNotNullParameter(view, "itemView");
            View viewFindViewById = view.findViewById(EmptyListAdapter.access$getActionBtnId$p(emptyListAdapter));
            Intrinsics3.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(actionBtnId)");
            this.actionBtn = viewFindViewById;
        }
    }

    public EmptyListAdapter(@LayoutRes int i, @IdRes int i2, View.OnClickListener onClickListener) {
        Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
        this.itemLayoutId = i;
        this.actionBtnId = i2;
        this.onClickListener = onClickListener;
    }

    public static final /* synthetic */ int access$getActionBtnId$p(EmptyListAdapter emptyListAdapter) {
        return emptyListAdapter.actionBtnId;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((ViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.actionBtn.setOnClickListener(this.onClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(this.itemLayoutId, parent, false);
        Intrinsics3.checkNotNullExpressionValue(viewInflate, "view");
        return new ViewHolder(this, viewInflate);
    }
}
