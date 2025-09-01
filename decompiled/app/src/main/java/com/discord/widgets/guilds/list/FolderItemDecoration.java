package com.discord.widgets.guilds.list;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.widgets.guilds.list.GuildListViewHolder;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: FolderItemDecoration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/guilds/list/FolderItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "canvas", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "", "drawBackgroundForInitialFolder", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;)I", "c", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "halfSize", "I", "Landroid/graphics/drawable/Drawable;", "tintableDrawableNoChildren", "Landroid/graphics/drawable/Drawable;", "drawableNoChildren", "drawableWithChildren", "sizePx", "<init>", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;I)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class FolderItemDecoration extends RecyclerView.ItemDecoration {
    private static final int EXTRA_PADDING_PX = 200;
    private final Drawable drawableNoChildren;
    private final Drawable drawableWithChildren;
    private final int halfSize;
    private final Drawable tintableDrawableNoChildren;

    public FolderItemDecoration(Drawable drawable, Drawable drawable2, Drawable drawable3, int i) {
        Intrinsics3.checkNotNullParameter(drawable, "drawableNoChildren");
        Intrinsics3.checkNotNullParameter(drawable2, "tintableDrawableNoChildren");
        Intrinsics3.checkNotNullParameter(drawable3, "drawableWithChildren");
        this.drawableNoChildren = drawable;
        this.tintableDrawableNoChildren = drawable2;
        this.drawableWithChildren = drawable3;
        this.halfSize = i / 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int drawBackgroundForInitialFolder(Canvas canvas, RecyclerView parent) {
        int i;
        boolean z2 = false;
        View childAt = parent.getChildAt(0);
        RecyclerView.ViewHolder childViewHolder = parent.getChildViewHolder(childAt);
        if (childViewHolder instanceof GuildListViewHolder.GuildViewHolder) {
            GuildListViewHolder.GuildViewHolder guildViewHolder = (GuildListViewHolder.GuildViewHolder) childViewHolder;
            if (guildViewHolder.getFolderId() != null) {
                Long folderId = guildViewHolder.getFolderId();
                boolean z3 = true;
                i = 1;
                while (z3 && i < parent.getChildCount()) {
                    RecyclerView.ViewHolder childViewHolder2 = parent.getChildViewHolder(parent.getChildAt(i));
                    if ((childViewHolder2 instanceof GuildListViewHolder.GuildViewHolder) && Intrinsics3.areEqual(((GuildListViewHolder.GuildViewHolder) childViewHolder2).getFolderId(), folderId)) {
                        i++;
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
            } else {
                i = 0;
            }
        }
        if (i > 0) {
            Intrinsics3.checkNotNullExpressionValue(childAt, "firstView");
            int left = (childAt.getLeft() + childAt.getRight()) / 2;
            int top = (childAt.getTop() + childAt.getBottom()) / 2;
            boolean z4 = parent.getChildCount() == i;
            RecyclerView.ViewHolder childViewHolder3 = parent.getChildViewHolder(parent.getChildAt(parent.getChildCount() - 1));
            if (z4 && (childViewHolder3 instanceof GuildListViewHolder.GuildViewHolder) && Intrinsics3.areEqual(((GuildListViewHolder.GuildViewHolder) childViewHolder3).isLastGuildInFolder(), Boolean.FALSE)) {
                z2 = true;
            }
            int height = childAt.getHeight();
            int i2 = this.halfSize;
            int i3 = ((i - 1) * height) + top + i2;
            if (z2) {
                i3 += 200;
            }
            this.drawableWithChildren.setBounds(left - i2, (top - i2) - 200, left + i2, i3);
            this.drawableWithChildren.draw(canvas);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        Drawable drawable;
        Intrinsics3.checkNotNullParameter(c, "c");
        Intrinsics3.checkNotNullParameter(parent, "parent");
        Intrinsics3.checkNotNullParameter(state, "state");
        if (parent.getChildCount() < 1) {
            return;
        }
        int childCount = parent.getChildCount();
        for (int iDrawBackgroundForInitialFolder = drawBackgroundForInitialFolder(c, parent); iDrawBackgroundForInitialFolder < childCount; iDrawBackgroundForInitialFolder++) {
            View childAt = parent.getChildAt(iDrawBackgroundForInitialFolder);
            RecyclerView.ViewHolder childViewHolder = parent.getChildViewHolder(childAt);
            if (childViewHolder instanceof GuildListViewHolder.FolderViewHolder) {
                GuildListViewHolder.FolderViewHolder folderViewHolder = (GuildListViewHolder.FolderViewHolder) childViewHolder;
                if (folderViewHolder.shouldDrawDecoration()) {
                    Intrinsics3.checkNotNullExpressionValue(childAt, "view");
                    int left = (childAt.getLeft() + childAt.getRight()) / 2;
                    int top = (childAt.getTop() + childAt.getBottom()) / 2;
                    int numChildren = folderViewHolder.getNumChildren();
                    if (numChildren == 0) {
                        Integer color = folderViewHolder.getColor();
                        if (color != null) {
                            DrawableCompat.setTint(this.tintableDrawableNoChildren, color.intValue());
                            drawable = this.tintableDrawableNoChildren;
                        } else {
                            drawable = this.drawableNoChildren;
                        }
                        int i = this.halfSize;
                        drawable.setBounds(left - i, top - i, left + i, top + i);
                        drawable.draw(c);
                    } else {
                        int height = (childAt.getHeight() * numChildren) + this.halfSize + top;
                        Drawable drawable2 = this.drawableWithChildren;
                        int i2 = this.halfSize;
                        drawable2.setBounds(left - i2, top - i2, left + i2, height);
                        this.drawableWithChildren.draw(c);
                    }
                }
            }
            if ((childViewHolder instanceof GuildListViewHolder.GuildViewHolder) && ((GuildListViewHolder.GuildViewHolder) childViewHolder).isTargetedForFolderCreation()) {
                Intrinsics3.checkNotNullExpressionValue(childAt, "view");
                int left2 = (childAt.getLeft() + childAt.getRight()) / 2;
                int top2 = (childAt.getTop() + childAt.getBottom()) / 2;
                Drawable drawable3 = this.drawableNoChildren;
                int i3 = this.halfSize;
                drawable3.setBounds(left2 - i3, top2 - i3, left2 + i3, top2 + i3);
                this.drawableNoChildren.draw(c);
            }
        }
    }
}
