package com.discord.widgets.forums;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetForumBrowserAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/discord/widgets/forums/WidgetForumBrowserAdapter$itemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.forums.WidgetForumBrowserAdapter$itemDecoration$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetForumBrowserAdapter4 extends RecyclerView.ItemDecoration {
    public final /* synthetic */ WidgetForumBrowserAdapter this$0;

    public WidgetForumBrowserAdapter4(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
        this.this$0 = widgetForumBrowserAdapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics3.checkNotNullParameter(outRect, "outRect");
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(parent, "parent");
        Intrinsics3.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            return;
        }
        boolean z2 = childAdapterPosition == 0;
        int type = ((ForumBrowserItem) WidgetForumBrowserAdapter.access$getInternalData$p(this.this$0).get(childAdapterPosition)).getType();
        if (type == 0) {
            outRect.top = DimenUtils.dpToPixels(24);
            outRect.bottom = DimenUtils.dpToPixels(8);
            outRect.left = DimenUtils.dpToPixels(16);
        }
        if (type == 1) {
            outRect.bottom = DimenUtils.dpToPixels(12);
            outRect.top = z2 ? DimenUtils.dpToPixels(12) : 0;
        }
    }
}
