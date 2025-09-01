package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import b.d.b.a.outline;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AnalyticsFormattedMonetizationRequirements.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b1\b\u0086\b\u0018\u0000 M2\u00020\u0001:\u0001MB\u0091\u0001\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\u0006\u0010#\u001a\u00020\u0005\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\u0006\u0010%\u001a\u00020\u0005\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\u0006\u0010'\u001a\u00020\u0005\u0012\u0006\u0010(\u001a\u00020\u0005\u0012\u0006\u0010)\u001a\u00020\u0010\u0012\u0006\u0010*\u001a\u00020\u0010\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010/\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\bK\u0010LJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJº\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\u00102\b\b\u0002\u0010*\u001a\u00020\u00102\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u001dHÆ\u0001¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b2\u0010\u0004J\u0010\u00103\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b3\u0010\u0012J\u001a\u00105\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b5\u00106R\u0019\u0010 \u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u00107\u001a\u0004\b \u0010\u0007R\u0019\u0010)\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b)\u00108\u001a\u0004\b9\u0010\u0012R\u0019\u0010!\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\b:\u0010\u0007R\u001b\u0010+\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010;\u001a\u0004\b<\u0010\u0016R\u0019\u0010(\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u00107\u001a\u0004\b(\u0010\u0007R\u0019\u0010&\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u00107\u001a\u0004\b=\u0010\u0007R\u0019\u0010#\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u00107\u001a\u0004\b>\u0010\u0007R\u001b\u0010.\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010?\u001a\u0004\b@\u0010\u001bR\u0019\u0010*\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b*\u00108\u001a\u0004\bA\u0010\u0012R\u0019\u0010%\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b%\u00107\u001a\u0004\bB\u0010\u0007R\u0019\u0010$\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u00107\u001a\u0004\bC\u0010\u0007R\u0019\u0010\"\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00107\u001a\u0004\bD\u0010\u0007R\u0019\u0010'\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b'\u00107\u001a\u0004\bE\u0010\u0007R\u001b\u0010/\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010F\u001a\u0004\bG\u0010\u001fR\u001b\u0010,\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010H\u001a\u0004\bI\u0010\u0019R\u001b\u0010-\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010?\u001a\u0004\bJ\u0010\u001b¨\u0006N"}, d2 = {"Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/AnalyticsFormattedMonetizationRequirements;", "", "", "toJson", "()Ljava/lang/String;", "", "component1", "()Z", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "", "component10", "()I", "component11", "Lcom/discord/api/creatormonetization/CreatorMonetizationEnableRequest;", "component12", "()Lcom/discord/api/creatormonetization/CreatorMonetizationEnableRequest;", "Lcom/discord/api/creatormonetization/CreatorMonetizationEligibilityRequirements$Rejection;", "component13", "()Lcom/discord/api/creatormonetization/CreatorMonetizationEligibilityRequirements$Rejection;", "component14", "()Ljava/lang/Integer;", "component15", "", "component16", "()Ljava/lang/Double;", "isEligibleForMonetization", "hasSufficientMembers", "meetsServerAgeRequirement", "noRecentViolations", "weeklyCommunicators", "hasMemberRetention", "notNSFW", "canApply", "isApplicationPending", "minimumAgeInDays", "minimumSize", "latestRequest", "rejection", "guildMemberCount", "communicatorCount", "retentionScore", "copy", "(ZZZZZZZZZIILcom/discord/api/creatormonetization/CreatorMonetizationEnableRequest;Lcom/discord/api/creatormonetization/CreatorMonetizationEligibilityRequirements$Rejection;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;)Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/AnalyticsFormattedMonetizationRequirements;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "I", "getMinimumAgeInDays", "getHasSufficientMembers", "Lcom/discord/api/creatormonetization/CreatorMonetizationEnableRequest;", "getLatestRequest", "getNotNSFW", "getNoRecentViolations", "Ljava/lang/Integer;", "getCommunicatorCount", "getMinimumSize", "getHasMemberRetention", "getWeeklyCommunicators", "getMeetsServerAgeRequirement", "getCanApply", "Ljava/lang/Double;", "getRetentionScore", "Lcom/discord/api/creatormonetization/CreatorMonetizationEligibilityRequirements$Rejection;", "getRejection", "getGuildMemberCount", "<init>", "(ZZZZZZZZZIILcom/discord/api/creatormonetization/CreatorMonetizationEnableRequest;Lcom/discord/api/creatormonetization/CreatorMonetizationEligibilityRequirements$Rejection;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class AnalyticsFormattedMonetizationRequirements {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy gsonInstance$delegate = LazyJVM.lazy(AnalyticsFormattedMonetizationRequirements2.INSTANCE);
    private final boolean canApply;
    private final Integer communicatorCount;
    private final Integer guildMemberCount;
    private final boolean hasMemberRetention;
    private final boolean hasSufficientMembers;
    private final boolean isApplicationPending;
    private final boolean isEligibleForMonetization;
    private final CreatorMonetizationEnableRequest latestRequest;
    private final boolean meetsServerAgeRequirement;
    private final int minimumAgeInDays;
    private final int minimumSize;
    private final boolean noRecentViolations;
    private final boolean notNSFW;
    private final CreatorMonetizationEligibilityRequirements.Rejection rejection;
    private final Double retentionScore;
    private final boolean weeklyCommunicators;

    /* compiled from: AnalyticsFormattedMonetizationRequirements.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R%\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/AnalyticsFormattedMonetizationRequirements$Companion;", "", "Lcom/discord/api/creatormonetization/CreatorMonetizationEligibilityRequirements;", "Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/AnalyticsFormattedMonetizationRequirements;", "toAnalyticsFormat", "(Lcom/discord/api/creatormonetization/CreatorMonetizationEligibilityRequirements;)Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/AnalyticsFormattedMonetizationRequirements;", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gsonInstance$delegate", "Lkotlin/Lazy;", "getGsonInstance", "()Lcom/google/gson/Gson;", "gsonInstance", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Gson access$getGsonInstance$p(Companion companion) {
            return companion.getGsonInstance();
        }

        private final Gson getGsonInstance() {
            Lazy lazyAccess$getGsonInstance$cp = AnalyticsFormattedMonetizationRequirements.access$getGsonInstance$cp();
            Companion companion = AnalyticsFormattedMonetizationRequirements.INSTANCE;
            return (Gson) lazyAccess$getGsonInstance$cp.getValue();
        }

        public final AnalyticsFormattedMonetizationRequirements toAnalyticsFormat(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
            Intrinsics3.checkNotNullParameter(creatorMonetizationEligibilityRequirements, "$this$toAnalyticsFormat");
            boolean sufficient = creatorMonetizationEligibilityRequirements.getSufficient();
            boolean size = creatorMonetizationEligibilityRequirements.getSize();
            boolean age = creatorMonetizationEligibilityRequirements.getAge();
            boolean safeEnvironment = creatorMonetizationEligibilityRequirements.getSafeEnvironment();
            boolean engagementHealthy = creatorMonetizationEligibilityRequirements.getEngagementHealthy();
            boolean retentionHealthy = creatorMonetizationEligibilityRequirements.getRetentionHealthy();
            Map<String, Object> mapI = creatorMonetizationEligibilityRequirements.i();
            boolean z2 = mapI == null || mapI.isEmpty();
            boolean canApply = creatorMonetizationEligibilityRequirements.getCanApply();
            CreatorMonetizationEnableRequest latestRequest = creatorMonetizationEligibilityRequirements.getLatestRequest();
            boolean z3 = (latestRequest != null ? latestRequest.getState() : null) == CreatorMonetizationEnableRequest.State.OPEN;
            int minimumAgeInDays = creatorMonetizationEligibilityRequirements.getMinimumAgeInDays();
            int minimumSize = creatorMonetizationEligibilityRequirements.getMinimumSize();
            CreatorMonetizationEnableRequest latestRequest2 = creatorMonetizationEligibilityRequirements.getLatestRequest();
            CreatorMonetizationEligibilityRequirements.Rejection rejection = creatorMonetizationEligibilityRequirements.getRejection();
            CreatorMonetizationEligibilityRequirements.HealthScore healthScore = creatorMonetizationEligibilityRequirements.getHealthScore();
            Integer guildSize = healthScore != null ? healthScore.getGuildSize() : null;
            CreatorMonetizationEligibilityRequirements.HealthScore healthScore2 = creatorMonetizationEligibilityRequirements.getHealthScore();
            Integer communicators = healthScore2 != null ? healthScore2.getCommunicators() : null;
            CreatorMonetizationEligibilityRequirements.HealthScore healthScore3 = creatorMonetizationEligibilityRequirements.getHealthScore();
            return new AnalyticsFormattedMonetizationRequirements(sufficient, size, age, safeEnvironment, engagementHealthy, retentionHealthy, z2, canApply, z3, minimumAgeInDays, minimumSize, latestRequest2, rejection, guildSize, communicators, healthScore3 != null ? healthScore3.getPercRetW1() : null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AnalyticsFormattedMonetizationRequirements(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i, int i2, CreatorMonetizationEnableRequest creatorMonetizationEnableRequest, CreatorMonetizationEligibilityRequirements.Rejection rejection, Integer num, Integer num2, Double d) {
        this.isEligibleForMonetization = z2;
        this.hasSufficientMembers = z3;
        this.meetsServerAgeRequirement = z4;
        this.noRecentViolations = z5;
        this.weeklyCommunicators = z6;
        this.hasMemberRetention = z7;
        this.notNSFW = z8;
        this.canApply = z9;
        this.isApplicationPending = z10;
        this.minimumAgeInDays = i;
        this.minimumSize = i2;
        this.latestRequest = creatorMonetizationEnableRequest;
        this.rejection = rejection;
        this.guildMemberCount = num;
        this.communicatorCount = num2;
        this.retentionScore = d;
    }

    public static final /* synthetic */ Lazy access$getGsonInstance$cp() {
        return gsonInstance$delegate;
    }

    public static /* synthetic */ AnalyticsFormattedMonetizationRequirements copy$default(AnalyticsFormattedMonetizationRequirements analyticsFormattedMonetizationRequirements, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i, int i2, CreatorMonetizationEnableRequest creatorMonetizationEnableRequest, CreatorMonetizationEligibilityRequirements.Rejection rejection, Integer num, Integer num2, Double d, int i3, Object obj) {
        return analyticsFormattedMonetizationRequirements.copy((i3 & 1) != 0 ? analyticsFormattedMonetizationRequirements.isEligibleForMonetization : z2, (i3 & 2) != 0 ? analyticsFormattedMonetizationRequirements.hasSufficientMembers : z3, (i3 & 4) != 0 ? analyticsFormattedMonetizationRequirements.meetsServerAgeRequirement : z4, (i3 & 8) != 0 ? analyticsFormattedMonetizationRequirements.noRecentViolations : z5, (i3 & 16) != 0 ? analyticsFormattedMonetizationRequirements.weeklyCommunicators : z6, (i3 & 32) != 0 ? analyticsFormattedMonetizationRequirements.hasMemberRetention : z7, (i3 & 64) != 0 ? analyticsFormattedMonetizationRequirements.notNSFW : z8, (i3 & 128) != 0 ? analyticsFormattedMonetizationRequirements.canApply : z9, (i3 & 256) != 0 ? analyticsFormattedMonetizationRequirements.isApplicationPending : z10, (i3 & 512) != 0 ? analyticsFormattedMonetizationRequirements.minimumAgeInDays : i, (i3 & 1024) != 0 ? analyticsFormattedMonetizationRequirements.minimumSize : i2, (i3 & 2048) != 0 ? analyticsFormattedMonetizationRequirements.latestRequest : creatorMonetizationEnableRequest, (i3 & 4096) != 0 ? analyticsFormattedMonetizationRequirements.rejection : rejection, (i3 & 8192) != 0 ? analyticsFormattedMonetizationRequirements.guildMemberCount : num, (i3 & 16384) != 0 ? analyticsFormattedMonetizationRequirements.communicatorCount : num2, (i3 & 32768) != 0 ? analyticsFormattedMonetizationRequirements.retentionScore : d);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsEligibleForMonetization() {
        return this.isEligibleForMonetization;
    }

    /* renamed from: component10, reason: from getter */
    public final int getMinimumAgeInDays() {
        return this.minimumAgeInDays;
    }

    /* renamed from: component11, reason: from getter */
    public final int getMinimumSize() {
        return this.minimumSize;
    }

    /* renamed from: component12, reason: from getter */
    public final CreatorMonetizationEnableRequest getLatestRequest() {
        return this.latestRequest;
    }

    /* renamed from: component13, reason: from getter */
    public final CreatorMonetizationEligibilityRequirements.Rejection getRejection() {
        return this.rejection;
    }

    /* renamed from: component14, reason: from getter */
    public final Integer getGuildMemberCount() {
        return this.guildMemberCount;
    }

    /* renamed from: component15, reason: from getter */
    public final Integer getCommunicatorCount() {
        return this.communicatorCount;
    }

    /* renamed from: component16, reason: from getter */
    public final Double getRetentionScore() {
        return this.retentionScore;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHasSufficientMembers() {
        return this.hasSufficientMembers;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getMeetsServerAgeRequirement() {
        return this.meetsServerAgeRequirement;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getNoRecentViolations() {
        return this.noRecentViolations;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getWeeklyCommunicators() {
        return this.weeklyCommunicators;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getHasMemberRetention() {
        return this.hasMemberRetention;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getNotNSFW() {
        return this.notNSFW;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getCanApply() {
        return this.canApply;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsApplicationPending() {
        return this.isApplicationPending;
    }

    public final AnalyticsFormattedMonetizationRequirements copy(boolean isEligibleForMonetization, boolean hasSufficientMembers, boolean meetsServerAgeRequirement, boolean noRecentViolations, boolean weeklyCommunicators, boolean hasMemberRetention, boolean notNSFW, boolean canApply, boolean isApplicationPending, int minimumAgeInDays, int minimumSize, CreatorMonetizationEnableRequest latestRequest, CreatorMonetizationEligibilityRequirements.Rejection rejection, Integer guildMemberCount, Integer communicatorCount, Double retentionScore) {
        return new AnalyticsFormattedMonetizationRequirements(isEligibleForMonetization, hasSufficientMembers, meetsServerAgeRequirement, noRecentViolations, weeklyCommunicators, hasMemberRetention, notNSFW, canApply, isApplicationPending, minimumAgeInDays, minimumSize, latestRequest, rejection, guildMemberCount, communicatorCount, retentionScore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnalyticsFormattedMonetizationRequirements)) {
            return false;
        }
        AnalyticsFormattedMonetizationRequirements analyticsFormattedMonetizationRequirements = (AnalyticsFormattedMonetizationRequirements) other;
        return this.isEligibleForMonetization == analyticsFormattedMonetizationRequirements.isEligibleForMonetization && this.hasSufficientMembers == analyticsFormattedMonetizationRequirements.hasSufficientMembers && this.meetsServerAgeRequirement == analyticsFormattedMonetizationRequirements.meetsServerAgeRequirement && this.noRecentViolations == analyticsFormattedMonetizationRequirements.noRecentViolations && this.weeklyCommunicators == analyticsFormattedMonetizationRequirements.weeklyCommunicators && this.hasMemberRetention == analyticsFormattedMonetizationRequirements.hasMemberRetention && this.notNSFW == analyticsFormattedMonetizationRequirements.notNSFW && this.canApply == analyticsFormattedMonetizationRequirements.canApply && this.isApplicationPending == analyticsFormattedMonetizationRequirements.isApplicationPending && this.minimumAgeInDays == analyticsFormattedMonetizationRequirements.minimumAgeInDays && this.minimumSize == analyticsFormattedMonetizationRequirements.minimumSize && Intrinsics3.areEqual(this.latestRequest, analyticsFormattedMonetizationRequirements.latestRequest) && Intrinsics3.areEqual(this.rejection, analyticsFormattedMonetizationRequirements.rejection) && Intrinsics3.areEqual(this.guildMemberCount, analyticsFormattedMonetizationRequirements.guildMemberCount) && Intrinsics3.areEqual(this.communicatorCount, analyticsFormattedMonetizationRequirements.communicatorCount) && Intrinsics3.areEqual(this.retentionScore, analyticsFormattedMonetizationRequirements.retentionScore);
    }

    public final boolean getCanApply() {
        return this.canApply;
    }

    public final Integer getCommunicatorCount() {
        return this.communicatorCount;
    }

    public final Integer getGuildMemberCount() {
        return this.guildMemberCount;
    }

    public final boolean getHasMemberRetention() {
        return this.hasMemberRetention;
    }

    public final boolean getHasSufficientMembers() {
        return this.hasSufficientMembers;
    }

    public final CreatorMonetizationEnableRequest getLatestRequest() {
        return this.latestRequest;
    }

    public final boolean getMeetsServerAgeRequirement() {
        return this.meetsServerAgeRequirement;
    }

    public final int getMinimumAgeInDays() {
        return this.minimumAgeInDays;
    }

    public final int getMinimumSize() {
        return this.minimumSize;
    }

    public final boolean getNoRecentViolations() {
        return this.noRecentViolations;
    }

    public final boolean getNotNSFW() {
        return this.notNSFW;
    }

    public final CreatorMonetizationEligibilityRequirements.Rejection getRejection() {
        return this.rejection;
    }

    public final Double getRetentionScore() {
        return this.retentionScore;
    }

    public final boolean getWeeklyCommunicators() {
        return this.weeklyCommunicators;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    public int hashCode() {
        boolean z2 = this.isEligibleForMonetization;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.hasSufficientMembers;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        ?? r22 = this.meetsServerAgeRequirement;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        ?? r23 = this.noRecentViolations;
        int i6 = r23;
        if (r23 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        ?? r24 = this.weeklyCommunicators;
        int i8 = r24;
        if (r24 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        ?? r25 = this.hasMemberRetention;
        int i10 = r25;
        if (r25 != 0) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        ?? r26 = this.notNSFW;
        int i12 = r26;
        if (r26 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        ?? r27 = this.canApply;
        int i14 = r27;
        if (r27 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z3 = this.isApplicationPending;
        int i16 = (((((i15 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.minimumAgeInDays) * 31) + this.minimumSize) * 31;
        CreatorMonetizationEnableRequest creatorMonetizationEnableRequest = this.latestRequest;
        int iHashCode = (i16 + (creatorMonetizationEnableRequest != null ? creatorMonetizationEnableRequest.hashCode() : 0)) * 31;
        CreatorMonetizationEligibilityRequirements.Rejection rejection = this.rejection;
        int iHashCode2 = (iHashCode + (rejection != null ? rejection.hashCode() : 0)) * 31;
        Integer num = this.guildMemberCount;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.communicatorCount;
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Double d = this.retentionScore;
        return iHashCode4 + (d != null ? d.hashCode() : 0);
    }

    public final boolean isApplicationPending() {
        return this.isApplicationPending;
    }

    public final boolean isEligibleForMonetization() {
        return this.isEligibleForMonetization;
    }

    public final String toJson() throws JsonIOException {
        String strM = Companion.access$getGsonInstance$p(INSTANCE).m(this);
        Intrinsics3.checkNotNullExpressionValue(strM, "gsonInstance.toJson(this)");
        return strM;
    }

    public String toString() {
        StringBuilder sbU = outline.U("AnalyticsFormattedMonetizationRequirements(isEligibleForMonetization=");
        sbU.append(this.isEligibleForMonetization);
        sbU.append(", hasSufficientMembers=");
        sbU.append(this.hasSufficientMembers);
        sbU.append(", meetsServerAgeRequirement=");
        sbU.append(this.meetsServerAgeRequirement);
        sbU.append(", noRecentViolations=");
        sbU.append(this.noRecentViolations);
        sbU.append(", weeklyCommunicators=");
        sbU.append(this.weeklyCommunicators);
        sbU.append(", hasMemberRetention=");
        sbU.append(this.hasMemberRetention);
        sbU.append(", notNSFW=");
        sbU.append(this.notNSFW);
        sbU.append(", canApply=");
        sbU.append(this.canApply);
        sbU.append(", isApplicationPending=");
        sbU.append(this.isApplicationPending);
        sbU.append(", minimumAgeInDays=");
        sbU.append(this.minimumAgeInDays);
        sbU.append(", minimumSize=");
        sbU.append(this.minimumSize);
        sbU.append(", latestRequest=");
        sbU.append(this.latestRequest);
        sbU.append(", rejection=");
        sbU.append(this.rejection);
        sbU.append(", guildMemberCount=");
        sbU.append(this.guildMemberCount);
        sbU.append(", communicatorCount=");
        sbU.append(this.communicatorCount);
        sbU.append(", retentionScore=");
        sbU.append(this.retentionScore);
        sbU.append(")");
        return sbU.toString();
    }
}
