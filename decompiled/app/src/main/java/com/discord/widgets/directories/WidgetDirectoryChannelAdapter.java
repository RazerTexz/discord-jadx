package com.discord.widgets.directories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.DirectoryAddServerListItemBinding;
import com.discord.databinding.DirectoryEntryListItemBinding;
import com.discord.databinding.DirectorySectionHeaderListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.directories.ServerDiscoveryItem;
import com.discord.widgets.directories.DirectoryChannelItem;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: WidgetDirectoryChannelAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b \u0010!J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R6\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoryChannelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "getItemViewType", "(I)I", "getItemCount", "()I", "Lcom/discord/widgets/directories/DirectoryChannelItemClickInterface;", "clickListener", "Lcom/discord/widgets/directories/DirectoryChannelItemClickInterface;", "getClickListener", "()Lcom/discord/widgets/directories/DirectoryChannelItemClickInterface;", "", "Lcom/discord/widgets/directories/DirectoryChannelItem;", "value", "directoryChannelItems", "Ljava/util/List;", "getDirectoryChannelItems", "()Ljava/util/List;", "setDirectoryChannelItems", "(Ljava/util/List;)V", "<init>", "(Lcom/discord/widgets/directories/DirectoryChannelItemClickInterface;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetDirectoryChannelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final DirectoryChannelItemClickInterface clickListener;
    private List<? extends DirectoryChannelItem> directoryChannelItems;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            DirectoryChannelItem.ViewType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[DirectoryChannelItem.ViewType.Item.ordinal()] = 1;
            iArr[DirectoryChannelItem.ViewType.AddServer.ordinal()] = 2;
            iArr[DirectoryChannelItem.ViewType.SectionHeader.ordinal()] = 3;
        }
    }

    public WidgetDirectoryChannelAdapter(DirectoryChannelItemClickInterface directoryChannelItemClickInterface) {
        Intrinsics3.checkNotNullParameter(directoryChannelItemClickInterface, "clickListener");
        this.clickListener = directoryChannelItemClickInterface;
        this.directoryChannelItems = Collections2.emptyList();
    }

    public final DirectoryChannelItemClickInterface getClickListener() {
        return this.clickListener;
    }

    public final List<DirectoryChannelItem> getDirectoryChannelItems() {
        return this.directoryChannelItems;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.directoryChannelItems.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.directoryChannelItems.get(position).getViewType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        if (!(holder instanceof DirectoryChannelViewHolder)) {
            holder = null;
        }
        DirectoryChannelViewHolder directoryChannelViewHolder = (DirectoryChannelViewHolder) holder;
        if (directoryChannelViewHolder != null) {
            directoryChannelViewHolder.bind(this.directoryChannelItems.get(position), this.clickListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        int iOrdinal = DirectoryChannelItem.ViewType.INSTANCE.findType(viewType).ordinal();
        if (iOrdinal == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.directory_entry_list_item, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            ServerDiscoveryItem serverDiscoveryItem = (ServerDiscoveryItem) viewInflate;
            DirectoryEntryListItemBinding directoryEntryListItemBinding = new DirectoryEntryListItemBinding(serverDiscoveryItem, serverDiscoveryItem);
            Intrinsics3.checkNotNullExpressionValue(directoryEntryListItemBinding, "DirectoryEntryListItemBi…          false\n        )");
            return new DirectoryEntryViewHolder(directoryEntryListItemBinding);
        }
        if (iOrdinal == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.directory_add_server_list_item, parent, false);
            Objects.requireNonNull(viewInflate2, "rootView");
            TextView textView = (TextView) viewInflate2;
            DirectoryAddServerListItemBinding directoryAddServerListItemBinding = new DirectoryAddServerListItemBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(directoryAddServerListItemBinding, "DirectoryAddServerListIt…          false\n        )");
            return new AddServerViewHolder(directoryAddServerListItemBinding);
        }
        if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.directory_section_header_list_item, parent, false);
        Objects.requireNonNull(viewInflate3, "rootView");
        TextView textView2 = (TextView) viewInflate3;
        DirectorySectionHeaderListItemBinding directorySectionHeaderListItemBinding = new DirectorySectionHeaderListItemBinding(textView2, textView2);
        Intrinsics3.checkNotNullExpressionValue(directorySectionHeaderListItemBinding, "DirectorySectionHeaderLi…          false\n        )");
        return new SectionHeaderViewHolder(directorySectionHeaderListItemBinding);
    }

    public final void setDirectoryChannelItems(List<? extends DirectoryChannelItem> list) {
        Intrinsics3.checkNotNullParameter(list, "value");
        this.directoryChannelItems = list;
        notifyDataSetChanged();
    }
}
