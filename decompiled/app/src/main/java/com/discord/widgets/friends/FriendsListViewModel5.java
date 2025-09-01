package com.discord.widgets.friends;

import com.discord.utilities.user.UserUtils;
import com.discord.widgets.friends.FriendsListViewModel;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: FriendsListViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Item$PendingFriendRequest;", "kotlin.jvm.PlatformType", "lhs", "rhs", "", "compare", "(Lcom/discord/widgets/friends/FriendsListViewModel$Item$PendingFriendRequest;Lcom/discord/widgets/friends/FriendsListViewModel$Item$PendingFriendRequest;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.friends.FriendsListViewModel$getItems$sortedPendingItems$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class FriendsListViewModel5<T> implements Comparator<FriendsListViewModel.Item.PendingFriendRequest> {
    public static final FriendsListViewModel5 INSTANCE = new FriendsListViewModel5();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(FriendsListViewModel.Item.PendingFriendRequest pendingFriendRequest, FriendsListViewModel.Item.PendingFriendRequest pendingFriendRequest2) {
        return compare2(pendingFriendRequest, pendingFriendRequest2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(FriendsListViewModel.Item.PendingFriendRequest pendingFriendRequest, FriendsListViewModel.Item.PendingFriendRequest pendingFriendRequest2) {
        if (pendingFriendRequest.getRelationshipType() == 3 && pendingFriendRequest2.getRelationshipType() == 4) {
            return -1;
        }
        if (pendingFriendRequest.getRelationshipType() == 4 && pendingFriendRequest2.getRelationshipType() == 3) {
            return 1;
        }
        return UserUtils.INSTANCE.compareUserNames(pendingFriendRequest.getUser(), pendingFriendRequest2.getUser());
    }
}
