package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadMember;
import com.discord.api.thread.ThreadMemberUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelPayload;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.search.network.state.SearchState;
import d0.t.Maps6;
import d0.t.MutableCollections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreThreadsJoined.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0002EFB\u0019\u0012\u0006\u0010=\u001a\u00020<\u0012\b\b\u0002\u0010:\u001a\u000209¢\u0006\u0004\bC\u0010DJ\u001f\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\n2\n\u0010\u000e\u001a\u00060\u0003j\u0002`\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0019\u0010\u0015\u001a\u00020\u00142\n\u0010\u0013\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\u0010\u0013\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u00142\n\u0010\u0013\u001a\u00060\u0003j\u0002`\u0004H\u0007¢\u0006\u0004\b\u0019\u0010\u0016J!\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001a2\n\u0010\u0013\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001d\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010\fJ\u001b\u0010$\u001a\u00020\n2\n\u0010\u000e\u001a\u00060\u0003j\u0002`\rH\u0007¢\u0006\u0004\b$\u0010\u0010J\u0017\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\n2\u0006\u0010 \u001a\u00020)H\u0007¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b,\u0010(J\u0017\u0010.\u001a\u00020\n2\u0006\u0010 \u001a\u00020-H\u0007¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\n2\u0006\u0010 \u001a\u000200H\u0007¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\n2\u0006\u00104\u001a\u000203H\u0007¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\nH\u0017¢\u0006\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R&\u0010@\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR&\u0010B\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010A¨\u0006G"}, d2 = {"Lcom/discord/stores/StoreThreadsJoined;", "Lcom/discord/stores/StoreV2;", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "getAllJoinedThreads", "()Ljava/util/Map;", "Lcom/discord/api/guild/Guild;", "guild", "", "saveThreads", "(Lcom/discord/api/guild/Guild;)V", "Lcom/discord/primitives/GuildId;", "guildId", "deleteThreads", "(J)V", "getAllJoinedThreadsInternal$app_productionGoogleRelease", "getAllJoinedThreadsInternal", "threadId", "", "hasJoined", "(J)Z", "getJoinedThread", "(J)Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "hasJoinedInternal", "Lrx/Observable;", "observeJoinedThread", "(J)Lrx/Observable;", "observeJoinedThreads", "()Lrx/Observable;", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "handleGuildCreate", "handleGuildDelete", "Lcom/discord/api/channel/Channel;", "channel", "handleThreadCreateOrUpdate", "(Lcom/discord/api/channel/Channel;)V", "Lcom/discord/models/thread/dto/ModelThreadListSync;", "handleThreadListSync", "(Lcom/discord/models/thread/dto/ModelThreadListSync;)V", "handleThreadDelete", "Lcom/discord/api/thread/ThreadMemberUpdate;", "handleThreadMemberUpdate", "(Lcom/discord/api/thread/ThreadMemberUpdate;)V", "Lcom/discord/api/thread/ThreadMembersUpdate;", "handleThreadMembersUpdate", "(Lcom/discord/api/thread/ThreadMembersUpdate;)V", "Lcom/discord/utilities/search/network/state/SearchState;", "searchState", "handleSearchFinish", "(Lcom/discord/utilities/search/network/state/SearchState;)V", "snapshotData", "()V", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "", "joinedThreads", "Ljava/util/Map;", "joinedThreadsSnapshot", "<init>", "(Lcom/discord/stores/StoreUser;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "JoinedThread", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreThreadsJoined extends StoreV2 {
    public static final int ALL_FLAGS = 15;
    public static final int NOTIFICATION_FLAGS = 14;
    private final Map<Long, JoinedThread> joinedThreads;
    private Map<Long, JoinedThread> joinedThreadsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreUser storeUser;

    /* compiled from: StoreThreadsJoined.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\u0010\u0014\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0015\u001a\u00060\u0002j\u0002`\u0006\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0011¢\u0006\u0004\b.\u0010/J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013JT\u0010\u001a\u001a\u00020\u00002\f\b\u0002\u0010\u0014\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u0015\u001a\u00060\u0002j\u0002`\u00062\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001f\u0010\nJ\u001a\u0010!\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0019\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010#\u001a\u0004\b$\u0010\u0013R\u0019\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b&\u0010\u0010R\u001d\u0010\u0014\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\u0005R\u001d\u0010\u0015\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b)\u0010\u0005R\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010\nR\u0019\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010\r¨\u00060"}, d2 = {"Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "Lcom/discord/primitives/GuildId;", "component2", "", "component3", "()I", "", "component4", "()Z", "Lcom/discord/models/domain/ModelMuteConfig;", "component5", "()Lcom/discord/models/domain/ModelMuteConfig;", "Lcom/discord/api/utcdatetime/UtcDateTime;", "component6", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "threadId", "guildId", "flags", "muted", "muteConfig", "joinTimestamp", "copy", "(JJIZLcom/discord/models/domain/ModelMuteConfig;Lcom/discord/api/utcdatetime/UtcDateTime;)Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/utcdatetime/UtcDateTime;", "getJoinTimestamp", "Lcom/discord/models/domain/ModelMuteConfig;", "getMuteConfig", "J", "getThreadId", "getGuildId", "I", "getFlags", "Z", "getMuted", "<init>", "(JJIZLcom/discord/models/domain/ModelMuteConfig;Lcom/discord/api/utcdatetime/UtcDateTime;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class JoinedThread {
        private final int flags;
        private final long guildId;
        private final UtcDateTime joinTimestamp;
        private final ModelMuteConfig muteConfig;
        private final boolean muted;
        private final long threadId;

        public JoinedThread(long j, long j2, int i, boolean z2, ModelMuteConfig modelMuteConfig, UtcDateTime utcDateTime) {
            Intrinsics3.checkNotNullParameter(modelMuteConfig, "muteConfig");
            Intrinsics3.checkNotNullParameter(utcDateTime, "joinTimestamp");
            this.threadId = j;
            this.guildId = j2;
            this.flags = i;
            this.muted = z2;
            this.muteConfig = modelMuteConfig;
            this.joinTimestamp = utcDateTime;
        }

        public static /* synthetic */ JoinedThread copy$default(JoinedThread joinedThread, long j, long j2, int i, boolean z2, ModelMuteConfig modelMuteConfig, UtcDateTime utcDateTime, int i2, Object obj) {
            return joinedThread.copy((i2 & 1) != 0 ? joinedThread.threadId : j, (i2 & 2) != 0 ? joinedThread.guildId : j2, (i2 & 4) != 0 ? joinedThread.flags : i, (i2 & 8) != 0 ? joinedThread.muted : z2, (i2 & 16) != 0 ? joinedThread.muteConfig : modelMuteConfig, (i2 & 32) != 0 ? joinedThread.joinTimestamp : utcDateTime);
        }

        /* renamed from: component1, reason: from getter */
        public final long getThreadId() {
            return this.threadId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component3, reason: from getter */
        public final int getFlags() {
            return this.flags;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getMuted() {
            return this.muted;
        }

        /* renamed from: component5, reason: from getter */
        public final ModelMuteConfig getMuteConfig() {
            return this.muteConfig;
        }

        /* renamed from: component6, reason: from getter */
        public final UtcDateTime getJoinTimestamp() {
            return this.joinTimestamp;
        }

        public final JoinedThread copy(long threadId, long guildId, int flags, boolean muted, ModelMuteConfig muteConfig, UtcDateTime joinTimestamp) {
            Intrinsics3.checkNotNullParameter(muteConfig, "muteConfig");
            Intrinsics3.checkNotNullParameter(joinTimestamp, "joinTimestamp");
            return new JoinedThread(threadId, guildId, flags, muted, muteConfig, joinTimestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof JoinedThread)) {
                return false;
            }
            JoinedThread joinedThread = (JoinedThread) other;
            return this.threadId == joinedThread.threadId && this.guildId == joinedThread.guildId && this.flags == joinedThread.flags && this.muted == joinedThread.muted && Intrinsics3.areEqual(this.muteConfig, joinedThread.muteConfig) && Intrinsics3.areEqual(this.joinTimestamp, joinedThread.joinTimestamp);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final UtcDateTime getJoinTimestamp() {
            return this.joinTimestamp;
        }

        public final ModelMuteConfig getMuteConfig() {
            return this.muteConfig;
        }

        public final boolean getMuted() {
            return this.muted;
        }

        public final long getThreadId() {
            return this.threadId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = (((b.a(this.guildId) + (b.a(this.threadId) * 31)) * 31) + this.flags) * 31;
            boolean z2 = this.muted;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iA + i) * 31;
            ModelMuteConfig modelMuteConfig = this.muteConfig;
            int iHashCode = (i2 + (modelMuteConfig != null ? modelMuteConfig.hashCode() : 0)) * 31;
            UtcDateTime utcDateTime = this.joinTimestamp;
            return iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("JoinedThread(threadId=");
            sbU.append(this.threadId);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", flags=");
            sbU.append(this.flags);
            sbU.append(", muted=");
            sbU.append(this.muted);
            sbU.append(", muteConfig=");
            sbU.append(this.muteConfig);
            sbU.append(", joinTimestamp=");
            sbU.append(this.joinTimestamp);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreThreadsJoined.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "invoke", "()Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreThreadsJoined$observeJoinedThread$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<JoinedThread> {
        public final /* synthetic */ long $threadId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$threadId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ JoinedThread invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final JoinedThread invoke() {
            return StoreThreadsJoined.this.getJoinedThread(this.$threadId);
        }
    }

    /* compiled from: StoreThreadsJoined.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreThreadsJoined$observeJoinedThreads$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends JoinedThread>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends JoinedThread> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends JoinedThread> invoke2() {
            return StoreThreadsJoined.access$getAllJoinedThreads(StoreThreadsJoined.this);
        }
    }

    public /* synthetic */ StoreThreadsJoined(StoreUser storeUser, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeUser, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ Map access$getAllJoinedThreads(StoreThreadsJoined storeThreadsJoined) {
        return storeThreadsJoined.getAllJoinedThreads();
    }

    private final void deleteThreads(long guildId) {
        if (MutableCollections.removeAll(this.joinedThreads.values(), new StoreThreadsJoined2(guildId))) {
            markChanged();
        }
    }

    private final Map<Long, JoinedThread> getAllJoinedThreads() {
        return this.joinedThreadsSnapshot;
    }

    private final void saveThreads(Guild guild) {
        ThreadMember member;
        List<Channel> listN = guild.N();
        if (listN != null) {
            for (Channel channel : listN) {
                if (ChannelUtils.H(channel) && (member = channel.getMember()) != null) {
                    this.joinedThreads.put(Long.valueOf(channel.getId()), new JoinedThread(channel.getId(), guild.getId(), member.getFlags(), member.getMuted(), new ModelMuteConfig(member.getMuteConfig()), member.getJoinTimestamp()));
                    markChanged();
                }
            }
        }
    }

    @Store3
    public final Map<Long, JoinedThread> getAllJoinedThreadsInternal$app_productionGoogleRelease() {
        return this.joinedThreads;
    }

    public final JoinedThread getJoinedThread(long threadId) {
        return this.joinedThreadsSnapshot.get(Long.valueOf(threadId));
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.joinedThreads.clear();
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            Intrinsics3.checkNotNullExpressionValue(guild, "guild");
            saveThreads(guild);
        }
        markChanged();
    }

    @Store3
    public final void handleGuildCreate(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        deleteThreads(guild.getId());
        saveThreads(guild);
    }

    @Store3
    public final void handleGuildDelete(long guildId) {
        deleteThreads(guildId);
    }

    @Store3
    public final void handleSearchFinish(SearchState searchState) {
        Channel channel;
        Intrinsics3.checkNotNullParameter(searchState, "searchState");
        List<Channel> threads = searchState.getThreads();
        if (threads == null || (channel = threads.get(0)) == null) {
            return;
        }
        long guildId = channel.getGuildId();
        List<ThreadMember> threadMembers = searchState.getThreadMembers();
        if (threadMembers != null) {
            for (ThreadMember threadMember : threadMembers) {
                if (threadMember.getUserId() == this.storeUser.getMeSnapshot().getId()) {
                    this.joinedThreads.put(Long.valueOf(threadMember.getId()), new JoinedThread(threadMember.getId(), guildId, threadMember.getFlags(), threadMember.getMuted(), new ModelMuteConfig(threadMember.getMuteConfig()), threadMember.getJoinTimestamp()));
                }
            }
        }
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        ThreadMember member = channel.getMember();
        if (member == null || member.getUserId() != this.storeUser.getMeSnapshot().getId()) {
            return;
        }
        this.joinedThreads.put(Long.valueOf(channel.getId()), new JoinedThread(channel.getId(), channel.getGuildId(), member.getFlags(), member.getMuted(), new ModelMuteConfig(member.getMuteConfig()), member.getJoinTimestamp()));
        markChanged();
    }

    @Store3
    public final void handleThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (this.joinedThreads.containsKey(Long.valueOf(channel.getId()))) {
            this.joinedThreads.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    @Store3
    public final void handleThreadListSync(ModelThreadListSync payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<ThreadMember> members = payload.getMembers();
        if (members != null) {
            for (ThreadMember threadMember : members) {
                this.joinedThreads.put(Long.valueOf(threadMember.getId()), new JoinedThread(threadMember.getId(), payload.getGuildId(), threadMember.getFlags(), threadMember.getMuted(), new ModelMuteConfig(threadMember.getMuteConfig()), threadMember.getJoinTimestamp()));
                markChanged();
            }
        }
    }

    @Store3
    public final void handleThreadMemberUpdate(ThreadMemberUpdate payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        if (payload.getUserId() == this.storeUser.getMeSnapshot().getId()) {
            this.joinedThreads.put(Long.valueOf(payload.getId()), new JoinedThread(payload.getId(), payload.getGuildId(), payload.getFlags(), payload.getMuted(), new ModelMuteConfig(payload.getMuteConfig()), payload.getJoinTimestamp()));
            markChanged();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Store3
    public final void handleThreadMembersUpdate(ThreadMembersUpdate payload) {
        List<Long> listD;
        Intrinsics3.checkNotNullParameter(payload, "payload");
        long id2 = this.storeUser.getMeSnapshot().getId();
        if (this.joinedThreads.containsKey(Long.valueOf(payload.getId())) && (listD = payload.d()) != null && listD.contains(Long.valueOf(id2))) {
            this.joinedThreads.remove(Long.valueOf(payload.getId()));
            markChanged();
        }
        List<AugmentedThreadMember> listA = payload.a();
        AugmentedThreadMember augmentedThreadMember = null;
        if (listA != null) {
            Iterator<T> it = listA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((AugmentedThreadMember) next).getUserId() == id2) {
                    augmentedThreadMember = next;
                    break;
                }
            }
            augmentedThreadMember = augmentedThreadMember;
        }
        if (augmentedThreadMember != null) {
            this.joinedThreads.put(Long.valueOf(payload.getId()), new JoinedThread(payload.getId(), payload.getGuildId(), augmentedThreadMember.getFlags(), augmentedThreadMember.getMuted(), new ModelMuteConfig(augmentedThreadMember.getMuteConfig()), augmentedThreadMember.getJoinTimestamp()));
            markChanged();
        }
    }

    public final boolean hasJoined(long threadId) {
        return this.joinedThreadsSnapshot.containsKey(Long.valueOf(threadId));
    }

    @Store3
    public final boolean hasJoinedInternal(long threadId) {
        return this.joinedThreads.containsKey(Long.valueOf(threadId));
    }

    public final Observable<JoinedThread> observeJoinedThread(long threadId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(threadId), 14, null);
    }

    public final Observable<Map<Long, JoinedThread>> observeJoinedThreads() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.joinedThreadsSnapshot = new HashMap(this.joinedThreads);
    }

    public StoreThreadsJoined(StoreUser storeUser, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeUser = storeUser;
        this.observationDeck = observationDeck;
        this.joinedThreads = new HashMap();
        this.joinedThreadsSnapshot = Maps6.emptyMap();
    }
}
