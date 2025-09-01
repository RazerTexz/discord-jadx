package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import kotlin.Metadata;

/* compiled from: WidgetDirectoryEntryViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/directories/DirectoryChannelItemClickInterface;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "", "onEntryClicked", "(JJ)V", "onGoToGuildClicked", "(J)V", "onAddServerClicked", "()V", "Lcom/discord/api/directory/DirectoryEntryGuild;", "directoryEntry", "", "isServerOwner", "onOverflowClicked", "(Lcom/discord/api/directory/DirectoryEntryGuild;JZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface DirectoryChannelItemClickInterface {

    /* compiled from: WidgetDirectoryEntryViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onAddServerClicked(DirectoryChannelItemClickInterface directoryChannelItemClickInterface) {
        }
    }

    void onAddServerClicked();

    void onEntryClicked(long guildId, long channelId);

    void onGoToGuildClicked(long guildId);

    void onOverflowClicked(DirectoryEntryGuild directoryEntry, long channelId, boolean isServerOwner);
}
