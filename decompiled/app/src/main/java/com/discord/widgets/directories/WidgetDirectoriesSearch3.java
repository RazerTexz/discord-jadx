package com.discord.widgets.directories;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.stores.StoreStream;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.widgets.directories.DirectoryChannelItemClickInterface;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetDirectoriesSearch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/discord/widgets/directories/WidgetDirectoriesSearch$adapter$1", "Lcom/discord/widgets/directories/DirectoryChannelItemClickInterface;", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "", "onEntryClicked", "(JJ)V", "onGoToGuildClicked", "(J)V", "Lcom/discord/api/directory/DirectoryEntryGuild;", "directoryEntry", "", "isServerOwner", "onOverflowClicked", "(Lcom/discord/api/directory/DirectoryEntryGuild;JZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearch$adapter$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetDirectoriesSearch3 implements DirectoryChannelItemClickInterface {
    public final /* synthetic */ WidgetDirectoriesSearch this$0;

    public WidgetDirectoriesSearch3(WidgetDirectoriesSearch widgetDirectoriesSearch) {
        this.this$0 = widgetDirectoriesSearch;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onAddServerClicked() {
        DirectoryChannelItemClickInterface.DefaultImpls.onAddServerClicked(this);
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onEntryClicked(long guildId, long channelId) {
        Context context = this.this$0.getContext();
        if (context != null) {
            WidgetDirectoriesSearchViewModel viewModel = this.this$0.getViewModel();
            Intrinsics3.checkNotNullExpressionValue(context, "it");
            viewModel.joinGuild(context, guildId, channelId);
        }
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onGoToGuildClicked(long guildId) {
        StoreStream.INSTANCE.getGuildSelected().set(guildId);
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onOverflowClicked(DirectoryEntryGuild directoryEntry, long channelId, boolean isServerOwner) {
        Intrinsics3.checkNotNullParameter(directoryEntry, "directoryEntry");
        DirectoryUtils directoryUtils = DirectoryUtils.INSTANCE;
        WidgetDirectoriesSearch widgetDirectoriesSearch = this.this$0;
        directoryUtils.showServerOptions(widgetDirectoriesSearch, directoryEntry, widgetDirectoriesSearch.getViewModel().getHubName(), isServerOwner, new WidgetDirectoriesSearch4(this, directoryEntry, channelId));
    }
}
