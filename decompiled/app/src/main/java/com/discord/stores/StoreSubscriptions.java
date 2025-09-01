package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreSubscriptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001'B\u001f\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\r\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0004R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/discord/stores/StoreSubscriptions;", "Lcom/discord/stores/StoreV2;", "", "handleSubscriptionsFetchStart", "()V", "", "Lcom/discord/models/domain/ModelSubscription;", "subscriptions", "handleSubscriptionsFetchSuccess", "(Ljava/util/List;)V", "handleSubscriptionsFetchFailure", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "getSubscriptions", "()Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "Lrx/Observable;", "observeSubscriptions", "()Lrx/Observable;", "", "hasFetchedSubscriptions", "()Z", "isFetchingSubscriptions", "handlePreLogout", "handleUserSubscriptionsUpdate", "snapshotData", "fetchSubscriptions", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "subscriptionsStateSnapshot", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "subscriptionsState", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/rest/RestAPI;)V", "SubscriptionsState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreSubscriptions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private SubscriptionsState subscriptionsState;
    private SubscriptionsState subscriptionsStateSnapshot;

    /* compiled from: StoreSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "", "<init>", "()V", "Failure", "Loaded", "Loading", "Unfetched", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState$Loaded;", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState$Loading;", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState$Failure;", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState$Unfetched;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class SubscriptionsState {

        /* compiled from: StoreSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreSubscriptions$SubscriptionsState$Failure;", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends SubscriptionsState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: StoreSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/discord/stores/StoreSubscriptions$SubscriptionsState$Loaded;", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "", "Lcom/discord/models/domain/ModelSubscription;", "component1", "()Ljava/util/List;", "subscriptions", "copy", "(Ljava/util/List;)Lcom/discord/stores/StoreSubscriptions$SubscriptionsState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getSubscriptions", "getPremiumSubscription", "()Lcom/discord/models/domain/ModelSubscription;", "premiumSubscription", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends SubscriptionsState {
            private final List<ModelSubscription> subscriptions;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<ModelSubscription> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "subscriptions");
                this.subscriptions = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.subscriptions;
                }
                return loaded.copy(list);
            }

            public final List<ModelSubscription> component1() {
                return this.subscriptions;
            }

            public final Loaded copy(List<ModelSubscription> subscriptions) {
                Intrinsics3.checkNotNullParameter(subscriptions, "subscriptions");
                return new Loaded(subscriptions);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.subscriptions, ((Loaded) other).subscriptions);
                }
                return true;
            }

            public final ModelSubscription getPremiumSubscription() {
                Object next;
                Iterator<T> it = this.subscriptions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (((ModelSubscription) next).getType() == ModelSubscription.Type.PREMIUM) {
                        break;
                    }
                }
                return (ModelSubscription) next;
            }

            public final List<ModelSubscription> getSubscriptions() {
                return this.subscriptions;
            }

            public int hashCode() {
                List<ModelSubscription> list = this.subscriptions;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(subscriptions="), this.subscriptions, ")");
            }
        }

        /* compiled from: StoreSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreSubscriptions$SubscriptionsState$Loading;", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends SubscriptionsState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StoreSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreSubscriptions$SubscriptionsState$Unfetched;", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Unfetched extends SubscriptionsState {
            public static final Unfetched INSTANCE = new Unfetched();

            private Unfetched() {
                super(null);
            }
        }

        private SubscriptionsState() {
        }

        public /* synthetic */ SubscriptionsState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSubscriptions$fetchSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {

        /* compiled from: StoreSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/models/domain/ModelSubscription;", "subscriptions", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreSubscriptions$fetchSubscriptions$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01801 extends Lambda implements Function1<List<? extends ModelSubscription>, Unit> {

            /* compiled from: StoreSubscriptions.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreSubscriptions$fetchSubscriptions$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01811 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $subscriptions;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01811(List list) {
                    super(0);
                    this.$subscriptions = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreSubscriptions.access$handleSubscriptionsFetchSuccess(StoreSubscriptions.this, this.$subscriptions);
                }
            }

            public C01801() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelSubscription> list) {
                invoke2((List<ModelSubscription>) list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ModelSubscription> list) {
                Intrinsics3.checkNotNullParameter(list, "subscriptions");
                StoreSubscriptions.access$getDispatcher$p(StoreSubscriptions.this).schedule(new C01811(list));
            }
        }

        /* compiled from: StoreSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreSubscriptions$fetchSubscriptions$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreSubscriptions.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreSubscriptions$fetchSubscriptions$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01821 extends Lambda implements Function0<Unit> {
                public C01821() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreSubscriptions.access$handleSubscriptionsFetchFailure(StoreSubscriptions.this);
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
                StoreSubscriptions.access$getDispatcher$p(StoreSubscriptions.this).schedule(new C01821());
            }
        }

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreSubscriptions.access$getSubscriptionsState$p(StoreSubscriptions.this) instanceof SubscriptionsState.Loading) {
                return;
            }
            StoreSubscriptions.access$handleSubscriptionsFetchStart(StoreSubscriptions.this);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreSubscriptions.access$getRestAPI$p(StoreSubscriptions.this).getSubscriptions(), false, 1, null), StoreSubscriptions.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C01801(), 54, (Object) null);
        }
    }

    /* compiled from: StoreSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "invoke", "()Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSubscriptions$observeSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<SubscriptionsState> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ SubscriptionsState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubscriptionsState invoke() {
            return StoreSubscriptions.this.getSubscriptionsStateSnapshot();
        }
    }

    public StoreSubscriptions(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        SubscriptionsState.Unfetched unfetched = SubscriptionsState.Unfetched.INSTANCE;
        this.subscriptionsState = unfetched;
        this.subscriptionsStateSnapshot = unfetched;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreSubscriptions storeSubscriptions) {
        return storeSubscriptions.dispatcher;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreSubscriptions storeSubscriptions) {
        return storeSubscriptions.restAPI;
    }

    public static final /* synthetic */ SubscriptionsState access$getSubscriptionsState$p(StoreSubscriptions storeSubscriptions) {
        return storeSubscriptions.subscriptionsState;
    }

    public static final /* synthetic */ void access$handleSubscriptionsFetchFailure(StoreSubscriptions storeSubscriptions) {
        storeSubscriptions.handleSubscriptionsFetchFailure();
    }

    public static final /* synthetic */ void access$handleSubscriptionsFetchStart(StoreSubscriptions storeSubscriptions) {
        storeSubscriptions.handleSubscriptionsFetchStart();
    }

    public static final /* synthetic */ void access$handleSubscriptionsFetchSuccess(StoreSubscriptions storeSubscriptions, List list) {
        storeSubscriptions.handleSubscriptionsFetchSuccess(list);
    }

    public static final /* synthetic */ void access$setSubscriptionsState$p(StoreSubscriptions storeSubscriptions, SubscriptionsState subscriptionsState) {
        storeSubscriptions.subscriptionsState = subscriptionsState;
    }

    @Store3
    private final void handleSubscriptionsFetchFailure() {
        this.subscriptionsState = SubscriptionsState.Failure.INSTANCE;
        markChanged();
    }

    @Store3
    private final void handleSubscriptionsFetchStart() {
        this.subscriptionsState = SubscriptionsState.Loading.INSTANCE;
        markChanged();
    }

    @Store3
    private final void handleSubscriptionsFetchSuccess(List<ModelSubscription> subscriptions) {
        this.subscriptionsState = new SubscriptionsState.Loaded(subscriptions);
        markChanged();
    }

    public final void fetchSubscriptions() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    /* renamed from: getSubscriptions, reason: from getter */
    public final SubscriptionsState getSubscriptionsStateSnapshot() {
        return this.subscriptionsStateSnapshot;
    }

    @Store3
    public final void handlePreLogout() {
        this.subscriptionsState = SubscriptionsState.Unfetched.INSTANCE;
        markChanged();
    }

    @Store3
    public final void handleUserSubscriptionsUpdate() {
        fetchSubscriptions();
    }

    public final boolean hasFetchedSubscriptions() {
        return this.subscriptionsStateSnapshot instanceof SubscriptionsState.Loaded;
    }

    public final boolean isFetchingSubscriptions() {
        return this.subscriptionsStateSnapshot instanceof SubscriptionsState.Loading;
    }

    public final Observable<SubscriptionsState> observeSubscriptions() {
        Observable<SubscriptionsState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        SubscriptionsState subscriptionsStateCopy = this.subscriptionsState;
        if (subscriptionsStateCopy instanceof SubscriptionsState.Loaded) {
            SubscriptionsState.Loaded loaded = (SubscriptionsState.Loaded) subscriptionsStateCopy;
            subscriptionsStateCopy = loaded.copy(new ArrayList(loaded.getSubscriptions()));
        } else if (!Intrinsics3.areEqual(subscriptionsStateCopy, SubscriptionsState.Failure.INSTANCE) && !Intrinsics3.areEqual(subscriptionsStateCopy, SubscriptionsState.Loading.INSTANCE) && !Intrinsics3.areEqual(subscriptionsStateCopy, SubscriptionsState.Unfetched.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.subscriptionsStateSnapshot = subscriptionsStateCopy;
    }
}
