package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.channel.ChannelUtils3;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreMessagesMostRecent;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserAffinities;
import com.discord.stores.StoreUserRelationships;
import com.discord.widgets.guilds.invite.InviteSuggestion;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func3;

/* compiled from: InviteSuggestionsManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0018B9\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestionsManager;", "", "Lrx/Observable;", "", "Lcom/discord/widgets/guilds/invite/InviteSuggestion;", "observeInviteSuggestions", "()Lrx/Observable;", "Lcom/discord/stores/StoreUser;", "storeUsers", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreUserAffinities;", "storeUserAffinities", "Lcom/discord/stores/StoreUserAffinities;", "Lcom/discord/stores/StoreUserRelationships;", "storeUserRelationships", "Lcom/discord/stores/StoreUserRelationships;", "Lcom/discord/stores/StoreMessagesMostRecent;", "storeMessagesMostRecent", "Lcom/discord/stores/StoreMessagesMostRecent;", "<init>", "(Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreMessagesMostRecent;Lcom/discord/stores/StoreUserAffinities;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreUserRelationships;)V", "UserAffinityData", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class InviteSuggestionsManager {
    private final StoreChannels storeChannels;
    private final StoreMessagesMostRecent storeMessagesMostRecent;
    private final StoreUserAffinities storeUserAffinities;
    private final StoreUserRelationships storeUserRelationships;
    private final StoreUser storeUsers;

    /* compiled from: InviteSuggestionsManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002\u0012\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\b0\u0007\u0012\u001a\u0010\u0010\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u000bj\u0002`\f0\u0007¢\u0006\u0004\b!\u0010\"J\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ$\u0010\r\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u000bj\u0002`\f0\u0007HÆ\u0003¢\u0006\u0004\b\r\u0010\nJ\\\u0010\u0011\u001a\u00020\u00002\u0012\b\u0002\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00022\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\b0\u00072\u001c\b\u0002\u0010\u0010\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u000bj\u0002`\f0\u0007HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR#\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u0006R-\u0010\u0010\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u000bj\u0002`\f0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\nR)\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b \u0010\n¨\u0006#"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestionsManager$UserAffinityData;", "", "", "", "Lcom/discord/primitives/UserId;", "component1", "()Ljava/util/List;", "", "Lcom/discord/models/user/User;", "component2", "()Ljava/util/Map;", "", "Lcom/discord/primitives/RelationshipType;", "component3", "userIds", "users", "relationships", "copy", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/guilds/invite/InviteSuggestionsManager$UserAffinityData;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getUserIds", "Ljava/util/Map;", "getRelationships", "getUsers", "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UserAffinityData {
        private final Map<Long, Integer> relationships;
        private final List<Long> userIds;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public UserAffinityData(List<Long> list, Map<Long, ? extends User> map, Map<Long, Integer> map2) {
            Intrinsics3.checkNotNullParameter(list, "userIds");
            Intrinsics3.checkNotNullParameter(map, "users");
            Intrinsics3.checkNotNullParameter(map2, "relationships");
            this.userIds = list;
            this.users = map;
            this.relationships = map2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UserAffinityData copy$default(UserAffinityData userAffinityData, List list, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = userAffinityData.userIds;
            }
            if ((i & 2) != 0) {
                map = userAffinityData.users;
            }
            if ((i & 4) != 0) {
                map2 = userAffinityData.relationships;
            }
            return userAffinityData.copy(list, map, map2);
        }

        public final List<Long> component1() {
            return this.userIds;
        }

        public final Map<Long, User> component2() {
            return this.users;
        }

        public final Map<Long, Integer> component3() {
            return this.relationships;
        }

        public final UserAffinityData copy(List<Long> userIds, Map<Long, ? extends User> users, Map<Long, Integer> relationships) {
            Intrinsics3.checkNotNullParameter(userIds, "userIds");
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(relationships, "relationships");
            return new UserAffinityData(userIds, users, relationships);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserAffinityData)) {
                return false;
            }
            UserAffinityData userAffinityData = (UserAffinityData) other;
            return Intrinsics3.areEqual(this.userIds, userAffinityData.userIds) && Intrinsics3.areEqual(this.users, userAffinityData.users) && Intrinsics3.areEqual(this.relationships, userAffinityData.relationships);
        }

        public final Map<Long, Integer> getRelationships() {
            return this.relationships;
        }

        public final List<Long> getUserIds() {
            return this.userIds;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            List<Long> list = this.userIds;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            Map<Long, User> map = this.users;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Integer> map2 = this.relationships;
            return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("UserAffinityData(userIds=");
            sbU.append(this.userIds);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", relationships=");
            return outline.M(sbU, this.relationships, ")");
        }
    }

    /* compiled from: InviteSuggestionsManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "affinityUserIds", "Lrx/Observable;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionsManager$UserAffinityData;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.InviteSuggestionsManager$observeInviteSuggestions$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<List<? extends Long>, Observable<? extends UserAffinityData>> {

        /* compiled from: InviteSuggestionsManager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\f\u001a\n \u0004*\u0004\u0018\u00010\t0\t2.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u000026\u0010\b\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0006j\u0002`\u0007 \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "kotlin.jvm.PlatformType", "users", "", "Lcom/discord/primitives/RelationshipType;", "relationships", "Lcom/discord/widgets/guilds/invite/InviteSuggestionsManager$UserAffinityData;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/guilds/invite/InviteSuggestionsManager$UserAffinityData;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guilds.invite.InviteSuggestionsManager$observeInviteSuggestions$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02931<T1, T2, R> implements Func2<Map<Long, ? extends User>, Map<Long, ? extends Integer>, UserAffinityData> {
            public final /* synthetic */ List $affinityUserIds;

            public C02931(List list) {
                this.$affinityUserIds = list;
            }

            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ UserAffinityData call(Map<Long, ? extends User> map, Map<Long, ? extends Integer> map2) {
                return call2(map, (Map<Long, Integer>) map2);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final UserAffinityData call2(Map<Long, ? extends User> map, Map<Long, Integer> map2) {
                List list = this.$affinityUserIds;
                Intrinsics3.checkNotNullExpressionValue(list, "affinityUserIds");
                Intrinsics3.checkNotNullExpressionValue(map, "users");
                Intrinsics3.checkNotNullExpressionValue(map2, "relationships");
                return new UserAffinityData(list, map, map2);
            }
        }

        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends UserAffinityData> call(List<? extends Long> list) {
            return call2((List<Long>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends UserAffinityData> call2(List<Long> list) {
            StoreUser storeUserAccess$getStoreUsers$p = InviteSuggestionsManager.access$getStoreUsers$p(InviteSuggestionsManager.this);
            Intrinsics3.checkNotNullExpressionValue(list, "affinityUserIds");
            return Observable.j(storeUserAccess$getStoreUsers$p.observeUsers(list).r(), InviteSuggestionsManager.access$getStoreUserRelationships$p(InviteSuggestionsManager.this).observe(list), new C02931(list));
        }
    }

    /* compiled from: InviteSuggestionsManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u000b \u0004*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\n2.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u000026\u0010\u0007\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u0006 \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0018\u00010\u00000\u00002\u000e\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "privateChannels", "Lcom/discord/primitives/MessageId;", "mostRecentMessages", "Lcom/discord/widgets/guilds/invite/InviteSuggestionsManager$UserAffinityData;", "affinityUserData", "", "Lcom/discord/widgets/guilds/invite/InviteSuggestion;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;Lcom/discord/widgets/guilds/invite/InviteSuggestionsManager$UserAffinityData;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.InviteSuggestionsManager$observeInviteSuggestions$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, T3, R> implements Func3<Map<Long, ? extends Channel>, Map<Long, ? extends Long>, UserAffinityData, List<? extends InviteSuggestion>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ List<? extends InviteSuggestion> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Long> map2, UserAffinityData userAffinityData) {
            return call2((Map<Long, Channel>) map, (Map<Long, Long>) map2, userAffinityData);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<InviteSuggestion> call2(Map<Long, Channel> map, Map<Long, Long> map2, UserAffinityData userAffinityData) {
            User userA;
            ArrayList arrayList = new ArrayList();
            Collection<Channel> collectionValues = map.values();
            Channel.Companion companion = Channel.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(map2, "mostRecentMessages");
            Intrinsics3.checkNotNullParameter(companion, "$this$getSortByMostRecent");
            Intrinsics3.checkNotNullParameter(map2, "mostRecentMessageIds");
            List listSortedWith = _Collections.sortedWith(collectionValues, new ChannelUtils3(map2));
            Channel channel = listSortedWith.isEmpty() ^ true ? (Channel) listSortedWith.get(0) : null;
            if (channel != null) {
                arrayList.add(new InviteSuggestion.ChannelItem(channel));
            }
            List<Long> userIds = userAffinityData.getUserIds();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = userIds.iterator();
            while (it.hasNext()) {
                User user = userAffinityData.getUsers().get(Long.valueOf(((Number) it.next()).longValue()));
                if (user != null) {
                    arrayList2.add(user);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                User user2 = (User) next;
                Integer num = (Integer) outline.f(user2, userAffinityData.getRelationships());
                if (!(!(channel == null || (userA = ChannelUtils.a(channel)) == null || userA.getId() != user2.getId()) || (num != null && num.intValue() == 2))) {
                    arrayList3.add(next);
                }
            }
            List listDistinct = _Collections.distinct(arrayList3);
            Iterator it3 = listDistinct.iterator();
            while (it3.hasNext()) {
                arrayList.add(new InviteSuggestion.UserSuggestion((User) it3.next()));
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj : listSortedWith) {
                Channel channel2 = (Channel) obj;
                if ((Intrinsics3.areEqual(channel, channel2) ^ true) && (ChannelUtils.a(channel2) == null || !_Collections.contains(listDistinct, ChannelUtils.a(channel2)))) {
                    arrayList4.add(obj);
                }
            }
            ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList4, 10));
            Iterator it4 = arrayList4.iterator();
            while (it4.hasNext()) {
                arrayList5.add(Boolean.valueOf(arrayList.add(new InviteSuggestion.ChannelItem((Channel) it4.next()))));
            }
            return arrayList;
        }
    }

    public InviteSuggestionsManager() {
        this(null, null, null, null, null, 31, null);
    }

    public InviteSuggestionsManager(StoreChannels storeChannels, StoreMessagesMostRecent storeMessagesMostRecent, StoreUserAffinities storeUserAffinities, StoreUser storeUser, StoreUserRelationships storeUserRelationships) {
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeMessagesMostRecent, "storeMessagesMostRecent");
        Intrinsics3.checkNotNullParameter(storeUserAffinities, "storeUserAffinities");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        this.storeChannels = storeChannels;
        this.storeMessagesMostRecent = storeMessagesMostRecent;
        this.storeUserAffinities = storeUserAffinities;
        this.storeUsers = storeUser;
        this.storeUserRelationships = storeUserRelationships;
    }

    public static final /* synthetic */ StoreUserRelationships access$getStoreUserRelationships$p(InviteSuggestionsManager inviteSuggestionsManager) {
        return inviteSuggestionsManager.storeUserRelationships;
    }

    public static final /* synthetic */ StoreUser access$getStoreUsers$p(InviteSuggestionsManager inviteSuggestionsManager) {
        return inviteSuggestionsManager.storeUsers;
    }

    public final Observable<List<InviteSuggestion>> observeInviteSuggestions() {
        Observable<List<InviteSuggestion>> observableI = Observable.i(this.storeChannels.observePrivateChannels(), this.storeMessagesMostRecent.observeRecentMessageIds().Z(1), this.storeUserAffinities.observeAffinityUserIds().Y(new AnonymousClass1()), AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest… inviteSuggestionList\n  }");
        return observableI;
    }

    public /* synthetic */ InviteSuggestionsManager(StoreChannels storeChannels, StoreMessagesMostRecent storeMessagesMostRecent, StoreUserAffinities storeUserAffinities, StoreUser storeUser, StoreUserRelationships storeUserRelationships, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 2) != 0 ? StoreStream.INSTANCE.getMessagesMostRecent() : storeMessagesMostRecent, (i & 4) != 0 ? StoreStream.INSTANCE.getUserAffinities() : storeUserAffinities, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getUserRelationships() : storeUserRelationships);
    }
}
