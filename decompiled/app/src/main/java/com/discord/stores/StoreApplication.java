package com.discord.stores;

import android.content.Context;
import com.discord.api.application.Application;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
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
import rx.Observable;

/* compiled from: StoreApplication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\"\u0010#J%\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00060\u000b0\u00052\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\t¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R:\u0010\u001b\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00060\u0019j\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0006`\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR.\u0010\u001f\u001a\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001dj\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R:\u0010!\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00060\u0019j\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0006`\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001c¨\u0006$"}, d2 = {"Lcom/discord/stores/StoreApplication;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/ApplicationId;", "appId", "Lrx/Observable;", "Lcom/discord/api/application/Application;", "observeApplication", "(Ljava/lang/Long;)Lrx/Observable;", "", "applicationIds", "", "observeApplications", "(Ljava/util/Collection;)Lrx/Observable;", "", "fetchIfNonexisting", "(J)V", "snapshotData", "()V", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "applications", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "applicationsLoading", "Ljava/util/HashSet;", "applicationsSnapshot", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreApplication extends StoreV2 {
    private final HashMap<Long, Application> applications;
    private final HashSet<Long> applicationsLoading;
    private HashMap<Long, Application> applicationsSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreApplication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $appId;

        /* compiled from: StoreApplication.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/api/application/Application;", "results", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00761 extends Lambda implements Function1<List<? extends Application>, Unit> {

            /* compiled from: StoreApplication.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00771 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $results;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00771(List list) {
                    super(0);
                    this.$results = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Object next;
                    StoreApplication.access$getApplicationsLoading$p(StoreApplication.this).remove(Long.valueOf(AnonymousClass1.this.$appId));
                    Iterator it = this.$results.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it.next();
                            if (((Application) next).getId() == AnonymousClass1.this.$appId) {
                                break;
                            }
                        }
                    }
                    Application application = (Application) next;
                    if (application != null) {
                        StoreApplication.access$getApplications$p(StoreApplication.this).put(Long.valueOf(AnonymousClass1.this.$appId), application);
                        StoreApplication.this.markChanged();
                    }
                }
            }

            public C00761() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Application> list) {
                invoke2((List<Application>) list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Application> list) {
                Intrinsics3.checkNotNullParameter(list, "results");
                StoreApplication.access$getDispatcher$p(StoreApplication.this).schedule(new C00771(list));
            }
        }

        /* compiled from: StoreApplication.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreApplication.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C00781 extends Lambda implements Function0<Unit> {
                public C00781() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreApplication.access$getApplicationsLoading$p(StoreApplication.this).remove(Long.valueOf(AnonymousClass1.this.$appId));
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
                StoreApplication.access$getDispatcher$p(StoreApplication.this).schedule(new C00781());
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
            if (StoreApplication.access$getApplications$p(StoreApplication.this).containsKey(Long.valueOf(this.$appId)) || StoreApplication.access$getApplicationsLoading$p(StoreApplication.this).contains(Long.valueOf(this.$appId))) {
                return;
            }
            StoreApplication.access$getApplicationsLoading$p(StoreApplication.this).add(Long.valueOf(this.$appId));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getApplications(this.$appId), false, 1, null), StoreApplication.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C00761(), 54, (Object) null);
        }
    }

    /* compiled from: StoreApplication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/application/Application;", "invoke", "()Lcom/discord/api/application/Application;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplication$observeApplication$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Application> {
        public final /* synthetic */ Long $appId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l) {
            super(0);
            this.$appId = l;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Application invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Application invoke() {
            return (Application) StoreApplication.access$getApplicationsSnapshot$p(StoreApplication.this).get(this.$appId);
        }
    }

    /* compiled from: StoreApplication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ApplicationId;", "Lcom/discord/api/application/Application;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplication$observeApplications$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Application>> {
        public final /* synthetic */ Collection $applicationIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Collection collection) {
            super(0);
            this.$applicationIds = collection;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Application> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Application> invoke2() {
            HashMap mapAccess$getApplicationsSnapshot$p = StoreApplication.access$getApplicationsSnapshot$p(StoreApplication.this);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : mapAccess$getApplicationsSnapshot$p.entrySet()) {
                if (this.$applicationIds.contains(Long.valueOf(((Number) entry.getKey()).longValue()))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    public StoreApplication(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.applications = new HashMap<>();
        this.applicationsLoading = new HashSet<>();
        this.applicationsSnapshot = new HashMap<>();
    }

    public static final /* synthetic */ HashMap access$getApplications$p(StoreApplication storeApplication) {
        return storeApplication.applications;
    }

    public static final /* synthetic */ HashSet access$getApplicationsLoading$p(StoreApplication storeApplication) {
        return storeApplication.applicationsLoading;
    }

    public static final /* synthetic */ HashMap access$getApplicationsSnapshot$p(StoreApplication storeApplication) {
        return storeApplication.applicationsSnapshot;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreApplication storeApplication) {
        return storeApplication.dispatcher;
    }

    public static final /* synthetic */ void access$setApplicationsSnapshot$p(StoreApplication storeApplication, HashMap map) {
        storeApplication.applicationsSnapshot = map;
    }

    public final void fetchIfNonexisting(long appId) {
        this.dispatcher.schedule(new AnonymousClass1(appId));
    }

    public final Observable<Application> observeApplication(Long appId) {
        if (appId != null) {
            fetchIfNonexisting(appId.longValue());
            return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(appId), 14, null);
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n          .just(null)");
        return scalarSynchronousObservable;
    }

    public final Observable<Map<Long, Application>> observeApplications(Collection<Long> applicationIds) {
        Intrinsics3.checkNotNullParameter(applicationIds, "applicationIds");
        Observable<Map<Long, Application>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(applicationIds), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.applicationsSnapshot = new HashMap<>(this.applications);
    }
}
