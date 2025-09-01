package com.discord.utilities.views;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StickyHeaderItemDecoration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002'(B\u000f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b%\u0010&J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010 \u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/discord/utilities/views/StickyHeaderItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "", "itemPosition", "Landroid/view/View;", "getAndBindHeaderViewForItem", "(I)Landroid/view/View;", "Landroid/graphics/Canvas;", "c", "header", "", "offsetY", "", "drawHeader", "(Landroid/graphics/Canvas;Landroid/view/View;F)V", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "contactPoint", "getOverlappingView", "(Landroidx/recyclerview/widget/RecyclerView;I)Landroid/view/View;", "resetActionDownCoordinates", "()V", "blockClicks", "(Landroidx/recyclerview/widget/RecyclerView;)V", "canvas", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "onDrawOver", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "actionDownRawY", "Ljava/lang/Float;", "actionDownRawX", "stickyHeaderBottom", "F", "Lcom/discord/utilities/views/StickyHeaderItemDecoration$StickyHeaderAdapter;", "adapter", "Lcom/discord/utilities/views/StickyHeaderItemDecoration$StickyHeaderAdapter;", "<init>", "(Lcom/discord/utilities/views/StickyHeaderItemDecoration$StickyHeaderAdapter;)V", "LayoutManager", "StickyHeaderAdapter", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StickyHeaderItemDecoration extends RecyclerView.ItemDecoration {
    private Float actionDownRawX;
    private Float actionDownRawY;
    private final StickyHeaderAdapter adapter;
    private float stickyHeaderBottom;

    /* compiled from: StickyHeaderItemDecoration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/views/StickyHeaderItemDecoration$LayoutManager;", "", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "view", "", "layoutHeaderView", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class LayoutManager {
        public static final LayoutManager INSTANCE = new LayoutManager();

        private LayoutManager() {
        }

        public static final void layoutHeaderView(ViewGroup parent, View view) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            Intrinsics3.checkNotNullParameter(view, "view");
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(parent.getWidth(), BasicMeasure.EXACTLY);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(parent.getHeight(), 0);
            view.measure(ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, parent.getPaddingRight() + parent.getPaddingLeft(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(iMakeMeasureSpec2, parent.getPaddingBottom() + parent.getPaddingTop(), view.getLayoutParams().height));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* compiled from: StickyHeaderItemDecoration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/discord/utilities/views/StickyHeaderItemDecoration$StickyHeaderAdapter;", "", "", "itemPosition", "getHeaderPositionForItem", "(I)Ljava/lang/Integer;", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "isHeader", "(I)Z", "Landroid/view/View;", "getAndBindHeaderView", "(I)Landroid/view/View;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface StickyHeaderAdapter {
        View getAndBindHeaderView(int position);

        Integer getHeaderPositionForItem(int itemPosition);

        boolean isHeader(int position);
    }

    /* compiled from: StickyHeaderItemDecoration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/discord/utilities/views/StickyHeaderItemDecoration$blockClicks$1", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/MotionEvent;", "event", "", "onInterceptTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)Z", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.views.StickyHeaderItemDecoration$blockClicks$1, reason: invalid class name */
    public static final class AnonymousClass1 extends RecyclerView.SimpleOnItemTouchListener {
        public AnonymousClass1() {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
        @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent event) {
            boolean z2;
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics3.checkNotNullParameter(event, "event");
            int action = event.getAction();
            if (action == 0) {
                StickyHeaderItemDecoration.access$setActionDownRawX$p(StickyHeaderItemDecoration.this, Float.valueOf(event.getRawX()));
                StickyHeaderItemDecoration.access$setActionDownRawY$p(StickyHeaderItemDecoration.this, Float.valueOf(event.getRawY()));
            } else if (action == 1) {
                Float fAccess$getActionDownRawX$p = StickyHeaderItemDecoration.access$getActionDownRawX$p(StickyHeaderItemDecoration.this);
                Float fAccess$getActionDownRawY$p = StickyHeaderItemDecoration.access$getActionDownRawY$p(StickyHeaderItemDecoration.this);
                if (fAccess$getActionDownRawX$p == null || fAccess$getActionDownRawY$p == null) {
                    z2 = false;
                    StickyHeaderItemDecoration.access$resetActionDownCoordinates(StickyHeaderItemDecoration.this);
                    if (!z2 && event.getY() <= StickyHeaderItemDecoration.access$getStickyHeaderBottom$p(StickyHeaderItemDecoration.this)) {
                        return true;
                    }
                } else {
                    float fAbs = Math.abs(event.getRawX() - fAccess$getActionDownRawX$p.floatValue());
                    float fAbs2 = Math.abs(event.getRawY() - fAccess$getActionDownRawY$p.floatValue());
                    float dimensionPixelSize = recyclerView.getResources().getDimensionPixelSize(R.dimen.default_scroll_slop);
                    if (fAbs < dimensionPixelSize && fAbs2 < dimensionPixelSize) {
                        z2 = true;
                    }
                    StickyHeaderItemDecoration.access$resetActionDownCoordinates(StickyHeaderItemDecoration.this);
                    if (!z2) {
                    }
                }
            } else if (action == 3) {
                StickyHeaderItemDecoration.access$resetActionDownCoordinates(StickyHeaderItemDecoration.this);
            }
            return false;
        }
    }

    public StickyHeaderItemDecoration(StickyHeaderAdapter stickyHeaderAdapter) {
        Intrinsics3.checkNotNullParameter(stickyHeaderAdapter, "adapter");
        this.adapter = stickyHeaderAdapter;
    }

    public static final /* synthetic */ Float access$getActionDownRawX$p(StickyHeaderItemDecoration stickyHeaderItemDecoration) {
        return stickyHeaderItemDecoration.actionDownRawX;
    }

    public static final /* synthetic */ Float access$getActionDownRawY$p(StickyHeaderItemDecoration stickyHeaderItemDecoration) {
        return stickyHeaderItemDecoration.actionDownRawY;
    }

    public static final /* synthetic */ float access$getStickyHeaderBottom$p(StickyHeaderItemDecoration stickyHeaderItemDecoration) {
        return stickyHeaderItemDecoration.stickyHeaderBottom;
    }

    public static final /* synthetic */ void access$resetActionDownCoordinates(StickyHeaderItemDecoration stickyHeaderItemDecoration) {
        stickyHeaderItemDecoration.resetActionDownCoordinates();
    }

    public static final /* synthetic */ void access$setActionDownRawX$p(StickyHeaderItemDecoration stickyHeaderItemDecoration, Float f) {
        stickyHeaderItemDecoration.actionDownRawX = f;
    }

    public static final /* synthetic */ void access$setActionDownRawY$p(StickyHeaderItemDecoration stickyHeaderItemDecoration, Float f) {
        stickyHeaderItemDecoration.actionDownRawY = f;
    }

    public static final /* synthetic */ void access$setStickyHeaderBottom$p(StickyHeaderItemDecoration stickyHeaderItemDecoration, float f) {
        stickyHeaderItemDecoration.stickyHeaderBottom = f;
    }

    private final void drawHeader(Canvas c, View header, float offsetY) {
        c.save();
        if (offsetY != 0.0f) {
            c.translate(0.0f, offsetY);
        }
        this.stickyHeaderBottom = header.getBottom() - offsetY;
        header.draw(c);
        c.restore();
    }

    public static /* synthetic */ void drawHeader$default(StickyHeaderItemDecoration stickyHeaderItemDecoration, Canvas canvas, View view, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        stickyHeaderItemDecoration.drawHeader(canvas, view, f);
    }

    private final View getAndBindHeaderViewForItem(int itemPosition) {
        Integer headerPositionForItem = this.adapter.getHeaderPositionForItem(itemPosition);
        if (headerPositionForItem == null) {
            return null;
        }
        return this.adapter.getAndBindHeaderView(headerPositionForItem.intValue());
    }

    private final View getOverlappingView(RecyclerView parent, int contactPoint) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            Intrinsics3.checkNotNullExpressionValue(childAt, "child");
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            if (top <= contactPoint && bottom > contactPoint) {
                return childAt;
            }
        }
        return null;
    }

    private final void resetActionDownCoordinates() {
        this.actionDownRawX = null;
        this.actionDownRawY = null;
    }

    public final void blockClicks(RecyclerView parent) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        parent.addOnItemTouchListener(new AnonymousClass1());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        int childAdapterPosition;
        int childAdapterPosition2;
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
        Intrinsics3.checkNotNullParameter(parent, "parent");
        Intrinsics3.checkNotNullParameter(state, "state");
        super.onDrawOver(canvas, parent, state);
        View childAt = parent.getChildAt(0);
        if (childAt == null || (childAdapterPosition = parent.getChildAdapterPosition(childAt)) == -1) {
            return;
        }
        View andBindHeaderViewForItem = getAndBindHeaderViewForItem(childAdapterPosition);
        float top = 0.0f;
        if (andBindHeaderViewForItem == null) {
            this.stickyHeaderBottom = 0.0f;
            return;
        }
        int top2 = parent.getTop() + andBindHeaderViewForItem.getBottom();
        int top3 = parent.getTop();
        int bottom = parent.getBottom();
        if (top3 > top2 || bottom <= top2) {
            return;
        }
        View overlappingView = getOverlappingView(parent, andBindHeaderViewForItem.getBottom());
        if (overlappingView != null && (childAdapterPosition2 = parent.getChildAdapterPosition(overlappingView)) != -1 && this.adapter.isHeader(childAdapterPosition2)) {
            top = overlappingView.getTop() - andBindHeaderViewForItem.getHeight();
        }
        drawHeader(canvas, andBindHeaderViewForItem, top);
    }
}
