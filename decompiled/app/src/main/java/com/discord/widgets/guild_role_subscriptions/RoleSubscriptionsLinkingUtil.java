package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.stores.StoreStream;
import com.discord.utilities.handoff.MobileWebHandoff;
import com.discord.utilities.intent.StaticChannelRoutes;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: RoleSubscriptionsLinkingUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/RoleSubscriptionsLinkingUtil;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/widgets/guild_role_subscriptions/RoleSubscriptionsLinkingUtil$HandoffEligibility;", "getHandoffEligibility", "(J)Lcom/discord/widgets/guild_role_subscriptions/RoleSubscriptionsLinkingUtil$HandoffEligibility;", "Landroid/content/Context;", "context", "", "url", "", "performHandoff", "(Landroid/content/Context;Ljava/lang/String;)Z", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "tryPerformHandoff", "(Landroid/content/Context;Landroid/net/Uri;)Z", "Lcom/discord/widgets/guild_role_subscriptions/RoleSubscriptionsLinkingUtil$HandoffResult;", "handoffToGuildRoleSubscriptions", "(Landroid/content/Context;J)Lcom/discord/widgets/guild_role_subscriptions/RoleSubscriptionsLinkingUtil$HandoffResult;", "<init>", "()V", "HandoffEligibility", "HandoffResult", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RoleSubscriptionsLinkingUtil {
    public static final RoleSubscriptionsLinkingUtil INSTANCE = new RoleSubscriptionsLinkingUtil();

    /* compiled from: RoleSubscriptionsLinkingUtil.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/RoleSubscriptionsLinkingUtil$HandoffEligibility;", "", "<init>", "(Ljava/lang/String;I)V", "ELIGIBLE", "UNKNOWN_GUILD", "INELIGIBLE_FOR_ROLE_SUBSCRIPTIONS", "INELIGIBLE_FOR_MOBILE_WEB_PURCHASE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum HandoffEligibility {
        ELIGIBLE,
        UNKNOWN_GUILD,
        INELIGIBLE_FOR_ROLE_SUBSCRIPTIONS,
        INELIGIBLE_FOR_MOBILE_WEB_PURCHASE
    }

    /* compiled from: RoleSubscriptionsLinkingUtil.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/RoleSubscriptionsLinkingUtil$HandoffResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "INELIGIBLE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum HandoffResult {
        SUCCESS,
        FAILURE,
        INELIGIBLE
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            HandoffEligibility.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[HandoffEligibility.UNKNOWN_GUILD.ordinal()] = 1;
            iArr[HandoffEligibility.INELIGIBLE_FOR_ROLE_SUBSCRIPTIONS.ordinal()] = 2;
            iArr[HandoffEligibility.INELIGIBLE_FOR_MOBILE_WEB_PURCHASE.ordinal()] = 3;
            iArr[HandoffEligibility.ELIGIBLE.ordinal()] = 4;
        }
    }

    private RoleSubscriptionsLinkingUtil() {
    }

    private final HandoffEligibility getHandoffEligibility(long guildId) {
        if (guildId == 0 || StoreStream.INSTANCE.getGuilds().getGuild(guildId) == null) {
            return HandoffEligibility.UNKNOWN_GUILD;
        }
        GuildRoleSubscriptionsFeatureFlag.Companion companion = GuildRoleSubscriptionsFeatureFlag.INSTANCE;
        return !companion.getINSTANCE().canGuildSeePremiumMemberships(guildId) ? HandoffEligibility.INELIGIBLE_FOR_ROLE_SUBSCRIPTIONS : !companion.getINSTANCE().canGuildAccessMobileWebPurchases(guildId) ? HandoffEligibility.INELIGIBLE_FOR_MOBILE_WEB_PURCHASE : HandoffEligibility.ELIGIBLE;
    }

    private final boolean performHandoff(Context context, String url) {
        return MobileWebHandoff.tryLaunchRedirectTo$default(new MobileWebHandoff(context, null, null, null, 14, null), url, false, true, 2, null);
    }

    public final HandoffResult handoffToGuildRoleSubscriptions(Context context, long guildId) {
        Intrinsics3.checkNotNullParameter(context, "context");
        int iOrdinal = getHandoffEligibility(guildId).ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1 || iOrdinal == 2) {
                AppToast.g(context, R.string.inaccessible_channel_link_title, 0, null, 12);
                return HandoffResult.INELIGIBLE;
            }
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            WidgetGuildRoleSubscriptionEntryPoint.INSTANCE.launch(context, guildId, "Role Subscriptions Tab");
            return HandoffResult.INELIGIBLE;
        }
        boolean zPerformHandoff = performHandoff(context, "/channels/" + guildId + MentionUtils.SLASH_CHAR + StaticChannelRoutes.ROLE_SUBSCRIPTIONS.getRoute());
        if (zPerformHandoff) {
            return HandoffResult.SUCCESS;
        }
        if (zPerformHandoff) {
            throw new NoWhenBranchMatchedException();
        }
        return HandoffResult.FAILURE;
    }

    public final boolean tryPerformHandoff(Context context, Uri uri) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        StaticChannelRoutes.WithGuild withGuildExtractStaticRoute = StaticChannelRoutes.INSTANCE.extractStaticRoute(uri);
        if (withGuildExtractStaticRoute != null) {
            return withGuildExtractStaticRoute.getRoute() == StaticChannelRoutes.ROLE_SUBSCRIPTIONS && handoffToGuildRoleSubscriptions(context, withGuildExtractStaticRoute.getGuildId()) != HandoffResult.FAILURE;
        }
        return false;
    }
}
