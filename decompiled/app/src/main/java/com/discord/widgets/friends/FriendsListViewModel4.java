package com.discord.widgets.friends;

import com.discord.utilities.user.UserUtils;
import com.discord.widgets.friends.FriendsListViewModel;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: FriendsListViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Item$Friend;", "kotlin.jvm.PlatformType", "lhs", "rhs", "", "compare", "(Lcom/discord/widgets/friends/FriendsListViewModel$Item$Friend;Lcom/discord/widgets/friends/FriendsListViewModel$Item$Friend;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.friends.FriendsListViewModel$getItems$onlineFriendItems$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class FriendsListViewModel4<T> implements Comparator<FriendsListViewModel.Item.Friend> {
    public static final FriendsListViewModel4 INSTANCE = new FriendsListViewModel4();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(FriendsListViewModel.Item.Friend friend, FriendsListViewModel.Item.Friend friend2) {
        return compare2(friend, friend2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(FriendsListViewModel.Item.Friend friend, FriendsListViewModel.Item.Friend friend2) {
        return UserUtils.INSTANCE.compareUserNames(friend.getUser(), friend2.getUser());
    }
}
