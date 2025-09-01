package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.databinding.DirectoryEntryListItemBinding;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.views.directories.ServerDiscoveryItem;
import com.discord.widgets.directories.DirectoryChannelItem;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetDirectoryEntryViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/directories/DirectoryEntryViewHolder;", "Lcom/discord/widgets/directories/DirectoryChannelViewHolder;", "Lcom/discord/widgets/directories/DirectoryChannelItem;", "item", "Lcom/discord/widgets/directories/DirectoryChannelItemClickInterface;", "listener", "", "bind", "(Lcom/discord/widgets/directories/DirectoryChannelItem;Lcom/discord/widgets/directories/DirectoryChannelItemClickInterface;)V", "Lcom/discord/databinding/DirectoryEntryListItemBinding;", "viewBinding", "Lcom/discord/databinding/DirectoryEntryListItemBinding;", "getViewBinding", "()Lcom/discord/databinding/DirectoryEntryListItemBinding;", "<init>", "(Lcom/discord/databinding/DirectoryEntryListItemBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class DirectoryEntryViewHolder extends DirectoryChannelViewHolder {
    private final DirectoryEntryListItemBinding viewBinding;

    /* JADX WARN: Illegal instructions before constructor call */
    public DirectoryEntryViewHolder(DirectoryEntryListItemBinding directoryEntryListItemBinding) {
        Intrinsics3.checkNotNullParameter(directoryEntryListItemBinding, "viewBinding");
        ServerDiscoveryItem serverDiscoveryItem = directoryEntryListItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(serverDiscoveryItem, "viewBinding.root");
        super(serverDiscoveryItem);
        this.viewBinding = directoryEntryListItemBinding;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelViewHolder
    public void bind(DirectoryChannelItem item, DirectoryChannelItemClickInterface listener) {
        DirectoryEntryData directoryEntryData;
        Intrinsics3.checkNotNullParameter(item, "item");
        Intrinsics3.checkNotNullParameter(listener, "listener");
        if (!(item instanceof DirectoryChannelItem.DirectoryItem)) {
            item = null;
        }
        DirectoryChannelItem.DirectoryItem directoryItem = (DirectoryChannelItem.DirectoryItem) item;
        if (directoryItem == null || (directoryEntryData = directoryItem.getDirectoryEntryData()) == null) {
            return;
        }
        DirectoryEntryGuild entry = directoryEntryData.getEntry();
        ServerDiscoveryItem serverDiscoveryItem = this.viewBinding.f2096b;
        serverDiscoveryItem.setTitle(entry.getGuild().getName());
        serverDiscoveryItem.setDescription(entry.getDescription());
        Integer approximateMemberCount = entry.getGuild().getApproximateMemberCount();
        serverDiscoveryItem.setMembers(approximateMemberCount != null ? approximateMemberCount.intValue() : 0);
        Integer approximatePresenceCount = entry.getGuild().getApproximatePresenceCount();
        serverDiscoveryItem.setOnline(approximatePresenceCount != null ? approximatePresenceCount.intValue() : 0);
        String forGuild$default = IconUtils.getForGuild$default(Long.valueOf(entry.getGuild().getId()), entry.getGuild().getIcon(), null, false, null, 28, null);
        String strComputeShortName = GuildUtils.computeShortName(entry.getGuild().getName());
        Intrinsics3.checkNotNullParameter(strComputeShortName, "fallbackText");
        serverDiscoveryItem.binding.f.a(forGuild$default, strComputeShortName);
        if (directoryEntryData.getHasJoinedGuild()) {
            serverDiscoveryItem.setJoinButtonOnClickListener(null);
            serverDiscoveryItem.setJoinedButtonOnClickListener(new DirectoryEntryViewHolder$bind$$inlined$apply$lambda$2(entry, directoryEntryData, listener));
        } else {
            serverDiscoveryItem.setJoinButtonOnClickListener(new DirectoryEntryViewHolder$bind$$inlined$apply$lambda$1(entry, directoryEntryData, listener));
            serverDiscoveryItem.setJoinedButtonOnClickListener(null);
        }
        serverDiscoveryItem.setOnLongClickListener(new DirectoryEntryViewHolder$bind$$inlined$apply$lambda$3(entry, directoryEntryData, listener));
        serverDiscoveryItem.setJoinedGuild(directoryEntryData.getHasJoinedGuild());
    }

    public final DirectoryEntryListItemBinding getViewBinding() {
        return this.viewBinding;
    }
}
