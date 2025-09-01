package com.discord.widgets.guild_role_subscriptions;

import com.discord.api.guild.GuildFeature;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.servers.creator_monetization_eligibility.CreatorMonetizationCountryAllowlist;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: GuildRoleSubscriptionsFeatureFlag.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001.B9\u0012\b\b\u0002\u0010'\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u000f\u0010\tJ\u0019\u0010\u0010\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0010\u0010\tJ\u0019\u0010\u0011\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0011\u0010\tJ#\u0010\u0014\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0016\u0010\tJ\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u001a\u0010\u0019J\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u001b\u0010\u0019J#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/GuildRoleSubscriptionsFeatureFlag;", "", "", "canUserCreateRoleSubscriptions", "()Z", "", "Lcom/discord/primitives/GuildId;", "guildId", "canGuildAccessMobileWebPurchases", "(J)Z", "canGuildCreateRoleSubscriptions", "Lcom/discord/stores/StoreExperiments;", "experiments", "canUserAccessRoleSubscriptionManagement", "(Lcom/discord/stores/StoreExperiments;)Z", "isGuildEligibleForRoleSubscriptions", "isGuildEligibleForGuildRoleSubscriptionTrials", "canGuildSeePremiumMemberships", "Lcom/discord/widgets/servers/creator_monetization_eligibility/CreatorMonetizationCountryAllowlist;", "countryAllowlist", "canGuildSeeGuildRoleSubscriptionSettings", "(JLcom/discord/widgets/servers/creator_monetization_eligibility/CreatorMonetizationCountryAllowlist;)Z", "canGuildSeePurchaseFeedbackLoopMessages", "Lrx/Observable;", "observeCanGuildSeeGuildRoleSubscriptionsSettings", "(J)Lrx/Observable;", "observeCanGuildSeeGuildRoleSubscriptions", "observeIsGuildEligibleForGuildRoleSubscriptionFreeTrials", "observeCanGuildSeePurchaseFeedbackLoopSystemMessages", "(Ljava/lang/Long;)Lrx/Observable;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "storeExperiments", "Lcom/discord/stores/StoreExperiments;", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StorePermissions;", "<init>", "(Lcom/discord/stores/StoreExperiments;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionsFeatureFlag {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(GuildRoleSubscriptionsFeatureFlag2.INSTANCE);
    private final ObservationDeck observationDeck;
    private final StoreExperiments storeExperiments;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreUser storeUser;

    /* compiled from: GuildRoleSubscriptionsFeatureFlag.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\t*\u00020\b8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/GuildRoleSubscriptionsFeatureFlag$Companion;", "", "Lcom/discord/widgets/guild_role_subscriptions/GuildRoleSubscriptionsFeatureFlag;", "INSTANCE$delegate", "Lkotlin/Lazy;", "getINSTANCE", "()Lcom/discord/widgets/guild_role_subscriptions/GuildRoleSubscriptionsFeatureFlag;", "INSTANCE", "Lcom/discord/models/guild/Guild;", "", "isCreatorMonetizable", "(Lcom/discord/models/guild/Guild;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ boolean access$isCreatorMonetizable$p(Companion companion, Guild guild) {
            return companion.isCreatorMonetizable(guild);
        }

        private final boolean isCreatorMonetizable(Guild guild) {
            return guild.hasFeature(GuildFeature.CREATOR_MONETIZABLE) && !guild.hasFeature(GuildFeature.CREATOR_MONETIZABLE_DISABLED);
        }

        public final GuildRoleSubscriptionsFeatureFlag getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = GuildRoleSubscriptionsFeatureFlag.access$getINSTANCE$cp();
            Companion companion = GuildRoleSubscriptionsFeatureFlag.INSTANCE;
            return (GuildRoleSubscriptionsFeatureFlag) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildRoleSubscriptionsFeatureFlag.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag$observeCanGuildSeeGuildRoleSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return GuildRoleSubscriptionsFeatureFlag.this.canGuildSeePremiumMemberships(this.$guildId);
        }
    }

    /* compiled from: GuildRoleSubscriptionsFeatureFlag.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag$observeCanGuildSeeGuildRoleSubscriptionsSettings$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return GuildRoleSubscriptionsFeatureFlag.canGuildSeeGuildRoleSubscriptionSettings$default(GuildRoleSubscriptionsFeatureFlag.this, this.$guildId, null, 2, null);
        }
    }

    /* compiled from: GuildRoleSubscriptionsFeatureFlag.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag$observeCanGuildSeePurchaseFeedbackLoopSystemMessages$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ Long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l) {
            super(0);
            this.$guildId = l;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return GuildRoleSubscriptionsFeatureFlag.this.canGuildSeePurchaseFeedbackLoopMessages(this.$guildId.longValue());
        }
    }

    /* compiled from: GuildRoleSubscriptionsFeatureFlag.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag$observeIsGuildEligibleForGuildRoleSubscriptionFreeTrials$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return GuildRoleSubscriptionsFeatureFlag.this.isGuildEligibleForGuildRoleSubscriptionTrials(this.$guildId);
        }
    }

    public GuildRoleSubscriptionsFeatureFlag() {
        this(null, null, null, null, null, 31, null);
    }

    public GuildRoleSubscriptionsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreUser storeUser, StorePermissions storePermissions, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeExperiments = storeExperiments;
        this.storeGuilds = storeGuilds;
        this.storeUser = storeUser;
        this.storePermissions = storePermissions;
        this.observationDeck = observationDeck;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static /* synthetic */ boolean canGuildSeeGuildRoleSubscriptionSettings$default(GuildRoleSubscriptionsFeatureFlag guildRoleSubscriptionsFeatureFlag, long j, CreatorMonetizationCountryAllowlist creatorMonetizationCountryAllowlist, int i, Object obj) {
        if ((i & 2) != 0) {
            creatorMonetizationCountryAllowlist = CreatorMonetizationCountryAllowlist.INSTANCE.getINSTANCE();
        }
        return guildRoleSubscriptionsFeatureFlag.canGuildSeeGuildRoleSubscriptionSettings(j, creatorMonetizationCountryAllowlist);
    }

    public static /* synthetic */ boolean canUserAccessRoleSubscriptionManagement$default(GuildRoleSubscriptionsFeatureFlag guildRoleSubscriptionsFeatureFlag, StoreExperiments storeExperiments, int i, Object obj) {
        if ((i & 1) != 0) {
            storeExperiments = guildRoleSubscriptionsFeatureFlag.storeExperiments;
        }
        return guildRoleSubscriptionsFeatureFlag.canUserAccessRoleSubscriptionManagement(storeExperiments);
    }

    private final boolean canUserCreateRoleSubscriptions() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2021-08_guild_role_subscription_users", false);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }

    public final boolean canGuildAccessMobileWebPurchases(long guildId) {
        Experiment guildExperiment = this.storeExperiments.getGuildExperiment("2022-05_mobile_web_role_subscription_purchase_page", guildId, false);
        return guildExperiment != null && guildExperiment.getBucket() == 1;
    }

    public final boolean canGuildCreateRoleSubscriptions(long guildId) {
        Experiment guildExperiment = this.storeExperiments.getGuildExperiment("2021-06_guild_role_subscriptions", guildId, false);
        return guildExperiment != null && guildExperiment.getBucket() == 1;
    }

    public final boolean canGuildSeeGuildRoleSubscriptionSettings(long guildId, CreatorMonetizationCountryAllowlist countryAllowlist) {
        Guild guild;
        Intrinsics3.checkNotNullParameter(countryAllowlist, "countryAllowlist");
        if (isGuildEligibleForRoleSubscriptions(guildId) && (guild = this.storeGuilds.getGuild(guildId)) != null) {
            return Companion.access$isCreatorMonetizable$p(INSTANCE, guild) ? PermissionUtils.can(32L, this.storePermissions.getGuildPermissions().get(Long.valueOf(guildId))) : guild.isOwner(this.storeUser.getMeSnapshot().getId()) && countryAllowlist.isUserInEligibleCountry();
        }
        return false;
    }

    public final boolean canGuildSeePremiumMemberships(long guildId) {
        Guild guild = this.storeGuilds.getGuild(guildId);
        if (guild != null) {
            return guild.hasFeature(GuildFeature.ROLE_SUBSCRIPTIONS_AVAILABLE_FOR_PURCHASE) && Companion.access$isCreatorMonetizable$p(INSTANCE, guild);
        }
        return false;
    }

    public final boolean canGuildSeePurchaseFeedbackLoopMessages(long guildId) {
        Experiment guildExperiment = this.storeExperiments.getGuildExperiment("2022-04_guild_role_subscription_purchase_feedback_loop", guildId, false);
        return guildExperiment != null && guildExperiment.getBucket() == 1 && isGuildEligibleForRoleSubscriptions(guildId);
    }

    public final boolean canUserAccessRoleSubscriptionManagement(StoreExperiments experiments) {
        Intrinsics3.checkNotNullParameter(experiments, "experiments");
        Experiment userExperiment = experiments.getUserExperiment("2022-06_native_mobile_role_subscription_management", false);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }

    public final boolean isGuildEligibleForGuildRoleSubscriptionTrials(long guildId) {
        Experiment guildExperiment = this.storeExperiments.getGuildExperiment("2022-01_guild_role_subscription_trials", guildId, false);
        return guildExperiment != null && guildExperiment.getBucket() == 1 && isGuildEligibleForRoleSubscriptions(guildId);
    }

    public final boolean isGuildEligibleForRoleSubscriptions(long guildId) {
        return canGuildCreateRoleSubscriptions(guildId) && canUserCreateRoleSubscriptions();
    }

    public final Observable<Boolean> observeCanGuildSeeGuildRoleSubscriptions(long guildId) {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeGuilds}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeCanGuildSeeGuildRoleSubscriptionsSettings(long guildId) {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeExperiments, this.storeGuilds, this.storeUser, this.storePermissions}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeCanGuildSeePurchaseFeedbackLoopSystemMessages(Long guildId) {
        if (guildId == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Boolean.FALSE);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(false)");
            return scalarSynchronousObservable;
        }
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeExperiments, this.storeGuilds}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsGuildEligibleForGuildRoleSubscriptionFreeTrials(long guildId) {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeExperiments}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ GuildRoleSubscriptionsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreUser storeUser, StorePermissions storePermissions, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 8) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 16) != 0 ? ObservationDeck4.get() : observationDeck);
    }
}
