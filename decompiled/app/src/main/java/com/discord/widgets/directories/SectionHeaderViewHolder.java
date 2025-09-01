package com.discord.widgets.directories;

import android.widget.TextView;
import b.a.k.FormatUtils;
import com.discord.databinding.DirectorySectionHeaderListItemBinding;
import com.discord.widgets.directories.DirectoryChannelItem;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetDirectoryEntryViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/directories/SectionHeaderViewHolder;", "Lcom/discord/widgets/directories/DirectoryChannelViewHolder;", "Lcom/discord/widgets/directories/DirectoryChannelItem;", "item", "Lcom/discord/widgets/directories/DirectoryChannelItemClickInterface;", "listener", "", "bind", "(Lcom/discord/widgets/directories/DirectoryChannelItem;Lcom/discord/widgets/directories/DirectoryChannelItemClickInterface;)V", "Lcom/discord/databinding/DirectorySectionHeaderListItemBinding;", "viewBinding", "Lcom/discord/databinding/DirectorySectionHeaderListItemBinding;", "getViewBinding", "()Lcom/discord/databinding/DirectorySectionHeaderListItemBinding;", "<init>", "(Lcom/discord/databinding/DirectorySectionHeaderListItemBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SectionHeaderViewHolder extends DirectoryChannelViewHolder {
    private final DirectorySectionHeaderListItemBinding viewBinding;

    /* JADX WARN: Illegal instructions before constructor call */
    public SectionHeaderViewHolder(DirectorySectionHeaderListItemBinding directorySectionHeaderListItemBinding) {
        Intrinsics3.checkNotNullParameter(directorySectionHeaderListItemBinding, "viewBinding");
        TextView textView = directorySectionHeaderListItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(textView, "viewBinding.root");
        super(textView);
        this.viewBinding = directorySectionHeaderListItemBinding;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelViewHolder
    public void bind(DirectoryChannelItem item, DirectoryChannelItemClickInterface listener) {
        Intrinsics3.checkNotNullParameter(item, "item");
        Intrinsics3.checkNotNullParameter(listener, "listener");
        int textRes = ((DirectoryChannelItem.SectionHeader) item).getTextRes();
        TextView textView = this.viewBinding.f2097b;
        Intrinsics3.checkNotNullExpressionValue(textView, "viewBinding.directorySectionText");
        FormatUtils.n(textView, textRes, new Object[0], null, 4);
    }

    public final DirectorySectionHeaderListItemBinding getViewBinding() {
        return this.viewBinding;
    }
}
