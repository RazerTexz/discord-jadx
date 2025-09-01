package com.discord.stores;

import android.content.Context;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.collections.LeastRecentlyAddedSet;
import com.discord.utilities.persister.Persister;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreGuildSelected.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\u00020\u0001:\u0001?B1\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00104\u001a\u000203\u0012\b\b\u0002\u0010.\u001a\u00020-¢\u0006\u0004\b=\u0010>J\u0011\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\b0\u000b¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b¢\u0006\u0004\b\u0010\u0010\rJ\u0019\u0010\u0013\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b$\u0010\u0014J\u000f\u0010%\u001a\u00020\u0012H\u0017¢\u0006\u0004\b%\u0010#R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R&\u0010+\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030*0)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R \u00106\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R \u0010;\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lcom/discord/stores/StoreGuildSelected;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/GuildId;", "getSelectedGuildId", "()J", "getSelectedGuildIdInternal$app_productionGoogleRelease", "getSelectedGuildIdInternal", "", "getRecentlySelectedGuildIds", "()Ljava/util/List;", "Lrx/Observable;", "observeSelectedGuildId", "()Lrx/Observable;", "observeRecentSelectedGuildIds", "Lcom/discord/models/guild/Guild;", "observeSelectedGuild", "guildId", "", "set", "(J)V", "dispatchSampleGuildIdSelected", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/api/guild/Guild;", "guild", "handleGuildRemove", "(Lcom/discord/api/guild/Guild;)V", "handlePreLogout", "()V", "handleGuildSelected", "snapshotData", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/utilities/collections/LeastRecentlyAddedSet;", "selectedGuildIdsCache", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreGuilds;", "guildStore", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StoreAnalytics;", "analyticsStore", "Lcom/discord/stores/StoreAnalytics;", "selectedGuildIds", "Lcom/discord/utilities/collections/LeastRecentlyAddedSet;", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "selectedGuildIdsSnapshot", "Ljava/util/List;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreAnalytics;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildSelected extends StoreV2 {
    private static final int MAX_SAVED_GUILD_IDS = 5;
    public static final long UNSELECTED = 0;
    private final StoreAnalytics analyticsStore;
    private final Dispatcher dispatcher;
    private final StoreGuilds guildStore;
    private final ObservationDeck observationDeck;
    private final LeastRecentlyAddedSet<Long> selectedGuildIds;
    private final Persister<LeastRecentlyAddedSet<Long>> selectedGuildIdsCache;
    private List<Long> selectedGuildIdsSnapshot;
    private final StoreStream stream;

    /* compiled from: StoreGuildSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildSelected$dispatchSampleGuildIdSelected$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSelected.access$getStream$p(StoreGuildSelected.this).handleSamplePremiumGuildSelected(this.$guildId);
        }
    }

    /* compiled from: StoreGuildSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "guildId", "", "invoke", "(J)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildSelected$handleConnectionOpen$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Boolean> {
        public final /* synthetic */ ModelPayload $payload;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelPayload modelPayload) {
            super(1);
            this.$payload = modelPayload;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
            return Boolean.valueOf(invoke(l.longValue()));
        }

        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean invoke(long j) {
            boolean z2;
            if (j != 0) {
                List<Guild> guilds = this.$payload.getGuilds();
                Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
                if ((guilds instanceof Collection) && guilds.isEmpty()) {
                    z2 = false;
                    if (z2) {
                    }
                } else {
                    Iterator<T> it = guilds.iterator();
                    while (it.hasNext()) {
                        if (j == ((Guild) it.next()).getId()) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    if (z2) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: StoreGuildSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildSelected$observeRecentSelectedGuildIds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends Long> invoke2() {
            return StoreGuildSelected.this.getRecentlySelectedGuildIds();
        }
    }

    /* compiled from: StoreGuildSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/models/guild/Guild;", "invoke", "()Lcom/discord/models/guild/Guild;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildSelected$observeSelectedGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<com.discord.models.guild.Guild> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ com.discord.models.guild.Guild invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.discord.models.guild.Guild invoke() {
            return StoreGuildSelected.access$getGuildStore$p(StoreGuildSelected.this).getGuilds().get(Long.valueOf(StoreGuildSelected.this.getSelectedGuildId()));
        }
    }

    /* compiled from: StoreGuildSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "invoke", "()J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildSelected$observeSelectedGuildId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Long> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return StoreGuildSelected.this.getSelectedGuildId();
        }
    }

    /* compiled from: StoreGuildSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildSelected$set$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSelected.access$getStream$p(StoreGuildSelected.this).handleGuildSelected(this.$guildId);
        }
    }

    public /* synthetic */ StoreGuildSelected(StoreStream storeStream, Dispatcher dispatcher, StoreGuilds storeGuilds, StoreAnalytics storeAnalytics, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, storeGuilds, storeAnalytics, (i & 16) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ StoreGuilds access$getGuildStore$p(StoreGuildSelected storeGuildSelected) {
        return storeGuildSelected.guildStore;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreGuildSelected storeGuildSelected) {
        return storeGuildSelected.stream;
    }

    public final void dispatchSampleGuildIdSelected(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final List<Long> getRecentlySelectedGuildIds() {
        return this.selectedGuildIdsSnapshot;
    }

    public final long getSelectedGuildId() {
        Long l = (Long) _Collections.firstOrNull((List) this.selectedGuildIdsSnapshot);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @Store3
    public final long getSelectedGuildIdInternal$app_productionGoogleRelease() {
        Long l = (Long) _Collections.lastOrNull(this.selectedGuildIds);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        MutableCollections.removeAll(this.selectedGuildIds, new AnonymousClass1(payload));
        markChanged();
    }

    @Store3
    public final void handleGuildRemove(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        if (this.selectedGuildIds.remove(Long.valueOf(guild.getId()))) {
            markChanged();
        }
    }

    @Store3
    public final void handleGuildSelected(long guildId) {
        this.selectedGuildIds.add(Long.valueOf(guildId));
        markChanged();
    }

    @Store3
    public final void handlePreLogout() {
        this.selectedGuildIds.clear();
        markChanged();
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.selectedGuildIds.clear();
        this.selectedGuildIds.addAll(this.selectedGuildIdsCache.get());
        markChanged();
    }

    public final Observable<List<Long>> observeRecentSelectedGuildIds() {
        Observable<List<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<com.discord.models.guild.Guild> observeSelectedGuild() {
        Observable<com.discord.models.guild.Guild> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.guildStore}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Long> observeSelectedGuildId() {
        Observable<Long> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void set(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        if (this.selectedGuildIds.isEmpty()) {
            this.selectedGuildIds.add(0L);
        }
        this.analyticsStore.trackGuildViewed(((Number) _Collections.last(this.selectedGuildIds)).longValue());
        Set<Long> lurkingGuildIdsSync = this.stream.getLurking().getLurkingGuildIdsSync();
        LeastRecentlyAddedSet<Long> leastRecentlyAddedSet = new LeastRecentlyAddedSet<>(0, null, 3, null);
        LeastRecentlyAddedSet<Long> leastRecentlyAddedSet2 = this.selectedGuildIds;
        ArrayList arrayList = new ArrayList();
        for (Long l : leastRecentlyAddedSet2) {
            if (true ^ lurkingGuildIdsSync.contains(Long.valueOf(l.longValue()))) {
                arrayList.add(l);
            }
        }
        leastRecentlyAddedSet.addAll(arrayList);
        this.selectedGuildIdsCache.set(leastRecentlyAddedSet, true);
        this.selectedGuildIdsSnapshot = _Collections.reversed(this.selectedGuildIds);
    }

    public StoreGuildSelected(StoreStream storeStream, Dispatcher dispatcher, StoreGuilds storeGuilds, StoreAnalytics storeAnalytics, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildStore");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "analyticsStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.guildStore = storeGuilds;
        this.analyticsStore = storeAnalytics;
        this.observationDeck = observationDeck;
        LeastRecentlyAddedSet<Long> leastRecentlyAddedSet = new LeastRecentlyAddedSet<>(5, null, 2, null);
        this.selectedGuildIds = leastRecentlyAddedSet;
        this.selectedGuildIdsSnapshot = new ArrayList();
        this.selectedGuildIdsCache = new Persister<>("STORE_GUILD_SELECTED_V5", leastRecentlyAddedSet);
    }
}
