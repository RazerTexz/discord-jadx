package com.discord.stores;

import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.guild.Guild;
import com.discord.api.presence.ClientStatus;
import com.discord.api.presence.Presence;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadListMember;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.models.domain.ModelPayload;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import d0.t.Collections2;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StoreGameParty.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\bG\u0010HJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\r\u001a\u00020\u00052\n\u0010\n\u001a\u00060\bj\u0002`\t2\n\u0010\f\u001a\u00060\bj\u0002`\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u0012\u001a\u00020\u00052\n\u0010\n\u001a\u00060\bj\u0002`\t2\n\u0010\f\u001a\u00060\bj\u0002`\u000b2\u000e\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010H\u0003¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\n\u0010\f\u001a\u00060\bj\u0002`\u000bH\u0003¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u001a\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u00190\u00180\u00172\u000e\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b\"\u0010#J%\u0010$\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\f\b\u0002\u0010\f\u001a\u00060\bj\u0002`\u000bH\u0007¢\u0006\u0004\b$\u0010\u0016J\u001d\u0010%\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b%\u0010\u0007J\u0017\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*H\u0007¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0005H\u0017¢\u0006\u0004\b.\u0010/R\u0019\u00101\u001a\u0002008\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0019\u00106\u001a\u0002058\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109Rj\u0010>\u001aV\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u001c\u0012\u001a\u0012\b\u0012\u00060\bj\u0002`\t0;j\f\u0012\b\u0012\u00060\bj\u0002`\t`<0:j*\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u001c\u0012\u001a\u0012\b\u0012\u00060\bj\u0002`\t0;j\f\u0012\b\u0012\u00060\bj\u0002`\t`<`=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0092\u0001\u0010@\u001a~\u0012\b\u0012\u00060\bj\u0002`\t\u00120\u0012.\u0012\b\u0012\u00060\bj\u0002`\u000b\u0012\b\u0012\u00060\u000fj\u0002`\u00100:j\u0016\u0012\b\u0012\u00060\bj\u0002`\u000b\u0012\b\u0012\u00060\u000fj\u0002`\u0010`=0:j>\u0012\b\u0012\u00060\bj\u0002`\t\u00120\u0012.\u0012\b\u0012\u00060\bj\u0002`\u000b\u0012\b\u0012\u00060\u000fj\u0002`\u00100:j\u0016\u0012\b\u0012\u00060\bj\u0002`\u000b\u0012\b\u0012\u00060\u000fj\u0002`\u0010`=`=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010?R\u0019\u0010B\u001a\u00020A8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ERj\u0010F\u001aV\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u001c\u0012\u001a\u0012\b\u0012\u00060\bj\u0002`\t0;j\f\u0012\b\u0012\u00060\bj\u0002`\t`<0:j*\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u001c\u0012\u001a\u0012\b\u0012\u00060\bj\u0002`\t0;j\f\u0012\b\u0012\u00060\bj\u0002`\t`<`=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010?¨\u0006I"}, d2 = {"Lcom/discord/stores/StoreGameParty;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/api/presence/Presence;", "presences", "", "handlePresences", "(Ljava/util/List;)V", "", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/primitives/GuildId;", "guildId", "removeUserFromParty", "(JJ)V", "", "Lcom/discord/primitives/ActivityPartyId;", "partyId", "addUserToParty", "(JJLjava/lang/String;)V", "presence", "updateParty", "(Lcom/discord/api/presence/Presence;J)V", "Lrx/Observable;", "", "Lcom/discord/models/user/User;", "observeUsersForPartyId", "(Ljava/lang/String;)Lrx/Observable;", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/api/guild/Guild;", "guild", "handleGuildCreateOrSync", "(Lcom/discord/api/guild/Guild;)V", "handlePresenceUpdate", "handlePresenceReplace", "Lcom/discord/api/thread/ThreadMemberListUpdate;", "threadMemberListUpdate", "handleThreadMemberListUpdate", "(Lcom/discord/api/thread/ThreadMemberListUpdate;)V", "Lcom/discord/api/thread/ThreadMembersUpdate;", "threadMembersUpdate", "handleThreadMembersUpdate", "(Lcom/discord/api/thread/ThreadMembersUpdate;)V", "snapshotData", "()V", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "getObservationDeck", "()Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "getStoreUser", "()Lcom/discord/stores/StoreUser;", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "parties", "Ljava/util/HashMap;", "userParties", "Lcom/discord/stores/StoreUserPresence;", "storeUserPresence", "Lcom/discord/stores/StoreUserPresence;", "getStoreUserPresence", "()Lcom/discord/stores/StoreUserPresence;", "partiesSnapshot", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreUserPresence;Lcom/discord/stores/StoreUser;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGameParty extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final HashMap<String, HashSet<Long>> parties;
    private HashMap<String, HashSet<Long>> partiesSnapshot;
    private final StoreUser storeUser;
    private final StoreUserPresence storeUserPresence;
    private final HashMap<Long, HashMap<Long, String>> userParties;

    /* compiled from: StoreGameParty.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGameParty$observeUsersForPartyId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends User>> {
        public final /* synthetic */ String $partyId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$partyId = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends User> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends User> invoke2() {
            List listEmptyList;
            HashSet hashSet = (HashSet) StoreGameParty.access$getPartiesSnapshot$p(StoreGameParty.this).get(this.$partyId);
            StoreUser storeUser = StoreGameParty.this.getStoreUser();
            if (hashSet == null || (listEmptyList = _Collections.toList(hashSet)) == null) {
                listEmptyList = Collections2.emptyList();
            }
            SortedMap sortedMap = MapsJVM.toSortedMap(storeUser.getUsers(listEmptyList, false));
            Objects.requireNonNull(sortedMap, "null cannot be cast to non-null type kotlin.collections.Map<com.discord.primitives.UserId /* = kotlin.Long */, com.discord.models.user.User>");
            return sortedMap;
        }
    }

    public StoreGameParty(ObservationDeck observationDeck, StoreUserPresence storeUserPresence, StoreUser storeUser) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeUserPresence, "storeUserPresence");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        this.observationDeck = observationDeck;
        this.storeUserPresence = storeUserPresence;
        this.storeUser = storeUser;
        this.userParties = new HashMap<>();
        this.parties = new HashMap<>();
        this.partiesSnapshot = new HashMap<>();
    }

    public static final /* synthetic */ HashMap access$getPartiesSnapshot$p(StoreGameParty storeGameParty) {
        return storeGameParty.partiesSnapshot;
    }

    public static final /* synthetic */ void access$setPartiesSnapshot$p(StoreGameParty storeGameParty, HashMap map) {
        storeGameParty.partiesSnapshot = map;
    }

    @Store3
    private final void addUserToParty(long userId, long guildId, String partyId) {
        if (partyId != null) {
            if (guildId > 0) {
                HashMap<Long, HashMap<Long, String>> map = this.userParties;
                Long lValueOf = Long.valueOf(userId);
                HashMap<Long, String> map2 = map.get(lValueOf);
                if (map2 == null) {
                    map2 = new HashMap<>();
                    map.put(lValueOf, map2);
                }
                map2.put(Long.valueOf(guildId), partyId);
            }
            HashSet<Long> hashSet = this.parties.get(partyId);
            HashSet<Long> hashSet2 = hashSet != null ? new HashSet<>(hashSet) : new HashSet<>();
            hashSet2.add(Long.valueOf(userId));
            this.parties.put(partyId, hashSet2);
            markChanged();
        }
    }

    public static /* synthetic */ void handlePresenceUpdate$default(StoreGameParty storeGameParty, Presence presence, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            Long guildId = presence.getGuildId();
            j = guildId != null ? guildId.longValue() : 0L;
        }
        storeGameParty.handlePresenceUpdate(presence, j);
    }

    @Store3
    private final void handlePresences(List<Presence> presences) {
        for (Presence presence : presences) {
            Long guildId = presence.getGuildId();
            updateParty(presence, guildId != null ? guildId.longValue() : 0L);
        }
    }

    @Store3
    private final void removeUserFromParty(long userId, long guildId) {
        String strRemove;
        HashMap<Long, String> map = this.userParties.get(Long.valueOf(userId));
        if (map == null || (strRemove = map.remove(Long.valueOf(guildId))) == null) {
            return;
        }
        Intrinsics3.checkNotNullExpressionValue(strRemove, "userParties[userId]?.remove(guildId) ?: return");
        HashSet<Long> hashSet = this.parties.get(strRemove);
        if (hashSet != null) {
            if (hashSet.size() != 1) {
                HashMap<String, HashSet<Long>> map2 = this.parties;
                HashSet<Long> hashSet2 = new HashSet<>(hashSet);
                hashSet2.remove(Long.valueOf(userId));
                map2.put(strRemove, hashSet2);
            } else {
                this.parties.remove(strRemove);
            }
        }
        markChanged();
    }

    @Store3
    private final void updateParty(Presence presence, long guildId) {
        List<Activity> listEmptyList;
        boolean z2;
        Object next;
        ActivityParty party;
        com.discord.api.user.User user = presence.getUser();
        if (user != null) {
            HashMap<Long, String> map = this.userParties.get(Long.valueOf(user.getId()));
            String id2 = null;
            String str = map != null ? map.get(Long.valueOf(guildId)) : null;
            Map<Long, com.discord.models.presence.Presence> mapM19getPresences = this.storeUserPresence.m19getPresences();
            com.discord.api.user.User user2 = presence.getUser();
            com.discord.models.presence.Presence presence2 = mapM19getPresences.get(user2 != null ? Long.valueOf(user2.getId()) : null);
            if (presence2 == null || (listEmptyList = presence2.getActivities()) == null) {
                listEmptyList = Collections2.emptyList();
            }
            Iterator<T> it = listEmptyList.iterator();
            while (true) {
                z2 = false;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                ActivityParty party2 = ((Activity) next).getParty();
                if ((party2 != null ? party2.getId() : null) != null) {
                    break;
                }
            }
            Activity activity = (Activity) next;
            if (activity != null && (party = activity.getParty()) != null) {
                id2 = party.getId();
            }
            String str2 = id2;
            if (str2 != null && presence.getStatus() != ClientStatus.OFFLINE) {
                z2 = true;
            }
            if (!z2) {
                removeUserFromParty(user.getId(), guildId);
                return;
            }
            if (!Intrinsics3.areEqual(str, str2)) {
                removeUserFromParty(user.getId(), guildId);
            }
            addUserToParty(user.getId(), guildId, str2);
        }
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    public final StoreUser getStoreUser() {
        return this.storeUser;
    }

    public final StoreUserPresence getStoreUserPresence() {
        return this.storeUserPresence;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<Presence> presences = payload.getPresences();
        if (presences != null) {
            handlePresences(presences);
        }
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        Iterator<T> it = guilds.iterator();
        while (it.hasNext()) {
            handleGuildCreateOrSync((Guild) it.next());
        }
    }

    @Store3
    public final void handleGuildCreateOrSync(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        List<Presence> listD = guild.D();
        if (listD != null) {
            handlePresences(listD);
        }
    }

    @Store3
    public final void handlePresenceReplace(List<Presence> presences) {
        Intrinsics3.checkNotNullParameter(presences, "presences");
        handlePresences(presences);
    }

    @Store3
    public final void handlePresenceUpdate(Presence presence) {
        handlePresenceUpdate$default(this, presence, 0L, 2, null);
    }

    @Store3
    public final void handlePresenceUpdate(Presence presence, long guildId) {
        Intrinsics3.checkNotNullParameter(presence, "presence");
        updateParty(presence, guildId);
    }

    @Store3
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        Intrinsics3.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        List<ThreadListMember> listB = threadMemberListUpdate.b();
        if (listB != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                Presence presence = ((ThreadListMember) it.next()).getPresence();
                if (presence != null) {
                    arrayList.add(presence);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                updateParty((Presence) it2.next(), threadMemberListUpdate.getGuildId());
            }
        }
    }

    @Store3
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        Intrinsics3.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        List<AugmentedThreadMember> listA = threadMembersUpdate.a();
        if (listA != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                Presence presence = ((AugmentedThreadMember) it.next()).getPresence();
                if (presence != null) {
                    arrayList.add(presence);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                updateParty((Presence) it2.next(), threadMembersUpdate.getGuildId());
            }
        }
    }

    public final Observable<Map<Long, User>> observeUsersForPartyId(String partyId) {
        Observable<Map<Long, User>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, StoreUser.INSTANCE.getUsersUpdate()}, false, null, null, new AnonymousClass1(partyId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.partiesSnapshot = new HashMap<>();
        for (Map.Entry<String, HashSet<Long>> entry : this.parties.entrySet()) {
            this.partiesSnapshot.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }
    }
}
