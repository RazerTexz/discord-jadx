package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.duration.DurationUtils;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.resources.StringResourceUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildInviteUiHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000b\u001a/\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u0010\u001a\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0014\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a)\u0010\u0014\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0014\u0010\u0016\u001a%\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001d\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u001f\u0010!\u001a\u00020\u001b2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010#\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b#\u0010\u0013\u001a!\u0010'\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"Landroid/content/Context;", "context", "Lcom/discord/models/domain/ModelInvite;", "invite", "Landroid/content/Intent;", "mostRecentIntent", "", "copyLinkClick", "(Landroid/content/Context;Lcom/discord/models/domain/ModelInvite;Landroid/content/Intent;)V", "", "analyticsSource", "(Landroid/content/Context;Lcom/discord/models/domain/ModelInvite;Ljava/lang/String;)V", "Lcom/discord/widgets/guilds/invite/GuildInvite;", "guildInvite", "Lcom/discord/api/channel/Channel;", "channel", "(Landroid/content/Context;Lcom/discord/widgets/guilds/invite/GuildInvite;Lcom/discord/api/channel/Channel;Ljava/lang/String;)V", "inviteLink", "copyLink", "(Landroid/content/Context;Ljava/lang/String;)V", "shareLinkClick", "(Landroid/content/Context;Lcom/discord/models/domain/ModelInvite;)V", "(Landroid/content/Context;Lcom/discord/widgets/guilds/invite/GuildInvite;Lcom/discord/api/channel/Channel;)V", "", "expirationDurationMs", "", "maxUses", "", "getInviteSettingsText", "(Landroid/content/Context;JI)Ljava/lang/CharSequence;", "(Landroid/content/Context;J)Ljava/lang/CharSequence;", "Lcom/discord/models/experiments/domain/Experiment;", "experiment", "getInviteLinkText", "(Landroid/content/Context;Lcom/discord/models/experiments/domain/Experiment;)Ljava/lang/CharSequence;", "shareLink", "inviteModel", "Landroid/content/res/Resources;", "resources", "getInviteLink", "(Lcom/discord/models/domain/ModelInvite;Landroid/content/res/Resources;)Ljava/lang/String;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.invite.GuildInviteUiHelperKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildInviteUiHelper {
    private static final void copyLink(Context context, String str) {
        AppToast.a(context, str, R.string.invite_link_copied);
    }

    public static final void copyLinkClick(Context context, ModelInvite modelInvite, Intent intent) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(intent, "mostRecentIntent");
        String stringExtra = intent.getStringExtra("com.discord.intent.ORIGIN_SOURCE");
        if (stringExtra == null) {
            stringExtra = "";
        }
        copyLinkClick(context, modelInvite, stringExtra);
    }

    private static final String getInviteLink(ModelInvite modelInvite, Resources resources) {
        if (modelInvite == null) {
            return BuildConfig.HOST_INVITE;
        }
        String link = modelInvite.toLink(resources, BuildConfig.HOST_INVITE);
        Intrinsics3.checkNotNullExpressionValue(link, "inviteModel.toLink(resou… BuildConfig.HOST_INVITE)");
        return link;
    }

    public static final CharSequence getInviteLinkText(Context context, Experiment experiment) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return FormatUtils.h(context, R.string.invite_links_expire_after_default, new Object[]{(experiment == null || experiment.getBucket() != 1) ? StringResourceUtils.getI18nPluralString(context, R.plurals.duration_days_days, 1, 1) : StringResourceUtils.getI18nPluralString(context, R.plurals.duration_days_days, 7, 7)}, null, 4);
    }

    public static final CharSequence getInviteSettingsText(Context context, long j, int i) throws Resources.NotFoundException {
        Object quantityString;
        Intrinsics3.checkNotNullParameter(context, "context");
        if (i == 0) {
            quantityString = context.getString(R.string.max_uses_description_unlimited_uses);
            Intrinsics3.checkNotNullExpressionValue(quantityString, "context.getString(R.stri…scription_unlimited_uses)");
        } else {
            Resources resources = context.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
            quantityString = StringResourceUtils.getQuantityString(resources, context, R.plurals.max_uses_description_mobile_maxUses, i, Integer.valueOf(i));
        }
        return j <= 0 ? FormatUtils.h(context, R.string.invite_settings_description_no_expiration, new Object[]{context.getString(R.string.max_age_never_description_mobile), quantityString}, null, 4) : FormatUtils.h(context, R.string.invite_settings_expired_description, new Object[]{DurationUtils.humanizeDurationRounded(context, j), quantityString}, null, 4);
    }

    private static final void shareLink(Context context, String str) throws Resources.NotFoundException {
        String string = context.getResources().getString(R.string.tip_instant_invite_title3);
        Intrinsics3.checkNotNullExpressionValue(string, "context.resources.getStr…ip_instant_invite_title3)");
        IntentUtils.performChooserSendIntent(context, str, string);
    }

    public static final void shareLinkClick(Context context, ModelInvite modelInvite) {
        Intrinsics3.checkNotNullParameter(modelInvite, "invite");
        AnalyticsTracker.inviteShareClicked(modelInvite);
        if (context != null) {
            Resources resources = context.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
            shareLink(context, getInviteLink(modelInvite, resources));
        }
    }

    public static final void copyLinkClick(Context context, ModelInvite modelInvite, String str) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(str, "analyticsSource");
        AnalyticsTracker.inviteCopied(modelInvite, str);
        Resources resources = context.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
        copyLink(context, getInviteLink(modelInvite, resources));
    }

    public static final void shareLinkClick(Context context, GuildInvite guildInvite, Channel channel) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(guildInvite, "guildInvite");
        AnalyticsTracker.INSTANCE.inviteShareClicked(guildInvite, channel);
        if (context != null) {
            shareLink(context, guildInvite.toLink());
        }
    }

    public static final void copyLinkClick(Context context, GuildInvite guildInvite, Channel channel, String str) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(guildInvite, "guildInvite");
        Intrinsics3.checkNotNullParameter(str, "analyticsSource");
        AnalyticsTracker.INSTANCE.inviteCopied(guildInvite, channel, str);
        copyLink(context, guildInvite.toLink());
    }

    public static final CharSequence getInviteSettingsText(Context context, long j) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (j <= 0) {
            return FormatUtils.h(context, R.string.max_age_never_description_mobile, new Object[0], null, 4);
        }
        return FormatUtils.h(context, R.string.invite_expired_subtext_mobile, new Object[]{DurationUtils.humanizeDurationRounded(context, j)}, null, 4);
    }
}
