package com.discord.models.domain.premium;

import androidx.room.RoomDatabase;
import b.d.b.a.outline;
import com.discord.api.premium.PremiumTier;
import com.discord.api.premium.SubscriptionInterval;
import com.discord.models.domain.ModelSubscription;
import d0.t.Iterables2;
import d0.t.Sets5;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NONE_MONTH' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: SubscriptionPlanType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\u0001\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001$B=\b\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\"\u0010#J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5¨\u00066"}, d2 = {"Lcom/discord/models/domain/premium/SubscriptionPlanType;", "", "", "isGrandfathered", "()Z", "isPremiumSubscription", "isMonthlyInterval", "Lcom/discord/api/premium/PremiumTier;", "premiumTier", "Lcom/discord/api/premium/PremiumTier;", "getPremiumTier", "()Lcom/discord/api/premium/PremiumTier;", "Lcom/discord/api/premium/SubscriptionInterval;", "interval", "Lcom/discord/api/premium/SubscriptionInterval;", "getInterval", "()Lcom/discord/api/premium/SubscriptionInterval;", "", "price", "I", "getPrice", "()I", "intervalCount", "getIntervalCount", "", "planId", "J", "getPlanId", "()J", "", "planTypeString", "Ljava/lang/String;", "getPlanTypeString", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;IILcom/discord/api/premium/SubscriptionInterval;ILjava/lang/String;JLcom/discord/api/premium/PremiumTier;)V", "Companion", "NONE_MONTH", "NONE_3_MONTH", "NONE_6_MONTH", "NONE_YEAR", "PREMIUM_MONTH_LEGACY", "PREMIUM_YEAR_LEGACY", "PREMIUM_MONTH_TIER_1", "PREMIUM_YEAR_TIER_1", "PREMIUM_MONTH_TIER_2", "PREMIUM_3_MONTH_TIER_2", "PREMIUM_6_MONTH_TIER_2", "PREMIUM_YEAR_TIER_2", "PREMIUM_MONTH_TIER_0", "PREMIUM_GUILD_MONTH", "PREMIUM_GUILD_3_MONTH", "PREMIUM_GUILD_6_MONTH", "PREMIUM_GUILD_YEAR", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class SubscriptionPlanType {
    private static final /* synthetic */ SubscriptionPlanType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Set<SubscriptionPlanType> LEGACY_PLANS;
    public static final SubscriptionPlanType NONE_3_MONTH;
    public static final SubscriptionPlanType NONE_6_MONTH;
    public static final SubscriptionPlanType NONE_MONTH;
    public static final SubscriptionPlanType NONE_YEAR;
    public static final SubscriptionPlanType PREMIUM_3_MONTH_TIER_2;
    public static final SubscriptionPlanType PREMIUM_6_MONTH_TIER_2;
    public static final SubscriptionPlanType PREMIUM_GUILD_3_MONTH;
    public static final SubscriptionPlanType PREMIUM_GUILD_6_MONTH;
    public static final SubscriptionPlanType PREMIUM_GUILD_MONTH;
    private static final Set<SubscriptionPlanType> PREMIUM_GUILD_PLANS;
    public static final SubscriptionPlanType PREMIUM_GUILD_YEAR;
    public static final SubscriptionPlanType PREMIUM_MONTH_LEGACY;
    public static final SubscriptionPlanType PREMIUM_MONTH_TIER_0;
    public static final SubscriptionPlanType PREMIUM_MONTH_TIER_1;
    public static final SubscriptionPlanType PREMIUM_MONTH_TIER_2;
    private static final Set<SubscriptionPlanType> PREMIUM_PLANS;
    public static final SubscriptionPlanType PREMIUM_YEAR_LEGACY;
    public static final SubscriptionPlanType PREMIUM_YEAR_TIER_1;
    public static final SubscriptionPlanType PREMIUM_YEAR_TIER_2;
    private static final Set<SubscriptionPlanType> TIER_0_PLANS;
    private static final Set<SubscriptionPlanType> TIER_1_PLANS;
    private static final Set<SubscriptionPlanType> TIER_2_PLANS;
    private final SubscriptionInterval interval;
    private final int intervalCount;
    private final long planId;
    private final String planTypeString;
    private final PremiumTier premiumTier;
    private final int price;

    /* compiled from: SubscriptionPlanType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010J+\u0010\u0014\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0018R\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0018R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0018¨\u0006$"}, d2 = {"Lcom/discord/models/domain/premium/SubscriptionPlanType$Companion;", "", "Lcom/discord/api/premium/SubscriptionInterval;", "interval", "", "intervalCount", "Lcom/discord/models/domain/premium/SubscriptionPlanType;", "getNonePlanForIntervalType", "(Lcom/discord/api/premium/SubscriptionInterval;I)Lcom/discord/models/domain/premium/SubscriptionPlanType;", "", "Lcom/discord/primitives/PlanId;", "planId", "from", "(J)Lcom/discord/models/domain/premium/SubscriptionPlanType;", "", "planTypeString", "(Ljava/lang/String;)Lcom/discord/models/domain/premium/SubscriptionPlanType;", "", "Lcom/discord/models/domain/ModelSubscription$SubscriptionItem;", "items", "getBasePlanFromSubscriptionItems", "(Ljava/util/List;Lcom/discord/api/premium/SubscriptionInterval;I)Lcom/discord/models/domain/premium/SubscriptionPlanType;", "", "PREMIUM_PLANS", "Ljava/util/Set;", "getPREMIUM_PLANS", "()Ljava/util/Set;", "PREMIUM_GUILD_PLANS", "getPREMIUM_GUILD_PLANS", "LEGACY_PLANS", "getLEGACY_PLANS", "TIER_0_PLANS", "TIER_1_PLANS", "TIER_2_PLANS", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                SubscriptionInterval.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[SubscriptionInterval.MONTHLY.ordinal()] = 1;
                iArr[SubscriptionInterval.YEARLY.ordinal()] = 2;
            }
        }

        private Companion() {
        }

        private final SubscriptionPlanType getNonePlanForIntervalType(SubscriptionInterval interval, int intervalCount) {
            int iOrdinal = interval.ordinal();
            if (iOrdinal == 0) {
                return intervalCount != 3 ? intervalCount != 6 ? SubscriptionPlanType.NONE_MONTH : SubscriptionPlanType.NONE_6_MONTH : SubscriptionPlanType.NONE_3_MONTH;
            }
            if (iOrdinal == 1) {
                return SubscriptionPlanType.NONE_YEAR;
            }
            throw new IllegalArgumentException("unsupported plan interval: " + interval);
        }

        public final SubscriptionPlanType from(long planId) {
            SubscriptionPlanType subscriptionPlanType;
            SubscriptionPlanType[] subscriptionPlanTypeArrValues = SubscriptionPlanType.values();
            int i = 0;
            while (true) {
                if (i >= 17) {
                    subscriptionPlanType = null;
                    break;
                }
                subscriptionPlanType = subscriptionPlanTypeArrValues[i];
                if (subscriptionPlanType.getPlanId() == planId) {
                    break;
                }
                i++;
            }
            if (subscriptionPlanType != null) {
                return subscriptionPlanType;
            }
            throw new IllegalArgumentException(outline.t("unsupported type plan id: ", planId));
        }

        public final SubscriptionPlanType getBasePlanFromSubscriptionItems(List<ModelSubscription.SubscriptionItem> items, SubscriptionInterval interval, int intervalCount) {
            Object next;
            SubscriptionInterval interval2;
            Intrinsics3.checkNotNullParameter(items, "items");
            Intrinsics3.checkNotNullParameter(interval, "interval");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(items, 10));
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                arrayList.add(SubscriptionPlanType.INSTANCE.from(((ModelSubscription.SubscriptionItem) it.next()).getPlanId()));
            }
            SubscriptionPlanType subscriptionPlanType = (SubscriptionPlanType) _Collections.firstOrNull((List) arrayList);
            if (subscriptionPlanType != null && (interval2 = subscriptionPlanType.getInterval()) != null) {
                interval = interval2;
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (((SubscriptionPlanType) next).getPremiumTier() != null) {
                    break;
                }
            }
            SubscriptionPlanType subscriptionPlanType2 = (SubscriptionPlanType) next;
            return subscriptionPlanType2 != null ? subscriptionPlanType2 : getNonePlanForIntervalType(interval, intervalCount);
        }

        public final Set<SubscriptionPlanType> getLEGACY_PLANS() {
            return SubscriptionPlanType.access$getLEGACY_PLANS$cp();
        }

        public final Set<SubscriptionPlanType> getPREMIUM_GUILD_PLANS() {
            return SubscriptionPlanType.access$getPREMIUM_GUILD_PLANS$cp();
        }

        public final Set<SubscriptionPlanType> getPREMIUM_PLANS() {
            return SubscriptionPlanType.access$getPREMIUM_PLANS$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubscriptionPlanType from(String planTypeString) {
            SubscriptionPlanType subscriptionPlanType;
            Intrinsics3.checkNotNullParameter(planTypeString, "planTypeString");
            SubscriptionPlanType[] subscriptionPlanTypeArrValues = SubscriptionPlanType.values();
            int i = 0;
            while (true) {
                if (i >= 17) {
                    subscriptionPlanType = null;
                    break;
                }
                subscriptionPlanType = subscriptionPlanTypeArrValues[i];
                if (Intrinsics3.areEqual(subscriptionPlanType.getPlanTypeString(), planTypeString)) {
                    break;
                }
                i++;
            }
            if (subscriptionPlanType != null) {
                return subscriptionPlanType;
            }
            throw new IllegalArgumentException(outline.w("unsupported planTypeString: ", planTypeString));
        }
    }

    static {
        SubscriptionInterval subscriptionInterval = SubscriptionInterval.MONTHLY;
        PremiumTier premiumTier = PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY;
        SubscriptionPlanType subscriptionPlanType = new SubscriptionPlanType("NONE_MONTH", 0, 0, subscriptionInterval, 1, "none_month", 628379151761408000L, premiumTier);
        NONE_MONTH = subscriptionPlanType;
        SubscriptionPlanType subscriptionPlanType2 = new SubscriptionPlanType("NONE_3_MONTH", 1, 0, subscriptionInterval, 3, "none_3_month", 944265614527037440L, premiumTier);
        NONE_3_MONTH = subscriptionPlanType2;
        SubscriptionPlanType subscriptionPlanType3 = new SubscriptionPlanType("NONE_6_MONTH", 2, 0, subscriptionInterval, 6, "none_6_month", 944265636643602432L, premiumTier);
        NONE_6_MONTH = subscriptionPlanType3;
        SubscriptionInterval subscriptionInterval2 = SubscriptionInterval.YEARLY;
        SubscriptionPlanType subscriptionPlanType4 = new SubscriptionPlanType("NONE_YEAR", 3, 0, subscriptionInterval2, 1, "none_year", 628381571568631808L, premiumTier);
        NONE_YEAR = subscriptionPlanType4;
        PremiumTier premiumTier2 = PremiumTier.TIER_2;
        SubscriptionPlanType subscriptionPlanType5 = new SubscriptionPlanType("PREMIUM_MONTH_LEGACY", 4, 499, subscriptionInterval, 1, "premium_month", 511651856145973248L, premiumTier2);
        PREMIUM_MONTH_LEGACY = subscriptionPlanType5;
        SubscriptionPlanType subscriptionPlanType6 = new SubscriptionPlanType("PREMIUM_YEAR_LEGACY", 5, 4999, subscriptionInterval2, 1, "premium_year", 511651860671627264L, premiumTier2);
        PREMIUM_YEAR_LEGACY = subscriptionPlanType6;
        PremiumTier premiumTier3 = PremiumTier.TIER_1;
        SubscriptionPlanType subscriptionPlanType7 = new SubscriptionPlanType("PREMIUM_MONTH_TIER_1", 6, 499, subscriptionInterval, 1, "premium_month_tier_1", 511651871736201216L, premiumTier3);
        PREMIUM_MONTH_TIER_1 = subscriptionPlanType7;
        SubscriptionPlanType subscriptionPlanType8 = new SubscriptionPlanType("PREMIUM_YEAR_TIER_1", 7, 4999, subscriptionInterval2, 1, "premium_year_tier_1", 511651876987469824L, premiumTier3);
        PREMIUM_YEAR_TIER_1 = subscriptionPlanType8;
        SubscriptionPlanType subscriptionPlanType9 = new SubscriptionPlanType("PREMIUM_MONTH_TIER_2", 8, RoomDatabase.MAX_BIND_PARAMETER_CNT, subscriptionInterval, 1, "premium_month_tier_2", 511651880837840896L, premiumTier2);
        PREMIUM_MONTH_TIER_2 = subscriptionPlanType9;
        SubscriptionPlanType subscriptionPlanType10 = new SubscriptionPlanType("PREMIUM_3_MONTH_TIER_2", 9, 2849, subscriptionInterval, 3, "premium_3_month_tier_2", 642251038925127690L, premiumTier2);
        PREMIUM_3_MONTH_TIER_2 = subscriptionPlanType10;
        SubscriptionPlanType subscriptionPlanType11 = new SubscriptionPlanType("PREMIUM_6_MONTH_TIER_2", 10, 5499, subscriptionInterval, 6, "premium_6_month_tier_2", 944037208325619722L, premiumTier2);
        PREMIUM_6_MONTH_TIER_2 = subscriptionPlanType11;
        SubscriptionPlanType subscriptionPlanType12 = new SubscriptionPlanType("PREMIUM_YEAR_TIER_2", 11, 9999, subscriptionInterval2, 1, "premium_year_tier_2", 511651885459963904L, premiumTier2);
        PREMIUM_YEAR_TIER_2 = subscriptionPlanType12;
        SubscriptionPlanType subscriptionPlanType13 = new SubscriptionPlanType("PREMIUM_MONTH_TIER_0", 12, 299, subscriptionInterval, 1, "premium_month_tier_0", 978380692553465866L, PremiumTier.TIER_0);
        PREMIUM_MONTH_TIER_0 = subscriptionPlanType13;
        SubscriptionPlanType subscriptionPlanType14 = new SubscriptionPlanType("PREMIUM_GUILD_MONTH", 13, 499, subscriptionInterval, 1, null, 590665532894740483L, null);
        PREMIUM_GUILD_MONTH = subscriptionPlanType14;
        SubscriptionPlanType subscriptionPlanType15 = new SubscriptionPlanType("PREMIUM_GUILD_3_MONTH", 14, 1427, subscriptionInterval, 3, null, 944037355453415424L, null);
        PREMIUM_GUILD_3_MONTH = subscriptionPlanType15;
        SubscriptionPlanType subscriptionPlanType16 = new SubscriptionPlanType("PREMIUM_GUILD_6_MONTH", 15, 2750, subscriptionInterval, 6, null, 944037391444738048L, null);
        PREMIUM_GUILD_6_MONTH = subscriptionPlanType16;
        SubscriptionPlanType subscriptionPlanType17 = new SubscriptionPlanType("PREMIUM_GUILD_YEAR", 16, 4999, subscriptionInterval2, 1, null, 590665538238152709L, null);
        PREMIUM_GUILD_YEAR = subscriptionPlanType17;
        $VALUES = new SubscriptionPlanType[]{subscriptionPlanType, subscriptionPlanType2, subscriptionPlanType3, subscriptionPlanType4, subscriptionPlanType5, subscriptionPlanType6, subscriptionPlanType7, subscriptionPlanType8, subscriptionPlanType9, subscriptionPlanType10, subscriptionPlanType11, subscriptionPlanType12, subscriptionPlanType13, subscriptionPlanType14, subscriptionPlanType15, subscriptionPlanType16, subscriptionPlanType17};
        INSTANCE = new Companion(null);
        Set<SubscriptionPlanType> of = SetsJVM.setOf(subscriptionPlanType13);
        TIER_0_PLANS = of;
        Set<SubscriptionPlanType> of2 = Sets5.setOf((Object[]) new SubscriptionPlanType[]{subscriptionPlanType8, subscriptionPlanType7});
        TIER_1_PLANS = of2;
        Set<SubscriptionPlanType> of3 = Sets5.setOf((Object[]) new SubscriptionPlanType[]{subscriptionPlanType6, subscriptionPlanType5});
        LEGACY_PLANS = of3;
        Set<SubscriptionPlanType> setPlus = _Sets.plus(Sets5.setOf((Object[]) new SubscriptionPlanType[]{subscriptionPlanType9, subscriptionPlanType10, subscriptionPlanType11, subscriptionPlanType12}), (Iterable) of3);
        TIER_2_PLANS = setPlus;
        PREMIUM_PLANS = _Sets.plus(_Sets.plus((Set) of, (Iterable) of2), (Iterable) setPlus);
        PREMIUM_GUILD_PLANS = Sets5.setOf((Object[]) new SubscriptionPlanType[]{subscriptionPlanType14, subscriptionPlanType10, subscriptionPlanType11, subscriptionPlanType17});
    }

    private SubscriptionPlanType(String str, int i, int i2, SubscriptionInterval subscriptionInterval, int i3, String str2, long j, PremiumTier premiumTier) {
        this.price = i2;
        this.interval = subscriptionInterval;
        this.intervalCount = i3;
        this.planTypeString = str2;
        this.planId = j;
        this.premiumTier = premiumTier;
    }

    public static final /* synthetic */ Set access$getLEGACY_PLANS$cp() {
        return LEGACY_PLANS;
    }

    public static final /* synthetic */ Set access$getPREMIUM_GUILD_PLANS$cp() {
        return PREMIUM_GUILD_PLANS;
    }

    public static final /* synthetic */ Set access$getPREMIUM_PLANS$cp() {
        return PREMIUM_PLANS;
    }

    public static SubscriptionPlanType valueOf(String str) {
        return (SubscriptionPlanType) Enum.valueOf(SubscriptionPlanType.class, str);
    }

    public static SubscriptionPlanType[] values() {
        return (SubscriptionPlanType[]) $VALUES.clone();
    }

    public final SubscriptionInterval getInterval() {
        return this.interval;
    }

    public final int getIntervalCount() {
        return this.intervalCount;
    }

    public final long getPlanId() {
        return this.planId;
    }

    public final String getPlanTypeString() {
        return this.planTypeString;
    }

    public final PremiumTier getPremiumTier() {
        return this.premiumTier;
    }

    public final int getPrice() {
        return this.price;
    }

    public final boolean isGrandfathered() {
        return LEGACY_PLANS.contains(this);
    }

    public final boolean isMonthlyInterval() {
        return this.interval == SubscriptionInterval.MONTHLY;
    }

    public final boolean isPremiumSubscription() {
        return PREMIUM_PLANS.contains(this);
    }
}
