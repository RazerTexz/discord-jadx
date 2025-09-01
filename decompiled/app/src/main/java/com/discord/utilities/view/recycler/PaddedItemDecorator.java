package com.discord.utilities.view.recycler;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import d0.Standard2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PaddedItemDecorator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u0015\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0019\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/discord/utilities/view/recycler/PaddedItemDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "spaceHorz", "I", "getSpaceHorz", "()I", "spaceVert", "getSpaceVert", "", "spaceBetweenItemsOnly", "Z", "getSpaceBetweenItemsOnly", "()Z", "orientation", "getOrientation", "<init>", "(IIIZ)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PaddedItemDecorator extends RecyclerView.ItemDecoration {
    private final int orientation;
    private final boolean spaceBetweenItemsOnly;
    private final int spaceHorz;
    private final int spaceVert;

    public /* synthetic */ PaddedItemDecorator(int i, int i2, int i3, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i4 & 8) != 0 ? false : z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics3.checkNotNullParameter(outRect, "outRect");
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(parent, "parent");
        Intrinsics3.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        boolean z2 = childAdapterPosition == 0;
        boolean z3 = childAdapterPosition == state.getItemCount() - 1;
        int i = this.orientation;
        if (i == 0) {
            int i2 = this.spaceVert;
            outRect.top = i2;
            outRect.bottom = i2;
            outRect.left = (!z2 || this.spaceBetweenItemsOnly) ? 0 : this.spaceHorz;
            outRect.right = (z3 && this.spaceBetweenItemsOnly) ? 0 : this.spaceHorz;
            return;
        }
        if (i != 1) {
            throw new Standard2(outline.w("An operation is not implemented: ", outline.B(outline.U("Other("), this.orientation, ") orientation padding for items not supported yet.")));
        }
        outRect.top = (!z2 || this.spaceBetweenItemsOnly) ? 0 : this.spaceVert;
        outRect.bottom = (z3 && this.spaceBetweenItemsOnly) ? 0 : this.spaceVert;
        int i3 = this.spaceHorz;
        outRect.left = i3;
        outRect.right = i3;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final boolean getSpaceBetweenItemsOnly() {
        return this.spaceBetweenItemsOnly;
    }

    public final int getSpaceHorz() {
        return this.spaceHorz;
    }

    public final int getSpaceVert() {
        return this.spaceVert;
    }

    public PaddedItemDecorator(int i, int i2, int i3, boolean z2) {
        this.orientation = i;
        this.spaceHorz = i2;
        this.spaceVert = i3;
        this.spaceBetweenItemsOnly = z2;
    }
}
