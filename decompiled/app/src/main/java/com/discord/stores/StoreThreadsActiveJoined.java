package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.thread.ThreadMemberUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreThreadsActiveJoined.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001FB!\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u00107\u001a\u000206\u0012\b\b\u0002\u0010@\u001a\u00020?¢\u0006\u0004\bD\u0010EJ!\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\t\u001a\u00060\u0002j\u0002`\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\r0\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\n\u0010\t\u001a\u00060\u0002j\u0002`\bH\u0001¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\r0\f0\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\u00120\f0\u0016¢\u0006\u0004\b\u0019\u0010\u0018J?\u0010\u001a\u001a(\u0012$\u0012\"\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\r0\f0\f0\u00162\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001c\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\u00120\f0\u00162\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ;\u0010\u001d\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\r0\f0\u00162\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\t\u001a\u00060\u0002j\u0002`\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b#\u0010$J\u001b\u0010%\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0012H\u0007¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0012H\u0007¢\u0006\u0004\b.\u0010-J\u0017\u00100\u001a\u00020\u00052\u0006\u0010(\u001a\u00020/H\u0007¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u00052\u0006\u0010(\u001a\u000202H\u0007¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0005H\u0017¢\u0006\u0004\b5\u0010 R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108RF\u00109\u001a2\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012$\u0012\"\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\r0\f0\f0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R&\u0010;\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010:R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR&\u0010C\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\r0B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010:¨\u0006G"}, d2 = {"Lcom/discord/stores/StoreThreadsActiveJoined;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "saveThreads", "(Ljava/lang/Long;)V", "Lcom/discord/primitives/ChannelId;", "channelId", "updateThread", "(JJ)V", "", "Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;", "getActiveJoinedThreadsInternal$app_productionGoogleRelease", "()Ljava/util/Map;", "getActiveJoinedThreadsInternal", "", "Lcom/discord/api/channel/Channel;", "getActiveJoinedThreadsForChannelInternal$app_productionGoogleRelease", "(J)Ljava/util/List;", "getActiveJoinedThreadsForChannelInternal", "Lrx/Observable;", "observeAllActiveJoinedThreadsById", "()Lrx/Observable;", "observeAllActiveJoinedThreadsChannelsById", "observeActiveJoinedThreadsForGuild", "(J)Lrx/Observable;", "observeActiveJoinedThreadsChannelsForGuild", "observeActiveJoinedThreadsForChannel", "(JJ)Lrx/Observable;", "handleConnectionOpen", "()V", "Lcom/discord/api/guild/Guild;", "guild", "handleGuildCreate", "(Lcom/discord/api/guild/Guild;)V", "handleGuildDelete", "(J)V", "Lcom/discord/models/thread/dto/ModelThreadListSync;", "payload", "handleThreadListSync", "(Lcom/discord/models/thread/dto/ModelThreadListSync;)V", "channel", "handleChannelCreateOrUpdate", "(Lcom/discord/api/channel/Channel;)V", "handleThreadCreateOrUpdateOrDelete", "Lcom/discord/api/thread/ThreadMemberUpdate;", "handleThreadMemberUpdate", "(Lcom/discord/api/thread/ThreadMemberUpdate;)V", "Lcom/discord/api/thread/ThreadMembersUpdate;", "handleThreadMembersUpdate", "(Lcom/discord/api/thread/ThreadMembersUpdate;)V", "snapshotData", "Lcom/discord/stores/StoreThreadsJoined;", "storeThreadsJoined", "Lcom/discord/stores/StoreThreadsJoined;", "activeJoinedThreadsHierarchicalSnapshot", "Ljava/util/Map;", "activeJoinedThreadsByThreadIdSnapshot", "Lcom/discord/stores/StoreThreadsActive;", "storeThreadsActive", "Lcom/discord/stores/StoreThreadsActive;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "", "activeJoinedThreads", "<init>", "(Lcom/discord/stores/StoreThreadsActive;Lcom/discord/stores/StoreThreadsJoined;Lcom/discord/stores/updates/ObservationDeck;)V", "ActiveJoinedThread", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreThreadsActiveJoined extends StoreV2 {
    private final Map<Long, ActiveJoinedThread> activeJoinedThreads;
    private Map<Long, ActiveJoinedThread> activeJoinedThreadsByThreadIdSnapshot;
    private Map<Long, ? extends Map<Long, ? extends Map<Long, ActiveJoinedThread>>> activeJoinedThreadsHierarchicalSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreThreadsActive storeThreadsActive;
    private final StoreThreadsJoined storeThreadsJoined;

    /* compiled from: StoreThreadsActiveJoined.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\n¨\u0006!"}, d2 = {"Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/api/utcdatetime/UtcDateTime;", "component2", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "", "component3", "()Z", "channel", "joinTimestamp", "muted", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/utcdatetime/UtcDateTime;Z)Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/api/utcdatetime/UtcDateTime;", "getJoinTimestamp", "Z", "getMuted", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/utcdatetime/UtcDateTime;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ActiveJoinedThread {
        private final Channel channel;
        private final UtcDateTime joinTimestamp;
        private final boolean muted;

        public ActiveJoinedThread(Channel channel, UtcDateTime utcDateTime, boolean z2) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(utcDateTime, "joinTimestamp");
            this.channel = channel;
            this.joinTimestamp = utcDateTime;
            this.muted = z2;
        }

        public static /* synthetic */ ActiveJoinedThread copy$default(ActiveJoinedThread activeJoinedThread, Channel channel, UtcDateTime utcDateTime, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = activeJoinedThread.channel;
            }
            if ((i & 2) != 0) {
                utcDateTime = activeJoinedThread.joinTimestamp;
            }
            if ((i & 4) != 0) {
                z2 = activeJoinedThread.muted;
            }
            return activeJoinedThread.copy(channel, utcDateTime, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final UtcDateTime getJoinTimestamp() {
            return this.joinTimestamp;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getMuted() {
            return this.muted;
        }

        public final ActiveJoinedThread copy(Channel channel, UtcDateTime joinTimestamp, boolean muted) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(joinTimestamp, "joinTimestamp");
            return new ActiveJoinedThread(channel, joinTimestamp, muted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActiveJoinedThread)) {
                return false;
            }
            ActiveJoinedThread activeJoinedThread = (ActiveJoinedThread) other;
            return Intrinsics3.areEqual(this.channel, activeJoinedThread.channel) && Intrinsics3.areEqual(this.joinTimestamp, activeJoinedThread.joinTimestamp) && this.muted == activeJoinedThread.muted;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final UtcDateTime getJoinTimestamp() {
            return this.joinTimestamp;
        }

        public final boolean getMuted() {
            return this.muted;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            UtcDateTime utcDateTime = this.joinTimestamp;
            int iHashCode2 = (iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
            boolean z2 = this.muted;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ActiveJoinedThread(channel=");
            sbU.append(this.channel);
            sbU.append(", joinTimestamp=");
            sbU.append(this.joinTimestamp);
            sbU.append(", muted=");
            return outline.O(sbU, this.muted, ")");
        }
    }

    /* compiled from: StoreThreadsActiveJoined.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreThreadsActiveJoined$observeActiveJoinedThreadsChannelsForGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Channel>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Channel> invoke2() {
            Collection<Map> collectionValues;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map map = (Map) StoreThreadsActiveJoined.access$getActiveJoinedThreadsHierarchicalSnapshot$p(StoreThreadsActiveJoined.this).get(Long.valueOf(this.$guildId));
            if (map != null && (collectionValues = map.values()) != null) {
                for (Map map2 : collectionValues) {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(map2.size()));
                    for (Map.Entry entry : map2.entrySet()) {
                        linkedHashMap2.put(entry.getKey(), ((ActiveJoinedThread) entry.getValue()).getChannel());
                    }
                    linkedHashMap.putAll(linkedHashMap2);
                }
            }
            return Maps6.toMap(linkedHashMap);
        }
    }

    /* compiled from: StoreThreadsActiveJoined.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreThreadsActiveJoined$observeActiveJoinedThreadsForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends ActiveJoinedThread>> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends ActiveJoinedThread> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends ActiveJoinedThread> invoke2() {
            Map<Long, ? extends ActiveJoinedThread> map;
            Map map2 = (Map) StoreThreadsActiveJoined.access$getActiveJoinedThreadsHierarchicalSnapshot$p(StoreThreadsActiveJoined.this).get(Long.valueOf(this.$guildId));
            return (map2 == null || (map = (Map) map2.get(Long.valueOf(this.$channelId))) == null) ? Maps6.emptyMap() : map;
        }
    }

    /* compiled from: StoreThreadsActiveJoined.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\"\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreThreadsActiveJoined$observeActiveJoinedThreadsForGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Map<Long, ? extends ActiveJoinedThread>>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends ActiveJoinedThread>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Map<Long, ? extends ActiveJoinedThread>> invoke2() {
            Map<Long, ? extends Map<Long, ? extends ActiveJoinedThread>> map = (Map) StoreThreadsActiveJoined.access$getActiveJoinedThreadsHierarchicalSnapshot$p(StoreThreadsActiveJoined.this).get(Long.valueOf(this.$guildId));
            return map != null ? map : Maps6.emptyMap();
        }
    }

    /* compiled from: StoreThreadsActiveJoined.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreThreadsActiveJoined$observeAllActiveJoinedThreadsById$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends ActiveJoinedThread>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends ActiveJoinedThread> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends ActiveJoinedThread> invoke2() {
            return StoreThreadsActiveJoined.access$getActiveJoinedThreadsByThreadIdSnapshot$p(StoreThreadsActiveJoined.this);
        }
    }

    /* compiled from: StoreThreadsActiveJoined.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreThreadsActiveJoined$observeAllActiveJoinedThreadsChannelsById$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Channel>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Channel> invoke2() {
            Map mapAccess$getActiveJoinedThreadsByThreadIdSnapshot$p = StoreThreadsActiveJoined.access$getActiveJoinedThreadsByThreadIdSnapshot$p(StoreThreadsActiveJoined.this);
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(mapAccess$getActiveJoinedThreadsByThreadIdSnapshot$p.size()));
            for (Map.Entry entry : mapAccess$getActiveJoinedThreadsByThreadIdSnapshot$p.entrySet()) {
                linkedHashMap.put(entry.getKey(), ((ActiveJoinedThread) entry.getValue()).getChannel());
            }
            return linkedHashMap;
        }
    }

    public /* synthetic */ StoreThreadsActiveJoined(StoreThreadsActive storeThreadsActive, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeThreadsActive, storeThreadsJoined, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ Map access$getActiveJoinedThreadsByThreadIdSnapshot$p(StoreThreadsActiveJoined storeThreadsActiveJoined) {
        return storeThreadsActiveJoined.activeJoinedThreadsByThreadIdSnapshot;
    }

    public static final /* synthetic */ Map access$getActiveJoinedThreadsHierarchicalSnapshot$p(StoreThreadsActiveJoined storeThreadsActiveJoined) {
        return storeThreadsActiveJoined.activeJoinedThreadsHierarchicalSnapshot;
    }

    public static final /* synthetic */ void access$setActiveJoinedThreadsByThreadIdSnapshot$p(StoreThreadsActiveJoined storeThreadsActiveJoined, Map map) {
        storeThreadsActiveJoined.activeJoinedThreadsByThreadIdSnapshot = map;
    }

    public static final /* synthetic */ void access$setActiveJoinedThreadsHierarchicalSnapshot$p(StoreThreadsActiveJoined storeThreadsActiveJoined, Map map) {
        storeThreadsActiveJoined.activeJoinedThreadsHierarchicalSnapshot = map;
    }

    @Store3
    private final void saveThreads(Long guildId) {
        Channel channel;
        Map<Long, Map<Long, Channel>> allActiveThreadsInternal$app_productionGoogleRelease = this.storeThreadsActive.getAllActiveThreadsInternal$app_productionGoogleRelease();
        for (StoreThreadsJoined.JoinedThread joinedThread : this.storeThreadsJoined.getAllJoinedThreadsInternal$app_productionGoogleRelease().values()) {
            if (guildId == null || joinedThread.getGuildId() == guildId.longValue()) {
                Map<Long, Channel> map = allActiveThreadsInternal$app_productionGoogleRelease.get(Long.valueOf(joinedThread.getGuildId()));
                if (map != null && (channel = map.get(Long.valueOf(joinedThread.getThreadId()))) != null) {
                    this.activeJoinedThreads.put(Long.valueOf(channel.getId()), new ActiveJoinedThread(channel, joinedThread.getJoinTimestamp(), joinedThread.getMuted()));
                    markChanged();
                }
            }
        }
    }

    public static /* synthetic */ void saveThreads$default(StoreThreadsActiveJoined storeThreadsActiveJoined, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        storeThreadsActiveJoined.saveThreads(l);
    }

    @Store3
    private final void updateThread(long guildId, long channelId) {
        Map<Long, Channel> map = this.storeThreadsActive.getAllActiveThreadsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        Channel channel = map != null ? map.get(Long.valueOf(channelId)) : null;
        StoreThreadsJoined.JoinedThread joinedThread = this.storeThreadsJoined.getAllJoinedThreadsInternal$app_productionGoogleRelease().get(Long.valueOf(channelId));
        if (channel != null && joinedThread != null) {
            this.activeJoinedThreads.put(Long.valueOf(channelId), new ActiveJoinedThread(channel, joinedThread.getJoinTimestamp(), joinedThread.getMuted()));
            markChanged();
        } else if (this.activeJoinedThreads.containsKey(Long.valueOf(channelId))) {
            this.activeJoinedThreads.remove(Long.valueOf(channelId));
            markChanged();
        }
    }

    @Store3
    public final List<Channel> getActiveJoinedThreadsForChannelInternal$app_productionGoogleRelease(long channelId) {
        Collection<ActiveJoinedThread> collectionValues = this.activeJoinedThreads.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((ActiveJoinedThread) obj).getChannel().getParentId() == channelId) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ActiveJoinedThread) it.next()).getChannel());
        }
        return arrayList2;
    }

    @Store3
    public final Map<Long, ActiveJoinedThread> getActiveJoinedThreadsInternal$app_productionGoogleRelease() {
        return this.activeJoinedThreads;
    }

    @Store3
    public final void handleChannelCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        for (Channel channel2 : getActiveJoinedThreadsForChannelInternal$app_productionGoogleRelease(channel.getId())) {
            updateThread(channel2.getGuildId(), channel2.getId());
        }
    }

    @Store3
    public final void handleConnectionOpen() {
        this.activeJoinedThreads.clear();
        saveThreads$default(this, null, 1, null);
        markChanged();
    }

    @Store3
    public final void handleGuildCreate(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        saveThreads(Long.valueOf(guild.getId()));
    }

    @Store3
    public final void handleGuildDelete(long guildId) {
        Iterator<ActiveJoinedThread> it = this.activeJoinedThreads.values().iterator();
        while (it.hasNext()) {
            if (it.next().getChannel().getGuildId() == guildId) {
                it.remove();
                markChanged();
            }
        }
    }

    @Store3
    public final void handleThreadCreateOrUpdateOrDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        updateThread(channel.getGuildId(), channel.getId());
    }

    @Store3
    public final void handleThreadListSync(ModelThreadListSync payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        handleGuildDelete(payload.getGuildId());
        saveThreads(Long.valueOf(payload.getGuildId()));
    }

    @Store3
    public final void handleThreadMemberUpdate(ThreadMemberUpdate payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        updateThread(payload.getGuildId(), payload.getId());
    }

    @Store3
    public final void handleThreadMembersUpdate(ThreadMembersUpdate payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        updateThread(payload.getGuildId(), payload.getId());
    }

    public final Observable<Map<Long, Channel>> observeActiveJoinedThreadsChannelsForGuild(long guildId) {
        Observable<Map<Long, Channel>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, ActiveJoinedThread>> observeActiveJoinedThreadsForChannel(long guildId, long channelId) {
        Observable<Map<Long, ActiveJoinedThread>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId, channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Map<Long, ActiveJoinedThread>>> observeActiveJoinedThreadsForGuild(long guildId) {
        Observable<Map<Long, Map<Long, ActiveJoinedThread>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, ActiveJoinedThread>> observeAllActiveJoinedThreadsById() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Map<Long, Channel>> observeAllActiveJoinedThreadsChannelsById() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.activeJoinedThreadsByThreadIdSnapshot = new HashMap(this.activeJoinedThreads);
        Collection<ActiveJoinedThread> collectionValues = this.activeJoinedThreads.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : collectionValues) {
            Long lValueOf = Long.valueOf(((ActiveJoinedThread) obj).getChannel().getGuildId());
            Object arrayList = linkedHashMap.get(lValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(lValueOf, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            List list = (List) entry.getValue();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Object obj2 : list) {
                Long lValueOf2 = Long.valueOf(((ActiveJoinedThread) obj2).getChannel().getParentId());
                Object arrayList2 = linkedHashMap3.get(lValueOf2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap3.put(lValueOf2, arrayList2);
                }
                ((List) arrayList2).add(obj2);
            }
            LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsJVM.mapCapacity(linkedHashMap3.size()));
            for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
                Object key2 = entry2.getKey();
                List list2 = (List) entry2.getValue();
                LinkedHashMap linkedHashMap5 = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(list2, 10)), 16));
                for (Object obj3 : list2) {
                    linkedHashMap5.put(Long.valueOf(((ActiveJoinedThread) obj3).getChannel().getId()), obj3);
                }
                linkedHashMap4.put(key2, linkedHashMap5);
            }
            linkedHashMap2.put(key, linkedHashMap4);
        }
        this.activeJoinedThreadsHierarchicalSnapshot = linkedHashMap2;
    }

    public StoreThreadsActiveJoined(StoreThreadsActive storeThreadsActive, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        Intrinsics3.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeThreadsActive = storeThreadsActive;
        this.storeThreadsJoined = storeThreadsJoined;
        this.observationDeck = observationDeck;
        this.activeJoinedThreads = new HashMap();
        this.activeJoinedThreadsByThreadIdSnapshot = new HashMap();
        this.activeJoinedThreadsHierarchicalSnapshot = new HashMap();
    }
}
