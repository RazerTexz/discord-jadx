package com.discord.utilities.views;

import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SwipeableItemTouchHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001#B3\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000f\u0012\b\b\u0002\u0010 \u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b!\u0010\"J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJG\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/discord/utilities/views/SwipeableItemTouchHelper;", "Landroidx/recyclerview/widget/ItemTouchHelper$SimpleCallback;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "target", "", "onMove", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "Landroid/graphics/Canvas;", "c", "", "dX", "dY", "", "actionState", "isCurrentlyActive", "", "onChildDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;FFIZ)V", "Lcom/discord/utilities/views/SwipeableItemTouchHelper$SwipeRevealConfiguration;", "startConfiguration", "Lcom/discord/utilities/views/SwipeableItemTouchHelper$SwipeRevealConfiguration;", "getStartConfiguration", "()Lcom/discord/utilities/views/SwipeableItemTouchHelper$SwipeRevealConfiguration;", "endConfiguration", "getEndConfiguration", "Landroid/graphics/drawable/ColorDrawable;", "background", "Landroid/graphics/drawable/ColorDrawable;", "dragDirs", "swipeDirs", "<init>", "(IILcom/discord/utilities/views/SwipeableItemTouchHelper$SwipeRevealConfiguration;Lcom/discord/utilities/views/SwipeableItemTouchHelper$SwipeRevealConfiguration;)V", "SwipeRevealConfiguration", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class SwipeableItemTouchHelper extends ItemTouchHelper.SimpleCallback {
    private final ColorDrawable background;
    private final SwipeRevealConfiguration endConfiguration;
    private final SwipeRevealConfiguration startConfiguration;

    /* compiled from: SwipeableItemTouchHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/utilities/views/SwipeableItemTouchHelper$SwipeRevealConfiguration;", "", "", "backgroundColor", "I", "getBackgroundColor", "()I", "padding", "getPadding", "Landroid/graphics/drawable/Drawable;", "icon", "Landroid/graphics/drawable/Drawable;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "<init>", "(ILandroid/graphics/drawable/Drawable;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class SwipeRevealConfiguration {
        private final int backgroundColor;
        private final Drawable icon;
        private final int padding;

        public SwipeRevealConfiguration() {
            this(0, null, 0, 7, null);
        }

        public SwipeRevealConfiguration(@ColorInt int i, Drawable drawable, int i2) {
            this.backgroundColor = i;
            this.icon = drawable;
            this.padding = i2;
        }

        public final int getBackgroundColor() {
            return this.backgroundColor;
        }

        public final Drawable getIcon() {
            return this.icon;
        }

        public final int getPadding() {
            return this.padding;
        }

        public /* synthetic */ SwipeRevealConfiguration(int i, Drawable drawable, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? null : drawable, (i3 & 4) != 0 ? 0 : i2);
        }
    }

    public SwipeableItemTouchHelper() {
        this(0, 0, null, null, 15, null);
    }

    public /* synthetic */ SwipeableItemTouchHelper(int i, int i2, SwipeRevealConfiguration swipeRevealConfiguration, SwipeRevealConfiguration swipeRevealConfiguration2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 12 : i2, (i3 & 4) != 0 ? null : swipeRevealConfiguration, (i3 & 8) != 0 ? null : swipeRevealConfiguration2);
    }

    public final SwipeRevealConfiguration getEndConfiguration() {
        return this.endConfiguration;
    }

    public final SwipeRevealConfiguration getStartConfiguration() {
        return this.startConfiguration;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        Intrinsics3.checkNotNullParameter(c, "c");
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
        View view = viewHolder.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "viewHolder.itemView");
        float f = 0;
        if (dX > f && this.startConfiguration != null) {
            int left = view.getLeft();
            int left2 = view.getLeft() + ((int) dX);
            this.background.setColor(this.startConfiguration.getBackgroundColor());
            this.background.setBounds(left, view.getTop(), left2, view.getBottom());
            this.background.draw(c);
            Drawable icon = this.startConfiguration.getIcon();
            if (icon != null) {
                int iMin = Math.min(this.startConfiguration.getPadding() + icon.getIntrinsicWidth() + left, left2);
                int intrinsicWidth = iMin - icon.getIntrinsicWidth();
                int height = ((view.getHeight() - icon.getIntrinsicHeight()) / 2) + view.getTop();
                icon.setBounds(intrinsicWidth, height, iMin, icon.getIntrinsicHeight() + height);
                icon.draw(c);
            }
        } else if (dX < f && this.endConfiguration != null) {
            int right = view.getRight() + ((int) dX);
            int right2 = view.getRight();
            this.background.setColor(this.endConfiguration.getBackgroundColor());
            this.background.setBounds(right, view.getTop(), right2, view.getBottom());
            this.background.draw(c);
            Drawable icon2 = this.endConfiguration.getIcon();
            if (icon2 != null) {
                int iMin2 = right2 - Math.min((int) Math.abs(dX), this.endConfiguration.getPadding() + icon2.getIntrinsicWidth());
                int intrinsicWidth2 = icon2.getIntrinsicWidth() + iMin2;
                int height2 = ((view.getHeight() - icon2.getIntrinsicHeight()) / 2) + view.getTop();
                icon2.setBounds(iMin2, height2, intrinsicWidth2, icon2.getIntrinsicHeight() + height2);
                icon2.draw(c);
            }
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics3.checkNotNullParameter(target, "target");
        return false;
    }

    public SwipeableItemTouchHelper(int i, int i2, SwipeRevealConfiguration swipeRevealConfiguration, SwipeRevealConfiguration swipeRevealConfiguration2) {
        super(i, i2);
        this.startConfiguration = swipeRevealConfiguration;
        this.endConfiguration = swipeRevealConfiguration2;
        this.background = new ColorDrawable();
    }
}
