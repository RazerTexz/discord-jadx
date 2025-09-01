package com.discord.widgets.chat.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ThreadSpineItemDecoration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b!\u0010\"J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0015\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001a\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/discord/widgets/chat/list/ThreadSpineItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "canvas", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "", "handleRecyclerViewChildren", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;)V", "Landroid/view/View;", "child", "drawSpinePiece", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;)V", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "onDrawOver", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/drawable/Drawable;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "getAdapter", "()Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "startPositionPx", "I", "<init>", "(Landroid/content/Context;Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ThreadSpineItemDecoration extends RecyclerView.ItemDecoration {
    private final WidgetChatListAdapter adapter;
    private final Context context;
    private final Drawable drawable;
    private final int startPositionPx;

    public ThreadSpineItemDecoration(Context context, WidgetChatListAdapter widgetChatListAdapter) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        this.context = context;
        this.adapter = widgetChatListAdapter;
        this.drawable = ContextCompat.getDrawable(context, R.drawable.thread_embed_spine_drawable);
        this.startPositionPx = context.getResources().getDimensionPixelSize(R.dimen.chat_list_spine_margin);
    }

    private final void drawSpinePiece(Canvas canvas, RecyclerView parent, View child) {
        Rect rect = new Rect();
        parent.getDecoratedBoundsWithMargins(child, rect);
        Drawable drawable = this.drawable;
        if (drawable != null) {
            int i = this.startPositionPx;
            drawable.setBounds(i, rect.top, drawable.getIntrinsicWidth() + i, rect.bottom);
            this.drawable.draw(canvas);
        }
    }

    private final void handleRecyclerViewChildren(Canvas canvas, RecyclerView parent) {
        canvas.save();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            int childAdapterPosition = parent.getChildAdapterPosition(childAt);
            if (childAdapterPosition >= 0 && childAdapterPosition < this.adapter.getPageSize() && this.adapter.getItem(childAdapterPosition).getShouldShowThreadSpine()) {
                Intrinsics3.checkNotNullExpressionValue(childAt, "child");
                drawSpinePiece(canvas, parent, childAt);
            }
        }
        canvas.restore();
    }

    public final WidgetChatListAdapter getAdapter() {
        return this.adapter;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
        Intrinsics3.checkNotNullParameter(parent, "parent");
        Intrinsics3.checkNotNullParameter(state, "state");
        if (parent.getLayoutManager() == null) {
            return;
        }
        handleRecyclerViewChildren(canvas, parent);
    }
}
