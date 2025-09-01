package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import b.d.b.a.outline;
import com.discord.api.premium.ClaimedOutboundPromotion;
import com.discord.api.premium.OutboundPromotion;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelPayload;
import com.discord.models.user.MeUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.settings.premium.OutboundPromosPreviewFeatureFlag;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreOutboundPromotions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u000212B+\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010'\u001a\u00020&¢\u0006\u0004\b/\u00100J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u000eJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00020\u000b¢\u0006\u0004\b\u0019\u0010\rJ\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b2\n\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001f\u0010\u0017R\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/discord/stores/StoreOutboundPromotions;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/api/premium/OutboundPromotion;", "promos", "", "getUnseenCount", "(Ljava/util/List;)I", "Lcom/discord/stores/StoreOutboundPromotions$State;", "getState", "()Lcom/discord/stores/StoreOutboundPromotions$State;", "Lrx/Observable;", "observeState", "()Lrx/Observable;", "()I", "observeUnseenCount", "Lcom/discord/models/domain/ModelPayload;", "readyPayload", "", "handleConnectionOpen$app_productionGoogleRelease", "(Lcom/discord/models/domain/ModelPayload;)V", "handleConnectionOpen", "markSeen", "()V", "Lcom/discord/api/premium/ClaimedOutboundPromotion;", "fetchClaimedOutboundPromotions", "", "Lcom/discord/primitives/PromoId;", "promotionId", "claimOutboundPromotion", "(J)Lrx/Observable;", "snapshotData", "stateSnapshot", "Lcom/discord/stores/StoreOutboundPromotions$State;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "state", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/widgets/settings/premium/OutboundPromosPreviewFeatureFlag;", "previewFeatureFlag", "Lcom/discord/widgets/settings/premium/OutboundPromosPreviewFeatureFlag;", "<init>", "(Lcom/discord/widgets/settings/premium/OutboundPromosPreviewFeatureFlag;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/utilities/rest/RestAPI;)V", "Companion", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreOutboundPromotions extends StoreV2 {
    private static final String CONSUMED_ENTITLEMENT_PROMO_ID = "CONSUMED_ENTITLEMENT_CODE";
    private static final String LATEST_SEEN_PROMO_DATE = "LATEST_SEEN_PROMO_DATE";
    private static final long NO_PROMO_ID = -1;
    private static final long NO_SEEN_PROMO_DATE = -1;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final OutboundPromosPreviewFeatureFlag previewFeatureFlag;
    private final RestAPI restAPI;
    private State state;
    private State stateSnapshot;

    /* compiled from: StoreOutboundPromotions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0002\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/stores/StoreOutboundPromotions$State;", "", "deepCopy", "()Lcom/discord/stores/StoreOutboundPromotions$State;", "<init>", "()V", "Failed", "Loaded", "Loading", "Lcom/discord/stores/StoreOutboundPromotions$State$Failed;", "Lcom/discord/stores/StoreOutboundPromotions$State$Loading;", "Lcom/discord/stores/StoreOutboundPromotions$State$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        /* compiled from: StoreOutboundPromotions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreOutboundPromotions$State$Failed;", "Lcom/discord/stores/StoreOutboundPromotions$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failed extends State {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* compiled from: StoreOutboundPromotions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0002\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ*\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\nJ\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\nR\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/discord/stores/StoreOutboundPromotions$State$Loaded;", "Lcom/discord/stores/StoreOutboundPromotions$State;", "deepCopy", "()Lcom/discord/stores/StoreOutboundPromotions$State$Loaded;", "", "Lcom/discord/api/premium/OutboundPromotion;", "component1", "()Ljava/util/List;", "", "component2", "()I", "validActivePromotions", "unseenCount", "copy", "(Ljava/util/List;I)Lcom/discord/stores/StoreOutboundPromotions$State$Loaded;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getUnseenCount", "Ljava/util/List;", "getValidActivePromotions", "<init>", "(Ljava/util/List;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends State {
            private final int unseenCount;
            private final List<OutboundPromotion> validActivePromotions;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<OutboundPromotion> list, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "validActivePromotions");
                this.validActivePromotions = list;
                this.unseenCount = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    list = loaded.validActivePromotions;
                }
                if ((i2 & 2) != 0) {
                    i = loaded.unseenCount;
                }
                return loaded.copy(list, i);
            }

            public final List<OutboundPromotion> component1() {
                return this.validActivePromotions;
            }

            /* renamed from: component2, reason: from getter */
            public final int getUnseenCount() {
                return this.unseenCount;
            }

            public final Loaded copy(List<OutboundPromotion> validActivePromotions, int unseenCount) {
                Intrinsics3.checkNotNullParameter(validActivePromotions, "validActivePromotions");
                return new Loaded(validActivePromotions, unseenCount);
            }

            @Override // com.discord.stores.StoreOutboundPromotions.State
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
                return Intrinsics3.areEqual(this.validActivePromotions, loaded.validActivePromotions) && this.unseenCount == loaded.unseenCount;
            }

            public final int getUnseenCount() {
                return this.unseenCount;
            }

            public final List<OutboundPromotion> getValidActivePromotions() {
                return this.validActivePromotions;
            }

            public int hashCode() {
                List<OutboundPromotion> list = this.validActivePromotions;
                return ((list != null ? list.hashCode() : 0) * 31) + this.unseenCount;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(validActivePromotions=");
                sbU.append(this.validActivePromotions);
                sbU.append(", unseenCount=");
                return outline.B(sbU, this.unseenCount, ")");
            }

            @Override // com.discord.stores.StoreOutboundPromotions.State
            public Loaded deepCopy() {
                return copy$default(this, new ArrayList(this.validActivePromotions), 0, 2, null);
            }
        }

        /* compiled from: StoreOutboundPromotions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreOutboundPromotions$State$Loading;", "Lcom/discord/stores/StoreOutboundPromotions$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* compiled from: StoreOutboundPromotions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreOutboundPromotions$markSeen$1, reason: invalid class name */
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
            List<OutboundPromotion> validActivePromotions;
            State stateAccess$getState$p = StoreOutboundPromotions.access$getState$p(StoreOutboundPromotions.this);
            Object next = null;
            if (!(stateAccess$getState$p instanceof State.Loaded)) {
                stateAccess$getState$p = null;
            }
            State.Loaded loaded = (State.Loaded) stateAccess$getState$p;
            if (loaded == null || (validActivePromotions = loaded.getValidActivePromotions()) == null) {
                return;
            }
            Iterator<T> it = validActivePromotions.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    UtcDateTime startDate = ((OutboundPromotion) next).getStartDate();
                    do {
                        Object next2 = it.next();
                        UtcDateTime startDate2 = ((OutboundPromotion) next2).getStartDate();
                        if (startDate.compareTo(startDate2) < 0) {
                            next = next2;
                            startDate = startDate2;
                        }
                    } while (it.hasNext());
                }
            }
            OutboundPromotion outboundPromotion = (OutboundPromotion) next;
            if (outboundPromotion != null) {
                SharedPreferences.Editor editorEdit = StoreOutboundPromotions.this.getPrefs().edit();
                Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
                editorEdit.putLong(StoreOutboundPromotions.LATEST_SEEN_PROMO_DATE, outboundPromotion.getStartDate().getDateTimeMillis());
                editorEdit.apply();
                StoreOutboundPromotions storeOutboundPromotions = StoreOutboundPromotions.this;
                StoreOutboundPromotions.access$setState$p(storeOutboundPromotions, new State.Loaded(validActivePromotions, StoreOutboundPromotions.access$getUnseenCount(storeOutboundPromotions, validActivePromotions)));
                StoreOutboundPromotions.this.markChanged();
            }
        }
    }

    /* compiled from: StoreOutboundPromotions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreOutboundPromotions$State;", "invoke", "()Lcom/discord/stores/StoreOutboundPromotions$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreOutboundPromotions$observeState$1, reason: invalid class name */
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
            return StoreOutboundPromotions.this.getStateSnapshot();
        }
    }

    /* compiled from: StoreOutboundPromotions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreOutboundPromotions$observeUnseenCount$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Integer> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return StoreOutboundPromotions.this.getUnseenCount();
        }
    }

    public /* synthetic */ StoreOutboundPromotions(OutboundPromosPreviewFeatureFlag outboundPromosPreviewFeatureFlag, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(outboundPromosPreviewFeatureFlag, dispatcher, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreOutboundPromotions storeOutboundPromotions) {
        return storeOutboundPromotions.dispatcher;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreOutboundPromotions storeOutboundPromotions) {
        return storeOutboundPromotions.restAPI;
    }

    public static final /* synthetic */ State access$getState$p(StoreOutboundPromotions storeOutboundPromotions) {
        return storeOutboundPromotions.state;
    }

    public static final /* synthetic */ int access$getUnseenCount(StoreOutboundPromotions storeOutboundPromotions, List list) {
        return storeOutboundPromotions.getUnseenCount(list);
    }

    public static final /* synthetic */ void access$setState$p(StoreOutboundPromotions storeOutboundPromotions, State state) {
        storeOutboundPromotions.state = state;
    }

    public final Observable<ClaimedOutboundPromotion> claimOutboundPromotion(long promotionId) {
        return this.restAPI.claimOutboundPromotion(promotionId);
    }

    public final Observable<List<ClaimedOutboundPromotion>> fetchClaimedOutboundPromotions() {
        return this.restAPI.getClaimedOutboundPromotions();
    }

    /* renamed from: getState, reason: from getter */
    public final State getStateSnapshot() {
        return this.stateSnapshot;
    }

    public final int getUnseenCount() {
        State stateSnapshot = getStateSnapshot();
        if (!(stateSnapshot instanceof State.Loaded)) {
            stateSnapshot = null;
        }
        State.Loaded loaded = (State.Loaded) stateSnapshot;
        if (loaded != null) {
            return loaded.getUnseenCount();
        }
        return 0;
    }

    @Store3
    public final void handleConnectionOpen$app_productionGoogleRelease(ModelPayload readyPayload) {
        Intrinsics3.checkNotNullParameter(readyPayload, "readyPayload");
        UserUtils userUtils = UserUtils.INSTANCE;
        User me2 = readyPayload.getMe();
        Intrinsics3.checkNotNullExpressionValue(me2, "readyPayload.me");
        if (!userUtils.isPremiumTier2(new MeUser(me2))) {
            this.state = new State.Loaded(Collections2.emptyList(), 0);
            markChanged();
            return;
        }
        this.state = State.Loading.INSTANCE;
        markChanged();
        RestAPI restAPI = this.restAPI;
        Observable observableA = ObservableExtensionsKt.restSubscribeOn$default(this.previewFeatureFlag.isEnabled() ? restAPI.getAllPreviewPromotions() : restAPI.getAllActiveOutboundPromotions(), false, 1, null).A(new StoreOutboundPromotions2(this));
        Intrinsics3.checkNotNullExpressionValue(observableA, "restAPI.run {\n        if…            }\n          }");
        ObservableExtensionsKt.appSubscribe$default(observableA, StoreOutboundPromotions.class, (Context) null, (Function1) null, new StoreOutboundPromotions3(this), (Function0) null, (Function0) null, new StoreOutboundPromotions4(this), 54, (Object) null);
    }

    public final void markSeen() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final Observable<State> observeState() {
        Observable<State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Integer> observeUnseenCount() {
        Observable<Integer> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.stateSnapshot = this.state.deepCopy();
    }

    private final int getUnseenCount(List<OutboundPromotion> promos) {
        long j = getPrefs().getLong(LATEST_SEEN_PROMO_DATE, -1L);
        if ((promos instanceof Collection) && promos.isEmpty()) {
            return 0;
        }
        Iterator<T> it = promos.iterator();
        int i = 0;
        while (it.hasNext()) {
            if ((((OutboundPromotion) it.next()).getStartDate().getDateTimeMillis() > j) && (i = i + 1) < 0) {
                Collections2.throwCountOverflow();
            }
        }
        return i;
    }

    public StoreOutboundPromotions(OutboundPromosPreviewFeatureFlag outboundPromosPreviewFeatureFlag, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(outboundPromosPreviewFeatureFlag, "previewFeatureFlag");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.previewFeatureFlag = outboundPromosPreviewFeatureFlag;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        State.Loading loading = State.Loading.INSTANCE;
        this.state = loading;
        this.stateSnapshot = loading;
    }
}
