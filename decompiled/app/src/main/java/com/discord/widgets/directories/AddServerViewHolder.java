package com.discord.widgets.directories;

import android.view.View;
import android.widget.TextView;
import com.discord.databinding.DirectoryAddServerListItemBinding;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetDirectoryEntryViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/directories/AddServerViewHolder;", "Lcom/discord/widgets/directories/DirectoryChannelViewHolder;", "Lcom/discord/widgets/directories/DirectoryChannelItem;", "item", "Lcom/discord/widgets/directories/DirectoryChannelItemClickInterface;", "listener", "", "bind", "(Lcom/discord/widgets/directories/DirectoryChannelItem;Lcom/discord/widgets/directories/DirectoryChannelItemClickInterface;)V", "Lcom/discord/databinding/DirectoryAddServerListItemBinding;", "viewBinding", "Lcom/discord/databinding/DirectoryAddServerListItemBinding;", "getViewBinding", "()Lcom/discord/databinding/DirectoryAddServerListItemBinding;", "<init>", "(Lcom/discord/databinding/DirectoryAddServerListItemBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AddServerViewHolder extends DirectoryChannelViewHolder {
    private final DirectoryAddServerListItemBinding viewBinding;

    /* compiled from: WidgetDirectoryEntryViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.AddServerViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ DirectoryChannelItemClickInterface $listener;

        public AnonymousClass1(DirectoryChannelItemClickInterface directoryChannelItemClickInterface) {
            this.$listener = directoryChannelItemClickInterface;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$listener.onAddServerClicked();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AddServerViewHolder(DirectoryAddServerListItemBinding directoryAddServerListItemBinding) {
        Intrinsics3.checkNotNullParameter(directoryAddServerListItemBinding, "viewBinding");
        TextView textView = directoryAddServerListItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(textView, "viewBinding.root");
        super(textView);
        this.viewBinding = directoryAddServerListItemBinding;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelViewHolder
    public void bind(DirectoryChannelItem item, DirectoryChannelItemClickInterface listener) {
        Intrinsics3.checkNotNullParameter(item, "item");
        Intrinsics3.checkNotNullParameter(listener, "listener");
        this.viewBinding.f2095b.setOnClickListener(new AnonymousClass1(listener));
    }

    public final DirectoryAddServerListItemBinding getViewBinding() {
        return this.viewBinding;
    }
}
