package com.discord.widgets.directories;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WidgetDirectoryChannelViewPagerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR6\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoryChannelViewPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "()I", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/directories/WidgetDirectoryCategory;", "createFragment", "(I)Lcom/discord/widgets/directories/WidgetDirectoryCategory;", "", "Lcom/discord/models/hubs/DirectoryEntryCategory;", "value", "tabs", "Ljava/util/List;", "getTabs", "()Ljava/util/List;", "setTabs", "(Ljava/util/List;)V", "Lcom/discord/app/AppFragment;", "fragment", "<init>", "(Lcom/discord/app/AppFragment;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetDirectoryChannelViewPagerAdapter extends FragmentStateAdapter {
    private List<? extends DirectoryEntryCategory> tabs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryChannelViewPagerAdapter(AppFragment appFragment) {
        super(appFragment);
        Intrinsics3.checkNotNullParameter(appFragment, "fragment");
        this.tabs = Collections2.emptyList();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public /* bridge */ /* synthetic */ Fragment createFragment(int i) {
        return createFragment(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.tabs.size();
    }

    public final List<DirectoryEntryCategory> getTabs() {
        return this.tabs;
    }

    public final void setTabs(List<? extends DirectoryEntryCategory> list) {
        Intrinsics3.checkNotNullParameter(list, "value");
        this.tabs = list;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public WidgetDirectoryCategory createFragment(int position) {
        WidgetDirectoryCategory widgetDirectoryCategory = new WidgetDirectoryCategory();
        DirectoryEntryCategory directoryEntryCategory = (DirectoryEntryCategory) _Collections.getOrNull(this.tabs, position);
        if (directoryEntryCategory != null) {
            widgetDirectoryCategory.setArguments(AnimatableValueParser.e2(new WidgetDirectoryCategory2(directoryEntryCategory)));
            return widgetDirectoryCategory;
        }
        StringBuilder sbV = outline.V("Couldn't find tab with position ", position, " in ");
        sbV.append(this.tabs);
        throw new IllegalStateException(sbV.toString());
    }
}
