package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import b.d.b.a.outline;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.ModelPaymentSource3;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StorePaymentSources.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001'B#\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u0012\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\n\u0010\u0004J#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0017\u0010\u0004J\r\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0004R\u0016\u0010\u0019\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/discord/stores/StorePaymentSources;", "Lcom/discord/stores/StoreV2;", "", "handlePaymentSourcesFetchStart", "()V", "", "Lcom/discord/models/domain/ModelPaymentSource;", "paymentSources", "handlePaymentSourcesFetchSuccess", "(Ljava/util/List;)V", "handlePaymentSourcesFetchFailure", "Lcom/discord/models/domain/PaymentSourceRaw;", "rawPaymentSources", "ensureDefaultPaymentSource", "(Ljava/util/List;)Ljava/util/List;", "Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "getPaymentSourcesState", "()Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "Lrx/Observable;", "observePaymentSourcesState", "()Lrx/Observable;", "handlePreLogout", "handleUserPaymentSourcesUpdate", "snapshotData", "fetchPaymentSources", "paymentSourcesState", "Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "paymentSourcesStateSnapshot", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/utilities/rest/RestAPI;)V", "PaymentSourcesState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StorePaymentSources extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private PaymentSourcesState paymentSourcesState;
    private PaymentSourcesState paymentSourcesStateSnapshot;
    private final RestAPI restAPI;

    /* compiled from: StorePaymentSources.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "", "<init>", "()V", "Failure", "Loaded", "Loading", "Unfetched", "Lcom/discord/stores/StorePaymentSources$PaymentSourcesState$Loaded;", "Lcom/discord/stores/StorePaymentSources$PaymentSourcesState$Loading;", "Lcom/discord/stores/StorePaymentSources$PaymentSourcesState$Failure;", "Lcom/discord/stores/StorePaymentSources$PaymentSourcesState$Unfetched;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class PaymentSourcesState {

        /* compiled from: StorePaymentSources.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StorePaymentSources$PaymentSourcesState$Failure;", "Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends PaymentSourcesState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: StorePaymentSources.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/StorePaymentSources$PaymentSourcesState$Loaded;", "Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "", "Lcom/discord/models/domain/ModelPaymentSource;", "component1", "()Ljava/util/List;", "paymentSources", "copy", "(Ljava/util/List;)Lcom/discord/stores/StorePaymentSources$PaymentSourcesState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getPaymentSources", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends PaymentSourcesState {
            private final List<ModelPaymentSource> paymentSources;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends ModelPaymentSource> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "paymentSources");
                this.paymentSources = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.paymentSources;
                }
                return loaded.copy(list);
            }

            public final List<ModelPaymentSource> component1() {
                return this.paymentSources;
            }

            public final Loaded copy(List<? extends ModelPaymentSource> paymentSources) {
                Intrinsics3.checkNotNullParameter(paymentSources, "paymentSources");
                return new Loaded(paymentSources);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.paymentSources, ((Loaded) other).paymentSources);
                }
                return true;
            }

            public final List<ModelPaymentSource> getPaymentSources() {
                return this.paymentSources;
            }

            public int hashCode() {
                List<ModelPaymentSource> list = this.paymentSources;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(paymentSources="), this.paymentSources, ")");
            }
        }

        /* compiled from: StorePaymentSources.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StorePaymentSources$PaymentSourcesState$Loading;", "Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends PaymentSourcesState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StorePaymentSources.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StorePaymentSources$PaymentSourcesState$Unfetched;", "Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Unfetched extends PaymentSourcesState {
            public static final Unfetched INSTANCE = new Unfetched();

            private Unfetched() {
                super(null);
            }
        }

        private PaymentSourcesState() {
        }

        public /* synthetic */ PaymentSourcesState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StorePaymentSources.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {

        /* compiled from: StorePaymentSources.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0002*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00000\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/models/domain/PaymentSourceRaw;", "kotlin.jvm.PlatformType", "it", "Lcom/discord/models/domain/ModelPaymentSource;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01621<T, R> implements Func1<List<? extends ModelPaymentSource3>, List<? extends ModelPaymentSource>> {
            public C01621() {
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ List<? extends ModelPaymentSource> call(List<? extends ModelPaymentSource3> list) {
                return call2((List<ModelPaymentSource3>) list);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final List<ModelPaymentSource> call2(List<ModelPaymentSource3> list) {
                StorePaymentSources storePaymentSources = StorePaymentSources.this;
                Intrinsics3.checkNotNullExpressionValue(list, "it");
                return StorePaymentSources.access$ensureDefaultPaymentSource(storePaymentSources, list);
            }
        }

        /* compiled from: StorePaymentSources.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/models/domain/ModelPaymentSource;", "kotlin.jvm.PlatformType", "paymentSources", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends ModelPaymentSource>, Unit> {

            /* compiled from: StorePaymentSources.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01631 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $paymentSources;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01631(List list) {
                    super(0);
                    this.$paymentSources = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StorePaymentSources storePaymentSources = StorePaymentSources.this;
                    List list = this.$paymentSources;
                    Intrinsics3.checkNotNullExpressionValue(list, "paymentSources");
                    StorePaymentSources.access$handlePaymentSourcesFetchSuccess(storePaymentSources, list);
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelPaymentSource> list) {
                invoke2(list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends ModelPaymentSource> list) {
                StorePaymentSources.access$getDispatcher$p(StorePaymentSources.this).schedule(new C01631(list));
            }
        }

        /* compiled from: StorePaymentSources.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StorePaymentSources.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StorePaymentSources$fetchPaymentSources$1$3$1, reason: invalid class name and collision with other inner class name */
            public static final class C01641 extends Lambda implements Function0<Unit> {
                public C01641() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StorePaymentSources.access$handlePaymentSourcesFetchFailure(StorePaymentSources.this);
                }
            }

            public AnonymousClass3() {
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
                StorePaymentSources.access$getDispatcher$p(StorePaymentSources.this).schedule(new C01641());
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
            if (StorePaymentSources.access$getPaymentSourcesState$p(StorePaymentSources.this) instanceof PaymentSourcesState.Loading) {
                return;
            }
            StorePaymentSources.access$handlePaymentSourcesFetchStart(StorePaymentSources.this);
            Observable observableG = ObservableExtensionsKt.restSubscribeOn$default(StorePaymentSources.access$getRestAPI$p(StorePaymentSources.this).getPaymentSources(), false, 1, null).G(new C01621());
            Intrinsics3.checkNotNullExpressionValue(observableG, "restAPI\n          .getPa…efaultPaymentSource(it) }");
            ObservableExtensionsKt.appSubscribe$default(observableG, StorePaymentSources.this.getClass(), (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
        }
    }

    /* compiled from: StorePaymentSources.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "invoke", "()Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StorePaymentSources$observePaymentSourcesState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<PaymentSourcesState> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ PaymentSourcesState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PaymentSourcesState invoke() {
            return StorePaymentSources.this.getPaymentSourcesStateSnapshot();
        }
    }

    public /* synthetic */ StorePaymentSources(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ List access$ensureDefaultPaymentSource(StorePaymentSources storePaymentSources, List list) {
        return storePaymentSources.ensureDefaultPaymentSource(list);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StorePaymentSources storePaymentSources) {
        return storePaymentSources.dispatcher;
    }

    public static final /* synthetic */ PaymentSourcesState access$getPaymentSourcesState$p(StorePaymentSources storePaymentSources) {
        return storePaymentSources.paymentSourcesState;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StorePaymentSources storePaymentSources) {
        return storePaymentSources.restAPI;
    }

    public static final /* synthetic */ void access$handlePaymentSourcesFetchFailure(StorePaymentSources storePaymentSources) {
        storePaymentSources.handlePaymentSourcesFetchFailure();
    }

    public static final /* synthetic */ void access$handlePaymentSourcesFetchStart(StorePaymentSources storePaymentSources) {
        storePaymentSources.handlePaymentSourcesFetchStart();
    }

    public static final /* synthetic */ void access$handlePaymentSourcesFetchSuccess(StorePaymentSources storePaymentSources, List list) {
        storePaymentSources.handlePaymentSourcesFetchSuccess(list);
    }

    public static final /* synthetic */ void access$setPaymentSourcesState$p(StorePaymentSources storePaymentSources, PaymentSourcesState paymentSourcesState) {
        storePaymentSources.paymentSourcesState = paymentSourcesState;
    }

    private final List<ModelPaymentSource> ensureDefaultPaymentSource(List<ModelPaymentSource3> rawPaymentSources) {
        if (rawPaymentSources.isEmpty()) {
            return Collections2.emptyList();
        }
        List mutableList = _Collections.toMutableList((Collection) _Collections.sortedWith(rawPaymentSources, new StorePaymentSources$ensureDefaultPaymentSource$$inlined$sortedBy$1()));
        mutableList.set(0, ModelPaymentSource3.copy$default((ModelPaymentSource3) _Collections.first(mutableList), 0, null, false, null, true, null, null, null, 0, 0, PointerIconCompat.TYPE_CROSSHAIR, null));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(mutableList, 10));
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            arrayList.add(ModelPaymentSource.INSTANCE.wrap((ModelPaymentSource3) it.next()));
        }
        return arrayList;
    }

    @Store3
    private final void handlePaymentSourcesFetchFailure() {
        this.paymentSourcesState = PaymentSourcesState.Failure.INSTANCE;
        markChanged();
    }

    @Store3
    private final void handlePaymentSourcesFetchStart() {
        this.paymentSourcesState = PaymentSourcesState.Loading.INSTANCE;
        markChanged();
    }

    @Store3
    private final void handlePaymentSourcesFetchSuccess(List<? extends ModelPaymentSource> paymentSources) {
        this.paymentSourcesState = new PaymentSourcesState.Loaded(paymentSources);
        markChanged();
    }

    public final void fetchPaymentSources() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    /* renamed from: getPaymentSourcesState, reason: from getter */
    public final PaymentSourcesState getPaymentSourcesStateSnapshot() {
        return this.paymentSourcesStateSnapshot;
    }

    @Store3
    public final void handlePreLogout() {
        this.paymentSourcesState = PaymentSourcesState.Unfetched.INSTANCE;
        markChanged();
    }

    @Store3
    public final void handleUserPaymentSourcesUpdate() {
        fetchPaymentSources();
    }

    public final Observable<PaymentSourcesState> observePaymentSourcesState() {
        Observable<PaymentSourcesState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        PaymentSourcesState paymentSourcesStateCopy = this.paymentSourcesState;
        if (paymentSourcesStateCopy instanceof PaymentSourcesState.Loaded) {
            PaymentSourcesState.Loaded loaded = (PaymentSourcesState.Loaded) paymentSourcesStateCopy;
            paymentSourcesStateCopy = loaded.copy(new ArrayList(loaded.getPaymentSources()));
        } else if (!Intrinsics3.areEqual(paymentSourcesStateCopy, PaymentSourcesState.Loading.INSTANCE) && !Intrinsics3.areEqual(paymentSourcesStateCopy, PaymentSourcesState.Failure.INSTANCE) && !Intrinsics3.areEqual(paymentSourcesStateCopy, PaymentSourcesState.Unfetched.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.paymentSourcesStateSnapshot = paymentSourcesStateCopy;
    }

    public StorePaymentSources(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        PaymentSourcesState.Unfetched unfetched = PaymentSourcesState.Unfetched.INSTANCE;
        this.paymentSourcesState = unfetched;
        this.paymentSourcesStateSnapshot = unfetched;
    }
}
