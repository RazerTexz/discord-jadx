package b.a.a.a;

import android.content.Context;
import androidx.annotation.StringRes;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: GuildBoostCancelViewModel.kt */
/* renamed from: b.a.a.a.f, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildBoostCancelViewModel3 extends AppViewModel<c> {
    public static final a j = new a(null);
    public final long k;
    public final StoreGuildBoost l;
    public final StoreSubscriptions m;
    public final RestAPI n;

    /* compiled from: GuildBoostCancelViewModel.kt */
    /* renamed from: b.a.a.a.f$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: GuildBoostCancelViewModel.kt */
    /* renamed from: b.a.a.a.f$b */
    public static final class b {
        public final StoreGuildBoost.State a;

        /* renamed from: b, reason: collision with root package name */
        public final StoreSubscriptions.SubscriptionsState f41b;

        public b(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState) {
            Intrinsics3.checkNotNullParameter(state, "guildBoostState");
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionState");
            this.a = state;
            this.f41b = subscriptionsState;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics3.areEqual(this.a, bVar.a) && Intrinsics3.areEqual(this.f41b, bVar.f41b);
        }

        public int hashCode() {
            StoreGuildBoost.State state = this.a;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.f41b;
            return iHashCode + (subscriptionsState != null ? subscriptionsState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildBoostState=");
            sbU.append(this.a);
            sbU.append(", subscriptionState=");
            sbU.append(this.f41b);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildBoostCancelViewModel.kt */
    /* renamed from: b.a.a.a.f$c */
    public static abstract class c {
        public final boolean a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f42b;
        public final boolean c;
        public final boolean d;
        public final boolean e;

        /* compiled from: GuildBoostCancelViewModel.kt */
        /* renamed from: b.a.a.a.f$c$a */
        public static final class a extends c {
            public final ModelSubscription f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ModelSubscription modelSubscription) {
                super(false, true, false, true, false, null);
                Intrinsics3.checkNotNullParameter(modelSubscription, Traits.Payment.Type.SUBSCRIPTION);
                this.f = modelSubscription;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && Intrinsics3.areEqual(this.f, ((a) obj).f);
                }
                return true;
            }

            public int hashCode() {
                ModelSubscription modelSubscription = this.f;
                if (modelSubscription != null) {
                    return modelSubscription.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("CancelInProgress(subscription=");
                sbU.append(this.f);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: GuildBoostCancelViewModel.kt */
        /* renamed from: b.a.a.a.f$c$b */
        public static final class b extends c {
            public final ModelSubscription f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(ModelSubscription modelSubscription) {
                super(false, false, false, false, true, null);
                Intrinsics3.checkNotNullParameter(modelSubscription, Traits.Payment.Type.SUBSCRIPTION);
                this.f = modelSubscription;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof b) && Intrinsics3.areEqual(this.f, ((b) obj).f);
                }
                return true;
            }

            public int hashCode() {
                ModelSubscription modelSubscription = this.f;
                if (modelSubscription != null) {
                    return modelSubscription.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Cancelled(subscription=");
                sbU.append(this.f);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: GuildBoostCancelViewModel.kt */
        /* renamed from: b.a.a.a.f$c$c, reason: collision with other inner class name */
        public static final class C0008c extends c {
            public final Integer f;

            public C0008c() {
                this(null, 1);
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ C0008c(Integer num, int i) {
                this(null);
                int i2 = i & 1;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof C0008c) && Intrinsics3.areEqual(this.f, ((C0008c) obj).f);
                }
                return true;
            }

            public int hashCode() {
                Integer num = this.f;
                if (num != null) {
                    return num.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.F(outline.U("Dismiss(dismissStringId="), this.f, ")");
            }

            public C0008c(@StringRes Integer num) {
                super(false, false, false, false, true, null);
                this.f = num;
            }
        }

        /* compiled from: GuildBoostCancelViewModel.kt */
        /* renamed from: b.a.a.a.f$c$d */
        public static final class d extends c {
            public final ModelSubscription f;

            public d(ModelSubscription modelSubscription) {
                super(true, true, true, false, true, null);
                this.f = modelSubscription;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof d) && Intrinsics3.areEqual(this.f, ((d) obj).f);
                }
                return true;
            }

            public int hashCode() {
                ModelSubscription modelSubscription = this.f;
                if (modelSubscription != null) {
                    return modelSubscription.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("FailureCancelling(subscription=");
                sbU.append(this.f);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: GuildBoostCancelViewModel.kt */
        /* renamed from: b.a.a.a.f$c$e */
        public static final class e extends c {
            public final ModelSubscription f;
            public final boolean g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(ModelSubscription modelSubscription, boolean z2) {
                super(false, true, true, false, true, null);
                Intrinsics3.checkNotNullParameter(modelSubscription, Traits.Payment.Type.SUBSCRIPTION);
                this.f = modelSubscription;
                this.g = z2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return Intrinsics3.areEqual(this.f, eVar.f) && this.g == eVar.g;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                ModelSubscription modelSubscription = this.f;
                int iHashCode = (modelSubscription != null ? modelSubscription.hashCode() : 0) * 31;
                boolean z2 = this.g;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(subscription=");
                sbU.append(this.f);
                sbU.append(", isFromInventory=");
                return outline.O(sbU, this.g, ")");
            }
        }

        /* compiled from: GuildBoostCancelViewModel.kt */
        /* renamed from: b.a.a.a.f$c$f */
        public static final class f extends c {
            public static final f f = new f();

            public f() {
                super(false, true, false, false, true, null);
            }
        }

        public c(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, DefaultConstructorMarker defaultConstructorMarker) {
            this.a = z2;
            this.f42b = z3;
            this.c = z4;
            this.d = z5;
            this.e = z6;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostCancelViewModel3(long j2, StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, RestAPI restAPI, Observable observable, int i) {
        Observable observableJ;
        super(c.f.f);
        StoreGuildBoost guildBoosts = (i & 2) != 0 ? StoreStream.INSTANCE.getGuildBoosts() : null;
        StoreSubscriptions subscriptions = (i & 4) != 0 ? StoreStream.INSTANCE.getSubscriptions() : null;
        RestAPI api = (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : null;
        if ((i & 16) != 0) {
            Observable observableObserveGuildBoostState$default = StoreGuildBoost.observeGuildBoostState$default(guildBoosts, null, 1, null);
            Observable<StoreSubscriptions.SubscriptionsState> observableObserveSubscriptions = subscriptions.observeSubscriptions();
            GuildBoostCancelViewModel2 guildBoostCancelViewModel2 = GuildBoostCancelViewModel2.j;
            observableJ = Observable.j(observableObserveGuildBoostState$default, observableObserveSubscriptions, (Func2) (guildBoostCancelViewModel2 != null ? new GuildBoostCancelViewModel5(guildBoostCancelViewModel2) : guildBoostCancelViewModel2));
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…   ::StoreState\n        )");
        } else {
            observableJ = null;
        }
        Intrinsics3.checkNotNullParameter(guildBoosts, "storeGuildBoost");
        Intrinsics3.checkNotNullParameter(subscriptions, "storeSubscriptions");
        Intrinsics3.checkNotNullParameter(api, "api");
        Intrinsics3.checkNotNullParameter(observableJ, "storeObservable");
        this.k = j2;
        this.l = guildBoosts;
        this.m = subscriptions;
        this.n = api;
        guildBoosts.fetchUserGuildBoostState();
        subscriptions.fetchSubscriptions();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableJ), this, null, 2, null), GuildBoostCancelViewModel3.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildBoostCancelViewModel(this), 62, (Object) null);
    }
}
