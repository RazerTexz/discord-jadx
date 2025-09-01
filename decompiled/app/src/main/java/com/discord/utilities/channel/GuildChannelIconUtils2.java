package com.discord.utilities.channel;

import androidx.annotation.DrawableRes;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.utilities.PermissionOverwriteUtils;
import com.discord.utilities.channel.GuildChannelIconUtils;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: GuildChannelIconUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\t\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/utilities/channel/GuildChannelIconType;", "getChannelType", "(Lcom/discord/api/channel/Channel;)Lcom/discord/utilities/channel/GuildChannelIconType;", "guildChannelIconType", "", "mapGuildChannelTypeToIcon", "(Lcom/discord/utilities/channel/GuildChannelIconType;)I", "guildChannelIcon", "(Lcom/discord/api/channel/Channel;)I", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.channel.GuildChannelIconUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildChannelIconUtils2 {
    public static final GuildChannelIconUtils getChannelType(Channel channel) {
        if (channel == null) {
            return GuildChannelIconUtils.Text.INSTANCE;
        }
        Object obj = null;
        if (ChannelUtils.s(channel, null, 1)) {
            if (channel.getNsfw()) {
                return GuildChannelIconUtils.NSFW.ForumPost.INSTANCE;
            }
            List<PermissionOverwrite> listV = channel.v();
            if (listV != null) {
                Iterator<T> it = listV.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((PermissionOverwrite) next).e() == channel.getGuildId()) {
                        obj = next;
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite = (PermissionOverwrite) obj;
                if (permissionOverwrite != null && PermissionOverwriteUtils.denies(permissionOverwrite, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconUtils.Locked.ForumPost.INSTANCE;
                }
            }
            return GuildChannelIconUtils.ForumPost.INSTANCE;
        }
        int type = channel.getType();
        if (type == 2) {
            return channel.getNsfw() ? GuildChannelIconUtils.NSFW.Voice.INSTANCE : GuildChannelIconUtils.Voice.INSTANCE;
        }
        if (type == 5) {
            if (channel.getNsfw()) {
                return GuildChannelIconUtils.NSFW.Announcements.INSTANCE;
            }
            List<PermissionOverwrite> listV2 = channel.v();
            if (listV2 != null) {
                Iterator<T> it2 = listV2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    if (((PermissionOverwrite) next2).e() == channel.getGuildId()) {
                        obj = next2;
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite2 = (PermissionOverwrite) obj;
                if (permissionOverwrite2 != null && PermissionOverwriteUtils.denies(permissionOverwrite2, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconUtils.Locked.Announcements.INSTANCE;
                }
            }
            return GuildChannelIconUtils.Announcements.INSTANCE;
        }
        if (type == 14) {
            return GuildChannelIconUtils.Directory.INSTANCE;
        }
        if (type == 15) {
            if (channel.getNsfw()) {
                return GuildChannelIconUtils.NSFW.Forum.INSTANCE;
            }
            List<PermissionOverwrite> listV3 = channel.v();
            if (listV3 != null) {
                Iterator<T> it3 = listV3.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Object next3 = it3.next();
                    if (((PermissionOverwrite) next3).e() == channel.getGuildId()) {
                        obj = next3;
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite3 = (PermissionOverwrite) obj;
                if (permissionOverwrite3 != null && PermissionOverwriteUtils.denies(permissionOverwrite3, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconUtils.Locked.Forum.INSTANCE;
                }
            }
            return GuildChannelIconUtils.Forum.INSTANCE;
        }
        switch (type) {
            case 10:
                return channel.getNsfw() ? GuildChannelIconUtils.NSFW.Thread.INSTANCE : GuildChannelIconUtils.Thread.INSTANCE;
            case 11:
                return channel.getNsfw() ? GuildChannelIconUtils.NSFW.Thread.INSTANCE : GuildChannelIconUtils.Thread.INSTANCE;
            case 12:
                return GuildChannelIconUtils.Locked.Thread.INSTANCE;
            default:
                if (channel.getNsfw()) {
                    return GuildChannelIconUtils.NSFW.Text.INSTANCE;
                }
                List<PermissionOverwrite> listV4 = channel.v();
                if (listV4 != null) {
                    Iterator<T> it4 = listV4.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            Object next4 = it4.next();
                            if (((PermissionOverwrite) next4).e() == channel.getGuildId()) {
                                obj = next4;
                            }
                        }
                    }
                    PermissionOverwrite permissionOverwrite4 = (PermissionOverwrite) obj;
                    if (permissionOverwrite4 != null && PermissionOverwriteUtils.denies(permissionOverwrite4, Permission.VIEW_CHANNEL)) {
                        return GuildChannelIconUtils.Locked.Text.INSTANCE;
                    }
                }
                return GuildChannelIconUtils.Text.INSTANCE;
        }
    }

    public static final int guildChannelIcon(Channel channel) {
        return mapGuildChannelTypeToIcon(getChannelType(channel));
    }

    @DrawableRes
    public static final int mapGuildChannelTypeToIcon(GuildChannelIconUtils guildChannelIconUtils) {
        Intrinsics3.checkNotNullParameter(guildChannelIconUtils, "guildChannelIconType");
        if (Intrinsics3.areEqual(guildChannelIconUtils, GuildChannelIconUtils.Text.INSTANCE)) {
            return R.drawable.ic_channel_text;
        }
        if (guildChannelIconUtils instanceof GuildChannelIconUtils.Thread) {
            return R.drawable.ic_thread;
        }
        if (guildChannelIconUtils instanceof GuildChannelIconUtils.Announcements) {
            return R.drawable.ic_channel_announcements;
        }
        if (guildChannelIconUtils instanceof GuildChannelIconUtils.Forum) {
            return R.drawable.ic_channel_forum;
        }
        if (!(guildChannelIconUtils instanceof GuildChannelIconUtils.ForumPost)) {
            if (guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.Text) {
                return R.drawable.ic_channel_text_nsfw;
            }
            if (guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.Announcements) {
                return R.drawable.ic_channel_announcements_nsfw;
            }
            if (guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.Thread) {
                return R.drawable.ic_thread_locked;
            }
            if (guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.Voice) {
                return R.drawable.ic_voice_nsfw;
            }
            if (guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.Forum) {
                return R.drawable.ic_channel_forum_nsfw;
            }
            if (!(guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.ForumPost)) {
                if (guildChannelIconUtils instanceof GuildChannelIconUtils.Locked.Text) {
                    return R.drawable.ic_channel_text_locked;
                }
                if (guildChannelIconUtils instanceof GuildChannelIconUtils.Locked.Announcements) {
                    return R.drawable.ic_channel_announcements_locked;
                }
                if (guildChannelIconUtils instanceof GuildChannelIconUtils.Locked.Thread) {
                    return R.drawable.ic_thread_locked;
                }
                if (guildChannelIconUtils instanceof GuildChannelIconUtils.Locked.Forum) {
                    return R.drawable.ic_channel_forum_locked;
                }
                if (!(guildChannelIconUtils instanceof GuildChannelIconUtils.Locked.ForumPost)) {
                    if (guildChannelIconUtils instanceof GuildChannelIconUtils.Directory) {
                        return R.drawable.ic_hub_24dp;
                    }
                    if (guildChannelIconUtils instanceof GuildChannelIconUtils.Voice) {
                        return R.drawable.ic_channel_voice_grey_header_24dp;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return R.drawable.ic_channel_forum_post;
    }
}
