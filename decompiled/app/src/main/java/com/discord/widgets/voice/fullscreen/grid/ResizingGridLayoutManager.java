package com.discord.widgets.voice.fullscreen.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import d0.d0._Ranges;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ResizingGridLayoutManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010!\u001a\u00020\u000e\u0012\u0006\u0010\"\u001a\u00020\b\u0012\u0006\u0010#\u001a\u00020\b¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0012\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\b8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\nR\u0016\u0010 \u001a\u00020\b8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\n¨\u0006&"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/grid/ResizingGridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "layoutParams", "spanLayoutSize", "(Landroidx/recyclerview/widget/RecyclerView$LayoutParams;)Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "spanLayoutSizeVerticalOrientation", "spanLayoutSizeHorizontalOrientation", "", "maxRows", "()I", "maxColumns", "generateDefaultLayoutParams", "()Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "Landroid/content/Context;", "c", "Landroid/util/AttributeSet;", "attrs", "generateLayoutParams", "(Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "Landroid/view/ViewGroup$LayoutParams;", "lp", "(Landroid/view/ViewGroup$LayoutParams;)Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "", "checkLayoutParams", "(Landroidx/recyclerview/widget/RecyclerView$LayoutParams;)Z", "canScrollVertically", "()Z", "canScrollHorizontally", "getVerticalSpace", "verticalSpace", "getHorizontalSpace", "horizontalSpace", "context", "spanCount", "orientation", "<init>", "(Landroid/content/Context;II)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public class ResizingGridLayoutManager extends GridLayoutManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResizingGridLayoutManager(Context context, int i, int i2) {
        super(context, i, i2, false);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    private final int getHorizontalSpace() {
        return (getWidth() - getPaddingRight()) - getPaddingLeft();
    }

    private final int getVerticalSpace() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    private final int maxColumns() {
        return 4;
    }

    private final int maxRows() {
        return 4;
    }

    private final RecyclerView.LayoutParams spanLayoutSize(RecyclerView.LayoutParams layoutParams) {
        int orientation = getOrientation();
        if (orientation == 0) {
            spanLayoutSizeHorizontalOrientation(layoutParams);
        } else if (orientation == 1) {
            spanLayoutSizeVerticalOrientation(layoutParams);
        }
        return layoutParams;
    }

    private final RecyclerView.LayoutParams spanLayoutSizeHorizontalOrientation(RecyclerView.LayoutParams layoutParams) {
        int itemCount = 2;
        if (getItemCount() != 2) {
            itemCount = (getItemCount() % 2) + (getItemCount() / 2);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).width = _Ranges.coerceAtLeast(getHorizontalSpace() / itemCount, getHorizontalSpace() / maxColumns());
        return layoutParams;
    }

    private final RecyclerView.LayoutParams spanLayoutSizeVerticalOrientation(RecyclerView.LayoutParams layoutParams) {
        int itemCount = 2;
        if (getItemCount() != 2) {
            itemCount = (getItemCount() % 2) + (getItemCount() / 2);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).height = _Ranges.coerceAtLeast(getVerticalSpace() / itemCount, getVerticalSpace() / maxRows());
        return layoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return getOrientation() == 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return getOrientation() == 1;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
        Intrinsics3.checkNotNullParameter(lp, "lp");
        RecyclerView.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        return super.checkLayoutParams(lp) && ((ViewGroup.MarginLayoutParams) layoutParamsGenerateDefaultLayoutParams).width == ((ViewGroup.MarginLayoutParams) lp).width && ((ViewGroup.MarginLayoutParams) layoutParamsGenerateDefaultLayoutParams).height == ((ViewGroup.MarginLayoutParams) lp).height;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        RecyclerView.LayoutParams layoutParamsGenerateDefaultLayoutParams = super.generateDefaultLayoutParams();
        Intrinsics3.checkNotNullExpressionValue(layoutParamsGenerateDefaultLayoutParams, "super.generateDefaultLayoutParams()");
        return spanLayoutSize(layoutParamsGenerateDefaultLayoutParams);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context c, AttributeSet attrs) {
        Intrinsics3.checkNotNullParameter(c, "c");
        Intrinsics3.checkNotNullParameter(attrs, "attrs");
        RecyclerView.LayoutParams layoutParamsGenerateLayoutParams = super.generateLayoutParams(c, attrs);
        Intrinsics3.checkNotNullExpressionValue(layoutParamsGenerateLayoutParams, "super.generateLayoutParams(c, attrs)");
        return spanLayoutSize(layoutParamsGenerateLayoutParams);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        Intrinsics3.checkNotNullParameter(lp, "lp");
        RecyclerView.LayoutParams layoutParamsGenerateLayoutParams = super.generateLayoutParams(lp);
        Intrinsics3.checkNotNullExpressionValue(layoutParamsGenerateLayoutParams, "super.generateLayoutParams(lp)");
        return spanLayoutSize(layoutParamsGenerateLayoutParams);
    }
}
