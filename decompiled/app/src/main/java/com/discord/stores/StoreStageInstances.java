package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreStageInstances.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u00101\u001a\u000200¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\n\u0010\u000b\u001a\u00060\u0007j\u0002`\nH\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e2\n\u0010\u000b\u001a\u00060\u0007j\u0002`\n¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\u0010\u000b\u001a\u00060\u0007j\u0002`\n¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\u0010\u000b\u001a\u00060\u0007j\u0002`\n¢\u0006\u0004\b\u0013\u0010\u0012J\u001d\u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0017\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u00020\u00140\u000e2\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\u0017\u0010\u0010J#\u0010\u0018\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u00020\u00140\u000e¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001a\u001a\"\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u00020\u00140\u0014¢\u0006\u0004\b\u001a\u0010\u0016J)\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u00020\u00142\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u00020\u00142\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0007¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b&\u0010%J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b+\u0010\u0006J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b,\u0010\u0006J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b-\u0010\u0006J\u000f\u0010.\u001a\u00020\u0004H\u0017¢\u0006\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R&\u00104\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R6\u00106\u001a\"\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u000203038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00105R6\u00107\u001a\"\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u00020\u00140\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R&\u00108\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00105¨\u0006;"}, d2 = {"Lcom/discord/stores/StoreStageInstances;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/api/stageinstance/StageInstance;", "stageInstance", "", "handleStageInstanceCreateOrUpdate", "(Lcom/discord/api/stageinstance/StageInstance;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "handleDelete", "(Ljava/lang/Long;J)V", "Lrx/Observable;", "observeStageInstanceForChannel", "(J)Lrx/Observable;", "getStageInstanceForChannelInternal", "(J)Lcom/discord/api/stageinstance/StageInstance;", "getStageInstanceForChannel", "", "getStageInstances", "()Ljava/util/Map;", "observeStageInstancesForGuild", "observeStageInstances", "()Lrx/Observable;", "getStageInstancesByGuild", "getStageInstancesForGuild", "(J)Ljava/util/Map;", "getStageInstancesForGuildInternal", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/api/guild/Guild;", "guild", "handleGuildAdd", "(Lcom/discord/api/guild/Guild;)V", "handleGuildRemove", "Lcom/discord/api/channel/Channel;", "channel", "handleChannelDelete", "(Lcom/discord/api/channel/Channel;)V", "handleStageInstanceCreate", "handleStageInstanceUpdate", "handleStageInstanceDelete", "snapshotData", "()V", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "", "stageInstancesByChannel", "Ljava/util/Map;", "stageInstancesByGuild", "stageInstancesByGuildSnapshot", "stageInstancesByChannelSnapshot", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreStageInstances extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final Map<Long, StageInstance> stageInstancesByChannel;
    private Map<Long, StageInstance> stageInstancesByChannelSnapshot;
    private final Map<Long, Map<Long, StageInstance>> stageInstancesByGuild;
    private Map<Long, ? extends Map<Long, StageInstance>> stageInstancesByGuildSnapshot;

    /* compiled from: StoreStageInstances.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/stageinstance/StageInstance;", "invoke", "()Lcom/discord/api/stageinstance/StageInstance;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStageInstances$observeStageInstanceForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<StageInstance> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ StageInstance invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StageInstance invoke() {
            return StoreStageInstances.this.getStageInstanceForChannel(this.$channelId);
        }
    }

    /* compiled from: StoreStageInstances.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/stageinstance/StageInstance;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStageInstances$observeStageInstances$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends StageInstance>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends StageInstance> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends StageInstance> invoke2() {
            return StoreStageInstances.this.getStageInstances();
        }
    }

    /* compiled from: StoreStageInstances.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/stageinstance/StageInstance;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStageInstances$observeStageInstancesForGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends StageInstance>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends StageInstance> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends StageInstance> invoke2() {
            return StoreStageInstances.this.getStageInstancesForGuild(this.$guildId);
        }
    }

    public StoreStageInstances() {
        this(null, 1, null);
    }

    public /* synthetic */ StoreStageInstances(ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    private final void handleDelete(Long guildId, long channelId) {
        this.stageInstancesByChannel.remove(Long.valueOf(channelId));
        Map<Long, StageInstance> map = this.stageInstancesByGuild.get(guildId);
        if (map != null) {
            map.remove(Long.valueOf(channelId));
        }
        markChanged();
    }

    private final void handleStageInstanceCreateOrUpdate(StageInstance stageInstance) {
        this.stageInstancesByChannel.put(Long.valueOf(stageInstance.getChannelId()), stageInstance);
        Map<Long, Map<Long, StageInstance>> map = this.stageInstancesByGuild;
        Long lValueOf = Long.valueOf(stageInstance.getGuildId());
        Map<Long, StageInstance> linkedHashMap = map.get(lValueOf);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
            map.put(lValueOf, linkedHashMap);
        }
        linkedHashMap.put(Long.valueOf(stageInstance.getChannelId()), stageInstance);
        markChanged();
    }

    public final StageInstance getStageInstanceForChannel(long channelId) {
        return this.stageInstancesByChannelSnapshot.get(Long.valueOf(channelId));
    }

    public final StageInstance getStageInstanceForChannelInternal(long channelId) {
        return this.stageInstancesByChannel.get(Long.valueOf(channelId));
    }

    public final Map<Long, StageInstance> getStageInstances() {
        return this.stageInstancesByChannelSnapshot;
    }

    public final Map<Long, Map<Long, StageInstance>> getStageInstancesByGuild() {
        return this.stageInstancesByGuildSnapshot;
    }

    public final Map<Long, StageInstance> getStageInstancesForGuild(long guildId) {
        Map<Long, StageInstance> map = this.stageInstancesByGuildSnapshot.get(Long.valueOf(guildId));
        return map != null ? map : Maps6.emptyMap();
    }

    @Store3
    public final Map<Long, StageInstance> getStageInstancesForGuildInternal(long guildId) {
        Map<Long, StageInstance> map = this.stageInstancesByGuild.get(Long.valueOf(guildId));
        return map != null ? map : Maps6.emptyMap();
    }

    @Store3
    public final void handleChannelDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        handleDelete(Long.valueOf(channel.getGuildId()), channel.getId());
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.stageInstancesByGuild.clear();
        this.stageInstancesByChannel.clear();
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            Intrinsics3.checkNotNullExpressionValue(guild, "it");
            handleGuildAdd(guild);
        }
    }

    @Store3
    public final void handleGuildAdd(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        List<StageInstance> listJ = guild.J();
        if (listJ != null) {
            Iterator<T> it = listJ.iterator();
            while (it.hasNext()) {
                handleStageInstanceCreateOrUpdate((StageInstance) it.next());
            }
        }
    }

    @Store3
    public final void handleGuildRemove(Guild guild) {
        Set<Long> setEmptySet;
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Map<Long, StageInstance> mapRemove = this.stageInstancesByGuild.remove(Long.valueOf(guild.getId()));
        if (mapRemove == null || (setEmptySet = mapRemove.keySet()) == null) {
            setEmptySet = Sets5.emptySet();
        }
        if (setEmptySet.isEmpty()) {
            return;
        }
        this.stageInstancesByChannel.keySet().removeAll(setEmptySet);
        markChanged();
    }

    @Store3
    public final void handleStageInstanceCreate(StageInstance stageInstance) {
        Intrinsics3.checkNotNullParameter(stageInstance, "stageInstance");
        handleStageInstanceCreateOrUpdate(stageInstance);
    }

    @Store3
    public final void handleStageInstanceDelete(StageInstance stageInstance) {
        Intrinsics3.checkNotNullParameter(stageInstance, "stageInstance");
        handleDelete(Long.valueOf(stageInstance.getGuildId()), stageInstance.getChannelId());
    }

    @Store3
    public final void handleStageInstanceUpdate(StageInstance stageInstance) {
        Intrinsics3.checkNotNullParameter(stageInstance, "stageInstance");
        handleStageInstanceCreateOrUpdate(stageInstance);
    }

    public final Observable<StageInstance> observeStageInstanceForChannel(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null);
    }

    public final Observable<Map<Long, StageInstance>> observeStageInstances() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Map<Long, StageInstance>> observeStageInstancesForGuild(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.stageInstancesByChannelSnapshot = new HashMap(this.stageInstancesByChannel);
        HashMap map = new HashMap();
        for (Map.Entry<Long, Map<Long, StageInstance>> entry : this.stageInstancesByGuild.entrySet()) {
            map.put(entry.getKey(), new HashMap(entry.getValue()));
        }
        this.stageInstancesByGuildSnapshot = map;
    }

    public StoreStageInstances(ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.stageInstancesByChannel = new LinkedHashMap();
        this.stageInstancesByChannelSnapshot = new HashMap();
        this.stageInstancesByGuild = new LinkedHashMap();
        this.stageInstancesByGuildSnapshot = new HashMap();
    }
}
