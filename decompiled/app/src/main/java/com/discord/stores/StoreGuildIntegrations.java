package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreGuildIntegrations.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b-\u0010.J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\b\u0010\tJ)\u0010\r\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0007J1\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00110\u00102\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00102\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0015\u001a\u00060\u0002j\u0002`\u0012¢\u0006\u0004\b\u0013\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0017\u0010\u0007J\r\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\tJ\u0019\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR»\u0001\u0010\"\u001a¦\u0001\u0012L\u0012J\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u000b0\u0011 !*$\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u000b0\u0011\u0018\u00010\u00110\u0011 !*R\u0012L\u0012J\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u000b0\u0011 !*$\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u000b0\u0011\u0018\u00010\u00110\u0011\u0018\u00010 0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R6\u0010%\u001a\"\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u000b0\u00110$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/discord/stores/StoreGuildIntegrations;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "handleIntegrationScreenOpened", "(J)V", "handleIntegrationScreenClosed", "()V", "", "Lcom/discord/models/domain/ModelGuildIntegration;", "integrations", "handleIntegrationsLoaded", "(JLjava/util/List;)V", "requestGuildIntegrations", "Lrx/Observable;", "", "Lcom/discord/primitives/IntegrationId;", "get", "(J)Lrx/Observable;", "integrationId", "(JJ)Lrx/Observable;", "onIntegrationScreenOpened", "onIntegrationScreenClosed", "Lcom/discord/models/domain/ModelGuildIntegration$Update;", "update", "handleUpdate", "(Lcom/discord/models/domain/ModelGuildIntegration$Update;)V", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "integrationsSubject", "Lrx/subjects/BehaviorSubject;", "Ljava/util/HashMap;", "allIntegrations", "Ljava/util/HashMap;", "", "isOnIntegrationsScreen", "Z", "Lrx/Subscription;", "closeIntegrationScreenSubscription", "Lrx/Subscription;", "<init>", "(Lcom/discord/stores/Dispatcher;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildIntegrations {
    private final HashMap<Long, Map<Long, ModelGuildIntegration>> allIntegrations;
    private Subscription closeIntegrationScreenSubscription;
    private final Dispatcher dispatcher;
    private final BehaviorSubject<Map<Long, Map<Long, ModelGuildIntegration>>> integrationsSubject;
    private boolean isOnIntegrationsScreen;

    /* compiled from: StoreGuildIntegrations.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00002N\u0010\u0006\u001aJ\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0000 \u0005*$\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0000\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/IntegrationId;", "Lcom/discord/models/domain/ModelGuildIntegration;", "kotlin.jvm.PlatformType", "integrations", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildIntegrations$get$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>>, Map<Long, ? extends ModelGuildIntegration>> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass1(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends ModelGuildIntegration> call(Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, ModelGuildIntegration> call2(Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>> map) {
            return (Map) map.get(Long.valueOf(this.$guildId));
        }
    }

    /* compiled from: StoreGuildIntegrations.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0018\u0010\u0004\u001a\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/IntegrationId;", "Lcom/discord/models/domain/ModelGuildIntegration;", "integrations", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/models/domain/ModelGuildIntegration;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildIntegrations$get$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Map<Long, ? extends ModelGuildIntegration>, ModelGuildIntegration> {
        public final /* synthetic */ long $integrationId;

        public AnonymousClass2(long j) {
            this.$integrationId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ ModelGuildIntegration call(Map<Long, ? extends ModelGuildIntegration> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ModelGuildIntegration call2(Map<Long, ? extends ModelGuildIntegration> map) {
            if (map != null) {
                return map.get(Long.valueOf(this.$integrationId));
            }
            return null;
        }
    }

    /* compiled from: StoreGuildIntegrations.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenClosed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {

        /* compiled from: StoreGuildIntegrations.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenClosed$1$1, reason: invalid class name and collision with other inner class name */
        public static final /* synthetic */ class C01171 extends FunctionReferenceImpl implements Function0<Unit> {
            public C01171(StoreGuildIntegrations storeGuildIntegrations) {
                super(0, storeGuildIntegrations, StoreGuildIntegrations.class, "handleIntegrationScreenClosed", "handleIntegrationScreenClosed()V", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildIntegrations.access$handleIntegrationScreenClosed((StoreGuildIntegrations) this.receiver);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreGuildIntegrations.access$getDispatcher$p(StoreGuildIntegrations.this).schedule(new C01171(StoreGuildIntegrations.this));
        }
    }

    /* compiled from: StoreGuildIntegrations.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenClosed$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            StoreGuildIntegrations.access$setCloseIntegrationScreenSubscription$p(StoreGuildIntegrations.this, subscription);
        }
    }

    /* compiled from: StoreGuildIntegrations.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenOpened$1, reason: invalid class name */
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
            StoreGuildIntegrations.access$handleIntegrationScreenOpened(StoreGuildIntegrations.this, this.$guildId);
        }
    }

    /* compiled from: StoreGuildIntegrations.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/models/domain/ModelGuildIntegration;", "integrations", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildIntegrations$requestGuildIntegrations$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ModelGuildIntegration>, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildIntegrations.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildIntegrations$requestGuildIntegrations$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01181 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $integrations;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01181(List list) {
                super(0);
                this.$integrations = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreGuildIntegrations.access$handleIntegrationsLoaded(StoreGuildIntegrations.this, anonymousClass1.$guildId, this.$integrations);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGuildIntegration> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ModelGuildIntegration> list) {
            Intrinsics3.checkNotNullParameter(list, "integrations");
            StoreGuildIntegrations.access$getDispatcher$p(StoreGuildIntegrations.this).schedule(new C01181(list));
        }
    }

    public StoreGuildIntegrations(Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.allIntegrations = new HashMap<>();
        this.integrationsSubject = BehaviorSubject.l0(new HashMap());
    }

    public static final /* synthetic */ Subscription access$getCloseIntegrationScreenSubscription$p(StoreGuildIntegrations storeGuildIntegrations) {
        return storeGuildIntegrations.closeIntegrationScreenSubscription;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildIntegrations storeGuildIntegrations) {
        return storeGuildIntegrations.dispatcher;
    }

    public static final /* synthetic */ void access$handleIntegrationScreenClosed(StoreGuildIntegrations storeGuildIntegrations) {
        storeGuildIntegrations.handleIntegrationScreenClosed();
    }

    public static final /* synthetic */ void access$handleIntegrationScreenOpened(StoreGuildIntegrations storeGuildIntegrations, long j) {
        storeGuildIntegrations.handleIntegrationScreenOpened(j);
    }

    public static final /* synthetic */ void access$handleIntegrationsLoaded(StoreGuildIntegrations storeGuildIntegrations, long j, List list) {
        storeGuildIntegrations.handleIntegrationsLoaded(j, list);
    }

    public static final /* synthetic */ void access$setCloseIntegrationScreenSubscription$p(StoreGuildIntegrations storeGuildIntegrations, Subscription subscription) {
        storeGuildIntegrations.closeIntegrationScreenSubscription = subscription;
    }

    @Store3
    private final void handleIntegrationScreenClosed() {
        this.isOnIntegrationsScreen = false;
    }

    @Store3
    private final void handleIntegrationScreenOpened(long guildId) {
        if (this.isOnIntegrationsScreen) {
            return;
        }
        this.isOnIntegrationsScreen = true;
        requestGuildIntegrations(guildId);
    }

    @Store3
    private final void handleIntegrationsLoaded(long guildId, List<? extends ModelGuildIntegration> integrations) {
        HashMap<Long, Map<Long, ModelGuildIntegration>> map = this.allIntegrations;
        Long lValueOf = Long.valueOf(guildId);
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(integrations, 10)), 16));
        for (Object obj : integrations) {
            linkedHashMap.put(Long.valueOf(((ModelGuildIntegration) obj).getId()), obj);
        }
        map.put(lValueOf, linkedHashMap);
        this.integrationsSubject.onNext(new HashMap(this.allIntegrations));
    }

    private final void requestGuildIntegrations(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getGuildIntegrations(guildId), false, 1, null), StoreGuildIntegrations.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(guildId), 62, (Object) null);
    }

    public final Observable<Map<Long, ModelGuildIntegration>> get(long guildId) {
        Observable<Map<Long, ModelGuildIntegration>> observableR = this.integrationsSubject.G(new AnonymousClass1(guildId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "integrationsSubject\n    …  .distinctUntilChanged()");
        return observableR;
    }

    @Store3
    public final void handleUpdate(ModelGuildIntegration.Update update) {
        if (!this.isOnIntegrationsScreen || update == null) {
            return;
        }
        requestGuildIntegrations(update.getGuildId());
    }

    public final synchronized void onIntegrationScreenClosed() {
        Subscription subscription = this.closeIntegrationScreenSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<Long> observableD0 = Observable.d0(1000L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n        .time…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableD0, getClass(), (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 58, (Object) null);
    }

    public final synchronized void onIntegrationScreenOpened(long guildId) {
        Subscription subscription = this.closeIntegrationScreenSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final Observable<ModelGuildIntegration> get(long guildId, long integrationId) {
        Observable<ModelGuildIntegration> observableR = get(guildId).G(new AnonymousClass2(integrationId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "get(guildId)\n          .…  .distinctUntilChanged()");
        return observableR;
    }
}
