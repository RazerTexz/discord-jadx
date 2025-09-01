package com.discord.widgets.stage;

import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.permissions.PermissionUtils;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t._Maps;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J;\u0010\f\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\nj\u0002`\u000b0\t0\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ[\u0010\u0014\u001a\f\u0012\b\u0012\u00060\nj\u0002`\u000b0\t2&\u0010\u0011\u001a\"\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\nj\u0002`\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\u000e2\u001a\u0010\u0013\u001a\u0016\u0012\b\u0012\u00060\nj\u0002`\u000f\u0012\b\u0012\u00060\nj\u0002`\u00120\u000e¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/stage/GuildIdsWithVisibleStageInstanceModel;", "", "Lcom/discord/stores/StoreStageInstances;", "storeStageInstances", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lrx/Observable;", "", "", "Lcom/discord/primitives/GuildId;", "observe", "(Lcom/discord/stores/StoreStageInstances;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/updates/ObservationDeck;)Lrx/Observable;", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/stageinstance/StageInstance;", "instancesByGuild", "Lcom/discord/api/permission/PermissionBit;", "permissionsByChannel", "compute", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Set;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildIdsWithVisibleStageInstanceModel {
    public static final GuildIdsWithVisibleStageInstanceModel INSTANCE = new GuildIdsWithVisibleStageInstanceModel();

    /* compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010&\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072&\u0010\u0006\u001a\"\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/stageinstance/StageInstance;", "<name for destructuring parameter 0>", "", "invoke", "(Ljava/util/Map$Entry;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.GuildIdsWithVisibleStageInstanceModel$compute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>>, Boolean> {
        public final /* synthetic */ Map $permissionsByChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(1);
            this.$permissionsByChannel = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>> entry) {
            return Boolean.valueOf(invoke2((Map.Entry<Long, ? extends Map<Long, StageInstance>>) entry));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Map.Entry<Long, ? extends Map<Long, StageInstance>> entry) {
            int i;
            Intrinsics3.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
            entry.getKey().longValue();
            Set<Long> setKeySet = entry.getValue().keySet();
            if ((setKeySet instanceof Collection) && setKeySet.isEmpty()) {
                i = 0;
            } else {
                Iterator<T> it = setKeySet.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (PermissionUtils.can(Permission.VIEW_CHANNEL, (Long) this.$permissionsByChannel.get(Long.valueOf(((Number) it.next()).longValue()))) && (i = i + 1) < 0) {
                        Collections2.throwCountOverflow();
                    }
                }
            }
            return i > 0;
        }
    }

    /* compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010&\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00060\u0001j\u0002`\u00022&\u0010\u0006\u001a\"\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/stageinstance/StageInstance;", "entry", "invoke", "(Ljava/util/Map$Entry;)J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.GuildIdsWithVisibleStageInstanceModel$compute$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>>, Long> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Long invoke(Map.Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>> entry) {
            return Long.valueOf(invoke2((Map.Entry<Long, ? extends Map<Long, StageInstance>>) entry));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2(Map.Entry<Long, ? extends Map<Long, StageInstance>> entry) {
            Intrinsics3.checkNotNullParameter(entry, "entry");
            return entry.getKey().longValue();
        }
    }

    /* compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "invoke", "()Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.GuildIdsWithVisibleStageInstanceModel$observe$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public final /* synthetic */ StorePermissions $storePermissions;
        public final /* synthetic */ StoreStageInstances $storeStageInstances;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreStageInstances storeStageInstances, StorePermissions storePermissions) {
            super(0);
            this.$storeStageInstances = storeStageInstances;
            this.$storePermissions = storePermissions;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Long> invoke2() {
            return GuildIdsWithVisibleStageInstanceModel.INSTANCE.compute(this.$storeStageInstances.getStageInstancesByGuild(), this.$storePermissions.getPermissionsByChannel());
        }
    }

    private GuildIdsWithVisibleStageInstanceModel() {
    }

    public static /* synthetic */ Observable observe$default(GuildIdsWithVisibleStageInstanceModel guildIdsWithVisibleStageInstanceModel, StoreStageInstances storeStageInstances, StorePermissions storePermissions, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 1) != 0) {
            storeStageInstances = StoreStream.INSTANCE.getStageInstances();
        }
        if ((i & 2) != 0) {
            storePermissions = StoreStream.INSTANCE.getPermissions();
        }
        if ((i & 4) != 0) {
            observationDeck = ObservationDeck4.get();
        }
        return guildIdsWithVisibleStageInstanceModel.observe(storeStageInstances, storePermissions, observationDeck);
    }

    public final Set<Long> compute(Map<Long, ? extends Map<Long, StageInstance>> instancesByGuild, Map<Long, Long> permissionsByChannel) {
        Intrinsics3.checkNotNullParameter(instancesByGuild, "instancesByGuild");
        Intrinsics3.checkNotNullParameter(permissionsByChannel, "permissionsByChannel");
        return _Sequences2.toSet(_Sequences2.map(_Sequences2.filter(_Maps.asSequence(instancesByGuild), new AnonymousClass1(permissionsByChannel)), AnonymousClass2.INSTANCE));
    }

    public final Observable<Set<Long>> observe(StoreStageInstances storeStageInstances, StorePermissions storePermissions, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStageInstances, "storeStageInstances");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeStageInstances, storePermissions}, false, null, null, new AnonymousClass1(storeStageInstances, storePermissions), 14, null);
    }
}
