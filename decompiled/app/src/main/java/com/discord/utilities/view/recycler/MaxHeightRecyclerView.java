package com.discord.utilities.view.recycler;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utils.R;
import d0.a0.MathJVM;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MaxHeightRecyclerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0007\u001a\u00020\u0005*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/discord/utilities/view/recycler/MaxHeightRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "getHeightMaximum", "(Landroid/content/Context;Landroid/util/AttributeSet;I)I", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "maxHeight", "I", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "context", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MaxHeightRecyclerView extends RecyclerView {
    private int maxHeight;

    public MaxHeightRecyclerView(Context context) {
        this(context, null, 0, 6, null);
    }

    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MaxHeightRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final int getHeightMaximum(Context context, AttributeSet attributeSet, int i) {
        if (attributeSet == null) {
            return 0;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.MaxHeightRecyclerView, i, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(a…lerView, defStyleAttr, 0)");
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.b.MaxHeightRecyclerView_max_height, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(R.b.MaxHeightRecyclerView_max_height_screen_ratio, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        if (f <= 0.0f || f >= 1.0f) {
            return dimensionPixelSize;
        }
        Intrinsics3.checkNotNullExpressionValue(context.getResources(), "resources");
        return MathJVM.roundToInt(r3.getDisplayMetrics().heightPixels * f);
    }

    public final int getMaxHeight() {
        return this.maxHeight;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = this.maxHeight;
        if (i > 0) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.maxHeight = getHeightMaximum(context, attributeSet, 0);
    }
}
