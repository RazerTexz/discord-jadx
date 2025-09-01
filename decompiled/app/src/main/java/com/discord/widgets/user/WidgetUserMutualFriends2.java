package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.widgets.user.WidgetUserMutualFriends;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func6;

/* compiled from: WidgetUserMutualFriends.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/models/domain/ModelUserRelationship;", "kotlin.jvm.PlatformType", "relationshipsApiResponse", "Lrx/Observable;", "Lcom/discord/widgets/user/WidgetUserMutualFriends$Model;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.WidgetUserMutualFriends$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserMutualFriends2<T, R> implements Func1<List<? extends ModelUserRelationship>, Observable<? extends WidgetUserMutualFriends.Model>> {
    public final /* synthetic */ long $userId;

    /* compiled from: WidgetUserMutualFriends.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0015\u001a\n \u0005*\u0004\u0018\u00010\u00120\u00122:\u0010\u0006\u001a6\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003 \u0005*\u001a\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00000\u00002.\u0010\b\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0007 \u0005*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00000\u000026\u0010\u000b\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\tj\u0002`\n \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\tj\u0002`\n\u0018\u00010\u00000\u000026\u0010\u000e\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\fj\u0002`\r \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\fj\u0002`\r\u0018\u00010\u00000\u00002.\u0010\u0010\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u000f \u0005*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00000\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0004\b\u0013\u0010\u0014"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/models/guild/Guild;", "kotlin.jvm.PlatformType", "mutualGuilds", "Lcom/discord/models/user/User;", "users", "Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "presences", "", "Lcom/discord/primitives/RelationshipType;", "relationships", "Lcom/discord/models/domain/ModelApplicationStream;", "applicationStreams", "modelUser", "Lcom/discord/widgets/user/WidgetUserMutualFriends$Model;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/discord/models/user/User;)Lcom/discord/widgets/user/WidgetUserMutualFriends$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserMutualFriends$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, R> implements Func6<Map<Long, ? extends List<? extends Guild>>, Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends Integer>, Map<Long, ? extends ModelApplicationStream>, User, WidgetUserMutualFriends.Model> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func6
        public /* bridge */ /* synthetic */ WidgetUserMutualFriends.Model call(Map<Long, ? extends List<? extends Guild>> map, Map<Long, ? extends User> map2, Map<Long, ? extends Presence> map3, Map<Long, ? extends Integer> map4, Map<Long, ? extends ModelApplicationStream> map5, User user) {
            return call2((Map<Long, ? extends List<Guild>>) map, map2, (Map<Long, Presence>) map3, (Map<Long, Integer>) map4, map5, user);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetUserMutualFriends.Model call2(Map<Long, ? extends List<Guild>> map, Map<Long, ? extends User> map2, Map<Long, Presence> map3, Map<Long, Integer> map4, Map<Long, ? extends ModelApplicationStream> map5, User user) {
            Intrinsics3.checkNotNullExpressionValue(map2, "users");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, ? extends User> entry : map2.entrySet()) {
                if (map4.containsKey(Long.valueOf(entry.getKey().longValue()))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                long jLongValue = ((Number) entry2.getKey()).longValue();
                User user2 = (User) entry2.getValue();
                Presence presence = map3.get(Long.valueOf(jLongValue));
                List<Guild> listEmptyList = map.get(Long.valueOf(jLongValue));
                if (listEmptyList == null) {
                    listEmptyList = Collections2.emptyList();
                }
                arrayList.add(new WidgetUserMutualFriends.Model.Item.MutualFriend(user2, presence, listEmptyList, Boolean.valueOf(map5.containsKey(Long.valueOf(jLongValue)))));
            }
            return new WidgetUserMutualFriends.Model(user, arrayList.isEmpty() ? _Collections.plus((Collection<? extends WidgetUserMutualFriends.Model.Item.Empty>) arrayList, WidgetUserMutualFriends.Model.Item.Empty.INSTANCE) : arrayList, arrayList.size());
        }
    }

    public WidgetUserMutualFriends2(long j) {
        this.$userId = j;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetUserMutualFriends.Model> call(List<? extends ModelUserRelationship> list) {
        return call2(list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetUserMutualFriends.Model> call2(List<? extends ModelUserRelationship> list) {
        Intrinsics3.checkNotNullExpressionValue(list, "relationshipsApiResponse");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((ModelUserRelationship) it.next()).getId()));
        }
        Observable<Map<Long, List<Guild>>> observableObserveMutualGuilds = new UserMutualGuildsManager(null, null, null, 7, null).observeMutualGuilds(arrayList);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveMutualGuilds, companion.getUsers().observeUsers(arrayList), companion.getPresences().observePresencesForUsers(arrayList), companion.getUserRelationships().observe(), companion.getApplicationStreaming().observeStreamsByUser(), companion.getUsers().observeUser(this.$userId), AnonymousClass1.INSTANCE, 1000L, TimeUnit.MILLISECONDS);
    }
}
