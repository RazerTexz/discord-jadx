package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetGroupInviteFriends.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\f\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\t0\t \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\t0\t\u0018\u00010\b0\b2n\u0010\u0007\u001aj\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00050\u0004j\u0002`\u0005 \u0003*4\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00050\u0004j\u0002`\u0005\u0018\u00010\u00060\u0000H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "", "Lcom/discord/primitives/RelationshipType;", "", "filteredFriends", "Lrx/Observable;", "Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$ModelAppUserRelationship;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3<T, R> implements Func1<Map<Long, Integer>, Observable<? extends WidgetGroupInviteFriends.Model.ModelAppUserRelationship>> {
    public static final WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3 INSTANCE = new WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3();

    /* compiled from: WidgetGroupInviteFriends.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b26\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u00002.\u0010\b\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0007 \u0005*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00000\u00002.\u0010\n\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\t \u0005*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "kotlin.jvm.PlatformType", "presences", "Lcom/discord/models/user/User;", "users", "Lcom/discord/models/domain/ModelApplicationStream;", "applicationStreams", "Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$ModelAppUserRelationship;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$ModelAppUserRelationship;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Map<Long, ? extends Presence>, Map<Long, ? extends User>, Map<Long, ? extends ModelApplicationStream>, WidgetGroupInviteFriends.Model.ModelAppUserRelationship> {
        public final /* synthetic */ Map $filteredFriends;

        public AnonymousClass1(Map map) {
            this.$filteredFriends = map;
        }

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetGroupInviteFriends.Model.ModelAppUserRelationship call(Map<Long, ? extends Presence> map, Map<Long, ? extends User> map2, Map<Long, ? extends ModelApplicationStream> map3) {
            return call2((Map<Long, Presence>) map, map2, map3);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetGroupInviteFriends.Model.ModelAppUserRelationship call2(Map<Long, Presence> map, Map<Long, ? extends User> map2, Map<Long, ? extends ModelApplicationStream> map3) {
            Map map4 = this.$filteredFriends;
            Intrinsics3.checkNotNullExpressionValue(map4, "filteredFriends");
            Intrinsics3.checkNotNullExpressionValue(map, "presences");
            Intrinsics3.checkNotNullExpressionValue(map2, "users");
            Intrinsics3.checkNotNullExpressionValue(map3, "applicationStreams");
            return new WidgetGroupInviteFriends.Model.ModelAppUserRelationship(map4, map, map2, map3);
        }
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends.Model.ModelAppUserRelationship> call(Map<Long, Integer> map) {
        return call2(map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGroupInviteFriends.Model.ModelAppUserRelationship> call2(Map<Long, Integer> map) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.i(companion.getPresences().observePresencesForUsers(map.keySet()), companion.getUsers().observeUsers(map.keySet()), companion.getApplicationStreaming().observeStreamsByUser(), new AnonymousClass1(map));
    }
}
