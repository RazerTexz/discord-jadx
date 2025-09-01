package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadListMember;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.user.User;
import com.discord.stores.updates.ObservationDeck;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StoreThreadMembers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b)\u0010*J)\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\nH\u0017¢\u0006\u0004\b\u001a\u0010\fR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dRN\u0010 \u001a:\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u00060\u001ej\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u0006`\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R0\u0010'\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070&0%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/discord/stores/StoreThreadMembers;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lrx/Observable;", "", "Lcom/discord/primitives/UserId;", "observeThreadMembers", "(J)Lrx/Observable;", "", "handleConnectionOpen", "()V", "Lcom/discord/api/thread/ThreadMembersUpdate;", "threadMembersUpdate", "handleThreadMembersUpdate", "(Lcom/discord/api/thread/ThreadMembersUpdate;)V", "Lcom/discord/api/thread/ThreadMemberListUpdate;", "threadMemberListUpdate", "handleThreadMemberListUpdate", "(Lcom/discord/api/thread/ThreadMemberListUpdate;)V", "Lcom/discord/api/channel/Channel;", "channel", "handleThreadCreateOrUpdate", "(Lcom/discord/api/channel/Channel;)V", "handleThreadDelete", "snapshotData", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "memberListsSnapshot", "Ljava/util/HashMap;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "", "", "memberLists", "Ljava/util/Map;", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreChannels;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreThreadMembers extends StoreV2 {
    private final Map<Long, Set<Long>> memberLists;
    private HashMap<Long, Set<Long>> memberListsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;

    /* compiled from: StoreThreadMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "invoke", "()Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreThreadMembers$observeThreadMembers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Long> invoke2() {
            Set<? extends Long> set = (Set) StoreThreadMembers.access$getMemberListsSnapshot$p(StoreThreadMembers.this).get(Long.valueOf(this.$channelId));
            return set != null ? set : Sets5.emptySet();
        }
    }

    public StoreThreadMembers(ObservationDeck observationDeck, StoreChannels storeChannels) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        this.observationDeck = observationDeck;
        this.storeChannels = storeChannels;
        this.memberLists = new LinkedHashMap();
        this.memberListsSnapshot = new HashMap<>();
    }

    public static final /* synthetic */ HashMap access$getMemberListsSnapshot$p(StoreThreadMembers storeThreadMembers) {
        return storeThreadMembers.memberListsSnapshot;
    }

    public static final /* synthetic */ void access$setMemberListsSnapshot$p(StoreThreadMembers storeThreadMembers, HashMap map) {
        storeThreadMembers.memberListsSnapshot = map;
    }

    @Store3
    public final void handleConnectionOpen() {
        this.memberLists.clear();
        markChanged();
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        ThreadMetadata threadMetadata;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (this.memberLists.containsKey(Long.valueOf(channel.getId())) && (threadMetadata = channel.getThreadMetadata()) != null && threadMetadata.getArchived()) {
            this.memberLists.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    @Store3
    public final void handleThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (this.memberLists.containsKey(Long.valueOf(channel.getId()))) {
            this.memberLists.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    @Store3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        Set<Long> linkedHashSet;
        Intrinsics3.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        Channel channelInternal$app_productionGoogleRelease = this.storeChannels.getChannelInternal$app_productionGoogleRelease(threadMemberListUpdate.getGuildId(), threadMemberListUpdate.getThreadId());
        if ((channelInternal$app_productionGoogleRelease != null ? Long.valueOf(channelInternal$app_productionGoogleRelease.getParentId()) : null) != null) {
            Map<Long, Set<Long>> map = this.memberLists;
            Long lValueOf = Long.valueOf(channelInternal$app_productionGoogleRelease.getId());
            List<ThreadListMember> listB = threadMemberListUpdate.b();
            if (listB != null) {
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listB, 10));
                Iterator<T> it = listB.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((ThreadListMember) it.next()).getUserId()));
                }
                linkedHashSet = _Collections.toMutableSet(arrayList);
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet<>();
                }
            }
            map.put(lValueOf, linkedHashSet);
            markChanged();
        }
    }

    @Store3
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        User user;
        Intrinsics3.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        if (this.memberLists.containsKey(Long.valueOf(threadMembersUpdate.getId()))) {
            List<AugmentedThreadMember> listA = threadMembersUpdate.a();
            if (listA != null) {
                Iterator<T> it = listA.iterator();
                while (it.hasNext()) {
                    GuildMember member = ((AugmentedThreadMember) it.next()).getMember();
                    Long lValueOf = (member == null || (user = member.getUser()) == null) ? null : Long.valueOf(user.getId());
                    if (lValueOf != null) {
                        Set<Long> set = this.memberLists.get(Long.valueOf(threadMembersUpdate.getId()));
                        if (set != null) {
                            set.add(lValueOf);
                        }
                        markChanged();
                    }
                }
            }
            List<Long> listD = threadMembersUpdate.d();
            if (listD != null) {
                Iterator<T> it2 = listD.iterator();
                while (it2.hasNext()) {
                    long jLongValue = ((Number) it2.next()).longValue();
                    Set<Long> set2 = this.memberLists.get(Long.valueOf(threadMembersUpdate.getId()));
                    if (set2 != null) {
                        set2.remove(Long.valueOf(jLongValue));
                    }
                    markChanged();
                }
            }
        }
    }

    public final Observable<Set<Long>> observeThreadMembers(long channelId) {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        Map<Long, Set<Long>> map = this.memberLists;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), _Collections.toSet((Iterable) entry.getValue()));
        }
        this.memberListsSnapshot = new HashMap<>(linkedHashMap);
    }
}
