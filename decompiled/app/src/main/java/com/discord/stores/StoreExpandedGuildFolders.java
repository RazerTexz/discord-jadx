package com.discord.stores;

import android.content.Context;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.persister.Persister;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreExpandedGuildFolders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\f2\n\u0010\u000f\u001a\u00060\u0003j\u0002`\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\f2\n\u0010\u000f\u001a\u00060\u0003j\u0002`\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\fH\u0017¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\f2\n\u0010\u000f\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0015\u0010\u0011J\u0019\u0010\u0016\u001a\u00020\f2\n\u0010\u000f\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0016\u0010\u0011R \u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R&\u0010\u001b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010 \u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/discord/stores/StoreExpandedGuildFolders;", "Lcom/discord/stores/StoreV2;", "", "", "Lcom/discord/primitives/FolderId;", "getOpenFolderIds", "()Ljava/util/Set;", "Lrx/Observable;", "observeOpenFolderIds", "()Lrx/Observable;", "Landroid/content/Context;", "context", "", "init", "(Landroid/content/Context;)V", "folderId", "handleFolderOpened", "(J)V", "handleFolderClosed", "snapshotData", "()V", "openFolder", "closeFolder", "", "openFolderIds", "Ljava/util/Set;", "Lcom/discord/utilities/persister/Persister;", "openFolderIdsCache", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "openFolderIdsSnapshot", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreExpandedGuildFolders extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Set<Long> openFolderIds;
    private final Persister<Set<Long>> openFolderIdsCache;
    private Set<Long> openFolderIdsSnapshot;

    /* compiled from: StoreExpandedGuildFolders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreExpandedGuildFolders$closeFolder$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $folderId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$folderId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreExpandedGuildFolders.this.handleFolderClosed(this.$folderId);
        }
    }

    /* compiled from: StoreExpandedGuildFolders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lcom/discord/primitives/FolderId;", "invoke", "()Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreExpandedGuildFolders$observeOpenFolderIds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Long> invoke2() {
            return StoreExpandedGuildFolders.this.getOpenFolderIds();
        }
    }

    /* compiled from: StoreExpandedGuildFolders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreExpandedGuildFolders$openFolder$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $folderId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$folderId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreExpandedGuildFolders.this.handleFolderOpened(this.$folderId);
        }
    }

    public /* synthetic */ StoreExpandedGuildFolders(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public final void closeFolder(long folderId) {
        this.dispatcher.schedule(new AnonymousClass1(folderId));
    }

    public final Set<Long> getOpenFolderIds() {
        return this.openFolderIdsSnapshot;
    }

    @Store3
    public final void handleFolderClosed(long folderId) {
        this.openFolderIds.remove(Long.valueOf(folderId));
        markChanged();
    }

    @Store3
    public final void handleFolderOpened(long folderId) {
        this.openFolderIds.add(Long.valueOf(folderId));
        markChanged();
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.openFolderIds.addAll(this.openFolderIdsCache.get());
        markChanged();
    }

    public final Observable<Set<Long>> observeOpenFolderIds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final void openFolder(long folderId) {
        this.dispatcher.schedule(new AnonymousClass1(folderId));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        HashSet hashSet = new HashSet(this.openFolderIds);
        this.openFolderIdsSnapshot = hashSet;
        Persister.set$default(this.openFolderIdsCache, hashSet, false, 2, null);
    }

    public StoreExpandedGuildFolders(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.openFolderIdsSnapshot = Sets5.emptySet();
        this.openFolderIds = new HashSet();
        this.openFolderIdsCache = new Persister<>("CACHE_KEY_OPEN_FOLDERS", new HashSet());
    }
}
