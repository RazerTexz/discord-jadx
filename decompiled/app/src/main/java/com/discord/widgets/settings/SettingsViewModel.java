package com.discord.widgets.settings;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.FrameMetricsAggregator;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNotificationUpsells;
import com.discord.stores.StoreOutboundPromotions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.handoff.MobileWebHandoff;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: SettingsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003#$%Bg\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001f¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006&"}, d2 = {"Lcom/discord/widgets/settings/SettingsViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/settings/SettingsViewModel$ViewState;", "Lcom/discord/widgets/settings/SettingsViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/settings/SettingsViewModel$StoreState;)V", "refreshSubscriptions", "()V", "Landroid/content/Context;", "context", "openRoleSubscriptionsManagement", "(Landroid/content/Context;)V", "Lcom/discord/stores/StoreSubscriptions;", "subscriptionsStore", "Lcom/discord/stores/StoreSubscriptions;", "Lcom/discord/stores/StoreExperiments;", "experimentsStore", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreNotificationUpsells;", "notificationUpsellsStore", "Lcom/discord/stores/StoreOutboundPromotions;", "outboundPromotionsStore", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUserPresence;", "userPresenceStore", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lrx/Observable;", "storeStateObservable", "<init>", "(Lcom/discord/stores/StoreExperiments;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreNotificationUpsells;Lcom/discord/stores/StoreOutboundPromotions;Lcom/discord/stores/StoreSubscriptions;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreUserPresence;Lcom/discord/stores/updates/ObservationDeck;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SettingsViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String MANAGE_SUBSCRIPTIONS_URL = "/settings/subscriptions/role-subscriptions";
    private final StoreSubscriptions subscriptionsStore;

    /* compiled from: SettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/settings/SettingsViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Lcom/discord/widgets/settings/SettingsViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.SettingsViewModel$1, reason: invalid class name */
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
            SettingsViewModel settingsViewModel = SettingsViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            SettingsViewModel.access$handleStoreState(settingsViewModel, storeState);
        }
    }

    /* compiled from: SettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJU\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u0017*\u00020\u00168B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/settings/SettingsViewModel$Companion;", "", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreUserPresence;", "userPresenceStore", "Lcom/discord/stores/StoreOutboundPromotions;", "outboundPromotionsStore", "Lcom/discord/stores/StoreNotificationUpsells;", "notificationUpsellsStore", "Lcom/discord/stores/StoreExperiments;", "experimentsStore", "Lcom/discord/stores/StoreSubscriptions;", "subscriptionsStore", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lrx/Observable;", "Lcom/discord/widgets/settings/SettingsViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUserPresence;Lcom/discord/stores/StoreOutboundPromotions;Lcom/discord/stores/StoreNotificationUpsells;Lcom/discord/stores/StoreExperiments;Lcom/discord/stores/StoreSubscriptions;Lcom/discord/stores/updates/ObservationDeck;)Lrx/Observable;", "Lcom/discord/models/domain/ModelSubscription;", "", "isActiveGuildSubscription", "(Lcom/discord/models/domain/ModelSubscription;)Z", "", "MANAGE_SUBSCRIPTIONS_URL", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ boolean access$isActiveGuildSubscription$p(Companion companion, ModelSubscription modelSubscription) {
            return companion.isActiveGuildSubscription(modelSubscription);
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StoreOutboundPromotions storeOutboundPromotions, StoreNotificationUpsells storeNotificationUpsells, StoreExperiments storeExperiments, StoreSubscriptions storeSubscriptions, ObservationDeck observationDeck) {
            return companion.observeStoreState(storeUser, storeGuilds, storeUserPresence, storeOutboundPromotions, storeNotificationUpsells, storeExperiments, storeSubscriptions, observationDeck);
        }

        private final boolean isActiveGuildSubscription(ModelSubscription modelSubscription) {
            return modelSubscription.getType() == ModelSubscription.Type.GUILD && modelSubscription.getStatus() != ModelSubscription.Status.ENDED;
        }

        private final Observable<StoreState> observeStoreState(StoreUser userStore, StoreGuilds guildsStore, StoreUserPresence userPresenceStore, StoreOutboundPromotions outboundPromotionsStore, StoreNotificationUpsells notificationUpsellsStore, StoreExperiments experimentsStore, StoreSubscriptions subscriptionsStore, ObservationDeck observationDeck) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{userStore, guildsStore, userPresenceStore, outboundPromotionsStore, notificationUpsellsStore, subscriptionsStore}, false, null, null, new SettingsViewModel2(subscriptionsStore, userStore, guildsStore, userPresenceStore, outboundPromotionsStore, notificationUpsellsStore, experimentsStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J^\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b \u0010\rJ\u001a\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0018\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b%\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\rR\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\nR\u0019\u0010\u0019\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010\u0004R!\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b-\u0010\u0013¨\u00060"}, d2 = {"Lcom/discord/widgets/settings/SettingsViewModel$StoreState;", "", "Lcom/discord/models/user/MeUser;", "component1", "()Lcom/discord/models/user/MeUser;", "", "component2", "()Z", "Lcom/discord/models/presence/Presence;", "component3", "()Lcom/discord/models/presence/Presence;", "", "component4", "()I", "component5", "component6", "", "Lcom/discord/models/domain/ModelSubscription;", "component7", "()Ljava/util/List;", "meUser", "isStaffOrAlpha", "presence", "promoCount", "pushNotificationUpsellDismissed", "isEligibleForMobileWebSubscriptions", "subscriptions", "copy", "(Lcom/discord/models/user/MeUser;ZLcom/discord/models/presence/Presence;IZZLjava/util/List;)Lcom/discord/widgets/settings/SettingsViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getPushNotificationUpsellDismissed", "I", "getPromoCount", "Lcom/discord/models/presence/Presence;", "getPresence", "Lcom/discord/models/user/MeUser;", "getMeUser", "Ljava/util/List;", "getSubscriptions", "<init>", "(Lcom/discord/models/user/MeUser;ZLcom/discord/models/presence/Presence;IZZLjava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final boolean isEligibleForMobileWebSubscriptions;
        private final boolean isStaffOrAlpha;
        private final MeUser meUser;
        private final Presence presence;
        private final int promoCount;
        private final boolean pushNotificationUpsellDismissed;
        private final List<ModelSubscription> subscriptions;

        public StoreState(MeUser meUser, boolean z2, Presence presence, int i, boolean z3, boolean z4, List<ModelSubscription> list) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(presence, "presence");
            this.meUser = meUser;
            this.isStaffOrAlpha = z2;
            this.presence = presence;
            this.promoCount = i;
            this.pushNotificationUpsellDismissed = z3;
            this.isEligibleForMobileWebSubscriptions = z4;
            this.subscriptions = list;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, MeUser meUser, boolean z2, Presence presence, int i, boolean z3, boolean z4, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                meUser = storeState.meUser;
            }
            if ((i2 & 2) != 0) {
                z2 = storeState.isStaffOrAlpha;
            }
            boolean z5 = z2;
            if ((i2 & 4) != 0) {
                presence = storeState.presence;
            }
            Presence presence2 = presence;
            if ((i2 & 8) != 0) {
                i = storeState.promoCount;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                z3 = storeState.pushNotificationUpsellDismissed;
            }
            boolean z6 = z3;
            if ((i2 & 32) != 0) {
                z4 = storeState.isEligibleForMobileWebSubscriptions;
            }
            boolean z7 = z4;
            if ((i2 & 64) != 0) {
                list = storeState.subscriptions;
            }
            return storeState.copy(meUser, z5, presence2, i3, z6, z7, list);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsStaffOrAlpha() {
            return this.isStaffOrAlpha;
        }

        /* renamed from: component3, reason: from getter */
        public final Presence getPresence() {
            return this.presence;
        }

        /* renamed from: component4, reason: from getter */
        public final int getPromoCount() {
            return this.promoCount;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getPushNotificationUpsellDismissed() {
            return this.pushNotificationUpsellDismissed;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsEligibleForMobileWebSubscriptions() {
            return this.isEligibleForMobileWebSubscriptions;
        }

        public final List<ModelSubscription> component7() {
            return this.subscriptions;
        }

        public final StoreState copy(MeUser meUser, boolean isStaffOrAlpha, Presence presence, int promoCount, boolean pushNotificationUpsellDismissed, boolean isEligibleForMobileWebSubscriptions, List<ModelSubscription> subscriptions) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(presence, "presence");
            return new StoreState(meUser, isStaffOrAlpha, presence, promoCount, pushNotificationUpsellDismissed, isEligibleForMobileWebSubscriptions, subscriptions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.meUser, storeState.meUser) && this.isStaffOrAlpha == storeState.isStaffOrAlpha && Intrinsics3.areEqual(this.presence, storeState.presence) && this.promoCount == storeState.promoCount && this.pushNotificationUpsellDismissed == storeState.pushNotificationUpsellDismissed && this.isEligibleForMobileWebSubscriptions == storeState.isEligibleForMobileWebSubscriptions && Intrinsics3.areEqual(this.subscriptions, storeState.subscriptions);
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final Presence getPresence() {
            return this.presence;
        }

        public final int getPromoCount() {
            return this.promoCount;
        }

        public final boolean getPushNotificationUpsellDismissed() {
            return this.pushNotificationUpsellDismissed;
        }

        public final List<ModelSubscription> getSubscriptions() {
            return this.subscriptions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MeUser meUser = this.meUser;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            boolean z2 = this.isStaffOrAlpha;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            Presence presence = this.presence;
            int iHashCode2 = (((i2 + (presence != null ? presence.hashCode() : 0)) * 31) + this.promoCount) * 31;
            boolean z3 = this.pushNotificationUpsellDismissed;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (iHashCode2 + i3) * 31;
            boolean z4 = this.isEligibleForMobileWebSubscriptions;
            int i5 = (i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
            List<ModelSubscription> list = this.subscriptions;
            return i5 + (list != null ? list.hashCode() : 0);
        }

        public final boolean isEligibleForMobileWebSubscriptions() {
            return this.isEligibleForMobileWebSubscriptions;
        }

        public final boolean isStaffOrAlpha() {
            return this.isStaffOrAlpha;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(meUser=");
            sbU.append(this.meUser);
            sbU.append(", isStaffOrAlpha=");
            sbU.append(this.isStaffOrAlpha);
            sbU.append(", presence=");
            sbU.append(this.presence);
            sbU.append(", promoCount=");
            sbU.append(this.promoCount);
            sbU.append(", pushNotificationUpsellDismissed=");
            sbU.append(this.pushNotificationUpsellDismissed);
            sbU.append(", isEligibleForMobileWebSubscriptions=");
            sbU.append(this.isEligibleForMobileWebSubscriptions);
            sbU.append(", subscriptions=");
            return outline.L(sbU, this.subscriptions, ")");
        }
    }

    /* compiled from: SettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/settings/SettingsViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Uninitialized", "Lcom/discord/widgets/settings/SettingsViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/settings/SettingsViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: SettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007JL\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001b\u0010\rJ\u001a\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b\u0011\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\nR\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b%\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b&\u0010\u0007R\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\r¨\u0006+"}, d2 = {"Lcom/discord/widgets/settings/SettingsViewModel$ViewState$Loaded;", "Lcom/discord/widgets/settings/SettingsViewModel$ViewState;", "Lcom/discord/models/user/MeUser;", "component1", "()Lcom/discord/models/user/MeUser;", "", "component2", "()Z", "Lcom/discord/models/presence/Presence;", "component3", "()Lcom/discord/models/presence/Presence;", "", "component4", "()I", "component5", "component6", "meUser", "isStaffOrAlpha", "presence", "promoCount", "pushNotificationUpsellDismissed", "showRoleSubscriptionsButton", "copy", "(Lcom/discord/models/user/MeUser;ZLcom/discord/models/presence/Presence;IZZ)Lcom/discord/widgets/settings/SettingsViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/models/user/MeUser;", "getMeUser", "Lcom/discord/models/presence/Presence;", "getPresence", "getShowRoleSubscriptionsButton", "getPushNotificationUpsellDismissed", "I", "getPromoCount", "<init>", "(Lcom/discord/models/user/MeUser;ZLcom/discord/models/presence/Presence;IZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final boolean isStaffOrAlpha;
            private final MeUser meUser;
            private final Presence presence;
            private final int promoCount;
            private final boolean pushNotificationUpsellDismissed;
            private final boolean showRoleSubscriptionsButton;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(MeUser meUser, boolean z2, Presence presence, int i, boolean z3, boolean z4) {
                super(null);
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                Intrinsics3.checkNotNullParameter(presence, "presence");
                this.meUser = meUser;
                this.isStaffOrAlpha = z2;
                this.presence = presence;
                this.promoCount = i;
                this.pushNotificationUpsellDismissed = z3;
                this.showRoleSubscriptionsButton = z4;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, MeUser meUser, boolean z2, Presence presence, int i, boolean z3, boolean z4, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    meUser = loaded.meUser;
                }
                if ((i2 & 2) != 0) {
                    z2 = loaded.isStaffOrAlpha;
                }
                boolean z5 = z2;
                if ((i2 & 4) != 0) {
                    presence = loaded.presence;
                }
                Presence presence2 = presence;
                if ((i2 & 8) != 0) {
                    i = loaded.promoCount;
                }
                int i3 = i;
                if ((i2 & 16) != 0) {
                    z3 = loaded.pushNotificationUpsellDismissed;
                }
                boolean z6 = z3;
                if ((i2 & 32) != 0) {
                    z4 = loaded.showRoleSubscriptionsButton;
                }
                return loaded.copy(meUser, z5, presence2, i3, z6, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final MeUser getMeUser() {
                return this.meUser;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsStaffOrAlpha() {
                return this.isStaffOrAlpha;
            }

            /* renamed from: component3, reason: from getter */
            public final Presence getPresence() {
                return this.presence;
            }

            /* renamed from: component4, reason: from getter */
            public final int getPromoCount() {
                return this.promoCount;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getPushNotificationUpsellDismissed() {
                return this.pushNotificationUpsellDismissed;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getShowRoleSubscriptionsButton() {
                return this.showRoleSubscriptionsButton;
            }

            public final Loaded copy(MeUser meUser, boolean isStaffOrAlpha, Presence presence, int promoCount, boolean pushNotificationUpsellDismissed, boolean showRoleSubscriptionsButton) {
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                Intrinsics3.checkNotNullParameter(presence, "presence");
                return new Loaded(meUser, isStaffOrAlpha, presence, promoCount, pushNotificationUpsellDismissed, showRoleSubscriptionsButton);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.meUser, loaded.meUser) && this.isStaffOrAlpha == loaded.isStaffOrAlpha && Intrinsics3.areEqual(this.presence, loaded.presence) && this.promoCount == loaded.promoCount && this.pushNotificationUpsellDismissed == loaded.pushNotificationUpsellDismissed && this.showRoleSubscriptionsButton == loaded.showRoleSubscriptionsButton;
            }

            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final Presence getPresence() {
                return this.presence;
            }

            public final int getPromoCount() {
                return this.promoCount;
            }

            public final boolean getPushNotificationUpsellDismissed() {
                return this.pushNotificationUpsellDismissed;
            }

            public final boolean getShowRoleSubscriptionsButton() {
                return this.showRoleSubscriptionsButton;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                MeUser meUser = this.meUser;
                int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
                boolean z2 = this.isStaffOrAlpha;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                Presence presence = this.presence;
                int iHashCode2 = (((i2 + (presence != null ? presence.hashCode() : 0)) * 31) + this.promoCount) * 31;
                boolean z3 = this.pushNotificationUpsellDismissed;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (iHashCode2 + i3) * 31;
                boolean z4 = this.showRoleSubscriptionsButton;
                return i4 + (z4 ? 1 : z4 ? 1 : 0);
            }

            public final boolean isStaffOrAlpha() {
                return this.isStaffOrAlpha;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(meUser=");
                sbU.append(this.meUser);
                sbU.append(", isStaffOrAlpha=");
                sbU.append(this.isStaffOrAlpha);
                sbU.append(", presence=");
                sbU.append(this.presence);
                sbU.append(", promoCount=");
                sbU.append(this.promoCount);
                sbU.append(", pushNotificationUpsellDismissed=");
                sbU.append(this.pushNotificationUpsellDismissed);
                sbU.append(", showRoleSubscriptionsButton=");
                return outline.O(sbU, this.showRoleSubscriptionsButton, ")");
            }
        }

        /* compiled from: SettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/SettingsViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/settings/SettingsViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SettingsViewModel() {
        this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SettingsViewModel(StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreNotificationUpsells storeNotificationUpsells, StoreOutboundPromotions storeOutboundPromotions, StoreSubscriptions storeSubscriptions, StoreUser storeUser, StoreUserPresence storeUserPresence, ObservationDeck observationDeck, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreExperiments experiments = (i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments;
        StoreGuilds guilds = (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreNotificationUpsells notificationUpsells = (i & 4) != 0 ? StoreStream.INSTANCE.getNotificationUpsells() : storeNotificationUpsells;
        StoreOutboundPromotions outboundPromotions = (i & 8) != 0 ? StoreStream.INSTANCE.getOutboundPromotions() : storeOutboundPromotions;
        StoreSubscriptions subscriptions = (i & 16) != 0 ? StoreStream.INSTANCE.getSubscriptions() : storeSubscriptions;
        StoreUser users = (i & 32) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreUserPresence presences = (i & 64) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence;
        ObservationDeck observationDeck2 = (i & 128) != 0 ? ObservationDeck4.get() : observationDeck;
        this(experiments, guilds, notificationUpsells, outboundPromotions, subscriptions, users, presences, observationDeck2, (i & 256) != 0 ? Companion.access$observeStoreState(INSTANCE, users, guilds, presences, outboundPromotions, notificationUpsells, experiments, subscriptions, observationDeck2) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(SettingsViewModel settingsViewModel, StoreState storeState) {
        settingsViewModel.handleStoreState(storeState);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleStoreState(StoreState storeState) {
        boolean z2;
        boolean z3;
        if (storeState.isEligibleForMobileWebSubscriptions()) {
            List<ModelSubscription> subscriptions = storeState.getSubscriptions();
            if (subscriptions == null) {
                subscriptions = Collections2.emptyList();
            }
            if ((subscriptions instanceof Collection) && subscriptions.isEmpty()) {
                z3 = false;
                if (!z3) {
                }
            } else {
                Iterator<T> it = subscriptions.iterator();
                while (it.hasNext()) {
                    if (Companion.access$isActiveGuildSubscription$p(INSTANCE, (ModelSubscription) it.next())) {
                        z3 = true;
                        break;
                    }
                }
                z3 = false;
                if (!z3) {
                    z2 = true;
                }
            }
        } else {
            z2 = false;
        }
        updateViewState(new ViewState.Loaded(storeState.getMeUser(), storeState.isStaffOrAlpha(), storeState.getPresence(), storeState.getPromoCount(), storeState.getPushNotificationUpsellDismissed(), z2));
    }

    public final void openRoleSubscriptionsManagement(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        MobileWebHandoff.tryLaunchRedirectTo$default(new MobileWebHandoff(context, null, null, null, 14, null), MANAGE_SUBSCRIPTIONS_URL, false, false, 6, null);
    }

    public final void refreshSubscriptions() {
        if (this.subscriptionsStore.isFetchingSubscriptions()) {
            return;
        }
        this.subscriptionsStore.fetchSubscriptions();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsViewModel(StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreNotificationUpsells storeNotificationUpsells, StoreOutboundPromotions storeOutboundPromotions, StoreSubscriptions storeSubscriptions, StoreUser storeUser, StoreUserPresence storeUserPresence, ObservationDeck observationDeck, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentsStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeNotificationUpsells, "notificationUpsellsStore");
        Intrinsics3.checkNotNullParameter(storeOutboundPromotions, "outboundPromotionsStore");
        Intrinsics3.checkNotNullParameter(storeSubscriptions, "subscriptionsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeUserPresence, "userPresenceStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.subscriptionsStore = storeSubscriptions;
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), SettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
