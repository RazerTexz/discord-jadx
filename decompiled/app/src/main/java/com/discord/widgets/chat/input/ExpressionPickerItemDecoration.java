package com.discord.widgets.chat.input;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;

/* compiled from: ExpressionPickerItemDecoration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/chat/input/ExpressionPickerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "", "itemPosition", "getNextHeaderPositionForItem", "(I)Ljava/lang/Integer;", "getHeaderPositionForItem", "(I)I", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "headerIndices", "Ljava/util/List;", "numOfColumns", "I", "bottomPaddingForLastRow", "<init>", "(ILjava/util/List;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ExpressionPickerItemDecoration extends RecyclerView.ItemDecoration {
    private final int bottomPaddingForLastRow;
    private final List<Integer> headerIndices;
    private final int numOfColumns;

    public ExpressionPickerItemDecoration(int i, List<Integer> list, int i2) {
        Intrinsics3.checkNotNullParameter(list, "headerIndices");
        this.numOfColumns = i;
        this.headerIndices = list;
        this.bottomPaddingForLastRow = i2;
    }

    private final int getHeaderPositionForItem(int itemPosition) {
        Integer numPrevious;
        List<Integer> list = this.headerIndices;
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                numPrevious = null;
                break;
            }
            numPrevious = listIterator.previous();
            if (itemPosition >= numPrevious.intValue()) {
                break;
            }
        }
        Integer num = numPrevious;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private final Integer getNextHeaderPositionForItem(int itemPosition) {
        Object next;
        Iterator<T> it = this.headerIndices.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (itemPosition <= ((Number) next).intValue()) {
                break;
            }
        }
        return (Integer) next;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics3.checkNotNullParameter(outRect, "outRect");
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(parent, "parent");
        Intrinsics3.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        if (this.headerIndices.isEmpty()) {
            return;
        }
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (this.headerIndices.contains(Integer.valueOf(childAdapterPosition))) {
            return;
        }
        int headerPositionForItem = getHeaderPositionForItem(childAdapterPosition);
        Integer nextHeaderPositionForItem = getNextHeaderPositionForItem(childAdapterPosition);
        int iIntValue = ((nextHeaderPositionForItem != null ? nextHeaderPositionForItem.intValue() : state.getItemCount()) - headerPositionForItem) - 1;
        int i = (childAdapterPosition - headerPositionForItem) - 1;
        int i2 = this.numOfColumns;
        outRect.bottom = i >= ((iIntValue / i2) - (iIntValue % i2 == 0 ? 1 : 0)) * i2 ? this.bottomPaddingForLastRow : 0;
    }
}
