package com.discord.widgets.channels.invite;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: GroupInviteFriendsSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "kotlin.jvm.PlatformType", "friendsUsers", "Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GroupInviteFriendsSheetViewModel3<T, R> implements Func1<Map<Long, ? extends User>, GroupInviteFriendsSheetViewModel.StoreState> {
    public static final GroupInviteFriendsSheetViewModel3 INSTANCE = new GroupInviteFriendsSheetViewModel3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ GroupInviteFriendsSheetViewModel.StoreState call(Map<Long, ? extends User> map) {
        return call2(map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GroupInviteFriendsSheetViewModel.StoreState call2(Map<Long, ? extends User> map) {
        Intrinsics3.checkNotNullExpressionValue(map, "friendsUsers");
        return new GroupInviteFriendsSheetViewModel.StoreState(map, null, 2, null);
    }
}
