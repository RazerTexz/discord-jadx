package com.discord.widgets.channels.invite;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: GroupInviteFriendsSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002.\u0010\u0007\u001a*\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "kotlin.jvm.PlatformType", "friendUsersMap", "Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;Ljava/util/Map;)Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel$Companion$observeStoreState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GroupInviteFriendsSheetViewModel4<T1, T2, R> implements Func2<Channel, Map<Long, ? extends User>, GroupInviteFriendsSheetViewModel.StoreState> {
    public static final GroupInviteFriendsSheetViewModel4 INSTANCE = new GroupInviteFriendsSheetViewModel4();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ GroupInviteFriendsSheetViewModel.StoreState call(Channel channel, Map<Long, ? extends User> map) {
        return call2(channel, map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GroupInviteFriendsSheetViewModel.StoreState call2(Channel channel, Map<Long, ? extends User> map) {
        Intrinsics3.checkNotNullExpressionValue(map, "friendUsersMap");
        return new GroupInviteFriendsSheetViewModel.StoreState(map, channel);
    }
}
