package com.discord.stores;

import android.content.Context;
import com.discord.api.application.ApplicationAsset;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreApplicationAssets.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010%\u001a\u00020$\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b'\u0010(J)\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0003¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00060\u000b0\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\b2\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR&\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00060\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR.\u0010 \u001a\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001ej\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R&\u0010#\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00060\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/discord/stores/StoreApplicationAssets;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/ApplicationId;", "applicationId", "", "Lcom/discord/api/application/ApplicationAsset;", "appAssets", "", "handleApplicationAssets", "(JLjava/util/List;)V", "", "getEmbeddedAppBackgrounds", "()Ljava/util/Map;", "Lrx/Observable;", "observeEmbeddedAppBackgrounds", "()Lrx/Observable;", "appId", "fetchIfNonExisting", "(J)V", "snapshotData", "()V", "Lcom/discord/utilities/rest/RestAPI;", "restApi", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "embeddedAppBackgroundsSnapshot", "Ljava/util/Map;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "embeddedAppBackgroundsLoading", "Ljava/util/HashSet;", "", "embeddedAppBackgrounds", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/utilities/rest/RestAPI;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreApplicationAssets extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, ApplicationAsset> embeddedAppBackgrounds;
    private final HashSet<Long> embeddedAppBackgroundsLoading;
    private Map<Long, ApplicationAsset> embeddedAppBackgroundsSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restApi;

    /* compiled from: StoreApplicationAssets.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $appId;

        /* compiled from: StoreApplicationAssets.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/api/application/ApplicationAsset;", "applicationAssets", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00791 extends Lambda implements Function1<List<? extends ApplicationAsset>, Unit> {

            /* compiled from: StoreApplicationAssets.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00801 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $applicationAssets;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00801(List list) {
                    super(0);
                    this.$applicationAssets = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreApplicationAssets.access$getEmbeddedAppBackgroundsLoading$p(StoreApplicationAssets.this).remove(Long.valueOf(AnonymousClass1.this.$appId));
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreApplicationAssets.access$handleApplicationAssets(StoreApplicationAssets.this, anonymousClass1.$appId, this.$applicationAssets);
                }
            }

            public C00791() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ApplicationAsset> list) {
                invoke2((List<ApplicationAsset>) list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ApplicationAsset> list) {
                Intrinsics3.checkNotNullParameter(list, "applicationAssets");
                StoreApplicationAssets.access$getDispatcher$p(StoreApplicationAssets.this).schedule(new C00801(list));
            }
        }

        /* compiled from: StoreApplicationAssets.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreApplicationAssets.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C00811 extends Lambda implements Function0<Unit> {
                public C00811() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreApplicationAssets.access$getEmbeddedAppBackgroundsLoading$p(StoreApplicationAssets.this).remove(Long.valueOf(AnonymousClass1.this.$appId));
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreApplicationAssets.access$getDispatcher$p(StoreApplicationAssets.this).schedule(new C00811());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$appId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreApplicationAssets.access$getEmbeddedAppBackgrounds$p(StoreApplicationAssets.this).containsKey(Long.valueOf(this.$appId)) || StoreApplicationAssets.access$getEmbeddedAppBackgroundsLoading$p(StoreApplicationAssets.this).contains(Long.valueOf(this.$appId))) {
                return;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreApplicationAssets.access$getRestApi$p(StoreApplicationAssets.this).getApplicationAssets(this.$appId), false, 1, null), StoreApplicationAssets.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C00791(), 54, (Object) null);
        }
    }

    /* compiled from: StoreApplicationAssets.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ApplicationId;", "Lcom/discord/api/application/ApplicationAsset;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationAssets$observeEmbeddedAppBackgrounds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends ApplicationAsset>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends ApplicationAsset> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends ApplicationAsset> invoke2() {
            return StoreApplicationAssets.this.getEmbeddedAppBackgrounds();
        }
    }

    public /* synthetic */ StoreApplicationAssets(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreApplicationAssets storeApplicationAssets) {
        return storeApplicationAssets.dispatcher;
    }

    public static final /* synthetic */ Map access$getEmbeddedAppBackgrounds$p(StoreApplicationAssets storeApplicationAssets) {
        return storeApplicationAssets.embeddedAppBackgrounds;
    }

    public static final /* synthetic */ HashSet access$getEmbeddedAppBackgroundsLoading$p(StoreApplicationAssets storeApplicationAssets) {
        return storeApplicationAssets.embeddedAppBackgroundsLoading;
    }

    public static final /* synthetic */ RestAPI access$getRestApi$p(StoreApplicationAssets storeApplicationAssets) {
        return storeApplicationAssets.restApi;
    }

    public static final /* synthetic */ void access$handleApplicationAssets(StoreApplicationAssets storeApplicationAssets, long j, List list) {
        storeApplicationAssets.handleApplicationAssets(j, list);
    }

    @Store3
    private final void handleApplicationAssets(long applicationId, List<ApplicationAsset> appAssets) {
        Object next;
        Iterator<T> it = appAssets.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics3.areEqual(((ApplicationAsset) next).getName(), "embedded_background")) {
                    break;
                }
            }
        }
        ApplicationAsset applicationAsset = (ApplicationAsset) next;
        if (applicationAsset != null) {
            this.embeddedAppBackgrounds.put(Long.valueOf(applicationId), applicationAsset);
            markChanged();
        }
    }

    public final void fetchIfNonExisting(long appId) {
        this.dispatcher.schedule(new AnonymousClass1(appId));
    }

    public final Map<Long, ApplicationAsset> getEmbeddedAppBackgrounds() {
        return this.embeddedAppBackgroundsSnapshot;
    }

    public final Observable<Map<Long, ApplicationAsset>> observeEmbeddedAppBackgrounds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.embeddedAppBackgroundsSnapshot = new HashMap(this.embeddedAppBackgrounds);
    }

    public StoreApplicationAssets(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restApi = restAPI;
        this.embeddedAppBackgrounds = new LinkedHashMap();
        this.embeddedAppBackgroundsLoading = new HashSet<>();
        this.embeddedAppBackgroundsSnapshot = Maps6.emptyMap();
    }
}
