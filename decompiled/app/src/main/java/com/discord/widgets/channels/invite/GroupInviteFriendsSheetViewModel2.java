package com.discord.widgets.channels.invite;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.stores.StoreUser;
import j0.k.Func1;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: GroupInviteFriendsSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001aj\u0012.\b\u0001\u0012*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\b \u0005*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u00000\u0000 \u0005*4\u0012.\b\u0001\u0012*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\b \u0005*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u00000\u0000\u0018\u00010\u00070\u000726\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "kotlin.jvm.PlatformType", "relationships", "Lrx/Observable;", "Lcom/discord/models/user/User;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel$Companion$observeFriends$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GroupInviteFriendsSheetViewModel2<T, R> implements Func1<Map<Long, ? extends Integer>, Observable<? extends Map<Long, ? extends User>>> {
    public final /* synthetic */ StoreUser $storeUser;

    public GroupInviteFriendsSheetViewModel2(StoreUser storeUser) {
        this.$storeUser = storeUser;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends User>> call(Map<Long, ? extends Integer> map) {
        return call2((Map<Long, Integer>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, User>> call2(Map<Long, Integer> map) {
        return this.$storeUser.observeUsers(map.keySet());
    }
}
