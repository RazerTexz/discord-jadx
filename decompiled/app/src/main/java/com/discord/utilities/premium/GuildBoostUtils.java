package com.discord.utilities.premium;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.guilds.GuildConstants;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import d0.a0.MathJVM;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import j0.p.Schedulers2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: GuildBoostUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u00017B\t\b\u0002¢\u0006\u0004\b5\u00106JA\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J+\u0010\u001e\u001a\u00020\u00112\n\u0010\u0019\u001a\u00060\u0004j\u0002`\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ7\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b \u0010!J7\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\"\u0010!J=\u0010$\u001a\u00020\u00132\n\u0010\u0019\u001a\u00060\u0004j\u0002`\u00182\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b$\u0010%J=\u0010&\u001a\u00020\u00132\n\u0010\u0019\u001a\u00060\u0004j\u0002`\u00182\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b&\u0010%J5\u0010(\u001a\u00020\u00132\n\u0010\u0019\u001a\u00060\u0004j\u0002`\u00182\u0006\u0010'\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b(\u0010)J5\u0010+\u001a\u00020\u00132\n\u0010\u0019\u001a\u00060\u0004j\u0002`\u00182\u0006\u0010*\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b+\u0010)J#\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0013¢\u0006\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00138\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00138\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u00102R\u0016\u00104\u001a\u00020\u00138\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u00102¨\u00068"}, d2 = {"Lcom/discord/utilities/premium/GuildBoostUtils;", "", "Lcom/discord/utilities/rest/RestAPI;", "api", "", "Lcom/discord/primitives/GuildBoostSlotId;", "slotId", "Lcom/discord/models/domain/ModelSubscription;", Traits.Payment.Type.SUBSCRIPTION, "", "cancel", "Lcom/discord/stores/StoreGuildBoost;", "storeGuildBoost", "Lrx/Observable;", "Lcom/discord/utilities/premium/GuildBoostUtils$ModifyGuildBoostSlotResult;", "modifyGuildBoostSlot", "(Lcom/discord/utilities/rest/RestAPI;JLcom/discord/models/domain/ModelSubscription;ZLcom/discord/stores/StoreGuildBoost;)Lrx/Observable;", "Lcom/discord/utilities/premium/GuildBoostTierAmounts;", "boostTierAmounts", "", "premiumTier", "getNextTierSubs", "(Lcom/discord/utilities/premium/GuildBoostTierAmounts;I)I", "getCurrentTierSubs", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "getBoostTierAmounts", "(JLcom/discord/stores/StoreExperiments;Lcom/discord/stores/StoreGuilds;)Lcom/discord/utilities/premium/GuildBoostTierAmounts;", "cancelGuildBoostSlot", "(Lcom/discord/utilities/rest/RestAPI;JLcom/discord/models/domain/ModelSubscription;Lcom/discord/stores/StoreGuildBoost;)Lrx/Observable;", "uncancelGuildBoostSlot", "subscriptionCount", "calculateTotalProgress", "(JIILcom/discord/stores/StoreExperiments;Lcom/discord/stores/StoreGuilds;)I", "calculatePercentToNextTier", "guildBoostCount", "getBoostTier", "(JILcom/discord/stores/StoreExperiments;Lcom/discord/stores/StoreGuilds;)I", "tier", "getBoostsRequiredForTier", "guildBoostAdjustment", "", "Lcom/discord/models/domain/ModelSubscription$SubscriptionAdditionalPlan;", "calculateAdditionalPlansWithGuildBoostAdjustment", "(Lcom/discord/models/domain/ModelSubscription;I)Ljava/util/List;", "DEFAULT_GUILD_BOOST_SLOT_COUNT", "I", "GUILD_BOOST_COOLDOWN_DAYS", "DEFAULT_GUILD_BOOST_GUILD_COUNT", "<init>", "()V", "ModifyGuildBoostSlotResult", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildBoostUtils {
    public static final int DEFAULT_GUILD_BOOST_GUILD_COUNT = 1;
    public static final int DEFAULT_GUILD_BOOST_SLOT_COUNT = 1;
    public static final int GUILD_BOOST_COOLDOWN_DAYS = 7;
    public static final GuildBoostUtils INSTANCE = new GuildBoostUtils();

    /* compiled from: GuildBoostUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/utilities/premium/GuildBoostUtils$ModifyGuildBoostSlotResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE_MODIFYING_SLOT", "FAILURE_UPDATING_SUBSCRIPTION", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum ModifyGuildBoostSlotResult {
        SUCCESS,
        FAILURE_MODIFYING_SLOT,
        FAILURE_UPDATING_SUBSCRIPTION
    }

    /* compiled from: GuildBoostUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/ModelGuildBoostSlot;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelGuildBoostSlot;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.premium.GuildBoostUtils$modifyGuildBoostSlot$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<ModelGuildBoostSlot> {
        public final /* synthetic */ StoreGuildBoost $storeGuildBoost;

        public AnonymousClass1(StoreGuildBoost storeGuildBoost) {
            this.$storeGuildBoost = storeGuildBoost;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelGuildBoostSlot modelGuildBoostSlot) {
            call2(modelGuildBoostSlot);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelGuildBoostSlot modelGuildBoostSlot) {
            StoreGuildBoost storeGuildBoost = this.$storeGuildBoost;
            Intrinsics3.checkNotNullExpressionValue(modelGuildBoostSlot, "it");
            storeGuildBoost.updateGuildBoostSlot(modelGuildBoostSlot);
        }
    }

    /* compiled from: GuildBoostUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/ModelGuildBoostSlot;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelGuildBoostSlot;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.premium.GuildBoostUtils$modifyGuildBoostSlot$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<ModelGuildBoostSlot, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(ModelGuildBoostSlot modelGuildBoostSlot) {
            return call2(modelGuildBoostSlot);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(ModelGuildBoostSlot modelGuildBoostSlot) {
            return Boolean.TRUE;
        }
    }

    /* compiled from: GuildBoostUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.premium.GuildBoostUtils$modifyGuildBoostSlot$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<Throwable, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Throwable th) {
            return Boolean.FALSE;
        }
    }

    /* compiled from: GuildBoostUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "wasCancelSubscriptionSlotSuccessful", "Lrx/Observable;", "Lcom/discord/utilities/premium/GuildBoostUtils$ModifyGuildBoostSlotResult;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.premium.GuildBoostUtils$modifyGuildBoostSlot$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements Func1<Boolean, Observable<? extends ModifyGuildBoostSlotResult>> {
        public final /* synthetic */ RestAPI $api;
        public final /* synthetic */ boolean $cancel;
        public final /* synthetic */ ModelSubscription $subscription;

        /* compiled from: GuildBoostUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Void;", "it", "Lcom/discord/utilities/premium/GuildBoostUtils$ModifyGuildBoostSlotResult;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)Lcom/discord/utilities/premium/GuildBoostUtils$ModifyGuildBoostSlotResult;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.premium.GuildBoostUtils$modifyGuildBoostSlot$4$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Void, ModifyGuildBoostSlotResult> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ ModifyGuildBoostSlotResult call(Void r1) {
                return call2(r1);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final ModifyGuildBoostSlotResult call2(Void r1) {
                return ModifyGuildBoostSlotResult.SUCCESS;
            }
        }

        /* compiled from: GuildBoostUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lcom/discord/utilities/premium/GuildBoostUtils$ModifyGuildBoostSlotResult;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)Lcom/discord/utilities/premium/GuildBoostUtils$ModifyGuildBoostSlotResult;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.premium.GuildBoostUtils$modifyGuildBoostSlot$4$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements Func1<Throwable, ModifyGuildBoostSlotResult> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ ModifyGuildBoostSlotResult call(Throwable th) {
                return call2(th);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final ModifyGuildBoostSlotResult call2(Throwable th) {
                return ModifyGuildBoostSlotResult.FAILURE_UPDATING_SUBSCRIPTION;
            }
        }

        public AnonymousClass4(RestAPI restAPI, ModelSubscription modelSubscription, boolean z2) {
            this.$api = restAPI;
            this.$subscription = modelSubscription;
            this.$cancel = z2;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends ModifyGuildBoostSlotResult> call(Boolean bool) {
            return call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends ModifyGuildBoostSlotResult> call2(Boolean bool) {
            if (bool.booleanValue()) {
                return this.$api.updateSubscription(this.$subscription.getId(), new RestAPIParams.UpdateSubscription(null, null, null, GuildBoostUtils.INSTANCE.calculateAdditionalPlansWithGuildBoostAdjustment(this.$subscription, this.$cancel ? -1 : 1), 7, null)).G(AnonymousClass1.INSTANCE).M(AnonymousClass2.INSTANCE);
            }
            return new ScalarSynchronousObservable(ModifyGuildBoostSlotResult.FAILURE_MODIFYING_SLOT);
        }
    }

    private GuildBoostUtils() {
    }

    public static /* synthetic */ int calculatePercentToNextTier$default(GuildBoostUtils guildBoostUtils, long j, int i, int i2, StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i3 & 16) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        return guildBoostUtils.calculatePercentToNextTier(j, i, i2, storeExperiments2, storeGuilds);
    }

    public static /* synthetic */ int calculateTotalProgress$default(GuildBoostUtils guildBoostUtils, long j, int i, int i2, StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i3 & 16) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        return guildBoostUtils.calculateTotalProgress(j, i, i2, storeExperiments2, storeGuilds);
    }

    public static /* synthetic */ int getBoostTier$default(GuildBoostUtils guildBoostUtils, long j, int i, StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i2 & 8) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        return guildBoostUtils.getBoostTier(j, i, storeExperiments2, storeGuilds);
    }

    private final GuildBoostTierAmounts getBoostTierAmounts(long guildId, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Guild guild = storeGuilds.getGuild(guildId);
        boolean z2 = false;
        boolean z3 = guild != null && guild.hasFeature(GuildFeature.BOOSTING_TIERS_EXPERIMENT_SMALL_GUILD);
        Guild guild2 = storeGuilds.getGuild(guildId);
        if (guild2 != null && guild2.hasFeature(GuildFeature.BOOSTING_TIERS_EXPERIMENT_MEDIUM_GUILD)) {
            z2 = true;
        }
        Experiment guildExperiment = storeExperiments.getGuildExperiment("2022-03_boosting_tiers_small_guilds", guildId, z3);
        Experiment guildExperiment2 = storeExperiments.getGuildExperiment("2022-03_boosting_tiers_medium_guilds", guildId, z2);
        return (!z3 || ((guildExperiment == null || guildExperiment.getBucket() != 1) && (guildExperiment == null || guildExperiment.getBucket() != 2))) ? (!z2 || ((guildExperiment2 == null || guildExperiment2.getBucket() != 1) && (guildExperiment2 == null || guildExperiment2.getBucket() != 2))) ? GuildConstants.getGUILD_BOOST_TIER_AMOUNTS() : GuildConstants.getGUILD_BOOST_TIER_AMOUNTS_EXP_MEDIUM_GUILDS() : GuildConstants.getGUILD_BOOST_TIER_AMOUNTS_EXP_SMALL_GUILDS();
    }

    public static /* synthetic */ int getBoostsRequiredForTier$default(GuildBoostUtils guildBoostUtils, long j, int i, StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i2 & 8) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        return guildBoostUtils.getBoostsRequiredForTier(j, i, storeExperiments2, storeGuilds);
    }

    private final int getCurrentTierSubs(GuildBoostTierAmounts boostTierAmounts, int premiumTier) {
        if (premiumTier == 1) {
            return boostTierAmounts.getTier1Boosts();
        }
        if (premiumTier == 2) {
            return boostTierAmounts.getTier2Boosts();
        }
        if (premiumTier != 3) {
            return 0;
        }
        return boostTierAmounts.getTier3Boosts();
    }

    private final int getNextTierSubs(GuildBoostTierAmounts boostTierAmounts, int premiumTier) {
        if (premiumTier == 1) {
            return boostTierAmounts.getTier2Boosts();
        }
        if (premiumTier == 2) {
            return boostTierAmounts.getTier3Boosts();
        }
        if (premiumTier != 3) {
            return boostTierAmounts.getTier1Boosts();
        }
        return 0;
    }

    private final Observable<ModifyGuildBoostSlotResult> modifyGuildBoostSlot(RestAPI api, long slotId, ModelSubscription subscription, boolean cancel, StoreGuildBoost storeGuildBoost) {
        Observable<ModifyGuildBoostSlotResult> observableA = (cancel ? api.cancelSubscriptionSlot(slotId) : api.uncancelSubscriptionSlot(slotId)).X(Schedulers2.c()).u(new AnonymousClass1(storeGuildBoost)).G(AnonymousClass2.INSTANCE).M(AnonymousClass3.INSTANCE).A(new AnonymousClass4(api, subscription, cancel));
        Intrinsics3.checkNotNullExpressionValue(observableA, "apiObs\n        .subscrib…N }\n          }\n        }");
        return observableA;
    }

    public final List<ModelSubscription.SubscriptionAdditionalPlan> calculateAdditionalPlansWithGuildBoostAdjustment(ModelSubscription subscription, int guildBoostAdjustment) {
        Object next;
        Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
        ModelSubscription.SubscriptionRenewalMutations renewalMutations = subscription.getRenewalMutations();
        List<ModelSubscription.SubscriptionAdditionalPlan> premiumAdditionalPlans = renewalMutations == null ? subscription.getPremiumAdditionalPlans() : renewalMutations.getPremiumAdditionalPlans();
        Iterator<T> it = premiumAdditionalPlans.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ModelSubscription.SubscriptionAdditionalPlan subscriptionAdditionalPlan = (ModelSubscription.SubscriptionAdditionalPlan) next;
            if (subscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_MONTH.getPlanId() || subscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_3_MONTH.getPlanId() || subscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_6_MONTH.getPlanId() || subscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_YEAR.getPlanId()) {
                break;
            }
        }
        ModelSubscription.SubscriptionAdditionalPlan subscriptionAdditionalPlan2 = (ModelSubscription.SubscriptionAdditionalPlan) next;
        int quantity = (subscriptionAdditionalPlan2 != null ? subscriptionAdditionalPlan2.getQuantity() : 0) + guildBoostAdjustment;
        if (quantity < 0 || subscriptionAdditionalPlan2 == null) {
            Logger.e$default(AppLog.g, "Error calculating additional_plans adjustment, new sub count:" + quantity, null, null, 6, null);
            return subscription.getPremiumAdditionalPlans();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : premiumAdditionalPlans) {
            ModelSubscription.SubscriptionAdditionalPlan subscriptionAdditionalPlan3 = (ModelSubscription.SubscriptionAdditionalPlan) obj;
            if ((subscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_MONTH.getPlanId() || subscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_3_MONTH.getPlanId() || subscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_6_MONTH.getPlanId() || subscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_YEAR.getPlanId()) ? false : true) {
                arrayList.add(obj);
            }
        }
        return quantity == 0 ? arrayList : _Collections.plus((Collection) arrayList, (Iterable) CollectionsJVM.listOf(new ModelSubscription.SubscriptionAdditionalPlan(subscriptionAdditionalPlan2.getPlanId(), quantity)));
    }

    public final int calculatePercentToNextTier(long guildId, int premiumTier, int subscriptionCount, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        if (premiumTier >= 3) {
            return 100;
        }
        GuildBoostTierAmounts boostTierAmounts = getBoostTierAmounts(guildId, storeExperiments, storeGuilds);
        return MathJVM.roundToInt(((subscriptionCount - getCurrentTierSubs(boostTierAmounts, premiumTier)) / getNextTierSubs(boostTierAmounts, premiumTier)) * 100);
    }

    public final int calculateTotalProgress(long guildId, int premiumTier, int subscriptionCount, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        if (premiumTier >= 3) {
            return 100;
        }
        GuildBoostTierAmounts boostTierAmounts = getBoostTierAmounts(guildId, storeExperiments, storeGuilds);
        int nextTierSubs = getNextTierSubs(boostTierAmounts, premiumTier);
        int currentTierSubs = getCurrentTierSubs(boostTierAmounts, premiumTier);
        return MathJVM.roundToInt((((subscriptionCount - currentTierSubs) / (nextTierSubs - currentTierSubs)) * 33.3f) + (premiumTier * 33.3f));
    }

    public final Observable<ModifyGuildBoostSlotResult> cancelGuildBoostSlot(RestAPI api, long slotId, ModelSubscription subscription, StoreGuildBoost storeGuildBoost) {
        Intrinsics3.checkNotNullParameter(api, "api");
        Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
        Intrinsics3.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        return modifyGuildBoostSlot(api, slotId, subscription, true, storeGuildBoost);
    }

    public final int getBoostTier(long guildId, int guildBoostCount, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        GuildBoostTierAmounts boostTierAmounts = getBoostTierAmounts(guildId, storeExperiments, storeGuilds);
        if (guildBoostCount >= boostTierAmounts.getTier3Boosts()) {
            return 3;
        }
        if (guildBoostCount >= boostTierAmounts.getTier2Boosts()) {
            return 2;
        }
        return guildBoostCount >= boostTierAmounts.getTier1Boosts() ? 1 : 0;
    }

    public final int getBoostsRequiredForTier(long guildId, int tier, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        GuildBoostTierAmounts boostTierAmounts = getBoostTierAmounts(guildId, storeExperiments, storeGuilds);
        if (tier == 1) {
            return boostTierAmounts.getTier1Boosts();
        }
        if (tier == 2) {
            return boostTierAmounts.getTier2Boosts();
        }
        if (tier != 3) {
            return 0;
        }
        return boostTierAmounts.getTier3Boosts();
    }

    public final Observable<ModifyGuildBoostSlotResult> uncancelGuildBoostSlot(RestAPI api, long slotId, ModelSubscription subscription, StoreGuildBoost storeGuildBoost) {
        Intrinsics3.checkNotNullParameter(api, "api");
        Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
        Intrinsics3.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        return modifyGuildBoostSlot(api, slotId, subscription, false, storeGuildBoost);
    }
}
