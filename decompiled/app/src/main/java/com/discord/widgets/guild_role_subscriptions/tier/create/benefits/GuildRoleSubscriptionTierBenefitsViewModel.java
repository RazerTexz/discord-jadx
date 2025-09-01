package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: GuildRoleSubscriptionTierBenefitsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B9\u0012\n\u0010\f\u001a\u00060\nj\u0002`\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0019R\u001a\u0010\f\u001a\u00060\nj\u0002`\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$ViewState;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$StoreState;)V", "updateList", "()V", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "observeStoreState", "(J)Lrx/Observable;", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "guildRoleSubscriptionTier", "", "isFullServerGating", "updateBenefits", "(Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;Ljava/lang/Boolean;)V", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitListType;", "benefitListType", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitListType;", "Ljava/lang/Boolean;", "J", "Lcom/discord/stores/StoreExperiments;", "experimentsStore", "Lcom/discord/stores/StoreExperiments;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$StoreState;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "guildRoleSubscriptionsStore", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "<init>", "(JLcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitListType;Lcom/discord/stores/StoreExperiments;Lcom/discord/stores/StoreGuildRoleSubscriptions;Lcom/discord/stores/updates/ObservationDeck;)V", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierBenefitsViewModel extends AppViewModel<ViewState> {
    private final GuildRoleSubscriptionTierBenefitListType benefitListType;
    private final StoreExperiments experimentsStore;
    private final long guildId;
    private GuildRoleSubscriptionTier guildRoleSubscriptionTier;
    private final StoreGuildRoleSubscriptions guildRoleSubscriptionsStore;
    private Boolean isFullServerGating;
    private final ObservationDeck observationDeck;
    private StoreState storeState;

    /* compiled from: GuildRoleSubscriptionTierBenefitsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitsViewModel$1, reason: invalid class name */
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
            GuildRoleSubscriptionTierBenefitsViewModel guildRoleSubscriptionTierBenefitsViewModel = GuildRoleSubscriptionTierBenefitsViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            GuildRoleSubscriptionTierBenefitsViewModel.access$handleStoreState(guildRoleSubscriptionTierBenefitsViewModel, storeState);
        }
    }

    /* compiled from: GuildRoleSubscriptionTierBenefitsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ<\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u000b\u0010\u0004R!\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$StoreState;", "", "", "component1", "()Z", "", "", "component2", "()Ljava/util/List;", "Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;", "component3", "isGuildEligibleForTrials", "activeTrialUserLimitOptions", "trialIntervalOptions", "copy", "(ZLjava/util/List;Ljava/util/List;)Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/util/List;", "getActiveTrialUserLimitOptions", "getTrialIntervalOptions", "<init>", "(ZLjava/util/List;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final List<Integer> activeTrialUserLimitOptions;
        private final boolean isGuildEligibleForTrials;
        private final List<SubscriptionTrialInterval> trialIntervalOptions;

        public StoreState(boolean z2, List<Integer> list, List<SubscriptionTrialInterval> list2) {
            Intrinsics3.checkNotNullParameter(list, "activeTrialUserLimitOptions");
            Intrinsics3.checkNotNullParameter(list2, "trialIntervalOptions");
            this.isGuildEligibleForTrials = z2;
            this.activeTrialUserLimitOptions = list;
            this.trialIntervalOptions = list2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, boolean z2, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = storeState.isGuildEligibleForTrials;
            }
            if ((i & 2) != 0) {
                list = storeState.activeTrialUserLimitOptions;
            }
            if ((i & 4) != 0) {
                list2 = storeState.trialIntervalOptions;
            }
            return storeState.copy(z2, list, list2);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsGuildEligibleForTrials() {
            return this.isGuildEligibleForTrials;
        }

        public final List<Integer> component2() {
            return this.activeTrialUserLimitOptions;
        }

        public final List<SubscriptionTrialInterval> component3() {
            return this.trialIntervalOptions;
        }

        public final StoreState copy(boolean isGuildEligibleForTrials, List<Integer> activeTrialUserLimitOptions, List<SubscriptionTrialInterval> trialIntervalOptions) {
            Intrinsics3.checkNotNullParameter(activeTrialUserLimitOptions, "activeTrialUserLimitOptions");
            Intrinsics3.checkNotNullParameter(trialIntervalOptions, "trialIntervalOptions");
            return new StoreState(isGuildEligibleForTrials, activeTrialUserLimitOptions, trialIntervalOptions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.isGuildEligibleForTrials == storeState.isGuildEligibleForTrials && Intrinsics3.areEqual(this.activeTrialUserLimitOptions, storeState.activeTrialUserLimitOptions) && Intrinsics3.areEqual(this.trialIntervalOptions, storeState.trialIntervalOptions);
        }

        public final List<Integer> getActiveTrialUserLimitOptions() {
            return this.activeTrialUserLimitOptions;
        }

        public final List<SubscriptionTrialInterval> getTrialIntervalOptions() {
            return this.trialIntervalOptions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.isGuildEligibleForTrials;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            List<Integer> list = this.activeTrialUserLimitOptions;
            int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
            List<SubscriptionTrialInterval> list2 = this.trialIntervalOptions;
            return iHashCode + (list2 != null ? list2.hashCode() : 0);
        }

        public final boolean isGuildEligibleForTrials() {
            return this.isGuildEligibleForTrials;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(isGuildEligibleForTrials=");
            sbU.append(this.isGuildEligibleForTrials);
            sbU.append(", activeTrialUserLimitOptions=");
            sbU.append(this.activeTrialUserLimitOptions);
            sbU.append(", trialIntervalOptions=");
            return outline.L(sbU, this.trialIntervalOptions, ")");
        }
    }

    /* compiled from: GuildRoleSubscriptionTierBenefitsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJX\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0005HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR!\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b \u0010\bR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\nR\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b#\u0010\bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$ViewState;", "", "", "component1", "()Z", "", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem;", "component2", "()Ljava/util/List;", "component3", "()Ljava/lang/Boolean;", "", "component4", "Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;", "component5", "canChangeChannelSettings", "items", "canAccessAllChannels", "activeTrialUserLimitOptions", "trialIntervalOptions", "copy", "(ZLjava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getActiveTrialUserLimitOptions", "getItems", "Ljava/lang/Boolean;", "getCanAccessAllChannels", "getTrialIntervalOptions", "Z", "getCanChangeChannelSettings", "<init>", "(ZLjava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final List<Integer> activeTrialUserLimitOptions;
        private final Boolean canAccessAllChannels;
        private final boolean canChangeChannelSettings;
        private final List<GuildRoleSubscriptionBenefitAdapterItem> items;
        private final List<SubscriptionTrialInterval> trialIntervalOptions;

        public ViewState() {
            this(false, null, null, null, null, 31, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(boolean z2, List<? extends GuildRoleSubscriptionBenefitAdapterItem> list, Boolean bool, List<Integer> list2, List<SubscriptionTrialInterval> list3) {
            Intrinsics3.checkNotNullParameter(list, "items");
            Intrinsics3.checkNotNullParameter(list2, "activeTrialUserLimitOptions");
            Intrinsics3.checkNotNullParameter(list3, "trialIntervalOptions");
            this.canChangeChannelSettings = z2;
            this.items = list;
            this.canAccessAllChannels = bool;
            this.activeTrialUserLimitOptions = list2;
            this.trialIntervalOptions = list3;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, List list, Boolean bool, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = viewState.canChangeChannelSettings;
            }
            if ((i & 2) != 0) {
                list = viewState.items;
            }
            List list4 = list;
            if ((i & 4) != 0) {
                bool = viewState.canAccessAllChannels;
            }
            Boolean bool2 = bool;
            if ((i & 8) != 0) {
                list2 = viewState.activeTrialUserLimitOptions;
            }
            List list5 = list2;
            if ((i & 16) != 0) {
                list3 = viewState.trialIntervalOptions;
            }
            return viewState.copy(z2, list4, bool2, list5, list3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getCanChangeChannelSettings() {
            return this.canChangeChannelSettings;
        }

        public final List<GuildRoleSubscriptionBenefitAdapterItem> component2() {
            return this.items;
        }

        /* renamed from: component3, reason: from getter */
        public final Boolean getCanAccessAllChannels() {
            return this.canAccessAllChannels;
        }

        public final List<Integer> component4() {
            return this.activeTrialUserLimitOptions;
        }

        public final List<SubscriptionTrialInterval> component5() {
            return this.trialIntervalOptions;
        }

        public final ViewState copy(boolean canChangeChannelSettings, List<? extends GuildRoleSubscriptionBenefitAdapterItem> items, Boolean canAccessAllChannels, List<Integer> activeTrialUserLimitOptions, List<SubscriptionTrialInterval> trialIntervalOptions) {
            Intrinsics3.checkNotNullParameter(items, "items");
            Intrinsics3.checkNotNullParameter(activeTrialUserLimitOptions, "activeTrialUserLimitOptions");
            Intrinsics3.checkNotNullParameter(trialIntervalOptions, "trialIntervalOptions");
            return new ViewState(canChangeChannelSettings, items, canAccessAllChannels, activeTrialUserLimitOptions, trialIntervalOptions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.canChangeChannelSettings == viewState.canChangeChannelSettings && Intrinsics3.areEqual(this.items, viewState.items) && Intrinsics3.areEqual(this.canAccessAllChannels, viewState.canAccessAllChannels) && Intrinsics3.areEqual(this.activeTrialUserLimitOptions, viewState.activeTrialUserLimitOptions) && Intrinsics3.areEqual(this.trialIntervalOptions, viewState.trialIntervalOptions);
        }

        public final List<Integer> getActiveTrialUserLimitOptions() {
            return this.activeTrialUserLimitOptions;
        }

        public final Boolean getCanAccessAllChannels() {
            return this.canAccessAllChannels;
        }

        public final boolean getCanChangeChannelSettings() {
            return this.canChangeChannelSettings;
        }

        public final List<GuildRoleSubscriptionBenefitAdapterItem> getItems() {
            return this.items;
        }

        public final List<SubscriptionTrialInterval> getTrialIntervalOptions() {
            return this.trialIntervalOptions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        public int hashCode() {
            boolean z2 = this.canChangeChannelSettings;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            List<GuildRoleSubscriptionBenefitAdapterItem> list = this.items;
            int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
            Boolean bool = this.canAccessAllChannels;
            int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
            List<Integer> list2 = this.activeTrialUserLimitOptions;
            int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<SubscriptionTrialInterval> list3 = this.trialIntervalOptions;
            return iHashCode3 + (list3 != null ? list3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(canChangeChannelSettings=");
            sbU.append(this.canChangeChannelSettings);
            sbU.append(", items=");
            sbU.append(this.items);
            sbU.append(", canAccessAllChannels=");
            sbU.append(this.canAccessAllChannels);
            sbU.append(", activeTrialUserLimitOptions=");
            sbU.append(this.activeTrialUserLimitOptions);
            sbU.append(", trialIntervalOptions=");
            return outline.L(sbU, this.trialIntervalOptions, ")");
        }

        public /* synthetic */ ViewState(boolean z2, List list, Boolean bool, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? Collections2.emptyList() : list, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? Collections2.emptyList() : list2, (i & 16) != 0 ? Collections2.emptyList() : list3);
        }
    }

    /* compiled from: GuildRoleSubscriptionTierBenefitsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$StoreState;", "invoke", "()Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitsViewModel$observeStoreState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<StoreState> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ StoreState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StoreState invoke() {
            return new StoreState(GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().isGuildEligibleForGuildRoleSubscriptionTrials(this.$guildId), GuildRoleSubscriptionTierBenefitsViewModel.access$getGuildRoleSubscriptionsStore$p(GuildRoleSubscriptionTierBenefitsViewModel.this).getGuildRoleSubscriptionFreeTrialActiveUserLimitOptions(), GuildRoleSubscriptionTierBenefitsViewModel.access$getGuildRoleSubscriptionsStore$p(GuildRoleSubscriptionTierBenefitsViewModel.this).getGuildRoleSubscriptionFreeTrialIntervalOptions());
        }
    }

    public /* synthetic */ GuildRoleSubscriptionTierBenefitsViewModel(long j, GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType, StoreExperiments storeExperiments, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, guildRoleSubscriptionTierBenefitListType, (i & 4) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 8) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions, (i & 16) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ StoreGuildRoleSubscriptions access$getGuildRoleSubscriptionsStore$p(GuildRoleSubscriptionTierBenefitsViewModel guildRoleSubscriptionTierBenefitsViewModel) {
        return guildRoleSubscriptionTierBenefitsViewModel.guildRoleSubscriptionsStore;
    }

    public static final /* synthetic */ void access$handleStoreState(GuildRoleSubscriptionTierBenefitsViewModel guildRoleSubscriptionTierBenefitsViewModel, StoreState storeState) {
        guildRoleSubscriptionTierBenefitsViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        this.storeState = storeState;
        updateList();
    }

    private final Observable<StoreState> observeStoreState(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.experimentsStore, this.guildRoleSubscriptionsStore}, false, null, null, new AnonymousClass1(guildId), 14, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateList() {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier;
        boolean z2;
        List<Integer> listEmptyList;
        List<SubscriptionTrialInterval> listEmptyList2;
        if (this.storeState == null || (guildRoleSubscriptionTier = this.guildRoleSubscriptionTier) == null) {
            return;
        }
        List<Benefit.ChannelBenefit> channelBenefits = guildRoleSubscriptionTier.getChannelBenefits();
        List<Benefit.IntangibleBenefit> intangibleBenefits = guildRoleSubscriptionTier.getIntangibleBenefits();
        GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType = this.benefitListType;
        long j = this.guildId;
        String name = guildRoleSubscriptionTier.getName();
        Boolean boolValueOf = Boolean.valueOf(guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(this.isFullServerGating));
        if (this.benefitListType != GuildRoleSubscriptionTierBenefitListType.ALL) {
            z2 = false;
        } else {
            StoreState storeState = this.storeState;
            if (storeState != null ? storeState.isGuildEligibleForTrials() : false) {
                z2 = true;
            }
        }
        List<GuildRoleSubscriptionBenefitAdapterItem> listGenerateGuildRoleSubscriptionBenefitListItems = GuildRoleSubscriptionBenefitListItemGenerator.generateGuildRoleSubscriptionBenefitListItems(channelBenefits, intangibleBenefits, guildRoleSubscriptionTierBenefitListType, j, name, boolValueOf, z2, guildRoleSubscriptionTier.getTrialInterval(), guildRoleSubscriptionTier.getActiveTrialUserLimit());
        boolean z3 = Intrinsics3.areEqual(this.isFullServerGating, Boolean.TRUE) && this.benefitListType != GuildRoleSubscriptionTierBenefitListType.INTANGIBLE;
        Boolean boolValueOf2 = Boolean.valueOf(guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(this.isFullServerGating));
        StoreState storeState2 = this.storeState;
        if (storeState2 == null || (listEmptyList = storeState2.getActiveTrialUserLimitOptions()) == null) {
            listEmptyList = Collections2.emptyList();
        }
        StoreState storeState3 = this.storeState;
        if (storeState3 == null || (listEmptyList2 = storeState3.getTrialIntervalOptions()) == null) {
            listEmptyList2 = Collections2.emptyList();
        }
        updateViewState(new ViewState(z3, listGenerateGuildRoleSubscriptionBenefitListItems, boolValueOf2, listEmptyList, listEmptyList2));
    }

    public final void updateBenefits(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean isFullServerGating) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
        this.isFullServerGating = isFullServerGating;
        updateList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionTierBenefitsViewModel(long j, GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType, StoreExperiments storeExperiments, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierBenefitListType, "benefitListType");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentsStore");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "guildRoleSubscriptionsStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.guildId = j;
        this.benefitListType = guildRoleSubscriptionTierBenefitListType;
        this.experimentsStore = storeExperiments;
        this.guildRoleSubscriptionsStore = storeGuildRoleSubscriptions;
        this.observationDeck = observationDeck;
        Observable<StoreState> observableR = observeStoreState(j).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeStoreState(guildI…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), GuildRoleSubscriptionTierBenefitsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
