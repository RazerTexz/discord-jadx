package com.discord.widgets.servers.guildboost;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.android.billingclient.api.Purchase;
import com.discord.R;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.StoreUser;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
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
import rx.functions.Func5;
import rx.subjects.PublishSubject;

/* compiled from: GuildBoostViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004'()*BA\u0012\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000e\u0010\u0005J\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00060\u0013j\u0002`\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR:\u0010\"\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010\u000b0\u000b !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010 0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006+"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState;", "", "fetchData", "()V", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$StoreState;)V", "Lrx/Observable;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;", "observeEvents", "()Lrx/Observable;", "retryClicked", "", "section", "subscribeClicked", "(Ljava/lang/String;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "Lcom/discord/stores/StoreSubscriptions;", "storeSubscriptions", "Lcom/discord/stores/StoreSubscriptions;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/stores/StoreGuildBoost;", "storeGuildBoost", "Lcom/discord/stores/StoreGuildBoost;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "storeObservable", "<init>", "(JLcom/discord/stores/StoreGuildBoost;Lcom/discord/stores/StoreSubscriptions;Lcom/discord/utilities/time/Clock;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildBoostViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Clock clock;
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final StoreGuildBoost storeGuildBoost;
    private final StoreSubscriptions storeSubscriptions;

    /* compiled from: GuildBoostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.GuildBoostViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            GuildBoostViewModel.access$handleStoreState(GuildBoostViewModel.this, storeState);
        }
    }

    /* compiled from: GuildBoostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$StoreState;", "observeStores", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, long j) {
            return companion.observeStores(j);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v1, types: [com.discord.widgets.servers.guildboost.GuildBoostViewModel$sam$rx_functions_Func5$0] */
        private final Observable<StoreState> observeStores(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableObserveGuildBoostState$default = StoreGuildBoost.observeGuildBoostState$default(companion.getGuildBoosts(), null, 1, null);
            Observable<StoreSubscriptions.SubscriptionsState> observableObserveSubscriptions = companion.getSubscriptions().observeSubscriptions();
            Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
            Observable<Guild> observableObserveGuild = companion.getGuilds().observeGuild(guildId);
            Observable<StoreGooglePlayPurchases.State> observableObserveState = companion.getGooglePlayPurchases().observeState();
            GuildBoostViewModel2 guildBoostViewModel3 = GuildBoostViewModel2.INSTANCE;
            if (guildBoostViewModel3 != null) {
                guildBoostViewModel3 = new GuildBoostViewModel3(guildBoostViewModel3);
            }
            Observable<StoreState> observableG = Observable.g(observableObserveGuildBoostState$default, observableObserveSubscriptions, observableObserveMe$default, observableObserveGuild, observableObserveState, (Func5) guildBoostViewModel3);
            Intrinsics3.checkNotNullExpressionValue(observableG, "Observable.combineLatest…     ::StoreState\n      )");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildBoostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;", "", "<init>", "()V", "LaunchPurchaseSubscription", "LaunchSubscriptionConfirmation", "ShowBlockedPlanSwitchAlertDialog", "ShowDesktopAlertDialog", "UnacknowledgedPurchase", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event$LaunchSubscriptionConfirmation;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event$LaunchPurchaseSubscription;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event$ShowDesktopAlertDialog;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event$UnacknowledgedPurchase;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: GuildBoostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J4\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\f\b\u0002\u0010\u000b\u001a\u00060\u0005j\u0002`\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001d\u0010\u000b\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event$LaunchPurchaseSubscription;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/primitives/GuildId;", "component2", "()J", "component3", "section", "guildId", "oldSkuName", "copy", "(Ljava/lang/String;JLjava/lang/String;)Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event$LaunchPurchaseSubscription;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSection", "J", "getGuildId", "getOldSkuName", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class LaunchPurchaseSubscription extends Event {
            private final long guildId;
            private final String oldSkuName;
            private final String section;

            public /* synthetic */ LaunchPurchaseSubscription(String str, long j, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, j, (i & 4) != 0 ? null : str2);
            }

            public static /* synthetic */ LaunchPurchaseSubscription copy$default(LaunchPurchaseSubscription launchPurchaseSubscription, String str, long j, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = launchPurchaseSubscription.section;
                }
                if ((i & 2) != 0) {
                    j = launchPurchaseSubscription.guildId;
                }
                if ((i & 4) != 0) {
                    str2 = launchPurchaseSubscription.oldSkuName;
                }
                return launchPurchaseSubscription.copy(str, j, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getSection() {
                return this.section;
            }

            /* renamed from: component2, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component3, reason: from getter */
            public final String getOldSkuName() {
                return this.oldSkuName;
            }

            public final LaunchPurchaseSubscription copy(String section, long guildId, String oldSkuName) {
                Intrinsics3.checkNotNullParameter(section, "section");
                return new LaunchPurchaseSubscription(section, guildId, oldSkuName);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchPurchaseSubscription)) {
                    return false;
                }
                LaunchPurchaseSubscription launchPurchaseSubscription = (LaunchPurchaseSubscription) other;
                return Intrinsics3.areEqual(this.section, launchPurchaseSubscription.section) && this.guildId == launchPurchaseSubscription.guildId && Intrinsics3.areEqual(this.oldSkuName, launchPurchaseSubscription.oldSkuName);
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final String getOldSkuName() {
                return this.oldSkuName;
            }

            public final String getSection() {
                return this.section;
            }

            public int hashCode() {
                String str = this.section;
                int iA = (b.a(this.guildId) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
                String str2 = this.oldSkuName;
                return iA + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("LaunchPurchaseSubscription(section=");
                sbU.append(this.section);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", oldSkuName=");
                return outline.J(sbU, this.oldSkuName, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LaunchPurchaseSubscription(String str, long j, String str2) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "section");
                this.section = str;
                this.guildId = j;
                this.oldSkuName = str2;
            }
        }

        /* compiled from: GuildBoostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J,\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\b\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u0006HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u001d\u0010\b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event$LaunchSubscriptionConfirmation;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "Lcom/discord/primitives/GuildBoostSlotId;", "component2", "guildId", "slotId", "copy", "(JJ)Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event$LaunchSubscriptionConfirmation;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getSlotId", "getGuildId", "<init>", "(JJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class LaunchSubscriptionConfirmation extends Event {
            private final long guildId;
            private final long slotId;

            public LaunchSubscriptionConfirmation(long j, long j2) {
                super(null);
                this.guildId = j;
                this.slotId = j2;
            }

            public static /* synthetic */ LaunchSubscriptionConfirmation copy$default(LaunchSubscriptionConfirmation launchSubscriptionConfirmation, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchSubscriptionConfirmation.guildId;
                }
                if ((i & 2) != 0) {
                    j2 = launchSubscriptionConfirmation.slotId;
                }
                return launchSubscriptionConfirmation.copy(j, j2);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component2, reason: from getter */
            public final long getSlotId() {
                return this.slotId;
            }

            public final LaunchSubscriptionConfirmation copy(long guildId, long slotId) {
                return new LaunchSubscriptionConfirmation(guildId, slotId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchSubscriptionConfirmation)) {
                    return false;
                }
                LaunchSubscriptionConfirmation launchSubscriptionConfirmation = (LaunchSubscriptionConfirmation) other;
                return this.guildId == launchSubscriptionConfirmation.guildId && this.slotId == launchSubscriptionConfirmation.slotId;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final long getSlotId() {
                return this.slotId;
            }

            public int hashCode() {
                return b.a(this.slotId) + (b.a(this.guildId) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("LaunchSubscriptionConfirmation(guildId=");
                sbU.append(this.guildId);
                sbU.append(", slotId=");
                return outline.C(sbU, this.slotId, ")");
            }
        }

        /* compiled from: GuildBoostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0006\u001a\u00020\u00022\b\b\u0003\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;", "", "component1", "()I", "component2", "headerStringRes", "bodyStringRes", "copy", "(II)Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getHeaderStringRes", "getBodyStringRes", "<init>", "(II)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowBlockedPlanSwitchAlertDialog extends Event {
            private final int bodyStringRes;
            private final int headerStringRes;

            public ShowBlockedPlanSwitchAlertDialog(@StringRes int i, @StringRes int i2) {
                super(null);
                this.headerStringRes = i;
                this.bodyStringRes = i2;
            }

            public static /* synthetic */ ShowBlockedPlanSwitchAlertDialog copy$default(ShowBlockedPlanSwitchAlertDialog showBlockedPlanSwitchAlertDialog, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = showBlockedPlanSwitchAlertDialog.headerStringRes;
                }
                if ((i3 & 2) != 0) {
                    i2 = showBlockedPlanSwitchAlertDialog.bodyStringRes;
                }
                return showBlockedPlanSwitchAlertDialog.copy(i, i2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getHeaderStringRes() {
                return this.headerStringRes;
            }

            /* renamed from: component2, reason: from getter */
            public final int getBodyStringRes() {
                return this.bodyStringRes;
            }

            public final ShowBlockedPlanSwitchAlertDialog copy(@StringRes int headerStringRes, @StringRes int bodyStringRes) {
                return new ShowBlockedPlanSwitchAlertDialog(headerStringRes, bodyStringRes);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowBlockedPlanSwitchAlertDialog)) {
                    return false;
                }
                ShowBlockedPlanSwitchAlertDialog showBlockedPlanSwitchAlertDialog = (ShowBlockedPlanSwitchAlertDialog) other;
                return this.headerStringRes == showBlockedPlanSwitchAlertDialog.headerStringRes && this.bodyStringRes == showBlockedPlanSwitchAlertDialog.bodyStringRes;
            }

            public final int getBodyStringRes() {
                return this.bodyStringRes;
            }

            public final int getHeaderStringRes() {
                return this.headerStringRes;
            }

            public int hashCode() {
                return (this.headerStringRes * 31) + this.bodyStringRes;
            }

            public String toString() {
                StringBuilder sbU = outline.U("ShowBlockedPlanSwitchAlertDialog(headerStringRes=");
                sbU.append(this.headerStringRes);
                sbU.append(", bodyStringRes=");
                return outline.B(sbU, this.bodyStringRes, ")");
            }
        }

        /* compiled from: GuildBoostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event$ShowDesktopAlertDialog;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowDesktopAlertDialog extends Event {
            public static final ShowDesktopAlertDialog INSTANCE = new ShowDesktopAlertDialog();

            private ShowDesktopAlertDialog() {
                super(null);
            }
        }

        /* compiled from: GuildBoostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event$UnacknowledgedPurchase;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class UnacknowledgedPurchase extends Event {
            public static final UnacknowledgedPurchase INSTANCE = new UnacknowledgedPurchase();

            private UnacknowledgedPurchase() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildBoostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010\nR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010\rR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010\u0010¨\u0006."}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$StoreState;", "", "Lcom/discord/stores/StoreGuildBoost$State;", "component1", "()Lcom/discord/stores/StoreGuildBoost$State;", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "component2", "()Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "Lcom/discord/models/user/MeUser;", "component3", "()Lcom/discord/models/user/MeUser;", "Lcom/discord/models/guild/Guild;", "component4", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/stores/StoreGooglePlayPurchases$State;", "component5", "()Lcom/discord/stores/StoreGooglePlayPurchases$State;", "guildBoostState", "subscriptionState", "meUser", "guild", "purchasesState", "copy", "(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGooglePlayPurchases$State;)Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/user/MeUser;", "getMeUser", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/stores/StoreGuildBoost$State;", "getGuildBoostState", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "getSubscriptionState", "Lcom/discord/stores/StoreGooglePlayPurchases$State;", "getPurchasesState", "<init>", "(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGooglePlayPurchases$State;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final StoreGuildBoost.State guildBoostState;
        private final MeUser meUser;
        private final StoreGooglePlayPurchases.State purchasesState;
        private final StoreSubscriptions.SubscriptionsState subscriptionState;

        public StoreState(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, MeUser meUser, Guild guild, StoreGooglePlayPurchases.State state2) {
            Intrinsics3.checkNotNullParameter(state, "guildBoostState");
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionState");
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(state2, "purchasesState");
            this.guildBoostState = state;
            this.subscriptionState = subscriptionsState;
            this.meUser = meUser;
            this.guild = guild;
            this.purchasesState = state2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, MeUser meUser, Guild guild, StoreGooglePlayPurchases.State state2, int i, Object obj) {
            if ((i & 1) != 0) {
                state = storeState.guildBoostState;
            }
            if ((i & 2) != 0) {
                subscriptionsState = storeState.subscriptionState;
            }
            StoreSubscriptions.SubscriptionsState subscriptionsState2 = subscriptionsState;
            if ((i & 4) != 0) {
                meUser = storeState.meUser;
            }
            MeUser meUser2 = meUser;
            if ((i & 8) != 0) {
                guild = storeState.guild;
            }
            Guild guild2 = guild;
            if ((i & 16) != 0) {
                state2 = storeState.purchasesState;
            }
            return storeState.copy(state, subscriptionsState2, meUser2, guild2, state2);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        /* renamed from: component2, reason: from getter */
        public final StoreSubscriptions.SubscriptionsState getSubscriptionState() {
            return this.subscriptionState;
        }

        /* renamed from: component3, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* renamed from: component4, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component5, reason: from getter */
        public final StoreGooglePlayPurchases.State getPurchasesState() {
            return this.purchasesState;
        }

        public final StoreState copy(StoreGuildBoost.State guildBoostState, StoreSubscriptions.SubscriptionsState subscriptionState, MeUser meUser, Guild guild, StoreGooglePlayPurchases.State purchasesState) {
            Intrinsics3.checkNotNullParameter(guildBoostState, "guildBoostState");
            Intrinsics3.checkNotNullParameter(subscriptionState, "subscriptionState");
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(purchasesState, "purchasesState");
            return new StoreState(guildBoostState, subscriptionState, meUser, guild, purchasesState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guildBoostState, storeState.guildBoostState) && Intrinsics3.areEqual(this.subscriptionState, storeState.subscriptionState) && Intrinsics3.areEqual(this.meUser, storeState.meUser) && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.purchasesState, storeState.purchasesState);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final StoreGooglePlayPurchases.State getPurchasesState() {
            return this.purchasesState;
        }

        public final StoreSubscriptions.SubscriptionsState getSubscriptionState() {
            return this.subscriptionState;
        }

        public int hashCode() {
            StoreGuildBoost.State state = this.guildBoostState;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.subscriptionState;
            int iHashCode2 = (iHashCode + (subscriptionsState != null ? subscriptionsState.hashCode() : 0)) * 31;
            MeUser meUser = this.meUser;
            int iHashCode3 = (iHashCode2 + (meUser != null ? meUser.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode4 = (iHashCode3 + (guild != null ? guild.hashCode() : 0)) * 31;
            StoreGooglePlayPurchases.State state2 = this.purchasesState;
            return iHashCode4 + (state2 != null ? state2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildBoostState=");
            sbU.append(this.guildBoostState);
            sbU.append(", subscriptionState=");
            sbU.append(this.subscriptionState);
            sbU.append(", meUser=");
            sbU.append(this.meUser);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", purchasesState=");
            sbU.append(this.purchasesState);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildBoostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState;", "", "<init>", "()V", "Failure", "Loaded", "Loading", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState$Loaded;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState$Loading;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState$Failure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: GuildBoostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState$Failure;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends ViewState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: GuildBoostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0016\u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b1\u00102J \u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014JZ\u0010\u001a\u001a\u00020\u00002\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u0012HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b%\u0010&R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b(\u0010\nR\u0019\u0010\u0019\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b*\u0010\u0014R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b,\u0010\u000eR)\u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010-\u001a\u0004\b.\u0010\u0007R\u0019\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u0010\u0011¨\u00063"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState$Loaded;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState;", "", "", "Lcom/discord/primitives/GuildBoostSlotId;", "Lcom/discord/models/domain/ModelGuildBoostSlot;", "component1", "()Ljava/util/Map;", "Lcom/discord/models/domain/ModelSubscription;", "component2", "()Lcom/discord/models/domain/ModelSubscription;", "", "Lcom/android/billingclient/api/Purchase;", "component3", "()Ljava/util/List;", "Lcom/discord/models/user/MeUser;", "component4", "()Lcom/discord/models/user/MeUser;", "Lcom/discord/models/guild/Guild;", "component5", "()Lcom/discord/models/guild/Guild;", "boostSlotMap", "premiumSubscription", "purchases", "meUser", "guild", "copy", "(Ljava/util/Map;Lcom/discord/models/domain/ModelSubscription;Ljava/util/List;Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelSubscription;", "getPremiumSubscription", "Lcom/discord/models/guild/Guild;", "getGuild", "Ljava/util/List;", "getPurchases", "Ljava/util/Map;", "getBoostSlotMap", "Lcom/discord/models/user/MeUser;", "getMeUser", "<init>", "(Ljava/util/Map;Lcom/discord/models/domain/ModelSubscription;Ljava/util/List;Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final Map<Long, ModelGuildBoostSlot> boostSlotMap;
            private final Guild guild;
            private final MeUser meUser;
            private final ModelSubscription premiumSubscription;
            private final List<Purchase> purchases;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(Map<Long, ModelGuildBoostSlot> map, ModelSubscription modelSubscription, List<? extends Purchase> list, MeUser meUser, Guild guild) {
                super(null);
                Intrinsics3.checkNotNullParameter(map, "boostSlotMap");
                Intrinsics3.checkNotNullParameter(list, "purchases");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                Intrinsics3.checkNotNullParameter(guild, "guild");
                this.boostSlotMap = map;
                this.premiumSubscription = modelSubscription;
                this.purchases = list;
                this.meUser = meUser;
                this.guild = guild;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, ModelSubscription modelSubscription, List list, MeUser meUser, Guild guild, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.boostSlotMap;
                }
                if ((i & 2) != 0) {
                    modelSubscription = loaded.premiumSubscription;
                }
                ModelSubscription modelSubscription2 = modelSubscription;
                if ((i & 4) != 0) {
                    list = loaded.purchases;
                }
                List list2 = list;
                if ((i & 8) != 0) {
                    meUser = loaded.meUser;
                }
                MeUser meUser2 = meUser;
                if ((i & 16) != 0) {
                    guild = loaded.guild;
                }
                return loaded.copy(map, modelSubscription2, list2, meUser2, guild);
            }

            public final Map<Long, ModelGuildBoostSlot> component1() {
                return this.boostSlotMap;
            }

            /* renamed from: component2, reason: from getter */
            public final ModelSubscription getPremiumSubscription() {
                return this.premiumSubscription;
            }

            public final List<Purchase> component3() {
                return this.purchases;
            }

            /* renamed from: component4, reason: from getter */
            public final MeUser getMeUser() {
                return this.meUser;
            }

            /* renamed from: component5, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final Loaded copy(Map<Long, ModelGuildBoostSlot> boostSlotMap, ModelSubscription premiumSubscription, List<? extends Purchase> purchases, MeUser meUser, Guild guild) {
                Intrinsics3.checkNotNullParameter(boostSlotMap, "boostSlotMap");
                Intrinsics3.checkNotNullParameter(purchases, "purchases");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Loaded(boostSlotMap, premiumSubscription, purchases, meUser, guild);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.boostSlotMap, loaded.boostSlotMap) && Intrinsics3.areEqual(this.premiumSubscription, loaded.premiumSubscription) && Intrinsics3.areEqual(this.purchases, loaded.purchases) && Intrinsics3.areEqual(this.meUser, loaded.meUser) && Intrinsics3.areEqual(this.guild, loaded.guild);
            }

            public final Map<Long, ModelGuildBoostSlot> getBoostSlotMap() {
                return this.boostSlotMap;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final ModelSubscription getPremiumSubscription() {
                return this.premiumSubscription;
            }

            public final List<Purchase> getPurchases() {
                return this.purchases;
            }

            public int hashCode() {
                Map<Long, ModelGuildBoostSlot> map = this.boostSlotMap;
                int iHashCode = (map != null ? map.hashCode() : 0) * 31;
                ModelSubscription modelSubscription = this.premiumSubscription;
                int iHashCode2 = (iHashCode + (modelSubscription != null ? modelSubscription.hashCode() : 0)) * 31;
                List<Purchase> list = this.purchases;
                int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
                MeUser meUser = this.meUser;
                int iHashCode4 = (iHashCode3 + (meUser != null ? meUser.hashCode() : 0)) * 31;
                Guild guild = this.guild;
                return iHashCode4 + (guild != null ? guild.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(boostSlotMap=");
                sbU.append(this.boostSlotMap);
                sbU.append(", premiumSubscription=");
                sbU.append(this.premiumSubscription);
                sbU.append(", purchases=");
                sbU.append(this.purchases);
                sbU.append(", meUser=");
                sbU.append(this.meUser);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: GuildBoostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState$Loading;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ GuildBoostViewModel(long j, StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? StoreStream.INSTANCE.getGuildBoosts() : storeGuildBoost, (i & 4) != 0 ? StoreStream.INSTANCE.getSubscriptions() : storeSubscriptions, (i & 8) != 0 ? ClockFactory.get() : clock, (i & 16) != 0 ? Companion.access$observeStores(INSTANCE, j) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildBoostViewModel guildBoostViewModel, StoreState storeState) {
        guildBoostViewModel.handleStoreState(storeState);
    }

    private final void fetchData() {
        this.storeGuildBoost.fetchUserGuildBoostState();
        this.storeSubscriptions.fetchSubscriptions();
        GooglePlayBillingManager.INSTANCE.queryPurchases();
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        ViewState loaded;
        StoreGuildBoost.State guildBoostState = storeState.getGuildBoostState();
        StoreSubscriptions.SubscriptionsState subscriptionState = storeState.getSubscriptionState();
        StoreGooglePlayPurchases.State purchasesState = storeState.getPurchasesState();
        if ((guildBoostState instanceof StoreGuildBoost.State.Loading) || (subscriptionState instanceof StoreSubscriptions.SubscriptionsState.Loading) || (purchasesState instanceof StoreGooglePlayPurchases.State.Uninitialized)) {
            loaded = ViewState.Loading.INSTANCE;
        } else if ((guildBoostState instanceof StoreGuildBoost.State.Failure) || (subscriptionState instanceof StoreSubscriptions.SubscriptionsState.Failure) || !(guildBoostState instanceof StoreGuildBoost.State.Loaded) || !(subscriptionState instanceof StoreSubscriptions.SubscriptionsState.Loaded) || !(purchasesState instanceof StoreGooglePlayPurchases.State.Loaded)) {
            loaded = ViewState.Failure.INSTANCE;
        } else {
            if (storeState.getGuild() == null) {
                ViewState.Failure failure = ViewState.Failure.INSTANCE;
                return;
            }
            loaded = new ViewState.Loaded(((StoreGuildBoost.State.Loaded) guildBoostState).getBoostSlotMap(), ((StoreSubscriptions.SubscriptionsState.Loaded) subscriptionState).getPremiumSubscription(), ((StoreGooglePlayPurchases.State.Loaded) purchasesState).getPurchases(), storeState.getMeUser(), storeState.getGuild());
        }
        updateViewState(loaded);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void retryClicked() {
        fetchData();
    }

    @MainThread
    public final void subscribeClicked(String section) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(section, "section");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            Map<Long, ModelGuildBoostSlot> boostSlotMap = loaded.getBoostSlotMap();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map.Entry<Long, ModelGuildBoostSlot>> it = boostSlotMap.entrySet().iterator();
            while (true) {
                z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Long, ModelGuildBoostSlot> next = it.next();
                ModelGuildBoostSlot value = next.getValue();
                if (value.getCooldownExpiresAtTimestamp() < this.clock.currentTimeMillis()) {
                    ModelAppliedGuildBoost premiumGuildSubscription = value.getPremiumGuildSubscription();
                    if ((premiumGuildSubscription != null ? Long.valueOf(premiumGuildSubscription.getGuildId()) : null) == null) {
                        z2 = true;
                    }
                }
                if (z2) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            if (!linkedHashMap.isEmpty()) {
                this.eventSubject.k.onNext(new Event.LaunchSubscriptionConfirmation(loaded.getGuild().getId(), ((ModelGuildBoostSlot) _Collections.first(linkedHashMap.values())).getId()));
                return;
            }
            ModelSubscription premiumSubscription = loaded.getPremiumSubscription();
            if (premiumSubscription != null && !premiumSubscription.isGoogleSubscription()) {
                this.eventSubject.k.onNext(Event.ShowDesktopAlertDialog.INSTANCE);
                return;
            }
            if ((premiumSubscription != null ? premiumSubscription.getRenewalMutations() : null) != null) {
                this.eventSubject.k.onNext(new Event.ShowBlockedPlanSwitchAlertDialog(R.string.premium_guild_subscription_out_of_slots_title, R.string.premium_guild_subscription_out_of_slots_pending_plan_change));
                return;
            }
            if ((premiumSubscription != null ? premiumSubscription.getStatus() : null) == ModelSubscription.Status.CANCELED) {
                this.eventSubject.k.onNext(new Event.ShowBlockedPlanSwitchAlertDialog(R.string.premium_guild_subscription_out_of_slots_title, R.string.premium_guild_subscription_out_of_slots_canceled_subscription));
                return;
            }
            if ((premiumSubscription != null ? premiumSubscription.getStatus() : null) == ModelSubscription.Status.ACCOUNT_HOLD) {
                this.eventSubject.k.onNext(new Event.ShowBlockedPlanSwitchAlertDialog(R.string.premium_guild_subscription_out_of_slots_account_hold_title, R.string.premium_guild_subscription_out_of_slots_account_hold));
                return;
            }
            List<Purchase> purchases = loaded.getPurchases();
            if (!(purchases instanceof Collection) || !purchases.isEmpty()) {
                Iterator<T> it2 = purchases.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (!((Purchase) it2.next()).c()) {
                        z2 = true;
                        break;
                    }
                }
            }
            if (z2) {
                this.eventSubject.k.onNext(Event.UnacknowledgedPurchase.INSTANCE);
            } else {
                PublishSubject<Event> publishSubject = this.eventSubject;
                long id2 = loaded.getGuild().getId();
                ModelSubscription premiumSubscription2 = loaded.getPremiumSubscription();
                publishSubject.k.onNext(new Event.LaunchPurchaseSubscription(section, id2, premiumSubscription2 != null ? premiumSubscription2.getPaymentGatewayPlanId() : null));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostViewModel(long j, StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, Clock clock, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        Intrinsics3.checkNotNullParameter(storeSubscriptions, "storeSubscriptions");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.storeGuildBoost = storeGuildBoost;
        this.storeSubscriptions = storeSubscriptions;
        this.clock = clock;
        this.eventSubject = PublishSubject.k0();
        fetchData();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildBoostViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
