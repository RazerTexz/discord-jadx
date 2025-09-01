package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.models.domain.ModelEntitlement;
import com.discord.restapi.RestAPIInterface;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreEntitlements.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001/B!\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b-\u0010.J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\nJ\u001d\u0010\u000f\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0015\u001a\u00020\b2\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0017\u0010\nJ\u0019\u0010\u0018\u001a\u00020\b2\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\nR,\u0010\u001d\u001a\u0018\u0012\b\u0012\u00060\u0011j\u0002`\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R,\u0010%\u001a\u0018\u0012\b\u0012\u00060\u0011j\u0002`\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001eR\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010 R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/discord/stores/StoreEntitlements;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/stores/StoreEntitlements$State;", "getEntitlementState", "()Lcom/discord/stores/StoreEntitlements$State;", "Lrx/Observable;", "observeEntitlementState", "()Lrx/Observable;", "", "handleFetchingState", "()V", "handleFetchError", "", "Lcom/discord/models/domain/ModelEntitlement;", "giftEntitlements", "handleFetchGiftsSuccess", "(Ljava/util/List;)V", "", "Lcom/discord/primitives/ApplicationId;", "applicationId", "entitlements", "handleFetchEntitlementsSuccess", "(JLjava/util/List;)V", "snapshotData", "fetchMyEntitlementsForApplication", "(J)V", "fetchMyGiftEntitlements", "", "Lcom/discord/primitives/SkuId;", "giftEntitlementMap", "Ljava/util/Map;", "state", "Lcom/discord/stores/StoreEntitlements$State;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "", "entitlementMap", "stateSnapshot", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/utilities/rest/RestAPI;)V", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreEntitlements extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Long, List<ModelEntitlement>> entitlementMap;
    private Map<Long, ? extends List<ModelEntitlement>> giftEntitlementMap;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private State state;
    private State stateSnapshot;

    /* compiled from: StoreEntitlements.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0002\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/stores/StoreEntitlements$State;", "", "deepCopy", "()Lcom/discord/stores/StoreEntitlements$State;", "<init>", "()V", "Failure", "Loaded", "Loading", "Lcom/discord/stores/StoreEntitlements$State$Loading;", "Lcom/discord/stores/StoreEntitlements$State$Failure;", "Lcom/discord/stores/StoreEntitlements$State$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        /* compiled from: StoreEntitlements.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreEntitlements$State$Failure;", "Lcom/discord/stores/StoreEntitlements$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: StoreEntitlements.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u001c\u0010\r\u001a\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004\u0012\u001c\u0010\u000e\u001a\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0002\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ&\u0010\f\u001a\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\nJP\u0010\u000f\u001a\u00020\u00002\u001e\b\u0002\u0010\r\u001a\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00042\u001e\b\u0002\u0010\u000e\u001a\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR/\u0010\u000e\u001a\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\nR/\u0010\r\u001a\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001e\u0010\n¨\u0006!"}, d2 = {"Lcom/discord/stores/StoreEntitlements$State$Loaded;", "Lcom/discord/stores/StoreEntitlements$State;", "deepCopy", "()Lcom/discord/stores/StoreEntitlements$State$Loaded;", "", "", "Lcom/discord/primitives/SkuId;", "", "Lcom/discord/models/domain/ModelEntitlement;", "component1", "()Ljava/util/Map;", "Lcom/discord/primitives/ApplicationId;", "component2", "giftableEntitlements", "ownedEntitlements", "copy", "(Ljava/util/Map;Ljava/util/Map;)Lcom/discord/stores/StoreEntitlements$State$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getOwnedEntitlements", "getGiftableEntitlements", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends State {
            private final Map<Long, List<ModelEntitlement>> giftableEntitlements;
            private final Map<Long, List<ModelEntitlement>> ownedEntitlements;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(Map<Long, ? extends List<ModelEntitlement>> map, Map<Long, ? extends List<ModelEntitlement>> map2) {
                super(null);
                Intrinsics3.checkNotNullParameter(map, "giftableEntitlements");
                Intrinsics3.checkNotNullParameter(map2, "ownedEntitlements");
                this.giftableEntitlements = map;
                this.ownedEntitlements = map2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, Map map2, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.giftableEntitlements;
                }
                if ((i & 2) != 0) {
                    map2 = loaded.ownedEntitlements;
                }
                return loaded.copy(map, map2);
            }

            public final Map<Long, List<ModelEntitlement>> component1() {
                return this.giftableEntitlements;
            }

            public final Map<Long, List<ModelEntitlement>> component2() {
                return this.ownedEntitlements;
            }

            public final Loaded copy(Map<Long, ? extends List<ModelEntitlement>> giftableEntitlements, Map<Long, ? extends List<ModelEntitlement>> ownedEntitlements) {
                Intrinsics3.checkNotNullParameter(giftableEntitlements, "giftableEntitlements");
                Intrinsics3.checkNotNullParameter(ownedEntitlements, "ownedEntitlements");
                return new Loaded(giftableEntitlements, ownedEntitlements);
            }

            @Override // com.discord.stores.StoreEntitlements.State
            public /* bridge */ /* synthetic */ State deepCopy() {
                return deepCopy();
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.giftableEntitlements, loaded.giftableEntitlements) && Intrinsics3.areEqual(this.ownedEntitlements, loaded.ownedEntitlements);
            }

            public final Map<Long, List<ModelEntitlement>> getGiftableEntitlements() {
                return this.giftableEntitlements;
            }

            public final Map<Long, List<ModelEntitlement>> getOwnedEntitlements() {
                return this.ownedEntitlements;
            }

            public int hashCode() {
                Map<Long, List<ModelEntitlement>> map = this.giftableEntitlements;
                int iHashCode = (map != null ? map.hashCode() : 0) * 31;
                Map<Long, List<ModelEntitlement>> map2 = this.ownedEntitlements;
                return iHashCode + (map2 != null ? map2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(giftableEntitlements=");
                sbU.append(this.giftableEntitlements);
                sbU.append(", ownedEntitlements=");
                return outline.M(sbU, this.ownedEntitlements, ")");
            }

            @Override // com.discord.stores.StoreEntitlements.State
            public Loaded deepCopy() {
                return copy(new HashMap(this.giftableEntitlements), new HashMap(this.ownedEntitlements));
            }
        }

        /* compiled from: StoreEntitlements.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreEntitlements$State$Loading;", "Lcom/discord/stores/StoreEntitlements$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends State {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private State() {
        }

        public State deepCopy() {
            return this;
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreEntitlements.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEntitlements$fetchMyEntitlementsForApplication$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
            StoreEntitlements.this.handleFetchingState();
        }
    }

    /* compiled from: StoreEntitlements.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEntitlements$fetchMyEntitlementsForApplication$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

        /* compiled from: StoreEntitlements.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreEntitlements$fetchMyEntitlementsForApplication$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
                StoreEntitlements.this.handleFetchError();
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
            StoreEntitlements.access$getDispatcher$p(StoreEntitlements.this).schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreEntitlements.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/models/domain/ModelEntitlement;", "entitlements", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEntitlements$fetchMyEntitlementsForApplication$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<List<? extends ModelEntitlement>, Unit> {
        public final /* synthetic */ long $applicationId;

        /* compiled from: StoreEntitlements.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreEntitlements$fetchMyEntitlementsForApplication$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $entitlements;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$entitlements = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreEntitlements.this.handleFetchEntitlementsSuccess(anonymousClass3.$applicationId, this.$entitlements);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j) {
            super(1);
            this.$applicationId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelEntitlement> list) {
            invoke2((List<ModelEntitlement>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelEntitlement> list) {
            Intrinsics3.checkNotNullParameter(list, "entitlements");
            StoreEntitlements.access$getDispatcher$p(StoreEntitlements.this).schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StoreEntitlements.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEntitlements$fetchMyGiftEntitlements$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
            StoreEntitlements.this.handleFetchingState();
        }
    }

    /* compiled from: StoreEntitlements.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEntitlements$fetchMyGiftEntitlements$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

        /* compiled from: StoreEntitlements.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreEntitlements$fetchMyGiftEntitlements$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
                StoreEntitlements.this.handleFetchError();
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
            StoreEntitlements.access$getDispatcher$p(StoreEntitlements.this).schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreEntitlements.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/models/domain/ModelEntitlement;", "entitlements", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEntitlements$fetchMyGiftEntitlements$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<List<? extends ModelEntitlement>, Unit> {

        /* compiled from: StoreEntitlements.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreEntitlements$fetchMyGiftEntitlements$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $entitlements;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$entitlements = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreEntitlements.this.handleFetchGiftsSuccess(this.$entitlements);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelEntitlement> list) {
            invoke2((List<ModelEntitlement>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelEntitlement> list) {
            Intrinsics3.checkNotNullParameter(list, "entitlements");
            StoreEntitlements.access$getDispatcher$p(StoreEntitlements.this).schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StoreEntitlements.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreEntitlements$State;", "invoke", "()Lcom/discord/stores/StoreEntitlements$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEntitlements$observeEntitlementState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<State> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ State invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreEntitlements.access$getStateSnapshot$p(StoreEntitlements.this);
        }
    }

    public /* synthetic */ StoreEntitlements(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreEntitlements storeEntitlements) {
        return storeEntitlements.dispatcher;
    }

    public static final /* synthetic */ State access$getStateSnapshot$p(StoreEntitlements storeEntitlements) {
        return storeEntitlements.stateSnapshot;
    }

    public static final /* synthetic */ void access$setStateSnapshot$p(StoreEntitlements storeEntitlements, State state) {
        storeEntitlements.stateSnapshot = state;
    }

    public final void fetchMyEntitlementsForApplication(long applicationId) {
        this.dispatcher.schedule(new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPIInterface.DefaultImpls.getMyEntitlements$default(this.restAPI, applicationId, false, 2, null), false, 1, null), StoreEntitlements.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass3(applicationId), 54, (Object) null);
    }

    public final void fetchMyGiftEntitlements() {
        this.dispatcher.schedule(new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGifts(), false, 1, null), StoreEntitlements.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass3(), 54, (Object) null);
    }

    /* renamed from: getEntitlementState, reason: from getter */
    public final State getStateSnapshot() {
        return this.stateSnapshot;
    }

    @Store3
    public final void handleFetchEntitlementsSuccess(long applicationId, List<ModelEntitlement> entitlements) {
        Intrinsics3.checkNotNullParameter(entitlements, "entitlements");
        this.entitlementMap.put(Long.valueOf(applicationId), entitlements);
        this.state = new State.Loaded(this.giftEntitlementMap, this.entitlementMap);
        markChanged();
    }

    @Store3
    public final void handleFetchError() {
        this.state = State.Failure.INSTANCE;
        markChanged();
    }

    @Store3
    public final void handleFetchGiftsSuccess(List<ModelEntitlement> giftEntitlements) {
        Intrinsics3.checkNotNullParameter(giftEntitlements, "giftEntitlements");
        HashMap map = new HashMap();
        for (ModelEntitlement modelEntitlement : giftEntitlements) {
            List arrayList = (List) map.get(Long.valueOf(modelEntitlement.getSkuId()));
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(modelEntitlement);
            map.put(Long.valueOf(modelEntitlement.getSkuId()), arrayList);
        }
        this.giftEntitlementMap = map;
        this.state = new State.Loaded(map, this.entitlementMap);
        markChanged();
    }

    @Store3
    public final void handleFetchingState() {
        this.state = State.Loading.INSTANCE;
        markChanged();
    }

    public final Observable<State> observeEntitlementState() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.stateSnapshot = this.state.deepCopy();
    }

    public StoreEntitlements(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.giftEntitlementMap = Maps6.emptyMap();
        this.entitlementMap = new LinkedHashMap();
        State.Loading loading = State.Loading.INSTANCE;
        this.state = loading;
        this.stateSnapshot = loading;
    }
}
