package com.discord.widgets.guilds.list;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: GuildsDragAndDropCallback.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0003-./B\u000f\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b+\u0010,J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0011J7\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u000bH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u000bH\u0016¢\u0006\u0004\b'\u0010&R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u00060"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildsDragAndDropCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "getMovementFlags", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)I", "source", "target", "", "onMove", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "actionState", "", "onSelectedChanged", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "i", "onSwiped", "viewSize", "viewSizeOutOfBounds", "totalSize", "", "msSinceStartScroll", "interpolateOutOfBoundsScroll", "(Landroidx/recyclerview/widget/RecyclerView;IIIJ)I", "selected", "", "dropTargets", "curX", "curY", "chooseDropTarget", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;II)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "getMoveThreshold", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)F", "isLongPressDragEnabled", "()Z", "isItemViewSwipeEnabled", "Lcom/discord/widgets/guilds/list/GuildsDragAndDropCallback$Controller;", "controller", "Lcom/discord/widgets/guilds/list/GuildsDragAndDropCallback$Controller;", "<init>", "(Lcom/discord/widgets/guilds/list/GuildsDragAndDropCallback$Controller;)V", "Companion", "Controller", "DraggableViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildsDragAndDropCallback extends ItemTouchHelper.Callback {
    private static final int DEFAULT_DRAG_SCROLL_SPEED = 20;
    private static final float MOVE_THRESHOLD = 0.2f;
    private final Controller controller;

    /* compiled from: GuildsDragAndDropCallback.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildsDragAndDropCallback$Controller;", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "onDragStarted", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "onDrop", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "source", "target", "", "onMove", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "selected", "", "dropTargets", "", "curX", "curY", "chooseDropTarget", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;II)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface Controller {
        RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder selected, List<RecyclerView.ViewHolder> dropTargets, int curX, int curY);

        void onDragStarted(RecyclerView.ViewHolder viewHolder);

        void onDrop();

        boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target);
    }

    /* compiled from: GuildsDragAndDropCallback.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildsDragAndDropCallback$DraggableViewHolder;", "", "", "canDrag", "()Z", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface DraggableViewHolder {
        boolean canDrag();
    }

    public GuildsDragAndDropCallback(Controller controller) {
        Intrinsics3.checkNotNullParameter(controller, "controller");
        this.controller = controller;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder selected, List<RecyclerView.ViewHolder> dropTargets, int curX, int curY) {
        Intrinsics3.checkNotNullParameter(selected, "selected");
        Intrinsics3.checkNotNullParameter(dropTargets, "dropTargets");
        return this.controller.chooseDropTarget(selected, dropTargets, curX, curY);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
        Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
        return 0.2f;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
        boolean z2 = viewHolder instanceof DraggableViewHolder;
        Object obj = viewHolder;
        if (!z2) {
            obj = null;
        }
        DraggableViewHolder draggableViewHolder = (DraggableViewHolder) obj;
        return ItemTouchHelper.Callback.makeMovementFlags(draggableViewHolder != null && draggableViewHolder.canDrag() ? 3 : 0, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int viewSize, int viewSizeOutOfBounds, int totalSize, long msSinceStartScroll) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        return ((int) Math.signum(viewSizeOutOfBounds)) * 20;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(source, "source");
        Intrinsics3.checkNotNullParameter(target, "target");
        return this.controller.onMove(recyclerView, source, target);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState == 2) {
            if (viewHolder != null) {
                this.controller.onDragStarted(viewHolder);
            }
        } else if (actionState == 0) {
            this.controller.onDrop();
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
    }
}
