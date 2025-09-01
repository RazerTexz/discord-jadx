package com.discord.widgets.directories;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetDirectoryEntryViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/discord/widgets/directories/DirectoryChannelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/widgets/directories/DirectoryChannelItem;", "item", "Lcom/discord/widgets/directories/DirectoryChannelItemClickInterface;", "listener", "", "bind", "(Lcom/discord/widgets/directories/DirectoryChannelItem;Lcom/discord/widgets/directories/DirectoryChannelItemClickInterface;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class DirectoryChannelViewHolder extends RecyclerView.ViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectoryChannelViewHolder(View view) {
        super(view);
        Intrinsics3.checkNotNullParameter(view, "view");
    }

    public abstract void bind(DirectoryChannelItem item, DirectoryChannelItemClickInterface listener);
}
