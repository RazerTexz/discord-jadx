package com.discord.widgets.friends;

import androidx.core.app.NotificationCompat;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.widgets.friends.WidgetFriendsAddUserAdapter;
import com.discord.widgets.friends.WidgetFriendsFindNearby;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: WidgetFriendsFindNearby.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000f\u001a\n \u0004*\u0004\u0018\u00010\f0\f2.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u000026\u0010\b\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0006j\u0002`\u0007 \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0018\u00010\u00000\u000026\u0010\u000b\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\tj\u0002`\n \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\tj\u0002`\n\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "kotlin.jvm.PlatformType", "users", "Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "presences", "", "Lcom/discord/primitives/RelationshipType;", "relationships", "Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model$NearbyUsers;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model$NearbyUsers;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$ModelProvider$getUserModels$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetFriendsFindNearby3<T1, T2, T3, R> implements Func3<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends Integer>, WidgetFriendsFindNearby.Model.NearbyUsers> {
    public static final WidgetFriendsFindNearby3 INSTANCE = new WidgetFriendsFindNearby3();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetFriendsFindNearby.Model.NearbyUsers call(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2, Map<Long, ? extends Integer> map3) {
        return call2(map, (Map<Long, Presence>) map2, (Map<Long, Integer>) map3);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetFriendsFindNearby.Model.NearbyUsers call2(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, Integer> map3) {
        Intrinsics3.checkNotNullExpressionValue(map, "users");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<Long, ? extends User> entry : map.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            User value = entry.getValue();
            List listEmptyList = Collections2.emptyList();
            Presence presence = map2.get(Long.valueOf(jLongValue));
            Integer num = map3.get(Long.valueOf(jLongValue));
            boolean z2 = true;
            if (num == null || num.intValue() != 1) {
                z2 = false;
            }
            arrayList.add(new WidgetFriendsAddUserAdapter.ItemUser(value, listEmptyList, presence, z2));
        }
        return new WidgetFriendsFindNearby.Model.NearbyUsers(arrayList);
    }
}
