package com.discord.widgets.settings.guildboost;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.premium.PremiumTier;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.settings.guildboost.SettingsGuildBoostSampleGuildAdapter;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import rx.functions.Func4;

/* compiled from: SettingsGuildBoostViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00042345B+\u0012\b\b\u0002\u0010)\u001a\u00020(\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060.¢\u0006\u0004\b0\u00101J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\tJ?\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0017\u0010\u0005J#\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00182\n\u0010\u001a\u001a\u00060\rj\u0002`\u000eH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010!\u001a\u00020\u00032\n\u0010\u001e\u001a\u00060\rj\u0002`\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u00020\u00032\n\u0010\u001e\u001a\u00060\rj\u0002`\u001dH\u0007¢\u0006\u0004\b#\u0010$J\u001b\u0010&\u001a\u00020\u00032\n\u0010%\u001a\u00060\rj\u0002`\u000eH\u0007¢\u0006\u0004\b&\u0010$J\u000f\u0010'\u001a\u00020\u0003H\u0007¢\u0006\u0004\b'\u0010\u0005R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00066"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState;", "", "fetchData", "()V", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$StoreState;)V", "Lcom/discord/stores/StoreGuildBoost$State$Loaded;", "guildSubState", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "guilds", "Lcom/discord/models/domain/ModelSubscription;", Traits.Payment.Type.SUBSCRIPTION, "", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item;", "createGuildBoostItems", "(Lcom/discord/stores/StoreGuildBoost$State$Loaded;Ljava/util/Map;Lcom/discord/models/domain/ModelSubscription;)Ljava/util/List;", "retryClicked", "Lcom/discord/models/domain/ModelGuildBoostSlot;", "slot", "previousGuildId", "transferClicked", "(Lcom/discord/models/domain/ModelGuildBoostSlot;J)V", "Lcom/discord/primitives/GuildBoostSlotId;", "slotId", "", "cancel", "cancelClicked", "(JZ)V", "subscribeClicked", "(J)V", "guildId", "handleGuildSearchCallback", "consumePendingAction", "Lcom/discord/stores/StoreGuildBoost;", "storeGuildBoost", "Lcom/discord/stores/StoreGuildBoost;", "Lcom/discord/stores/StoreSubscriptions;", "storeSubscriptions", "Lcom/discord/stores/StoreSubscriptions;", "Lrx/Observable;", "storeObservable", "<init>", "(Lcom/discord/stores/StoreGuildBoost;Lcom/discord/stores/StoreSubscriptions;Lrx/Observable;)V", "Companion", "PendingAction", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SettingsGuildBoostViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int NUM_SAMPLE_GUILDS = 4;
    private static final Long UNUSED_GUILD_BOOST_GUILD_ID = null;
    private final StoreGuildBoost storeGuildBoost;
    private final StoreSubscriptions storeSubscriptions;

    /* compiled from: SettingsGuildBoostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.guildboost.SettingsGuildBoostViewModel$1, reason: invalid class name */
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
            SettingsGuildBoostViewModel.access$handleStoreState(SettingsGuildBoostViewModel.this, storeState);
        }
    }

    /* compiled from: SettingsGuildBoostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$Companion;", "", "Lrx/Observable;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$StoreState;", "observeStores", "()Lrx/Observable;", "", "NUM_SAMPLE_GUILDS", "I", "", "Lcom/discord/primitives/GuildId;", "UNUSED_GUILD_BOOST_GUILD_ID", "Ljava/lang/Long;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion) {
            return companion.observeStores();
        }

        private final Observable<StoreState> observeStores() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableObserveGuildBoostState$default = StoreGuildBoost.observeGuildBoostState$default(companion.getGuildBoosts(), null, 1, null);
            Observable<StoreSubscriptions.SubscriptionsState> observableObserveSubscriptions = companion.getSubscriptions().observeSubscriptions();
            Observable<LinkedHashMap<Long, Guild>> observableObserveOrderedGuilds = companion.getGuildsSorted().observeOrderedGuilds();
            Observable observableR = StoreUser.observeMe$default(companion.getUsers(), false, 1, null).G(SettingsGuildBoostViewModel2.INSTANCE).r();
            SettingsGuildBoostViewModel3 settingsGuildBoostViewModel3 = SettingsGuildBoostViewModel3.INSTANCE;
            Object settingsGuildBoostViewModel4 = settingsGuildBoostViewModel3;
            if (settingsGuildBoostViewModel3 != null) {
                settingsGuildBoostViewModel4 = new SettingsGuildBoostViewModel4(settingsGuildBoostViewModel3);
            }
            Observable<StoreState> observableH = Observable.h(observableObserveGuildBoostState$default, observableObserveSubscriptions, observableObserveOrderedGuilds, observableR, (Func4) settingsGuildBoostViewModel4);
            Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…     ::StoreState\n      )");
            return observableH;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SettingsGuildBoostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction;", "", "<init>", "()V", "Cancel", "Subscribe", "Transfer", "Uncancel", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction$Transfer;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction$Subscribe;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction$Cancel;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction$Uncancel;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class PendingAction {

        /* compiled from: SettingsGuildBoostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction$Cancel;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction;", "", "Lcom/discord/primitives/GuildBoostSlotId;", "component1", "()J", "slotId", "copy", "(J)Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction$Cancel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getSlotId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Cancel extends PendingAction {
            private final long slotId;

            public Cancel(long j) {
                super(null);
                this.slotId = j;
            }

            public static /* synthetic */ Cancel copy$default(Cancel cancel, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = cancel.slotId;
                }
                return cancel.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getSlotId() {
                return this.slotId;
            }

            public final Cancel copy(long slotId) {
                return new Cancel(slotId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Cancel) && this.slotId == ((Cancel) other).slotId;
                }
                return true;
            }

            public final long getSlotId() {
                return this.slotId;
            }

            public int hashCode() {
                return b.a(this.slotId);
            }

            public String toString() {
                return outline.C(outline.U("Cancel(slotId="), this.slotId, ")");
            }
        }

        /* compiled from: SettingsGuildBoostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R!\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction$Subscribe;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction;", "", "Lcom/discord/primitives/GuildBoostSlotId;", "component1", "()J", "Lcom/discord/primitives/GuildId;", "component2", "()Ljava/lang/Long;", "slotId", "targetGuildId", "copy", "(JLjava/lang/Long;)Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction$Subscribe;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getSlotId", "Ljava/lang/Long;", "getTargetGuildId", "<init>", "(JLjava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Subscribe extends PendingAction {
            private final long slotId;
            private final Long targetGuildId;

            public /* synthetic */ Subscribe(long j, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(j, (i & 2) != 0 ? null : l);
            }

            public static /* synthetic */ Subscribe copy$default(Subscribe subscribe, long j, Long l, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = subscribe.slotId;
                }
                if ((i & 2) != 0) {
                    l = subscribe.targetGuildId;
                }
                return subscribe.copy(j, l);
            }

            /* renamed from: component1, reason: from getter */
            public final long getSlotId() {
                return this.slotId;
            }

            /* renamed from: component2, reason: from getter */
            public final Long getTargetGuildId() {
                return this.targetGuildId;
            }

            public final Subscribe copy(long slotId, Long targetGuildId) {
                return new Subscribe(slotId, targetGuildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Subscribe)) {
                    return false;
                }
                Subscribe subscribe = (Subscribe) other;
                return this.slotId == subscribe.slotId && Intrinsics3.areEqual(this.targetGuildId, subscribe.targetGuildId);
            }

            public final long getSlotId() {
                return this.slotId;
            }

            public final Long getTargetGuildId() {
                return this.targetGuildId;
            }

            public int hashCode() {
                int iA = b.a(this.slotId) * 31;
                Long l = this.targetGuildId;
                return iA + (l != null ? l.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Subscribe(slotId=");
                sbU.append(this.slotId);
                sbU.append(", targetGuildId=");
                return outline.G(sbU, this.targetGuildId, ")");
            }

            public Subscribe(long j, Long l) {
                super(null);
                this.slotId = j;
                this.targetGuildId = l;
            }
        }

        /* compiled from: SettingsGuildBoostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\u0010\f\u001a\u00060\u0005j\u0002`\u0006\u0012\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\f\b\u0002\u0010\f\u001a\u00060\u0005j\u0002`\u00062\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR!\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u001d\u0010\f\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction$Transfer;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction;", "Lcom/discord/models/domain/ModelGuildBoostSlot;", "component1", "()Lcom/discord/models/domain/ModelGuildBoostSlot;", "", "Lcom/discord/primitives/GuildId;", "component2", "()J", "component3", "()Ljava/lang/Long;", "slot", "previousGuildId", "targetGuildId", "copy", "(Lcom/discord/models/domain/ModelGuildBoostSlot;JLjava/lang/Long;)Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction$Transfer;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getTargetGuildId", "J", "getPreviousGuildId", "Lcom/discord/models/domain/ModelGuildBoostSlot;", "getSlot", "<init>", "(Lcom/discord/models/domain/ModelGuildBoostSlot;JLjava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Transfer extends PendingAction {
            private final long previousGuildId;
            private final ModelGuildBoostSlot slot;
            private final Long targetGuildId;

            public /* synthetic */ Transfer(ModelGuildBoostSlot modelGuildBoostSlot, long j, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(modelGuildBoostSlot, j, (i & 4) != 0 ? null : l);
            }

            public static /* synthetic */ Transfer copy$default(Transfer transfer, ModelGuildBoostSlot modelGuildBoostSlot, long j, Long l, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildBoostSlot = transfer.slot;
                }
                if ((i & 2) != 0) {
                    j = transfer.previousGuildId;
                }
                if ((i & 4) != 0) {
                    l = transfer.targetGuildId;
                }
                return transfer.copy(modelGuildBoostSlot, j, l);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelGuildBoostSlot getSlot() {
                return this.slot;
            }

            /* renamed from: component2, reason: from getter */
            public final long getPreviousGuildId() {
                return this.previousGuildId;
            }

            /* renamed from: component3, reason: from getter */
            public final Long getTargetGuildId() {
                return this.targetGuildId;
            }

            public final Transfer copy(ModelGuildBoostSlot slot, long previousGuildId, Long targetGuildId) {
                Intrinsics3.checkNotNullParameter(slot, "slot");
                return new Transfer(slot, previousGuildId, targetGuildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Transfer)) {
                    return false;
                }
                Transfer transfer = (Transfer) other;
                return Intrinsics3.areEqual(this.slot, transfer.slot) && this.previousGuildId == transfer.previousGuildId && Intrinsics3.areEqual(this.targetGuildId, transfer.targetGuildId);
            }

            public final long getPreviousGuildId() {
                return this.previousGuildId;
            }

            public final ModelGuildBoostSlot getSlot() {
                return this.slot;
            }

            public final Long getTargetGuildId() {
                return this.targetGuildId;
            }

            public int hashCode() {
                ModelGuildBoostSlot modelGuildBoostSlot = this.slot;
                int iA = (b.a(this.previousGuildId) + ((modelGuildBoostSlot != null ? modelGuildBoostSlot.hashCode() : 0) * 31)) * 31;
                Long l = this.targetGuildId;
                return iA + (l != null ? l.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Transfer(slot=");
                sbU.append(this.slot);
                sbU.append(", previousGuildId=");
                sbU.append(this.previousGuildId);
                sbU.append(", targetGuildId=");
                return outline.G(sbU, this.targetGuildId, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Transfer(ModelGuildBoostSlot modelGuildBoostSlot, long j, Long l) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGuildBoostSlot, "slot");
                this.slot = modelGuildBoostSlot;
                this.previousGuildId = j;
                this.targetGuildId = l;
            }
        }

        /* compiled from: SettingsGuildBoostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction$Uncancel;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction;", "", "Lcom/discord/primitives/GuildBoostSlotId;", "component1", "()J", "slotId", "copy", "(J)Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction$Uncancel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getSlotId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Uncancel extends PendingAction {
            private final long slotId;

            public Uncancel(long j) {
                super(null);
                this.slotId = j;
            }

            public static /* synthetic */ Uncancel copy$default(Uncancel uncancel, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = uncancel.slotId;
                }
                return uncancel.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getSlotId() {
                return this.slotId;
            }

            public final Uncancel copy(long slotId) {
                return new Uncancel(slotId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Uncancel) && this.slotId == ((Uncancel) other).slotId;
                }
                return true;
            }

            public final long getSlotId() {
                return this.slotId;
            }

            public int hashCode() {
                return b.a(this.slotId);
            }

            public String toString() {
                return outline.C(outline.U("Uncancel(slotId="), this.slotId, ")");
            }
        }

        private PendingAction() {
        }

        public /* synthetic */ PendingAction(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SettingsGuildBoostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0016\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0006\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JH\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b2\b\b\u0002\u0010\u0014\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u0007R)\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\r¨\u0006+"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$StoreState;", "", "Lcom/discord/stores/StoreGuildBoost$State;", "component1", "()Lcom/discord/stores/StoreGuildBoost$State;", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "component2", "()Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "component3", "()Ljava/util/Map;", "Lcom/discord/api/premium/PremiumTier;", "component4", "()Lcom/discord/api/premium/PremiumTier;", "guildBoostState", "subscriptionState", "guilds", "userPremiumTier", "copy", "(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Ljava/util/Map;Lcom/discord/api/premium/PremiumTier;)Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/premium/PremiumTier;", "getUserPremiumTier", "Lcom/discord/stores/StoreGuildBoost$State;", "getGuildBoostState", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "getSubscriptionState", "Ljava/util/Map;", "getGuilds", "<init>", "(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Ljava/util/Map;Lcom/discord/api/premium/PremiumTier;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final StoreGuildBoost.State guildBoostState;
        private final Map<Long, Guild> guilds;
        private final StoreSubscriptions.SubscriptionsState subscriptionState;
        private final PremiumTier userPremiumTier;

        public StoreState(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, Map<Long, Guild> map, PremiumTier premiumTier) {
            Intrinsics3.checkNotNullParameter(state, "guildBoostState");
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionState");
            Intrinsics3.checkNotNullParameter(map, "guilds");
            Intrinsics3.checkNotNullParameter(premiumTier, "userPremiumTier");
            this.guildBoostState = state;
            this.subscriptionState = subscriptionsState;
            this.guilds = map;
            this.userPremiumTier = premiumTier;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, Map map, PremiumTier premiumTier, int i, Object obj) {
            if ((i & 1) != 0) {
                state = storeState.guildBoostState;
            }
            if ((i & 2) != 0) {
                subscriptionsState = storeState.subscriptionState;
            }
            if ((i & 4) != 0) {
                map = storeState.guilds;
            }
            if ((i & 8) != 0) {
                premiumTier = storeState.userPremiumTier;
            }
            return storeState.copy(state, subscriptionsState, map, premiumTier);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        /* renamed from: component2, reason: from getter */
        public final StoreSubscriptions.SubscriptionsState getSubscriptionState() {
            return this.subscriptionState;
        }

        public final Map<Long, Guild> component3() {
            return this.guilds;
        }

        /* renamed from: component4, reason: from getter */
        public final PremiumTier getUserPremiumTier() {
            return this.userPremiumTier;
        }

        public final StoreState copy(StoreGuildBoost.State guildBoostState, StoreSubscriptions.SubscriptionsState subscriptionState, Map<Long, Guild> guilds, PremiumTier userPremiumTier) {
            Intrinsics3.checkNotNullParameter(guildBoostState, "guildBoostState");
            Intrinsics3.checkNotNullParameter(subscriptionState, "subscriptionState");
            Intrinsics3.checkNotNullParameter(guilds, "guilds");
            Intrinsics3.checkNotNullParameter(userPremiumTier, "userPremiumTier");
            return new StoreState(guildBoostState, subscriptionState, guilds, userPremiumTier);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guildBoostState, storeState.guildBoostState) && Intrinsics3.areEqual(this.subscriptionState, storeState.subscriptionState) && Intrinsics3.areEqual(this.guilds, storeState.guilds) && Intrinsics3.areEqual(this.userPremiumTier, storeState.userPremiumTier);
        }

        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        public final Map<Long, Guild> getGuilds() {
            return this.guilds;
        }

        public final StoreSubscriptions.SubscriptionsState getSubscriptionState() {
            return this.subscriptionState;
        }

        public final PremiumTier getUserPremiumTier() {
            return this.userPremiumTier;
        }

        public int hashCode() {
            StoreGuildBoost.State state = this.guildBoostState;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.subscriptionState;
            int iHashCode2 = (iHashCode + (subscriptionsState != null ? subscriptionsState.hashCode() : 0)) * 31;
            Map<Long, Guild> map = this.guilds;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            PremiumTier premiumTier = this.userPremiumTier;
            return iHashCode3 + (premiumTier != null ? premiumTier.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildBoostState=");
            sbU.append(this.guildBoostState);
            sbU.append(", subscriptionState=");
            sbU.append(this.subscriptionState);
            sbU.append(", guilds=");
            sbU.append(this.guilds);
            sbU.append(", userPremiumTier=");
            sbU.append(this.userPremiumTier);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: SettingsGuildBoostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState;", "", "<init>", "()V", "Failure", "Loaded", "Loading", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState$Loaded;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState$Loading;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState$Failure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: SettingsGuildBoostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState$Failure;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends ViewState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: SettingsGuildBoostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JZ\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0017\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b%\u0010\u0011R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010\u000eR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010\u0004R\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010\tR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b,\u0010\u0004R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b-\u0010\t¨\u00060"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState$Loaded;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState;", "", "component1", "()Z", "component2", "", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item;", "component3", "()Ljava/util/List;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostSampleGuildAdapter$Item;", "component4", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction;", "component5", "()Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction;", "Lcom/discord/api/premium/PremiumTier;", "component6", "()Lcom/discord/api/premium/PremiumTier;", "canCancelBoosts", "canUncancelBoosts", "guildBoostItems", "sampleGuildItems", "pendingAction", "userPremiumTier", "copy", "(ZZLjava/util/List;Ljava/util/List;Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction;Lcom/discord/api/premium/PremiumTier;)Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/premium/PremiumTier;", "getUserPremiumTier", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction;", "getPendingAction", "Z", "getCanUncancelBoosts", "Ljava/util/List;", "getSampleGuildItems", "getCanCancelBoosts", "getGuildBoostItems", "<init>", "(ZZLjava/util/List;Ljava/util/List;Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$PendingAction;Lcom/discord/api/premium/PremiumTier;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final boolean canCancelBoosts;
            private final boolean canUncancelBoosts;
            private final List<WidgetSettingsGuildBoostSubscriptionAdapter.Item> guildBoostItems;
            private final PendingAction pendingAction;
            private final List<SettingsGuildBoostSampleGuildAdapter.Item> sampleGuildItems;
            private final PremiumTier userPremiumTier;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(boolean z2, boolean z3, List<? extends WidgetSettingsGuildBoostSubscriptionAdapter.Item> list, List<SettingsGuildBoostSampleGuildAdapter.Item> list2, PendingAction pendingAction, PremiumTier premiumTier) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "guildBoostItems");
                Intrinsics3.checkNotNullParameter(list2, "sampleGuildItems");
                Intrinsics3.checkNotNullParameter(premiumTier, "userPremiumTier");
                this.canCancelBoosts = z2;
                this.canUncancelBoosts = z3;
                this.guildBoostItems = list;
                this.sampleGuildItems = list2;
                this.pendingAction = pendingAction;
                this.userPremiumTier = premiumTier;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, boolean z2, boolean z3, List list, List list2, PendingAction pendingAction, PremiumTier premiumTier, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = loaded.canCancelBoosts;
                }
                if ((i & 2) != 0) {
                    z3 = loaded.canUncancelBoosts;
                }
                boolean z4 = z3;
                if ((i & 4) != 0) {
                    list = loaded.guildBoostItems;
                }
                List list3 = list;
                if ((i & 8) != 0) {
                    list2 = loaded.sampleGuildItems;
                }
                List list4 = list2;
                if ((i & 16) != 0) {
                    pendingAction = loaded.pendingAction;
                }
                PendingAction pendingAction2 = pendingAction;
                if ((i & 32) != 0) {
                    premiumTier = loaded.userPremiumTier;
                }
                return loaded.copy(z2, z4, list3, list4, pendingAction2, premiumTier);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getCanCancelBoosts() {
                return this.canCancelBoosts;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getCanUncancelBoosts() {
                return this.canUncancelBoosts;
            }

            public final List<WidgetSettingsGuildBoostSubscriptionAdapter.Item> component3() {
                return this.guildBoostItems;
            }

            public final List<SettingsGuildBoostSampleGuildAdapter.Item> component4() {
                return this.sampleGuildItems;
            }

            /* renamed from: component5, reason: from getter */
            public final PendingAction getPendingAction() {
                return this.pendingAction;
            }

            /* renamed from: component6, reason: from getter */
            public final PremiumTier getUserPremiumTier() {
                return this.userPremiumTier;
            }

            public final Loaded copy(boolean canCancelBoosts, boolean canUncancelBoosts, List<? extends WidgetSettingsGuildBoostSubscriptionAdapter.Item> guildBoostItems, List<SettingsGuildBoostSampleGuildAdapter.Item> sampleGuildItems, PendingAction pendingAction, PremiumTier userPremiumTier) {
                Intrinsics3.checkNotNullParameter(guildBoostItems, "guildBoostItems");
                Intrinsics3.checkNotNullParameter(sampleGuildItems, "sampleGuildItems");
                Intrinsics3.checkNotNullParameter(userPremiumTier, "userPremiumTier");
                return new Loaded(canCancelBoosts, canUncancelBoosts, guildBoostItems, sampleGuildItems, pendingAction, userPremiumTier);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.canCancelBoosts == loaded.canCancelBoosts && this.canUncancelBoosts == loaded.canUncancelBoosts && Intrinsics3.areEqual(this.guildBoostItems, loaded.guildBoostItems) && Intrinsics3.areEqual(this.sampleGuildItems, loaded.sampleGuildItems) && Intrinsics3.areEqual(this.pendingAction, loaded.pendingAction) && Intrinsics3.areEqual(this.userPremiumTier, loaded.userPremiumTier);
            }

            public final boolean getCanCancelBoosts() {
                return this.canCancelBoosts;
            }

            public final boolean getCanUncancelBoosts() {
                return this.canUncancelBoosts;
            }

            public final List<WidgetSettingsGuildBoostSubscriptionAdapter.Item> getGuildBoostItems() {
                return this.guildBoostItems;
            }

            public final PendingAction getPendingAction() {
                return this.pendingAction;
            }

            public final List<SettingsGuildBoostSampleGuildAdapter.Item> getSampleGuildItems() {
                return this.sampleGuildItems;
            }

            public final PremiumTier getUserPremiumTier() {
                return this.userPremiumTier;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v12 */
            /* JADX WARN: Type inference failed for: r0v13 */
            public int hashCode() {
                boolean z2 = this.canCancelBoosts;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean z3 = this.canUncancelBoosts;
                int i2 = (i + (z3 ? 1 : z3 ? 1 : 0)) * 31;
                List<WidgetSettingsGuildBoostSubscriptionAdapter.Item> list = this.guildBoostItems;
                int iHashCode = (i2 + (list != null ? list.hashCode() : 0)) * 31;
                List<SettingsGuildBoostSampleGuildAdapter.Item> list2 = this.sampleGuildItems;
                int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
                PendingAction pendingAction = this.pendingAction;
                int iHashCode3 = (iHashCode2 + (pendingAction != null ? pendingAction.hashCode() : 0)) * 31;
                PremiumTier premiumTier = this.userPremiumTier;
                return iHashCode3 + (premiumTier != null ? premiumTier.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(canCancelBoosts=");
                sbU.append(this.canCancelBoosts);
                sbU.append(", canUncancelBoosts=");
                sbU.append(this.canUncancelBoosts);
                sbU.append(", guildBoostItems=");
                sbU.append(this.guildBoostItems);
                sbU.append(", sampleGuildItems=");
                sbU.append(this.sampleGuildItems);
                sbU.append(", pendingAction=");
                sbU.append(this.pendingAction);
                sbU.append(", userPremiumTier=");
                sbU.append(this.userPremiumTier);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: SettingsGuildBoostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState$Loading;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    public SettingsGuildBoostViewModel() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ SettingsGuildBoostViewModel(StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getGuildBoosts() : storeGuildBoost, (i & 2) != 0 ? StoreStream.INSTANCE.getSubscriptions() : storeSubscriptions, (i & 4) != 0 ? Companion.access$observeStores(INSTANCE) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(SettingsGuildBoostViewModel settingsGuildBoostViewModel, StoreState storeState) {
        settingsGuildBoostViewModel.handleStoreState(storeState);
    }

    private final List<WidgetSettingsGuildBoostSubscriptionAdapter.Item> createGuildBoostItems(StoreGuildBoost.State.Loaded guildSubState, Map<Long, Guild> guilds, ModelSubscription subscription) {
        Collection<ModelGuildBoostSlot> collectionValues = guildSubState.getBoostSlotMap().values();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ModelGuildBoostSlot modelGuildBoostSlot = (ModelGuildBoostSlot) it.next();
            ModelAppliedGuildBoost premiumGuildSubscription = modelGuildBoostSlot.getPremiumGuildSubscription();
            Long lValueOf = premiumGuildSubscription != null ? Long.valueOf(premiumGuildSubscription.getGuildId()) : null;
            Object arrayList2 = map.get(lValueOf);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
            }
            ((ArrayList) arrayList2).add(modelGuildBoostSlot);
            map.put(lValueOf, arrayList2);
        }
        ArrayList arrayList3 = (ArrayList) map.remove(UNUSED_GUILD_BOOST_GUILD_ID);
        if (arrayList3 != null) {
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList.add(new WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem((ModelGuildBoostSlot) it2.next(), subscription != null ? subscription.getCurrentPeriodEnd() : null));
            }
        }
        if (!map.isEmpty()) {
            arrayList.add(new WidgetSettingsGuildBoostSubscriptionAdapter.Item.HeaderItem(R.string.premium_guild_subscription_active_title));
        }
        for (Map.Entry entry : map.entrySet()) {
            Long l = (Long) entry.getKey();
            ArrayList arrayList4 = (ArrayList) entry.getValue();
            Guild guild = guilds.get(l);
            if (l != null && guild != null) {
                arrayList.add(new WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildItem(guild, arrayList4.size()));
                Iterator it3 = arrayList4.iterator();
                while (it3.hasNext()) {
                    arrayList.add(new WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem((ModelGuildBoostSlot) it3.next(), subscription != null ? subscription.getCurrentPeriodEnd() : null));
                }
            }
        }
        return arrayList;
    }

    private final void fetchData() {
        this.storeGuildBoost.fetchUserGuildBoostState();
        this.storeSubscriptions.fetchSubscriptions();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bc A[LOOP:0: B:41:0x00b6->B:43:0x00bc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00db  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleStoreState(StoreState storeState) {
        Object loaded;
        boolean z2;
        SubscriptionPlanType planType;
        Iterator it;
        SubscriptionPlanType planType2;
        StoreGuildBoost.State guildBoostState = storeState.getGuildBoostState();
        StoreSubscriptions.SubscriptionsState subscriptionState = storeState.getSubscriptionState();
        if ((guildBoostState instanceof StoreGuildBoost.State.Loading) || (subscriptionState instanceof StoreSubscriptions.SubscriptionsState.Loading)) {
            loaded = ViewState.Loading.INSTANCE;
        } else if ((guildBoostState instanceof StoreGuildBoost.State.Failure) || (subscriptionState instanceof StoreSubscriptions.SubscriptionsState.Failure) || !(guildBoostState instanceof StoreGuildBoost.State.Loaded) || !(subscriptionState instanceof StoreSubscriptions.SubscriptionsState.Loaded)) {
            loaded = ViewState.Failure.INSTANCE;
        } else {
            ModelSubscription premiumSubscription = ((StoreSubscriptions.SubscriptionsState.Loaded) subscriptionState).getPremiumSubscription();
            boolean z3 = premiumSubscription != null && premiumSubscription.isGoogleSubscription();
            if (!z3) {
                if (((premiumSubscription == null || (planType = premiumSubscription.getPlanType()) == null) ? null : planType.getPremiumTier()) == PremiumTier.TIER_2) {
                    Map<Long, ModelGuildBoostSlot> boostSlotMap = ((StoreGuildBoost.State.Loaded) guildBoostState).getBoostSlotMap();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<Long, ModelGuildBoostSlot> entry : boostSlotMap.entrySet()) {
                        if (!entry.getValue().getCanceled()) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    if (linkedHashMap.size() <= 2) {
                        z2 = false;
                    }
                    boolean z4 = !z3;
                    List<WidgetSettingsGuildBoostSubscriptionAdapter.Item> listCreateGuildBoostItems = createGuildBoostItems((StoreGuildBoost.State.Loaded) guildBoostState, storeState.getGuilds(), premiumSubscription);
                    List listTake = _Collections.take(storeState.getGuilds().values(), 4);
                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listTake, 10));
                    it = listTake.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new SettingsGuildBoostSampleGuildAdapter.Item((Guild) it.next()));
                    }
                    if (premiumSubscription != null || (planType2 = premiumSubscription.getPlanType()) == null || (premiumTier = planType2.getPremiumTier()) == null) {
                        PremiumTier premiumTier = PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY;
                    }
                    loaded = new ViewState.Loaded(z2, z4, listCreateGuildBoostItems, arrayList, null, premiumTier);
                }
                z2 = true;
                boolean z42 = !z3;
                List<WidgetSettingsGuildBoostSubscriptionAdapter.Item> listCreateGuildBoostItems2 = createGuildBoostItems((StoreGuildBoost.State.Loaded) guildBoostState, storeState.getGuilds(), premiumSubscription);
                List listTake2 = _Collections.take(storeState.getGuilds().values(), 4);
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listTake2, 10));
                it = listTake2.iterator();
                while (it.hasNext()) {
                }
                if (premiumSubscription != null) {
                    PremiumTier premiumTier2 = PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY;
                    loaded = new ViewState.Loaded(z2, z42, listCreateGuildBoostItems2, arrayList2, null, premiumTier2);
                }
            }
        }
        updateViewState(loaded);
    }

    @MainThread
    public final void cancelClicked(long slotId, boolean cancel) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, null, null, cancel ? new PendingAction.Cancel(slotId) : new PendingAction.Uncancel(slotId), null, 47, null));
        }
    }

    @MainThread
    public final void consumePendingAction() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, null, null, null, null, 47, null));
        }
    }

    @MainThread
    public final void handleGuildSearchCallback(long guildId) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            PendingAction pendingAction = loaded.getPendingAction();
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, null, null, pendingAction instanceof PendingAction.Transfer ? PendingAction.Transfer.copy$default((PendingAction.Transfer) loaded.getPendingAction(), null, 0L, Long.valueOf(guildId), 3, null) : pendingAction instanceof PendingAction.Subscribe ? PendingAction.Subscribe.copy$default((PendingAction.Subscribe) loaded.getPendingAction(), 0L, Long.valueOf(guildId), 1, null) : loaded.getPendingAction(), null, 47, null));
        }
    }

    @MainThread
    public final void retryClicked() {
        fetchData();
    }

    @MainThread
    public final void subscribeClicked(long slotId) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, null, null, new PendingAction.Subscribe(slotId, null, 2, null), null, 47, null));
        }
    }

    @MainThread
    public final void transferClicked(ModelGuildBoostSlot slot, long previousGuildId) {
        Intrinsics3.checkNotNullParameter(slot, "slot");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, null, null, new PendingAction.Transfer(slot, previousGuildId, null, 4, null), null, 47, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGuildBoostViewModel(StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        Intrinsics3.checkNotNullParameter(storeSubscriptions, "storeSubscriptions");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.storeGuildBoost = storeGuildBoost;
        this.storeSubscriptions = storeSubscriptions;
        fetchData();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), SettingsGuildBoostViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
