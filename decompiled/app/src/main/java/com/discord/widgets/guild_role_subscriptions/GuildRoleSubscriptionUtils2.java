package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import com.discord.R;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionFreeTrialIntervalTypes;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.PayoutStatus;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.api.permission.Permission;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.widgets.servers.guild_role_subscription.model.PayoutStatusMedia;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: GuildRoleSubscriptionUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a-\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u0010\u001a\u00020\n*\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0011\u0010\u0014\u001a\u00020\u0013*\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0019\u0010\u001a\u001a\u00020\u0019*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "", "getPrice", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;)I", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "", "getFullServerGatingOverwrite", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;Ljava/util/Map;)Ljava/lang/Boolean;", "", "Lcom/discord/models/domain/ModelSubscription;", "userSubscriptions", "hasUserActiveSubscriptionFor", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;Ljava/util/List;)Z", "Lcom/discord/api/guildrolesubscription/PayoutStatus;", "Lcom/discord/widgets/servers/guild_role_subscription/model/PayoutStatusMedia;", "getStatusMedia", "(Lcom/discord/api/guildrolesubscription/PayoutStatus;)Lcom/discord/widgets/servers/guild_role_subscription/model/PayoutStatusMedia;", "Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;", "Landroid/content/Context;", "context", "", "getFormattedLabel", "(Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;Landroid/content/Context;)Ljava/lang/CharSequence;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionUtils2 {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtilsKt$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            PayoutStatus.values();
            int[] iArr = new int[14];
            $EnumSwitchMapping$0 = iArr;
            iArr[PayoutStatus.MANUAL.ordinal()] = 1;
            iArr[PayoutStatus.OPEN.ordinal()] = 2;
            iArr[PayoutStatus.PENDING.ordinal()] = 3;
            iArr[PayoutStatus.PROCESSING.ordinal()] = 4;
            iArr[PayoutStatus.SUBMITTED.ordinal()] = 5;
            iArr[PayoutStatus.PENDING_FUNDS.ordinal()] = 6;
            iArr[PayoutStatus.PAID.ordinal()] = 7;
            iArr[PayoutStatus.CANCELED.ordinal()] = 8;
            iArr[PayoutStatus.DEFERRED.ordinal()] = 9;
            iArr[PayoutStatus.DEFERRED_INTERNAL.ordinal()] = 10;
            iArr[PayoutStatus.ERROR.ordinal()] = 11;
            iArr[PayoutStatus.UNKNOWN.ordinal()] = 12;
            iArr[PayoutStatus.REJECTED.ordinal()] = 13;
            iArr[PayoutStatus.RISK_REVIEW.ordinal()] = 14;
            GuildRoleSubscriptionFreeTrialIntervalTypes.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[GuildRoleSubscriptionFreeTrialIntervalTypes.DAILY.ordinal()] = 1;
            iArr2[GuildRoleSubscriptionFreeTrialIntervalTypes.MONTHLY.ordinal()] = 2;
            iArr2[GuildRoleSubscriptionFreeTrialIntervalTypes.YEARLY.ordinal()] = 3;
        }
    }

    public static final CharSequence getFormattedLabel(SubscriptionTrialInterval subscriptionTrialInterval, Context context) {
        Intrinsics3.checkNotNullParameter(subscriptionTrialInterval, "$this$getFormattedLabel");
        Intrinsics3.checkNotNullParameter(context, "context");
        int iOrdinal = subscriptionTrialInterval.getInterval().ordinal();
        if (iOrdinal == 0) {
            return StringResourceUtils.getI18nPluralString(context, R.plurals.duration_months_capitalize_months, subscriptionTrialInterval.getIntervalCount(), Integer.valueOf(subscriptionTrialInterval.getIntervalCount()));
        }
        if (iOrdinal == 1) {
            return StringResourceUtils.getI18nPluralString(context, R.plurals.duration_years_capitalize_years, subscriptionTrialInterval.getIntervalCount(), Integer.valueOf(subscriptionTrialInterval.getIntervalCount()));
        }
        if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (subscriptionTrialInterval.getIntervalCount() <= 0 || subscriptionTrialInterval.getIntervalCount() % 7 != 0) {
            return StringResourceUtils.getI18nPluralString(context, R.plurals.duration_days_capitalize_days, subscriptionTrialInterval.getIntervalCount(), Integer.valueOf(subscriptionTrialInterval.getIntervalCount()));
        }
        int intervalCount = subscriptionTrialInterval.getIntervalCount() / 7;
        return StringResourceUtils.getI18nPluralString(context, R.plurals.duration_weeks_capitalize_weeks, intervalCount, Integer.valueOf(intervalCount));
    }

    public static final Boolean getFullServerGatingOverwrite(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Map<Long, GuildRole> map) {
        Boolean boolValueOf;
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionGroupListing, "$this$getFullServerGatingOverwrite");
        List<GuildRoleSubscriptionTierListing> listH = guildRoleSubscriptionGroupListing.h();
        if (listH != null) {
            boolean z2 = false;
            if (!listH.isEmpty()) {
                Iterator<T> it = listH.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((GuildRoleSubscriptionTierListing) it.next()).getPublished()) {
                        z2 = true;
                        break;
                    }
                }
            }
            boolValueOf = Boolean.valueOf(z2);
        } else {
            boolValueOf = null;
        }
        if (boolValueOf == null || !boolValueOf.booleanValue()) {
            return null;
        }
        return Boolean.valueOf(!PermissionUtils.INSTANCE.canRole(Permission.VIEW_CHANNEL, map != null ? map.get(Long.valueOf(guildRoleSubscriptionGroupListing.getGuildId())) : null, null));
    }

    public static final int getPrice(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierListing, "$this$getPrice");
        SubscriptionPlan subscriptionPlan = (SubscriptionPlan) _Collections.getOrNull(guildRoleSubscriptionTierListing.i(), 0);
        if (subscriptionPlan != null) {
            return subscriptionPlan.getPrice();
        }
        return 0;
    }

    public static final PayoutStatusMedia getStatusMedia(PayoutStatus payoutStatus) {
        Intrinsics3.checkNotNullParameter(payoutStatus, "$this$getStatusMedia");
        switch (payoutStatus) {
            case UNKNOWN:
            case ERROR:
                return new PayoutStatusMedia(R.drawable.ic_close, R.string.guild_role_subscription_earnings_table_status_error);
            case OPEN:
            case PENDING:
            case MANUAL:
            case PROCESSING:
            case SUBMITTED:
            case PENDING_FUNDS:
                return new PayoutStatusMedia(R.drawable.ic_pending, R.string.guild_role_subscription_earnings_table_status_scheduled);
            case PAID:
                return new PayoutStatusMedia(R.drawable.ic_paid, R.string.guild_role_subscription_earnings_table_status_paid);
            case CANCELED:
                return new PayoutStatusMedia(R.drawable.ic_close, R.string.guild_role_subscription_earnings_table_status_cancelled);
            case DEFERRED:
                return new PayoutStatusMedia(R.drawable.ic_close, R.string.guild_role_subscription_earnings_table_status_cancelled);
            case DEFERRED_INTERNAL:
                return new PayoutStatusMedia(R.drawable.ic_close, R.string.guild_role_subscription_earnings_table_status_deferred);
            case REJECTED:
                return new PayoutStatusMedia(R.drawable.ic_close, R.string.guild_role_subscription_earnings_table_status_rejected);
            case RISK_REVIEW:
                return new PayoutStatusMedia(R.drawable.ic_close, R.string.guild_role_subscription_earnings_table_status_risk_review);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean hasUserActiveSubscriptionFor(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List<ModelSubscription> list) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionGroupListing, "$this$hasUserActiveSubscriptionFor");
        Intrinsics3.checkNotNullParameter(list, "userSubscriptions");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ModelSubscription.SubscriptionItem subscriptionItem = (ModelSubscription.SubscriptionItem) _Collections.getOrNull(((ModelSubscription) it.next()).getItems(), 0);
            Long lValueOf = subscriptionItem != null ? Long.valueOf(subscriptionItem.getPlanId()) : null;
            if (lValueOf != null) {
                arrayList.add(lValueOf);
            }
        }
        Set set = _Collections.toSet(arrayList);
        List<GuildRoleSubscriptionTierListing> listH = guildRoleSubscriptionGroupListing.h();
        if (listH != null) {
            Iterator<T> it2 = listH.iterator();
            while (it2.hasNext()) {
                SubscriptionPlan subscriptionPlan = (SubscriptionPlan) _Collections.getOrNull(((GuildRoleSubscriptionTierListing) it2.next()).i(), 0);
                Long lValueOf2 = subscriptionPlan != null ? Long.valueOf(subscriptionPlan.getId()) : null;
                if (lValueOf2 != null && set.contains(lValueOf2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
