package com.discord.utilities.channel;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheet;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetFeatureFlag;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChannelInviteLaunchUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/utilities/channel/ChannelInviteLaunchUtils;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/discord/api/channel/Channel;", "channel", "", "source", "", "eventId", "inviteStoreKey", "", "inviteToChannel", "(Landroidx/fragment/app/Fragment;Lcom/discord/api/channel/Channel;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelInviteLaunchUtils {
    public static final ChannelInviteLaunchUtils INSTANCE = new ChannelInviteLaunchUtils();

    private ChannelInviteLaunchUtils() {
    }

    public static /* synthetic */ void inviteToChannel$default(ChannelInviteLaunchUtils channelInviteLaunchUtils, Fragment fragment, Channel channel, String str, Long l, String str2, int i, Object obj) {
        channelInviteLaunchUtils.inviteToChannel(fragment, channel, str, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : str2);
    }

    public final void inviteToChannel(Fragment fragment, Channel channel, String source, Long eventId, String inviteStoreKey) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(source, "source");
        if (channel != null) {
            long id2 = channel.getId();
            if (channel.getGuildId() != 0) {
                WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
                Context contextRequireContext = fragment.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
                FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
                WidgetGuildInviteShare.Companion.launch$default(companion, contextRequireContext, childFragmentManager, channel.getGuildId(), Long.valueOf(id2), false, eventId, inviteStoreKey, source, 16, null);
                return;
            }
            if (GroupInviteFriendsSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
                GroupInviteFriendsSheet.Companion companion2 = GroupInviteFriendsSheet.INSTANCE;
                FragmentManager childFragmentManager2 = fragment.getChildFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(childFragmentManager2, "fragment.childFragmentManager");
                companion2.show(childFragmentManager2, id2, source);
                return;
            }
            WidgetGroupInviteFriends.Companion companion3 = WidgetGroupInviteFriends.INSTANCE;
            Context contextRequireContext2 = fragment.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "fragment.requireContext()");
            companion3.launch(contextRequireContext2, id2, source);
        }
    }
}
